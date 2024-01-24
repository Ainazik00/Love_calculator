package com.example.homework_2_5m

import java.io.Serializable

data class LoveModel(
    var firstName: String,
    var secondName: String,
    var percentage: String,
    var result: String,
) : Serializable