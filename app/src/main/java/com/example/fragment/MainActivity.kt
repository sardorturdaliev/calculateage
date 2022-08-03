package com.example.fragment

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinute: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnDatepicker: Button = findViewById(R.id.buttonDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinute = findViewById(R.id.tvAgeInMinute)


        btnDatepicker.setOnClickListener {
            clickDatePicker()
        }

    }


    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedyear, selectedmonth, selecetedayofMonth ->
//                Toast.makeText(this, "You was $year, month was ${month + 1}", Toast.LENGTH_SHORT)
//                    .show()
                val selectedDate =
                    "$selecetedayofMonth/${selectedmonth + 1}/${selectedyear}"// --->  2/8/2022
                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val selecetedDateMinute = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinute = currentDate.time / 60000
                val differenceMinute = currentDateInMinute - selecetedDateMinute

                tvAgeInMinute?.text = differenceMinute.toString()


            },
            year,
            month,
            day
        ).show()

    }

}