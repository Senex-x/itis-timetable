package com.senex.timetable.presentation.ui.schedule.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.senex.timetable.databinding.FragmentDailyScheduleBinding
import com.senex.timetable.domain.util.toast
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.ui.schedule.ScheduleFragmentDirections
import com.senex.timetable.presentation.ui.schedule.ScheduleViewModel
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItem
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItemDiffCallback
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.DayOfWeek
import javax.inject.Inject

class DailyScheduleFragment : DaggerFragment() {
    private var _binding: FragmentDailyScheduleBinding? = null
    private val binding
        get() = _binding!!

    private val dayOfWeek by lazy {
        arguments?.getSerializable(DAY_OF_WEEK_KEY) as DayOfWeek
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels(
        ownerProducer = { requireParentFragment() },
        factoryProducer = { factory },
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentDailyScheduleBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        scheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        scheduleRecyclerView.adapter = AsyncListDifferDelegationAdapter(
            SubjectsRecyclerItemDiffCallback,
            SubjectsRecyclerItem.OrdinaryItem.getDelegate(navigateToOrdinarySubjectFragment),
            SubjectsRecyclerItem.ElectiveItem.getDelegate(navigateToElectiveSubjectFragment),
            SubjectsRecyclerItem.EnglishItem.getDelegate(navigateToEnglishSubjectFragment),
            SubjectsRecyclerItem.PhysicalItem.getDelegate { requireContext().toast("Physical item") },
            SubjectsRecyclerItem.BlockItem.getDelegate { requireContext().toast("Block item") },
            SubjectsRecyclerItem.EmptyItem.getDelegate(),
        ).apply {
            viewModel.getDailySubjectRecyclerItems(dayOfWeek).onEach {
                emptyListHint.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
                items = it
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private val navigateToOrdinarySubjectFragment: (Long) -> Unit = { subjectId ->
        findNavController().navigate(
            ScheduleFragmentDirections.actionScheduleFragmentToOrdinarySubjectFragment(
                subjectId
            )
        )
    }

    private val navigateToElectiveSubjectFragment: (Long) -> Unit = { electiveSubjectId ->
        findNavController().navigate(
            ScheduleFragmentDirections.actionScheduleFragmentToElectiveSubjectFragment(
                electiveSubjectId
            )
        )
    }

    private val navigateToEnglishSubjectFragment: (Long) -> Unit = { englishSubjectId ->
        findNavController().navigate(
            ScheduleFragmentDirections.actionScheduleFragmentToEnglishSubjectFragment(
                englishSubjectId
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val DAY_OF_WEEK_KEY = "day_of_week"

        fun newInstance(dayOfWeek: DayOfWeek) = DailyScheduleFragment().apply {
            arguments = Bundle().apply {
                putSerializable(DAY_OF_WEEK_KEY, dayOfWeek)
            }
        }
    }
}