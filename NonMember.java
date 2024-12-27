// Mendefinisikan kelas NonMember yang merupakan turunan dari User.
public class NonMember extends User {
    private boolean hasBorrowedBook = false; // Status apakah pengguna telah meminjam buku.

    // Konstruktor untuk membuat NonMember dengan nama pengguna.
    public NonMember(String name) {
        super(name); // Memanggil konstruktor dari kelas induk (User).
    }

    // Implementasi metode borrowBook() untuk NonMember.
    @Override
    public boolean borrowBook(Book book) {
        if (hasBorrowedBook) return false; // Jika sudah meminjam buku, tidak bisa meminjam lagi.
        hasBorrowedBook = true; // Menandakan bahwa pengguna sudah meminjam buku.
        return true; // Peminjaman berhasil.
    }

    // Implementasi metode returnBook() untuk NonMember.
    @Override
    public boolean returnBook(Book book) {
        if (!hasBorrowedBook) return false; // Jika belum meminjam buku, tidak bisa mengembalikannya.
        hasBorrowedBook = false; // Menandakan bahwa buku telah dikembalikan.
        return true; // Pengembalian berhasil.
    }

    // Mengubah representasi string dari objek NonMember.
    @Override
    public String toString() {
        return super.toString() + " (Non Anggota)"; // Menambahkan keterangan bahwa pengguna ini adalah NonMember.
    }
}
