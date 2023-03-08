package com.example.blockcipher.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.blockcipher.R


class EncryptMessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_encrypt_message, container, false)

        val cipherName = arguments?.getString("cipher")
        requireActivity().title = "Encrypt using $cipherName" // Set title of fragment

        val messageEditText = view.findViewById<EditText>(R.id.message_edit)
        val keyEditText = view.findViewById<EditText>(R.id.key)
        val encryptButton = view.findViewById<Button>(R.id.btn_encrypt)
        val resultTextView = view.findViewById<TextView>(R.id.result)

        encryptButton.setOnClickListener {
            val message = messageEditText.text.toString()
            val key = keyEditText.text.toString()

            // Call the cipher function with message and key
            val result = when (cipherName) {
                "AES" -> aesCipher(message, key)
                "DES" -> desCipher(message, key)
                "TripleDES" -> tripleDesCipher(message, key)
                else -> "Invalid cipher"
            }

            resultTextView.text = result
        }



        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Link the ActionBar to the NavController
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun aesCipher(message: String, key: String): String {
        // Implement AES cipher function here
        return "aes"
    }

    private fun desCipher(message: String, key: String): String {
        // Implement DES cipher function here
        return "des"
    }

    private fun tripleDesCipher(message: String, key: String): String {
        // Implement Triple DES cipher function here
        return "trip"
    }
}
