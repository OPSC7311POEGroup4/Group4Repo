package za.co.varsitycollege.poegroup4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ButtonLogin=findViewById<Button>(R.id.btnlogin)
        val ButtonSignUp=findViewById<Button>(R.id.btnsign)



        ButtonLogin.setOnClickListener{
            val intent= Intent(this,Login::class.java)
            startActivity(intent)
        }
        ButtonSignUp.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity((intent))
        }
    }
    //https://www.geeksforgeeks.org/handling-click-events-button-android/
    //Vijayaraghavan
}