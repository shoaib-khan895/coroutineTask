package com.example.Coroutine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Coroutine.R
import com.example.Coroutine.model.DataModel

class PostDetailsAdapter(private val dataSet: List<DataModel>) :
    RecyclerView.Adapter<PostDetailsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitleTextView: TextView = view.findViewById(R.id.postTitle_TV)
        val postBodyTextView: TextView = view.findViewById(R.id.post_Msg_TV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_details, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitleTextView.text = dataSet[position].postTitle
        holder.postBodyTextView.text = dataSet[position].postBody
    }
}