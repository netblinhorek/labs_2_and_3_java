public interface Handler {
    void handle(Command command, ICpu cpu);
    void setNextHandler(Handler nextHandler);
}
