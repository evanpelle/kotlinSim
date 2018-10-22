package com.company.action

import com.company.automaton.Attributes
import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnimalActionTest {

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

    @Test
    fun returnsRestOrHealActionWhenValid() {
        auto.getStatus().energy = 10.0
        assertThat(action.execute(simMap)).containsOnly(
                RestOrHealAction(auto.getStatus())
        )
    }

    @Test
    fun returnsAttackNeighborActionIfItHasAWeakerNeighbor() {
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
    fun movesRandomlyWhenDoesNotHaveNeighborToAttack() {
        auto.getStatus().energy = 60.0
        simMap.addAutomaton(Loc(1, 1), auto)
        assertThat(action.execute(simMap)).containsOnly(
                RandomMove(auto)
        )
    }

    @Test
    fun reproducesIfHasEnoughEnergyAndHealthAndNoAttackableNeighbors() {
        simMap.addAutomaton(Loc(1, 1), auto)
        assertThat(action.execute(simMap).map { it::class }).containsOnly(
                ReproduceAction::class
        )
    }

}