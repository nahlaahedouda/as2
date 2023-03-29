package com.example.as2.Adapter

import android.app.Activity
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.as2.databinding.ActivityStudyBinding
import com.example.as2.databinding.StudynoteBinding
import com.example.as2.model.information

class studyAdapter (var activity: Activity, private var data: ArrayList<information>) :
    RecyclerView.Adapter<studyAdapter.MyViewHolder>() {
    class MyViewHolder(var binding:StudynoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = StudynoteBinding.inflate(activity.layoutInflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvId.text = data[position].id.toString()
        holder.binding.tvName.text = data[position].name
        holder.binding.tvdetails.text = data[position].details

        holder.binding.root.setOnClickListener {
            Toast.makeText(activity,data[position].name,Toast.LENGTH_SHORT).show()
        }
    }

}