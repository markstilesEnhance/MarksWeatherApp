package com.example.marksweatherapp.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marksweatherapp.R
import com.example.marksweatherapp.model.network.TempData.detailTemp
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var adapter: DetailListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detail_recycler.layoutManager = LinearLayoutManager(this)
        adapter =
            DetailListAdapter(detailTemp)
        detail_recycler.adapter = adapter
    }
}
