package com.odougle.basic

import org.parceler.Parcel

@Parcel
data class Cliente(
    var name: String = "",
    var age: Int = 0
)