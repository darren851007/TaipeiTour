package com.example.taipeitour

import com.example.taipeitour.model.DataItem
import com.example.taipeitour.model.TaipeiTourModel

interface TaipeiTourListContract {
    interface View {
        fun bindData(response: ArrayList<DataItem>)
    }

    interface Presenter {
        fun getData(lang: String, page: Int)
        fun getData2(lang: String, page: Int)
    }
}