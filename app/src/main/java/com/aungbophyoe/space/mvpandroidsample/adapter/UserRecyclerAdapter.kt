package com.aungbophyoe.space.mvpandroidsample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aungbophyoe.space.mvpandroidsample.R
import com.aungbophyoe.space.mvpandroidsample.model.User

class UserRecyclerAdapter(private val context: Context):
    ListAdapter<User, UserRecyclerAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.phone == newItem.phone
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return  oldItem == newItem
        }

    }
) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return currentList.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val tvPhone = view.findViewById<TextView>(R.id.tvPhone)
        val tvWebsite = view.findViewById<TextView>(R.id.tvWebsite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = inflater.inflate(R.layout.rv_user_item, parent, false)
        val viewHolder=ViewHolder(inflateView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            currentList[position]?.let { user ->
                holder.tvName.text = user.name
                holder.tvEmail.text = user.email
                holder.tvPhone.text = user.phone
                holder.tvWebsite.text = user.website
            }
        }catch (e:Exception){
            Log.d("rv_error","${e.message}")
        }
    }
}