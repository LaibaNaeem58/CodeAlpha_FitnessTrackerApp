# CodeAlpha Fitness Tracker App

## Task 03 — Android Internship Project

---

## 📌 Internship Program
CodeAlpha Android Development Internship

## 📱 Project Type
Android Application

## 💻 Language
Kotlin

## 🗄️ Database
Room (SQLite)

## 🏗️ Architecture
MVVM (Model - View - ViewModel)

## 🧰 IDE
Android Studio 2025.1.3

## 📊 SDK Info
Min SDK: 24  
Target SDK: 36  

---

## 📖 Project Description

Fitness Tracker App allows users to log daily workouts including exercise type, duration, calories, and notes.

It also shows a dashboard with daily and total workout statistics.

---

## ✨ Features

### Core Features
- Add workout entry  
- Select exercise type  
- Enter duration  
- Track calories  
- View workout history  
- Delete workout  

### Dashboard Features
- Today’s calories burned  
- Today’s duration  
- Total workouts  
- Total calories burned  

### Extra Features
- Auto calorie calculation  
- Notes for workouts  
- Live updates using LiveData  

---

## 🏃 Supported Exercises

- Running  
- Cycling  
- Swimming  
- Weight Training  
- Yoga  
- Boxing  
- Walking  
- HIIT  
- Dancing  
- Football  
- Basketball  
- Tennis  

---

## 📁 Project Structure

CodeAlpha_FitnessTrackerApp/

- data/
  - Workout.kt
  - WorkoutDao.kt
  - WorkoutDatabase.kt
  - WorkoutRepository.kt

- ui/
  - MainActivity.kt
  - AddWorkoutActivity.kt
  - SplashActivity.kt
  - WorkoutAdapter.kt
  - WorkoutViewModel.kt

- utils/
  - ExerciseTypes.kt

- res/
  - layout/
  - drawable/
  - anim/
  - values/

- AndroidManifest.xml

---

## 🔁 App Flow

Splash Screen  
↓  
Dashboard Screen  
↓  
Add Workout Screen  
↓  
Workout History Update  

---

## 🛠️ Tech Stack

- Kotlin  
- XML Layouts  
- Room Database  
- MVVM Architecture  
- LiveData  
- RecyclerView  
- Coroutines  

---

## 💾 Database Info

Room database stored in:

/data/data/<package_name>/databases/workout_database

✔ Offline storage  
✔ Persistent data  
❌ Deleted on uninstall  

---

## ⚙️ Setup Instructions

1. Open project in Android Studio  
2. Sync Gradle  
3. Run on emulator or device  

---

## 📌 Project Summary

A complete Fitness Tracker Android App using Kotlin, Room, and MVVM with real-time dashboard analytics.
