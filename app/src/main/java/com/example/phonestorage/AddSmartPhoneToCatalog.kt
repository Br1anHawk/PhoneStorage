package com.example.phonestorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.phonestorage.databinding.FragmentAddSmartphoneToCatalogBinding
import com.example.phonestorage.databinding.FragmentHomeBinding

class AddSmartPhoneToCatalog: Fragment() {

    private var _binding: FragmentAddSmartphoneToCatalogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddSmartphoneToCatalogBinding.inflate(inflater, container, false)

        with(binding) {
            addSmartPhoneToCatalogButton.setOnClickListener {
                it
                    .findNavController()
                    .navigate(
                        AddSmartPhoneToCatalogDirections
                            .actionAddSmartPhoneToCatalogToCatalogFragment(
                                SmartPhone(
                                    id = 0L,
                                    vendor = smartPhoneVendorEditText.text.toString(),
                                    model = smartPhoneModelNameEditText.text.toString(),
                                    os = smartPhoneOSEditText.text.toString(),
                                    ram = smartPhoneRAMEditText.text.toString().toByteOrNull() ?: DATA_CLASS_BYTE_TYPE_INIT,
                                    flash = smartPhoneFlashEditText.text.toString().toShortOrNull() ?: DATA_CLASS_SHORT_TYPE_INIT,
                                    screen = smartPhoneScreenEditText.text.toString().toFloatOrNull() ?: DATA_CLASS_FLOAT_TYPE_INIT,
                                    display = smartPhoneDisplayEditText.text.toString(),
                                    camera = smartPhoneCameraEditText.text.toString().toShortOrNull() ?: DATA_CLASS_SHORT_TYPE_INIT
                                )
                            )
                    )
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}