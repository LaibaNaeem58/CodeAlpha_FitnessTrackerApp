package com.example.codealpha_fitnessapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workouts ORDER BY timestamp DESC")
    fun getAllWorkouts(): LiveData<List<Workout>>

    @Query("SELECT SUM(calories) FROM workouts WHERE date = :date")
    fun getCaloriesForDate(date: String): LiveData<Int?>

    @Query("SELECT SUM(durationMinutes) FROM workouts WHERE date = :date")
    fun getDurationForDate(date: String): LiveData<Int?>

    @Query("SELECT COUNT(*) FROM workouts")
    fun getTotalCount(): LiveData<Int>

    @Query("SELECT SUM(calories) FROM workouts")
    fun getTotalCalories(): LiveData<Int?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workout: Workout)

    @Delete
    suspend fun delete(workout: Workout)
}