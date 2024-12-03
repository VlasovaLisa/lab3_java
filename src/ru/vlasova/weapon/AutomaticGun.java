package ru.vlasova.weapon;

import static java.lang.System.out;

public class AutomaticGun extends Gun { //implements Fireable { //связываем с интерфейсом для 5.8
    private final int fireRate; //скорострельность

    //без параметров (скорострельность 30, вместимость 30)
    public AutomaticGun() {
        super(30);
        this.fireRate = 30;
    }

    //с указанием максимального числа патронов
    public AutomaticGun(int maxBullets) {
        super(maxBullets);
        this.fireRate = Math.max(1, maxBullets / 2); //половина вместимости, минимум 1
    }

    //с указанием вместимости и скорострельности
    public AutomaticGun(int maxBullets, int fireRate) {
        super(maxBullets);
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом");
        }
        this.fireRate = fireRate;
    }

    public int getFireRate() {
        return fireRate;
    }

    //переопределение стрельбы
    public void shoot() {
        if (getBullets() >= fireRate) {
            for (int i = 0; i < fireRate; i++) {
                super.shoot(); //вызов стрельбы из базового класса
            }
        } else {
            out.println("Недостаточно патронов для полной очереди");
            while (getBullets() > 0) {
                super.shoot();
            }
        }
    }

    //стрелять N секунд
    public void shootForSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным");
        }
        int totalShots = seconds * fireRate;
        if (getBullets() >= totalShots) {
            for (int i = 0; i < totalShots; i++) {
                super.shoot();
            }
        } else {
            out.println("Недостаточно патронов для стрельбы " + seconds + " секунд");
            while (getBullets() > 0) {
                super.shoot();
            }
        }
    }

    public String toString() {
        return "Автомат с скорострельностью " + fireRate + " выстрелов в секунду, " +
                "с " + getBullets() + " патронами (макс: " + getMaxBullets() + ")";
    }
}
