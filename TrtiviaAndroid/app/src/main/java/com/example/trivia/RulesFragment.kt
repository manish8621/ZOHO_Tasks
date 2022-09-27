package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trivia.databinding.FragmentGameOverBinding
import com.example.trivia.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {
    lateinit var binding: FragmentRulesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRulesBinding.inflate(inflater,container,false)
        return binding.root
    }

}