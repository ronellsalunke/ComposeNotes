package ronell.composenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ronell.composenotes.ui.screens.Edit
import ronell.composenotes.ui.screens.Home
import ronell.composenotes.ui.theme.ComposeNotesTheme
import ronell.composenotes.ui.viewmodel.NoteViewModel
import ronell.composenotes.ui.viewmodel.NoteViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((application as NoteApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NoteIt(viewModel)
                }
            }
        }
    }
}

@Composable
fun NoteIt(viewModel: NoteViewModel) {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        NavHost(navController, "home", Modifier.padding(innerPadding)) {
            composable("home") { Home(viewModel, navController) }
            composable("edit") { Edit() }
        }
    }
}
