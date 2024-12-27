// Kelas User adalah kelas abstrak yang mendefinisikan dasar untuk pengguna di perpustakaan.
public abstract class User {
    private String name; // Nama pengguna.

    // Konstruktor untuk membuat pengguna dengan nama tertentu.
    public User(String name) {
        this.name = name; // Menyimpan nama pengguna.
    }

    // Getter untuk mendapatkan nama pengguna.
    public String getName() {
        return name;
    }

    // Metode abstrak untuk meminjam buku, harus diimplementasikan oleh kelas turunan.
    public abstract boolean borrowBook(Book book);

    // Metode abstrak untuk mengembalikan buku, harus diimplementasikan oleh kelas turunan.
    public abstract boolean returnBook(Book book);

    // Mengubah representasi string dari objek User.
    @Override
    public String toString() {
        return "Pengguna{" +
                "Nama='" + name + '\'' + // Menampilkan nama pengguna.
                '}';
    }
}
