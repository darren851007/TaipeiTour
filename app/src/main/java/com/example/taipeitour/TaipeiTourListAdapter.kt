package com.example.taipeitourimport

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.taipeitour.R
import com.example.taipeitour.databinding.ListItemBinding
import com.example.taipeitour.model.DataItem

class TaipeiTourListAdapter(
    private val listener: CustomListeners
    ) : RecyclerView.Adapter<TaipeiTourListAdapter.TaipeiTourListViewHolder>() {
    private val dataList = AsyncListDiffer<Any>(this, object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return if (oldItem == newItem && oldItem is DataItem) {
                try {
                    return oldItem.hashCode() == (newItem as DataItem).hashCode()
                } catch (e: Exception) {
                    return false
                }
            } else {
                false
            }
        }

    })
    companion object {
        private const val VIEW_TYPE_LOADING = 0
        private const val VIEW_TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            dataList.currentList.get(position) == null -> VIEW_TYPE_LOADING
            else -> VIEW_TYPE_ITEM
        }
    }
    private lateinit var mContext: Context
    private val diffUtilItemCallback = object : DiffUtil.ItemCallback<DataItem>() {
        //pk is the primary key for the data class.
        //replace with any unique identifier of your specific data class.
        override fun areItemsTheSame(
            oldItem: DataItem,
            newItem: DataItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataItem,
            newItem: DataItem
        ): Boolean {
            return when {
                oldItem.id != newItem.id -> {
                    false
                }
                oldItem.name != newItem.name -> {
                    false
                }
                oldItem.introduction != newItem.introduction -> {
                    false
                }
                else -> {
                    true
                }
            }
//            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaipeiTourListViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        mContext = parent.context
        return TaipeiTourListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TaipeiTourListViewHolder, position: Int) {
        val item = dataList.currentList[position]
        holder.bind(item as DataItem)
    }

    override fun getItemCount(): Int {
        return dataList.currentList.size
    }

    fun submitList(list: List<DataItem>) {
        dataList.submitList(list)
    }

    inner class TaipeiTourListViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DataItem) {
            //Custom onClick for whole item onClick
            binding.root.setOnClickListener {
                //Pass respective parameter, adapterPosition or pk.
                listener.onItemSelected(item)
            }

            //TODO : Bind your data to views here.
            //Use CustomListeners respective function for respective view’s listeners.
            binding.apply {
                tvTitle.text = item.name
                tvContent.text = item.introduction
                if (!item.images.isNullOrEmpty()) {
                    Glide.with(mContext)
                        .load(item.images[0].src)
                        .into(ivPicture)
                } else {
                    Glide.with(mContext)
                        .load(R.mipmap.ic_no_image_icon_round)
                        .into(ivPicture)
                }


                Log.i("API", item.images.toString())
            }
        }
    }

    interface CustomListeners {
        fun onItemSelected(item: DataItem)
    }
}
