package com.garpix.pack.text_watcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * TextWatcher for converting a string to a phone number in the format: "+7 (999) 999-99-99
 * @param input - editText in which to perform the operation
 */


class GarpixPhoneTextWatcher constructor(private val input : EditText) : TextWatcher {

    private var backspacingFlag = false
    private var editedFlag = false
    private var cursorComplement = 0
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        cursorComplement = s.length - input.selectionStart
        backspacingFlag = count > after
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    override fun afterTextChanged(s: Editable) {
        val string = s.toString()
        val phone = string.replace("[^\\d]".toRegex(), "")
        if (!editedFlag) {
            if (phone.length >= 9 && !backspacingFlag) {
                editedFlag = true
                if (phone[0].toString() == "7" || phone[0].toString() == "8") {
                    val ans = "+7 (" + phone.substring(1, 4) + ") " + phone.substring(
                        4,
                        7
                    ) + "-" + phone.substring(7, 9) + "-" + phone.substring(9)
                    input.setText(ans)
                    input.setSelection(input.text.length - cursorComplement)
                } else {
                    val ans = "+7 (" + phone.substring(0, 3) + ") " + phone.substring(
                        3,
                        6
                    ) + "-" + phone.substring(6, 8) + "-" + phone.substring(8)
                    input.setText(ans)
                    input.setSelection(input.text.length - cursorComplement)
                }
            } else if (phone.length >= 4 && !backspacingFlag) {
                editedFlag = true
                if (phone[0].toString() == "7" || phone[0].toString() == "8") {
                    val ans = "+7 (" + phone.substring(1, 4) + ") " + phone.substring(4)
                    input.setText(ans)
                    input.setSelection(input.text.length - cursorComplement)
                } else {
                    val ans = "+7 (" + phone.substring(0, 3) + ") " + phone.substring(3)
                    input.setText(ans)
                    input.setSelection(input.text.length - cursorComplement)
                }
            }
        } else {
            editedFlag = false
        }
    }

    companion object {
        const val SECRET_KEY = 112
    }

}