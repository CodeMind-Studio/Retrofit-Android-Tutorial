package com.dev.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dev.firstapp.data.PostRequestModel
import com.dev.firstapp.data.PostResponseModel
import com.dev.firstapp.network.DataApiImp
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.concurrent.Flow

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView1)


//     1.    Using LiveData


//        val responseLiveData: LiveData<Response<PostResponseModel>> = liveData {
//            val response: Response<PostResponseModel> =
//                DataApiImp().getDataApi().postData(PostRequestModel(10, "Gaming", "Dev"))
//            emit(response)
//        }

//        responseLiveData.observe(this) {
//            textView.text = it.body()!!.data.response
//        }






//   2.     Without LiveData or Flow



//        lifecycleScope.launch {
//            val response: Response<PostResponseModel> =
//                DataApiImp().getDataApi().postData(PostRequestModel(10, "Gaming", "Dev"))
//            textView.text = response.body()!!.data.response
//        }






//   3.     With Flow

        val flowResponse = flow {
            val response: Response<PostResponseModel> =
                DataApiImp().getDataApi().postData(PostRequestModel(10, "Gaming", "Dev"))
            emit(response)
        }

        lifecycleScope.launch {
            flowResponse.collect{
                textView.text = it.body()!!.data.response
            }
        }
    }

}