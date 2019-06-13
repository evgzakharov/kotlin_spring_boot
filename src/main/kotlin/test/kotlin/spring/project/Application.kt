package test.kotlin.spring.project

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    println("starting application...")
    SpringApplication.run(Application::class.java, *args)
}
