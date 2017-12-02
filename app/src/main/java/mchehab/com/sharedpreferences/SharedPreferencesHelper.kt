package mchehab.com.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by muhammadchehab on 12/2/17.
 */
object SharedPreferencesHelper {

    private val SHARED_PREFERENCES_NAME = "name"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("name", Context.MODE_PRIVATE)
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {
        getSharedPreferences(context).edit().putBoolean(key, value).apply()
    }

    fun putString(context: Context, key: String, value: String) {
        getSharedPreferences(context).edit().putString(key, value).apply()
    }

    fun putInt(context: Context, key: String, value: Int) {
        getSharedPreferences(context).edit().putInt(key, value).apply()
    }

    fun getString(context: Context, key: String, defaultValue: String): String? {
        return getSharedPreferences(context).getString(key, defaultValue)
    }

    fun getInt(context: Context, key: String, defaultValue: Int): Int {
        return getSharedPreferences(context).getInt(key, defaultValue)
    }

    fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
        return getSharedPreferences(context).getBoolean(key, defaultValue)
    }
}