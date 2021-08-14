package com.example.phonestorage

import androidx.recyclerview.widget.DiffUtil

object SmartPhoneDiffCallback: DiffUtil.ItemCallback<SmartPhone>() {
    override fun areItemsTheSame(oldItem: SmartPhone, newItem: SmartPhone): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SmartPhone, newItem: SmartPhone): Boolean {
        return oldItem == newItem
    }

    //override fun getChangePayload(oldItem: SmartPhone, newItem: SmartPhone) = Any()
}