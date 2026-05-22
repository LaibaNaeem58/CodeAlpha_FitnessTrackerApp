CodeAlpha Fitness Tracker App
Task 03 — Android Internship Project

Internship Program: CodeAlpha
Project Type: Android Application
Language: Kotlin
Database: Room (SQLite)
Architecture: MVVM
IDE: Android Studio 2025.1.3
Min SDK: 24
Target SDK: 36

Project Description

The Fitness Tracker App allows users to log daily workouts including exercise type, duration, calories, and notes. It shows a dashboard with daily and total workout statistics.

Features
Core Features
Add workout entry
Exercise type selection
Duration input
Calories tracking
Workout history list
Delete workout
Dashboard Features
Today’s calories
Today’s duration
Total workouts
Total calories burned
Extra Features
Auto calorie calculation
Notes for workouts
Category-based exercise system
Live updates using LiveData
Supported Exercises
Running
Cycling
Swimming
Weight Training
Yoga
Boxing
Walking
HIIT
Dancing
Football
Basketball
Tennis
Project Structure

CodeAlpha_FitnessTrackerApp/
│
├── data/
│ ├── Workout.kt
│ ├── WorkoutDao.kt
│ ├── WorkoutDatabase.kt
│ └── WorkoutRepository.kt
│
├── ui/
│ ├── MainActivity.kt
│ ├── AddWorkoutActivity.kt
│ ├── SplashActivity.kt
│ ├── WorkoutAdapter.kt
│ └── WorkoutViewModel.kt
│
├── utils/
│ └── ExerciseTypes.kt
│
├── res/
│ ├── layout/
│ ├── drawable/
│ ├── anim/
│ └── values/
│
└── AndroidManifest.xml

App Flow

Splash Screen
↓
Dashboard Screen
↓
Add Workout Screen
↓
Workout History Update

Tech Stack
Kotlin
XML Layouts
Room Database
MVVM Architecture
LiveData
RecyclerView
Coroutines
Database Info

Room database stores workout data in internal device storage:

/data/data/<package_name>/databases/workout_database

Setup Instructions

Step 1: Open project in Android Studio
Step 2: Sync Gradle files
Step 3: Run on emulator or device

Project Summary

A complete fitness tracking application with dashboard analytics and persistent workout storage using Room database.
