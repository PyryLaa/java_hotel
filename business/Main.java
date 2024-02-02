package business;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Console;


public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        Integer role = 0;
        
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Employee> employees = new ArrayList<Employee>();

        do{
            System.out.println("*****Welcome to Business!*****");
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


    static void new_customer(ArrayList<Customer> cust){
        System.out.println("Welcome new customer to Business!");
        System.out.println("Please give your details so we can register you to the system.");
        System.out.println("Orders after this can be made from the returning customer\nmenu with your credentials.");
        int index = cust.size();
        cust.add(new Customer());
        cust.get(index).setId(index + 1);
        System.out.println("Give your first name:");
        cust.get(index).setFname(scan.nextLine());

        System.out.println("Give your last name:");
        cust.get(index).setLname(scan.nextLine());

        //Users username is format fname.lname
        cust.get(index).setUname(cust.get(index).getFname().toLowerCase()+"."+cust.get(index).getLname().toLowerCase());

        System.out.println("Give your email:");
        cust.get(index).setEmail(scan.nextLine());

        System.out.println("Give your phone number:");
        cust.get(index).setPhone(scan.nextLine());

        System.out.println("Give a password:");
        cust.get(index).setPassword(scan.nextLine());

        System.out.println("Give password again:");
        String check_pass = scan.nextLine();
        while(!(cust.get(index).getPassword().equals(check_pass))){ //If the wrong password is given the second time
            System.out.println("Wrong password given, please type again:");
            check_pass = scan.nextLine();
        }

        System.out.println("\n*****Your credentials are*****");
        System.out.println("First name: " + cust.get(index).getFname());
        System.out.println("Last name: " + cust.get(index).getLname());
        System.out.println("Username: " + cust.get(index).getUname());
        System.out.println("Email: " + cust.get(index).getEmail());
        System.out.println("Phone: " + cust.get(index).getPhone());
        System.out.println("Your customer id: " + cust.get(index).getId());
        
    }
    static void ret_customer(ArrayList<Customer> cust){
        String input;
        System.out.println("Give username: ");
        input = scan.nextLine();
        System.out.println("Welcome (insert customer name here) to Business!");
    }
    static void emp(ArrayList<Employee> emp){
        System.out.println("Hello, (employee name here)!");
    }
}
