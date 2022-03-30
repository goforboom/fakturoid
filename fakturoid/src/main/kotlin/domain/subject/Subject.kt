package domain.subject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Subject(
    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("custom_id")
    val customId: String?,

    val type: SubjectType,

    @field:JsonProperty("html_url")
    val urlHtml: String,

    @field:JsonProperty("url")
    val url: String,

    @field:JsonProperty("updated_at")
    val updatedAt: String,

    @field:JsonProperty("created_at")
    val createdAt: String,

    // ---
    // Business info
    // ---

    @field:JsonProperty("full_name")
    val fullName: String?,

    val name: String,
    val phone: String?,
    val web: String?,
    val email: String,

    @field:JsonProperty("email_copy")
    val emailCopy: String?,

    @field:JsonProperty("private_note")
    val privateNote: String?,

    @field:JsonProperty("registration_no")
    val registrationNumber: String?,

    @field:JsonProperty("vat_no")
    val vatNumber: String?,

    // ---
    // Address
    // ---

    val city: String?,
    val zip: String?,
    val country: String?,

    // ---
    // Bank
    // ---

    @field:JsonProperty("bank_account")
    val bankAccount: String?,

    @field:JsonProperty("variable_symbol")
    val variableSymbol: String?,

    val iban: String?,


    val enabled_reminders: Boolean,
    val local_vat_no: String,

    val street2: String?,
    val street: String?,

    val avatar_url: String?


)
