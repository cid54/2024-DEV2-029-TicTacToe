package org.dev29.tictactoe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.Black),
        ) {

            Row(
                modifier = Modifier.weight(1f, fill = true),
            ) {
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.leftTopTile
                )
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.centerTopTile
                )
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.rightTopTile
                )
            }

            Row(
                modifier = Modifier.weight(1f, fill = true),
            ) {
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.leftCenterTile
                )
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.centerCenterTile
                )
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.rightCenterTile
                )
            }

            Row(
                modifier = Modifier.weight(1f, fill = true),
            ) {
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.leftBottomTile
                )
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.centerBottomTile
                )
                Tile(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    gameTile = Game.rightBottomTile
                )
            }

        }
    }
}

@Composable
fun Tile(
    modifier: Modifier,
    gameTile: GameTile
) {

    val empty by gameTile.empty
    val won by gameTile.won

    var cardModif = modifier

    if (empty) {
        cardModif = modifier.clickable { gameTile.click() }
    }

    Card(
        modifier = cardModif,
        border = BorderStroke(1.dp, if(won) Color.Green else Color.Black),
    ) {

        if (!empty) {
            Image(
                painter = painterResource("${gameTile.sign}.png"),
                contentDescription = "O"
            )
        }
    }

}
