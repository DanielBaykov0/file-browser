package baykov.daniel.logs.model;


import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ResponseMessage {

    private static final String SUCCESS_CODE = "SUCCESS";
    private static final String ERROR_CODE = "ERROR";
    private static final int STATUS_SUCCESS = 0;
    private static final int STATUS_ERROR = 1;

    private final int status;
    private final String messageCode;
    private final String message;
    private final String path;
    private final boolean isDirectory;
    private final int httpStatusCode;
    private final int pageNumber;
    private final int pageSize;
    private final List<String> data;

    private ResponseMessage(Builder builder) {
        this.status = builder.status;
        this.messageCode = builder.messageCode;
        this.message = builder.message;
        this.path = builder.path;
        this.isDirectory = builder.isDirectory;
        this.httpStatusCode = builder.httpStatusCode;
        this.pageNumber = builder.pageNumber;
        this.pageSize = builder.pageSize;
        this.data = builder.data;
    }

    public static ResponseMessage success() {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .httpStatusCode(HttpStatus.OK.value())
                .build();
    }

    public static ResponseMessage success(String message, boolean isDirectory) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(HttpStatus.OK.value())
                .build();
    }

    public static ResponseMessage success(String path, List<String> data) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .path(path)
                .httpStatusCode(HttpStatus.OK.value())
                .data(data)
                .build();
    }

    public static ResponseMessage success(String messageCode, String message, boolean isDirectory) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(messageCode)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(HttpStatus.OK.value())
                .build();
    }

    public static ResponseMessage success(String message, boolean isDirectory, int httpStatusCode) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(httpStatusCode)
                .build();
    }

    public static ResponseMessage success(String message, String path, List<String> data) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .path(path)
                .httpStatusCode(HttpStatus.OK.value())
                .data(data)
                .build();
    }

    public static ResponseMessage success(String message, boolean isDirectory, int httpStatusCode, List<String> data) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(httpStatusCode)
                .data(data)
                .build();
    }

    public static ResponseMessage success(String message, int pageNumber, int pageSize, List<String> data) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .httpStatusCode(HttpStatus.OK.value())
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .data(data)
                .build();
    }

    public static ResponseMessage success(String message, boolean isDirectory, int pageNumber, int pageSize, List<String> data) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(HttpStatus.OK.value())
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .data(data)
                .build();
    }

    public static ResponseMessage success(String message, boolean isDirectory, int httpStatusCode, int pageNumber, int pageSize, List<String> data) {
        return new Builder()
                .status(STATUS_SUCCESS)
                .messageCode(SUCCESS_CODE)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(httpStatusCode)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .data(data)
                .build();
    }

    public static ResponseMessage error() {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(ERROR_CODE)
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    public static ResponseMessage error(String message) {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(ERROR_CODE)
                .message(message)
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    public static ResponseMessage error(String message, int httpStatusCode) {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(ERROR_CODE)
                .message(message)
                .httpStatusCode(httpStatusCode)
                .build();
    }

    public static ResponseMessage error(String message, boolean isDirectory) {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(ERROR_CODE)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    public static ResponseMessage error(String message, String path, int httpStatusCode) {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(ERROR_CODE)
                .message(message)
                .path(path)
                .httpStatusCode(httpStatusCode)
                .build();
    }

    public static ResponseMessage error(String messageCode, String message, boolean isDirectory) {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(messageCode)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    public static ResponseMessage error(String messageCode, String message, boolean isDirectory, int httpStatusCode) {
        return new Builder()
                .status(STATUS_ERROR)
                .messageCode(messageCode)
                .message(message)
                .isDirectory(isDirectory)
                .httpStatusCode(httpStatusCode)
                .build();
    }

    public boolean isSuccess() {
        return this.status == STATUS_SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<String> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "status=" + status +
                ", messageCode='" + messageCode + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", isDirectory='" + isDirectory + '\'' +
                ", httpStatusCode=" + httpStatusCode +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }

    public static class Builder {

        private int status;
        private String messageCode;
        private String message;
        private String path;
        private boolean isDirectory;
        private int httpStatusCode;
        private int pageNumber;
        private int pageSize;
        private List<String> data = new ArrayList<>();

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder messageCode(String messageCode) {
            this.messageCode = messageCode;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder isDirectory(boolean isDirectory) {
            this.isDirectory = isDirectory;
            return this;
        }

        public Builder httpStatusCode(int httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public Builder pageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder data(List<String> data) {
            this.data = data;
            return this;
        }

        public ResponseMessage build() {
            return new ResponseMessage(this);
        }
    }
}
