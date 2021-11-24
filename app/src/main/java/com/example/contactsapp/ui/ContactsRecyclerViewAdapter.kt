package com.example.contactsapp.ui

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.Data.ContactsData
import com.example.contactsapp.databinding.ContactsRecyclerViewBinding
import com.example.contactsapp.databinding.FragmentContactsBinding
import com.google.firebase.database.core.Context
import kotlin.coroutines.coroutineContext


class ContactsRecyclerViewAdapter:RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> (){

    val contacts = mutableListOf<ContactsData>()

    inner class ViewHolder(val binding: ContactsRecyclerViewBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContactsRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   holder.binding.nameTextView.text= contacts[ position].fullName
        holder.binding.numberTextView.text= contacts[ position].phoneNumber

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun addContact(contact: ContactsData){
        if(!contacts.contains(contact)){
             contacts.add(contact)
        }else{
            val index = contacts.indexOf(contact)

            if(contact.isDeleted){
                contacts.removeAt(index)
            }else{
                contacts[index] =  contact
            }

        }

        notifyDataSetChanged()

    }
}