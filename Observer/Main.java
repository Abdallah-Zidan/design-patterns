class Main {
    public static void main(String[] args) {
        Facebook facebook = new Facebook();
        Youtube youtube = new Youtube();
        Manager manager = new Manager(youtube);
        User user = new NormalUser(facebook);
        user.subscribe();
        manager.subscribe();
        facebook.update("new message ");
        youtube.update("new video ");
        user.unsubscribe();
        user.setSubject(youtube);
        user.subscribe();
        facebook.update("not sent.. ");
        youtube.update("sent to both ");
    }
}