package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.NewFraseButtonID.setOnClickListener(this)



        supportActionBar?.hide()

        //HandleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()

        binding.NewFraseButtonID.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageFace.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.NameViewID.setOnClickListener(this)

    }

    //onResume refresh the activity before user access (Refresh the user name before user access)
    override fun onResume(){
        super.onResume()
        HandleUserName()

    }

    override fun onClick(v: View?) {
        if (v != null) {
            if(v.id == R.id.NewFraseButtonID){
                handleNextPhrase()
            }else if (v.id in listOf(R.id.image_all, R.id.image_face, R.id.image_sunny)){
                handleFilter(v.id)

            }else if(v.id == R.id.NameViewID){
                startActivity(Intent(this,UserIntro::class.java))
            }
        }
    }

    private fun handleFilter(id: Int){

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.purple_default))
        binding.imageFace.setColorFilter(ContextCompat.getColor(this, R.color.purple_default))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.purple_default))

        when (id) {
            R.id.image_all -> {

                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.filter.all
            }
            R.id.image_face -> {

                binding.imageFace.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.filter.face
            }
            R.id.image_sunny -> {

                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.filter.sunny
            }
        }
    }

    private fun handleNextPhrase(){
        binding.MessageViewID.text = Mock().getPhrase(categoryId)
    }

    private fun HandleUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.key.USER_NAME)
        binding.NameViewID.text = "Olá, ${name}!"
    }
}