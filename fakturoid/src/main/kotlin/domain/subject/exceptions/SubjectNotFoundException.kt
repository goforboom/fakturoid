package domain.subject.exceptions

import model.http.RequestException

class SubjectNotFoundException(
    val subjectId: Int
) : RequestException("Subject with id '$subjectId' was not found")
