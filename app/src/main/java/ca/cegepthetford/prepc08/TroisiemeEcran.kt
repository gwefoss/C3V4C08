package ca.cegepthetford.prepc08

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TroisiemeEcran(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Troisième écran",
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Retour", fontSize = 20.sp)
        }
        Button(onClick = {
            navController.navigate(route = "PremierEcran") {
                popUpTo(route = "PremierEcran") { inclusive = true}
            }
        }) {
            Text(text = "Retourner au premier écran", fontSize = 20.sp)
        }

    }
}