package com.example.geochat

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.geochat.screens.ChatScreen
import com.example.geochat.screens.MapScreen
import com.example.geochat.screens.Message
import com.example.geochat.screens.SettingsScreen
import com.example.geochat.ui.theme.GeochatTheme
import com.example.geochat.utils.Constants
import kotlin.random.Random

private const val SCREEN_STATE_KEY = "screen_state_key"

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeochatTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App() {
    // remember navController so it does not
    // get recreated on recomposition
    val navController = rememberNavController()

    Surface /*(color = Color.White)*/ {
        // Scaffold Component
        Scaffold(
            // Bottom navigation
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }, content = { padding ->
                // Navhost: where screens are placed
                NavHostContainer(navController = navController, padding = padding)
            }
        )
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "map",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            // route : Home
            composable("chat") {
                ChatScreen()
            }

            // route : search
            composable("map") {
                MapScreen()
            }

            // route : profile
            composable("settings") {
                SettingsScreen()
            }
        })

}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(

        // set background color
        containerColor = Color(0x000000)
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            NavigationBarItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
    }
}