package command;

import java.util.concurrent.ThreadFactory;

class Stereo {

    public void on() {
        System.out.println("stereo on");
    }

    public void off() {
        System.out.println("stereo off");
    }
}

// receiver
class Light {

    boolean isOn;

    public Light() {
        this.isOn = false;
    }

    public void on() {
        if (isOn) {
            System.out.println("light already on");
        } else {
            System.out.println("light is turned on");
            isOn = true;
        }

    }

    public void off() {
        if (!isOn) {
            System.out.println("light already off");
        } else {
            System.out.println("light is turned off");
            isOn = false;
        }
    }
}

interface Command {
    public void execute();

    // public void undo();
}

// class LightOnCommand implements Command {

// Light light;

// public LightOnCommand(Light light) {
// // System.out.println("light on command");
// this.light = light;
// }

// @Override
// public void execute() {
// light.on();
// }

// @Override
// public void undo() {
// light.off();
// }

// }

class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        // System.out.println("light off command");
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    // @Override
    // public void undo() {
    // light.on();
    // }

}

// receiver
class GarageDoor {
    void up() {
        System.out.println("raising the door up");
    }

    void down() {
        System.out.println("lowering the door down");
    }

    void stop() {
        System.out.println("stop");
    }

    void lightOn() {
        System.out.println("turn on the light");
    }

    void lightOff() {
        System.out.println("turn off the light");
    }
}

class GarageDoorOpen implements Command {
    GarageDoor gd;

    public GarageDoorOpen(GarageDoor gd) {
        // System.out.println("open garage command");
        this.gd = gd;
    }

    @Override
    public void execute() {
        this.gd.up();
        this.gd.stop();
        this.gd.lightOn();
    }

    // @Override
    // public void undo() {
    // this.gd.lightOff();
    // this.gd.down();
    // this.gd.stop();
    // }

}

class GarageDoorClose implements Command {
    GarageDoor gd;

    public GarageDoorClose(GarageDoor gd) {
        // System.out.println("close garagecommand");
        this.gd = gd;
    }

    @Override
    public void execute() {
        this.gd.lightOff();
        this.gd.down();
        this.gd.stop();
    }

    // @Override
    // public void undo() {
    // this.gd.up();
    // this.gd.stop();
    // this.gd.lightOn();
    // }
}

class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("doing nothing ... assign me a command");
    }

    @Override
    public void undo() {
        System.out.println("doing nothing ... assign me a command");

    }
}

class Remote {

    Command[] onCommands;
    Command[] offCommands;
    Command previousCommand;

    public Remote() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < offCommands.length; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onPressed(int slot) {
        onCommands[slot].execute();
        this.previousCommand = offCommands[slot];
    }

    public void offPressed(int slot) {
        offCommands[slot].execute();
        this.previousCommand = onCommands[slot];
    }

    public void undo() {
        if (previousCommand != null) {
            this.previousCommand.undo();
        }

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n===============================================\n");
        for (int i = 0; i < offCommands.length; i++) {
            sb.append("[slot: " + i + "] " + onCommands[i].getClass().getName() + "     "
                    + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
