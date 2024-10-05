package com.kikepb7.dragonballapp.domain.common

sealed class FailureDomain {
    data object ApiError : FailureDomain()
    data object Unauthorized : FailureDomain()
    data object UnknownHostError : FailureDomain()
}