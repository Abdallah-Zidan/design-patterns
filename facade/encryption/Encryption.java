
interface IEncryptionAlgorithm {
    void encrypt();
}

class SimpleEncryption implements IEncryptionAlgorithm {
    public void encrypt() {
        System.out.println("encrypting using simple encryption.. quick and simple");
    }

    @Override
    public String toString() {
        return "Simple encryption Algorithm";
    }
}

class AdvancedEncryption implements IEncryptionAlgorithm {
    public void encrypt() {
        System.out.println("encrypting using advanced encryption.. takes long time");
    }

    @Override
    public String toString() {
        return "Advanced encryption Algorithm";
    }
}

class CustomEncryption implements IEncryptionAlgorithm {
    public void encrypt() {
        System.out.println("encrypting using custom encryption... very customizable");
    }

    @Override
    public String toString() {
        return "Custom encryption Algorithm";
    }
}

class NewEncryption implements IEncryptionAlgorithm {
    public void encrypt() {
        System.out.println("encrypting using new encryption...");
    }

    @Override
    public String toString() {
        return "New encryption Algorithm";
    }
}