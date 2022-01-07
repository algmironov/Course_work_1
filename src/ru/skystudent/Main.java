package ru.skystudent;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Сергеев Николай Сергеевич", 1, 75000f);
        employeeBook.addEmployee("Иванов Иван Иванович", 1, 76800f);
        employeeBook.addEmployee("Трифонов Петр Михайлович", 2, 56000f);
        employeeBook.addEmployee("Ульянова Тамара Федоровна", 2, 61200f);
        employeeBook.addEmployee("Петрова Маргарита Михайловна", 3, 72000f);
        employeeBook.addEmployee("Дмитриев Владимир Андреевич", 1, 77550f);
        employeeBook.addEmployee("Зельдин Григорий Семенович", 3, 88000f);
        employeeBook.addEmployee("Смирнов Валентин Михайлович", 4, 89335f);
        employeeBook.addEmployee("Рожкова Татьяна Алексеевна", 4, 91000f);
        employeeBook.addEmployee("Маринина Ольга Дмитриевна", 5, 95600f);

        EmployeeBook.printAllEmployees();

        System.out.println();

        EmployeeBook.findEmployeeById(5);

        System.out.println();

        EmployeeBook.getSize();

        System.out.println();

        EmployeeBook.findEmployeeWithMaxSalary();

        System.out.println();

        EmployeeBook.findEmployeeWithMinSalary();

        System.out.println();

        EmployeeBook.printSalaryExpenses();

        System.out.println();

        EmployeeBook.printAverageSalary();

        System.out.println();

        EmployeeBook.printNames();

        System.out.println();

        EmployeeBook.increaseSalaryByPercent(10);
        EmployeeBook.findEmployeeWithMinSalary();

        EmployeeBook.removeEmployee(8);
        EmployeeBook.printAllEmployees();
        System.out.println();

        employeeBook.getSize();
        employeeBook.findEmployeeById(9);
        System.out.println();

        EmployeeBook.addEmployee("Гаврилов Сергей Сергеевич", 5, 89000f);
        EmployeeBook.printAllEmployees();
        System.out.println();

        EmployeeBook.findEmployeeWithMinSalaryInDepartment(1);
        System.out.println();

        EmployeeBook.findEmployeeWithMaxSalaryInDepartment(1);
        System.out.println();

        EmployeeBook.printSalaryExpensesInDepartment(1);
        System.out.println();

        EmployeeBook.printAverageSalaryInDepartment(1);
        System.out.println();

        EmployeeBook.increaseSalaryInDepartmentByPercent(1, 10);
        EmployeeBook.printAverageSalaryInDepartment(1);
        System.out.println();

        EmployeeBook.printEmployeesFromDepartment(1);
        System.out.println();

        EmployeeBook.editEmployee("Сергеев Николай Сергеевич", 95000, 4);
        EmployeeBook.printAllEmployees();
        System.out.println();

        EmployeeBook.printAllEmployeesByDepartment();
        System.out.println();









    }
}
