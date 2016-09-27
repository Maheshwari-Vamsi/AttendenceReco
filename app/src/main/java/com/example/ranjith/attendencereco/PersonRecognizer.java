package com.example.ranjith.attendencereco;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;

import com.googlecode.javacv.cpp.opencv_contrib;
import com.googlecode.javacv.cpp.opencv_contrib.FaceRecognizer;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_imgproc;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

import googlecode.javacv.cpp.opencv_core;

public class PersonRecognizer
{
  static final int HEIGHT = 128;
  public static final int MAXIMG = 100;
  static final int WIDTH = 128;
  int count = 0;
  opencv_contrib.FaceRecognizer faceRecognizer = opencv_contrib.createLBPHFaceRecognizer(2, 8, 8, 8, 200.0D);
  labels labelsFile;
  String mPath;
  private int mProb = 999;
  
  PersonRecognizer(String paramString)
  {
    this.mPath = paramString;
    this.labelsFile = new labels(this.mPath);
    this.labelsFile.Read();
  }
  
  opencv_core.IplImage BitmapToIplImage(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) || (paramInt2 != -1)) {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
    }
    opencv_core.IplImage localIplImage1 = opencv_core.IplImage.create(paramBitmap.getWidth(), paramBitmap.getHeight(), 8, 4);
    paramBitmap.copyPixelsToBuffer(localIplImage1.getByteBuffer());
    opencv_core.IplImage localIplImage2 = opencv_core.IplImage.create(localIplImage1.width(), localIplImage1.height(), 8, 1);
    opencv_imgproc.cvCvtColor(localIplImage1, localIplImage2, 6);
    return localIplImage2;
  }
  
  opencv_core.IplImage MatToIplImage(Mat paramMat, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramMat.width(), paramMat.height(), Config.ARGB_8888);
    Utils.matToBitmap(paramMat, localBitmap);
    return BitmapToIplImage(localBitmap, paramInt1, paramInt2);
  }
  
  protected void SaveBmp(Bitmap paramBitmap, String paramString)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString, true);
      paramBitmap.compress(CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      Log.e("", localException.getMessage() + localException.getCause());
      localException.printStackTrace();
    }
  }
  
  void add(Mat paramMat, String paramString)
  {
    Bitmap localBitmap1 = Bitmap.createBitmap(paramMat.width(), paramMat.height(), Config.ARGB_8888);
    Utils.matToBitmap(paramMat, localBitmap1);
    Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, 128, 128, false);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(this.mPath + paramString + "-" + this.count + ".jpg", true);
      this.count = (1 + this.count);
      localBitmap2.compress(CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      Log.e("error", localException.getCause() + " " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public boolean canPredict()
  {
    return this.labelsFile.max() > 1;
  }
  
  void changeRecognizer(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      train();
      return;
      this.faceRecognizer = opencv_contrib.createLBPHFaceRecognizer(1, 8, 8, 8, 100.0D);
      continue;
      this.faceRecognizer = opencv_contrib.createFisherFaceRecognizer();
      continue;
      this.faceRecognizer = opencv_contrib.createEigenFaceRecognizer();
    }
  }
  
  public int getProb()
  {
    return this.mProb;
  }
  
  public void load()
  {
    train();
  }
  
  public String predict(Mat paramMat)
  {
    if (!canPredict()) {
      return "";
    }
    int[] arrayOfInt = new int[1];
    double[] arrayOfDouble = new double[1];
    opencv_core.IplImage localIplImage = MatToIplImage(paramMat, 128, 128);
    this.faceRecognizer.predict(localIplImage, arrayOfInt, arrayOfDouble);
    if (arrayOfInt[0] != -1) {}
    for (this.mProb = ((int)arrayOfDouble[0]); arrayOfInt[0] != -1; this.mProb = -1) {
      return this.labelsFile.getResult(arrayOfInt[0]);
    }
    return "Unknown Face";
  }
  
  public boolean train()
  {
    File localFile = new File(this.mPath);
    FilenameFilter local2 = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.toLowerCase().endsWith(".jpg");
      }
    };
    File[] arrayOfFile = localFile.listFiles(local2);
    opencv_core.MatVector localMatVector = new opencv_core.MatVector(arrayOfFile.length);
    int[] arrayOfInt = new int[arrayOfFile.length];
    int i = 0;
    int j = this.mPath.length();
    int k = arrayOfFile.length;
    for (int m = 0; m < k; m++)
    {
      String str1 = arrayOfFile[m].getAbsolutePath();
      opencv_core.IplImage localIplImage1 = opencv_highgui.cvLoadImage(str1);
      if (localIplImage1 == null) {
        Log.e("Error", "Error cVLoadImage");
      }
      Log.i("image", str1);
      int n = str1.lastIndexOf("-");
      int i1 = str1.lastIndexOf(".");
      int i2 = Integer.parseInt(str1.substring(n + 1, i1));
      if (this.count < i2) {
        this.count = (1 + this.count);
      }
      String str2 = str1.substring(j, n);
      if (this.labelsFile.get(str2) < 0) {}
      int i3 = this.labelsFile.get(str2);
      opencv_core.IplImage localIplImage2 = opencv_core.IplImage.create(localIplImage1.width(), localIplImage1.height(), 8, 1);
      opencv_imgproc.cvCvtColor(localIplImage1, localIplImage2, 6);
      localMatVector.put(i, localIplImage2);
      arrayOfInt[i] = i3;
      i++;
    }
    if ((i > 0) && (this.labelsFile.max() > 1)) {
      this.faceRecognizer.train(localMatVector, arrayOfInt);
    }
    this.labelsFile.Save();
    return true;
  }
  
  public boolean train(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(this.mPath);
    FilenameFilter local1 = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.toLowerCase().endsWith(".jpg");
      }
    };
    File[] arrayOfFile = localFile.listFiles(local1);
    opencv_core.MatVector localMatVector = new opencv_core.MatVector(arrayOfFile.length);
    int[] arrayOfInt = new int[arrayOfFile.length];
    int i = 0;
    int j = this.mPath.length();
    int k = arrayOfFile.length;
    for (int m = 0; m < k; m++)
    {
      String str1 = arrayOfFile[m].getAbsolutePath();
      opencv_core.IplImage localIplImage1 = opencv_highgui.cvLoadImage(str1);
      if (localIplImage1 == null) {
        Log.e("Error", "Error cVLoadImage");
      }
      Log.i("image", str1);
      int n = str1.lastIndexOf("-");
      int i1 = str1.lastIndexOf(".");
      int i2 = Integer.parseInt(str1.substring(n + 1, i1));
      if (this.count < i2) {
        this.count = (1 + this.count);
      }
      String str2 = str1.substring(j, n);
      if (this.labelsFile.get(str2) < 0) {
        this.labelsFile.add(paramString1, str2, paramString2, paramString3, 1 + this.labelsFile.max());
      }
      int i3 = this.labelsFile.get(str2);
      opencv_core.IplImage localIplImage2 = opencv_core.IplImage.create(localIplImage1.width(), localIplImage1.height(), 8, 1);
      opencv_imgproc.cvCvtColor(localIplImage1, localIplImage2, 6);
      localMatVector.put(i, localIplImage2);
      arrayOfInt[i] = i3;
      i++;
    }
    if ((i > 0) && (this.labelsFile.max() > 1)) {
      this.faceRecognizer.train(localMatVector, arrayOfInt);
    }
    this.labelsFile.Save();
    return true;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\seakleng\facedetection\PersonRecognizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */