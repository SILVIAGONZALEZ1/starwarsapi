import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(new Pelicula("Star Wars", 1, "A long time ago...", "George Lucas", "Gary Kurtz", "1977-05-25"));
        System.out.println(json);
    }
}
