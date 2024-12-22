public class Book {
    private String judul;
    private String author;
    private String idBuku;
    private int quantitas;

    public Book(String judul, String author, String idBuku, int quantitas) {
        this.judul = judul;
        this.author = author;
        this.idBuku = idBuku;
        this.quantitas = quantitas;
    }

    public String getIdBook() {
        return idBuku;
    }

    public int getQuantity() {
        return quantitas;
    }

    public void decreaseQuantity() {
        if (quantitas > 0) quantitas--;
    }

    public void increaseQuantity() {
        quantitas++;
    }

    @Override
    public String toString() {
        return "Buku: " +
                "Judul='" + judul + '\'' +
                ", Penulis='" + author + '\'' +
                ", Kode='" + idBuku + '\'' +
                ", Kuantitas=" + quantitas;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantitas(int quantitas) {
        this.quantitas = quantitas;
    }
}
