
public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        System.out.println(game.getPlayers());
        game.info();

        game.addNewPlayer("Василий", 2);
        game.addNewPlayer("Алексей", 41);
        game.addNewPlayer("Игнат", 22);


        System.out.println(game.getPlayers());
        game.addNewPlayer("Михаил", 6);
        game.addNewPlayer("Александр", 7);
        game.addNewPlayer("Василий", 11);
        System.out.println(game.getPlayers());


        game.addNewPlayer("Борис", 54);
        System.out.println(game.getPlayers());

        game.getPlayers().get(0).run();
        game.getPlayers().get(3).run();

        System.out.println(game.isRepeatName("Алексей"));
        System.out.println(game.isRepeatName("Боб"));

        game.reduceStamina(game.getPlayers().get(4));
        game.info();
    }
}