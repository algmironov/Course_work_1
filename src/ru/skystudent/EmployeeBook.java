package ru.skystudent;

public class EmployeeBook {
    private static Employee[] employees;
    private static int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String names, int department, float salary) {
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

    public void removeEmployee(int employeeId) {
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

    public void printAllEmployees() {
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

    public void findEmployeeById(int employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == employeeId) {
                System.out.println(employees[i]);
            }
        }
    }

    public void getSize() {
        System.out.println("В компании " + size + " сотрудников.");
    }

    public void findEmployeeWithMaxSalary() {
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

    public void findEmployeeWithMinSalary() {
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
    public void printSalaryExpenses() {
        System.out.println("Расходы на зарплату в месяц составляют " + calculateSalaryExpenses() + " р.");
    }

    public static float getAverageSalary() {
        float averageSalary = 0f;
        averageSalary = calculateSalaryExpenses() / size;
        return averageSalary;
    }

    public void printAverageSalary() {
        System.out.println("Средняя зарплата составляет: " + getAverageSalary() + " р.");
    }

    public void printNames() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getNames());
        }
    }

    public void increaseSalaryByPercent(float percent) {
        for (int i = 0; i < size; i++) {
            float newSalary = employees[i].getSalary() * (1 + percent / 100f);
            employees[i].setSalary(newSalary);
        }
        System.out.println("Зарплата увеличена всем сотрудникам на " + percent + "%");
    }

    public void findEmployeeWithMinSalaryInDepartment(int department) {
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

    public void findEmployeeWithMaxSalaryInDepartment(int departmentId) {
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

    public float getSalaryExpensesInDepartment(int departmentId) {
        float salaryExpenses = 0f;
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                salaryExpenses = salaryExpenses + employees[i].getSalary();
            }
        }
        return salaryExpenses;
    }
    public void printSalaryExpensesInDepartment(int departmentId) {

        System.out.println("Расходы на зарплату в месяц в " + departmentId + " отделе составляют: " + getSalaryExpensesInDepartment(departmentId) + " р.");
    }

    public void printAverageSalaryInDepartment(int departmentId) {
        if (getEmployeesNumberInDepartment(departmentId) == employees.length) {
            printAverageSalary();
            return;
        }else {
            float averageSalary = 0f;
            averageSalary = getSalaryExpensesInDepartment(departmentId) / getEmployeesNumberInDepartment(departmentId);
            System.out.println("Средняя зарплата в " + departmentId + " отделе составляет: " + averageSalary + " р.");
        }
    }

    public void increaseSalaryInDepartmentByPercent(int departmentId, float percent) {
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                float newSalary = employees[i].getSalary() * (1 + percent / 100f);
                employees[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплата всем сотрудникам " + departmentId + " отдела увеличена на " + percent + "%");
    }

    public void printEmployeesFromDepartment(int departmentId) {
        System.out.println("Сотрудники " + departmentId + " отдела: ");
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == departmentId) {
                System.out.println("id: " + employees[i].getId() + " ФИО: " + employees[i].getNames() + " Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public void editEmployee(String name, float salary, int department) {
        String employeeName = name;
        for (Employee employee : employees) {
            if (employee.getNames().equalsIgnoreCase(employeeName)) {
                employee.setSalary(salary);
                employee.setDepartment(department);
            }
        }
        System.out.println("Данные сотрудника " + name + " были изменены.");
    }

    public void printAllEmployeesByDepartment() {
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



