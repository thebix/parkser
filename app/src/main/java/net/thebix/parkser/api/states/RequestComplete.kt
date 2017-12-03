package net.thebix.parkser.api.states

data class RequestComplete<T>(var content: T?) : RequestState
