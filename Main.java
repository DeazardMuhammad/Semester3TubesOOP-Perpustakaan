import java.util.Scanner; // Mengimpor class Scanner untuk membaca input dari pengguna.

public class Main {
    public static void main(String[] args) { // Titik awal eksekusi program.
        Library library = new Library(); // Membuat objek Library untuk mengelola data buku, pengguna, dan transaksi.
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna.
        boolean running = true; // Variabel untuk mengontrol jalannya program.

        while (running) { // Loop utama program yang terus berjalan sampai `running` menjadi false.
            try {
                // Menampilkan menu utama kepada pengguna.
                System.out.println("\n=== Sistem Perpustakaan ===");
                System.out.println("1. Kelola Buku");
                System.out.println("2. Kelola Pengguna");
                System.out.println("3. Transaksi");
                System.out.println("4. Keluar");
                System.out.print("Pilih kategori: ");

                int category = Integer.parseInt(scanner.nextLine()); // Membaca input pengguna dan mengonversinya menjadi integer.

                // Memilih aksi berdasarkan input pengguna.
                switch (category) {
                    case 1 -> kelolaBuku(library, scanner); // Panggil fungsi untuk mengelola buku.
                    case 2 -> kelolaPengguna(library, scanner); // Panggil fungsi untuk mengelola pengguna.
                    case 3 -> kelolaTransaksi(library, scanner); // Panggil fungsi untuk mengelola transaksi.
                    case 4 -> running = false; // Menghentikan loop utama dan keluar dari program.
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Pesan jika input tidak valid.
                }
            } catch (Exception e) { // Menangkap kesalahan jika input tidak valid.
                System.out.println("Input tidak valid. Silakan coba lagi."); // Pesan kesalahan.
            }
        }
        scanner.close(); // Menutup Scanner untuk menghindari kebocoran sumber daya.
    }

    // Fungsi untuk mengelola menu buku.
    private static void kelolaBuku(Library library, Scanner scanner) {
        boolean running = true; // Variabel untuk mengontrol jalannya sub-menu.
        while (running) { // Loop untuk menu kelola buku.
            try {
                // Menampilkan menu kelola buku.
                System.out.println("\n=== Kelola Buku ===");
                System.out.println("1. Tambah Buku");
                System.out.println("2. Lihat Daftar Buku");
                System.out.println("3. Edit Buku");
                System.out.println("4. Hapus Buku");
                System.out.println("5. Kembali");
                System.out.print("Pilih menu: ");

                int choice = Integer.parseInt(scanner.nextLine()); // Membaca input pengguna dan mengonversinya menjadi integer.

                // Memilih aksi berdasarkan input pengguna.
                switch (choice) {
                    case 1 -> { // Tambah buku.
                        System.out.print("Judul Buku: ");
                        String judul = scanner.nextLine(); // Membaca judul buku.
                        System.out.print("Penulis: ");
                        String author = scanner.nextLine(); // Membaca nama penulis.
                        System.out.print("Kode Buku: ");
                        String code = scanner.nextLine(); // Membaca kode buku.
                        System.out.print("Jumlah Buku: ");
                        int quantity = Integer.parseInt(scanner.nextLine()); // Membaca jumlah buku.
                        library.addBook(judul, author, code, quantity); // Memanggil method untuk menambahkan buku ke perpustakaan.
                    }
                    case 2 -> library.listBuku(); // Menampilkan daftar buku yang ada di perpustakaan.
                    case 3 -> { // Edit buku.
                        System.out.print("Kode Buku yang ingin diedit: ");
                        String code = scanner.nextLine(); // Membaca kode buku yang akan diedit.
                        System.out.print("Judul Baru: ");
                        String newTitle = scanner.nextLine(); // Membaca judul baru.
                        System.out.print("Penulis Baru: ");
                        String newAuthor = scanner.nextLine(); // Membaca nama penulis baru.
                        System.out.print("Jumlah Baru: ");
                        int newQuantity = Integer.parseInt(scanner.nextLine()); // Membaca jumlah baru.
                        library.editBook(code, newTitle, newAuthor, newQuantity); // Memanggil method untuk mengedit buku.
                    }
                    case 4 -> { // Hapus buku.
                        System.out.print("Kode Buku yang ingin dihapus: ");
                        String code = scanner.nextLine(); // Membaca kode buku yang akan dihapus.
                        System.out.print("Yakin ingin menghapus? (yes/no): ");
                        String confirm = scanner.nextLine(); // Konfirmasi dari pengguna.
                        if (!confirm.equalsIgnoreCase("yes")) { // Jika pengguna tidak mengonfirmasi, batal hapus.
                            System.out.println("Penghapusan dibatalkan.");
                            return;
                        }
                        library.deleteBook(code); // Memanggil method untuk menghapus buku.
                    }
                    case 5 -> running = false; // Kembali ke menu utama.
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Pesan jika input tidak valid.
                }
            } catch (Exception e) { // Menangkap kesalahan jika input tidak valid.
                System.out.println("Input tidak valid. Silakan coba lagi."); // Pesan kesalahan.
            }
        }
    }

    // Fungsi untuk mengelola pengguna.
    private static void kelolaPengguna(Library library, Scanner scanner) {
        boolean running = true; // Variabel untuk mengontrol jalannya sub-menu.
        while (running) { // Loop untuk menu kelola pengguna.
            try {
                // Menampilkan menu kelola pengguna.
                System.out.println("\n=== Kelola Pengguna ===");
                System.out.println("1. Tambah Pengguna");
                System.out.println("2. Lihat Daftar Pengguna");
                System.out.println("3. Edit Pengguna");
                System.out.println("4. Hapus Pengguna");
                System.out.println("5. Kembali");
                System.out.print("Pilih menu: ");

                int choice = Integer.parseInt(scanner.nextLine()); // Membaca input pengguna dan mengonversinya menjadi integer.

                // Memilih aksi berdasarkan input pengguna.
                switch (choice) {
                    case 1 -> { // Tambah pengguna.
                        System.out.print("Nama Pengguna: ");
                        String name = scanner.nextLine(); // Membaca nama pengguna.
                        System.out.print("Apakah anggota terdaftar? (yes/no): ");
                        String isMember = scanner.nextLine(); // Membaca apakah pengguna adalah anggota terdaftar.
                        if (isMember.equalsIgnoreCase("yes")) { // Jika ya, tambahkan sebagai anggota.
                            System.out.print("ID Anggota: ");
                            String memberId = scanner.nextLine(); // Membaca ID anggota.
                            library.tambahUser(new Member(name, memberId)); // Tambahkan pengguna sebagai Member.
                        } else {
                            library.tambahUser(new NonMember(name)); // Tambahkan pengguna sebagai NonMember.
                        }
                    }
                    case 2 -> library.lihatUser(); // Menampilkan daftar pengguna.
                    case 3 -> { // Edit pengguna.
                        System.out.print("Nama Pengguna yang ingin diedit: ");
                        String name = scanner.nextLine(); // Membaca nama pengguna yang akan diedit.
                        System.out.print("Nama Baru: ");
                        String newName = scanner.nextLine(); // Membaca nama baru.
                        library.editUser(name, newName); // Memanggil method untuk mengedit pengguna.
                    }
                    case 4 -> { // Hapus pengguna.
                        System.out.print("Nama Pengguna yang ingin dihapus: ");
                        String name = scanner.nextLine(); // Membaca nama pengguna yang akan dihapus.
                        System.out.print("Yakin ingin menghapus? (yes/no): ");
                        String confirm = scanner.nextLine(); // Konfirmasi dari pengguna.
                        if (!confirm.equalsIgnoreCase("yes")) { // Jika pengguna tidak mengonfirmasi, batal hapus.
                            System.out.println("Penghapusan dibatalkan.");
                            return;
                        }
                        library.deleteUser(name); // Memanggil method untuk menghapus pengguna.
                    }
                    case 5 -> running = false; // Kembali ke menu utama.
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Pesan jika input tidak valid.
                }
            } catch (Exception e) { // Menangkap kesalahan jika input tidak valid.
                System.out.println("Input tidak valid. Silakan coba lagi."); // Pesan kesalahan.
            }
        }
    }

    // Fungsi untuk mengelola transaksi.
    private static void kelolaTransaksi(Library library, Scanner scanner) {
        boolean running = true; // Variabel untuk mengontrol jalannya sub-menu.
        while (running) { // Loop untuk menu kelola transaksi.
            try {
                // Menampilkan menu kelola transaksi.
                System.out.println("\n=== Kelola Transaksi ===");
                System.out.println("1. Peminjaman Buku");
                System.out.println("2. Pengembalian Buku");
                System.out.println("3. Lihat Daftar Transaksi");
                System.out.println("4. Kembali");
                System.out.print("Pilih menu: ");

                int choice = Integer.parseInt(scanner.nextLine()); // Membaca input pengguna dan mengonversinya menjadi integer.

                // Memilih aksi berdasarkan input pengguna.
                switch (choice) {
                    case 1 -> { // Proses peminjaman buku.
                        System.out.print("Nama Pengguna: ");
                        String userName = scanner.nextLine(); // Membaca nama pengguna.
                        System.out.print("Kode Buku: ");
                        String idBuku = scanner.nextLine(); // Membaca kode buku.
                        System.out.print("Jumlah Buku yang dipinjam: ");                        library.borrowBook(userName, idBuku);// Memanggil method untuk memproses peminjaman buku.
                    }
                    case 2 -> { // Proses pengembalian buku.
                        System.out.print("Nama Pengguna: ");
                        String userName = scanner.nextLine(); // Membaca nama pengguna.
                        System.out.print("Kode Buku: ");
                        String idBuku = scanner.nextLine(); // Membaca kode buku.
                        library.returnBook(userName, idBuku); // Memanggil method untuk memproses pengembalian buku.
                    }
                    case 3 -> library.viewTransactions(); // Menampilkan daftar transaksi.
                    case 4 -> running = false; // Kembali ke menu utama.
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Pesan jika input tidak valid.
                }
            } catch (Exception e) { // Menangkap kesalahan jika input tidak valid.
                System.out.println("Input tidak valid. Silakan coba lagi."); // Pesan kesalahan.
            }
        }
    }
}
