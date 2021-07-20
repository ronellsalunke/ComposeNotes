package ronell.composenotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ronell.composenotes.db.Note
import ronell.composenotes.ui.viewmodel.NoteViewModel

@Composable
fun Home(viewModel: NoteViewModel, navController: NavController) {
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
                onClick = { navController.navigate("Edit") },
            ) {
                Icon(Icons.TwoTone.Create, contentDescription = "New note")
            }
        }
    ) {
        // TODO
    }
}