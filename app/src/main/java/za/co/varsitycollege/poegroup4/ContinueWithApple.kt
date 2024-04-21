package za.co.varsitycollege.poegroup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import za.co.varsitycollege.poegroup4.databinding.ActivityContinueWithAppleBinding


class ContinueWithApple : AppCompatActivity() {

    private lateinit var binding: ActivityContinueWithAppleBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continue_with_apple)
        binding = ActivityContinueWithAppleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.btnAppleContinue.setOnClickListener {
            val signupEmail = binding.editTextAppleEmail.text.toString()
            val signupPassword = binding.editTextApplePassword.text.toString()
            signupDatabase(signupEmail, signupPassword)
        }
       binding.btnAppleContinue.setOnClickListener{
        val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun signupDatabase(email:String,password:String){
        val insertRowId = databaseHelper.insertUser(email,password)
        if (insertRowId != -1L){
            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Sign Up failed", Toast.LENGTH_SHORT).show()
        }
    }
}