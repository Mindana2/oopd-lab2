import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scania scania = new Scania(0.0);

        Saab95 saab95 = new Saab95(false);
        Volvo240 volvo240 = new Volvo240();


        CarTransport cartransport = new CarTransport(false, 10);
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);
        Workshop<Vehicle> generic = new Workshop<>(10);
        Workshop<Car> carWorkshop = new Workshop<>(10);
        Workshop<Truck> truckWorkshop = new Workshop<>(10);



        truckWorkshop.loadCar(scania);
        truckWorkshop.loadCar(cartransport);

        

    }
}



