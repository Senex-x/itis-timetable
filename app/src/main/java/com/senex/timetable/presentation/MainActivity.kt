package com.senex.timetable.presentation

import android.os.Bundle
import com.senex.timetable.databinding.ActivityMainBinding
import com.senex.timetable.presentation.common.prefs.LanguagePrefs
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var languagePrefs: LanguagePrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLocale()
    }

    private fun setLocale() {
        val locale = languagePrefs.getSavedLanguage().locale
        Locale.setDefault(locale)

        baseContext.resources.updateConfiguration(
            baseContext.resources.configuration.apply { setLocale(locale) },
            baseContext.resources.displayMetrics
        )
    }
}