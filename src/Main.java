import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(Players.info());
        Players player1 = Players.addNewPlayer();
        Players player2 = Players.addNewPlayer();
        Players player3 = Players.addNewPlayer();
        Players player4 = Players.addNewPlayer();
        System.out.print("Игроков на поле : " + Players.getCountPlayers() + " ");
        System.out.println(Players.info());
        Players player5 = Players.addNewPlayer();
        Players player6 = Players.addNewPlayer();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());

        Players player7 = Players.addNewPlayer();
        Players player8 = Players.addNewPlayer();
        System.out.print("Игроков на поле : " + Players.getCountPlayers() + " ");
        System.out.println(Players.info());

        player2.runUntilTired();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());
        player7.runUntilTired();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());
        System.out.println(Players.info());
        player1.runUntilTired();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());
        System.out.println(Players.info());
        player8.runUntilTired();
        System.out.println("Игроков на поле : " + Players.getCountPlayers());
        System.out.println(Players.info());

    }
}