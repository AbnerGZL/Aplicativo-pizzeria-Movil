package com.tecsup.loginapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecsup.loginapp.Models.Item

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<MutableList<Item>>(mutableListOf())
    val cartItems: LiveData<MutableList<Item>> get() = _cartItems

    fun addItem(item: Item) {
        _cartItems.value?.add(item)
        _cartItems.value = _cartItems.value
    }
}