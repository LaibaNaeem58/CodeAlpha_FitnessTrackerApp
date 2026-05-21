package com.example.codealpha_fitnessapp.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.codealpha_fitnessapp.data.Workout
import com.example.codealpha_fitnessapp.databinding.ActivityAddWorkoutBinding
import com.example.codealpha_fitnessapp.utils.ExerciseTypes
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddWorkoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddWorkoutBinding
    private lateinit var viewModel: WorkoutViewModel
    private var selectedExercise = ExerciseTypes.list[0]
    private var autoCalories = 0
    private var manualEdit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[WorkoutViewModel::class.java]

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ExerciseTypes.list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerExercise.adapter = adapter

        binding.spinnerExercise.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: android.widget.AdapterView<*>, v: android.view.View?, pos: Int, id: Long) {
                selectedExercise = ExerciseTypes.list[pos]
                recalc()
            }
            override fun onNothingSelected(p: android.widget.AdapterView<*>) {}
        }

        binding.etDuration.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: android.text.Editable?) { if (!manualEdit) recalc() }
        })

        binding.etCalories.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) { manualEdit = true }
            override fun afterTextChanged(s: android.text.Editable?) {}
        })

        binding.ivBack.setOnClickListener { finish() }
        binding.btnSave.setOnClickListener { save() }
        binding.btnCancel.setOnClickListener { finish() }
    }

    private fun recalc() {
        val dur = binding.etDuration.text.toString().toIntOrNull() ?: 0
        autoCalories = dur * ExerciseTypes.caloriesPerMin(selectedExercise)
        if (!manualEdit) binding.etCalories.setText(if (autoCalories > 0) "$autoCalories" else "")
    }

    private fun save() {
        val durStr = binding.etDuration.text.toString().trim()
        if (durStr.isEmpty()) { binding.tilDuration.error = "Enter duration"; return }
        val dur = durStr.toIntOrNull()
        if (dur == null || dur <= 0) { binding.tilDuration.error = "Invalid duration"; return }
        binding.tilDuration.error = null

        val cal = binding.etCalories.text.toString().toIntOrNull() ?: autoCalories
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        viewModel.insert(Workout(
            exerciseType = selectedExercise,
            durationMinutes = dur,
            calories = cal,
            date = today,
            notes = binding.etNotes.text.toString().trim()
        ))
        Snackbar.make(binding.root, "Workout saved! 💪", Snackbar.LENGTH_SHORT).show()
        finish()
    }
}