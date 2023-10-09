package FMS;

public class Customer {
    public String FirstName;
    public String LastName;
    public int age;
    public String PhoneNumber;
    public String custId;
    public String Address;
    Customer(String FirstName,String LastName,int age,String custId,String PhoneNumber,String Address)
    {
        this.age=age;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Address=Address;
        this.PhoneNumber=PhoneNumber;
        this.custId=custId;
    }
}
