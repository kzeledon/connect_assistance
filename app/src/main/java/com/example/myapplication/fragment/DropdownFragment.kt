package com.example.myapplication.fragment

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.FragmentDropdownBinding
import com.example.myapplication.viewmodel.DropdownViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DropdownFragment : Fragment() {

    private val viewModel by viewModel<DropdownViewModel>()
    private var _binding: FragmentDropdownBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDropdownBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservables()
        setupListener()
        viewModel.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupListener() {
        binding.dropdownCarBrand.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedItem = p0?.getItemAtPosition(p2).toString()
                viewModel.getModels(selectedItem)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // TODO
            }
        }
    }

    private fun setupObservables() {
        viewModel.brandLiveData.observe(viewLifecycleOwner, Observer {
            it?.let{
                binding.dropdownCarBrand.adapter = ArrayAdapter(
                    requireContext(), android.R.layout.simple_spinner_item, it
                )
            }
        })

        viewModel.modelLiveData.observe(viewLifecycleOwner, Observer {
            it?.let{
                binding.dropdownCarModel.adapter = ArrayAdapter(
                    requireContext(), R.layout.simple_spinner_item, it
                )
            }
        })
    }
}