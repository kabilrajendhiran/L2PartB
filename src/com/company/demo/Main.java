package com.company.demo;

import java.util.ArrayList;

public class Main {

     Question2 question2 = new Question2();
     public static void main(String[] args) {

        //Question 1

        Question1 question1 = new Question1();
        question1.findAllGrandChildren("Dasarathan");


        //Question 2


        Question1 question1 = new Question1();
        question1.findAllGrandChildren("Dasarathan");






       /* String groom = "Ajay";
        String bride = "Divya";

        Main main = new Main();

        System.out.println("Brides for "+ groom);
        main.findBribes(groom);
        System.out.println();

        System.out.println("Grooms for "+ bride);
        main.findGrooms(bride);
        System.out.println();*/
    }

    private static void printArray(ArrayList<DataModel> arrayList)
    {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    private void findBribes(String groomName)
    {
        question2.getAuntDaughter(groomName);
        question2.getUncleDaughter(groomName);
        question2.getDaughterOfSister(groomName);
    }

    private void findGrooms(String brideName)
    {
        question2.getAuntSon(brideName);
        question2.getUncleSon(brideName);
        printArray(question2.getUncle(brideName));
    }
}
