
import java.io.Serializable;


public class Vehicle implements Serializable{
    protected String licensePlate;
    protected String type;
    protected String owner;
    protected String vehicleName;
    protected double arrivaltime;

    public Vehicle(String licensePlate, String owner, String type,String vehicleName,double arrivaltime ) {
        this.licensePlate = licensePlate;
        this.owner= owner;
        this.type = type;
        this.vehicleName= vehicleName;
        this.arrivaltime=arrivaltime;


    }

    public Vehicle() {
        this.licensePlate = "XXX";
        this.owner = "XXX";
        this.type = "XXX";
        this.vehicleName="XXX";
        this.arrivaltime=0.0;
    }

    // display function
    
    public void display() {
        System.out.println();
        System.out.println("Owner: " + owner);
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("type: " + type);
        System.out.println("Arrival Time: "+arrivaltime);

        
    }

// setters and getters

    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
   
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
     public double getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(double arrivaltime) {
        this.arrivaltime = arrivaltime;
    }
    
    
    public String toString() {
        return  licensePlate +  type +   owner
                + vehicleName ;
    }
    
 public static void main(String[] args) {
    Vehicle v1=new Vehicle("764765", "haha", "car", "var", 8);
    System.out.println(v1.toString());
 }  
}