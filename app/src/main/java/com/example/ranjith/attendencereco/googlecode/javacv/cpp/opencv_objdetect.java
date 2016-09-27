package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.Pointer.Deallocator;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/objdetect/objdetect.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_objdetect@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_objdetect245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_objdetect
{
  public static final int CV_HAAR_DO_CANNY_PRUNING = 1;
  public static final int CV_HAAR_DO_ROUGH_SEARCH = 8;
  public static final int CV_HAAR_FEATURE_MAX = 3;
  public static final int CV_HAAR_FIND_BIGGEST_OBJECT = 4;
  public static final int CV_HAAR_MAGIC_VAL = 1112539136;
  public static final int CV_HAAR_SCALE_IMAGE = 2;
  public static final String CV_TYPE_NAME_HAAR = "opencv-haar-classifier";
  
  static
  {
    Loader.load(opencv_imgproc.class);
    Loader.load(opencv_highgui.class);
    Loader.load();
  }
  
  public static boolean CV_IS_HAAR_CLASSIFIER(CvHaarClassifierCascade paramCvHaarClassifierCascade)
  {
    return (paramCvHaarClassifierCascade != null) && ((0xFFFF0000 & paramCvHaarClassifierCascade.flags()) == 1112539136);
  }
  
  @ByVal
  public static native CvDataMatrixCodeDeque cvFindDataMatrix(opencv_core.CvMat paramCvMat);
  
  public static opencv_core.CvSeq cvHaarDetectObjects(opencv_core.CvArr paramCvArr, CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble, int paramInt1, int paramInt2)
  {
    return cvHaarDetectObjects(paramCvArr, paramCvHaarClassifierCascade, paramCvMemStorage, paramDouble, paramInt1, paramInt2, opencv_core.CvSize.ZERO, opencv_core.CvSize.ZERO);
  }
  
  public static native opencv_core.CvSeq cvHaarDetectObjects(opencv_core.CvArr paramCvArr, CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
  
  public static native opencv_core.CvSeq cvHaarDetectObjectsForROC(opencv_core.CvArr paramCvArr, CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvMemStorage paramCvMemStorage, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Cast({"bool"}) boolean paramBoolean);
  
  public static native opencv_core.CvSeq cvLatentSvmDetectObjects(@opencv_core.InputMat opencv_core.CvArr paramCvArr, CvLatentSvmDetector paramCvLatentSvmDetector, opencv_core.CvMemStorage paramCvMemStorage, float paramFloat, int paramInt);
  
  public static native CvHaarClassifierCascade cvLoadHaarClassifierCascade(String paramString, @ByVal opencv_core.CvSize paramCvSize);
  
  public static native CvLatentSvmDetector cvLoadLatentSvmDetector(String paramString);
  
  public static native void cvReleaseHaarClassifierCascade(@ByPtrPtr CvHaarClassifierCascade paramCvHaarClassifierCascade);
  
  public static native void cvReleaseLatentSvmDetector(@ByPtrPtr CvLatentSvmDetector paramCvLatentSvmDetector);
  
  public static native int cvRunHaarClassifierCascade(CvHaarClassifierCascade paramCvHaarClassifierCascade, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt);
  
  public static native void cvSetImagesForHaarClassifierCascade(CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble);
  
  @Namespace("cv")
  public static native void drawDataMatrixCodes(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @ByRef opencv_core.StringVector paramStringVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
  
  @Namespace("cv")
  public static native void findDataMatrix(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef opencv_core.StringVector paramStringVector, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @opencv_core.OutputArray opencv_core.CvMatArray paramCvMatArray);
  
  @Namespace("cv::linemod")
  @opencv_core.Ptr
  public static native Detector getDefaultLINE();
  
  @Namespace("cv::linemod")
  @opencv_core.Ptr
  public static native Detector getDefaultLINEMOD();
  
  @Namespace("cv")
  public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, int paramInt, double paramDouble);
  
  @Namespace("cv")
  public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, int paramInt, double paramDouble, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer);
  
  @Namespace("cv")
  public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector IntPointer paramIntPointer, int paramInt, double paramDouble);
  
  @Namespace("cv")
  public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer, int paramInt, double paramDouble);
  
  @Namespace("cv")
  public static native void groupRectangles_meanshift(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector DoublePointer paramDoublePointer1, @StdVector DoublePointer paramDoublePointer2, double paramDouble, @ByVal opencv_core.CvSize paramCvSize);
  
  @Namespace("cv")
  @NoOffset
  public static class CascadeClassifier
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CascadeClassifier()
    {
      allocate();
    }
    
    public CascadeClassifier(Pointer paramPointer)
    {
      super();
    }
    
    public CascadeClassifier(String paramString)
    {
      allocate(paramString);
    }
    
    private native void allocate();
    
    private native void allocate(String paramString);
    
    public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
    
    public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Cast({"bool"}) boolean paramBoolean);
    
    public native boolean empty();
    
    public native int getFeatureType();
    
    @Const
    @opencv_core.Ptr
    public native MaskGenerator getMaskGenerator();
    
    @ByVal
    public native opencv_core.CvSize getOriginalWindowSize();
    
    public native boolean isOldFormatCascade();
    
    public native boolean load(String paramString);
    
    public native boolean read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void setFaceDetectionMaskGenerator();
    
    public native boolean setImage(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native void setMaskGenerator(@opencv_core.Ptr MaskGenerator paramMaskGenerator);
    
    public static class MaskGenerator
      extends Pointer
    {
      static
      {
        Loader.load();
      }
      
      public MaskGenerator() {}
      
      public MaskGenerator(Pointer paramPointer)
      {
        super();
      }
      
      @opencv_core.OutputMat
      public native opencv_core.CvMat generateMask(opencv_core.CvMat paramCvMat);
      
      public native void initializeMask(opencv_core.CvMat paramCvMat);
    }
  }
  
  @Namespace("cv::linemod")
  @NoOffset
  public static class ColorGradient
    extends Modality
  {
    static
    {
      Loader.load();
    }
    
    public ColorGradient()
    {
      allocate();
    }
    
    public ColorGradient(float paramFloat1, @Cast({"size_t"}) long paramLong, float paramFloat2)
    {
      allocate(paramFloat1, paramLong, paramFloat2);
    }
    
    public ColorGradient(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, @Cast({"size_t"}) long paramLong, float paramFloat2);
    
    public native long num_features();
    
    public native ColorGradient num_features(long paramLong);
    
    public native float strong_threshold();
    
    public native ColorGradient strong_threshold(float paramFloat);
    
    public native float weak_threshold();
    
    public native ColorGradient weak_threshold(float paramFloat);
  }
  
  public static class CvAvgComp
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvAvgComp()
    {
      allocate();
    }
    
    public CvAvgComp(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvAvgComp(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int neighbors();
    
    public native CvAvgComp neighbors(int paramInt);
    
    public CvAvgComp position(int paramInt)
    {
      return (CvAvgComp)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvRect rect();
    
    public native CvAvgComp rect(opencv_core.CvRect paramCvRect);
  }
  
  public static class CvDataMatrixCode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDataMatrixCode()
    {
      allocate();
    }
    
    public CvDataMatrixCode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDataMatrixCode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native opencv_core.CvMat corners();
    
    public native CvDataMatrixCode corners(opencv_core.CvMat paramCvMat);
    
    public native CvDataMatrixCode msg(String paramString);
    
    public native String msg();
    
    public native opencv_core.CvMat original();
    
    public native CvDataMatrixCode original(opencv_core.CvMat paramCvMat);
    
    public CvDataMatrixCode position(int paramInt)
    {
      return (CvDataMatrixCode)super.position(paramInt);
    }
  }
  
  @Name({"std::deque<CvDataMatrixCode>"})
  public static class CvDataMatrixCodeDeque
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDataMatrixCodeDeque()
    {
      allocate();
    }
    
    public CvDataMatrixCodeDeque(long paramLong)
    {
      allocate(paramLong);
    }
    
    public CvDataMatrixCodeDeque(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByRef
    @Index
    public native opencv_objdetect.CvDataMatrixCode get(@Cast({"size_t"}) long paramLong);
    
    public native CvDataMatrixCodeDeque put(@Cast({"size_t"}) long paramLong, CvDataMatrixCode paramCvDataMatrixCode);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    public native long size();
  }
  
  public static class CvHaarClassifier
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHaarClassifier()
    {
      allocate();
    }
    
    public CvHaarClassifier(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvHaarClassifier(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native FloatPointer alpha();
    
    public native CvHaarClassifier alpha(FloatPointer paramFloatPointer);
    
    public native int count();
    
    public native CvHaarClassifier count(int paramInt);
    
    public native CvHaarClassifier haar_feature(CvHaarFeature paramCvHaarFeature);
    
    public native CvHaarFeature haar_feature();
    
    public native IntPointer left();
    
    public native CvHaarClassifier left(IntPointer paramIntPointer);
    
    public CvHaarClassifier position(int paramInt)
    {
      return (CvHaarClassifier)super.position(paramInt);
    }
    
    public native IntPointer right();
    
    public native CvHaarClassifier right(IntPointer paramIntPointer);
    
    public native FloatPointer threshold();
    
    public native CvHaarClassifier threshold(FloatPointer paramFloatPointer);
  }
  
  public static class CvHaarClassifierCascade
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHaarClassifierCascade()
    {
      allocate();
    }
    
    public CvHaarClassifierCascade(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvHaarClassifierCascade(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvHaarClassifierCascade load(String paramString, opencv_core.CvSize paramCvSize)
    {
      CvHaarClassifierCascade localCvHaarClassifierCascade = opencv_objdetect.cvLoadHaarClassifierCascade(paramString, paramCvSize);
      if (localCvHaarClassifierCascade != null) {
        localCvHaarClassifierCascade.deallocator(new ReleaseDeallocator(localCvHaarClassifierCascade));
      }
      return localCvHaarClassifierCascade;
    }
    
    public native int count();
    
    public native CvHaarClassifierCascade count(int paramInt);
    
    public native int flags();
    
    public native CvHaarClassifierCascade flags(int paramInt);
    
    public native CvHaarClassifierCascade hid_cascade(CvHidHaarClassifierCascade paramCvHidHaarClassifierCascade);
    
    public native CvHidHaarClassifierCascade hid_cascade();
    
    @ByRef
    public native opencv_core.CvSize orig_window_size();
    
    public native CvHaarClassifierCascade orig_window_size(opencv_core.CvSize paramCvSize);
    
    public CvHaarClassifierCascade position(int paramInt)
    {
      return (CvHaarClassifierCascade)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvSize real_window_size();
    
    public native CvHaarClassifierCascade real_window_size(opencv_core.CvSize paramCvSize);
    
    public void release()
    {
      deallocate();
    }
    
    public native double scale();
    
    public native CvHaarClassifierCascade scale(double paramDouble);
    
    public native CvHaarClassifierCascade stage_classifier(CvHaarStageClassifier paramCvHaarStageClassifier);
    
    public native CvHaarStageClassifier stage_classifier();
    
    static class ReleaseDeallocator
      extends CvHaarClassifierCascade
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvHaarClassifierCascade paramCvHaarClassifierCascade)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_objdetect.cvReleaseHaarClassifierCascade(this);
      }
    }
  }
  
  public static class CvHaarFeature
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHaarFeature()
    {
      allocate();
    }
    
    public CvHaarFeature(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvHaarFeature(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvHaarFeature position(int paramInt)
    {
      return (CvHaarFeature)super.position(paramInt);
    }
    
    @ByRef
    @Name({"rect", ".r"})
    public native opencv_core.CvRect rect_r(int paramInt);
    
    public native CvHaarFeature rect_r(int paramInt, opencv_core.CvRect paramCvRect);
    
    @Name({"rect", ".weight"})
    public native float rect_weight(int paramInt);
    
    public native CvHaarFeature rect_weight(int paramInt, float paramFloat);
    
    public native int tilted();
    
    public native CvHaarFeature tilted(int paramInt);
  }
  
  public static class CvHaarStageClassifier
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHaarStageClassifier()
    {
      allocate();
    }
    
    public CvHaarStageClassifier(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvHaarStageClassifier(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int child();
    
    public native CvHaarStageClassifier child(int paramInt);
    
    public native CvHaarClassifier classifier();
    
    public native CvHaarStageClassifier classifier(CvHaarClassifier paramCvHaarClassifier);
    
    public native int count();
    
    public native CvHaarStageClassifier count(int paramInt);
    
    public native int next();
    
    public native CvHaarStageClassifier next(int paramInt);
    
    public native int parent();
    
    public native CvHaarStageClassifier parent(int paramInt);
    
    public CvHaarStageClassifier position(int paramInt)
    {
      return (CvHaarStageClassifier)super.position(paramInt);
    }
    
    public native float threshold();
    
    public native CvHaarStageClassifier threshold(float paramFloat);
  }
  
  @Opaque
  public static class CvHidHaarClassifierCascade
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHidHaarClassifierCascade() {}
    
    public CvHidHaarClassifierCascade(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class CvLSVMFilterObject
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvLSVMFilterObject()
    {
      allocate();
    }
    
    public CvLSVMFilterObject(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvLSVMFilterObject(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native FloatPointer H();
    
    public native CvLSVMFilterObject H(FloatPointer paramFloatPointer);
    
    public native CvLSVMFilterObject V(CvLSVMFilterPosition paramCvLSVMFilterPosition);
    
    @ByRef
    public native opencv_objdetect.CvLSVMFilterPosition V();
    
    public native float fineFunction(int paramInt);
    
    public native CvLSVMFilterObject fineFunction(int paramInt, float paramFloat);
    
    public native int numFeatures();
    
    public native CvLSVMFilterObject numFeatures(int paramInt);
    
    public CvLSVMFilterObject position(int paramInt)
    {
      return (CvLSVMFilterObject)super.position(paramInt);
    }
    
    public native int sizeX();
    
    public native CvLSVMFilterObject sizeX(int paramInt);
    
    public native int sizeY();
    
    public native CvLSVMFilterObject sizeY(int paramInt);
  }
  
  public static class CvLSVMFilterPosition
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvLSVMFilterPosition()
    {
      allocate();
    }
    
    public CvLSVMFilterPosition(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvLSVMFilterPosition(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int l();
    
    public native CvLSVMFilterPosition l(int paramInt);
    
    public CvLSVMFilterPosition position(int paramInt)
    {
      return (CvLSVMFilterPosition)super.position(paramInt);
    }
    
    public native int x();
    
    public native CvLSVMFilterPosition x(int paramInt);
    
    public native int y();
    
    public native CvLSVMFilterPosition y(int paramInt);
  }
  
  public static class CvLatentSvmDetector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvLatentSvmDetector()
    {
      allocate();
    }
    
    public CvLatentSvmDetector(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvLatentSvmDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native FloatPointer b();
    
    public native CvLatentSvmDetector b(FloatPointer paramFloatPointer);
    
    @Cast({"CvLSVMFilterObject**"})
    public native PointerPointer filters();
    
    public native CvLatentSvmDetector filters(PointerPointer paramPointerPointer);
    
    public native int num_components();
    
    public native CvLatentSvmDetector num_components(int paramInt);
    
    public native int num_filters();
    
    public native CvLatentSvmDetector num_filters(int paramInt);
    
    public native IntPointer num_part_filters();
    
    public native CvLatentSvmDetector num_part_filters(IntPointer paramIntPointer);
    
    public CvLatentSvmDetector position(int paramInt)
    {
      return (CvLatentSvmDetector)super.position(paramInt);
    }
    
    public native float score_threshold();
    
    public native CvLatentSvmDetector score_threshold(float paramFloat);
  }
  
  public static class CvObjectDetection
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvObjectDetection()
    {
      allocate();
    }
    
    public CvObjectDetection(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvObjectDetection(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvObjectDetection position(int paramInt)
    {
      return (CvObjectDetection)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvRect rect();
    
    public native CvObjectDetection rect(opencv_core.CvRect paramCvRect);
    
    public native float score();
    
    public native CvObjectDetection score(float paramFloat);
  }
  
  @Namespace("cv::linemod")
  @NoOffset
  public static class DepthNormal
    extends Modality
  {
    static
    {
      Loader.load();
    }
    
    public DepthNormal()
    {
      allocate();
    }
    
    public DepthNormal(int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3)
    {
      allocate(paramInt1, paramInt2, paramLong, paramInt3);
    }
    
    public DepthNormal(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3);
    
    public native int difference_threshold();
    
    public native DepthNormal difference_threshold(int paramInt);
    
    public native int distance_threshold();
    
    public native DepthNormal distance_threshold(int paramInt);
    
    public native int extract_threshold();
    
    public native DepthNormal extract_threshold(int paramInt);
    
    @Cast({"size_t"})
    public native long num_features();
    
    public native DepthNormal num_features(long paramLong);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class DetectionROI
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DetectionROI()
    {
      allocate();
    }
    
    public DetectionROI(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public DetectionROI(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @StdVector
    public native DoublePointer confidences();
    
    public native DetectionROI confidences(DoublePointer paramDoublePointer);
    
    @StdVector("CvPoint,cv::Point")
    public native opencv_core.CvPoint locations();
    
    public native DetectionROI locations(opencv_core.CvPoint paramCvPoint);
    
    public DetectionROI position(int paramInt)
    {
      return (DetectionROI)super.position(paramInt);
    }
    
    public native double scale();
    
    public native DetectionROI scale(double paramDouble);
  }
  
  @Namespace("cv::linemod")
  public static class Detector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Detector()
    {
      allocate();
    }
    
    public Detector(Pointer paramPointer)
    {
      super();
    }
    
    public Detector(@ByRef opencv_objdetect.ModalityVector paramModalityVector, @Const @StdVector int[] paramArrayOfInt)
    {
      allocate(paramModalityVector, paramArrayOfInt);
    }
    
    private native void allocate();
    
    private native void allocate(@ByRef opencv_objdetect.ModalityVector paramModalityVector, @Const @StdVector int[] paramArrayOfInt);
    
    public native int addSyntheticTemplate(@Const @StdVector opencv_objdetect.Template paramTemplate, String paramString);
    
    public native int addTemplate(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, String paramString, opencv_core.IplImage paramIplImage, @Adapter("RectAdapter") @Const opencv_core.CvRect paramCvRect);
    
    @ByVal
    public native opencv_core.StringVector classIds();
    
    @ByRef
    @Const
    public native opencv_objdetect.ModalityVector getModalities();
    
    public native int getT(int paramInt);
    
    @StdVector
    public native opencv_objdetect.Template getTemplates(String paramString, int paramInt);
    
    public native void match(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray1, float paramFloat, @StdVector opencv_objdetect.Match paramMatch, @ByRef opencv_core.StringVector paramStringVector, @opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray2, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray3);
    
    public native int numClasses();
    
    public native int numTemplates();
    
    public native int numTemplates(String paramString);
    
    public native int pyramidLevels();
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    @ByRef
    public native String readClass(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, String paramString);
    
    public native void readClasses(@ByRef opencv_core.StringVector paramStringVector, String paramString);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void writeClass(String paramString, @Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void writeClasses(String paramString);
  }
  
  @Namespace("cv::linemod")
  @NoOffset
  public static class Feature
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Feature()
    {
      allocate();
    }
    
    public Feature(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Feature(int paramInt1, int paramInt2, int paramInt3)
    {
      allocate(paramInt1, paramInt2, paramInt3);
    }
    
    public Feature(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3);
    
    private native void allocateArray(int paramInt);
    
    public native int label();
    
    public native Feature label(int paramInt);
    
    public Feature position(int paramInt)
    {
      return (Feature)super.position(paramInt);
    }
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native int x();
    
    public native Feature x(int paramInt);
    
    public native int y();
    
    public native Feature y(int paramInt);
  }
  
  @Namespace("cv")
  public static class FeatureEvaluator
    extends Pointer
  {
    public static final int HAAR = 0;
    public static final int HOG = 2;
    public static final int LBP = 1;
    
    static
    {
      Loader.load();
    }
    
    public FeatureEvaluator()
    {
      allocate();
    }
    
    public FeatureEvaluator(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public FeatureEvaluator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @opencv_core.Ptr
    public static native FeatureEvaluator create(int paramInt);
    
    public native int calcCat(int paramInt);
    
    public native double calcOrd(int paramInt);
    
    @opencv_core.Ptr
    public native FeatureEvaluator clone();
    
    public native int getFeatureType();
    
    public FeatureEvaluator position(int paramInt)
    {
      return (FeatureEvaluator)super.position(paramInt);
    }
    
    public native boolean read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native boolean setImage(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize);
    
    public native boolean setWindow(@ByVal opencv_core.CvPoint paramCvPoint);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class HOGDescriptor
    extends Pointer
  {
    public static final int DEFAULT_NLEVELS = 64;
    public static final int L2Hys;
    
    static
    {
      Loader.load();
    }
    
    public HOGDescriptor()
    {
      allocate();
    }
    
    public HOGDescriptor(Pointer paramPointer)
    {
      super();
    }
    
    public HOGDescriptor(@ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3, @ByVal opencv_core.CvSize paramCvSize4, int paramInt1, int paramInt2, double paramDouble1, int paramInt3, double paramDouble2, boolean paramBoolean, int paramInt4)
    {
      allocate(paramCvSize1, paramCvSize2, paramCvSize3, paramCvSize4, paramInt1, paramInt2, paramDouble1, paramInt3, paramDouble2, paramBoolean, paramInt4);
    }
    
    public HOGDescriptor(@ByRef HOGDescriptor paramHOGDescriptor)
    {
      allocate(paramHOGDescriptor);
    }
    
    public HOGDescriptor(String paramString)
    {
      allocate(paramString);
    }
    
    private native void allocate();
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3, @ByVal opencv_core.CvSize paramCvSize4, int paramInt1, int paramInt2, double paramDouble1, int paramInt3, double paramDouble2, @Cast({"bool"}) boolean paramBoolean, int paramInt4);
    
    private native void allocate(@ByRef HOGDescriptor paramHOGDescriptor);
    
    private native void allocate(String paramString);
    
    @StdVector
    public static native FloatPointer getDaimlerPeopleDetector();
    
    @StdVector
    public static native FloatPointer getDefaultPeopleDetector();
    
    public native double L2HysThreshold();
    
    public native HOGDescriptor L2HysThreshold(double paramDouble);
    
    @ByVal
    public native opencv_core.CvSize blockSize();
    
    public native HOGDescriptor blockSize(opencv_core.CvSize paramCvSize);
    
    @ByVal
    public native opencv_core.CvSize blockStride();
    
    public native HOGDescriptor blockStride(opencv_core.CvSize paramCvSize);
    
    @ByVal
    public native opencv_core.CvSize cellSize();
    
    public native HOGDescriptor cellSize(opencv_core.CvSize paramCvSize);
    
    public native boolean checkDetectorSize();
    
    public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint);
    
    public native void computeGradient(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
    
    public native void copyTo(@ByRef HOGDescriptor paramHOGDescriptor);
    
    public native int derivAperture();
    
    public native HOGDescriptor derivAperture(int paramInt);
    
    public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint1, double paramDouble, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint2);
    
    public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint1, @StdVector DoublePointer paramDoublePointer, double paramDouble, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint2);
    
    public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, double paramDouble1, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, double paramDouble2, double paramDouble3, @Cast({"bool"}) boolean paramBoolean);
    
    public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, double paramDouble1, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, double paramDouble2, int paramInt);
    
    public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector DoublePointer paramDoublePointer, double paramDouble1, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, double paramDouble2, double paramDouble3, @Cast({"bool"}) boolean paramBoolean);
    
    public native void detectMultiScaleROI(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector opencv_objdetect.DetectionROI paramDetectionROI, double paramDouble, int paramInt);
    
    public native void detectROI(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint1, @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint2, @StdVector DoublePointer paramDoublePointer, double paramDouble, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
    
    public native HOGDescriptor gammaCorrection(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean gammaCorrection();
    
    public native long getDescriptorSize();
    
    public native double getWinSigma();
    
    public native int histogramNormType();
    
    public native HOGDescriptor histogramNormType(int paramInt);
    
    public native boolean load(String paramString1, String paramString2);
    
    public native int nbins();
    
    public native HOGDescriptor nbins(int paramInt);
    
    public native int nlevels();
    
    public native HOGDescriptor nlevels(int paramInt);
    
    public native boolean read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void readALTModel(String paramString);
    
    public native void save(String paramString1, String paramString2);
    
    public native void setSVMDetector(@opencv_core.InputArray FloatPointer paramFloatPointer);
    
    public native void setSVMDetector(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
    
    @Const
    @StdVector
    public native FloatPointer svmDetector();
    
    public native HOGDescriptor svmDetector(FloatPointer paramFloatPointer);
    
    public native double winSigma();
    
    public native HOGDescriptor winSigma(double paramDouble);
    
    @ByVal
    public native opencv_core.CvSize winSize();
    
    public native HOGDescriptor winSize(opencv_core.CvSize paramCvSize);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, String paramString);
  }
  
  @Namespace("cv::linemod")
  @NoOffset
  public static class Match
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Match()
    {
      allocate();
    }
    
    public Match(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Match(int paramInt1, int paramInt2, float paramFloat, String paramString, int paramInt3)
    {
      allocate(paramInt1, paramInt2, paramFloat, paramString, paramInt3);
    }
    
    public Match(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat, String paramString, int paramInt3);
    
    private native void allocateArray(int paramInt);
    
    public native Match class_id(String paramString);
    
    @ByRef
    public native String class_id();
    
    @Cast({"bool"})
    @Name({"operator<"})
    public native boolean compare(@ByRef Match paramMatch);
    
    @Cast({"bool"})
    @Name({"operator=="})
    public native boolean equals(@ByRef Match paramMatch);
    
    public Match position(int paramInt)
    {
      return (Match)super.position(paramInt);
    }
    
    public native float similarity();
    
    public native Match similarity(float paramFloat);
    
    public native int template_id();
    
    public native Match template_id(int paramInt);
    
    public native int x();
    
    public native Match x(int paramInt);
    
    public native int y();
    
    public native Match y(int paramInt);
  }
  
  @Namespace("cv::linemod")
  public static class Modality
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Modality() {}
    
    public Modality(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native Modality create(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    @opencv_core.Ptr
    public static native Modality create(String paramString);
    
    @ByRef
    public native String name();
    
    @opencv_core.Ptr
    public native QuantizedPyramid process(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
  }
  
  @Name({"std::vector<cv::Ptr<cv::linemod::Modality> >"})
  public static class ModalityVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ModalityVector()
    {
      allocate();
    }
    
    public ModalityVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public ModalityVector(Pointer paramPointer)
    {
      super();
    }
    
    public ModalityVector(Modality... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @Const
    @Index
    @opencv_core.Ptr
    public native opencv_objdetect.Modality get(@Cast({"size_t"}) long paramLong);
    
    public native ModalityVector put(@Cast({"size_t"}) long paramLong, Modality paramModality);
    
    public ModalityVector put(Modality... paramVarArgs)
    {
      if (size() < paramVarArgs.length) {
        resize(paramVarArgs.length);
      }
      for (int i = 0; i < paramVarArgs.length; i++) {
        put(i, paramVarArgs[i]);
      }
      return this;
    }
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    public native long size();
  }
  
  @Namespace("cv::linemod")
  public static class QuantizedPyramid
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public QuantizedPyramid() {}
    
    public QuantizedPyramid(Pointer paramPointer)
    {
      super();
    }
    
    @Cast({"bool"})
    public native boolean extractTemplate(@ByRef opencv_objdetect.Template paramTemplate);
    
    public native void pyrDown();
    
    public native void quantize(@opencv_core.InputMat opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv::linemod")
  @NoOffset
  public static class Template
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Template()
    {
      allocate();
    }
    
    public Template(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Template(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Const
    @StdVector
    public native opencv_objdetect.Feature features();
    
    public native Template features(Feature paramFeature);
    
    public native int height();
    
    public native Template height(int paramInt);
    
    public Template position(int paramInt)
    {
      return (Template)super.position(paramInt);
    }
    
    public native int pyramid_level();
    
    public native Template pyramid_level(int paramInt);
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native int width();
    
    public native Template width(int paramInt);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_objdetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */