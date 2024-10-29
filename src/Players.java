import java.util.Random;

/**
 * Класс создает объект типа Игрок. Содержит методы для управления полями и поведением.
 */
public class Players {
    private Integer stamina;
    private static final int MIN_STAMINA = 0;
    private static final int MAX_STAMINA = 10;
    private static Integer countPlayers = 0;
    private static final int PLAYERS_ON_FIELD = 6;
    private static final int START_RANGE_RANDOM_STAMINA_VALUE = 8;
    private static final int END_RANGE_RANDOM_STAMINA_VALUE = (Players.getMaxStamina() + 1);

    private Players() {

    }

    private Players(int stamina) {
        this.stamina = stamina;
        countPlayers++;
    }

    public static Players addNewPlayer() {
        Random random = new Random();
        int randomStaminaValue = random.nextInt(START_RANGE_RANDOM_STAMINA_VALUE, END_RANGE_RANDOM_STAMINA_VALUE);

        if (countPlayers < PLAYERS_ON_FIELD) {
            return new Players(randomStaminaValue);
        }
        return new Players();
    }

    public static int getMaxStamina() {
        return MAX_STAMINA;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    /**
     * Метод для управления состоянием игрока, при использовании уменьшает выносливость.
     */
    void run() {
        if (stamina > 0) {
            stamina--;
        }
    }

    /**
     * Метод проверяет игрока на участие в матче и снижает выносливость выбранного игрока к минимальному значению выносливости.
     */
    void runUntilTired() {
        boolean isTired = false;
        while (!isTired) {
            if (stamina == null) {
                break;
            } else if (stamina == MIN_STAMINA) {
                isTired = true;
                countPlayers--;
            } else {
                run();
            }
        }
    }

    /**
     * Метод для получения информации о количестве игроков на поле и свободных мест.
     *
     * @return возвращает информацию о количестве игроков на поле.
     */
    static String info() {
        if (countPlayers < 0) {
            throw new RuntimeException("Количество игроков не может быть отрицательным");
        } else if (countPlayers < PLAYERS_ON_FIELD) {
            return "Команды неполные. На поле ещё есть  " + (PLAYERS_ON_FIELD - countPlayers) + " мест";
        } else {
            return "На поле нет свободных мест";
        }
    }
}
