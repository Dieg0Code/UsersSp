package com.dieg0code.android.userssp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dieg0code.android.userssp.databinding.ItemUserBinding

// Clase UserAdapter recibe un listado de usuarios
class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context

    // infla la vista del xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)

        with(holder) {
            binding.tvOrder.text = user.id.toString()
            binding.tvName.text = user.name
        }
    }

    override fun getItemCount(): Int = users.size

    //Vinculamos nuestra vista con ViewHolder
    //habilitamos viewBinding en build.gradle(Module)
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemUserBinding.bind(view)
    }
}