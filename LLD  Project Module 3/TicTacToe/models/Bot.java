package models;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;

    public Bot(char symbol, String name, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(symbol, name, playerType);
        this.difficultyLevel = difficultyLevel;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
