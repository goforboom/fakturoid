package com.goforboom.fakturoid.domain.subject

import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL

open class BaseSubject(
    open var name: String
) {
    @field:JsonProperty("custom_id")
    var customId: URL? = null

    @field:JsonProperty("enabled_reminders")
    var reminders: Boolean = true

    var type: SubjectType = SubjectType.customer

    // ---
    // Business info
    // ---

    @field:JsonProperty("full_name")
    var fullName: String? = null

    var phone: String? = null
    var web: String? = null
    var email: String? = null

    @field:JsonProperty("email_copy")
    var emailCopy: String? = null

    @field:JsonProperty("private_note")
    var privateNote: String? = null

    @field:JsonProperty("registration_no")
    var registrationNumber: String? = null

    @field:JsonProperty("vat_no")
    var vatNumber: String? = null

    @field:JsonProperty("local_vat_no")
    var localVatNo: String? = null

    // ---
    // Address
    // ---

    var country: String? = null
    var city: String? = null
    var zip: String? = null
    var street: String? = null
    var street2: String? = null

    // ---
    // Bank
    // ---
    @field:JsonProperty("bank_account")
    var bankAccount: String? = null

    @field:JsonProperty("variable_symbol")
    var variableSymbol: String? = null

    var iban: String? = null
}
