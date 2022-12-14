package com.example.taipeitour

import android.util.Log
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.model.TaipeiTourModel
import com.example.taipeitour.network.ApiInterface
import com.example.taipeitour.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaipeiTourListPresenter(private val view: TaipeiTourListContract.View): TaipeiTourListContract.Presenter {

//    override fun loadData(): MutableList<TaipeiTourListModel1> {
//        val nameList: MutableList<TaipeiTourListModel1> = mutableListOf()
//        nameList.add(TaipeiTourListModel1(1, "title1", "desc1"))
//        nameList.add(TaipeiTourListModel1(50, "title2", "desc2"))
//        nameList.add(TaipeiTourListModel1(3, "title3", "desc3"))
//        nameList.add(TaipeiTourListModel1(43, "title4", "desc4"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//        nameList.add(TaipeiTourListModel1(500, "title5", "desc5"))
//
//        return nameList
//    }

    override fun getData(lang: String, page: Int) {
        RetrofitClient.instance.getAttractions(lang = lang, page = page).enqueue(object : Callback<TaipeiTourModel> {
            override fun onResponse(
                call: Call<TaipeiTourModel>,
                response: Response<TaipeiTourModel>
            ) {
                Log.e("Response", response.body()?.data.toString())
                response.body()?.data?.let { view.bindData(it as ArrayList<DataItem>) }
            }

            override fun onFailure(call: Call<TaipeiTourModel>, t: Throwable) {
                Log.e("Response", t.message.toString())
            }

        })
    }

}
