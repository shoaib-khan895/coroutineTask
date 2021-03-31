package com.example.Coroutine

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Coroutine.adapter.PostDetailsAdapter
import com.example.Coroutine.model.DataModel
import com.example.Coroutine.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import retrofit2.Response

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<DataModel>()
    private lateinit var postDetailsAdapter: PostDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        getData()

    }

    private fun setupUI() {
        createProgressDialog()
        progressDialog.show()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        post_details_RV.layoutManager = linearLayoutManager

        postDetailsAdapter = PostDetailsAdapter(dataList)
        post_details_RV.adapter = postDetailsAdapter
    }
    private fun getData() {
        lifecycleScope.launch {
            val call = ApiClient.getClient.getPost()
            call.enqueue(object : retrofit2.Callback<List<DataModel>> {
                override fun onFailure(call: retrofit2.Call<List<DataModel>>, t: Throwable) {
                    Log.i("MainActivity", "Error is ${t.localizedMessage}")
                    Toast.makeText(this@MainActivity, "There is some error while getting data", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }

                override fun onResponse(
                    call: retrofit2.Call<List<DataModel>>,
                    response: Response<List<DataModel>>
                ) {
                    progressDialog.dismiss()
                    Log.i("MainActivity", "Data is ${response.body()}")
                    dataList.addAll(response.body()?: ArrayList())
                    post_details_RV.adapter!!.notifyDataSetChanged()
                }
            })
        }
    }


    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait")
        progressDialog.setCancelable(false)
    }
}