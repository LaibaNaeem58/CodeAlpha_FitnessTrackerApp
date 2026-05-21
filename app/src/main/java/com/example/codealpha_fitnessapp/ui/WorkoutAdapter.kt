package com.example.codealpha_fitnessapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.codealpha_fitnessapp.data.Workout
import com.example.codealpha_fitnessapp.databinding.ItemWorkoutBinding
import java.text.SimpleDateFormat
import java.util.Locale

class WorkoutAdapter(private val onDelete: (Workout) -> Unit) :
    ListAdapter<Workout, WorkoutAdapter.VH>(Diff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(h: VH, pos: Int) = h.bind(getItem(pos))

    inner class VH(private val b: ItemWorkoutBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(w: Workout) {
            b.tvExercise.text  = w.exerciseType
            b.tvDuration.text  = "${w.durationMinutes} min"
            b.tvCalories.text  = "${w.calories} kcal"
            b.tvNotes.text     = w.notes.ifEmpty { "No notes" }
            b.tvDate.text      = try {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(sdf.parse(w.date)!!)
            } catch (e: Exception) { w.date }
            b.btnDelete.setOnClickListener { onDelete(w) }
        }
    }

    class Diff : DiffUtil.ItemCallback<Workout>() {
        override fun areItemsTheSame(o: Workout, n: Workout) = o.id == n.id
        override fun areContentsTheSame(o: Workout, n: Workout) = o == n
    }
}