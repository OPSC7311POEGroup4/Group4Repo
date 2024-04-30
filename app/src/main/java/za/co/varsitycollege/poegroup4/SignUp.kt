package za.co.varsitycollege.poegroup4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Toast
import za.co.varsitycollege.poegroup4.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {


    private lateinit var binding: ActivitySignUpBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //https://medium.com/@zehradurmus/a-beginners-guide-to-viewbinding-in-android-studio-1ba9353e2652
        //Zehra Durmus
        databaseHelper = DatabaseHelper(this)

        binding.btnsignup.setOnClickListener {
            val signupEmail = binding.editTextSignUpEmail.text.toString()
            val signupPassword = binding.editTextSignUpPassword.text.toString()
            signupDatabase(signupEmail, signupPassword)

        }


        binding.btnreturnsign.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
           startActivity(intent)
           finish()
       }


        binding.btngoogle.setOnClickListener{
             val intent= Intent(this,ContinueWithGoogle::class.java)
             startActivity(intent)
              finish()
          }


         binding.btnapple.setOnClickListener{
             val intent= Intent(this,ContinueWithApple::class.java)
             startActivity(intent)
              finish()
          }
    }

    private fun signupDatabase(email: String,password: String){
        val insertRowId = databaseHelper.insertUser(email, password)
        if (insertRowId != -1L){
            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(this,"Sign Up failed",Toast.LENGTH_SHORT).show()
        }   //https://engineering.backmarket.com/from-kotlin-synthetics-to-android-viewbinding-the-definitive-guide-c98c6e89fe0b
        //Florian Le Ficher
    }
}