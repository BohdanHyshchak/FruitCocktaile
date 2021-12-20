package com.example.fruitcoctaile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.fruitcoctaile.R
import com.example.fruitcoctaile.databinding.FragmentGameBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
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
                if(healthCount == 0) {
                    val gameOverDialog = GameOverDialogFragment()
                    gameOverDialog.show(parentFragmentManager, TAG)
                }
            }
        )

        return binding.root
    }

    private fun startGame() {
        lifecycleScope.launch {
            itemOne()
        }
        lifecycleScope.launch {
            itemTwo()
        }
        lifecycleScope.launch {
            itemThree()
        }
        lifecycleScope.launch {
            itemFour()
        }
        lifecycleScope.launch {
            itemFive()
        }
    }

//    private fun loadBanner() {
//        MobileAds.initialize(requireContext())
//        binding.adView.loadAd(AdRequest.Builder().build())
//    }

    private fun itemOne() = lifecycleScope.launch {
        delay(2500L)
        deadLine = binding.ivStick.y + 100f
        binding.img1.y = startHeight
        binding.img1.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
        binding.img1.setBackgroundResource(getRandomImg(randomImg1))

        var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
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
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img1.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img1.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
            if (binding.img1.y.toInt() >= deadLine.toInt()) {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg1)) {
                    removeLife()
                }
                randomImg1 = Random.nextInt(1, 6)
                binding.img1.setBackgroundResource(getRandomImg(randomImg1))
                speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img1.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img1.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
        }
    }

    private fun itemTwo() = lifecycleScope.launch {
        delay(3500L)
        deadLine = binding.ivStick.y + 100f
        binding.img2.y = startHeight
        binding.img2.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
        binding.img2.setBackgroundResource(getRandomImg(randomImg2))

        var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
        Log.d(TAG, binding.ivStick.y.toString())
        while (true) {
            // Log.d(TAG, binding.img2.y.toString())
            delay(speed.toLong())
            binding.img2.y += 1f
            binding.img2.setOnClickListener {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg2)) {
                    addScore()
                } else {
                    removeLife()
                }
                randomImg2 = Random.nextInt(1, 6)
                binding.img2.setBackgroundResource(getRandomImg(randomImg2))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img2.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img2.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
            if (binding.img2.y.toInt() >= deadLine.toInt()) {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg2)) {
                    removeLife()
                }
                randomImg2 = Random.nextInt(1, 6)
                binding.img2.setBackgroundResource(getRandomImg(randomImg2))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img2.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img2.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
        }
    }

    private fun itemThree() = lifecycleScope.launch {
        delay(5500L)
        deadLine = binding.ivStick.y + 100f
        binding.img3.y = startHeight
        binding.img3.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
        binding.img3.setBackgroundResource(getRandomImg(randomImg3))

        var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
        Log.d(TAG, binding.ivStick.y.toString())
        while (true) {
            // Log.d(TAG, binding.img3.y.toString())
            delay(speed.toLong())
            binding.img3.y += 1f
            binding.img3.setOnClickListener {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg3)) {
                    addScore()
                } else {
                    removeLife()
                }
                randomImg3 = Random.nextInt(1, 6)
                binding.img3.setBackgroundResource(getRandomImg(randomImg3))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img3.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img3.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
            if (binding.img3.y.toInt() >= deadLine.toInt()) {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg3)) {
                    removeLife()
                }
                randomImg3 = Random.nextInt(1, 6)
                binding.img3.setBackgroundResource(getRandomImg(randomImg3))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img3.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img3.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
        }
    }

    private fun itemFour() = lifecycleScope.launch {
        delay(7500L)
        deadLine = binding.ivStick.y + 100f
        binding.img4.y = startHeight
        binding.img4.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
        binding.img4.setBackgroundResource(getRandomImg(randomImg4))

        var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
        Log.d(TAG, binding.ivStick.y.toString())
        while (true) {
            // Log.d(TAG, binding.img4.y.toString())
            delay(speed.toLong())
            binding.img4.y += 1f
            binding.img4.setOnClickListener {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg4)) {
                    addScore()
                } else {
                    removeLife()
                }
                randomImg4 = Random.nextInt(1, 6)
                binding.img4.setBackgroundResource(getRandomImg(randomImg4))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img4.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img4.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
            if (binding.img4.y.toInt() >= deadLine.toInt()) {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg4)) {
                    removeLife()
                }
                randomImg4 = Random.nextInt(1, 6)
                binding.img4.setBackgroundResource(getRandomImg(randomImg4))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img4.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img4.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
        }
    }

    private fun itemFive() = lifecycleScope.launch {
        delay(9500L)
        deadLine = binding.ivStick.y + 100f
        binding.img5.y = startHeight
        binding.img5.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
        binding.img5.setBackgroundResource(getRandomImg(randomImg5))

        var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
        Log.d(TAG, binding.ivStick.y.toString())
        while (true) {
            // Log.d(TAG, binding.img5.y.toString())
            delay(speed.toLong())
            binding.img5.y += 1f
            binding.img5.setOnClickListener {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg5)) {
                    addScore()
                } else {
                    removeLife()
                }
                randomImg5 = Random.nextInt(1, 6)
                binding.img5.setBackgroundResource(getRandomImg(randomImg5))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img5.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img5.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
            if (binding.img5.y.toInt() >= deadLine.toInt()) {
                Log.d(TAG, "TRUE")
                if (!checkIsBomb(randomImg5)) {
                    removeLife()
                }
                randomImg5 = Random.nextInt(1, 6)
                binding.img5.setBackgroundResource(getRandomImg(randomImg5))
                var speed = Random.nextInt(Values.minDelay, Values.maxDelay - Values.difficulty)
                binding.img5.y = Random.nextInt(Values.minHeight, Values.maxHeight).toFloat()
                binding.img5.x = Random.nextInt(Values.minX, Values.maxX).toFloat()
            }
        }
    }

    private fun getRandomImg(randomNumber: Int): Int {
        return when (randomNumber) {
            1 -> R.drawable.fruit_1
            2 -> R.drawable.fruit_2
            3 -> R.drawable.fruit_3
            4 -> R.drawable.fruit_4
            else -> R.drawable.bomb
        }
    }

    private fun checkIsBomb(id: Int): Boolean {
        return id == 5
    }

    private fun addScore() {
        score++
        Values.score++
        binding.tvScore.text = "Score: $score"
        Log.d(TAG, Values.score.toString())
    }

    private fun removeLife() {
        val currentHealth = health.value
        if (currentHealth != null && currentHealth > 0) {
            health.postValue(currentHealth - 1)
        }
    }
}
