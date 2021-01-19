package command.remote;

import command.remote.command.GarageDoor;
import command.remote.command.Light;
import command.remote.command.impl.GarageDoorUpCommand;
import command.remote.command.impl.LightOnCommand;

public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light("");
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        simpleRemoteControl.setSlot(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();

        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(new GarageDoor(""));
        simpleRemoteControl.setSlot(garageDoorUpCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
