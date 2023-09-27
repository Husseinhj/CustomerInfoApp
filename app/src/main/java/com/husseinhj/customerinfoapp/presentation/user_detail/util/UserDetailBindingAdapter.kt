package com.husseinhj.customerinfoapp.presentation.user_detail.util

import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@BindingAdapter("userLatitude", "userLongitude", requireAll = true)
fun bindingLocation(mapView: MapView, lat: Double, lng: Double) {
    val locationLatLng = LatLng(lat, lng)

    mapView.outlineProvider = ViewOutlineProvider.BACKGROUND
    mapView.clipToOutline = true

    mapView.onCreate(null)
    mapView.getMapAsync { googleMap ->
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(locationLatLng, 18f), 500,null
        )

        googleMap.addMarker(
            MarkerOptions().position(locationLatLng)
        )
    }
}