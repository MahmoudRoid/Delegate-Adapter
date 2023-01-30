package com.ebcom.improvedrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebcom.improvedrecyclerview.adapter.MainCompositeAdapter
import com.ebcom.improvedrecyclerview.adapter.PersonAdapterDelegate
import com.ebcom.improvedrecyclerview.adapter.PhoneAdapterDelegate
import com.ebcom.improvedrecyclerview.adapter.TmpAdapterDelegate
import com.ebcom.improvedrecyclerview.databinding.ActivityMainBinding
import com.ebcom.improvedrecyclerview.model.PersonModel
import com.ebcom.improvedrecyclerview.model.PhoneModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val list = mutableListOf<PersonModel>()

    private val myAdapter by lazy {
        MainCompositeAdapter.Builder()
            .add(PersonAdapterDelegate(::onPersonItemClicked)) // 0
            .add(TmpAdapterDelegate()) // 1
            .build(::decideView)
    }

    private fun decideView(position: Int): Int {
        if (list[position].name.startsWith("X"))
            return 0
        else
            return 1
    }

    private fun onPersonItemClicked(personModel: PersonModel, position: Int){
        Toast.makeText(this, "on item clicked", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        list.addAll(preparePersonData())
        list.addAll(prepareTmpData())
        myAdapter.submitList(list.toList())

    }

    private fun preparePersonData(): List<PersonModel> = listOf(
        PersonModel(1, "Didier", 40),
        PersonModel(2, "John", 39),
        PersonModel(3, "Peter", 38),
    )

    private fun prepareTmpData(): List<PersonModel> = listOf(
        PersonModel(4, "XXX", 0),
        PersonModel(5, "YYY", 1),
    )

    private fun preparePhoneData(): List<PhoneModel> = listOf(
        PhoneModel("Huawei"),
        PhoneModel("Samsung"),
    )

}