package com.odougle.basic

import org.parceler.Parcel

@Parcel
class Cliente(
    var name: String = "",
    var phoneNumber: String = "",
    var address: String = ""
) {

}