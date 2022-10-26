package de.hennihaus

import de.hennihaus.plugins.configureMonitoring
import de.hennihaus.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        embeddedServer(CIO, port = 8080, host = "0.0.0.0") { module() }.start(wait = true)
    }
}

fun Application.module() {
    configureMonitoring()
    configureRouting()
}
