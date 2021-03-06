package com.example.app.presentation.ui.github.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.presentation.di.scopes.PerActivity
import com.example.app.presentation.ui.github.ankocomponents.FollowerItemUI
import com.example.app.presentation.ui.github.model.Follower
import com.example.app.presentation.utils.imageloader.ImageLoader
import com.facebook.drawee.view.SimpleDraweeView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import javax.inject.Inject

@PerActivity
class FollowersAdapter
@Inject
constructor(private val imageLoader: ImageLoader) :
        RecyclerView.Adapter<FollowersAdapter.ViewHolder>() {

    var list: List<Follower> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(FollowerItemUI().createView(AnkoContext.create(parent!!.context, parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(list[position], imageLoader)

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.find(FollowerItemUI.ID_LOGIN_NAME)
        val avatarImage: SimpleDraweeView = itemView.find(FollowerItemUI.ID_AVATAR_IMAGE)

        fun bind(follower: Follower, imageLoader: ImageLoader) {
            with(follower) {
                name.text = login
                avatar_url?.let {
                    imageLoader.loadImage(it, avatarImage)
                }
            }
        }
    }
}