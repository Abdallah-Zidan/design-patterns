package os_example;

import java.util.ArrayList;

/**
 * this is the class which we want to save its state as a snapshot for specified
 * attributes
 */
class OS {
    private ArrayList<String> installedPrograms;
    private String fontFamily;
    private String locale;

    public OS(String fontFamily, String locale, ArrayList<String> installedPrograms) {
        this.installedPrograms = installedPrograms != null ? new ArrayList<>(installedPrograms) : new ArrayList<>();
        this.fontFamily = fontFamily;
        this.locale = locale;
    }

    public OS(String fontFamily, String locale) {
        this(fontFamily, locale, null);
    }

    public void installProgram(String program) {
        this.installedPrograms.add(program);
    }

    public void setFont(String font) {
        this.fontFamily = font;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    class Snapshot {
        private ArrayList<String> installedPrograms;
        private String fontFamily;

        // be sure no one creates a snapshot except our OS
        private Snapshot(String fontFamily, ArrayList<String> installedPrograms) {
            this.fontFamily = fontFamily;
            this.installedPrograms = new ArrayList<>(installedPrograms);
        }
    }

    public void restoreSnapshot(Snapshot sn) {
        this.fontFamily = sn.fontFamily;
        this.installedPrograms = sn.installedPrograms;
    }

    // create a new memento of the current os object state
    public Memento createMemento() {
        Snapshot sn = new Snapshot(this.fontFamily, this.installedPrograms);
        return new Memento(this, sn);
    }

    @Override
    public String toString() {
        String description = "\nCurrent os description : \nFont family : " + this.fontFamily + "\nlocale : "
                + this.locale + "\ninstalled programs: ";
        for (String program : installedPrograms) {
            description += program + ", ";
        }
        return description + "\n";
    }
}
