package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.opencv_calib3d;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvPoint2D32f;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_flann.Index;
import com.googlecode.javacv.cpp.opencv_flann.IndexParams;
import com.googlecode.javacv.cpp.opencv_flann.KDTreeIndexParams;
import com.googlecode.javacv.cpp.opencv_flann.SearchParams;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_imgproc;
import com.googlecode.javacv.cpp.opencv_legacy;
import com.googlecode.javacv.cpp.opencv_legacy.CvSURFParams;
import com.googlecode.javacv.cpp.opencv_legacy.CvSURFPoint;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ObjectFinder
{
  private static final Logger logger;
  private opencv_core.CvMat H = null;
  private opencv_core.CvMat distsMat;
  private opencv_flann.Index flannIndex = null;
  private FloatBuffer[] imageDescriptors = null;
  private opencv_legacy.CvSURFPoint[] imageKeypoints = null;
  private opencv_core.CvMat imageMat;
  private opencv_flann.IndexParams indexParams = null;
  private opencv_core.CvMat indicesMat;
  private opencv_core.CvMat mask = null;
  private FloatBuffer[] objectDescriptors = null;
  private opencv_legacy.CvSURFPoint[] objectKeypoints = null;
  private opencv_core.CvMat objectMat;
  private opencv_core.CvMat pt1 = null;
  private opencv_core.CvMat pt2 = null;
  private ArrayList<Integer> ptpairs = null;
  private opencv_flann.SearchParams searchParams = null;
  private Settings settings;
  private opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();
  private opencv_core.CvMemStorage tempStorage = opencv_core.CvMemStorage.create();
  
  static
  {
    if (!ObjectFinder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      logger = Logger.getLogger(ObjectFinder.class.getName());
      return;
    }
  }
  
  public ObjectFinder(Settings paramSettings)
  {
    setSettings(paramSettings);
  }
  
  public ObjectFinder(opencv_core.IplImage paramIplImage)
  {
    this.settings = new Settings();
    this.settings.objectImage = paramIplImage;
    setSettings(this.settings);
  }
  
  private double compareSURFDescriptors(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, double paramDouble)
  {
    double d1 = 0.0D;
    assert ((paramFloatBuffer1.capacity() == paramFloatBuffer2.capacity()) && (paramFloatBuffer1.capacity() % 4 == 0));
    for (int i = 0;; i += 4) {
      if (i < paramFloatBuffer1.capacity())
      {
        double d2 = paramFloatBuffer1.get(i) - paramFloatBuffer2.get(i);
        double d3 = paramFloatBuffer1.get(i + 1) - paramFloatBuffer2.get(i + 1);
        double d4 = paramFloatBuffer1.get(i + 2) - paramFloatBuffer2.get(i + 2);
        double d5 = paramFloatBuffer1.get(i + 3) - paramFloatBuffer2.get(i + 3);
        d1 += d2 * d2 + d3 * d3 + d4 * d4 + d5 * d5;
        if (d1 <= paramDouble) {}
      }
      else
      {
        return d1;
      }
    }
  }
  
  private void findPairs(opencv_legacy.CvSURFPoint[] paramArrayOfCvSURFPoint1, FloatBuffer[] paramArrayOfFloatBuffer1, opencv_legacy.CvSURFPoint[] paramArrayOfCvSURFPoint2, FloatBuffer[] paramArrayOfFloatBuffer2)
  {
    for (int i = 0; i < paramArrayOfFloatBuffer1.length; i++)
    {
      opencv_legacy.CvSURFPoint localCvSURFPoint = paramArrayOfCvSURFPoint1[i];
      int j = naiveNearestNeighbor(paramArrayOfFloatBuffer1[i], localCvSURFPoint.laplacian(), paramArrayOfCvSURFPoint2, paramArrayOfFloatBuffer2);
      if (j >= 0)
      {
        this.ptpairs.add(Integer.valueOf(i));
        this.ptpairs.add(Integer.valueOf(j));
      }
    }
  }
  
  private void flannFindPairs(FloatBuffer[] paramArrayOfFloatBuffer1, FloatBuffer[] paramArrayOfFloatBuffer2)
  {
    int i = paramArrayOfFloatBuffer1[0].capacity();
    if (this.imageMat.rows() < paramArrayOfFloatBuffer2.length) {
      this.imageMat = opencv_core.CvMat.create(paramArrayOfFloatBuffer2.length, i, 5, 1);
    }
    int j = this.imageMat.rows();
    this.imageMat.rows(paramArrayOfFloatBuffer2.length);
    FloatBuffer localFloatBuffer1 = this.objectMat.getFloatBuffer();
    for (int k = 0; k < paramArrayOfFloatBuffer1.length; k++) {
      localFloatBuffer1.put(paramArrayOfFloatBuffer1[k]);
    }
    FloatBuffer localFloatBuffer2 = this.imageMat.getFloatBuffer();
    for (int m = 0; m < paramArrayOfFloatBuffer2.length; m++) {
      localFloatBuffer2.put(paramArrayOfFloatBuffer2[m]);
    }
    this.flannIndex.build(this.imageMat, this.indexParams, 1);
    this.flannIndex.knnSearch(this.objectMat, this.indicesMat, this.distsMat, 2, this.searchParams);
    IntBuffer localIntBuffer = this.indicesMat.getIntBuffer();
    FloatBuffer localFloatBuffer3 = this.distsMat.getFloatBuffer();
    for (int n = 0; n < paramArrayOfFloatBuffer1.length; n++) {
      if (localFloatBuffer3.get(n * 2) < this.settings.distanceThreshold * localFloatBuffer3.get(1 + n * 2))
      {
        this.ptpairs.add(Integer.valueOf(n));
        this.ptpairs.add(Integer.valueOf(localIntBuffer.get(n * 2)));
      }
    }
    this.imageMat.rows(j);
  }
  
  private double[] locatePlanarObject(opencv_legacy.CvSURFPoint[] paramArrayOfCvSURFPoint1, FloatBuffer[] paramArrayOfFloatBuffer1, opencv_legacy.CvSURFPoint[] paramArrayOfCvSURFPoint2, FloatBuffer[] paramArrayOfFloatBuffer2, double[] paramArrayOfDouble)
  {
    this.ptpairs.clear();
    if (this.settings.useFLANN) {
      flannFindPairs(paramArrayOfFloatBuffer1, paramArrayOfFloatBuffer2);
    }
    int i;
    for (;;)
    {
      i = this.ptpairs.size() / 2;
      logger.info(i + " matching pairs found");
      if (i >= this.settings.matchesMin) {
        break;
      }
      return null;
      findPairs(paramArrayOfCvSURFPoint1, paramArrayOfFloatBuffer1, paramArrayOfCvSURFPoint2, paramArrayOfFloatBuffer2);
    }
    this.pt1.cols(i);
    this.pt2.cols(i);
    this.mask.cols(i);
    for (int j = 0; j < i; j++)
    {
      opencv_core.CvPoint2D32f localCvPoint2D32f1 = paramArrayOfCvSURFPoint1[((Integer)this.ptpairs.get(j * 2)).intValue()].pt();
      this.pt1.put(j * 2, localCvPoint2D32f1.x());
      this.pt1.put(1 + j * 2, localCvPoint2D32f1.y());
      opencv_core.CvPoint2D32f localCvPoint2D32f2 = paramArrayOfCvSURFPoint2[((Integer)this.ptpairs.get(1 + j * 2)).intValue()].pt();
      this.pt2.put(j * 2, localCvPoint2D32f2.x());
      this.pt2.put(1 + j * 2, localCvPoint2D32f2.y());
    }
    if (opencv_calib3d.cvFindHomography(this.pt1, this.pt2, this.H, 8, this.settings.ransacReprojThreshold, this.mask) == 0) {
      return null;
    }
    if (opencv_core.cvCountNonZero(this.mask) < this.settings.matchesMin) {
      return null;
    }
    double[] arrayOfDouble1 = this.H.get();
    double[] arrayOfDouble2 = new double[paramArrayOfDouble.length];
    for (int k = 0;; k++)
    {
      int m = paramArrayOfDouble.length / 2;
      if (k >= m) {
        break;
      }
      double d1 = paramArrayOfDouble[(k * 2)];
      double d2 = paramArrayOfDouble[(1 + k * 2)];
      double d3 = 1.0D / (d1 * arrayOfDouble1[6] + d2 * arrayOfDouble1[7] + arrayOfDouble1[8]);
      double d4 = d3 * (d1 * arrayOfDouble1[0] + d2 * arrayOfDouble1[1] + arrayOfDouble1[2]);
      double d5 = d3 * (d1 * arrayOfDouble1[3] + d2 * arrayOfDouble1[4] + arrayOfDouble1[5]);
      arrayOfDouble2[(k * 2)] = d4;
      arrayOfDouble2[(1 + k * 2)] = d5;
    }
    this.pt1.cols(paramArrayOfFloatBuffer1.length);
    this.pt2.cols(paramArrayOfFloatBuffer1.length);
    this.mask.cols(paramArrayOfFloatBuffer1.length);
    return arrayOfDouble2;
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    String str1;
    if (paramArrayOfString.length == 2)
    {
      str1 = paramArrayOfString[0];
      if (paramArrayOfString.length != 2) {
        break label406;
      }
    }
    opencv_core.IplImage localIplImage1;
    opencv_core.IplImage localIplImage3;
    opencv_core.IplImage localIplImage4;
    ObjectFinder localObjectFinder;
    label406:
    for (String str2 = paramArrayOfString[1];; str2 = "/usr/share/opencv/samples/c/box_in_scene.png")
    {
      localIplImage1 = opencv_highgui.cvLoadImage(str1, 0);
      opencv_core.IplImage localIplImage2 = opencv_highgui.cvLoadImage(str2, 0);
      if ((localIplImage1 == null) || (localIplImage2 == null))
      {
        System.err.println("Can not load " + str1 + " and/or " + str2);
        System.exit(-1);
      }
      localIplImage3 = opencv_core.IplImage.create(localIplImage1.width(), localIplImage1.height(), 8, 3);
      opencv_imgproc.cvCvtColor(localIplImage1, localIplImage3, 8);
      localIplImage4 = opencv_core.IplImage.create(localIplImage2.width(), localIplImage1.height() + localIplImage2.height(), 8, 1);
      opencv_core.cvSetImageROI(localIplImage4, opencv_core.cvRect(0, 0, localIplImage1.width(), localIplImage1.height()));
      opencv_core.cvCopy(localIplImage1, localIplImage4);
      opencv_core.cvSetImageROI(localIplImage4, opencv_core.cvRect(0, localIplImage1.height(), localIplImage4.width(), localIplImage4.height()));
      opencv_core.cvCopy(localIplImage2, localIplImage4);
      opencv_core.cvResetImageROI(localIplImage4);
      Settings localSettings = new Settings();
      localSettings.objectImage = localIplImage1;
      localSettings.useFLANN = true;
      localSettings.ransacReprojThreshold = 5.0D;
      localObjectFinder = new ObjectFinder(localSettings);
      long l = System.currentTimeMillis();
      double[] arrayOfDouble = localObjectFinder.find(localIplImage2);
      System.out.println("Finding time = " + (System.currentTimeMillis() - l) + " ms");
      if (arrayOfDouble == null) {
        break label413;
      }
      for (int k = 0; k < 4; k++)
      {
        int m = (k + 1) % 4;
        int n = (int)Math.round(arrayOfDouble[(k * 2)]);
        int i1 = (int)Math.round(arrayOfDouble[(1 + k * 2)]);
        int i2 = (int)Math.round(arrayOfDouble[(m * 2)]);
        int i3 = (int)Math.round(arrayOfDouble[(1 + m * 2)]);
        opencv_core.cvLine(localIplImage4, opencv_core.cvPoint(n, i1 + localIplImage1.height()), opencv_core.cvPoint(i2, i3 + localIplImage1.height()), opencv_core.CvScalar.WHITE, 1, 8, 0);
      }
      str1 = "/usr/share/opencv/samples/c/box.png";
      break;
    }
    label413:
    for (int i = 0; i < localObjectFinder.ptpairs.size(); i += 2)
    {
      opencv_core.CvPoint2D32f localCvPoint2D32f1 = localObjectFinder.objectKeypoints[((Integer)localObjectFinder.ptpairs.get(i)).intValue()].pt();
      opencv_core.CvPoint2D32f localCvPoint2D32f2 = localObjectFinder.imageKeypoints[((Integer)localObjectFinder.ptpairs.get(i + 1)).intValue()].pt();
      opencv_core.cvLine(localIplImage4, opencv_core.cvPointFrom32f(localCvPoint2D32f1), opencv_core.cvPoint(Math.round(localCvPoint2D32f2.x()), Math.round(localCvPoint2D32f2.y() + localIplImage1.height())), opencv_core.CvScalar.WHITE, 1, 8, 0);
    }
    CanvasFrame localCanvasFrame1 = new CanvasFrame("Object");
    CanvasFrame localCanvasFrame2 = new CanvasFrame("Object Correspond");
    localCanvasFrame2.showImage(localIplImage4);
    for (int j = 0; j < localObjectFinder.objectKeypoints.length; j++)
    {
      opencv_legacy.CvSURFPoint localCvSURFPoint = localObjectFinder.objectKeypoints[j];
      opencv_core.cvCircle(localIplImage3, opencv_core.cvPointFrom32f(localCvSURFPoint.pt()), Math.round(2.0F * (1.2F * localCvSURFPoint.size() / 9.0F)), opencv_core.CvScalar.RED, 1, 8, 0);
    }
    localCanvasFrame1.showImage(localIplImage3);
    localCanvasFrame1.waitKey();
    localCanvasFrame1.dispose();
    localCanvasFrame2.dispose();
  }
  
  private int naiveNearestNeighbor(FloatBuffer paramFloatBuffer, int paramInt, opencv_legacy.CvSURFPoint[] paramArrayOfCvSURFPoint, FloatBuffer[] paramArrayOfFloatBuffer)
  {
    int i = -1;
    double d1 = 1000000.0D;
    double d2 = 1000000.0D;
    int j = 0;
    if (j < paramArrayOfFloatBuffer.length)
    {
      opencv_legacy.CvSURFPoint localCvSURFPoint = paramArrayOfCvSURFPoint[j];
      FloatBuffer localFloatBuffer = paramArrayOfFloatBuffer[j];
      if (paramInt != localCvSURFPoint.laplacian()) {}
      for (;;)
      {
        j++;
        break;
        double d3 = compareSURFDescriptors(paramFloatBuffer, localFloatBuffer, d2);
        if (d3 < d1)
        {
          d2 = d1;
          d1 = d3;
          i = j;
        }
        else if (d3 < d2)
        {
          d2 = d3;
        }
      }
    }
    if (d1 < d2 * this.settings.distanceThreshold) {
      return i;
    }
    return -1;
  }
  
  public double[] find(opencv_core.IplImage paramIplImage)
  {
    opencv_core.CvSeq localCvSeq1 = new opencv_core.CvSeq(null);
    opencv_core.CvSeq localCvSeq2 = new opencv_core.CvSeq(null);
    opencv_core.cvClearMemStorage(this.tempStorage);
    opencv_legacy.cvExtractSURF(paramIplImage, null, localCvSeq1, localCvSeq2, this.tempStorage, this.settings.parameters, 0);
    int i = localCvSeq2.total();
    int j = localCvSeq2.elem_size();
    this.imageKeypoints = new opencv_legacy.CvSURFPoint[i];
    this.imageDescriptors = new FloatBuffer[i];
    for (int k = 0; k < i; k++)
    {
      this.imageKeypoints[k] = new opencv_legacy.CvSURFPoint(opencv_core.cvGetSeqElem(localCvSeq1, k));
      this.imageDescriptors[k] = opencv_core.cvGetSeqElem(localCvSeq2, k).capacity(j).asByteBuffer().asFloatBuffer();
    }
    logger.info(i + " image descriptors");
    int m = this.settings.objectImage.width();
    int n = this.settings.objectImage.height();
    double[] arrayOfDouble = new double[8];
    arrayOfDouble[0] = 0.0D;
    arrayOfDouble[1] = 0.0D;
    arrayOfDouble[2] = m;
    arrayOfDouble[3] = 0.0D;
    arrayOfDouble[4] = m;
    arrayOfDouble[5] = n;
    arrayOfDouble[6] = 0.0D;
    arrayOfDouble[7] = n;
    return locatePlanarObject(this.objectKeypoints, this.objectDescriptors, this.imageKeypoints, this.imageDescriptors, arrayOfDouble);
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public void setSettings(Settings paramSettings)
  {
    this.settings = paramSettings;
    opencv_core.CvSeq localCvSeq1 = new opencv_core.CvSeq(null);
    opencv_core.CvSeq localCvSeq2 = new opencv_core.CvSeq(null);
    opencv_core.cvClearMemStorage(this.storage);
    opencv_legacy.cvExtractSURF(paramSettings.objectImage, null, localCvSeq1, localCvSeq2, this.storage, paramSettings.parameters, 0);
    int i = localCvSeq2.total();
    int j = localCvSeq2.elem_size();
    this.objectKeypoints = new opencv_legacy.CvSURFPoint[i];
    this.objectDescriptors = new FloatBuffer[i];
    for (int k = 0; k < i; k++)
    {
      this.objectKeypoints[k] = new opencv_legacy.CvSURFPoint(opencv_core.cvGetSeqElem(localCvSeq1, k));
      this.objectDescriptors[k] = opencv_core.cvGetSeqElem(localCvSeq2, k).capacity(j).asByteBuffer().asFloatBuffer();
    }
    if (paramSettings.useFLANN)
    {
      int m = this.objectDescriptors[0].capacity();
      this.objectMat = opencv_core.CvMat.create(i, m, 5, 1);
      this.imageMat = opencv_core.CvMat.create(i, m, 5, 1);
      this.indicesMat = opencv_core.CvMat.create(i, 2, 4, 1);
      this.distsMat = opencv_core.CvMat.create(i, 2, 5, 1);
      this.flannIndex = new opencv_flann.Index();
      this.indexParams = new opencv_flann.KDTreeIndexParams(4);
      this.searchParams = new opencv_flann.SearchParams(64, 0.0F, true);
    }
    this.pt1 = opencv_core.CvMat.create(1, i, 5, 2);
    this.pt2 = opencv_core.CvMat.create(1, i, 5, 2);
    this.mask = opencv_core.CvMat.create(1, i, 0, 1);
    this.H = opencv_core.CvMat.create(3, 3);
    this.ptpairs = new ArrayList(2 * this.objectDescriptors.length);
    logger.info(i + " object descriptors");
  }
  
  public static class Settings
    extends BaseChildSettings
  {
    double distanceThreshold = 0.6D;
    int matchesMin = 4;
    opencv_core.IplImage objectImage = null;
    opencv_legacy.CvSURFParams parameters = opencv_legacy.cvSURFParams(500.0D, 1);
    double ransacReprojThreshold = 1.0D;
    boolean useFLANN = false;
    
    public double getDistanceThreshold()
    {
      return this.distanceThreshold;
    }
    
    public double getHessianThreshold()
    {
      return this.parameters.hessianThreshold();
    }
    
    public int getMatchesMin()
    {
      return this.matchesMin;
    }
    
    public opencv_core.IplImage getObjectImage()
    {
      return this.objectImage;
    }
    
    public double getRansacReprojThreshold()
    {
      return this.ransacReprojThreshold;
    }
    
    public int getnOctaveLayers()
    {
      return this.parameters.nOctaveLayers();
    }
    
    public int getnOctaves()
    {
      return this.parameters.nOctaves();
    }
    
    public boolean isExtended()
    {
      return this.parameters.extended() != 0;
    }
    
    public boolean isUpright()
    {
      return this.parameters.upright() != 0;
    }
    
    public boolean isUseFLANN()
    {
      return this.useFLANN;
    }
    
    public void setDistanceThreshold(double paramDouble)
    {
      this.distanceThreshold = paramDouble;
    }
    
    public void setExtended(boolean paramBoolean)
    {
      opencv_legacy.CvSURFParams localCvSURFParams = this.parameters;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localCvSURFParams.extended(i);
        return;
      }
    }
    
    public void setHessianThreshold(double paramDouble)
    {
      this.parameters.hessianThreshold(paramDouble);
    }
    
    public void setMatchesMin(int paramInt)
    {
      this.matchesMin = paramInt;
    }
    
    public void setObjectImage(opencv_core.IplImage paramIplImage)
    {
      this.objectImage = paramIplImage;
    }
    
    public void setRansacReprojThreshold(double paramDouble)
    {
      this.ransacReprojThreshold = paramDouble;
    }
    
    public void setUpright(boolean paramBoolean)
    {
      opencv_legacy.CvSURFParams localCvSURFParams = this.parameters;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localCvSURFParams.upright(i);
        return;
      }
    }
    
    public void setUseFLANN(boolean paramBoolean)
    {
      this.useFLANN = paramBoolean;
    }
    
    public void setnOctaveLayers(int paramInt)
    {
      this.parameters.nOctaveLayers(paramInt);
    }
    
    public void setnOctaves(int paramInt)
    {
      this.parameters.nOctaves(paramInt);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ObjectFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */