package FMS;
import java.util.*;
public interface Flight {
    public void addFlight(int FlightId,String Source,String Destination ,String Date,int Seats,int CountCust);

    void DisplayFlight();
}
