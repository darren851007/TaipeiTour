package com.example.taipeitour

import com.example.taipeitour.model.DataItem
import com.example.taipeitour.model.TaipeiTourModel

interface TaipeiTourListContract {
    interface View {
        fun bindData(response: List<DataItem>)
    }

    interface Presenter {
        fun loadData(): List<TaipeiTourListModel1>
        fun getData(lang:String)
    }
}