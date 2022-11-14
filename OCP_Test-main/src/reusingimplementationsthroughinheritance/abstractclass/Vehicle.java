package reusingimplementationsthroughinheritance.abstractclass;

// Vehicle is our most general entity and will never be an
// actual instance.
abstract class Vehicle {

    // We create an enum which describes possible subclasses
    protected enum VehicleType {
        Automobile, Motorcycle, Moped, Bicycle, Scooter
    }

    // We define some attributes all vehicles would have in common
    private VehicleType type;
    private String owner;
    private String make;

    // Constructor will be the method we use to set data
    public Vehicle(VehicleType type, String owner, String make) {
        this.type = type;
        this.owner = owner;
        this.make = make;
    }

    // We use IntelliJ's generated toString method
    public String toString() {
        return "Vehicle{" +
                "type=" + type +
                ", owner='" + owner + '\'' +
                ", make='" + make + '\'' +
                '}';
    }

    // We create methods we want concrete subclasses to be forced to
    // implement
    public abstract void drive();

    public abstract void park();

    public abstract void makeNoise();

    private void sayHello() {
        System.out.println("Hello from Vehicle");
    }

    void sayHello2() {
        System.out.println("Hello2 from Vehicle");
    }
}