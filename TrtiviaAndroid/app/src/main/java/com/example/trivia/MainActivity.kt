package com.example.trivia

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.trivia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpButton()
    }

    private fun setUpButton() {
        val navController = this.findNavController(R.id.my_nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navController)
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = this.findNavController(R.id.my_nav_host_fragment)
        return NavigationUI.navigateUp(navController,binding.drawerLayout)
    }
//for up button
//    private fun setUpButton() {
//        val navController = this.findNavController(R.id.my_nav_host_fragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)
//    }
//
//    override fun onSupportNavigateUp(): Boolean = this.findNavController(R.id.my_nav_host_fragment) .navigateUp()

    fun onFragmentInteraction(title: String?) {
        supportActionBar!!.title = title
    }
}