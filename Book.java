public class Book { // Mendefinisikan class Book yang merepresentasikan entitas buku.
    private String judul; // Variabel untuk menyimpan judul buku (akses terbatas pada class ini saja).
    private String author; // Variabel untuk menyimpan nama penulis buku.
    private String idBuku; // Variabel untuk menyimpan kode unik buku.
    private int quantitas; // Variabel untuk menyimpan jumlah atau stok buku.

    // Konstruktor untuk menginisialisasi data buku.
    public Book(String judul, String author, String idBuku, int quantitas) {
        this.judul = judul; // Mengisi variabel `judul` dengan nilai yang diberikan saat objek dibuat.
        this.author = author; // Mengisi variabel `author` dengan nilai yang diberikan.
        this.idBuku = idBuku; // Mengisi variabel `idBuku` dengan nilai yang diberikan.
        this.quantitas = quantitas; // Mengisi variabel `quantitas` dengan nilai yang diberikan.
    }

    // Method untuk mendapatkan ID (kode) buku.
    public String getIdBook() {
        return idBuku; // Mengembalikan nilai dari variabel `idBuku`.
    }

    // Method untuk mendapatkan jumlah (stok) buku.
    public int getQuantity() {
        return quantitas; // Mengembalikan nilai dari variabel `quantitas`.
    }

    // Method untuk mengurangi jumlah buku (digunakan saat buku dipinjam).
    public void decreaseQuantity() {
        if (quantitas > 0) quantitas--; // Mengurangi stok buku hanya jika stok lebih dari 0.
    }

    // Method untuk menambah jumlah buku (digunakan saat buku dikembalikan).
    public void increaseQuantity() {
        quantitas++; // Menambahkan stok buku.
    }

    // Override method `toString` untuk memberikan representasi string dari objek buku.
    @Override
    public String toString() {
        // Mengembalikan string dengan informasi lengkap buku.
        return "Buku: " +
                "Judul='" + judul + '\'' + // Menampilkan judul buku.
                ", Penulis='" + author + '\'' + // Menampilkan nama penulis.
                ", Kode='" + idBuku + '\'' + // Menampilkan kode buku.
                ", Kuantitas=" + quantitas; // Menampilkan jumlah buku.
    }

    // Method untuk mengubah judul buku.
    public void setJudul(String judul) {
        this.judul = judul; // Mengisi variabel `judul` dengan nilai baru.
    }

    // Method untuk mengubah nama penulis buku.
    public void setAuthor(String author) {
        this.author = author; // Mengisi variabel `author` dengan nilai baru.
    }

    // Method untuk mengubah jumlah buku.
    public void setQuantitas(int quantitas) {
        this.quantitas = quantitas; // Mengisi variabel `quantitas` dengan nilai baru.
    }
}
