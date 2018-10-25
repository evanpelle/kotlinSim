package com.company.action

import com.company.automaton.Attributes
import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations.initMocks
import java.util.*

internal class AnimalActionTest {

    @Mock
    private lateinit var randomMock: Random
    private val simMap = SimMap(10, 10)
    private val auto = TestAutomaton()
    private val action = AnimalAction(auto)

    private val weakAuto = TestAutomaton(
            Status(
                    Attributes(
                            100.0,
                            100.0,
                            50.0
                    ),
                    100.0,
                    100.0
            )
    )

    private val strongAuto = TestAutomaton(
            Status(
                    Attributes(
                            100.0,
                            100.0,
                            200.0
                    ),
                    100.0,
                    100.0
            )
    )

    @BeforeEach
    fun before() {
        initMocks(this)
    }

    @Test
    fun returnsRestOrHealActionWhenValid() {
        auto.getStatus().energy = 10.0
        assertThat(action.execute(simMap)).containsOnly(
                RestOrHealAction(auto.getStatus())
        )
    }

    @Test
    fun returnsAttackNeighborActionIfItHasAWeakerNeighborAndRandom() {
        `when`(randomMock.nextDouble()).thenReturn(.79)
        simMap.addAutomaton(Loc(1, 1), auto)
        simMap.addAutomaton(Loc(1, 2), weakAuto)
        assertThat(action.execute(simMap)).containsOnly(
                Attack(auto, weakAuto)
        )
    }

    @Test
    fun doesNotAttackStrongNeighbor() {
        simMap.addAutomaton(Loc(1, 1), auto)
        simMap.addAutomaton(Loc(1, 2), strongAuto)
        assertThat(action.execute(simMap)).doesNotContain(
                Attack(auto, strongAuto)
        )
    }

    @Test
    fun attacksWeakNeighborWhenHasWeakAndStrongNeighbor() {
        simMap.addAutomaton(Loc(1, 1), auto)
        simMap.addAutomaton(Loc(1, 2), weakAuto)
        simMap.addAutomaton(Loc(1, 0), strongAuto)
        assertThat(action.execute(simMap)).containsOnly(
                Attack(auto, weakAuto)
        )
    }

    @Test
    fun movesRandomlyWhenDoesNotHaveNeighborToAttackAndRandom() {
        simMap.addAutomaton(Loc(1, 1), auto)
        `when`(randomMock.nextDouble()).thenReturn(.89).thenReturn(.49)
        val action = AnimalAction(auto, randomMock)
        assertThat(action.execute(simMap)).containsOnly(
                RandomMove(auto)
        )
    }

    @Test
    fun reproducesIfRandomSet() {
        `when`(randomMock.nextDouble()).thenReturn(.91)
        val action = AnimalAction(auto, randomMock)
        assertThat(action.execute(simMap).map { it::class }).containsOnly(
                ReproduceAction::class
        )
    }

}