package hotel;

public class Person {
    enum Role{
        CUSTOMER,
        EMPLOYEE
    }
    private String fname, lname, email, phone;
    public void setFname(String fn){
        this.fname = fn;
    }
    public void setLname(String ln){
        this.lname = ln;
    }
    public void setEmail(String mail){
        this.email = mail;
    }
    public void setPhone(String num){
        this.phone = num;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
}
