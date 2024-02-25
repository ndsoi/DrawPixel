package com.sunnyweather.drawpixel.ui.theme



import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageView


import com.sunnyweather.drawpixel.R

class MainActivity : AppCompatActivity() {

    // 设置一个画笔的颜色
    var penColor = android.graphics.Color.RED
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 获取调色板的按钮
        val redBtn = findViewById<Button>(R.id.redBtn)
        val blueBtn = findViewById<Button>(R.id.blueBtn)
        val greenBtn = findViewById<Button>(R.id.greenBtn)
        val nowColorBtn = findViewById<Button>(R.id.NowColorBtn)

        redBtn.setOnClickListener {
            penColor = android.graphics.Color.RED
            nowColorBtn.setBackgroundColor(penColor)
        }
        blueBtn.setOnClickListener {
            penColor = android.graphics.Color.BLUE
            nowColorBtn.setBackgroundColor(penColor)

        }
        greenBtn.setOnClickListener {
            penColor = android.graphics.Color.GREEN
            nowColorBtn.setBackgroundColor(penColor)

        }





        val gridLayout:GridLayout = findViewById(R.id.grid)



        for (i in 0..48)
        {
            val imageView:ImageView = ImageView(this)
            imageView.setBackgroundColor(android.graphics.Color.RED)

            imageView.layoutParams = GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED,1f),
                GridLayout.spec(GridLayout.UNDEFINED,1f)
            )
            imageView.setOnClickListener {
                val backgroundDrawable = imageView.background
                if (backgroundDrawable != null && backgroundDrawable is ColorDrawable) {
                    imageView.setBackgroundColor(penColor)

                }
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(it.windowToken,0)
            }

            gridLayout.addView(imageView)

        }

        // 获取editText中的数值
        val rValue :EditText = findViewById(R.id.rValue)
        val gValue:EditText = findViewById(R.id.gValue)
        val bValue:EditText = findViewById(R.id.bValue)
        rValue.setOnClickListener{
            rValue.isCursorVisible = true
        }
        gValue.setOnClickListener{
            gValue.isCursorVisible = true
        }
        bValue.setOnClickListener{
            bValue.isCursorVisible = true
        }

        nowColorBtn.setOnClickListener {
            penColor = checkcolor(rValue.text.toString(),gValue.text.toString(),bValue.text.toString(), penColor)
            rValue.isCursorVisible = false
            gValue.isCursorVisible = false
            bValue.isCursorVisible = false
            nowColorBtn.setBackgroundColor(penColor)
        }



    }



}


@SuppressLint("Range")
fun checkcolor(s1:String, s2:String, s3:String, curColor: Int):Int
{

    var r = s1.toInt()
    var g = s2.toInt()
    var b = s3.toInt()
    Log.d("color","rgb:${r},${g},${b}")
    if((r>=0&&r<256)&&(g>=0&&g<256)&&(b>=0&&b<256))
    {
        return Color.rgb(r,g,b)
    }
    return curColor
}

