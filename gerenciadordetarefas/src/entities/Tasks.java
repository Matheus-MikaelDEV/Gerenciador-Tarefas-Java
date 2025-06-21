package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tasks {
    private String name;
    private String description;
    private LocalDate limitDate;
    private Integer priority;

    public Tasks(String name, String description, LocalDate limitDate, Integer priority) {
        this.name = name;
        this.description = description;
        this.limitDate = limitDate;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public long getDelay() {
        if (LocalDate.now().isAfter(limitDate)) {
            LocalDate today = LocalDate.now();
            return ChronoUnit.DAYS.between(limitDate, today);
        }
        return 0;
    }
}