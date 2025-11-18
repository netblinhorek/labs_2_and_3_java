import java.util.*;

public class Main {
    public static void main(String[] args) {

        Program prog = new Program();

        prog.add(new Command("init", "10", "20"));
        prog.add(new Command("init", "11", "25"));
        prog.add(new Command("ld", "a", "10"));

        prog.add(new Command("ld", "b", "11"));
        prog.add(new Command("ld", "c", "11"));
        prog.add(new Command("add"));

        prog.add(new Command("mv", "a", "d"));
        prog.add(new Command("add"));

        prog.add(new Command("print"));

        System.out.println("Commands in program:");
        for (Command c : prog) {
            System.out.println(c);
        }
        System.out.println();

        System.out.println("Популярная инструкция " + prog.mostPopularInstruction());
        System.out.println("Диапазон адресов памяти " + prog.getMemoryAddressRange());
        System.out.println("Инструкции с разбивкой по частоте " + prog.getInstructionsByFrequency());
        System.out.println();

        ICpu cpu = new SimpleCpu();
        Executer exec = new Executer(cpu);

        exec.run(prog);
    }
}