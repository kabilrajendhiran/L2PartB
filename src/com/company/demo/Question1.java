package com.company.demo;


/*
*
* GrandChildren Question Implemented in different approach.
* Custom Stack was implemented using ArrayList
* Reduced the number of lines of code than previous version.
*
* */

import java.util.ArrayList;

public class Question1 {
    String arr[][] = {
            {"Lava" , "Rama"},
            {"Lava's Son1", "Lava"},{"Lava's Son2", "Lava"},{"Lava's Son3", "Lava"},
            {"Kusha" , "Rama"} ,
            {"Rama" , "Dasarathan"},
            {"Lakshman" , "Dasarathan"} ,
            {"Angad", "Lakshman"},
            {"Dharamketu","Lakshman"},
            {"Abhisek","Amitabh"},
            {"Aaradhya","Abhisek"}
            };

    StackImpl stack = new StackImpl();

    private int setChildren(String name, boolean flag)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1].equals(name)) {

                if (flag)
                {
                    System.out.println(arr[i][0]);
                }

                stack.addToStack(arr[i][0]);
            }
        }
        return stack.sizeOfStack();
    }

    public void findAllGrandChildren(String name)
    {

        int count = -setChildren(name,false);
        int size = stack.sizeOfStack();
        while (!stack.isStackEmpty())
        {
            String data = stack.popFromStack();
            setChildren(data,true);
            count ++;
        }

        System.out.println("\nThe number of Grand Children for "+ name+" = " +(count));
    }

    public ArrayList<String> findGrandChildren(String name)
    {
        int count = -setChildren(name,false);

        ArrayList<String> grandChildren = new ArrayList<>();
        while (!stack.isStackEmpty())
        {
            String data = stack.popFromStack();
            grandChildren.add(data);
        }

        for (int i = 0; i < grandChildren.size(); i++) {
            setChildren(grandChildren.get(i),false);
        }

        return grandChildren;
    }

    public void findGreatGrandChildren(String name)
    {
        int count  = 0;
        findGrandChildren(name);
        int size = stack.sizeOfStack();
        while (!stack.isStackEmpty())
        {
            count++;
            String name1 = stack.popFromStack();
            setChildren(name1,true);
        }

        
        System.out.println("\nThe number of Great Grand Children for "+ name+" = " +(count-size));


    }







}
