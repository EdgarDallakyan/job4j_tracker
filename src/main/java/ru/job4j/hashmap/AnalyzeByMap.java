package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                count++;
            }
        }
        return sumScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelsByPupil = new ArrayList<>();
        double sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            labelsByPupil.add(new Label(pupil.name(), sumScore / pupil.subjects().size()));
            sumScore = 0;
        }
        return labelsByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        List<Label> labelsBySubject = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labelsBySubject.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labelsBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
            score = 0;
        }
        return Collections.max(list);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        List<Label> list = new ArrayList<>();
        for (String subjectName : map.keySet()) {
            list.add(new Label(subjectName, (double) map.get(subjectName)));
        }
        return Collections.max(list);
    }
}