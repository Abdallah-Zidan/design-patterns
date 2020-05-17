package encryption;
abstract class File {

    protected String name;
    protected int size;
    private IEncryptionAlgorithm encryption; // private not to be accessed directly

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void setEncryptionAlgorithm(IEncryptionAlgorithm encryption) {
        this.encryption = encryption;
    }

    public void encrypt() {
        this.encryption.encrypt(); // here we need to send the file content to encrypt actually but for simplicity
                                   // we just print out a message
    }

    void displayInfo() {
        System.out.println("file name: " + this.name + ", file size: " + this.size + ", current encryption algorithm: "
                + this.encryption);
    }
}

class TextFile extends File {

    public TextFile(String name, int size) {
        super(name, size);
        this.setEncryptionAlgorithm(new SimpleEncryption());
    }
}

class VideoFile extends File {
    public VideoFile(String name, int size) {
        super(name, size);
        this.setEncryptionAlgorithm(new SimpleEncryption());
    }
}
