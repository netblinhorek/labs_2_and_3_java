import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Program implements Iterable<Command> {
    private List<Command> commands;

    public Program() {
        this.commands = new ArrayList<>();
    }

    public void add(Command command) {
        this.commands.add(command);
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    public String mostPopularInstruction() {
        return commands.stream()
                .collect(Collectors.groupingBy(Command::get_name, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    public String getMemoryAddressRange() {
        List<Integer> addresses = commands.stream()
                .filter(command -> command.get_name().equals("init") || command.get_name().equals("ld"))
                .flatMap(command -> Arrays.stream(command.get_args()))
                .map(arg -> {
                    try {
                        return Integer.parseInt(arg);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(java.util.Objects::nonNull)
                .collect(Collectors.toList());

        if (addresses.isEmpty()) {
            return "Нет свободной памяти";
        }

        int minAddress = Collections.min(addresses);
        int maxAddress = Collections.max(addresses);

        return minAddress + "-" + maxAddress;
    }

    public List<String> getInstructionsByFrequency() {
        return commands.stream()
                .collect(Collectors.groupingBy(Command::get_name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
