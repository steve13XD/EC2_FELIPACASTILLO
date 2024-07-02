package pe.edu.idat.ec2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.edu.idat.ec2.ui.theme.EC2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EC2Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "menu") {
                    composable("menu") { MenuPrincipal(navController) }
                    composable("registro") { RegistroScreen(navController) }
                }
            }
        }
    }
}

@Composable
fun MenuPrincipal(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_globe),
                        contentDescription = "World Image",
                        modifier = Modifier
                            .size(150.dp)
                            .padding(bottom = 50.dp)
                    )
                    Button(onClick = { navController.navigate("registro") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 8.dp)
                            .background(Color.Gray, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("REGISTRO", fontSize = 18.sp, color = Color.Black)
                    }
                    Button(onClick = { /* Navigate to Formulario Screen */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 8.dp)
                            .background(Color.Gray, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("FORMULARIO", fontSize = 18.sp, color = Color.Black)
                    }
                    Button(onClick = { /* Navigate to Listado Screen */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 8.dp)
                            .background(Color.Gray, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("LISTADO", fontSize = 18.sp, color = Color.Black)
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("INFORMACIÓN") },
                Modifier.background(color = Color.White),

            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    val textFieldModifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)

                    var nombre = remember { TextFieldValue() }
                    var apellidos = remember { TextFieldValue() }
                    var dni = remember { TextFieldValue() }
                    var celular = remember { TextFieldValue() }
                    var email = remember { TextFieldValue() }
                    var otroPrograma = remember { TextFieldValue() }

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") },
                        modifier = textFieldModifier
                    )
                    OutlinedTextField(
                        value = apellidos,
                        onValueChange = { apellidos = it },
                        label = { Text("Apellidos") },
                        modifier = textFieldModifier
                    )
                    OutlinedTextField(
                        value = dni,
                        onValueChange = { dni = it },
                        label = { Text("DNI") },
                        modifier = textFieldModifier
                    )
                    OutlinedTextField(
                        value = celular,
                        onValueChange = { celular = it },
                        label = { Text("Celular") },
                        modifier = textFieldModifier
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = textFieldModifier
                    )
                    Text("Seleccione Programas que domine:")


                    OutlinedTextField(
                        value = otroPrograma,
                        onValueChange = { otroPrograma = it },
                        label = { Text("Ingrese otro programa") },
                        modifier = textFieldModifier
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                navController.popBackStack()
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("Acceder", fontSize = 18.sp, color = Color.Black)
                    }
                }
            }
        }
    )
}
