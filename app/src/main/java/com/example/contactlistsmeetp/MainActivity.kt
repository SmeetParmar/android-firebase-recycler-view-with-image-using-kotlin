package com.example.contactlistsmeetp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private var adapter: PersonAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val query = FirebaseDatabase.getInstance().reference.child("people");
        val option = FirebaseRecyclerOptions.Builder<Person>().setQuery(query, Person::class.java).build()
        adapter = PersonAdapter(option);

        val rView : RecyclerView = findViewById(R.id.rView);
        rView.layoutManager = LinearLayoutManager(this);
        rView.adapter = adapter;
    }

    override fun onStart() {
        super.onStart();
        adapter?.startListening();

    }
}