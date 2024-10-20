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

@Operation(summary = "Read file content",
        description = "Reads content from the specified file with pagination.")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "File content retrieved successfully",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                             "status": 0,
                                             "messageCode": "SUCCESS",
                                             "message": null,
                                             "path": "C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs\\\\pom.xml",
                                             "isDirectory": false,
                                             "httpStatusCode": 200,
                                             "pageNumber": 1,
                                             "pageSize": 100,
                                             "data": [
                                                 "<?xml version=\\"1.0\\" encoding=\\"UTF-8\\"?>",
                                                 "<project xmlns=\\"http://maven.apache.org/POM/4.0.0\\" xmlns:xsi=\\"http://www.w3.org/2001/XMLSchema-instance\\"",
                                                 "\\txsi:schemaLocation=\\"http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd\\">",
                                                 "\\t<modelVersion>4.0.0</modelVersion>",
                                                 "",
                                                 "\\t<parent>",
                                                 "\\t\\t<groupId>org.springframework.boot</groupId>",
                                                 "\\t\\t<artifactId>spring-boot-starter-parent</artifactId>",
                                                 "\\t\\t<version>3.3.4</version>",
                                                 "\\t\\t<relativePath/> <!-- lookup parent from repository -->",
                                                 "\\t</parent>",
                                                 "",
                                                 "\\t<groupId>baykov.daniel</groupId>",
                                                 "\\t<artifactId>logs</artifactId>",
                                                 "\\t<version>0.0.1-SNAPSHOT</version>",
                                                 "\\t<packaging>war</packaging>",
                                                 "\\t<name>logs</name>",
                                                 "",
                                                 "\\t<description>Browse and download logs from the server</description>",
                                                 "",
                                                 "\\t<properties>",
                                                 "\\t\\t<java.version>17</java.version>",
                                                 "\\t</properties>",
                                                 "\\t<dependencies>",
                                                 "\\t\\t<dependency>",
                                                 "\\t\\t\\t<groupId>org.springframework.boot</groupId>",
                                                 "\\t\\t\\t<artifactId>spring-boot-starter-web</artifactId>",
                                                 "\\t\\t</dependency>",
                                                 "",
                                                 "\\t\\t<dependency>",
                                                 "\\t\\t\\t<groupId>commons-io</groupId>",
                                                 "\\t\\t\\t<artifactId>commons-io</artifactId>",
                                                 "\\t\\t\\t<version>2.16.1</version>",
                                                 "\\t\\t</dependency>",
                                                 "",
                                                 "\\t\\t<dependency>",
                                                 "\\t\\t\\t<groupId>org.springdoc</groupId>",
                                                 "\\t\\t\\t<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>",
                                                 "\\t\\t\\t<version>2.3.0</version>",
                                                 "\\t\\t</dependency>",
                                                 "",
                                                 "\\t</dependencies>",
                                                 "",
                                                 "\\t<build>",
                                                 "\\t\\t<plugins>",
                                                 "\\t\\t\\t<plugin>",
                                                 "\\t\\t\\t\\t<groupId>org.springframework.boot</groupId>",
                                                 "\\t\\t\\t\\t<artifactId>spring-boot-maven-plugin</artifactId>",
                                                 "\\t\\t\\t</plugin>",
                                                 "\\t\\t</plugins>",
                                                 "\\t</build>",
                                                 "\\t<repositories>",
                                                 "\\t\\t<repository>",
                                                 "\\t\\t\\t<id>maven_central</id>",
                                                 "\\t\\t\\t<name>Maven Central</name>",
                                                 "\\t\\t\\t<url>https://repo.maven.apache.org/maven2/</url>",
                                                 "\\t\\t</repository>",
                                                 "\\t</repositories>",
                                                 "",
                                                 "</project>"
                                             ],
                                             "success": true
                                        }"""
                        )
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
                responseCode = "400",
                description = "File not found",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(
                                example = """
                                        {
                                             "status": 1,
                                             "messageCode": "ERROR",
                                             "message": "Error reading file or directory:",
                                             "path": "C:\\\\Users\\\\DBaykov\\\\IdeaProjects\\\\Java\\\\logs",
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
public @interface ReadFileContentOpenAPi {
}
