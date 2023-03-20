package com.example.lab2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import com.example.lab2.LevelUp.LevelUpViewModel
import com.example.lab2.databinding.FragmentLevelUpBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LevelUpFragment : Fragment() {

    private lateinit var binding: FragmentLevelUpBinding
    //private lateinit var levelUpViewModel: LevelUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLevelUpBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        val tvQuote = binding.tvQuote
        val btnExcited = binding.btnExcited
        val btnTired = binding.btnTired
        val btnAnxious = binding.btnAnxious
        val btnIrritated = binding.btnIrritated
        val btnHome = binding.fabHome


        val viewModel: LevelUpViewModel by viewModels()

       //levelUpViewModel = ViewModelProvider(this)[LevelUpViewModel().javaClass]

        btnHome.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_levelUpFragment_to_homeFragment)
        }




                    btnExcited.setOnClickListener(){
                        // val excitedQuote = viewModel.getRandomExcitedQuote()
                        // tvQuote.text = excitedQuote

                        //fetching my quote from the schoosen array
                        viewModel.setExcitedQuote()

                    }

                    btnTired.setOnClickListener(){

                        viewModel.setTiredQuote()

                    }

                    btnAnxious.setOnClickListener() {

                        viewModel.setAnxiousQuote()
                    }

                    btnIrritated.setOnClickListener(){

                        viewModel.setIrritatedQuote()

                    }


        //My lifecycleScope for when my text change with a new quote
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect() {
                    tvQuote.text = viewModel.uiState.value.myList.toString()

                }


            }
        }




        return view
    }


}