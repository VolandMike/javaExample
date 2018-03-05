package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Wrong First name"),
    TRAINEE_WRONG_LASTNAME("Wrong Last name"),
    TRAINEE_WRONG_RATING("Wrong Rating");

    private String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
