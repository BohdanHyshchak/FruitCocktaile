package com.example.fruitcoctaile.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fruitcoctaile.R
import com.example.fruitcoctaile.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)

        binding.btnStartGame.setOnClickListener {
            // findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
            binding.startContainer.visibility = View.GONE
            binding.difficultyContainer.visibility = View.VISIBLE
        }
        binding.btnExit.setOnClickListener {
            ActivityCompat.finishAffinity(this.requireActivity())
        }

        binding.btnEasy.setOnClickListener {
            Values.difficulty = 0
            findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }

        binding.btnHARD.setOnClickListener {
            Values.difficulty = 1
            findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }

        binding.btnBRUTAL.setOnClickListener {
            Values.difficulty = 2
            findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }
        return binding.root
    }
}
