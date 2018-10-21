package com.company.action

import com.company.ActionExecutor
import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.event.StatusUpdateEvent
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.spy

internal class ReproduceActionTest {

    private val simMap = SimMap(10, 10)
    private val parent = TestAutomaton()
    private val child = TestAutomaton()

    @BeforeEach
    fun before() {
        simMap.addAutomaton(Loc(1, 1), parent)
    }

    @Test
    fun doesNothingWhenAutoDoesNotHaveEnoughHealth() {
        parent.getStatus().health = ReproduceAction.healthCost - 1.0
        assertThat(ReproduceAction(parent) { child }.execute(simMap)).isEmpty()
    }

    @Test
    fun doesNothingWhenAutoDoesNotHaveEnoughEnergy() {
        parent.getStatus().energy = ReproduceAction.energyCost - 1.0
        assertThat(ReproduceAction(parent) { child }.execute(simMap)).isEmpty()
    }

    @Test
    fun doesNothingIfThereIsNoEmptyNeighbor() {
        val simMapSpy = spy(simMap)
        doReturn(null).`when`(simMapSpy).getRandomEmptyNeighbor(Loc(1, 1))
        assertThat(ReproduceAction(parent) { child }.execute(simMapSpy)).isEmpty()
    }

    @Test
    fun createsAutoWhenIfPossible() {
        val simMapSpy = spy(simMap)
        doReturn(Loc(2, 1)).`when`(simMapSpy).getRandomEmptyNeighbor(Loc(1, 1))
        val reproduceAction = ReproduceAction(parent) { child }
        assertThat(reproduceAction.execute(simMapSpy))
                .containsOnly(
                        StatusUpdateEvent(
                                parent.getStatus(),
                                Status.StatusChange(-ReproduceAction.healthCost, -ReproduceAction.energyCost)
                        ),
                        PlaceAuto(child, Loc(2, 1))
                )
        ActionExecutor().executeAction(simMap, reproduceAction)
        assertThat(child.getStatus().health).isEqualTo(ReproduceAction.childHealth)
        assertThat(child.getStatus().energy).isEqualTo(ReproduceAction.childEnergy)
    }

}