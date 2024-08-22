public class Person {
    private final String studentName;
    private final int id;
    private final Person friend;

    public Person(String studentName, int id, Person friend) {
        this.studentName = studentName;
        this.id = id;
        this.friend = friend;
    }

    public Person getFriend(Person person)
    {
        return   person.friend;
    }

    @Override
    public String toString() {
        return studentName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Person)) return false;
        Person otherPerson = (Person) other;
        return this.id == otherPerson.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    public String getName() {
        return studentName;
}
}