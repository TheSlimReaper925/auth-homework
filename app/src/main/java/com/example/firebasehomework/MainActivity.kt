package com.example.firebasehomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        signUpBtn.setOnClickListener {
            val email = inputEmail.text.toString()
            val pass = password.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                Toast.makeText(this, "Something is wrong, I can feel it", Toast.LENGTH_LONG).show()
            }

            else{
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, OnCompleteListener {
                    task ->  if (task.isSuccessful){
                    Toast.makeText(this, "Something is not wrong, I can feel it", Toast.LENGTH_LONG).show()
                    inputEmail.text.clear()
                    password.text.clear()
                }
                    else {
                    Toast.makeText(this, "Something is still wrong I can feel it", Toast.LENGTH_LONG).show()
                }
                })
            }
        }


    }
}
