import java.util.ArrayList;
import java.util.List;

/**
 * Создает объект класса Game, содержит методы для управления состоянием и поведением.
 */
public class Game {
    private Integer countPlayers = 0;
    private static final int PLAYERS_ON_FIELD = 6;
    private List<Players> players = new ArrayList<>();


    /**
     * Метод для создания игрока на поле, содержит в себе проверку на максимально возможное количество игроков на поле.
     * Создает объект класса Player используя его конструктор.
     *
     * @param name       имя игрока из конструктора класса Player.
     * @param gameNumber номер игрока из конструктора класса Player.
     */
    public void addNewPlayer(String name, Integer gameNumber) {
        if (countPlayers < PLAYERS_ON_FIELD) {
            countPlayers++;
            Players newPlayer = new Players(name, gameNumber,this);
            players.add(newPlayer);
            System.out.println("Введён новый игрок, всего - " + countPlayers);
        } else {
            System.out.println("Игроков уже 6, мест нет!");
        }
    }

    /**
     * Метод для удаления игрока из списка.
     *
     * @param player Принимает параметр player класса Player.
     */
    public void removePlayer(Players player) {
        players.remove(player);
        countPlayers--;
    }

    /**
     * Метод для проверки имени игрока в списке игроков.
     *
     * @param name Имя игрока.
     * @return возвращает результат проверки.
     */
    public boolean isRepeatName(String name) {
        for (Players player : players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для получения информации о количестве свободных мест на поле.
     */
    public void info() {
        if (countPlayers < 0) {
            throw new RuntimeException("Количество игроков не может быть отрицательным");
        } else if (countPlayers < PLAYERS_ON_FIELD) {
            System.out.println("Команды неполные. На поле ещё есть  " + (PLAYERS_ON_FIELD - countPlayers) + " мест");
        } else {
            System.out.println("На поле нет свободных мест");
        }
    }

    /**
     * Метод снижает выносливость игрока до нуля.
     * @param player принимает параметр типа Игрок.
     */
    public void reduceStamina(Players player){
        for(int i = 0; i < Players.getMaxStamina(); i++){
            if(player.getStamina() > 0){
                player.run();
            }else {
                break;
            }
        }
    }

    public List<Players> getPlayers() {
        return players;
    }
}
