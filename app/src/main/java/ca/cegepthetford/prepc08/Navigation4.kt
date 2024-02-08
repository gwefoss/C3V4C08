package ca.cegepthetford.prepc08

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation4() {
    val controleurNav = rememberNavController()
    NavHost(
        navController = controleurNav,
        startDestination = "Accueil"
    ) {
        composable(route = "Accueil") { entree ->
            if(!entree.savedStateHandle.contains("username"))
                entree.savedStateHandle.set<String>("username","_______")
            val uname = entree.savedStateHandle.get<String>("username")
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Username: $uname",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(onClick = {
                    controleurNav.navigate(route = "FicheIdentite")
                }) {
                    Text(text = "Concevoir", fontSize = 20.sp)
                }
            }
        }
        composable(route = "FicheIdentite") {
            BackHandler(true) { }
            FicheIdentite(
                controleurNav
            )
        }
    }
}


@Composable
fun FicheIdentite(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var prenom : String by remember { mutableStateOf("Adam")}
        var nom : String by remember { mutableStateOf("Bernard")}
        OutlinedTextField (
            value = prenom,
            onValueChange = { prenom = it},
            label = { Text("Entrez votre prénom") }
        )
        OutlinedTextField (
            value = nom,
            onValueChange = { nom = it},
            label = { Text("Entrez votre nom") }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            val nouveauUsername : String =
                prenom.lowercase().slice(0..2) +
                nom.lowercase().slice(0..3)
            navController.previousBackStackEntry?.savedStateHandle?.set("username", nouveauUsername)
            navController.popBackStack()
        }) {
            Text(text = "Retour", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun ApercuNavigation4() {
    Navigation4()
}