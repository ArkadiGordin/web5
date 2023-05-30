/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Customer;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ManagerCustomer {

    Scanner scanner;


    public ManagerCustomer() {
        scanner = new Scanner(System.in);
    }
    public void printListCustomer(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i + 1);
            System.out.println(customers[i].getFirstname());
            System.out.println(customers[i].getLastname());
            System.out.println("номер телефона"+customers[i].getPhone());
        }
    }
    public Customer newBuyer() {
        Customer customer = new Customer();
        System.out.print("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.print("Введите номер телефона: ");
        customer.setPhone(scanner.nextLine());
        return customer;
    }

    public void PrintCash(Customer[] customers){
        System.out.println("список покупателей");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i + 1);
            System.out.println(customers[i].getFirstname());
            System.out.println(customers[i].getLastname());
            System.out.println("номер телефона"+customers[i].getPhone());
        }
        System.out.print("Введите ид покупателя и посмотрите кэш: ");
        int balans = scanner.nextInt(); scanner.nextLine();
        int printCash = customers[balans-1].getCash();
        System.out.println("Баланс покупателя: " + printCash);
    }
    public void Refill(Customer[] customers) {
        System.out.println("Выберите покупателя для записи балланса");
        System.out.println("список покупателей");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i + 1);
            System.out.println(customers[i].getFirstname());
            System.out.println(customers[i].getLastname());
            System.out.println("номер телефона"+customers[i].getPhone());
        }
        System.out.print("Введите номер покупателя: ");
        int buyer = scanner.nextInt(); scanner.nextLine();
        System.out.print("Сколько денег желаете добавить на счет? : ");
        int addMoney = scanner.nextInt(); scanner.nextLine();
        int customer = 0;
        int TotalMoney = customers[customer - 1].getCash() + addMoney;
        customers[customer - 1].setCash(TotalMoney);
        System.out.println("Счет пополнен!");
        System.out.println("На счету : " + customers[customer - 1].getCash());

    }
}