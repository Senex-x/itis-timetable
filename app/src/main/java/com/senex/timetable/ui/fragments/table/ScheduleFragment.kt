package com.senex.timetable.ui.fragments.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentScheduleBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        tableToolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_open_groups_fragment -> {
                    navigateToTableFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToTableFragment() {
        findNavController().navigate(
            R.id.action_tableFragment_to_groupsFragment
        )
    }
}