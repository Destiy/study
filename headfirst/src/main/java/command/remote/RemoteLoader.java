package command.remote;

import command.remote.command.CeilingFan;
import command.remote.command.GarageDoor;
import command.remote.command.Light;
import command.remote.command.Stereo;
import command.remote.command.impl.*;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo livingRoomStereo = new Stereo("Living Room");

        // light
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOffCommandOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        // ceiling fan
        CeilingFangOnCommand ceilingFangOn = new CeilingFangOnCommand(ceilingFan);
        CeilingFangOffCommand ceilingFangOff = new CeilingFangOffCommand(ceilingFan);
        // garage door
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
        // stereo
        StereoOnWithCDCommand livingRoomStereoOn = new StereoOnWithCDCommand(livingRoomStereo);
        StereoOffCommand livingRoomStereoOff = new StereoOffCommand(livingRoomStereo);

        remoteControl.setCommand(0, livingRoomLightOn, lightOffCommandOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFangOn, ceilingFangOff);
        remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
        remoteControl.setCommand(4, livingRoomStereoOn, livingRoomStereoOff);

        System.out.println(remoteControl);

        for (int i = 0; i < 5; i++) {
            remoteControl.onButtonWasPressed(i);
            remoteControl.offButtonWasPressed(i);
        }
    }
}
