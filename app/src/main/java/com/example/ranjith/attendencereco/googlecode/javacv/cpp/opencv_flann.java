package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"opencv_adapters.h", "<opencv2/flann/miniflann.hpp>"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_flann@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_flann245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_flann
{
  public static final int FLANN_CENTERS_GONZALES = 1;
  public static final int FLANN_CENTERS_KMEANSPP = 2;
  public static final int FLANN_CENTERS_RANDOM = 0;
  public static final int FLANN_DIST_CHI_SQUARE = 7;
  public static final int FLANN_DIST_CS = 7;
  public static final int FLANN_DIST_EUCLIDEAN = 1;
  public static final int FLANN_DIST_HAMMING = 9;
  public static final int FLANN_DIST_HELLINGER = 6;
  public static final int FLANN_DIST_HIST_INTERSECT = 5;
  public static final int FLANN_DIST_KL = 8;
  public static final int FLANN_DIST_KULLBACK_LEIBLER = 8;
  public static final int FLANN_DIST_L1 = 2;
  public static final int FLANN_DIST_L2 = 1;
  public static final int FLANN_DIST_MANHATTAN = 2;
  public static final int FLANN_DIST_MAX = 4;
  public static final int FLANN_DIST_MINKOWSKI = 3;
  public static final int FLANN_INDEX_AUTOTUNED = 255;
  public static final int FLANN_INDEX_COMPOSITE = 3;
  public static final int FLANN_INDEX_KDTREE = 1;
  public static final int FLANN_INDEX_KMEANS = 2;
  public static final int FLANN_INDEX_LINEAR = 0;
  public static final int FLANN_INDEX_SAVED = 254;
  public static final String FLANN_VERSION_ = "1.6.10";
  
  static
  {
    Loader.load(opencv_core.class);
    Loader.load();
  }
  
  @Namespace("cv::flann")
  public static class AutotunedIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public AutotunedIndexParams()
    {
      allocate();
    }
    
    public AutotunedIndexParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      allocate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    
    public AutotunedIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
  
  @Namespace("cv::flann")
  public static class CompositeIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public CompositeIndexParams()
    {
      allocate();
    }
    
    public CompositeIndexParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramInt4, paramFloat);
    }
    
    public CompositeIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3, @Cast({"cvflann::flann_centers_init_t"}) int paramInt4, float paramFloat);
  }
  
  @Namespace("cv::flann")
  public static class HierarchicalClusteringIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public HierarchicalClusteringIndexParams()
    {
      allocate();
    }
    
    public HierarchicalClusteringIndexParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public HierarchicalClusteringIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, @Cast({"cvflann::flann_centers_init_t"}) int paramInt2, int paramInt3, int paramInt4);
  }
  
  @Namespace("cv::flann")
  public static class Index
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Index()
    {
      allocate();
    }
    
    public Index(FloatPointer paramFloatPointer, IndexParams paramIndexParams, int paramInt)
    {
      allocate(paramFloatPointer, paramIndexParams, paramInt);
    }
    
    public Index(Pointer paramPointer)
    {
      super();
    }
    
    public Index(opencv_core.CvArr paramCvArr, IndexParams paramIndexParams, int paramInt)
    {
      allocate(paramCvArr, paramIndexParams, paramInt);
    }
    
    private native void allocate();
    
    private native void allocate(@opencv_core.InputArray FloatPointer paramFloatPointer, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
    
    private native void allocate(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
    
    public native void build(@opencv_core.InputArray FloatPointer paramFloatPointer, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
    
    public native void build(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
    
    @Cast({"cvflann::flann_algorithm_t"})
    public native int getAlgorithm();
    
    @Cast({"cvflann::flann_distance_t"})
    public native int getDistance();
    
    public native void knnSearch(@opencv_core.InputArray FloatPointer paramFloatPointer1, @opencv_core.OutputArray IntPointer paramIntPointer, @opencv_core.OutputArray FloatPointer paramFloatPointer2, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
    
    public native void knnSearch(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
    
    public native boolean load(@opencv_core.InputArray FloatPointer paramFloatPointer, String paramString);
    
    public native boolean load(@opencv_core.InputArray opencv_core.CvArr paramCvArr, String paramString);
    
    public native int radiusSearch(@opencv_core.InputArray FloatPointer paramFloatPointer1, @opencv_core.OutputArray IntPointer paramIntPointer, @opencv_core.OutputArray FloatPointer paramFloatPointer2, double paramDouble, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
    
    public native int radiusSearch(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, double paramDouble, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
    
    public native void release();
    
    public native void save(String paramString);
  }
  
  @Namespace("cv::flann")
  @NoOffset
  public static class IndexParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IndexParams()
    {
      allocate();
    }
    
    public IndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void getAll(@ByRef opencv_core.StringVector paramStringVector1, @StdVector IntPointer paramIntPointer, @ByRef opencv_core.StringVector paramStringVector2, @StdVector DoublePointer paramDoublePointer);
    
    public native double getDouble(String paramString, double paramDouble);
    
    public native int getInt(String paramString, int paramInt);
    
    @ByRef
    public native String getString(String paramString1, String paramString2);
    
    public native Pointer params();
    
    public native IndexParams params(Pointer paramPointer);
    
    public native void setAlgorithm(int paramInt);
    
    public native void setBool(String paramString, @Cast({"bool"}) boolean paramBoolean);
    
    public native void setDouble(String paramString, double paramDouble);
    
    public native void setFloat(String paramString, float paramFloat);
    
    public native void setInt(String paramString, int paramInt);
    
    public native void setString(String paramString1, String paramString2);
  }
  
  @Namespace("cv::flann")
  public static class KDTreeIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public KDTreeIndexParams()
    {
      allocate();
    }
    
    public KDTreeIndexParams(int paramInt)
    {
      allocate(paramInt);
    }
    
    public KDTreeIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt);
  }
  
  @Namespace("cv::flann")
  public static class KMeansIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public KMeansIndexParams()
    {
      allocate();
    }
    
    public KMeansIndexParams(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      allocate(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    
    public KMeansIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @Cast({"cvflann::flann_centers_init_t"}) int paramInt3, float paramFloat);
  }
  
  @Namespace("cv::flann")
  public static class LinearIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public LinearIndexParams()
    {
      allocate();
    }
    
    public LinearIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  @Namespace("cv::flann")
  public static class LshIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public LshIndexParams(int paramInt1, int paramInt2, int paramInt3)
    {
      allocate(paramInt1, paramInt2, paramInt3);
    }
    
    public LshIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(int paramInt1, int paramInt2, int paramInt3);
  }
  
  @Namespace("cv::flann")
  public static class SavedIndexParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public SavedIndexParams() {}
    
    public SavedIndexParams(Pointer paramPointer)
    {
      super();
    }
    
    public SavedIndexParams(String paramString)
    {
      allocate(paramString);
    }
    
    private native void allocate(String paramString);
  }
  
  @Namespace("cv::flann")
  public static class SearchParams
    extends IndexParams
  {
    static
    {
      Loader.load();
    }
    
    public SearchParams()
    {
      allocate();
    }
    
    public SearchParams(int paramInt, float paramFloat, boolean paramBoolean)
    {
      allocate(paramInt, paramFloat, paramBoolean);
    }
    
    public SearchParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt, float paramFloat, @Cast({"bool"}) boolean paramBoolean);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_flann.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */