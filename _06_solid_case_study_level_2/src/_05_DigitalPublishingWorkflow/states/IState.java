package _05_DigitalPublishingWorkflow.states;

import _05_DigitalPublishingWorkflow.Article;
import _05_DigitalPublishingWorkflow.RolePolicy;

public interface IState {
    public String getName();
   public void handle (Article article, String userRole, RolePolicy policy);
}
