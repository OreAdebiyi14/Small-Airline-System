
public class Flight
{
    //create the instance variables that are needed
    
    private String flightNumber;
    private String day;
    private String destination;
    private int seats;
    
    
    //Make 3 constructors
    //make the getter and setter methods for each instance variable 
    //Make a to string to display all info
    public Flight()
    {
        this.flightNumber = " ";
        this.day = " ";
        this.destination = " ";
        this.seats= 0;
       
    }
    
    public Flight(String number, String day, String destination, int seats)
    {
        this.flightNumber = number;
        this.day = day;
        this.destination = destination;
        this.seats = seats;
        
    }
    
    public String getFlightNumber()
    {
        return this.flightNumber;
    }
    
    public String getDay()
    {
        return this.day;
    }
    
    public String getDestination()
    {
        return this.destination;
    }
    
    public int getSeats()
    {
        return this.seats;
    }
    
    public void setNumber(String number)
    {
        this.flightNumber = number;
    }
    
    public void setDay(String day)
    {
        this.day = day;
    }
    
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    
    public void flightReceipt()
    {
       System.out.print("Flight Number: " + this.flightNumber +"\n");
       System.out.print("Flight Destination: " + this.destination +"\n");
       System.out.print("Day of Travel: "+  this.day);
                
    }
    
    public String toString()
    {
        return "Flight number:" + this.flightNumber + "\n" + 
        "Day of flight:" + this.day + "\n" + 
        "Flight destination: " + this.destination + "\n"+
        "Number of seats on the flight: " + this.seats +"\n";
    }
}
