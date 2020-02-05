package ru.krestyankin.quiz.service;

import ru.krestyankin.quiz.domain.Student;

public class StudentServiceImpl implements StudentService {
    private final userInterfaceService ui;

    public StudentServiceImpl(userInterfaceService ui) {
        this.ui = ui;
    }

    public Student getStudent() {
        String firstName;
        String lastName;
        ui.writeString("Фамилия студента:");
        firstName = ui.getString();
        ui.writeString("Имя студента:");
        lastName = ui.getString();
        return new Student(firstName, lastName);
    }
}
