import com.sun.org.apache.regexp.internal.RE;
import entity.Car;
import service.CarDealer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Program {
    private static final CarDealer DEALER = new CarDealer("MyDealer");
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {

            switch (READER.readLine()) {
                case "1":
                    addCar();
                    break;
                case "2":
                    printAll();
                    break;
                case "3":
                    getAllByMake();
                    break;
                case "4":
                    getAllByMakeLimit();
                    break;
                case "5":
                    remove();
                    break;
                case "6":
                    removeAllByMake();
                    break;
                case "7":
                    getAllByVolume();
                    break;
                case "8":
                    getAllByPrice();
                    break;
                case "9":
                    getAllByYear();
                    break;
                case "10":
                    update();
                    break;
                case "exit":
                    System.out.println("bye");
                    return;
                default:
                    System.out.println("There is no such option");
            }
        }
    }

    public static void addCar() throws IOException {
        System.out.println("Enter make: ");
        String make = READER.readLine();
        System.out.println("Enter model: ");
        String model = READER.readLine();
        System.out.println("Enter year: ");
        Integer year = Integer.valueOf(READER.readLine());
        System.out.println("Enter volume: ");
        Double volume = Double.valueOf(READER.readLine());
        System.out.println("Enter price: ");
        Integer price = Integer.valueOf(READER.readLine());
        Car car = new Car(make, model, year, price, volume);
        if (DEALER.addCar(car)) {
            System.out.println("car added");
        } else {
            System.out.println("car " + car + " already exists");
        }
    }

    public static void printAll() {
        if (DEALER.getCars().isEmpty()) {
            System.out.println("There is no cars in the set");
            return;
        }
        for (Car car : DEALER.getCars()) {
            System.out.println(car);
        }
    }

    public static void getAllByMake() throws IOException {
        System.out.println("Enter the maker you are looking for: ");
        String make = READER.readLine();

        for (Car car : DEALER.getAllByMake(make)) {
            System.out.println(car);
        }
    }

    public static void getAllByMakeLimit() throws IOException {
        System.out.println("Enter make: ");
        String make = READER.readLine();
        System.out.println("Enter limit: ");
        Integer limit = Integer.valueOf(READER.readLine());
        for (Car car : DEALER.getAllByMake(make, limit)) {
            System.out.println(car);
        }
    }

    public static void remove() throws IOException {
        System.out.println("Enter make: ");
        String make = READER.readLine();
        System.out.println("Enter model: ");
        String model = READER.readLine();
        System.out.println("Enter year: ");
        Integer year = Integer.valueOf(READER.readLine());
        System.out.println("Enter volume: ");
        Double volume = Double.valueOf(READER.readLine());
        System.out.println("Enter price: ");
        Integer price = Integer.valueOf(READER.readLine());
        Car car = new Car(make, model, year, price, volume);
        if (DEALER.remove(car)) {
            System.out.println("car removed");
        } else {
            System.out.println("car " + car + " is not exists");
        }
    }

    public static void removeAllByMake() throws IOException {
        System.out.println("Enter the maker you are looking for: ");
        String make = READER.readLine();
        if (!DEALER.removeAllByMake(make)) {
            System.out.println("There is no car of this maker");
        } else {
            System.out.println("Cars removed ");
        }
    }

    public static void getAllByVolume() throws IOException {
        System.out.println("Enter a volume from: ");
        Double from = Double.valueOf(READER.readLine());
        System.out.println("Enter a volume to: ");
        Double to = Double.valueOf(READER.readLine());

        for (Car car : DEALER.getAllByVolume(from, to)) {
                System.out.println(car);
            }
    }

    public static void getAllByPrice() throws IOException {
        System.out.println("Enter a price from: ");
        Integer from = Integer.valueOf(READER.readLine());
        System.out.println("Enter a price to: ");
        Integer to = Integer.valueOf(READER.readLine());

            for (Car car : DEALER.getAllByPrice(from, to)) {
                System.out.println(car);
            }
    }

    public static void getAllByYear() throws IOException {
        System.out.println("Enter a year from: ");
        Integer from = Integer.valueOf(READER.readLine());
        System.out.println("Enter a year to: ");
        Integer to = Integer.valueOf(READER.readLine());

            for (Car car : DEALER.getAllByYear(from, to)) {
                System.out.println(car);
            }
    }

    public static void update() throws IOException {
        System.out.println("Enter  make of car you want to remove: ");
        String makeOld = READER.readLine();
        System.out.println("Enter model of car you want to remove: ");
        String modelOld = READER.readLine();
        System.out.println("Enter  year of car you want to remove: ");
        Integer yearOld = Integer.valueOf(READER.readLine());
        System.out.println("Enter volume of car you want to remove: ");
        Double volumeOld = Double.valueOf(READER.readLine());
        System.out.println("Enter price of car you want to remove: ");
        Integer priceOld = Integer.valueOf(READER.readLine());
        System.out.println("Enter new make: ");
        Car car = new Car(makeOld, modelOld, yearOld, priceOld, volumeOld);

        String make = READER.readLine();
        System.out.println("Enter new model: ");
        String model = READER.readLine();
        System.out.println("Enter new year: ");
        Integer year = Integer.valueOf(READER.readLine());
        System.out.println("Enter new volume: ");
        Double volume = Double.valueOf(READER.readLine());
        System.out.println("Enter new price: ");
        Integer price = Integer.valueOf(READER.readLine());
        Car carNew = new Car(make, model, year, price, volume);
        if (DEALER.update(car, carNew) != null) {
            System.out.println("Old car remove");
            System.out.println("New car added");
        } else {
            System.out.println("car you want to remove" + car + " is not exists");
        }
    }

}
