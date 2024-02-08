package ca.cegepthetford.prepc08

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation2() {
    val controleurNav = rememberNavController()
    NavHost(
        navController = controleurNav,
        startDestination = "Formulaire"
    ) {
        composable(
            route = "Formulaire"
        ) {
            Formulaire(controleurNav)
        }
        composable(
            route = "Salutation/{prenom}",
            arguments = listOf(
                navArgument(name = "prenom") {
                    type = NavType.StringType
                }
            )
        ) {
            Salutation(
                controleurNav,
                it.arguments?.getString("prenom")
            )
        }
        composable(
            route = "SalutationPNA/{prenom}/{nom}/{age}",
            arguments = listOf(
                navArgument(name = "prenom") {
                    type = NavType.StringType
                },
                navArgument(name = "nom") {
                    type = NavType.StringType
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                }
            )
        ) {
            SalutationPNA(
                controleurNav,
                it.arguments?.getString("prenom"),
                it.arguments?.getString("nom"),
                it.arguments?.getInt("age")
            )
        }
        composable(
            route = "SalutationOptions?prenom={prenom}&nom={nom}&age={age}",
            arguments = listOf(
                navArgument(name = "prenom") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument(name = "nom") {
                    type = NavType.StringType
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                    defaultValue = 99 // 99 ans par défaut
                }
            )
        ) {
            SalutationPNA(
                controleurNav,
                it.arguments?.getString("prenom"),
                it.arguments?.getString("nom"),
                it.arguments?.getInt("age")
            )
        }
    }
}

@Composable
fun Formulaire(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var saisie by remember { mutableStateOf("") }
        OutlinedTextField (
            value = saisie,
            onValueChange = { saisie = it},
            label = { Text("Entrez votre prénom") }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            navController.navigate(route = "Salutation/${saisie}")
        }) {
            Text(text = "Soumettre", fontSize = 20.sp)
        }
        Button(onClick = {
            navController.navigate(route = "SalutationPNA/Adam/Bernard/24")
        }) {
            Text(text = "Soumettre adabern", fontSize = 20.sp)
        }
        Button(onClick = {
            navController.navigate(route = "SalutationOptions?prenom=Adam&nom=Bernard&age=24")
        }) {
            Text(text = "Soumettre ?prenom=Adam&nom=Bernard&age=24", fontSize = 10.sp)
        }
        Button(onClick = {
            navController.navigate(route = "SalutationOptions?nom=Bernard&age=24")
        }) {
            Text(text = "Soumettre ?nom=Bernard&age=24", fontSize = 10.sp)
        }
        Button(onClick = {
            navController.navigate(route = "SalutationOptions?prenom=Adam&nom=Bernard")
        }) {
            Text(text = "Soumettre ?prenom=Adam&nom=Bernard", fontSize = 10.sp)
        }
    }
}

@Composable
fun Salutation(navController: NavHostController, prenom : String?) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bonjour $prenom",
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Retour", fontSize = 20.sp)
        }
    }
}

@Composable
fun SalutationPNA(
    navController: NavHostController,
    prenom : String?,
    nom : String?,
    age : Int?
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Prenom: $prenom",
            fontSize = 40.sp
        )
        Text(
            text = "Nom: $nom",
            fontSize = 40.sp
        )
        Text(
            text = "Age: $age",
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Retour", fontSize = 20.sp)
        }
    }
}