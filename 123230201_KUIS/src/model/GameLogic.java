package model;

public class GameLogic {
    public static String determineWinner(Player p1, Player p2) {
        String c1 = p1.getChoice();
        String c2 = p2.getChoice();

        if (c1.equals(c2)) {
            return "Sayangnya, kedua pemain sama-sama kalah/menang";
        } else if ((c1.equals("Batu") && c2.equals("Gunting")) ||
                   (c1.equals("Kertas") && c2.equals("Batu")) ||
                   (c1.equals("Gunting") && c2.equals("Kertas"))) {
            return "Selamat!! " + p1.getName() + " memenangkan pertandingan";
        } else {
            return "Selamat!! " + p2.getName() + " memenangkan pertandingan";
        }
    }
}