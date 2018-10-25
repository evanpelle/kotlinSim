package com.company.event.complexaction

import com.company.ActionExecutor
import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.event.StatusUpdate
import com.company.event.basicaction.Reproduce
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.spy

internal class ReproduceTest {

    private val simMap = SimMap(10, 10)
    private val parent = TestAutomaton()
    private val child = TestAutomaton()

    @BeforeEach
    fun before() {
        simMap.addAutomaton(Loc(1, 1), parent)
    }

    @Test
    fun doesNothingWhenAutoDoesNotHaveEnoughHealth() {
        parent.getStatus().health = Reproduce.healthCost - 1.0
        assertThat(Reproduce(parent) { child }.execute(simMap)).isEmpty()
    }

    @Test
    fun doesNothingWhenAutoDoesNotHaveEnoughEnergy() {
        parent.getStatus().energy = Reproduce.energyCost - 1.0
        assertThat(Reproduce(parent) { child }.execute(simMap)).isEmpty()
    }

    @Test
    fun doesNothingIfThereIsNoEmptyNeighbor() {
        val simMapSpy = spy(simMap)
        doReturn(null).`when`(simMapSpy).getRandomEmptyNeighbor(Loc(1, 1))
        assertThat(Reproduce(parent) { child }.execute(simMapSpy)).isEmpty()
    }

    @Test
    fun createsAutoWhenIfPossible() {
        val simMapSpy = spy(simMap)
        doReturn(Loc(2, 1)).`when`(simMapSpy).getRandomEmptyNeighbor(Loc(1, 1))
        val reproduceAction = Reproduce(parent) { child }
        assertThat(reproduceAction.execute(simMapSpy))
                .containsOnly(
                        StatusUpdate(
                                parent.getStatus(),
                                Status.StatusChange(-Reproduce.healthCost, -Reproduce.energyCost)
                        ),
                        PlaceAuto(child, Loc(2, 1))
                )
        ActionExecutor().executeAction(simMap, reproduceAction)
        assertThat(child.getStatus().health).isEqualTo(Reproduce.childHealth)
        assertThat(child.getStatus().energy).isEqualTo(Reproduce.childEnergy)
    }

}