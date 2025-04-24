package _05_DigitalPublishingWorkflow;

import _05_DigitalPublishingWorkflow.states.DraftedState;
import _05_DigitalPublishingWorkflow.states.IState;
import _05_DigitalPublishingWorkflow.states.ReviewedState;

public class DigitalPublishingWorkflow {
    public static void main(String[] args) {
        IState initialState = new DraftedState();
        Article article = new Article(initialState);

        System.out.println("Initial State:" + article.getState());

        article.setState(new ReviewedState());

        System.out.println("Current state: " + article.getState());
    }
}
