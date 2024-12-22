import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Transaksi> arrayTransaksi = new ArrayList<>();
    private int hitungTransaksi = 1;

    public void addBook(String judul, String author, String idBuku, int quantitas) {
        for (Book book : books) {
            if (book.getIdBook().equalsIgnoreCase(idBuku)) {
                System.out.println("Kode buku sudah ada! Tidak dapat menambahkan buku dengan kode yang sama.");
                return;
            }
        }
        books.add(new Book(judul, author, idBuku, quantitas));
        System.out.println("Buku berhasil ditambahkan!");
    }

    public void tambahUser(User user) {
        for (User existingUser : users) {
            if (existingUser.getName().equalsIgnoreCase(user.getName())) {
                System.out.println("Nama pengguna sudah ada! Tidak dapat menambahkan pengguna dengan nama yang sama.");
                return;
            }
        }
        
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
    
        users.add(user);
        System.out.println("Pengguna berhasil ditambahkan!");
    }
    

    public void listBuku() {
        System.out.println("Daftar Buku:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void lihatUser() {
        System.out.println("Daftar Pengguna:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void borrowBook(String userName, String idBuku) {
        User user = findUser(userName);
        Book book = findBook(idBuku);
    
        if (user == null) {
            System.out.println("Pengguna tidak ditemukan!");
            return;
        }
    
        if (book == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }
    
        if (book.getQuantity() <= 0) {
            System.out.println("Buku habis, tidak dapat dipinjam!");
            return;
        }
    
        if (user.borrowBook(book)) {
            book.decreaseQuantity();  
            arrayTransaksi.add(new Transaksi(hitungTransaksi++, user, book, "Peminjaman"));
            System.out.println("Peminjaman berhasil!");
        } else {
            System.out.println("Gagal meminjam buku. Periksa batas atau ketersediaan.");
        }
    }
    
    public void returnBook(String userName, String idBuku) {
        User user = findUser(userName);
        Book book = findBook(idBuku);
    
        if (user == null) {
            System.out.println("Pengguna tidak ditemukan!");
            return;
        }
    
        if (book == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }
    
        if (user.returnBook(book)) {
            book.increaseQuantity();  
            for (Transaksi transaksi : arrayTransaksi) {
                if (transaksi.getUser().equals(user) &&
                    transaksi.getBook().equals(book) &&
                    transaksi.toString().contains("Peminjaman")) {
                    transaksi.setTransaksiType("Pengembalian");  
                    System.out.println("Pengembalian berhasil!");
                    return;
                }
            }
            System.out.println("Tidak ditemukan transaksi peminjaman terkait!");
        } else {
            System.out.println("Gagal mengembalikan buku. Periksa data pengguna dan buku.");
        }
    }
    
    

    public void viewTransactions() {
        System.out.println("Daftar Transaksi:");
        for (Transaksi transaksi : arrayTransaksi) {
            System.out.println(transaksi);
        }
    }

    private User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(String code) {
        for (Book book : books) {
            if (book.getIdBook().equalsIgnoreCase(code)) {
                return book;
            }
        }
        return null;
    }

    public void editBook(String code, String newTitle, String newAuthor, int newQuantity) {
        Book book = findBook(code);
        if (book != null) {
            if (newQuantity < 0) {
                System.out.println("Jumlah buku tidak boleh negatif!");
                return;
            }
            book.setJudul(newTitle);
            book.setAuthor(newAuthor);
            book.setQuantitas(newQuantity);
            System.out.println("Buku berhasil diperbarui!");
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    public void deleteBook(String code) {
        Book book = findBook(code);
        if (book != null) {
            for (Transaksi transaksi : arrayTransaksi) {
                if (transaksi.getBook().getIdBook().equalsIgnoreCase(code)) {
                    System.out.println("Tidak bisa menghapus buku karena masih ada transaksi terkait!");
                    return;
                }
            }
            books.remove(book);
            System.out.println("Buku berhasil dihapus!");
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    public void editUser(String name, String newName) {
        User user = findUser(name);
        if (user != null) {
            for (User existingUser : users) {
                if (existingUser.getName().equalsIgnoreCase(newName)) {
                    System.out.println("Nama baru pengguna sudah ada! Perubahan gagal.");
                    return;
                }
            }
            users.remove(user);
            if (user instanceof Member) {
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

    public void deleteUser(String name) {
        User user = findUser(name);
        if (user != null) {
            for (Transaksi transaksi : arrayTransaksi) {
                if (transaksi.getUser().getName().equalsIgnoreCase(name)) {
                    System.out.println("Tidak bisa menghapus pengguna karena masih ada transaksi terkait!");
                    return;
                }
            }
            users.remove(user);
            System.out.println("Pengguna berhasil dihapus!");
        } else {
            System.out.println("Pengguna tidak ditemukan!");
        }
    }
}
//