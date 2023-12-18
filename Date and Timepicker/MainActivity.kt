package com.pragadees.dateandtimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import java.time.Year
import java.util.Calendar

class MainActivity : AppCompatActivity() ,DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    private lateinit var displayDateAndTime : TextView
    private lateinit var dateAndTimeButton: Button
    private var TAG ="TAG"
    var day=0
    var month=0
    var year=0
    var hour=0
    var minutes=0
    var savedDay=0
    var savedMonth=0
    var savedYear=0
    var savedHour=0
    var savedMinutes=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    displayDateAndTime = findViewById(R.id.displayDateAndTime)
    dateAndTimeButton = findViewById(R.id.dateAndTimeButton)
        dateAndTimeButton.setOnClickListener{
        val cal = Calendar.getInstance()
        day=cal.get(Calendar.DATE)
        month=cal.get(Calendar.MONTH)
        year=cal.get(Calendar.YEAR)
        hour=cal.get(Calendar.HOUR)
        minutes=cal.get(Calendar.MINUTE)
        val datePickerDialog = DatePickerDialog(this,this,day,month,year)
        datePickerDialog.show()
        }
    }

    override fun onDateSet(view: DatePicker?, dayOfMonth : Int, month : Int, year : Int) {
        savedDay=dayOfMonth
        savedMonth=month
        savedYear=year
        val timePickerDialog=TimePickerDialog(this,this ,hour ,minutes ,true)
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        savedHour = hour
        savedMinutes= minutes
        displayDateAndTime.text = "$savedDay:${savedMonth+1}:$savedYear" + "\n" +"$savedHour:$savedMinutes"

    }
}