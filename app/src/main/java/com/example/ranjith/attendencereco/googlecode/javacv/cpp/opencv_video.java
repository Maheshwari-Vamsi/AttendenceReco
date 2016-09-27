package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.Pointer.Deallocator;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/video/video.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_video@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_video245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_video
{
  public static final int CV_LKFLOW_GET_MIN_EIGENVALS = 8;
  public static final int CV_LKFLOW_INITIAL_GUESSES = 4;
  public static final int CV_LKFLOW_PYR_A_READY = 1;
  public static final int CV_LKFLOW_PYR_B_READY = 2;
  public static final int OPTFLOW_FARNEBACK_GAUSSIAN = 256;
  public static final int OPTFLOW_LK_GET_MIN_EIGENVALS = 8;
  public static final int OPTFLOW_USE_INITIAL_FLOW = 4;
  
  static
  {
    Loader.load(opencv_imgproc.class);
    if (Loader.load() != null) {
      initModule_video();
    }
  }
  
  @Namespace("cv")
  public static native int buildOpticalFlowPyramid(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.IplImageArray paramIplImageArray, @ByVal opencv_core.CvSize paramCvSize, int paramInt1, @Cast({"bool"}) boolean paramBoolean1, int paramInt2, int paramInt3, @Cast({"bool"}) boolean paramBoolean2);
  
  @Namespace("cv")
  public static native void calcOpticalFlowFarneback(@opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray1, @opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray2, @opencv_core.InputArray opencv_core.CvArr paramCvArr, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble2, int paramInt5);
  
  @Namespace("cv")
  public static native void calcOpticalFlowPyrLK(@opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray1, @opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray2, @opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @ByVal opencv_core.CvSize paramCvSize, int paramInt1, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt2, double paramDouble);
  
  @Namespace("cv")
  public static native void calcOpticalFlowSF(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, int paramInt1, int paramInt2, int paramInt3);
  
  @Namespace("cv")
  public static native void calcOpticalFlowSF(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt5, double paramDouble6, double paramDouble7, double paramDouble8);
  
  @Namespace("cv")
  @opencv_core.Ptr
  public static native DenseOpticalFlow createOptFlow_DualTVL1();
  
  public static native void cvCalcAffineFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, FloatPointer paramFloatPointer1, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, FloatPointer paramFloatPointer2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
  
  public static native void cvCalcAffineFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, float[] paramArrayOfFloat1, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, float[] paramArrayOfFloat2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
  
  public static native double cvCalcGlobalOrientation(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble1, double paramDouble2);
  
  public static native void cvCalcMotionGradient(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble1, double paramDouble2, int paramInt);
  
  public static native void cvCalcOpticalFlowFarneback(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble2, int paramInt5);
  
  public static native void cvCalcOpticalFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, FloatPointer paramFloatPointer, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
  
  public static native void cvCalcOpticalFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, float[] paramArrayOfFloat, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
  
  public static native int cvCamShift(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvRect paramCvRect, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_imgproc.CvConnectedComp paramCvConnectedComp, opencv_core.CvBox2D paramCvBox2D);
  
  public static native CvKalman cvCreateKalman(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int cvEstimateRigidTransform(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, int paramInt);
  
  @Const
  public static native opencv_core.CvMat cvKalmanCorrect(CvKalman paramCvKalman, opencv_core.CvMat paramCvMat);
  
  @Const
  public static native opencv_core.CvMat cvKalmanPredict(CvKalman paramCvKalman, opencv_core.CvMat paramCvMat);
  
  public static opencv_core.CvMat cvKalmanUpdateByMeasurement(CvKalman paramCvKalman, opencv_core.CvMat paramCvMat)
  {
    return cvKalmanCorrect(paramCvKalman, paramCvMat);
  }
  
  public static opencv_core.CvMat cvKalmanUpdateByTime(CvKalman paramCvKalman, opencv_core.CvMat paramCvMat)
  {
    return cvKalmanPredict(paramCvKalman, paramCvMat);
  }
  
  public static native int cvMeanShift(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvRect paramCvRect, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_imgproc.CvConnectedComp paramCvConnectedComp);
  
  public static native void cvReleaseKalman(@ByPtrPtr CvKalman paramCvKalman);
  
  public static native opencv_core.CvSeq cvSegmentMotion(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble1, double paramDouble2);
  
  public static native void cvUpdateMotionHistory(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2);
  
  @Namespace("cv")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat estimateRigidTransform(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, boolean paramBoolean);
  
  @Cast({"bool"})
  @Namespace("cv")
  public static native boolean initModule_video();
  
  @Namespace("cv")
  public static class BackgroundSubtractor
    extends opencv_core.Algorithm
  {
    static
    {
      Loader.load();
    }
    
    public BackgroundSubtractor() {}
    
    public BackgroundSubtractor(Pointer paramPointer)
    {
      super();
    }
    
    @Name({"operator()"})
    public native void apply(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, double paramDouble);
    
    public native void getBackgroundImage(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class BackgroundSubtractorGMG
    extends BackgroundSubtractor
  {
    static
    {
      Loader.load();
    }
    
    public BackgroundSubtractorGMG()
    {
      allocate();
    }
    
    public BackgroundSubtractorGMG(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native double backgroundPrior();
    
    public native BackgroundSubtractorGMG backgroundPrior(double paramDouble);
    
    public native double decisionThreshold();
    
    public native BackgroundSubtractorGMG decisionThreshold(double paramDouble);
    
    public native void initialize(@ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2);
    
    public native double learningRate();
    
    public native BackgroundSubtractorGMG learningRate(double paramDouble);
    
    public native int maxFeatures();
    
    public native BackgroundSubtractorGMG maxFeatures(int paramInt);
    
    public native int numInitializationFrames();
    
    public native BackgroundSubtractorGMG numInitializationFrames(int paramInt);
    
    public native int quantizationLevels();
    
    public native BackgroundSubtractorGMG quantizationLevels(int paramInt);
    
    public native void release();
    
    public native int smoothingRadius();
    
    public native BackgroundSubtractorGMG smoothingRadius(int paramInt);
    
    public native BackgroundSubtractorGMG updateBackgroundModel(boolean paramBoolean);
    
    public native boolean updateBackgroundModel();
  }
  
  @Namespace("cv")
  @NoOffset
  public static class BackgroundSubtractorMOG
    extends BackgroundSubtractor
  {
    static
    {
      Loader.load();
    }
    
    public BackgroundSubtractorMOG()
    {
      allocate();
    }
    
    public BackgroundSubtractorMOG(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
    {
      allocate(paramInt1, paramInt2, paramDouble1, paramDouble2);
    }
    
    public BackgroundSubtractorMOG(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
    
    public native void initialize(@ByVal opencv_core.CvSize paramCvSize, int paramInt);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class BackgroundSubtractorMOG2
    extends BackgroundSubtractor
  {
    static
    {
      Loader.load();
    }
    
    public BackgroundSubtractorMOG2()
    {
      allocate();
    }
    
    public BackgroundSubtractorMOG2(int paramInt, float paramFloat, boolean paramBoolean)
    {
      allocate(paramInt, paramFloat, paramBoolean);
    }
    
    public BackgroundSubtractorMOG2(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, float paramFloat, boolean paramBoolean);
    
    public native void initialize(@ByVal opencv_core.CvSize paramCvSize, int paramInt);
  }
  
  public static class CvKalman
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvKalman()
    {
      allocate();
      zero();
    }
    
    public CvKalman(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvKalman(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvKalman create(int paramInt1, int paramInt2, int paramInt3)
    {
      CvKalman localCvKalman = opencv_video.cvCreateKalman(paramInt1, paramInt2, paramInt3);
      if (localCvKalman != null) {
        localCvKalman.deallocator(new ReleaseDeallocator(localCvKalman));
      }
      return localCvKalman;
    }
    
    public native int CP();
    
    public native CvKalman CP(int paramInt);
    
    public native int DP();
    
    public native CvKalman DP(int paramInt);
    
    public native FloatPointer DynamMatr();
    
    public native CvKalman DynamMatr(FloatPointer paramFloatPointer);
    
    public native FloatPointer KalmGainMatr();
    
    public native CvKalman KalmGainMatr(FloatPointer paramFloatPointer);
    
    public native FloatPointer MNCovariance();
    
    public native CvKalman MNCovariance(FloatPointer paramFloatPointer);
    
    public native int MP();
    
    public native CvKalman MP(int paramInt);
    
    public native FloatPointer MeasurementMatr();
    
    public native CvKalman MeasurementMatr(FloatPointer paramFloatPointer);
    
    public native FloatPointer PNCovariance();
    
    public native CvKalman PNCovariance(FloatPointer paramFloatPointer);
    
    public native FloatPointer PosterErrorCovariance();
    
    public native CvKalman PosterErrorCovariance(FloatPointer paramFloatPointer);
    
    public native FloatPointer PosterState();
    
    public native CvKalman PosterState(FloatPointer paramFloatPointer);
    
    public native FloatPointer PriorErrorCovariance();
    
    public native CvKalman PriorErrorCovariance(FloatPointer paramFloatPointer);
    
    public native FloatPointer PriorState();
    
    public native CvKalman PriorState(FloatPointer paramFloatPointer);
    
    public native FloatPointer Temp1();
    
    public native CvKalman Temp1(FloatPointer paramFloatPointer);
    
    public native FloatPointer Temp2();
    
    public native CvKalman Temp2(FloatPointer paramFloatPointer);
    
    public native opencv_core.CvMat control_matrix();
    
    public native CvKalman control_matrix(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat error_cov_post();
    
    public native CvKalman error_cov_post(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat error_cov_pre();
    
    public native CvKalman error_cov_pre(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat gain();
    
    public native CvKalman gain(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat measurement_matrix();
    
    public native CvKalman measurement_matrix(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat measurement_noise_cov();
    
    public native CvKalman measurement_noise_cov(opencv_core.CvMat paramCvMat);
    
    public CvKalman position(int paramInt)
    {
      return (CvKalman)super.position(paramInt);
    }
    
    public native opencv_core.CvMat process_noise_cov();
    
    public native CvKalman process_noise_cov(opencv_core.CvMat paramCvMat);
    
    public void release()
    {
      deallocate();
    }
    
    public native opencv_core.CvMat state_post();
    
    public native CvKalman state_post(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat state_pre();
    
    public native CvKalman state_pre(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat temp1();
    
    public native CvKalman temp1(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat temp2();
    
    public native CvKalman temp2(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat temp3();
    
    public native CvKalman temp3(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat temp4();
    
    public native CvKalman temp4(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat temp5();
    
    public native CvKalman temp5(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat transition_matrix();
    
    public native CvKalman transition_matrix(opencv_core.CvMat paramCvMat);
    
    static class ReleaseDeallocator
      extends CvKalman
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvKalman paramCvKalman)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_video.cvReleaseKalman(this);
      }
    }
  }
  
  @Namespace("cv")
  public static class DenseOpticalFlow
    extends opencv_core.Algorithm
  {
    static
    {
      Loader.load();
    }
    
    public DenseOpticalFlow() {}
    
    public DenseOpticalFlow(Pointer paramPointer)
    {
      super();
    }
    
    public native void calc(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
    
    public native void collectGarbage();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_video.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */