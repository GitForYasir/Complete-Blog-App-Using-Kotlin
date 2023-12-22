package com.example.blogapp.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blogapp.MainActivity
import com.example.blogapp.R
import com.example.blogapp.SignInAndRegistrationActivity
import com.example.blogapp.databinding.ActivityWelcomeBinding
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private val binding: ActivityWelcomeBinding by lazy{
        ActivityWelcomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, SignInAndRegistrationActivity::class.java)
            intent.putExtra("action", "login")
            startActivity(intent)
            finish()
        }

        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, SignInAndRegistrationActivity::class.java)
            intent.putExtra("action", "register")
            startActivity(intent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}