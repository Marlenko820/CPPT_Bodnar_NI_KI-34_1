package KI_304.BodnarN.lab2;

import java.io.IOException;

/**
 * Клас DogDriver є точкою входу програми, що демонструє використання класу Dog.
 * Містить основний метод для створення екземпляру собаки та виконання різних операцій з ним.
 */
public class DogDriver {
    /**
     * Головний метод, який запускає програму.
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            Dog dog = new Dog(
                    new Breed("Німецька вівчарка"),
                    new HealthStatus(),
                    new TrainingLevel(),
                    "Джексон",
                    3,
                    40.0
            );
            dog.feed(4);
            dog.walk(4);
            dog.train(5);
            dog.visitVet();
            dog.checkHealth();
            dog.checkTrainingLevel();
            dog.changeName("Барсік");
            dog.celebrateBirthday();
            dog.performTrick();
            dog.getInfo();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
