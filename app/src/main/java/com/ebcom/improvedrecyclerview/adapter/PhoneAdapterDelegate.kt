package com.ebcom.improvedrecyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebcom.improvedrecyclerview.databinding.PhoneItemBinding
import com.ebcom.improvedrecyclerview.model.PhoneModel

class PhoneAdapterDelegate : DelegateAdapter<PhoneModel, PhoneAdapterDelegate.BannerViewHolder>(
    PhoneModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = PhoneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun bindViewHolder(
        model: PhoneModel,
        viewHolder: BannerViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>,
        position: Int
    ) {
        viewHolder.bind(model)
    }

    inner class BannerViewHolder(private val binding: PhoneItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: PhoneModel) {
            binding.nameTv.text = item.name
        }
    }
}