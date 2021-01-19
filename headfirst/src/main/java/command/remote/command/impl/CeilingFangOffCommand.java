package command.remote.command.impl;

import command.remote.command.CeilingFan;
import command.remote.command.Command;

public class CeilingFangOffCommand implements Command {

    private CeilingFan ceilingFan;

    public CeilingFangOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.high();
    }
}
