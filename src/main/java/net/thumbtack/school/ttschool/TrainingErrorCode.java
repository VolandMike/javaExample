package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Wrong First name"),
    TRAINEE_WRONG_LASTNAME("Wrong Last name"),
    GROUP_WRONG_NAME("Wrong Group name"),
    GROUP_WRONG_ROOM("Wrong Room name"),
    TRAINEE_WRONG_RATING("Wrong Rating"),
    TRAINEE_NOT_FOUND("Trainee not found"),
    SCHOOL_WRONG_NAME("Wrong school name"),
    DUPLICATE_GROUP_NAME("Duplicate group name"),
    GROUP_NOT_FOUND("Group not found"),
    DUPLICATE_TRAINEE("Duplicate Trainee"),
    EMPTY_TRAINEE_QUEUE("Empty trainee queue");

    private String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
