package KI_304.BodnarN.lab2;

/**
 * Клас Breed представляє породу собаки.
 * Містить інформацію про назву породи та методи для її отримання та встановлення.
 */
public class Breed {
    private String name;

    /**
     * Конструктор за замовчуванням, який створює безпородного собаку.
     */
    public Breed() {
        this.name = "Безпородний";
    }

    /**
     * Конструктор з параметрами для створення породи з певною назвою.
     *
     * @param name Назва породи
     */
    public Breed(String name) {
        this.name = name;
    }

    /**
     * Метод для отримання назви породи.
     *
     * @return Назва породи
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для встановлення назви породи.
     *
     * @param name Назва породи
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                '}';
    }
}
