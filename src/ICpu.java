public interface ICpu {
    void exec(Command c);
    void print_registers();
    int get_register_value(String register);
    void set_register(String register, int value);
    int get_memory_value(int address);
    void set_memory(int address, int value);
}
