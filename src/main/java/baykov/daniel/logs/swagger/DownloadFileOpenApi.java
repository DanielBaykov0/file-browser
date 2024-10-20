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

@Operation(summary = "Download a file",
        description = "Downloads the specified file from the base directory.")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "File downloaded successfully",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "File not found",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                             "status": 1,
                                             "messageCode": "ERROR",
                                             "message": "File does not exist or is a directory",
                                             "path": "C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs\\\\pom.xm",
                                             "isDirectory": false,
                                             "httpStatusCode": 404,
                                             "pageNumber": 0,
                                             "pageSize": 0,
                                             "data": [],
                                             "success": false
                                        }"""
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Internal server error",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                             "status": 1,
                                             "messageCode": "ERROR",
                                             "message": "Required request parameter 'baseDir' for method parameter type String is not present",
                                             "path": null,
                                             "isDirectory": false,
                                             "httpStatusCode": 500,
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
public @interface DownloadFileOpenApi {
}
