package lensjudge.problem;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ConstructProblem implements Iterable<TestCase>{
    private List<TestCase> testCases;
    private int timeLimit;
    private int memoryLimit;


    @Override
    public Iterator<TestCase> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super TestCase> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<TestCase> spliterator() {
        return Iterable.super.spliterator();
    }
}
