package _06_DistributedJobScheduler.jobContext;

import _06_DistributedJobScheduler.jobContext.jobFailureStrategy.FailureStrategy;
import _06_DistributedJobScheduler.lifecycle.LifecycleState;

public class JobContext {

    private LifecycleState state;
    private RuntimeEnv runtimeEnv;
    private JobAllocatedResource jobAllocatedResource;
    private FailureStrategy failureStrategy;

    public JobContext(LifecycleState state, RuntimeEnv runtimeEnv, JobAllocatedResource jobAllocatedResource, FailureStrategy failureStrategy) {
        this.state = state;
        this.runtimeEnv = runtimeEnv;
        this.jobAllocatedResource = jobAllocatedResource;
        this.failureStrategy = failureStrategy;
    }

    public String getState() {
        return this.state.getState();
    }

    public RuntimeEnv getRuntime() {
        return this.runtimeEnv;
    }

    public JobAllocatedResource getAllocatedResource() {
        return this.jobAllocatedResource;
    }

    public FailureStrategy getFailureStartegy() {
        return this.failureStrategy;
    }

    public void updateState(LifecycleState state) {
        this.state = state;
    }
}
