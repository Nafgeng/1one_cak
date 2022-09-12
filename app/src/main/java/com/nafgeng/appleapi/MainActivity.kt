package com.nafgeng.appleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nafgeng.appleapi.adapter.Adapter1Cak
import com.nafgeng.appleapi.databinding.ActivityMainBinding
import com.nafgeng.appleapi.response.ResponseCak
import com.nafgeng.appleapi.service.Retrofit1Cak
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adaptermeme = Adapter1Cak()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            binding.rvMeme.adapter = adaptermeme
            binding.rvMeme.layoutManager = LinearLayoutManager(baseContext)
            binding.rvMeme.setHasFixedSize(true)
        }

        val call = Retrofit1Cak.getService().getDataOneCak()
        call.enqueue(object : Callback<ResponseCak> {
            override fun onResponse(
                call: Call<ResponseCak>,
                response: Response<ResponseCak>
            ) {
                val listArtikel = response.body()?.posts
                listArtikel.let {
                    it?.let {
                            it1 -> adaptermeme.datameme(it1)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCak>, t: Throwable) {
                Timber.e(t.localizedMessage)
            }
        })
    }
}
