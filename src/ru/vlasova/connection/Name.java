package ru.vlasova.connection;

public class Name {
    private final String surname;
    private final String firstName;
    private final String patronymic;

    public Name(String surname, String firstName, String patronymic) {
        if ((surname == null || surname.isEmpty()) &&
                (firstName == null || firstName.isEmpty()) &&
                (patronymic == null || patronymic.isEmpty())) {
            throw new IllegalArgumentException("Хотя бы одно из полей должно содержать значение");
        }
        this.surname = surname != null ? surname : "";
        this.firstName = firstName != null ? firstName : "";
        this.patronymic = patronymic != null ? patronymic : "";
    }

    public Name(String surname, String firstName) {
        this(surname, firstName, "");
    }

    public Name(String singleName) {
        this("", singleName, "");
    }

    // Геттеры
    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String toString() {  //преобразование объекта в строку
        StringBuilder fullName = new StringBuilder();

        if (!surname.isEmpty()) {
            fullName.append(surname);
        }
        if (!firstName.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(firstName);
        }
        if (!patronymic.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(patronymic);
        }
        return fullName.length() > 0 ? fullName.toString() : "имя не задано";
    }
}
