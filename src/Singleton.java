public class Singleton {
    private static Singleton instance;
    public Library value;

    public Singleton(Library value) {
        this.value = value;
    }

    public static Singleton getInstance(Library value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}

