package com.example.contactlistsmeetp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import org.w3c.dom.Text

class PersonAdapter (options: FirebaseRecyclerOptions<Person>) : FirebaseRecyclerAdapter<Person, PersonAdapter.MyViewHolder>(options){

    class MyViewHolder (inflater: LayoutInflater,parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout,parent,false)){
        val txtName: TextView = itemView.findViewById(R.id.txtName);
        val txtRole: TextView = itemView.findViewById(R.id.txtRole);
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        return MyViewHolder(inflater,parent);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Person) {
        holder.txtName.text = model.name;
        holder.txtRole.text = model.role;

        val storage: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.photo)
        Glide.with(holder.imgPhoto.context)
             .load(storage)
             .into(holder.imgPhoto)
    }
}