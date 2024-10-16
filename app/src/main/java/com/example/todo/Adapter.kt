package com.example.todo

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ViewBinding // Import ViewBinding class generated for your layout file

class Adapter(private val data: List<CardInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val priority = binding.priority
        val layout = binding.mylayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]
        when (currentItem.priority.toLowerCase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#7b7b78"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#949491"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#acacaa"))
        }

        holder.title.text = currentItem.title
        holder.priority.text = currentItem.priority
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateCard::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
