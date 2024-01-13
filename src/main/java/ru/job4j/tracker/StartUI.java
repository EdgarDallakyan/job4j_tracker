package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import java.util.List;
import java.util.ArrayList;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Меню:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Create(output));
        actions.add(new FindAll(output));
        actions.add(new Replace(output));
        actions.add(new Delete(output));
        actions.add(new FindById(output));
        actions.add(new FindByName(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }
}