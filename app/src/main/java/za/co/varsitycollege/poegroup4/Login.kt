package za.co.varsitycollege.poegroup4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Toast
import za.co.varsitycollege.poegroup4.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //https://medium.com/@zehradurmus/a-beginners-guide-to-viewbinding-in-android-studio-1ba9353e2652
        //Zehra Durmus

        databaseHelper= DatabaseHelper(this)

        binding.logbutton.setOnClickListener {
            val loginEmail=binding.editTextEmail.text.toString()
            val loginPassword=binding.editTextPassword.text.toString()
            loginDatabase(loginEmail, loginPassword)

        }

         binding.btnreturnlog.setOnClickListener{
             val intent= Intent(this,MainActivity::class.java)
             startActivity(intent)
             finish()
         }


         binding.btnforgot.setOnClickListener{
             val intent= Intent(this,forgotPassword::class.java)
            startActivity(intent)
            finish()
         }

    }
    private fun loginDatabase(email: String,password: String){
        val userExists = databaseHelper.readUser(email, password)
        if(userExists){
            Toast.makeText(this,"Login is Successful",Toast.LENGTH_SHORT).show()
            val intent= Intent(this,homepage::class.java)
            startActivity(intent)
            finish()
        }else {
        Toast.makeText(this,"Login failed",Toast.LENGTH_SHORT).show()
        }   //https://engineering.backmarket.com/from-kotlin-synthetics-to-android-viewbinding-the-definitive-guide-c98c6e89fe0b
        //Florian Le Ficher
    }
}