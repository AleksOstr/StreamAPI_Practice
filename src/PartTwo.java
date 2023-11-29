import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 *
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */

public class PartTwo {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Adam", 25, 20_000.00, "Cleaning department"));
        employees.add(new Employee("Eva", 32, 5_000.00, "Security"));
        employees.add(new Employee("Bill", 43, 20_000.00, "Security"));
        employees.add(new Employee("Daniel", 22, 30_000.00, "Transportation department"));
        employees.add(new Employee("Glen", 42, 9_000.00, "Transportation department"));
        employees.add(new Employee("Danny", 25, 4_000.00, "Loaders department"));
        employees.add(new Employee("Tom", 25, 30_000.00, "Cleaning department"));
        employees.add(new Employee("Jennifer", 25, 10_000.00, "Loaders department"));
        employees.add(new Employee("Valery", 25, 8_000.00, "Security"));
        employees.add(new Employee("Vik", 25, 14_000.00, "Cleaning department"));
        employees.add(new Employee("Lance", 25, 7_000.00, "Security"));
        employees.add(new Employee("Peter", 25, 2_000.00, "Loaders department"));
        employees.add(new Employee("John", 25, 3_000.00, "Transportation department"));
        employees.add(new Employee("Ashley", 25, 8_000.00, "Transportation department"));
        employees.add(new Employee("Dante", 25, 12_000.00, "Cleaning department"));


        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println(employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList());

        // 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        System.out.println(employees.stream()
                .filter(e -> e.getSalary() < 10_000)
                .peek(e -> e.setSalary(e.getSalary() * 1.2))
                .toList());
        // 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> employeeMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeeMap);

        // 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> averageSalaryByDepartmet = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryByDepartmet);
    }
}
