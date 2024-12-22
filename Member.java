public class Member extends User {
    private String memberId;

    public Member(String name, String memberId) {
        super(name);
        this.memberId = memberId;
    }

    @Override
    public boolean borrowBook(Book book) {
        return true;
    }

    @Override
    public boolean returnBook(Book book) {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID Anggota='" + memberId + "'";
    }

    public String getMemberId() {
        return memberId;
    }
    
}
