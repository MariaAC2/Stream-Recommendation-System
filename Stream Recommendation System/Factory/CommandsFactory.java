package Factory;

import Commands.*;
public class CommandsFactory {
    public Command getCommand(String command) {
        String[] info = command.split(" ");
        if (info[1].equals("ADD")) {
            return new AddCommand();
        } else if (info[1].equals("LIST")) {
            return new ListCommand();
        } else if (info[1].equals("DELETE")) {
            return new DeleteCommand();
        } else if (info[1].equals("LISTEN")) {
            return new ListenCommand();
        } else if (info[1].equals("RECOMMEND")) {
            return new RecommendCommand();
        } else if (info[1].equals("SURPRISE")){
            return new SurpriseCommand();
        }

        return null;
    }
}
