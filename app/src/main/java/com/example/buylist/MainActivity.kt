package com.example.buylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val gridView = findViewById<GridView>(R.id.GridView)
        val listView = findViewById<ListView>(R.id.Listview)

        val count = ArrayList<String>()
        val item = ArrayList<Item>()
        val priceRange = IntRange(10, 100)

        val array = resources.obtainTypedArray(R.array.image_list)

        for (i in 0 until array.length()) {
            val photo = array.getResourceId(i, 0)
            val name = "水果${i + 1}"
            val price = priceRange.random()
            count.add("${i + 1}個")
            item.add(Item(photo, name, price))
        }
        array.recycle()

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, count)

        gridView.adapter = MyAdapter(this, R.layout.adapter_vertical, item)
        gridView.numColumns=3

        listView.adapter = MyAdapter(this, R.layout.adapter_horizontal, item)
    }
}

data class Item(
    val photo: Int,
    val name: String,
    val price: Int
)
