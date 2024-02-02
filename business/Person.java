package business;

public class Person {
    enum Role{
        CUSTOMER,
        EMPLOYEE
    }
    //Once functioning, store password and user information to separate file
    private String fname, lname, uname, email, phone, password; 

    //Setters
    public void setFname(String fn){
        this.fname = fn;
    }
    public void setLname(String ln){
        this.lname = ln;
    }
    public void setUname(String un){
        this.uname = un;
    }
    public void setEmail(String mail){
        this.email = mail;
    }
    public void setPhone(String num){
        this.phone = num;
    }
    public void setPassword(String pass){
        this.password = pass;
    }

    //Getters
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getUname(){
        return uname;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getPassword(){
        return password;
    }
}
