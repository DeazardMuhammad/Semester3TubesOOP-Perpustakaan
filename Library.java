import java.util.ArrayList; // Mengimpor ArrayList untuk menyimpan daftar buku, pengguna, dan transaksi.

public class Library { // Mendefinisikan class Library yang merepresentasikan sistem perpustakaan.
    private ArrayList<Book> books = new ArrayList<>(); // Menyimpan daftar buku.
    private ArrayList<User> users = new ArrayList<>(); // Menyimpan daftar pengguna.
    private ArrayList<Transaksi> arrayTransaksi = new ArrayList<>(); // Menyimpan daftar transaksi.
    private int hitungTransaksi = 1; // Counter untuk memberi ID pada transaksi.

    // Method untuk menambahkan buku baru ke perpustakaan.
    public void addBook(String judul, String author, String idBuku, int quantitas) {
        for (Book book : books) { // Memeriksa apakah kode buku sudah ada.
            if (book.getIdBook().equalsIgnoreCase(idBuku)) {
                System.out.println("Kode buku sudah ada! Tidak dapat menambahkan buku dengan kode yang sama.");
                return; // Menghentikan proses jika kode buku sudah ada.
            }
        }
        books.add(new Book(judul, author, idBuku, quantitas)); // Menambahkan buku baru.
        System.out.println("Buku berhasil ditambahkan!");
    }

    // Method untuk menambahkan pengguna baru.
    public void tambahUser(User user) {
        for (User existingUser : users) { // Memeriksa apakah nama pengguna sudah ada.
            if (existingUser.getName().equalsIgnoreCase(user.getName())) {
                System.out.println("Nama pengguna sudah ada! Tidak dapat menambahkan pengguna dengan nama yang sama.");
                return;
            }
        }

        // Jika pengguna adalah Member, periksa ID anggota.
        if (user instanceof Member) {
            String memberId = ((Member) user).getMemberId();
            for (User existingUser : users) {
                if (existingUser instanceof Member) {
                    String existingMemberId = ((Member) existingUser).getMemberId();
                    if (existingMemberId.equals(memberId)) {
                        System.out.println("ID Anggota sudah ada! Tidak dapat menambahkan pengguna dengan ID yang sama.");
                        return;
                    }
                }
            }
        }

        users.add(user); // Menambahkan pengguna baru ke daftar.
        System.out.println("Pengguna berhasil ditambahkan!");
    }

    // Method untuk mencetak daftar buku.
    public void listBuku() {
        System.out.println("Daftar Buku:");
        for (Book book : books) {
            System.out.println(book); // Menggunakan `toString` dari objek Book.
        }
    }

    // Method untuk mencetak daftar pengguna.
    public void lihatUser() {
        System.out.println("Daftar Pengguna:");
        for (User user : users) {
            System.out.println(user); // Menggunakan `toString` dari objek User.
        }
    }

    // Method untuk meminjam buku.
    public void borrowBook(String userName, String idBuku) {
        User user = findUser(userName); // Mencari pengguna berdasarkan nama.
        Book book = findBook(idBuku); // Mencari buku berdasarkan kode.

        if (user == null) { // Validasi keberadaan pengguna.
            System.out.println("Pengguna tidak ditemukan!");
            return;
        }

        if (book == null) { // Validasi keberadaan buku.
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        if (book.getQuantity() <= 0) { // Validasi stok buku.
            System.out.println("Buku habis, tidak dapat dipinjam!");
            return;
        }

        if (user.borrowBook(book)) { // Jika pengguna berhasil meminjam buku.
            book.decreaseQuantity(); // Kurangi stok buku.
            arrayTransaksi.add(new Transaksi(hitungTransaksi++, user, book, "Peminjaman")); // Catat transaksi.
            System.out.println("Peminjaman berhasil!");
        } else {
            System.out.println("Gagal meminjam buku. Periksa batas atau ketersediaan.");
        }
    }

    // Method untuk mengembalikan buku.
    public void returnBook(String userName, String idBuku) {
        User user = findUser(userName); // Mencari pengguna.
        Book book = findBook(idBuku); // Mencari buku.

        if (user == null) {
            System.out.println("Pengguna tidak ditemukan!");
            return;
        }

        if (book == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        if (user.returnBook(book)) { // Jika pengguna berhasil mengembalikan buku.
            book.increaseQuantity(); // Tambah stok buku.
            for (Transaksi transaksi : arrayTransaksi) { // Cari transaksi terkait.
                if (transaksi.getUser().equals(user) &&
                    transaksi.getBook().equals(book) &&
                    transaksi.toString().contains("Peminjaman")) {
                    transaksi.setTransaksiType("Pengembalian"); // Ubah tipe transaksi.
                    System.out.println("Pengembalian berhasil!");
                    return;
                }
            }
            System.out.println("Tidak ditemukan transaksi peminjaman terkait!");
        } else {
            System.out.println("Gagal mengembalikan buku. Periksa data pengguna dan buku.");
        }
    }

    // Method untuk mencetak daftar transaksi.
    public void viewTransactions() {
        System.out.println("Daftar Transaksi:");
        for (Transaksi transaksi : arrayTransaksi) {
            System.out.println(transaksi); // Menggunakan `toString` dari objek Transaksi.
        }
    }

    // Method untuk mencari pengguna berdasarkan nama.
    private User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user; // Kembalikan pengguna jika ditemukan.
            }
        }
        return null; // Kembalikan null jika tidak ditemukan.
    }

    // Method untuk mencari buku berdasarkan kode.
    private Book findBook(String code) {
        for (Book book : books) {
            if (book.getIdBook().equalsIgnoreCase(code)) {
                return book; // Kembalikan buku jika ditemukan.
            }
        }
        return null; // Kembalikan null jika tidak ditemukan.
    }

    // Method untuk mengedit data buku.
    public void editBook(String code, String newTitle, String newAuthor, int newQuantity) {
        Book book = findBook(code);
        if (book != null) {
            if (newQuantity < 0) { // Validasi jumlah buku tidak negatif.
                System.out.println("Jumlah buku tidak boleh negatif!");
                return;
            }
            book.setJudul(newTitle); // Perbarui judul.
            book.setAuthor(newAuthor); // Perbarui penulis.
            book.setQuantitas(newQuantity); // Perbarui jumlah.
            System.out.println("Buku berhasil diperbarui!");
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    // Method untuk menghapus buku.
    public void deleteBook(String code) {
        Book book = findBook(code);
        if (book != null) {
            for (Transaksi transaksi : arrayTransaksi) { // Periksa apakah ada transaksi terkait buku.
                if (transaksi.getBook().getIdBook().equalsIgnoreCase(code)) {
                    System.out.println("Tidak bisa menghapus buku karena masih ada transaksi terkait!");
                    return;
                }
            }
            books.remove(book); // Hapus buku.
            System.out.println("Buku berhasil dihapus!");
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    // Method untuk mengedit data pengguna.
    public void editUser(String name, String newName) {
        User user = findUser(name);
        if (user != null) {
            for (User existingUser : users) { // Periksa apakah nama baru sudah ada.
                if (existingUser.getName().equalsIgnoreCase(newName)) {
                    System.out.println("Nama baru pengguna sudah ada! Perubahan gagal.");
                    return;
                }
            }
            users.remove(user); // Hapus pengguna lama.
            if (user instanceof Member) { // Jika pengguna adalah Member, tambahkan pengguna baru dengan ID sama.
                String memberId = ((Member) user).getMemberId();
                users.add(new Member(newName, memberId));
            } else {
                users.add(new NonMember(newName));
            }
            System.out.println("Pengguna berhasil diperbarui!");
        } else {
            System.out.println("Pengguna tidak ditemukan!");
        }
    }

    // Method untuk menghapus pengguna.
    public void deleteUser(String name) {
        User user = findUser(name);
        if (user != null) {
            for (Transaksi transaksi : arrayTransaksi) { // Periksa apakah ada transaksi terkait pengguna.
                if (transaksi.getUser().getName().equalsIgnoreCase(name)) {
                    System.out.println("Tidak bisa menghapus pengguna karena masih ada transaksi terkait!");
                    return;
                }
            }
            users.remove(user); // Hapus pengguna.
            System.out.println("Pengguna berhasil dihapus!");
        } else {
            System.out.println("Pengguna tidak ditemukan!");
        }
    }
}
