@file:Suppress("unused")

package com.husseinhj.customerinfoapp.data.remote.dto

import com.google.gson.annotations.SerializedName

enum class Sticker {
    @SerializedName("fam", alternate = ["Fam", "FAM"])
    Fam,
    @SerializedName("bam", alternate = ["Ban", "BAN"])
    Ban,
    @SerializedName("other", alternate = ["Other", "OTHER"])
    Other
}
