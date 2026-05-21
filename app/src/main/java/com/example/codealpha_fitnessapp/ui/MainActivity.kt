package com.example.codealpha_fitnessapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codealpha_fitnessapp.R
import com.example.codealpha_fitnessapp.data.Workout
import com.example.codealpha_fitnessapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WorkoutViewModel
    private lateinit var adapter: WorkoutAdapter

    private val today get() = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[WorkoutViewModel::class.java]

        binding.tvDay.text = SimpleDateFormat("EEEE", Locale.getDefault()).format(Date())
        binding.tvDate.text = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())

        adapter = WorkoutAdapter { confirmDelete(it) }
        binding.rvWorkouts.layoutManager = LinearLayoutManager(this)
        binding.rvWorkouts.adapter = adapter

        viewModel.allWorkouts.observe(this) {
            adapter.submitList(it)
            binding.layoutEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
            binding.rvWorkouts.visibility  = if (it.isEmpty()) View.GONE  else View.VISIBLE
        }

        viewModel.getCaloriesForDate(today).observe(this) {
            binding.tvTodayCalories.text = "${it ?: 0} kcal"
        }
        viewModel.getDurationForDate(today).observe(this) {
            binding.tvTodayDuration.text = "${it ?: 0} min"
        }
        viewModel.totalCount.observe(this) {
            binding.tvTotalWorkouts.text = "$it"
        }
        viewModel.totalCalories.observe(this) {
            binding.tvTotalCalories.text = "${it ?: 0} kcal"
        }

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddWorkoutActivity::class.java))
        }
    }

    private fun confirmDelete(workout: Workout) {
        AlertDialog.Builder(this)
            .setTitle("Delete Workout")
            .setMessage("Delete \"${workout.exerciseType}\"?")
            .setPositiveButton("Delete") { _, _ ->
                viewModel.delete(workout)
                Snackbar.make(binding.root, "Deleted", Snackbar.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}