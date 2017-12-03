package net.thebix.parkser.preferences

import android.content.Context
import android.content.SharedPreferences
import android.support.annotation.NonNull
import android.support.annotation.Nullable

class PreferencesManager(@NonNull context: Context) {

    private val PREFERENCES_FILE = "appData"
    private val PREFERENCES_ARRAY_PREFIX = "!#ARRAY#!"
    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
    }

    fun contains(key: String): Boolean {
        if (mSharedPreferences.contains(key))
            return true
        return mSharedPreferences.contains("${key}_${PREFERENCES_ARRAY_PREFIX}_${0}")
    }

    fun remove(key: String) {
        mSharedPreferences.edit().remove(key).apply()
        var i = 0
        var itemKey = getArrayKey(key, i)
        while (contains(itemKey)) {
            remove(itemKey)
            i += 1
            itemKey = getArrayKey(key, i)
        }
    }

    fun <T> get(@NonNull key: String, @NonNull default: T): T {
        return when (default) {
            is Int -> mSharedPreferences.getInt(key, default) as T
            is String -> mSharedPreferences.getString(key, default) as T
            is Long -> mSharedPreferences.getLong(key, default) as T
            is Boolean -> mSharedPreferences.getBoolean(key, default) as T
            else -> default
        }
    }

    fun <T> set(@NonNull key: String, @NonNull value: T) {
        checkNotNull(key, { "key" })
        val editor = mSharedPreferences.edit()
        when (value) {
            is Int -> editor.putInt(key, value)
            is String -> editor.putString(key, value)
            is Long -> editor.putLong(key, value)
            is Boolean -> editor.putBoolean(key, value)
            else -> return
        }
        editor.apply()
    }

    fun <T> getList(@Nullable key: String, @NonNull defaultListItem: T): List<T> {
        checkNotNull(key, { "key" })
        val result: ArrayList<T> = ArrayList()
        var i = 0
        var itemKey = getArrayKey(key, i)
        while (contains(itemKey)) {
            result.add(get(itemKey, defaultListItem))
            i += 1
            itemKey = getArrayKey(key, i)

        }
        return result
    }

    fun <T> setList(@NonNull key: String, @NonNull values: List<T>) {
        checkNotNull(key, { "key" })
        checkNotNull(values, { "values" })
        remove(key)
        for (i in values.indices) {
            set(getArrayKey(key, i), values[i])
        }
    }

    private fun getArrayKey(@NonNull key: String, @NonNull i: Int): String = "${key}_${PREFERENCES_ARRAY_PREFIX}_${i}"
}
