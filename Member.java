// Mendefinisikan kelas Member yang merupakan turunan dari User.
public class Member extends User {
    private String memberId; // ID Anggota yang unik.

    // Konstruktor untuk membuat anggota baru dengan nama dan ID anggota.
    public Member(String name, String memberId) {
        super(name); // Memanggil konstruktor dari kelas induk (User).
        this.memberId = memberId;
    }

    // Implementasi metode borrowBook() untuk anggota, selalu mengembalikan true (peminjaman berhasil).
    @Override
    public boolean borrowBook(Book book) {
        return true; // Anggota bisa meminjam buku.
    }

    // Implementasi metode returnBook() untuk anggota, selalu mengembalikan true (pengembalian berhasil).
    @Override
    public boolean returnBook(Book book) {
        return true; // Anggota bisa mengembalikan buku.
    }

    // Mengubah representasi string dari objek Member.
    @Override
    public String toString() {
        return super.toString() + ", ID Anggota='" + memberId + "'"; // Menambahkan ID Anggota ke hasil string dari kelas induk.
    }

    // Getter untuk mendapatkan memberId.
    public String getMemberId() {
        return memberId;
    }
}
