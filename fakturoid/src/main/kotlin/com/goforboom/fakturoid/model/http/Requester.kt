package com.goforboom.fakturoid.model.http

import com.goforboom.fakturoid.Client
import com.goforboom.fakturoid.ClientRequestCatalog
import com.goforboom.fakturoid.model.mapper.Mapper
import kong.unirest.*
import kong.unirest.jackson.JacksonObjectMapper

object Requester {

    /** Build default HTTP client with predefined security headers and request method */
    private fun builder(client: Client, method: RequestMethod, path: String): HttpRequest<*> {
        val basePath = ClientRequestCatalog.V2.BASE.replace("{slug}", client.slug)
        val apiPath = "$basePath/$path"

        val request = when (method) {
            RequestMethod.GET -> Unirest.get(apiPath)
            RequestMethod.POST -> Unirest.post(apiPath)
            RequestMethod.PATCH -> Unirest.patch(apiPath)
        }

        // Associate default headers used in every request
        request
            .basicAuth(client.email, client.apiKey)
            .header("User-Agent", client.apiUserAgent)
            .withObjectMapper(
                JacksonObjectMapper(Mapper.objectMapper)
            )

        return request
    }


    /** Request JSON endpoint */
    fun requestJson(
        client: Client,
        method: RequestMethod,
        path: String,
        query: Map<String, String> = emptyMap(),
        body: Any? = null
    ): HttpResponse<JsonNode> {
        Unirest.config().objectMapper = JacksonObjectMapper()

        val request = builder(client, method, path)
            .header("Content-Type", "application/json")
            .queryString(query)

        if (request is HttpRequestWithBody && body !== null) {
            return request.body(body).asJson()
        }

        return request.asJson()
    }
}
