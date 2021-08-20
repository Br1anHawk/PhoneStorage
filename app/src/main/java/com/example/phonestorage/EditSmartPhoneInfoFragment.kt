package com.example.phonestorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.phonestorage.databinding.FragmentEditSmartphoneInfoBinding
import kotlinx.android.synthetic.main.template_fill_info_about_smartphone.*

class EditSmartPhoneInfoFragment : Fragment() {
    private var _binding: FragmentEditSmartphoneInfoBinding? = null
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
        _binding = FragmentEditSmartphoneInfoBinding.inflate(inflater, container, false)

        val args: EditSmartPhoneInfoFragmentArgs by navArgs()
        val smartphoneId = args.smartphone?.id ?: 0L
        args.smartphone?.let {
            with(binding.include) {
                editTextSmartphoneVendor.setText(it.vendor)
                editTextSmartphoneModel.setText(it.model)
                editTextSmartphoneOS.setText(it.os)
                editTextSmartphoneRAM.setText(it.ram.toString())
                editTextSmartphoneFlash.setText(it.flash.toString())
                editTextSmartphoneScreen.setText(it.screen.toString())
                editTextSmartphoneDisplay.setText(it.display)
                editTextSmartphoneCamera.setText(it.camera.toString())
            }
        }

        binding.buttonRemoveSmartphoneFromCatalog.setOnClickListener {
            catalogViewModel.deleteSmartPhone(smartphoneId)
            this
                .findNavController()
                .navigate(
                    EditSmartPhoneInfoFragmentDirections
                        .actionEditSmartPhoneInfoToCatalogFragment()
                )
        }

        binding.buttonEditSmartphoneInfo.setOnClickListener {
            with(binding.include) {
                val smartPhone = SmartPhone(
                    id = smartphoneId,
                    vendor = editTextSmartphoneVendor.text.toString(),
                    model = editTextSmartphoneModel.text.toString(),
                    os = editTextSmartphoneOS.text.toString(),
                    ram = editTextSmartphoneRAM.text.toString().toByteOrNull()
                        ?: DATA_CLASS_BYTE_TYPE_INIT,
                    flash = editTextSmartphoneFlash.text.toString().toShortOrNull()
                        ?: DATA_CLASS_SHORT_TYPE_INIT,
                    screen = editTextSmartphoneScreen.text.toString().toFloatOrNull()
                        ?: DATA_CLASS_FLOAT_TYPE_INIT,
                    display = editTextSmartphoneDisplay.text.toString(),
                    camera = editTextSmartphoneCamera.text.toString().toShortOrNull()
                        ?: DATA_CLASS_SHORT_TYPE_INIT
                )
                catalogViewModel.updateSmartPhone(smartPhone)
            }
                this
                    .findNavController()
                    .navigate(
                        EditSmartPhoneInfoFragmentDirections
                            .actionEditSmartPhoneInfoToCatalogFragment()
                    )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}