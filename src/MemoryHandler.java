public class MemoryHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Command command, ICpu cpu) {
        String[] operands = command.get_args();
        String operation = command.get_name();


        switch (operation) {
            case "init":
                cpu.set_memory(Integer.parseInt(operands[0]), Integer.parseInt(operands[1]));
                break;
            case "ld":
                cpu.set_register(operands[0], cpu.get_memory_value(Integer.parseInt(operands[1])));
                break;
            case "st":
                cpu.set_memory(Integer.parseInt(operands[1]), cpu.get_register_value(operands[0]));
                break;
            case "mv":
                cpu.set_register(operands[0], cpu.get_register_value(operands[1]));
                break;
            default:
                if (nextHandler != null) {
                    nextHandler.handle(command, cpu);
                } else {
                    throw new IllegalArgumentException("Неизвестный регистр");
                }
        }
    }
}
