package com.kishlo.ecommerce

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun Fragment.setTitle(@StringRes id: Int) {
    (activity as AppCompatActivity?)?.supportActionBar?.title = getString(id)
}