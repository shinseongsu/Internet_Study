package cats

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.catRouter(catsService: CatsService) {
    route("/cats") {
        post {
            with(call) {
                val parameters = receiveParameters()
                val name = requireNotNull(parameters["name"])
                val age = parameters["age"]?.toInt()

                catsService.create(name, age)
                call.response.status(HttpStatusCode.Created)
            }
        }

        get {
            call.respond(catsService.all())
        }
    }
}