class Singleton {
    private static Singleton obj;

    private Singleton() {
    };

    // option 1 thread safe but synchronized isn't the best choice
    // public synchronized static Singleton getObject() {
    // if (obj == null) {
    // obj = new Singleton();
    // }
    // return obj;
    // }

    // ============================================//

    // option 2 thread safe but and better synchronized usage
    // public static Singleton getObject() {
    // if (obj == null) {
    // synchronized (Singleton.class) {
    // if (obj == null) {
    // obj = new Singleton();
    // }
    // }

    // }
    // return obj;
    // }

    // ============================================//

    // option 3 using thread safe Bill Pugh .. very effecient
    private static class SingleInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getObject() {
        return SingleInstance.INSTANCE;
    }

    // ============================================//

    // option 4 not thread safe but synchronized isn't the best choice
    // public static Singleton getObject() {
    // if (obj == null) {
    // obj = new Singleton();
    // }
    // return obj;
    // }

}

class Main {
    public static void main(String[] args) {
        Singleton single = Singleton.getObject();
        Singleton second = Singleton.getObject();
        System.out.println(single);
        System.out.println(second);
        // same object id will be printed
    }
}
