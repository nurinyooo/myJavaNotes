package nurullahdur.com.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40","N32",
                "B10","B6",
                "G53","G49","G60","G54","g64",
                "I26","I17","I20",
                "O82");

        List<String> gNumbers = new ArrayList<>();


//        someBingoNumbers.forEach(number ->{
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//            //    System.out.println(number);
//            }
//        });
//        gNumbers.sort((String s1,String s2)->s1.compareTo(s2));
//        gNumbers.forEach((String s)-> System.out.println(s));

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s ->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        System.out.println("**************************");
        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNumberStream);
        System.out.println("======================");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        System.out.println("?????????????????????????????????????");
        Employee nurinyoo = new Employee("Nurinyoo dursun",27);
        Employee rozinyoo = new Employee("Rozinyoo erdemci",22);
        Employee hasan = new Employee("Hasan Topdemir",35);
        Employee ozkan = new Employee("Ozkan Korkmaz",34);

        Department hr = new Department("Human Resources");
        hr.addEmployee(nurinyoo);
        hr.addEmployee(rozinyoo);
        hr.addEmployee(hasan);
        hr.addEmployee(ozkan);

        Department engineer = new Department("Engineer");
        engineer.addEmployee(nurinyoo);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(engineer);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
        System.out.println("____________________-");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s->s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

        for (String s: sortedGNumbers){
            System.out.println(s);
        }

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2)->e1.getAge()<e2.getAge()?e1:e2)
                .ifPresent(System.out::println);

        Stream.of("ABC","AC","BAA","CCC","XY","ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() ==3;
                })
                .count();
    }
}
