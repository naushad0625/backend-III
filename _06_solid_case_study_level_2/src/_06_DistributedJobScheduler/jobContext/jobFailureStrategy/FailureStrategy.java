package _06_DistributedJobScheduler.jobContext.jobFailureStrategy;

import _06_DistributedJobScheduler.jobContext.JobContext;

public interface FailureStrategy {
    public void handle(JobContext job);
}
