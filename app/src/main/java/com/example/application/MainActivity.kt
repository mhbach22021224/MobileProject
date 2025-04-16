package com.example.application

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.searchButton.setOnClickListener {
            val word = binding.searchInput.text.toString()
            getMeaning(word)
        }
    }

    private fun getMeaning(word : String) {
        GlobalScope.launch {
            val response = Retrofit.dictionaryAPI.getMeaning(word)

            runOnUiThread {
                setInProgress(false)
                response.body()?.first()?.let {
                    setUI(it)
                }
            }
        }
    }

    private fun setUI(response : WordResult) {
        binding.wordTextview.text = response.word
        binding.phoneticTextview.text = response.phonetics.toString()
    }

    private fun setInProgress(inProgress : Boolean) {
        if(inProgress) {
            binding.searchButton.visibility = View.INVISIBLE
            binding.progressBar.visibility = View.VISIBLE
        }  else {
            binding.searchButton.visibility = View.VISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}