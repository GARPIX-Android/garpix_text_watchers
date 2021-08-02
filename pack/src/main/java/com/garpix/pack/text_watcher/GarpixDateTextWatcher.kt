package com.garpix.pack.text_watcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * TextWatcher for converting a string to a date in the format: "00.00.0000"
 * @param input - editText in which to perform the operation
 */


class GarpixDateTextWatcher constructor(private val input: EditText) : TextWatcher {
    private var current = ""
    private val ddmmyyyy = "ддммгггг"
    private val cal: Calendar = Calendar.getInstance()

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.toString() != current) {
            var clean = s.toString().replace("[^\\d.]|\\.".toRegex(), "")
            val cleanC = current.replace("[^\\d.]|\\.".toRegex(), "")
            val cl = clean.length
            var sel = cl
            var i = 2
            while (i <= cl && i < 6) {
                sel++
                i += 2
            }
            if (clean == cleanC) {
                sel--
            }
            if (clean.length < 8) {
                clean += ddmmyyyy.substring(clean.length)
            } else {
                var day = clean.substring(0, 2).toInt()
                var mon = clean.substring(2, 4).toInt()
                var year = clean.substring(4, 8).toInt()
                mon = if (mon < 1) 1 else min(mon, 12)
                cal[Calendar.MONTH] = mon - 1
                val currentYear = Calendar.getInstance()[Calendar.YEAR]
                year = if (year < currentYear - 120) currentYear - 120 else Math.min(
                    year,
                    currentYear - 18
                )
                cal[Calendar.YEAR] = year
                day = min(day, cal.getActualMaximum(Calendar.DATE))
                clean = String.format("%02d%02d%02d", day, mon, year)
            }
            clean = String.format(
                "%s.%s.%s",
                clean.substring(0, 2),
                clean.substring(2, 4),
                clean.substring(4, 8)
            )
            sel = max(sel, 0)
            current = clean
            input.setText(current)
            input.setSelection(min(sel, current.length))
        }
    }

    override fun afterTextChanged(s: Editable?) {}

}