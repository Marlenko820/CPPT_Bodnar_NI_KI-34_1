package KI_304.BodnarN_Lab3;

import java.io.IOException;

/**
 * Клас Dog представляє собаку з різними характеристиками, такими як порода, стан здоров'я,
 * рівень тренованості, вік і вага. Клас також має методи для взаємодії з собакою,
 * такі як годування, прогулянка, тренування, зміна імені та виконання трюків.
 */
public abstract class Dog {
    protected Breed breed;
    protected HealthStatus healthStatus;
    protected TrainingLevel trainingLevel;
    protected Logger logger;
    protected String name;
    protected int age;
    protected double weight;

    /**
     * Конструктор за замовчуванням, який створює собаку з базовими характеристиками.
     * @throws IOException якщо виникає помилка при створенні лог-файлу.
     */
    public Dog() throws IOException {
        this.name = "Бобік";
        this.breed = new Breed();
        this.healthStatus = new HealthStatus();
        this.trainingLevel = new TrainingLevel();
        this.age = 1;
        this.weight = 5.0;

        this.logger = new Logger("dog_log.txt");

        logger.log(String.format("Пса %s сторено.", this.toString()));
    }

    /**
     * Конструктор з параметрами для створення собаки з певними характеристиками.
     *
     * @param breed Порода собаки
     * @param healthStatus Стан здоров'я
     * @param trainingLevel Рівень тренованості
     * @param name Ім'я собаки
     * @param age Вік собаки
     * @param weight Вага собаки
     * @throws IOException якщо виникає помилка при створенні лог-файлу.
     */
    public Dog(Breed breed, HealthStatus healthStatus, TrainingLevel trainingLevel, String name, int age, double weight) throws IOException {
        this.breed = breed;
        this.healthStatus = healthStatus;
        this.trainingLevel = trainingLevel;
        this.name = name;
        this.age = age;
        this.weight = weight;

        this.logger = new Logger("dog_log.txt");

        logger.log(String.format("Пса %s сторено.", this.toString()));
    }
    /**
     * Повертає мету використання об'єкта.
     *
     * @return мета, для якої об'єкт призначений.
     */
    public abstract String getPurpose();

    /**
     * Перевіряє, чи потрібен об'єкту спеціальний догляд.
     *
     * @return {@code true}, якщо об'єкт потребує спеціального догляду, інакше {@code false}.
     */
    public abstract boolean isSpecialCareNeeded();


    /**
     * Метод для годування собаки.
     * Збільшує вагу собаки та покращує стан здоров'я.
     *
     * @param foodAmount Кількість їжі для годування
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public void feed(double foodAmount) throws IOException {
        weight += foodAmount * 0.1;
        healthStatus.increaseHealth(foodAmount * 0.05);

        logger.log("Собаку нагодовано. Нова вага: " + weight + " кг");
        System.out.println("Собаку нагодовано. Нова вага: " + weight + " кг");
    }

    /**
     * Метод для вигулу собаки.
     * Зменшує вагу собаки, покращує здоров'я і підвищує рівень тренованості.
     *
     * @param duration Тривалість прогулянки у хвилинах
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public void walk(int duration) throws IOException {
        weight -= duration * 0.01;
        healthStatus.increaseHealth(duration * 0.1);
        trainingLevel.increaseLevel(duration * 0.05);

        logger.log("Собаку вигуляно протягом " + duration + " хвилин");
        System.out.println("Собаку вигуляно протягом " + duration + " хвилин");
    }

    /**
     * Метод для тренування собаки.
     * Збільшує рівень тренованості і зменшує здоров'я в залежності від інтенсивності.
     *
     * @param intensity Інтенсивність тренування (1-10)
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public void train(int intensity) throws IOException {
        if (intensity < 1 || intensity > 10) {

            logger.log("Неправильна інтенсивність тренування");
            System.out.println("Неправильна інтенсивність тренування");
            return;
        }
        trainingLevel.increaseLevel(intensity * 0.2);
        healthStatus.decreaseHealth(intensity * 0.1);

        logger.log("Проведено тренування з інтенсивністю " + intensity);
        System.out.println("Проведено тренування з інтенсивністю " + intensity);
    }

    /**
     * Метод для відвідування ветеринара.
     * Повністю відновлює здоров'я собаки.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public void visitVet() throws IOException {
        healthStatus.setHealth(100);

        logger.log("Відвідано ветеринара. Здоров'я відновлено");
        System.out.println("Відвідано ветеринара. Здоров'я відновлено");
    }

    /**
     * Метод для перевірки стану здоров'я собаки.
     *
     * @return Поточний рівень здоров'я у відсотках
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public double checkHealth() throws IOException {
        double health = healthStatus.getHealth();

        logger.log("Перевірено здоров'я: " + health + "%");
        System.out.println("Перевірено здоров'я: " + health + "%");
        return health;
    }

    /**
     * Метод для перевірки рівня тренованості собаки.
     *
     * @return Поточний рівень тренованості у відсотках
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public double checkTrainingLevel() throws IOException {
        double level = trainingLevel.getLevel();

        logger.log("Перевірено рівень тренованості: " + level + "%");
        System.out.println("Перевірено рівень тренованості: " + level + "%");
        return level;
    }

    /**
     * Метод для зміни імені собаки.
     *
     * @param newName Нове ім'я собаки
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public void changeName(String newName) throws IOException {
        String oldName = this.name;
        this.name = newName;

        logger.log("Змінено ім'я з " + oldName + " на " + newName);
        System.out.println("Змінено ім'я з " + oldName + " на " + newName);
    }

    /**
     * Метод для святкування дня народження собаки.
     * Збільшує вік собаки на один рік.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public void celebrateBirthday() throws IOException {
        age++;

        logger.log("Відсвятковано день народження. Новий вік: " + age + " років");
        System.out.println("Відсвятковано день народження. Новий вік: " + age + " років");
    }

    /**
     * Метод для виконання трюку.
     *
     * @return true, якщо трюк виконано успішно, false - якщо ні
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public boolean performTrick() throws IOException {
        if (trainingLevel.getLevel() > 50) {

            logger.log("Успішно виконано трюк");
            System.out.println("Успішно виконано трюк");
            return true;
        } else {
            logger.log("Не вдалося виконати трюк. Потрібно більше тренувань");
            System.out.println("Не вдалося виконати трюк. Потрібно більше тренувань");
            return false;
        }
    }

    /**
     * Метод для отримання інформації про собаку.
     *
     * @return Рядок з інформацією про собаку
     * @throws IOException якщо виникає помилка при записі в лог-файл.
     */
    public String getInfo() throws IOException {
        String info = "Собака: " + name + ", Порода: " + breed.getName() +
                ", Вік: " + age + " років, Вага: " + weight + " кг, " +
                "Здоров'я: " + checkHealth() + "%, " +
                "Рівень тренованості: " + checkTrainingLevel() + "%";

        logger.log(String.format("Дістати інформацію про %s", info));
        System.out.printf("Дістати інформацію про %s\n", info);
        return info;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed=" + breed +
                ", healthStatus=" + healthStatus +
                ", trainingLevel=" + trainingLevel +
                ", logger=" + logger +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
