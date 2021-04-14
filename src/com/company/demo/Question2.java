package com.company.demo;

/*

["Ajay" , "M","Babu","Chitra"] ,
["Divya","F","Babu","Chitra"],
["Chitra","F","Eashan","Falguni"],
["Ganesh" , "M","Eashan","Falguni"],
["Hema","F","Ganesh","Indhu"],
["Jegan","M","Ganesh","Indhu"],
[ "Babu","M","Kumar","Lakshmi"],
["Meena","F","Kumar","Lakshmi"],
["Nethaji","M","OmPrakash","Meena"]

   * */

import java.util.ArrayList;

public class Question2 {

  ArrayList<DataModel> dataModels = new ArrayList<>();

  public Question2() {
    dataModels.add(new DataModel("Ajay", "M", "Babu", "Chitra"));
    dataModels.add(new DataModel("Divya", "F", "Babu", "Chitra"));
    dataModels.add(new DataModel("Chitra", "F", "Eashan", "Falguni"));
    dataModels.add(new DataModel("Ganesh", "M", "Eashan", "Falguni"));
    dataModels.add(new DataModel("Hema", "F", "Ganesh", "Indhu"));
    dataModels.add(new DataModel("Jegan", "M", "Ganesh", "Indhu"));
    dataModels.add(new DataModel("Babu", "M", "Kumar", "Lakshmi"));
    dataModels.add(new DataModel("Meena", "F", "Kumar", "Lakshmi"));
    dataModels.add(new DataModel("Nethaji", "M", "OmPrakash", "Meena"));
  }

  public void getUncleDaughter(String groomName) {
    ArrayList<DataModel> uncles = getUncle(groomName);

    for (DataModel uncle : uncles) {
      ArrayList<DataModel> children = getChildByFatherName(uncle.getName());

      for (DataModel bride : children) {
        if (bride.getGender().equals("F")) {
          System.out.println(bride.toString());
        }
      }
    }
  }

  public void getUncleSon(String brideName) {
    ArrayList<DataModel> uncles = getUncle(brideName);

    for (DataModel uncle : uncles) {
      ArrayList<DataModel> children = getChildByFatherName(uncle.getName());

      for (DataModel groom : children) {
        if (groom.getGender().equals("M")) {
          System.out.println(groom.toString());
        }
      }
    }
  }

  public void getAuntDaughter(String groomName) {
    ArrayList<DataModel> aunties = getAunt(groomName);

    for (DataModel aunt : aunties) {
      ArrayList<DataModel> children = getChildByMotherName(aunt.getName());

      for (DataModel bride : children) {
        if (bride.getGender().equals("F")) {
          System.out.println(bride.toString());
        }
      }
    }
  }

  public void getAuntSon(String brideName) {
    ArrayList<DataModel> aunties = getAunt(brideName);
    for (DataModel aunt : aunties) {
      ArrayList<DataModel> children = getChildByMotherName(aunt.getName());

      for (DataModel groom : children) {
        if (groom.getGender().equals("M")) {
          System.out.println(groom.toString());
        }
      }
    }
  }

  public ArrayList<DataModel> getDaughterOfSister(String groomName) {
    ArrayList<DataModel> daughters = new ArrayList<>();
    ArrayList<DataModel> siblings = findSiblings(groomName);
    for (DataModel sibling : siblings) {
      if (sibling.getGender().equals("F")) {
        daughters.add(sibling);
      }
    }
    return daughters;
  }

  public ArrayList<DataModel> getAunt(String groomName) {
    ArrayList<DataModel> aunties = new ArrayList<>();
    String fatherName = getFather(groomName);
    ArrayList<DataModel> siblingsOfFather = findSiblings(fatherName);
    for (DataModel datamodel : siblingsOfFather) {
      if (datamodel.getGender().equals("F")) {
        aunties.add(datamodel);
      }
    }
    //     printArray(aunties);
    return aunties;
  }

  // Mother's brothers
  public ArrayList<DataModel> getUncle(String groomName) {
    ArrayList<DataModel> uncles = new ArrayList<>();
    String motherName = getMother(groomName);
    ArrayList<DataModel> siblingsOfMother = findSiblings(motherName);
    for (DataModel datamodel : siblingsOfMother) {
      if (datamodel.getGender().equals("M")) {
        uncles.add(datamodel);
      }
    }
    // printArray(uncles);
    return uncles;
  }

  public ArrayList<DataModel> findSiblings(String name) {
    ArrayList<DataModel> siblings = new ArrayList<>();
    String fatherName = getFather(name);
    for (DataModel dataModel : dataModels) {
      if (dataModel.getFather().equals(fatherName) && !dataModel.getName().equals(name)) {
        siblings.add(dataModel);
      }
    }
    //     printArray(siblings);
    return siblings;
  }

  public String getFather(String name) {
    for (DataModel dataModel : dataModels) {
      if (dataModel.getName().equals(name)) {
        return dataModel.getFather();
      }
    }
    return "";
  }

  public String getMother(String name) {
    for (DataModel dataModel : dataModels) {
      if (dataModel.getName().equals(name)) {
        return dataModel.getMother();
      }
    }
    return "";
  }

  public ArrayList<DataModel> getChildByFatherName(String fatherName) {
    ArrayList<DataModel> children = new ArrayList<>();
    for (DataModel child : dataModels) {
      if (child.getFather().equals(fatherName)) {
        children.add(child);
      }
    }
    return children;
  }

  public ArrayList<DataModel> getChildByMotherName(String motherName) {
    ArrayList<DataModel> children = new ArrayList<>();
    for (DataModel child : dataModels) {
      if (child.getMother().equals(motherName)) {
        children.add(child);
      }
    }
    //   printArray(children);
    return children;
  }

  private void printArray(ArrayList<DataModel> arrayList) {
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i).toString());
    }
  }
}
