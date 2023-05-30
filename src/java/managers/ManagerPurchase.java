/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ManagerPurchase {
    private final Scanner scanner;
    public static int totalSumma;
    public int product;
    public int customer;
    public  int quantityBuyingProduct_final;
    public ManagerPurchase() {
        scanner = new Scanner(System.in);
    }
    public Purchase createStoryList(Product[] products, Customer[] customers) throws IOException {

        String historyProduct = String.valueOf(products[product-1].getTitle());

        Purchase purchase = new Purchase();
        purchase.setHistoryProductName(historyProduct);
        purchase.setHistoryProductPrice(String.valueOf(totalSumma));
        purchase.setHistoryProductQantity(String.valueOf(quantityBuyingProduct_final));
        purchase.setCustomer(customers[customer - 1]);
        purchase.setBuyOnProduct(new GregorianCalendar().getTime());


        return purchase;
    }
    public void buyProduct(Product[] products, Customer[] customers) {
        System.out.println("Список покупателей: ");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i + 1);
            System.out.println(customers[i].getFirstname());
            System.out.println(customers[i].getLastname());
            System.out.println("номер телефона"+customers[i].getPhone());
        }
        System.out.print("Номер покупателя: ");
        customer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.length; j++) {

            System.out.println("."+j + 1);
            System.out.println("Название продукта"+products[j].getTitle());
            System.out.println("Количество"+products[j].getQuantity());
            System.out.println("Цена продукта"+products[j].getPrice());
        }
        System.out.println();
        System.out.print("Выберите товар: ");
        product = scanner.nextInt(); scanner.nextLine();
        System.out.print("Выберите кол-во товара: ");

        int quantityBuyingProduct = scanner.nextInt(); scanner.nextLine();
        int productQuantity = products[product - 1].getQuantity();
        int productPrice = products[product - 1].getPrice();

        if (quantityBuyingProduct <=productQuantity) {
            int totalPrisePushares = productPrice * quantityBuyingProduct;
            if (productPrice > customers[customer - 1].getCash()) {
                System.out.println("Недостаточно средств");
            } else {
                int balance = customers[customer - 1].getCash() - totalPrisePushares;
                customers[customer - 1].setCash(balance);
                int ark = products[product - 1].getQuantity() - quantityBuyingProduct;
                products[product - 1].setQuantity(ark);
                totalSumma = totalPrisePushares;
                quantityBuyingProduct_final = quantityBuyingProduct;

                System.out.println("Балланс: " + balance);
            }
        } else {
            System.out.println("Товара нет");
        }
    }
    public void printListBuys(Purchase[] purchases) {
        for (int i = 0; i < purchases.length; i++) {
            System.out.println(i + 1);
            System.out.println("Название продукта"+purchases[i].getHistoryProductName());
            System.out.println("Цена продукта"+purchases[i].getHistoryProductPrice());
            System.out.println("Колл-во продукта"+purchases[i].getHistoryProductQantity());
            System.out.println("Покупатель"+purchases[i].getCustomer());
            System.out.println(""+purchases[i].getBuyOnProduct());
        }
        System.out.println();
    }



}

    

