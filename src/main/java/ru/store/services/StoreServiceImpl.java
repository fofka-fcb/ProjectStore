package ru.store.services;

import ru.store.domain.ClientOfStore;
import ru.store.domain.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreServiceImpl implements StoreService{
    @Override
    public void start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        String clientName = scanner.next();

        ClientOfStore clientOfStore = new ClientOfStore(clientName, new ArrayList<>());

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone("Iphone_7"));
        phoneList.add(new Phone("Iphone_8"));
        phoneList.add(new Phone("Iphone_X"));
        phoneList.add(new Phone("Iphone_XR"));
        phoneList.add(new Phone("Iphone_11"));
        phoneList.add(new Phone("Iphone_12"));
        phoneList.add(new Phone("Iphone_13"));
        phoneList.add(new Phone("Iphone_14"));

        List<Phone> basketList = new ArrayList<>();

        PhoneService phoneService = new PhoneServiceImpl(phoneList, basketList);

        ClientService clientService = new ClientServiceImpl(scanner, phoneService, clientOfStore);

        MenuService menuService = new MenuServiceImpl(phoneService, clientService, scanner);

        menuService.menu();

    }
}
