package com.sunnyweather.drawpixel.ui.theme

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import com.sunnyweather.drawpixel.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayout:GridLayout = findViewById(R.id.grid)
        for (i in 0..48)
        {
            val imageView:ImageView = ImageView(this)
            imageView.setBackgroundColor(Color.RED)
//            imageView.maxWidth = 10
//            imageView.maxHeight = 10
            imageView.layoutParams = GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED,1f),
                GridLayout.spec(GridLayout.UNDEFINED,1f)
            )
            imageView.setOnClickListener {
                val backgroundDrawable = imageView.background
                if (backgroundDrawable != null && backgroundDrawable is ColorDrawable) {
                    val color = backgroundDrawable.color
                    if (color == Color.RED) {
                        imageView.setBackgroundColor(Color.WHITE)
                    } else {
                        imageView.setBackgroundColor(Color.RED)
                    }

                }
            }
            gridLayout.addView(imageView)

        }
    }
}