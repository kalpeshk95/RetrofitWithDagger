package com.retrofit.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.retrofit.R
import com.retrofit.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter
    private lateinit var dialog: ProgressDialog

    private val model by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.model = model

        observeField()
    }

    private fun observeField() {
        model.list.observe(this,
            Observer {
                adapter = PostAdapter(this, it)
                val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                binding.rvPosts.layoutManager = layoutManager
                binding.rvPosts.adapter = adapter
            })

        model.toastMsg.observe(this,
            Observer {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })

        model.showLoader.observe(this,
            Observer {
                if (it) showLoading() else hideLoading()
            }
        )
    }

    private fun showLoading() {
        dialog = ProgressDialog(this).apply {
            setCanceledOnTouchOutside(false)
            setMessage("Please wait...")
        }
        if(!dialog.isShowing){
            dialog.show()
        }
    }

    private fun hideLoading() {
        if (dialog.isShowing) dialog.dismiss()
    }
}
