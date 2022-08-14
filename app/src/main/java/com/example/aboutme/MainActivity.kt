package com.example.aboutme

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName:MyName = MyName("Yashwant Chouhan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

//        findViewById<Button>(R.id.Done).setOnClickListener {
//            addNickname(it)
//        }
        binding.Done.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {

//            binding.nicknameText.text = binding.nicknameEdit.text

            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}