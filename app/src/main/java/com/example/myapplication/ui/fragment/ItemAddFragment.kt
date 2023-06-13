package com.example.myapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentItemAddBinding

class ItemAddFragment : Fragment() {
    private lateinit var binding: FragmentItemAddBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemAddBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        navController = findNavController()
        binding.addTask.setOnClickListener {
            navController.navigate(R.id.action_itemAddFragment_to_homeFragment)
        }

        binding.ivBack.setOnClickListener {
            navController.navigate(R.id.action_itemAddFragment_to_homeFragment)
        }
    }
}