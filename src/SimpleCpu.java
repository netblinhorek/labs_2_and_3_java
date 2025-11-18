public class SimpleCpu implements ICpu{
    private int a,b,c,d;
    private int [] memory = new int [1024];
    private MyHandler myHandler;

    public SimpleCpu() {
        this.myHandler = new MyHandler();
    }

    @Override
    public void exec(Command c) {
        myHandler.processCommand(c, this);
    }


    @Override
    public void print_registers() {
        System.out.printf("a=%d b=%d c=%d d=%d%n", a, b, c, d);
    }

    @Override
    public int get_register_value(String register) {
        switch (register) {
            case "a": return a;
            case "b": return b;
            case "c": return c;
            case "d": return d;
            default: throw new IllegalArgumentException("Неизвестный регистр");
        }
    }

    @Override
    public void set_register(String register, int value) {
        switch (register) {
            case "a":
                a = value;
                break;
            case "b":
                b = value;
                break;
            case "c":
                c = value;
                break;
            case "d":
                d = value;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный регистр");
        }
    }

    @Override
    public int get_memory_value(int address) {
        if (address < 0 || address >= memory.length) {
            throw new IllegalArgumentException("Неверное значение памяти");
        }
        return memory[address];
    }

    @Override
    public void set_memory(int address, int value) {
        if (address < 0 || address >= memory.length) {
            throw new IllegalArgumentException("Неверное значение памяти");
        }
        memory[address] = value;
    }
}
