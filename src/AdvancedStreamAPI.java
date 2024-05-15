import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamAPI {
    enum Gender {
        MALE, FEMALE
    }

    record Employee(String name, int age, int salary, Gender gender) {
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 20, 2000, Gender.MALE);
        Employee employee2 = new Employee("Jane", 28, 2000, Gender.FEMALE);
        Employee employee3 = new Employee("Alex", 38, 2750, Gender.MALE);
        Employee employee4 = new Employee("Mary", 35, 3500, Gender.FEMALE);
        Employee employee5 = new Employee("Pedro", 40, 3100, Gender.MALE);

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);

        /**
         * What is the total salary of male employees aged over 25?
         * By chaining filter and mapToDouble operations,
         * we first filter male employees older than 25 and then map their salaries to double values.
         * The sum operation then calculates the total salary of these filtered employees.
         */
        double sum = employees.stream().filter(employee -> employee.gender.equals(Gender.MALE) &&
                employee.age >= 25).mapToDouble(employee -> employee.salary).sum();

        System.out.println(sum);

        /**
         * 2. Does a female employee under the age of 30 named ‘Jane’ exist?
         * We filter the employees to include only those who are female and under the age of 30 using the filter operation.
         * Then, we check if any of these filtered employees have the name “Jane” using the anyMatch operation with a lambda expression
         */
        boolean existed = employees.stream().filter(employee -> employee.gender.equals(Gender.FEMALE) && employee.age < 30)
                .anyMatch(employee -> employee.name.equals("ABC"));
        System.out.println(existed);

        /**
         * What is the total salary budget for all employees?
         */
        Integer sumOfSalaries = employees.stream().map(Employee::salary).reduce(0, Integer::sum);
        System.out.println(sumOfSalaries);

        /**
         * What are the top three highest salaries among the employees?
         */
        List<Integer> top3highestSalaries = employees.stream().map(Employee::salary).distinct()
                .sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(top3highestSalaries);

        /**
         * What is the total salary for each gender group among employees over the age of 20?
         */

        Map<Gender, Integer> integerMap = employees.stream().filter(employee -> employee.age > 20).
                collect(Collectors.groupingBy(Employee::gender, Collectors.summingInt(Employee::salary)));
        System.out.println(integerMap);
    }




}