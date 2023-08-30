package dev.shreyansh.testinginandroid.repository

import androidx.lifecycle.LiveData
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItemDatabase
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import dev.shreyansh.testinginandroid.data.remote.PixabayAPI
import dev.shreyansh.testinginandroid.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val shoppingItemDatabase: ShoppingItemDatabase,
    private val pixabayAPI: PixabayAPI) : ShoppingRepository{

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItemDatabase.shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItemDatabase.shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingItemDatabase.shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingItemDatabase.shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            } else {
                Resource.error("An unknown error occured",null)
            }

        } catch (e: Exception) {
            return Resource.error("An unknown error occured", null)
        }
    }


}