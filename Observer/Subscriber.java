interface Observer {
    void update(String message);
}

class User implements Observer {
    // private Observable subject;

    // public User(Observable subject){
    // this.subject=subject;
    // }

    // public void setSubject(Observable subject) {
    // this.subject = subject;
    // }
    public void subscribe(Observable sub) {
        sub.subscribe(this);
    }

    public void unsbuscribe(Observable sub) {
        sub.unsubscribe(this);
    }

    @Override
    public void update(String message) {
        System.out.println(message + "to user");
    }
}

class Manager implements Observer {

    public void subscribe(Observable sub) {
        sub.subscribe(this);
    }

    public void unsbuscribe(Observable sub) {
        sub.unsubscribe(this);
    }

    @Override
    public void update(String message) {
        System.out.println(message + "to manager");
    }
}
