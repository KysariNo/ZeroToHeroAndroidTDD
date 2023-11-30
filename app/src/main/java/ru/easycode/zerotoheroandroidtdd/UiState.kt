package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState :Serializable {

    fun apply(decrmentButton: Button,
              incrementButton: Button,
              textView: TextView)
    data class Min(private val text: String) : UiState {
        override fun apply(decrmentButton: Button, incrementButton: Button, textView: TextView) {
           textView.text = text
            decrmentButton.isEnabled = false
        }

    }

    data class Base(private val text: String) : UiState {
        override fun apply(decrmentButton: Button, incrementButton: Button, textView: TextView) {
            textView.text = text
        }

    }

    data class Max(private val text: String) : UiState {
        override fun apply(decrmentButton: Button, incrementButton: Button, textView: TextView) {
            textView.text = text
            incrementButton.isEnabled =false
        }

    }
}