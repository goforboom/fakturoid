package com.goforboom.fakturoid.domain.subject.exceptions

import com.goforboom.fakturoid.model.http.RequestException

class SubjectNotFoundException(
    val subjectId: String
) : RequestException("Subject with id '$subjectId' was not found")
