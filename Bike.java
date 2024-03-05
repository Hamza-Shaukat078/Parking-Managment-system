import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Bike extends Vehicle implements Serializable {

    public Bike() {
        super();

    }

    public Bike(String licensePlate, String owner, String type, String vehicleName, double arrivaltime) {
        this.licensePlate = licensePlate;
        this.owner = owner;
        this.type = type;
        this.vehicleName = vehicleName;
        this.arrivaltime = arrivaltime;

    }

    public Bike(Bike b1) {
        this.licensePlate = b1.licensePlate;
        this.owner = b1.owner;
        this.type = b1.type;
        this.vehicleName = b1.vehicleName;
        this.arrivaltime = b1.arrivaltime;

    }

    // setters and getters
    public double getArrivalTime() {
        return arrivaltime;
    }

    public void setArrivalTime(double time) {
        this.arrivaltime = time;
    }

    // display function

    public void display() {
        super.display();

    }

    public String toString() {
        return super.toString();
    }

    // writing to file

    public static void writeToFile(Bike b1) {
        try {
            File f = new File("Bikes.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));

            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));

            }
            oos.writeObject(b1);
            oos.close();

        } catch (IOException e) {
            System.out.println("Error in File Writing");
        }
    }

    // readng from file

    public static ArrayList<Bike> ReadFromFile() {
        ArrayList<Bike> a = new ArrayList<Bike>();
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Bikes.ser"));
            while (true) {
                Object obj = (Object) ois.readObject();
                if (obj instanceof Bike) {
                    Bike c1 = (Bike) obj;
                    a.add(c1);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        } catch (EOFException e) {
            return a;
        } catch (IOException e) {
            System.out.println("catching error");
        }

        return a;
    }

    // updating Bike name

    public static void updateOwnerName(String name, String licenseNo) {
        ArrayList<Bike> c1 = ReadFromFile();
        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getLicensePlate().equalsIgnoreCase(licenseNo)) {
                c1.get(i).setOwner(name);
                break;
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Bikes.ser"));
            for (int i = 0; i < c1.size(); i++) {
                oos.writeObject(c1.get(i));
            }
        } catch (Exception e) {
            System.out.println("error in cars file");

        }
    }

    // deleting Bike

    public static void deleteBike(String licensePlate) {
        ArrayList<Bike> c1 = ReadFromFile();
        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {
                c1.remove(i);
                break;
            }
        }
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Bikes.ser"));
            for (int i = 0; i < c1.size(); i++) {
                oos.writeObject(c1.get(i));
            }
        } catch (Exception e) {
            System.out.println("error in Bikes file");

        }
    }

    // displaying file
    public static void displayFile() {

        ArrayList<Bike> c1 = ReadFromFile();
        for (int i = 0; i < c1.size(); i++) {
            System.out.println("--------Bike No" + i + "---------------");
            c1.get(i).display();
        }
    }
    // Searching from file

    public static boolean SearchFromFile(String licensePlate) {

        ArrayList<Bike> ppt = new ArrayList<Bike>();
        ppt = ReadFromFile();
        for (int i = 0; i < ppt.size(); i++) {
            if (ppt.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {

                return true;

            }
        }

        return false;
    }

    // deleting a file
    public static void deleteFile(String fileName) {
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
