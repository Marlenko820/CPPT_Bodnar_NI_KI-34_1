package KI_304.BodnarN.lab2;
/**
 * Клас TrainingLevel представляє рівень тренованості собаки.
 * Містить методи для збільшення рівня тренованості та отримання його значення.
 */
public class TrainingLevel {
    private double level;

    /**
     * Конструктор за замовчуванням, який встановлює рівень тренованості на 0.0.
     */
    public TrainingLevel() {
        this.level = 0.0;
    }

    /**
     * Метод для збільшення рівня тренованості на задану величину.
     * Якщо рівень тренованості перевищує 100%, він встановлюється на 100%.
     *
     * @param amount Величина, на яку збільшується рівень тренованості
     */
    public void increaseLevel(double amount) {
        level += amount;
        if (level > 100.0) level = 100.0;
    }

    /**
     * Метод для отримання поточного рівня тренованості.
     *
     * @return Поточний рівень тренованості у відсотках
     */
    public double getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "TrainingLevel{" +
                "level=" + level +
                '}';
    }
}
