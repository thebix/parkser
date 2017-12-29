package net.thebix.parkser.api.states

interface RequestState

class RequestStart : RequestState
data class RequestError(val error: Throwable) : RequestState
data class RequestComplete<T>(var content: T?) : RequestState
