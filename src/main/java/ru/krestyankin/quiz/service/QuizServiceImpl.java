package ru.krestyankin.quiz.service;

import ru.krestyankin.quiz.dao.QuestionDao;
import ru.krestyankin.quiz.domain.Student;
import ru.krestyankin.quiz.domain.TestResult;

public class QuizServiceImpl implements QuizService {
    private final StudentService studentService;
    private final QuestionDao questions;
    private final QuestionService questionService;
    private final TestResultService testResultService;
    private static final int QUESTIONS_TO_ASK=5;

    private Student student;

    public QuizServiceImpl(StudentService studentService, QuestionDao questions, QuestionService questionService, TestResultService testResultService) {
        this.studentService = studentService;
        this.questions = questions;
        this.questionService = questionService;
        this.testResultService = testResultService;
    }

    public String getMark(int rightAnswers, int totalQuestions) {
        return (100*rightAnswers/totalQuestions>80?"Зачет":"Не зачет");
    }

    public void start() {
        if(questions.count()<QUESTIONS_TO_ASK)
            throw new RuntimeException("Мало вопросов в вопроснике: " + questions.count() + " < " + QUESTIONS_TO_ASK);
        student=studentService.getStudent();
        int rightAnswers=0;
        for(int i=0; i<QUESTIONS_TO_ASK; i++){
            rightAnswers+=(questionService.askQuestion(questions.getByNum(i))?1:0);
        }
        testResultService.store(new TestResult(student, getMark(rightAnswers, QUESTIONS_TO_ASK)));
    }
}
