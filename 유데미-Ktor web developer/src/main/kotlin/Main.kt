import cats.Cats
import cats.CatsServiceDB
import cats.catRouter
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    val port = 8080

    val server = embeddedServer(Netty, port, module = Application::mainModule)

    server.start()
}

fun Application.mainModule() {

    DB.connect()

    transaction {
        SchemaUtils.create(Cats)
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        trace {
            application.log.debug(it.buildText())
        }

        get {
            context.respond(mapOf("Welcome" to "our Cat Hostel"))
        }

        catRouter(CatsServiceDB())
    }
}