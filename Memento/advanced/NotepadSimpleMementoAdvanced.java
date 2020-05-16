package advanced;

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
    final private String text; // this can be a custom snapshot object provided by the notepad
    final private Notepad notepad; // containing the attributes that need to be saved as a state

    public Memento(Notepad notepad, String text) {
        this.notepad = notepad;
        this.text = text;
    }

    public void restore() {
        this.notepad.setText(this.text);
    }
}

class CareTaker {
    private ArrayList<Memento> mementos = new ArrayList<>();
    final private Notepad notepad;
    private int currMemento = -1;

    public CareTaker(Notepad notepad) {
        this.notepad = notepad;
    }

    public void addMemento() {
        this.mementos.add(this.notepad.createMemento());
        this.currMemento = mementos.size() - 1;
    }

    public Memento getMemento(int index) {
        this.currMemento = index;
        return this.mementos.get(index);
    }

    // this logic could be added in aseperate class that handles doing and undoing
    // commands
    public void undo() {
        if (mementos.size() > 0) {
            if (this.currMemento > 0)
                this.currMemento--;
            else
                this.currMemento = 0;
            this.notepad.restore(getMemento(this.currMemento));
        }

    }

    public void redo() {
        if (mementos.size() > 0) {
            if (this.currMemento < mementos.size() - 1)
                this.currMemento++;
            else
                this.currMemento = mementos.size() - 1;
            this.notepad.restore(getMemento(this.currMemento));
        }

    }
}

class Main {
    public static void main(String[] args) {
        Notepad np = new Notepad();
        CareTaker careTaker = new CareTaker(np);
        np.setText("hello");
        careTaker.addMemento();
        np.setText("again");
        careTaker.addMemento();

        // print current text in the notepad
        System.out.println(np.getText());

        // undo the last change
        careTaker.undo();
        // restore the previous text
        System.out.println(np.getText());

        // get the next change again
        careTaker.redo();
        System.out.println(np.getText());

        // restore specific change point
        careTaker.undo();
        System.out.println(np.getText());

    }
}