package model.http

open class RequestException(
    override val message: String, source: Throwable? = null
) : RuntimeException(message, source)
