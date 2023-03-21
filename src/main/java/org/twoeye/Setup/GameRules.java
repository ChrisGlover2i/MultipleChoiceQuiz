package org.twoeye.Setup;

public class GameRules {
    private final int numPlayers;
    private final String[] playerNames;
    private final int numRounds;

    public GameRules(int numPlayers, String[] playerNames, int numRounds) {
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;
        this.numRounds = numRounds;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public int getNumRounds() {
        return numRounds;
    }

    public void printRules() {
        System.out.println("Starting game with " + numPlayers + " players and " + numRounds + " rounds.");
    }

}
