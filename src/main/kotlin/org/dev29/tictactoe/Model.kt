package org.dev29.tictactoe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.dev29.tictactoe.Game.activePlayer
import org.dev29.tictactoe.Game.gameDone
import org.dev29.tictactoe.Game.nextMove

object Game {

    val leftTopTile = GameTile()
    val centerTopTile = GameTile()
    val rightTopTile = GameTile()

    val leftCenterTile = GameTile()
    val centerCenterTile = GameTile()
    val rightCenterTile = GameTile()

    val leftBottomTile = GameTile()
    val centerBottomTile = GameTile()
    val rightBottomTile = GameTile()

    private val patterns = listOf(
        // horizontal
        listOf(leftTopTile, centerTopTile, rightTopTile),
        listOf(leftCenterTile, centerCenterTile, rightCenterTile),
        listOf(leftBottomTile, centerBottomTile, rightBottomTile),
        // vertical
        listOf(leftTopTile, leftCenterTile, leftBottomTile),
        listOf(centerTopTile, centerCenterTile, centerBottomTile),
        listOf(rightTopTile, rightCenterTile, rightBottomTile),
        // diags
        listOf(leftTopTile, centerCenterTile, rightBottomTile),
        listOf(rightTopTile, centerCenterTile, leftBottomTile)
    )

    private val player1 = Player('X')
    private val player2 = Player('O')

    var activePlayer = player1

    private var clickCount = 0

    var gameDone = false

    fun nextMove() {

        clickCount++

        // Check for victory or end
        // You can't win before move 5
        if (clickCount > 4) {

            // There are only 8 winning patterns, so just check them
            // instead of doing some magic traversal
            val winningPattern = patterns.find { pattern ->
                pattern.none { it.sign == ' ' }
                        &&
                        pattern.map { it.sign }
                            .distinct()
                            .size == 1
            }

            if (winningPattern != null) {

                winningPattern.forEach {
                    it.won.value = true
                }

                gameDone = true

            }

        }

        // Switch players
        activePlayer = if (activePlayer == player1) player2 else player1

    }

}

class GameTile(
    var empty: MutableState<Boolean> = mutableStateOf(true),
    var won: MutableState<Boolean> = mutableStateOf(false),
    var sign: Char = ' '
) {

    fun click() {

        if (!this.empty.value || gameDone) {
            return
        }

        // Set the sign
        this.sign = activePlayer.sign
        // Update the game
        nextMove()
        // Mark tile as clicked
        this.empty.value = false

    }

}

data class Player(val sign: Char)
