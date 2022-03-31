package unit

import com.goforboom.fakturoid.domain.subject.Subject
import com.goforboom.fakturoid.model.mapper.Mapper
import kong.unirest.JsonNode
import org.junit.Assert
import org.junit.Test
import utils.FileLoader
import java.net.URL
import java.time.ZoneId
import java.time.ZonedDateTime

class JacksonMapperUnitTest {

    @Test
    fun testLoadProperJsonToValueObject() {
        val subjectJson = FileLoader.loadResourceFile("mocks/responses/subject.json")
        val subjectJsonNode = JsonNode(subjectJson)

        val finalSubject = Mapper.mapToObject<Subject>(subjectJsonNode)

        // Try to assert nullable, datetime, URL objects to check if Jackson works well
        Assert.assertEquals("11430347", finalSubject.id)
        Assert.assertEquals(null, finalSubject.avatar)
        Assert.assertEquals(URL("https://app.fakturoid.cz/api/v2/accounts/example/subjects/11430347.json"), finalSubject.url)
        Assert.assertEquals(
            ZonedDateTime.of(
                2021, 1, 22, 14, 35, 46, 0, ZoneId.of("UTC")
            ),
            finalSubject.createdAt
        )
    }


    @Test
    fun testLoadLJsonListValuesToValueObjects() {
        val subjectsJson = FileLoader.loadResourceFile("mocks/responses/subjects.json")
        val subjectsJsonNode = JsonNode(subjectsJson)

        val subjects = Mapper.mapToObject<List<Subject>>(subjectsJsonNode)

        Assert.assertEquals(3, subjects.size)
        Assert.assertEquals("Alza.cz a.s.", subjects[0].name)
        Assert.assertEquals("Fakturoid s.r.o.", subjects[1].name)
        Assert.assertEquals("IKEA Česká republika, s.r.o.", subjects[2].name)
    }

}
