
class Main {
    public static void main(String[] args) {

        // before using facade
        // TextFile tf = new TextFile("file1.txt", 1024);
        // tf.displayInfo();
        // tf.encrypt();
        // tf.setEncryptionAlgorithm(new CustomEncryption());
        // tf.displayInfo();
        // tf.encrypt();
        // VideoFile vf = new VideoFile("video1.mp4 ", 12000);
        // vf.displayInfo();
        // vf.encrypt();
        // vf.setEncryptionAlgorithm(new AdvancedEncryption());
        // vf.displayInfo();
        // vf.encrypt();
        // ============================================//

        // after using facade
        File encryptedFile = EncryptionFacade.encrypt("test.txt", 1024);
        System.out.println("================================\n");
        encryptedFile = EncryptionFacade.encrypt("test.mp4", 12000);
        System.out.println("================================\n");
        encryptedFile = EncryptionFacade.encrypt("test.mp4", 12000, new CustomEncryption());
    }
}