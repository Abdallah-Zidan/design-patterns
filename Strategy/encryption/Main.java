package encryption;

class Main {
    public static void main(String[] args) {
        TextFile tf = new TextFile("file1", 1024);
        tf.displayInfo();
        tf.encrypt();
        tf.setEncryptionAlgorithm(new CustomEncryption());
        tf.displayInfo();
        tf.encrypt();
        VideoFile vf = new VideoFile("video1 ", 12000);
        vf.displayInfo();
        vf.encrypt();
        vf.setEncryptionAlgorithm(new AdvancedEncryption());
        vf.displayInfo();
        vf.encrypt();
    }
}