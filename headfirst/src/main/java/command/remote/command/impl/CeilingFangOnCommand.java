package command.remote.command.impl;

import command.remote.command.CeilingFan;
import command.remote.command.Command;

public class CeilingFangOnCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFangOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.high();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}