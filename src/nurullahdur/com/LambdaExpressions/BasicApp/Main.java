package nurullahdur.com.LambdaExpressions.BasicApp;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John",22);
        Employee nurinyo = new Employee("Nurinyoo",27);
        Employee rozinyo = new Employee("Rozinyo",23);
        Employee mısra = new Employee("Mısra",6);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(rozinyo);
        employeeList.add(nurinyo);
        employeeList.add(mısra);

       employeeList.forEach(employee -> {
           System.out.println(employee.getAge());
           System.out.println(employee.getName());
       });

       Collections.sort(employeeList, ( employee1, employee2)->
            employee1.getName().compareTo(employee2.getName() ));

        for(Employee employee : employeeList){
        //    System.out.println(employee.getName());
        }
//        String sillyString =doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },employeeList.get(0).getName(),employeeList.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat uc = (String s1,String s2)->{
            String result=s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(uc,employeeList.get(0).getName(),employeeList.get(1).getName());
      //  System.out.println(sillyString);
        AnotherClass s = new AnotherClass();
    //    System.out.println(s.doSomething());
    }
    public final static String doStringStuff(UpperConcat uc, String s1,String s2){

        return uc.upperAndConcat(s1,s2);

    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1,String s2);
}

class AnotherClass {
    public String doSomething(){

        UpperConcat uc = (s1,s2) ->{
    //        System.out.println("Lambda Expressions's class is" + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

      //  System.out.println("The AnotherClass's name is : " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1","String2");
//            UpperConcat uc = (s1,s2)->{
//                System.out.println("The Lambda Expressions class is " + getClass().getSimpleName());
//                System.out.println("i in the lambda expression = " + i );
//                String result = s1.toUpperCase() + s2.toUpperCase();
//                return result;
//            };

//        System.out.println("The AnotherClass's name is : " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },"String1","String2");
    }
    public void printValue(){
        int number =25;

        Runnable r = () ->{
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
          System.out.println("The Value is " + number);
        };
        new Thread(r).start();
    }
}
