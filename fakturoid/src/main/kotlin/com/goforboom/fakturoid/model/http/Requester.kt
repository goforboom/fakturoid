package com.goforboom.fakturoid.model.http

import com.goforboom.fakturoid.Client
import kong.unirest.HttpRequest
import kong.unirest.HttpResponse
import kong.unirest.JsonNode
import kong.unirest.Unirest
import kong.unirest.jackson.JacksonObjectMapper


object Requester {

    /** Build default HTTP client with predefined security headers and request method */
    private fun builder(client: Client, method: RequestMethod, path: String): HttpRequest<*> {
        val apiPath = "https://app.fakturoid.cz/api/v2/accounts/${client.slug}/$path"

        val request = when (method) {
            RequestMethod.GET -> Unirest.get(apiPath)
            RequestMethod.POST -> Unirest.post(apiPath)
        }

        // Associate default headers used in every request
        request
            .basicAuth(client.email, client.apiKey)
            .header("User-Agent", client.apiUserAgent)

        return request
    }


    /** Request JSON endpoint */
    fun requestJson(client: Client, method: RequestMethod, path: String, query: Map<String, String> = emptyMap()): HttpResponse<JsonNode> {
        Unirest.config().objectMapper = JacksonObjectMapper()

        val request = builder(client, method, path)
            .header("Content-Type", "application/json")
            .queryString(query)

        return request.asJson()
    }
}
