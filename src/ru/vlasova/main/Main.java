//вариант 4 Власова Елизавета
package ru.vlasova.main;

import ru.vlasova.weapon.*;
import ru.vlasova.connection.*;

import java.util.Scanner;

import static java.lang.System.out;


public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //1.5
        out.println("------------------ЗАДАНИЕ 1.5------------------");
        Gun gun1 = new Gun(7);
        out.println("Создан пистолет: " + gun1);
        gun1.reload(3);
        out.println("Заряжено 3 патрона");
        for (int i = 1; i <= 5; i++) {
            out.print("Выстрел " + i + ": ");
            gun1.shoot();
        }
        gun1.reload(8);
        for (int i = 1; i <= 2; i++) {
            out.print("Выстрел " + i + ": ");
            gun1.shoot();
        }
        int unloadedBullets = gun1.unload();
        out.println("Пистолет разряжен. Возвращено " + unloadedBullets + " патронов.");
        out.print("Контрольный выстрел: ");
        gun1.shoot();


        out.print("Хотите создать пистолет? (да/нет): ");
        String createGun = getYesOrNoInput();

        if (createGun.equals("да")) {
            out.print("Введите максимальное количество патронов для пистолета: ");
            int maxBullets;
            while (true) {
                if (in.hasNextInt()) {
                    maxBullets = in.nextInt();
                    if (maxBullets > 0) {
                        break;
                    } else {
                        out.print("Максимальное количество патронов должно быть положительным числом. Повторите ввод: ");
                    }
                } else {
                    out.print("Некорректный ввод, введите целое положительное число: ");
                    in.next();
                }
            }
            Gun gun = new Gun(maxBullets);
            out.println("Создан новый пистолет: " + gun);
            boolean exit = false;
            while (!exit) {
                out.println("Выберите действие для пистолета:");
                out.println("1. Узнать максимальную вместимость патронов");
                out.println("2. Зарядить или перезарядить пистолет");
                out.println("3. Разрядить пистолет");
                out.println("4. Узнать, сколько сейчас заряжено патронов");
                out.println("5. Проверить, заряжен ли пистолет");
                out.println("6. Выстрелить");
                out.println("7. Выход");

                int choice;
                while (true) {
                    out.print("Ваш выбор: ");
                    if (in.hasNextInt()) {
                        choice = in.nextInt();
                        if (choice >= 1 && choice <= 7) {
                            break;
                        } else {
                            out.println("Введите число от 1 до 7.");
                        }
                    } else {
                        out.println("Некорректный ввод, введите целое число.");
                        in.next();
                    }
                }

                switch (choice) {
                    case 1:
                        out.println("Максимальная вместимость патронов: " + gun.getMaxBullets());
                        break;
                    case 2:
                        out.print("Введите количество патронов для зарядки/перезарядки: ");
                        int bulletsToAdd;
                        while (true) {
                            if (in.hasNextInt()) {
                                bulletsToAdd = in.nextInt();
                                if (bulletsToAdd > 0) {
                                    break;
                                } else {
                                    out.print("Количество патронов для зарядки не может быть меньше 1. Повторите ввод: ");
                                }
                            } else {
                                out.print("Некорректный ввод, введите целое положительное число: ");
                                in.next();
                            }
                        }
                        gun.reload(bulletsToAdd);
                        out.println("Пистолет заряжен. Текущие патроны: " + gun.getBullets());
                        break;
                    case 3:
                        int returnedBullets = gun.unload();
                        out.println("Пистолет разряжен. Возвращено патронов: " + returnedBullets);
                        break;
                    case 4:
                        out.println("Сейчас заряжено патронов: " + gun.getBullets());
                        break;
                    case 5:
                        out.println(gun.isLoaded() ? "Пистолет заряжен." : "Пистолет разряжен.");
                        break;
                    case 6:
                        out.print("Сколько раз вы хотите выстрелить? ");
                        int shots;
                        while (true) {
                            if (in.hasNextInt()) {
                                shots = in.nextInt();
                                if (shots > 0) {
                                    break;
                                } else {
                                    out.print("Количество выстрелов должно быть положительным числом. Повторите ввод: ");
                                }
                            } else {
                                out.print("Некорректный ввод, введите целое положительное число: ");
                                in.next();
                            }
                        }
                        for (int i = 1; i <= shots; i++) {
                            out.print("Выстрел " + i + ": ");
                            gun.shoot();
                        }
                        break;
                    case 7:
                        out.println("Переход к следующему заданию");
                        exit = true;
                        break;
                    default:
                        out.println("Некорректный выбор");
                        break;
                }
            }
        } else {
            out.println("Переход к следующему заданию");
        }


        out.println("------------------ЗАДАНИЕ 1.7------------------");

        Name cleo2 = new Name("", "Клеопатра");
        Name push2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name vlad2 = new Name("Маяковский", "Владимир");
        Name christopher = new Name("Бонифатьевич", "Христофор");

        out.println(cleo2);
        out.println(push2);
        out.println(vlad2);
        out.println(christopher);

        //попытка создать имя без значений
        try {
            Name invalidName = new Name("", "", "");
        } catch (IllegalArgumentException e) {
            out.println("ошибка: " + e.getMessage());
        }

        out.print("Хотите добавить новое имя (да/нет)? ");
        while (getYesOrNoInput().equals("да")) {
            out.print("Введите фамилию: ");
            String surname = in.nextLine().trim();
            out.print("Введите имя: ");
            String firstName = in.nextLine().trim();
            out.print("Введите отчество: ");
            String patronymic = in.nextLine().trim();

            try {
                Name newName = new Name(surname, firstName, patronymic);
                out.println("Новое имя: " + newName);
            } catch (IllegalArgumentException e) {
                out.println("Ошибка: " + e.getMessage());
            }
            out.print("Хотите добавить еще одно новое имя (да/нет)? ");
        }

        out.println("Переход к следующему заданию");

        out.println("------------------ЗАДАНИЕ 2.3------------------");
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Вася", "89003337788");
        phoneBook.addContact("Петя", "89003337789");
        phoneBook.addContact("Маша", "89003337790");
        out.println("После добавления:");
        out.println(phoneBook);

        out.print("Хотите открыть телефонный справочник? (да/нет): ");
        String createTel = getYesOrNoInput();
        if (createTel.equals("да")) {
            boolean exit1 = false;
            while (!exit1) {
                out.println("\nТелефонный справочник:");
                out.println("1. Добавить контакт");
                out.println("2. Удалить контакт");
                out.println("3. Найти телефон по имени");
                out.println("4. Проверить наличие имени");
                out.println("5. Проверить наличие телефона");
                out.println("6. Показать все контакты");
                out.println("7. Показать только телефоны");
                out.println("8. Показать только имена");
                out.println("9. Найти имена по начальным символам");
                out.println("10. Узнать количество контактов");
                out.println("0. Выйти");

                int choice3;
                while (true) {
                    out.print("Выберите действие: ");
                    if (in.hasNextInt()) {
                        choice3 = in.nextInt();
                        in.nextLine();
                        if (choice3 >= 0 && choice3 <= 10) {
                            break;
                        } else {
                            out.println("Ошибка, введите число от 0 до 10");
                        }
                    } else {
                        out.println("Ошибка, попробуйте снова");
                        in.next();
                    }
                }

                switch (choice3) {
                    case 1:
                        out.print("Введите имя: ");
                        String name = in.nextLine().trim();
                        out.print("Введите телефон: ");
                        String phone = in.nextLine().trim();
                        String oldPhone = phoneBook.addContact(name, phone);
                        if (oldPhone != null) {
                            out.println("Контакт обновлен. Старый телефон: " + oldPhone);
                        } else {
                            out.println("Контакт добавлен");
                        }
                        break;

                    case 2:
                        out.print("Введите имя контакта для удаления: ");
                        name = in.nextLine().trim();
                        if (phoneBook.removeContact(name)) {
                            out.println("Контакт удален");
                        } else {
                            out.println("Контакт не найден");
                        }
                        break;

                    case 3:
                        out.print("Введите имя: ");
                        name = in.nextLine().trim();
                        phone = phoneBook.getPhone(name);
                        if (phone != null) {
                            out.println("Телефон: " + phone);
                        } else {
                            out.println("Контакт не найден");
                        }
                        break;

                    case 4:
                        out.print("Введите имя для проверки: ");
                        name = in.nextLine().trim();
                        out.println(phoneBook.containsName(name) ? "Имя найдено" : "Имя не найдено");
                        break;

                    case 5:
                        out.print("Введите телефон для проверки: ");
                        phone = in.nextLine().trim();
                        out.println(phoneBook.containsPhone(phone) ? "Телефон найден" : "Телефон не найден");
                        break;

                    case 6:
                        out.println("Все контакты:");
                        for (String pair : phoneBook.getAllPairs()) {
                            out.println(pair);
                        }
                        break;

                    case 7:
                        out.println("Все телефоны:");
                        for (String p : phoneBook.getAllPhones()) {
                            out.println(p);
                        }
                        break;

                    case 8:
                        out.println("Все имена:");
                        for (String n : phoneBook.getAllNames()) {
                            out.println(n);
                        }
                        break;

                    case 9:
                        out.print("Введите начальные символы для поиска имен: ");
                        String prefix = in.nextLine().trim();
                        String[] results = phoneBook.searchNamesByPrefix(prefix);
                        if (results.length > 0) {
                            out.println("Имена, начинающиеся с \"" + prefix + "\":");
                            for (String result : results) {
                                out.println(result);
                            }
                        } else {
                            out.println("Имена с таким префиксом не найдены");
                        }
                        break;

                    case 10:
                        out.println("Количество контактов: " + phoneBook.size());
                        break;

                    case 0:
                        out.println("Переход к следующему заданию");
                        exit1 = true;
                        break;

                    default:
                        out.println("Некорректный выбор, попробуйте снова");
                }
            }
        } else {
            out.println("Переход к следующему заданию");
        }

        out.println("------------------ЗАДАНИЕ 3.4------------------");

        AutomaticGun defaultGun = new AutomaticGun();  //с параметрами по умолчанию
        out.println("\n" + defaultGun);
        defaultGun.reload(30); //перезаряжаем до полной вместимости
        defaultGun.shoot(); //одна очередь по умолчанию (30 выстрелов)
        out.println(defaultGun);

        AutomaticGun customCapacityGun = new AutomaticGun(6); //с заданной вместимостью
        out.println("\n" + customCapacityGun);
        customCapacityGun.reload(6); //перезарядка
        customCapacityGun.shoot(); //стреляет со скорострельностью 3
        out.println(customCapacityGun);

        AutomaticGun customGun = new AutomaticGun(50, 2);  //с заданной вместимостью и скорострельностью
        out.println("\n" + customGun);
        customGun.reload(50); //перезарядка
        customGun.shootForSeconds(3); //стреляет 3 секунды (3 * 2 = 6 выстрелов)
        out.println(customGun);

        out.println("------------------ЗАДАНИЕ 4.1------------------");
        GunW gunW = new GunW(10, 5); //макс патронов 10, начальное 5
        out.println(gunW);

        gunW.shoot(); //стреляем Бах!
        gunW.shoot(); // Бах!
        out.println(gunW); //3 патрона

        gunW.shoot(); // Бах!
        gunW.shoot(); // Бах!
        gunW.shoot(); // Клац!
        out.println(gunW); //0 патронов

        gunW.reload(13); // Перезаряжено до максимума. Осталось 3 лишних патрона.
        out.println(gunW); //10 патронов

        int unloadedBull = gunW.unload(); //сбрасываем все патроны
        out.println("Снято патронов: " + unloadedBull); //снято патронов: 10
        out.println(gunW); //0 патронов

        out.println("------------------ЗАДАНИЕ 5.8------------------");

        Shooter shooter1 = new ShooterImpl("Иван", null); //без оружия
        Shooter shooter2 = new ShooterImpl("Сергей", new GunW(10, 5)); //с пистолетом

        shooter1.shoot(); // Иван не может участвовать в перестрелке, оружие отсутствует
        shooter2.shoot(); // Сергей стреляет: Бах!

        // Изменяем оружие для стрелка 1
        shooter1.setWeapon(new GunW(10, 5));
        shooter1.shoot(); // Иван стреляет: Бах!

        out.println("------------------ЗАДАНИЕ 6.2------------------");

        Point point1 = new Point(3, 5);
        Point point2 = new Point(25, 6);
        Point point3 = new Point(7, 8);

        out.println(point1); // {3;5}
        out.println(point2); // {25;6}
        out.println(point3); // {7;8}

        out.println("point1 equals point2: " + point1.equals(point2)); // false
        out.println("point2 equals point2: " + point2.equals(point2)); // true

        out.println("------------------ЗАДАНИЕ 7.3------------------");

        if (args.length == 2) { //параметры переданы через командную строку
            String xStr = args[0];
            String yStr = args[1];
            double result = power(xStr, yStr);
            System.out.println("Результат возведения в степень: " + result);
        } else {
            System.out.println("Для возведения в степень нужно передать два числа");
        }


        in.close();
    }

    public static String getYesOrNoInput() {
        while (true) {
            String input = in.nextLine().trim().toLowerCase();
            if (input.equals("да") || input.equals("нет")) {
                return input;
            } else {
                out.print("Некорректный ввод, пожалуйста, введите 'да' или 'нет': ");
            }
        }
    }

    public static double power(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        return Math.pow(x, y);
    }

}