import java.util.Comparator;


public class StatusComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        int rank1 = getStatusRank(task1.getStatus());
        int rank2 = getStatusRank(task2.getStatus());

        if (rank1 > rank2) {
            return -1;
        }

        if (rank1 < rank2) {
            return 1;
        }

        return 0;
    }

    private int getStatusRank(TaskStatus status) {

        switch (status) {

            case COMPLETED:
                return 3;

            case IN_PROGRESS:
                return 2;

            case PENDING:
                return 1;

            default:
                return 0;
        }
    }
}