package baykov.daniel.logs.service;

import baykov.daniel.logs.model.ResponseMessage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileBrowserService {

    @Value("${app.root.path}")
    private String rootPath;

    public ResponseMessage listFilesAndDirectories(String relativePath) throws FileNotFoundException {
        Path absolutePath = getAbsolutePath(relativePath);

        File folder = absolutePath.toFile();
        List<String> filesAndDirectories = new ArrayList<>();

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    filesAndDirectories.add(file.getName() + (file.isDirectory() ? FileSystems.getDefault().getSeparator() : ""));
                }
            }
        } else {
            throw new IllegalArgumentException("The specified path does not exist: " + absolutePath);
        }

        return ResponseMessage.success(
                absolutePath.toString(),
                filesAndDirectories
        );
    }

    public ResponseMessage readFileContent(String relativePath, int pageNumber, int pageSize) throws IOException {
        Path absolutePath = getAbsolutePath(relativePath);
        File file = absolutePath.toFile();

        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException(absolutePath.toString());
        }

        List<String> lines = new ArrayList<>();
        try (LineIterator it = FileUtils.lineIterator(file, StandardCharsets.UTF_8.name())) {
            int startLine = (pageNumber - 1) * pageSize;
            int endLine = startLine + pageSize;

            int currentLine = 0;
            while (it.hasNext()) {
                String line = it.nextLine();
                if (currentLine >= startLine && currentLine < endLine) {
                    lines.add(line);
                }

                currentLine++;

                if (currentLine >= endLine) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new IOException(absolutePath.toString());
        }

        return ResponseMessage.success(
                absolutePath.toString(),
                pageNumber,
                pageSize,
                lines
        );
    }

    public Resource downloadFile(String baseDir, String filePath) throws IOException {
        baseDir = baseDir.replace("\\", FileSystems.getDefault().getSeparator());

        if (!isPathSafe(baseDir, filePath)) {
            throw new IllegalArgumentException("Invalid path: " + filePath);
        }

        File file = new File(baseDir, filePath);

        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }

        return new FileSystemResource(file);
    }

    public ResponseMessage isDirectory(String relativePath) throws NoSuchFileException {
        Path absolutePath = getAbsolutePath(relativePath);

        if (!Files.exists(absolutePath)) {
            throw new NoSuchFileException(absolutePath.toString());
        }

        return ResponseMessage.success(absolutePath.toString(), Files.isDirectory(absolutePath));
    }

    private Path getAbsolutePath(String relativePath) {
        Path absolutePath = Path.of(rootPath).normalize();
        if (relativePath != null && !relativePath.isEmpty()) {
            absolutePath = absolutePath.resolve(relativePath).normalize();

            // Check for upward traversal
//            if (relativePath.contains("..")) {
//                throw new IllegalArgumentException("Invalid relative path: " + relativePath);
//            }
        }

        return absolutePath;
    }

    private boolean isPathSafe(String baseDir, String filePath) throws IOException {
        return
                // Check for upward traversal
//                !filePath.contains("..") &&
                !filePath.startsWith(FileSystems.getDefault().getSeparator()) &&
                        new File(baseDir, filePath).getCanonicalPath().startsWith(new File(baseDir).getCanonicalPath());
    }
}
