package com.goforboom.fakturoid.domain.subject

import com.goforboom.fakturoid.Client
import com.goforboom.fakturoid.domain.subject.exceptions.SubjectNotFoundException
import com.goforboom.fakturoid.model.http.RequestMethod
import com.goforboom.fakturoid.model.http.Requester
import com.goforboom.fakturoid.model.mapper.Mapper

class SubjectClient(private val client: Client) {

    fun list(page: Int = 1): List<Subject> {
        val response = Requester.requestJson(
            client = client,
            method = RequestMethod.GET,
            path = "subjects.json",
            query = mapOf(
                "page" to page.toString()
            )
        )


        throw RuntimeException(response.body.toPrettyString())

        return if (response.isSuccess) Mapper.mapToObject<List<Subject>>(response.body) else emptyList()
    }


    @Throws(SubjectNotFoundException::class)
    fun detail(subjectId: Int): Subject {
        val response = Requester.requestJson(
            client = client,
            method = RequestMethod.GET,
            path = "subjects/$subjectId.json"
        )

        if (response.isSuccess) {
            return Mapper.mapToObject<Subject>(response.body)
        } else {
            throw SubjectNotFoundException(subjectId)
        }
    }
}
