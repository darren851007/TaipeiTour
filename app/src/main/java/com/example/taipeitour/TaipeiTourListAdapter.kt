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
    private val dataList =
        AsyncListDiffer<DataItem>(this, object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.equals(newItem)
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



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaipeiTourListViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaipeiTourListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TaipeiTourListViewHolder, position: Int) {
        val item = dataList.currentList[position]
        holder.bind(item as DataItem)
    }

    override fun getItemCount(): Int {
        return dataList.currentList.size
    }

    fun submitList(list: ArrayList<DataItem>) {
        Log.e("List", list.size.toString())
        //https://juejin.cn/post/7054930375675478023
        //toList()問題
        dataList.submitList(list.toList())
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
                val image = if (!item.images.isNullOrEmpty()) {
                    item.images[0].src
                } else {
                    R.mipmap.ic_no_image_icon_round
                }
                Glide.with(ivPicture.context)
                    .load(image)
                    .into(ivPicture)
                Log.i("API", item.images.toString())
            }
        }
    }

    interface CustomListeners {
        fun onItemSelected(item: DataItem)
    }
}
