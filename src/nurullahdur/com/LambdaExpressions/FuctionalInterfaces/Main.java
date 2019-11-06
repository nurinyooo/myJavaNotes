package nurullahdur.com.LambdaExpressions.FuctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John yok",22);
        Employee nurinyo = new Employee("Nurinyoo dursun",27);
        Employee rozinyo = new Employee("Rozinyo erdemci",23);
        Employee mısra = new Employee("Mısra önel",6);
        Employee red = new Employee("Red white",4);
        Employee charming = new Employee("Price Charming",28);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(rozinyo);
        employeeList.add(nurinyo);
        employeeList.add(mısra);
        employeeList.add(red);
        employeeList.add(charming);

        Function<Employee , String> getLastName = (Employee employee) ->{
            return employee.getName().substring(employee.getName().indexOf(' ') +1);
        };

        String lastName = getLastName.apply(employeeList.get(2));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee)->{
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };


//        System.out.println("Employees over 25:");
//        System.out.println("=====================");
//        employeeList.forEach(employee -> {
//            if(employee.getAge()>25){
//                System.out.println(employee.getName());
//            }
//        });
//
//        System.out.println("\nEmployees 25 and younger:");
//        System.out.println("=============================");
//        employeeList.forEach(employee -> {
//            if(employee.getAge() <=25){
//                System.out.println(employee.getName());
//            }
//        });

//        for(Employee employee : employeeList){
//            if(employee.getAge() >25){
//                System.out.println(employee.getName());
//            }
//        }

//        printEmployeesByAge(employeeList,"Employees over 25",employee -> employee.getAge()>25);
//        printEmployeesByAge(employeeList,"\nEmployees 25 and Younger",employee -> employee.getAge()<=25);
//        printEmployeesByAge(employeeList, "\nEmployees younger than 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge()<25;
//            }
//        });
//        IntPredicate intp = i ->i >15;
//        System.out.println(intp.test(16));
//        System.out.println("*****************************");
//        employeeList.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last Name is : " + lastName);
//        });

        Random random1 = new Random();
        for(Employee employee : employeeList){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName,employee));
            }else {
                System.out.println(getAName(getLastName, employee));
            }
        }
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName =  name -> name.substring(0,name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employeeList.get(0)));

        BiFunction<String ,Employee,String> concatAge = (String name, Employee employee) ->{
            return name.concat(" " + employee.getAge());
        };

        String upperName =upperCase.apply(employeeList.get(0));
        System.out.println(concatAge.apply(upperName,employeeList.get(0)));

        IntUnaryOperator incBy5 = i ->i+5;
        System.out.println(incBy5.applyAsInt(15));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s-> System.out.println(s);
        c1.andThen(c2).accept("Hello World");
    }

    private static String getAName(Function<Employee,String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employeeList,
                                            String agaText,
                                            Predicate<Employee> ageCondition){

        System.out.println(agaText);
        System.out.println("=============================");
        for(Employee employee : employeeList){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
        employeeList.forEach(employee -> {
            if(employee.getAge() <=25){
                System.out.println(employee.getName());
            }
        });
    }



}
