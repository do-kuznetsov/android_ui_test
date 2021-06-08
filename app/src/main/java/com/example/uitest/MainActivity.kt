package com.example.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.uitest.helpers.activate

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val emailText by lazy { findViewById<EditText>(R.id.email) }
    private val resultText by lazy { findViewById<TextView>(R.id.result) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        emailText.activate()
        findViewById<Button>(R.id.verify).setOnClickListener {
            verifyButtonClicked()
        }
    }

    private fun verifyButtonClicked() {
        emailText.clearFocus()
        val success = emailText.text.contains("@")
        resultText.text = getString(R.string.verify_status, getString(if (success) { R.string.ok } else { R.string.fail}))
    }
}
