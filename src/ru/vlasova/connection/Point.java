package ru.vlasova.connection;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //вывод точки в формате {X;Y}
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    //сравнение точек по координатам
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; //это один и тот же объект
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; //объект не того же класса или равен null
        }
        Point point = (Point) obj; //приведение объекта к типу Point
        return x == point.x && y == point.y; //сравнение координат
    }
}