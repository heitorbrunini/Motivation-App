package com.devbrunini.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devbrunini.motivation.R
import com.devbrunini.motivation.utils.SecurityPreferences
import com.devbrunini.motivation.databinding.ActivityUserBinding
import com.devbrunini.motivation.utils.MotivationConstants

class UserActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSave.setOnClickListener(this)
        verifyUserName()

    }

    private fun verifyUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if(name !=""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(v: View) {

        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.textName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString("USER_NAME", name)

            startActivity(
                Intent(this, MainActivity::class.java))
                finish()
        } else {
            Toast.makeText(this, "Preencha seu nome", Toast.LENGTH_SHORT).show()
        }
    }

}