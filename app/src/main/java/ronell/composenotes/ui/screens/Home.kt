package ronell.composenotes.ui.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "NoteIt")
                },
                elevation = 0.dp
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
            ) {
                Icon(Icons.TwoTone.Create, contentDescription = "New note")
            }
        }
    ) {
        // TODO
    }
}