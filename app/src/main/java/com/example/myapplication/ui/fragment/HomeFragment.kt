package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        setupOnClickListeners()
        return binding.root
    }

    private fun init() {
        navController = findNavController()
    }
    private fun setupOnClickListeners() {
        binding.tvHello.setOnClickListener {
            //navigate with action id
            navController.navigate(R.id.action_homeFragment_to_item_Add_Fragment)
        }

        binding.tvAddTask.setOnClickListener {
            //navigate with direction object
            val actionHomeFragmentToViewTransactions = HomeFragmentDirections.actionHomeFragmentToItemAddFragment()
            navController.navigate(actionHomeFragmentToViewTransactions)
        }

       /*binding.calendar.setOnClickListener {
           val navOption = NavOptions.Builder()
               .setEnterAnim(R.anim.slide_in_right)
               .setExitAnim(R.anim.slide_out_left)
               .setPopEnterAnim(R.anim.slide_in_left)
               .setPopExitAnim(R.anim.slide_out_right)
               .build()

           navController.navigate(R.id.action_homeFragment_to_item_Add_Fragment,null,navOption)
       }*/
    }

}
