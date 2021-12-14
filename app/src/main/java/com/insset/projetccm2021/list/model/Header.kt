package com.insset.projetccm2021.list.model

sealed class MyObjectForRecyclerView(
    open val timestamp: Long
)

data class Header(
    val header: String
): MyObjectForRecyclerView(System.currentTimeMillis())
