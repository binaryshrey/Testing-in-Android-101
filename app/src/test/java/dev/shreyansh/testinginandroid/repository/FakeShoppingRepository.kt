package dev.shreyansh.testinginandroid.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import dev.shreyansh.testinginandroid.utils.Resource
import org.junit.Assert.*

class FakeShoppingRepository : ShoppingRepository {

    val shoppingItems = mutableListOf<ShoppingItem>()

    val observeAllShoppingItems = MutableLiveData<List<ShoppingItem>>(shoppingItems)

    val observeTotalPrice = MutableLiveData<Float>()

    var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean){
        shouldReturnNetworkError = value
    }

    private fun refreshLiveData(){
        observeAllShoppingItems.postValue(shoppingItems)
        observeTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice(): Float {
        return shoppingItems.sumByDouble { it.price.toDouble() * it.amount.toDouble() }.toFloat()
    }


    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
        refreshLiveData()
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.remove(shoppingItem)
        refreshLiveData()
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return observeAllShoppingItems
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return observeTotalPrice
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return if(shouldReturnNetworkError){
            Resource.error("Error", null)
        } else {
            Resource.success(ImageResponse(listOf(), 0, 0))
        }
    }



}