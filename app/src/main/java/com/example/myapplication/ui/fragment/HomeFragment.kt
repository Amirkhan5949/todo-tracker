package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.TaskViewModel
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.adapter.TaskListAdapter
import com.example.myapplication.ui.bottomsheet.ShowCalendarViewBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private val taskViewModel: TaskViewModel by viewModels()

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
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.taskRecycler.layoutManager = layoutManager
        onBackPressed()
    }

    private fun setupOnClickListeners() {
        binding.tvHello.setOnClickListener { navController.navigate(R.id.action_homeFragment_to_item_Add_Fragment) }

        binding.tvAddTask.setOnClickListener {
            val actionHomeFragmentToViewTransactions =
                HomeFragmentDirections.actionHomeFragmentToItemAddFragment()
            navController.navigate(actionHomeFragmentToViewTransactions)
        }

        binding.calendar.setOnClickListener {
            ShowCalendarViewBottomSheet().show(
                childFragmentManager,
                tag
            )
        }

        taskViewModel.getAllTask().observe(this) {
            val adapter = TaskListAdapter(it)
            binding.taskRecycler.adapter = adapter
        }

    }

    private fun onBackPressed() = requireActivity().onBackPressedDispatcher.addCallback(
        viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })

}
