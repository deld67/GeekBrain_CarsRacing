package src.ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private Car winner;
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>( Arrays.asList(stages));
    }

    public Car getWinner() {
        return winner;
    }

    public void setWinner(Car winner) {
        if (this.winner == null) this.winner = winner;
    }
}