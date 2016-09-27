package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.Pointer.Deallocator;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByPtrRef;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/calib3d/calib3d.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_calib3d@.2.4", "opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_calib3d245", "opencv_features2d245", "opencv_flann245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_calib3d
{
  public static final int CALIB_CB_ASYMMETRIC_GRID = 2;
  public static final int CALIB_CB_CLUSTERING = 4;
  public static final int CALIB_CB_SYMMETRIC_GRID = 1;
  public static final int CV_CALIB_CB_ADAPTIVE_THRESH = 1;
  public static final int CV_CALIB_CB_FAST_CHECK = 8;
  public static final int CV_CALIB_CB_FILTER_QUADS = 4;
  public static final int CV_CALIB_CB_NORMALIZE_IMAGE = 2;
  public static final int CV_CALIB_FIX_ASPECT_RATIO = 2;
  public static final int CV_CALIB_FIX_FOCAL_LENGTH = 16;
  public static final int CV_CALIB_FIX_INTRINSIC = 256;
  public static final int CV_CALIB_FIX_K1 = 32;
  public static final int CV_CALIB_FIX_K2 = 64;
  public static final int CV_CALIB_FIX_K3 = 128;
  public static final int CV_CALIB_FIX_K4 = 2048;
  public static final int CV_CALIB_FIX_K5 = 4096;
  public static final int CV_CALIB_FIX_K6 = 8192;
  public static final int CV_CALIB_FIX_PRINCIPAL_POINT = 4;
  public static final int CV_CALIB_RATIONAL_MODEL = 16384;
  public static final int CV_CALIB_SAME_FOCAL_LENGTH = 512;
  public static final int CV_CALIB_USE_INTRINSIC_GUESS = 1;
  public static final int CV_CALIB_ZERO_DISPARITY = 1024;
  public static final int CV_CALIB_ZERO_TANGENT_DIST = 8;
  public static final int CV_EPNP = 1;
  public static final int CV_FM_7POINT = 1;
  public static final int CV_FM_8POINT = 2;
  public static final int CV_FM_LMEDS = 4;
  public static final int CV_FM_LMEDS_ONLY = 4;
  public static final int CV_FM_RANSAC = 8;
  public static final int CV_FM_RANSAC_ONLY = 8;
  public static final int CV_ITERATIVE = 0;
  public static final int CV_LMEDS = 4;
  public static final int CV_P3P = 2;
  public static final int CV_RANSAC = 8;
  public static final int CV_STEREO_BM_BASIC = 0;
  public static final int CV_STEREO_BM_FISH_EYE = 1;
  public static final int CV_STEREO_BM_NARROW = 2;
  public static final int CV_STEREO_BM_NORMALIZED_RESPONSE = 0;
  public static final int CV_STEREO_BM_XSOBEL = 1;
  public static final int EPNP = 1;
  public static final int ITERATIVE = 0;
  public static final int P3P = 2;
  
  static
  {
    Loader.load(opencv_highgui.class);
    Loader.load(opencv_flann.class);
    Loader.load(opencv_features2d.class);
    Loader.load();
  }
  
  public static native void cvCalcMatMulDeriv(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
  
  public static native double cvCalibrateCamera2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, int paramInt);
  
  public static native double cvCalibrateCamera2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, int paramInt, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
  
  public static native void cvCalibrationMatrixValues(opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble4);
  
  public static native int cvCheckChessboard(opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvSize paramCvSize);
  
  public static native void cvComposeRT(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, opencv_core.CvMat paramCvMat12, opencv_core.CvMat paramCvMat13, opencv_core.CvMat paramCvMat14);
  
  public static native void cvComputeCorrespondEpilines(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
  
  public static native void cvConvertPointsHomogeneous(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
  
  public static native void cvCorrectMatches(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5);
  
  public static native CvPOSITObject cvCreatePOSITObject(opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt);
  
  public static native CvStereoBMState cvCreateStereoBMState(int paramInt1, int paramInt2);
  
  public static native void cvDecomposeProjectionMatrix(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvPoint3D64f paramCvPoint3D64f);
  
  public static native void cvDrawChessboardCorners(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, int paramInt1, int paramInt2);
  
  public static native int cvFindChessboardCorners(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, int[] paramArrayOfInt, int paramInt);
  
  public static void cvFindExtrinsicCameraParams2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6)
  {
    cvFindExtrinsicCameraParams2(paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramCvMat6, 0);
  }
  
  public static native void cvFindExtrinsicCameraParams2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, int paramInt);
  
  public static native int cvFindFundamentalMat(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt, double paramDouble1, double paramDouble2, opencv_core.CvMat paramCvMat4);
  
  public static int cvFindHomography(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3)
  {
    return cvFindHomography(paramCvMat1, paramCvMat2, paramCvMat3, 0, 3.0D, null);
  }
  
  public static native int cvFindHomography(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt, double paramDouble, opencv_core.CvMat paramCvMat4);
  
  public static native void cvFindStereoCorrespondenceBM(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, CvStereoBMState paramCvStereoBMState);
  
  public static native void cvGetOptimalNewCameraMatrix(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @ByVal opencv_core.CvSize paramCvSize1, double paramDouble, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize2, opencv_core.CvRect paramCvRect, int paramInt);
  
  @ByVal
  public static native opencv_core.CvRect cvGetValidDisparityROI(@ByVal opencv_core.CvRect paramCvRect1, @ByVal opencv_core.CvRect paramCvRect2, int paramInt1, int paramInt2, int paramInt3);
  
  public static void cvInitIntrinsicParams2D(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4)
  {
    cvInitIntrinsicParams2D(paramCvMat1, paramCvMat2, paramCvMat3, paramCvSize, paramCvMat4, -1.0D);
  }
  
  public static native void cvInitIntrinsicParams2D(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, double paramDouble);
  
  public static native void cvPOSIT(CvPOSITObject paramCvPOSITObject, opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2);
  
  public static native void cvPOSIT(CvPOSITObject paramCvPOSITObject, opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public static void cvProjectPoints2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6)
  {
    cvProjectPoints2(paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramCvMat6, null, null, null, null, null, 0.0D);
  }
  
  public static native void cvProjectPoints2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, double paramDouble);
  
  public static native int cvRANSACUpdateNumIters(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
  
  public static native void cvRQDecomp3x3(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvPoint3D64f paramCvPoint3D64f);
  
  public static native void cvReleasePOSITObject(@ByPtrPtr CvPOSITObject paramCvPOSITObject);
  
  public static native void cvReleaseStereoBMState(@ByPtrPtr CvStereoBMState paramCvStereoBMState);
  
  public static void cvReprojectImageTo3D(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat)
  {
    cvReprojectImageTo3D(paramCvArr1, paramCvArr2, paramCvMat, 0);
  }
  
  public static native void cvReprojectImageTo3D(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, int paramInt);
  
  public static native int cvRodrigues2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
  
  public static native double cvStereoCalibrate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, opencv_core.CvMat paramCvMat12, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt);
  
  public static native void cvStereoRectify(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_core.CvSize paramCvSize1, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, int paramInt, double paramDouble, @ByVal opencv_core.CvSize paramCvSize2, opencv_core.CvRect paramCvRect1, opencv_core.CvRect paramCvRect2);
  
  public static native int cvStereoRectifyUncalibrated(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, double paramDouble);
  
  public static native void cvTriangulatePoints(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5);
  
  public static native void cvValidateDisparity(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, int paramInt3);
  
  @Namespace("cv")
  public static native int estimateAffine3D(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, double paramDouble1, double paramDouble2);
  
  @Namespace("cv")
  public static native void filterSpeckles(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, double paramDouble1, int paramInt, double paramDouble2, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
  
  @Namespace("cv")
  public static native boolean find4QuadCornerSubpix(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize);
  
  @Namespace("cv")
  public static native boolean findCirclesGrid(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, int paramInt, @opencv_core.Ptr opencv_features2d.FeatureDetector paramFeatureDetector);
  
  @Namespace("cv")
  public static native boolean findCirclesGridDefault(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, int paramInt);
  
  @Namespace("cv")
  public static native float rectify3Collinear(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.InputArray opencv_core.CvMat paramCvMat3, @opencv_core.InputArray opencv_core.CvMat paramCvMat4, @opencv_core.InputArray opencv_core.CvMat paramCvMat5, @opencv_core.InputArray opencv_core.CvMat paramCvMat6, @ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector1, @ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector2, @ByVal opencv_core.CvSize paramCvSize1, @opencv_core.InputArray opencv_core.CvMat paramCvMat7, @opencv_core.InputArray opencv_core.CvMat paramCvMat8, @opencv_core.InputArray opencv_core.CvMat paramCvMat9, @opencv_core.InputArray opencv_core.CvMat paramCvMat10, @opencv_core.InputArray opencv_core.CvMat paramCvMat11, @opencv_core.InputArray opencv_core.CvMat paramCvMat12, @opencv_core.InputArray opencv_core.CvMat paramCvMat13, @opencv_core.InputArray opencv_core.CvMat paramCvMat14, @opencv_core.InputArray opencv_core.CvMat paramCvMat15, @opencv_core.InputArray opencv_core.CvMat paramCvMat16, @opencv_core.InputArray opencv_core.CvMat paramCvMat17, double paramDouble, @ByVal opencv_core.CvSize paramCvSize2, @Adapter("RectAdapter") @Const opencv_core.CvRect paramCvRect1, @Adapter("RectAdapter") @Const opencv_core.CvRect paramCvRect2, int paramInt);
  
  @Namespace("cv")
  public static native boolean solvePnP(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.InputArray opencv_core.CvMat paramCvMat3, @opencv_core.InputArray opencv_core.CvMat paramCvMat4, @opencv_core.OutputArray opencv_core.CvMat paramCvMat5, @opencv_core.OutputArray opencv_core.CvMat paramCvMat6, boolean paramBoolean, int paramInt);
  
  @Namespace("cv")
  public static native void solvePnPRansac(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.InputArray opencv_core.CvMat paramCvMat3, @opencv_core.InputArray opencv_core.CvMat paramCvMat4, @opencv_core.InputArray opencv_core.CvMat paramCvMat5, @opencv_core.InputArray opencv_core.CvMat paramCvMat6, boolean paramBoolean, int paramInt1, float paramFloat, int paramInt2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat7, int paramInt3);
  
  @NoOffset
  public static class CvLevMarq
    extends Pointer
  {
    public static final int CALC_J = 2;
    public static final int CHECK_ERR = 3;
    public static final int DONE = 0;
    public static final int STARTED = 1;
    
    static
    {
      Loader.load();
    }
    
    public CvLevMarq()
    {
      allocate();
    }
    
    public CvLevMarq(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, boolean paramBoolean)
    {
      allocate(paramInt1, paramInt2, paramCvTermCriteria, paramBoolean);
    }
    
    public CvLevMarq(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, boolean paramBoolean);
    
    public native CvLevMarq J(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat J();
    
    public native CvLevMarq JtErr(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat JtErr();
    
    public native CvLevMarq JtJ(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat JtJ();
    
    public native CvLevMarq JtJN(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat JtJN();
    
    public native CvLevMarq JtJV(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat JtJV();
    
    public native CvLevMarq JtJW(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat JtJW();
    
    public native void clear();
    
    public native CvLevMarq completeSymmFlag(boolean paramBoolean);
    
    public native boolean completeSymmFlag();
    
    public native CvLevMarq criteria(opencv_core.CvTermCriteria paramCvTermCriteria);
    
    @ByRef
    public native opencv_core.CvTermCriteria criteria();
    
    public native CvLevMarq err(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat err();
    
    public native double errNorm();
    
    public native CvLevMarq errNorm(double paramDouble);
    
    public native void init(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, boolean paramBoolean);
    
    public native int iters();
    
    public native CvLevMarq iters(int paramInt);
    
    public native int lambdaLg10();
    
    public native CvLevMarq lambdaLg10(int paramInt);
    
    public native CvLevMarq mask(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat mask();
    
    public native CvLevMarq param(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat param();
    
    public native double prevErrNorm();
    
    public native CvLevMarq prevErrNorm(double paramDouble);
    
    public native CvLevMarq prevParam(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat prevParam();
    
    public native int state();
    
    public native CvLevMarq state(int paramInt);
    
    public native void step();
    
    public native boolean update(@Cast({"const CvMat*&"}) opencv_core.CvMat paramCvMat1, @ByPtrRef opencv_core.CvMat paramCvMat2, @ByPtrRef opencv_core.CvMat paramCvMat3);
    
    public native boolean updateAlt(@Cast({"const CvMat*&"}) opencv_core.CvMat paramCvMat1, @ByPtrRef opencv_core.CvMat paramCvMat2, @ByPtrRef opencv_core.CvMat paramCvMat3, @ByPtrRef DoublePointer paramDoublePointer);
  }
  
  @Opaque
  public static class CvPOSITObject
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPOSITObject() {}
    
    public CvPOSITObject(Pointer paramPointer)
    {
      super();
    }
    
    public static CvPOSITObject create(opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt)
    {
      CvPOSITObject localCvPOSITObject = opencv_calib3d.cvCreatePOSITObject(paramCvPoint3D32f, paramInt);
      if (localCvPOSITObject != null) {
        localCvPOSITObject.deallocator(new ReleaseDeallocator(localCvPOSITObject));
      }
      return localCvPOSITObject;
    }
    
    public void release()
    {
      deallocate();
    }
    
    static class ReleaseDeallocator
      extends CvPOSITObject
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvPOSITObject paramCvPOSITObject)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_calib3d.cvReleasePOSITObject(this);
      }
    }
  }
  
  public static class CvStereoBMState
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStereoBMState()
    {
      allocate();
      zero();
    }
    
    public CvStereoBMState(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvStereoBMState(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvStereoBMState create(int paramInt1, int paramInt2)
    {
      CvStereoBMState localCvStereoBMState = opencv_calib3d.cvCreateStereoBMState(paramInt1, paramInt2);
      if (localCvStereoBMState != null) {
        localCvStereoBMState.deallocator(new ReleaseDeallocator(localCvStereoBMState));
      }
      return localCvStereoBMState;
    }
    
    public native int SADWindowSize();
    
    public native CvStereoBMState SADWindowSize(int paramInt);
    
    public native CvStereoBMState cost(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat cost();
    
    public native CvStereoBMState disp(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat disp();
    
    public native int disp12MaxDiff();
    
    public native CvStereoBMState disp12MaxDiff(int paramInt);
    
    public native int minDisparity();
    
    public native CvStereoBMState minDisparity(int paramInt);
    
    public native int numberOfDisparities();
    
    public native CvStereoBMState numberOfDisparities(int paramInt);
    
    public CvStereoBMState position(int paramInt)
    {
      return (CvStereoBMState)super.position(paramInt);
    }
    
    public native int preFilterCap();
    
    public native CvStereoBMState preFilterCap(int paramInt);
    
    public native int preFilterSize();
    
    public native CvStereoBMState preFilterSize(int paramInt);
    
    public native int preFilterType();
    
    public native CvStereoBMState preFilterType(int paramInt);
    
    public native CvStereoBMState preFilteredImg0(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat preFilteredImg0();
    
    public native CvStereoBMState preFilteredImg1(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat preFilteredImg1();
    
    public void release()
    {
      deallocate();
    }
    
    public native CvStereoBMState roi1(opencv_core.CvRect paramCvRect);
    
    @ByRef
    public native opencv_core.CvRect roi1();
    
    public native CvStereoBMState roi2(opencv_core.CvRect paramCvRect);
    
    @ByRef
    public native opencv_core.CvRect roi2();
    
    public native CvStereoBMState slidingSumBuf(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat slidingSumBuf();
    
    public native int speckleRange();
    
    public native CvStereoBMState speckleRange(int paramInt);
    
    public native int speckleWindowSize();
    
    public native CvStereoBMState speckleWindowSize(int paramInt);
    
    public native int textureThreshold();
    
    public native CvStereoBMState textureThreshold(int paramInt);
    
    public native int trySmallerWindows();
    
    public native CvStereoBMState trySmallerWindows(int paramInt);
    
    public native int uniquenessRatio();
    
    public native CvStereoBMState uniquenessRatio(int paramInt);
    
    static class ReleaseDeallocator
      extends CvStereoBMState
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvStereoBMState paramCvStereoBMState)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_calib3d.cvReleaseStereoBMState(this);
      }
    }
  }
  
  @Namespace("cv")
  @NoOffset
  public static class StereoBM
    extends Pointer
  {
    public static final int BASIC_PRESET = 0;
    public static final int FISH_EYE_PRESET = 1;
    public static final int NARROW_PRESET = 2;
    public static final int PREFILTER_NORMALIZED_RESPONSE = 0;
    public static final int PREFILTER_XSOBEL = 1;
    
    static
    {
      Loader.load();
    }
    
    public StereoBM()
    {
      allocate();
    }
    
    public StereoBM(int paramInt1, int paramInt2, int paramInt3)
    {
      allocate(paramInt1, paramInt2, paramInt3);
    }
    
    public StereoBM(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3);
    
    @Name({"operator()"})
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, int paramInt);
    
    public native void init(int paramInt1, int paramInt2, int paramInt3);
    
    public native CvStereoBMState state();
    
    public native StereoBM state(CvStereoBMState paramCvStereoBMState);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class StereoSGBM
    extends Pointer
  {
    public static final int DISP_SCALE = 16;
    public static final int DISP_SHIFT = 4;
    
    static
    {
      Loader.load();
    }
    
    public StereoSGBM()
    {
      allocate();
    }
    
    public StereoSGBM(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramBoolean);
    }
    
    public StereoSGBM(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean);
    
    public native int P1();
    
    public native StereoSGBM P1(int paramInt);
    
    public native int P2();
    
    public native StereoSGBM P2(int paramInt);
    
    public native int SADWindowSize();
    
    public native StereoSGBM SADWindowSize(int paramInt);
    
    @Name({"operator()"})
    public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
    
    public native int disp12MaxDiff();
    
    public native StereoSGBM disp12MaxDiff(int paramInt);
    
    public native StereoSGBM fullDP(boolean paramBoolean);
    
    public native boolean fullDP();
    
    public native int minDisparity();
    
    public native StereoSGBM minDisparity(int paramInt);
    
    public native int numberOfDisparities();
    
    public native StereoSGBM numberOfDisparities(int paramInt);
    
    public native int preFilterCap();
    
    public native StereoSGBM preFilterCap(int paramInt);
    
    public native int speckleRange();
    
    public native StereoSGBM speckleRange(int paramInt);
    
    public native int speckleWindowSize();
    
    public native StereoSGBM speckleWindowSize(int paramInt);
    
    public native int uniquenessRatio();
    
    public native StereoSGBM uniquenessRatio(int paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_calib3d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */