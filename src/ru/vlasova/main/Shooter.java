package ru.vlasova.main;

import ru.vlasova.weapon.*;

interface Shooter {
    void shoot();  // метод для стрельбы
    String getName();  // метод для получения имени стрелка

    void setWeapon(Weapon weapon); // метод для смены оружия
    Weapon getWeapon(); // метод для получения оружия

}