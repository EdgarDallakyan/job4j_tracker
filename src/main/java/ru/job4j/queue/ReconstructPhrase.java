package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        for (int i = evenElements.size(); i > 0; i--) {
            Character number = evenElements.poll();
            if (i % 2 == 0) {
                rsl.append(number);
            }
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        while (descendingElements.size() > 0) {
            Character number = descendingElements.pollLast();
            rsl.append(number);
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}