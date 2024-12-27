// Mendefinisikan kelas Transaksi untuk merepresentasikan transaksi peminjaman dan pengembalian buku.
public class Transaksi {
    private int transaksiId; // ID unik untuk transaksi.
    private User user; // Pengguna yang melakukan transaksi.
    private Book book; // Buku yang dipinjam atau dikembalikan.
    private String transaksiType; // Jenis transaksi (misalnya "Peminjaman" atau "Pengembalian").

    // Getter untuk mengambil tipe transaksi (Peminjaman/Pengembalian).
    public String getTransaksiType() {
        return transaksiType; // Mengembalikan tipe transaksi.
    }

    // Konstruktor untuk membuat objek Transaksi dengan ID, pengguna, buku, dan tipe transaksi.
    public Transaksi(int transaksiId, User user, Book book, String transaksiType) {
        this.transaksiId = transaksiId; // Menginisialisasi ID transaksi.
        this.user = user; // Menginisialisasi pengguna yang terkait dengan transaksi.
        this.book = book; // Menginisialisasi buku yang terlibat dalam transaksi.
        this.transaksiType = transaksiType; // Menginisialisasi tipe transaksi.
    }

    // Setter untuk mengubah tipe transaksi setelah objek Transaksi dibuat.
    public void setTransaksiType(String transaksiType) {
        this.transaksiType = transaksiType; // Menetapkan tipe transaksi baru.
    }

    // Mengubah representasi objek Transaksi menjadi string untuk tujuan tampilan/print.
    @Override
    public String toString() {
        return "Transaksi{" +
                "ID=" + transaksiId + // Menampilkan ID transaksi.
                ", Pengguna=" + user.getName() + // Menampilkan nama pengguna yang melakukan transaksi.
                ", Buku=" + book.getIdBook() + // Menampilkan ID buku yang terlibat dalam transaksi.
                ", Jenis='" + transaksiType + '\'' + // Menampilkan jenis transaksi (Peminjaman/Pengembalian).
                '}'; // Menyelesaikan representasi string transaksi.
    }

    // Getter untuk mengambil objek Book yang terlibat dalam transaksi.
    public Book getBook() {
        return book; // Mengembalikan objek Book.
    }

    // Getter untuk mengambil objek User yang melakukan transaksi.
    public User getUser() {
        return user; // Mengembalikan objek User.
    }

    // Getter untuk mengambil ID transaksi.
    public int getTransaksiId() {
        return transaksiId; // Mengembalikan ID transaksi.
    }
}
