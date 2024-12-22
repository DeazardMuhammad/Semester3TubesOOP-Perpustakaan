public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean borrowBook(Book book);

    public abstract boolean returnBook(Book book);

    @Override
    public String toString() {
        return "Pengguna{" +
                "Nama='" + name + '\'' +
                '}';
    }
}
