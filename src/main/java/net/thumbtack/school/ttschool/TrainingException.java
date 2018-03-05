package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {
    private TrainingErrorCode ErrorCode;

    public TrainingException(TrainingErrorCode ErrorCode) {
        this.ErrorCode = ErrorCode;
    }


    public void setTrainingErrorCode(TrainingErrorCode trainingErrorCode) {
        this.ErrorCode = trainingErrorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return ErrorCode;
    }
}
