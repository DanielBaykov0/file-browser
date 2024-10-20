package baykov.daniel.logs.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Operation(summary = "Check if path is a directory",
        description = "Checks if the given path is a directory.")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Path exists and is a directory or not",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                            "status": 0,
                                            "messageCode": "SUCCESS",
                                            "message": "C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs",
                                            "path": null,
                                            "isDirectory": true,
                                            "httpStatusCode": 200,
                                            "pageNumber": 0,
                                            "pageSize": 0,
                                            "data": [],
                                            "success": true
                                        }"""
                        )
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Path not found",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                             "status": 1,
                                             "messageCode": "ERROR",
                                             "message": "File or directory not found",
                                             "path": "C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs\\\\xml",
                                             "isDirectory": false,
                                             "httpStatusCode": 404,
                                             "pageNumber": 0,
                                             "pageSize": 0,
                                             "data": [],
                                             "success": false
                                        }"""
                        )
                )
        )
})
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDirectoryOpenApi {
}
