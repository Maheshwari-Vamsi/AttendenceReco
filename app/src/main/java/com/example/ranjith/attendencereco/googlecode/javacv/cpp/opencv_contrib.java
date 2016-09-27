package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;
import com.googlecode.javacpp.annotation.ValueGetter;

@Properties({@Platform(include={"<opencv2/contrib/contrib.hpp>", "<opencv2/contrib/detection_based_tracker.hpp>", "<opencv2/contrib/hybridtracker.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_contrib@.2.4", "opencv_ml@.2.4", "opencv_video@.2.4", "opencv_objdetect@.2.4", "opencv_calib3d@.2.4", "opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_contrib245", "opencv_ml245", "opencv_video245", "opencv_objdetect245", "opencv_calib3d245", "opencv_features2d245", "opencv_flann245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_contrib
{
  public static final int COLORMAP_AUTUMN = 0;
  public static final int COLORMAP_BONE = 1;
  public static final int COLORMAP_COOL = 8;
  public static final int COLORMAP_HOT = 11;
  public static final int COLORMAP_HSV = 9;
  public static final int COLORMAP_JET = 2;
  public static final int COLORMAP_OCEAN = 5;
  public static final int COLORMAP_PINK = 10;
  public static final int COLORMAP_RAINBOW = 4;
  public static final int COLORMAP_SPRING = 7;
  public static final int COLORMAP_SUMMER = 6;
  public static final int COLORMAP_WINTER = 3;
  public static final int RETINA_COLOR_BAYER = 2;
  public static final int RETINA_COLOR_DIAGONAL = 1;
  public static final int RETINA_COLOR_RANDOM = 0;
  public static final int RIGID_BODY_MOTION = 4;
  public static final int ROTATION = 1;
  public static final int TRANSLATION = 2;
  
  static
  {
    Loader.load(opencv_calib3d.class);
    Loader.load(opencv_objdetect.class);
    Loader.load(opencv_video.class);
    Loader.load(opencv_ml.class);
    if (Loader.load() != null) {
      initModule_contrib();
    }
  }
  
  @Namespace("cv")
  public static native boolean RGBDOdometry(@opencv_core.InputMat opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, opencv_core.IplImage paramIplImage4, opencv_core.IplImage paramIplImage5, opencv_core.IplImage paramIplImage6, opencv_core.CvMat paramCvMat3, float paramFloat1, float paramFloat2, float paramFloat3, @Const @StdVector IntPointer paramIntPointer, @Const @StdVector FloatPointer paramFloatPointer, int paramInt);
  
  @Namespace("cv")
  public static native void applyColorMap(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt);
  
  @Namespace("cv")
  public static native int chamerMatching(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_core.PointVectorVector paramPointVectorVector, @StdVector FloatPointer paramFloatPointer, double paramDouble1, int paramInt1, double paramDouble2, int paramInt2, int paramInt3, int paramInt4, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native FaceRecognizer createEigenFaceRecognizer();
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native FaceRecognizer createEigenFaceRecognizer(int paramInt, double paramDouble);
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native FaceRecognizer createFisherFaceRecognizer();
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native FaceRecognizer createFisherFaceRecognizer(int paramInt, double paramDouble);
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native FaceRecognizer createLBPHFaceRecognizer();
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native FaceRecognizer createLBPHFaceRecognizer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  @Namespace("cv")
  public static native void generateColors(@Const @StdVector("CvScalar,cv::Scalar") opencv_core.CvScalar paramCvScalar, long paramLong1, long paramLong2);
  
  @Cast({"bool"})
  @Namespace("cv")
  public static native boolean initModule_contrib();
  
  @Namespace("cv")
  public static native void polyfit(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @opencv_core.InputMat opencv_core.CvMat paramCvMat3, int paramInt);
  
  @Namespace("cv")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat subspaceProject(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
  
  @Namespace("cv")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat subspaceReconstruct(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
  
  @Namespace("cv::of2")
  public static class BOWMSCTrainer
    extends opencv_features2d.BOWTrainer
  {
    static
    {
      Loader.load();
    }
    
    public BOWMSCTrainer()
    {
      allocate();
    }
    
    public BOWMSCTrainer(double paramDouble)
    {
      allocate(paramDouble);
    }
    
    public BOWMSCTrainer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble);
  }
  
  @Namespace("cv::of2")
  public static class ChowLiuTree
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ChowLiuTree()
    {
      allocate();
    }
    
    public ChowLiuTree(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void add(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native void add(@ByRef opencv_core.MatVector paramMatVector);
    
    @ByRef
    @Const
    public native opencv_core.MatVector getImgDescriptors();
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat make(double paramDouble);
  }
  
  public static class CvAdaptiveSkinDetector
    extends Pointer
  {
    public static final int MORPHING_METHOD_ERODE = 1;
    public static final int MORPHING_METHOD_ERODE_DILATE = 3;
    public static final int MORPHING_METHOD_ERODE_ERODE = 2;
    public static final int MORPHING_METHOD_NONE;
    
    static
    {
      Loader.load();
    }
    
    public CvAdaptiveSkinDetector()
    {
      allocate();
    }
    
    public CvAdaptiveSkinDetector(int paramInt1, int paramInt2)
    {
      allocate(paramInt1, paramInt2);
    }
    
    public CvAdaptiveSkinDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2);
    
    public native void process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvFeatureTracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFeatureTracker(Pointer paramPointer)
    {
      super();
    }
    
    public CvFeatureTracker(@ByVal opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams)
    {
      allocate(paramCvFeatureTrackerParams);
    }
    
    private native void allocate(@ByVal opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams);
    
    @MemberGetter
    @opencv_core.InputMat
    public native opencv_core.CvMat disp_matches();
    
    @ByVal
    public native opencv_core.CvPoint2D32f getTrackingCenter();
    
    @ByVal
    public native opencv_core.CvRect getTrackingWindow();
    
    public native void newTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvRect paramCvRect);
    
    @ByRef
    @MemberGetter
    public native opencv_contrib.CvFeatureTrackerParams params();
    
    public native void setTrackingWindow(@ByVal opencv_core.CvRect paramCvRect);
    
    @ByVal
    public native opencv_core.CvRect updateTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
    
    @ByVal
    public native opencv_core.CvRect updateTrackingWindowWithFlow(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
    
    @ByVal
    public native opencv_core.CvRect updateTrackingWindowWithSIFT(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvFeatureTrackerParams
    extends Pointer
  {
    public static final int OPTICAL_FLOW = 2;
    public static final int SIFT = 0;
    public static final int SURF = 1;
    
    static
    {
      Loader.load();
    }
    
    public CvFeatureTrackerParams()
    {
      allocate();
    }
    
    public CvFeatureTrackerParams(int paramInt1, int paramInt2)
    {
      allocate(paramInt1, paramInt2);
    }
    
    public CvFeatureTrackerParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2);
    
    public native int feature_type();
    
    public native CvFeatureTrackerParams feature_type(int paramInt);
    
    public native int window_size();
    
    public native CvFeatureTrackerParams window_size(int paramInt);
  }
  
  public static class CvFuzzyController
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFuzzyController()
    {
      allocate();
    }
    
    public CvFuzzyController(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFuzzyController(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native void addRule(CvFuzzyCurve paramCvFuzzyCurve1, CvFuzzyCurve paramCvFuzzyCurve2, CvFuzzyCurve paramCvFuzzyCurve3);
    
    public native double calcOutput(double paramDouble1, double paramDouble2);
    
    public CvFuzzyController position(int paramInt)
    {
      return (CvFuzzyController)super.position(paramInt);
    }
  }
  
  public static class CvFuzzyCurve
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFuzzyCurve()
    {
      allocate();
    }
    
    public CvFuzzyCurve(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFuzzyCurve(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native void addPoint(double paramDouble1, double paramDouble2);
    
    public native double calcValue(double paramDouble);
    
    public native void clear();
    
    public native double getCentre();
    
    public native double getValue();
    
    public CvFuzzyCurve position(int paramInt)
    {
      return (CvFuzzyCurve)super.position(paramInt);
    }
    
    public native void setCentre(double paramDouble);
    
    public native void setValue(double paramDouble);
  }
  
  public static class CvFuzzyFunction
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFuzzyFunction()
    {
      allocate();
    }
    
    public CvFuzzyFunction(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFuzzyFunction(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native void addCurve(CvFuzzyCurve paramCvFuzzyCurve, double paramDouble);
    
    public native double calcValue();
    
    @Const
    @NoOffset
    @StdVector
    public native opencv_contrib.CvFuzzyCurve curves();
    
    public native CvFuzzyFunction curves(CvFuzzyCurve paramCvFuzzyCurve);
    
    public native CvFuzzyCurve newCurve();
    
    public CvFuzzyFunction position(int paramInt)
    {
      return (CvFuzzyFunction)super.position(paramInt);
    }
    
    public native void resetValues();
  }
  
  @NoOffset
  public static class CvFuzzyMeanShiftTracker
    extends Pointer
  {
    public static final int MinKernelMass = 1000;
    public static final int rmEdgeDensityFuzzy = 1;
    public static final int rmEdgeDensityLinear = 0;
    public static final int rmInnerDensity = 2;
    public static final int tsDisabled = 10;
    public static final int tsNone = 0;
    public static final int tsSearching = 1;
    public static final int tsSetWindow = 3;
    public static final int tsTracking = 2;
    
    static
    {
      Loader.load();
    }
    
    public CvFuzzyMeanShiftTracker()
    {
      allocate();
    }
    
    public CvFuzzyMeanShiftTracker(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFuzzyMeanShiftTracker(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    @MemberGetter
    public native Pointer kernel();
    
    public CvFuzzyMeanShiftTracker position(int paramInt)
    {
      return (CvFuzzyMeanShiftTracker)super.position(paramInt);
    }
    
    public native int searchMode();
    
    public native CvFuzzyMeanShiftTracker searchMode(int paramInt);
    
    public native void track(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2);
  }
  
  @NoOffset
  public static class CvFuzzyPoint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFuzzyPoint() {}
    
    public CvFuzzyPoint(double paramDouble1, double paramDouble2)
    {
      allocate(paramDouble1, paramDouble2);
    }
    
    public CvFuzzyPoint(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(double paramDouble1, double paramDouble2);
    
    public native double value();
    
    public native CvFuzzyPoint value(double paramDouble);
    
    public native double x();
    
    public native CvFuzzyPoint x(double paramDouble);
    
    public native double y();
    
    public native CvFuzzyPoint y(double paramDouble);
  }
  
  public static class CvFuzzyRule
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFuzzyRule()
    {
      allocate();
    }
    
    public CvFuzzyRule(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFuzzyRule(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double calcValue(double paramDouble1, double paramDouble2);
    
    public native CvFuzzyCurve getOutputCurve();
    
    public CvFuzzyRule position(int paramInt)
    {
      return (CvFuzzyRule)super.position(paramInt);
    }
    
    public native void setRule(CvFuzzyCurve paramCvFuzzyCurve1, CvFuzzyCurve paramCvFuzzyCurve2, CvFuzzyCurve paramCvFuzzyCurve3);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvHybridTracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHybridTracker()
    {
      allocate();
    }
    
    public CvHybridTracker(Pointer paramPointer)
    {
      super();
    }
    
    public CvHybridTracker(@ByVal opencv_contrib.CvHybridTrackerParams paramCvHybridTrackerParams)
    {
      allocate(paramCvHybridTrackerParams);
    }
    
    private native void allocate();
    
    private native void allocate(@ByVal opencv_contrib.CvHybridTrackerParams paramCvHybridTrackerParams);
    
    @ByVal
    public native opencv_core.CvRect getTrackingWindow();
    
    public native void newTracker(@opencv_core.InputMat opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvRect paramCvRect);
    
    @ByRef
    @MemberGetter
    public native opencv_contrib.CvHybridTrackerParams params();
    
    public native void updateTracker(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvHybridTrackerParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvHybridTrackerParams()
    {
      allocate();
    }
    
    public CvHybridTrackerParams(float paramFloat1, float paramFloat2, @ByVal opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams, @ByVal opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams, @ByVal opencv_contrib.CvMotionModel paramCvMotionModel)
    {
      allocate(paramFloat1, paramFloat2, paramCvFeatureTrackerParams, paramCvMeanShiftTrackerParams, paramCvMotionModel);
    }
    
    public CvHybridTrackerParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2, @ByVal opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams, @ByVal opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams, @ByVal opencv_contrib.CvMotionModel paramCvMotionModel);
    
    @ByRef
    public native opencv_contrib.CvFeatureTrackerParams ft_params();
    
    public native CvHybridTrackerParams ft_params(CvFeatureTrackerParams paramCvFeatureTrackerParams);
    
    public native float ft_tracker_weight();
    
    public native CvHybridTrackerParams ft_tracker_weight(float paramFloat);
    
    public native float low_pass_gain();
    
    public native CvHybridTrackerParams low_pass_gain(float paramFloat);
    
    public native int motion_model();
    
    public native CvHybridTrackerParams motion_model(int paramInt);
    
    public native CvHybridTrackerParams ms_params(CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams);
    
    @ByRef
    public native opencv_contrib.CvMeanShiftTrackerParams ms_params();
    
    public native float ms_tracker_weight();
    
    public native CvHybridTrackerParams ms_tracker_weight(float paramFloat);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvMeanShiftTracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvMeanShiftTracker(Pointer paramPointer)
    {
      super();
    }
    
    public CvMeanShiftTracker(@ByVal opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams)
    {
      allocate(paramCvMeanShiftTrackerParams);
    }
    
    private native void allocate(@ByVal opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams);
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage getHistogramProjection(int paramInt);
    
    @ByVal
    public native opencv_core.CvPoint2D32f getTrackingCenter();
    
    @ByVal
    public native opencv_core.CvBox2D getTrackingEllipse();
    
    @ByVal
    public native opencv_core.CvRect getTrackingWindow();
    
    public native void newTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvRect paramCvRect);
    
    @ByRef
    @MemberGetter
    public native opencv_contrib.CvMeanShiftTrackerParams params();
    
    public native void setTrackingWindow(@ByVal opencv_core.CvRect paramCvRect);
    
    @ByVal
    public native opencv_core.CvBox2D updateTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvMeanShiftTrackerParams
    extends Pointer
  {
    public static final int H = 0;
    public static final int HS = 1;
    public static final int HSV = 2;
    
    static
    {
      Loader.load();
    }
    
    public CvMeanShiftTrackerParams()
    {
      allocate();
    }
    
    public CvMeanShiftTrackerParams(int paramInt, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria)
    {
      allocate(paramInt, paramCvTermCriteria);
    }
    
    public CvMeanShiftTrackerParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
    
    @Const
    @StdVector
    public native FloatPointer h_range();
    
    public native CvMeanShiftTrackerParams h_range(FloatPointer paramFloatPointer);
    
    @Const
    @StdVector
    public native FloatPointer s_range();
    
    public native CvMeanShiftTrackerParams s_range(FloatPointer paramFloatPointer);
    
    public native CvMeanShiftTrackerParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
    
    @ByRef
    public native opencv_core.CvTermCriteria term_crit();
    
    public native int tracking_type();
    
    public native CvMeanShiftTrackerParams tracking_type(int paramInt);
    
    @Const
    @StdVector
    public native FloatPointer v_range();
    
    public native CvMeanShiftTrackerParams v_range(FloatPointer paramFloatPointer);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class CvMotionModel
    extends Pointer
  {
    public static final int EM = 2;
    public static final int KALMAN_FILTER = 1;
    public static final int LOW_PASS_FILTER;
    
    static
    {
      Loader.load();
    }
    
    public CvMotionModel()
    {
      allocate();
    }
    
    public CvMotionModel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native float low_pass_gain();
    
    public native CvMotionModel low_pass_gain(float paramFloat);
  }
  
  @Platform({"linux", "macosx", "android"})
  public static class DetectionBasedTracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DetectionBasedTracker(Pointer paramPointer)
    {
      super();
    }
    
    public DetectionBasedTracker(String paramString, @ByRef Parameters paramParameters)
    {
      allocate(paramString, paramParameters);
    }
    
    private native void allocate(String paramString, @ByRef Parameters paramParameters);
    
    public native void getObjects(@ByRef opencv_contrib.RectIntPairVector paramRectIntPairVector);
    
    public native void getObjects(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect);
    
    @ByRef
    @Const
    public native Parameters getParameters();
    
    public native void process(opencv_core.IplImage paramIplImage);
    
    public native void resetTracking();
    
    public native boolean run();
    
    public native boolean setParameters(@ByRef Parameters paramParameters);
    
    public native void stop();
    
    @NoOffset
    public static class Parameters
      extends Pointer
    {
      static
      {
        Loader.load();
      }
      
      public Parameters()
      {
        allocate();
      }
      
      public Parameters(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int maxObjectSize();
      
      public native Parameters maxObjectSize(int paramInt);
      
      public native int maxTrackLifetime();
      
      public native Parameters maxTrackLifetime(int paramInt);
      
      public native int minDetectionPeriod();
      
      public native Parameters minDetectionPeriod(int paramInt);
      
      public native int minNeighbors();
      
      public native Parameters minNeighbors(int paramInt);
      
      public native int minObjectSize();
      
      public native Parameters minObjectSize(int paramInt);
      
      public native double scaleFactor();
      
      public native Parameters scaleFactor(double paramDouble);
    }
  }
  
  @Namespace("cv")
  public static class Directory
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Directory()
    {
      allocate();
    }
    
    public Directory(Pointer paramPointer)
    {
      super();
    }
    
    @ByVal
    public static native opencv_core.StringVector GetListFiles(String paramString1, String paramString2, boolean paramBoolean);
    
    @ByVal
    public static native opencv_core.StringVector GetListFilesR(String paramString1, String paramString2, boolean paramBoolean);
    
    @ByVal
    public static native opencv_core.StringVector GetListFolders(String paramString1, String paramString2, boolean paramBoolean);
    
    private native void allocate();
  }
  
  @Namespace("cv::of2")
  public static class FabMap
    extends Pointer
  {
    public static final int CHOW_LIU = 8;
    public static final int MEAN_FIELD = 1;
    public static final int MOTION_MODEL = 16;
    public static final int NAIVE_BAYES = 4;
    public static final int SAMPLED = 2;
    
    static
    {
      Loader.load();
    }
    
    protected FabMap() {}
    
    public FabMap(Pointer paramPointer)
    {
      super();
    }
    
    public FabMap(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt);
    }
    
    public FabMap(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt1, paramInt2);
    }
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
    
    public native void add(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native void add(@ByRef opencv_core.MatVector paramMatVector);
    
    public native void addTraining(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native void addTraining(@ByRef opencv_core.MatVector paramMatVector);
    
    public native void compare(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_contrib.IMatch paramIMatch, boolean paramBoolean, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
    
    public native void compare(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_contrib.IMatch paramIMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
    
    public native void compare(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @ByRef opencv_core.MatVector paramMatVector, @StdVector opencv_contrib.IMatch paramIMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
    
    public native void compare(@ByRef opencv_core.MatVector paramMatVector, @StdVector opencv_contrib.IMatch paramIMatch, boolean paramBoolean, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native void compare(@ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_core.MatVector paramMatVector2, @StdVector opencv_contrib.IMatch paramIMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    @ByRef
    @Const
    public native opencv_core.MatVector getTestImgDescriptors();
    
    @ByRef
    @Const
    public native opencv_core.MatVector getTrainingImgDescriptors();
  }
  
  @Namespace("cv::of2")
  public static class FabMap1
    extends FabMap
  {
    static
    {
      Loader.load();
    }
    
    public FabMap1(Pointer paramPointer)
    {
      super();
    }
    
    public FabMap1(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt);
    }
    
    public FabMap1(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt1, paramInt2);
    }
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
  }
  
  @Namespace("cv::of2")
  public static class FabMap2
    extends FabMap
  {
    static
    {
      Loader.load();
    }
    
    public FabMap2(Pointer paramPointer)
    {
      super();
    }
    
    public FabMap2(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt);
    }
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
  }
  
  @Namespace("cv::of2")
  public static class FabMapFBO
    extends FabMap
  {
    static
    {
      Loader.load();
    }
    
    public FabMapFBO(Pointer paramPointer)
    {
      super();
    }
    
    public FabMapFBO(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt);
    }
    
    public FabMapFBO(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, int paramInt3, int paramInt4)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt1, paramInt2, paramDouble3, paramDouble4, paramInt3, paramInt4);
    }
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, int paramInt3, int paramInt4);
  }
  
  @Namespace("cv::of2")
  public static class FabMapLUT
    extends FabMap
  {
    static
    {
      Loader.load();
    }
    
    public FabMapLUT(Pointer paramPointer)
    {
      super();
    }
    
    public FabMapLUT(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt);
    }
    
    public FabMapLUT(opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3)
    {
      allocate(paramCvArr, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt3);
    }
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
    
    private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3);
  }
  
  @Namespace("cv")
  public static class FaceRecognizer
    extends opencv_core.Algorithm
  {
    static
    {
      Loader.load();
    }
    
    public FaceRecognizer() {}
    
    public FaceRecognizer(Pointer paramPointer)
    {
      super();
    }
    
    public native void load(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void load(String paramString);
    
    public native int predict(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
    
    public native void predict(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef int[] paramArrayOfInt, @ByRef double[] paramArrayOfDouble);
    
    public native void save(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void save(String paramString);
    
    public native void train(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray IntPointer paramIntPointer);
    
    public native void train(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr);
    
    public native void train(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray int[] paramArrayOfInt);
    
    public native void update(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray IntPointer paramIntPointer);
    
    public native void update(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr);
    
    public native void update(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray int[] paramArrayOfInt);
  }
  
  @Namespace("cv::of2")
  @NoOffset
  public static class IMatch
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IMatch()
    {
      allocate();
    }
    
    public IMatch(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public IMatch(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
    {
      allocate(paramInt1, paramInt2, paramDouble1, paramDouble2);
    }
    
    public IMatch(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
    
    private native void allocateArray(int paramInt);
    
    @Name({"operator<"})
    public native boolean compare(@ByRef IMatch paramIMatch);
    
    public native int imgIdx();
    
    public native IMatch imgIdx(int paramInt);
    
    public native double likelihood();
    
    public native IMatch likelihood(double paramDouble);
    
    public native double match();
    
    public native IMatch match(double paramDouble);
    
    public IMatch position(int paramInt)
    {
      return (IMatch)super.position(paramInt);
    }
    
    public native int queryIdx();
    
    public native IMatch queryIdx(int paramInt);
  }
  
  @Namespace("cv")
  public static class LDA
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public LDA()
    {
      allocate();
    }
    
    public LDA(int paramInt)
    {
      allocate(paramInt);
    }
    
    public LDA(Pointer paramPointer)
    {
      super();
    }
    
    public LDA(opencv_core.MatVector paramMatVector, IntPointer paramIntPointer, int paramInt)
    {
      allocate(paramMatVector, paramIntPointer, paramInt);
    }
    
    public LDA(opencv_core.MatVector paramMatVector, opencv_core.CvArr paramCvArr, int paramInt)
    {
      allocate(paramMatVector, paramCvArr, paramInt);
    }
    
    public LDA(opencv_core.MatVector paramMatVector, int[] paramArrayOfInt, int paramInt)
    {
      allocate(paramMatVector, paramArrayOfInt, paramInt);
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
    
    private native void allocate(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray IntPointer paramIntPointer, int paramInt);
    
    private native void allocate(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt);
    
    private native void allocate(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray int[] paramArrayOfInt, int paramInt);
    
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.InputArray IntPointer paramIntPointer);
    
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
    
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.InputArray int[] paramArrayOfInt);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat eigenvalues();
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat eigenvectors();
    
    public native void load(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void load(String paramString);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat project(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat reconstruct(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
    
    public native void save(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void save(String paramString);
  }
  
  @Namespace("cv")
  public static class LogPolar_Adjacent
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public LogPolar_Adjacent()
    {
      allocate();
    }
    
    public LogPolar_Adjacent(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, int paramInt5, int paramInt6)
    {
      allocate(paramInt1, paramInt2, paramCvPoint, paramInt3, paramDouble1, paramDouble2, paramInt4, paramInt5, paramInt6);
    }
    
    public LogPolar_Adjacent(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, int paramInt5, int paramInt6);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat to_cartesian(opencv_core.CvMat paramCvMat);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat to_cortical(opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv")
  public static class LogPolar_Interp
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public LogPolar_Interp()
    {
      allocate();
    }
    
    public LogPolar_Interp(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      allocate(paramInt1, paramInt2, paramCvPoint, paramInt3, paramDouble, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    
    public LogPolar_Interp(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat to_cartesian(opencv_core.CvMat paramCvMat);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat to_cortical(opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv")
  public static class LogPolar_Overlapping
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public LogPolar_Overlapping()
    {
      allocate();
    }
    
    public LogPolar_Overlapping(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6)
    {
      allocate(paramInt1, paramInt2, paramCvPoint, paramInt3, paramDouble, paramInt4, paramInt5, paramInt6);
    }
    
    public LogPolar_Overlapping(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat to_cartesian(opencv_core.CvMat paramCvMat);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat to_cortical(opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class Mesh3D
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Mesh3D()
    {
      allocate();
    }
    
    public Mesh3D(Pointer paramPointer)
    {
      super();
    }
    
    public Mesh3D(@ByVal opencv_core.CvPoint3D32f paramCvPoint3D32f)
    {
      allocate(paramCvPoint3D32f);
    }
    
    private native void allocate();
    
    private native void allocate(@Const @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f);
    
    public native void buildOctree();
    
    public native void clearOctree();
    
    public native void computeNormals(float paramFloat, int paramInt);
    
    public native void computeNormals(@Const @StdVector int[] paramArrayOfInt, float paramFloat, int paramInt);
    
    public native float estimateResolution(float paramFloat);
    
    public native Mesh3D normals(@Const opencv_core.CvPoint3D32f paramCvPoint3D32f);
    
    @StdVector("CvPoint3D32f,cv::Point3f")
    public native opencv_core.CvPoint3D32f normals();
    
    public native Mesh3D octree(Octree paramOctree);
    
    @ByRef
    public native opencv_contrib.Octree octree();
    
    public native float resolution();
    
    public native Mesh3D resolution(float paramFloat);
    
    public native Mesh3D vtx(@Const opencv_core.CvPoint3D32f paramCvPoint3D32f);
    
    @StdVector("CvPoint3D32f,cv::Point3f")
    public native opencv_core.CvPoint3D32f vtx();
    
    public native void writeAsVrml(String paramString, @Const @StdVector("CvScalar, cv::Scalar") opencv_core.CvScalar paramCvScalar);
    
    @Opaque
    public static class EmptyMeshException
      extends Pointer
    {
      static
      {
        Loader.load();
      }
      
      public EmptyMeshException() {}
      
      public EmptyMeshException(Pointer paramPointer)
      {
        super();
      }
    }
  }
  
  @Namespace("cv")
  public static class Octree
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Octree()
    {
      allocate();
    }
    
    public Octree(Pointer paramPointer)
    {
      super();
    }
    
    public Octree(opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt1, int paramInt2)
    {
      allocate(paramCvPoint3D32f, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocate(@Const @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt1, int paramInt2);
    
    public native void buildTree(@Const @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt1, int paramInt2);
    
    @StdVector
    public native Node getNodes();
    
    public native void getPointsWithinSphere(@ByVal opencv_core.CvPoint3D32f paramCvPoint3D32f1, float paramFloat, @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f2);
    
    @NoOffset
    public static class Node
      extends Pointer
    {
      static
      {
        Loader.load();
      }
      
      public Node()
      {
        allocate();
      }
      
      public Node(int paramInt)
      {
        allocateArray(paramInt);
      }
      
      public Node(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      private native void allocateArray(int paramInt);
      
      public native int begin();
      
      public native Node begin(int paramInt);
      
      public native int children(int paramInt);
      
      public native Node children(int paramInt1, int paramInt2);
      
      public native int end();
      
      public native Node end(int paramInt);
      
      public native Node isLeaf(boolean paramBoolean);
      
      @Cast({"bool"})
      public native boolean isLeaf();
      
      public native int maxLevels();
      
      public native Node maxLevels(int paramInt);
      
      public Node position(int paramInt)
      {
        return (Node)super.position(paramInt);
      }
      
      public native float x_max();
      
      public native Node x_max(float paramFloat);
      
      public native float x_min();
      
      public native Node x_min(float paramFloat);
      
      public native float y_max();
      
      public native Node y_max(float paramFloat);
      
      public native float y_min();
      
      public native Node y_min(float paramFloat);
      
      public native float z_max();
      
      public native Node z_max(float paramFloat);
      
      public native float z_min();
      
      public native Node z_min(float paramFloat);
    }
  }
  
  @Name({"std::vector<std::pair<cv::Rect, int> >"})
  public static class RectIntPairVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public RectIntPairVector()
    {
      allocate();
    }
    
    public RectIntPairVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public RectIntPairVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(long paramLong);
    
    public native RectIntPairVector first(long paramLong, opencv_core.CvRect paramCvRect);
    
    @Adapter("RectAdapter")
    @Const
    @Index
    public native opencv_core.CvRect first(long paramLong);
    
    @Index
    public native int second(long paramLong);
    
    public native RectIntPairVector second(long paramLong, int paramInt);
  }
  
  @Namespace("cv")
  public static class Retina
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Retina(Pointer paramPointer)
    {
      super();
    }
    
    public Retina(@ByVal opencv_core.CvSize paramCvSize)
    {
      allocate(paramCvSize);
    }
    
    public Retina(@ByVal opencv_core.CvSize paramCvSize, boolean paramBoolean1, @Cast({"cv::RETINA_COLORSAMPLINGMETHOD"}) int paramInt, boolean paramBoolean2, double paramDouble1, double paramDouble2)
    {
      allocate(paramCvSize, paramBoolean1, paramInt, paramBoolean2, paramDouble1, paramDouble2);
    }
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize);
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize, @Cast({"bool"}) boolean paramBoolean1, @Cast({"cv::RETINA_COLORSAMPLINGMETHOD"}) int paramInt, @Cast({"bool"}) boolean paramBoolean2, double paramDouble1, double paramDouble2);
    
    public native void activateContoursProcessing(@Cast({"bool"}) boolean paramBoolean);
    
    public native void activateMovingContoursProcessing(@Cast({"bool"}) boolean paramBoolean);
    
    public native void clearBuffers();
    
    public native void getMagno(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    @ByVal
    public native RetinaParameters getParameters();
    
    public native void getParvo(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    @ByVal
    public native opencv_core.CvSize inputSize();
    
    @ByVal
    public native opencv_core.CvSize outputSize();
    
    @ByRef
    public native String printSetup();
    
    public native void run(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native void setColorSaturation(@Cast({"bool"}) boolean paramBoolean, float paramFloat);
    
    public native void setup(@ByVal RetinaParameters paramRetinaParameters);
    
    public native void setup(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, @Cast({"bool"}) boolean paramBoolean);
    
    public native void setup(String paramString, @Cast({"bool"}) boolean paramBoolean);
    
    public native void setupIPLMagnoChannel(@Cast({"bool"}) boolean paramBoolean, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
    
    public native void setupOPLandIPLParvoChannel(@Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void write(String paramString);
    
    @NoOffset
    public static class RetinaParameters
      extends Pointer
    {
      static
      {
        Loader.load();
      }
      
      public RetinaParameters()
      {
        allocate();
      }
      
      public RetinaParameters(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      @ByRef
      @MemberGetter
      public native IplMagnoParameters IplMagno();
      
      @ByRef
      @MemberGetter
      public native OPLandIplParvoParameters OPLandIplParvo();
      
      @NoOffset
      public static class IplMagnoParameters
        extends Pointer
      {
        static
        {
          Loader.load();
        }
        
        public IplMagnoParameters()
        {
          allocate();
        }
        
        public IplMagnoParameters(Pointer paramPointer)
        {
          super();
        }
        
        private native void allocate();
        
        public native float V0CompressionParameter();
        
        public native IplMagnoParameters V0CompressionParameter(float paramFloat);
        
        public native float amacrinCellsTemporalCutFrequency();
        
        public native IplMagnoParameters amacrinCellsTemporalCutFrequency(float paramFloat);
        
        public native float localAdaptintegration_k();
        
        public native IplMagnoParameters localAdaptintegration_k(float paramFloat);
        
        public native float localAdaptintegration_tau();
        
        public native IplMagnoParameters localAdaptintegration_tau(float paramFloat);
        
        public native IplMagnoParameters normaliseOutput(boolean paramBoolean);
        
        public native boolean normaliseOutput();
        
        public native float parasolCells_beta();
        
        public native IplMagnoParameters parasolCells_beta(float paramFloat);
        
        public native float parasolCells_k();
        
        public native IplMagnoParameters parasolCells_k(float paramFloat);
        
        public native float parasolCells_tau();
        
        public native IplMagnoParameters parasolCells_tau(float paramFloat);
      }
      
      @NoOffset
      public static class OPLandIplParvoParameters
        extends Pointer
      {
        static
        {
          Loader.load();
        }
        
        public OPLandIplParvoParameters()
        {
          allocate();
        }
        
        public OPLandIplParvoParameters(Pointer paramPointer)
        {
          super();
        }
        
        private native void allocate();
        
        public native OPLandIplParvoParameters colorMode(boolean paramBoolean);
        
        public native boolean colorMode();
        
        public native float ganglionCellsSensitivity();
        
        public native OPLandIplParvoParameters ganglionCellsSensitivity(float paramFloat);
        
        public native float hcellsSpatialConstant();
        
        public native OPLandIplParvoParameters hcellsSpatialConstant(float paramFloat);
        
        public native float hcellsTemporalConstant();
        
        public native OPLandIplParvoParameters hcellsTemporalConstant(float paramFloat);
        
        public native float horizontalCellsGain();
        
        public native OPLandIplParvoParameters horizontalCellsGain(float paramFloat);
        
        public native OPLandIplParvoParameters normaliseOutput(boolean paramBoolean);
        
        public native boolean normaliseOutput();
        
        public native float photoreceptorsLocalAdaptationSensitivity();
        
        public native OPLandIplParvoParameters photoreceptorsLocalAdaptationSensitivity(float paramFloat);
        
        public native float photoreceptorsSpatialConstant();
        
        public native OPLandIplParvoParameters photoreceptorsSpatialConstant(float paramFloat);
        
        public native float photoreceptorsTemporalConstant();
        
        public native OPLandIplParvoParameters photoreceptorsTemporalConstant(float paramFloat);
      }
    }
  }
  
  @Namespace("cv")
  @NoOffset
  public static class SelfSimDescriptor
    extends Pointer
  {
    public static final int DEFAULT_LARGE_SIZE = 41;
    public static final int DEFAULT_NUM_ANGLES = 20;
    public static final int DEFAULT_NUM_DISTANCE_BUCKETS = 7;
    public static final int DEFAULT_SMALL_SIZE = 5;
    public static final int DEFAULT_START_DISTANCE_BUCKET = 3;
    
    static
    {
      Loader.load();
    }
    
    public SelfSimDescriptor()
    {
      allocate();
    }
    
    public SelfSimDescriptor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public SelfSimDescriptor(Pointer paramPointer)
    {
      super();
    }
    
    public SelfSimDescriptor(@ByRef SelfSimDescriptor paramSelfSimDescriptor)
    {
      allocate(paramSelfSimDescriptor);
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    private native void allocate(@ByRef SelfSimDescriptor paramSelfSimDescriptor);
    
    public native void SSD(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvPoint paramCvPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
    
    public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint);
    
    public native void computeLogPolarMapping(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
    
    public native long getDescriptorSize();
    
    @ByVal
    public native opencv_core.CvSize getGridSize(@ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
    
    public native int largeSize();
    
    public native SelfSimDescriptor largeSize(int paramInt);
    
    public native int numberOfAngles();
    
    public native SelfSimDescriptor numberOfAngles(int paramInt);
    
    public native int numberOfDistanceBuckets();
    
    public native SelfSimDescriptor numberOfDistanceBuckets(int paramInt);
    
    @ByRef
    @Name({"operator="})
    public native SelfSimDescriptor put(@ByRef SelfSimDescriptor paramSelfSimDescriptor);
    
    public native int smallSize();
    
    public native SelfSimDescriptor smallSize(int paramInt);
    
    public native int startDistanceBucket();
    
    public native SelfSimDescriptor startDistanceBucket(int paramInt);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class SpinImageModel
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SpinImageModel()
    {
      allocate();
    }
    
    public SpinImageModel(Pointer paramPointer)
    {
      super();
    }
    
    public SpinImageModel(Mesh3D paramMesh3D)
    {
      allocate(paramMesh3D);
    }
    
    private native void allocate();
    
    private native void allocate(@ByRef opencv_contrib.Mesh3D paramMesh3D);
    
    public static native boolean spinCorrelation(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, float paramFloat, @ByRef float[] paramArrayOfFloat);
    
    public native float T_GeometriccConsistency();
    
    public native SpinImageModel T_GeometriccConsistency(float paramFloat);
    
    public native float T_GroupingCorespondances();
    
    public native SpinImageModel T_GroupingCorespondances(float paramFloat);
    
    public native float binSize();
    
    public native SpinImageModel binSize(float paramFloat);
    
    public native void compute();
    
    public native float gamma();
    
    public native SpinImageModel gamma(float paramFloat);
    
    @ByRef
    public native opencv_contrib.Mesh3D getMesh();
    
    public native long getSpinCount();
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage getSpinImage(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    public native opencv_core.CvPoint3D32f getSpinNormal(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    public native opencv_core.CvPoint3D32f getSpinVertex(@Cast({"size_t"}) long paramLong);
    
    public native int imageWidth();
    
    public native SpinImageModel imageWidth(int paramInt);
    
    public native float lambda();
    
    public native SpinImageModel lambda(float paramFloat);
    
    public native void match(@ByRef SpinImageModel paramSpinImageModel, @ByRef opencv_contrib.Vec2iVectorVector paramVec2iVectorVector);
    
    public native int minNeighbors();
    
    public native SpinImageModel minNeighbors(int paramInt);
    
    public native float normalRadius();
    
    public native SpinImageModel normalRadius(float paramFloat);
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage packRandomScaledSpins(@Cast({"bool"}) boolean paramBoolean, @Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native void selectRandomSubset(float paramFloat);
    
    public native void setLogger(@Cast({"std::ostream*"}) Pointer paramPointer);
    
    public native void setSubset(@Const @StdVector int[] paramArrayOfInt);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class StereoVar
    extends Pointer
  {
    public static final int CYCLE_O = 0;
    public static final int CYCLE_V = 1;
    public static final int PENALIZATION_CHARBONNIER = 1;
    public static final int PENALIZATION_PERONA_MALIK = 2;
    public static final int PENALIZATION_TICHONOV = 0;
    public static final int USE_AUTO_PARAMS = 8;
    public static final int USE_EQUALIZE_HIST = 2;
    public static final int USE_INITIAL_DISPARITY = 1;
    public static final int USE_MEDIAN_FILTERING = 16;
    public static final int USE_SMART_ID = 4;
    
    static
    {
      Loader.load();
    }
    
    public StereoVar()
    {
      allocate();
    }
    
    public StereoVar(int paramInt1, double paramDouble1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble2, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8)
    {
      allocate(paramInt1, paramDouble1, paramInt2, paramInt3, paramInt4, paramInt5, paramDouble2, paramFloat1, paramFloat2, paramInt6, paramInt7, paramInt8);
    }
    
    public StereoVar(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, double paramDouble1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble2, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8);
    
    @Name({"operator()"})
    public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
    
    public native int cycle();
    
    public native StereoVar cycle(int paramInt);
    
    public native float fi();
    
    public native StereoVar fi(float paramFloat);
    
    public native int flags();
    
    public native StereoVar flags(int paramInt);
    
    public native float lambda();
    
    public native StereoVar lambda(float paramFloat);
    
    public native int levels();
    
    public native StereoVar levels(int paramInt);
    
    public native int maxDisp();
    
    public native StereoVar maxDisp(int paramInt);
    
    public native int minDisp();
    
    public native StereoVar minDisp(int paramInt);
    
    public native int nIt();
    
    public native StereoVar nIt(int paramInt);
    
    public native int penalization();
    
    public native StereoVar penalization(int paramInt);
    
    public native int poly_n();
    
    public native StereoVar poly_n(int paramInt);
    
    public native double poly_sigma();
    
    public native StereoVar poly_sigma(double paramDouble);
    
    public native double pyrScale();
    
    public native StereoVar pyrScale(double paramDouble);
  }
  
  @Namespace("cv")
  public static class TickMeter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public TickMeter()
    {
      allocate();
    }
    
    public TickMeter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native long getCounter();
    
    public native double getTimeMicro();
    
    public native double getTimeMilli();
    
    public native double getTimeSec();
    
    public native long getTimeTicks();
    
    public native void reset();
    
    public native void start();
    
    public native void stop();
  }
  
  @Name({"std::vector<std::vector<cv::Vec2i> >"})
  public static class Vec2iVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Vec2iVectorVector()
    {
      allocate();
    }
    
    public Vec2iVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public Vec2iVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    @Index
    @ValueGetter
    public native opencv_core.CvScalar get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_contrib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */