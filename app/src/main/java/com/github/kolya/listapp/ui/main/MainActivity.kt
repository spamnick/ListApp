package com.github.kolya.listapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.kolya.listapp.R
import com.github.kolya.listapp.ui.users.UserListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onStart() {
        super.onStart()
        /*only in onStart, because at onCreate findNavController is NULL*/
        setupToolbar()
    }

    private fun setupToolbar() {
        val navController = findNavController(R.id.nav_host_fragment)
        // This remaining block is only necessary if using a Toolbar from your layout.
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setupWithNavController(navController)
        // This will handle back actions initiated by the the back arrow
        // at the start of the toolbar.
        toolbar.setNavigationOnClickListener {
            // Handle the back button event and return to override
            // the default behavior the same way as the OnBackPressedCallback.
            // (reason: handle custom back behavior here if desired.)
            // If no custom behavior was handled perform the default action.
            navController.navigateUp() || super.onSupportNavigateUp()
        }
    }

    override fun onBackPressed() {
        if (!findNavController(R.id.nav_host_fragment).navigateUp())
        super.onBackPressed()
    }
}