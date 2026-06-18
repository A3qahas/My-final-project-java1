package Sys;
import java.time.LocalDate;
import java.time.Period;

public class Employee {
    
    private String firstName,lastName;
    private int EID;
    private static int SEID=99;
    private LocalDate employeeBirthDay;
    
    
    public Employee(){
            EID=++SEID;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public LocalDate getEmployeeBirthDay() {
        return employeeBirthDay;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEID() {
        return EID;
    }
    
    public void setEmployeeBirthDay(LocalDate employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }
    
    public int getAge(){
       return Period.between(this.getEmployeeBirthDay(),LocalDate.now()).getYears();
    }

    
}
