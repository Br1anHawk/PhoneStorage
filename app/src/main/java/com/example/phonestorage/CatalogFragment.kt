package com.example.phonestorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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

        val args: CatalogFragmentArgs by navArgs()
        args.smartPhone?.let { catalogViewModel.insertSmartPhone(it) }


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

    override fun deleteSmartPhoneFromCatalog(id: Long) {
        catalogViewModel.deleteSmartPhone(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}