import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParkingSpot implements Serializable {
    static ArrayList<Vehicle> vehicles = new ArrayList<>(100);
    static int count;

    public static void FillingSpots() {
        try {
            ObjectInputStream carInputStream = new ObjectInputStream(new FileInputStream("Cars.ser"));
            while (true) {
                try {
                    Object obj = (Object) carInputStream.readObject();
                    if (obj instanceof Car) {
                        Car c1 = (Car) obj;
                        vehicles.add(c1);

                        count++;

                    }
                } catch (EOFException e) {

                    System.out.println("YOU FAilureeeeee");
                    break;
                }
            }
            carInputStream.close();

            ObjectInputStream bikeInputStream = new ObjectInputStream(new FileInputStream("Bikes.ser"));
            while (true) {
                try {
                    Object obj = (Object) bikeInputStream.readObject();
                    if (obj instanceof Bike) {
                        Bike b1 = (Bike) obj;
                        vehicles.add(b1);

                        count++;

                    }
                } catch (EOFException e) {
                    System.out.println("YOU FAilureeeeee");

                    break;
                }
            }
            bikeInputStream.close();

            ObjectInputStream truckInputStream = new ObjectInputStream(new FileInputStream("Trucks.ser"));
            while (true) {
                try {
                    Object obj = (Object) truckInputStream.readObject();
                    if (obj instanceof Truck) {
                        Truck v1 = (Truck) obj;
                        vehicles.add(v1);

                        count++;

                    }
                } catch (EOFException e) {
                    System.out.println("YOU FAilureeeeee");

                    break;
                }
            }
            truckInputStream.close();

        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception occurred you failed: " );
        }
    }

    public static void numberOfVehicleParked() {
        System.out.println("Total number of vehicles are : " + count);
    }

    public static int numberOfCarsParked() {
        int carCount = 0;
        try {
            ObjectInputStream carInputStream = new ObjectInputStream(new FileInputStream("Cars.ser"));
            while (true) {
                try {
                    Object obj = (Object) carInputStream.readObject();
                    if (obj instanceof Car) {
                        carCount++;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            carInputStream.close();
        } catch (IOException e) {
            System.out.println("Errorrrrrrrrrrr you failure");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }

        return carCount;
    }

    public static int numberOfBikesParked() {
        int bikeCount = 0;
        try {
            ObjectInputStream carInputStream = new ObjectInputStream(new FileInputStream("Bikes.ser"));
            while (true) {
                try {
                    Object obj = (Object) carInputStream.readObject();
                    if (obj instanceof Bike) {
                        bikeCount++;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            carInputStream.close();
        } catch (IOException e) {
            System.out.println("Errorrrrrrrrrrr you failure");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }

        return bikeCount;
    }

    public static int numberOfTruckParked() {
        int truckCount = 0;
        try {
            ObjectInputStream carInputStream = new ObjectInputStream(new FileInputStream("Trucks.ser"));
            while (true) {
                try {
                    Object obj = (Object) carInputStream.readObject();
                    if (obj instanceof Truck) {
                        truckCount++;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            carInputStream.close();
        } catch (IOException e) {
            System.out.println("Errorrrrrrrrrrr you failure");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }

        return truckCount;
    }

    public static int isSpotEmpty() {
        int emptySpots = 0;
        emptySpots = 100 - count;
        return emptySpots;
    }

    public static void displayAllVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).display();
        }

    }

    public static void saveTotalBill(String licensePlate, double totalBill) {
        try {
            File file = new File("totalbills.txt");

            // Check if the file exists
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("Failed to create the file.");
                    return;
                }
            }

            try (FileWriter writer = new FileWriter(file, true)) {
                String entry = String.format("%s: %.2f Rs%n", licensePlate, totalBill);
                writer.write(entry);
                System.out.println("Total bill entry added to the file.");
            }
        } catch (IOException e) {
            System.out.println("Its all your fault you deserve it ");
        }
    }

    public static double calculateGrandTotal() {
        double grandTotal = 0.0;

        try {
            File file = new File("totalbills.txt");

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File not found.");
                return grandTotal;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        double totalBill = Double.parseDouble(parts[1].replace(" Rs", "").trim());
                        grandTotal += totalBill;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Its all your fault you deserve it ");
        }

        return grandTotal;
    }

    public static void writeHistory(Vehicle b1) {
        try {
            File f = new File("History.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));

            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));

            }
            oos.writeObject(b1);
            oos.close();

        } catch (IOException e) {
            System.out.println("Error you failure");
        }
    }

    // deleting a file
    public static void deleteHistoryFile(String fileName) {
        try {
            File fileToDelete = new File(fileName);

            if (fileToDelete.exists()) {
                boolean isDeleted = fileToDelete.delete();
                if (isDeleted) {
                    System.out.println("File " + fileName + " has been deleted.");
                } else {
                    System.out.println("Unable to delete the file " + fileName);
                }
            } else {
                System.out.println("File " + fileName + " does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the file: " + e.getMessage());
        }
    }
}
