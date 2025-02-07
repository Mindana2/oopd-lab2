import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scania scania = new Scania(0.0);


        Saab95 saab95 = new Saab95(false);
        Volvo240 volvo240 = new Volvo240();

        CarTransport cartransport = new CarTransport(false, 10);

        cartransport.lowerRamp();


        cartransport.loadCar(volvo240);

        cartransport.raiseRamp();
        cartransport.startEngine();
        cartransport.gas(1);
        cartransport.move();
        cartransport.stopEngine();
        cartransport.lowerRamp();
        System.out.println((cartransport.getCurrentSpeed()));
        cartransport.unloadCar();
        System.out.println(Arrays.toString(cartransport.getSlotList()));
        System.out.println(volvo240.getyPos());








    }
}



