package de.hennihaus.plugins

import de.hennihaus.configuration.Configuration.SINGLE_PAGE_APPLICATION_PATH
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.http.content.singlePageApplication
import io.ktor.server.http.content.vue
import io.ktor.server.routing.IgnoreTrailingSlash
import io.ktor.server.routing.Routing

fun Application.configureRouting() {
    install(plugin = IgnoreTrailingSlash)
    install(plugin = Routing) {
        singlePageApplication {
            vue(filesPath = SINGLE_PAGE_APPLICATION_PATH)
        }
    }
}
