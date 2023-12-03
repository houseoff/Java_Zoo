import ru.gb.zoo.models.animals.commands.Commands;

public class Main {
    public static void main(String[] args) {
        Commands commands = new Commands();
        commands.add("First String");
        commands.add("Second String");
        System.out.println(commands);
    }
}