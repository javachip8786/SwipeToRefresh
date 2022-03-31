package com.example.swipetorefresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.swipetorefresh.R

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var start = 0
    private var end = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val item = fetchData()
        val adapter = RecyclerAdapter(item)
        recyclerView.adapter = adapter

        val swipe: SwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipe.setOnRefreshListener {
            item.addAll(updateData())
            adapter.notifyDataSetChanged()
            swipe.isRefreshing = false
        }

    }

    private fun fetchData(): ArrayList<String> {
        val list = ArrayList<String>()
        for(i in start until end){
            list.add("Item $i")
        }
        start = end
        end = end+1
        return list;
    }

    fun updateData(): ArrayList<String>{
        val list = ArrayList<String>()
        for(i in start until end){
            list.add("Item $i")
        }
        start = end
        end = end+1
        return list;
    }

}