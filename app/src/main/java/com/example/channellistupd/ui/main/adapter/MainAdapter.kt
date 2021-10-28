package com.example.channellistupd.ui.main.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.channellistupd.R
import com.example.channellistupd.data.model.Channel
import com.example.channellistupd.data.model.Playlist
import com.example.channellistupd.databinding.ChannelCardBinding
import com.example.channellistupd.ui.main.adapter.MainAdapter.DataViewHolder

class MainAdapter(private val playlist: Playlist) : RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(channel: Channel) {
            val card = ChannelCardBinding.bind(itemView)
            itemView.apply {
                card.channelName.text = channel.name_ru
                card.channelTitle.text = channel.current?.title
                Glide.with(card.channelImage.context)
                    .load(channel.image)
                    .apply(RequestOptions().transform(RoundedCorners(10)))
                    .into(card.channelImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.channel_card, parent, false)
        )


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(playlist.channels[position])
    }

    override fun getItemCount(): Int = playlist.channels.size

    fun addChannels(playlist: Playlist) {
        this.playlist.channels.apply {
            clear()
            addAll(playlist.channels)
        }
    }

}