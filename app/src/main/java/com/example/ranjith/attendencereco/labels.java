package com.example.ranjith.attendencereco;

import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class labels
{
  String mPath;
  ArrayList<label> thelist = new ArrayList();
  
  public labels(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void Delete(String paramString)
  {
    File localFile1;
    File localFile2;
    BufferedReader localBufferedReader;
    try
    {
      localFile1 = new File(this.mPath + "faces.txt");
      localFile2 = new File(this.mPath + "myTempFile.txt");
      localBufferedReader = new BufferedReader(new FileReader(localFile1));
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(localFile2));
      for (;;)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null) {
          break;
        }
        String[] arrayOfString = str1.split(",", -1);
        String str2 = arrayOfString[0];
        String str3 = arrayOfString[1];
        String str4 = arrayOfString[2];
        String str5 = arrayOfString[3];
        String str6 = arrayOfString[4];
        if (!str3.equalsIgnoreCase(paramString))
        {
          localBufferedWriter.write(str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6 + ",");
          localBufferedWriter.newLine();
        }
      }
      localBufferedWriter.close();
    }
    catch (IOException localIOException)
    {
      Log.e("error", localIOException.getMessage() + " " + localIOException.getCause());
      localIOException.printStackTrace();
      return;
    }
    localBufferedReader.close();
    localFile2.renameTo(localFile1);
  }
  
  public void Read()
  {
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(this.mPath + "faces.txt");
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
      this.thelist = new ArrayList();
      for (;;)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null) {
          break;
        }
        String[] arrayOfString = str1.split(",", -1);
        String str2 = arrayOfString[0];
        String str3 = arrayOfString[1];
        String str4 = arrayOfString[2];
        String str5 = arrayOfString[3];
        String str6 = arrayOfString[4];
        this.thelist.add(new label(str2, str3, str4, str5, Integer.parseInt(str6)));
      }
      localBufferedReader.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    localFileInputStream.close();
  }
  
  public void Save()
  {
    try
    {
      File localFile = new File(this.mPath + "faces.txt");
      localFile.createNewFile();
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(localFile));
      Iterator localIterator = this.thelist.iterator();
      while (localIterator.hasNext())
      {
        label locallabel = (label)localIterator.next();
        localBufferedWriter.write(locallabel.id + "," + locallabel.name + "," + locallabel.sex + "," + locallabel.tel + "," + locallabel.num + ",");
        localBufferedWriter.newLine();
      }
      localBufferedWriter.close();
    }
    catch (IOException localIOException)
    {
      Log.e("error", localIOException.getMessage() + " " + localIOException.getCause());
      localIOException.printStackTrace();
      return;
    }
  }
  
  public void add(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.thelist.add(new label(paramString1, paramString2, paramString3, paramString4, paramInt));
  }
  
  public int get(String paramString)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.thelabel.equalsIgnoreCase(paramString)) {
        return locallabel.num;
      }
    }
    return -1;
  }
  
  public String get(int paramInt)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num == paramInt) {
        return locallabel.thelabel;
      }
    }
    return "";
  }
  
  public String getCode(int paramInt)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num == paramInt) {
        return locallabel.id;
      }
    }
    return "";
  }
  
  public String getName(int paramInt)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num == paramInt) {
        return locallabel.name;
      }
    }
    return "";
  }
  
  public String getResult(int paramInt)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num == paramInt) {
        return locallabel.id + ", " + locallabel.name + ", " + locallabel.sex + ", " + locallabel.tel;
      }
    }
    return "";
  }
  
  public String getSex(int paramInt)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num == paramInt) {
        return locallabel.sex;
      }
    }
    return "";
  }
  
  public String getTel(int paramInt)
  {
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num == paramInt) {
        return locallabel.tel;
      }
    }
    return "";
  }
  
  public boolean isEmpty()
  {
    return this.thelist.size() <= 0;
  }
  
  public int max()
  {
    int i = 0;
    Iterator localIterator = this.thelist.iterator();
    while (localIterator.hasNext())
    {
      label locallabel = (label)localIterator.next();
      if (locallabel.num > i) {
        i = locallabel.num;
      }
    }
    return i;
  }
  
  class label
  {
    String id;
    String name;
    int num;
    String sex;
    String tel;
    String thelabel;
    
    public label(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.id = paramString1;
      this.name = paramString2;
      this.sex = paramString3;
      this.tel = paramString4;
      this.thelabel = paramString2;
      this.num = paramInt;
    }
  }
}

