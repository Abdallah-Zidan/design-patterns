class Main {
    public static void main(String[] args) {
        Facebook facebook = new Facebook();
        Youtube youtube = new Youtube();
        Manager manager = new Manager();
        User user = new User();
        user.subscribe(facebook);
        manager.subscribe(youtube);
        facebook.update("new message ");
        youtube.update("new video ");
        user.subscribe(youtube);
        youtube.update("new update ");
        manager.unsbuscribe(youtube);
        youtube.update("server is down ");
        manager.subscribe(facebook);
        facebook.update("new emojis ");
    }
}