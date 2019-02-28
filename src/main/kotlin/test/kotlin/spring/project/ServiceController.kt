package test.kotlin.spring.project

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

data class AckResponse(val status: Boolean, val result: String, val message: String? = null)

@RestController
open class ServiceController {
    @GetMapping("/request")
    open fun nameRequest(
        @RequestParam(value = "name") name: String,
        @RequestParam(value = "surname", required = false) surname: String?
    ): AckResponse {
        return if (surname == null)
            AckResponse(status = true, result = "Hi $name", message = "surname is empty")
        else
            AckResponse(status = true, result = "Hi $surname,$name")
    }

    @GetMapping("/sort_request")
    open fun findMinimum(@RequestParam(value = "values") values: Array<String>): AckResponse {
        println("values:")
        values.forEach { println(it) }

        val minValue = values.apply { sortBy { it.length } }
            .firstOrNull()
            ?.split("_")
            ?.sorted()
            ?.joinToString(",") ?: ""

        return AckResponse(status = true, result = minValue)
    }
}
