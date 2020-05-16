package simple;

import java.util.ArrayList;

class Notepad {
    private String text;

    public Notepad(String text) {
        this.text = text;

    }

    public Notepad() {
        this("initial text");
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public Memento createMemento() {
        return new Memento(this, this.text);
    }

    public void restore(Memento memento) {
        memento.restore();
    }

}

class Memento {
    final private String text; // this can be a custom snapshot specified by the notepad class
    final private Notepad notepad; // this can be any class implements interface of backupble object

    public Memento(Notepad notepad, String text) {
        this.text = text;
        this.notepad = notepad;
    }

    public void restore() {
        this.notepad.setText(this.text);
    }
}

class CareTaker {
    private ArrayList<Memento> mementos = new ArrayList<>();
    private int currMemento = -1;

    public void addMemento(Memento memento) {
        this.mementos.add(memento);
        this.currMemento = mementos.size() - 1;
    }

    public Memento getMemento(int index) {
        this.currMemento = index;
        return this.mementos.get(index);
    }

    public Memento undo() {
        if (mementos.size() > 0) {
            if (this.currMemento > 0)
                this.currMemento--;
            else
                this.currMemento = 0;
            return getMemento(this.currMemento);
        }
        return null;
    }

    public Memento redo() {
        if (mementos.size() > 0) {
            if (this.currMemento < mementos.size() - 1)
                this.currMemento++;
            else
                this.currMemento = mementos.size() - 1;
            return getMemento(this.currMemento);
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        Notepad np = new Notepad();
        CareTaker careTaker = new CareTaker();
        np.setText("hello");
        careTaker.addMemento(np.createMemento());
        np.setText("again");
        careTaker.addMemento(np.createMemento());

        // print current text in the notepad
        System.out.println(np.getText());

        // undo the last change
        np.restore(careTaker.undo());
        // restore the previous text
        System.out.println(np.getText());

        // get the next change again
        np.restore(careTaker.redo());
        System.out.println(np.getText());

        // restore specific change point
        np.restore(careTaker.undo());
        System.out.println(np.getText());

    }
}