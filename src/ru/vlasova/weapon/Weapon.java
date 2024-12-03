package ru.vlasova.weapon;

public abstract class Weapon {
    private int ammo;

    public Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException("Количество патронов не может быть отрицательным");
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int getAmmo() {
        return ammo;
    }

    public boolean isAmmoAvailable() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public int load(int ammo) {
        if (ammo < 0) throw new RuntimeException("Невозможно загрузить отрицательное количество патронов");
        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }
}