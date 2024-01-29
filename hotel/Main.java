package hotel;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        final int max_rooms = 300;
        Integer role = 0;
        
        Room[] rooms = new Room[max_rooms]; 
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        rooms = init_rooms(rooms, max_rooms);

        do{
            System.out.println("*****Welcome to Sunshine Hotel!*****");
            System.out.println("Please choose your role:");
            System.out.println("1. New customer");
            System.out.println("2. Returning customer");
            System.out.println("3. Employee");
            System.out.println("4. Quit");
            role = Integer.parseInt(scan.nextLine()); //Don't use nextInt, doesn't ignore newline
            
            switch(role){
                case 1:
                    new_customer(customers);
                    break;
                case 2:
                    ret_customer(customers);
                    break;
                case 3:
                    emp(employees);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("An error occurred, please restart the program :(");
                    break;
            }
        }while(role != 4);
        scan.close();
    }

    /*Initialize the hotel's rooms 
    and return the initialize array to main */
    static Room[] init_rooms(Room[] r_arr, int size){ 
        for(int i = 0; i < size / 2; i++){ //Create 2 person rooms, price 150 / night
            r_arr[i] = new Room();
            r_arr[i].setMax(2);
            r_arr[i].setPrice(150);
            r_arr[i].setReserved(false);
        }
        for(int i = size / 2; i < size; i++){ //Create 3 person rooms, price 200 / night
            r_arr[i] = new Room();
            r_arr[i].setMax(3);
            r_arr[i].setPrice(200);
            r_arr[i].setReserved(false);
        }
        return r_arr;
    }
    static void new_customer(ArrayList<Customer> cust){
        System.out.println("Welcome new customer to Sunshine Hotel!");
        System.out.println("Please give your details so we can register you to the system.");
        System.out.println("Reservations after this can be made from the returning customer\nmenu with your credentials.");
        int index = cust.size();
        cust.add(new Customer());
        cust.get(index).setId(index + 1);
        System.out.println("Give your first name:");
        cust.get(index).setFname(scan.nextLine());
        System.out.println("Give your last name:");
        cust.get(index).setLname(scan.nextLine());
        System.out.println("Give your email:");
        cust.get(index).setEmail(scan.nextLine());
        System.out.println("Give your phone number:");
        cust.get(index).setPhone(scan.nextLine());

        System.out.println("\n*****Your credentials are*****");
        System.out.println("First name: " + cust.get(index).getFname());
        System.out.println("Last name: " + cust.get(index).getLname());
        System.out.println("Email: " + cust.get(index).getEmail());
        System.out.println("Phone: " + cust.get(index).getPhone());
        System.out.println("Your customer id: " + cust.get(index).getId());
        
    }
    static void ret_customer(ArrayList<Customer> cust){
        System.out.println("Welcome (insert customer name here) to Sunshine Hotel!");
    }
    static void emp(ArrayList<Employee> emp){
        System.out.println("Hello, (employee name here)!");
    }
}
