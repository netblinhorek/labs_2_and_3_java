public class ArithmeticHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Command command, ICpu cpu) {
        String operation = command.get_name();



        int valA = cpu.get_register_value("a");
        int valB = cpu.get_register_value("b");


        switch (operation) {
            case "add":
                cpu.set_register("d", valA + valB);
                break;
            case "div":
                if (valB == 0) {
                    throw new IllegalArgumentException("Нклья делить на ноль b = 0");
                }
                cpu.set_register("d", valA / valB);
                break;
            case "sub":
                cpu.set_register("d", valA - valB);
                break;
            case "mult":
                cpu.set_register("d", valA * valB);
                break;
            default:
                if (nextHandler != null) {
                    nextHandler.handle(command, cpu);
                } else {
                    throw new IllegalArgumentException("Неизвестная команда ");
                }
        }
    }
}
