package net.thebix.parkser.api.states

data class RequestComplete<out T>(val content: T) : RequestState
