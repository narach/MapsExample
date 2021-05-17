package com.example.mapsexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.mapsexample.place.Place
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class MarkerInfoWindowAdapter(
    private val context: Context
) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(marker: Marker?): View? {
        val place = marker?.tag as? Place ?: return null

        val view = LayoutInflater.from(context).inflate(
            R.layout.marker_info_contents, null
        )

        view.findViewById<TextView>(
            R.id.text_view_title
        ).text = place.name
        view.findViewById<TextView>(
            R.id.text_view_address
        ).text = place.address
        view.findViewById<TextView>(
            R.id.text_view_rating
        ).text = "Rating: %.2f".format(place.rating)

        return view
    }

    override fun getInfoWindow(p0: Marker): View? {
        return null
    }

}