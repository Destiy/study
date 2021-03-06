package command.remote;

import command.remote.command.Command;
import command.remote.command.impl.NoCommand;

import java.util.Arrays;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        this.onCommands[slot].execute();
        this.undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        this.offCommands[slot].execute();
        this.undoCommand = onCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }
    @Override
    public String toString() {
        System.out.println("------------ remote control -----------\n");
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
