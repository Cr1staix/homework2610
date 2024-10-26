import java.util.Random;

public class Main {
    private static final int START_RANGE_RANDOM_STAMINA_VALUE = 8;
    private static final int END_RANGE_RANDOM_STAMINA_VALUE = (Players.getMaxStamina() + 1);

    public static void main(String[] args) {
        Random random = new Random();
        int randomStaminaValue = random.nextInt(START_RANGE_RANDOM_STAMINA_VALUE, END_RANGE_RANDOM_STAMINA_VALUE);
        System.out.println(Players.info());
        Players player1 = new Players(randomStaminaValue);
        Players player2 = new Players(randomStaminaValue);
        Players player3 = new Players(randomStaminaValue);
        Players player4 = new Players(randomStaminaValue);
        System.out.print("Игроков на поле : " + Players.getCountPlayers() + " ");
        System.out.println(Players.info());
        Players player5 = new Players(randomStaminaValue);
        Players player6 = new Players(randomStaminaValue);
        System.out.println("Игроков на поле : " + Players.getCountPlayers());

        Players player7 = new Players(randomStaminaValue);
        Players player8 = new Players(randomStaminaValue);
        System.out.print("Игроков на поле : " + Players.getCountPlayers() + " ");
        System.out.println(Players.info());

        player2.runUntilTired();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());
        player7.runUntilTired();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());

    }
}