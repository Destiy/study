package command.remote.command.impl;

import command.remote.command.Command;
import command.remote.command.Light;

public class LivingroomLightOffCommand implements Command {
    private Light light;

    public LivingroomLightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
