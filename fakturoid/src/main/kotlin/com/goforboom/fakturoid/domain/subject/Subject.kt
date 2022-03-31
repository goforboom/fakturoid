package com.goforboom.fakturoid.domain.subject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL
import java.time.ZonedDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
class Subject(

    override var name: String,

    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("html_url")
    val urlHtml: URL,

    @field:JsonProperty("url")
    val url: URL,

    @field:JsonProperty("avatar_url")
    val avatar: URL? = null,

    @field:JsonProperty("created_at")
    val createdAt: ZonedDateTime,

    @field:JsonProperty("updated_at")
    val updatedAt: ZonedDateTime

) : BaseSubject(name)
