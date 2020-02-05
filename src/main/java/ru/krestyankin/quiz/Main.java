package ru.krestyankin.quiz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.krestyankin.quiz.service.QuizService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService Quiz = context.getBean(QuizService.class);

        Quiz.start();

        context.close();
    }
}
