package br.com.igti.futebolquiz.control;

import java.util.ArrayList;
import java.util.List;

import br.com.igti.futebolquiz.model.Answer;
import br.com.igti.futebolquiz.model.Question;

public class QuizFactory {
    public static List<Question> buildQuizQuestions(){
        List<Question> list = new ArrayList<>();
        list.add(buildOne());
        list.add(buildTwo());
        list.add(buildThree());
        list.add(buildFour());
        list.add(buildFive());
        return list;
    }
    private static Question buildOne(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Maradona"));
        answers.add(new Answer("Pelé"));
        return new Question("Quem é o maior jogador da história?",2,answers);
    }
    private static Question buildTwo(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("6"));
        answers.add(new Answer("4"));
        answers.add(new Answer("5"));
        return new Question("Quantas vezes a seleção brasileira ganhou a copa do mundo?",3,answers);
    }
    private static Question buildThree(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("CR7"));
        answers.add(new Answer("Nenhum dos dois tem bola de ouro"));
        answers.add(new Answer("Messi"));
        answers.add(new Answer("Empatados"));
        return new Question("Quem tem mais bolas de ouro: Messi ou CR7?",4,answers);
    }
    private static Question buildFour(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Everaldo(Chapecoense)"));
        answers.add(new Answer("Bruno Henrique(Flamengo)"));
        answers.add(new Answer("Kayke(Do Góias)"));
        answers.add(new Answer("Pedro(Fluminense)"));
        answers.add(new Answer("Gabigol(Do Flamengo)"));
        return new Question("Quem é o artilheiro do brasileirão de 2019?",5,answers);
    }
    private static Question buildFive(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("350"));
        answers.add(new Answer("352"));
        answers.add(new Answer("348"));
        answers.add(new Answer("302"));
        answers.add(new Answer("52"));
        answers.add(new Answer("332"));
        return new Question("Quantos gols o Neymar já fez na carreira?",2,answers);
    }

}
