package com.company.demo;

import java.util.ArrayList;

public class StackImpl {

    ArrayList<String> arrayList = new ArrayList();

    public String popFromStack()
    {
        return arrayList.remove(arrayList.size()-1);
    }

    public void addToStack(String data)
    {
        arrayList.add(data);
    }

    public String topOfStack()
    {
       return arrayList.get(arrayList.size()-1);
    }

    public boolean isStackEmpty()
    {
        return arrayList.isEmpty();
    }

    public int sizeOfStack()
    {
        return arrayList.size();
    }

}
