package com.company.demo;


/*
*
* GrandChildren Question Implemented in different approach.
* Custom Stack was implemented using ArrayList
* Reduced the number of lines of code than previous version.
*
* */

public class Question1 {
    String arr[][] = {
            {"Lava" , "Rama"},
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

        while (!stack.isStackEmpty())
        {
            String data = stack.popFromStack();
            setChildren(data,true);
            count ++;
        }

        System.out.println("\nThe number of Grand Children for "+ name+" = " +count);
    }


}
