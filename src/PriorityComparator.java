import java.util.Comparator;

public class PriorityComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        int rank1 = getPriorityRank(task1.getPriority());
        int rank2 = getPriorityRank(task2.getPriority());
        return Integer.compare(rank2, rank1);
        
        
    }

    private int getPriorityRank(Priority priority) {

    switch (priority) {

        case HIGH:
            return 3;

        case MEDIUM:
            return 2;

        case LOW:
            return 1;

        default:
            return 0;
    }

}

}