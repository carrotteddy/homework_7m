package com.example.homework_7m.presentation.screens.doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_7m.R
import com.example.homework_7m.databinding.FragmentDoorsBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DoorsFragment : Fragment() {

    private lateinit var binding : FragmentDoorsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}