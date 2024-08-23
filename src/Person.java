
public class Person {
    private final String studentName;
    private final int id;
    private final Person friend;
    private int friendCounter;

    public Person(String studentName, int id, Person friend) {
        this.studentName = studentName;
        this.id = id;
        this.friend = friend;
        this.friendCounter = 0 ;
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

    public int getFriendCounter() {
        return this.friendCounter;
    }

    public void incraementCounter()
    {
        this.friendCounter++;
    }


}
