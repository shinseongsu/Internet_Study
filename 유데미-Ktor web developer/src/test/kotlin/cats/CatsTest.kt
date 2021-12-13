package cats

import asJson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import mainModule
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CatsTest {

    @Test
    fun `Create cat`() {
        withTestApplication(Application::mainModule) {
            val call = handleRequest(HttpMethod.Post, "/cats") {
                addHeader(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
                setBody(listOf("name" to "Fuzzy", "age" to "3").formUrlEncode())
            }

            Assert.assertEquals(HttpStatusCode.Created, call.response.status())
        }
    }

    @Test
    fun `All cats`() {
        withTestApplication(Application::mainModule) {
            val call = handleRequest(HttpMethod.Get, "/cats")
            assertEquals("[]".asJson(), call.response.content?.asJson())
        }
    }

    @Before
    fun cleanup() {
        print("11111")

        DB.connect()
        transaction {
            SchemaUtils.drop(Cats)
        }
    }

}