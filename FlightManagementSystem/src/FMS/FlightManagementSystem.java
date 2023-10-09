package FMS;

public class FlightManagementSystem implements Flight{
    int FlightId,Seats,CountCust;
    String Source,Destination,Date;
    Customer []customer=new Customer[100];

    @Override
    public void addFlight(int FlightId,String Source,String Destination ,String Date,int Seats,int CountCust)
    {
        this.FlightId=FlightId;
        this.Source=Source;
        this.Destination=Destination;
        this.Date=Date;
        this.Seats=Seats;
        this.CountCust=CountCust;
    }
    @Override
    public void DisplayFlight() {
        System.out.println("Flight Id: " + this.FlightId);
        System.out.println("Destination: " + this.Destination);
        System.out.println("Start Point: " + this.Source);
        System.out.println("Date: " + this.Date);
        System.out.println("Seats Available: " + this.Seats);
    }

}
