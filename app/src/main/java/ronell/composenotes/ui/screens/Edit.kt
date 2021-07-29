package ronell.composenotes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Edit() {
    val noteTitle = remember { mutableStateOf(TextFieldValue()) }
    val noteBody = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                // TODO: add navigate up logic
            ) {
            }
        }
    ) {
        EditFields(noteTitle, noteBody)
        // TODO: add saving/updating/deleting logic
    }
}

@Composable
fun EditFields(noteTitle: MutableState<TextFieldValue>, noteBody: MutableState<TextFieldValue>) {
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