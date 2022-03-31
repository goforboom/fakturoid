package com.goforboom.fakturoid.domain.subject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL
import java.time.ZonedDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
class Subject(
    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("custom_id")
    val customId: URL?,

    @field:JsonProperty("enabled_reminders")
    val reminders: Boolean,

    val type: SubjectType,

    @field:JsonProperty("html_url")
    val urlHtml: URL,

    @field:JsonProperty("url")
    val url: URL,

    @field:JsonProperty("updated_at")
    val updatedAt: ZonedDateTime,

    @field:JsonProperty("created_at")
    val createdAt: ZonedDateTime,

    // ---
    // Business info
    // ---

    @field:JsonProperty("full_name")
    val fullName: String?,

    val name: String,
    val phone: String?,
    val web: String?,
    val email: String,

    @field:JsonProperty("avatar_url")
    val avatar: URL?,

    @field:JsonProperty("email_copy")
    val emailCopy: String?,

    @field:JsonProperty("private_note")
    val privateNote: String?,

    @field:JsonProperty("registration_no")
    val registrationNumber: String?,

    @field:JsonProperty("vat_no")
    val vatNumber: String?,

    @field:JsonProperty("local_vat_no")
    val localVatNo: String,

    // ---
    // Address
    // ---

    val country: String?,
    val city: String?,
    val zip: String?,
    val street: String?,
    val street2: String?,

    // ---
    // Bank
    // ---

    @field:JsonProperty("bank_account")
    val bankAccount: String?,

    @field:JsonProperty("variable_symbol")
    val variableSymbol: String?,

    val iban: String?
)
