package mchehab.com.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButtonDoneOnClickListener()
        if (areValuesInPreferences()) {
            restoreFromPreferences()
        }
    }

    private fun setButtonDoneOnClickListener() {
        buttonDone.setOnClickListener {
            val name = editTextName.text.toString()
            val age: Int
            if (editTextAge.text.toString() == "") {
                age = 0
            } else {
                age = Integer.parseInt(editTextAge.text.toString())
            }
            val isChecked = checkbox.isChecked()

            SharedPreferencesHelper.putString(this, SharedPreferencesConstants.NAME, name)
            SharedPreferencesHelper.putInt(this, SharedPreferencesConstants.AGE, age)
            SharedPreferencesHelper.putBoolean(this, SharedPreferencesConstants.CHECKBOX, isChecked)
            SharedPreferencesHelper.putBoolean(this, SharedPreferencesConstants.ARE_VALUES_STORED, true)
        }
    }

    private fun areValuesInPreferences(): Boolean {
        return SharedPreferencesHelper.getBoolean(this, "isStored", false)
    }

    private fun restoreFromPreferences() {
        editTextName.setText(SharedPreferencesHelper.getString(this, SharedPreferencesConstants.NAME, ""))
        editTextAge.setText("" + SharedPreferencesHelper.getInt(this, SharedPreferencesConstants.AGE, 0))
        checkbox.isChecked = SharedPreferencesHelper.getBoolean(this, SharedPreferencesConstants.CHECKBOX, false)
    }

}
