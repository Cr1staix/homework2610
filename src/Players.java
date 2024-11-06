/**
 * * Создает объект класса Player, содержит методы для управления состоянием и поведением.
 */

import java.util.Random;

public class Players {
    Random random = new Random();
    private Integer stamina;
    private static final int MIN_STAMINA = 0;
    private static final int MAX_STAMINA = 10;
    private static final int START_RANGE_RANDOM_STAMINA_VALUE = 8;
    private static final int END_RANGE_RANDOM_STAMINA_VALUE = (Players.getMaxStamina() + 1);
    private Game game;
    private String name;
    private Integer gameNumber;

    public Players(String name, Integer gameNumber, Game game) {
        this.stamina = random.nextInt(START_RANGE_RANDOM_STAMINA_VALUE, END_RANGE_RANDOM_STAMINA_VALUE);
        this.name = name;
        this.gameNumber = gameNumber;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(Integer gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static int getMaxStamina() {
        return MAX_STAMINA;
    }

    public Integer getStamina() {
        return stamina;
    }

    /**
     * Метод для управления состоянием выносливости, при снижении до нуля игрок удаляется.
     *
     */
    public void run() {
        stamina--;
        System.out.println("Игрок " + name + " побежал, выносливость - " + stamina);
        if (stamina <= MIN_STAMINA) {
            game.removePlayer(this);
            System.out.println("Игрок  " + name + " под номером " + gameNumber + " выбыл");
        }

    }

    @Override
    public String toString() {
        return "Игрок " + name + "{выносливость=" + stamina + '\'' + ", игровой номер=" + gameNumber + '}';
    }
}
