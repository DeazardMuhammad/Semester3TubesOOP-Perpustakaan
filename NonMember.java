public class NonMember extends User {
    private boolean hasBorrowedBook = false;

    public NonMember(String name) {
        super(name);
    }

    @Override
    public boolean borrowBook(Book book) {
        if (hasBorrowedBook) return false;
        hasBorrowedBook = true;
        return true;
    }

    @Override
    public boolean returnBook(Book book) {
        if (!hasBorrowedBook) return false;
        hasBorrowedBook = false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " (Non Anggota)";
    }
}
