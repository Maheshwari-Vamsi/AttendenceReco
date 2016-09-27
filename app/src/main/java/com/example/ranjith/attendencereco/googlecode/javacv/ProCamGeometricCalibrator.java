package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ProCamGeometricCalibrator
{
  private static ThreadLocal<opencv_core.CvMat> tempWarp3x3;
  private final int LSB_IMAGE_SHIFT = 7;
  private final int MSB_IMAGE_SHIFT = 8;
  LinkedList<Marker[]>[] allImagedBoardMarkers;
  private final MarkedPlane boardPlane;
  private opencv_core.CvMat[] boardWarp;
  private final opencv_core.CvMat boardWarpSrcPts;
  private GeometricCalibrator[] cameraCalibrators;
  private MarkerDetector.Settings detectorSettings;
  private opencv_core.IplImage[] grayscaleImage;
  private opencv_core.CvMat[] lastBoardWarp;
  private Marker[][] lastDetectedMarkers1;
  private Marker[][] lastDetectedMarkers2;
  private MarkerDetector[] markerDetectors;
  private opencv_core.CvMat[] prevBoardWarp;
  private opencv_core.CvMat[] projWarp;
  private final GeometricCalibrator projectorCalibrator;
  private final MarkedPlane projectorPlane;
  private double[] rmseBoardWarp;
  private double[] rmseProjWarp;
  private Settings settings;
  private opencv_core.IplImage[] tempImage1;
  private opencv_core.IplImage[] tempImage2;
  private opencv_core.CvMat[] tempPts1;
  private opencv_core.CvMat[] tempPts2;
  private boolean updatePrewarp = false;
  
  static
  {
    if (!ProCamGeometricCalibrator.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      tempWarp3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      return;
    }
  }
  
  public ProCamGeometricCalibrator(Settings paramSettings, MarkerDetector.Settings paramSettings1, MarkedPlane paramMarkedPlane1, MarkedPlane paramMarkedPlane2, ProjectiveDevice paramProjectiveDevice1, ProjectiveDevice paramProjectiveDevice2)
  {
    this(paramSettings, paramSettings1, paramMarkedPlane1, paramMarkedPlane2, arrayOfGeometricCalibrator, new GeometricCalibrator(paramSettings, paramSettings1, paramMarkedPlane2, paramProjectiveDevice2));
  }
  
  public ProCamGeometricCalibrator(Settings paramSettings, MarkerDetector.Settings paramSettings1, MarkedPlane paramMarkedPlane1, MarkedPlane paramMarkedPlane2, GeometricCalibrator[] paramArrayOfGeometricCalibrator, GeometricCalibrator paramGeometricCalibrator)
  {
    this.settings = paramSettings;
    this.detectorSettings = paramSettings1;
    this.boardPlane = paramMarkedPlane1;
    this.projectorPlane = paramMarkedPlane2;
    this.cameraCalibrators = paramArrayOfGeometricCalibrator;
    int i = paramArrayOfGeometricCalibrator.length;
    this.markerDetectors = new MarkerDetector[i];
    this.allImagedBoardMarkers = new LinkedList[i];
    this.grayscaleImage = new opencv_core.IplImage[i];
    this.tempImage1 = new opencv_core.IplImage[i];
    this.tempImage2 = new opencv_core.IplImage[i];
    this.lastDetectedMarkers1 = new Marker[i][];
    this.lastDetectedMarkers2 = new Marker[i][];
    this.rmseBoardWarp = new double[i];
    this.rmseProjWarp = new double[i];
    this.boardWarp = new opencv_core.CvMat[i];
    this.projWarp = new opencv_core.CvMat[i];
    this.prevBoardWarp = new opencv_core.CvMat[i];
    this.lastBoardWarp = new opencv_core.CvMat[i];
    this.tempPts1 = new opencv_core.CvMat[i];
    this.tempPts2 = new opencv_core.CvMat[i];
    for (int j = 0; j < i; j++)
    {
      this.markerDetectors[j] = new MarkerDetector(paramSettings1);
      this.allImagedBoardMarkers[j] = new LinkedList();
      this.grayscaleImage[j] = null;
      this.tempImage1[j] = null;
      this.tempImage2[j] = null;
      this.lastDetectedMarkers1[j] = null;
      this.lastDetectedMarkers2[j] = null;
      this.rmseBoardWarp[j] = Double.POSITIVE_INFINITY;
      this.rmseProjWarp[j] = Double.POSITIVE_INFINITY;
      this.boardWarp[j] = opencv_core.CvMat.create(3, 3);
      this.projWarp[j] = opencv_core.CvMat.create(3, 3);
      this.prevBoardWarp[j] = opencv_core.CvMat.create(3, 3);
      this.lastBoardWarp[j] = opencv_core.CvMat.create(3, 3);
      opencv_core.cvSetIdentity(this.prevBoardWarp[j]);
      opencv_core.cvSetIdentity(this.lastBoardWarp[j]);
      this.tempPts1[j] = opencv_core.CvMat.create(1, 4, 6, 2);
      this.tempPts2[j] = opencv_core.CvMat.create(1, 4, 6, 2);
    }
    this.projectorCalibrator = paramGeometricCalibrator;
    this.boardWarpSrcPts = opencv_core.CvMat.create(1, 4, 6, 2);
    if (paramMarkedPlane1 != null)
    {
      int n = paramMarkedPlane1.getImage().width();
      int i1 = paramMarkedPlane1.getImage().height();
      opencv_core.CvMat localCvMat = this.boardWarpSrcPts;
      double[] arrayOfDouble = new double[8];
      arrayOfDouble[0] = 0.0D;
      arrayOfDouble[1] = 0.0D;
      arrayOfDouble[2] = n;
      arrayOfDouble[3] = 0.0D;
      arrayOfDouble[4] = n;
      arrayOfDouble[5] = i1;
      arrayOfDouble[6] = 0.0D;
      arrayOfDouble[7] = i1;
      localCvMat.put(arrayOfDouble);
    }
    if (paramMarkedPlane2 != null)
    {
      int k = paramMarkedPlane2.getImage().width();
      int m = paramMarkedPlane2.getImage().height();
      paramGeometricCalibrator.getProjectiveDevice().imageWidth = k;
      paramGeometricCalibrator.getProjectiveDevice().imageHeight = m;
    }
  }
  
  public void addMarkers()
  {
    addMarkers(0);
  }
  
  public void addMarkers(int paramInt)
  {
    addMarkers(this.lastDetectedMarkers1[paramInt], this.lastDetectedMarkers2[paramInt], paramInt);
  }
  
  public void addMarkers(Marker[] paramArrayOfMarker1, Marker[] paramArrayOfMarker2)
  {
    addMarkers(paramArrayOfMarker1, paramArrayOfMarker2, 0);
  }
  
  public void addMarkers(Marker[] paramArrayOfMarker1, Marker[] paramArrayOfMarker2, int paramInt)
  {
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)tempWarp3x3.get();
    if (!this.settings.useOnlyIntersection)
    {
      this.cameraCalibrators[paramInt].addMarkers(this.boardPlane.getMarkers(), paramArrayOfMarker1);
      this.allImagedBoardMarkers[paramInt].add(paramArrayOfMarker1);
    }
    Marker[] arrayOfMarker4;
    for (;;)
    {
      arrayOfMarker4 = new Marker[this.projectorPlane.getMarkers().length];
      for (int i1 = 0; i1 < arrayOfMarker4.length; i1++) {
        arrayOfMarker4[i1] = this.projectorPlane.getMarkers()[i1].clone();
      }
      Marker[] arrayOfMarker1 = new Marker[paramArrayOfMarker1.length];
      for (int i = 0; i < arrayOfMarker1.length; i++) {
        arrayOfMarker1[i] = paramArrayOfMarker1[i].clone();
      }
      opencv_core.cvInvert(this.projWarp[paramInt], localCvMat);
      Marker.applyWarp(arrayOfMarker1, localCvMat);
      int j = this.projectorPlane.getImage().width();
      int k = this.projectorPlane.getImage().height();
      Marker[] arrayOfMarker2 = new Marker[paramArrayOfMarker1.length];
      int m = 0;
      int n = 0;
      if (n < arrayOfMarker1.length)
      {
        double[] arrayOfDouble = arrayOfMarker1[n].corners;
        for (int i3 = 0;; i3++)
        {
          int i4 = 0;
          if (i3 < 4)
          {
            int i6 = this.detectorSettings.subPixelWindow / 2;
            if ((arrayOfDouble[(i3 * 2)] < i6) || (arrayOfDouble[(i3 * 2)] >= j - i6) || (arrayOfDouble[(1 + i3 * 2)] < i6) || (arrayOfDouble[(1 + i3 * 2)] >= k - i6)) {
              i4 = 1;
            }
          }
          else
          {
            if (i4 == 0)
            {
              int i5 = m + 1;
              arrayOfMarker2[m] = paramArrayOfMarker1[n];
              m = i5;
            }
            n++;
            break;
          }
        }
      }
      Marker[] arrayOfMarker3 = (Marker[])Arrays.copyOf(arrayOfMarker2, m);
      this.cameraCalibrators[paramInt].addMarkers(this.boardPlane.getMarkers(), arrayOfMarker3);
      this.allImagedBoardMarkers[paramInt].add(arrayOfMarker3);
    }
    Marker.applyWarp(arrayOfMarker4, this.projectorPlane.getPrewarp());
    synchronized (this.projectorCalibrator)
    {
      for (;;)
      {
        int i2 = this.projectorCalibrator.getImageCount() % this.cameraCalibrators.length;
        if (i2 >= paramInt) {
          break;
        }
        try
        {
          this.projectorCalibrator.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.projectorCalibrator.addMarkers(paramArrayOfMarker2, arrayOfMarker4);
      this.projectorCalibrator.notify();
      opencv_core.cvCopy(this.boardWarp[paramInt], this.lastBoardWarp[paramInt]);
      return;
    }
  }
  
  public double[] calibrate(boolean paramBoolean1, boolean paramBoolean2)
  {
    return calibrate(paramBoolean1, paramBoolean2);
  }
  
  public double[] calibrate(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    GeometricCalibrator localGeometricCalibrator = this.cameraCalibrators[paramInt];
    if (paramBoolean2) {
      for (int n = 0; n < this.cameraCalibrators.length; n++)
      {
        this.cameraCalibrators[n].calibrate(paramBoolean1);
        if (this.cameraCalibrators[n] != localGeometricCalibrator) {
          localGeometricCalibrator.calibrateStereo(paramBoolean1, this.cameraCalibrators[n]);
        }
      }
    }
    LinkedList localLinkedList1 = this.projectorCalibrator.getAllObjectMarkers();
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList3 = new LinkedList();
    LinkedList localLinkedList4 = new LinkedList();
    Iterator localIterator = localLinkedList1.iterator();
    Iterator[] arrayOfIterator = new Iterator[this.cameraCalibrators.length];
    for (int i = 0; i < this.cameraCalibrators.length; i++) {
      arrayOfIterator[i] = this.allImagedBoardMarkers[i].iterator();
    }
    if (localIterator.hasNext())
    {
      int j = 0;
      label169:
      if (j < this.cameraCalibrators.length)
      {
        double d = this.settings.prewarpUpdateErrorMax * (this.cameraCalibrators[j].getProjectiveDevice().imageWidth + this.cameraCalibrators[j].getProjectiveDevice().imageHeight) / 2.0D;
        Marker[] arrayOfMarker1 = (Marker[])arrayOfIterator[j].next();
        Marker[] arrayOfMarker2 = (Marker[])localIterator.next();
        Marker[] arrayOfMarker3 = new Marker[arrayOfMarker1.length];
        Marker[] arrayOfMarker4 = new Marker[arrayOfMarker2.length];
        for (int k = 0; k < arrayOfMarker1.length; k++)
        {
          Marker localMarker2 = arrayOfMarker1[k].clone();
          arrayOfMarker3[k] = localMarker2;
          localMarker2.corners = this.cameraCalibrators[j].getProjectiveDevice().undistort(localMarker2.corners);
        }
        for (int m = 0; m < arrayOfMarker2.length; m++)
        {
          Marker localMarker1 = arrayOfMarker2[m].clone();
          arrayOfMarker4[m] = localMarker1;
          localMarker1.corners = this.cameraCalibrators[j].getProjectiveDevice().undistort(localMarker1.corners);
        }
        if ((this.boardPlane.getTotalWarp(arrayOfMarker3, this.boardWarp[j]) > d) && (!$assertionsDisabled)) {
          throw new AssertionError();
        }
        opencv_core.cvInvert(this.boardWarp[j], this.boardWarp[j]);
        Marker.applyWarp(arrayOfMarker4, this.boardWarp[j]);
        localLinkedList3.add(arrayOfMarker4);
        if (this.cameraCalibrators[j] != localGeometricCalibrator) {
          break label486;
        }
        localLinkedList4.add(arrayOfMarker4);
        localLinkedList2.add(arrayOfMarker2);
      }
      for (;;)
      {
        j++;
        break label169;
        break;
        label486:
        localLinkedList4.add(new Marker[0]);
        localLinkedList2.add(new Marker[0]);
      }
    }
    this.projectorCalibrator.setAllObjectMarkers(localLinkedList3);
    double[] arrayOfDouble1 = this.projectorCalibrator.calibrate(paramBoolean1);
    LinkedList localLinkedList5 = localGeometricCalibrator.getAllObjectMarkers();
    LinkedList localLinkedList6 = localGeometricCalibrator.getAllImageMarkers();
    localGeometricCalibrator.setAllObjectMarkers(localLinkedList4);
    localGeometricCalibrator.setAllImageMarkers(localLinkedList2);
    double[] arrayOfDouble2 = localGeometricCalibrator.calibrateStereo(paramBoolean1, this.projectorCalibrator);
    this.projectorCalibrator.setAllObjectMarkers(localLinkedList1);
    localGeometricCalibrator.setAllObjectMarkers(localLinkedList5);
    localGeometricCalibrator.setAllImageMarkers(localLinkedList6);
    double[] arrayOfDouble3 = new double[4];
    arrayOfDouble3[0] = arrayOfDouble1[0];
    arrayOfDouble3[1] = arrayOfDouble1[1];
    arrayOfDouble3[2] = arrayOfDouble2[0];
    arrayOfDouble3[3] = arrayOfDouble2[1];
    return arrayOfDouble3;
  }
  
  public void drawMarkers(opencv_core.IplImage paramIplImage)
  {
    drawMarkers(paramIplImage, 0);
  }
  
  public void drawMarkers(opencv_core.IplImage paramIplImage, int paramInt)
  {
    this.cameraCalibrators[paramInt].markerDetector.draw(paramIplImage, this.lastDetectedMarkers1[paramInt]);
    this.projectorCalibrator.markerDetector.draw(paramIplImage, this.lastDetectedMarkers2[paramInt]);
  }
  
  public MarkedPlane getBoardPlane()
  {
    return this.boardPlane;
  }
  
  public GeometricCalibrator[] getCameraCalibrators()
  {
    return this.cameraCalibrators;
  }
  
  public int getImageCount()
  {
    int i = this.projectorCalibrator.getImageCount() / this.cameraCalibrators.length;
    for (GeometricCalibrator localGeometricCalibrator : this.cameraCalibrators) {
      assert (localGeometricCalibrator.getImageCount() == i);
    }
    return i;
  }
  
  public GeometricCalibrator getProjectorCalibrator()
  {
    return this.projectorCalibrator;
  }
  
  public opencv_core.IplImage getProjectorImage()
  {
    if (this.updatePrewarp)
    {
      double d1 = Double.MAX_VALUE;
      int i = 0;
      for (int j = 0; j < this.cameraCalibrators.length; j++)
      {
        double d2 = this.rmseBoardWarp[j] + this.rmseProjWarp[j];
        if (d2 < d1)
        {
          d1 = d2;
          i = j;
        }
      }
      opencv_core.CvMat localCvMat = this.projectorPlane.getPrewarp();
      opencv_core.cvInvert(this.projWarp[i], localCvMat);
      opencv_core.cvMatMul(localCvMat, this.boardWarp[i], localCvMat);
      this.projectorPlane.setPrewarp(localCvMat);
    }
    return this.projectorPlane.getImage();
  }
  
  public MarkedPlane getProjectorPlane()
  {
    return this.projectorPlane;
  }
  
  public Marker[][] processCameraImage(opencv_core.IplImage paramIplImage)
  {
    return processCameraImage(paramIplImage, 0);
  }
  
  public Marker[][] processCameraImage(opencv_core.IplImage paramIplImage, final int paramInt)
  {
    this.cameraCalibrators[paramInt].getProjectiveDevice().imageWidth = paramIplImage.width();
    this.cameraCalibrators[paramInt].getProjectiveDevice().imageHeight = paramIplImage.height();
    final boolean bool1;
    label161:
    final boolean bool2;
    if (paramIplImage.nChannels() > 1)
    {
      if ((this.grayscaleImage[paramInt] == null) || (this.grayscaleImage[paramInt].width() != paramIplImage.width()) || (this.grayscaleImage[paramInt].height() != paramIplImage.height()) || (this.grayscaleImage[paramInt].depth() != paramIplImage.depth())) {
        this.grayscaleImage[paramInt] = opencv_core.IplImage.create(paramIplImage.width(), paramIplImage.height(), paramIplImage.depth(), 1, paramIplImage.origin());
      }
      opencv_imgproc.cvCvtColor(paramIplImage, this.grayscaleImage[paramInt], 6);
      if (this.boardPlane.getForegroundColor().magnitude() <= this.boardPlane.getBackgroundColor().magnitude()) {
        break label418;
      }
      bool1 = true;
      if (this.projectorPlane.getForegroundColor().magnitude() <= this.projectorPlane.getBackgroundColor().magnitude()) {
        break label423;
      }
      bool2 = true;
      label188:
      if (this.grayscaleImage[paramInt].depth() <= 8) {
        break label429;
      }
      if ((this.tempImage1[paramInt] == null) || (this.tempImage1[paramInt].width() != this.grayscaleImage[paramInt].width()) || (this.tempImage1[paramInt].height() != this.grayscaleImage[paramInt].height()))
      {
        this.tempImage1[paramInt] = opencv_core.IplImage.create(this.grayscaleImage[paramInt].width(), this.grayscaleImage[paramInt].height(), 8, 1, this.grayscaleImage[paramInt].origin());
        this.tempImage2[paramInt] = opencv_core.IplImage.create(this.grayscaleImage[paramInt].width(), this.grayscaleImage[paramInt].height(), 8, 1, this.grayscaleImage[paramInt].origin());
      }
      Runnable[] arrayOfRunnable2 = new Runnable[2];
      arrayOfRunnable2[0 = new Runnable()
      {
        public void run()
        {
          opencv_core.cvConvertScale(ProCamGeometricCalibrator.this.grayscaleImage[paramInt], ProCamGeometricCalibrator.this.tempImage1[paramInt], 0.0078125D, 0.0D);
          ProCamGeometricCalibrator.this.lastDetectedMarkers1[paramInt] = ProCamGeometricCalibrator.this.cameraCalibrators[paramInt].markerDetector.detect(ProCamGeometricCalibrator.this.tempImage1[paramInt], bool1);
        }
      };
      arrayOfRunnable2[1 = new Runnable()
      {
        public void run()
        {
          opencv_core.cvConvertScale(ProCamGeometricCalibrator.this.grayscaleImage[paramInt], ProCamGeometricCalibrator.this.tempImage2[paramInt], 0.00390625D, 0.0D);
          ProCamGeometricCalibrator.this.lastDetectedMarkers2[paramInt] = ProCamGeometricCalibrator.this.markerDetectors[paramInt].detect(ProCamGeometricCalibrator.this.tempImage2[paramInt], bool2);
        }
      };
      Parallel.run(arrayOfRunnable2);
    }
    for (;;)
    {
      if (!processMarkers(paramInt)) {
        break label472;
      }
      Marker[][] arrayOfMarker = new Marker[2][];
      arrayOfMarker[0] = this.lastDetectedMarkers1[paramInt];
      arrayOfMarker[1] = this.lastDetectedMarkers2[paramInt];
      return arrayOfMarker;
      this.grayscaleImage[paramInt] = paramIplImage;
      break;
      label418:
      bool1 = false;
      break label161;
      label423:
      bool2 = false;
      break label188;
      label429:
      Runnable[] arrayOfRunnable1 = new Runnable[2];
      arrayOfRunnable1[0 = new Runnable()
      {
        public void run()
        {
          ProCamGeometricCalibrator.this.lastDetectedMarkers1[paramInt] = ProCamGeometricCalibrator.this.cameraCalibrators[paramInt].markerDetector.detect(ProCamGeometricCalibrator.this.grayscaleImage[paramInt], bool1);
        }
      };
      arrayOfRunnable1[1 = new Runnable()
      {
        public void run()
        {
          ProCamGeometricCalibrator.this.lastDetectedMarkers2[paramInt] = ProCamGeometricCalibrator.this.markerDetectors[paramInt].detect(ProCamGeometricCalibrator.this.grayscaleImage[paramInt], bool2);
        }
      };
      Parallel.run(arrayOfRunnable1);
    }
    label472:
    return (Marker[][])null;
  }
  
  public boolean processMarkers()
  {
    return processMarkers(0);
  }
  
  public boolean processMarkers(int paramInt)
  {
    return processMarkers(this.lastDetectedMarkers1[paramInt], this.lastDetectedMarkers2[paramInt], paramInt);
  }
  
  public boolean processMarkers(Marker[] paramArrayOfMarker1, Marker[] paramArrayOfMarker2)
  {
    return processMarkers(paramArrayOfMarker1, paramArrayOfMarker2, 0);
  }
  
  public boolean processMarkers(Marker[] paramArrayOfMarker1, Marker[] paramArrayOfMarker2, int paramInt)
  {
    this.rmseBoardWarp[paramInt] = this.boardPlane.getTotalWarp(paramArrayOfMarker1, this.boardWarp[paramInt]);
    this.rmseProjWarp[paramInt] = this.projectorPlane.getTotalWarp(paramArrayOfMarker2, this.projWarp[paramInt]);
    int i = (this.cameraCalibrators[paramInt].getProjectiveDevice().imageWidth + this.cameraCalibrators[paramInt].getProjectiveDevice().imageHeight) / 2;
    if ((this.rmseBoardWarp[paramInt] <= this.settings.prewarpUpdateErrorMax * i) && (this.rmseProjWarp[paramInt] <= this.settings.prewarpUpdateErrorMax * i))
    {
      this.updatePrewarp = true;
      if ((paramArrayOfMarker1.length < this.boardPlane.getMarkers().length * this.settings.detectedBoardMin) || (paramArrayOfMarker2.length < this.projectorPlane.getMarkers().length * this.settings.detectedProjectorMin)) {
        return false;
      }
    }
    else
    {
      return false;
    }
    opencv_core.cvPerspectiveTransform(this.boardWarpSrcPts, this.tempPts1[paramInt], this.boardWarp[paramInt]);
    opencv_core.cvPerspectiveTransform(this.boardWarpSrcPts, this.tempPts2[paramInt], this.prevBoardWarp[paramInt]);
    double d1 = opencv_core.cvNorm(this.tempPts1[paramInt], this.tempPts2[paramInt]);
    opencv_core.cvPerspectiveTransform(this.boardWarpSrcPts, this.tempPts2[paramInt], this.lastBoardWarp[paramInt]);
    double d2 = opencv_core.cvNorm(this.tempPts1[paramInt], this.tempPts2[paramInt]);
    opencv_core.cvCopy(this.boardWarp[paramInt], this.prevBoardWarp[paramInt]);
    return (d1 < this.settings.patternSteadySize * i) && (d2 > this.settings.patternMovedSize * i);
  }
  
  public static class Settings
    extends GeometricCalibrator.Settings
  {
    double detectedProjectorMin = 0.5D;
    double prewarpUpdateErrorMax = 0.01D;
    boolean useOnlyIntersection = true;
    
    public double getDetectedProjectorMin()
    {
      return this.detectedProjectorMin;
    }
    
    public double getPrewarpUpdateErrorMax()
    {
      return this.prewarpUpdateErrorMax;
    }
    
    public boolean isUseOnlyIntersection()
    {
      return this.useOnlyIntersection;
    }
    
    public void setDetectedProjectorMin(double paramDouble)
    {
      this.detectedProjectorMin = paramDouble;
    }
    
    public void setPrewarpUpdateErrorMax(double paramDouble)
    {
      this.prewarpUpdateErrorMax = paramDouble;
    }
    
    public void setUseOnlyIntersection(boolean paramBoolean)
    {
      this.useOnlyIntersection = paramBoolean;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProCamGeometricCalibrator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */