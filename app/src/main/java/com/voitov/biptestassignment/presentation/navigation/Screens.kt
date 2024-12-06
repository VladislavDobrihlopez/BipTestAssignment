package com.voitov.biptestassignment.presentation.navigation

sealed class Screen {
    @kotlinx.serialization.Serializable
    data object Meeting : Screen()
}
