package com

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.remote.LoveModel

class LoveViewModel : ViewModel() {

    private val repository = Repository()

    fun getLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveModel(firstName = firstName, secondName = secondName)
    }

}