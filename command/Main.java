package command;

class Main {

    public static void main(String[] args) {
        // receivers
        Light light = new Light();
        GarageDoor gd = new GarageDoor();
        Stereo stereo = new Stereo();
        // commands garage
        GarageDoorOpen gdo = new GarageDoorOpen(gd);
        GarageDoorClose gdc = new GarageDoorClose(gd);

        // commands garage
        // LightOnCommand lon = new LightOnCommand(light);
        LightOffCommand lof = new LightOffCommand(light);

        Remote remote = new Remote();
        // System.out.println(remote);

        // remote.setCommand(0, lon, lof);
        // System.out.println(remote);
        // remote.onPressed(0);
        // remote.offPressed(0);
        // remote.onPressed(0);
        remote.setCommand(1, gdo, gdc);
        // System.out.println(remote);
        // System.out.println(remote);
        remote.onPressed(1);
        remote.setCommand(0, () -> {
            light.on();
        }, lof);
        remote.setCommand(2, () -> {
            stereo.on();
        }, () -> {
            stereo.off();
        });
        System.out.println(remote);
        remote.onPressed(0);
        remote.onPressed(2);
        remote.offPressed(2);
        // remote.setCommand(1, lon, lof);

        // System.out.println("\n\n");
        // System.out.println(remote);
        // remote.onPressed(1);
        // remote.offPressed(1);
    }

}
