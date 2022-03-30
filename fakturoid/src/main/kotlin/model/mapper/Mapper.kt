package model.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kong.unirest.JsonNode

object Mapper {

    val objectMapper = ObjectMapper().registerKotlinModule()

    
    inline fun <reified R> mapToObject(jsonNode: JsonNode): R {
        return objectMapper.readValue(jsonNode.toString(), R::class.java)
    }

}
