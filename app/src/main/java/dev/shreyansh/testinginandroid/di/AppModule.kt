package dev.shreyansh.testinginandroid.di

import android.content.Context
import androidx.room.Room
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingDao
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItemDatabase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.shreyansh.testinginandroid.data.remote.PixabayAPI
import dev.shreyansh.testinginandroid.repository.ShoppingRepository
import dev.shreyansh.testinginandroid.repository.ShoppingRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDataBaseDeps(@ApplicationContext context : Context) =
        Room.databaseBuilder(context, ShoppingItemDatabase::class.java, "ShoppingITEMDB").build()

    @Singleton
    @Provides
    fun provideDataBaseDao(database: ShoppingItemDatabase) = database.shoppingDao


    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val BASE_URL = "https://pixabay.com"

    @Singleton
    @Provides
    fun provideRetrofitDeps(): PixabayAPI = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()
        .create(PixabayAPI::class.java)


    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(database: ShoppingItemDatabase, api: PixabayAPI) = ShoppingRepositoryImpl(database, api) as ShoppingRepository

}