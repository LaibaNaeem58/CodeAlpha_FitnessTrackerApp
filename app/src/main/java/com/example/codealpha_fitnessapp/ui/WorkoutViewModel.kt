package com.example.codealpha_fitnessapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.codealpha_fitnessapp.data.Workout
import com.example.codealpha_fitnessapp.data.WorkoutDatabase
import com.example.codealpha_fitnessapp.data.WorkoutRepository
import kotlinx.coroutines.launch

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WorkoutRepository
    val allWorkouts: LiveData<List<Workout>>
    val totalCalories: LiveData<Int?>
    val totalCount: LiveData<Int>

    init {
        val dao = WorkoutDatabase.getDatabase(application).workoutDao()
        repository = WorkoutRepository(dao)
        allWorkouts = repository.allWorkouts
        totalCalories = repository.totalCalories
        totalCount = repository.totalCount
    }

    fun getCaloriesForDate(date: String) = repository.getCaloriesForDate(date)
    fun getDurationForDate(date: String) = repository.getDurationForDate(date)
    fun insert(w: Workout) = viewModelScope.launch { repository.insert(w) }
    fun delete(w: Workout) = viewModelScope.launch { repository.delete(w) }
}