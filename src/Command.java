import java.util.Arrays;
public class Command {
    private String name;
    private String[] args;

    public Command(String name, String... args) {
        this.name = name;
        this.args = args;
    }

    public String get_name() {
        return name;
    }

    public String[] get_args() {
        return args;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}