package com.example.phonestorage

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class CatalogAdapter(
    private val smartPhoneListener: SmartPhoneListener
): ListAdapter<SmartPhone, SmartPhoneViewHolder>(SmartPhoneDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartPhoneViewHolder {
        return SmartPhoneViewHolder.from(parent, smartPhoneListener)
    }

    override fun onBindViewHolder(holder: SmartPhoneViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}