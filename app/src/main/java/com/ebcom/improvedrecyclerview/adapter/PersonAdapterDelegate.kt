package com.ebcom.improvedrecyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebcom.improvedrecyclerview.databinding.PersonItemBinding
import com.ebcom.improvedrecyclerview.model.PersonModel

class PersonAdapterDelegate(
    private val callback: ((personModel: PersonModel, position: Int)-> Unit)? = null
) : DelegateAdapter<PersonModel, PersonAdapterDelegate.BannerViewHolder>(PersonModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun bindViewHolder(
        model: PersonModel,
        viewHolder: BannerViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>,
        position: Int
    ) {
        viewHolder.bind(model, position)
    }

    inner class BannerViewHolder(private val binding: PersonItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: PersonModel, position: Int) {
            binding.nameTv.text = item.name
            binding.ageTv.text = "age: ${item.name}"
            binding.nameTv.setOnClickListener { callback?.invoke(item, position) }
        }
    }
}
