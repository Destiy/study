package command.remote.command.impl;

import command.remote.command.Command;
import command.remote.command.Light;

public class LivingroomLightOnCommand implements Command {
    private Light light;

    public LivingroomLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
