import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val port = 8080

    val server = embeddedServer(Netty, port) {
        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
        }

        routing {
            get {
                context.respond(mapOf("Welcome" to "our Cat Hostel"))
            }
            get("/{name}") {
                val name = call.parameters["name"]
                context.respond(mapOf("Cat name:" to name))
            }
        }

    }

    server.start()

}