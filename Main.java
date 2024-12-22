import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n=== Sistem Perpustakaan ===");
                System.out.println("1. Kelola Buku");
                System.out.println("2. Kelola Pengguna");
                System.out.println("3. Transaksi");
                System.out.println("4. Keluar");
                System.out.print("Pilih kategori: ");

                int category = Integer.parseInt(scanner.nextLine());

                switch (category) {
                    case 1 -> kelolaBuku(library, scanner);
                    case 2 -> kelolaPengguna(library, scanner);
                    case 3 -> kelolaTransaksi(library, scanner);
                    case 4 -> running = false;
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private static void kelolaBuku(Library library, Scanner scanner) {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\n=== Kelola Buku ===");
                System.out.println("1. Tambah Buku");
                System.out.println("2. Lihat Daftar Buku");
                System.out.println("3. Edit Buku");
                System.out.println("4. Hapus Buku");
                System.out.println("5. Kembali");
                System.out.print("Pilih menu: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Judul Buku: ");
                        String judul = scanner.nextLine();
                        System.out.print("Penulis: ");
                        String author = scanner.nextLine();
                        System.out.print("Kode Buku: ");
                        String code = scanner.nextLine();
                        System.out.print("Jumlah Buku: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        library.addBook(judul, author, code, quantity);
                    }
                    case 2 -> library.listBuku();
                    case 3 -> {
                        System.out.print("Kode Buku yang ingin diedit: ");
                        String code = scanner.nextLine();
                        System.out.print("Judul Baru: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Penulis Baru: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Jumlah Baru: ");
                        int newQuantity = Integer.parseInt(scanner.nextLine());
                        library.editBook(code, newTitle, newAuthor, newQuantity);
                    }
                    case 4 -> {
                        System.out.print("Kode Buku yang ingin dihapus: ");
                        String code = scanner.nextLine();
                        System.out.print("Yakin ingin menghapus? (yes/no): ");
                        String confirm = scanner.nextLine();
                        if (!confirm.equalsIgnoreCase("yes")) {
                            System.out.println("Penghapusan dibatalkan.");
                            return;
                        }

                        library.deleteBook(code);
                        
                    }
                    case 5 -> running = false;
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void kelolaPengguna(Library library, Scanner scanner) {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\n=== Kelola Pengguna ===");
                System.out.println("1. Tambah Pengguna");
                System.out.println("2. Lihat Daftar Pengguna");
                System.out.println("3. Edit Pengguna");
                System.out.println("4. Hapus Pengguna");
                System.out.println("5. Kembali");
                System.out.print("Pilih menu: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Nama Pengguna: ");
                        String name = scanner.nextLine();
                        System.out.print("Apakah anggota terdaftar? (yes/no): ");
                        String isMember = scanner.nextLine();
                        if (isMember.equalsIgnoreCase("yes")) {
                            System.out.print("ID Anggota: ");
                            String memberId = scanner.nextLine();
                            library.tambahUser(new Member(name, memberId));
                        } else {
                            library.tambahUser(new NonMember(name));
                        }
                    }
                    case 2 -> library.lihatUser();
                    case 3 -> {
                        System.out.print("Nama Pengguna yang ingin diedit: ");
                        String name = scanner.nextLine();
                        System.out.print("Nama Baru: ");
                        String newName = scanner.nextLine();
                        library.editUser(name, newName);
                    }
                    case 4 -> {
                        System.out.print("Nama Pengguna yang ingin dihapus: ");
                        String name = scanner.nextLine();
                        System.out.print("Yakin ingin menghapus? (yes/no): ");
                        String confirm = scanner.nextLine();
                        if (!confirm.equalsIgnoreCase("yes")) {
                            System.out.println("Penghapusan dibatalkan.");
                            return;
                        }                        
                        library.deleteUser(name);
                    }
                    case 5 -> running = false;
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void kelolaTransaksi(Library library, Scanner scanner) {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\n=== Kelola Transaksi ===");
                System.out.println("1. Peminjaman Buku");
                System.out.println("2. Pengembalian Buku");
                System.out.println("3. Lihat Daftar Transaksi");
                System.out.println("4. Kembali");
                System.out.print("Pilih menu: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Nama Pengguna: ");
                        String userName = scanner.nextLine();
                        System.out.print("Kode Buku: ");
                        String idBuku = scanner.nextLine();
                        library.borrowBook(userName, idBuku);
                    }
                    case 2 -> {
                        System.out.print("Nama Pengguna: ");
                        String userName = scanner.nextLine();
                        System.out.print("Kode Buku: ");
                        String idBuku = scanner.nextLine();
                        library.returnBook(userName, idBuku);
                    }
                    case 3 -> library.viewTransactions();
                    case 4 -> running = false;
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
    }
}
