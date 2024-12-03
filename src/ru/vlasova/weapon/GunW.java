package ru.vlasova.weapon;

import static java.lang.System.out;

public class GunW extends Weapon { //} implements Fireable { //связываем с интерфейсом для 5.8
    private int maxBullets;

    public GunW(int maxBullets, int ammo) {
        super(ammo);  //вызов конструктора родительского класса Weapon
        setMaxBullets(maxBullets); //сеттер для инициализации с проверкой
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public void setMaxBullets(int maxBullets) {
        if (maxBullets <= 0) {
            throw new IllegalArgumentException("Максимальное количество патронов должно быть положительным");
        }
        this.maxBullets = maxBullets;
    }

    public void reload(int bulletCount) {
        if (bulletCount < 0) {
            throw new IllegalArgumentException("Число патронов не может быть отрицательным");
        }
        if (getAmmo() + bulletCount > maxBullets) {
            int extra = getAmmo() + bulletCount - maxBullets;
            load(maxBullets);  //перезарядка до максимума
            out.println("Перезаряжено до максимума. Осталось " + extra + " лишних патронов");
        } else {
            load(getAmmo() + bulletCount);  //добавление патронов
        }
    }

    public int unload() {
        int returnedBullets = getAmmo();
        load(0);  //сбрасываем количество патронов в оружии
        return returnedBullets;
    }

    public boolean isLoaded() {
        return getAmmo() > 0;
    }

    public void shoot() {
        if (isAmmoAvailable()) {
            out.println("Бах!");
        } else {
            out.println("Клац!");
        }
    }

    public String toString() {
        return "Пистолет с " + getAmmo() + " патронами (макс: " + maxBullets + ")";
    }
}