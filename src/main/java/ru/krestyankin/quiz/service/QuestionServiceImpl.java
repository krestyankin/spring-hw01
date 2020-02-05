package ru.krestyankin.quiz.service;

import ru.krestyankin.quiz.domain.Question;

import java.util.regex.Pattern;

public class QuestionServiceImpl implements QuestionService {
    private final userInterfaceService ui;

    public QuestionServiceImpl(userInterfaceService ui) {
        this.ui = ui;
    }

    public boolean askQuestion(Question question) {
        ui.writeString(question.getQuestion());
        return Pattern.matches(question.getAnswer(), ui.getString().trim());
    }
}
