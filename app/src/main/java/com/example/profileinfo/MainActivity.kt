package com.example.profileinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.profileinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        save()
        clear()
    }

    private fun save (){
        binding.save.setOnClickListener {

            val email = binding.edEmail.text.toString()
            val username = binding.edUsername.text.toString()
            val firstName = binding.edFirstName.text.toString()
            val lastName = binding.edLastName.text.toString()
            val age = binding.edAge.text.toString()

            if (email.isNotEmpty() && username.isNotEmpty()
                && firstName.isNotEmpty() && lastName.isNotEmpty()
                && age.isNotEmpty()){

                if (username.length < 10) {

                    Toast.makeText(
                        this,
                        "“Username”-ში შეყვანილი სიმბოლოების რაოდენობა არ უნდა იყოს 10-ზე ნაკლები.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener

                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    Toast.makeText(this, "email არასწორია", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else{
                    Toast.makeText(this, "თქვენი ინფორმაცია შენახულია", Toast.LENGTH_SHORT).show()
                    startActivity()
                    finish()
                }

            }else{
                Toast.makeText(this, "გთხოვთ შეავსოთ ველი", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clear(){
        binding.clear.setOnLongClickListener{
            binding.edEmail.setText("")
            binding.edUsername.setText("")
            binding.edFirstName.setText("")
            binding.edLastName.setText("")
            binding.edAge.setText("")
            return@setOnLongClickListener true
        }

    }

    private fun startActivity(){
        val email:String = binding.edEmail.text.toString()
        val username:String = binding.edUsername.text.toString()
        val firstName:String = binding.edFirstName.text.toString()
        val lastName:String = binding.edLastName.text.toString()
        val age:Int = binding.edAge.text.toString().toInt()
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("email",email)
        intent.putExtra("username",username)
        intent.putExtra("firstName",firstName)
        intent.putExtra("lastName",lastName)
        intent.putExtra("age",age)
        startActivity(intent)
    }
}