
public class AmusementRide {

    private String name;
    private IsraeliQueue<Person> israeliQueue;
    private int maxCapacity;

    public AmusementRide(String name, int maxCapacity) {
        this.name = name;
        this.israeliQueue = new IsraeliQueue<>();
        this.maxCapacity = maxCapacity;
    }


    public void startRide() {
        if (israeliQueue.isEmpty()) {
            System.out.println("Ride is empty.");
            return;
        }

        int capacity = Math.min(israeliQueue.returnSize(), maxCapacity);
        System.out.println("Currently using the ride:");
        for (int i = 0; i < capacity; i++) {
            Person person = israeliQueue.remove();
            System.out.println(person.getName());
        }


    }
    public void addPerson(Person person) {
        israeliQueue.add(person, person.getFriend(person));
    }
}
