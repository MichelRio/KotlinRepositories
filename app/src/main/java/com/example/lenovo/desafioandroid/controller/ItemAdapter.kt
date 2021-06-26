package com.example.lenovo.desafioandroid.controller

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lenovo.desafioandroid.R
import com.example.lenovo.desafioandroid.model.ItemResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_user.view.*

class ItemAdapter(val content: ItemResponse) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_user, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return content.items.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, position: Int) {
        val list = content.items.get(position)
        val customViewHolder = p0 as CustomViewHolder

        customViewHolder.view.name.text = list.owner.login
        customViewHolder.view.fullname.text = list.full_name

        customViewHolder.view.repname.text = list.full_name
        customViewHolder.view.repdesc.text = list.description
        customViewHolder.view.tvForks.text = list.forks_count.toString()
        customViewHolder.view.tvStars.text = list.stargazers_count.toString()

        Picasso.get()
                .load(list.owner.avatar_url)
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(customViewHolder.view.cover)
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
}
