package com.audhil.routes

import com.audhil.data.model.Rabbit
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "http://192.168.0.101:8080" //  for running in device
//private const val BASE_URL = "http://10.0.2.2:8080" //  for running in emulator

private val rabbits = listOf(
    Rabbit("Audhil", "Jack and jill went up the hill to fetch a pail of water!", "$BASE_URL/rabbits/rabbit1.jpg"),
    Rabbit("Mohammed", "fetch a pail of water! Jack and jill went up the hill to", "$BASE_URL/rabbits/rabbit2.jpg"),
    Rabbit("Mehtab", "went up the hill to fetch a pail of water!", "$BASE_URL/rabbits/rabbit3.jpg"),
    Rabbit("Hafsa", "pail of water!", "$BASE_URL/rabbits/rabbit4.jpg"),
    Rabbit("Humaira", "went up the hill", "$BASE_URL/rabbits/rabbit5.jpg")
)

fun Route.randomRabbit() {
    get("/randomrabbit") {
//        call.parameters["rabbitId"]   //  for params from user
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )
    }
}