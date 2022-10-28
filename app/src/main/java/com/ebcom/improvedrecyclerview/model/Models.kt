package com.ebcom.improvedrecyclerview.model

import com.ebcom.improvedrecyclerview.adapter.DelegateAdapterItem

data class PersonModel(
    val id: Int,
    val name: String,
    val age: Int
): DelegateAdapterItem {
    override fun id(): Any = id // or something else
    override fun content(): Any = age
}



data class PhoneModel(
    val name: String
): DelegateAdapterItem {
    override fun id(): Any = name // or something else
    override fun content(): Any = name
}
