package model;

public class Player {
    private String name;
    private String choice;

    public Player(String name, String choice) {
        this.name = name;
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }
}