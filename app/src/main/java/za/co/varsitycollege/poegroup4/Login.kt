package za.co.varsitycollege.poegroup4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.Toast
import za.co.varsitycollege.poegroup4.databinding.ActivityLoginBinding
import za.co.varsitycollege.poegroup4.databinding.ActivitySignUpBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)
        databaseHelper= DatabaseHelper(this)

        binding.logbutton.setOnClickListener {
            val loginEmail=binding.editTextEmail.text.toString()
            val loginPassword=binding.editTextPassword.text.toString()
            loginDatabase(loginEmail,loginPassword)
        }
        binding.logbutton.setOnClickListener{
            val intent=Intent(this,homepage::class.java)
            startActivity(intent)
            finish()
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
    private fun loginDatabase(email:String,password:String){
        val userExists=databaseHelper.readUser(email,password)
        if(userExists){
            Toast.makeText(this,"Login is Successful",Toast.LENGTH_SHORT).show()
            val intent= Intent(this,homepage::class.java)
            startActivity(intent)
            finish()
        }else {
        Toast.makeText(this,"Login faailed",Toast.LENGTH_SHORT).show()
        }
    }
}