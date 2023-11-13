package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Clock {

    private LocalDateTime created = LocalDateTime.now();

    public Clock() { }

    public LocalDateTime getCreated() {
        return created;
    }
}
