package KI_304.BodnarN_Lab3;

import java.io.IOException;

/**
 * Клас DogDriver є точкою входу програми, що демонструє використання класу Dog.
 * Містить основний метод для створення екземпляру собаки та виконання різних операцій з ним.
 */
public class ExperimentalDriver {
    /**
     * Головний метод, який запускає програму.
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            ExperimentalDog dog = new ExperimentalDog(
                    new Breed("Лабрадор"),
                    new HealthStatus(),
                    new TrainingLevel(),
                    "Рекс",
                    2,
                    25.0,
                    "EXP-001"
            );

            dog.feed(2);
            dog.walk(30);
            dog.train(5);
            dog.checkHealth();
            dog.checkTrainingLevel();
            dog.changeName("Макс");
            dog.celebrateBirthday();
            dog.performTrick();
            dog.visitVet();

            System.out.println("\nОтримання загальної інформації:");
            System.out.println(dog.getInfo());

            System.out.println("\nТестування експериментальних методів:");
            if (dog.canConductNewExperiment()) {
                System.out.println("Проведення експерименту...");
                dog.conductExperiment();
                dog.recordResults("Перший експеримент: собака показує гарну реакцію на стимули");
            }

            System.out.println("\nПеревірка стану здоров'я для експерименту:");
            boolean healthyForExperiment = dog.isHealthyForExperiment();
            System.out.println("Придатний до експерименту: " + healthyForExperiment);
            System.out.println("\nВстановлення карантину:");
            dog.setQuarantine(true);
            if (dog.canConductNewExperiment()) {
                dog.conductExperiment();
            } else {
                System.out.println("Експеримент неможливий через карантин");
            }

            dog.setQuarantine(false);
            if (dog.canConductNewExperiment()) {
                dog.conductExperiment();
                dog.recordResults("Другий експеримент: спостерігається покращення показників");
            }
            System.out.println("\nІсторія експериментів:");
            System.out.println(dog.getExperimentHistory());
            System.out.println("\nПеревірка необхідності спеціального догляду:");
            boolean needsSpecialCare = dog.isSpecialCareNeeded();
            System.out.println("Потребує спеціального догляду: " + needsSpecialCare);
            System.out.println("\nПризначення собаки:");
            System.out.println(dog.getPurpose());
            System.out.println("\nФінальний стан собаки:");
            System.out.println(dog.toString());
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
