package com.sunnyweather.drawpixel.ui.theme

import android.graphics.Color
import android.graphics.ColorSpace.Rgb
import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView

import com.sunnyweather.drawpixel.R

class MainActivity : AppCompatActivity() {

    // 设置一个画笔的颜色
    var penColor = Color.RED
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 获取调色板的按钮
        val redBtn = findViewById<Button>(R.id.redBtn)
        val blueBtn = findViewById<Button>(R.id.blueBtn)
        val greenBtn = findViewById<Button>(R.id.greenBtn)

        redBtn.setOnClickListener {
            // 按钮变大

            penColor = Color.RED
        }
        blueBtn.setOnClickListener {
            penColor = Color.BLUE


        }
        greenBtn.setOnClickListener {
            penColor = Color.GREEN


        }



        val gridLayout:GridLayout = findViewById(R.id.grid)
        for (i in 0..48)
        {
            val imageView:ImageView = ImageView(this)
            imageView.setBackgroundColor(Color.RED)

            imageView.layoutParams = GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED,1f),
                GridLayout.spec(GridLayout.UNDEFINED,1f)
            )
            imageView.setOnClickListener {
                val backgroundDrawable = imageView.background
                if (backgroundDrawable != null && backgroundDrawable is ColorDrawable) {
                    imageView.setBackgroundColor(penColor)

                }
            }
            gridLayout.addView(imageView)

        }
    }
}