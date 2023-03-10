package com.example.android3lesson1dop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.android3lesson1dop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserves()
        setupListener()
    }

    private fun setupObserves() {
        viewModel?.number?.observe(this) {
            binding.tvInt.text = it.toString()
        }
    }

    private fun setupListener() {
        binding.btnPlus.setOnClickListener {
            viewModel?.setPlus()
            if (viewModel?.count == 10 || viewModel?.count == -10) {
                binding.tvInt.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.yellow
                    )
                )
            } else {
                binding.tvInt.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            }
        }
        binding.btnMinus.setOnClickListener {
            viewModel?.setMinus()
            if (viewModel?.count == -10 || viewModel?.count == 10) {
                binding.tvInt.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.yellow
                    )
                )
            } else {
                binding.tvInt.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            }
        }
    }
}
