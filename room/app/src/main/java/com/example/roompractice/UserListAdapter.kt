package com.example.roompractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roompractice.databinding.ItemUserListBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewholder>() {
    val followerList = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewholder {
        val binding =
            ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewholder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewholder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

    class UserListViewholder(
        private val binding: ItemUserListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: User) {
            binding.tvName.text = data.name
            binding.tvEmail.text = data.email
        }
    }
}