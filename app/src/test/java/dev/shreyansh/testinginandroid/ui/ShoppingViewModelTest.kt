package dev.shreyansh.testinginandroid.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.androiddevs.shoppinglisttestingyt.ui.ShoppingViewModel
import com.google.common.truth.Truth.assertThat
import dev.shreyansh.testinginandroid.repository.FakeShoppingRepository
import dev.shreyansh.testinginandroid.utils.Status
import dev.shreyansh.testinginandroid.utils.getOrAwaitValueTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class ShoppingViewModelTest  {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ShoppingViewModel


    @Before
    fun setup() {
        viewModel = ShoppingViewModel(FakeShoppingRepository())
    }

    @Test
    fun insertEmptyShoppingItemIntoDb_returnsError() {
        viewModel.insertShoppingItem("name", "", "3.0")
        val totalValue = viewModel.insertShoppingItemStatus.getOrAwaitValueTest()

        assertThat(totalValue.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)



    }
}