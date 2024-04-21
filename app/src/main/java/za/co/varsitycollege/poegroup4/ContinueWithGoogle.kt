package za.co.varsitycollege.poegroup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import za.co.varsitycollege.poegroup4.databinding.ActivityContinueWithGoogleBinding


class ContinueWithGoogle : AppCompatActivity() {
    private lateinit var binding: ActivityContinueWithGoogleBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continue_with_google)

        binding = ActivityContinueWithGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)

        binding.GoogleContinuebtn.setOnClickListener {
            val signupEmail = binding.editTextGoogleEmail.text.toString()
            val signupPassword = binding.editTextGooglePassword.text.toString()
            signupDatabase(signupEmail, signupPassword)
        }
       binding.GoogleContinuebtn.setOnClickListener{
          val intent= Intent(this,Login::class.java)
         startActivity(intent)
         finish()
       }


    }

    private fun signupDatabase(email:String,password:String) {
        val insertRowId = databaseHelper.insertUser(email, password)
        if (insertRowId != -1L) {
            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Sign Up failed", Toast.LENGTH_SHORT).show()
        }
    }

}