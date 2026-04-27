package petdata;

import java.util.List;

public class datapet {
    public int id;
    public Kategori kategori;
    public String name;
    public List<String> photourl;
    public List<Tag> tags;
    public String status;

    // Inner class Kategori
    public static class Kategori {
        public int id;
        public String nama;
    }

    // Inner class Tag
    public static class Tag {
        public int id;
        public String name;
    }
}