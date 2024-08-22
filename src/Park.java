public class Park
{
    private  String parkName;
    private AmusementRide[] rides;
    private int counter;



    public Park(String parkName) {
        this.parkName = parkName;
        rides = new AmusementRide[5];
        counter = 0 ;
    }
    public  void  add (AmusementRide newRide)
    {
        if (counter  >= 5)
            System.out.println("Cannot add more rides. Maximum limit reached.");
        else
        {
            rides[counter++] = newRide;
        }


    }
    public void removeRide(AmusementRide newRide) {
        for (int i = 0; i < counter; i++) {
            if (rides[i] == newRide) {
                for (int j = i; j < counter - 1; j++) {
                    rides[j] = rides[j + 1];
                }
                rides[counter - 1] = null;
                counter--;
                System.out.println("Ride removed from the park.");
                return;
            }
        }
        System.out.println("Ride not found in the park.");
    }
    public void startRides() {
        for (int i = 0; i < counter; i++) {
            rides[i].startRide();
        }
    }
    public void addPerson(AmusementRide ride, Person person) {
        for (int i = 0; i < counter; i++) {
            if (rides[i] == ride) {
                rides[i].addPerson(person);
                return;
            }
        }
        System.out.println("Ride not found in the park.");
    }
}
