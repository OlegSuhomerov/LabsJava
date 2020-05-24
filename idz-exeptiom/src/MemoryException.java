import java.io.IOException;

public class MemoryException extends IOException {
    public MemoryException() {

    }

    public MemoryException(String msg) {
        super(msg);
    }
}
