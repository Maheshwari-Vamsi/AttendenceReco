package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@Platform(include={"<opencv2/videostab/videostab.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_videostab@.2.4", "opencv_gpu@.2.4", "opencv_legacy@.2.4", "opencv_ml@.2.4", "opencv_video@.2.4", "opencv_nonfree@.2.4", "opencv_photo@.2.4", "opencv_objdetect@.2.4", "opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_calib3d@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @Platform(link={"opencv_videostab", "opencv_legacy", "opencv_ml", "opencv_video", "opencv_nonfree", "opencv_photo", "opencv_objdetect", "opencv_features2d", "opencv_flann", "opencv_calib3d", "opencv_highgui", "opencv_imgproc", "opencv_core"}, value={"android"}), @Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_videostab245", "opencv_gpu245", "opencv_legacy245", "opencv_ml245", "opencv_video245", "opencv_nonfree245", "opencv_photo245", "opencv_objdetect245", "opencv_features2d245", "opencv_flann245", "opencv_calib3d245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_videostab
{
  public static final int AFFINE = 3;
  public static final int LINEAR_SIMILARITY = 2;
  public static final int TRANSLATION = 0;
  public static final int TRANSLATION_AND_SCALE = 1;
  
  static
  {
    Loader.load(opencv_calib3d.class);
    Loader.load(opencv_features2d.class);
    Loader.load(opencv_objdetect.class);
    Loader.load(opencv_photo.class);
    Loader.load(opencv_nonfree.class);
    Loader.load(opencv_video.class);
    Loader.load(opencv_ml.class);
    Loader.load(opencv_legacy.class);
    Loader.load();
  }
  
  @Namespace("cv::videostab")
  public static native float calcBlurriness(opencv_core.IplImage paramIplImage);
  
  @Namespace("cv::videostab")
  public static native void calcFlowMask(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, float paramFloat, opencv_core.IplImage paramIplImage4, opencv_core.IplImage paramIplImage5, @opencv_core.InputMat opencv_core.IplImage paramIplImage6);
  
  @Name({"dynamic_cast<cv::videostab::IDenseOptFlowEstimator*>"})
  @Platform(not={"android"})
  public static native IDenseOptFlowEstimator castIDenseOptFlowEstimator(DensePyrLkOptFlowEstimatorGpu paramDensePyrLkOptFlowEstimatorGpu);
  
  @Name({"dynamic_cast<cv::videostab::IFrameSource*>"})
  public static native IFrameSource castIFrameSource(OnePassStabilizer paramOnePassStabilizer);
  
  @Name({"dynamic_cast<cv::videostab::IFrameSource*>"})
  public static native IFrameSource castIFrameSource(TwoPassStabilizer paramTwoPassStabilizer);
  
  @Name({"dynamic_cast<cv::videostab::ISparseOptFlowEstimator*>"})
  public static native ISparseOptFlowEstimator castISparseOptFlowEstimator(SparsePyrLkOptFlowEstimator paramSparsePyrLkOptFlowEstimator);
  
  @Name({"dynamic_cast<cv::videostab::PyrLkOptFlowEstimatorBase*>"})
  @Platform(not={"android"})
  public static native PyrLkOptFlowEstimatorBase castPyrLkOptFlowEstimatorBase(DensePyrLkOptFlowEstimatorGpu paramDensePyrLkOptFlowEstimatorGpu);
  
  @Name({"dynamic_cast<cv::videostab::PyrLkOptFlowEstimatorBase*>"})
  public static native PyrLkOptFlowEstimatorBase castPyrLkOptFlowEstimatorBase(SparsePyrLkOptFlowEstimator paramSparsePyrLkOptFlowEstimator);
  
  @Name({"dynamic_cast<cv::videostab::StabilizerBase*>"})
  public static native StabilizerBase castStabilizerBase(OnePassStabilizer paramOnePassStabilizer);
  
  @Name({"dynamic_cast<cv::videostab::StabilizerBase*>"})
  public static native StabilizerBase castStabilizerBase(TwoPassStabilizer paramTwoPassStabilizer);
  
  @Namespace("cv::videostab")
  public static native void completeFrameAccordingToFlow(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, opencv_core.IplImage paramIplImage4, opencv_core.IplImage paramIplImage5, float paramFloat, @opencv_core.InputMat opencv_core.IplImage paramIplImage6, @opencv_core.InputMat opencv_core.IplImage paramIplImage7);
  
  @Namespace("cv::videostab")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat ensureInclusionConstraint(opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize, float paramFloat);
  
  @Namespace("cv::videostab")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat estimateGlobalMotionLeastSquares(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f1, @Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt, float[] paramArrayOfFloat);
  
  @Namespace("cv::videostab")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat estimateGlobalMotionRobust(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f1, @Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt, @ByRef RansacParams paramRansacParams, float[] paramArrayOfFloat, int[] paramArrayOfInt);
  
  @Namespace("cv::videostab")
  public static native float estimateOptimalTrimRatio(opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize);
  
  @Namespace("cv::videostab")
  @opencv_core.OutputMat
  public static native opencv_core.CvMat getMotion(int paramInt1, int paramInt2, @ByRef opencv_core.MatVector paramMatVector);
  
  @Namespace("cv::videostab")
  public static class ColorAverageInpainter
    extends InpainterBase
  {
    static
    {
      Loader.load();
    }
    
    public ColorAverageInpainter()
    {
      allocate();
    }
    
    public ColorAverageInpainter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::videostab")
  public static class ColorInpainter
    extends InpainterBase
  {
    static
    {
      Loader.load();
    }
    
    public ColorInpainter()
    {
      allocate();
    }
    
    public ColorInpainter(int paramInt, double paramDouble)
    {
      allocate(paramInt, paramDouble);
    }
    
    public ColorInpainter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, double paramDouble);
  }
  
  @Namespace("cv::videostab")
  public static class ConsistentMosaicInpainter
    extends InpainterBase
  {
    static
    {
      Loader.load();
    }
    
    public ConsistentMosaicInpainter()
    {
      allocate();
    }
    
    public ConsistentMosaicInpainter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void setStdevThresh(float paramFloat);
    
    public native float stdevThresh();
  }
  
  @Namespace("cv::videostab")
  public static class DeblurerBase
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DeblurerBase() {}
    
    public DeblurerBase(Pointer paramPointer)
    {
      super();
    }
    
    @StdVector
    public native FloatPointer blurrinessRates();
    
    public native void deblur(int paramInt, @opencv_core.InputMat opencv_core.IplImage paramIplImage);
    
    @ByRef
    @Const
    public native opencv_core.MatVector frames();
    
    @ByRef
    @Const
    public native opencv_core.MatVector motions();
    
    public native int radius();
    
    public native void setBlurrinessRates(@Const @StdVector FloatPointer paramFloatPointer);
    
    public native void setFrames(@ByRef @Const opencv_core.MatVector paramMatVector);
    
    public native void setMotions(@ByRef @Const opencv_core.MatVector paramMatVector);
    
    public native void setRadius(int paramInt);
    
    public native void update();
  }
  
  @Namespace("cv::videostab")
  @Platform(not={"android"})
  public static class DensePyrLkOptFlowEstimatorGpu
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DensePyrLkOptFlowEstimatorGpu()
    {
      allocate();
    }
    
    public DensePyrLkOptFlowEstimatorGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public IDenseOptFlowEstimator getIDenseOptFlowEstimator()
    {
      return opencv_videostab.castIDenseOptFlowEstimator(this);
    }
    
    public PyrLkOptFlowEstimatorBase getPyrLkOptFlowEstimatorBase()
    {
      return opencv_videostab.castPyrLkOptFlowEstimatorBase(this);
    }
    
    public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5);
  }
  
  @Namespace("cv::videostab")
  public static class GaussianMotionFilter
    extends MotionFilterBase
  {
    static
    {
      Loader.load();
    }
    
    public GaussianMotionFilter()
    {
      allocate();
    }
    
    public GaussianMotionFilter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void setStdev(float paramFloat);
    
    public native float stdev();
  }
  
  @Namespace("cv::videostab")
  public static class IDenseOptFlowEstimator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IDenseOptFlowEstimator() {}
    
    public IDenseOptFlowEstimator(Pointer paramPointer)
    {
      super();
    }
    
    public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5);
  }
  
  @Namespace("cv::videostab")
  public static class IFrameSource
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IFrameSource() {}
    
    public IFrameSource(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage nextFrame();
    
    public native void reset();
  }
  
  @Namespace("cv::videostab")
  public static class IGlobalMotionEstimator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IGlobalMotionEstimator() {}
    
    public IGlobalMotionEstimator(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat estimate(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  }
  
  @Namespace("cv::videostab")
  public static class ILog
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ILog() {}
    
    public ILog(Pointer paramPointer)
    {
      super();
    }
    
    public native void print(String paramString);
  }
  
  @Namespace("cv::videostab")
  public static class IMotionStabilizer
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IMotionStabilizer() {}
    
    public IMotionStabilizer(Pointer paramPointer)
    {
      super();
    }
    
    public native void stabilize(@opencv_core.InputMat opencv_core.CvMat paramCvMat1, int paramInt, @opencv_core.InputMat opencv_core.CvMat paramCvMat2);
  }
  
  @Namespace("cv::videostab")
  public static class ISparseOptFlowEstimator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ISparseOptFlowEstimator() {}
    
    public ISparseOptFlowEstimator(Pointer paramPointer)
    {
      super();
    }
    
    public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5, @opencv_core.InputArray opencv_core.CvArr paramCvArr6);
  }
  
  @Namespace("cv::videostab")
  public static class InpainterBase
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public InpainterBase() {}
    
    public InpainterBase(Pointer paramPointer)
    {
      super();
    }
    
    @ByRef
    @Const
    public native opencv_core.MatVector frames();
    
    public native void inpaint(int paramInt, @opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
    
    @ByRef
    @Const
    public native opencv_core.MatVector motions();
    
    public native int radius();
    
    public native void setFrames(@ByRef @Const opencv_core.MatVector paramMatVector);
    
    public native void setMotions(@ByRef @Const opencv_core.MatVector paramMatVector);
    
    public native void setRadius(int paramInt);
    
    public native void setStabilizationMotions(@ByRef @Const opencv_core.MatVector paramMatVector);
    
    public native void setStabilizedFrames(@ByRef @Const opencv_core.MatVector paramMatVector);
    
    @ByRef
    @Const
    public native opencv_core.MatVector stabilizationMotions();
    
    @ByRef
    @Const
    public native opencv_core.MatVector stabilizedFrames();
    
    public native void update();
  }
  
  @Namespace("cv::videostab")
  public static class InpaintingPipeline
    extends InpainterBase
  {
    static
    {
      Loader.load();
    }
    
    public InpaintingPipeline()
    {
      allocate();
    }
    
    public InpaintingPipeline(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Cast({"bool"})
    public native boolean empty();
    
    public native void pushBack(@opencv_core.Ptr InpainterBase paramInpainterBase);
  }
  
  @Namespace("cv::videostab")
  public static class LogToStdout
    extends ILog
  {
    static
    {
      Loader.load();
    }
    
    public LogToStdout()
    {
      allocate();
    }
    
    public LogToStdout(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::videostab")
  public static class MotionFilterBase
    extends IMotionStabilizer
  {
    static
    {
      Loader.load();
    }
    
    public MotionFilterBase() {}
    
    public MotionFilterBase(Pointer paramPointer)
    {
      super();
    }
    
    public native int radius();
    
    public native void setRadius(int paramInt);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat stabilize(int paramInt1, @opencv_core.InputMat opencv_core.CvMat paramCvMat, int paramInt2);
    
    public native void update();
  }
  
  @Namespace("cv::videostab")
  public static class MotionInpainter
    extends InpainterBase
  {
    static
    {
      Loader.load();
    }
    
    public MotionInpainter()
    {
      allocate();
    }
    
    public MotionInpainter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int borderMode();
    
    public native float distThresh();
    
    public native float flowErrorThreshold();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.IDenseOptFlowEstimator optFlowEstimator();
    
    public native void setBorderMode(int paramInt);
    
    public native void setDistThreshold(float paramFloat);
    
    public native void setFlowErrorThreshold(float paramFloat);
    
    public native void setOptFlowEstimator(@opencv_core.Ptr IDenseOptFlowEstimator paramIDenseOptFlowEstimator);
  }
  
  @Namespace("cv::videostab")
  public static class NullDeblurer
    extends DeblurerBase
  {
    static
    {
      Loader.load();
    }
    
    public NullDeblurer()
    {
      allocate();
    }
    
    public NullDeblurer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::videostab")
  public static class NullFrameSource
    extends IFrameSource
  {
    static
    {
      Loader.load();
    }
    
    public NullFrameSource()
    {
      allocate();
    }
    
    public NullFrameSource(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::videostab")
  public static class NullInpainter
    extends InpainterBase
  {
    static
    {
      Loader.load();
    }
    
    public NullInpainter()
    {
      allocate();
    }
    
    public NullInpainter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::videostab")
  public static class NullLog
    extends ILog
  {
    static
    {
      Loader.load();
    }
    
    public NullLog()
    {
      allocate();
    }
    
    public NullLog(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::videostab")
  public static class OnePassStabilizer
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public OnePassStabilizer()
    {
      allocate();
    }
    
    public OnePassStabilizer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public IFrameSource getIFrameSource()
    {
      return opencv_videostab.castIFrameSource(this);
    }
    
    public StabilizerBase getStabilizerBase()
    {
      return opencv_videostab.castStabilizerBase(this);
    }
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.MotionFilterBase motionFilter();
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage nextFrame();
    
    public native void reset();
    
    public native void setMotionFilter(@opencv_core.Ptr MotionFilterBase paramMotionFilterBase);
  }
  
  @Namespace("cv::videostab")
  public static class PyrLkOptFlowEstimatorBase
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public PyrLkOptFlowEstimatorBase()
    {
      allocate();
    }
    
    public PyrLkOptFlowEstimatorBase(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int maxLevel();
    
    public native void setMaxLevel(int paramInt);
    
    public native void setWinSize(@ByVal opencv_core.CvSize paramCvSize);
    
    @ByVal
    @Const
    public native opencv_core.CvSize winSize();
  }
  
  @Namespace("cv::videostab")
  public static class PyrLkRobustMotionEstimator
    extends IGlobalMotionEstimator
  {
    static
    {
      Loader.load();
    }
    
    public PyrLkRobustMotionEstimator()
    {
      allocate();
    }
    
    public PyrLkRobustMotionEstimator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Const
    @opencv_core.Ptr
    public native opencv_features2d.FeatureDetector detector();
    
    public native float maxRmse();
    
    public native float minInlierRatio();
    
    @Cast({"cv::videostab::MotionModel"})
    public native int motionModel();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.ISparseOptFlowEstimator optFlowEstimator();
    
    @ByVal
    public native opencv_videostab.RansacParams ransacParams();
    
    public native void setDetector(@opencv_core.Ptr opencv_features2d.FeatureDetector paramFeatureDetector);
    
    public native void setMaxRmse(float paramFloat);
    
    public native void setMinInlierRatio(float paramFloat);
    
    public native void setMotionModel(@Cast({"cv::videostab::MotionModel"}) int paramInt);
    
    public native void setOptFlowEstimator(@opencv_core.Ptr ISparseOptFlowEstimator paramISparseOptFlowEstimator);
    
    public native void setRansacParams(@ByRef opencv_videostab.RansacParams paramRansacParams);
  }
  
  @Namespace("cv::videostab")
  @NoOffset
  public static class RansacParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public RansacParams(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      allocate(paramInt, paramFloat1, paramFloat2, paramFloat3);
    }
    
    public RansacParams(Pointer paramPointer)
    {
      super();
    }
    
    static RansacParams affine2dMotionStd()
    {
      return new RansacParams(6, 0.5F, 0.5F, 0.99F);
    }
    
    private native void allocate(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
    
    static RansacParams linearSimilarityMotionStd()
    {
      return new RansacParams(4, 0.5F, 0.5F, 0.99F);
    }
    
    static RansacParams translationAndScale2dMotionStd()
    {
      return new RansacParams(3, 0.5F, 0.5F, 0.99F);
    }
    
    static RansacParams translationMotionStd()
    {
      return new RansacParams(2, 0.5F, 0.5F, 0.99F);
    }
    
    public native float eps();
    
    public native RansacParams eps(float paramFloat);
    
    public native float prob();
    
    public native RansacParams prob(float paramFloat);
    
    public native int size();
    
    public native RansacParams size(int paramInt);
    
    public native float thresh();
    
    public native RansacParams thresh(float paramFloat);
  }
  
  @Namespace("cv::videostab")
  public static class SparsePyrLkOptFlowEstimator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SparsePyrLkOptFlowEstimator()
    {
      allocate();
    }
    
    public SparsePyrLkOptFlowEstimator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public ISparseOptFlowEstimator getISparseOptFlowEstimator()
    {
      return opencv_videostab.castISparseOptFlowEstimator(this);
    }
    
    public PyrLkOptFlowEstimatorBase getPyrLkOptFlowEstimatorBase()
    {
      return opencv_videostab.castPyrLkOptFlowEstimatorBase(this);
    }
    
    public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5, @opencv_core.InputArray opencv_core.CvArr paramCvArr6);
  }
  
  @Namespace("cv::videostab")
  public static class StabilizerBase
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public StabilizerBase() {}
    
    public StabilizerBase(Pointer paramPointer)
    {
      super();
    }
    
    public native int borderMode();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.DeblurerBase deblurrer();
    
    @Cast({"bool"})
    public native boolean doCorrectionForInclusion();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.IFrameSource frameSource();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.InpainterBase inpainter();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.ILog log();
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.IGlobalMotionEstimator motionEstimator();
    
    public native int radius();
    
    public native void setBorderMode(int paramInt);
    
    public native void setCorrectionForInclusion(@Cast({"bool"}) boolean paramBoolean);
    
    public native void setDeblurer(@opencv_core.Ptr DeblurerBase paramDeblurerBase);
    
    public native void setFrameSource(@opencv_core.Ptr IFrameSource paramIFrameSource);
    
    public native void setInpainter(@opencv_core.Ptr InpainterBase paramInpainterBase);
    
    public native void setLog(@opencv_core.Ptr ILog paramILog);
    
    public native void setMotionEstimator(@opencv_core.Ptr IGlobalMotionEstimator paramIGlobalMotionEstimator);
    
    public native void setRadius(int paramInt);
    
    public native void setTrimRatio(float paramFloat);
    
    public native float trimRatio();
  }
  
  @Namespace("cv::videostab")
  public static class TwoPassStabilizer
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public TwoPassStabilizer()
    {
      allocate();
    }
    
    public TwoPassStabilizer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public IFrameSource getIFrameSource()
    {
      return opencv_videostab.castIFrameSource(this);
    }
    
    public StabilizerBase getStabilizerBase()
    {
      return opencv_videostab.castStabilizerBase(this);
    }
    
    @Const
    @opencv_core.Ptr
    public native opencv_videostab.IMotionStabilizer motionStabilizer();
    
    @ByVal
    public native opencv_core.MatVector motions();
    
    @Cast({"bool"})
    public native boolean mustEstimateTrimaRatio();
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage nextFrame();
    
    public native void reset();
    
    public native void setEstimateTrimRatio(@Cast({"bool"}) boolean paramBoolean);
    
    public native void setMotionStabilizer(@opencv_core.Ptr IMotionStabilizer paramIMotionStabilizer);
  }
  
  @Namespace("cv::videostab")
  public static class VideoFileSource
    extends IFrameSource
  {
    static
    {
      Loader.load();
    }
    
    public VideoFileSource(Pointer paramPointer)
    {
      super();
    }
    
    public VideoFileSource(String paramString)
    {
      allocate(paramString);
    }
    
    public VideoFileSource(String paramString, @Cast({"bool"}) boolean paramBoolean)
    {
      allocate(paramString, paramBoolean);
    }
    
    private native void allocate(String paramString);
    
    private native void allocate(String paramString, @Cast({"bool"}) boolean paramBoolean);
    
    public native double fps();
    
    public native int frameCount();
  }
  
  @Namespace("cv::videostab")
  public static class WeightingDeblurer
    extends DeblurerBase
  {
    static
    {
      Loader.load();
    }
    
    public WeightingDeblurer()
    {
      allocate();
    }
    
    public WeightingDeblurer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native float sensitivity();
    
    public native void setSensitivity(float paramFloat);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_videostab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */