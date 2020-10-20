package command.remote;

import java.util.GregorianCalendar;

public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light("");
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        simpleRemoteControl.setSlot(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(new GarageDoor(""));
        simpleRemoteControl.setSlot(garageDoorOpenCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
