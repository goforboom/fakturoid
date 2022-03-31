package com.goforboom.fakturoid.model.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kong.unirest.JsonNode

object Mapper {

    val objectMapper: ObjectMapper = ObjectMapper()
        .registerModule(
            JavaTimeModule()
        )
        .registerModule(
            KotlinModule()
        )

    inline fun <reified R> mapToObject(jsonNode: JsonNode): R {
        return objectMapper.readValue(jsonNode.toString(), R::class.java)
    }

}
