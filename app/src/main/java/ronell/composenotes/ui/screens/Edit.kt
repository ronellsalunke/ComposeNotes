package ronell.composenotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ronell.composenotes.db.Note
import ronell.composenotes.ui.viewmodel.NoteViewModel

@Composable
fun Edit(viewModel: NoteViewModel, navController: NavController) {
    val noteTitle = remember { mutableStateOf(TextFieldValue()) }
    val noteBody = remember { mutableStateOf(TextFieldValue()) }
    val snackBarVisibility = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {
                    Text(text = "Edit")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (noteTitle.value.text.isNotEmpty() && noteBody.value.text.isNotEmpty()) {
                            viewModel.insertNote(
                                Note(noteTitle.value.text, noteBody.value.text)
                            )
                        }
                        navController.popBackStack()
                    }) {
                        Icon(Icons.TwoTone.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (noteTitle.value.text.isEmpty() && noteBody.value.text.isEmpty()) {
                            snackBarVisibility.value = true
                        } else {
                            viewModel.deleteNote(
                                Note(noteTitle.value.text, noteBody.value.text)
                            )
                            navController.popBackStack()
                        }
                    }) {
                        Icon(Icons.TwoTone.Delete, contentDescription = "Delete note")
                    }
                },
            )
        },
        snackbarHost = {
            if (snackBarVisibility.value) {
                Snackbar(modifier = Modifier.padding(10.dp)) {
                    Text(text = "Empty note!")
                }
            }
        }
    ) {
        EditFields(noteTitle, noteBody)
    }
}

@Composable
fun EditFields(
    noteTitle: MutableState<TextFieldValue>,
    noteBody: MutableState<TextFieldValue>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TextField(
            value = noteTitle.value,
            onValueChange = { noteTitle.value = it },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(fontSize = 22.sp),
            placeholder = { Text(text = "Title", fontSize = 22.sp) },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Transparent,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent
            )
        )
        TextField(
            value = noteBody.value,
            onValueChange = { noteBody.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            maxLines = Int.MAX_VALUE,
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
            placeholder = { Text(text = "Note", fontSize = 16.sp) },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Default
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Transparent,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent
            )
        )
    }
}