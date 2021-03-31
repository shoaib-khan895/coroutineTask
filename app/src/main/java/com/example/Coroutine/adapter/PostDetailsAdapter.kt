package com.example.Coroutine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Coroutine.R
import com.example.Coroutine.model.DataModel

class PostDetailsAdapter(private val context: Context, private val dataSet: List<DataModel>) :
    RecyclerView.Adapter<PostDetailsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitleTextView: TextView = view.findViewById(R.id.postTitle_TV)
        val postBodyTextView: TextView = view.findViewById(R.id.post_Msg_TV)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostDetailsAdapter.ViewHolder {

        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_details, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: PostDetailsAdapter.ViewHolder, position: Int) {
        holder.postTitleTextView.text = dataSet[position].postTitle
        holder.postBodyTextView.text = dataSet[position].postBody
    }
}