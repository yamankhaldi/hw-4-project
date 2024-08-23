public class Park
{
    private final  int numRides = 5 ;
    private  String parkName;
    private AmusementRide[] rides;
    private int counter;



    public Park(String parkName) {
        this.parkName = parkName;
        rides = new AmusementRide[numRides];
        counter = 0 ;
    }
    public  void  add (AmusementRide newRide)
    {
        if (counter < numRides)
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
                rides[--counter] = null;
            }
        }
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
    }
}
