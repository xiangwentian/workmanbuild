package com.source.workman.designMode.strategy;

public class MainInvokeTest {
    public static void main(String[] args) {
        Profession profession = ProfessionFactory.getProfession("programmer");
        profession.outPut();
    }
}
