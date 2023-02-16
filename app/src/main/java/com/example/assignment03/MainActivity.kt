package com.example.assignment03

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get access to our view elements
        val spinner = findViewById<Spinner>(R.id.spinner)
        val canvas = findViewById<View>(R.id.canvas)
        //Create an array of color elements (of Strings actually)
        val colors = arrayOf(
            "Please select the color",
            "red",
            "blue",
            "green",
            "black",
            "white",
            "gray",
            "cyan",
            "magenta",
            "yellow",
            "lightgray",
            "darkgray"
        )
        val adapter = ColorAdapter(this, colors)


        // Set the custom adapter for the spinner
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == 0) {
                    canvas.setBackgroundColor(Color.parseColor("white"))
                    return
                }
                p0?.run {
                    val color = getItemAtPosition(p2).toString()
                    canvas.setBackgroundColor(Color.parseColor(color))
                }
                /* p1?.run {
                     val color = (this as TextView).text.toString()
                     canvas.setBackgroundColor(Color.parseColor(color))
                 }*/

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }
}

class ColorAdapter(_context: Context, _colors: Array<String>) : BaseAdapter() {
    private val context = _context
    private val colors = _colors

    override fun getCount(): Int {
        return colors.size
    }

    override fun getItem(p0: Int): Any {
        return colors[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView: TextView

        if (p1 != null) {
            // this is a previously created TextView
            textView = p1 as TextView
        } else {
            textView = TextView(context)
            textView.textSize = 22f
            textView.setPadding(5, 10, 0, 10)
        }
        textView.text = colors[p0]
        //update some properties
        textView.setBackgroundColor(Color.parseColor("white"))
        return textView
    }

    override fun getDropDownView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView: TextView

        if (p1 != null) {
            // this is a previously created TextView
            textView = p1 as TextView
        } else {
            textView = TextView(context)
            textView.textSize = 22f
            textView.setPadding(5, 10, 0, 10)
        }
        //update some properties
        textView.text = colors[p0]

        if (p0 != 0) {
            textView.setBackgroundColor(Color.parseColor(colors[p0]))
        }
        else{
            textView.setBackgroundColor(Color.parseColor("White"))
        }


        return textView
    }
}
