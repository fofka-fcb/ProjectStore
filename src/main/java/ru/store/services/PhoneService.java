package ru.store.services;

import ru.store.domain.Phone;

public interface PhoneService {

    void putPhone(String model);
    void removePhone(String model);
    void printPhone();
    void printBasket();
    void byBasket();

}
