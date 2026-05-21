package com.example.codealpha_fitnessapp.data

import androidx.lifecycle.LiveData

class WorkoutRepository(private val dao: WorkoutDao) {
    val allWorkouts: LiveData<List<Workout>> = dao.getAllWorkouts()
    val totalCalories: LiveData<Int?> = dao.getTotalCalories()
    val totalCount: LiveData<Int> = dao.getTotalCount()

    fun getCaloriesForDate(date: String) = dao.getCaloriesForDate(date)
    fun getDurationForDate(date: String) = dao.getDurationForDate(date)

    suspend fun insert(workout: Workout) = dao.insert(workout)
    suspend fun delete(workout: Workout) = dao.delete(workout)
}