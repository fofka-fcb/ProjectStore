package ru.store.services;

import lombok.RequiredArgsConstructor;
import ru.store.domain.ClientOfStore;

import java.util.Scanner;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final Scanner scanner;
    private final PhoneService phoneService;
    private final ClientOfStore client;

    @Override
    public void putPhone() {
        System.out.println("Введите модель телефона: ");
        String model = scanner.next();
        phoneService.putPhone(model);
    }

    @Override
    public void removePhone() {
        System.out.println("Введите модель телефона: ");
        String model = scanner.next();
        phoneService.removePhone(model);
    }

    @Override
    public void printPhoneFromBasket(){
        System.out.println("Корзина " + client.getName() + ": ");
        phoneService.printBasket();
    }

    @Override
    public void buyPhones() {
        phoneService.byBasket();
    }

}
