package com.goforboom.fakturoid

data class Client(
    val slug: String,
    val email: String,

    val apiKey: String,
    val apiUserAgent: String,
    val apiVersion: ClientVersion
)
