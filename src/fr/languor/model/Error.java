package fr.languor.model;

public class Error {

    private int line;
    private String message;
    private String value;

    public Error(int line, String message, String value) {
        this.line = line;
        this.message = message;
        this.value = value;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Error{" +
                "line=" + line +
                ", message='" + message + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
