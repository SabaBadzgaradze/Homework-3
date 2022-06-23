package com.example.profileinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.profileinfo.databinding.ActivityMain2Binding
import com.example.profileinfo.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.extras?.getString("email","Mail")
        val username = intent.extras?.getString("username","Username")
        val firstName = intent.extras?.getString("firstName","firstName")
        val lastName = intent.extras?.getString("lastName","firstName")
        val age = intent.extras?.getInt("age",0)
        binding.tvEmail.text = "Name: $email"
        binding.tvUsername.text = "Username: $username"
        binding.tvFirstName.text = "FirstName: $firstName"
        binding.tvLastName.text = "LastName: $lastName"
        binding.tvAge.text = "Age: $age"

        signOut()
    }

    private fun signOut(){
        binding.btnSignOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}