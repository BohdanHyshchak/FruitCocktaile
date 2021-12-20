package com.example.fruitcoctaile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.fruitcoctaile.R
import com.example.fruitcoctaile.databinding.FragmentGameOverBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class GameOverDialogFragment : DialogFragment() {
    lateinit var binding: FragmentGameOverBinding
    private var mInterstitialAd: InterstitialAd? = null
    private val TAG = "Game over"
    private var hasAdShown = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameOverBinding.inflate(layoutInflater)

        binding.btnExit.setOnClickListener {
            ActivityCompat.finishAffinity(this.requireActivity())
        }

        binding.btnAgain.setOnClickListener {
            findNavController().navigate(R.id.gameFragment)
            Values.score = 0
            dismiss()
        }

        binding.tvYourScore.text = "Your score is ${Values.score}"

        return binding.root
    }
}
