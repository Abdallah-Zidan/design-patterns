package os_example;

import java.util.ArrayList;

class Memento {
    // final private instance of the state we want to keep track of
    final private OS.Snapshot snapshot;

    final private OS os; // to restore its state without getting in details of how he does that

    public Memento(OS os, OS.Snapshot snapshot) {
        this.os = os;
        this.snapshot = snapshot;
    }

    public void restoreOs() {
        this.os.restoreSnapshot(this.snapshot);
    }
}

/**
 * this class handles the storage and history of mementos it adds mementos to
 * the list or retreives any required memento using index takes care of undoing
 * and redoing changes to the OS object it takes care of
 */
class CareTaker {
    private ArrayList<Memento> mementos = new ArrayList<>();
    final private OS os;
    private int currentMemento = -1;

    public CareTaker(OS os) {
        this.os = os;
    }

    public void addMemento() {
        Memento memento = this.os.createMemento();
        this.mementos.add(memento);
        this.currentMemento = mementos.size() - 1;
    }

    public void getMemento(int index) {
        this.mementos.get(index).restoreOs();
    }

    public void undoChanges() {
        if (this.mementos.size() > 0) {
            this.currentMemento--;
            this.getMemento(this.currentMemento);
        }
    }

    public void redoChanges() {
        if (this.mementos.size() < this.mementos.size() - 1) {
            this.currentMemento++;
            this.getMemento(this.currentMemento);
        }
    }
}

class Main {
    public static void main(String[] args) {
        OS os = new OS("sanserif", "en");
        CareTaker ct = new CareTaker(os);

        os.installProgram("firefox");
        // first os state {locale : "en" , font : "sanserif" , programs : ["firefox",]}
        ct.addMemento();
        // change os state
        os.installProgram("chrome");
        os.installProgram("vscode");
        os.setFont("mono");
        os.setLocale("ar");
        ct.addMemento();

        // if we print the current os object
        System.out.println(os);
        // this is the expected output :
        // font family : mono
        // local : ar
        // installed programs : ["firefox", "vscode","chrome"]

        // if we want a previous state we need to get the previous memento
        // until now in our care taker object we have 2 mementos
        // restoring os state of memento 0
        ct.undoChanges();
        System.out.println(os);
        // expected output
        // font family : sanserif
        // local : ar // because locale isn't specified in the snapshot
        // installed programs : ["firefox",]
    }
}