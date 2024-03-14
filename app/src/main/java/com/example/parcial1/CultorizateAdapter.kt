package com.example.parcial1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CultorizateAdapter (context: Context, cultorizateList: List<CulturizateItem>):

    ArrayAdapter<CulturizateItem>(context, 0, cultorizateList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.culturizate_adapter, parent, false)
        }

        val currentItem = getItem(position)

        val tvAnho = itemView?.findViewById<TextView>(R.id.textViewAnho)
        val tvNombre = itemView?.findViewById<TextView>(R.id.textViewNombre)


        tvAnho?.text = currentItem?.anio_nacimiento
        tvNombre?.text = currentItem?.nombre

        return itemView!!
    }
}