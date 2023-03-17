package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.lab2.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAboutBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        val btnHome = binding.btnGoToHome

        val btnNewsletter = binding.btnGoToSignUpNewsletter

        //onClick to remove my fragment from the stack to go back to main
        btnHome.setOnClickListener(){
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        btnNewsletter.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_aboutFragment_to_newsletterFragment)
        }

        return view
    }

}