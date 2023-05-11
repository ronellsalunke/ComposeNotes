package ronell.composenotes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ronell.composenotes.db.Note
import ronell.composenotes.ui.viewmodel.NoteViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(viewModel: NoteViewModel, navController: NavController) {

    val getAllNotes = viewModel.allNotes.collectAsState().value

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
        NoteCardList(getAllNotes, navController)
    }
}

@Composable
fun NoteCardList(notes: List<Note>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        LazyColumn {
            items(notes) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    //TODO: onClick handler
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = it.noteTitle,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(6.dp)
                        )
                        Text(
                            text = it.noteBody,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }
            }
        }
    }
}