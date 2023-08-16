package ru.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.store.domain.Phone;
import ru.store.services.PhoneService;
import ru.store.services.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Класс PhoneServiceImpl должен")
public class PhoneTest {
    List<Phone> basketList = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();
    PhoneService phoneService = new PhoneServiceImpl(phoneList, basketList);

    @DisplayName("Корректно добавлять телефон в корзину клиента")
    @Test
    public void shouldHaveCorrectPutPhone(){

        phoneList.add(new Phone("Iphone_7"));

        assertEquals(0, basketList.size());

        phoneService.putPhone("Iphone_7");

        assertAll(() -> assertEquals(new Phone ("Iphone_7"), basketList.get(0)),
                () -> assertEquals(1, basketList.size()));

    }

    @DisplayName("Корректно удалять телефон из корзины клиента")
    @Test
    public void shouldHaveCorrectRemovePhone(){

        phoneList.add(new Phone("Iphone_7"));

        assertEquals(0, basketList.size());

        phoneService.putPhone("Iphone_7");

        phoneService.removePhone("Iphone_7");

        assertAll(() -> assertFalse(basketList.contains("Iphone_7")),
                () -> assertEquals(0, basketList.size()));

    }

    @DisplayName("Корректно покупать содержимое корзины")
    @Test
    public void shouldHaveCorrectByBasket(){

        phoneList.add(new Phone("Iphone_7"));
        phoneList.add(new Phone("Iphone_8"));
        phoneList.add(new Phone("Iphone_X"));

        assertEquals(0, basketList.size());

        phoneService.putPhone("Iphone_7");
        phoneService.putPhone("Iphone_8");
        phoneService.putPhone("Iphone_X");

        phoneService.byBasket();

        assertAll(() -> assertTrue(basketList.isEmpty()),
                () -> assertEquals(0, basketList.size()));

    }

    @DisplayName("Корректно покупать содержимое пустой корзины")
    @Test
    public void shouldHaveCorrectByEmptyBasket(){

        phoneList.add(new Phone("Iphone_7"));
        phoneList.add(new Phone("Iphone_8"));
        phoneList.add(new Phone("Iphone_X"));

        assertEquals(0, basketList.size());

        phoneService.byBasket();

        assertAll(() -> assertTrue(basketList.isEmpty()),
                () -> assertEquals(0, basketList.size()));

    }
}
