import java.util.ArrayList;

interface Observable {
    /**
     * this could be an abstract class too if you need to implement some other
     * common logic
     */
    void subscribe(Observer o);

    void unsubscribe(Observer o);

    void notifyObservers(String message);
}

class Facebook implements Observable {
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void update(String message) {
        this.notifyObservers(message + "from facebook ");
    }
}

class Youtube implements Observable {
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {

        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void update(String message) {
        this.notifyObservers(message + "from youtube ");
    }
}
