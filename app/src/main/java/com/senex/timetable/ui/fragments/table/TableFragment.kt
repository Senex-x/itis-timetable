package com.senex.timetable.ui.fragments.table

import android.os.Bundle
import android.view.*
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentTableBinding
import com.senex.timetable.utils.log

class TableFragment : Fragment() {
    private var _binding: FragmentTableBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTableBinding.inflate(
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
                R.id.action_pick_group -> {
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