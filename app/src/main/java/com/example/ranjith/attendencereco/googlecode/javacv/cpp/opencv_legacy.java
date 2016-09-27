package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.Pointer.Deallocator;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.SizeTPointer;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/legacy/compat.hpp>", "<opencv2/legacy/legacy.hpp>", "<opencv2/legacy/blobtrack.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_legacy@.2.4", "opencv_ml@.2.4", "opencv_video@.2.4", "opencv_nonfree@.2.4", "opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_calib3d@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_legacy245", "opencv_ml245", "opencv_video245", "opencv_nonfree245", "opencv_features2d245", "opencv_flann245", "opencv_calib3d245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_legacy
{
  public static final int CLIQUE_END = 0;
  public static final int CLIQUE_FOUND = 1;
  public static final int CLIQUE_TIME_OFF = 2;
  public static final int CV_ARRAY = 2;
  public static final float CV_BGFG_FGD_ALPHA_1 = 0.1F;
  public static final float CV_BGFG_FGD_ALPHA_2 = 0.005F;
  public static final float CV_BGFG_FGD_ALPHA_3 = 0.1F;
  public static final float CV_BGFG_FGD_BG_UPDATE_TRESH = 0.5F;
  public static final float CV_BGFG_FGD_DELTA = 2.0F;
  public static final int CV_BGFG_FGD_LC = 128;
  public static final int CV_BGFG_FGD_LCC = 64;
  public static final float CV_BGFG_FGD_MINAREA = 15.0F;
  public static final int CV_BGFG_FGD_N1C = 15;
  public static final int CV_BGFG_FGD_N1CC = 25;
  public static final int CV_BGFG_FGD_N2C = 25;
  public static final int CV_BGFG_FGD_N2CC = 40;
  public static final float CV_BGFG_FGD_T = 0.9F;
  public static final double CV_BGFG_MOG_BACKGROUND_THRESHOLD = 0.7D;
  public static final int CV_BGFG_MOG_MAX_NGAUSSIANS = 500;
  public static final double CV_BGFG_MOG_MINAREA = 15.0D;
  public static final int CV_BGFG_MOG_NCOLORS = 3;
  public static final int CV_BGFG_MOG_NGAUSSIANS = 5;
  public static final double CV_BGFG_MOG_SIGMA_INIT = 30.0D;
  public static final double CV_BGFG_MOG_STD_THRESHOLD = 2.5D;
  public static final double CV_BGFG_MOG_WEIGHT_INIT = 0.05D;
  public static final int CV_BGFG_MOG_WINDOW_SIZE = 200;
  public static final int CV_BG_MODEL_FGD = 0;
  public static final int CV_BG_MODEL_FGD_SIMPLE = 2;
  public static final int CV_BG_MODEL_MOG = 1;
  public static final int CV_BLOB_MINH = 5;
  public static final int CV_BLOB_MINW = 5;
  public static final int CV_CALIB_ETALON_CHECKERBOARD = 0;
  public static final int CV_CALIB_ETALON_CHESSBOARD = 0;
  public static final int CV_CALIB_ETALON_USER = -1;
  public static final int CV_CAMERA_TO_WARP = 1;
  public static final int CV_CONTOUR_TREES_MATCH_I1 = 1;
  public static final int CV_DISPARITY_BIRCHFIELD = 0;
  public static final int CV_DOMINANT_IPAN = 1;
  public static final int CV_EIGOBJ_BOTH_CALLBACK = 3;
  public static final int CV_EIGOBJ_INPUT_CALLBACK = 1;
  public static final int CV_EIGOBJ_NO_CALLBACK = 0;
  public static final int CV_EIGOBJ_OUTPUT_CALLBACK = 2;
  public static final int CV_FACE_LEFT_EYE = 1;
  public static final int CV_FACE_MOUTH = 0;
  public static final int CV_FACE_RIGHT_EYE = 2;
  public static final int CV_GLCMDESC_CLUSTERSHADE = 5;
  public static final int CV_GLCMDESC_CLUSTERTENDENCY = 4;
  public static final int CV_GLCMDESC_CONTRAST = 3;
  public static final int CV_GLCMDESC_CORRELATION = 6;
  public static final int CV_GLCMDESC_CORRELATIONINFO1 = 7;
  public static final int CV_GLCMDESC_CORRELATIONINFO2 = 8;
  public static final int CV_GLCMDESC_ENERGY = 1;
  public static final int CV_GLCMDESC_ENTROPY = 0;
  public static final int CV_GLCMDESC_HOMOGENITY = 2;
  public static final int CV_GLCMDESC_MAXIMUMPROBABILITY = 9;
  public static final int CV_GLCMDESC_OPTIMIZATION_ALLOWDOUBLENEST = 10;
  public static final int CV_GLCMDESC_OPTIMIZATION_ALLOWTRIPLENEST = 11;
  public static final int CV_GLCMDESC_OPTIMIZATION_HISTOGRAM = 4;
  public static final int CV_GLCM_ALL = 0;
  public static final int CV_GLCM_DESC = 2;
  public static final int CV_GLCM_GLCM = 1;
  public static final int CV_GLCM_OPTIMIZATION_HISTOGRAM = 0;
  public static final int CV_GLCM_OPTIMIZATION_LUT = -1;
  public static final int CV_GLCM_OPTIMIZATION_NONE = -2;
  public static final int CV_IDP_BIRCHFIELD_PARAM1 = 25;
  public static final int CV_IDP_BIRCHFIELD_PARAM2 = 5;
  public static final int CV_IDP_BIRCHFIELD_PARAM3 = 12;
  public static final int CV_IDP_BIRCHFIELD_PARAM4 = 15;
  public static final int CV_IDP_BIRCHFIELD_PARAM5 = 25;
  public static final int CV_LEE_AUTO = -1;
  public static final int CV_LEE_DOUBLE = 2;
  public static final int CV_LEE_ERODE = 0;
  public static final int CV_LEE_FLOAT = 1;
  public static final int CV_LEE_INT = 0;
  public static final int CV_LEE_NON = 2;
  public static final int CV_LEE_ZOOM = 1;
  public static final int CV_NOISE_GAUSSIAN = 1;
  public static final int CV_NOISE_NONE = 0;
  public static final int CV_NOISE_SALT_AND_PEPPER = 4;
  public static final int CV_NOISE_SPECKLE = 3;
  public static final int CV_NOISE_UNIFORM = 2;
  public static final int CV_NOT_WEIGHTED = 0;
  public static final int CV_NUM_FACE_ELEMENTS = 3;
  public static final int CV_STEREO_GC_OCCLUDED = 32767;
  public static final int CV_UNDEF_SC_PARAM = 12345;
  public static final int CV_VALUE = 1;
  public static final int CV_WARP_TO_CAMERA = 2;
  public static final int CV_WEIGHTED_ALL = 3;
  public static final int CV_WEIGHTED_EDGE = 2;
  public static final int CV_WEIGHTED_VTX = 1;
  public static final int PROFILE_DOG = 1;
  public static final int PROFILE_EPANECHNIKOV;
  
  static
  {
    Loader.load(opencv_calib3d.class);
    Loader.load(opencv_features2d.class);
    Loader.load(opencv_nonfree.class);
    Loader.load(opencv_video.class);
    Loader.load(opencv_ml.class);
    Loader.load();
  }
  
  public static opencv_core.CvPoint2D32f CV_BLOB_CENTER(CvBlob paramCvBlob)
  {
    return opencv_core.cvPoint2D32f(paramCvBlob.x(), paramCvBlob.y());
  }
  
  public static int CV_BLOB_ID(CvBlob paramCvBlob)
  {
    return paramCvBlob.ID();
  }
  
  public static opencv_core.CvRect CV_BLOB_RECT(CvBlob paramCvBlob)
  {
    return opencv_core.cvRect(Math.round(paramCvBlob.x() - CV_BLOB_RX(paramCvBlob)), Math.round(paramCvBlob.y() - CV_BLOB_RY(paramCvBlob)), Math.round(CV_BLOB_WX(paramCvBlob)), Math.round(CV_BLOB_WY(paramCvBlob)));
  }
  
  public static float CV_BLOB_RX(CvBlob paramCvBlob)
  {
    return 0.5F * CV_BLOB_WX(paramCvBlob);
  }
  
  public static float CV_BLOB_RY(CvBlob paramCvBlob)
  {
    return 0.5F * CV_BLOB_WY(paramCvBlob);
  }
  
  public static float CV_BLOB_WX(CvBlob paramCvBlob)
  {
    return paramCvBlob.w();
  }
  
  public static float CV_BLOB_WY(CvBlob paramCvBlob)
  {
    return paramCvBlob.h();
  }
  
  public static float CV_BLOB_X(CvBlob paramCvBlob)
  {
    return paramCvBlob.x();
  }
  
  public static float CV_BLOB_Y(CvBlob paramCvBlob)
  {
    return paramCvBlob.y();
  }
  
  public static void CV_COUNT_OBS(opencv_core.CvSize paramCvSize1, opencv_core.CvSize paramCvSize2, opencv_core.CvSize paramCvSize3, opencv_core.CvSize paramCvSize4)
  {
    paramCvSize4.width((paramCvSize1.width() - paramCvSize2.width() + paramCvSize3.width()) / paramCvSize3.width());
    paramCvSize4.height((paramCvSize1.height() - paramCvSize2.height() + paramCvSize3.height()) / paramCvSize3.height());
  }
  
  public static int CV_CURRENT_INT(opencv_core.CvSeqReader paramCvSeqReader)
  {
    return new IntPointer(paramCvSeqReader.ptr()).get();
  }
  
  public static CvVoronoiEdge2D CV_FIRST_VORONOIEDGE2D(CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    return paramCvVoronoiSite2D.edge(0);
  }
  
  public static CvVoronoiEdge2D CV_LAST_VORONOIEDGE2D(CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    return paramCvVoronoiSite2D.edge(1);
  }
  
  public static CvVoronoiEdge2D CV_NEXT_VORONOIEDGE2D(CvVoronoiEdge2D paramCvVoronoiEdge2D, CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    CvVoronoiSite2D localCvVoronoiSite2D = paramCvVoronoiEdge2D.site(0);
    int i = 0;
    if (localCvVoronoiSite2D != paramCvVoronoiSite2D) {
      i = 1;
    }
    return paramCvVoronoiEdge2D.next(i);
  }
  
  public static CvVoronoiSite2D CV_NEXT_VORONOISITE2D(CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    CvVoronoiEdge2D localCvVoronoiEdge2D = paramCvVoronoiSite2D.edge(0);
    CvVoronoiSite2D localCvVoronoiSite2D = paramCvVoronoiSite2D.edge(0).site(0);
    int i = 0;
    if (localCvVoronoiSite2D == paramCvVoronoiSite2D) {
      i = 1;
    }
    return localCvVoronoiEdge2D.site(i);
  }
  
  public static int CV_PREV_INT(opencv_core.CvSeqReader paramCvSeqReader)
  {
    return new IntPointer(paramCvSeqReader.prev_elem()).get();
  }
  
  public static CvVoronoiEdge2D CV_PREV_VORONOIEDGE2D(CvVoronoiEdge2D paramCvVoronoiEdge2D, CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    CvVoronoiSite2D localCvVoronoiSite2D = paramCvVoronoiEdge2D.site(0);
    int i = 0;
    if (localCvVoronoiSite2D != paramCvVoronoiSite2D) {
      i = 1;
    }
    return paramCvVoronoiEdge2D.next(i + 2);
  }
  
  public static CvVoronoiSite2D CV_PREV_VORONOISITE2D(CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    int i = 1;
    CvVoronoiEdge2D localCvVoronoiEdge2D = paramCvVoronoiSite2D.edge(i);
    if (paramCvVoronoiSite2D.edge(i).site(0) == paramCvVoronoiSite2D) {}
    for (;;)
    {
      return localCvVoronoiEdge2D.site(i);
      i = 0;
    }
  }
  
  public static CvVoronoiSite2D CV_TWIN_VORONOISITE2D(CvVoronoiSite2D paramCvVoronoiSite2D, CvVoronoiEdge2D paramCvVoronoiEdge2D)
  {
    CvVoronoiSite2D localCvVoronoiSite2D = paramCvVoronoiEdge2D.site(0);
    int i = 0;
    if (localCvVoronoiSite2D == paramCvVoronoiSite2D) {
      i = 1;
    }
    return paramCvVoronoiEdge2D.site(i);
  }
  
  public static CvVoronoiNode2D CV_VORONOIEDGE2D_BEGINNODE(CvVoronoiEdge2D paramCvVoronoiEdge2D, CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    CvVoronoiSite2D localCvVoronoiSite2D = paramCvVoronoiEdge2D.site(0);
    int i = 0;
    if (localCvVoronoiSite2D != paramCvVoronoiSite2D) {
      i = 1;
    }
    return paramCvVoronoiEdge2D.node(i);
  }
  
  public static CvVoronoiNode2D CV_VORONOIEDGE2D_ENDNODE(CvVoronoiEdge2D paramCvVoronoiEdge2D, CvVoronoiSite2D paramCvVoronoiSite2D)
  {
    CvVoronoiSite2D localCvVoronoiSite2D = paramCvVoronoiEdge2D.site(0);
    int i = 0;
    if (localCvVoronoiSite2D == paramCvVoronoiSite2D) {
      i = 1;
    }
    return paramCvVoronoiEdge2D.node(i);
  }
  
  public static native int LSHSize(CvLSH paramCvLSH);
  
  public static Cv3dTracker2dTrackedObject cv3dTracker2dTrackedObject(int paramInt, opencv_core.CvPoint2D32f paramCvPoint2D32f)
  {
    Cv3dTracker2dTrackedObject localCv3dTracker2dTrackedObject = new Cv3dTracker2dTrackedObject();
    localCv3dTracker2dTrackedObject.id(paramInt);
    localCv3dTracker2dTrackedObject.p(paramCvPoint2D32f);
    return localCv3dTracker2dTrackedObject;
  }
  
  public static native boolean cv3dTrackerCalibrateCameras(int paramInt, Cv3dTrackerCameraIntrinsics paramCv3dTrackerCameraIntrinsics, @ByVal opencv_core.CvSize paramCvSize, float paramFloat, opencv_core.IplImageArray paramIplImageArray, Cv3dTrackerCameraInfo paramCv3dTrackerCameraInfo);
  
  public static native int cv3dTrackerLocateObjects(int paramInt1, int paramInt2, Cv3dTrackerCameraInfo paramCv3dTrackerCameraInfo, Cv3dTracker2dTrackedObject paramCv3dTracker2dTrackedObject, Cv3dTrackerTrackedObject paramCv3dTrackerTrackedObject);
  
  public static Cv3dTrackerTrackedObject cv3dTrackerTrackedObject(int paramInt, opencv_core.CvPoint3D32f paramCvPoint3D32f)
  {
    Cv3dTrackerTrackedObject localCv3dTrackerTrackedObject = new Cv3dTrackerTrackedObject();
    localCv3dTrackerTrackedObject.id(paramInt);
    localCv3dTrackerTrackedObject.p(paramCvPoint3D32f);
    return localCv3dTrackerTrackedObject;
  }
  
  public static native void cvBGCodeBookClearStale(CvBGCodeBookModel paramCvBGCodeBookModel, int paramInt, @ByVal opencv_core.CvRect paramCvRect, opencv_core.CvArr paramCvArr);
  
  public static native int cvBGCodeBookDiff(CvBGCodeBookModel paramCvBGCodeBookModel, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvRect paramCvRect);
  
  public static native void cvBGCodeBookUpdate(CvBGCodeBookModel paramCvBGCodeBookModel, opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvRect paramCvRect, opencv_core.CvArr paramCvArr2);
  
  public static CvBlob cvBlob(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new CvBlob().x(paramFloat1).y(paramFloat2).w(paramFloat3).h(paramFloat4).ID(0);
  }
  
  public static native void cvCalcCovarMatrixEx(int paramInt1, Pointer paramPointer1, int paramInt2, int paramInt3, @Cast({"uchar*"}) BytePointer paramBytePointer, Pointer paramPointer2, opencv_core.IplImage paramIplImage, FloatPointer paramFloatPointer);
  
  public static native void cvCalcCovarMatrixEx(int paramInt1, Pointer paramPointer1, int paramInt2, int paramInt3, @Cast({"uchar*"}) BytePointer paramBytePointer, Pointer paramPointer2, opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
  
  public static void cvCalcCovarMatrixEx(int paramInt1, opencv_core.IplImage[] paramArrayOfIplImage, int paramInt2, int paramInt3, @Cast({"uchar*"}) BytePointer paramBytePointer, Pointer paramPointer, opencv_core.IplImage paramIplImage, FloatPointer paramFloatPointer)
  {
    cvCalcCovarMatrixEx(paramInt1, new opencv_core.IplImageArray(paramArrayOfIplImage), paramInt2, paramInt3, paramBytePointer, paramPointer, paramIplImage, paramFloatPointer);
  }
  
  public static void cvCalcCovarMatrixEx(int paramInt1, opencv_core.IplImage[] paramArrayOfIplImage, int paramInt2, int paramInt3, @Cast({"uchar*"}) BytePointer paramBytePointer, Pointer paramPointer, opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat)
  {
    cvCalcCovarMatrixEx(paramInt1, new opencv_core.IplImageArray(paramArrayOfIplImage), paramInt2, paramInt3, paramBytePointer, paramPointer, paramIplImage, paramArrayOfFloat);
  }
  
  public static native double cvCalcDecompCoeff(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3);
  
  public static native void cvCalcEigenObjects(int paramInt1, Pointer paramPointer1, Pointer paramPointer2, int paramInt2, int paramInt3, Pointer paramPointer3, opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.IplImage paramIplImage, FloatPointer paramFloatPointer);
  
  public static native void cvCalcEigenObjects(int paramInt1, Pointer paramPointer1, Pointer paramPointer2, int paramInt2, int paramInt3, Pointer paramPointer3, opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
  
  public static void cvCalcEigenObjects(int paramInt1, opencv_core.IplImage[] paramArrayOfIplImage1, opencv_core.IplImage[] paramArrayOfIplImage2, int paramInt2, int paramInt3, Pointer paramPointer, opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.IplImage paramIplImage, FloatPointer paramFloatPointer)
  {
    cvCalcEigenObjects(paramInt1, new opencv_core.IplImageArray(paramArrayOfIplImage1), new opencv_core.IplImageArray(paramArrayOfIplImage2), paramInt2, paramInt3, paramPointer, paramCvTermCriteria, paramIplImage, paramFloatPointer);
  }
  
  public static void cvCalcEigenObjects(int paramInt1, opencv_core.IplImage[] paramArrayOfIplImage1, opencv_core.IplImage[] paramArrayOfIplImage2, int paramInt2, int paramInt3, Pointer paramPointer, opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat)
  {
    cvCalcEigenObjects(paramInt1, new opencv_core.IplImageArray(paramArrayOfIplImage1), new opencv_core.IplImageArray(paramArrayOfIplImage2), paramInt2, paramInt3, paramPointer, paramCvTermCriteria, paramIplImage, paramArrayOfFloat);
  }
  
  public static native void cvCalcImageHomography(FloatPointer paramFloatPointer1, opencv_core.CvPoint3D32f paramCvPoint3D32f, FloatPointer paramFloatPointer2, FloatPointer paramFloatPointer3);
  
  public static native void cvCalcImageHomography(float[] paramArrayOfFloat1, opencv_core.CvPoint3D32f paramCvPoint3D32f, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
  
  public static native void cvCalcOpticalFlowBM(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3, int paramInt, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
  
  public static native void cvCalcOpticalFlowHS(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, double paramDouble, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
  
  public static native void cvCalcOpticalFlowLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
  
  public static native void cvCalcPGH(opencv_core.CvSeq paramCvSeq, opencv_imgproc.CvHistogram paramCvHistogram);
  
  public static native void cvCalcSubdivVoronoi2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D);
  
  public static native int cvChangeDetection(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3);
  
  public static native void cvClearSubdivVoronoi2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D);
  
  public static native void cvComputePerspectiveMap(@Cast({"double(*)[3]"}) DoublePointer paramDoublePointer, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
  
  public static native void cvComputePerspectiveMap(@Cast({"double(*)[3]"}) double[] paramArrayOfDouble, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
  
  public static native void cvConDensInitSampleSet(CvConDensation paramCvConDensation, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
  
  public static native void cvConDensUpdateByTime(CvConDensation paramCvConDensation);
  
  public static native opencv_core.CvSeq cvContourFromContourTree(CvContourTree paramCvContourTree, opencv_core.CvMemStorage paramCvMemStorage, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
  
  public static native CvEHMM cvCreate2DHMM(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  public static native CvBGCodeBookModel cvCreateBGCodeBookModel();
  
  public static native CvBlobDetector cvCreateBlobDetectorCC();
  
  public static native CvBlobDetector cvCreateBlobDetectorSimple();
  
  public static native CvBlobTrackAnalysis cvCreateBlobTrackAnalysisList(CreateCvBlobTrackAnalysisOne paramCreateCvBlobTrackAnalysisOne);
  
  public static native CvBlobTrackPostProc cvCreateBlobTrackPostProcList(CreateCvBlobTrackPostProcOne paramCreateCvBlobTrackPostProcOne);
  
  public static native CvBlobTrackerAuto cvCreateBlobTrackerAuto(int paramInt, Pointer paramPointer);
  
  public static native CvBlobTrackerAuto cvCreateBlobTrackerAuto1(CvBlobTrackerAutoParam1 paramCvBlobTrackerAutoParam1);
  
  public static native CvBlobTracker cvCreateBlobTrackerCC();
  
  public static native CvBlobTracker cvCreateBlobTrackerCCMSPF();
  
  public static native CvBlobTracker cvCreateBlobTrackerList(CreateCvBlobTrackerOne paramCreateCvBlobTrackerOne);
  
  public static native CvBlobTracker cvCreateBlobTrackerMS();
  
  public static native CvBlobTracker cvCreateBlobTrackerMSFG();
  
  public static native CvBlobTracker cvCreateBlobTrackerMSFGS();
  
  public static native CvBlobTracker cvCreateBlobTrackerMSPF();
  
  public static native CvConDensation cvCreateConDensation(int paramInt1, int paramInt2, int paramInt3);
  
  public static native CvContourTree cvCreateContourTree(opencv_core.CvSeq paramCvSeq, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble);
  
  public static native CvBGStatModel cvCreateFGDStatModel(opencv_core.IplImage paramIplImage, CvFGDStatModelParams paramCvFGDStatModelParams);
  
  public static native CvFGDetector cvCreateFGDetectorBase(int paramInt, Pointer paramPointer);
  
  public static native CvGLCM cvCreateGLCM(opencv_core.IplImage paramIplImage, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3);
  
  public static native void cvCreateGLCMDescriptors(CvGLCM paramCvGLCM, int paramInt);
  
  public static native opencv_core.IplImage cvCreateGLCMImage(CvGLCM paramCvGLCM, int paramInt);
  
  public static native CvBGStatModel cvCreateGaussianBGModel(opencv_core.IplImage paramIplImage, CvGaussBGStatModelParams paramCvGaussBGStatModelParams);
  
  public static native void cvCreateHandMask(opencv_core.CvSeq paramCvSeq, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect);
  
  public static native opencv_imgproc.CvFeatureTree cvCreateKDTree(opencv_core.CvMat paramCvMat);
  
  public static native CvLSH cvCreateLSH(CvLSHOperations paramCvLSHOperations, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, long paramLong);
  
  public static native CvLSH cvCreateMemoryLSH(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, long paramLong);
  
  public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistP();
  
  public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistPV();
  
  public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistPVS();
  
  public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistSS();
  
  public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisIOR();
  
  public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisTrackDist();
  
  public static native CvBlobTrackGen cvCreateModuleBlobTrackGen1();
  
  public static native CvBlobTrackGen cvCreateModuleBlobTrackGenYML();
  
  public static native CvBlobTrackPostProc cvCreateModuleBlobTrackPostProcKalman();
  
  public static native CvBlobTrackPostProc cvCreateModuleBlobTrackPostProcTimeAverExp();
  
  public static native CvBlobTrackPostProc cvCreateModuleBlobTrackPostProcTimeAverRect();
  
  public static native CvBlobTrackPredictor cvCreateModuleBlobTrackPredictKalman();
  
  public static native CvImgObsInfo cvCreateObsInfo(@ByVal opencv_core.CvSize paramCvSize, int paramInt);
  
  public static native opencv_imgproc.CvFeatureTree cvCreateSpillTree(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2);
  
  public static native CvStereoGCState cvCreateStereoGCState(int paramInt1, int paramInt2);
  
  public static native opencv_imgproc.CvSubdiv2D cvCreateSubdiv2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, opencv_core.CvMemStorage paramCvMemStorage);
  
  public static opencv_imgproc.CvSubdiv2D cvCreateSubdivDelaunay2D(opencv_core.CvRect paramCvRect, opencv_core.CvMemStorage paramCvMemStorage)
  {
    opencv_imgproc.CvSubdiv2D localCvSubdiv2D = cvCreateSubdiv2D(8192, Loader.sizeof(opencv_imgproc.CvSubdiv2D.class), Loader.sizeof(opencv_imgproc.CvSubdiv2DPoint.class), Loader.sizeof(opencv_imgproc.CvQuadEdge2D.class), paramCvMemStorage);
    cvInitSubdivDelaunay2D(localCvSubdiv2D, paramCvRect);
    return localCvSubdiv2D;
  }
  
  public static native CvTestSeq cvCreateTestSeq(@Cast({"char*"}) String paramString, @Cast({"char**"}) PointerPointer paramPointerPointer, int paramInt1, float paramFloat, int paramInt2, double paramDouble);
  
  public static native void cvDeInterlace(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3);
  
  public static native void cvDeleteMoire(opencv_core.IplImage paramIplImage);
  
  public static CvDetectedBlob cvDetectedBlob(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5)
  {
    CvDetectedBlob localCvDetectedBlob = new CvDetectedBlob();
    localCvDetectedBlob.x(paramFloat1).y(paramFloat2).w(paramFloat3).h(paramFloat4).ID(paramInt);
    localCvDetectedBlob.response(paramFloat5);
    return localCvDetectedBlob;
  }
  
  public static native void cvDynamicCorrespondMulti(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6);
  
  public static native float cvEViterbi(CvImgObsInfo paramCvImgObsInfo, CvEHMM paramCvEHMM);
  
  public static native void cvEigenDecomposite(opencv_core.IplImage paramIplImage1, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, opencv_core.IplImage paramIplImage2, FloatPointer paramFloatPointer);
  
  public static native void cvEigenDecomposite(opencv_core.IplImage paramIplImage1, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, opencv_core.IplImage paramIplImage2, float[] paramArrayOfFloat);
  
  public static void cvEigenDecomposite(opencv_core.IplImage paramIplImage1, int paramInt1, opencv_core.IplImage[] paramArrayOfIplImage, int paramInt2, Pointer paramPointer, opencv_core.IplImage paramIplImage2, FloatPointer paramFloatPointer)
  {
    cvEigenDecomposite(paramIplImage1, paramInt1, new opencv_core.IplImageArray(paramArrayOfIplImage), paramInt2, paramPointer, paramIplImage2, paramFloatPointer);
  }
  
  public static void cvEigenDecomposite(opencv_core.IplImage paramIplImage1, int paramInt1, opencv_core.IplImage[] paramArrayOfIplImage, int paramInt2, Pointer paramPointer, opencv_core.IplImage paramIplImage2, float[] paramArrayOfFloat)
  {
    cvEigenDecomposite(paramIplImage1, paramInt1, new opencv_core.IplImageArray(paramArrayOfIplImage), paramInt2, paramPointer, paramIplImage2, paramArrayOfFloat);
  }
  
  public static native void cvEigenProjection(Pointer paramPointer1, int paramInt1, int paramInt2, Pointer paramPointer2, FloatPointer paramFloatPointer, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  
  public static native void cvEigenProjection(Pointer paramPointer1, int paramInt1, int paramInt2, Pointer paramPointer2, float[] paramArrayOfFloat, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  
  public static void cvEigenProjection(opencv_core.IplImage[] paramArrayOfIplImage, int paramInt1, int paramInt2, Pointer paramPointer, FloatPointer paramFloatPointer, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2)
  {
    cvEigenProjection(new opencv_core.IplImageArray(paramArrayOfIplImage), paramInt1, paramInt2, paramPointer, paramFloatPointer, paramIplImage1, paramIplImage2);
  }
  
  public static void cvEigenProjection(opencv_core.IplImage[] paramArrayOfIplImage, int paramInt1, int paramInt2, Pointer paramPointer, float[] paramArrayOfFloat, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2)
  {
    cvEigenProjection(new opencv_core.IplImageArray(paramArrayOfIplImage), paramInt1, paramInt2, paramPointer, paramArrayOfFloat, paramIplImage1, paramIplImage2);
  }
  
  public static native void cvEstimateHMMStateParams(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
  
  public static native void cvEstimateObsProb(CvImgObsInfo paramCvImgObsInfo, CvEHMM paramCvEHMM);
  
  public static native void cvEstimateTransProb(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
  
  public static native void cvExtractSURF(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByPtrPtr opencv_core.CvSeq paramCvSeq1, @ByPtrPtr opencv_core.CvSeq paramCvSeq2, opencv_core.CvMemStorage paramCvMemStorage, @ByVal CvSURFParams paramCvSURFParams, int paramInt);
  
  public static native opencv_core.CvSeq cvFindDominantPoints(opencv_core.CvSeq paramCvSeq, opencv_core.CvMemStorage paramCvMemStorage, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  public static native void cvFindFeatures(opencv_imgproc.CvFeatureTree paramCvFeatureTree, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt1, int paramInt2);
  
  public static native int cvFindFeaturesBoxed(opencv_imgproc.CvFeatureTree paramCvFeatureTree, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
  
  public static native void cvFindHandRegion(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
  
  public static native void cvFindHandRegion(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, float[] paramArrayOfFloat, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
  
  public static native void cvFindHandRegionA(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
  
  public static native void cvFindHandRegionA(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, float[] paramArrayOfFloat, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
  
  public static native opencv_imgproc.CvSubdiv2DPoint cvFindNearestPoint2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f);
  
  public static native void cvFindRuns(int paramInt, @Cast({"uchar*"}) BytePointer paramBytePointer1, @Cast({"uchar*"}) BytePointer paramBytePointer2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6);
  
  public static native void cvFindStereoCorrespondence(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, opencv_core.CvArr paramCvArr3, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5);
  
  public static native void cvFindStereoCorrespondenceGC(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, CvStereoGCState paramCvStereoGCState, int paramInt);
  
  public static native double cvGetGLCMDescriptor(CvGLCM paramCvGLCM, int paramInt1, int paramInt2);
  
  public static native void cvGetGLCMDescriptorStatistics(CvGLCM paramCvGLCM, int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public static Pointer cvGetHistValue_1D(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt)
  {
    return opencv_core.cvPtr1D(paramCvHistogram.bins(), paramInt, null);
  }
  
  public static Pointer cvGetHistValue_2D(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt1, int paramInt2)
  {
    return opencv_core.cvPtr2D(paramCvHistogram.bins(), paramInt1, paramInt2, null);
  }
  
  public static Pointer cvGetHistValue_3D(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt1, int paramInt2, int paramInt3)
  {
    return opencv_core.cvPtr3D(paramCvHistogram.bins(), paramInt1, paramInt2, paramInt3, null);
  }
  
  public static Pointer cvGetHistValue_nD(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt, int[] paramArrayOfInt)
  {
    return opencv_core.cvPtrND(paramCvHistogram.bins(), paramArrayOfInt, null, 1, null);
  }
  
  public static opencv_core.CvSeq cvGetStarKeypoints(opencv_core.CvArr paramCvArr, opencv_core.CvMemStorage paramCvMemStorage)
  {
    return cvGetStarKeypoints(paramCvArr, paramCvMemStorage, cvStarDetectorParams());
  }
  
  public static native opencv_core.CvSeq cvGetStarKeypoints(opencv_core.CvArr paramCvArr, opencv_core.CvMemStorage paramCvMemStorage, @ByVal CvStarDetectorParams paramCvStarDetectorParams);
  
  public static native void cvImgToObs_DCT(opencv_core.CvArr paramCvArr, FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3);
  
  public static native void cvImgToObs_DCT(opencv_core.CvArr paramCvArr, float[] paramArrayOfFloat, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3);
  
  public static native CvFaceTracker cvInitFaceTracker(CvFaceTracker paramCvFaceTracker, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect, int paramInt);
  
  public static native void cvInitMixSegm(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
  
  public static native void cvInitPerspectiveTransform(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, @Cast({"double(*)[3]"}) DoublePointer paramDoublePointer, opencv_core.CvArr paramCvArr);
  
  public static native void cvInitPerspectiveTransform(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, @Cast({"double(*)[3]"}) double[] paramArrayOfDouble, opencv_core.CvArr paramCvArr);
  
  public static native void cvInitSubdivDelaunay2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvRect paramCvRect);
  
  public static native void cvLSHAdd(CvLSH paramCvLSH, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
  
  public static native void cvLSHQuery(CvLSH paramCvLSH, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt1, int paramInt2);
  
  public static native void cvLSHRemove(CvLSH paramCvLSH, opencv_core.CvMat paramCvMat);
  
  public static native opencv_core.CvGraph cvLinearContorModelFromVoronoiDiagram(CvVoronoiDiagram2D paramCvVoronoiDiagram2D, float paramFloat);
  
  public static native void cvMakeAlphaScanlines(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int paramInt, float paramFloat);
  
  public static native void cvMakeScanlines(@Cast({"CvMatrix3*"}) FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
  
  public static native void cvMakeScanlines(@Cast({"CvMatrix3*"}) float[] paramArrayOfFloat, @ByVal opencv_core.CvSize paramCvSize, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
  
  public static native double cvMatchContourTrees(CvContourTree paramCvContourTree1, CvContourTree paramCvContourTree2, int paramInt, double paramDouble);
  
  public static native void cvMixSegmL2(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
  
  public static native void cvMorphEpilinesMulti(int paramInt, @Cast({"uchar*"}) BytePointer paramBytePointer1, int[] paramArrayOfInt1, @Cast({"uchar*"}) BytePointer paramBytePointer2, int[] paramArrayOfInt2, @Cast({"uchar*"}) BytePointer paramBytePointer3, int[] paramArrayOfInt3, float paramFloat, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7, int[] paramArrayOfInt8, int[] paramArrayOfInt9);
  
  public static native void cvPostWarpImage(int paramInt, @Cast({"uchar*"}) BytePointer paramBytePointer, int[] paramArrayOfInt1, opencv_core.IplImage paramIplImage, int[] paramArrayOfInt2);
  
  public static native void cvPreWarpImage(int paramInt, opencv_core.IplImage paramIplImage, @Cast({"uchar*"}) BytePointer paramBytePointer, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static native void cvPyrSegmentation(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq, int paramInt, double paramDouble1, double paramDouble2);
  
  public static float cvQueryHistValue_1D(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt)
  {
    return (float)opencv_core.cvGetReal1D(paramCvHistogram.bins(), paramInt);
  }
  
  public static float cvQueryHistValue_2D(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt1, int paramInt2)
  {
    return (float)opencv_core.cvGetReal2D(paramCvHistogram.bins(), paramInt1, paramInt2);
  }
  
  public static float cvQueryHistValue_3D(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt1, int paramInt2, int paramInt3)
  {
    return (float)opencv_core.cvGetReal3D(paramCvHistogram.bins(), paramInt1, paramInt2, paramInt3);
  }
  
  public static float cvQueryHistValue_nD(opencv_imgproc.CvHistogram paramCvHistogram, int paramInt, int[] paramArrayOfInt)
  {
    return (float)opencv_core.cvGetRealND(paramCvHistogram.bins(), paramArrayOfInt);
  }
  
  public static native void cvReadStructByName(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, String paramString1, Pointer paramPointer, String paramString2);
  
  @ByVal
  public static native opencv_core.CvRect cvRectIntersection(@ByVal opencv_core.CvRect paramCvRect1, @ByVal opencv_core.CvRect paramCvRect2);
  
  public static native void cvRefineForegroundMaskBySegm(opencv_core.CvSeq paramCvSeq, CvBGStatModel paramCvBGStatModel);
  
  public static native void cvRelease2DHMM(@ByPtrPtr CvEHMM paramCvEHMM);
  
  public static native void cvReleaseBGCodeBookModel(@ByPtrPtr CvBGCodeBookModel paramCvBGCodeBookModel);
  
  public static native void cvReleaseBGStatModel(@ByPtrPtr CvBGStatModel paramCvBGStatModel);
  
  public static native void cvReleaseBlobDetector(@ByPtrPtr CvBlobDetector paramCvBlobDetector);
  
  public static native void cvReleaseBlobTrackAnalysis(@ByPtrPtr CvBlobTrackAnalysis paramCvBlobTrackAnalysis);
  
  public static native void cvReleaseBlobTrackGen(@ByPtrPtr CvBlobTrackGen paramCvBlobTrackGen);
  
  public static native void cvReleaseBlobTrackPostProc(@ByPtrPtr CvBlobTrackPostProc paramCvBlobTrackPostProc);
  
  public static native void cvReleaseBlobTracker(@ByPtrPtr CvBlobTracker paramCvBlobTracker);
  
  public static native void cvReleaseBlobTrackerAuto(@ByPtrPtr CvBlobTrackerAuto paramCvBlobTrackerAuto);
  
  public static native void cvReleaseBlobTrackerOne(@ByPtrPtr CvBlobTrackerOne paramCvBlobTrackerOne);
  
  public static native void cvReleaseConDensation(@ByPtrPtr CvConDensation paramCvConDensation);
  
  public static native void cvReleaseFGDetector(@ByPtrPtr CvFGDetector paramCvFGDetector);
  
  public static native void cvReleaseFaceTracker(@ByPtrPtr CvFaceTracker paramCvFaceTracker);
  
  public static native void cvReleaseFeatureTree(opencv_imgproc.CvFeatureTree paramCvFeatureTree);
  
  public static native void cvReleaseGLCM(@ByPtrPtr CvGLCM paramCvGLCM, int paramInt);
  
  public static native void cvReleaseLSH(@ByPtrPtr CvLSH paramCvLSH);
  
  public static native int cvReleaseLinearContorModelStorage(@ByPtrPtr opencv_core.CvGraph paramCvGraph);
  
  public static native void cvReleaseObsInfo(@ByPtrPtr CvImgObsInfo paramCvImgObsInfo);
  
  public static native void cvReleaseProb(@ByPtrPtr CvProb paramCvProb);
  
  public static native void cvReleaseStereoGCState(@ByPtrPtr CvStereoGCState paramCvStereoGCState);
  
  public static native void cvReleaseTestSeq(@ByPtrPtr CvTestSeq paramCvTestSeq);
  
  public static native void cvReleaseVoronoiStorage(CvVoronoiDiagram2D paramCvVoronoiDiagram2D, @ByPtrPtr opencv_core.CvMemStorage paramCvMemStorage);
  
  @ByVal
  public static native CvSURFParams cvSURFParams(double paramDouble, int paramInt);
  
  public static CvSURFPoint cvSURFPoint(opencv_core.CvPoint2D32f paramCvPoint2D32f, int paramInt1, int paramInt2)
  {
    return cvSURFPoint(paramCvPoint2D32f, paramInt1, paramInt2, 0.0F, 0.0F);
  }
  
  public static CvSURFPoint cvSURFPoint(opencv_core.CvPoint2D32f paramCvPoint2D32f, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    CvSURFPoint localCvSURFPoint = new CvSURFPoint();
    localCvSURFPoint.pt(paramCvPoint2D32f);
    localCvSURFPoint.laplacian(paramInt1);
    localCvSURFPoint.size(paramInt2);
    localCvSURFPoint.dir(paramFloat1);
    localCvSURFPoint.hessian(paramFloat2);
    return localCvSURFPoint;
  }
  
  public static native opencv_core.CvSeq cvSegmentFGMask(opencv_core.CvArr paramCvArr, int paramInt, float paramFloat, opencv_core.CvMemStorage paramCvMemStorage, @ByVal opencv_core.CvPoint paramCvPoint);
  
  public static native opencv_core.CvSeq cvSegmentImage(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage);
  
  public static native void cvSnakeImage(opencv_core.IplImage paramIplImage, opencv_core.CvPoint paramCvPoint, int paramInt1, FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2, FloatPointer paramFloatPointer3, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
  
  public static native void cvSnakeImage(opencv_core.IplImage paramIplImage, opencv_core.CvPoint paramCvPoint, int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
  
  public static CvStarDetectorParams cvStarDetectorParams()
  {
    return cvStarDetectorParams(45, 30, 10, 8, 5);
  }
  
  public static CvStarDetectorParams cvStarDetectorParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    CvStarDetectorParams localCvStarDetectorParams = new CvStarDetectorParams();
    localCvStarDetectorParams.maxSize(paramInt1);
    localCvStarDetectorParams.responseThreshold(paramInt2);
    localCvStarDetectorParams.lineThresholdProjected(paramInt3);
    localCvStarDetectorParams.lineThresholdBinarized(paramInt4);
    localCvStarDetectorParams.suppressNonmaxSize(paramInt5);
    return localCvStarDetectorParams;
  }
  
  public static CvStarKeypoint cvStarKeypoint(opencv_core.CvPoint paramCvPoint, int paramInt, float paramFloat)
  {
    CvStarKeypoint localCvStarKeypoint = new CvStarKeypoint();
    localCvStarKeypoint.pt(paramCvPoint);
    localCvStarKeypoint.size(paramInt);
    localCvStarKeypoint.response(paramFloat);
    return localCvStarKeypoint;
  }
  
  public static native opencv_imgproc.CvSubdiv2DPoint cvSubdiv2DEdgeDst(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge);
  
  public static native opencv_imgproc.CvSubdiv2DPoint cvSubdiv2DEdgeOrg(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge);
  
  @ByVal
  public static native opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DGetEdge(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge, @Cast({"CvNextEdgeType"}) int paramInt);
  
  public static native int cvSubdiv2DLocate(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @Cast({"CvSubdiv2DEdge*"}) SizeTPointer paramSizeTPointer, @ByPtrPtr opencv_imgproc.CvSubdiv2DPoint paramCvSubdiv2DPoint);
  
  public static opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DNextEdge(opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge)
  {
    return opencv_imgproc.CV_SUBDIV2D_NEXT_EDGE(paramCvSubdiv2DEdge);
  }
  
  @ByVal
  public static native opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DRotateEdge(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge, int paramInt);
  
  @ByVal
  public static native opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DSymEdge(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge);
  
  public static native opencv_imgproc.CvSubdiv2DPoint cvSubdivDelaunay2DInsert(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f);
  
  public static native void cvTestSeqAddIntensityVariation(CvTestSeq paramCvTestSeq, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native void cvTestSeqAddNoise(CvTestSeq paramCvTestSeq, int paramInt, double paramDouble);
  
  public static native int cvTestSeqFrameNum(CvTestSeq paramCvTestSeq);
  
  public static native opencv_core.IplImage cvTestSeqGetFGMask(CvTestSeq paramCvTestSeq);
  
  public static native opencv_core.IplImage cvTestSeqGetImage(CvTestSeq paramCvTestSeq);
  
  @ByVal
  public static native opencv_core.CvSize cvTestSeqGetImageSize(CvTestSeq paramCvTestSeq);
  
  public static native int cvTestSeqGetObjectNum(CvTestSeq paramCvTestSeq);
  
  public static native int cvTestSeqGetObjectPos(CvTestSeq paramCvTestSeq, int paramInt, opencv_core.CvPoint2D32f paramCvPoint2D32f);
  
  public static native int cvTestSeqGetObjectSize(CvTestSeq paramCvTestSeq, int paramInt, opencv_core.CvPoint2D32f paramCvPoint2D32f);
  
  public static native opencv_core.IplImage cvTestSeqQueryFrame(CvTestSeq paramCvTestSeq);
  
  public static native void cvTestSeqSetFrame(CvTestSeq paramCvTestSeq, int paramInt);
  
  public static native int cvTrackFace(CvFaceTracker paramCvFaceTracker, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect, int paramInt, opencv_core.CvPoint paramCvPoint, double[] paramArrayOfDouble);
  
  public static native double cvTriangleArea(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f3);
  
  public static native void cvUniformImgSegm(CvImgObsInfo paramCvImgObsInfo, CvEHMM paramCvEHMM);
  
  public static native int cvUpdateBGStatModel(opencv_core.IplImage paramIplImage, CvBGStatModel paramCvBGStatModel, double paramDouble);
  
  public static native int cvVoronoiDiagramFromContour(opencv_core.CvSeq paramCvSeq, @ByPtrPtr CvVoronoiDiagram2D paramCvVoronoiDiagram2D, opencv_core.CvMemStorage paramCvMemStorage, @Cast({"CvLeeParameters"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native int cvVoronoiDiagramFromImage(opencv_core.IplImage paramIplImage, @ByPtrPtr opencv_core.CvSeq paramCvSeq, @ByPtrPtr CvVoronoiDiagram2D paramCvVoronoiDiagram2D, opencv_core.CvMemStorage paramCvMemStorage, @Cast({"CvLeeParameters"}) int paramInt, float paramFloat);
  
  public static native void cvWriteStruct(opencv_core.CvFileStorage paramCvFileStorage, String paramString1, Pointer paramPointer, String paramString2, int paramInt);
  
  public static native int icvComCoeffForLine(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f4, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, DoublePointer paramDoublePointer4, DoublePointer paramDoublePointer5, DoublePointer paramDoublePointer6, CvStereoLineCoeff paramCvStereoLineCoeff, int[] paramArrayOfInt);
  
  public static native int icvComCoeffForLine(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f4, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4, double[] paramArrayOfDouble5, double[] paramArrayOfDouble6, CvStereoLineCoeff paramCvStereoLineCoeff, int[] paramArrayOfInt);
  
  public static native int icvCompute3DPoint(double paramDouble1, double paramDouble2, CvStereoLineCoeff paramCvStereoLineCoeff, opencv_core.CvPoint3D64f paramCvPoint3D64f);
  
  public static native int icvComputeCoeffForStereo(CvStereoCamera paramCvStereoCamera);
  
  public static native int icvComputeRestStereoParams(CvStereoCamera paramCvStereoCamera);
  
  public static native int icvComputeStereoLineCoeffs(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f3, double paramDouble, CvStereoLineCoeff paramCvStereoLineCoeff);
  
  public static native void icvComputeStereoParamsForCameras(CvStereoCamera paramCvStereoCamera);
  
  public static native void icvComputeeInfiniteProject1(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2);
  
  public static native void icvComputeeInfiniteProject1(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2);
  
  public static native void icvComputeeInfiniteProject2(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2);
  
  public static native void icvComputeeInfiniteProject2(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2);
  
  public static native int icvConvertPointSystem(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2);
  
  public static native int icvConvertPointSystem(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public static native int icvConvertWarpCoordinates(@Cast({"double(*)[3]"}) DoublePointer paramDoublePointer, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt);
  
  public static native int icvConvertWarpCoordinates(@Cast({"double(*)[3]"}) double[] paramArrayOfDouble, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt);
  
  public static native int icvCreateConvertMatrVect(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, DoublePointer paramDoublePointer4, DoublePointer paramDoublePointer5, DoublePointer paramDoublePointer6);
  
  public static native int icvCreateConvertMatrVect(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4, double[] paramArrayOfDouble5, double[] paramArrayOfDouble6);
  
  public static native opencv_core.IplImage icvCreateIsometricImage(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, int paramInt1, int paramInt2);
  
  public static native float icvDefinePointPosition(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f3);
  
  public static native void icvDrawMosaic(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  
  public static native int icvGetAngleLine(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D64f paramCvPoint2D64f2, opencv_core.CvPoint2D64f paramCvPoint2D64f3);
  
  public static native void icvGetCoefForPiece(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, int[] paramArrayOfInt);
  
  public static native void icvGetCrossDirectDirect(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, opencv_core.CvPoint2D64f paramCvPoint2D64f, int[] paramArrayOfInt);
  
  public static native void icvGetCrossDirectDirect(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvPoint2D64f paramCvPoint2D64f, int[] paramArrayOfInt);
  
  public static native int icvGetCrossLineDirect(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, float paramFloat1, float paramFloat2, float paramFloat3, opencv_core.CvPoint2D32f paramCvPoint2D32f3);
  
  public static native int icvGetCrossLines(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f3, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f4, opencv_core.CvPoint3D64f paramCvPoint3D64f5);
  
  public static native void icvGetCrossPieceDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, double paramDouble1, double paramDouble2, double paramDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f3, int[] paramArrayOfInt);
  
  public static native void icvGetCrossPiecePiece(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f4, opencv_core.CvPoint2D64f paramCvPoint2D64f5, int[] paramArrayOfInt);
  
  public static native int icvGetCrossPieceVector(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f3, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f4, opencv_core.CvPoint2D32f paramCvPoint2D32f5);
  
  public static native void icvGetCrossRectDirect(@ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, double paramDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f1, opencv_core.CvPoint2D64f paramCvPoint2D64f2, int[] paramArrayOfInt);
  
  public static native void icvGetCutPiece(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D64f paramCvPoint2D64f2, opencv_core.CvPoint2D64f paramCvPoint2D64f3, opencv_core.CvPoint2D64f paramCvPoint2D64f4, opencv_core.CvPoint2D64f paramCvPoint2D64f5, int[] paramArrayOfInt);
  
  public static native void icvGetCutPiece(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D64f paramCvPoint2D64f2, opencv_core.CvPoint2D64f paramCvPoint2D64f3, opencv_core.CvPoint2D64f paramCvPoint2D64f4, opencv_core.CvPoint2D64f paramCvPoint2D64f5, int[] paramArrayOfInt);
  
  public static native int icvGetDirectionForPoint(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, DoublePointer paramDoublePointer, opencv_core.CvPoint3D64f paramCvPoint3D64f);
  
  public static native int icvGetDirectionForPoint(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble, opencv_core.CvPoint3D64f paramCvPoint3D64f);
  
  public static native void icvGetDistanceFromPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, DoublePointer paramDoublePointer, double[] paramArrayOfDouble);
  
  public static native void icvGetDistanceFromPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public static native void icvGetMiddleAnglePoint(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, opencv_core.CvPoint2D64f paramCvPoint2D64f4);
  
  public static native void icvGetNormalDirect(DoublePointer paramDoublePointer1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, DoublePointer paramDoublePointer2);
  
  public static native void icvGetNormalDirect(double[] paramArrayOfDouble1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble2);
  
  public static native void icvGetPieceLength(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, double[] paramArrayOfDouble);
  
  public static native void icvGetPieceLength3D(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, double[] paramArrayOfDouble);
  
  public static native void icvGetQuadsTransform(@ByVal opencv_core.CvSize paramCvSize1, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, DoublePointer paramDoublePointer4, DoublePointer paramDoublePointer5, DoublePointer paramDoublePointer6, opencv_core.CvSize paramCvSize2, @Cast({"double(*)[2]"}) DoublePointer paramDoublePointer7, @Cast({"double(*)[2]"}) DoublePointer paramDoublePointer8, DoublePointer paramDoublePointer9, opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2);
  
  public static native void icvGetQuadsTransform(@ByVal opencv_core.CvSize paramCvSize1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4, double[] paramArrayOfDouble5, double[] paramArrayOfDouble6, opencv_core.CvSize paramCvSize2, @Cast({"double(*)[2]"}) double[] paramArrayOfDouble7, @Cast({"double(*)[2]"}) double[] paramArrayOfDouble8, double[] paramArrayOfDouble9, opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2);
  
  public static native void icvGetQuadsTransformStruct(CvStereoCamera paramCvStereoCamera);
  
  public static native int icvGetSymPoint3D(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f3, opencv_core.CvPoint3D64f paramCvPoint3D64f4);
  
  public static native double icvGetVect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3);
  
  public static native void icvProjectPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, DoublePointer paramDoublePointer, opencv_core.CvPoint2D64f paramCvPoint2D64f2);
  
  public static native void icvProjectPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, double[] paramArrayOfDouble, opencv_core.CvPoint2D64f paramCvPoint2D64f2);
  
  public static native void icvProjectPointToImage(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, opencv_core.CvPoint2D64f paramCvPoint2D64f);
  
  public static native void icvProjectPointToImage(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f);
  
  public static double icvSqDist2D32f(opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2)
  {
    double d1 = paramCvPoint2D32f1.x() - paramCvPoint2D32f2.x();
    double d2 = paramCvPoint2D32f1.y() - paramCvPoint2D32f2.y();
    return d1 * d1 + d2 * d2;
  }
  
  public static native int icvStereoCalibration(int paramInt, int[] paramArrayOfInt, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, opencv_core.CvPoint3D32f paramCvPoint3D32f, CvStereoCamera paramCvStereoCamera);
  
  public static native int icvSubdiv2DCheck(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D);
  
  public static int iplHeight(opencv_core.IplImage paramIplImage)
  {
    if (paramIplImage == null) {
      return 0;
    }
    if (paramIplImage.roi() == null) {
      return paramIplImage.height();
    }
    return paramIplImage.roi().height();
  }
  
  public static int iplWidth(opencv_core.IplImage paramIplImage)
  {
    if (paramIplImage == null) {
      return 0;
    }
    if (paramIplImage.roi() == null) {
      return paramIplImage.width();
    }
    return paramIplImage.roi().width();
  }
  
  @Namespace("cv")
  @NoOffset
  public static class BaseKeypoint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public BaseKeypoint()
    {
      allocate();
    }
    
    public BaseKeypoint(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public BaseKeypoint(int paramInt1, int paramInt2, opencv_core.IplImage paramIplImage)
    {
      allocate(paramInt1, paramInt2, paramIplImage);
    }
    
    public BaseKeypoint(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, opencv_core.IplImage paramIplImage);
    
    private native void allocateArray(int paramInt);
    
    public native opencv_core.IplImage image();
    
    public native BaseKeypoint image(opencv_core.IplImage paramIplImage);
    
    public BaseKeypoint position(int paramInt)
    {
      return (BaseKeypoint)super.position(paramInt);
    }
    
    public native int x();
    
    public native BaseKeypoint x(int paramInt);
    
    public native int y();
    
    public native BaseKeypoint y(int paramInt);
  }
  
  public static class CreateCvBlobTrackAnalysisOne
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    public CreateCvBlobTrackAnalysisOne(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlobTrackAnalysisOne call();
  }
  
  public static class CreateCvBlobTrackPostProcOne
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    public CreateCvBlobTrackPostProcOne(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlobTrackPostProcOne call();
  }
  
  public static class CreateCvBlobTrackerOne
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    public CreateCvBlobTrackerOne(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlobTrackerOne call();
  }
  
  @Opaque
  public static class Cv1DObsInfo
    extends CvImgObsInfo
  {
    static
    {
      Loader.load();
    }
    
    public Cv1DObsInfo() {}
    
    public Cv1DObsInfo(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class Cv3dTracker2dTrackedObject
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Cv3dTracker2dTrackedObject()
    {
      allocate();
    }
    
    public Cv3dTracker2dTrackedObject(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Cv3dTracker2dTrackedObject(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int id();
    
    public native Cv3dTracker2dTrackedObject id(int paramInt);
    
    @ByRef
    public native opencv_core.CvPoint2D32f p();
    
    public native Cv3dTracker2dTrackedObject p(opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    public Cv3dTracker2dTrackedObject position(int paramInt)
    {
      return (Cv3dTracker2dTrackedObject)super.position(paramInt);
    }
  }
  
  public static class Cv3dTrackerCameraInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Cv3dTrackerCameraInfo()
    {
      allocate();
    }
    
    public Cv3dTrackerCameraInfo(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Cv3dTrackerCameraInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"float(*)[4]"})
    @MemberGetter
    public native FloatPointer mat();
    
    public Cv3dTrackerCameraInfo position(int paramInt)
    {
      return (Cv3dTrackerCameraInfo)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvPoint2D32f principal_point();
    
    public native Cv3dTrackerCameraInfo principal_point(opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    public native Cv3dTrackerCameraInfo valid(boolean paramBoolean);
    
    public native boolean valid();
  }
  
  public static class Cv3dTrackerCameraIntrinsics
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Cv3dTrackerCameraIntrinsics()
    {
      allocate();
    }
    
    public Cv3dTrackerCameraIntrinsics(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Cv3dTrackerCameraIntrinsics(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @MemberGetter
    public native FloatPointer distortion();
    
    @MemberGetter
    public native FloatPointer focal_length();
    
    public Cv3dTrackerCameraIntrinsics position(int paramInt)
    {
      return (Cv3dTrackerCameraIntrinsics)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvPoint2D32f principal_point();
    
    public native Cv3dTrackerCameraIntrinsics principal_point(opencv_core.CvPoint2D32f paramCvPoint2D32f);
  }
  
  public static class Cv3dTrackerTrackedObject
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Cv3dTrackerTrackedObject()
    {
      allocate();
    }
    
    public Cv3dTrackerTrackedObject(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Cv3dTrackerTrackedObject(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int id();
    
    public native Cv3dTrackerTrackedObject id(int paramInt);
    
    @ByRef
    public native opencv_core.CvPoint3D32f p();
    
    public native Cv3dTrackerTrackedObject p(opencv_core.CvPoint3D32f paramCvPoint3D32f);
    
    public Cv3dTrackerTrackedObject position(int paramInt)
    {
      return (Cv3dTrackerTrackedObject)super.position(paramInt);
    }
  }
  
  @Namespace("cv")
  public static class CvAffinePose
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvAffinePose()
    {
      allocate();
    }
    
    public CvAffinePose(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvAffinePose(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float lambda1();
    
    public native CvAffinePose lambda1(float paramFloat);
    
    public native float lambda2();
    
    public native CvAffinePose lambda2(float paramFloat);
    
    public native float phi();
    
    public native CvAffinePose phi(float paramFloat);
    
    public CvAffinePose position(int paramInt)
    {
      return (CvAffinePose)super.position(paramInt);
    }
    
    public native float theta();
    
    public native CvAffinePose theta(float paramFloat);
  }
  
  public static class CvBGCodeBookElem
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBGCodeBookElem()
    {
      allocate();
    }
    
    public CvBGCodeBookElem(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBGCodeBookElem(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native byte boxMax(int paramInt);
    
    public native CvBGCodeBookElem boxMax(int paramInt, byte paramByte);
    
    public native byte boxMin(int paramInt);
    
    public native CvBGCodeBookElem boxMin(int paramInt, byte paramByte);
    
    public native byte learnMax(int paramInt);
    
    public native CvBGCodeBookElem learnMax(int paramInt, byte paramByte);
    
    public native byte learnMin(int paramInt);
    
    public native CvBGCodeBookElem learnMin(int paramInt, byte paramByte);
    
    public native CvBGCodeBookElem next();
    
    public native CvBGCodeBookElem next(CvBGCodeBookElem paramCvBGCodeBookElem);
    
    public CvBGCodeBookElem position(int paramInt)
    {
      return (CvBGCodeBookElem)super.position(paramInt);
    }
    
    public native int stale();
    
    public native CvBGCodeBookElem stale(int paramInt);
    
    public native int tLastUpdate();
    
    public native CvBGCodeBookElem tLastUpdate(int paramInt);
  }
  
  public static class CvBGCodeBookModel
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBGCodeBookModel()
    {
      allocate();
      zero();
    }
    
    public CvBGCodeBookModel(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvBGCodeBookModel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvBGCodeBookModel create()
    {
      CvBGCodeBookModel localCvBGCodeBookModel = opencv_legacy.cvCreateBGCodeBookModel();
      if (localCvBGCodeBookModel != null) {
        localCvBGCodeBookModel.deallocator(new ReleaseDeallocator(localCvBGCodeBookModel));
      }
      return localCvBGCodeBookModel;
    }
    
    public native byte cbBounds(int paramInt);
    
    public native CvBGCodeBookModel cbBounds(int paramInt, byte paramByte);
    
    @Cast({"CvBGCodeBookElem**"})
    public native PointerPointer cbmap();
    
    public native CvBGCodeBookModel cbmap(PointerPointer paramPointerPointer);
    
    public native CvBGCodeBookElem freeList();
    
    public native CvBGCodeBookModel freeList(CvBGCodeBookElem paramCvBGCodeBookElem);
    
    public native byte modMax(int paramInt);
    
    public native CvBGCodeBookModel modMax(int paramInt, byte paramByte);
    
    public native byte modMin(int paramInt);
    
    public native CvBGCodeBookModel modMin(int paramInt, byte paramByte);
    
    public CvBGCodeBookModel position(int paramInt)
    {
      return (CvBGCodeBookModel)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    @ByRef
    public native opencv_core.CvSize size();
    
    public native CvBGCodeBookModel size(opencv_core.CvSize paramCvSize);
    
    public native opencv_core.CvMemStorage storage();
    
    public native CvBGCodeBookModel storage(opencv_core.CvMemStorage paramCvMemStorage);
    
    public native int t();
    
    public native CvBGCodeBookModel t(int paramInt);
    
    static class ReleaseDeallocator
      extends CvBGCodeBookModel
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvBGCodeBookModel paramCvBGCodeBookModel)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseBGCodeBookModel(this);
      }
    }
  }
  
  public static class CvBGPixelCCStatTable
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBGPixelCCStatTable()
    {
      allocate();
    }
    
    public CvBGPixelCCStatTable(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBGPixelCCStatTable(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float Pv();
    
    public native CvBGPixelCCStatTable Pv(float paramFloat);
    
    public native float Pvb();
    
    public native CvBGPixelCCStatTable Pvb(float paramFloat);
    
    public CvBGPixelCCStatTable position(int paramInt)
    {
      return (CvBGPixelCCStatTable)super.position(paramInt);
    }
    
    public native byte v(int paramInt);
    
    public native CvBGPixelCCStatTable v(int paramInt, byte paramByte);
  }
  
  public static class CvBGPixelCStatTable
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBGPixelCStatTable()
    {
      allocate();
    }
    
    public CvBGPixelCStatTable(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBGPixelCStatTable(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float Pv();
    
    public native CvBGPixelCStatTable Pv(float paramFloat);
    
    public native float Pvb();
    
    public native CvBGPixelCStatTable Pvb(float paramFloat);
    
    public CvBGPixelCStatTable position(int paramInt)
    {
      return (CvBGPixelCStatTable)super.position(paramInt);
    }
    
    public native byte v(int paramInt);
    
    public native CvBGPixelCStatTable v(int paramInt, byte paramByte);
  }
  
  public static class CvBGPixelStat
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBGPixelStat()
    {
      allocate();
    }
    
    public CvBGPixelStat(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBGPixelStat(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float Pbc();
    
    public native CvBGPixelStat Pbc(float paramFloat);
    
    public native float Pbcc();
    
    public native CvBGPixelStat Pbcc(float paramFloat);
    
    public native CvBGPixelCCStatTable cctable();
    
    public native CvBGPixelStat cctable(CvBGPixelCCStatTable paramCvBGPixelCCStatTable);
    
    public native CvBGPixelCStatTable ctable();
    
    public native CvBGPixelStat ctable(CvBGPixelCStatTable paramCvBGPixelCStatTable);
    
    public native byte is_trained_dyn_model();
    
    public native CvBGPixelStat is_trained_dyn_model(byte paramByte);
    
    public native byte is_trained_st_model();
    
    public native CvBGPixelStat is_trained_st_model(byte paramByte);
    
    public CvBGPixelStat position(int paramInt)
    {
      return (CvBGPixelStat)super.position(paramInt);
    }
  }
  
  public static class CvBGStatModel
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBGStatModel()
    {
      allocate();
      zero();
    }
    
    public CvBGStatModel(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvBGStatModel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvBGStatModel create(opencv_core.IplImage paramIplImage, CvFGDStatModelParams paramCvFGDStatModelParams)
    {
      CvBGStatModel localCvBGStatModel = opencv_legacy.cvCreateFGDStatModel(paramIplImage, paramCvFGDStatModelParams);
      if (localCvBGStatModel != null) {
        localCvBGStatModel.deallocator(new ReleaseDeallocator(localCvBGStatModel));
      }
      return localCvBGStatModel;
    }
    
    public static CvBGStatModel create(opencv_core.IplImage paramIplImage, CvGaussBGStatModelParams paramCvGaussBGStatModelParams)
    {
      CvBGStatModel localCvBGStatModel = opencv_legacy.cvCreateGaussianBGModel(paramIplImage, paramCvGaussBGStatModelParams);
      if (localCvBGStatModel != null) {
        localCvBGStatModel.deallocator(new ReleaseDeallocator(localCvBGStatModel));
      }
      return localCvBGStatModel;
    }
    
    public native opencv_core.IplImage background();
    
    public native CvBGStatModel background(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage foreground();
    
    public native CvBGStatModel foreground(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.CvSeq foreground_regions();
    
    public native CvBGStatModel foreground_regions(opencv_core.CvSeq paramCvSeq);
    
    public native int layer_count();
    
    public native CvBGStatModel layer_count(int paramInt);
    
    public native opencv_core.IplImageArray layers();
    
    public native CvBGStatModel layers(opencv_core.IplImageArray paramIplImageArray);
    
    public CvBGStatModel position(int paramInt)
    {
      return (CvBGStatModel)super.position(paramInt);
    }
    
    public native CvBGStatModel release(CvReleaseBGStatModel paramCvReleaseBGStatModel);
    
    public native CvReleaseBGStatModel release();
    
    public void release2()
    {
      deallocate();
    }
    
    public native opencv_core.CvMemStorage storage();
    
    public native CvBGStatModel storage(opencv_core.CvMemStorage paramCvMemStorage);
    
    public native int type();
    
    public native CvBGStatModel type(int paramInt);
    
    public native CvBGStatModel update(CvUpdateBGStatModel paramCvUpdateBGStatModel);
    
    public native CvUpdateBGStatModel update();
    
    static class ReleaseDeallocator
      extends CvBGStatModel
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvBGStatModel paramCvBGStatModel)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseBGStatModel(this);
      }
    }
  }
  
  public static class CvBlob
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlob()
    {
      allocate();
    }
    
    public CvBlob(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBlob(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int ID();
    
    public native CvBlob ID(int paramInt);
    
    public native float h();
    
    public native CvBlob h(float paramFloat);
    
    public CvBlob position(int paramInt)
    {
      return (CvBlob)super.position(paramInt);
    }
    
    public native float w();
    
    public native CvBlob w(float paramFloat);
    
    public native float x();
    
    public native CvBlob x(float paramFloat);
    
    public native float y();
    
    public native CvBlob y(float paramFloat);
  }
  
  public static class CvBlobDetector
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobDetector() {}
    
    public CvBlobDetector(Pointer paramPointer)
    {
      super();
    }
    
    public native int DetectNewBlob(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, CvBlobSeq paramCvBlobSeq1, CvBlobSeq paramCvBlobSeq2);
  }
  
  public static class CvBlobSeq
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobSeq()
    {
      allocate();
    }
    
    public CvBlobSeq(int paramInt)
    {
      allocate(paramInt);
    }
    
    public CvBlobSeq(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
    
    public native void AddBlob(CvBlob paramCvBlob);
    
    public native void AddFormat(String paramString);
    
    public native void Clear();
    
    public native void DelBlob(int paramInt);
    
    public native void DelBlobByID(int paramInt);
    
    public native CvBlob GetBlob(int paramInt);
    
    public native CvBlob GetBlobByID(int paramInt);
    
    public native int GetBlobNum();
    
    public native void Load(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void Write(opencv_core.CvFileStorage paramCvFileStorage, String paramString);
  }
  
  public static class CvBlobTrack
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrack()
    {
      allocate();
    }
    
    public CvBlobTrack(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBlobTrack(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int StartFrame();
    
    public native CvBlobTrack StartFrame(int paramInt);
    
    public native int TrackID();
    
    public native CvBlobTrack TrackID(int paramInt);
    
    public native CvBlobSeq pBlobSeq();
    
    public native CvBlobTrack pBlobSeq(CvBlobSeq paramCvBlobSeq);
    
    public CvBlobTrack position(int paramInt)
    {
      return (CvBlobTrack)super.position(paramInt);
    }
  }
  
  public static class CvBlobTrackAnalysis
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackAnalysis() {}
    
    public CvBlobTrackAnalysis(Pointer paramPointer)
    {
      super();
    }
    
    public native void AddBlob(CvBlob paramCvBlob);
    
    public native float GetState(int paramInt);
    
    public native String GetStateDesc(int paramInt);
    
    public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void SetFileName(@Cast({"char*"}) String paramString);
  }
  
  public static class CvBlobTrackAnalysisHeight
    extends CvBlobTrackAnalysis
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackAnalysisHeight() {}
    
    public CvBlobTrackAnalysisHeight(Pointer paramPointer)
    {
      super();
    }
    
    public native double GetHeight(CvBlob paramCvBlob);
  }
  
  public static class CvBlobTrackAnalysisOne
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackAnalysisOne() {}
    
    public CvBlobTrackAnalysisOne(Pointer paramPointer)
    {
      super();
    }
    
    public native int Process(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void Release();
  }
  
  public static class CvBlobTrackFVGen
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackFVGen() {}
    
    public CvBlobTrackFVGen(Pointer paramPointer)
    {
      super();
    }
    
    public native void AddBlob(CvBlob paramCvBlob);
    
    public native FloatPointer GetFV(int paramInt, int[] paramArrayOfInt);
    
    public native FloatPointer GetFVMax();
    
    public native FloatPointer GetFVMin();
    
    public native int GetFVNum();
    
    public native int GetFVSize();
    
    public native FloatPointer GetFVVar();
    
    public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  }
  
  public static class CvBlobTrackGen
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackGen() {}
    
    public CvBlobTrackGen(Pointer paramPointer)
    {
      super();
    }
    
    public native void AddBlob(CvBlob paramCvBlob);
    
    public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void SetFileName(@Cast({"char*"}) String paramString);
  }
  
  public static class CvBlobTrackPostProc
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackPostProc() {}
    
    public CvBlobTrackPostProc(Pointer paramPointer)
    {
      super();
    }
    
    public native void AddBlob(CvBlob paramCvBlob);
    
    public native CvBlob GetBlob(int paramInt);
    
    public native CvBlob GetBlobByID(int paramInt);
    
    public native int GetBlobNum();
    
    public native void Process();
  }
  
  public static class CvBlobTrackPostProcOne
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackPostProcOne() {}
    
    public CvBlobTrackPostProcOne(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlob Process(CvBlob paramCvBlob);
  }
  
  public static class CvBlobTrackPredictor
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackPredictor() {}
    
    public CvBlobTrackPredictor(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlob Predict();
    
    public native void Update(CvBlob paramCvBlob);
  }
  
  public static class CvBlobTrackSeq
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackSeq()
    {
      allocate();
    }
    
    public CvBlobTrackSeq(int paramInt)
    {
      allocate(paramInt);
    }
    
    public CvBlobTrackSeq(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
    
    public native void AddBlobTrack(int paramInt1, int paramInt2);
    
    public native void Clear();
    
    public native void DelBlobTrack(int paramInt);
    
    public native void DelBlobTrackByID(int paramInt);
    
    public native CvBlobTrack GetBlobTrack(int paramInt);
    
    public native CvBlobTrack GetBlobTrackByID(int paramInt);
    
    public native int GetBlobTrackNum();
  }
  
  public static class CvBlobTracker
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTracker() {}
    
    public CvBlobTracker(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlob AddBlob(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void DelBlob(int paramInt);
    
    public native void DelBlobByID(int paramInt);
    
    public native CvBlob GetBlob(int paramInt);
    
    public native CvBlob GetBlobByID(int paramInt);
    
    public native CvBlob GetBlobHyp(int paramInt1, int paramInt2);
    
    public native int GetBlobHypNum(int paramInt);
    
    public native int GetBlobIndexByID(int paramInt);
    
    public native int GetBlobNum();
    
    public native double GetConfidence(int paramInt, CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native double GetConfidenceList(CvBlobSeq paramCvBlobSeq, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void ProcessBlob(int paramInt, CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void SetBlob(int paramInt, CvBlob paramCvBlob);
    
    public native void SetBlobByID(int paramInt, CvBlob paramCvBlob);
    
    public native void SetBlobHyp(int paramInt, CvBlob paramCvBlob);
    
    public native void Update(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void UpdateBlob(int paramInt, CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  }
  
  public static class CvBlobTrackerAuto
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackerAuto() {}
    
    public CvBlobTrackerAuto(Pointer paramPointer)
    {
      super();
    }
    
    public native CvBlob GetBlob(int paramInt);
    
    public native CvBlob GetBlobByID(int paramInt);
    
    public native int GetBlobNum();
    
    public native opencv_core.IplImage GetFGMask();
    
    public native float GetState(int paramInt);
    
    public native String GetStateDesc(int paramInt);
    
    public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  }
  
  public static class CvBlobTrackerAutoParam1
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackerAutoParam1()
    {
      allocate();
    }
    
    public CvBlobTrackerAutoParam1(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBlobTrackerAutoParam1(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int FGTrainFrames();
    
    public native CvBlobTrackerAutoParam1 FGTrainFrames(int paramInt);
    
    public native int UsePPData();
    
    public native CvBlobTrackerAutoParam1 UsePPData(int paramInt);
    
    public native CvBlobDetector pBD();
    
    public native CvBlobTrackerAutoParam1 pBD(CvBlobDetector paramCvBlobDetector);
    
    public native CvBlobTracker pBT();
    
    public native CvBlobTrackerAutoParam1 pBT(CvBlobTracker paramCvBlobTracker);
    
    public native CvBlobTrackAnalysis pBTA();
    
    public native CvBlobTrackerAutoParam1 pBTA(CvBlobTrackAnalysis paramCvBlobTrackAnalysis);
    
    public native CvBlobTrackGen pBTGen();
    
    public native CvBlobTrackerAutoParam1 pBTGen(CvBlobTrackGen paramCvBlobTrackGen);
    
    public native CvBlobTrackPostProc pBTPP();
    
    public native CvBlobTrackerAutoParam1 pBTPP(CvBlobTrackPostProc paramCvBlobTrackPostProc);
    
    public native CvBlobTrackerAutoParam1 pFG(CvFGDetector paramCvFGDetector);
    
    public native CvFGDetector pFG();
    
    public CvBlobTrackerAutoParam1 position(int paramInt)
    {
      return (CvBlobTrackerAutoParam1)super.position(paramInt);
    }
  }
  
  public static class CvBlobTrackerOne
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackerOne() {}
    
    public CvBlobTrackerOne(Pointer paramPointer)
    {
      super();
    }
    
    public native double GetConfidence(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3);
    
    public native void Init(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native CvBlob Process(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void SetCollision(int paramInt);
    
    public native void SkipProcess(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
    
    public native void Update(CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
  }
  
  public static class CvBlobTrackerParamLH
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackerParamLH()
    {
      allocate();
    }
    
    public CvBlobTrackerParamLH(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBlobTrackerParamLH(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int HistType();
    
    public native CvBlobTrackerParamLH HistType(int paramInt);
    
    public native int ScaleAfter();
    
    public native CvBlobTrackerParamLH ScaleAfter(int paramInt);
    
    public CvBlobTrackerParamLH position(int paramInt)
    {
      return (CvBlobTrackerParamLH)super.position(paramInt);
    }
  }
  
  public static class CvBlobTrackerParamMS
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBlobTrackerParamMS()
    {
      allocate();
    }
    
    public CvBlobTrackerParamMS(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBlobTrackerParamMS(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int appearance_profile();
    
    public native CvBlobTrackerParamMS appearance_profile(int paramInt);
    
    public native int meanshift_profile();
    
    public native CvBlobTrackerParamMS meanshift_profile(int paramInt);
    
    public native int noOfSigBits();
    
    public native CvBlobTrackerParamMS noOfSigBits(int paramInt);
    
    public CvBlobTrackerParamMS position(int paramInt)
    {
      return (CvBlobTrackerParamMS)super.position(paramInt);
    }
    
    public native float sigma();
    
    public native CvBlobTrackerParamMS sigma(float paramFloat);
  }
  
  public static class CvCalibFilter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvCalibFilter()
    {
      allocate();
    }
    
    public CvCalibFilter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void DrawPoints(opencv_core.CvMatArray paramCvMatArray);
    
    public native void DrawPoints(opencv_core.IplImageArray paramIplImageArray);
    
    public native boolean FindEtalon(opencv_core.CvMatArray paramCvMatArray);
    
    public native boolean FindEtalon(opencv_core.IplImageArray paramIplImageArray);
    
    public native int GetCameraCount();
    
    @Const
    public native opencv_legacy.CvCamera GetCameraParams(int paramInt);
    
    @Cast({"CvCalibEtalonType"})
    public native int GetEtalon(int[] paramArrayOfInt1, @Cast({"const double**"}) PointerPointer paramPointerPointer1, int[] paramArrayOfInt2, @Cast({"const CvPoint2D32f**"}) PointerPointer paramPointerPointer2);
    
    public native int GetFrameCount(int[] paramArrayOfInt);
    
    public native boolean GetLatestPoints(int paramInt, @Cast({"CvPoint2D32f**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean);
    
    @Const
    public native opencv_legacy.CvStereoCamera GetStereoParams();
    
    public native boolean IsCalibrated();
    
    public native boolean LoadCameraParams(String paramString);
    
    public native boolean Push(@Cast({"const CvPoint2D32f**"}) PointerPointer paramPointerPointer);
    
    public native boolean Rectify(opencv_core.CvMatArray paramCvMatArray1, opencv_core.CvMatArray paramCvMatArray2);
    
    public native boolean Rectify(opencv_core.IplImageArray paramIplImageArray1, opencv_core.IplImageArray paramIplImageArray2);
    
    public native boolean SaveCameraParams(String paramString);
    
    public native void SetCameraCount(int paramInt);
    
    public native boolean SetCameraParams(CvCamera paramCvCamera);
    
    public native boolean SetEtalon(@Cast({"CvCalibEtalonType"}) int paramInt1, double[] paramArrayOfDouble, int paramInt2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    public native boolean SetFrames(int paramInt);
    
    public native void Stop(boolean paramBoolean);
    
    public native boolean Undistort(opencv_core.CvMatArray paramCvMatArray1, opencv_core.CvMatArray paramCvMatArray2);
    
    public native boolean Undistort(opencv_core.IplImageArray paramIplImageArray1, opencv_core.IplImageArray paramIplImageArray2);
  }
  
  public static class CvCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvCallback()
    {
      allocate();
    }
    
    public CvCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(int paramInt, Pointer paramPointer1, Pointer paramPointer2);
  }
  
  public static class CvCamShiftTracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvCamShiftTracker()
    {
      allocate();
    }
    
    public CvCamShiftTracker(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native opencv_core.IplImage get_back_project();
    
    @ByVal
    public native opencv_core.CvPoint2D32f get_center();
    
    public native int get_hist_dims(int[] paramArrayOfInt);
    
    public native float get_length();
    
    public native int get_max_ch_val(int paramInt);
    
    public native int get_min_ch_val(int paramInt);
    
    public native float get_orientation();
    
    public native int get_threshold();
    
    public native float get_width();
    
    @ByVal
    public native opencv_core.CvRect get_window();
    
    public native float query(int[] paramArrayOfInt);
    
    public native void reset_histogram();
    
    public native boolean set_hist_bin_range(int paramInt1, int paramInt2, int paramInt3);
    
    public native boolean set_hist_dims(int paramInt, int[] paramArrayOfInt);
    
    public native boolean set_max_ch_val(int paramInt1, int paramInt2);
    
    public native boolean set_min_ch_val(int paramInt1, int paramInt2);
    
    public native boolean set_threshold(int paramInt);
    
    public native boolean set_window(@ByVal opencv_core.CvRect paramCvRect);
    
    public native boolean track_object(opencv_core.IplImage paramIplImage);
    
    public native boolean update_histogram(opencv_core.IplImage paramIplImage);
  }
  
  public static class CvCamera
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvCamera()
    {
      allocate();
    }
    
    public CvCamera(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvCamera(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @MemberGetter
    public native FloatPointer distortion();
    
    @MemberGetter
    public native FloatPointer imgSize();
    
    @MemberGetter
    public native FloatPointer matrix();
    
    public CvCamera position(int paramInt)
    {
      return (CvCamera)super.position(paramInt);
    }
    
    @MemberGetter
    public native FloatPointer rotMatr();
    
    @MemberGetter
    public native FloatPointer transVect();
  }
  
  public static class CvCliqueFinder
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvCliqueFinder()
    {
      allocate();
    }
    
    public CvCliqueFinder(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvCliqueFinder(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"int**"})
    public native PointerPointer All();
    
    public native CvCliqueFinder All(PointerPointer paramPointerPointer);
    
    public native int N();
    
    public native CvCliqueFinder N(int paramInt);
    
    @Cast({"int**"})
    public native PointerPointer adj_matr();
    
    public native CvCliqueFinder adj_matr(PointerPointer paramPointerPointer);
    
    public native int best_score();
    
    public native CvCliqueFinder best_score(int paramInt);
    
    public native float best_weight();
    
    public native CvCliqueFinder best_weight(float paramFloat);
    
    public native FloatPointer cand_weight();
    
    public native CvCliqueFinder cand_weight(FloatPointer paramFloatPointer);
    
    public native IntPointer ce();
    
    public native CvCliqueFinder ce(IntPointer paramIntPointer);
    
    public native FloatPointer cur_weight();
    
    public native CvCliqueFinder cur_weight(FloatPointer paramFloatPointer);
    
    public native IntPointer current_comp();
    
    public native CvCliqueFinder current_comp(IntPointer paramIntPointer);
    
    public native FloatPointer edge_weights();
    
    public native CvCliqueFinder edge_weights(FloatPointer paramFloatPointer);
    
    public native IntPointer fixp();
    
    public native CvCliqueFinder fixp(IntPointer paramIntPointer);
    
    public native opencv_core.CvGraph graph();
    
    public native CvCliqueFinder graph(opencv_core.CvGraph paramCvGraph);
    
    public native int k();
    
    public native CvCliqueFinder k(int paramInt);
    
    public native IntPointer ne();
    
    public native CvCliqueFinder ne(IntPointer paramIntPointer);
    
    public native IntPointer nod();
    
    public native CvCliqueFinder nod(IntPointer paramIntPointer);
    
    public CvCliqueFinder position(int paramInt)
    {
      return (CvCliqueFinder)super.position(paramInt);
    }
    
    public native IntPointer s();
    
    public native CvCliqueFinder s(IntPointer paramIntPointer);
    
    public native int status();
    
    public native CvCliqueFinder status(int paramInt);
    
    public native FloatPointer vertex_weights();
    
    public native CvCliqueFinder vertex_weights(FloatPointer paramFloatPointer);
    
    public native int weighted();
    
    public native CvCliqueFinder weighted(int paramInt);
    
    public native int weighted_edges();
    
    public native CvCliqueFinder weighted_edges(int paramInt);
  }
  
  public static class CvConDensation
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvConDensation()
    {
      allocate();
      zero();
    }
    
    public CvConDensation(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvConDensation(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvConDensation create(int paramInt1, int paramInt2, int paramInt3)
    {
      CvConDensation localCvConDensation = opencv_legacy.cvCreateConDensation(paramInt1, paramInt2, paramInt3);
      if (localCvConDensation != null) {
        localCvConDensation.deallocator(new ReleaseDeallocator(localCvConDensation));
      }
      return localCvConDensation;
    }
    
    public native int DP();
    
    public native CvConDensation DP(int paramInt);
    
    public native FloatPointer DynamMatr();
    
    public native CvConDensation DynamMatr(FloatPointer paramFloatPointer);
    
    public native int MP();
    
    public native CvConDensation MP(int paramInt);
    
    public native CvConDensation RandS(CvRandState paramCvRandState);
    
    public native CvRandState RandS();
    
    public native FloatPointer RandomSample();
    
    public native CvConDensation RandomSample(FloatPointer paramFloatPointer);
    
    public native int SamplesNum();
    
    public native CvConDensation SamplesNum(int paramInt);
    
    public native FloatPointer State();
    
    public native CvConDensation State(FloatPointer paramFloatPointer);
    
    public native FloatPointer Temp();
    
    public native CvConDensation Temp(FloatPointer paramFloatPointer);
    
    public native FloatPointer flConfidence();
    
    public native CvConDensation flConfidence(FloatPointer paramFloatPointer);
    
    public native FloatPointer flCumulative();
    
    public native CvConDensation flCumulative(FloatPointer paramFloatPointer);
    
    @Cast({"float**"})
    public native PointerPointer flNewSamples();
    
    public native CvConDensation flNewSamples(PointerPointer paramPointerPointer);
    
    @Cast({"float**"})
    public native PointerPointer flSamples();
    
    public native CvConDensation flSamples(PointerPointer paramPointerPointer);
    
    public CvConDensation position(int paramInt)
    {
      return (CvConDensation)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    static class ReleaseDeallocator
      extends CvConDensation
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvConDensation paramCvConDensation)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseConDensation(this);
      }
    }
  }
  
  public static class CvContourOrientation
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvContourOrientation()
    {
      allocate();
    }
    
    public CvContourOrientation(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvContourOrientation(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float egvals(int paramInt);
    
    public native CvContourOrientation egvals(int paramInt, float paramFloat);
    
    public native float egvects(int paramInt);
    
    public native CvContourOrientation egvects(int paramInt, float paramFloat);
    
    public native int imax();
    
    public native CvContourOrientation imax(int paramInt);
    
    public native int imin();
    
    public native CvContourOrientation imin(int paramInt);
    
    public native float max();
    
    public native CvContourOrientation max(float paramFloat);
    
    public native float min();
    
    public native CvContourOrientation min(float paramFloat);
    
    public CvContourOrientation position(int paramInt)
    {
      return (CvContourOrientation)super.position(paramInt);
    }
  }
  
  public static class CvContourTree
    extends opencv_core.CvSeq
  {
    static
    {
      Loader.load();
    }
    
    public CvContourTree()
    {
      allocate();
      zero();
    }
    
    public CvContourTree(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvContourTree(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    public native opencv_core.CvPoint p1();
    
    public native CvContourTree p1(opencv_core.CvPoint paramCvPoint);
    
    @ByRef
    public native opencv_core.CvPoint p2();
    
    public native CvContourTree p2(opencv_core.CvPoint paramCvPoint);
    
    public CvContourTree position(int paramInt)
    {
      return (CvContourTree)super.position(paramInt);
    }
  }
  
  public static class CvDefParam
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDefParam()
    {
      allocate();
    }
    
    public CvDefParam(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDefParam(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double Double();
    
    public native CvDefParam Double(double paramDouble);
    
    public native float Float();
    
    public native CvDefParam Float(float paramFloat);
    
    public native int Int();
    
    public native CvDefParam Int(int paramInt);
    
    @Cast({"char*"})
    public native BytePointer Str();
    
    public native CvDefParam Str(BytePointer paramBytePointer);
    
    public native CvDefParam next();
    
    public native CvDefParam next(CvDefParam paramCvDefParam);
    
    @Cast({"char*"})
    public native BytePointer pComment();
    
    public native CvDefParam pComment(BytePointer paramBytePointer);
    
    public native DoublePointer pDouble();
    
    public native CvDefParam pDouble(DoublePointer paramDoublePointer);
    
    public native FloatPointer pFloat();
    
    public native CvDefParam pFloat(FloatPointer paramFloatPointer);
    
    public native IntPointer pInt();
    
    public native CvDefParam pInt(IntPointer paramIntPointer);
    
    @Cast({"char*"})
    public native BytePointer pName();
    
    public native CvDefParam pName(BytePointer paramBytePointer);
    
    @Cast({"char**"})
    public native PointerPointer pStr();
    
    public native CvDefParam pStr(PointerPointer paramPointerPointer);
    
    public CvDefParam position(int paramInt)
    {
      return (CvDefParam)super.position(paramInt);
    }
  }
  
  @NoOffset
  public static class CvDetectedBlob
    extends CvBlob
  {
    static
    {
      Loader.load();
    }
    
    public CvDetectedBlob()
    {
      allocate();
    }
    
    public CvDetectedBlob(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDetectedBlob(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvDetectedBlob position(int paramInt)
    {
      return (CvDetectedBlob)super.position(paramInt);
    }
    
    public native float response();
    
    public native CvDetectedBlob response(float paramFloat);
  }
  
  public static class CvDrawShape
    extends Pointer
  {
    public static final int ELLIPSE = 1;
    public static final int RECT;
    
    static
    {
      Loader.load();
    }
    
    public CvDrawShape()
    {
      allocate();
    }
    
    public CvDrawShape(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDrawShape(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    public native opencv_core.CvScalar color();
    
    public native CvDrawShape color(opencv_core.CvScalar paramCvScalar);
    
    public CvDrawShape position(int paramInt)
    {
      return (CvDrawShape)super.position(paramInt);
    }
  }
  
  public static class CvEHMM
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvEHMM()
    {
      allocate();
      zero();
    }
    
    public CvEHMM(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvEHMM(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvEHMM create(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    {
      CvEHMM localCvEHMM = opencv_legacy.cvCreate2DHMM(paramArrayOfInt1, paramArrayOfInt2, paramInt);
      if (localCvEHMM != null) {
        localCvEHMM.deallocator(new ReleaseDeallocator(localCvEHMM));
      }
      return localCvEHMM;
    }
    
    public native int level();
    
    public native CvEHMM level(int paramInt);
    
    public native int num_states();
    
    public native CvEHMM num_states(int paramInt);
    
    @Cast({"float**"})
    public native PointerPointer obsProb();
    
    public native CvEHMM obsProb(PointerPointer paramPointerPointer);
    
    public CvEHMM position(int paramInt)
    {
      return (CvEHMM)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    public native FloatPointer transP();
    
    public native CvEHMM transP(FloatPointer paramFloatPointer);
    
    @Name({"u.ehmm"})
    public native CvEHMM u_ehmm();
    
    public native CvEHMM u_ehmm(CvEHMM paramCvEHMM);
    
    public native CvEHMM u_state(CvEHMMState paramCvEHMMState);
    
    @Name({"u.state"})
    public native opencv_legacy.CvEHMMState u_state();
    
    static class ReleaseDeallocator
      extends CvEHMM
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvEHMM paramCvEHMM)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvRelease2DHMM(this);
      }
    }
  }
  
  public static class CvEHMMState
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvEHMMState()
    {
      allocate();
    }
    
    public CvEHMMState(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvEHMMState(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native FloatPointer inv_var();
    
    public native CvEHMMState inv_var(FloatPointer paramFloatPointer);
    
    public native FloatPointer log_var_val();
    
    public native CvEHMMState log_var_val(FloatPointer paramFloatPointer);
    
    public native FloatPointer mu();
    
    public native CvEHMMState mu(FloatPointer paramFloatPointer);
    
    public native int num_mix();
    
    public native CvEHMMState num_mix(int paramInt);
    
    public CvEHMMState position(int paramInt)
    {
      return (CvEHMMState)super.position(paramInt);
    }
    
    public native FloatPointer weight();
    
    public native CvEHMMState weight(FloatPointer paramFloatPointer);
  }
  
  public static class CvEM
    extends opencv_ml.CvStatModel
  {
    public static final int COV_MAT_DIAGONAL = 1;
    public static final int COV_MAT_GENERIC = 2;
    public static final int COV_MAT_SPHERICAL = 0;
    public static final int START_AUTO_STEP = 0;
    public static final int START_E_STEP = 1;
    public static final int START_M_STEP = 2;
    
    static
    {
      Loader.load();
    }
    
    public CvEM()
    {
      allocate();
    }
    
    public CvEM(Pointer paramPointer)
    {
      super();
    }
    
    public CvEM(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, CvEMParams paramCvEMParams, opencv_core.CvMat paramCvMat3)
    {
      allocate(paramCvMat1, paramCvMat2, paramCvEMParams, paramCvMat3);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @ByVal opencv_legacy.CvEMParams paramCvEMParams, opencv_core.CvMat paramCvMat3);
    
    public native double calcLikelihood(opencv_core.CvMat paramCvMat);
    
    @Const
    public native opencv_core.CvMatArray get_covs();
    
    public native double get_log_likelihood();
    
    @Const
    public native opencv_core.CvMat get_means();
    
    public native int get_nclusters();
    
    @Const
    public native opencv_core.CvMat get_probs();
    
    @Const
    public native opencv_core.CvMat get_weights();
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @ByVal opencv_legacy.CvEMParams paramCvEMParams, opencv_core.CvMat paramCvMat3);
  }
  
  @NoOffset
  public static class CvEMParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvEMParams()
    {
      allocate();
    }
    
    public CvEMParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvEMParams(int paramInt1, int paramInt2, int paramInt3, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @Const opencv_core.CvMatArray paramCvMatArray)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramCvTermCriteria, paramCvMat1, paramCvMat2, paramCvMat3, paramCvMatArray);
    }
    
    public CvEMParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @Const opencv_core.CvMatArray paramCvMatArray);
    
    private native void allocateArray(int paramInt);
    
    public native int cov_mat_type();
    
    public native CvEMParams cov_mat_type(int paramInt);
    
    @Const
    public native opencv_core.CvMatArray covs();
    
    public native CvEMParams covs(opencv_core.CvMatArray paramCvMatArray);
    
    @Const
    public native opencv_core.CvMat means();
    
    public native CvEMParams means(opencv_core.CvMat paramCvMat);
    
    public native int nclusters();
    
    public native CvEMParams nclusters(int paramInt);
    
    public CvEMParams position(int paramInt)
    {
      return (CvEMParams)super.position(paramInt);
    }
    
    @Const
    public native opencv_core.CvMat probs();
    
    public native CvEMParams probs(opencv_core.CvMat paramCvMat);
    
    public native int start_step();
    
    public native CvEMParams start_step(int paramInt);
    
    @ByRef
    public native opencv_core.CvTermCriteria term_crit();
    
    public native CvEMParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
    
    @Const
    public native opencv_core.CvMat weights();
    
    public native CvEMParams weights(opencv_core.CvMat paramCvMat);
  }
  
  public static class CvFGDStatModel
    extends CvBGStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvFGDStatModel()
    {
      allocate();
      zero();
    }
    
    public CvFGDStatModel(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvFGDStatModel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native opencv_core.IplImage Fbd();
    
    public native CvFGDStatModel Fbd(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage Ftd();
    
    public native CvFGDStatModel Ftd(opencv_core.IplImage paramIplImage);
    
    public native CvFGDStatModel params(CvFGDStatModelParams paramCvFGDStatModelParams);
    
    @ByRef
    public native opencv_legacy.CvFGDStatModelParams params();
    
    public native CvBGPixelStat pixel_stat();
    
    public native CvFGDStatModel pixel_stat(CvBGPixelStat paramCvBGPixelStat);
    
    public CvFGDStatModel position(int paramInt)
    {
      return (CvFGDStatModel)super.position(paramInt);
    }
    
    public native opencv_core.IplImage prev_frame();
    
    public native CvFGDStatModel prev_frame(opencv_core.IplImage paramIplImage);
  }
  
  public static class CvFGDStatModelParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFGDStatModelParams()
    {
      allocate();
    }
    
    public CvFGDStatModelParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFGDStatModelParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int Lc();
    
    public native CvFGDStatModelParams Lc(int paramInt);
    
    public native int Lcc();
    
    public native CvFGDStatModelParams Lcc(int paramInt);
    
    public native int N1c();
    
    public native CvFGDStatModelParams N1c(int paramInt);
    
    public native int N1cc();
    
    public native CvFGDStatModelParams N1cc(int paramInt);
    
    public native int N2c();
    
    public native CvFGDStatModelParams N2c(int paramInt);
    
    public native int N2cc();
    
    public native CvFGDStatModelParams N2cc(int paramInt);
    
    public native float T();
    
    public native CvFGDStatModelParams T(float paramFloat);
    
    public native float alpha1();
    
    public native CvFGDStatModelParams alpha1(float paramFloat);
    
    public native float alpha2();
    
    public native CvFGDStatModelParams alpha2(float paramFloat);
    
    public native float alpha3();
    
    public native CvFGDStatModelParams alpha3(float paramFloat);
    
    public native float delta();
    
    public native CvFGDStatModelParams delta(float paramFloat);
    
    public native int is_obj_without_holes();
    
    public native CvFGDStatModelParams is_obj_without_holes(int paramInt);
    
    public native float minArea();
    
    public native CvFGDStatModelParams minArea(float paramFloat);
    
    public native int perform_morphing();
    
    public native CvFGDStatModelParams perform_morphing(int paramInt);
    
    public CvFGDStatModelParams position(int paramInt)
    {
      return (CvFGDStatModelParams)super.position(paramInt);
    }
  }
  
  public static class CvFGDetector
    extends CvVSModule
  {
    static
    {
      Loader.load();
    }
    
    public CvFGDetector() {}
    
    public CvFGDetector(Pointer paramPointer)
    {
      super();
    }
    
    public native opencv_core.IplImage GetMask();
    
    public native void Process(opencv_core.IplImage paramIplImage);
  }
  
  public static class CvFace
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFace()
    {
      allocate();
    }
    
    public CvFace(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFace(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    public native opencv_core.CvRect LeftEyeRect();
    
    public native CvFace LeftEyeRect(opencv_core.CvRect paramCvRect);
    
    @ByRef
    public native opencv_core.CvRect MouthRect();
    
    public native CvFace MouthRect(opencv_core.CvRect paramCvRect);
    
    @ByRef
    public native opencv_core.CvRect RightEyeRect();
    
    public native CvFace RightEyeRect(opencv_core.CvRect paramCvRect);
    
    public CvFace position(int paramInt)
    {
      return (CvFace)super.position(paramInt);
    }
  }
  
  @Opaque
  public static class CvFaceTracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFaceTracker() {}
    
    public CvFaceTracker(Pointer paramPointer)
    {
      super();
    }
    
    public static CvFaceTracker create(CvFaceTracker paramCvFaceTracker, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect, int paramInt)
    {
      CvFaceTracker localCvFaceTracker = opencv_legacy.cvInitFaceTracker(new CvFaceTracker(), paramIplImage, paramCvRect, paramInt);
      if (localCvFaceTracker != null) {
        localCvFaceTracker.deallocator(new ReleaseDeallocator(localCvFaceTracker));
      }
      return localCvFaceTracker;
    }
    
    public void release()
    {
      deallocate();
    }
    
    static class ReleaseDeallocator
      extends CvFaceTracker
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvFaceTracker paramCvFaceTracker)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseFaceTracker(this);
      }
    }
  }
  
  @Opaque
  public static class CvGLCM
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvGLCM() {}
    
    public CvGLCM(Pointer paramPointer)
    {
      super();
    }
    
    public static CvGLCM create(opencv_core.IplImage paramIplImage, int paramInt)
    {
      return create(paramIplImage, paramInt, null, 0, -2);
    }
    
    public static CvGLCM create(opencv_core.IplImage paramIplImage, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
    {
      CvGLCM localCvGLCM = opencv_legacy.cvCreateGLCM(paramIplImage, paramInt1, paramArrayOfInt, paramInt2, paramInt3);
      if (localCvGLCM != null) {
        localCvGLCM.deallocator(new ReleaseDeallocator(localCvGLCM));
      }
      return localCvGLCM;
    }
    
    public void release()
    {
      deallocate();
    }
    
    static class ReleaseDeallocator
      extends CvGLCM
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvGLCM paramCvGLCM)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseGLCM(this, 0);
      }
    }
  }
  
  public static class CvGaussBGModel
    extends CvBGStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvGaussBGModel()
    {
      allocate();
      zero();
    }
    
    public CvGaussBGModel(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvGaussBGModel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int countFrames();
    
    public native CvGaussBGModel countFrames(int paramInt);
    
    public native CvGaussBGModel g_point(CvGaussBGPoint paramCvGaussBGPoint);
    
    public native CvGaussBGPoint g_point();
    
    public native CvGaussBGModel params(CvGaussBGStatModelParams paramCvGaussBGStatModelParams);
    
    @ByRef
    public native opencv_legacy.CvGaussBGStatModelParams params();
    
    public CvGaussBGModel position(int paramInt)
    {
      return (CvGaussBGModel)super.position(paramInt);
    }
  }
  
  public static class CvGaussBGPoint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvGaussBGPoint()
    {
      allocate();
    }
    
    public CvGaussBGPoint(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGaussBGPoint(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvGaussBGPoint g_values(CvGaussBGValues paramCvGaussBGValues);
    
    public native CvGaussBGValues g_values();
    
    public CvGaussBGPoint position(int paramInt)
    {
      return (CvGaussBGPoint)super.position(paramInt);
    }
  }
  
  public static class CvGaussBGStatModelParams
    extends CvBGStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvGaussBGStatModelParams()
    {
      allocate();
      zero();
    }
    
    public CvGaussBGStatModelParams(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvGaussBGStatModelParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double bg_threshold();
    
    public native CvGaussBGStatModelParams bg_threshold(double paramDouble);
    
    public native double minArea();
    
    public native CvGaussBGStatModelParams minArea(double paramDouble);
    
    public native int n_gauss();
    
    public native CvGaussBGStatModelParams n_gauss(int paramInt);
    
    public CvGaussBGStatModelParams position(int paramInt)
    {
      return (CvGaussBGStatModelParams)super.position(paramInt);
    }
    
    public native double std_threshold();
    
    public native CvGaussBGStatModelParams std_threshold(double paramDouble);
    
    public native double variance_init();
    
    public native CvGaussBGStatModelParams variance_init(double paramDouble);
    
    public native double weight_init();
    
    public native CvGaussBGStatModelParams weight_init(double paramDouble);
    
    public native int win_size();
    
    public native CvGaussBGStatModelParams win_size(int paramInt);
  }
  
  public static class CvGaussBGValues
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvGaussBGValues()
    {
      allocate();
    }
    
    public CvGaussBGValues(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGaussBGValues(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int match_sum();
    
    public native CvGaussBGValues match_sum(int paramInt);
    
    public native double mean(int paramInt);
    
    public native CvGaussBGValues mean(int paramInt, double paramDouble);
    
    public CvGaussBGValues position(int paramInt)
    {
      return (CvGaussBGValues)super.position(paramInt);
    }
    
    public native double variance(int paramInt);
    
    public native CvGaussBGValues variance(int paramInt, double paramDouble);
    
    public native double weight();
    
    public native CvGaussBGValues weight(double paramDouble);
  }
  
  public static class CvGraphWeightedEdge
    extends opencv_core.CvGraphEdge
  {}
  
  public static class CvGraphWeightedVtx
    extends opencv_core.CvGraphVtx
  {
    static
    {
      Loader.load();
    }
    
    public CvGraphWeightedVtx()
    {
      allocate();
    }
    
    public CvGraphWeightedVtx(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGraphWeightedVtx(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvGraphWeightedVtx position(int paramInt)
    {
      return (CvGraphWeightedVtx)super.position(paramInt);
    }
    
    public native float weight();
    
    public native CvGraphWeightedVtx weight(float paramFloat);
  }
  
  public static class CvImageDrawer
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvImageDrawer()
    {
      allocate();
    }
    
    public CvImageDrawer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native opencv_core.IplImage GetImage();
  }
  
  public static class CvImgObsInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvImgObsInfo()
    {
      allocate();
      zero();
    }
    
    public CvImgObsInfo(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvImgObsInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvImgObsInfo create(opencv_core.CvSize paramCvSize, int paramInt)
    {
      CvImgObsInfo localCvImgObsInfo = opencv_legacy.cvCreateObsInfo(paramCvSize, paramInt);
      if (localCvImgObsInfo != null) {
        localCvImgObsInfo.deallocator(new ReleaseDeallocator(localCvImgObsInfo));
      }
      return localCvImgObsInfo;
    }
    
    public native IntPointer mix();
    
    public native CvImgObsInfo mix(IntPointer paramIntPointer);
    
    public native FloatPointer obs();
    
    public native CvImgObsInfo obs(FloatPointer paramFloatPointer);
    
    public native int obs_size();
    
    public native CvImgObsInfo obs_size(int paramInt);
    
    public native int obs_x();
    
    public native CvImgObsInfo obs_x(int paramInt);
    
    public native int obs_y();
    
    public native CvImgObsInfo obs_y(int paramInt);
    
    public CvImgObsInfo position(int paramInt)
    {
      return (CvImgObsInfo)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    public native IntPointer state();
    
    public native CvImgObsInfo state(IntPointer paramIntPointer);
    
    static class ReleaseDeallocator
      extends CvImgObsInfo
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvImgObsInfo paramCvImgObsInfo)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseObsInfo(this);
      }
    }
  }
  
  public static class CvLCMEdge
    extends opencv_core.CvGraphEdge
  {
    static
    {
      Loader.load();
    }
    
    public CvLCMEdge()
    {
      allocate();
    }
    
    public CvLCMEdge(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvLCMEdge(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native opencv_core.CvSeq chain();
    
    public native CvLCMEdge chain(opencv_core.CvSeq paramCvSeq);
    
    public native int index1();
    
    public native CvLCMEdge index1(int paramInt);
    
    public native int index2();
    
    public native CvLCMEdge index2(int paramInt);
    
    public CvLCMEdge position(int paramInt)
    {
      return (CvLCMEdge)super.position(paramInt);
    }
    
    public native float width();
    
    public native CvLCMEdge width(float paramFloat);
  }
  
  public static class CvLCMNode
    extends opencv_core.CvGraphVtx
  {
    static
    {
      Loader.load();
    }
    
    public CvLCMNode()
    {
      allocate();
    }
    
    public CvLCMNode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvLCMNode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native opencv_core.CvContour contour();
    
    public native CvLCMNode contour(opencv_core.CvContour paramCvContour);
    
    public CvLCMNode position(int paramInt)
    {
      return (CvLCMNode)super.position(paramInt);
    }
  }
  
  @Opaque
  public static class CvLSH
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvLSH() {}
    
    public CvLSH(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Opaque
  public static class CvLSHOperations
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvLSHOperations() {}
    
    public CvLSHOperations(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class CvObjectDetector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvObjectDetector()
    {
      allocate();
    }
    
    public CvObjectDetector(Pointer paramPointer)
    {
      super();
    }
    
    public CvObjectDetector(String paramString)
    {
      allocate(paramString);
    }
    
    private native void allocate();
    
    private native void allocate(String paramString);
    
    public native void Detect(opencv_core.CvArr paramCvArr, CvBlobSeq paramCvBlobSeq);
    
    public native int GetMaxBorderSize();
    
    @ByVal
    public native opencv_core.CvSize GetMinWindowSize();
    
    public native boolean Load(String paramString);
  }
  
  public static class CvProb
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvProb() {}
    
    public CvProb(Pointer paramPointer)
    {
      super();
    }
    
    public native void AddFeature(float paramFloat, int[] paramArrayOfInt, int paramInt1, int paramInt2);
    
    public native void Release();
    
    public native void Scale(float paramFloat, int paramInt1, int paramInt2);
    
    public native double Value(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  }
  
  public static class CvRandState
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvRandState()
    {
      allocate();
    }
    
    public CvRandState(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvRandState(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int disttype();
    
    public native CvRandState disttype(int paramInt);
    
    @ByRef
    public native opencv_core.CvScalar param(int paramInt);
    
    public native CvRandState param(int paramInt, opencv_core.CvScalar paramCvScalar);
    
    public CvRandState position(int paramInt)
    {
      return (CvRandState)super.position(paramInt);
    }
    
    public native long state();
    
    public native CvRandState state(long paramLong);
  }
  
  public static class CvReleaseBGStatModel
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    public native void call(@ByPtrPtr opencv_legacy.CvBGStatModel paramCvBGStatModel);
  }
  
  public static class CvSURFParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSURFParams()
    {
      allocate();
    }
    
    public CvSURFParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSURFParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int extended();
    
    public native CvSURFParams extended(int paramInt);
    
    public native double hessianThreshold();
    
    public native CvSURFParams hessianThreshold(double paramDouble);
    
    public native int nOctaveLayers();
    
    public native CvSURFParams nOctaveLayers(int paramInt);
    
    public native int nOctaves();
    
    public native CvSURFParams nOctaves(int paramInt);
    
    public CvSURFParams position(int paramInt)
    {
      return (CvSURFParams)super.position(paramInt);
    }
    
    public native int upright();
    
    public native CvSURFParams upright(int paramInt);
  }
  
  public static class CvSURFPoint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSURFPoint()
    {
      allocate();
    }
    
    public CvSURFPoint(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSURFPoint(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float dir();
    
    public native CvSURFPoint dir(float paramFloat);
    
    public native float hessian();
    
    public native CvSURFPoint hessian(float paramFloat);
    
    public native int laplacian();
    
    public native CvSURFPoint laplacian(int paramInt);
    
    public CvSURFPoint position(int paramInt)
    {
      return (CvSURFPoint)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvPoint2D32f pt();
    
    public native CvSURFPoint pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    public native int size();
    
    public native CvSURFPoint size(int paramInt);
  }
  
  public static class CvStarDetectorParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStarDetectorParams()
    {
      allocate();
    }
    
    public CvStarDetectorParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvStarDetectorParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int lineThresholdBinarized();
    
    public native CvStarDetectorParams lineThresholdBinarized(int paramInt);
    
    public native int lineThresholdProjected();
    
    public native CvStarDetectorParams lineThresholdProjected(int paramInt);
    
    public native int maxSize();
    
    public native CvStarDetectorParams maxSize(int paramInt);
    
    public CvStarDetectorParams position(int paramInt)
    {
      return (CvStarDetectorParams)super.position(paramInt);
    }
    
    public native int responseThreshold();
    
    public native CvStarDetectorParams responseThreshold(int paramInt);
    
    public native int suppressNonmaxSize();
    
    public native CvStarDetectorParams suppressNonmaxSize(int paramInt);
  }
  
  public static class CvStarKeypoint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStarKeypoint()
    {
      allocate();
    }
    
    public CvStarKeypoint(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvStarKeypoint(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvStarKeypoint position(int paramInt)
    {
      return (CvStarKeypoint)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvPoint pt();
    
    public native CvStarKeypoint pt(opencv_core.CvPoint paramCvPoint);
    
    public native float response();
    
    public native CvStarKeypoint response(float paramFloat);
    
    public native int size();
    
    public native CvStarKeypoint size(int paramInt);
  }
  
  public static class CvStereoCamera
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStereoCamera()
    {
      allocate();
    }
    
    public CvStereoCamera(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvStereoCamera(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    public native opencv_core.CvPoint2D32f border(int paramInt1, int paramInt2);
    
    public native CvStereoCamera border(int paramInt1, int paramInt2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    public native CvCamera camera(int paramInt);
    
    public native CvStereoCamera camera(int paramInt, CvCamera paramCvCamera);
    
    public native double coeffs(int paramInt1, int paramInt2, int paramInt3);
    
    public native CvStereoCamera coeffs(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
    
    @ByRef
    public native opencv_core.CvPoint3D32f epipole(int paramInt);
    
    public native CvStereoCamera epipole(int paramInt, opencv_core.CvPoint3D32f paramCvPoint3D32f);
    
    @MemberGetter
    public native FloatPointer fundMatr();
    
    public native CvStereoCamera lineCoeffs(CvStereoLineCoeff paramCvStereoLineCoeff);
    
    public native CvStereoLineCoeff lineCoeffs();
    
    public native int needSwapCameras();
    
    public native CvStereoCamera needSwapCameras(int paramInt);
    
    public CvStereoCamera position(int paramInt)
    {
      return (CvStereoCamera)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvPoint2D32f quad(int paramInt1, int paramInt2);
    
    public native CvStereoCamera quad(int paramInt1, int paramInt2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    @MemberGetter
    public native FloatPointer rotMatrix();
    
    @MemberGetter
    public native FloatPointer transVector();
    
    @ByRef
    public native opencv_core.CvSize warpSize();
    
    public native CvStereoCamera warpSize(opencv_core.CvSize paramCvSize);
  }
  
  public static class CvStereoGCState
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStereoGCState()
    {
      allocate();
      zero();
    }
    
    public CvStereoGCState(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvStereoGCState(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvStereoGCState create(int paramInt1, int paramInt2)
    {
      CvStereoGCState localCvStereoGCState = opencv_legacy.cvCreateStereoGCState(paramInt1, paramInt2);
      if (localCvStereoGCState != null) {
        localCvStereoGCState.deallocator(new ReleaseDeallocator(localCvStereoGCState));
      }
      return localCvStereoGCState;
    }
    
    public native int Ithreshold();
    
    public native CvStereoGCState Ithreshold(int paramInt);
    
    public native float K();
    
    public native CvStereoGCState K(float paramFloat);
    
    public native opencv_core.CvMat dispLeft();
    
    public native CvStereoGCState dispLeft(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat dispRight();
    
    public native CvStereoGCState dispRight(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat edgeBuf();
    
    public native CvStereoGCState edgeBuf(opencv_core.CvMat paramCvMat);
    
    public native int interactionRadius();
    
    public native CvStereoGCState interactionRadius(int paramInt);
    
    public native float lambda();
    
    public native CvStereoGCState lambda(float paramFloat);
    
    public native float lambda1();
    
    public native CvStereoGCState lambda1(float paramFloat);
    
    public native float lambda2();
    
    public native CvStereoGCState lambda2(float paramFloat);
    
    public native opencv_core.CvMat left();
    
    public native CvStereoGCState left(opencv_core.CvMat paramCvMat);
    
    public native int maxIters();
    
    public native CvStereoGCState maxIters(int paramInt);
    
    public native int minDisparity();
    
    public native CvStereoGCState minDisparity(int paramInt);
    
    public native int numberOfDisparities();
    
    public native CvStereoGCState numberOfDisparities(int paramInt);
    
    public native int occlusionCost();
    
    public native CvStereoGCState occlusionCost(int paramInt);
    
    public CvStereoGCState position(int paramInt)
    {
      return (CvStereoGCState)super.position(paramInt);
    }
    
    public native opencv_core.CvMat ptrLeft();
    
    public native CvStereoGCState ptrLeft(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat ptrRight();
    
    public native CvStereoGCState ptrRight(opencv_core.CvMat paramCvMat);
    
    public void release()
    {
      deallocate();
    }
    
    public native opencv_core.CvMat right();
    
    public native CvStereoGCState right(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat vtxBuf();
    
    public native CvStereoGCState vtxBuf(opencv_core.CvMat paramCvMat);
    
    static class ReleaseDeallocator
      extends CvStereoGCState
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvStereoGCState paramCvStereoGCState)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_legacy.cvReleaseStereoGCState(this);
      }
    }
  }
  
  public static class CvStereoLineCoeff
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStereoLineCoeff()
    {
      allocate();
    }
    
    public CvStereoLineCoeff(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvStereoLineCoeff(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double Xcoef();
    
    public native CvStereoLineCoeff Xcoef(double paramDouble);
    
    public native double XcoefA();
    
    public native CvStereoLineCoeff XcoefA(double paramDouble);
    
    public native double XcoefAB();
    
    public native CvStereoLineCoeff XcoefAB(double paramDouble);
    
    public native double XcoefB();
    
    public native CvStereoLineCoeff XcoefB(double paramDouble);
    
    public native double Ycoef();
    
    public native CvStereoLineCoeff Ycoef(double paramDouble);
    
    public native double YcoefA();
    
    public native CvStereoLineCoeff YcoefA(double paramDouble);
    
    public native double YcoefAB();
    
    public native CvStereoLineCoeff YcoefAB(double paramDouble);
    
    public native double YcoefB();
    
    public native CvStereoLineCoeff YcoefB(double paramDouble);
    
    public native double Zcoef();
    
    public native CvStereoLineCoeff Zcoef(double paramDouble);
    
    public native double ZcoefA();
    
    public native CvStereoLineCoeff ZcoefA(double paramDouble);
    
    public native double ZcoefAB();
    
    public native CvStereoLineCoeff ZcoefAB(double paramDouble);
    
    public native double ZcoefB();
    
    public native CvStereoLineCoeff ZcoefB(double paramDouble);
    
    public CvStereoLineCoeff position(int paramInt)
    {
      return (CvStereoLineCoeff)super.position(paramInt);
    }
  }
  
  @Opaque
  public static class CvTestSeq
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvTestSeq() {}
    
    public CvTestSeq(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class CvTracksTimePos
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvTracksTimePos()
    {
      allocate();
    }
    
    public CvTracksTimePos(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvTracksTimePos(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int beg1();
    
    public native CvTracksTimePos beg1(int paramInt);
    
    public native int beg2();
    
    public native CvTracksTimePos beg2(int paramInt);
    
    public native int comLen();
    
    public native CvTracksTimePos comLen(int paramInt);
    
    public native int end1();
    
    public native CvTracksTimePos end1(int paramInt);
    
    public native int end2();
    
    public native CvTracksTimePos end2(int paramInt);
    
    public native int len1();
    
    public native CvTracksTimePos len1(int paramInt);
    
    public native int len2();
    
    public native CvTracksTimePos len2(int paramInt);
    
    public CvTracksTimePos position(int paramInt)
    {
      return (CvTracksTimePos)super.position(paramInt);
    }
    
    public native int shift1();
    
    public native CvTracksTimePos shift1(int paramInt);
    
    public native int shift2();
    
    public native CvTracksTimePos shift2(int paramInt);
  }
  
  public static class CvUpdateBGStatModel
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    public native int call(opencv_core.IplImage paramIplImage, CvBGStatModel paramCvBGStatModel, double paramDouble);
  }
  
  public static class CvVSModule
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvVSModule() {}
    
    public CvVSModule(Pointer paramPointer)
    {
      super();
    }
    
    public native String GetModuleName();
    
    public native String GetNickName();
    
    public native double GetParam(String paramString);
    
    public native String GetParamComment(String paramString);
    
    public native String GetParamName(int paramInt);
    
    public native String GetParamStr(String paramString);
    
    public native String GetTypeName();
    
    public native int IsModuleName(String paramString);
    
    public native int IsModuleTypeName(String paramString);
    
    public native void LoadState(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void ParamUpdate();
    
    public native void Release();
    
    public native void SaveState(opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void SetNickName(String paramString);
    
    public native void SetParam(String paramString, double paramDouble);
    
    public native void SetParamStr(String paramString1, String paramString2);
    
    public native void TransferParamsFromChild(CvVSModule paramCvVSModule, String paramString);
    
    public native void TransferParamsToChild(CvVSModule paramCvVSModule, @Cast({"char*"}) String paramString);
  }
  
  public static class CvVoronoiDiagram2D
    extends opencv_core.CvGraph
  {
    static
    {
      Loader.load();
    }
    
    public CvVoronoiDiagram2D()
    {
      allocate();
    }
    
    public CvVoronoiDiagram2D(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvVoronoiDiagram2D(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvVoronoiDiagram2D position(int paramInt)
    {
      return (CvVoronoiDiagram2D)super.position(paramInt);
    }
    
    public native opencv_core.CvSet sites();
    
    public native CvVoronoiDiagram2D sites(opencv_core.CvSet paramCvSet);
  }
  
  public static class CvVoronoiEdge2D
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvVoronoiEdge2D()
    {
      allocate();
    }
    
    public CvVoronoiEdge2D(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvVoronoiEdge2D(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvVoronoiEdge2D next(int paramInt);
    
    public native CvVoronoiEdge2D next(int paramInt, CvVoronoiEdge2D paramCvVoronoiEdge2D);
    
    public native CvVoronoiEdge2D node(int paramInt, CvVoronoiNode2D paramCvVoronoiNode2D);
    
    public native CvVoronoiNode2D node(int paramInt);
    
    public CvVoronoiEdge2D position(int paramInt)
    {
      return (CvVoronoiEdge2D)super.position(paramInt);
    }
    
    public native CvVoronoiEdge2D site(int paramInt, CvVoronoiSite2D paramCvVoronoiSite2D);
    
    public native CvVoronoiSite2D site(int paramInt);
  }
  
  public static class CvVoronoiNode2D
    extends opencv_core.CvSetElem
  {
    static
    {
      Loader.load();
    }
    
    public CvVoronoiNode2D()
    {
      allocate();
    }
    
    public CvVoronoiNode2D(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvVoronoiNode2D(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvVoronoiNode2D position(int paramInt)
    {
      return (CvVoronoiNode2D)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvPoint2D32f pt();
    
    public native CvVoronoiNode2D pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    public native float radius();
    
    public native CvVoronoiNode2D radius(float paramFloat);
  }
  
  public static class CvVoronoiSite2D
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvVoronoiSite2D()
    {
      allocate();
    }
    
    public CvVoronoiSite2D(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvVoronoiSite2D(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvVoronoiEdge2D edge(int paramInt);
    
    public native CvVoronoiSite2D edge(int paramInt, CvVoronoiEdge2D paramCvVoronoiEdge2D);
    
    public native CvVoronoiSite2D next(int paramInt);
    
    public native CvVoronoiSite2D next(int paramInt, CvVoronoiSite2D paramCvVoronoiSite2D);
    
    public native CvVoronoiNode2D node(int paramInt);
    
    public native CvVoronoiSite2D node(int paramInt, CvVoronoiNode2D paramCvVoronoiNode2D);
    
    public CvVoronoiSite2D position(int paramInt)
    {
      return (CvVoronoiSite2D)super.position(paramInt);
    }
  }
  
  @Namespace("cv")
  public static class FernClassifier
    extends Pointer
  {
    public static final int COMPRESSION_NONE = 0;
    public static final int COMPRESSION_PCA = 2;
    public static final int COMPRESSION_RANDOM_PROJ = 1;
    public static final int DEFAULT_COMPRESSION_METHOD = 0;
    public static final int DEFAULT_SIGNATURE_SIZE = 176;
    public static final int DEFAULT_STRUCTS = 50;
    public static final int DEFAULT_STRUCT_SIZE = 9;
    public static final int DEFAULT_VIEWS = 5000;
    public static final int PATCH_SIZE = 31;
    
    static
    {
      Loader.load();
    }
    
    public FernClassifier()
    {
      allocate();
    }
    
    public FernClassifier(Pointer paramPointer)
    {
      super();
    }
    
    public FernClassifier(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode)
    {
      allocate(paramCvFileStorage, paramCvFileNode);
    }
    
    public FernClassifier(@ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @ByRef opencv_core.IntVectorVector paramIntVectorVector, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator)
    {
      allocate(paramPoint2fVectorVector, paramIplImageArray, paramIntVectorVector, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramPatchGenerator);
    }
    
    private native void allocate();
    
    private native void allocate(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    private native void allocate(@ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @ByRef opencv_core.IntVectorVector paramIntVectorVector, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    @Name({"operator()"})
    public native int classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector FloatPointer paramFloatPointer);
    
    @Name({"operator()"})
    public native int classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @StdVector FloatPointer paramFloatPointer);
    
    public native void clear();
    
    public native int getClassCount();
    
    public native int getCompressionMethod();
    
    @ByVal
    public native opencv_core.CvSize getPatchSize();
    
    public native int getSignatureSize();
    
    public native int getStructCount();
    
    public native int getStructSize();
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
    
    public native void train(@ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @ByRef opencv_core.IntVectorVector paramIntVectorVector, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    public native void trainFromSingleView(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, String paramString);
    
    public static class Feature
      extends Pointer
    {
      public byte x1;
      public byte x2;
      public byte y1;
      public byte y2;
      
      static
      {
        Loader.load();
      }
      
      public Feature()
      {
        allocate();
      }
      
      public Feature(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
      {
        allocate(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      
      private native void allocate();
      
      private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    }
  }
  
  @Namespace("cv")
  public static class FernDescriptorMatcher
    extends opencv_features2d.GenericDescriptorMatcher
  {
    static
    {
      Loader.load();
    }
    
    public FernDescriptorMatcher()
    {
      allocate();
    }
    
    public FernDescriptorMatcher(Pointer paramPointer)
    {
      super();
    }
    
    public FernDescriptorMatcher(Params paramParams)
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
      
      public Params(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator)
      {
        allocate(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramPatchGenerator);
      }
      
      public Params(Pointer paramPointer)
      {
        super();
      }
      
      public Params(String paramString)
      {
        allocate(paramString);
      }
      
      private native void allocate();
      
      private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
      
      private native void allocate(String paramString);
      
      private native void allocateArray(int paramInt);
      
      public native int compressionMethod();
      
      public native Params compressionMethod(int paramInt);
      
      public native Params filename(String paramString);
      
      @ByRef
      public native String filename();
      
      public native int nclasses();
      
      public native Params nclasses(int paramInt);
      
      public native int nstructs();
      
      public native Params nstructs(int paramInt);
      
      public native int nviews();
      
      public native Params nviews(int paramInt);
      
      public native Params patchGenerator(PatchGenerator paramPatchGenerator);
      
      @ByRef
      public native opencv_legacy.PatchGenerator patchGenerator();
      
      public native int patchSize();
      
      public native Params patchSize(int paramInt);
      
      public Params position(int paramInt)
      {
        return (Params)super.position(paramInt);
      }
      
      public native int signatureSize();
      
      public native Params signatureSize(int paramInt);
      
      public native int structSize();
      
      public native Params structSize(int paramInt);
    }
  }
  
  @Name({"cv::CalonderDescriptorExtractor<float>"})
  public static class FloatCalonderDescriptorExtractor
    extends opencv_features2d.DescriptorExtractor
  {
    protected static final int BORDER_SIZE = 16;
    
    static
    {
      Loader.load();
    }
    
    public FloatCalonderDescriptorExtractor() {}
    
    public FloatCalonderDescriptorExtractor(Pointer paramPointer)
    {
      super();
    }
    
    public FloatCalonderDescriptorExtractor(String paramString)
    {
      allocate(paramString);
    }
    
    private native void allocate(String paramString);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class LDetector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public LDetector()
    {
      allocate();
    }
    
    public LDetector(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble1, paramDouble2);
    }
    
    public LDetector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2);
    
    public native double baseFeatureSize();
    
    public native LDetector baseFeatureSize(double paramDouble);
    
    public native double clusteringDistance();
    
    public native LDetector clusteringDistance(double paramDouble);
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt, @Cast({"bool"}) boolean paramBoolean);
    
    @Name({"operator()"})
    public native void detect(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt, @Cast({"bool"}) boolean paramBoolean);
    
    public native void getMostStable2D(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    public native int nOctaves();
    
    public native LDetector nOctaves(int paramInt);
    
    public native int nViews();
    
    public native LDetector nViews(int paramInt);
    
    public native int radius();
    
    public native LDetector radius(int paramInt);
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
    
    public native int threshold();
    
    public native LDetector threshold(int paramInt);
    
    public native LDetector verbose(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean verbose();
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, String paramString);
  }
  
  @Namespace("cv")
  public static class OneWayDescriptor
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public OneWayDescriptor()
    {
      allocate();
    }
    
    public OneWayDescriptor(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void Allocate(int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2);
    
    public native void EstimatePose(opencv_core.IplImage paramIplImage, @ByRef int[] paramArrayOfInt, @ByRef float[] paramArrayOfFloat);
    
    public native void EstimatePosePCA(opencv_core.CvArr paramCvArr, @ByRef int[] paramArrayOfInt, @ByRef float[] paramArrayOfFloat, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native void GenerateSamples(int paramInt1, opencv_core.IplImage paramIplImage, int paramInt2);
    
    public native void GenerateSamplesFast(opencv_core.IplImage paramIplImage, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, OneWayDescriptor paramOneWayDescriptor);
    
    @ByVal
    public native opencv_core.CvPoint GetCenter();
    
    public native String GetFeatureName();
    
    @ByVal
    public native opencv_core.CvSize GetInputPatchSize();
    
    public native opencv_core.CvMatArray GetPCACoeffs();
    
    public native int GetPCADimHigh();
    
    public native int GetPCADimLow();
    
    public native opencv_core.IplImage GetPatch(int paramInt);
    
    @ByVal
    public native opencv_core.CvSize GetPatchSize();
    
    @ByVal
    public native opencv_legacy.CvAffinePose GetPose(int paramInt);
    
    public native void Initialize(int paramInt1, opencv_core.IplImage paramIplImage, String paramString, int paramInt2);
    
    public native void InitializeFast(int paramInt, opencv_core.IplImage paramIplImage, String paramString, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, OneWayDescriptor paramOneWayDescriptor);
    
    public native void InitializePCACoeffs(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native void ProjectPCASample(opencv_core.IplImage paramIplImage, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
    
    public native int ReadByName(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, String paramString);
    
    public native void Save(String paramString);
    
    public native void SetPCADimHigh(int paramInt);
    
    public native void SetPCADimLow(int paramInt);
    
    public native void SetTransforms(CvAffinePose paramCvAffinePose, opencv_core.CvMatArray paramCvMatArray);
    
    public native void Write(opencv_core.CvFileStorage paramCvFileStorage, String paramString);
  }
  
  @Namespace("cv")
  public static class OneWayDescriptorBase
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public OneWayDescriptorBase() {}
    
    public OneWayDescriptorBase(Pointer paramPointer)
    {
      super();
    }
    
    public OneWayDescriptorBase(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4)
    {
      allocate(paramCvSize, paramInt1, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3, paramInt2, paramInt3, paramInt4);
    }
    
    public OneWayDescriptorBase(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4)
    {
      allocate(paramCvSize, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramInt3, paramInt4);
    }
    
    @ByRef
    public static native String GetPCAFilename();
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4);
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4);
    
    public native void Allocate(int paramInt);
    
    public native void AllocatePCADescriptors();
    
    public native void CreateDescriptorsFromImage(opencv_core.IplImage paramIplImage, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    public native void CreatePCADescriptors();
    
    public native void FindDescriptor(opencv_core.IplImage paramIplImage, int paramInt, @Const @StdVector int[] paramArrayOfInt1, @Const @StdVector int[] paramArrayOfInt2, @Const @StdVector float[] paramArrayOfFloat1, @Const @StdVector float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
    
    public native void FindDescriptor(opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2, @ByRef float[] paramArrayOfFloat);
    
    public native void FindDescriptor(opencv_core.IplImage paramIplImage, @ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2, @ByRef float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
    
    public native void GeneratePCA(String paramString1, String paramString2, int paramInt);
    
    @Const
    public native opencv_legacy.OneWayDescriptor GetDescriptor(int paramInt);
    
    public native int GetDescriptorCount();
    
    public native int GetLowPCA(@ByPtrPtr opencv_core.CvMat paramCvMat1, @ByPtrPtr opencv_core.CvMat paramCvMat2);
    
    public native int GetPCADimHigh();
    
    public native int GetPCADimLow();
    
    @ByVal
    public native opencv_core.CvSize GetPatchSize();
    
    public native int GetPoseCount();
    
    public native int GetPyrLevels();
    
    public native void InitializeDescriptor(int paramInt, opencv_core.IplImage paramIplImage, @ByRef opencv_features2d.KeyPoint paramKeyPoint, String paramString);
    
    public native void InitializeDescriptor(int paramInt, opencv_core.IplImage paramIplImage, String paramString);
    
    public native void InitializeDescriptors(opencv_core.IplImage paramIplImage, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, String paramString, int paramInt);
    
    public native void InitializePoseTransforms();
    
    public native void InitializePoses();
    
    public native void InitializeTransformsFromPoses();
    
    public native int LoadPCADescriptors(String paramString);
    
    public native void LoadPCADescriptors(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void Read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void SavePCADescriptors(opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void SavePCADescriptors(String paramString);
    
    public native void SetPCAHigh(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native void SetPCALow(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native void Write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public native void clear();
    
    public native boolean empty();
  }
  
  @Namespace("cv")
  public static class OneWayDescriptorMatcher
    extends opencv_features2d.GenericDescriptorMatcher
  {
    static
    {
      Loader.load();
    }
    
    public OneWayDescriptorMatcher()
    {
      allocate();
    }
    
    public OneWayDescriptorMatcher(Pointer paramPointer)
    {
      super();
    }
    
    public OneWayDescriptorMatcher(Params paramParams)
    {
      allocate(paramParams);
    }
    
    private native void allocate();
    
    private native void allocate(@ByRef Params paramParams);
    
    public native void initialize(@ByRef Params paramParams, @opencv_core.Ptr OneWayDescriptorBase paramOneWayDescriptorBase);
    
    @NoOffset
    public static class Params
      extends Pointer
    {
      public static final int PATCH_HEIGHT = 24;
      public static final int PATCH_WIDTH = 24;
      public static final int POSE_COUNT = 500;
      
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
      
      public Params(int paramInt, @ByVal opencv_core.CvSize paramCvSize, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
      {
        allocate(paramInt, paramCvSize, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
      }
      
      public Params(Pointer paramPointer)
      {
        super();
      }
      
      public static native float GET_MAX_SCALE();
      
      public static native float GET_MIN_SCALE();
      
      public static native float GET_STEP_SCALE();
      
      private native void allocate();
      
      private native void allocate(int paramInt, @ByVal opencv_core.CvSize paramCvSize, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3);
      
      private native void allocateArray(int paramInt);
      
      public native float maxScale();
      
      public native Params maxScale(float paramFloat);
      
      public native float minScale();
      
      public native Params minScale(float paramFloat);
      
      @ByVal
      public native opencv_core.CvSize patchSize();
      
      public native Params patchSize(opencv_core.CvSize paramCvSize);
      
      public native Params pcaFilename(String paramString);
      
      @ByRef
      public native String pcaFilename();
      
      public native int poseCount();
      
      public native Params poseCount(int paramInt);
      
      public Params position(int paramInt)
      {
        return (Params)super.position(paramInt);
      }
      
      public native float stepScale();
      
      public native Params stepScale(float paramFloat);
      
      public native Params trainImagesList(String paramString);
      
      @ByRef
      public native String trainImagesList();
      
      public native Params trainPath(String paramString);
      
      @ByRef
      public native String trainPath();
    }
  }
  
  @Namespace("cv")
  public static class OneWayDescriptorObject
    extends OneWayDescriptorBase
  {
    static
    {
      Loader.load();
    }
    
    public OneWayDescriptorObject() {}
    
    public OneWayDescriptorObject(Pointer paramPointer)
    {
      super();
    }
    
    public OneWayDescriptorObject(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
    {
      allocate(paramCvSize, paramInt1, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3, paramInt2);
    }
    
    public OneWayDescriptorObject(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
    {
      allocate(paramCvSize, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2);
    }
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2);
    
    private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2);
    
    public native void Allocate(int paramInt1, int paramInt2);
    
    public native int GetDescriptorPart(int paramInt);
    
    @StdVector
    public native opencv_features2d.KeyPoint GetLabeledFeatures();
    
    public native int GetObjectFeatureCount();
    
    public native void InitializeObjectDescriptors(opencv_core.IplImage paramIplImage, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, String paramString, int paramInt1, float paramFloat, int paramInt2);
    
    public native int IsDescriptorObject(int paramInt);
    
    public native int MatchPointToPart(@ByVal opencv_core.CvPoint paramCvPoint);
    
    public native void SetLabeledFeatures(@Const @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    @StdVector
    public native opencv_features2d.KeyPoint _GetLabeledFeatures();
  }
  
  @Namespace("cv")
  @NoOffset
  public static class PatchGenerator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public PatchGenerator()
    {
      allocate();
    }
    
    public PatchGenerator(double paramDouble1, double paramDouble2, double paramDouble3, boolean paramBoolean, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      allocate(paramDouble1, paramDouble2, paramDouble3, paramBoolean, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDouble8, paramDouble9);
    }
    
    public PatchGenerator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3, @Cast({"bool"}) boolean paramBoolean, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9);
    
    public native double backgroundMax();
    
    public native PatchGenerator backgroundMax(double paramDouble);
    
    public native double backgroundMin();
    
    public native PatchGenerator backgroundMin(double paramDouble);
    
    @Name({"operator()"})
    public native void generate(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, opencv_core.CvMat paramCvMat, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG);
    
    @Name({"operator()"})
    public native void generate(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG);
    
    public native void generateRandomTransform(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG, @Cast({"bool"}) boolean paramBoolean);
    
    public native double lambdaMax();
    
    public native PatchGenerator lambdaMax(double paramDouble);
    
    public native double lambdaMin();
    
    public native PatchGenerator lambdaMin(double paramDouble);
    
    public native double noiseRange();
    
    public native PatchGenerator noiseRange(double paramDouble);
    
    public native double phiMax();
    
    public native PatchGenerator phiMax(double paramDouble);
    
    public native double phiMin();
    
    public native PatchGenerator phiMin(double paramDouble);
    
    public native PatchGenerator randomBlur(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean randomBlur();
    
    public native void setAffineParam(double paramDouble1, double paramDouble2, double paramDouble3);
    
    public native double thetaMax();
    
    public native PatchGenerator thetaMax(double paramDouble);
    
    public native double thetaMin();
    
    public native PatchGenerator thetaMin(double paramDouble);
    
    public native void warpWholeImage(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, int paramInt, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG);
  }
  
  @Namespace("cv")
  public static class PlanarObjectDetector
    extends Pointer
  {
    public PlanarObjectDetector()
    {
      allocate();
    }
    
    public PlanarObjectDetector(Pointer paramPointer)
    {
      super();
    }
    
    public PlanarObjectDetector(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode)
    {
      allocate(paramCvFileStorage, paramCvFileNode);
    }
    
    public PlanarObjectDetector(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator)
    {
      allocate(paramIplImageArray, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLDetector, paramPatchGenerator);
    }
    
    private native void allocate();
    
    private native void allocate(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    private native void allocate(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    @Name({"operator()"})
    public native boolean detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f);
    
    @Name({"operator()"})
    public native boolean detect(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @StdVector IntPointer paramIntPointer);
    
    @StdVector
    public native opencv_features2d.KeyPoint getModelPoints();
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
    
    public native void train(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    public native void train(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, String paramString);
  }
  
  @Namespace("cv")
  public static class RTreeClassifier
    extends Pointer
  {
    public static final int DEFAULT_NUM_QUANT_BITS = 4;
    public static final int DEFAULT_TREES = 48;
    
    static
    {
      Loader.load();
    }
    
    public RTreeClassifier()
    {
      allocate();
    }
    
    public RTreeClassifier(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public static native int countNonZeroElements(float[] paramArrayOfFloat, int paramInt, double paramDouble);
    
    public native int classes();
    
    public native float countZeroElements();
    
    public native void discardFloatPosteriors();
    
    public native void getFloatSignature(opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
    
    public native void getSignature(opencv_core.IplImage paramIplImage, @Cast({"uchar*"}) byte[] paramArrayOfByte);
    
    public native void getSignature(opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
    
    public native void getSparseSignature(opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat, float paramFloat);
    
    public native int original_num_classes();
    
    public native void read(@ByRef @Cast({"std::istream*"}) Pointer paramPointer);
    
    public native void read(String paramString);
    
    public native void saveAllBytePosteriors(String paramString);
    
    public native void saveAllFloatPosteriors(String paramString);
    
    public native void setFloatPosteriorsFromTextfile_176(String paramString);
    
    public native void setQuantization(int paramInt);
    
    public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Adapter("RNGAdapter") @Const opencv_core.CvRNG paramCvRNG, int paramInt1, int paramInt2, int paramInt3, @Cast({"size_t"}) long paramLong, int paramInt4);
    
    public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Adapter("RNGAdapter") @Const opencv_core.CvRNG paramCvRNG, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator, int paramInt1, int paramInt2, int paramInt3, @Cast({"size_t"}) long paramLong, int paramInt4);
    
    public native RTreeClassifier trees_(RandomizedTree paramRandomizedTree);
    
    @Const
    @NoOffset
    @StdVector
    public native opencv_legacy.RandomizedTree trees_();
    
    public native void write(@ByRef @Cast({"std::ostream*"}) Pointer paramPointer);
    
    public native void write(String paramString);
  }
  
  @Namespace("cv")
  @NoOffset
  public static class RTreeNode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public RTreeNode()
    {
      allocate();
    }
    
    public RTreeNode(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
    {
      allocate(paramByte1, paramByte2, paramByte3, paramByte4);
    }
    
    private native void allocate();
    
    private native void allocate(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
    
    @Name({"operator()"})
    public native boolean compare(@Cast({"uchar*"}) BytePointer paramBytePointer);
    
    public native RTreeNode offset1(short paramShort);
    
    public native short offset1();
    
    public native RTreeNode offset2(short paramShort);
    
    public native short offset2();
  }
  
  @Namespace("cv")
  public static class RandomizedTree
    extends Pointer
  {
    public static final int DEFAULT_DEPTH = 9;
    public static final int DEFAULT_REDUCED_NUM_DIM = 176;
    public static final int DEFAULT_VIEWS = 5000;
    public static final byte PATCH_SIZE = 32;
    
    static
    {
      Loader.load();
    }
    
    public RandomizedTree()
    {
      allocate();
    }
    
    public RandomizedTree(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public RandomizedTree(Pointer paramPointer)
    {
      super();
    }
    
    public static native float GET_LOWER_QUANT_PERC();
    
    public static native float GET_UPPER_QUANT_PERC();
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static native void quantizeVector(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);
    
    public static native void quantizeVector(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, @Cast({"uchar*"}) BytePointer paramBytePointer);
    
    public native void applyQuantization(int paramInt);
    
    public native int classes();
    
    public native int depth();
    
    public native void discardFloatPosteriors();
    
    public native FloatPointer getPosterior(@Cast({"uchar*"}) BytePointer paramBytePointer);
    
    @Cast({"uchar*"})
    public native BytePointer getPosterior2(@Cast({"uchar*"}) BytePointer paramBytePointer);
    
    public RandomizedTree position(int paramInt)
    {
      return (RandomizedTree)super.position(paramInt);
    }
    
    public native void read(@ByRef @Cast({"std::istream*"}) Pointer paramPointer, int paramInt);
    
    public native void read(String paramString, int paramInt);
    
    public native void savePosteriors(String paramString, @Cast({"bool"}) boolean paramBoolean);
    
    public native void savePosteriors2(String paramString, @Cast({"bool"}) boolean paramBoolean);
    
    public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Adapter("RNGAdapter") @Const opencv_core.CvRNG paramCvRNG, int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3);
    
    public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Adapter("RNGAdapter") @Const opencv_core.CvRNG paramCvRNG, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator, int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3);
    
    public native void write(@ByRef @Cast({"std::ostream*"}) Pointer paramPointer);
    
    public native void write(String paramString);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_legacy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */