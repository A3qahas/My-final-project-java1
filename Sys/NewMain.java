package Sys;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class NewMain {
static int number=0;
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        String firstName="",lastName="";
        int option=0,op2=0,EIDS,i=0,op3=0;
        
        boolean forLoop=false;
        ArrayList<Employee> empl=new ArrayList<>();
        
        
        do{
        try{
        System.out.println("Choose your option ");
        System.out.println("1=Add new Employee");
        System.out.println("2=search for Employee");
        System.out.println("3=Update Employee information");
        
        System.out.println("4=Exit");
        
        option=input.nextInt();
        
        if(option==1){
            option1(empl);
        }
        else if(option==2){
            option2(empl);
        }
        else if(option==3){
            option3(empl);
            
        }
        
        
        
        
        }catch(InputMismatchException e){
        System.out.println("ERROR 01 WRONG INPUT number 00");
        input.next();
    }
        
        
        
        }while(option!=4);
        
        
    }
    
    
    public static boolean checkName(String c_firstName){
        int x=0;
        char c;
        for(int i=0;i<c_firstName.length();i++){
            c=c_firstName.charAt(i);
            if(!Character.isLetter(c))
                return false;
            if(Character.isLetter(c)){
               x++; 
            }
        }
        
        if(x>=2)
            return true;
        else
            return false;
    }
    
     public static boolean checkEID(String c_EID){
         if(c_EID.length()>0){
         char c;
         for(int i=0;i<c_EID.length();i++){
         c=c_EID.charAt(i);
         
         if(!Character.isDigit(c))
             return false;
         }
         return true;
     }
         return false;
     }
     
     public static boolean checkDate(String dDate,String mDate,String yDate){
        int day,month,year;
        
         if(dDate.length()==2)
         {
         day=Integer.parseInt(dDate);
         if(day<=31&&day>=1)
         {
             if(mDate.length()==2)
             {
         month=Integer.parseInt(mDate);
         if (month>=01&&month<=12)
         {
             if(yDate.length()==4)
             {
                 year=Integer.parseInt(yDate);
                 if(year>=0001&&year<=9999){
                     return true;
                 }
             }
         }
             }
         }
         }
         return false;
     }
     

    public static void option1(ArrayList<Employee> empl){
    
        Scanner input=new Scanner(System.in);
        String firstName="",lastName="";
        String dayDate,monthDate,yearDate,fullDate;
        LocalDate birthDay;
            
            Employee emp=new Employee();
            empl.add(emp);
            
        do{
        System.out.println("Enter the employee first name ");
        firstName=input.next();
        if (checkName(firstName))
        break;
        
        else
        System.out.println("Invaled name ");
        
        }while (true);
        empl.get(number).setFirstName(firstName);
        
        do{
        System.out.println("Enter the employee last name ");
        lastName=input.next();
        if (checkName(lastName))
        break;
        
        else
        System.out.println("Invaled name ");
        
        }while (true);
        empl.get(number).setLastName(lastName);
        
        do{
            
        try{
            System.out.println("Enter Employee birth day\nFirst the day");
        dayDate=input.next();
        if(dayDate.length()==1){
            dayDate='0'+dayDate;
        }
        System.out.println("Then the month");
        monthDate=input.next();
        if(monthDate.length()==1){
            monthDate='0'+monthDate;
        }
        
        System.out.println("Now the year");
        yearDate=input.next();
        
        if(checkDate(dayDate,monthDate,yearDate)){
            fullDate=yearDate+'-'+monthDate+'-'+dayDate;
            birthDay=LocalDate.parse(fullDate);
           empl.get(number).setEmployeeBirthDay(birthDay);
           break;
        } else {
            System.out.println("Wrong date");
        }
            
        }catch(Exception e){
            System.out.println("Wrong Date 001");
        }
        }while(true);
       
        
        number++;
        }
    
    public  static void option2(ArrayList<Employee> empl){
        Scanner input=new Scanner(System.in);
        int op2=0,i,EIDS;
        String firstName="",lastName="";
        boolean tillDone=false;
        do{
            try{
            System.out.println("Enter your option ");
            System.out.println("1=Search for Employee using hes name ");
            System.out.println("2=Search for Employee using hes ID ");
            System.out.println("3=see all Employee ");
            System.out.println("4=Exit");    
            
            op2=input.nextInt();
            
            if(op2==1){
                System.out.println("Enter the full name of the Employee  ");
                firstName=input.next();
                lastName=input.next();
                
                tillDone=false;
                 
                for(int j=0;j<empl.size();j++){
                    if(empl.get(j).getFirstName().equals(firstName) && empl.get(j).getLastName().equals(lastName)){
                    System.out.println("Employee number "+(j+1)+"\n his name is "+empl.get(j).getFirstName()+" "+empl.get(j).getLastName()+"\n his id = "+empl.get(j).getEID());
                    System.out.println(" his "+empl.get(j).getAge()+" years old\n------------------");
                    tillDone=true;
                    
                    
                    }
                    
                   
                    }
                if(tillDone){
                    
                }
                 else{
                        System.out.println("I couldn't find it :( ");
                              
                    
                }
            }
            else if(op2==2){
                System.out.println("Enter the Employee ID ");
                EIDS=input.nextInt();
                tillDone=false;
                for(int j=0;j<empl.size();j++){
                                    
                    if(empl.get(j).getEID()==EIDS){
                    System.out.println("Employee number "+(j+1)+"\n his name is "+empl.get(j).getFirstName()+" "+empl.get(j).getLastName()+"\n his id = "+empl.get(j).getEID());
                    System.out.println(" his "+empl.get(j).getAge()+" years old\n------------------");
                    tillDone=true;
                    }
                    
                    
                }
                if(tillDone==false)
                    System.out.println("Wrong ID");
         
            } else if(op2==3){
                
                if(empl.size()>0){
                for(int j=0;j<empl.size();j++){
                    System.out.println("Employee number "+(j+1)+"\n his name is "+empl.get(j).getFirstName()+" "+empl.get(j).getLastName()+"\n his id = "+empl.get(j).getEID());
                    System.out.println(" his "+empl.get(j).getAge()+" years old\n------------------");
                }
                }else
                    System.out.println("There is no Employee information\n----------------");                
            }
         
            }catch(InputMismatchException e2){
        System.out.println("ERROR 02 WRONG INPUT ");
        input.next();
            }
            
            }while(op2!=4);
    }
    
    public static void option3(ArrayList<Employee> empl){
        Scanner input=new Scanner(System.in);
        int IDS=0,IDF=0,opt3=0;
        String firstName,lastName,dayDate,monthDate,yearDate,fullDate;
        LocalDate birthDay;
        do{
            try{
            System.out.println("Enter the employee ID /-1=Exit");
            IDS=input.nextInt();
        
        
        for (int i=0;i<empl.size();i++){
            if(IDS==empl.get(i).getEID()){
                do{
                    System.out.println("Choose the option\n1=Update Employee Name\n2=Update Employee Birth Day\n3=Exit");
                 opt3=input.nextInt();
                
                 if(opt3==1){
                     do{
        System.out.println("Enter the employee first name ");
        firstName=input.next();
        if (checkName(firstName))
        break;
        
        else
        System.out.println("Invaled name ");
        
        }while (true);
        empl.get(i).setFirstName(firstName);                     
                     
        do{
        System.out.println("Enter the employee last name ");
        lastName=input.next();
        if (checkName(lastName))
        break;
        
        else
        System.out.println("Invaled name ");
        
        }while (true);
        empl.get(i).setLastName(lastName);
        
                 } 
                 else if(opt3==2){
                             do{
            
        try{
            System.out.println("Enter Employee birth day\nFirst the day");
        dayDate=input.next();
        if(dayDate.length()==1){
            dayDate='0'+dayDate;
        }
        System.out.println("Then the month");
        monthDate=input.next();
        if(monthDate.length()==1){
            monthDate='0'+monthDate;
        }
        
        System.out.println("Now the year");
        yearDate=input.next();
        
        if(checkDate(dayDate,monthDate,yearDate)){
            fullDate=yearDate+'-'+monthDate+'-'+dayDate;
            birthDay=LocalDate.parse(fullDate);
           empl.get(i).setEmployeeBirthDay(birthDay);
           break;
        } else {
            System.out.println("Wrong date");
        }
            
        }catch(Exception e){
            System.out.println("Wrong Date 001");
        }
        }while(true);

                 }
            
                }while(opt3!=3);
        }
        }    
        }catch(InputMismatchException e2){
        System.out.println("ERROR 03 WRONG INPUT ");
        input.next();
            }
            
        }while(IDS!=-1);
        
        
        
    }
        
}

