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
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> labelsBySubject = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labelsBySubject.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labelsBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelsStudents = new ArrayList<>();
        double sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            labelsStudents.add(new Label(pupil.name(), sumScore));
            sumScore = 0;
        }
        labelsStudents.sort(Comparator.naturalOrder());
        return labelsStudents.get(labelsStudents.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.putIfAbsent(subject.name(), 0);
                if (map.containsKey(subject.name())) {
                    map.replace(subject.name(), map.get(subject.name()) + subject.score());
                }
            }
        }
        List<Label> labelsSubjects = new ArrayList<>();
        for (String subjectName : map.keySet()) {
            labelsSubjects.add(new Label(subjectName, (double) map.get(subjectName)));
        }
        labelsSubjects.sort(Comparator.naturalOrder());
        return labelsSubjects.get(labelsSubjects.size() - 1);
    }
}