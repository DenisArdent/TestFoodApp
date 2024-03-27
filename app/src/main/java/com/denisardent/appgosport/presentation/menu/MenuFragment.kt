package com.denisardent.appgosport.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.denisardent.appgosport.R
import com.denisardent.appgosport.databinding.FragmentMenuBinding
import com.denisardent.appgosport.presentation.menu.adapters.BannerListAdapter
import com.denisardent.appgosport.presentation.menu.adapters.ButtonsListAdapter
import com.denisardent.appgosport.presentation.menu.adapters.PizzaListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    private val binding get() = _binding!!

    private val bannerList = listOf<Int>(R.drawable.banner_first, R.drawable.banner_second)

    private val viewModel: MenuViewModel by viewModels()
    private val pizzaAdapter = PizzaListAdapter()
    private val buttonAdapter = ButtonsListAdapter()
    private val bannerAdapter = BannerListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.pizzaRecyclerView.adapter = pizzaAdapter
        binding.buttonRecyclerView.adapter = buttonAdapter
        binding.bannerRecyclerView.adapter = bannerAdapter
        viewModel.pizzaList.observe(viewLifecycleOwner) {
            pizzaAdapter.submitList(it)
        }
        viewModel.buttonsList.observe(viewLifecycleOwner){
            buttonAdapter.submitList(it)
        }
        bannerAdapter.submitList(bannerList)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}