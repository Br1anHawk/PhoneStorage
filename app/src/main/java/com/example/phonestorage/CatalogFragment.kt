package com.example.phonestorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonestorage.databinding.FragmentCatalogBinding

class CatalogFragment: Fragment(), SmartPhoneListener {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    private val catalogViewModel: CatalogViewModel by viewModels {
        ViewModelsFactory(
            CatalogDatabase.getInstance(
                requireNotNull(this.activity).application
            )
            .catalogDatabaseDao
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)

        val catalogAdapter = CatalogAdapter(this)
        binding.catalogList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = catalogAdapter
        }

        binding.openSmartPhoneFormForAddindButton.setOnClickListener {
            this.findNavController().navigate(
                CatalogFragmentDirections.actionCatalogFragmentToAddSmartPhoneToCatalog()
            )
        }

        catalogViewModel.smartPhones.observe(viewLifecycleOwner, {
            it?.let {
                catalogAdapter.submitList(it)
                //catalogAdapter.notifyDataSetChanged()
            }
        })

        return binding.root
    }

    override fun editSmartphoneInfo(id: Long) {
        val smartPhone = catalogViewModel.getSmartPhone(id)
        this.findNavController().navigate(
            CatalogFragmentDirections.actionCatalogFragmentToEditSmartPhoneInfo(smartPhone )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}