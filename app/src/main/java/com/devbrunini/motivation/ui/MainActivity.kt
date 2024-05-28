package com.devbrunini.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devbrunini.motivation.utils.MotivationConstants
import com.devbrunini.motivation.R
import com.devbrunini.motivation.utils.SecurityPreferences
import com.devbrunini.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        binding.textName.text = "Olá $name!"

        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
        binding.imageBubble.setOnClickListener(this)
        binding.imageInfinity.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        if (v.id == R.id.button_new_phrase){

        }else if (v.id in listOf( R.id.image_infinity, R.id.image_sun, R.id.image_bubble)){
            handleFilter(v.id)
        }

    }

    private fun handleFilter(id: Int){

        when (id) {
            R.id.image_infinity -> {
                binding.imageInfinity.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.violet_secondary))
                binding.imageBubble.setColorFilter(ContextCompat.getColor(this, R.color.violet_secondary))
                categoryId = 1
            }
            R.id.image_sun -> {
                binding.imageInfinity.setColorFilter(ContextCompat.getColor(this,R.color.violet_secondary))
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imageBubble.setColorFilter(ContextCompat.getColor(this, R.color.violet_secondary))
                categoryId = 3
            }
            R.id.image_bubble -> {
                binding.imageInfinity.setColorFilter(ContextCompat.getColor(this,R.color.violet_secondary))
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.violet_secondary))
                binding.imageBubble.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 2
            }
        }

    }
}