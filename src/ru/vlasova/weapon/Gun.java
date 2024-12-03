package ru.vlasova.weapon;

import static java.lang.System.out;

public class Gun {

    private int bullets;
    private int maxBullets;

    public Gun(int maxBullets) {
        setMaxBullets(maxBullets); //сеттер для инициализации с проверкой
        this.bullets = 0;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public void setMaxBullets(int maxBullets) {
        if (maxBullets <= 0) {
            throw new IllegalArgumentException("Максимальное количество патронов должно быть положительным.");
        }
        this.maxBullets = maxBullets;
    }

    public void reload(int bulletCount) {
        if (bulletCount < 0) {
            throw new IllegalArgumentException("Число патронов не может быть отрицательным");
        }
        if (bullets + bulletCount > maxBullets) {
            int extra = bullets + bulletCount - maxBullets;
            bullets = maxBullets;
            out.println("Перезаряжено до максимума. Осталось " + extra + " лишних патронов.");
        } else {
            bullets += bulletCount;
        }
    }

    public int unload() {
        int returnedBullets = bullets;
        bullets = 0;
        return returnedBullets;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным.");
        } else if (bullets > maxBullets) {
            throw new IllegalArgumentException("Количество патронов не может превышать максимальную вместимость.");
        }
        this.bullets = bullets;
    }

    public boolean isLoaded() {
        return bullets > 0;
    }

    public void shoot() {
        if (bullets > 0) {
            out.println("Бах!");
            bullets--;
        } else {
            out.println("Клац!");
        }
    }

    public String toString() {
        return "Пистолет с " + bullets + " патронами (макс: " + maxBullets + ")";
    }

}