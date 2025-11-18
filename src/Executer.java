public class Executer{
    private ICpu cpu;

    public Executer(ICpu cpu) {
        this.cpu = cpu;
    }


    public void run(Program program) {
        for (Command command : program) {
          //  System.out.println(command.toString());
            cpu.exec(command);
        }
    }
}