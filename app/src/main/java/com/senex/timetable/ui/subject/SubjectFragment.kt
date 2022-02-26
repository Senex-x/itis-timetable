package com.senex.timetable.ui.subject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.senex.timetable.daggerAppComponent
import com.senex.timetable.databinding.FragmentSubjectBinding
import kotlinx.coroutines.*
import javax.inject.Inject

class SubjectFragment : Fragment() {
    private var _binding: FragmentSubjectBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: SubjectViewModel by viewModels(factoryProducer = { factory })

    private val args: SubjectFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        context.daggerAppComponent.inject(this)

        runBlocking {
            viewModel.setSubject(args.subjectId)
        }

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSubjectBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = with(binding) {
        val subject = viewModel.getSubject()

    }
}