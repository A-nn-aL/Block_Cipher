package com.example.blockcipher.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.blockcipher.R

class CipherAdapter(val cipherList: List<String>) : RecyclerView.Adapter<CipherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cipherButton: Button = itemView.findViewById(R.id.cipher_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cipher_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cipher = cipherList[position]

        // Set the text of the cipherButton to the cipher name
        holder.cipherButton.text = cipher

        // Add an OnClickListener to the cipherButton
        holder.cipherButton.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToEncryptMessageFragment(cipher)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = cipherList.size
}


interface OnCipherClickListener {
    fun onCipherClick(cipherName: String)
}