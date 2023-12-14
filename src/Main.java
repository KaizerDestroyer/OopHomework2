import java.util.Comparator;
import java.util.TreeSet;

/**
 * Создать класс Employee (сотрудник) со следующими полями:
 * 1. String name - имя
 * 2. int age - возраст
 * 3. double salary - зарплата
 * <p>
 * Необходимо:
 * 0. Создать список из 10-20 рандомных сотрудников.
 * 1. Отсортировать его по убыванию возрастов (от большего к меньшему).
 * 2. Отсортировать его по возрастанию зарплаты.
 * 3. Вывести топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени в алфавитном порядке.
 * 4.* Отсортировать сотрудников по возрастанию возрастов.
 * Если возрасты одинаковые - то по убыванию зарплаты.
 * Если и они равны - в алфавитном порядке.
 */


public class Main {
    public static void main(String[] args) {
//        Comparator<Employee> ageComparator = Comparator.comparingInt(Employee::getAge).reversed(); // 1 пункт
//        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary); // 2 пункт
//        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary).reversed(); // 3 пункт
//        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName); // тоже 3 пункт
        Comparator<Employee> combinedComparator = Comparator // 4 пункт
                .comparingInt(Employee::getAge)  // 4 пункт
                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())  // 4 пункт
                .thenComparing(Employee::getName);  // 4 пункт

//      Задаю сотрудников
        Employee employee1 = new Employee("Ivan", 25, 30000);
        Employee employee2 = new Employee("Peter", 26, 35000);
        Employee employee3 = new Employee("Irina", 27, 40000);
        Employee employee4 = new Employee("Sergey", 28, 45000);
        Employee employee5 = new Employee("Maria", 29, 50000);
        Employee employee6 = new Employee("Alexander", 30, 55000);
        Employee employee7 = new Employee("Elena", 31, 60000);
        Employee employee8 = new Employee("Dmitry", 32, 65000);
        Employee employee9 = new Employee("Olga", 33, 70000);
        Employee employee10 = new Employee("Vasily", 34, 75000);

//      Заполняю коллекцию
        TreeSet<Employee> employeesByAge = new TreeSet<>(combinedComparator);
        employeesByAge.add(employee1);
        employeesByAge.add(employee2);
        employeesByAge.add(employee3);
        employeesByAge.add(employee4);
        employeesByAge.add(employee5);
        employeesByAge.add(employee6);
        employeesByAge.add(employee7);
        employeesByAge.add(employee8);
        employeesByAge.add(employee9);
        employeesByAge.add(employee10);

//        Вывод в консоль
        int count = 0;
        for (Employee employee : employeesByAge) {
            System.out.printf("Name: %s, Age: %d, Salary: $%.2f%n",
                    employee.getName(), employee.getAge(), employee.getSalary());
            count++;
            if(count == 5)
                break;
        }

    }


    public static class Employee {
        private String name;
        private int age;
        private double salary;

//        Конструктор класса Employee
        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

//        Геттеры
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

//        Tostring
        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}