package com.goforboom.fakturoid

object ClientRequestCatalog {

    object V2 {
        const val BASE = "https://app.fakturoid.cz/api/v2/accounts/{slug}"

        const val SUBJECTS = "subjects.json"
        const val SUBJECTS_DETAIL = "subjects/{subjectId}.json"
    }
}
