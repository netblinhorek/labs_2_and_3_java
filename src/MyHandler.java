import java.util.HashMap;
import java.util.Map;

public class MyHandler {
    private Handler headHandler;

    public MyHandler() {
        Handler arithmeticHandler = new ArithmeticHandler();
        Handler memoryHandler = new MemoryHandler();
        Handler otherHandler = new OtherHandler();

        arithmeticHandler.setNextHandler(memoryHandler);
        memoryHandler.setNextHandler(otherHandler);
        headHandler = arithmeticHandler;
    }

    public void processCommand(Command command, ICpu cpu) {
        if (headHandler != null) {
            headHandler.handle(command, cpu);
        } else {
            throw new IllegalStateException("В цепочки нет обраьотчиков");
        }
    }
}
