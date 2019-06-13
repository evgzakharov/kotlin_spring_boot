package test.kotlin.spring.project

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

interface Response {
    val status: Boolean
}

data class MessageResponse(
    val result: String,
    val message: String? = null,
    override val status: Boolean = true
) : Response

data class ValuesResponse(
    val values: List<Long>,
    override val status: Boolean = true
) : Response

@RestController
class ServiceController {
    @GetMapping("/hello")
    fun hello(
        @RequestParam(value = "name") name: String,
        @RequestParam(value = "surname", required = false) surname: String?
    ): Response {
        return if (surname == null)
            MessageResponse(result = "Hi $name", message = "surname is empty")
        else
            MessageResponse(result = "Hi $surname,$name")
    }

    @GetMapping("/sort")
    fun sort(@RequestParam(value = "values") values: List<Long>): Response {
        println("values:")

        return ValuesResponse(values = values.sorted())
    }
}
