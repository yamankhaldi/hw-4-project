public class Person {
    private final String studentName;
    private  final String id;
    private final Person friend;

    public Person(String studentName,String id ,Person friend) {
        this.studentName = studentName;
        this.id = id;
        this.friend = friend;
    }
    @Override
    public String toString()
    {
        return friend.studentName;
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person)) {
            return false;
        }
        Person otherPesron = (Person) other;
        return this.id == otherPesron.id;
    }






















}
