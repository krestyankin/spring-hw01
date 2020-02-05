package ru.krestyankin.quiz.service;

import ru.krestyankin.quiz.domain.TestResult;

public class TestResultServiceImpl implements TestResultService {
    private final userInterfaceService ui;

    public TestResultServiceImpl(userInterfaceService ui) {
        this.ui = ui;
    }

    public void store(TestResult testResult) {
        ui.writeString("Рузультат тестирования: \n"+ testResult.toString());
    }
}
