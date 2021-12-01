package com.github.kolya.listapp.ui.users

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.kolya.listapp.models.UserDataUI

class DiffUserDataUICallback : DiffUtil.ItemCallback<UserDataUI>() {
    override fun areItemsTheSame(oldItem: UserDataUI, newItem: UserDataUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserDataUI, newItem: UserDataUI): Boolean {
        return oldItem == newItem
    }
}

class UserListAdapter constructor(
) : ListAdapter<UserDataUI, UserListAdapter.UserViewHolder>(DiffUserDataUICallback()) {

    lateinit var onItemClickListener : OnUserItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(UserView(parent.context))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindView(item, onItemClickListener)
    }

    class UserViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(item: UserDataUI, listener: (UserDataUI) -> Unit) {
            val view = itemView as UserView
            view.bindView(item)
            view.setOnClickListener {
                listener(item)
            }
        }
    }
}

typealias OnUserItemClickListener = (UserDataUI)->Unit
