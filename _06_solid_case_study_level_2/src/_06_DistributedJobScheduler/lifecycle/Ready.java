package _06_DistributedJobScheduler.lifecycle;

public class Ready extends LifecycleState {
    public Ready() {
        state = "Ready";
    }

    @Override
    public String getState() {
        return state;
    }
}
