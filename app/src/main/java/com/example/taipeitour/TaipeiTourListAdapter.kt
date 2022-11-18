package com.example.taipeitourimport

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.taipeitour.MainActivity
import com.example.taipeitour.R
import com.example.taipeitour.TaipeiTourListFragment
import com.example.taipeitour.TaipeiTourListModel1
import com.example.taipeitour.databinding.ListItemBinding
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.model.ImagesItem
import com.example.taipeitour.model.TaipeiTourModel

class TaipeiTourListAdapter(private val customListeners: CustomListeners) : RecyclerView.Adapter<TaipeiTourListAdapter.TaipeiTourListViewHolder>() {
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
            return oldItem == newItem
        }
    }
    private val listDiffer = AsyncListDiffer(this, diffUtilItemCallback)


    private lateinit var binding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaipeiTourListAdapter.TaipeiTourListViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        mContext = parent.context
        return TaipeiTourListViewHolder(customListeners)

    }

    override fun onBindViewHolder(holder: TaipeiTourListViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun submitList(list: List<DataItem>) {
        listDiffer.submitList(list)
    }

    inner class TaipeiTourListViewHolder(private val customListeners: CustomListeners) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DataItem) {
            //Custom onClick for whole item onClick
            binding.root.setOnClickListener {
                //Pass respective parameter, adapterPosition or pk.
                customListeners.onItemSelected(item)
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
    // Interface to be inherited by view to provide
    //custom listeners for each item based on position
    //or other custom parameters (ex : Primary key)

    interface CustomListeners {
        fun onItemSelected(item: DataItem)
        // add your view listeners here
        // ex : fun onSwitchChecked(..) , fun onItemLongPress(..)
    }
}
