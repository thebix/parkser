package net.thebix.parkser.api.states

data class RequestError(val error: Throwable) : RequestState
