package de.hennihaus

import io.kotest.assertions.ktor.client.shouldHaveStatus
import io.kotest.matchers.shouldBe
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import org.junit.jupiter.api.Test
import java.io.File

class ApplicationTest {

    @Test
    fun `should return 200 and example message when root endpoint is called`() = testApplication {
        application {
            module()
        }

        val response: HttpResponse = client.get(urlString = "")

        response shouldHaveStatus HttpStatusCode.OK
        response.bodyAsText() shouldBe File(SINGLE_PAGE_APPLICATION_PATH).readText()
    }

    @Test
    fun `should return 200 and example message when root endpoint is called with trailing slash`() = testApplication {
        application {
            module()
        }

        val response: HttpResponse = client.get(urlString = "/")

        response shouldHaveStatus HttpStatusCode.OK
        response.bodyAsText() shouldBe File(SINGLE_PAGE_APPLICATION_PATH).readText()
    }

    companion object {
        private const val SINGLE_PAGE_APPLICATION_PATH = "vue-app/index.html"
    }
}
