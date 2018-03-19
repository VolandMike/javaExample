package net.thumbtack.school.ttschool;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {

    Queue<Trainee> queue;

    public TraineeQueue() {
        queue = new LinkedList<>();
    }

    public Queue<Trainee> getQueue() {
        return queue;
    }

    /**
     * Добавляет студента в очередь.
     *
     * @param trainee
     */
    public void addTrainee(Trainee trainee) {
        getQueue().add(trainee);
    }

    /**
     * Удаляет студента из очереди. Если в очереди никого нет,
     * выбрасывает TrainingException с TrainingErrorCode.EMPTY_TRAINEE_QUEUE.
     *
     * @return
     */
    public Trainee removeTrainee() throws TrainingException {
        if (!getQueue().isEmpty()) {
            return getQueue().remove();
        }

        throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);

    }

}
