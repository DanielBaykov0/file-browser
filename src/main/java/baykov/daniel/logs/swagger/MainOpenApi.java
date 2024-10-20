package baykov.daniel.logs.swagger;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@OpenAPIDefinition(info = @Info(
        title = "Spring Boot listing, reading and downloading files APIs",
        description = "Spring Boot File Browser App REST APIs Documentation",
        version = "v1.0",
        contact = @Contact(
                name = "Daniel",
                email = "danibaikov@gmail.com"
        )
),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot File Browser App Documentation",
                url = "https://github.com/DanielBaykov0/file-browser"
        )
)
@Documented
@Target({ TYPE })
@Retention(RUNTIME)
public @interface MainOpenApi {
}
