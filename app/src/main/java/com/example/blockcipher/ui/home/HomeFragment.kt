package com.example.blockcipher.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blockcipher.R
import com.example.blockcipher.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var cipherAdapter: CipherAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        //val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val cipherList = listOf("AES", "DES", "TripleDES") // Replace with your list of ciphers
        cipherAdapter = CipherAdapter(cipherList)
        recyclerView.adapter = cipherAdapter

        //val actionBar = supportFragmentManager.findFragmentById
        return root
    }

    fun onCipherClick(cipherName: String) {
        val fragment = EncryptMessageFragment()
        val args = Bundle()
        args.putString("cipher", cipherName)
        fragment.arguments = args

        parentFragmentManager.beginTransaction()
            .replace(R.id.mobile_navigation, fragment)
            .addToBackStack(null)
            .commit()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}