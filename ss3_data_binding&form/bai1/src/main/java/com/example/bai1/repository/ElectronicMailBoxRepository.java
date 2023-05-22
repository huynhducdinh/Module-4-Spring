package com.example.bai1.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ElectronicMailBoxRepository implements  IElectronicMailBoxRepository{
  private  static List<String> languageslList =new ArrayList<>();
    static {
        languageslList.add("English");
        languageslList.add("Vietnamese");
        languageslList.add("Japanese");
        languageslList.add("Chinese");
    }
    public static List<String> pageSizeList=new ArrayList<>();
    static {
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("20");
    }

    @Override
    public List<String> languagesList() {
        return languageslList;
    }

    @Override
    public List<String> pageSizeList() {
        return pageSizeList;
    }

}
