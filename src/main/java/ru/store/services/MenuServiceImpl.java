package ru.store.services;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final PhoneService phoneService;
    private final ClientService clientService;
    private final Scanner scanner;
    @Override
    public void menu() {
        while (true) {
            printMenu();
            System.out.println();
            System.out.println("Введите номер меню");
            int menuNum = scanner.nextInt();

            if (menuNum == 1) {
                System.out.println();
                System.out.println("Вы выбрали посмотреть список телефонов");
                phoneService.printPhone();
            } else if (menuNum == 2) {
                System.out.println();
                System.out.println("Вы выбрали положить телефон в корзину");
                clientService.putPhone();
            } else if (menuNum == 3) {
                System.out.println();
                System.out.println("Вы выбрали выложить телефон из корзины");
                clientService.removePhone();
            } else if (menuNum == 4){
                System.out.println();
                System.out.println("Посмотреть содержимое корзины");
                clientService.printPhoneFromBasket();
            } else if (menuNum == 5) {
                System.out.println();
                System.out.println("Купить содержимое корзины");
                clientService.buyPhones();
            } else {
                System.out.println();
                System.out.println("Выход");
                System.out.println("Досвидания");
                break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println();
        System.out.print("Меню: ");
        System.out.println("1 - Каталог; 2 - Положить в корзину; 3 - Выложить из корзины; " +
                "4 - Посмотреть содержимое корзины; 5 - Купить содержимое корзины; Все остальное выход");
    }
}
