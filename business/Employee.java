package business;

public class Employee extends Person {
    private int emp_id;
    final Person.Role role = Person.Role.EMPLOYEE; 
    public void setId(int id){
        this.emp_id = id;
    }
    public int getId(){
        return emp_id;
    }
}
