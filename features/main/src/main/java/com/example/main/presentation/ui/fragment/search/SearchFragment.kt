package com.example.main.presentation.ui.fragment.search

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseBottomSheetDialogFragment
import com.example.main.R
import com.example.main.databinding.FragmentBottomDialogBinding

class SearchFragment(private val searchByNameCity: (cityName: String) -> Unit) :
    BaseBottomSheetDialogFragment<FragmentBottomDialogBinding>(R.layout.fragment_bottom_dialog) {
    override val binding: FragmentBottomDialogBinding by viewBinding(FragmentBottomDialogBinding::bind)

    override fun initialize() {
        binding.itemBtnSearch.setOnClickListener {
            val cityName = binding.itemEtSearch.text.toString()
            searchByNameCity(cityName)
            dismiss()
        }
    }
}