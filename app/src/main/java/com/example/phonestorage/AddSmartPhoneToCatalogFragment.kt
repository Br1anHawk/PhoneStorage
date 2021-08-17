package com.example.phonestorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.phonestorage.databinding.FragmentAddSmartphoneToCatalogBinding
import kotlinx.android.synthetic.main.template_fill_info_about_smartphone.*

class AddSmartPhoneToCatalogFragment: Fragment() {

    private var _binding: FragmentAddSmartphoneToCatalogBinding? = null
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
        _binding = FragmentAddSmartphoneToCatalogBinding.inflate(inflater, container, false)


        binding.addSmartPhoneToCatalogButton.setOnClickListener {
            val smartPhone = SmartPhone(
                id = 0L,
                vendor = editTextSmartphoneVendor.text.toString(),
                model = editTextSmartphoneModel.text.toString(),
                os = editTextSmartphoneOS.text.toString(),
                ram = editTextSmartphoneRAM.text.toString().toByteOrNull() ?: DATA_CLASS_BYTE_TYPE_INIT,
                flash = editTextSmartphoneFlash.text.toString().toShortOrNull() ?: DATA_CLASS_SHORT_TYPE_INIT,
                screen = editTextSmartphoneScreen.text.toString().toFloatOrNull() ?: DATA_CLASS_FLOAT_TYPE_INIT,
                display = editTextSmartphoneDisplay.text.toString(),
                camera = editTextSmartphoneCamera.text.toString().toShortOrNull() ?: DATA_CLASS_SHORT_TYPE_INIT
            )
            catalogViewModel.insertSmartPhone(smartPhone)
            this
                .findNavController()
                .navigate(
                    AddSmartPhoneToCatalogFragmentDirections
                        .actionAddSmartPhoneToCatalogToCatalogFragment()
                )

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}