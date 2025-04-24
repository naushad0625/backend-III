package _05_DigitalPublishingWorkflow.states;

import _05_DigitalPublishingWorkflow.Article;
import _05_DigitalPublishingWorkflow.RolePolicy;

public class ReviewedState implements IState{
    @Override
    public String getName() {
        return States.REVIEWED.toString();
    }

    @Override
    public void handle(Article article, String userRole, RolePolicy policy) {
        if (policy.isAllowed(getName(), userRole))
            System.out.println("Article has been reviewed");
        else System.out.println("No permission.");
    }
}
