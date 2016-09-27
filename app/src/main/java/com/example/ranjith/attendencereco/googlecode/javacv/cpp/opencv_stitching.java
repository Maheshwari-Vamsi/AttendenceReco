package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
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
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@Platform(include={"<opencv2/stitching/stitcher.hpp>", "<opencv2/stitching/detail/autocalib.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_stitching@.2.4", "opencv_gpu@.2.4", "opencv_video@.2.4", "opencv_legacy@.2.4", "opencv_ml@.2.4", "opencv_photo@.2.4", "opencv_nonfree@.2.4", "opencv_objdetect@.2.4", "opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_calib3d@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @Platform(link={"opencv_stitching", "opencv_video", "opencv_legacy", "opencv_ml", "opencv_photo", "opencv_nonfree", "opencv_objdetect", "opencv_features2d", "opencv_flann", "opencv_calib3d", "opencv_highgui", "opencv_imgproc", "opencv_core"}, value={"android"}), @Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_stitching245", "opencv_gpu245", "opencv_video245", "opencv_legacy245", "opencv_ml245", "opencv_photo245", "opencv_nonfree245", "opencv_objdetect245", "opencv_features2d245", "opencv_flann245", "opencv_calib3d245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_stitching
{
  public static final int WAVE_CORRECT_HORIZ = 0;
  public static final int WAVE_CORRECT_VERT = 1;
  
  static
  {
    Loader.load(opencv_calib3d.class);
    Loader.load(opencv_features2d.class);
    Loader.load(opencv_objdetect.class);
    Loader.load(opencv_nonfree.class);
    Loader.load(opencv_photo.class);
    Loader.load(opencv_ml.class);
    Loader.load(opencv_legacy.class);
    Loader.load(opencv_video.class);
    Loader.load();
  }
  
  @Cast({"bool"})
  @Namespace("cv::detail")
  public static native boolean calibrateRotatingCamera(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
  
  @Namespace("cv::detail")
  public static native void createLaplacePyr(@opencv_core.InputMat opencv_core.CvArr paramCvArr, int paramInt, @ByRef opencv_core.MatVector paramMatVector);
  
  @Namespace("cv::detail")
  public static native void createLaplacePyrGpu(@opencv_core.InputMat opencv_core.CvArr paramCvArr, int paramInt, @ByRef opencv_core.MatVector paramMatVector);
  
  @Namespace("cv::detail")
  public static native void createWeightMap(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, float paramFloat, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
  
  @Namespace("cv::detail")
  public static native void estimateFocal(@Const @StdVector ImageFeatures paramImageFeatures, @Const @StdVector MatchesInfo paramMatchesInfo, @Const @StdVector double[] paramArrayOfDouble);
  
  @Namespace("cv::detail")
  public static native void findMaxSpanningTree(int paramInt, @Const @StdVector MatchesInfo paramMatchesInfo, @ByRef Graph paramGraph, @Const @StdVector int[] paramArrayOfInt);
  
  @Namespace("cv::detail")
  public static native void focalsFromHomography(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByRef double[] paramArrayOfDouble1, @ByRef double[] paramArrayOfDouble2, @ByRef @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @ByRef @Cast({"bool*"}) boolean[] paramArrayOfBoolean2);
  
  @Namespace("cv::detail")
  @StdVector
  public static native IntPointer leaveBiggestComponent(@Const @StdVector ImageFeatures paramImageFeatures, @Const @StdVector MatchesInfo paramMatchesInfo, float paramFloat);
  
  @ByRef
  @Namespace("cv::detail")
  public static native String matchesGraphAsString(@ByRef opencv_core.StringVector paramStringVector, @Const @StdVector MatchesInfo paramMatchesInfo, float paramFloat);
  
  @Namespace("cv::detail")
  public static native void normalizeUsingWeightMap(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
  
  @Cast({"bool"})
  @Namespace("cv::detail")
  public static native boolean overlapRoi(@ByVal opencv_core.CvPoint paramCvPoint1, @ByVal opencv_core.CvPoint paramCvPoint2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Adapter("RectAdapter") @Const opencv_core.CvRect paramCvRect);
  
  @Namespace("cv::detail")
  public static native void restoreImageFromLaplacePyr(@ByRef opencv_core.MatVector paramMatVector);
  
  @Namespace("cv::detail")
  public static native void restoreImageFromLaplacePyrGpu(@ByRef opencv_core.MatVector paramMatVector);
  
  @ByVal
  @Namespace("cv::detail")
  public static native opencv_core.CvRect resultRoi(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @Const @StdVector("CvSize,cv::Size") opencv_core.CvSize paramCvSize);
  
  @ByVal
  @Namespace("cv::detail")
  public static native opencv_core.CvRect resultRoi(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector);
  
  @ByVal
  @Namespace("cv::detail")
  public static native opencv_core.CvPoint resultTl(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint);
  
  @Namespace("cv::detail")
  public static native void selectRandomSubset(int paramInt1, int paramInt2, @Const @StdVector int[] paramArrayOfInt);
  
  @ByRef
  @Namespace("cv::detail")
  public static native IntPointer stitchingLogLevel();
  
  @Namespace("cv::detail")
  public static native void waveCorrect(@ByRef opencv_core.MatVector paramMatVector, @Cast({"cv::detail::WaveCorrectKind"}) int paramInt);
  
  @Namespace("cv::detail")
  public static class BestOf2NearestMatcher
    extends FeaturesMatcher
  {
    static
    {
      Loader.load();
    }
    
    public BestOf2NearestMatcher()
    {
      allocate();
    }
    
    public BestOf2NearestMatcher(Pointer paramPointer)
    {
      super();
    }
    
    public BestOf2NearestMatcher(@Cast({"bool"}) boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2)
    {
      allocate(paramBoolean, paramFloat, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"bool"}) boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2);
  }
  
  @Namespace("cv::detail")
  public static class Blender
    extends Pointer
  {
    public static final int FEATHER = 1;
    public static final int MULTI_BAND = 2;
    public static final int NO;
    
    static
    {
      Loader.load();
    }
    
    public Blender()
    {
      allocate();
    }
    
    public Blender(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @opencv_core.Ptr
    public static native Blender createDefault(int paramInt);
    
    @opencv_core.Ptr
    public static native Blender createDefault(int paramInt, @Cast({"bool"}) boolean paramBoolean);
    
    public native void blend(@opencv_core.OutputMat opencv_core.IplImage paramIplImage1, @opencv_core.OutputMat opencv_core.IplImage paramIplImage2);
    
    public native void feed(@opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2, @ByVal opencv_core.CvPoint paramCvPoint);
    
    public native void prepare(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @Const @StdVector("CvSize,cv::Size") opencv_core.CvSize paramCvSize);
    
    public native void prepare(@ByVal opencv_core.CvRect paramCvRect);
  }
  
  @Namespace("cv::detail")
  public static class BlocksGainCompensator
    extends ExposureCompensator
  {
    static
    {
      Loader.load();
    }
    
    public BlocksGainCompensator()
    {
      allocate();
    }
    
    public BlocksGainCompensator(int paramInt1, int paramInt2)
    {
      allocate(paramInt1, paramInt2);
    }
    
    public BlocksGainCompensator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2);
  }
  
  @Namespace("cv::detail")
  public static class BundleAdjusterBase
    extends Estimator
  {
    static
    {
      Loader.load();
    }
    
    public BundleAdjusterBase() {}
    
    public BundleAdjusterBase(Pointer paramPointer)
    {
      super();
    }
    
    public native double confThresh();
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat refinementMask();
    
    public native void setConfThresh(double paramDouble);
    
    public native void setRefinementMask(opencv_core.CvMat paramCvMat);
    
    public native void setTermCriteria(@ByRef opencv_core.CvTermCriteria paramCvTermCriteria);
    
    @ByVal
    public native opencv_core.CvTermCriteria termCriteria();
  }
  
  @Namespace("cv::detail")
  public static class BundleAdjusterRay
    extends BundleAdjusterBase
  {
    static
    {
      Loader.load();
    }
    
    public BundleAdjusterRay()
    {
      allocate();
    }
    
    public BundleAdjusterRay(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class BundleAdjusterReproj
    extends BundleAdjusterBase
  {
    static
    {
      Loader.load();
    }
    
    public BundleAdjusterReproj()
    {
      allocate();
    }
    
    public BundleAdjusterReproj(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  @NoOffset
  public static class CameraParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CameraParams()
    {
      allocate();
    }
    
    public CameraParams(Pointer paramPointer)
    {
      super();
    }
    
    public CameraParams(@ByRef CameraParams paramCameraParams)
    {
      allocate(paramCameraParams);
    }
    
    private native void allocate();
    
    private native void allocate(@ByRef CameraParams paramCameraParams);
    
    @opencv_core.OutputMat
    public native opencv_core.CvMat K();
    
    @opencv_core.InputMat
    public native opencv_core.CvMat R();
    
    public native CameraParams R(opencv_core.CvMat paramCvMat);
    
    public native double aspect();
    
    public native CameraParams aspect(double paramDouble);
    
    public native double focal();
    
    public native CameraParams focal(double paramDouble);
    
    public native double ppx();
    
    public native CameraParams ppx(double paramDouble);
    
    public native double ppy();
    
    public native CameraParams ppy(double paramDouble);
    
    @ByRef
    @Const
    @Name({"operator="})
    public native CameraParams put(@ByRef CameraParams paramCameraParams);
    
    @opencv_core.InputMat
    public native opencv_core.CvMat t();
    
    public native CameraParams t(opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv")
  public static class CompressedRectilinearPortraitWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public CompressedRectilinearPortraitWarper()
    {
      allocate();
    }
    
    public CompressedRectilinearPortraitWarper(float paramFloat1, float paramFloat2)
    {
      allocate(paramFloat1, paramFloat2);
    }
    
    public CompressedRectilinearPortraitWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2);
  }
  
  @Namespace("cv")
  public static class CompressedRectilinearWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public CompressedRectilinearWarper()
    {
      allocate();
    }
    
    public CompressedRectilinearWarper(float paramFloat1, float paramFloat2)
    {
      allocate(paramFloat1, paramFloat2);
    }
    
    public CompressedRectilinearWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2);
  }
  
  @Namespace("cv::detail")
  public static class CylindricalPortraitWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public CylindricalPortraitWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public CylindricalPortraitWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Namespace("cv")
  public static class CylindricalWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public CylindricalWarper()
    {
      allocate();
    }
    
    public CylindricalWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv")
  @Platform(not={"android"})
  public static class CylindricalWarperGpu
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public CylindricalWarperGpu()
    {
      allocate();
    }
    
    public CylindricalWarperGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Name({"cv::detail::CompressedRectilinearPortraitWarper"})
  public static class DetailCompressedRectilinearPortraitWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailCompressedRectilinearPortraitWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailCompressedRectilinearPortraitWarper(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      allocate(paramFloat1, paramFloat2, paramFloat3);
    }
    
    public DetailCompressedRectilinearPortraitWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
    
    private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  @Name({"cv::detail::CompressedRectilinearWarper"})
  public static class DetailCompressedRectilinearWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailCompressedRectilinearWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailCompressedRectilinearWarper(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      allocate(paramFloat1, paramFloat2, paramFloat3);
    }
    
    public DetailCompressedRectilinearWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
    
    private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  @Name({"cv::detail::CylindricalWarper"})
  public static class DetailCylindricalWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailCylindricalWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailCylindricalWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::CylindricalWarperGpu"})
  @Platform(not={"android"})
  public static class DetailCylindricalWarperGpu
    extends DetailCylindricalWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailCylindricalWarperGpu(float paramFloat)
    {
      super();
      allocate(paramFloat);
    }
    
    public DetailCylindricalWarperGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::FisheyeWarper"})
  public static class DetailFisheyeWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailFisheyeWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailFisheyeWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::MercatorWarper"})
  public static class DetailMercatorWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailMercatorWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailMercatorWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::PaniniPortraitWarper"})
  public static class DetailPaniniPortraitWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailPaniniPortraitWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailPaniniPortraitWarper(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      allocate(paramFloat1, paramFloat2, paramFloat3);
    }
    
    public DetailPaniniPortraitWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
    
    private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  @Name({"cv::detail::PaniniWarper"})
  public static class DetailPaniniWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailPaniniWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailPaniniWarper(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      allocate(paramFloat1, paramFloat2, paramFloat3);
    }
    
    public DetailPaniniWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
    
    private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  @Name({"cv::detail::PlaneWarper"})
  public static class DetailPlaneWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailPlaneWarper()
    {
      allocate();
    }
    
    public DetailPlaneWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailPlaneWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::PlaneWarperGpu"})
  @Platform(not={"android"})
  public static class DetailPlaneWarperGpu
    extends DetailPlaneWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailPlaneWarperGpu()
    {
      allocate();
    }
    
    public DetailPlaneWarperGpu(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailPlaneWarperGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat);
    
    @ByVal
    public native opencv_core.CvRect buildMaps(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
    
    @ByVal
    public native opencv_core.CvPoint warp(opencv_core.IplImage paramIplImage1, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt1, int paramInt2, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
  }
  
  @Name({"cv::detail::SphericalWarper"})
  public static class DetailSphericalWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailSphericalWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailSphericalWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::SphericalWarperGpu"})
  @Platform(not={"android"})
  public static class DetailSphericalWarperGpu
    extends DetailSphericalWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailSphericalWarperGpu(float paramFloat)
    {
      super();
      allocate(paramFloat);
    }
    
    public DetailSphericalWarperGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::StereographicWarper"})
  public static class DetailStereographicWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailStereographicWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailStereographicWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Name({"cv::detail::TransverseMercatorWarper"})
  public static class DetailTransverseMercatorWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public DetailTransverseMercatorWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public DetailTransverseMercatorWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Namespace("cv::detail")
  @NoOffset
  public static class DisjointSets
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public DisjointSets()
    {
      allocate();
    }
    
    public DisjointSets(int paramInt)
    {
      allocate(paramInt);
    }
    
    public DisjointSets(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
    
    public native void createOneElemSets(int paramInt);
    
    public native int findSetByElem(int paramInt);
    
    public native int mergeSets(int paramInt1, int paramInt2);
    
    @Const
    @StdVector
    public native IntPointer parent();
    
    public native DisjointSets parent(IntPointer paramIntPointer);
    
    @Const
    @StdVector
    public native IntPointer size();
    
    public native DisjointSets size(IntPointer paramIntPointer);
  }
  
  @Namespace("cv::detail")
  public static class DpSeamFinder
    extends SeamFinder
  {
    public static final int COLOR = 0;
    public static final int COLOR_GRAD = 1;
    
    static
    {
      Loader.load();
    }
    
    public DpSeamFinder()
    {
      allocate();
    }
    
    public DpSeamFinder(int paramInt)
    {
      allocate(paramInt);
    }
    
    public DpSeamFinder(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"cv::detail::DpSeamFinder::CostFunction"}) int paramInt);
    
    @Cast({"cv::detail::DpSeamFinder::CostFunction"})
    public native int costFunction();
    
    public native void setCostFunction(@Cast({"cv::detail::DpSeamFinder::CostFunction"}) int paramInt);
  }
  
  @Namespace("cv::detail")
  public static class Estimator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Estimator() {}
    
    public Estimator(Pointer paramPointer)
    {
      super();
    }
    
    @Name({"operator()"})
    public native void estimate(@Const @StdVector opencv_stitching.ImageFeatures paramImageFeatures, @Const @StdVector opencv_stitching.MatchesInfo paramMatchesInfo, @Const @StdVector opencv_stitching.CameraParams paramCameraParams);
  }
  
  @Namespace("cv::detail")
  public static class ExposureCompensator
    extends Pointer
  {
    public static final int GAIN = 1;
    public static final int GAIN_BLOCKS = 2;
    public static final int NO;
    
    static
    {
      Loader.load();
    }
    
    public ExposureCompensator() {}
    
    public ExposureCompensator(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public static native ExposureCompensator createDefault(int paramInt);
    
    public native void apply(int paramInt, @ByVal opencv_core.CvPoint paramCvPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
    
    public native void feed(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_core.MatVector paramMatVector2);
    
    public native void feed(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_stitching.MatBytePairVector paramMatBytePairVector);
  }
  
  @Namespace("cv::detail")
  public static class FeatherBlender
    extends Blender
  {
    static
    {
      Loader.load();
    }
    
    public FeatherBlender()
    {
      allocate();
    }
    
    public FeatherBlender(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public FeatherBlender(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat);
    
    @ByVal
    public native opencv_core.CvRect createWeightMaps(@ByRef opencv_core.MatVector paramMatVector1, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector2);
    
    public native void setSharpness(float paramFloat);
    
    public native float sharpness();
  }
  
  @Namespace("cv::detail")
  public static class FeaturesFinder
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public FeaturesFinder() {}
    
    public FeaturesFinder(Pointer paramPointer)
    {
      super();
    }
    
    public native void collectGarbage();
    
    @Name({"operator()"})
    public native void find(opencv_core.IplImage paramIplImage, @ByRef opencv_stitching.ImageFeatures paramImageFeatures);
    
    @Name({"operator()"})
    public native void find(opencv_core.IplImage paramIplImage, @ByRef opencv_stitching.ImageFeatures paramImageFeatures, @Const @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect);
  }
  
  @Namespace("cv::detail")
  public static class FeaturesMatcher
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public FeaturesMatcher() {}
    
    public FeaturesMatcher(Pointer paramPointer)
    {
      super();
    }
    
    public native void collectGarbage();
    
    @Cast({"bool"})
    public native boolean isThreadSafe();
    
    @Name({"operator()"})
    public native void match(@ByRef opencv_stitching.ImageFeatures paramImageFeatures1, @ByRef opencv_stitching.ImageFeatures paramImageFeatures2, @ByRef opencv_stitching.MatchesInfo paramMatchesInfo);
    
    @Name({"operator()"})
    public native void match(@Const @StdVector opencv_stitching.ImageFeatures paramImageFeatures, @Const @StdVector opencv_stitching.MatchesInfo paramMatchesInfo, opencv_core.CvMat paramCvMat);
  }
  
  @Namespace("cv")
  public static class FisheyeWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public FisheyeWarper()
    {
      allocate();
    }
    
    public FisheyeWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class GainCompensator
    extends ExposureCompensator
  {
    static
    {
      Loader.load();
    }
    
    public GainCompensator()
    {
      allocate();
    }
    
    public GainCompensator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @StdVector
    public native DoublePointer gains();
  }
  
  @Namespace("cv::detail")
  public static class Graph
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Graph()
    {
      allocate();
    }
    
    public Graph(int paramInt)
    {
      allocate(paramInt);
    }
    
    public Graph(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
    
    public native void addEdge(int paramInt1, int paramInt2, float paramFloat);
    
    public native void create(int paramInt);
    
    public native int numVertices();
  }
  
  @Namespace("cv::detail")
  public static class GraphCutSeamFinder
    extends SeamFinder
    implements GraphCutSeamFinderBase
  {
    static
    {
      Loader.load();
    }
    
    public GraphCutSeamFinder()
    {
      allocate();
    }
    
    public GraphCutSeamFinder(int paramInt, float paramFloat1, float paramFloat2)
    {
      allocate(paramInt, paramFloat1, paramFloat2);
    }
    
    public GraphCutSeamFinder(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface GraphCutSeamFinderBase
  {
    public static final int COST_COLOR = 0;
    public static final int COST_COLOR_GRAD = 1;
  }
  
  @Namespace("cv::detail")
  @Platform(not={"android"})
  public static class GraphCutSeamFinderGpu
    extends PairwiseSeamFinder
    implements GraphCutSeamFinderBase
  {
    static
    {
      Loader.load();
    }
    
    public GraphCutSeamFinderGpu()
    {
      allocate();
    }
    
    public GraphCutSeamFinderGpu(int paramInt, float paramFloat1, float paramFloat2)
    {
      allocate(paramInt, paramFloat1, paramFloat2);
    }
    
    public GraphCutSeamFinderGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, float paramFloat1, float paramFloat2);
    
    public native void findInPair(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, @ByVal opencv_core.CvRect paramCvRect);
  }
  
  @Namespace("cv::detail")
  @NoOffset
  public static class GraphEdge
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public GraphEdge(int paramInt1, int paramInt2, float paramFloat)
    {
      allocate(paramInt1, paramInt2, paramFloat);
    }
    
    public GraphEdge(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat);
    
    public native int from();
    
    public native GraphEdge from(int paramInt);
    
    @Cast({"bool"})
    @Name({"operator>"})
    public native boolean greaterThan(@ByRef GraphEdge paramGraphEdge);
    
    @Cast({"bool"})
    @Name({"operator<"})
    public native boolean lessThan(@ByRef GraphEdge paramGraphEdge);
    
    public native int to();
    
    public native GraphEdge to(int paramInt);
    
    public native float weight();
    
    public native GraphEdge weight(float paramFloat);
  }
  
  @Namespace("cv::detail")
  public static class HomographyBasedEstimator
    extends Estimator
  {
    static
    {
      Loader.load();
    }
    
    public HomographyBasedEstimator()
    {
      allocate();
    }
    
    public HomographyBasedEstimator(Pointer paramPointer)
    {
      super();
    }
    
    public HomographyBasedEstimator(@Cast({"bool"}) boolean paramBoolean)
    {
      allocate(paramBoolean);
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"bool"}) boolean paramBoolean);
  }
  
  @Namespace("cv::detail")
  @NoOffset
  public static class ImageFeatures
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ImageFeatures()
    {
      allocate();
    }
    
    public ImageFeatures(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public ImageFeatures(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @opencv_core.InputMat
    public native opencv_core.CvMat descriptors();
    
    public native ImageFeatures descriptors(opencv_core.CvMat paramCvMat);
    
    public native int img_idx();
    
    public native ImageFeatures img_idx(int paramInt);
    
    @ByVal
    public native opencv_core.CvSize img_size();
    
    public native ImageFeatures img_size(opencv_core.CvSize paramCvSize);
    
    @Const
    @StdVector
    public native opencv_features2d.KeyPoint keypoints();
    
    public native ImageFeatures keypoints(opencv_features2d.KeyPoint paramKeyPoint);
    
    public ImageFeatures position(int paramInt)
    {
      return (ImageFeatures)super.position(paramInt);
    }
  }
  
  @Name({"std::vector<std::pair<cv::Mat,uchar> >"})
  public static class MatBytePairVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public MatBytePairVector()
    {
      allocate();
    }
    
    public MatBytePairVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public MatBytePairVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(long paramLong);
    
    @Index
    @opencv_core.InputMat
    public native opencv_core.CvMat first(long paramLong);
    
    public native MatBytePairVector first(long paramLong, opencv_core.CvMat paramCvMat);
    
    @Index
    public native byte second(long paramLong);
    
    public native MatBytePairVector second(long paramLong, byte paramByte);
  }
  
  @Namespace("cv::detail")
  @NoOffset
  public static class MatchesInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public MatchesInfo()
    {
      allocate();
    }
    
    public MatchesInfo(Pointer paramPointer)
    {
      super();
    }
    
    public MatchesInfo(@ByRef MatchesInfo paramMatchesInfo)
    {
      allocate(paramMatchesInfo);
    }
    
    private native void allocate();
    
    private native void allocate(@ByRef MatchesInfo paramMatchesInfo);
    
    @opencv_core.InputMat
    public native opencv_core.CvMat H();
    
    public native MatchesInfo H(opencv_core.CvMat paramCvMat);
    
    public native double confidence();
    
    public native MatchesInfo confidence(double paramDouble);
    
    public native int dst_img_idx();
    
    public native MatchesInfo dst_img_idx(int paramInt);
    
    @Cast({"uchar*"})
    @Const
    @StdVector
    public native BytePointer inliers_mask();
    
    public native MatchesInfo inliers_mask(BytePointer paramBytePointer);
    
    @Const
    @StdVector
    public native opencv_features2d.DMatch matches();
    
    public native MatchesInfo matches(opencv_features2d.DMatch paramDMatch);
    
    public native int num_inliers();
    
    public native MatchesInfo num_inliers(int paramInt);
    
    @ByRef
    @Const
    @Name({"operator="})
    public native MatchesInfo put(@ByRef MatchesInfo paramMatchesInfo);
    
    public native int src_img_idx();
    
    public native MatchesInfo src_img_idx(int paramInt);
  }
  
  @Namespace("cv")
  public static class MercatorWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public MercatorWarper()
    {
      allocate();
    }
    
    public MercatorWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class MultiBandBlender
    extends Blender
  {
    static
    {
      Loader.load();
    }
    
    public MultiBandBlender()
    {
      allocate();
    }
    
    public MultiBandBlender(Pointer paramPointer)
    {
      super();
    }
    
    public MultiBandBlender(@Cast({"int"}) boolean paramBoolean, int paramInt1, int paramInt2)
    {
      allocate(paramBoolean, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"int"}) boolean paramBoolean, int paramInt1, int paramInt2);
    
    public native int numBands();
    
    public native void setNumBands(int paramInt);
  }
  
  @Namespace("cv::detail")
  public static class NoExposureCompensator
    extends ExposureCompensator
  {
    static
    {
      Loader.load();
    }
    
    public NoExposureCompensator()
    {
      allocate();
    }
    
    public NoExposureCompensator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class NoSeamFinder
    extends SeamFinder
  {
    static
    {
      Loader.load();
    }
    
    public NoSeamFinder()
    {
      allocate();
    }
    
    public NoSeamFinder(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class OrbFeaturesFinder
    extends FeaturesFinder
  {
    static
    {
      Loader.load();
    }
    
    public OrbFeaturesFinder()
    {
      allocate();
    }
    
    public OrbFeaturesFinder(Pointer paramPointer)
    {
      super();
    }
    
    public OrbFeaturesFinder(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, float paramFloat, int paramInt2)
    {
      allocate(paramCvSize, paramInt1, paramFloat, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, float paramFloat, int paramInt2);
  }
  
  @Namespace("cv::detail")
  public static class PairwiseSeamFinder
    extends SeamFinder
  {
    static
    {
      Loader.load();
    }
    
    public PairwiseSeamFinder() {}
    
    public PairwiseSeamFinder(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Namespace("cv")
  public static class PaniniPortraitWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public PaniniPortraitWarper()
    {
      allocate();
    }
    
    public PaniniPortraitWarper(float paramFloat1, float paramFloat2)
    {
      allocate(paramFloat1, paramFloat2);
    }
    
    public PaniniPortraitWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2);
  }
  
  @Namespace("cv")
  public static class PaniniWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public PaniniWarper()
    {
      allocate();
    }
    
    public PaniniWarper(float paramFloat1, float paramFloat2)
    {
      allocate(paramFloat1, paramFloat2);
    }
    
    public PaniniWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2);
  }
  
  @Namespace("cv::detail")
  public static class PlanePortraitWarper
    extends RotationWarper
  {
    static
    {
      Loader.load();
    }
    
    public PlanePortraitWarper(float paramFloat)
    {
      allocate(paramFloat);
    }
    
    public PlanePortraitWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(float paramFloat);
  }
  
  @Namespace("cv")
  public static class PlaneWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public PlaneWarper()
    {
      allocate();
    }
    
    public PlaneWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv")
  @Platform(not={"android"})
  public static class PlaneWarperGpu
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public PlaneWarperGpu()
    {
      allocate();
    }
    
    public PlaneWarperGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class RotationWarper
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public RotationWarper() {}
    
    public RotationWarper(Pointer paramPointer)
    {
      super();
    }
    
    @ByVal
    public native opencv_core.CvRect buildMaps(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
    
    public native float getScale();
    
    public native void setScale(float paramFloat);
    
    @ByVal
    public native opencv_core.CvPoint warp(opencv_core.IplImage paramIplImage1, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, int paramInt1, int paramInt2, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
    
    public native void warpBackward(opencv_core.IplImage paramIplImage1, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
    
    @ByVal
    public native opencv_core.CvPoint2D32f warpPoint(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    @ByVal
    public native opencv_core.CvRect warpRoi(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
  }
  
  @Namespace("cv::detail")
  public static class SeamFinder
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SeamFinder() {}
    
    public SeamFinder(Pointer paramPointer)
    {
      super();
    }
    
    public native void find(@ByRef opencv_core.MatVector paramMatVector1, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector2);
  }
  
  @Namespace("cv")
  public static class SphericalWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public SphericalWarper()
    {
      allocate();
    }
    
    public SphericalWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv")
  @Platform(not={"android"})
  public static class SphericalWarperGpu
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public SphericalWarperGpu()
    {
      allocate();
    }
    
    public SphericalWarperGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv")
  public static class StereographicWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public StereographicWarper()
    {
      allocate();
    }
    
    public StereographicWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv")
  public static class Stitcher
    extends Pointer
  {
    public static final int ERR_NEED_MORE_IMGS = 1;
    public static final int OK = 0;
    public static final int ORIG_RESOL = -1;
    
    static
    {
      Loader.load();
    }
    
    public Stitcher() {}
    
    public Stitcher(Pointer paramPointer)
    {
      super();
    }
    
    @ByVal
    public static native Stitcher createDefault(@Cast({"bool"}) boolean paramBoolean);
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.Blender blender();
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.BundleAdjusterBase bundleAdjuster();
    
    @StdVector
    public native opencv_stitching.CameraParams cameras();
    
    @StdVector
    public native IntPointer component();
    
    public native int composePanorama(@opencv_core.OutputArray opencv_core.IplImage paramIplImage);
    
    public native int composePanorama(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.OutputArray opencv_core.IplImage paramIplImage);
    
    public native double compositingResol();
    
    public native int estimateTransform(@ByRef opencv_core.MatVector paramMatVector);
    
    public native int estimateTransform(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_core.RectVectorVector paramRectVectorVector);
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.ExposureCompensator exposureCompensator();
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.FeaturesFinder featuresFinder();
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.FeaturesMatcher featuresMatcher();
    
    @opencv_core.OutputMat
    public native opencv_core.IplImage matchingMask();
    
    public native double panoConfidenceThresh();
    
    public native double registrationResol();
    
    public native double seamEstimationResol();
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.SeamFinder seamFinder();
    
    public native void setBlender(@opencv_core.Ptr Blender paramBlender);
    
    public native void setBundleAdjuster(@opencv_core.Ptr BundleAdjusterBase paramBundleAdjusterBase);
    
    public native void setCompositingResol(double paramDouble);
    
    public native void setExposureCompensator(@opencv_core.Ptr ExposureCompensator paramExposureCompensator);
    
    public native void setFeaturesFinder(@opencv_core.Ptr FeaturesFinder paramFeaturesFinder);
    
    public native void setFeaturesMatcher(@opencv_core.Ptr FeaturesMatcher paramFeaturesMatcher);
    
    public native void setMatchingMask(opencv_core.IplImage paramIplImage);
    
    public native void setPanoConfidenceThresh(double paramDouble);
    
    public native void setRegistrationResol(double paramDouble);
    
    public native void setSeamEstimationResol(double paramDouble);
    
    public native void setSeamFinder(@opencv_core.Ptr SeamFinder paramSeamFinder);
    
    public native void setWarper(@opencv_core.Ptr WarperCreator paramWarperCreator);
    
    public native void setWaveCorrectKind(@Cast({"cv::detail::WaveCorrectKind"}) int paramInt);
    
    public native void setWaveCorrection(@Cast({"bool"}) boolean paramBoolean);
    
    public native int stitch(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.OutputArray opencv_core.IplImage paramIplImage);
    
    public native int stitch(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_core.RectVectorVector paramRectVectorVector, @opencv_core.OutputArray opencv_core.IplImage paramIplImage);
    
    @Const
    @opencv_core.Ptr
    public native opencv_stitching.WarperCreator warper();
    
    @Cast({"cv::detail::WaveCorrectKind"})
    public native int waveCorrectKind();
    
    @Cast({"bool"})
    public native boolean waveCorrection();
    
    public native double workScale();
  }
  
  @Namespace("cv::detail")
  public static class SurfFeaturesFinder
    extends FeaturesFinder
  {
    static
    {
      Loader.load();
    }
    
    public SurfFeaturesFinder()
    {
      allocate();
    }
    
    public SurfFeaturesFinder(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      allocate(paramDouble, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public SurfFeaturesFinder(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  @Namespace("cv::detail")
  @Platform(not={"android"})
  public static class SurfFeaturesFinderGpu
    extends FeaturesFinder
  {
    static
    {
      Loader.load();
    }
    
    public SurfFeaturesFinderGpu()
    {
      allocate();
    }
    
    public SurfFeaturesFinderGpu(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      allocate(paramDouble, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public SurfFeaturesFinderGpu(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  @Namespace("cv")
  public static class TransverseMercatorWarper
    extends WarperCreator
  {
    static
    {
      Loader.load();
    }
    
    public TransverseMercatorWarper()
    {
      allocate();
    }
    
    public TransverseMercatorWarper(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::detail")
  public static class VoronoiSeamFinder
    extends PairwiseSeamFinder
  {
    static
    {
      Loader.load();
    }
    
    public VoronoiSeamFinder()
    {
      allocate();
    }
    
    public VoronoiSeamFinder(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv")
  public static class WarperCreator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public WarperCreator() {}
    
    public WarperCreator(Pointer paramPointer)
    {
      super();
    }
    
    @opencv_core.Ptr
    public native RotationWarper create(float paramFloat);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_stitching.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */