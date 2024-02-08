package ca.cegepthetford.prepc08

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Navigation3() {
    val controleurNav = rememberNavController()
    NavHost(
        navController = controleurNav,
        startDestination = "EquipeProfs"
    ) {
        composable(route = "EquipeProfs") {
            EquipeProfs(controleurNav)
        }
        composable(
            route = "ProfIndividuel/{nom}",
            arguments = listOf(
                navArgument(name = "nom") {
                    type = NavType.StringType
                }
            )
        ) {
            FicheProfIndiv(
                controleurNav,
                it.arguments?.getString("nom")!!
            )
        }
    }
}


enum class CodeSexe { HOMME, FEMME }
data class Prof(val prenom : String, val nom : String, val codeSexe : CodeSexe)

val profs : List<Prof> = listOf(
    Prof("Marco", "Guay", CodeSexe.HOMME), Prof("Ridha", "Louati",CodeSexe.HOMME), Prof("Gilles", "Portelance", CodeSexe.HOMME), Prof("Frederic", "Bergeron", CodeSexe.HOMME), Prof("Mathieu","Morissette", CodeSexe.HOMME), Prof("Marie-Pier","Nadeau",CodeSexe.FEMME)
)

@Composable
fun EquipeProfs(navController: NavHostController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ){
        item {
            Text(
                text = "Liste des profs", fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(height = 8.dp)) }
        itemsIndexed(items = profs) { indice, prof ->
            ListItem(
                headlineContent = {
                    Text(
                        text = "${indice+1}. ${prof.nom}, ${prof.prenom}",
                        fontSize = 20.sp
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Icone vers détail"
                    )
                },
                modifier = Modifier.clickable {
                    navController.navigate(route = "ProfIndividuel/${prof.nom}")
                }
            )
        } }
}

@Composable
fun FicheProfIndiv(navController: NavHostController, nom: String) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val leProf : Prof = profs.firstOrNull() { unProf -> unProf.nom == nom} !!
        Text(
            text = "Prenom: ${leProf.prenom}",
            fontSize = 40.sp
        )
        Text(
            text = "Nom: $nom",
            fontSize = 40.sp
        )
        Text(
            text = "Code sexe: " + if(leProf.codeSexe == CodeSexe.HOMME) "Homme" else "Femme",
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

