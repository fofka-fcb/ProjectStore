package ru.store.services;

import lombok.RequiredArgsConstructor;
import ru.store.domain.Phone;

import java.util.List;

@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final List<Phone> phoneFromCatalog;
    private final List<Phone> phoneBasket;

    @Override
    public void putPhone(String model) {
        int count = 0;
        int countOfSize = 0;
        for (Phone phone: phoneFromCatalog) {
            countOfSize++;
            if (phone.getModel().equals(model) == true){
                count++;
                if (count > 0){
                    phoneBasket.add(phone);
                    System.out.println();
                    System.out.println("Телефон добавлен в корзину");
                    break;
                }
            }
            if (countOfSize == phoneFromCatalog.size() && count == 0){
                System.out.println();
                System.out.println("Такого телефона нет в каталоге");
            }
        }
    }

    @Override
    public void removePhone(String model) {
        int count = 0;
        int countOfSize = 0;
        if (phoneBasket.size() == 0){
            System.out.println("Корзина и так пуста");
        } else {
            for (int x = 0; x < phoneBasket.size(); x++){
                countOfSize++;
                if (phoneBasket.get(x).getModel().equals(model) == true){
                    count++;
                    if (count > 0){
                        phoneBasket.remove(x);
                        System.out.println();
                        System.out.println("Телефон убран из корзины");
                        break;
                    }
                }
                if (countOfSize == phoneBasket.size() && count == 0){
                    System.out.println();
                    System.out.println("Такого телефона нет в корзине");
                }
            }
        }
    }

    @Override
    public void printPhone(){
        int count = 0;
        System.out.print("Каталог телефонов: ");
        for (Phone phone: phoneFromCatalog){
            count++;
            if (count < phoneFromCatalog.size()){
                System.out.print(phone.getModel() + "; ");
            } else {
                System.out.println(phone.getModel() + ". ");
            }
        }
    }

    @Override
    public void printBasket(){
        int count = 0;
        if (phoneBasket.size() == 0){
            System.out.println("Корзина пуста");
        } else {
            for (Phone phone: phoneBasket){
                count++;
                if (count < phoneBasket.size()){
                    System.out.print(phone.getModel() + "; ");
                } else {
                    System.out.println(phone.getModel() + ". ");
                }
            }
        }

    }

    @Override
    public void byBasket(){
        if (phoneBasket.size() > 0){
            phoneBasket.clear();
            System.out.println("Покупка совершена!");
        }
        else {
            System.out.println("Корзина пуста, покупку невозможно совершить!");
        }
    }

}
