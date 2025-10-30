package com.example.littlelemon.destinations

interface Destinations {
    val route: String;
}

object Onboarding : Destinations {
    override val route: String = "onboarding";
}

object Home : Destinations {
    override val route: String = "home";
}

object Profile : Destinations {
    override val route: String = "profile";
}