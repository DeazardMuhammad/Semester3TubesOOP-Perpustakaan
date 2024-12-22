public class Transaksi {
    private int transaksiId;
    private User user;
    private Book book;
    private String transaksiType;

    public String getTransaksiType() {
        return transaksiType;
    }

    public Transaksi(int transaksiId, User user, Book book, String transaksiType) {
        this.transaksiId = transaksiId;
        this.user = user;
        this.book = book;
        this.transaksiType = transaksiType;
    }

    public void setTransaksiType(String transaksiType) {
        this.transaksiType = transaksiType;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "ID=" + transaksiId +
                ", Pengguna=" + user.getName() +
                ", Buku=" + book.getIdBook() +
                ", Jenis='" + transaksiType + '\'' +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public int getTransaksiId() {
        return transaksiId;
    }
}
