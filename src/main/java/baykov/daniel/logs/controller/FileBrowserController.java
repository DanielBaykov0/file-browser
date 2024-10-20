package baykov.daniel.logs.controller;

import baykov.daniel.logs.model.ResponseMessage;
import baykov.daniel.logs.service.FileBrowserService;
import baykov.daniel.logs.swagger.DownloadFileOpenApi;
import baykov.daniel.logs.swagger.IsDirectoryOpenApi;
import baykov.daniel.logs.swagger.ListFilesAndDirectoriesOpenApi;
import baykov.daniel.logs.swagger.ReadFileContentOpenAPi;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/file-browser")
@Tag(name = "File Operations", description = "Rest APIs for listing, reading, and downloading files")
public class FileBrowserController {

    private final FileBrowserService fileBrowserService;

    public FileBrowserController(FileBrowserService fileBrowserService) {
        this.fileBrowserService = fileBrowserService;
    }

    @ListFilesAndDirectoriesOpenApi
    @GetMapping("/list")
    public ResponseEntity<ResponseMessage> listFilesAndDirectories(
            @RequestParam(required = false) String path) throws FileNotFoundException {
        return ResponseEntity.ok(fileBrowserService.listFilesAndDirectories(path));
    }

    @ReadFileContentOpenAPi
    @GetMapping("/read")
    public ResponseEntity<ResponseMessage> readFileContent(
            @RequestParam(required = false) String path,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "100") int pageSize) throws IOException {
        return ResponseEntity.ok(fileBrowserService.readFileContent(path, pageNumber, pageSize));
    }

    @IsDirectoryOpenApi
    @GetMapping("/is-directory")
    public ResponseEntity<ResponseMessage> isDirectory(@RequestParam(required = false) String path) throws NoSuchFileException {
        return ResponseEntity.ok(fileBrowserService.isDirectory(path));
    }

    @DownloadFileOpenApi
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam String baseDir, @RequestParam String filePath) throws IOException {
        Resource file = fileBrowserService.downloadFile(baseDir, filePath);

        HttpHeaders headers = new HttpHeaders();
        String filename = file.getFilename() != null ? file.getFilename() : "default_filename.txt";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + URLEncoder.encode(timestamp + "_" + filename.replace("\\", FileSystems.getDefault().getSeparator()), StandardCharsets.UTF_8));

        return ResponseEntity.ok().headers(headers).contentLength(file.contentLength()).body(file);
    }
}
