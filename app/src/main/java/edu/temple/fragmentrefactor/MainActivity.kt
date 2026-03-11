package edu.temple.fragmentrefactor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/**
 * ## Lab Assignment Instructions:
 *
 * - Take a look at the code and run it to understand its behavior.
 *
 * - Once it is understood, refactor the project to utilize a Fragment to
 * provide the app functionality. That is, create a fragment instance that performs the functionality currently performed by the Activity. Additionally (and necessarily) move the view items from the activity's layout file to the Fragment's layout file. Once the fragment implementation is complete, add an instance to the activity using a FragmentTransaction.
 *
 * - Remember that when creating a fragment in Android Studio, always choose
 * the "Blank" fragment template.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val changeButton = findViewById<Button>(R.id.changeButton)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, GreetingFragment.newInstance
                    ("Hello World"))
                .commit()
        }
        changeButton.setOnClickListener {
            val name = nameEditText.text.toString()

            val message = if (name.isNotBlank()) {
                "Hello, $name!"
            } else {
                "Please enter your name"
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, GreetingFragment
                    .newInstance(message))
                .commit()
        }
    }
}