package ro.mirodone;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Bruce Banner", 33);
        Employee employee2 = new Employee("Bruce Wayne", 52);
        Employee employee3 = new Employee("Peter Parker", 23);
        Employee employee4 = new Employee("Tony Stark", 42);
        Employee employee5 = new Employee("Diana Prince", 28);
        Employee employee6 = new Employee("Steve Rogers", 37);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);

        System.out.println("Employees over 30: ");
        System.out.println("==============");

        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName() + " " + employee.getAge());
            }
        });

        printEmplByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmplByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);

        Function<Employee, String> getLastName = (employee -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        });

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(firstName);

        for (Employee employee7 : employees) {
            System.out.println(chainedFunction.apply(employee7));
        }
        System.out.println("==================");
        BiFunction<String, Employee, String> concatAge = (name, employee) -> name.concat(" " + employee.getAge());
        String upperName;

//        for (int i = 0; i <employees.size() ; i++){
//            upperName = upperCase.apply(employees.get(i));
//            System.out.println(concatAge.apply(upperName, employees.get(i)));
//        }

        for (Employee employee : employees) {
            upperName = upperCase.apply(employee);
            System.out.println(concatAge.apply(upperName, employee));
        }

    }

    private static void printEmplByAge(List<Employee> employees,
                                       String ageText,
                                       Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=============");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + " " + employee.getAge());
            }
        }

    }
}
