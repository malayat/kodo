package solmedia.ec.kodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import solmedia.ec.kodo.controller.TodoController
import solmedia.ec.kodo.model.TodoDao
import solmedia.ec.kodo.service.TodoService
import javax.faces.webapp.FacesServlet

@SpringBootApplication
@ComponentScan(basePackageClasses = [TodoController::class, TodoService::class, TodoDao::class])
class KodoApplication : SpringBootServletInitializer() {

    @Bean
    fun servletRegistrationBean(): ServletRegistrationBean<*> {
        val servlet = FacesServlet()
        return ServletRegistrationBean(servlet, "*.jsf")
    }
}

fun main(args: Array<String>) {
    runApplication<KodoApplication>(*args)
}
