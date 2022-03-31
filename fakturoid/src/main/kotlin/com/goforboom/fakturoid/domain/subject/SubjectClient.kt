package com.goforboom.fakturoid.domain.subject

import com.goforboom.fakturoid.Client
import com.goforboom.fakturoid.ClientRequestCatalog
import com.goforboom.fakturoid.domain.subject.exceptions.SubjectNotFoundException
import com.goforboom.fakturoid.model.http.RequestMethod
import com.goforboom.fakturoid.model.http.Requester
import com.goforboom.fakturoid.model.mapper.Mapper

class SubjectClient(private val client: Client) {
    
    fun create(subject: BaseSubject): Subject {
        val response = Requester.requestJson(
            client = client,
            method = RequestMethod.POST,
            body = subject,
            path = ClientRequestCatalog.V2.SUBJECTS
        )

        if (response.isSuccess) {
            return Mapper.mapToObject(response.body)
        } else {
            TODO("Implement errors for wrong request body")
        }
    }


    fun list(page: Int = 1): List<Subject> {
        val response = Requester.requestJson(
            client = client,
            method = RequestMethod.GET,
            path = ClientRequestCatalog.V2.SUBJECTS,
            query = mapOf(
                "page" to page.toString()
            )
        )

        return if (response.isSuccess) Mapper.mapToObject(response.body) else emptyList()
    }


    @Throws(SubjectNotFoundException::class)
    fun detail(subjectId: String): Subject {
        val response = Requester.requestJson(
            client = client,
            method = RequestMethod.GET,
            path = ClientRequestCatalog.V2.SUBJECTS_DETAIL.replace("{subjectId}", subjectId)
        )

        if (response.isSuccess) {
            return Mapper.mapToObject(response.body)
        } else {
            throw SubjectNotFoundException(subjectId)
        }
    }


    @Throws(SubjectNotFoundException::class)
    fun change(subject: Subject): Subject {
        val response = Requester.requestJson(
            client = client,
            method = RequestMethod.PATCH,
            body = subject,
            path = ClientRequestCatalog.V2.SUBJECTS_DETAIL.replace("{subjectId}", subject.id)
        )

        if (response.isSuccess) {
            return Mapper.mapToObject(response.body)
        } else {
            throw SubjectNotFoundException(subject.id)
        }
    }
}
