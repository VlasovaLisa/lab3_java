package ru.vlasova.weapon;

abstract class Weapon2 {
    protected int ammo; //protected чтобы наследники могли работать с этим полем

    public Weapon2(int ammo) {
        if (ammo < 0) throw new RuntimeException("Количество патронов не может быть отрицательным");
        this.ammo = ammo;
    }

    abstract void shoot();

    //получение текущего количества патронов
    public int getAmmo() {
        return ammo;
    }

    //проверка доступности патронов и выстрел
    public boolean isAmmoAvailable() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    //метод для загрузки патронов
    public int load(int ammo) {
        if (ammo < 0) throw new RuntimeException("Невозможно загрузить отрицательное количество патронов");
        int tmp = this.ammo;
        this.ammo += ammo; //добавляем патроны к текущему количеству
        return tmp;
    }
}
