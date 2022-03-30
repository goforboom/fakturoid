package domain.subject

import Client
import domain.subject.exceptions.SubjectNotFoundException
import model.http.RequestMethod
import model.http.Requester
import model.mapper.Mapper

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
