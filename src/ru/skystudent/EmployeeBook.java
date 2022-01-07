package ru.skystudent;

public class EmployeeBook {
    private static Employee[] employees;
    private static int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public static void addEmployee(String names, int department, float salary) {
        if (size >= employees.length) {
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

    public static boolean nameIsEmpty(String name) {
        if (name == " ") return true;
        return name.equalsIgnoreCase(" ");
    }

//    public static void addNewEmployee(String names, int department, float salary) {
//        for (int i = 0; i <= size; i++) {
//            Employee employee = employees[i];
//            if (employees[i] == null) {
//                employees[i].setDepartment(department);
//                employees[i].setSalary(salary);
//                employees[i].setNames(names);
//                return;
//            }
//        }
//    }


    public static void removeEmployee(int employeeId) {
        if (employeeId > size || employeeId < 0) {
            System.out.println("Такого сотрудника не существует!");
            return;
        }
        for (int i = 0; i <= employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            int tempEmployee = employees[i].getId();
            String deletedEmployee = employees[i].getNames();
            if (tempEmployee == employeeId) {
                employees[i] = null;
//                employees[i].setSalary(0f);
//                if (i != employees.length - 1) {
//                    System.arraycopy(employees, i + 1, employees, i, size - i);
//                }
//                size--;
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
            System.out.println(employees[i].toString());
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
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employees[i] == null) {
                continue;
            }
            if (employee.getId() == employeeId) {
                System.out.println(employees[i].toString());
                return;
            }
        }
    }

    public static void getSize() {
        int employeeCount = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getSalary() != 0) {
                employeeCount++;
            }
        }

        System.out.println("В компании " + employeeCount + " сотрудников.");
    }

    public static void findEmployeeWithMaxSalary() {
        Employee EmployeeWithMaxSalary = null;
        float maxSalary = 0;
        for (int i = 0; i < size; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                EmployeeWithMaxSalary = employees[i];
            }
        }
        System.out.println("Самая большая зарплата у " + EmployeeWithMaxSalary.toString());
    }

    public static void findEmployeeWithMinSalary() {
        Employee EmployeeWithMinSalary = null;
        float minSalary = 1_000_000f;
        for (int i = 0; i < size; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                EmployeeWithMinSalary = employees[i];
            }
        }
        System.out.println("Самая маленькая зарплата у " + EmployeeWithMinSalary.toString());
    }

    public static void printSalaryExpenses() {
        float salaryExpenses = 0f;
        for (int i = 0; i < size; i++) {
            salaryExpenses = salaryExpenses + employees[i].getSalary();
        }
        System.out.println("Расходы на зарплату в месяц составляют " + salaryExpenses + " р.");
    }

    public static void printAverageSalary() {
        float averageSalary = 0f;
        float salaryExpenses = 0f;
        for (int i = 0; i < size; i++) {
            salaryExpenses = salaryExpenses + employees[i].getSalary();
        }
        averageSalary = salaryExpenses / size;
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
        Employee EmployeeWithMinSalary = null;
        float minSalary = 1_000_000f;
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == department) {
                if (minSalary > employees[i].getSalary()) {
                    minSalary = employees[i].getSalary();
                    EmployeeWithMinSalary = employees[i];
                }
            }
        }
        System.out.println("Самая маленькая зарплата в " + department + " отделе  у сотрудника: " + EmployeeWithMinSalary.getNames() + " - " + EmployeeWithMinSalary.getSalary() + " р.");
    }

    public static void findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee EmployeeWithMaxSalary = null;
        float maxSalary = 0;
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == department) {
                if (maxSalary < employees[i].getSalary()) {
                    maxSalary = employees[i].getSalary();
                    EmployeeWithMaxSalary = employees[i];
                }
            }
        }
        System.out.println("Самая высокая зарплата в " + department + " отделе  у сотрудника: " + EmployeeWithMaxSalary.getNames() + " - " + EmployeeWithMaxSalary.getSalary() + " р.");
    }

    public static void printSalaryExpensesInDepartment(int department) {
        float salaryExpenses = 0f;
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == department) {
                salaryExpenses = salaryExpenses + employees[i].getSalary();
            }
        }
        System.out.println("Расходы на зарплату в месяц в " + department + " отделе составляют: " + salaryExpenses + " р.");
    }

    public static void printAverageSalaryInDepartment(int department) {
        if (EmployeeBook.getEmployeesNumberInDepartment(department) == employees.length) {
            EmployeeBook.printAverageSalary();
            return;
        }else {
            float averageSalary = 0f;
            float salaryExpenses = 0f;
            for (int i = 0; i < size -1; i++) {
                if (employees[i].getDepartment() == department) {
                    salaryExpenses = salaryExpenses + employees[i].getSalary();
                }
            }
            averageSalary = salaryExpenses / EmployeeBook.getEmployeesNumberInDepartment(department);
            System.out.println("Средняя зарплата в " + department + " отделе составляет: " + averageSalary + " р.");
        }
    }

    public static void increaseSalaryInDepartmentByPercent(int department, float percent) {
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == department) {
                float newSalary = employees[i].getSalary() * (1 + percent / 100f);
                employees[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплата всем сотрудникам " + department + " отдела увеличена на " + percent + "%");
    }

    public static void printEmployeesFromDepartment(int department) {
        System.out.println("Сотрудники " + department + " отдела: ");
        for (int i = 0; i < size -1; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("id: " + employees[i].getId() + " ФИО: " + employees[i].getNames() + " Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public static void editEmployee(String name, float salary, int department) {
        String employeeName = name;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getNames().equalsIgnoreCase(employeeName)) {
                if (salary > 0) {
                    employees[i].setSalary(salary);
                }
            if (department != 0 && employees[i].getDepartment() != department) {
                    employees[i].setDepartment(department);
                } else {
                    return;
                }

            }
        }
        System.out.println("Данные сотрудника " + name + " были изменены.");
    }

    public static void printAllEmployeesByDepartment() {
        int department = 1;
        while (department != 6) {
            System.out.println();
            System.out.println("Сотрудники " + department + " отдела: ");
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    System.out.println(employees[i].getNames());
                }
            }
            department++;

        }
    }



}



