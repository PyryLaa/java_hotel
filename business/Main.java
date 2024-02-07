package business;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.Console;
import java.io.IOException;


public class Main {
    static Scanner scan = new Scanner(System.in);
    //Save employee's and customer's data to these files
    static File emp_file = new File("emps.txt");
    static File cust_file = new File("cust.txt");
    public static void main(String[] args){
        Integer role = 0;
        try{
            if(emp_file.createNewFile()){
                System.out.println("Emp file created!");
            }else{
                System.out.println("Emp file exists");
            }
            if(cust_file.createNewFile()){
                System.out.println("Customer file created");
            }else{
                System.out.println("Customer file exists");
            }
        }catch(IOException e){
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
        
        List<Customer> customers = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

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


    static void new_customer(List<Customer> cust){
        Console cons;
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

        if((cons = System.console()) != null){
            char[] pass = cons.readPassword("%s", "Give Password: ");
            char[] check_pass = cons.readPassword("%s", "Give password again:");

            while(!(Arrays.equals(check_pass, pass))){
                System.out.println("Please check that passwords match");
                check_pass = cons.readPassword("%s", "Give password again:");
            }
            cust.get(index).setPassword(String.valueOf(pass));
        }else{
            System.out.println("Console error");
        }

        System.out.println("\n*****Your credentials are*****");
        System.out.println("First name: " + cust.get(index).getFname());
        System.out.println("Last name: " + cust.get(index).getLname());
        System.out.println("Username: " + cust.get(index).getUname());
        System.out.println("Email: " + cust.get(index).getEmail());
        System.out.println("Phone: " + cust.get(index).getPhone());
        System.out.println("Your customer id: " + cust.get(index).getId());
        try{
            FileWriter cust_writer = new FileWriter("cust.txt");
            cust_writer.append(cust.get(index).getValues());
            cust_writer.close();
        }catch(IOException e){
            System.out.println("Error occurred when writing!");
            e.printStackTrace();
        }
        
    }
    static void ret_customer(List<Customer> cust){
        String un;
        char[] pass = null;
        boolean valid = false;
        int index = -1; //-1 to check if username is found or not
        Console cons;
        do{
            System.out.println("Username: ");
            un = scan.nextLine();
            if((cons = System.console()) != null){
                pass = cons.readPassword("%s", "Password: ");
            }else{
                System.out.println("Console error!");
            }
            for(int i = 0; i < cust.size(); i++){ //Check if the username is found
                if(cust.get(i).getUname().equals(un)){
                    index = i;
                    break;
                }
            }
            if(index == -1){
                System.out.println("Username not found!");
            }else{
                if(!(cust.get(index).getPassword().equals(String.valueOf(pass)))){
                    System.out.println("Invalid password!");
                }else{
                    valid = true;
                }
            }
        }while(valid == false);
        System.out.println("Welcome " + cust.get(index).getFname() + " " + cust.get(index).getLname() + " to Business!");

    }
    static void emp(List<Employee> emp){
        System.out.println("Hello, (employee name here)!");
        try{
            FileWriter emps_writer = new FileWriter("emps.txt");
            emps_writer.close();
        }catch(IOException e){
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }
}
