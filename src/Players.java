/**
 * Класс создает объект типа Игрок. Содержит методы для управления полями и поведением.
 */
public class Players {
    private int stamina;
    private static int id = 0;
    private final Integer countId;
    private static final int MIN_STAMINA = 0;
    private static final int MAX_STAMINA = 10;
    private static int countPlayers = 0;
    private static final int PLAYERS_ON_FIELD = 6;

    public Players(int stamina) {
        this.stamina = stamina;
        if (countPlayers < PLAYERS_ON_FIELD) {
            countPlayers++;
            countId = id++;
        }else {
            countId = null;
        }
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
        if(stamina < 0){
            stamina = MIN_STAMINA;
        }else {
            stamina--;
        }
    }

    /**
     * Метод проверяет игрока на участие в матче и снижает выносливость выбранного игрока к минимальному значению выносливости.
     */
    void runUntilTired(){
        boolean isTired = false;
        while (!isTired){
            if(countId == null){
                throw new RuntimeException("Этот игрок не участвовал в матче");
            }
            else if(stamina == MIN_STAMINA && countId <= PLAYERS_ON_FIELD){
                isTired = true;
                countPlayers--;
            }else {
                run();
            }
        }
    }

    /**
     * Метод для получения информации о количестве игроков на поле и свободных мест.
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
