public class OtherHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Command command, ICpu cpu) {
        String operation = command.get_name();


        switch (operation) {
            case "print":
                cpu.print_registers();
                break;
            default:
                if (nextHandler != null) {
                    nextHandler.handle(command, cpu);
                } else {
                    throw new IllegalArgumentException("Неизвестная команда");
                }
        }
    }
}
