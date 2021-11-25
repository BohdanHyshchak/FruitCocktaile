package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGameBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding
    private val TAG = "Game Fragment"

    private var randomImg1 = Random.nextInt(1, 6)
    private var randomImg2 = Random.nextInt(1, 6)
    private var randomImg3 = Random.nextInt(1, 6)
    private var randomImg4 = Random.nextInt(1, 6)
    private var randomImg5 = Random.nextInt(1, 6)
    private var health = MutableLiveData<Int>(3)
    private var startHeight = -150f
    private var deadLine = 1000f
    var score = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)

        startGame()
        // loadBanner()

        health.observe(
            viewLifecycleOwner,
            { healthCount ->
                binding.tvHealth.text = "Health: $healthCount"
            }
        )

        return binding.root
    }

    private fun startGame() {
        lifecycleScope.launch {
            itemOne()
        }
//        delay(1500L)
//        lifecycleScope.launch {
//            itemTwo()
//        }
//        delay(1500L)
//        lifecycleScope.launch {
//            itemThree()
//        }
//        delay(1500L)
//        lifecycleScope.launch {
//            itemFour()
//        }
//        delay(1500L)
//        lifecycleScope.launch {
//            itemFive()
//        }
    }

//    private fun loadBanner() {
//        TODO()
//    }

    private fun itemOne() = lifecycleScope.launch {
        delay(2000L)
        deadLine = binding.ivStick.y + 100f
        binding.img1.y = startHeight
        binding.img1.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
        binding.img1.setBackgroundResource(getRandomImg(randomImg1))

        var speed = Random.nextInt(Values.minDelay, Values.maxDelay)
        Log.d(TAG, binding.ivStick.y.toString())
        while (true) {
            // Log.d(TAG, binding.img1.y.toString())
            delay(speed.toLong())
            binding.img1.y += 1f
            binding.img1.setOnClickListener {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg1)) {
                    addScore()
                } else {
                    removeLife()
                }
                randomImg1 = Random.nextInt(1, 6)
                binding.img1.setBackgroundResource(getRandomImg(randomImg1))
                speed = Random.nextInt(Values.minDelay, Values.maxDelay)
                binding.img1.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img1.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
            if (binding.img1.y.toInt() >= deadLine.toInt()) {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg1)) {
                    removeLife()
                } else {
                    // TODO()
                }
                randomImg1 = Random.nextInt(1, 6)
                binding.img1.setBackgroundResource(getRandomImg(randomImg1))
                speed = Random.nextInt(Values.minDelay, Values.maxDelay)
                binding.img1.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img1.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
        }
    }

    private fun getRandomImg(randomNumber: Int): Int {
        return when (randomNumber) {
            1 -> R.drawable.joker_1
            2 -> R.drawable.joker_2
            3 -> R.drawable.joker_3
            4 -> R.drawable.joker_4
            else -> R.drawable.bomb
        }
    }

    private fun checkIsBomb(id: Int): Boolean {
        return id == 5
    }

    private fun addScore() {
        score++
        binding.tvScore.text = "Score: $score"
        Log.d(TAG, Values.score.toString())
    }

    private fun removeLife() {
        val currentHealth = health.value
        if (currentHealth != null) {
            health.postValue(currentHealth - 1)
        }
    }
}
