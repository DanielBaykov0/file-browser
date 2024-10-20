package baykov.daniel.logs.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Operation(summary = "List files and directories",
        description = "Retrieves a list of files and directories at the specified path.")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "List retrieved successfully",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                             "status": 0,
                                             "messageCode": "SUCCESS",
                                             "message": null,
                                             "path": "C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs",
                                             "isDirectory": false,
                                             "httpStatusCode": 200,
                                             "pageNumber": 0,
                                             "pageSize": 0,
                                             "data": [
                                                 ".git\\\\",
                                                 ".gitattributes",
                                                 ".gitignore",
                                                 ".idea\\\\",
                                                 ".mvn\\\\",
                                                 "HELP.md",
                                                 "mvnw",
                                                 "mvnw.cmd",
                                                 "pom.xml",
                                                 "src\\\\",
                                                 "target\\\\"
                                             ],
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
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Wrong path",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(
                                        name = "Missing share name",
                                        value = """
                                                {
                                                     "status": 1,
                                                     "messageCode": "ERROR",
                                                     "message": "UNC path is missing sharename: //dsa",
                                                     "path": null,
                                                     "isDirectory": false,
                                                     "httpStatusCode": 400,
                                                     "pageNumber": 0,
                                                     "pageSize": 0,
                                                     "data": [],
                                                     "success": false
                                                }"""
                                ),
                                @ExampleObject(
                                        name = "Specified path does not exist",
                                        value = """
                                                {
                                                     "status": 1,
                                                     "messageCode": "ERROR",
                                                     "message": "The specified path does not exist: C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs\\\\xml",
                                                     "path": null,
                                                     "isDirectory": false,
                                                     "httpStatusCode": 400,
                                                     "pageNumber": 0,
                                                     "pageSize": 0,
                                                     "data": [],
                                                     "success": false
                                                }"""
                                )
                        }
                )
        )
})
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListFilesAndDirectoriesOpenApi {
}
