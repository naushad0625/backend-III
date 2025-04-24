package _05_DigitalPublishingWorkflow;

import java.util.*;

public class RolePolicy {
    private Map<String, List<String>> roles = new HashMap<>();

    public void addPolicy(String state, ArrayList<String> allowedRoles) {
        roles.put(state, allowedRoles);
    }

    public boolean isAllowed (String state, String role) {
        return roles.getOrDefault(state, Collections.emptyList()).contains(role);
    }
}
