package com.example.uitest.helpers

import android.view.View
import android.widget.EditText

fun EditText.activate() {
    onFocusChangeListener = View.OnFocusChangeListener { _, _ ->
        if (isRunningTest and (text.length > 15)) {
            setText(text.replace(Regex("@"), ""))
        }
    }
}
