package ca.cegepthetford.prepc08

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //PrepC08Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                    //,                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                    //Navigation2()
                    //Navigation3()
                    //Navigation4()
                }
            //}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApercuNavigation() {
    //Navigation()
    //Navigation2()
    //Navigation3()
    Navigation4()
}