package com.example.taipeitourimport

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.taipeitour.TaipeiTourListModel
import com.example.taipeitour.databinding.ListItemBinding
import javax.sql.DataSource

class TaipeiTourListAdapter(private val customListeners: CustomListeners) :
    RecyclerView.Adapter<TaipeiTourListAdapter.TaipeiTourListViewHolder>() {
    private val diffUtilItemCallback = object : DiffUtil.ItemCallback<TaipeiTourListModel>() {
        //pk is the primary key for the data class.
        //replace with any unique identifier of your specific data class.
        override fun areItemsTheSame(
            oldItem: TaipeiTourListModel,
            newItem: TaipeiTourListModel
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: TaipeiTourListModel,
            newItem: TaipeiTourListModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this, diffUtilItemCallback)

    private lateinit var binding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaipeiTourListViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaipeiTourListViewHolder(binding, customListeners)
    }

    override fun onBindViewHolder(holder: TaipeiTourListViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position])
        getItemId(position)?.run {

        }
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun submitList(list: List<TaipeiTourListModel>) {
        listDiffer.submitList(list)
    }

    class TaipeiTourListViewHolder
    constructor(
        private val binding: ListItemBinding,
        private val customListeners: CustomListeners
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TaipeiTourListModel) {
            //Custom onClick for whole item onClick
            binding.root.setOnClickListener {
                //Pass respective parameter, adapterPosition or pk.
                customListeners.onItemSelected(item.id)
            }

            //TODO : Bind your data to views here.
            //Use CustomListeners respective function for respective view’s listeners.
        }
    }
    // Interface to be inherited by view to provide
    //custom listeners for each item based on position
    //or other custom parameters (ex : Primary key)

    interface CustomListeners {
        fun onItemSelected(position: Int)
        // add your view listeners here
        // ex : fun onSwitchChecked(..) , fun onItemLongPress(..)
    }
}
