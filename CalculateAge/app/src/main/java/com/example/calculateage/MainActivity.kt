package com.example.calculateage

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS

class MainActivity : AppCompatActivity() {


    private val cal = Calendar.getInstance()
    private val currentYear : Int = cal.get(Calendar.YEAR)
    private val currentMonth : Int = cal.get(Calendar.MONTH)
    private val currentDay : Int = cal.get(Calendar.DAY_OF_MONTH)
    private val date = Date(currentYear, currentMonth, currentDay)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectDateButton.setOnClickListener { view ->
            clickDateButton(view)
        }
    }

    fun clickDateButton(view : View) {
        var year  = cal.get(Calendar.YEAR)
        var month  = cal.get(Calendar.MONTH)
        var day  = cal.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            calculateMinutes(year, month, dayOfMonth)
            setLabel()
        } , year, month, day).show()
    }

    fun setLabel() {
        displayDate.text = "" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR)
    }

    fun calculateMinutes(year: Int, month: Int, day : Int) {
        val selectedDate = Date(year, month, day)

        val diff : Long = date.time - selectedDate.time
        minutesTextView.text = (MILLISECONDS.toMinutes(diff)).toString();
        print(minutesTextView.text)


    }
}