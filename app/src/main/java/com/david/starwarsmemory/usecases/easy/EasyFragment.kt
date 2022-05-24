package com.david.starwarsmemory.usecases.easy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.david.starwarsmemory.usecases.OnFragmentActionsListener
import com.david.starwarsmemory.databinding.FragmentEasyBinding


class EasyFragment : Fragment() {

    private var listener: OnFragmentActionsListener? = null
    private var _binding: FragmentEasyBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EasyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEasyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ViewModel
        viewModel = ViewModelProvider(this).get(EasyViewModel::class.java)

        //Setup
        setup()
    }

    private fun setup() {
        viewModel.setupGame(binding, listener!!, resources, requireContext())
        viewModel.setClickableCards(true)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnFragmentActionsListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}