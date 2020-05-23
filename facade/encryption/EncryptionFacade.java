
class EncryptionFacade {
    public static File encrypt(String fileName, int size) {
        File file = FileFactory.getFile(fileName, size);
        if (file != null) {
            if (file instanceof VideoFile) {
                file.setEncryptionAlgorithm(new AdvancedEncryption());
            } else {
                file.setEncryptionAlgorithm(new SimpleEncryption());
            }

            file.displayInfo();
            file.encrypt();
            return file;
        }
        return null;
    }

    public static File encrypt(String fileName, int size, IEncryptionAlgorithm encryptionAlgorithm) {
        File file = FileFactory.getFile(fileName, size);

        if (file != null) {
            file.setEncryptionAlgorithm(encryptionAlgorithm);
            file.displayInfo();
            file.encrypt();
            return file;
        }
        return null;

    }
}