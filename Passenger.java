
public class Passenger
{
    //create the instance variables that are needed
    
    private String name;
    private Flight address;
    private String emailAddress;
    private int seats;
    private String food;
    private String allergy;
    

    //Make 3 constructors
    //make the getter and setter methods for each instance variable 
    //Make a to string to display all info
    public Passenger()
    {
        this.name = " ";
        this.address = null;
        this.emailAddress = " ";
        this.seats = 0;
        this.food = " ";
        this.allergy = " ";
        
    }
    
    public Passenger(String name, int seats, String email, String food, String allergy)
    {
        this.name = name;
        this.address = null;
        this.emailAddress = email;
        this.seats = seats;
        this.food = food;
        this.allergy = allergy;
    }
    
    public Passenger(String name, int Seats, String email, Flight address, String food, String allergy)
    {
        this.name =  name;
        this.address = address;
        this.emailAddress = email;
        this.seats = Seats;
        this.food = food;
        this.allergy = allergy;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Flight getAddress()
    {
        return this.address;
    }
    
    public String getEmail()
    {
        return this.emailAddress;
    }
    
    public int getSeats()
    {
        return this.seats;
    }
    
    public String getFood()
    {
        return this.food;
    }
    
    public String getAllergy()
    {
        return this.allergy;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setAddress(Flight address)
    {
        this.address = address;
    }
    
    public void setEmail(String email)
    {
        this.emailAddress = email;
    }
    
    public void setSeats(int Seats)
    {
        this.seats = Seats;
    }
    
    public void setFood(String food)
    {
        this.food = food;
    }
    
    public void setAllergy(String allergy)
    {
        this.allergy = allergy;
    }
    
    public void PassengerReceipt()
    {
        /**System.out.print("\n");
        System.out.print("Passenger name: " + this.name + "\n");
        System.out.print("Amount of seats booked: "+ this.seats + "\n");
        System.out.print("Food picked: "+  this.food + "\n");
        System.out.print("Allergy: "+ this.allergy);*/
    }
    
    
    public String toString()
    {
        String details = null;
        
        if(this.address == null)
        {
            details = details + "This Passenger has no flight details\n";
        }
        else
        {
        details =  "\nPassengers name: " + this.name + "\n" + 
        "Passengers email: " + this.emailAddress + "\n" + 
        this.address + "\n" +
        "The amount of seats booked: " + this.seats + "\n" + "Food picked for flight: " +
        this.food + "\n" + "Allergy is: " + this.allergy ;
        
        }
        
        return details;
    }    
    
}
