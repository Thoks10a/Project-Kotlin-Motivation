package com.example.motivation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.databinding.ActivityUserIntroBinding
import java.lang.Exception

class UserIntro : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.UserButtonSaveID.setOnClickListener(this)



        supportActionBar?.hide()

        //verifyUserName()
    }

    override fun onClick(v: View?) {

        if (v != null) {
            if(v.id == R.id.UserButtonSaveID){
                handleSave()
            }
        }else{

            Toast.makeText(this@UserIntro,"Porfavor preencha seu nome!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSave(){
            try{


                var name = binding.UserInputNameID.text.toString()
                if(name != "" && name.length > 3){
                    SecurityPreferences(this).storeString(MotivationConstants.key.USER_NAME,name)
                    //startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this@UserIntro,"Porfavor preencha seu nome, deve conter no minimo 4 letras!",Toast.LENGTH_SHORT).show()
                }


            }catch(e: Exception){
                Toast.makeText(this@UserIntro,"Porfavor preencha seu nome!",Toast.LENGTH_SHORT).show()
            }


        }


    /*private fun verifyUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.key.USER_NAME)
        if(name != ""){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }*/
}