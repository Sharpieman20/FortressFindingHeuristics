package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.*;

import java.util.*;

public abstract class LoggingAlgorithm extends Algorithm {

    HashSet<Position> visited;

    public void reset(Position startPos) {
        super.reset(startPos);

        visited = new HashSet<Position>();
    }

    protected boolean isVisited(Position pos) {

        return visited.contains(pos);
    }

    public void doStep() {

        super.doStep();

        visited.add(prevPos);
    }
}