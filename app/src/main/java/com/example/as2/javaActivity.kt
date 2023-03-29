package com.example.as2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.as2.Adapter.javaAdapter
import com.example.as2.Adapter.studyAdapter
import com.example.as2.databinding.ActivityStudyBinding
import com.example.as2.model.information

class javaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStudyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = ArrayList<information>()
        data.add(information(1, "Est placidus saga, cesaris.", "nahlllaa"))
        data.add(information(2, "Cacula, nixus, et saga.", "nahlllaa"))
        data.add(information(3, "Est nobilis fortis, cesaris.", "nahlllaa"))
        data.add(information(4, "Est placidus saga, cesaris.", "nahlllaa"))



        binding.rvstudy.layoutManager = LinearLayoutManager(this)
        val javaAdapter = javaAdapter(this, data)
        binding.rvstudy.adapter = javaAdapter

    }
}