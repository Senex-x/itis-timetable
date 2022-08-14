package com.senex.timetable.presentation.ui.feedback

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentFeedbackBinding
import com.senex.timetable.domain.util.toast
import com.senex.timetable.presentation.common.BindingFragment

class FeedbackFragment : BindingFragment<FragmentFeedbackBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFeedbackBinding =
        FragmentFeedbackBinding::inflate

    override fun FragmentFeedbackBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())
        toolbarContainer.toolbar.title = getString(R.string.feedback_title)

        sendFeedbackButton.setOnClickListener {
            if (feedbackText.text.isNullOrBlank()) {
                requireContext().toast("To send a feedback you have to enter something first")
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.email_for_feedback)))
                putExtra(Intent.EXTRA_SUBJECT, "ITIS Timetable feedback")
                putExtra(Intent.EXTRA_TEXT, feedbackText.text.toString())
            }

            startActivity(intent)

            feedbackText.setText("")
        }
    }
}