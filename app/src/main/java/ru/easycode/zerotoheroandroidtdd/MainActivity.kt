package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var count= Count.Base(3,9,-9)
    private lateinit var uiState: UiState
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)
        textView = findViewById(R.id.countTextView)


        incrementButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(decrementButton, incrementButton, textView)
        }



        decrementButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(decrementButton, incrementButton, textView)
        }

        if (savedInstanceState == null) {
            uiState = count.initial((textView.text.toString()))
            uiState.apply(decrementButton, incrementButton, textView)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable(KEY,UiState::class.java) as UiState
        else
        savedInstanceState.getSerializable(KEY) as UiState
        uiState.apply(decrementButton, incrementButton, textView)
    }

    companion object {

        private const val KEY = "uiStateKey"
    }
}
