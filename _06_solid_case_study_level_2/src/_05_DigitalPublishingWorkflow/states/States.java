package _05_DigitalPublishingWorkflow.states;

public enum States {
    DRAFTED("Drafted"),
    REVIEWED("Reviewed"),
    APPROVED("Approved");

    private final String state;

    States(String state) {
        this.state = state;
    }
}
