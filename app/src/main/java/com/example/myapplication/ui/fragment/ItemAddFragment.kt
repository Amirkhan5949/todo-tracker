package com.example.myapplication.ui.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.TaskViewModel
import com.example.myapplication.databinding.FragmentItemAddBinding
import com.example.myapplication.model.Task
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemAddFragment : Fragment() {
    private lateinit var binding: FragmentItemAddBinding
    private lateinit var navController: NavController
    private val taskViewModel: TaskViewModel by viewModels()

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
        binding.addTask.setOnClickListener { saveTask() }
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

     private fun onBackPressed() {
        findNavController().popBackStack()
    }

    private fun saveTask() {
        val taskTitle = binding.addTaskTitle.text.toString()
        val taskDes = binding.addTaskDescription.text.toString()
        val taskDate = binding.taskDate.text.toString()
        val taskTime = binding.taskTime.text.toString()
        val addEvent = binding.taskEvent.text.toString()

        val task = Task(0,taskTitle, taskDes, taskDate, taskTime,addEvent)
        val isValidationSuccessful = taskViewModel.insertTask(task)

        if (isValidationSuccessful) {
            Toast.makeText(requireContext(), getString(R.string.data_saved), Toast.LENGTH_LONG).show()
            onBackPressed()
        } else {
            Toast.makeText(requireContext(), getString(R.string.validation), Toast.LENGTH_SHORT).show()
        }
    }

}