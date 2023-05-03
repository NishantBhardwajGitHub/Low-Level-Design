package utils_pack;

public class Id_Generator {
    private static int id = 0;
    public static int generateId() {
        id++;
        return id;
    }
}
