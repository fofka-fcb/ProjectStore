package ru.store.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ClientOfStore {

    private final String name;

    private final List<Phone> phone;

}
