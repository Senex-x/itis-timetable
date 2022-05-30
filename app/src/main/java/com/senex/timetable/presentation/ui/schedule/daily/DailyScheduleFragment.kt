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
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.ui.schedule.ScheduleFragmentDirections
import com.senex.timetable.presentation.ui.schedule.ScheduleViewModel
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItem
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItemDiffCallback
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.DayOfWeek
import javax.inject.Inject

class DailyScheduleFragment : BindingFragment<FragmentDailyScheduleBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDailyScheduleBinding =
        FragmentDailyScheduleBinding::inflate

    private val dayOfWeek by lazy {
        arguments?.getSerializable(DAY_OF_WEEK_KEY) as DayOfWeek
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels(
        ownerProducer = { requireParentFragment() },
        factoryProducer = { factory },
    )

    override fun FragmentDailyScheduleBinding.onViewCreated() {
        emptyListHint.visibility = if (viewModel.groupId == null)
            View.VISIBLE else View.GONE

        scheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        scheduleRecyclerView.adapter = AsyncListDifferDelegationAdapter(
            SubjectsRecyclerItemDiffCallback,
            SubjectsRecyclerItem.OrdinaryItem.getDelegate(navigateToSubjectFragment),
            SubjectsRecyclerItem.ElectiveItem.getDelegate(navigateToElectiveSubjectFragment),
            SubjectsRecyclerItem.EnglishItem.getDelegate(navigateToEnglishSubjectFragment),
            SubjectsRecyclerItem.PhysicalItem.getDelegate(navigateToSubjectFragment),
            SubjectsRecyclerItem.BlockItem.getDelegate(navigateToSubjectFragment),
            SubjectsRecyclerItem.EmptyItem.getDelegate(),
        ).apply {
            viewModel.getSubjectsRecyclerItems(dayOfWeek).onEach {
                loadingIndicator.visibility = if (it.isEmpty() && viewModel.groupId != null)
                    View.VISIBLE else View.GONE

                items = it
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private val navigateToSubjectFragment: (Long) -> Unit = { subjectId ->
        findNavController().navigate(
            ScheduleFragmentDirections.actionScheduleFragmentToSubjectFragment(
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

    companion object {
        private const val DAY_OF_WEEK_KEY = "day_of_week"

        fun newInstance(dayOfWeek: DayOfWeek) = DailyScheduleFragment().apply {
            arguments = Bundle().apply {
                putSerializable(DAY_OF_WEEK_KEY, dayOfWeek)
            }
        }
    }
}