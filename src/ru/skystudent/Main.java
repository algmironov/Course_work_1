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

        employeeBook.printAllEmployees();

        System.out.println();

        employeeBook.findEmployeeById(5);

        System.out.println();

        employeeBook.getSize();

        System.out.println();

        employeeBook.findEmployeeWithMaxSalary();

        System.out.println();

        employeeBook.findEmployeeWithMinSalary();

        System.out.println();

        employeeBook.printSalaryExpenses();

        System.out.println();

        employeeBook.printAverageSalary();

        System.out.println();

        employeeBook.printNames();

        System.out.println();

        employeeBook.increaseSalaryByPercent(10);
        System.out.println();
        employeeBook.findEmployeeWithMinSalary();

        employeeBook.removeEmployee(8);
        System.out.println();
        employeeBook.printAllEmployees();
        System.out.println();

        employeeBook.getSize();
        System.out.println();
        employeeBook.findEmployeeById(9);
        System.out.println();

        employeeBook.addEmployee("Гаврилов Сергей Сергеевич", 5, 89000f);
        System.out.println();
        employeeBook.printAllEmployees();
        System.out.println();

        employeeBook.findEmployeeWithMinSalaryInDepartment(1);
        System.out.println();

        employeeBook.findEmployeeWithMaxSalaryInDepartment(1);
        System.out.println();

        employeeBook.printSalaryExpensesInDepartment(1);
        System.out.println();

        employeeBook.printAverageSalaryInDepartment(1);
        System.out.println();

        employeeBook.increaseSalaryInDepartmentByPercent(1, 10);
        employeeBook.printAverageSalaryInDepartment(1);
        System.out.println();

        employeeBook.printEmployeesFromDepartment(1);
        System.out.println();

        employeeBook.editEmployee("Сергеев Николай Сергеевич", 95000, 4);
        employeeBook.printAllEmployees();
        System.out.println();

        employeeBook.printAllEmployeesByDepartment();
        System.out.println();









    }
}
