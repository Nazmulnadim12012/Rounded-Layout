package com.example.layoutwithroundedcorner

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userEditText = findViewById(R.id.userName)
        passwordEditText = findViewById(R.id.password)
        submitButton = findViewById(R.id.submitButton)



        userEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)


        submitButton.setOnClickListener {
            Toast.makeText(this@MainActivity,"Submit button clicked",Toast.LENGTH_SHORT).show()
        }



    }
   private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            val userName = userEditText.text.toString()
            val password = passwordEditText.text.toString()

            submitButton.isEnabled = userName.isNotEmpty() && password.isNotEmpty()


        }

        override fun afterTextChanged(s: Editable?) {

        }
    }
}