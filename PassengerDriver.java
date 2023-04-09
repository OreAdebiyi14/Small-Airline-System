import java.util.Scanner;
import java.util.ArrayList;
public class PassengerDriver
{
    //declaring the arrayLists for both classes
    ArrayList<Flight> listOfFlights;
    final int number_OfFlights = 5; //number of flights in the system

    ArrayList<Passenger> listOfPassengers;
    final int NUM_OFSEATS = 10; //number of seats available in each flight
    
    public PassengerDriver ()
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("\f");
        
        //passengers arrayList which is blank
        listOfPassengers = new ArrayList<Passenger>();
        //flight arrayList which is blank
        listOfFlights = new ArrayList<Flight>();
        
        CreateFlights();
        menu();
    }

    /** Creating 5 new flights for the user to input */
    public void CreateFlights()
    {
        //Input 5 flight details
        //Create variables
        //Ask user to Input flight number
        //Ask user to Input destination
        //Ask user to Input day
        //Input and Validate Results
        
        Scanner scan = new Scanner(System.in);

        Flight aFlight;

        String number;
        String day;
        String destination;
        
        /
        System.out.println("Please enter flight Information: ");
        for(int count = 0; count < 2; count++)
        {
            System.out.print("Enter Flight Number: ");
            number = scan.nextLine();
            if(number.charAt(0) == ('E') && number.charAt(1) == ('I') && (number.length() != 4))
            {
            System.out.print("Enter day of flight (Mon, Tue... ): ");
            day = scan.nextLine();
            System.out.print("Enter flight destination (Paris, london...): ");
            destination = scan.nextLine();
            
            aFlight = new Flight(number, day, destination, 10);   
            listOfFlights.add(aFlight);
            
            System.out.print("\n");
            }
            else
            {
            System.out.print("Sorry flight number has to start with (EI) to continue");
            }
            
        }
        /*
       
         aFlight= new Flight ("EI111", "Mon", "Spain", 10);
         listOfFlights.add(aFlight);
         
         aFlight= new Flight ("EI222", "Tue", "Germany", 10);
         listOfFlights.add(aFlight);
         
         aFlight= new Flight ("EI333", "Wed", "italy", 10);
         listOfFlights.add(aFlight);
         
         aFlight= new Flight ("EI444", "Thur", "america", 10);
         listOfFlights.add(aFlight);
         
         aFlight= new Flight ("EI555", "Fri", "Hungary", 10);
         listOfFlights.add(aFlight);
       
         */
    }

    public void menu()
    {
        //create 6 menu options for the passenger to pick from
        //ask user to input a number
        //execute the number option
        Scanner scan = new Scanner(System.in);
        int menuOption;

        do
        {
            System.out.print("\f");
            System.out.println("Welcome to Air flights, Below is a menu please choose an option \n\n");

            System.out.println("1. Book a flight");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Display Full flight schedule");
            System.out.println("4. Display Passenger bookings");
            System.out.println("5. Flight Special");
            System.out.println("6. Exit system");
            do
            {

                System.out.println("Enter a Menu option: ");
                menuOption = scan.nextInt();    scan.nextLine();
                System.out.print("\f");

                if (menuOption != 1 && menuOption != 2 && menuOption != 3 && menuOption != 4 && menuOption != 5 && menuOption != 6)
                {
                    System.out.print("ERROR - Option should be 1,2,3,4,5 or 6");
                }

            }while(menuOption != 1 && menuOption != 2  && menuOption != 3 && menuOption != 4 && menuOption != 5 && menuOption != 6 );

            if (menuOption == 1)
            { 
                bookFlight();
            }
            else if (menuOption == 2)
            {
                cancel();
            }
            else if (menuOption == 3)
            {
                DisplayFlight();
            }
            else if (menuOption == 4)
            {
                DisplayPassenger();
            }
            else if (menuOption == 5)
            {
                Special();
            }
            else
            {
                Exit();
            }
            scan.nextLine();
        }while(menuOption != 6);
    } 

    public void bookFlight()
    {
        /** ask user to input the destination and day of travel
         *  search the flight list 
         *  if the flight exist and there is seats then the passengers details are inputted
         *  store details in passengers list
         *  inform user of bookings
         *  take one seat away from seats
         *  if flight is full inform user of this
         *  then offer other flights or return to menu()
         */
        Scanner scan = new Scanner(System.in);
        String name , address , email, food;
        String destination , day;
        int seats;
        Passenger Passenger0;
        Flight location;
        
        System.out.print("Enter destination: ");
        destination = scan.nextLine();

        System.out.print("Enter day of travel: ");
        day = scan.nextLine();
            
        location = getFlightLocation(destination , day);

            if(location == null)
            {
                System.out.print("Sorry - There is no flight with this destination or day ");
            }
            else
            {
                System.out.println("The flight exist " + location.getFlightNumber());
                
                System.out.println("\f");
                
                System.out.println("Please enter your personel details \n\n");     
                
                System.out.print("Please enter your name: ");
                name = scan.nextLine();
                
                System.out.print("Please enter email: ");
                email = scan.nextLine();
                
                System.out.print("Please enter amount of seats needed: ");
                seats = scan.nextInt();   scan.nextLine();
                
                Passenger0 = new Passenger(name , seats , email ,null , null);
                Passenger0.setAddress(location);
                listOfPassengers.add(Passenger0); 

                
                seats = Passenger0.getAddress().getSeats();
                seats--;
                Passenger0.getAddress().setSeats(seats);
                
                System.out.println("\f");
                System.out.println("Your flight is booked -- \n");
                
                location.flightReceipt();
                
        }
      }

   public Flight getFlightLocation (String destination , String day)
    {
        Flight location = null;
        
        for (Flight f: listOfFlights )
        {
            if (destination.equalsIgnoreCase(f.getDestination()) && day.equalsIgnoreCase(f.getDay()))
            {
                location = f;
            }
        }
        
        return location;
    }
    
   public void cancel()
    {
    //To cancel a booking, the passenger name should be input by the user, followed by a flight number. 
    //The bookings list is searched for this passenger, 
    //if the passenger is found and the flight
    //number that was input matches the flight that they are booked for, then the passenger’s flight
    //variable should be set to null and the number of seats booked on the flight decremented by 1.
     Scanner scan = new Scanner(System.in);

     String booking , name , day; 
     String flightNumber;
     Flight Location;
     int seats; 
     Passenger location;
     Passenger Passenger0;
     
     System.out.print("Do you want to cancel your flight booking? (yes/No) ");
     booking = scan.nextLine();
     
     if (booking.equalsIgnoreCase ("yes") )
     {
         System.out.print("To cancel the booking please input your details \n\n");
     
         System.out.println("Please input your name: ");
         name = scan.nextLine();
     
         System.out.println("Please input the flight number: ");
         flightNumber =scan.nextLine();
         
         System.out.println("Please input amount of seats that was booked: ");
         seats = scan.nextInt(); scan.nextLine(); 
     
         location = getPassengerLocation (name);
         
         for(Passenger p: listOfPassengers)
         {
             
             if (p.getName().equals(name))
             {
                 seats = p.getAddress().getSeats();
                 seats++;
                 p.getAddress().setSeats(seats);
                
                 p.setAddress(null);
                 
             }
             
         }
         
         System.out.print("Your flight has been cancelled if you want to book a flight again please go back to the menu");
         
     }
     else
     {
         System.out.print("Please press enter to return to the menu");
     }
     
 }
 
 public Passenger getPassengerLocation (String name)
 {
        Passenger location = null;
        
        for (Passenger p: listOfPassengers )
        {
            if (name.equalsIgnoreCase(p.getName()) )
            {
                location = p;
            }
        }
        
        return location;
 }
 
 public void DisplayFlight()
 {
     //Display Flight message
     //Call all flights from flight list
     //Display all flight details (number..)
     System.out.print("Displaying all the Flight details: \n ");
        
       for (Flight f: listOfFlights)
        {
            System.out.println(f.toString());
        }
       
 }
 
 public void DisplayPassenger()
 {
     //Display Passenger flight
     //Call all Passengers from list
     //Display all passenger details (name..)
     
     System.out.println("Displaying all passenger details with their flights \n");

        for (Passenger p: listOfPassengers)  /** iterator */
        {
            System.out.println(p.toString());
        }
        
 }
 
 public void Special()
 {
   //Display welcome and explanation message
   //Ask passenger to input flight Number
   //Ask passenger to input food/allergy option
   //Validate input
   //If not a food option display error message
   //5.4 Set food/allergy option to option ("pizza"..)
     
   Scanner scan = new Scanner(System.in);
   String number , food , allergy;
   int foodOption;
   Passenger location;
    
   System.out.println("Welcome to Air Flights special deals \n\n");
    
   System.out.print("Please pick a food option for the flight or Please enter any allergy you have.");
    
   System.out.print("\n Please enter your flight number: ");
   number = scan.nextLine();
    
   System.out.print("\f");
    for(Passenger p: listOfPassengers)
    {
        if (p.getAddress().getFlightNumber().equals(number))
          {
            do
                {
                System.out.println("Here is a list of food options:");
                System.out.println("1. Pizza");
                System.out.println("2. Pasta ");
                System.out.println("3. Fish and Chips");
                System.out.println("4. Chicken Salad");
                System.out.println("5. Snacks ");
                System.out.println("6. Allergy ");
                
                
                do
                {

                System.out.print("Please enter a food option (1,2..): ");
                foodOption = scan.nextInt(); scan.nextLine();
                

                if (foodOption != 1 && foodOption != 2 && foodOption != 3 && foodOption != 4 && foodOption != 5 && foodOption != 6)
                {
                    System.out.print("ERROR - food Option should be either Pizza, Pasta...");
                }

            }while(foodOption != 1 && foodOption != 2  && foodOption != 3 && foodOption != 4 && foodOption != 5 && foodOption != 6);
                
          
            if (foodOption == 1)
            { 
                p.setFood("Pizza");
                System.out.print("Your food Option has been selected and added to your flight");
            }
            else if (foodOption == 2 )
            {
               p.setFood("Pasta");
               System.out.print("Your food Option has been selected and added to your flight");
            }
            else if (foodOption == 3)
            {
               p.setFood("Fish and Chips");
               System.out.print("Your food Option has been selected and added to your flight");
            }
            else if (foodOption == 4)
            {
                p.setFood("Chicken Salad");
                System.out.print("Your food Option has been selected and added to your flight");
            }
            else if (foodOption == 5)
            {
               p.setFood("Snacks ");
               System.out.print("Your food Option has been selected and added to your flight");
            }
            else
            {
                System.out.print("Please input the allergy: "); 
                allergy = scan.nextLine();
                
                p.setAllergy(allergy);
                System.out.print("Your Allergy Option has been selected and added to your flight");
            }
            
          }while(foodOption != 1 && foodOption != 2  && foodOption != 3 && foodOption != 4 && foodOption != 5 && foodOption != 6);
          
        }
        else
        {
            System.out.print("Sorry the flight number is not found!");
        }
   }
 }
 
  
 public void Exit()
 {
     //Display thank you message
     
     System.out.print("Thank you for booking a flight with Air Flights");
 }
 
 public static void main(String[] args)
 {
      new PassengerDriver();
 }
    
    
}