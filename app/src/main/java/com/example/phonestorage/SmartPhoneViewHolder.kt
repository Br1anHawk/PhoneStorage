package com.example.phonestorage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonestorage.databinding.CatalogItemBinding

class SmartPhoneViewHolder private constructor(
    private val binding: CatalogItemBinding,
    private val smartPhoneListener: SmartPhoneListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(smartPhone: SmartPhone) {
        with(binding) {

            VendorTextView.text = smartPhone.vendor
            phoneModelNameTextView.text = smartPhone.model
            OSTextView.text = smartPhone.os
            RAMTextView.text =
                if (isValid(smartPhone.ram))
                    "${smartPhone.ram} $DISPLAY_GB"
                else
                    DISPLAY_IF_PROPERTY_IS_INVALID

            FlashTextView.text =
                if (isValid(smartPhone.flash))
                    "${smartPhone.flash} $DISPLAY_GB"
                else
                    DISPLAY_IF_PROPERTY_IS_INVALID

            ScreenTextView.text =
                if (isValid(smartPhone.screen))
                    "${smartPhone.screen} $DISPLAY_INCHES"
                else
                    DISPLAY_IF_PROPERTY_IS_INVALID

            DisplayTextView.text = smartPhone.display
            CameraTextView.text =
                if (isValid(smartPhone.camera))
                    "${smartPhone.camera} $DISPLAY_GB"
                else
                    DISPLAY_IF_PROPERTY_IS_INVALID

            buttonEditSmartphoneInfo.setOnClickListener {
                smartPhoneListener.editSmartphoneInfo(smartPhone.id)
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup, smartPhoneListener: SmartPhoneListener): SmartPhoneViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CatalogItemBinding.inflate(layoutInflater, parent, false)
            return SmartPhoneViewHolder(binding, smartPhoneListener)
        }
    }
}