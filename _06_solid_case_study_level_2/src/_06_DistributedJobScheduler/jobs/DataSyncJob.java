package _06_DistributedJobScheduler.jobs;

import _06_DistributedJobScheduler.jobContext.JobContext;

public class DataSyncJob implements Job{
    private JobContext jobContext;

    public DataSyncJob(JobContext jobContext) {
        this.jobContext = jobContext;
    }

    @Override
    public void execute() {

    }
}
