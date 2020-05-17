interface Observer {
    void update(String message);
}

abstract class User implements Observer {
    private Observable subject;

    public User(Observable subject) {
        this.subject = subject;
    }

    public void setSubject(Observable subject) {
        this.subject = subject;
    }

    public void subscribe() {
        this.subject.subscribe(this);
    }

    public void unsubscribe() {
        this.subject.unsubscribe(this);
    }
    // public void subscribe(Observable sub) {
    // sub.subscribe(this);
    // }

    // public void unsbuscribe(Observable sub) {
    // sub.unsubscribe(this);
    // }

}

class NormalUser extends User {

    public NormalUser(Observable subject) {
        super(subject);
    }

    @Override
    public void update(String message) {
        System.out.println(message + "to normal user");
    }
}

class Manager extends User {
    public Manager(Observable subject) {
        super(subject);
    }

    @Override
    public void update(String message) {
        System.out.println(message + "to manager");
    }
}
