package ru.store;

import ru.store.services.StoreService;
import ru.store.services.StoreServiceImpl;

public class Application {
    public static void main(String[] args) {

        StoreService storeService = new StoreServiceImpl();
        storeService.start();
        
    }
}
