package com.example.garpix.text_watcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * TextWatcher to serialize the string and the number of the passport "0000 000000"
 * @param input - editText in which to perform the operation
 */

class GarpixPassportTextWatcher constructor(private val input : EditText) : TextWatcher {

    var edited = false
    private val dividerCharacter = " "

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (edited) {
            edited = false
            return
        }
        var working = getEditText()
        working = manageDateDivider(working, 4, start, before)
        edited = true
        input.setText(working)
        input.text?.let { input.setSelection(it.length) }
    }

    private fun manageDateDivider(
        working: String,
        position: Int,
        start: Int,
        before: Int
    ): String {
        if (working.length == position) {
            return if (before <= position && start < position)
                working + dividerCharacter
            else
                working.dropLast(1)
        }
        return working
    }

    private fun getEditText(): String {
        return if (input.text?.length!! >= 11)
            input.text.toString().substring(0, 11)
        else
            input.text.toString()
    }

    override fun afterTextChanged(s: Editable) {}
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
}

