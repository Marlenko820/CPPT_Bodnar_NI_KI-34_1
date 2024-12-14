package KI_304.BodnarN_Lab3;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code ExperimentalDog} представляє піддослідного пса, який бере участь у наукових експериментах.
 * Він розширює клас {@code Dog} та реалізує інтерфейс {@code Experimental}, що включає функції проведення експериментів.
 */
public class ExperimentalDog extends Dog implements Experimental {
    private String experimentId;
    private List<String> experimentResults;
    private LocalDateTime lastExperimentDate;
    private int experimentsCount;
    private boolean underQuarantine;

    /**
     * Конструктор класу {@code ExperimentalDog}.
     *
     * @param breed Порода собаки.
     * @param healthStatus Стан здоров'я собаки.
     * @param trainingLevel Рівень тренованості собаки.
     * @param name Ім'я собаки.
     * @param age Вік собаки.
     * @param weight Вага собаки.
     * @param experimentId Ідентифікатор експерименту.
     * @throws IOException якщо виникає помилка при створенні лог-файлу.
     */
    public ExperimentalDog(Breed breed, HealthStatus healthStatus,
                           TrainingLevel trainingLevel, String name, int age,
                           double weight, String experimentId) throws IOException {
        super(breed, healthStatus, trainingLevel, name, age, weight);
        this.experimentId = experimentId;
        this.experimentResults = new ArrayList<>();
        this.experimentsCount = 0;
        this.underQuarantine = false;
        logger.log(String.format("Створено піддослідного пса: %s, ID експерименту: %s",
                name, experimentId));
    }

    /**
     * Проводить експеримент над собакою.
     * Якщо стан здоров'я недостатній або собака під карантином, експеримент не проводиться.
     */
    @Override
    public void conductExperiment() {
        try {
            if (!isHealthyForExperiment()) {
                logger.log("Експеримент скасовано через поганий стан здоров'я");
                return;
            }
            experimentsCount++;
            lastExperimentDate = LocalDateTime.now();
            healthStatus.decreaseHealth(10); // Експеримент впливає на здоров'я
            logger.log(String.format("Проведено експеримент №%d над %s",
                    experimentsCount, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Записує результати експерименту.
     *
     * @param results Результати експерименту у вигляді тексту.
     */
    @Override
    public void recordResults(String results) {
        try {
            experimentResults.add(results);
            logger.log(String.format("Записано результати експерименту: %s", results));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Перевіряє, чи є собака достатньо здоровою для проведення експерименту.
     *
     * @return {@code true}, якщо собака здорова для експерименту, інакше {@code false}.
     */
    @Override
    public boolean isHealthyForExperiment() {
        return healthStatus.getHealth() > 70 && !underQuarantine;
    }

    /**
     * Повертає історію проведених експериментів.
     *
     * @return історія експериментів у вигляді тексту.
     */
    @Override
    public String getExperimentHistory() {
        return String.join("\n", experimentResults);
    }

    /**
     * Повертає мету використання цієї собаки.
     *
     * @return мета - піддослідний пес для наукових експериментів.
     */
    @Override
    public String getPurpose() {
        return "Піддослідний пес для наукових експериментів";
    }

    /**
     * Перевіряє, чи потрібен собаці спеціальний догляд.
     *
     * @return {@code true}, якщо собака потребує спеціального догляду, інакше {@code false}.
     */
    @Override
    public boolean isSpecialCareNeeded() {
        return healthStatus.getHealth() < 50 || underQuarantine;
    }

    /**
     * Встановлює або знімає карантин для собаки.
     *
     * @param quarantine статус карантину.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void setQuarantine(boolean quarantine) throws IOException {
        this.underQuarantine = quarantine;
        logger.log(String.format("Статус карантину змінено на: %s",
                quarantine ? "під карантином" : "не під карантином"));
    }

    /**
     * Перевіряє, чи можна проводити новий експеримент.
     * Новий експеримент можливий, якщо собака здорова і минуло більше 7 днів з моменту останнього експерименту.
     *
     * @return {@code true}, якщо можна провести новий експеримент, інакше {@code false}.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public boolean canConductNewExperiment() throws IOException {
        boolean canConduct = isHealthyForExperiment() &&
                (lastExperimentDate == null ||
                        ChronoUnit.DAYS.between(lastExperimentDate,
                                LocalDateTime.now()) >= 7);

        logger.log(String.format("Перевірка можливості проведення нового експерименту: %s",
                canConduct));
        return canConduct;
    }

    /**
     * Повертає строкове представлення об'єкта {@code ExperimentalDog}.
     *
     * @return строка, що представляє об'єкт {@code ExperimentalDog}.
     */
    @Override
    public String toString() {
        return String.format("ExperimentalDog{name='%s', experimentId='%s', " +
                        "experimentsCount=%d, underQuarantine=%s}",
                name, experimentId, experimentsCount, underQuarantine);
    }
}
