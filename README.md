🏋️ CodeAlpha Fitness Tracker App
Task 03 — Android Internship Project
📌 Internship Program

CodeAlpha Android Development Internship

📱 Project Type

Android Application

💻 Language

Kotlin

🗄️ Database

Room (SQLite)

🏗️ Architecture

MVVM (Model - View - ViewModel)

🧰 IDE

Android Studio 2025.1.3

📊 SDK Info
Min SDK: 24
Target SDK: 36
📖 Project Description

The Fitness Tracker App allows users to log daily workouts including exercise type, duration, calories, and notes.

It also provides a dashboard that shows daily and total workout statistics such as calories burned, workout duration, and total workouts.

✨ Features
🧠 Core Features
Add workout entry
Select exercise type
Enter duration (minutes)
Track calories burned
View workout history
Delete workout entry
📊 Dashboard Features
Today’s calories burned
Today’s workout duration
Total workouts count
Total calories burned
⚡ Extra Features
Auto calorie calculation based on exercise type
Add personal notes for each workout
Category-based exercise system
Live updates using LiveData
🏃 Supported Exercises
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
📁 Project Structure
CodeAlpha_FitnessTrackerApp/
│
├── data/
│   ├── Workout.kt
│   ├── WorkoutDao.kt
│   ├── WorkoutDatabase.kt
│   └── WorkoutRepository.kt
│
├── ui/
│   ├── MainActivity.kt
│   ├── AddWorkoutActivity.kt
│   ├── SplashActivity.kt
│   ├── WorkoutAdapter.kt
│   └── WorkoutViewModel.kt
│
├── utils/
│   └── ExerciseTypes.kt
│
├── res/
│   ├── layout/
│   ├── drawable/
│   ├── anim/
│   └── values/
│
└── AndroidManifest.xml
🔁 App Flow
Splash Screen
      ↓
Dashboard Screen
      ↓
Add Workout Screen
      ↓
Workout History Update
🛠️ Tech Stack
Kotlin
XML Layouts
Room Database
MVVM Architecture
LiveData
RecyclerView
Coroutines
Material Design Components
💾 Database Info (Room)

Room database stores workout data in internal device storage:

/data/data/<package_name>/databases/workout_database
✔ Features:
Offline storage
Persistent data
Secure (private app storage)
❌ Note:

Data is deleted when app is uninstalled.

⚙️ Setup Instructions
Step 1

Open project in Android Studio

Step 2

Sync Gradle files:

File → Sync Project with Gradle Files
Step 3

Run app on emulator or device

📌 Project Summary

A complete Fitness Tracker Android Application built with Kotlin, Room Database, and MVVM architecture. It provides real-time workout tracking with a modern dashboard and persistent local storage.
