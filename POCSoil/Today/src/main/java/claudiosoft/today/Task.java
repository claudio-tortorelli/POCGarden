package claudiosoft.today;

import java.time.LocalDate;

/**
 *
 * @author Claudio
 */
public class Task {

    private LocalDate startDate;
    private LocalDate endDate;
    private Priority priority;
    private double effort;
    private String Id;
    private boolean enabled;
    private boolean flexible;

    public Task(LocalDate startDate, LocalDate endDate, Priority priority, double effort, String Id, boolean enabled, boolean flexible) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.effort = effort;
        this.Id = Id;
        this.enabled = enabled;
        this.flexible = flexible;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isFlexible() {
        return flexible;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

}
