package com.garpix.pack.text_watcher

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * TextWatcher to add the required suffix at the end of the line
 * @param suffix - needed suffix
 * @param editText - editText in which to perform the operation
 */

class GarpixSuffixTextWatcher constructor(
    private val editText: EditText,
    private val suffix: String
) : TextWatcher {

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun beforeTextChanged(c: CharSequence?, start: Int, count: Int, after: Int) {}

    @SuppressLint("SetTextI18n")
    override fun afterTextChanged(e: Editable) {
        var s = e.toString()
        if (s.isNotEmpty()) {
            if (!s.endsWith(suffix)) {
                if (s != s + suffix) {
                    s = s.replace("[^\\d.]".toRegex(), "")
                    editText.setText("$s $suffix")
                } else {
                    editText.setSelection(s.length - suffix.length)
                }
            } else {
                editText.setSelection(s.length - suffix.length)
                if (s == suffix) {
                    editText.setText("")
                }
            }
        }
    }

}