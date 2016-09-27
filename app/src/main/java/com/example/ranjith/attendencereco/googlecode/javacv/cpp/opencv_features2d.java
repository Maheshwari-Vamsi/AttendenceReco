package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/features2d/features2d.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_features2d245", "opencv_flann245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_features2d
{
  static
  {
    Loader.load(opencv_highgui.class);
    Loader.load(opencv_flann.class);
    if (Loader.load() != null) {
      initModule_features2d();
    }
  }
  
  @Namespace("cv")
  public static native void FAST(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @StdVector KeyPoint paramKeyPoint, int paramInt, @Cast({"bool"}) boolean paramBoolean);
  
  @Namespace("cv")
  public static native void FASTX(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @StdVector KeyPoint paramKeyPoint, int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2);
  
  @Name({"dynamic_cast<cv::DescriptorExtractor*>"})
  public static native DescriptorExtractor castDescriptorExtractor(Feature2D paramFeature2D);
  
  @Name({"dynamic_cast<cv::FeatureDetector*>"})
  public static native FeatureDetector castFeatureDetector(Feature2D paramFeature2D);
  
  public static native void computeRecallPrecisionCurve(@ByRef DMatchVectorVector paramDMatchVectorVector, @ByRef @Cast({"std::vector<std::vector<uchar> >*"}) opencv_core.ByteVectorVector paramByteVectorVector, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f);
  
  public static native void drawKeypoints(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @Const @StdVector KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_core.CvScalar paramCvScalar, int paramInt);
  
  public static native void drawMatches(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @Const @StdVector KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @Const @StdVector KeyPoint paramKeyPoint2, @Const @StdVector DMatch paramDMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @ByRef opencv_core.CvScalar paramCvScalar1, @ByRef opencv_core.CvScalar paramCvScalar2, @Cast({"char*"}) @Const @StdVector byte[] paramArrayOfByte, int paramInt);
  
  public static native void drawMatches(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @Const @StdVector KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @Const @StdVector KeyPoint paramKeyPoint2, @ByRef DMatchVectorVector paramDMatchVectorVector, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @ByRef opencv_core.CvScalar paramCvScalar1, @ByRef opencv_core.CvScalar paramCvScalar2, @ByRef opencv_core.ByteVectorVector paramByteVectorVector, int paramInt);
  
  public static native void evaluateFeatureDetector(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, @StdVector KeyPoint paramKeyPoint1, @StdVector KeyPoint paramKeyPoint2, @ByRef float[] paramArrayOfFloat, @ByRef int[] paramArrayOfInt, @opencv_core.Ptr FeatureDetector paramFeatureDetector);
  
  public static native void evaluateGenericDescriptorMatcher(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, @StdVector KeyPoint paramKeyPoint1, @StdVector KeyPoint paramKeyPoint2, DMatchVectorVector paramDMatchVectorVector, @Cast({"std::vector<std::vector<uchar> >*"}) opencv_core.ByteVectorVector paramByteVectorVector, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @opencv_core.Ptr GenericDescriptorMatcher paramGenericDescriptorMatcher);
  
  public static native int getNearestPoint(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat);
  
  public static native float getRecall(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat);
  
  @Cast({"bool"})
  @Namespace("cv")
  public static native boolean initModule_features2d();
  
  @Namespace("cv")
  public static native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, @StdVector KeyPoint paramKeyPoint);
  
  @opencv_core.OutputMat
  public static native opencv_core.CvMat windowedMatchingMask(@Const @StdVector KeyPoint paramKeyPoint1, @Const @StdVector KeyPoint paramKeyPoint2, float paramFloat1, float paramFloat2);
  
  @Namespace("cv")
  public static native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, String paramString, @Const @StdVector KeyPoint paramKeyPoint);
  
  @Namespace("cv")
  public static class AdjusterAdapter
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public AdjusterAdapter() {}
    
    public AdjusterAdapter(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native AdjusterAdapter create(String paramString);
    
    @opencv_core.Ptr
    public native AdjusterAdapter clone();
    
    public native boolean good();
    
    public native void tooFew(int paramInt1, int paramInt2);
    
    public native void tooMany(int paramInt1, int paramInt2);
  }
  
  @Namespace("cv")
  public static class BFMatcher
    extends DescriptorMatcher
  {
    static
    {
      Loader.load();
    }
    
    public BFMatcher()
    {
      allocate();
    }
    
    public BFMatcher(int paramInt, @Cast({"bool"}) boolean paramBoolean)
    {
      allocate(paramInt, paramBoolean);
    }
    
    public BFMatcher(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, @Cast({"bool"}) boolean paramBoolean);
  }
  
  @Namespace("cv")
  public static class BOWImgDescriptorExtractor
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public BOWImgDescriptorExtractor(Pointer paramPointer)
    {
      super();
    }
    
    public BOWImgDescriptorExtractor(@opencv_core.Ptr DescriptorExtractor paramDescriptorExtractor, @opencv_core.Ptr DescriptorMatcher paramDescriptorMatcher)
    {
      allocate(paramDescriptorExtractor, paramDescriptorMatcher);
    }
    
    private native void allocate(@opencv_core.Ptr DescriptorExtractor paramDescriptorExtractor, @opencv_core.Ptr DescriptorMatcher paramDescriptorMatcher);
    
    public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputMat opencv_core.CvMat paramCvMat1, opencv_core.IntVectorVector paramIntVectorVector, @opencv_core.OutputMat opencv_core.CvMat paramCvMat2);
    
    public native int descriptorSize();
    
    public native int descriptorType();
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat getVocabulary();
    
    public native void setVocabulary(opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv")
  public static class BOWKMeansTrainer
    extends BOWTrainer
  {
    static
    {
      Loader.load();
    }
    
    public BOWKMeansTrainer(int paramInt)
    {
      allocate(paramInt);
    }
    
    public BOWKMeansTrainer(int paramInt1, @ByRef opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt2, int paramInt3)
    {
      allocate(paramInt1, paramCvTermCriteria, paramInt2, paramInt3);
    }
    
    public BOWKMeansTrainer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(int paramInt);
    
    private native void allocate(int paramInt1, @ByRef opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt2, int paramInt3);
  }
  
  @Namespace("cv")
  public static class BOWTrainer
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public BOWTrainer() {}
    
    public BOWTrainer(Pointer paramPointer)
    {
      super();
    }
    
    public native void add(opencv_core.CvMat paramCvMat);
    
    public native void clear();
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat cluster();
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat cluster(opencv_core.CvMat paramCvMat);
    
    public native int descripotorsCount();
    
    @ByRef
    @Const
    public native opencv_core.MatVector getDescriptors();
  }
  
  @Namespace("cv")
  public static class BRISK
    extends Feature2D
  {
    public static final int FAST_SCORE = 1;
    public static final int HARRIS_SCORE = 0;
    public static final int kBytes = 32;
    
    static
    {
      Loader.load();
    }
    
    public BRISK()
    {
      allocate();
    }
    
    public BRISK(int paramInt1, int paramInt2, float paramFloat)
    {
      allocate(paramInt1, paramInt2, paramFloat);
    }
    
    public BRISK(Pointer paramPointer)
    {
      super();
    }
    
    public BRISK(@StdVector float[] paramArrayOfFloat, @StdVector int[] paramArrayOfInt1, float paramFloat1, float paramFloat2, @StdVector int[] paramArrayOfInt2)
    {
      allocate(paramArrayOfFloat, paramArrayOfInt1, paramFloat1, paramFloat2, paramArrayOfInt2);
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat);
    
    private native void allocate(@StdVector float[] paramArrayOfFloat, @StdVector int[] paramArrayOfInt1, float paramFloat1, float paramFloat2, @StdVector int[] paramArrayOfInt2);
    
    @Name({"operator()"})
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    @Name({"operator()"})
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, boolean paramBoolean);
    
    public native int descriptorSize();
    
    public native int descriptorType();
    
    public native void generateKernel(@StdVector float[] paramArrayOfFloat, @StdVector int[] paramArrayOfInt1, float paramFloat1, float paramFloat2, @StdVector int[] paramArrayOfInt2);
    
    public native opencv_core.AlgorithmInfo info();
  }
  
  @Namespace("cv")
  public static class BriefDescriptorExtractor
    extends DescriptorExtractor
  {
    public static final int KERNEL_SIZE = 9;
    public static final int PATCH_SIZE = 48;
    
    static
    {
      Loader.load();
    }
    
    public BriefDescriptorExtractor()
    {
      allocate();
    }
    
    public BriefDescriptorExtractor(int paramInt)
    {
      allocate(paramInt);
    }
    
    public BriefDescriptorExtractor(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class DMatch
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DMatch()
    {
      allocate();
    }
    
    public DMatch(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public DMatch(int paramInt1, int paramInt2, float paramFloat)
    {
      allocate(paramInt1, paramInt2, paramFloat);
    }
    
    public DMatch(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    
    public DMatch(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat);
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
    
    private native void allocateArray(int paramInt);
    
    @Name({"operator<"})
    public native boolean compare(@ByRef DMatch paramDMatch);
    
    public native float distance();
    
    public native DMatch distance(float paramFloat);
    
    public native int imgIdx();
    
    public native DMatch imgIdx(int paramInt);
    
    public DMatch position(int paramInt)
    {
      return (DMatch)super.position(paramInt);
    }
    
    public native int queryIdx();
    
    public native DMatch queryIdx(int paramInt);
    
    public native int trainIdx();
    
    public native DMatch trainIdx(int paramInt);
  }
  
  @Name({"std::vector<std::vector<cv::DMatch> >"})
  public static class DMatchVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DMatchVectorVector()
    {
      allocate();
    }
    
    public DMatchVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public DMatchVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByRef
    @Index
    public native opencv_features2d.DMatch get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native DMatchVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, DMatch paramDMatch);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  @Namespace("cv")
  public static class DenseFeatureDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public DenseFeatureDetector()
    {
      allocate();
    }
    
    public DenseFeatureDetector(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, int paramInt3, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2)
    {
      allocate(paramFloat1, paramInt1, paramFloat2, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
    }
    
    public DenseFeatureDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, int paramInt3, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2);
  }
  
  @Namespace("cv")
  public static class DescriptorExtractor
    extends opencv_core.Algorithm
  {
    static
    {
      Loader.load();
    }
    
    public DescriptorExtractor() {}
    
    public DescriptorExtractor(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native DescriptorExtractor create(String paramString);
    
    public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputMat opencv_core.CvMat paramCvMat);
    
    public native void compute(@ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector, @ByRef opencv_core.MatVector paramMatVector2);
    
    public native int descriptorSize();
    
    public native int descriptorType();
    
    public native boolean empty();
  }
  
  @Namespace("cv")
  public static class DescriptorMatcher
    extends opencv_core.Algorithm
  {
    static
    {
      Loader.load();
    }
    
    public DescriptorMatcher() {}
    
    public DescriptorMatcher(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native DescriptorMatcher create(String paramString);
    
    public native void add(@ByRef opencv_core.MatVector paramMatVector);
    
    public native void clear();
    
    @opencv_core.Ptr
    public native DescriptorMatcher clone();
    
    @opencv_core.Ptr
    public native DescriptorMatcher clone(@Cast({"bool"}) boolean paramBoolean);
    
    public native boolean empty();
    
    @ByRef
    @Const
    public native opencv_core.MatVector getTrainDescriptors();
    
    public native boolean isMaskSupported();
    
    public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
    
    public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
    
    public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.DMatch paramDMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
    
    public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.DMatch paramDMatch, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray);
    
    public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
    
    public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
    
    public native void train();
  }
  
  public static class DrawMatchesFlags
  {
    public static final int DEFAULT = 0;
    public static final int DRAW_OVER_OUTIMG = 1;
    public static final int DRAW_RICH_KEYPOINTS = 4;
    public static final int NOT_DRAW_SINGLE_POINTS = 2;
  }
  
  @Namespace("cv")
  public static class DynamicAdaptedFeatureDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public DynamicAdaptedFeatureDetector() {}
    
    public DynamicAdaptedFeatureDetector(Pointer paramPointer)
    {
      super();
    }
    
    public DynamicAdaptedFeatureDetector(@opencv_core.Ptr AdjusterAdapter paramAdjusterAdapter, int paramInt1, int paramInt2, int paramInt3)
    {
      allocate(paramAdjusterAdapter, paramInt1, paramInt2, paramInt3);
    }
    
    private native void allocate(@opencv_core.Ptr AdjusterAdapter paramAdjusterAdapter, int paramInt1, int paramInt2, int paramInt3);
  }
  
  @Namespace("cv")
  public static class FREAK
    extends DescriptorExtractor
  {
    public static final int FAST_SCORE = 1;
    public static final int HARRIS_SCORE = 0;
    public static final int NB_ORIENPAIRS = 45;
    public static final int NB_PAIRS = 512;
    public static final int NB_SCALES = 64;
    public static final int kBytes = 32;
    
    static
    {
      Loader.load();
    }
    
    public FREAK()
    {
      allocate();
    }
    
    public FREAK(Pointer paramPointer)
    {
      super();
    }
    
    public FREAK(boolean paramBoolean1, boolean paramBoolean2, float paramFloat, int paramInt, @Const @StdVector IntPointer paramIntPointer)
    {
      allocate(paramBoolean1, paramBoolean2, paramFloat, paramInt, paramIntPointer);
    }
    
    private native void allocate();
    
    private native void allocate(boolean paramBoolean1, boolean paramBoolean2, float paramFloat, int paramInt, @Const @StdVector IntPointer paramIntPointer);
    
    @StdVector
    public native IntPointer selectPairs(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector, double paramDouble, boolean paramBoolean);
  }
  
  @Namespace("cv")
  public static class FastAdjuster
    extends AdjusterAdapter
  {
    static
    {
      Loader.load();
    }
    
    public FastAdjuster()
    {
      allocate();
    }
    
    public FastAdjuster(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
    {
      allocate(paramInt1, paramBoolean, paramInt2, paramInt3);
    }
    
    public FastAdjuster(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2, int paramInt3);
  }
  
  @Namespace("cv")
  public static class FastFeatureDetector
    extends FeatureDetector
  {
    public static final int TYPE_5_8 = 0;
    public static final int TYPE_7_12 = 1;
    public static final int TYPE_9_16 = 2;
    
    static
    {
      Loader.load();
    }
    
    public FastFeatureDetector() {}
    
    public FastFeatureDetector(int paramInt, boolean paramBoolean)
    {
      allocate(paramInt, paramBoolean);
    }
    
    public FastFeatureDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(int paramInt, @Cast({"bool"}) boolean paramBoolean);
  }
  
  @Namespace("cv")
  public static class Feature2D
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Feature2D() {}
    
    public Feature2D(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native Feature2D create(String paramString);
    
    @Name({"operator()"})
    public native void detectAndCompute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
    
    public DescriptorExtractor getDescriptorExtractor()
    {
      return opencv_features2d.castDescriptorExtractor(this);
    }
    
    public FeatureDetector getFeatureDetector()
    {
      return opencv_features2d.castFeatureDetector(this);
    }
  }
  
  @Namespace("cv")
  public static class FeatureDetector
    extends opencv_core.Algorithm
  {
    static
    {
      Loader.load();
    }
    
    public FeatureDetector() {}
    
    public FeatureDetector(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native FeatureDetector create(String paramString);
    
    public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
    
    public native void detect(@ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector, @ByRef opencv_core.MatVector paramMatVector2);
    
    public native boolean empty();
  }
  
  @Namespace("cv")
  public static class FlannBasedMatcher
    extends DescriptorMatcher
  {
    static
    {
      Loader.load();
    }
    
    public FlannBasedMatcher()
    {
      allocate();
    }
    
    public FlannBasedMatcher(Pointer paramPointer)
    {
      super();
    }
    
    public FlannBasedMatcher(opencv_flann.IndexParams paramIndexParams, opencv_flann.SearchParams paramSearchParams)
    {
      allocate(paramIndexParams, paramSearchParams);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_flann.IndexParams paramIndexParams, opencv_flann.SearchParams paramSearchParams);
  }
  
  @Namespace("cv")
  public static class GFTTDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public GFTTDetector()
    {
      allocate();
    }
    
    public GFTTDetector(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, @Cast({"bool"}) boolean paramBoolean, double paramDouble3)
    {
      allocate(paramInt1, paramDouble1, paramDouble2, paramInt2, paramBoolean, paramDouble3);
    }
    
    public GFTTDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, @Cast({"bool"}) boolean paramBoolean, double paramDouble3);
  }
  
  @Namespace("cv")
  public static class GenericDescriptorMatcher
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public GenericDescriptorMatcher() {}
    
    public GenericDescriptorMatcher(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native GenericDescriptorMatcher create(String paramString1, String paramString2);
    
    public native void add(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector);
    
    public native void classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    public native void classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2);
    
    public native void clear();
    
    @opencv_core.Ptr
    public native GenericDescriptorMatcher clone();
    
    @opencv_core.Ptr
    public native GenericDescriptorMatcher clone(@Cast({"bool"}) boolean paramBoolean);
    
    public native boolean empty();
    
    @ByRef
    @Const
    public native opencv_core.MatVector getTrainImages();
    
    @ByRef
    @Const
    public native opencv_features2d.KeyPointVectorVector getTrainKeypoints();
    
    public native boolean isMaskSupported();
    
    public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
    
    public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
    
    public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2, @StdVector opencv_features2d.DMatch paramDMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
    
    public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @StdVector opencv_features2d.DMatch paramDMatch, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray);
    
    public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
    
    public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void train();
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
  }
  
  @Namespace("cv")
  public static class GridAdaptedFeatureDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public GridAdaptedFeatureDetector()
    {
      allocate();
    }
    
    public GridAdaptedFeatureDetector(Pointer paramPointer)
    {
      super();
    }
    
    public GridAdaptedFeatureDetector(@opencv_core.Ptr FeatureDetector paramFeatureDetector, int paramInt1, int paramInt2, int paramInt3)
    {
      allocate(paramFeatureDetector, paramInt1, paramInt2, paramInt3);
    }
    
    private native void allocate();
    
    private native void allocate(@opencv_core.Ptr FeatureDetector paramFeatureDetector, int paramInt1, int paramInt2, int paramInt3);
  }
  
  @Namespace("cv")
  public static class Hamming
    extends Pointer
  {
    public static final int normType = 6;
    
    static
    {
      Loader.load();
    }
    
    public Hamming()
    {
      allocate();
    }
    
    public Hamming(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Name({"operator()"})
    public native int d(@Cast({"unsigned char*"}) byte[] paramArrayOfByte1, @Cast({"unsigned char*"}) byte[] paramArrayOfByte2, int paramInt);
  }
  
  @Name({"cv::HammingMultilevel<2>"})
  public static class HammingMultilevel2
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public HammingMultilevel2()
    {
      allocate();
    }
    
    public HammingMultilevel2(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Name({"operator()"})
    public native int d(@Cast({"unsigned char*"}) byte[] paramArrayOfByte1, @Cast({"unsigned char*"}) byte[] paramArrayOfByte2, int paramInt);
  }
  
  @Name({"cv::HammingMultilevel<4>"})
  public static class HammingMultilevel4
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public HammingMultilevel4()
    {
      allocate();
    }
    
    public HammingMultilevel4(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Name({"operator()"})
    public native int d(@Cast({"unsigned char*"}) byte[] paramArrayOfByte1, @Cast({"unsigned char*"}) byte[] paramArrayOfByte2, int paramInt);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class KeyPoint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public KeyPoint()
    {
      allocate();
    }
    
    public KeyPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2)
    {
      allocate(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramInt1, paramInt2);
    }
    
    public KeyPoint(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public KeyPoint(Pointer paramPointer)
    {
      super();
    }
    
    public KeyPoint(opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      allocate(paramCvPoint2D32f, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2);
    
    private native void allocate(@ByRef opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);
    
    private native void allocateArray(int paramInt);
    
    public static native void convert(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @StdVector KeyPoint paramKeyPoint, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
    
    public static native void convert(@Const @StdVector KeyPoint paramKeyPoint, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @Const @StdVector int[] paramArrayOfInt);
    
    public static native float overlap(@ByRef KeyPoint paramKeyPoint1, @ByRef KeyPoint paramKeyPoint2);
    
    public native float angle();
    
    public native KeyPoint angle(float paramFloat);
    
    public native int class_id();
    
    public native KeyPoint class_id(int paramInt);
    
    public native long hash();
    
    public native int octave();
    
    public native KeyPoint octave(int paramInt);
    
    public KeyPoint position(int paramInt)
    {
      return (KeyPoint)super.position(paramInt);
    }
    
    @ByVal
    public native opencv_core.CvPoint2D32f pt();
    
    public native KeyPoint pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    @Name({"pt.x"})
    public native float pt_x();
    
    public native KeyPoint pt_x(float paramFloat);
    
    @Name({"pt.y"})
    public native float pt_y();
    
    public native KeyPoint pt_y(float paramFloat);
    
    public native float response();
    
    public native KeyPoint response(float paramFloat);
    
    public native float size();
    
    public native KeyPoint size(float paramFloat);
  }
  
  @Name({"std::vector<std::vector<cv::KeyPoint> >"})
  public static class KeyPointVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public KeyPointVectorVector()
    {
      allocate();
    }
    
    public KeyPointVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public KeyPointVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByRef
    @Index
    public native opencv_features2d.KeyPoint get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native KeyPointVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, KeyPoint paramKeyPoint);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  @Namespace("cv")
  public static class KeyPointsFilter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public KeyPointsFilter()
    {
      allocate();
    }
    
    public KeyPointsFilter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public static native void removeDuplicated(@StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    public static native void runByImageBorder(@StdVector opencv_features2d.KeyPoint paramKeyPoint, @ByVal opencv_core.CvSize paramCvSize, int paramInt);
    
    public static native void runByKeypointSize(@StdVector opencv_features2d.KeyPoint paramKeyPoint, float paramFloat1, float paramFloat2);
    
    public static native void runByPixelsMask(@StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
  }
  
  @Namespace("cv")
  public static class MSER
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public MSER()
    {
      allocate();
    }
    
    public MSER(int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, double paramDouble3, double paramDouble4, int paramInt5)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramDouble1, paramDouble2, paramInt4, paramDouble3, paramDouble4, paramInt5);
    }
    
    public MSER(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, double paramDouble3, double paramDouble4, int paramInt5);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class ORB
    extends Feature2D
  {
    public static final int FAST_SCORE = 1;
    public static final int HARRIS_SCORE = 0;
    public static final int kBytes = 32;
    
    static
    {
      Loader.load();
    }
    
    public ORB()
    {
      allocate();
    }
    
    public ORB(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      allocate(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    
    public ORB(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
    
    public native int descriptorSize();
    
    public native int descriptorType();
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
    
    public native opencv_core.AlgorithmInfo info();
  }
  
  @Namespace("cv")
  public static class OpponentColorDescriptorExtractor
    extends DescriptorExtractor
  {
    static
    {
      Loader.load();
    }
    
    public OpponentColorDescriptorExtractor() {}
    
    public OpponentColorDescriptorExtractor(Pointer paramPointer)
    {
      super();
    }
    
    public OpponentColorDescriptorExtractor(@opencv_core.Ptr DescriptorExtractor paramDescriptorExtractor)
    {
      allocate(paramDescriptorExtractor);
    }
    
    private native void allocate(@opencv_core.Ptr DescriptorExtractor paramDescriptorExtractor);
  }
  
  @Namespace("cv")
  public static class PyramidAdaptedFeatureDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public PyramidAdaptedFeatureDetector() {}
    
    public PyramidAdaptedFeatureDetector(Pointer paramPointer)
    {
      super();
    }
    
    public PyramidAdaptedFeatureDetector(@opencv_core.Ptr FeatureDetector paramFeatureDetector, int paramInt)
    {
      allocate(paramFeatureDetector, paramInt);
    }
    
    private native void allocate(@opencv_core.Ptr FeatureDetector paramFeatureDetector, int paramInt);
  }
  
  @Namespace("cv")
  public static class SimpleBlobDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public SimpleBlobDetector()
    {
      allocate();
    }
    
    public SimpleBlobDetector(Pointer paramPointer)
    {
      super();
    }
    
    public SimpleBlobDetector(@ByRef Params paramParams)
    {
      allocate(paramParams);
    }
    
    private native void allocate();
    
    private native void allocate(@ByRef Params paramParams);
    
    @NoOffset
    public static class Params
      extends Pointer
    {
      static
      {
        Loader.load();
      }
      
      public Params()
      {
        allocate();
      }
      
      public Params(int paramInt)
      {
        allocateArray(paramInt);
      }
      
      public Params(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      private native void allocateArray(int paramInt);
      
      public native byte blobColor();
      
      public native Params blobColor(byte paramByte);
      
      public native Params filterByArea(boolean paramBoolean);
      
      @Cast({"bool"})
      public native boolean filterByArea();
      
      public native Params filterByCircularity(boolean paramBoolean);
      
      @Cast({"bool"})
      public native boolean filterByCircularity();
      
      public native Params filterByColor(boolean paramBoolean);
      
      @Cast({"bool"})
      public native boolean filterByColor();
      
      public native Params filterByConvexity(boolean paramBoolean);
      
      @Cast({"bool"})
      public native boolean filterByConvexity();
      
      public native Params filterByInertia(boolean paramBoolean);
      
      @Cast({"bool"})
      public native boolean filterByInertia();
      
      public native float maxArea();
      
      public native Params maxArea(float paramFloat);
      
      public native float maxCircularity();
      
      public native Params maxCircularity(float paramFloat);
      
      public native float maxConvexity();
      
      public native Params maxConvexity(float paramFloat);
      
      public native float maxInertiaRatio();
      
      public native Params maxInertiaRatio(float paramFloat);
      
      public native float maxThreshold();
      
      public native Params maxThreshold(float paramFloat);
      
      public native float minArea();
      
      public native Params minArea(float paramFloat);
      
      public native float minCircularity();
      
      public native Params minCircularity(float paramFloat);
      
      public native float minConvexity();
      
      public native Params minConvexity(float paramFloat);
      
      public native float minDistBetweenBlobs();
      
      public native Params minDistBetweenBlobs(float paramFloat);
      
      public native float minInertiaRatio();
      
      public native Params minInertiaRatio(float paramFloat);
      
      @Cast({"size_t"})
      public native long minRepeatability();
      
      public native Params minRepeatability(long paramLong);
      
      public native float minThreshold();
      
      public native Params minThreshold(float paramFloat);
      
      public Params position(int paramInt)
      {
        return (Params)super.position(paramInt);
      }
      
      public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
      
      public native float thresholdStep();
      
      public native Params thresholdStep(float paramFloat);
      
      public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    }
  }
  
  @Namespace("cv")
  public static class StarAdjuster
    extends AdjusterAdapter
  {
    static
    {
      Loader.load();
    }
    
    public StarAdjuster()
    {
      allocate();
    }
    
    public StarAdjuster(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      allocate(paramDouble1, paramDouble2, paramDouble3);
    }
    
    public StarAdjuster(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3);
  }
  
  @Namespace("cv")
  public static class StarDetector
    extends FeatureDetector
  {
    static
    {
      Loader.load();
    }
    
    public StarDetector()
    {
      allocate();
    }
    
    public StarDetector(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public StarDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
  }
  
  @Namespace("cv")
  public static class SurfAdjuster
    extends AdjusterAdapter
  {
    static
    {
      Loader.load();
    }
    
    public SurfAdjuster()
    {
      allocate();
    }
    
    public SurfAdjuster(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      allocate(paramDouble1, paramDouble2, paramDouble3);
    }
    
    public SurfAdjuster(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3);
  }
  
  @Namespace("cv")
  public static class VectorDescriptorMatcher
    extends GenericDescriptorMatcher
  {
    static
    {
      Loader.load();
    }
    
    public VectorDescriptorMatcher() {}
    
    public VectorDescriptorMatcher(Pointer paramPointer)
    {
      super();
    }
    
    public VectorDescriptorMatcher(@opencv_core.Ptr DescriptorExtractor paramDescriptorExtractor, @opencv_core.Ptr DescriptorMatcher paramDescriptorMatcher)
    {
      allocate(paramDescriptorExtractor, paramDescriptorMatcher);
    }
    
    private native void allocate(@opencv_core.Ptr DescriptorExtractor paramDescriptorExtractor, @opencv_core.Ptr DescriptorMatcher paramDescriptorMatcher);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_features2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */