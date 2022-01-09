package ru.skystudent;

public class EmployeeBook {
    private static Employee[] employees;
    private static int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public static void addEmployee(String names, int department, float salary) {
        if (size >= 10) {
            System.out.println("В компании максимальное число сотрудников, новых не набираем!");
        }
        Employee newEmployee = new Employee(names, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                size++;
                return;
            }
        }
    }

    public static void removeEmployee(int employeeId) {
        if (employeeId > size || employeeId < 0) {
            System.out.println("Такого сотрудника не существует!");
            return;
        }
        for (int i = 0; i <= employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            int currentEmployeeId = employees[i].getId();
            String deletedEmployee = employees[i].getNames();
            if (currentEmployeeId == employeeId) {
                employees[i] = null;
                size--;
                System.out.println("Сотрудник " + deletedEmployee + " удален.");
                return;
            }
        }
    }

    public static void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                System.out.println("Должность свободна");
                continue;
            }
            System.out.println(employees[i]);
        }
    }

    public static int getEmployeesNumberInDepartment(int department) {
        int employeesInDepartment = 0;
        for (int i = 0; i < size -1; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                employeesInDepartment++;
            }
        }
        return employeesInDepartment;
    }

    public static void findEmployeeById(int employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == employeeId) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void getSize() {
        System.out.println("В компании " + size + " сотрудников.");
    }

    public static void findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        float maxSalary = 0;
        for (int i = 0; i < size; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }
        System.out.println("Самая большая зарплата у " + employeeWithMaxSalary.toString());
    }

    public static void findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        float minSalary = employees[0].getSalary();
        for (int i = 1; i < size; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }
        System.out.println("Самая маленькая зарплата у " + employeeWithMinSalary.toString());
    }

    public static float calculateSalaryExpenses() {
        float salaryExpenses = 0f;
        for (int i = 0; i < size; i++) {
            salaryExpenses = salaryExpenses + employees[i].getSalary();
        }
        return salaryExpenses;
    }
    public static void printSalaryExpenses() {
        System.out.println("Расходы на зарплату в месяц составляют " + calculateSalaryExpenses() + " р.");
    }

    public static void printAverageSalary() {
        float averageSalary = 0f;
        averageSalary = calculateSalaryExpenses() / size;
        System.out.println("Средняя зарплата составляет: " + averageSalary + " р.");
    }

    public static void printNames() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getNames());
        }
    }

    public static void increaseSalaryByPercent(float percent) {
        for (int i = 0; i < size; i++) {
            float newSalary = employees[i].getSalary() * (1 + percent / 100f);
            employees[i].setSalary(newSalary);
        }
        System.out.println("Зарплата увеличена всем сотрудникам на " + percent + "%");
    }

    public static void findEmployeeWithMinSalaryInDepartment(int department) {
        Employee employeeWithMinSalary = null;
        float minSalary = employees[0].getSalary();
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == department) {
                if (minSalary >= employees[i].getSalary()) {
                    minSalary = employees[i].getSalary();
                    employeeWithMinSalary = employees[i];
                }
            }
        }
        System.out.println("Самая маленькая зарплата в " + department + " отделе  у сотрудника: " + employeeWithMinSalary.getNames() + " - " + employeeWithMinSalary.getSalary() + " р.");
    }

    public static void findEmployeeWithMaxSalaryInDepartment(int departmentId) {
        Employee employeeWithMaxSalary = null;
        float maxSalary = 0;
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                if (maxSalary <= employees[i].getSalary()) {
                    maxSalary = employees[i].getSalary();
                    employeeWithMaxSalary = employees[i];
                }
            }
        }
        System.out.println("Самая высокая зарплата в " + departmentId + " отделе  у сотрудника: " + employeeWithMaxSalary.getNames() + " - " + employeeWithMaxSalary.getSalary() + " р.");
    }

    public static float getSalaryExpensesInDepartment(int departmentId) {
        float salaryExpenses = 0f;
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                salaryExpenses = salaryExpenses + employees[i].getSalary();
            }
        }
        return salaryExpenses;
    }
    public static void printSalaryExpensesInDepartment(int departmentId) {

        System.out.println("Расходы на зарплату в месяц в " + departmentId + " отделе составляют: " + getSalaryExpensesInDepartment(departmentId) + " р.");
    }

    public static void printAverageSalaryInDepartment(int departmentId) {
        if (EmployeeBook.getEmployeesNumberInDepartment(departmentId) == employees.length) {
            EmployeeBook.printAverageSalary();
            return;
        }else {
            float averageSalary = 0f;
            averageSalary = getSalaryExpensesInDepartment(departmentId) / getEmployeesNumberInDepartment(departmentId);
            System.out.println("Средняя зарплата в " + departmentId + " отделе составляет: " + averageSalary + " р.");
        }
    }

    public static void increaseSalaryInDepartmentByPercent(int departmentId, float percent) {
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                float newSalary = employees[i].getSalary() * (1 + percent / 100f);
                employees[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплата всем сотрудникам " + departmentId + " отдела увеличена на " + percent + "%");
    }

    public static void printEmployeesFromDepartment(int departmentId) {
        System.out.println("Сотрудники " + departmentId + " отдела: ");
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                System.out.println("id: " + employees[i].getId() + " ФИО: " + employees[i].getNames() + " Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public static void editEmployee(String name, float salary, int department) {
        String employeeName = name;
        for (Employee employee : employees) {
            if (employee.getNames().equalsIgnoreCase(employeeName)) {
                employee.setSalary(salary);
                employee.setDepartment(department);
            }
        }
        System.out.println("Данные сотрудника " + name + " были изменены.");
    }

    public static void printAllEmployeesByDepartment() {
        int departmentId = 1;
        while (departmentId != 6) {
            System.out.println();
            System.out.println("Сотрудники " + departmentId + " отдела: ");
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == departmentId) {
                    System.out.println(employees[i].getNames());
                }
            }
            departmentId++;

        }
    }



}



