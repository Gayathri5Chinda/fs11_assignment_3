import java.io.*;

class Customer implements Serializable {
    private int id;
    private String name;
    private String contactNo;
    private String address;

    // Constructor
    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Creating a Customer object
        Customer customer = new Customer(1, "John Doe", "1234567890", "123 Main St, City");

        // Serialization
        try {
            // Create FileOutputStream to write object to file
            FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
            // Create ObjectOutputStream to write object
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            // Write object to file
            objectOut.writeObject(customer);
            // Close streams
            objectOut.close();
            fileOut.close();
            System.out.println("Customer object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
