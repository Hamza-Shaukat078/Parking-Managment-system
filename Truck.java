import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Truck extends Vehicle implements Serializable{
   
    public Truck()
    {
        super();
    }
    public Truck(String licensePlate, String owner, String type,String vehicleName,double arrivaltime) {
        this.licensePlate = licensePlate;
        this.owner= owner;
        this.type = type;
        this.vehicleName= vehicleName;
        this.arrivaltime= arrivaltime;
     
    }

    public Truck(Truck t1) {
        this.licensePlate = t1.licensePlate;
        this.owner= t1.owner;
        this.type = t1.type;
        this.vehicleName= t1.vehicleName;
        this.arrivaltime= t1.arrivaltime;

    }
    // setters and getters
    public double getArrivaltime() {
        return arrivaltime;
    }
    public void setArrivaltime(double arrivaltime) {
        this.arrivaltime = arrivaltime;
    }
    // display function

    public void display()
    {
        super.display();
       
    }
    
    public String toString() {
        return ""+super.toString();
    }
       // writing to file

    public static void writeToFile(Truck b1) {
        try {
            File f = new File("Trucks.ser");
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
 
    public static ArrayList<Truck> ReadFromFile() {
        ArrayList<Truck> a = new ArrayList<Truck>();
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Trucks.ser"));
            while (true) {
                Object obj = (Object) ois.readObject();
                if (obj instanceof Truck) {
                    Truck c1 = (Truck) obj;
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

    // updating Truck name

   
    public static void updateOwnerName(String name,String licenseNo) {
        ArrayList<Truck> c1 = ReadFromFile();
        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getLicensePlate().equalsIgnoreCase(licenseNo)) {
                c1.get(i).setOwner(name);
                break;
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Trucks.ser"));
            for (int i = 0; i < c1.size(); i++) {
                oos.writeObject(c1.get(i));
            }
        } catch (Exception e) {
            System.out.println("error in cars file");

        }
    }

    // deleting Truck

    public static void deleteTruck(String licensePlate) {
        ArrayList<Truck> c1 = ReadFromFile();
        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {
                c1.remove(i);
                break;
            }
        }
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Trucks.ser"));
            for (int i = 0; i < c1.size(); i++) {
                oos.writeObject(c1.get(i));
            }
        } catch (Exception e) {
            System.out.println("error in Trucks file");

        }
    }
    // displaying file
    public static void displayFile() {

        ArrayList<Truck> c1 = ReadFromFile();
        for (int i = 0; i < c1.size(); i++) {
            System.out.println("--------Truck No" + i + "---------------");
            c1.get(i).display();
        }
    }
    // Searching from file

    public static boolean SearchFromFile(String licensePlate) {

        ArrayList<Truck> ppt = new ArrayList<Truck>();
        ppt = ReadFromFile();
        for (int i = 0; i < ppt.size(); i++) {
            if (ppt.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {

                return true;

            }
        }

        return false;
    }
    
    //  deleting  a file
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
