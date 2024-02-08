

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
            navController.navigate(route = "A") {
                popUpTo(route = "A") { inclusive = true}
            }
        }) {
            Text(text = "Retourner au premier écran", fontSize = 20.sp)
        }

    }
}