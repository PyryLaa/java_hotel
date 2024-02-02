package business;

public class Customer extends Person {
    private int cust_id;
    final Person.Role role = Person.Role.EMPLOYEE;

    public void setId(int id){
        this.cust_id = id;
    }
    public int getId(){
        return cust_id;
    }
}
