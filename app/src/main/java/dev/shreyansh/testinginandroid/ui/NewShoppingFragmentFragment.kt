package dev.shreyansh.testinginandroid.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.shoppinglisttestingyt.ui.ShoppingViewModel
import dev.shreyansh.testinginandroid.R


class NewShoppingFragmentFragment : Fragment() {

    lateinit var viewModel: ShoppingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
        return inflater.inflate(R.layout.fragment_new_shopping_fragment, container, false)
    }


}