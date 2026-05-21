package com.example.codealpha_fitnessapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val exerciseType: String,
    val durationMinutes: Int,
    val calories: Int,
    val date: String,
    val notes: String = "",
    val timestamp: Long = System.currentTimeMillis()
)