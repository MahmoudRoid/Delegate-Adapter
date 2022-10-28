package com.ebcom.improvedrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebcom.improvedrecyclerview.adapter.MainCompositeAdapter
import com.ebcom.improvedrecyclerview.adapter.PersonAdapterDelegate
import com.ebcom.improvedrecyclerview.adapter.PhoneAdapterDelegate
import com.ebcom.improvedrecyclerview.databinding.ActivityMainBinding
import com.ebcom.improvedrecyclerview.model.PersonModel
import com.ebcom.improvedrecyclerview.model.PhoneModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy {
        MainCompositeAdapter.Builder()
            .add(PersonAdapterDelegate(::onPersonItemClicked))
            .add(PhoneAdapterDelegate())
            .build()
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

        myAdapter.submitList(
            preparePersonData() + preparePhoneData()
        )

    }

    private fun preparePersonData(): List<PersonModel> = listOf(
        PersonModel(1, "Didier", 40),
        PersonModel(2, "John", 39),
        PersonModel(3, "Peter", 38),
    )

    private fun preparePhoneData(): List<PhoneModel> = listOf(
        PhoneModel("Huawei"),
        PhoneModel("Samsung"),
    )

}