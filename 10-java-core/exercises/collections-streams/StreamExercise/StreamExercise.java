package Optional;


import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise {

    record Employee(
            Long id,
            String name,
            String department,
            double salary,
            int yearsOfService,
            List<String> skills
    ) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1L, "Alice", "Engineering", 85000, 5, List.of("Java", "Python")),
                new Employee(2L, "Bob", "Engineering", 75000, 3, List.of("Java", "JavaScript")),
                new Employee(3L, "Charlie", "Sales", 65000, 7, List.of("Communication", "CRM")),
                new Employee(4L, "Diana", "Engineering", 95000, 8, List.of("Java", "Kotlin", "Go")),
                new Employee(5L, "Eve", "HR", 55000, 2, List.of("Recruiting", "Communication")),
                new Employee(6L, "Frank", "Sales", 70000, 4, List.of("Negotiation", "CRM"))
        );

        System.out.println("1. Engineering employees sorted by salary (desc): " + filterAndSortEngineering(employees));
        System.out.println("2. Employee names in uppercase: " + mapNamesToUpper(employees));
        System.out.println("3. Employees grouped by department: " + groupByDepartment(employees));
        printSalaryStatistics(employees);
        System.out.println("5. All unique skills: " + getAllUniqueSkills(employees));
        System.out.println("6. Employees partitioned by salary > 70000: " + partitionBySalary(employees));
        System.out.println("7. Total years of service: " + totalYearsOfService(employees) + " years");
        System.out.println("8. Departments with average salary > 70000: " + departmentsWithHighAvgSalary(employees));
    }

    private static List<String> filterAndSortEngineering(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.department().equals("Engineering"))
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .map(Employee::name)
                .toList();
    }

    private static List<String> mapNamesToUpper(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.name().toUpperCase())
                .toList();
    }

 
    private static Map<String, List<String>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())));
    }

    private static void printSalaryStatistics(List<Employee> employees) {
        double totalSalary = employees.stream()
                .mapToDouble(Employee::salary)
                .sum();

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));

        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::salary));

        System.out.println("4. Total salary: $" + (int) totalSalary +
                ", Avg by dept: " + avgSalaryByDept +
                ", Highest paid: " + highestPaid.map(Employee::name).orElse("N/A"));
    }


    private static List<String> getAllUniqueSkills(List<Employee> employees) {
        return employees.stream()
                .flatMap(e -> e.skills().stream())
                .distinct()
                .toList();
    }


    private static Map<Boolean, List<String>> partitionBySalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.salary() > 70000,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
    }


    private static int totalYearsOfService(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::yearsOfService)
                .sum();
    }
    private static List<String> departmentsWithHighAvgSalary(List<Employee> employees) {
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));

        return avgSalaryByDept.entrySet().stream()
                .filter(e -> e.getValue() > 70000)
                .map(Map.Entry::getKey)
                .toList();
    }
}