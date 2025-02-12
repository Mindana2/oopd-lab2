import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Workshop<T>{

    private final int numSlots;
    private ArrayList<T> slotList;

    public Workshop(int numSlots) {
        this.slotList = new ArrayList<>(numSlots);
        this.numSlots = numSlots;

        for (int i = 0; i < numSlots; i++) {
            slotList.add(null);
        }
    }


    public int getNumSlots() {
        return this.numSlots;
    }

    public List<T> getSlotList() {
        return this.slotList;
    }


    public void loadCar(T car) {

        for (int x = 0; x < this.getNumSlots(); x++) {

            if (this.slotList.get(x) == null) {
                this.slotList.set(x, car);
                System.out.println(car + " loaded");
                return;
            }

        }
        System.out.println("Workshop is full");
    }


    public void unloadCar(T car) {

        if (this.slotList.contains(car)) {
            System.out.println(car + " of type " + car.getClass() +  " unloaded");
            this.slotList.set(this.slotList.indexOf(car), null);
        }

        else{
            System.out.println(car + " is not in workshop");

        }

    }
}

