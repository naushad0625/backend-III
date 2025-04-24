package _05_DigitalPublishingWorkflow;

import _05_DigitalPublishingWorkflow.states.IState;

public class Article {
    private IState state;

    public  Article (IState primaryState){
        state = primaryState;
    }

    public String getState() {
        return state.getName();
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void process (String userRole, RolePolicy policy) {
        state.handle(this, userRole, policy);
    }
}
