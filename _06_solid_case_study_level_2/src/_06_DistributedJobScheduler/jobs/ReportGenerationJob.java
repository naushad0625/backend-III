package _06_DistributedJobScheduler.jobs;

import _06_DistributedJobScheduler.jobContext.JobContext;

public class ReportGenerationJob implements Job{
    private JobContext jobContext;

    public ReportGenerationJob(JobContext jobContext) {
        this.jobContext = jobContext;
    }

    @Override
    public void execute () {}
}
