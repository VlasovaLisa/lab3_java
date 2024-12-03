

package ru.vlasova.main;
import ru.vlasova.weapon.*;

import static java.lang.System.out;

class ShooterImpl implements Shooter {
    private String name;
    private Weapon weapon;


    public ShooterImpl(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon == null) {
            out.println(name + " не может участвовать в перестрелке, оружие отсутствует");
        } else {
            out.print(name + " стреляет: ");
            weapon.shoot();
        }
    }

    public String getName() {
        return name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
