package com.example.codealpha_fitnessapp.utils

object ExerciseTypes {
    val list = listOf(
        "🏃 Running", "🚴 Cycling", "🏊 Swimming",
        "🏋️ Weight Training", "🧘 Yoga", "🥊 Boxing",
        "⚽ Football", "🏀 Basketball", "🚶 Walking",
        "💃 Dancing", "🪂 HIIT", "🎾 Tennis"
    )

    fun caloriesPerMin(type: String): Int = when {
        type.contains("Running")  -> 10
        type.contains("Cycling")  -> 8
        type.contains("Swimming") -> 9
        type.contains("Weight")   -> 6
        type.contains("Yoga")     -> 4
        type.contains("Boxing")   -> 11
        type.contains("Walking")  -> 4
        type.contains("HIIT")     -> 12
        else -> 6
    }
}