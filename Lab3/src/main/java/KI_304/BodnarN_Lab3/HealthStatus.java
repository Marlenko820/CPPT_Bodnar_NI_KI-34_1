package KI_304.BodnarN_Lab3;

/**
 * Клас HealthStatus представляє стан здоров'я собаки.
 * Містить методи для збільшення, зменшення та отримання рівня здоров'я.
 */
public class HealthStatus {
    private double health;

    /**
     * Конструктор за замовчуванням, який встановлює здоров'я на рівні 100%.
     */
    public HealthStatus() {
        this.health = 100.0;
    }

    /**
     * Метод для збільшення рівня здоров'я на задану величину.
     * Якщо рівень здоров'я перевищує 100%, він встановлюється на 100%.
     *
     * @param amount Величина, на яку збільшується здоров'я
     */
    public void increaseHealth(double amount) {
        health += amount;
        if (health > 100.0) health = 100.0;
    }

    /**
     * Метод для зменшення рівня здоров'я на задану величину.
     * Якщо рівень здоров'я зменшується нижче 0%, він встановлюється на 0%.
     *
     * @param amount Величина, на яку зменшується здоров'я
     */
    public void decreaseHealth(double amount) {
        health -= amount;
        if (health < 0.0) health = 0.0;
    }

    /**
     * Метод для встановлення рівня здоров'я.
     *
     * @param health Новий рівень здоров'я
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Метод для отримання поточного рівня здоров'я.
     *
     * @return Поточний рівень здоров'я у відсотках
     */
    public double getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "HealthStatus{" +
                "health=" + health +
                '}';
    }
}
