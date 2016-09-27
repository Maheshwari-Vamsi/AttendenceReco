package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.Pointer.Deallocator;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacpp.SizeTPointer;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Convention;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.MemberSetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;
import com.googlecode.javacpp.annotation.ValueGetter;
import com.googlecode.javacpp.annotation.ValueSetter;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferDouble;
import java.awt.image.DataBufferFloat;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferShort;
import java.awt.image.DataBufferUShort;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/core/core.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}, preload={"tbb"}), @com.googlecode.javacpp.annotation.Platform(define={"_WIN32_WINNT 0x0502"}, includepath={"C:/opencv/build/include/"}, link={"opencv_core245"}, preload={"msvcr100", "msvcp100"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_core
{
  public static final int CV_16S = 3;
  public static final int CV_16SC1 = 0;
  public static final int CV_16SC2 = 0;
  public static final int CV_16SC3 = 0;
  public static final int CV_16SC4 = 0;
  public static final int CV_16U = 2;
  public static final int CV_16UC1 = 0;
  public static final int CV_16UC2 = 0;
  public static final int CV_16UC3 = 0;
  public static final int CV_16UC4 = 0;
  public static final int CV_32F = 5;
  public static final int CV_32FC1 = 0;
  public static final int CV_32FC2 = 0;
  public static final int CV_32FC3 = 0;
  public static final int CV_32FC4 = 0;
  public static final int CV_32S = 4;
  public static final int CV_32SC1 = 0;
  public static final int CV_32SC2 = 0;
  public static final int CV_32SC3 = 0;
  public static final int CV_32SC4 = 0;
  public static final int CV_64F = 6;
  public static final int CV_64FC1 = 0;
  public static final int CV_64FC2 = 0;
  public static final int CV_64FC3 = 0;
  public static final int CV_64FC4 = 0;
  public static final int CV_8S = 1;
  public static final int CV_8SC1 = 0;
  public static final int CV_8SC2 = 0;
  public static final int CV_8SC3 = 0;
  public static final int CV_8SC4 = 0;
  public static final int CV_8U = 0;
  public static final int CV_8UC1 = 0;
  public static final int CV_8UC2 = 0;
  public static final int CV_8UC3 = 0;
  public static final int CV_8UC4 = 0;
  public static final int CV_AA = 16;
  public static final int CV_AUTOSTEP = Integer.MAX_VALUE;
  public static final int CV_AUTO_STEP = Integer.MAX_VALUE;
  public static final int CV_BACK = 0;
  public static final int CV_BadAlign = -21;
  public static final int CV_BadAlphaChannel = -18;
  public static final int CV_BadCOI = -24;
  public static final int CV_BadCallBack = -22;
  public static final int CV_BadDataPtr = -12;
  public static final int CV_BadDepth = -17;
  public static final int CV_BadImageSize = -10;
  public static final int CV_BadModelOrChSeq = -14;
  public static final int CV_BadNumChannel1U = -16;
  public static final int CV_BadNumChannels = -15;
  public static final int CV_BadOffset = -11;
  public static final int CV_BadOrder = -19;
  public static final int CV_BadOrigin = -20;
  public static final int CV_BadROISize = -25;
  public static final int CV_BadStep = -13;
  public static final int CV_BadTileSize = -23;
  public static final int CV_C = 1;
  public static final int CV_CHECK_QUIET = 2;
  public static final int CV_CHECK_RANGE = 1;
  public static final int CV_CHOLESKY = 3;
  public static final int CV_CMP_EQ = 0;
  public static final int CV_CMP_GE = 2;
  public static final int CV_CMP_GT = 1;
  public static final int CV_CMP_LE = 4;
  public static final int CV_CMP_LT = 3;
  public static final int CV_CMP_NE = 5;
  public static final int CV_CN_MAX = 512;
  public static final int CV_CN_SHIFT = 3;
  public static final int CV_COVAR_COLS = 16;
  public static final int CV_COVAR_NORMAL = 1;
  public static final int CV_COVAR_ROWS = 8;
  public static final int CV_COVAR_SCALE = 4;
  public static final int CV_COVAR_SCRAMBLED = 0;
  public static final int CV_COVAR_USE_AVG = 2;
  public static final int CV_CPU_AVX = 10;
  public static final int CV_CPU_MMX = 1;
  public static final int CV_CPU_NONE = 0;
  public static final int CV_CPU_POPCNT = 8;
  public static final int CV_CPU_SSE = 2;
  public static final int CV_CPU_SSE2 = 3;
  public static final int CV_CPU_SSE3 = 4;
  public static final int CV_CPU_SSE4_1 = 6;
  public static final int CV_CPU_SSE4_2 = 7;
  public static final int CV_CPU_SSSE3 = 5;
  public static final int CV_DEPTH_MAX = 8;
  public static final int CV_DIFF = 16;
  public static final int CV_DIFF_C = 17;
  public static final int CV_DIFF_L1 = 18;
  public static final int CV_DIFF_L2 = 20;
  public static final int CV_DXT_FORWARD = 0;
  public static final int CV_DXT_INVERSE = 1;
  public static final int CV_DXT_INVERSE_SCALE = 3;
  public static final int CV_DXT_INV_SCALE = 3;
  public static final int CV_DXT_MUL_CONJ = 8;
  public static final int CV_DXT_ROWS = 4;
  public static final int CV_DXT_SCALE = 2;
  public static final int CV_ErrModeLeaf = 0;
  public static final int CV_ErrModeParent = 1;
  public static final int CV_ErrModeSilent = 2;
  public static final int CV_FILLED = -1;
  public static final int CV_FONT_HERSHEY_COMPLEX = 3;
  public static final int CV_FONT_HERSHEY_COMPLEX_SMALL = 5;
  public static final int CV_FONT_HERSHEY_DUPLEX = 2;
  public static final int CV_FONT_HERSHEY_PLAIN = 1;
  public static final int CV_FONT_HERSHEY_SCRIPT_COMPLEX = 7;
  public static final int CV_FONT_HERSHEY_SCRIPT_SIMPLEX = 6;
  public static final int CV_FONT_HERSHEY_SIMPLEX = 0;
  public static final int CV_FONT_HERSHEY_TRIPLEX = 4;
  public static final int CV_FONT_ITALIC = 16;
  public static final int CV_FONT_VECTOR0 = 0;
  public static final int CV_FRONT = 1;
  public static final int CV_GEMM_A_T = 1;
  public static final int CV_GEMM_B_T = 2;
  public static final int CV_GEMM_C_T = 4;
  public static final int CV_GRAPH = 4096;
  public static final int CV_GRAPH_ALL_ITEMS = -1;
  public static final int CV_GRAPH_ANY_EDGE = 30;
  public static final int CV_GRAPH_BACKTRACKING = 64;
  public static final int CV_GRAPH_BACK_EDGE = 4;
  public static final int CV_GRAPH_CROSS_EDGE = 16;
  public static final int CV_GRAPH_FLAG_ORIENTED = 16384;
  public static final int CV_GRAPH_FORWARD_EDGE = 8;
  public static final int CV_GRAPH_FORWARD_EDGE_FLAG = 268435456;
  public static final int CV_GRAPH_ITEM_VISITED_FLAG = 1073741824;
  public static final int CV_GRAPH_NEW_TREE = 32;
  public static final int CV_GRAPH_OVER = -1;
  public static final int CV_GRAPH_SEARCH_TREE_NODE_FLAG = 536870912;
  public static final int CV_GRAPH_TREE_EDGE = 2;
  public static final int CV_GRAPH_VERTEX = 1;
  public static final int CV_GpuApiCallError = -217;
  public static final int CV_GpuNotSupported = -216;
  public static final int CV_HARDWARE_MAX_FEATURE = 255;
  public static final int CV_HeaderIsNull = -9;
  public static final int CV_KMEANS_USE_INITIAL_LABELS = 1;
  public static final int CV_L1 = 2;
  public static final int CV_L2 = 4;
  public static final int CV_LSQ = 8;
  public static final int CV_LU = 0;
  public static final int CV_MAGIC_MASK = -65536;
  public static final int CV_MAJOR_VERSION = 2;
  public static final int CV_MATND_MAGIC_VAL = 1111687168;
  public static final int CV_MAT_CN_MASK = 4088;
  public static final int CV_MAT_CONT_FLAG = 16384;
  public static final int CV_MAT_CONT_FLAG_SHIFT = 14;
  public static final int CV_MAT_DEPTH_MASK = 7;
  public static final int CV_MAT_MAGIC_VAL = 1111621632;
  public static final int CV_MAT_TEMP_FLAG = 32768;
  public static final int CV_MAT_TEMP_FLAG_SHIFT = 15;
  public static final int CV_MAT_TYPE_MASK = 4095;
  public static final int CV_MAX_ARR = 10;
  public static final int CV_MAX_DIM = 32;
  public static final int CV_MAX_DIM_HEAP = 1024;
  public static final int CV_MINMAX = 32;
  public static final int CV_MINOR_VERSION = 4;
  public static final int CV_MaskIsTiled = -26;
  public static final int CV_NODE_EMPTY = 32;
  public static final int CV_NODE_FLOAT = 2;
  public static final int CV_NODE_FLOW = 8;
  public static final int CV_NODE_INT = 1;
  public static final int CV_NODE_INTEGER = 1;
  public static final int CV_NODE_MAP = 6;
  public static final int CV_NODE_NAMED = 64;
  public static final int CV_NODE_NONE = 0;
  public static final int CV_NODE_REAL = 2;
  public static final int CV_NODE_REF = 4;
  public static final int CV_NODE_SEQ = 5;
  public static final int CV_NODE_SEQ_SIMPLE = 256;
  public static final int CV_NODE_STR = 3;
  public static final int CV_NODE_STRING = 3;
  public static final int CV_NODE_TYPE_MASK = 7;
  public static final int CV_NODE_USER = 16;
  public static final int CV_NORMAL = 16;
  public static final int CV_NORM_MASK = 7;
  public static final int CV_NO_CN_CHECK = 2;
  public static final int CV_NO_DEPTH_CHECK = 1;
  public static final int CV_NO_SIZE_CHECK = 4;
  public static final int CV_ORIENTED_GRAPH = 20480;
  public static final int CV_OpenGlApiCallError = -219;
  public static final int CV_OpenGlNotSupported = -218;
  public static final int CV_PCA_DATA_AS_COL = 1;
  public static final int CV_PCA_DATA_AS_ROW = 0;
  public static final int CV_PCA_USE_AVG = 2;
  public static final int CV_QR = 4;
  public static final int CV_RAND_NORMAL = 1;
  public static final int CV_RAND_UNI = 0;
  public static final int CV_REDUCE_AVG = 1;
  public static final int CV_REDUCE_MAX = 2;
  public static final int CV_REDUCE_MIN = 3;
  public static final int CV_REDUCE_SUM = 0;
  public static final int CV_RELATIVE = 8;
  public static final int CV_RELATIVE_C = 9;
  public static final int CV_RELATIVE_L1 = 10;
  public static final int CV_RELATIVE_L2 = 12;
  public static final long CV_RNG_COEFF = 4164903690L;
  public static final int CV_SEQ_CHAIN = 0;
  public static final int CV_SEQ_CHAIN_CONTOUR = 0;
  public static final int CV_SEQ_CONNECTED_COMP = 0;
  public static final int CV_SEQ_CONTOUR = 0;
  public static final int CV_SEQ_ELTYPE_BITS = 12;
  public static final int CV_SEQ_ELTYPE_CODE = 0;
  public static final int CV_SEQ_ELTYPE_CONNECTED_COMP = 0;
  public static final int CV_SEQ_ELTYPE_GENERIC = 0;
  public static final int CV_SEQ_ELTYPE_GRAPH_EDGE = 0;
  public static final int CV_SEQ_ELTYPE_GRAPH_VERTEX = 0;
  public static final int CV_SEQ_ELTYPE_INDEX = 0;
  public static final int CV_SEQ_ELTYPE_MASK = 4095;
  public static final int CV_SEQ_ELTYPE_POINT = 0;
  public static final int CV_SEQ_ELTYPE_POINT3D = 0;
  public static final int CV_SEQ_ELTYPE_PPOINT = 7;
  public static final int CV_SEQ_ELTYPE_PTR = 7;
  public static final int CV_SEQ_ELTYPE_TRIAN_ATR = 0;
  public static final int CV_SEQ_FLAG_CLOSED = 16384;
  public static final int CV_SEQ_FLAG_CONVEX = 0;
  public static final int CV_SEQ_FLAG_HOLE = 32768;
  public static final int CV_SEQ_FLAG_SHIFT = 14;
  public static final int CV_SEQ_FLAG_SIMPLE = 0;
  public static final int CV_SEQ_INDEX = 0;
  public static final int CV_SEQ_KIND_BIN_TREE = 8192;
  public static final int CV_SEQ_KIND_BITS = 2;
  public static final int CV_SEQ_KIND_CURVE = 4096;
  public static final int CV_SEQ_KIND_GENERIC = 0;
  public static final int CV_SEQ_KIND_GRAPH = 4096;
  public static final int CV_SEQ_KIND_MASK = 12288;
  public static final int CV_SEQ_KIND_SUBDIV2D = 8192;
  public static final int CV_SEQ_MAGIC_VAL = 1117323264;
  public static final int CV_SEQ_POINT3D_SET = 0;
  public static final int CV_SEQ_POINT_SET = 0;
  public static final int CV_SEQ_POLYGON = 0;
  public static final int CV_SEQ_POLYGON_TREE = 8192;
  public static final int CV_SEQ_POLYLINE = 0;
  public static final int CV_SEQ_SIMPLE_POLYGON = 0;
  public static final int CV_SET_ELEM_FREE_FLAG = 128;
  public static final int CV_SET_ELEM_IDX_MASK = 67108863;
  public static final int CV_SET_MAGIC_VAL = 1117257728;
  public static final int CV_SORT_ASCENDING = 0;
  public static final int CV_SORT_DESCENDING = 16;
  public static final int CV_SORT_EVERY_COLUMN = 1;
  public static final int CV_SORT_EVERY_ROW = 0;
  public static final int CV_SPARSE_MAT_MAGIC_VAL = 1111752704;
  public static final int CV_STORAGE_APPEND = 2;
  public static final int CV_STORAGE_FORMAT_AUTO = 0;
  public static final int CV_STORAGE_FORMAT_MASK = 56;
  public static final int CV_STORAGE_FORMAT_XML = 8;
  public static final int CV_STORAGE_FORMAT_YAML = 16;
  public static final int CV_STORAGE_MAGIC_VAL = 1116274688;
  public static final int CV_STORAGE_MEMORY = 4;
  public static final int CV_STORAGE_READ = 0;
  public static final int CV_STORAGE_WRITE = 1;
  public static final int CV_STORAGE_WRITE_BINARY = 1;
  public static final int CV_STORAGE_WRITE_TEXT = 1;
  public static final int CV_SUBMINOR_VERSION = 5;
  public static final int CV_SVD = 1;
  public static final int CV_SVD_MODIFY_A = 1;
  public static final int CV_SVD_SYM = 2;
  public static final int CV_SVD_U_T = 2;
  public static final int CV_SVD_V_T = 4;
  public static final int CV_StsAssert = -215;
  public static final int CV_StsAutoTrace = -8;
  public static final int CV_StsBackTrace = -1;
  public static final int CV_StsBadArg = -5;
  public static final int CV_StsBadFlag = -206;
  public static final int CV_StsBadFunc = -6;
  public static final int CV_StsBadMask = -208;
  public static final int CV_StsBadMemBlock = -214;
  public static final int CV_StsBadPoint = -207;
  public static final int CV_StsBadSize = -201;
  public static final int CV_StsDivByZero = -202;
  public static final int CV_StsError = -2;
  public static final int CV_StsFilterOffsetErr = -31;
  public static final int CV_StsFilterStructContentErr = -29;
  public static final int CV_StsInplaceNotSupported = -203;
  public static final int CV_StsInternal = -3;
  public static final int CV_StsKernelStructContentErr = -30;
  public static final int CV_StsNoConv = -7;
  public static final int CV_StsNoMem = -4;
  public static final int CV_StsNotImplemented = -213;
  public static final int CV_StsNullPtr = -27;
  public static final int CV_StsObjectNotFound = -204;
  public static final int CV_StsOk = 0;
  public static final int CV_StsOutOfRange = -211;
  public static final int CV_StsParseError = -212;
  public static final int CV_StsUnmatchedFormats = -205;
  public static final int CV_StsUnmatchedSizes = -209;
  public static final int CV_StsUnsupportedFormat = -210;
  public static final int CV_StsVecLengthErr = -28;
  public static final int CV_TERMCRIT_EPS = 2;
  public static final int CV_TERMCRIT_ITER = 1;
  public static final int CV_TERMCRIT_NUMBER = 1;
  public static final String CV_TYPE_NAME_GRAPH = "opencv-graph";
  public static final String CV_TYPE_NAME_IMAGE = "opencv-image";
  public static final String CV_TYPE_NAME_MAT = "opencv-matrix";
  public static final String CV_TYPE_NAME_MATND = "opencv-nd-matrix";
  public static final String CV_TYPE_NAME_SEQ = "opencv-sequence";
  public static final String CV_TYPE_NAME_SEQ_TREE = "opencv-sequence-tree";
  public static final String CV_TYPE_NAME_SPARSE_MAT = "opencv-sparse-matrix";
  public static final int CV_USRTYPE1 = 7;
  public static final String CV_VERSION = "2.4.5.0";
  public static final int CV_VERSION_EPOCH = 2;
  public static final int CV_VERSION_MAJOR = 4;
  public static final int CV_VERSION_MINOR = 5;
  public static final int CV_VERSION_REVISION = 0;
  public static final CvSlice CV_WHOLE_ARR;
  public static final CvSlice CV_WHOLE_SEQ;
  public static final int CV_WHOLE_SEQ_END_INDEX = 1073741823;
  public static final int IPL_ALIGN_16BYTES = 16;
  public static final int IPL_ALIGN_32BYTES = 32;
  public static final int IPL_ALIGN_4BYTES = 4;
  public static final int IPL_ALIGN_8BYTES = 8;
  public static final int IPL_ALIGN_DWORD = 4;
  public static final int IPL_ALIGN_QWORD = 8;
  public static final int IPL_BORDER_CONSTANT = 0;
  public static final int IPL_BORDER_REFLECT = 2;
  public static final int IPL_BORDER_REFLECT_101 = 4;
  public static final int IPL_BORDER_REPLICATE = 1;
  public static final int IPL_BORDER_TRANSPARENT = 5;
  public static final int IPL_BORDER_WRAP = 3;
  public static final int IPL_DATA_ORDER_PIXEL = 0;
  public static final int IPL_DATA_ORDER_PLANE = 1;
  public static final int IPL_DEPTH_16S = -2147483632;
  public static final int IPL_DEPTH_16U = 16;
  public static final int IPL_DEPTH_1U = 1;
  public static final int IPL_DEPTH_32F = 32;
  public static final int IPL_DEPTH_32S = -2147483616;
  public static final int IPL_DEPTH_64F = 64;
  public static final int IPL_DEPTH_8S = -2147483640;
  public static final int IPL_DEPTH_8U = 8;
  public static final int IPL_DEPTH_SIGN = Integer.MIN_VALUE;
  public static final int IPL_IMAGE_DATA = 2;
  public static final int IPL_IMAGE_HEADER = 1;
  public static final int IPL_IMAGE_MAGIC_VAL = 0;
  public static final int IPL_IMAGE_ROI = 4;
  public static final int IPL_ORIGIN_BL = 1;
  public static final int IPL_ORIGIN_TL = 0;
  public static final int NORM_HAMMING = 6;
  public static final int NORM_HAMMING2 = 7;
  public static final int NORM_INF = 1;
  public static final int NORM_L1 = 2;
  public static final int NORM_L2 = 4;
  public static final int NORM_L2SQR = 5;
  public static final int NORM_MINMAX = 32;
  public static final int NORM_RELATIVE = 8;
  public static final int NORM_TYPE_MASK = 7;
  public static final String androidIncludepath = "../include/";
  public static final String androidLinkpath = "../lib/";
  public static final String genericIncludepath = "/usr/local/include:/opt/local/include/";
  public static final String genericLinkpath = "/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/";
  public static final String windowsIncludepath = "C:/opencv/build/include/";
  public static final String windowsx64Linkpath = "C:/opencv/build/x64/vc10/lib/";
  public static final String windowsx64Preloadpath = "C:/opencv/build/x64/vc10/bin/";
  public static final String windowsx86Linkpath = "C:/opencv/build/x86/vc10/lib/";
  public static final String windowsx86Preloadpath = "C:/opencv/build/x86/vc10/bin/";
  
  static
  {
    boolean bool;
    String str;
    label42:
    int i;
    label50:
    CvSlice localCvSlice1;
    if (!opencv_core.class.desiredAssertionStatus())
    {
      bool = true;
      $assertionsDisabled = bool;
      if (Loader.load() != null)
      {
        str = Loader.getPlatformName();
        if (!str.equals("windows-x86")) {
          break label414;
        }
        SetLibraryPath("C:/opencv/build/x86/vc10/bin/");
      }
      if (Loader.load() != null) {
        break label434;
      }
      i = 0;
      IPL_IMAGE_MAGIC_VAL = i;
      CV_8UC1 = CV_MAKETYPE(0, 1);
      CV_8UC2 = CV_MAKETYPE(0, 2);
      CV_8UC3 = CV_MAKETYPE(0, 3);
      CV_8UC4 = CV_MAKETYPE(0, 4);
      CV_8SC1 = CV_MAKETYPE(1, 1);
      CV_8SC2 = CV_MAKETYPE(1, 2);
      CV_8SC3 = CV_MAKETYPE(1, 3);
      CV_8SC4 = CV_MAKETYPE(1, 4);
      CV_16UC1 = CV_MAKETYPE(2, 1);
      CV_16UC2 = CV_MAKETYPE(2, 2);
      CV_16UC3 = CV_MAKETYPE(2, 3);
      CV_16UC4 = CV_MAKETYPE(2, 4);
      CV_16SC1 = CV_MAKETYPE(3, 1);
      CV_16SC2 = CV_MAKETYPE(3, 2);
      CV_16SC3 = CV_MAKETYPE(3, 3);
      CV_16SC4 = CV_MAKETYPE(3, 4);
      CV_32SC1 = CV_MAKETYPE(4, 1);
      CV_32SC2 = CV_MAKETYPE(4, 2);
      CV_32SC3 = CV_MAKETYPE(4, 3);
      CV_32SC4 = CV_MAKETYPE(4, 4);
      CV_32FC1 = CV_MAKETYPE(5, 1);
      CV_32FC2 = CV_MAKETYPE(5, 2);
      CV_32FC3 = CV_MAKETYPE(5, 3);
      CV_32FC4 = CV_MAKETYPE(5, 4);
      CV_64FC1 = CV_MAKETYPE(6, 1);
      CV_64FC2 = CV_MAKETYPE(6, 2);
      CV_64FC3 = CV_MAKETYPE(6, 3);
      CV_64FC4 = CV_MAKETYPE(6, 4);
      if (Loader.load() != null) {
        break label444;
      }
      localCvSlice1 = null;
      label290:
      CV_WHOLE_ARR = localCvSlice1;
      if (Loader.load() != null) {
        break label455;
      }
    }
    label414:
    label434:
    label444:
    label455:
    for (CvSlice localCvSlice2 = null;; localCvSlice2 = cvSlice(0, 1073741823))
    {
      CV_WHOLE_SEQ = localCvSlice2;
      CV_SEQ_ELTYPE_POINT = CV_32SC2;
      CV_SEQ_ELTYPE_CODE = CV_8UC1;
      CV_SEQ_ELTYPE_INDEX = CV_32SC1;
      CV_SEQ_ELTYPE_POINT3D = CV_32FC3;
      CV_SEQ_POINT_SET = 0x0 | CV_SEQ_ELTYPE_POINT;
      CV_SEQ_POINT3D_SET = 0x0 | CV_SEQ_ELTYPE_POINT3D;
      CV_SEQ_POLYLINE = 0x1000 | CV_SEQ_ELTYPE_POINT;
      CV_SEQ_POLYGON = 0x4000 | CV_SEQ_POLYLINE;
      CV_SEQ_CONTOUR = CV_SEQ_POLYGON;
      CV_SEQ_SIMPLE_POLYGON = 0x0 | CV_SEQ_POLYGON;
      CV_SEQ_CHAIN = 0x1000 | CV_SEQ_ELTYPE_CODE;
      CV_SEQ_CHAIN_CONTOUR = 0x4000 | CV_SEQ_CHAIN;
      CV_SEQ_INDEX = 0x0 | CV_SEQ_ELTYPE_INDEX;
      return;
      bool = false;
      break;
      if (!str.equals("windows-x86_64")) {
        break label42;
      }
      SetLibraryPath("C:/opencv/build/x64/vc10/bin/");
      break label42;
      i = Loader.sizeof(IplImage.class);
      break label50;
      localCvSlice1 = cvSlice(0, 1073741823);
      break label290;
    }
  }
  
  public static int CV_16SC(int paramInt)
  {
    return CV_MAKETYPE(3, paramInt);
  }
  
  public static int CV_16UC(int paramInt)
  {
    return CV_MAKETYPE(0, paramInt);
  }
  
  public static int CV_32FC(int paramInt)
  {
    return CV_MAKETYPE(5, paramInt);
  }
  
  public static int CV_32SC(int paramInt)
  {
    return CV_MAKETYPE(4, paramInt);
  }
  
  public static int CV_64FC(int paramInt)
  {
    return CV_MAKETYPE(6, paramInt);
  }
  
  public static int CV_8SC(int paramInt)
  {
    return CV_MAKETYPE(1, paramInt);
  }
  
  public static int CV_8UC(int paramInt)
  {
    return CV_MAKETYPE(0, paramInt);
  }
  
  public static boolean CV_ARE_CNS_EQ(CvMat paramCvMat1, CvMat paramCvMat2)
  {
    return (0xFF8 & (paramCvMat1.raw_type() ^ paramCvMat2.raw_type())) == 0;
  }
  
  public static boolean CV_ARE_DEPTHS_EQ(CvMat paramCvMat1, CvMat paramCvMat2)
  {
    return (0x7 & (paramCvMat1.raw_type() ^ paramCvMat2.raw_type())) == 0;
  }
  
  public static boolean CV_ARE_SIZES_EQ(CvMat paramCvMat1, CvMat paramCvMat2)
  {
    return (paramCvMat1.rows() == paramCvMat2.rows()) && (paramCvMat1.cols() == paramCvMat2.cols());
  }
  
  public static boolean CV_ARE_TYPES_EQ(CvMat paramCvMat1, CvMat paramCvMat2)
  {
    return (0xFFF & (paramCvMat1.raw_type() ^ paramCvMat2.raw_type())) == 0;
  }
  
  public static CvPoint CV_CURRENT_POINT(CvSeqReader paramCvSeqReader)
  {
    return new CvPoint(paramCvSeqReader.ptr());
  }
  
  public static int CV_ELEM_SIZE(int paramInt)
  {
    return CV_MAT_CN(paramInt) << (0x3 & (0x3A50 | 16384 * (1 + Loader.sizeof(SizeTPointer.class) / 4)) >> 2 * CV_MAT_DEPTH(paramInt));
  }
  
  public static int CV_ELEM_SIZE1(int paramInt)
  {
    return 0xF & (0x8442211 | Loader.sizeof(SizeTPointer.class) << 28) >> 4 * CV_MAT_DEPTH(paramInt);
  }
  
  public static boolean CV_IS_CONT_MAT(int paramInt)
  {
    return CV_IS_MAT_CONT(paramInt);
  }
  
  public static boolean CV_IS_GRAPH(CvSeq paramCvSeq)
  {
    return (CV_IS_SET(paramCvSeq)) && (CV_SEQ_KIND(paramCvSeq) == 4096);
  }
  
  public static boolean CV_IS_GRAPH_EDGE_VISITED(CvGraphVtx paramCvGraphVtx)
  {
    return (0x40000000 & paramCvGraphVtx.flags()) != 0;
  }
  
  public static boolean CV_IS_GRAPH_ORIENTED(CvSeq paramCvSeq)
  {
    return (0x4000 & paramCvSeq.flags()) != 0;
  }
  
  public static boolean CV_IS_GRAPH_VERTEX_VISITED(CvGraphEdge paramCvGraphEdge)
  {
    return (0x40000000 & paramCvGraphEdge.flags()) != 0;
  }
  
  public static boolean CV_IS_IMAGE(CvArr paramCvArr)
  {
    return (CV_IS_IMAGE_HDR(paramCvArr)) && (new IplImage(paramCvArr).imageData() != null);
  }
  
  public static boolean CV_IS_IMAGE_HDR(CvArr paramCvArr)
  {
    return (paramCvArr != null) && (new IplImage(paramCvArr).nSize() == Loader.sizeof(IplImage.class));
  }
  
  public static boolean CV_IS_MASK_ARR(CvMat paramCvMat)
  {
    return (paramCvMat.raw_type() & 0xFFF & (0xFFFFFFFF ^ CV_8SC1)) == 0;
  }
  
  public static boolean CV_IS_MAT(CvArr paramCvArr)
  {
    return (CV_IS_MAT_HDR(paramCvArr)) && (new CvMat(paramCvArr).data_ptr() != null);
  }
  
  public static boolean CV_IS_MATND(CvArr paramCvArr)
  {
    return (CV_IS_MATND_HDR(paramCvArr)) && (new CvMatND(paramCvArr).data_ptr() != null);
  }
  
  public static boolean CV_IS_MATND_HDR(CvArr paramCvArr)
  {
    return (paramCvArr != null) && ((0xFFFF0000 & new CvMatND(paramCvArr).type()) == 1111687168);
  }
  
  public static boolean CV_IS_MAT_CONST(CvMat paramCvMat)
  {
    return (paramCvMat.rows() | paramCvMat.cols()) == 1;
  }
  
  public static boolean CV_IS_MAT_CONT(int paramInt)
  {
    return (paramInt & 0x4000) != 0;
  }
  
  public static boolean CV_IS_MAT_HDR(CvArr paramCvArr)
  {
    CvMat localCvMat = new CvMat(paramCvArr);
    return (paramCvArr != null) && ((0xFFFF0000 & localCvMat.raw_type()) == 1111621632) && (localCvMat.cols() > 0) && (localCvMat.rows() > 0);
  }
  
  public static boolean CV_IS_MAT_HDR_Z(CvArr paramCvArr)
  {
    CvMat localCvMat = new CvMat(paramCvArr);
    return (paramCvArr != null) && ((0xFFFF0000 & localCvMat.raw_type()) == 1111621632) && (localCvMat.cols() >= 0) && (localCvMat.rows() >= 0);
  }
  
  public static boolean CV_IS_SEQ(CvArr paramCvArr)
  {
    return (paramCvArr != null) && ((0xFFFF0000 & new CvSeq(paramCvArr).flags()) == 1117323264);
  }
  
  public static boolean CV_IS_SEQ_CHAIN(CvSeq paramCvSeq)
  {
    return (CV_SEQ_KIND(paramCvSeq) == 4096) && (paramCvSeq.elem_size() == 1);
  }
  
  public static boolean CV_IS_SEQ_CHAIN_CONTOUR(CvSeq paramCvSeq)
  {
    return (CV_IS_SEQ_CHAIN(paramCvSeq)) && (CV_IS_SEQ_CLOSED(paramCvSeq));
  }
  
  public static boolean CV_IS_SEQ_CLOSED(CvSeq paramCvSeq)
  {
    return (0x4000 & paramCvSeq.flags()) != 0;
  }
  
  public static boolean CV_IS_SEQ_CONTOUR(CvSeq paramCvSeq)
  {
    return (CV_IS_SEQ_CLOSED(paramCvSeq)) && ((CV_IS_SEQ_POLYLINE(paramCvSeq)) || (CV_IS_SEQ_CHAIN(paramCvSeq)));
  }
  
  public static boolean CV_IS_SEQ_CONVEX(CvSeq paramCvSeq)
  {
    return false;
  }
  
  public static boolean CV_IS_SEQ_CURVE(CvSeq paramCvSeq)
  {
    return CV_SEQ_KIND(paramCvSeq) == 4096;
  }
  
  public static boolean CV_IS_SEQ_HOLE(CvSeq paramCvSeq)
  {
    return (0x8000 & paramCvSeq.flags()) != 0;
  }
  
  public static boolean CV_IS_SEQ_INDEX(CvSeq paramCvSeq)
  {
    return (CV_SEQ_ELTYPE(paramCvSeq) == CV_SEQ_ELTYPE_INDEX) && (CV_SEQ_KIND(paramCvSeq) == 0);
  }
  
  public static boolean CV_IS_SEQ_POINT_SET(CvSeq paramCvSeq)
  {
    return (CV_SEQ_ELTYPE(paramCvSeq) == CV_32SC2) || (CV_SEQ_ELTYPE(paramCvSeq) == CV_32FC2);
  }
  
  public static boolean CV_IS_SEQ_POINT_SUBSET(CvSeq paramCvSeq)
  {
    return (CV_IS_SEQ_INDEX(paramCvSeq)) || (CV_SEQ_ELTYPE(paramCvSeq) == 7);
  }
  
  public static boolean CV_IS_SEQ_POLYGON(CvSeq paramCvSeq)
  {
    return (CV_IS_SEQ_POLYLINE(paramCvSeq)) && (CV_IS_SEQ_CLOSED(paramCvSeq));
  }
  
  public static boolean CV_IS_SEQ_POLYGON_TREE(CvSeq paramCvSeq)
  {
    return (CV_SEQ_ELTYPE(paramCvSeq) == 0) && (CV_SEQ_KIND(paramCvSeq) == 8192);
  }
  
  public static boolean CV_IS_SEQ_POLYLINE(CvSeq paramCvSeq)
  {
    return (CV_SEQ_KIND(paramCvSeq) == 4096) && (CV_IS_SEQ_POINT_SET(paramCvSeq));
  }
  
  public static boolean CV_IS_SEQ_SIMPLE(CvSeq paramCvSeq)
  {
    return true;
  }
  
  public static boolean CV_IS_SET(CvArr paramCvArr)
  {
    return (paramCvArr != null) && ((0xFFFF0000 & new CvSet(paramCvArr).flags()) == 1117257728);
  }
  
  public static boolean CV_IS_SET_ELEM(Pointer paramPointer)
  {
    return new CvSetElem(paramPointer).flags() >= 0;
  }
  
  public static boolean CV_IS_SPARSE_MAT(CvArr paramCvArr)
  {
    return CV_IS_SPARSE_MAT_HDR(paramCvArr);
  }
  
  public static boolean CV_IS_SPARSE_MAT_HDR(CvArr paramCvArr)
  {
    return (paramCvArr != null) && ((0xFFFF0000 & new CvSparseMat(paramCvArr).type()) == 1111752704);
  }
  
  public static boolean CV_IS_STORAGE(CvArr paramCvArr)
  {
    return (paramCvArr != null) && ((0xFFFF0000 & new CvMemStorage(paramCvArr).signature()) == 1116274688);
  }
  
  public static boolean CV_IS_SUBDIV2D(CvSeq paramCvSeq)
  {
    return (CV_IS_SET(paramCvSeq)) && (CV_SEQ_KIND(paramCvSeq) == 8192);
  }
  
  public static boolean CV_IS_TEMP_MAT(int paramInt)
  {
    return (0x8000 & paramInt) != 0;
  }
  
  public static int CV_MAKETYPE(int paramInt1, int paramInt2)
  {
    return CV_MAT_DEPTH(paramInt1) + (paramInt2 - 1 << 3);
  }
  
  public static int CV_MAKE_TYPE(int paramInt1, int paramInt2)
  {
    return CV_MAKETYPE(paramInt1, paramInt2);
  }
  
  public static int CV_MAT_CN(int paramInt)
  {
    return 1 + ((paramInt & 0xFF8) >> 3);
  }
  
  public static int CV_MAT_DEPTH(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int CV_MAT_TYPE(int paramInt)
  {
    return paramInt & 0xFFF;
  }
  
  public static CvGraphEdge CV_NEXT_GRAPH_EDGE(CvGraphEdge paramCvGraphEdge, CvGraphVtx paramCvGraphVtx)
  {
    int i = 1;
    assert ((paramCvGraphEdge.vtx(0).equals(paramCvGraphVtx)) || (paramCvGraphEdge.vtx(i).equals(paramCvGraphVtx)));
    if (paramCvGraphEdge.vtx(i).equals(paramCvGraphVtx)) {}
    for (;;)
    {
      return paramCvGraphEdge.next(i);
      i = 0;
    }
  }
  
  public static native void CV_NEXT_LINE_POINT(@ByVal CvLineIterator paramCvLineIterator);
  
  public static native void CV_NEXT_SEQ_ELEM(int paramInt, @ByVal CvSeqReader paramCvSeqReader);
  
  public static boolean CV_NODE_HAS_NAME(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  public static IntPointer CV_NODE_IDX(CvSparseMat paramCvSparseMat, CvSparseNode paramCvSparseNode)
  {
    return new IntPointer(new BytePointer(paramCvSparseNode).position(paramCvSparseMat.idxoffset()));
  }
  
  public static boolean CV_NODE_IS_COLLECTION(int paramInt)
  {
    return CV_NODE_TYPE(paramInt) >= 5;
  }
  
  public static boolean CV_NODE_IS_EMPTY(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  public static boolean CV_NODE_IS_FLOW(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean CV_NODE_IS_INT(int paramInt)
  {
    return CV_NODE_TYPE(paramInt) == 1;
  }
  
  public static boolean CV_NODE_IS_MAP(int paramInt)
  {
    return CV_NODE_TYPE(paramInt) == 6;
  }
  
  public static boolean CV_NODE_IS_REAL(int paramInt)
  {
    return CV_NODE_TYPE(paramInt) == 2;
  }
  
  public static boolean CV_NODE_IS_SEQ(int paramInt)
  {
    return CV_NODE_TYPE(paramInt) == 5;
  }
  
  public static boolean CV_NODE_IS_STRING(int paramInt)
  {
    return CV_NODE_TYPE(paramInt) == 3;
  }
  
  public static boolean CV_NODE_IS_USER(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  public static boolean CV_NODE_SEQ_IS_SIMPLE(CvSeq paramCvSeq)
  {
    return (0x100 & paramCvSeq.flags()) != 0;
  }
  
  public static int CV_NODE_TYPE(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static Pointer CV_NODE_VAL(CvSparseMat paramCvSparseMat, CvSparseNode paramCvSparseNode)
  {
    return new BytePointer(paramCvSparseNode).position(paramCvSparseMat.valoffset());
  }
  
  public static CvPoint CV_PREV_POINT(CvSeqReader paramCvSeqReader)
  {
    return new CvPoint(paramCvSeqReader.prev_elem());
  }
  
  public static native void CV_PREV_SEQ_ELEM(int paramInt, @ByVal CvSeqReader paramCvSeqReader);
  
  public static void CV_READ_EDGE(CvPoint paramCvPoint1, CvPoint paramCvPoint2, CvSeqReader paramCvSeqReader)
  {
    assert (paramCvSeqReader.seq().elem_size() == Loader.sizeof(CvPoint.class));
    CV_PREV_POINT(paramCvSeqReader);
    CV_CURRENT_POINT(paramCvSeqReader);
    paramCvSeqReader.prev_elem(paramCvSeqReader.ptr());
    CV_NEXT_SEQ_ELEM(Loader.sizeof(CvPoint.class), paramCvSeqReader);
  }
  
  public static native void CV_READ_SEQ_ELEM(@ByVal CvPoint paramCvPoint, @ByVal CvSeqReader paramCvSeqReader);
  
  public static native void CV_REV_READ_SEQ_ELEM(@ByVal CvPoint paramCvPoint, @ByVal CvSeqReader paramCvSeqReader);
  
  public static CvScalar CV_RGB(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return cvScalar(paramDouble3, paramDouble2, paramDouble1, 0.0D);
  }
  
  public static int CV_SEQ_ELTYPE(CvSeq paramCvSeq)
  {
    return 0xFFF & paramCvSeq.flags();
  }
  
  public static int CV_SEQ_KIND(CvSeq paramCvSeq)
  {
    return 0x3000 & paramCvSeq.flags();
  }
  
  public static native void CV_WRITE_SEQ_ELEM(@ByVal CvPoint paramCvPoint, @ByVal CvSeqWriter paramCvSeqWriter);
  
  public static native void CV_WRITE_SEQ_ELEM_VAR(Pointer paramPointer, @ByVal CvSeqWriter paramCvSeqWriter);
  
  public static int IPL2CV_DEPTH(int paramInt)
  {
    int i = (paramInt & 0xF0) >> 2;
    if ((0x80000000 & paramInt) != 0) {}
    for (int j = 20;; j = 0) {
      return 0xF & 1125516576 >> j + i;
    }
  }
  
  public static native void SetLibraryPath(String paramString);
  
  @Namespace("cv")
  public static native void batchDistance(@InputArray CvArr paramCvArr1, @InputArray CvArr paramCvArr2, @OutputArray CvMat paramCvMat1, int paramInt1, @OutputArray CvMat paramCvMat2, int paramInt2, int paramInt3, @InputArray CvArr paramCvArr3, int paramInt4, @Cast({"bool"}) boolean paramBoolean);
  
  public static void cvAXPY(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2, CvArr paramCvArr3)
  {
    cvScaleAdd(paramCvArr1, cvRealScalar(paramDouble), paramCvArr2, paramCvArr3);
  }
  
  public static void cvAbs(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    cvAbsDiffS(paramCvArr1, paramCvArr2, cvScalarAll(0.0D));
  }
  
  public static native void cvAbsDiff(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native void cvAbsDiffS(CvArr paramCvArr1, CvArr paramCvArr2, @ByVal CvScalar paramCvScalar);
  
  public static native void cvAdd(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvAddS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native void cvAddWeighted(CvArr paramCvArr1, double paramDouble1, CvArr paramCvArr2, double paramDouble2, double paramDouble3, CvArr paramCvArr3);
  
  public static native Pointer cvAlloc(@Cast({"size_t"}) long paramLong);
  
  public static native void cvAnd(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvAndS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static CvAttrList cvAttrList()
  {
    return new CvAttrList();
  }
  
  public static CvAttrList cvAttrList(PointerPointer paramPointerPointer, CvAttrList paramCvAttrList)
  {
    return new CvAttrList().attr(paramPointerPointer).next(paramCvAttrList);
  }
  
  public static native String cvAttrValue(CvAttrList paramCvAttrList, String paramString);
  
  @ByVal
  public static native CvScalar cvAvg(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static native void cvAvgSdv(CvArr paramCvArr1, CvScalar paramCvScalar1, CvScalar paramCvScalar2, CvArr paramCvArr2);
  
  public static native void cvBackProjectPCA(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvCalcCovarMatrix(@Const CvArrArray paramCvArrArray, int paramInt1, CvArr paramCvArr1, CvArr paramCvArr2, int paramInt2);
  
  public static void cvCalcCovarMatrix(CvArr[] paramArrayOfCvArr, int paramInt1, CvArr paramCvArr1, CvArr paramCvArr2, int paramInt2)
  {
    cvCalcCovarMatrix(new CvArrArray(paramArrayOfCvArr), paramInt1, paramCvArr1, paramCvArr2, paramInt2);
  }
  
  public static native void cvCalcPCA(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
  
  public static native void cvCartToPolar(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
  
  public static native float cvCbrt(float paramFloat);
  
  public static native void cvChangeSeqBlock(CvSeqReader paramCvSeqReader, int paramInt);
  
  public static native int cvCheckArr(CvArr paramCvArr, int paramInt, double paramDouble1, double paramDouble2);
  
  public static int cvCheckArray(CvArr paramCvArr, int paramInt, double paramDouble1, double paramDouble2)
  {
    return cvCheckArr(paramCvArr, paramInt, paramDouble1, paramDouble2);
  }
  
  public static native int cvCheckHardwareSupport(int paramInt);
  
  @ByVal
  public static native CvTermCriteria cvCheckTermCriteria(@ByVal CvTermCriteria paramCvTermCriteria, double paramDouble, int paramInt);
  
  public static native void cvCircle(CvArr paramCvArr, @ByVal CvPoint paramCvPoint, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void cvClearGraph(CvGraph paramCvGraph);
  
  public static native void cvClearMemStorage(CvMemStorage paramCvMemStorage);
  
  public static native void cvClearND(CvArr paramCvArr, int[] paramArrayOfInt);
  
  public static native void cvClearSeq(CvSeq paramCvSeq);
  
  public static native void cvClearSet(CvSet paramCvSet);
  
  public static native int cvClipLine(@ByVal CvSize paramCvSize, CvPoint paramCvPoint1, CvPoint paramCvPoint2);
  
  public static native Pointer cvClone(Pointer paramPointer);
  
  public static native CvGraph cvCloneGraph(CvGraph paramCvGraph, CvMemStorage paramCvMemStorage);
  
  public static native IplImage cvCloneImage(IplImage paramIplImage);
  
  public static native CvMat cvCloneMat(CvMat paramCvMat);
  
  public static native CvMatND cvCloneMatND(CvMatND paramCvMatND);
  
  public static CvSeq cvCloneSeq(CvSeq paramCvSeq, CvMemStorage paramCvMemStorage)
  {
    return cvSeqSlice(paramCvSeq, CV_WHOLE_SEQ, paramCvMemStorage, 1);
  }
  
  public static native CvSparseMat cvCloneSparseMat(CvSparseMat paramCvSparseMat);
  
  public static native void cvCmp(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
  
  public static native void cvCmpS(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2, int paramInt);
  
  @ByVal
  public static native CvScalar cvColorToScalar(double paramDouble, int paramInt);
  
  public static native void cvCompleteSymm(CvMat paramCvMat, int paramInt);
  
  public static void cvConvert(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    cvConvertScale(paramCvArr1, paramCvArr2, 1.0D, 0.0D);
  }
  
  public static native void cvConvertScale(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2);
  
  public static native void cvConvertScaleAbs(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2);
  
  public static void cvCopy(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    cvCopy(paramCvArr1, paramCvArr2, null);
  }
  
  public static native void cvCopy(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native int cvCountNonZero(CvArr paramCvArr);
  
  public static native CvMemStorage cvCreateChildMemStorage(CvMemStorage paramCvMemStorage);
  
  public static native void cvCreateData(CvArr paramCvArr);
  
  public static native CvGraph cvCreateGraph(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CvMemStorage paramCvMemStorage);
  
  public static native CvGraphScanner cvCreateGraphScanner(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx, int paramInt);
  
  public static native IplImage cvCreateImage(@ByVal CvSize paramCvSize, int paramInt1, int paramInt2);
  
  public static native IplImage cvCreateImageHeader(@ByVal CvSize paramCvSize, int paramInt1, int paramInt2);
  
  public static native CvMat cvCreateMat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native CvMat cvCreateMatHeader(int paramInt1, int paramInt2, int paramInt3);
  
  public static native CvMatND cvCreateMatND(int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public static native CvMatND cvCreateMatNDHeader(int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public static native CvMemStorage cvCreateMemStorage(int paramInt);
  
  public static native CvSeq cvCreateSeq(int paramInt1, @Cast({"size_t"}) long paramLong, int paramInt2, CvMemStorage paramCvMemStorage);
  
  public static native void cvCreateSeqBlock(CvSeqWriter paramCvSeqWriter);
  
  public static native CvSet cvCreateSet(int paramInt1, int paramInt2, int paramInt3, CvMemStorage paramCvMemStorage);
  
  public static native CvSparseMat cvCreateSparseMat(int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public static native void cvCrossProduct(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static void cvCvtScale(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2)
  {
    cvConvertScale(paramCvArr1, paramCvArr2, paramDouble1, paramDouble2);
  }
  
  public static void cvCvtScaleAbs(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2)
  {
    cvConvertScaleAbs(paramCvArr1, paramCvArr2, paramDouble1, paramDouble2);
  }
  
  public static Pointer cvCvtSeqToArray(CvSeq paramCvSeq, Pointer paramPointer)
  {
    return cvCvtSeqToArray(paramCvSeq, paramPointer, CV_WHOLE_SEQ);
  }
  
  public static native Pointer cvCvtSeqToArray(CvSeq paramCvSeq, Pointer paramPointer, @ByVal CvSlice paramCvSlice);
  
  public static Pointer cvCvtSeqToArray(CvSeq paramCvSeq, Buffer paramBuffer)
  {
    return cvCvtSeqToArray(paramCvSeq, paramBuffer, CV_WHOLE_SEQ);
  }
  
  public static native Pointer cvCvtSeqToArray(CvSeq paramCvSeq, Buffer paramBuffer, @ByVal CvSlice paramCvSlice);
  
  public static native void cvDCT(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt);
  
  public static native void cvDFT(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt1, int paramInt2);
  
  public static native double cvDet(CvArr paramCvArr);
  
  public static native void cvDiv(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, double paramDouble);
  
  public static native double cvDotProduct(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static void cvDrawCircle(CvArr paramCvArr, CvPoint paramCvPoint, int paramInt1, CvScalar paramCvScalar, int paramInt2, int paramInt3, int paramInt4)
  {
    cvCircle(paramCvArr, paramCvPoint, paramInt1, paramCvScalar, paramInt2, paramInt3, paramInt4);
  }
  
  public static void cvDrawContours(CvArr paramCvArr, CvSeq paramCvSeq, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2, int paramInt1, int paramInt2, int paramInt3)
  {
    cvDrawContours(paramCvArr, paramCvSeq, paramCvScalar1, paramCvScalar2, paramInt1, paramInt2, paramInt3, CvPoint.ZERO);
  }
  
  public static native void cvDrawContours(CvArr paramCvArr, CvSeq paramCvSeq, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2, int paramInt1, int paramInt2, int paramInt3, @ByVal CvPoint paramCvPoint);
  
  public static void cvDrawEllipse(CvArr paramCvArr, CvPoint paramCvPoint, CvSize paramCvSize, double paramDouble1, double paramDouble2, double paramDouble3, CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3)
  {
    cvEllipse(paramCvArr, paramCvPoint, paramCvSize, paramDouble1, paramDouble2, paramDouble3, paramCvScalar, paramInt1, paramInt2, paramInt3);
  }
  
  public static void cvDrawLine(CvArr paramCvArr, CvPoint paramCvPoint1, CvPoint paramCvPoint2, CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3)
  {
    cvLine(paramCvArr, paramCvPoint1, paramCvPoint2, paramCvScalar, paramInt1, paramInt2, paramInt3);
  }
  
  public static void cvDrawPolyLine(CvArr paramCvArr, @Cast({"CvPoint**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5)
  {
    cvPolyLine(paramCvArr, paramPointerPointer, paramArrayOfInt, paramInt1, paramInt2, paramCvScalar, paramInt3, paramInt4, paramInt5);
  }
  
  public static void cvDrawPolyLine(CvArr paramCvArr, @ByPtrPtr CvPoint paramCvPoint, int[] paramArrayOfInt, int paramInt1, int paramInt2, CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5)
  {
    cvPolyLine(paramCvArr, paramCvPoint, paramArrayOfInt, paramInt1, paramInt2, paramCvScalar, paramInt3, paramInt4, paramInt5);
  }
  
  public static void cvDrawPolyLine(CvArr paramCvArr, CvPoint[] paramArrayOfCvPoint, int[] paramArrayOfInt, int paramInt1, int paramInt2, CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5)
  {
    cvPolyLine(paramCvArr, paramArrayOfCvPoint, paramArrayOfInt, paramInt1, paramInt2, paramCvScalar, paramInt3, paramInt4, paramInt5);
  }
  
  public static void cvDrawRect(CvArr paramCvArr, CvPoint paramCvPoint1, CvPoint paramCvPoint2, CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3)
  {
    cvRectangle(paramCvArr, paramCvPoint1, paramCvPoint2, paramCvScalar, paramInt1, paramInt2, paramInt3);
  }
  
  public static native void cvEigenVV(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, double paramDouble, int paramInt1, int paramInt2);
  
  public static native void cvEllipse(CvArr paramCvArr, @ByVal CvPoint paramCvPoint, @ByVal CvSize paramCvSize, double paramDouble1, double paramDouble2, double paramDouble3, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int cvEllipse2Poly(@ByVal CvPoint paramCvPoint1, @ByVal CvSize paramCvSize, int paramInt1, int paramInt2, int paramInt3, CvPoint paramCvPoint2, int paramInt4);
  
  public static void cvEllipseBox(CvArr paramCvArr, @ByVal CvBox2D paramCvBox2D, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3)
  {
    CvSize2D32f localCvSize2D32f = paramCvBox2D.size();
    CvSize localCvSize = cvSize((int)Math.round(0.5D * localCvSize2D32f.width()), (int)Math.round(0.5D * localCvSize2D32f.height()));
    cvEllipse(paramCvArr, cvPointFrom32f(paramCvBox2D.center()), localCvSize, paramCvBox2D.angle(), 0.0D, 360.0D, paramCvScalar, paramInt1, paramInt2, paramInt3);
  }
  
  public static native CvSeq cvEndWriteSeq(CvSeqWriter paramCvSeqWriter);
  
  public static native void cvEndWriteStruct(CvFileStorage paramCvFileStorage);
  
  public static native void cvError(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);
  
  public static native int cvErrorFromIppStatus(int paramInt);
  
  public static native String cvErrorStr(int paramInt);
  
  public static native void cvExp(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static void cvFFT(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt1, int paramInt2)
  {
    cvDFT(paramCvArr1, paramCvArr2, paramInt1, paramInt2);
  }
  
  public static native float cvFastArctan(float paramFloat1, float paramFloat2);
  
  public static native void cvFillConvexPoly(CvArr paramCvArr, CvPoint paramCvPoint, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
  
  public static native void cvFillConvexPoly(CvArr paramCvArr, @Cast({"CvPoint*"}) int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
  
  public static native void cvFillPoly(CvArr paramCvArr, @Cast({"CvPoint**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
  
  public static native void cvFillPoly(CvArr paramCvArr, @ByPtrPtr CvPoint paramCvPoint, int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
  
  public static void cvFillPoly(CvArr paramCvArr, CvPoint[] paramArrayOfCvPoint, int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3)
  {
    cvFillPoly(paramCvArr, new PointerPointer(paramArrayOfCvPoint), paramArrayOfInt, paramInt1, paramCvScalar, paramInt2, paramInt3);
  }
  
  public static native CvGraphEdge cvFindGraphEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2);
  
  public static native CvGraphEdge cvFindGraphEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2);
  
  public static native CvTypeInfo cvFindType(String paramString);
  
  public static native CvTypeInfo cvFirstType();
  
  public static native void cvFlip(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt);
  
  public static native void cvFlushSeqWriter(CvSeqWriter paramCvSeqWriter);
  
  public static CvFont cvFont(double paramDouble, int paramInt)
  {
    CvFont localCvFont = new CvFont();
    cvInitFont(localCvFont, 1, paramDouble, paramDouble, 0.0D, paramInt, 16);
    return localCvFont;
  }
  
  public static void cvFree(Pointer paramPointer)
  {
    cvFree_(paramPointer);
    paramPointer.setNull();
  }
  
  public static native void cvFree_(Pointer paramPointer);
  
  public static native void cvGEMM(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, CvArr paramCvArr3, double paramDouble2, CvArr paramCvArr4, int paramInt);
  
  @ByVal
  public static native CvScalar cvGet1D(CvArr paramCvArr, int paramInt);
  
  @ByVal
  public static native CvScalar cvGet2D(CvArr paramCvArr, int paramInt1, int paramInt2);
  
  @ByVal
  public static native CvScalar cvGet3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3);
  
  public static CvMat cvGetCol(CvArr paramCvArr, CvMat paramCvMat, int paramInt)
  {
    return cvGetCols(paramCvArr, paramCvMat, paramInt, paramInt + 1);
  }
  
  public static native CvMat cvGetCols(CvArr paramCvArr, CvMat paramCvMat, int paramInt1, int paramInt2);
  
  public static native CvMat cvGetDiag(CvArr paramCvArr, CvMat paramCvMat, int paramInt);
  
  public static native int cvGetDimSize(CvArr paramCvArr, int paramInt);
  
  public static native int cvGetDims(CvArr paramCvArr, int[] paramArrayOfInt);
  
  public static native int cvGetElemType(CvArr paramCvArr);
  
  public static native int cvGetErrInfo(@ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer1, @ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer2, @ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer3, int[] paramArrayOfInt);
  
  public static native int cvGetErrMode();
  
  public static native int cvGetErrStatus();
  
  public static native CvFileNode cvGetFileNode(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, CvStringHashNode paramCvStringHashNode, int paramInt);
  
  public static native CvFileNode cvGetFileNodeByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString);
  
  public static native String cvGetFileNodeName(CvFileNode paramCvFileNode);
  
  public static CvGraphVtx cvGetGraphVtx(CvGraph paramCvGraph, int paramInt)
  {
    return new CvGraphVtx(cvGetSetElem(paramCvGraph, paramInt));
  }
  
  public static native CvStringHashNode cvGetHashedKey(CvFileStorage paramCvFileStorage, String paramString, int paramInt1, int paramInt2);
  
  public static native IplImage cvGetImage(CvArr paramCvArr, IplImage paramIplImage);
  
  public static native int cvGetImageCOI(IplImage paramIplImage);
  
  @ByVal
  public static native CvRect cvGetImageROI(IplImage paramIplImage);
  
  public static native CvMat cvGetMat(CvArr paramCvArr, CvMat paramCvMat, int[] paramArrayOfInt, int paramInt);
  
  public static native void cvGetModuleInfo(String paramString, @ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer1, @ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer2);
  
  @ByVal
  public static native CvScalar cvGetND(CvArr paramCvArr, int[] paramArrayOfInt);
  
  public static native CvSparseNode cvGetNextSparseNode(CvSparseMatIterator paramCvSparseMatIterator);
  
  public static native int cvGetNumThreads();
  
  public static native int cvGetOptimalDFTSize(int paramInt);
  
  public static native void cvGetRawData(CvArr paramCvArr, @ByPtrPtr @Cast({"uchar**"}) BytePointer paramBytePointer, int[] paramArrayOfInt, CvSize paramCvSize);
  
  public static native double cvGetReal1D(CvArr paramCvArr, int paramInt);
  
  public static native double cvGetReal2D(CvArr paramCvArr, int paramInt1, int paramInt2);
  
  public static native double cvGetReal3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3);
  
  public static native double cvGetRealND(CvArr paramCvArr, int[] paramArrayOfInt);
  
  public static native CvFileNode cvGetRootFileNode(CvFileStorage paramCvFileStorage, int paramInt);
  
  public static CvMat cvGetRow(CvArr paramCvArr, CvMat paramCvMat, int paramInt)
  {
    return cvGetRows(paramCvArr, paramCvMat, paramInt, paramInt + 1, 1);
  }
  
  public static native CvMat cvGetRows(CvArr paramCvArr, CvMat paramCvMat, int paramInt1, int paramInt2, int paramInt3);
  
  public static native Pointer cvGetSeqElem(CvSeq paramCvSeq, int paramInt);
  
  public static native int cvGetSeqReaderPos(CvSeqReader paramCvSeqReader);
  
  public static CvSetElem cvGetSetElem(CvSet paramCvSet, int paramInt)
  {
    CvSetElem localCvSetElem = new CvSetElem(cvGetSeqElem(paramCvSet, paramInt));
    if ((localCvSetElem != null) && (CV_IS_SET_ELEM(localCvSetElem))) {
      return localCvSetElem;
    }
    return null;
  }
  
  @ByVal
  public static native CvSize cvGetSize(CvArr paramCvArr);
  
  public static CvMat cvGetSubArr(CvArr paramCvArr, CvMat paramCvMat, @ByVal CvRect paramCvRect)
  {
    return cvGetSubRect(paramCvArr, paramCvMat, paramCvRect);
  }
  
  public static native CvMat cvGetSubRect(CvArr paramCvArr, CvMat paramCvMat, @ByVal CvRect paramCvRect);
  
  public static native void cvGetTextSize(String paramString, CvFont paramCvFont, CvSize paramCvSize, int[] paramArrayOfInt);
  
  public static native int cvGetThreadNum();
  
  public static native long cvGetTickCount();
  
  public static native double cvGetTickFrequency();
  
  public static native int cvGraphAddEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2, CvGraphEdge paramCvGraphEdge1, @ByPtrPtr CvGraphEdge paramCvGraphEdge2);
  
  public static native int cvGraphAddEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2, CvGraphEdge paramCvGraphEdge1, @ByPtrPtr CvGraphEdge paramCvGraphEdge2);
  
  public static native int cvGraphAddVtx(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, @ByPtrPtr CvGraphVtx paramCvGraphVtx2);
  
  public static int cvGraphEdgeIdx(CvGraph paramCvGraph, CvGraphEdge paramCvGraphEdge)
  {
    return 0x3FFFFFF & paramCvGraphEdge.flags();
  }
  
  public static CvGraphEdge cvGraphFindEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2)
  {
    return cvFindGraphEdge(paramCvGraph, paramInt1, paramInt2);
  }
  
  public static CvGraphEdge cvGraphFindEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2)
  {
    return cvFindGraphEdgeByPtr(paramCvGraph, paramCvGraphVtx1, paramCvGraphVtx2);
  }
  
  public static int cvGraphGetEdgeCount(CvGraph paramCvGraph)
  {
    return paramCvGraph.edges().active_count();
  }
  
  public static int cvGraphGetVtxCount(CvGraph paramCvGraph)
  {
    return paramCvGraph.active_count();
  }
  
  public static native void cvGraphRemoveEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2);
  
  public static native void cvGraphRemoveEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2);
  
  public static native int cvGraphRemoveVtx(CvGraph paramCvGraph, int paramInt);
  
  public static native int cvGraphRemoveVtxByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx);
  
  public static native int cvGraphVtxDegree(CvGraph paramCvGraph, int paramInt);
  
  public static native int cvGraphVtxDegreeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx);
  
  public static int cvGraphVtxIdx(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx)
  {
    return 0x3FFFFFF & paramCvGraphVtx.flags();
  }
  
  public static native int cvGuiBoxReport(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
  
  public static native void cvInRange(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvInRangeS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2, CvArr paramCvArr2);
  
  public static native void cvInitFont(CvFont paramCvFont, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt2, int paramInt3);
  
  public static native IplImage cvInitImageHeader(IplImage paramIplImage, @ByVal CvSize paramCvSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int cvInitLineIterator(CvArr paramCvArr, @ByVal CvPoint paramCvPoint1, @ByVal CvPoint paramCvPoint2, CvLineIterator paramCvLineIterator, int paramInt1, int paramInt2);
  
  public static native CvMat cvInitMatHeader(CvMat paramCvMat, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, int paramInt4);
  
  public static native CvMatND cvInitMatNDHeader(CvMatND paramCvMatND, int paramInt1, int[] paramArrayOfInt, int paramInt2, Pointer paramPointer);
  
  public static native int cvInitNArrayIterator(int paramInt1, CvArrArray paramCvArrArray, CvArr paramCvArr, CvMatND paramCvMatND, CvNArrayIterator paramCvNArrayIterator, int paramInt2);
  
  public static int cvInitNArrayIterator(int paramInt1, CvArr[] paramArrayOfCvArr, CvArr paramCvArr, CvMatND paramCvMatND, CvNArrayIterator paramCvNArrayIterator, int paramInt2)
  {
    return cvInitNArrayIterator(paramInt1, new CvArrArray(paramArrayOfCvArr), paramCvArr, paramCvMatND, paramCvNArrayIterator, paramInt2);
  }
  
  public static native CvSparseNode cvInitSparseMatIterator(CvSparseMat paramCvSparseMat, CvSparseMatIterator paramCvSparseMatIterator);
  
  public static native void cvInitTreeNodeIterator(CvTreeNodeIterator paramCvTreeNodeIterator, Pointer paramPointer, int paramInt);
  
  public static native void cvInsertNodeIntoTree(Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3);
  
  public static double cvInv(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    return cvInvert(paramCvArr1, paramCvArr2, 0);
  }
  
  public static double cvInv(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt)
  {
    return cvInvert(paramCvArr1, paramCvArr2, paramInt);
  }
  
  public static double cvInvert(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    return cvInvert(paramCvArr1, paramCvArr2, 0);
  }
  
  public static native double cvInvert(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt);
  
  public static int cvIplDepth(int paramInt)
  {
    int i = CV_MAT_DEPTH(paramInt);
    int j = 8 * CV_ELEM_SIZE1(i);
    if ((i == 1) || (i == 3) || (i == 4)) {}
    for (int k = Integer.MIN_VALUE;; k = 0) {
      return k | j;
    }
  }
  
  public static native int cvKMeans2(CvArr paramCvArr1, int paramInt1, CvArr paramCvArr2, @ByVal CvTermCriteria paramCvTermCriteria, int paramInt2, CvRNG paramCvRNG, int paramInt3, CvArr paramCvArr3, double[] paramArrayOfDouble);
  
  public static native void cvLUT(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native void cvLine(CvArr paramCvArr, @ByVal CvPoint paramCvPoint1, @ByVal CvPoint paramCvPoint2, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
  
  public static Pointer cvLoad(String paramString)
  {
    return cvLoad(paramString, null, null, null);
  }
  
  public static native Pointer cvLoad(String paramString1, CvMemStorage paramCvMemStorage, String paramString2, @ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer);
  
  public static native void cvLog(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static native double cvMahalanobis(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static double cvMahalonobis(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3)
  {
    return cvMahalanobis(paramCvArr1, paramCvArr2, paramCvArr3);
  }
  
  public static native CvSeq cvMakeSeqHeaderForArray(int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, int paramInt4, CvSeq paramCvSeq, CvSeqBlock paramCvSeqBlock);
  
  public static CvMat cvMat(int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer)
  {
    CvMat localCvMat = new CvMat();
    assert ((CV_MAT_DEPTH(paramInt3) >= 0) && (CV_MAT_DEPTH(paramInt3) <= 6));
    int i = CV_MAT_TYPE(paramInt3);
    localCvMat.raw_type(0x42424000 | i);
    localCvMat.cols(paramInt2);
    localCvMat.rows(paramInt1);
    localCvMat.step(paramInt2 * CV_ELEM_SIZE(i));
    localCvMat.data_ptr(new BytePointer(paramPointer));
    localCvMat.refcount(null);
    localCvMat.hdr_refcount(0);
    return localCvMat;
  }
  
  public static void cvMatMul(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3)
  {
    cvMatMulAdd(paramCvArr1, paramCvArr2, null, paramCvArr3);
  }
  
  public static void cvMatMulAdd(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4)
  {
    cvGEMM(paramCvArr1, paramCvArr2, 1.0D, paramCvArr3, 1.0D, paramCvArr4, 0);
  }
  
  public static void cvMatMulAddEx(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, CvArr paramCvArr3, double paramDouble2, CvArr paramCvArr4, int paramInt)
  {
    cvGEMM(paramCvArr1, paramCvArr2, paramDouble1, paramCvArr3, paramDouble2, paramCvArr4, paramInt);
  }
  
  public static void cvMatMulAddS(CvArr paramCvArr1, CvArr paramCvArr2, CvMat paramCvMat1, CvMat paramCvMat2)
  {
    cvTransform(paramCvArr1, paramCvArr2, paramCvMat1, paramCvMat2);
  }
  
  public static native void cvMax(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native void cvMaxS(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2);
  
  public static native Pointer cvMemStorageAlloc(CvMemStorage paramCvMemStorage, @Cast({"size_t"}) long paramLong);
  
  @ByVal
  public static native CvString cvMemStorageAllocString(CvMemStorage paramCvMemStorage, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
  
  @ByVal
  public static native CvString cvMemStorageAllocString(CvMemStorage paramCvMemStorage, String paramString, int paramInt);
  
  public static native void cvMerge(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, CvArr paramCvArr5);
  
  public static native void cvMin(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static void cvMinMaxLoc(CvArr paramCvArr, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    cvMinMaxLoc(paramCvArr, paramArrayOfDouble1, paramArrayOfDouble2, (CvPoint)null, (CvPoint)null, null);
  }
  
  public static native void cvMinMaxLoc(CvArr paramCvArr1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, CvPoint paramCvPoint1, CvPoint paramCvPoint2, CvArr paramCvArr2);
  
  public static native void cvMinMaxLoc(CvArr paramCvArr1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, @Cast({"CvPoint*"}) int[] paramArrayOfInt1, @Cast({"CvPoint*"}) int[] paramArrayOfInt2, CvArr paramCvArr2);
  
  public static native void cvMinS(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2);
  
  public static void cvMirror(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt)
  {
    cvFlip(paramCvArr1, paramCvArr2, paramInt);
  }
  
  public static native void cvMixChannels(@Const CvArrArray paramCvArrArray1, int paramInt1, CvArrArray paramCvArrArray2, int paramInt2, int[] paramArrayOfInt, int paramInt3);
  
  public static void cvMixChannels(CvArr[] paramArrayOfCvArr1, int paramInt1, CvArr[] paramArrayOfCvArr2, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    cvMixChannels(new CvArrArray(paramArrayOfCvArr1), paramInt1, new CvArrArray(paramArrayOfCvArr2), paramInt2, paramArrayOfInt, paramInt3);
  }
  
  public static native void cvMul(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, double paramDouble);
  
  public static native void cvMulSpectrums(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
  
  public static native void cvMulTransposed(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt, CvArr paramCvArr3, double paramDouble);
  
  public static native int cvNextGraphItem(CvGraphScanner paramCvGraphScanner);
  
  public static native int cvNextNArraySlice(CvNArrayIterator paramCvNArrayIterator);
  
  public static native Pointer cvNextTreeNode(CvTreeNodeIterator paramCvTreeNodeIterator);
  
  public static double cvNorm(CvArr paramCvArr)
  {
    return cvNorm(paramCvArr, null, 4, null);
  }
  
  public static double cvNorm(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    return cvNorm(paramCvArr1, paramCvArr2, 4, null);
  }
  
  public static double cvNorm(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt)
  {
    return cvNorm(paramCvArr1, paramCvArr2, paramInt, null);
  }
  
  public static native double cvNorm(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt, CvArr paramCvArr3);
  
  public static void cvNormalize(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    cvNormalize(paramCvArr1, paramCvArr2, 1.0D, 0.0D, 4, null);
  }
  
  public static native void cvNormalize(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2, int paramInt, CvArr paramCvArr3);
  
  public static native void cvNot(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static native int cvNulDevReport(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
  
  public static native CvFileStorage cvOpenFileStorage(String paramString1, CvMemStorage paramCvMemStorage, int paramInt, String paramString2);
  
  public static native void cvOr(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvOrS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native void cvPerspectiveTransform(CvArr paramCvArr1, CvArr paramCvArr2, CvMat paramCvMat);
  
  public static CvPoint cvPoint(int paramInt1, int paramInt2)
  {
    return new CvPoint().x(paramInt1).y(paramInt2);
  }
  
  public static CvPoint2D32f cvPoint2D32f(double paramDouble1, double paramDouble2)
  {
    return new CvPoint2D32f().x((float)paramDouble1).y((float)paramDouble2);
  }
  
  public static CvPoint2D64f cvPoint2D64f(double paramDouble1, double paramDouble2)
  {
    return new CvPoint2D64f().x(paramDouble1).y(paramDouble2);
  }
  
  public static CvPoint3D32f cvPoint3D32f(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return new CvPoint3D32f().x((float)paramDouble1).y((float)paramDouble2).z((float)paramDouble3);
  }
  
  public static CvPoint3D64f cvPoint3D64f(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return new CvPoint3D64f().x(paramDouble1).y(paramDouble2).z(paramDouble3);
  }
  
  public static CvPoint cvPointFrom32f(CvPoint2D32f paramCvPoint2D32f)
  {
    CvPoint localCvPoint = new CvPoint();
    localCvPoint.x(Math.round(paramCvPoint2D32f.x()));
    localCvPoint.y(Math.round(paramCvPoint2D32f.y()));
    return localCvPoint;
  }
  
  public static CvPoint2D32f cvPointTo32f(CvPoint paramCvPoint)
  {
    return cvPoint2D32f(paramCvPoint.x(), paramCvPoint.y());
  }
  
  public static native void cvPolarToCart(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
  
  public static native void cvPolyLine(CvArr paramCvArr, @Cast({"CvPoint**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void cvPolyLine(CvArr paramCvArr, @ByPtrPtr CvPoint paramCvPoint, int[] paramArrayOfInt, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5);
  
  public static void cvPolyLine(CvArr paramCvArr, CvPoint[] paramArrayOfCvPoint, int[] paramArrayOfInt, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5)
  {
    cvPolyLine(paramCvArr, new PointerPointer(paramArrayOfCvPoint), paramArrayOfInt, paramInt1, paramInt2, paramCvScalar, paramInt3, paramInt4, paramInt5);
  }
  
  public static native void cvPow(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble);
  
  public static native Pointer cvPrevTreeNode(CvTreeNodeIterator paramCvTreeNodeIterator);
  
  public static native void cvProjectPCA(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native Pointer cvPtr1D(CvArr paramCvArr, int paramInt, int[] paramArrayOfInt);
  
  public static native Pointer cvPtr2D(CvArr paramCvArr, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public static native Pointer cvPtr3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  public static native Pointer cvPtrND(CvArr paramCvArr, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, @Cast({"unsigned*"}) int[] paramArrayOfInt3);
  
  public static native void cvPutText(CvArr paramCvArr, String paramString, @ByVal CvPoint paramCvPoint, CvFont paramCvFont, @ByVal CvScalar paramCvScalar);
  
  public static CvRNG cvRNG()
  {
    return cvRNG(-1L);
  }
  
  public static CvRNG cvRNG(long paramLong)
  {
    CvRNG localCvRNG = new CvRNG();
    if (paramLong != 0L) {}
    for (;;)
    {
      return (CvRNG)localCvRNG.put(paramLong);
      paramLong = -1L;
    }
  }
  
  public static CvRect cvROIToRect(IplROI paramIplROI)
  {
    return cvRect(paramIplROI.xOffset(), paramIplROI.yOffset(), paramIplROI.width(), paramIplROI.height());
  }
  
  public static native void cvRandArr(CvRNG paramCvRNG, CvArr paramCvArr, int paramInt, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2);
  
  public static int cvRandInt(CvRNG paramCvRNG)
  {
    long l1 = paramCvRNG.get();
    long l2 = 4164903690L * (l1 & 0xFFFFFFFF) + (0xFFFFFFFF & l1 >> 32);
    paramCvRNG.put(l2);
    return (int)l2;
  }
  
  public static double cvRandReal(CvRNG paramCvRNG)
  {
    return 2.3283064365386963E-10D * (0xFFFFFFFF & cvRandInt(paramCvRNG));
  }
  
  public static native void cvRandShuffle(CvArr paramCvArr, CvRNG paramCvRNG, double paramDouble);
  
  public static native CvArr cvRange(CvArr paramCvArr, double paramDouble1, double paramDouble2);
  
  public static native void cvRawDataToScalar(Pointer paramPointer, int paramInt, CvScalar paramCvScalar);
  
  public static Pointer cvRead(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode)
  {
    return cvRead(paramCvFileStorage, paramCvFileNode, CvAttrList.EMPTY);
  }
  
  public static native Pointer cvRead(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, CvAttrList paramCvAttrList);
  
  public static Pointer cvReadByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString)
  {
    return cvReadByName(paramCvFileStorage, paramCvFileNode, paramString, CvAttrList.EMPTY);
  }
  
  public static Pointer cvReadByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString, CvAttrList paramCvAttrList)
  {
    return cvRead(paramCvFileStorage, cvGetFileNodeByName(paramCvFileStorage, paramCvFileNode, paramString), paramCvAttrList);
  }
  
  public static int cvReadInt(CvFileNode paramCvFileNode)
  {
    return cvReadInt(paramCvFileNode, 0);
  }
  
  public static int cvReadInt(CvFileNode paramCvFileNode, int paramInt)
  {
    if (paramCvFileNode == null) {
      return paramInt;
    }
    if (CV_NODE_IS_INT(paramCvFileNode.tag())) {
      return paramCvFileNode.data_i();
    }
    if (CV_NODE_IS_REAL(paramCvFileNode.tag())) {
      return (int)Math.round(paramCvFileNode.data_f());
    }
    return Integer.MAX_VALUE;
  }
  
  public static int cvReadIntByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString)
  {
    return cvReadIntByName(paramCvFileStorage, paramCvFileNode, paramString, 0);
  }
  
  public static int cvReadIntByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString, int paramInt)
  {
    return cvReadInt(cvGetFileNodeByName(paramCvFileStorage, paramCvFileNode, paramString), paramInt);
  }
  
  public static native void cvReadRawData(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, Pointer paramPointer, String paramString);
  
  public static native void cvReadRawDataSlice(CvFileStorage paramCvFileStorage, CvSeqReader paramCvSeqReader, int paramInt, Pointer paramPointer, String paramString);
  
  public static double cvReadReal(CvFileNode paramCvFileNode)
  {
    return cvReadReal(paramCvFileNode, 0.0D);
  }
  
  public static double cvReadReal(CvFileNode paramCvFileNode, double paramDouble)
  {
    if (paramCvFileNode == null) {
      return paramDouble;
    }
    if (CV_NODE_IS_INT(paramCvFileNode.tag())) {
      return paramCvFileNode.data_i();
    }
    if (CV_NODE_IS_REAL(paramCvFileNode.tag())) {
      return paramCvFileNode.data_f();
    }
    return 1.0E300D;
  }
  
  public static double cvReadRealByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString)
  {
    return cvReadRealByName(paramCvFileStorage, paramCvFileNode, paramString, 0.0D);
  }
  
  public static double cvReadRealByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString, double paramDouble)
  {
    return cvReadReal(cvGetFileNodeByName(paramCvFileStorage, paramCvFileNode, paramString), paramDouble);
  }
  
  public static String cvReadString(CvFileNode paramCvFileNode)
  {
    return cvReadString(paramCvFileNode, null);
  }
  
  public static String cvReadString(CvFileNode paramCvFileNode, String paramString)
  {
    if (paramCvFileNode == null) {
      return paramString;
    }
    if (CV_NODE_IS_STRING(paramCvFileNode.tag()))
    {
      CvString localCvString = paramCvFileNode.data_str();
      BytePointer localBytePointer = localCvString.ptr();
      byte[] arrayOfByte = new byte[localCvString.len()];
      localBytePointer.get(arrayOfByte);
      return new String(arrayOfByte);
    }
    return null;
  }
  
  public static String cvReadStringByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString)
  {
    return cvReadStringByName(paramCvFileStorage, paramCvFileNode, paramString, null);
  }
  
  public static String cvReadStringByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString1, String paramString2)
  {
    return cvReadString(cvGetFileNodeByName(paramCvFileStorage, paramCvFileNode, paramString1), paramString2);
  }
  
  public static CvScalar cvRealScalar(double paramDouble)
  {
    return new CvScalar().val(0, paramDouble).val(1, 0.0D).val(2, 0.0D).val(3, 0.0D);
  }
  
  public static CvRect cvRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new CvRect().x(paramInt1).y(paramInt2).width(paramInt3).height(paramInt4);
  }
  
  public static IplROI cvRectToROI(CvRect paramCvRect, int paramInt)
  {
    IplROI localIplROI = new IplROI();
    localIplROI.xOffset(paramCvRect.x());
    localIplROI.yOffset(paramCvRect.y());
    localIplROI.width(paramCvRect.width());
    localIplROI.height(paramCvRect.height());
    localIplROI.coi(paramInt);
    return localIplROI;
  }
  
  public static native void cvRectangle(CvArr paramCvArr, @ByVal CvPoint paramCvPoint1, @ByVal CvPoint paramCvPoint2, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void cvRectangleR(CvArr paramCvArr, @ByVal CvRect paramCvRect, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
  
  public static native CvErrorCallback cvRedirectError(CvErrorCallback paramCvErrorCallback, Pointer paramPointer1, @ByPtrPtr @Cast({"void**"}) Pointer paramPointer2);
  
  public static native void cvReduce(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt1, int paramInt2);
  
  public static native int cvRegisterModule(CvModuleInfo paramCvModuleInfo);
  
  public static native void cvRegisterType(CvTypeInfo paramCvTypeInfo);
  
  public static native void cvRelease(PointerPointer paramPointerPointer);
  
  public static native void cvReleaseData(CvArr paramCvArr);
  
  public static native void cvReleaseFileStorage(@ByPtrPtr CvFileStorage paramCvFileStorage);
  
  public static native void cvReleaseGraphScanner(@ByPtrPtr CvGraphScanner paramCvGraphScanner);
  
  public static native void cvReleaseImage(@ByPtrPtr IplImage paramIplImage);
  
  public static native void cvReleaseImageHeader(@ByPtrPtr IplImage paramIplImage);
  
  public static native void cvReleaseMat(@ByPtrPtr CvMat paramCvMat);
  
  public static native void cvReleaseMatND(@ByPtrPtr CvMatND paramCvMatND);
  
  public static native void cvReleaseMemStorage(@ByPtrPtr CvMemStorage paramCvMemStorage);
  
  public static native void cvReleaseSparseMat(@ByPtrPtr CvSparseMat paramCvSparseMat);
  
  public static native void cvRemoveNodeFromTree(Pointer paramPointer1, Pointer paramPointer2);
  
  public static native void cvRepeat(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static native void cvResetImageROI(IplImage paramIplImage);
  
  public static native CvMat cvReshape(CvArr paramCvArr, CvMat paramCvMat, int paramInt1, int paramInt2);
  
  public static native CvArr cvReshapeMatND(CvArr paramCvArr1, int paramInt1, CvArr paramCvArr2, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  public static CvArr cvReshapeND(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return cvReshapeMatND(paramCvArr1, Loader.sizeof(paramCvArr2.getClass()), paramCvArr2, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public static native void cvRestoreMemStoragePos(CvMemStorage paramCvMemStorage, CvMemStoragePos paramCvMemStoragePos);
  
  public static native void cvSVBkSb(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, CvArr paramCvArr5, int paramInt);
  
  public static native void cvSVD(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
  
  public static void cvSave(String paramString, Pointer paramPointer)
  {
    cvSave(paramString, paramPointer, null, null, CvAttrList.EMPTY);
  }
  
  public static native void cvSave(String paramString1, Pointer paramPointer, String paramString2, String paramString3, @ByVal CvAttrList paramCvAttrList);
  
  public static native void cvSaveMemStoragePos(CvMemStorage paramCvMemStorage, CvMemStoragePos paramCvMemStoragePos);
  
  public static CvScalar cvScalar(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return new CvScalar().val(0, paramDouble1).val(1, paramDouble2).val(2, paramDouble3).val(3, paramDouble4);
  }
  
  public static CvScalar cvScalarAll(double paramDouble)
  {
    return new CvScalar().val(0, paramDouble).val(1, paramDouble).val(2, paramDouble).val(3, paramDouble);
  }
  
  public static native void cvScalarToRawData(CvScalar paramCvScalar, Pointer paramPointer, int paramInt1, int paramInt2);
  
  public static void cvScale(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2)
  {
    cvConvertScale(paramCvArr1, paramCvArr2, paramDouble1, paramDouble2);
  }
  
  public static native void cvScaleAdd(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static native int cvSeqElemIdx(CvSeq paramCvSeq, Pointer paramPointer, @ByPtrPtr CvSeqBlock paramCvSeqBlock);
  
  public static native Pointer cvSeqInsert(CvSeq paramCvSeq, int paramInt, Pointer paramPointer);
  
  public static native void cvSeqInsertSlice(CvSeq paramCvSeq, int paramInt, CvArr paramCvArr);
  
  public static native void cvSeqInvert(CvSeq paramCvSeq);
  
  public static native int cvSeqPartition(CvSeq paramCvSeq1, CvMemStorage paramCvMemStorage, @ByPtrPtr CvSeq paramCvSeq2, CvCmpFunc paramCvCmpFunc, Pointer paramPointer);
  
  public static native void cvSeqPop(CvSeq paramCvSeq, Pointer paramPointer);
  
  public static native void cvSeqPopFront(CvSeq paramCvSeq, Pointer paramPointer);
  
  public static native void cvSeqPopMulti(CvSeq paramCvSeq, Pointer paramPointer, int paramInt1, int paramInt2);
  
  @Cast({"schar*"})
  public static native BytePointer cvSeqPush(CvSeq paramCvSeq, Pointer paramPointer);
  
  @Cast({"schar*"})
  public static native BytePointer cvSeqPushFront(CvSeq paramCvSeq, Pointer paramPointer);
  
  public static native void cvSeqPushMulti(CvSeq paramCvSeq, Pointer paramPointer, int paramInt1, int paramInt2);
  
  public static native void cvSeqRemove(CvSeq paramCvSeq, int paramInt);
  
  public static native void cvSeqRemoveSlice(CvSeq paramCvSeq, @ByVal CvSlice paramCvSlice);
  
  public static native Pointer cvSeqSearch(CvSeq paramCvSeq, Pointer paramPointer1, CvCmpFunc paramCvCmpFunc, int paramInt, int[] paramArrayOfInt, Pointer paramPointer2);
  
  public static native CvSeq cvSeqSlice(CvSeq paramCvSeq, @ByVal CvSlice paramCvSlice, CvMemStorage paramCvMemStorage, int paramInt);
  
  public static native void cvSeqSort(CvSeq paramCvSeq, CvCmpFunc paramCvCmpFunc, Pointer paramPointer);
  
  public static void cvSet(CvArr paramCvArr, CvScalar paramCvScalar)
  {
    cvSet(paramCvArr, paramCvScalar, null);
  }
  
  public static native void cvSet(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2);
  
  public static native void cvSet1D(CvArr paramCvArr, int paramInt, @ByVal CvScalar paramCvScalar);
  
  public static native void cvSet2D(CvArr paramCvArr, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar);
  
  public static native void cvSet3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3, @ByVal CvScalar paramCvScalar);
  
  public static native int cvSetAdd(CvSet paramCvSet, CvSetElem paramCvSetElem1, @ByPtrPtr CvSetElem paramCvSetElem2);
  
  public static native void cvSetData(CvArr paramCvArr, Pointer paramPointer, int paramInt);
  
  public static native int cvSetErrMode(int paramInt);
  
  public static native void cvSetErrStatus(int paramInt);
  
  public static native void cvSetIPLAllocators(Cv_iplCreateImageHeader paramCv_iplCreateImageHeader, Cv_iplAllocateImageData paramCv_iplAllocateImageData, Cv_iplDeallocate paramCv_iplDeallocate, Cv_iplCreateROI paramCv_iplCreateROI, Cv_iplCloneImage paramCv_iplCloneImage);
  
  public static void cvSetIdentity(CvArr paramCvArr)
  {
    cvSetIdentity(paramCvArr, 1.0D);
  }
  
  public static void cvSetIdentity(CvArr paramCvArr, double paramDouble)
  {
    cvSetIdentity(paramCvArr, cvRealScalar(paramDouble));
  }
  
  public static native void cvSetIdentity(CvArr paramCvArr, @ByVal CvScalar paramCvScalar);
  
  public static native void cvSetImageCOI(IplImage paramIplImage, int paramInt);
  
  public static native void cvSetImageROI(IplImage paramIplImage, @ByVal CvRect paramCvRect);
  
  public static native void cvSetMemoryManager(CvAllocFunc paramCvAllocFunc, CvFreeFunc paramCvFreeFunc, Pointer paramPointer);
  
  public static native void cvSetND(CvArr paramCvArr, int[] paramArrayOfInt, @ByVal CvScalar paramCvScalar);
  
  public static native void cvSetNumThreads(int paramInt);
  
  public static native void cvSetReal1D(CvArr paramCvArr, int paramInt, double paramDouble);
  
  public static native void cvSetReal2D(CvArr paramCvArr, int paramInt1, int paramInt2, double paramDouble);
  
  public static native void cvSetReal3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  public static native void cvSetRealND(CvArr paramCvArr, int[] paramArrayOfInt, double paramDouble);
  
  public static native void cvSetRemove(CvSet paramCvSet, int paramInt);
  
  public static native void cvSetSeqBlockSize(CvSeq paramCvSeq, int paramInt);
  
  public static native void cvSetSeqReaderPos(CvSeqReader paramCvSeqReader, int paramInt1, int paramInt2);
  
  public static native void cvSetZero(CvArr paramCvArr);
  
  public static CvSize cvSize(int paramInt1, int paramInt2)
  {
    return new CvSize().width(paramInt1).height(paramInt2);
  }
  
  public static CvSize2D32f cvSize2D32f(double paramDouble1, double paramDouble2)
  {
    return new CvSize2D32f().width((float)paramDouble1).height((float)paramDouble2);
  }
  
  public static CvSlice cvSlice(int paramInt1, int paramInt2)
  {
    return new CvSlice().start_index(paramInt1).end_index(paramInt2);
  }
  
  public static native int cvSliceLength(@ByVal CvSlice paramCvSlice, CvSeq paramCvSeq);
  
  public static int cvSolve(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3)
  {
    return cvSolve(paramCvArr1, paramCvArr2, paramCvArr3, 0);
  }
  
  public static native int cvSolve(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
  
  public static native int cvSolveCubic(CvMat paramCvMat1, CvMat paramCvMat2);
  
  public static native void cvSolvePoly(CvMat paramCvMat1, CvMat paramCvMat2, int paramInt1, int paramInt2);
  
  public static native void cvSort(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
  
  public static native void cvSplit(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, CvArr paramCvArr5);
  
  public static native void cvStartAppendToSeq(CvSeq paramCvSeq, CvSeqWriter paramCvSeqWriter);
  
  public static native void cvStartNextStream(CvFileStorage paramCvFileStorage);
  
  public static native void cvStartReadRawData(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, CvSeqReader paramCvSeqReader);
  
  public static native void cvStartReadSeq(CvSeq paramCvSeq, CvSeqReader paramCvSeqReader, int paramInt);
  
  public static native void cvStartWriteSeq(int paramInt1, int paramInt2, int paramInt3, CvMemStorage paramCvMemStorage, CvSeqWriter paramCvSeqWriter);
  
  public static void cvStartWriteStruct(CvFileStorage paramCvFileStorage, String paramString1, int paramInt, String paramString2)
  {
    cvStartWriteStruct(paramCvFileStorage, paramString1, paramInt, paramString2, CvAttrList.EMPTY);
  }
  
  public static native void cvStartWriteStruct(CvFileStorage paramCvFileStorage, String paramString1, int paramInt, String paramString2, @ByVal CvAttrList paramCvAttrList);
  
  public static native int cvStdErrReport(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
  
  public static native void cvSub(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvSubRS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static void cvSubS(CvArr paramCvArr1, CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3)
  {
    cvAddS(paramCvArr1, cvScalar(-paramCvScalar.val(0), -paramCvScalar.val(1), -paramCvScalar.val(2), -paramCvScalar.val(3)), paramCvArr2, paramCvArr3);
  }
  
  @ByVal
  public static native CvScalar cvSum(CvArr paramCvArr);
  
  public static void cvT(CvArr paramCvArr1, CvArr paramCvArr2)
  {
    cvTranspose(paramCvArr1, paramCvArr2);
  }
  
  public static CvTermCriteria cvTermCriteria(int paramInt1, int paramInt2, double paramDouble)
  {
    return new CvTermCriteria().type(paramInt1).max_iter(paramInt2).epsilon(paramDouble);
  }
  
  @ByVal
  public static native CvScalar cvTrace(CvArr paramCvArr);
  
  public static native void cvTransform(CvArr paramCvArr1, CvArr paramCvArr2, CvMat paramCvMat1, CvMat paramCvMat2);
  
  public static native void cvTranspose(CvArr paramCvArr1, CvArr paramCvArr2);
  
  public static native CvSeq cvTreeToNodeSeq(Pointer paramPointer, int paramInt, CvMemStorage paramCvMemStorage);
  
  public static native CvTypeInfo cvTypeOf(Pointer paramPointer);
  
  public static native void cvUnregisterType(String paramString);
  
  public static native int cvUseOptimized(int paramInt);
  
  public static void cvWrite(CvFileStorage paramCvFileStorage, String paramString, Pointer paramPointer)
  {
    cvWrite(paramCvFileStorage, paramString, paramPointer, CvAttrList.EMPTY);
  }
  
  public static native void cvWrite(CvFileStorage paramCvFileStorage, String paramString, Pointer paramPointer, @ByVal CvAttrList paramCvAttrList);
  
  public static native void cvWriteComment(CvFileStorage paramCvFileStorage, String paramString, int paramInt);
  
  public static native void cvWriteFileNode(CvFileStorage paramCvFileStorage, String paramString, CvFileNode paramCvFileNode, int paramInt);
  
  public static native void cvWriteInt(CvFileStorage paramCvFileStorage, String paramString, int paramInt);
  
  public static native void cvWriteRawData(CvFileStorage paramCvFileStorage, Pointer paramPointer, int paramInt, String paramString);
  
  public static native void cvWriteReal(CvFileStorage paramCvFileStorage, String paramString, double paramDouble);
  
  public static native void cvWriteString(CvFileStorage paramCvFileStorage, String paramString1, String paramString2, int paramInt);
  
  public static native void cvXor(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
  
  public static native void cvXorS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
  
  public static void cvZero(CvArr paramCvArr)
  {
    cvSetZero(paramCvArr);
  }
  
  @ByRef
  @Namespace("cv")
  public static native String getBuildInformation();
  
  @Name({"cv::partition<void*>"})
  public static native int partition(@StdVector PointerPointer paramPointerPointer, @StdVector IntPointer paramIntPointer, @ByRef Predicate paramPredicate);
  
  public CvSetElem cvSetNew(CvSet paramCvSet)
  {
    CvSetElem localCvSetElem = paramCvSet.free_elems();
    if (localCvSetElem != null)
    {
      paramCvSet.free_elems(localCvSetElem.next_free());
      localCvSetElem.flags(0x3FFFFFF & localCvSetElem.flags());
      paramCvSet.active_count(1 + paramCvSet.active_count());
      return localCvSetElem;
    }
    cvSetAdd(paramCvSet, null, localCvSetElem);
    return localCvSetElem;
  }
  
  public void cvSetRemoveByPtr(CvSet paramCvSet, CvSetElem paramCvSetElem)
  {
    assert (paramCvSetElem.flags() >= 0);
    paramCvSetElem.next_free(paramCvSet.free_elems());
    paramCvSetElem.flags(0x80 | 0x3FFFFFF & paramCvSetElem.flags());
    paramCvSet.free_elems(paramCvSetElem);
    paramCvSet.active_count(-1 + paramCvSet.active_count());
  }
  
  @Namespace("cv")
  public static class Algorithm
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Algorithm()
    {
      allocate();
    }
    
    public Algorithm(Pointer paramPointer)
    {
      super();
    }
    
    @Ptr
    public static native Algorithm _create(String paramString);
    
    private native void allocate();
    
    public static native void getList(@ByRef opencv_core.StringVector paramStringVector);
    
    @Const
    @Ptr
    public native Algorithm getAlgorithm(String paramString);
    
    @Cast({"bool"})
    public native boolean getBool(String paramString);
    
    public native double getDouble(String paramString);
    
    public native int getInt(String paramString);
    
    @OutputMat
    public native CvMat getMat(String paramString);
    
    @ByVal
    public native opencv_core.MatVector getMatVector(String paramString);
    
    public native void getParams(@ByRef opencv_core.StringVector paramStringVector);
    
    @ByRef
    public native String getString(String paramString);
    
    public native AlgorithmInfo info();
    
    @ByRef
    public native String name();
    
    @ByRef
    public native String paramHelp(String paramString);
    
    public native int paramType(String paramString);
    
    public native void read(@Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode);
    
    public native void set(String paramString, double paramDouble);
    
    public native void set(String paramString, int paramInt);
    
    public native void set(String paramString, @Ptr Algorithm paramAlgorithm);
    
    public native void set(String paramString, CvMat paramCvMat);
    
    public native void set(String paramString, @ByRef opencv_core.MatVector paramMatVector);
    
    public native void set(String paramString1, String paramString2);
    
    public native void set(String paramString, @Cast({"bool"}) boolean paramBoolean);
    
    public native void write(@Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
    
    public static class Constructor
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Constructor()
      {
        allocate();
      }
      
      public Constructor(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native Algorithm call();
    }
    
    @Const
    @Namespace("cv::Algorithm")
    public static class Getter
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      public Getter(Pointer paramPointer)
      {
        super();
      }
      
      public native int call(Algorithm paramAlgorithm);
    }
    
    @Namespace("cv::Algorithm")
    public static class Setter
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      public Setter(Pointer paramPointer)
      {
        super();
      }
      
      public native void call(Algorithm paramAlgorithm, int paramInt);
    }
  }
  
  @Namespace("cv")
  public static class AlgorithmInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AlgorithmInfo(Pointer paramPointer)
    {
      super();
    }
    
    public AlgorithmInfo(String paramString, Algorithm.Constructor paramConstructor)
    {
      allocate(paramString, paramConstructor);
    }
    
    private native void allocate(String paramString, Algorithm.Constructor paramConstructor);
    
    public native void addParam_(@ByRef opencv_core.Algorithm paramAlgorithm, String paramString1, int paramInt, Pointer paramPointer, @Cast({"bool"}) boolean paramBoolean, Algorithm.Getter paramGetter, Algorithm.Setter paramSetter, String paramString2);
    
    public native void get(Algorithm paramAlgorithm, String paramString, int paramInt, Pointer paramPointer);
    
    public native void getParams(@ByRef opencv_core.StringVector paramStringVector);
    
    @ByRef
    public native String name();
    
    @ByRef
    public native String paramHelp(String paramString);
    
    public native int paramType(String paramString);
    
    public native void read(Algorithm paramAlgorithm, @Adapter(argc=2, value="FileNodeAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode);
    
    public native void write(Algorithm paramAlgorithm, @Adapter("FileStorageAdapter") @Const opencv_core.CvFileStorage paramCvFileStorage);
  }
  
  @Name({"std::vector<std::vector<char> >"})
  public static class ByteVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ByteVectorVector()
    {
      allocate();
    }
    
    public ByteVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public ByteVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native byte get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native ByteVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, byte paramByte);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  public static class Cv32suf
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Cv32suf()
    {
      allocate();
    }
    
    public Cv32suf(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Cv32suf(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float f();
    
    public native Cv32suf f(float paramFloat);
    
    public native int i();
    
    public native Cv32suf i(int paramInt);
    
    public Cv32suf position(int paramInt)
    {
      return (Cv32suf)super.position(paramInt);
    }
    
    public native int u();
    
    public native Cv32suf u(int paramInt);
  }
  
  public static class Cv64suf
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Cv64suf()
    {
      allocate();
    }
    
    public Cv64suf(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public Cv64suf(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double f();
    
    public native Cv64suf f(double paramDouble);
    
    public native long i();
    
    public native Cv64suf i(long paramLong);
    
    public Cv64suf position(int paramInt)
    {
      return (Cv64suf)super.position(paramInt);
    }
    
    public native long u();
    
    public native Cv64suf u(long paramLong);
  }
  
  public static class CvAllocFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvAllocFunc()
    {
      allocate();
    }
    
    public CvAllocFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native Pointer call(@Cast({"size_t"}) long paramLong, Pointer paramPointer);
  }
  
  @Opaque
  public static class CvArr
    extends Pointer
    implements Cloneable
  {
    static
    {
      Loader.load();
    }
    
    protected CvArr() {}
    
    protected CvArr(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Name({"CvArr*"})
  public static class CvArrArray
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvArrArray(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvArrArray(Pointer paramPointer)
    {
      super();
    }
    
    public CvArrArray(CvArr... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
      position(0);
    }
    
    private native void allocateArray(int paramInt);
    
    public native CvArr get();
    
    public CvArrArray position(int paramInt)
    {
      return (CvArrArray)super.position(paramInt);
    }
    
    public native CvArrArray put(CvArr paramCvArr);
    
    public CvArrArray put(CvArr... paramVarArgs)
    {
      for (int i = 0; i < paramVarArgs.length; i++) {
        position(i).put(paramVarArgs[i]);
      }
      return this;
    }
  }
  
  public static class CvAttrList
    extends Pointer
  {
    public static final CvAttrList EMPTY = new CvAttrList();
    
    static
    {
      Loader.load();
    }
    
    public CvAttrList()
    {
      allocate();
    }
    
    public CvAttrList(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvAttrList(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"const char**"})
    public native PointerPointer attr();
    
    public native CvAttrList attr(PointerPointer paramPointerPointer);
    
    public native CvAttrList next();
    
    public native CvAttrList next(CvAttrList paramCvAttrList);
    
    public CvAttrList position(int paramInt)
    {
      return (CvAttrList)super.position(paramInt);
    }
  }
  
  public static class CvBox2D
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvBox2D()
    {
      allocate();
    }
    
    public CvBox2D(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBox2D(Pointer paramPointer)
    {
      super();
    }
    
    public CvBox2D(CvPoint2D32f paramCvPoint2D32f, CvSize2D32f paramCvSize2D32f, float paramFloat)
    {
      allocate();
      center(paramCvPoint2D32f).size(paramCvSize2D32f).angle(paramFloat);
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float angle();
    
    public native CvBox2D angle(float paramFloat);
    
    public native CvBox2D center(CvPoint2D32f paramCvPoint2D32f);
    
    @ByRef
    public native opencv_core.CvPoint2D32f center();
    
    public CvBox2D position(int paramInt)
    {
      return (CvBox2D)super.position(paramInt);
    }
    
    public native CvBox2D size(CvSize2D32f paramCvSize2D32f);
    
    @ByRef
    public native opencv_core.CvSize2D32f size();
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + center() + ", " + size() + ", " + angle() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + center() + ", " + size() + ", " + angle() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
  }
  
  public static class CvChain
    extends CvSeq
  {
    public CvChain()
    {
      allocate();
    }
    
    public CvChain(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvChain(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvChain origin(CvPoint paramCvPoint);
    
    @ByRef
    public native opencv_core.CvPoint origin();
    
    public CvChain position(int paramInt)
    {
      return (CvChain)super.position(paramInt);
    }
  }
  
  public static class CvCloneFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvCloneFunc()
    {
      allocate();
    }
    
    public CvCloneFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native Pointer call(@Const Pointer paramPointer);
  }
  
  public static class CvCmpFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvCmpFunc()
    {
      allocate();
    }
    
    public CvCmpFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(@Const Pointer paramPointer1, @Const Pointer paramPointer2, Pointer paramPointer3);
  }
  
  public static class CvContour
    extends CvSeq
  {
    public CvContour()
    {
      allocate();
    }
    
    public CvContour(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvContour(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int color();
    
    public native CvContour color(int paramInt);
    
    public CvContour position(int paramInt)
    {
      return (CvContour)super.position(paramInt);
    }
    
    public native CvContour rect(CvRect paramCvRect);
    
    @ByRef
    public native opencv_core.CvRect rect();
    
    public native int reserved(int paramInt);
    
    public native CvContour reserved(int paramInt1, int paramInt2);
  }
  
  public static class CvErrorCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvErrorCallback()
    {
      allocate();
    }
    
    public CvErrorCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
  }
  
  public static class CvFileNode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFileNode()
    {
      allocate();
    }
    
    public CvFileNode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFileNode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Name({"data.f"})
    public native double data_f();
    
    public native CvFileNode data_f(double paramDouble);
    
    @Name({"data.i"})
    public native int data_i();
    
    public native CvFileNode data_i(int paramInt);
    
    public native CvFileNode data_map(CvFileNodeHash paramCvFileNodeHash);
    
    @Name({"data.map"})
    public native opencv_core.CvFileNodeHash data_map();
    
    public native CvFileNode data_seq(CvSeq paramCvSeq);
    
    @Name({"data.seq"})
    public native opencv_core.CvSeq data_seq();
    
    public native CvFileNode data_str(CvString paramCvString);
    
    @ByRef
    @Name({"data.str"})
    public native opencv_core.CvString data_str();
    
    public native CvFileNode info(CvTypeInfo paramCvTypeInfo);
    
    public native CvTypeInfo info();
    
    public CvFileNode position(int paramInt)
    {
      return (CvFileNode)super.position(paramInt);
    }
    
    public native int tag();
    
    public native CvFileNode tag(int paramInt);
  }
  
  @Opaque
  public static class CvFileNodeHash
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFileNodeHash() {}
    
    public CvFileNodeHash(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Opaque
  public static class CvFileStorage
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFileStorage() {}
    
    public CvFileStorage(Pointer paramPointer)
    {
      super();
    }
    
    public static CvFileStorage open(String paramString, CvMemStorage paramCvMemStorage, int paramInt)
    {
      return open(paramString, paramCvMemStorage, paramInt, null);
    }
    
    public static CvFileStorage open(String paramString1, CvMemStorage paramCvMemStorage, int paramInt, String paramString2)
    {
      CvFileStorage localCvFileStorage = opencv_core.cvOpenFileStorage(paramString1, paramCvMemStorage, paramInt, paramString2);
      if (localCvFileStorage != null) {
        localCvFileStorage.deallocator(new ReleaseDeallocator(localCvFileStorage));
      }
      return localCvFileStorage;
    }
    
    public void release()
    {
      deallocate();
    }
    
    protected static class ReleaseDeallocator
      extends CvFileStorage
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvFileStorage paramCvFileStorage)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseFileStorage(this);
      }
    }
  }
  
  public static class CvFont
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvFont()
    {
      allocate();
    }
    
    public CvFont(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvFont(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt2, int paramInt3)
    {
      allocate();
      opencv_core.cvInitFont(this, paramInt1, paramDouble1, paramDouble2, paramDouble3, paramInt2, paramInt3);
    }
    
    public CvFont(int paramInt1, double paramDouble, int paramInt2)
    {
      allocate();
      opencv_core.cvInitFont(this, paramInt1, paramDouble, paramDouble, 0.0D, paramInt2, 16);
    }
    
    public CvFont(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Const
    public native IntPointer ascii();
    
    public native CvFont ascii(IntPointer paramIntPointer);
    
    public native CvFont color(CvScalar paramCvScalar);
    
    @ByRef
    public native opencv_core.CvScalar color();
    
    @Const
    public native IntPointer cyrillic();
    
    public native CvFont cyrillic(IntPointer paramIntPointer);
    
    public native float dx();
    
    public native CvFont dx(float paramFloat);
    
    public native int font_face();
    
    public native CvFont font_face(int paramInt);
    
    @Const
    public native IntPointer greek();
    
    public native CvFont greek(IntPointer paramIntPointer);
    
    public native float hscale();
    
    public native CvFont hscale(float paramFloat);
    
    public native int line_type();
    
    public native CvFont line_type(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer nameFont();
    
    public native CvFont nameFont(BytePointer paramBytePointer);
    
    public CvFont position(int paramInt)
    {
      return (CvFont)super.position(paramInt);
    }
    
    public native float shear();
    
    public native CvFont shear(float paramFloat);
    
    public native int thickness();
    
    public native CvFont thickness(int paramInt);
    
    public native float vscale();
    
    public native CvFont vscale(float paramFloat);
  }
  
  public static class CvFreeFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvFreeFunc()
    {
      allocate();
    }
    
    public CvFreeFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(Pointer paramPointer1, Pointer paramPointer2);
  }
  
  public static class CvGraph
    extends CvSet
  {
    public CvGraph()
    {
      allocate();
      zero();
    }
    
    public CvGraph(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvGraph(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvGraph create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CvMemStorage paramCvMemStorage)
    {
      return opencv_core.cvCreateGraph(paramInt1, paramInt2, paramInt3, paramInt4, paramCvMemStorage);
    }
    
    public native CvGraph edges(CvSet paramCvSet);
    
    public native CvSet edges();
    
    public CvGraph position(int paramInt)
    {
      return (CvGraph)super.position(paramInt);
    }
  }
  
  public static class CvGraphEdge
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvGraphEdge()
    {
      allocate();
    }
    
    public CvGraphEdge(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGraphEdge(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int flags();
    
    public native CvGraphEdge flags(int paramInt);
    
    public native CvGraphEdge next(int paramInt);
    
    public native CvGraphEdge next(int paramInt, CvGraphEdge paramCvGraphEdge);
    
    public CvGraphEdge position(int paramInt)
    {
      return (CvGraphEdge)super.position(paramInt);
    }
    
    public native CvGraphEdge vtx(int paramInt, CvGraphVtx paramCvGraphVtx);
    
    public native CvGraphVtx vtx(int paramInt);
    
    public native float weight();
    
    public native CvGraphEdge weight(float paramFloat);
  }
  
  public static class CvGraphScanner
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvGraphScanner()
    {
      allocate();
      zero();
    }
    
    public CvGraphScanner(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvGraphScanner(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvGraphScanner create(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx, int paramInt)
    {
      CvGraphScanner localCvGraphScanner = opencv_core.cvCreateGraphScanner(paramCvGraph, paramCvGraphVtx, paramInt);
      if (localCvGraphScanner != null) {
        localCvGraphScanner.deallocator(new ReleaseDeallocator(localCvGraphScanner));
      }
      return localCvGraphScanner;
    }
    
    public native CvGraphScanner dst(CvGraphVtx paramCvGraphVtx);
    
    public native CvGraphVtx dst();
    
    public native CvGraphEdge edge();
    
    public native CvGraphScanner edge(CvGraphEdge paramCvGraphEdge);
    
    public native CvGraph graph();
    
    public native CvGraphScanner graph(CvGraph paramCvGraph);
    
    public native int index();
    
    public native CvGraphScanner index(int paramInt);
    
    public native int mask();
    
    public native CvGraphScanner mask(int paramInt);
    
    public CvGraphScanner position(int paramInt)
    {
      return (CvGraphScanner)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    public native CvGraphScanner stack(CvSeq paramCvSeq);
    
    public native CvSeq stack();
    
    public native CvGraphScanner vtx(CvGraphVtx paramCvGraphVtx);
    
    public native CvGraphVtx vtx();
    
    protected static class ReleaseDeallocator
      extends CvGraphScanner
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvGraphScanner paramCvGraphScanner)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseGraphScanner(this);
      }
    }
  }
  
  public static class CvGraphVtx
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvGraphVtx()
    {
      allocate();
    }
    
    public CvGraphVtx(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGraphVtx(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvGraphEdge first();
    
    public native CvGraphVtx first(CvGraphEdge paramCvGraphEdge);
    
    public native int flags();
    
    public native CvGraphVtx flags(int paramInt);
    
    public CvGraphVtx position(int paramInt)
    {
      return (CvGraphVtx)super.position(paramInt);
    }
  }
  
  public static class CvGraphVtx2D
    extends CvGraphVtx
  {
    public CvGraphVtx2D()
    {
      allocate();
    }
    
    public CvGraphVtx2D(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGraphVtx2D(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvGraphVtx2D position(int paramInt)
    {
      return (CvGraphVtx2D)super.position(paramInt);
    }
    
    public native CvGraphVtx2D ptr(CvPoint2D32f paramCvPoint2D32f);
    
    public native CvPoint2D32f ptr();
  }
  
  public static class CvIsInstanceFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvIsInstanceFunc()
    {
      allocate();
    }
    
    public CvIsInstanceFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(@Const Pointer paramPointer);
  }
  
  public static class CvLineIterator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvLineIterator()
    {
      allocate();
    }
    
    public CvLineIterator(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvLineIterator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int err();
    
    public native CvLineIterator err(int paramInt);
    
    public native int minus_delta();
    
    public native CvLineIterator minus_delta(int paramInt);
    
    public native int minus_step();
    
    public native CvLineIterator minus_step(int paramInt);
    
    public native int plus_delta();
    
    public native CvLineIterator plus_delta(int paramInt);
    
    public native int plus_step();
    
    public native CvLineIterator plus_step(int paramInt);
    
    public CvLineIterator position(int paramInt)
    {
      return (CvLineIterator)super.position(paramInt);
    }
    
    @Cast({"uchar*"})
    public native BytePointer ptr();
    
    public native CvLineIterator ptr(BytePointer paramBytePointer);
  }
  
  public static class CvMat
    extends CvArr
  {
    private ByteBuffer byteBuffer = null;
    private DoubleBuffer doubleBuffer = null;
    private FloatBuffer floatBuffer = null;
    private int fullSize = 0;
    private IntBuffer intBuffer = null;
    private ShortBuffer shortBuffer = null;
    
    static
    {
      if (!opencv_core.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public CvMat()
    {
      allocate();
      zero();
    }
    
    public CvMat(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvMat(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvMat create(int paramInt1, int paramInt2)
    {
      return create(paramInt1, paramInt2, 6, 1);
    }
    
    public static CvMat create(int paramInt1, int paramInt2, int paramInt3)
    {
      CvMat localCvMat = opencv_core.cvCreateMat(paramInt1, paramInt2, paramInt3);
      if (localCvMat != null)
      {
        localCvMat.fullSize = localCvMat.size();
        localCvMat.deallocator(new ReleaseDeallocator(localCvMat));
      }
      return localCvMat;
    }
    
    public static CvMat create(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return create(paramInt1, paramInt2, opencv_core.CV_MAKETYPE(paramInt3, paramInt4));
    }
    
    public static CvMat createHeader(int paramInt1, int paramInt2)
    {
      return createHeader(paramInt1, paramInt2, 6, 1);
    }
    
    public static CvMat createHeader(int paramInt1, int paramInt2, int paramInt3)
    {
      CvMat localCvMat = opencv_core.cvCreateMatHeader(paramInt1, paramInt2, paramInt3);
      if (localCvMat != null)
      {
        localCvMat.fullSize = localCvMat.size();
        localCvMat.deallocator(new ReleaseDeallocator(localCvMat));
      }
      return localCvMat;
    }
    
    public static CvMat createHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return createHeader(paramInt1, paramInt2, opencv_core.CV_MAKETYPE(paramInt3, paramInt4));
    }
    
    public static ThreadLocal<CvMat> createHeaderThreadLocal(int paramInt1, int paramInt2)
    {
      return createHeaderThreadLocal(paramInt1, paramInt2, 6, 1);
    }
    
    public static ThreadLocal<CvMat> createHeaderThreadLocal(int paramInt1, final int paramInt2, final int paramInt3)
    {
      new ThreadLocal()
      {
        protected CvMat initialValue()
        {
          return CvMat.createHeader(this.val$rows, paramInt2, paramInt3);
        }
      };
    }
    
    public static ThreadLocal<CvMat> createHeaderThreadLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return createHeaderThreadLocal(paramInt1, paramInt2, opencv_core.CV_MAKETYPE(paramInt3, paramInt4));
    }
    
    public static ThreadLocal<CvMat> createThreadLocal(int paramInt1, int paramInt2)
    {
      return createThreadLocal(paramInt1, paramInt2, 6, 1);
    }
    
    public static ThreadLocal<CvMat> createThreadLocal(int paramInt1, final int paramInt2, final int paramInt3)
    {
      new ThreadLocal()
      {
        protected CvMat initialValue()
        {
          return CvMat.create(this.val$rows, paramInt2, paramInt3);
        }
      };
    }
    
    public static ThreadLocal<CvMat> createThreadLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return createThreadLocal(paramInt1, paramInt2, opencv_core.CV_MAKETYPE(paramInt3, paramInt4));
    }
    
    private int fullSize()
    {
      if (this.fullSize > 0) {
        return this.fullSize;
      }
      int i = size();
      this.fullSize = i;
      return i;
    }
    
    public IplImage asIplImage()
    {
      IplImage localIplImage = new IplImage();
      opencv_core.cvGetImage(this, localIplImage);
      return localIplImage;
    }
    
    public int channels()
    {
      return opencv_core.CV_MAT_CN(type());
    }
    
    public CvMat clone()
    {
      CvMat localCvMat = opencv_core.cvCloneMat(this);
      if (localCvMat != null) {
        localCvMat.deallocator(new ReleaseDeallocator(localCvMat));
      }
      return localCvMat;
    }
    
    public native int cols();
    
    public native CvMat cols(int paramInt);
    
    public CvSize cvSize()
    {
      return opencv_core.cvSize(cols(), rows());
    }
    
    @Name({"data.db"})
    public native DoublePointer data_db();
    
    public native CvMat data_db(DoublePointer paramDoublePointer);
    
    @Name({"data.fl"})
    public native FloatPointer data_fl();
    
    public native CvMat data_fl(FloatPointer paramFloatPointer);
    
    @Name({"data.i"})
    public native IntPointer data_i();
    
    public native CvMat data_i(IntPointer paramIntPointer);
    
    @Cast({"uchar*"})
    @Name({"data.ptr"})
    public native BytePointer data_ptr();
    
    public native CvMat data_ptr(BytePointer paramBytePointer);
    
    @Name({"data.s"})
    public native ShortPointer data_s();
    
    public native CvMat data_s(ShortPointer paramShortPointer);
    
    public int depth()
    {
      return opencv_core.CV_MAT_DEPTH(type());
    }
    
    public int elemSize()
    {
      switch (depth())
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
        break;
      case 0: 
      case 1: 
        return 1;
      case 2: 
      case 3: 
        return 2;
      case 4: 
      case 5: 
        return 4;
      case 6: 
        return 8;
      }
      return 0;
    }
    
    public boolean empty()
    {
      return length() == 0;
    }
    
    public double get(int paramInt)
    {
      switch (depth())
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
        break;
      case 0: 
        return 0xFF & getByteBuffer().get(paramInt);
      case 1: 
        return getByteBuffer().get(paramInt);
      case 2: 
        return 0xFFFF & getShortBuffer().get(paramInt);
      case 3: 
        return getShortBuffer().get(paramInt);
      case 4: 
        return getIntBuffer().get(paramInt);
      case 5: 
        return getFloatBuffer().get(paramInt);
      case 6: 
        return getDoubleBuffer().get(paramInt);
      }
      return NaN.0D;
    }
    
    public double get(int paramInt1, int paramInt2)
    {
      return get(paramInt1 * step() / elemSize() + paramInt2 * channels());
    }
    
    public double get(int paramInt1, int paramInt2, int paramInt3)
    {
      return get(paramInt3 + (paramInt1 * step() / elemSize() + paramInt2 * channels()));
    }
    
    public CvMat get(int paramInt, double[] paramArrayOfDouble)
    {
      return get(paramInt, paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    public CvMat get(int paramInt1, double[] paramArrayOfDouble, int paramInt2, int paramInt3)
    {
      int i;
      try
      {
        i = depth();
        switch (i)
        {
        default: 
          if ($assertionsDisabled) {
            break label304;
          }
          throw new AssertionError();
        }
      }
      finally {}
      ByteBuffer localByteBuffer = getByteBuffer();
      localByteBuffer.position(paramInt1);
      int n = 0;
      ShortBuffer localShortBuffer;
      if (n < paramInt3)
      {
        if (i == 0)
        {
          paramArrayOfDouble[(n + paramInt2)] = (0xFF & localByteBuffer.get(n));
          break label308;
        }
        paramArrayOfDouble[(n + paramInt2)] = localByteBuffer.get(n);
        break label308;
        localShortBuffer = getShortBuffer();
        localShortBuffer.position(paramInt1);
      }
      for (int m = 0;; m++) {
        if (m < paramInt3)
        {
          if (i == 2)
          {
            paramArrayOfDouble[(m + paramInt2)] = (0xFFFF & localShortBuffer.get());
          }
          else
          {
            paramArrayOfDouble[(m + paramInt2)] = localShortBuffer.get();
            continue;
            IntBuffer localIntBuffer = getIntBuffer();
            localIntBuffer.position(paramInt1);
            int k = 0;
            while (k < paramInt3)
            {
              paramArrayOfDouble[(k + paramInt2)] = localIntBuffer.get();
              k++;
              continue;
              FloatBuffer localFloatBuffer = getFloatBuffer();
              localFloatBuffer.position(paramInt1);
              int j = 0;
              while (j < paramInt3)
              {
                paramArrayOfDouble[(j + paramInt2)] = localFloatBuffer.get();
                j++;
                continue;
                getDoubleBuffer().position(paramInt1);
                getDoubleBuffer().get(paramArrayOfDouble, paramInt2, paramInt3);
              }
            }
          }
        }
        else
        {
          label304:
          return this;
          label308:
          n++;
          break;
        }
      }
    }
    
    public CvMat get(double[] paramArrayOfDouble)
    {
      return get(0, paramArrayOfDouble);
    }
    
    public double[] get()
    {
      double[] arrayOfDouble = new double[fullSize() / elemSize()];
      get(arrayOfDouble);
      return arrayOfDouble;
    }
    
    public ByteBuffer getByteBuffer()
    {
      if (this.byteBuffer == null) {
        this.byteBuffer = data_ptr().capacity(fullSize()).asBuffer();
      }
      this.byteBuffer.position(0);
      return this.byteBuffer;
    }
    
    public DoubleBuffer getDoubleBuffer()
    {
      if (this.doubleBuffer == null) {
        this.doubleBuffer = data_db().capacity(fullSize() / 8).asBuffer();
      }
      this.doubleBuffer.position(0);
      return this.doubleBuffer;
    }
    
    public FloatBuffer getFloatBuffer()
    {
      if (this.floatBuffer == null) {
        this.floatBuffer = data_fl().capacity(fullSize() / 4).asBuffer();
      }
      this.floatBuffer.position(0);
      return this.floatBuffer;
    }
    
    public IntBuffer getIntBuffer()
    {
      if (this.intBuffer == null) {
        this.intBuffer = data_i().capacity(fullSize() / 4).asBuffer();
      }
      this.intBuffer.position(0);
      return this.intBuffer;
    }
    
    public ShortBuffer getShortBuffer()
    {
      if (this.shortBuffer == null) {
        this.shortBuffer = data_s().capacity(fullSize() / 2).asBuffer();
      }
      this.shortBuffer.position(0);
      return this.shortBuffer;
    }
    
    public native int hdr_refcount();
    
    public native CvMat hdr_refcount(int paramInt);
    
    public boolean isContinuous()
    {
      return opencv_core.CV_IS_MAT_CONT(type());
    }
    
    public int length()
    {
      return rows() * cols();
    }
    
    public int nChannels()
    {
      return opencv_core.CV_MAT_CN(type());
    }
    
    public CvMat position(int paramInt)
    {
      return (CvMat)super.position(paramInt);
    }
    
    public CvMat put(int paramInt, double paramDouble)
    {
      switch (depth())
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
      case 0: 
      case 1: 
        getByteBuffer().put(paramInt, (byte)(int)paramDouble);
        return this;
      case 2: 
      case 3: 
        getShortBuffer().put(paramInt, (short)(int)paramDouble);
        return this;
      case 4: 
        getIntBuffer().put(paramInt, (int)paramDouble);
        return this;
      case 5: 
        getFloatBuffer().put(paramInt, (float)paramDouble);
        return this;
      }
      getDoubleBuffer().put(paramInt, paramDouble);
      return this;
    }
    
    public CvMat put(int paramInt1, int paramInt2, double paramDouble)
    {
      return put(paramInt1 * step() / elemSize() + paramInt2 * channels(), paramDouble);
    }
    
    public CvMat put(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
    {
      return put(paramInt3 + (paramInt1 * step() / elemSize() + paramInt2 * channels()), paramDouble);
    }
    
    public CvMat put(int paramInt1, int paramInt2, int paramInt3, CvMat paramCvMat, int paramInt4, int paramInt5, int paramInt6)
    {
      for (;;)
      {
        int i;
        int j;
        int k;
        int m;
        int i1;
        int n;
        try
        {
          if ((rows() == paramCvMat.rows()) && (cols() == paramCvMat.cols()) && (step() == paramCvMat.step()) && (type() == paramCvMat.type()) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0) && (paramInt5 == 0) && (paramInt6 == 0))
          {
            getByteBuffer().clear();
            paramCvMat.getByteBuffer().clear();
            getByteBuffer().put(paramCvMat.getByteBuffer());
            return this;
          }
          i = Math.min(rows() - paramInt1, paramCvMat.rows() - paramInt4);
          j = Math.min(cols() - paramInt2, paramCvMat.cols() - paramInt5);
          k = Math.min(channels() - paramInt3, paramCvMat.channels() - paramInt6);
          m = 0;
        }
        finally {}
        if (i1 < k)
        {
          put(m + paramInt1, n + paramInt2, i1 + paramInt3, paramCvMat.get(m + paramInt4, n + paramInt5, i1 + paramInt6));
          i1++;
        }
        else
        {
          n++;
          break label253;
          m++;
          if (m < i)
          {
            n = 0;
            label253:
            if (n < j) {
              i1 = 0;
            }
          }
        }
      }
    }
    
    public CvMat put(int paramInt, double... paramVarArgs)
    {
      return put(paramInt, paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvMat put(int paramInt1, double[] paramArrayOfDouble, int paramInt2, int paramInt3)
    {
      try
      {
        switch (depth())
        {
        default: 
          if ($assertionsDisabled) {
            break label262;
          }
          throw new AssertionError();
        }
      }
      finally {}
      ByteBuffer localByteBuffer = getByteBuffer();
      localByteBuffer.position(paramInt1);
      int m = 0;
      while (m < paramInt3)
      {
        localByteBuffer.put((byte)(int)paramArrayOfDouble[(m + paramInt2)]);
        m++;
        continue;
        ShortBuffer localShortBuffer = getShortBuffer();
        localShortBuffer.position(paramInt1);
        int k = 0;
        while (k < paramInt3)
        {
          localShortBuffer.put((short)(int)paramArrayOfDouble[(k + paramInt2)]);
          k++;
          continue;
          IntBuffer localIntBuffer = getIntBuffer();
          localIntBuffer.position(paramInt1);
          int j = 0;
          while (j < paramInt3)
          {
            localIntBuffer.put((int)paramArrayOfDouble[(j + paramInt2)]);
            j++;
            continue;
            FloatBuffer localFloatBuffer = getFloatBuffer();
            localFloatBuffer.position(paramInt1);
            int i = 0;
            while (i < paramInt3)
            {
              localFloatBuffer.put((float)paramArrayOfDouble[(i + paramInt2)]);
              i++;
              continue;
              DoubleBuffer localDoubleBuffer = getDoubleBuffer();
              localDoubleBuffer.position(paramInt1);
              localDoubleBuffer.put(paramArrayOfDouble, paramInt2, paramInt3);
            }
          }
        }
      }
      label262:
      return this;
    }
    
    public CvMat put(CvMat paramCvMat)
    {
      return put(0, 0, 0, paramCvMat, 0, 0, 0);
    }
    
    public CvMat put(double... paramVarArgs)
    {
      return put(0, paramVarArgs);
    }
    
    @Name({"type"})
    public native int raw_type();
    
    public native CvMat raw_type(int paramInt);
    
    public native IntPointer refcount();
    
    public native CvMat refcount(IntPointer paramIntPointer);
    
    public void release()
    {
      deallocate();
    }
    
    public void reset()
    {
      this.fullSize = 0;
      this.byteBuffer = null;
      this.shortBuffer = null;
      this.intBuffer = null;
      this.floatBuffer = null;
      this.doubleBuffer = null;
    }
    
    public native int rows();
    
    public native CvMat rows(int paramInt);
    
    public int size()
    {
      if (rows() > 1) {
        return step() * rows();
      }
      return cols() * elemSize() * channels();
    }
    
    public native int step();
    
    public native CvMat step(int paramInt);
    
    public String toString()
    {
      return toString(0);
    }
    
    public String toString(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder("[ ");
      int i = channels();
      for (int j = 0; j < rows(); j++)
      {
        for (int k = 0; k < cols(); k++)
        {
          CvScalar localCvScalar = opencv_core.cvGet2D(this, j, k);
          if (i > 1) {
            localStringBuilder.append("(");
          }
          for (int n = 0; n < i; n++)
          {
            localStringBuilder.append((float)localCvScalar.val(n));
            if (n < i - 1) {
              localStringBuilder.append(", ");
            }
          }
          if (i > 1) {
            localStringBuilder.append(")");
          }
          if (k < -1 + cols()) {
            localStringBuilder.append(", ");
          }
        }
        if (j < -1 + rows())
        {
          localStringBuilder.append("\n  ");
          for (int m = 0; m < paramInt; m++) {
            localStringBuilder.append(' ');
          }
        }
      }
      localStringBuilder.append(" ]");
      return localStringBuilder.toString();
    }
    
    public int total()
    {
      return rows() * cols();
    }
    
    public int type()
    {
      return opencv_core.CV_MAT_TYPE(raw_type());
    }
    
    public void type(int paramInt1, int paramInt2)
    {
      raw_type(0x42420000 | opencv_core.CV_MAKETYPE(paramInt1, paramInt2));
    }
    
    protected static class ReleaseDeallocator
      extends CvMat
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvMat paramCvMat)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseMat(this);
      }
    }
  }
  
  @Name({"CvMat*"})
  public static class CvMatArray
    extends CvArrArray
  {
    public CvMatArray(int paramInt)
    {
      super();
      allocateArray(paramInt);
    }
    
    public CvMatArray(Pointer paramPointer)
    {
      super();
    }
    
    public CvMatArray(CvMat... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
      position(0);
    }
    
    private native void allocateArray(int paramInt);
    
    @ValueGetter
    public native opencv_core.CvMat get();
    
    public CvMatArray position(int paramInt)
    {
      return (CvMatArray)super.position(paramInt);
    }
    
    public CvMatArray put(CvArr paramCvArr)
    {
      if ((paramCvArr instanceof CvMat)) {
        return (CvMatArray)super.put(paramCvArr);
      }
      throw new ArrayStoreException(paramCvArr.getClass().getName());
    }
    
    public CvMatArray put(CvArr... paramVarArgs)
    {
      return (CvMatArray)super.put(paramVarArgs);
    }
  }
  
  public static class CvMatND
    extends CvArr
  {
    public CvMatND()
    {
      allocate();
      zero();
    }
    
    public CvMatND(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvMatND(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvMatND create(int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      CvMatND localCvMatND = opencv_core.cvCreateMatND(paramInt1, paramArrayOfInt, paramInt2);
      if (localCvMatND != null) {
        localCvMatND.deallocator(new ReleaseDeallocator(localCvMatND));
      }
      return localCvMatND;
    }
    
    public CvMatND clone()
    {
      CvMatND localCvMatND = opencv_core.cvCloneMatND(this);
      if (localCvMatND != null) {
        localCvMatND.deallocator(new ReleaseDeallocator(localCvMatND));
      }
      return localCvMatND;
    }
    
    @Name({"data.db"})
    public native DoublePointer data_db();
    
    public native CvMatND data_db(DoublePointer paramDoublePointer);
    
    @Name({"data.fl"})
    public native FloatPointer data_fl();
    
    public native CvMatND data_fl(FloatPointer paramFloatPointer);
    
    @Name({"data.i"})
    public native IntPointer data_i();
    
    public native CvMatND data_i(IntPointer paramIntPointer);
    
    @Cast({"uchar*"})
    @Name({"data.ptr"})
    public native BytePointer data_ptr();
    
    public native CvMatND data_ptr(BytePointer paramBytePointer);
    
    @Name({"data.s"})
    public native ShortPointer data_s();
    
    public native CvMatND data_s(ShortPointer paramShortPointer);
    
    @Name({"dim", ".size"})
    public native int dim_size(int paramInt);
    
    public native CvMatND dim_size(int paramInt1, int paramInt2);
    
    @Name({"dim", ".step"})
    public native int dim_step(int paramInt);
    
    public native CvMatND dim_step(int paramInt1, int paramInt2);
    
    public native int dims();
    
    public native CvMatND dims(int paramInt);
    
    public native int hdr_refcount();
    
    public native CvMatND hdr_refcount(int paramInt);
    
    public CvMatND position(int paramInt)
    {
      return (CvMatND)super.position(paramInt);
    }
    
    public native IntPointer refcount();
    
    public native CvMatND refcount(IntPointer paramIntPointer);
    
    public void release()
    {
      deallocate();
    }
    
    public native int type();
    
    public native CvMatND type(int paramInt);
    
    protected static class ReleaseDeallocator
      extends CvMatND
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvMatND paramCvMatND)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseMatND(this);
      }
    }
  }
  
  @Name({"CvMatND*"})
  public static class CvMatNDArray
    extends CvArrArray
  {
    public CvMatNDArray(int paramInt)
    {
      super();
      allocateArray(paramInt);
    }
    
    public CvMatNDArray(Pointer paramPointer)
    {
      super();
    }
    
    public CvMatNDArray(CvMatND... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
      position(0);
    }
    
    private native void allocateArray(int paramInt);
    
    @ValueGetter
    public native opencv_core.CvMatND get();
    
    public CvMatNDArray position(int paramInt)
    {
      return (CvMatNDArray)super.position(paramInt);
    }
    
    public CvMatNDArray put(CvArr paramCvArr)
    {
      if ((paramCvArr instanceof CvMatND)) {
        return (CvMatNDArray)super.put(paramCvArr);
      }
      throw new ArrayStoreException(paramCvArr.getClass().getName());
    }
    
    public CvMatNDArray put(CvArr... paramVarArgs)
    {
      return (CvMatNDArray)super.put(paramVarArgs);
    }
  }
  
  public static class CvMemBlock
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvMemBlock()
    {
      allocate();
    }
    
    public CvMemBlock(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvMemBlock(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvMemBlock next();
    
    public native CvMemBlock next(CvMemBlock paramCvMemBlock);
    
    public CvMemBlock position(int paramInt)
    {
      return (CvMemBlock)super.position(paramInt);
    }
    
    public native CvMemBlock prev();
    
    public native CvMemBlock prev(CvMemBlock paramCvMemBlock);
  }
  
  public static class CvMemStorage
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvMemStorage()
    {
      allocate();
      zero();
    }
    
    public CvMemStorage(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvMemStorage(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvMemStorage create()
    {
      return create(0);
    }
    
    public static CvMemStorage create(int paramInt)
    {
      CvMemStorage localCvMemStorage = opencv_core.cvCreateMemStorage(paramInt);
      if (localCvMemStorage != null) {
        localCvMemStorage.deallocator(new ReleaseDeallocator(localCvMemStorage));
      }
      return localCvMemStorage;
    }
    
    public native int block_size();
    
    public native CvMemStorage block_size(int paramInt);
    
    public native CvMemBlock bottom();
    
    public native CvMemStorage bottom(CvMemBlock paramCvMemBlock);
    
    public native int free_space();
    
    public native CvMemStorage free_space(int paramInt);
    
    public native CvMemStorage parent();
    
    public native CvMemStorage parent(CvMemStorage paramCvMemStorage);
    
    public CvMemStorage position(int paramInt)
    {
      return (CvMemStorage)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    public native int signature();
    
    public native CvMemStorage signature(int paramInt);
    
    public native CvMemBlock top();
    
    public native CvMemStorage top(CvMemBlock paramCvMemBlock);
    
    protected static class ReleaseDeallocator
      extends CvMemStorage
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvMemStorage paramCvMemStorage)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseMemStorage(this);
      }
    }
  }
  
  public static class CvMemStoragePos
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvMemStoragePos()
    {
      allocate();
    }
    
    public CvMemStoragePos(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvMemStoragePos(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int free_space();
    
    public native CvMemStoragePos free_space(int paramInt);
    
    public CvMemStoragePos position(int paramInt)
    {
      return (CvMemStoragePos)super.position(paramInt);
    }
    
    public native CvMemBlock top();
    
    public native CvMemStoragePos top(CvMemBlock paramCvMemBlock);
  }
  
  public static class CvModuleInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvModuleInfo()
    {
      allocate();
    }
    
    public CvModuleInfo(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvModuleInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvModuleInfo func_tab(CvPluginFuncInfo paramCvPluginFuncInfo);
    
    public native CvPluginFuncInfo func_tab();
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native CvModuleInfo name(BytePointer paramBytePointer);
    
    public native CvModuleInfo next();
    
    public native CvModuleInfo next(CvModuleInfo paramCvModuleInfo);
    
    public CvModuleInfo position(int paramInt)
    {
      return (CvModuleInfo)super.position(paramInt);
    }
    
    @Cast({"const char*"})
    public native BytePointer version();
    
    public native CvModuleInfo version(BytePointer paramBytePointer);
  }
  
  public static class CvNArrayIterator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvNArrayIterator()
    {
      allocate();
    }
    
    public CvNArrayIterator(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvNArrayIterator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int count();
    
    public native CvNArrayIterator count(int paramInt);
    
    public native int dims();
    
    public native CvNArrayIterator dims(int paramInt);
    
    public native CvMatND hdr(int paramInt);
    
    public native CvNArrayIterator hdr(int paramInt, CvMatND paramCvMatND);
    
    public CvNArrayIterator position(int paramInt)
    {
      return (CvNArrayIterator)super.position(paramInt);
    }
    
    @Cast({"uchar*"})
    public native BytePointer ptr(int paramInt);
    
    public native CvNArrayIterator ptr(int paramInt, BytePointer paramBytePointer);
    
    public native CvNArrayIterator size(CvSize paramCvSize);
    
    @ByRef
    public native opencv_core.CvSize size();
    
    public native int stack(int paramInt);
    
    public native CvNArrayIterator stack(int paramInt1, int paramInt2);
  }
  
  public static class CvPluginFuncInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPluginFuncInfo()
    {
      allocate();
    }
    
    public CvPluginFuncInfo(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPluginFuncInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native Pointer default_func_addr();
    
    public native CvPluginFuncInfo default_func_addr(Pointer paramPointer);
    
    public native PointerPointer func_addr();
    
    public native CvPluginFuncInfo func_addr(PointerPointer paramPointerPointer);
    
    @Cast({"const char*"})
    public native BytePointer func_names();
    
    public native CvPluginFuncInfo func_names(BytePointer paramBytePointer);
    
    public native int loaded_from();
    
    public native CvPluginFuncInfo loaded_from(int paramInt);
    
    public CvPluginFuncInfo position(int paramInt)
    {
      return (CvPluginFuncInfo)super.position(paramInt);
    }
    
    public native int search_modules();
    
    public native CvPluginFuncInfo search_modules(int paramInt);
  }
  
  public static class CvPoint
    extends Pointer
  {
    public static final CvPoint ZERO = new CvPoint().x(0).y(0);
    
    static
    {
      Loader.load();
    }
    
    public CvPoint()
    {
      allocate();
    }
    
    public CvPoint(byte paramByte, double... paramVarArgs)
    {
      this(paramByte, paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvPoint(byte paramByte, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this(paramInt2 / 2);
      put(paramByte, paramArrayOfDouble, paramInt1, paramInt2);
    }
    
    public CvPoint(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPoint(Pointer paramPointer)
    {
      super();
    }
    
    public CvPoint(int... paramVarArgs)
    {
      this(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvPoint(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this(paramInt2 / 2);
      put(paramArrayOfInt, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvPoint get(int[] paramArrayOfInt)
    {
      return get(paramArrayOfInt, 0, paramArrayOfInt.length);
    }
    
    public CvPoint get(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 2; i++)
      {
        position(i);
        paramArrayOfInt[(paramInt1 + i * 2)] = x();
        paramArrayOfInt[(1 + (paramInt1 + i * 2))] = y();
      }
      return position(0);
    }
    
    public int[] get()
    {
      if (this.capacity == 0) {}
      for (int i = 2;; i = 2 * this.capacity)
      {
        int[] arrayOfInt = new int[i];
        get(arrayOfInt);
        return arrayOfInt;
      }
    }
    
    public CvPoint position(int paramInt)
    {
      return (CvPoint)super.position(paramInt);
    }
    
    public CvPoint put(byte paramByte, CvPoint2D32f paramCvPoint2D32f)
    {
      x(Math.round(paramCvPoint2D32f.x() * (1 << paramByte)));
      y(Math.round(paramCvPoint2D32f.y() * (1 << paramByte)));
      return this;
    }
    
    public CvPoint put(byte paramByte, CvPoint2D64f paramCvPoint2D64f)
    {
      x((int)Math.round(paramCvPoint2D64f.x() * (1 << paramByte)));
      y((int)Math.round(paramCvPoint2D64f.y() * (1 << paramByte)));
      return this;
    }
    
    public final CvPoint put(byte paramByte, double... paramVarArgs)
    {
      return put(paramByte, paramVarArgs, 0, paramVarArgs.length);
    }
    
    public final CvPoint put(byte paramByte, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = new int[paramInt2];
      for (int i = 0; i < paramInt2; i++) {
        arrayOfInt[i] = ((int)Math.round(paramArrayOfDouble[(paramInt1 + i)] * (1 << paramByte)));
      }
      return put(arrayOfInt, 0, paramInt2);
    }
    
    public CvPoint put(int paramInt1, int paramInt2)
    {
      return x(paramInt1).y(paramInt2);
    }
    
    public CvPoint put(CvPoint paramCvPoint)
    {
      return x(paramCvPoint.x()).y(paramCvPoint.y());
    }
    
    public final CvPoint put(int... paramVarArgs)
    {
      return put(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public final CvPoint put(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 2; i++) {
        position(i).put(paramArrayOfInt[(paramInt1 + i * 2)], paramArrayOfInt[(1 + (paramInt1 + i * 2))]);
      }
      return position(0);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + x() + ", " + y() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + x() + ", " + y() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native int x();
    
    public native CvPoint x(int paramInt);
    
    public native int y();
    
    public native CvPoint y(int paramInt);
  }
  
  public static class CvPoint2D32f
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPoint2D32f()
    {
      allocate();
    }
    
    public CvPoint2D32f(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPoint2D32f(Pointer paramPointer)
    {
      super();
    }
    
    public CvPoint2D32f(double... paramVarArgs)
    {
      this(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvPoint2D32f(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this(paramInt2 / 2);
      put(paramArrayOfDouble, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvPoint2D32f get(double[] paramArrayOfDouble)
    {
      return get(paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    public CvPoint2D32f get(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 2; i++)
      {
        position(i);
        paramArrayOfDouble[(paramInt1 + i * 2)] = x();
        paramArrayOfDouble[(1 + (paramInt1 + i * 2))] = y();
      }
      return position(0);
    }
    
    public double[] get()
    {
      if (this.capacity == 0) {}
      for (int i = 2;; i = 2 * this.capacity)
      {
        double[] arrayOfDouble = new double[i];
        get(arrayOfDouble);
        return arrayOfDouble;
      }
    }
    
    public CvPoint2D32f position(int paramInt)
    {
      return (CvPoint2D32f)super.position(paramInt);
    }
    
    public CvPoint2D32f put(double paramDouble1, double paramDouble2)
    {
      return x((float)paramDouble1).y((float)paramDouble2);
    }
    
    public CvPoint2D32f put(CvPoint2D32f paramCvPoint2D32f)
    {
      return x(paramCvPoint2D32f.x()).y(paramCvPoint2D32f.y());
    }
    
    public CvPoint2D32f put(CvPoint2D64f paramCvPoint2D64f)
    {
      return x((float)paramCvPoint2D64f.x()).y((float)paramCvPoint2D64f.y());
    }
    
    public CvPoint2D32f put(CvPoint paramCvPoint)
    {
      return x(paramCvPoint.x()).y(paramCvPoint.y());
    }
    
    public final CvPoint2D32f put(double... paramVarArgs)
    {
      return put(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public final CvPoint2D32f put(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 2; i++) {
        position(i).put(paramArrayOfDouble[(paramInt1 + i * 2)], paramArrayOfDouble[(1 + (paramInt1 + i * 2))]);
      }
      return position(0);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + x() + ", " + y() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + x() + ", " + y() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native float x();
    
    public native CvPoint2D32f x(float paramFloat);
    
    public native float y();
    
    public native CvPoint2D32f y(float paramFloat);
  }
  
  public static class CvPoint2D64f
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPoint2D64f()
    {
      allocate();
    }
    
    public CvPoint2D64f(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPoint2D64f(Pointer paramPointer)
    {
      super();
    }
    
    public CvPoint2D64f(double... paramVarArgs)
    {
      this(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvPoint2D64f(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this(paramInt2 / 2);
      put(paramArrayOfDouble, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvPoint2D64f get(double[] paramArrayOfDouble)
    {
      return get(paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    public CvPoint2D64f get(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 2; i++)
      {
        position(i);
        paramArrayOfDouble[(paramInt1 + i * 2)] = x();
        paramArrayOfDouble[(1 + (paramInt1 + i * 2))] = y();
      }
      return position(0);
    }
    
    public double[] get()
    {
      if (this.capacity == 0) {}
      for (int i = 2;; i = 2 * this.capacity)
      {
        double[] arrayOfDouble = new double[i];
        get(arrayOfDouble);
        return arrayOfDouble;
      }
    }
    
    public CvPoint2D64f position(int paramInt)
    {
      return (CvPoint2D64f)super.position(paramInt);
    }
    
    public CvPoint2D64f put(double paramDouble1, double paramDouble2)
    {
      return x(paramDouble1).y(paramDouble2);
    }
    
    public CvPoint2D64f put(CvPoint2D32f paramCvPoint2D32f)
    {
      return x(paramCvPoint2D32f.x()).y(paramCvPoint2D32f.y());
    }
    
    public CvPoint2D64f put(CvPoint2D64f paramCvPoint2D64f)
    {
      return x(paramCvPoint2D64f.x()).y(paramCvPoint2D64f.y());
    }
    
    public CvPoint2D64f put(CvPoint paramCvPoint)
    {
      return x(paramCvPoint.x()).y(paramCvPoint.y());
    }
    
    public final CvPoint2D64f put(double... paramVarArgs)
    {
      return put(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public final CvPoint2D64f put(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 2; i++) {
        position(i).put(paramArrayOfDouble[(paramInt1 + i * 2)], paramArrayOfDouble[(1 + (paramInt1 + i * 2))]);
      }
      return position(0);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + (float)x() + ", " + (float)y() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + (float)x() + ", " + (float)y() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native double x();
    
    public native CvPoint2D64f x(double paramDouble);
    
    public native double y();
    
    public native CvPoint2D64f y(double paramDouble);
  }
  
  public static class CvPoint3D32f
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPoint3D32f()
    {
      allocate();
    }
    
    public CvPoint3D32f(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPoint3D32f(Pointer paramPointer)
    {
      super();
    }
    
    public CvPoint3D32f(double... paramVarArgs)
    {
      this(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvPoint3D32f(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this(paramInt2 / 3);
      put(paramArrayOfDouble, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvPoint3D32f get(double[] paramArrayOfDouble)
    {
      return get(paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    public CvPoint3D32f get(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 3; i++)
      {
        position(i);
        paramArrayOfDouble[(paramInt1 + i * 3)] = x();
        paramArrayOfDouble[(1 + (paramInt1 + i * 3))] = y();
        paramArrayOfDouble[(2 + (paramInt1 + i * 3))] = z();
      }
      return position(0);
    }
    
    public double[] get()
    {
      if (this.capacity == 0) {}
      for (int i = 3;; i = 3 * this.capacity)
      {
        double[] arrayOfDouble = new double[i];
        get(arrayOfDouble);
        return arrayOfDouble;
      }
    }
    
    public CvPoint3D32f position(int paramInt)
    {
      return (CvPoint3D32f)super.position(paramInt);
    }
    
    public CvPoint3D32f put(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      return x((float)paramDouble1).y((float)paramDouble2).z((float)paramDouble3);
    }
    
    public CvPoint3D32f put(CvPoint2D32f paramCvPoint2D32f)
    {
      return x(paramCvPoint2D32f.x()).y(paramCvPoint2D32f.y()).z(0.0F);
    }
    
    public CvPoint3D32f put(CvPoint2D64f paramCvPoint2D64f)
    {
      return x((float)paramCvPoint2D64f.x()).y((float)paramCvPoint2D64f.y()).z(0.0F);
    }
    
    public CvPoint3D32f put(CvPoint paramCvPoint)
    {
      return x(paramCvPoint.x()).y(paramCvPoint.y()).z(0.0F);
    }
    
    public final CvPoint3D32f put(double... paramVarArgs)
    {
      return put(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public final CvPoint3D32f put(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 3; i++) {
        position(i).put(paramArrayOfDouble[(paramInt1 + i * 3)], paramArrayOfDouble[(1 + (paramInt1 + i * 3))], paramArrayOfDouble[(2 + (paramInt1 + i * 3))]);
      }
      return position(0);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + x() + ", " + y() + ", " + z() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + x() + ", " + y() + ", " + z() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native float x();
    
    public native CvPoint3D32f x(float paramFloat);
    
    public native float y();
    
    public native CvPoint3D32f y(float paramFloat);
    
    public native float z();
    
    public native CvPoint3D32f z(float paramFloat);
  }
  
  public static class CvPoint3D64f
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPoint3D64f()
    {
      allocate();
    }
    
    public CvPoint3D64f(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPoint3D64f(Pointer paramPointer)
    {
      super();
    }
    
    public CvPoint3D64f(double... paramVarArgs)
    {
      this(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public CvPoint3D64f(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this(paramInt2 / 3);
      put(paramArrayOfDouble, paramInt1, paramInt2);
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public CvPoint3D64f get(double[] paramArrayOfDouble)
    {
      return get(paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    public CvPoint3D64f get(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 3; i++)
      {
        position(i);
        paramArrayOfDouble[(paramInt1 + i * 3)] = x();
        paramArrayOfDouble[(1 + (paramInt1 + i * 3))] = y();
        paramArrayOfDouble[(2 + (paramInt1 + i * 3))] = z();
      }
      return position(0);
    }
    
    public double[] get()
    {
      if (this.capacity == 0) {}
      for (int i = 3;; i = 3 * this.capacity)
      {
        double[] arrayOfDouble = new double[i];
        get(arrayOfDouble);
        return arrayOfDouble;
      }
    }
    
    public CvPoint3D64f position(int paramInt)
    {
      return (CvPoint3D64f)super.position(paramInt);
    }
    
    public CvPoint3D64f put(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      return x(x()).y(y()).z(z());
    }
    
    public CvPoint3D64f put(CvPoint2D32f paramCvPoint2D32f)
    {
      return x(paramCvPoint2D32f.x()).y(paramCvPoint2D32f.y()).z(0.0D);
    }
    
    public CvPoint3D64f put(CvPoint2D64f paramCvPoint2D64f)
    {
      return x(paramCvPoint2D64f.x()).y(paramCvPoint2D64f.y()).z(0.0D);
    }
    
    public CvPoint3D64f put(CvPoint paramCvPoint)
    {
      return x(paramCvPoint.x()).y(paramCvPoint.y()).z(0.0D);
    }
    
    public final CvPoint3D64f put(double... paramVarArgs)
    {
      return put(paramVarArgs, 0, paramVarArgs.length);
    }
    
    public final CvPoint3D64f put(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      for (int i = 0; i < paramInt2 / 3; i++) {
        position(i).put(paramArrayOfDouble[(paramInt1 + i * 3)], paramArrayOfDouble[(1 + (paramInt1 + i * 3))], paramArrayOfDouble[(2 + (paramInt1 + i * 3))]);
      }
      return position(0);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + (float)x() + ", " + (float)y() + ", " + (float)z() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + (float)x() + ", " + (float)y() + ", " + (float)z() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native double x();
    
    public native CvPoint3D64f x(double paramDouble);
    
    public native double y();
    
    public native CvPoint3D64f y(double paramDouble);
    
    public native double z();
    
    public native CvPoint3D64f z(double paramDouble);
  }
  
  public static class CvRNG
    extends LongPointer
  {
    static
    {
      Loader.load();
    }
    
    public CvRNG()
    {
      this(null);
      allocate();
    }
    
    public CvRNG(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  public static class CvReadFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvReadFunc()
    {
      allocate();
    }
    
    public CvReadFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native Pointer call(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode);
  }
  
  public static class CvRect
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvRect()
    {
      allocate();
    }
    
    public CvRect(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      allocate();
      x(paramInt1).y(paramInt2).width(paramInt3).height(paramInt4);
    }
    
    public CvRect(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int height();
    
    public native CvRect height(int paramInt);
    
    public CvRect position(int paramInt)
    {
      return (CvRect)super.position(paramInt);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + x() + ", " + y() + "; " + width() + ", " + height() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + x() + ", " + y() + "; " + width() + ", " + height() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native int width();
    
    public native CvRect width(int paramInt);
    
    public native int x();
    
    public native CvRect x(int paramInt);
    
    public native int y();
    
    public native CvRect y(int paramInt);
  }
  
  public static class CvReleaseFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvReleaseFunc()
    {
      allocate();
    }
    
    public CvReleaseFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(PointerPointer paramPointerPointer);
  }
  
  public static class CvScalar
    extends Pointer
  {
    public static final CvScalar ALPHA1;
    public static final CvScalar ALPHA255;
    public static final CvScalar BLACK;
    public static final CvScalar BLUE = opencv_core.CV_RGB(0.0D, 0.0D, 255.0D);
    public static final CvScalar CYAN = opencv_core.CV_RGB(0.0D, 255.0D, 255.0D);
    public static final CvScalar GRAY;
    public static final CvScalar GREEN;
    public static final CvScalar MAGENTA = opencv_core.CV_RGB(255.0D, 0.0D, 255.0D);
    public static final CvScalar ONE;
    public static final CvScalar ONEHALF;
    public static final CvScalar RED;
    public static final CvScalar WHITE;
    public static final CvScalar YELLOW = opencv_core.CV_RGB(255.0D, 255.0D, 0.0D);
    public static final CvScalar ZERO;
    
    static
    {
      Loader.load();
      ZERO = new CvScalar().val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 0.0D);
      ONE = new CvScalar().val(0, 1.0D).val(1, 1.0D).val(2, 1.0D).val(3, 1.0D);
      ONEHALF = new CvScalar().val(0, 0.5D).val(1, 0.5D).val(2, 0.5D).val(3, 0.5D);
      ALPHA1 = new CvScalar().val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 1.0D);
      ALPHA255 = new CvScalar().val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 255.0D);
      WHITE = opencv_core.CV_RGB(255.0D, 255.0D, 255.0D);
      GRAY = opencv_core.CV_RGB(128.0D, 128.0D, 128.0D);
      BLACK = opencv_core.CV_RGB(0.0D, 0.0D, 0.0D);
      RED = opencv_core.CV_RGB(255.0D, 0.0D, 0.0D);
      GREEN = opencv_core.CV_RGB(0.0D, 255.0D, 0.0D);
    }
    
    public CvScalar()
    {
      allocate();
    }
    
    public CvScalar(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      allocate();
      val(0, paramDouble1).val(1, paramDouble2).val(2, paramDouble3).val(3, paramDouble4);
    }
    
    public CvScalar(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvScalar(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public double blue()
    {
      return val(0);
    }
    
    public CvScalar blue(double paramDouble)
    {
      val(0, paramDouble);
      return this;
    }
    
    @MemberGetter
    @Name({"val"})
    public native DoublePointer getDoublePointerVal();
    
    @Cast({"double*"})
    @MemberGetter
    @Name({"val"})
    public native LongPointer getLongPointerVal();
    
    public double getVal(int paramInt)
    {
      return val(paramInt);
    }
    
    public double green()
    {
      return val(1);
    }
    
    public CvScalar green(double paramDouble)
    {
      val(1, paramDouble);
      return this;
    }
    
    public double magnitude()
    {
      return Math.sqrt(val(0) * val(0) + val(1) * val(1) + val(2) * val(2) + val(3) * val(3));
    }
    
    public CvScalar position(int paramInt)
    {
      return (CvScalar)super.position(paramInt);
    }
    
    public double red()
    {
      return val(2);
    }
    
    public CvScalar red(double paramDouble)
    {
      val(2, paramDouble);
      return this;
    }
    
    public void scale(double paramDouble)
    {
      for (int i = 0; i < 4; i++) {
        val(i, paramDouble * val(i));
      }
    }
    
    public CvScalar setVal(int paramInt, double paramDouble)
    {
      return val(paramInt, paramDouble);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + (float)val(0) + ", " + (float)val(1) + ", " + (float)val(2) + ", " + (float)val(3) + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + (float)val(0) + ", " + (float)val(1) + ", " + (float)val(2) + ", " + (float)val(3) + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native double val(int paramInt);
    
    public native CvScalar val(int paramInt, double paramDouble);
  }
  
  public static class CvSeq
    extends CvArr
  {
    public CvSeq()
    {
      allocate();
      zero();
    }
    
    public CvSeq(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvSeq(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvSeq create(int paramInt1, int paramInt2, int paramInt3, CvMemStorage paramCvMemStorage)
    {
      return opencv_core.cvCreateSeq(paramInt1, paramInt2, paramInt3, paramCvMemStorage);
    }
    
    @Cast({"schar*"})
    public native BytePointer block_max();
    
    public native CvSeq block_max(BytePointer paramBytePointer);
    
    public native int delta_elems();
    
    public native CvSeq delta_elems(int paramInt);
    
    public native int elem_size();
    
    public native CvSeq elem_size(int paramInt);
    
    public native CvSeq first(CvSeqBlock paramCvSeqBlock);
    
    public native CvSeqBlock first();
    
    public native int flags();
    
    public native CvSeq flags(int paramInt);
    
    public native CvSeq free_blocks(CvSeqBlock paramCvSeqBlock);
    
    public native CvSeqBlock free_blocks();
    
    public native CvSeq h_next();
    
    public native CvSeq h_next(CvSeq paramCvSeq);
    
    public native CvSeq h_prev();
    
    public native CvSeq h_prev(CvSeq paramCvSeq);
    
    public native int header_size();
    
    public native CvSeq header_size(int paramInt);
    
    public CvSeq position(int paramInt)
    {
      return (CvSeq)super.position(paramInt);
    }
    
    @Cast({"schar*"})
    public native BytePointer ptr();
    
    public native CvSeq ptr(BytePointer paramBytePointer);
    
    public native CvMemStorage storage();
    
    public native CvSeq storage(CvMemStorage paramCvMemStorage);
    
    public native int total();
    
    public native CvSeq total(int paramInt);
    
    public native CvSeq v_next();
    
    public native CvSeq v_next(CvSeq paramCvSeq);
    
    public native CvSeq v_prev();
    
    public native CvSeq v_prev(CvSeq paramCvSeq);
  }
  
  public static class CvSeqBlock
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSeqBlock()
    {
      allocate();
    }
    
    public CvSeqBlock(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSeqBlock(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int count();
    
    public native CvSeqBlock count(int paramInt);
    
    @Cast({"schar*"})
    public native BytePointer data();
    
    public native CvSeqBlock data(BytePointer paramBytePointer);
    
    public native CvSeqBlock next();
    
    public native CvSeqBlock next(CvSeqBlock paramCvSeqBlock);
    
    public CvSeqBlock position(int paramInt)
    {
      return (CvSeqBlock)super.position(paramInt);
    }
    
    public native CvSeqBlock prev();
    
    public native CvSeqBlock prev(CvSeqBlock paramCvSeqBlock);
    
    public native int start_index();
    
    public native CvSeqBlock start_index(int paramInt);
  }
  
  public static class CvSeqReader
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSeqReader()
    {
      allocate();
    }
    
    public CvSeqReader(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSeqReader(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvSeqBlock block();
    
    public native CvSeqReader block(CvSeqBlock paramCvSeqBlock);
    
    @Cast({"schar*"})
    public native BytePointer block_max();
    
    public native CvSeqReader block_max(BytePointer paramBytePointer);
    
    @Cast({"schar*"})
    public native BytePointer block_min();
    
    public native CvSeqReader block_min(BytePointer paramBytePointer);
    
    public native int delta_index();
    
    public native CvSeqReader delta_index(int paramInt);
    
    public native int header_size();
    
    public native CvSeqReader header_size(int paramInt);
    
    public CvSeqReader position(int paramInt)
    {
      return (CvSeqReader)super.position(paramInt);
    }
    
    @Cast({"schar*"})
    public native BytePointer prev_elem();
    
    public native CvSeqReader prev_elem(BytePointer paramBytePointer);
    
    @Cast({"schar*"})
    public native BytePointer ptr();
    
    public native CvSeqReader ptr(BytePointer paramBytePointer);
    
    public native CvSeq seq();
    
    public native CvSeqReader seq(CvSeq paramCvSeq);
  }
  
  public static class CvSeqWriter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSeqWriter()
    {
      allocate();
    }
    
    public CvSeqWriter(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSeqWriter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvSeqBlock block();
    
    public native CvSeqWriter block(CvSeqBlock paramCvSeqBlock);
    
    @Cast({"schar*"})
    public native BytePointer block_max();
    
    public native CvSeqWriter block_max(BytePointer paramBytePointer);
    
    @Cast({"schar*"})
    public native BytePointer block_min();
    
    public native CvSeqWriter block_min(BytePointer paramBytePointer);
    
    public native int header_size();
    
    public native CvSeqWriter header_size(int paramInt);
    
    public CvSeqWriter position(int paramInt)
    {
      return (CvSeqWriter)super.position(paramInt);
    }
    
    @Cast({"schar*"})
    public native BytePointer ptr();
    
    public native CvSeqWriter ptr(BytePointer paramBytePointer);
    
    public native CvSeq seq();
    
    public native CvSeqWriter seq(CvSeq paramCvSeq);
  }
  
  public static class CvSet
    extends CvSeq
  {
    public CvSet()
    {
      allocate();
      zero();
    }
    
    public CvSet(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvSet(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvSet create(int paramInt1, int paramInt2, int paramInt3, CvMemStorage paramCvMemStorage)
    {
      return opencv_core.cvCreateSet(paramInt1, paramInt2, paramInt3, paramCvMemStorage);
    }
    
    public native int active_count();
    
    public native CvSet active_count(int paramInt);
    
    public native CvSet free_elems(CvSetElem paramCvSetElem);
    
    public native CvSetElem free_elems();
    
    public CvSet position(int paramInt)
    {
      return (CvSet)super.position(paramInt);
    }
  }
  
  public static class CvSetElem
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSetElem()
    {
      allocate();
    }
    
    public CvSetElem(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSetElem(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int flags();
    
    public native CvSetElem flags(int paramInt);
    
    public native CvSetElem next_free();
    
    public native CvSetElem next_free(CvSetElem paramCvSetElem);
    
    public CvSetElem position(int paramInt)
    {
      return (CvSetElem)super.position(paramInt);
    }
  }
  
  public static class CvSize
    extends Pointer
  {
    public static final CvSize ZERO = new CvSize().width(0).height(0);
    
    static
    {
      Loader.load();
    }
    
    public CvSize()
    {
      allocate();
    }
    
    public CvSize(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSize(int paramInt1, int paramInt2)
    {
      allocate();
      width(paramInt1).height(paramInt2);
    }
    
    public CvSize(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int height();
    
    public native CvSize height(int paramInt);
    
    public CvSize position(int paramInt)
    {
      return (CvSize)super.position(paramInt);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + width() + ", " + height() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + width() + ", " + height() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native int width();
    
    public native CvSize width(int paramInt);
  }
  
  public static class CvSize2D32f
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSize2D32f()
    {
      allocate();
    }
    
    public CvSize2D32f(float paramFloat1, float paramFloat2)
    {
      allocate();
      width(paramFloat1).height(paramFloat2);
    }
    
    public CvSize2D32f(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSize2D32f(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native float height();
    
    public native CvSize2D32f height(float paramFloat);
    
    public CvSize2D32f position(int paramInt)
    {
      return (CvSize2D32f)super.position(paramInt);
    }
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      if (capacity() == 0) {
        return "(" + width() + ", " + height() + ")";
      }
      String str1 = "";
      int i = position();
      int j = 0;
      if (j < capacity())
      {
        position(j);
        StringBuilder localStringBuilder = new StringBuilder().append(str1);
        if (j == 0) {}
        for (String str2 = "(";; str2 = " (")
        {
          str1 = str2 + width() + ", " + height() + ")";
          j++;
          break;
        }
      }
      position(i);
      return str1;
    }
    
    public native float width();
    
    public native CvSize2D32f width(float paramFloat);
  }
  
  public static class CvSlice
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSlice()
    {
      allocate();
    }
    
    public CvSlice(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSlice(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int end_index();
    
    public native CvSlice end_index(int paramInt);
    
    public CvSlice position(int paramInt)
    {
      return (CvSlice)super.position(paramInt);
    }
    
    public native int start_index();
    
    public native CvSlice start_index(int paramInt);
  }
  
  public static class CvSparseMat
    extends CvArr
  {
    public CvSparseMat()
    {
      allocate();
      zero();
    }
    
    public CvSparseMat(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public CvSparseMat(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static CvSparseMat create(int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      CvSparseMat localCvSparseMat = opencv_core.cvCreateSparseMat(paramInt1, paramArrayOfInt, paramInt2);
      if (localCvSparseMat != null) {
        localCvSparseMat.deallocator(new ReleaseDeallocator(localCvSparseMat));
      }
      return localCvSparseMat;
    }
    
    public CvSparseMat clone()
    {
      CvSparseMat localCvSparseMat = opencv_core.cvCloneSparseMat(this);
      if (localCvSparseMat != null) {
        localCvSparseMat.deallocator(new ReleaseDeallocator(localCvSparseMat));
      }
      return localCvSparseMat;
    }
    
    public native int dims();
    
    public native CvSparseMat dims(int paramInt);
    
    public native int hashsize();
    
    public native CvSparseMat hashsize(int paramInt);
    
    public native PointerPointer hashtable();
    
    public native CvSparseMat hashtable(PointerPointer paramPointerPointer);
    
    public native int hdr_refcount();
    
    public native CvSparseMat hdr_refcount(int paramInt);
    
    public native CvSet heap();
    
    public native CvSparseMat heap(CvSet paramCvSet);
    
    public native int idxoffset();
    
    public native CvSparseMat idxoffset(int paramInt);
    
    public CvSparseMat position(int paramInt)
    {
      return (CvSparseMat)super.position(paramInt);
    }
    
    public native IntPointer refcount();
    
    public native CvSparseMat refcount(IntPointer paramIntPointer);
    
    public void release()
    {
      deallocate();
    }
    
    public native int size(int paramInt);
    
    public native CvSparseMat size(int paramInt1, int paramInt2);
    
    public native int type();
    
    public native CvSparseMat type(int paramInt);
    
    public native int valoffset();
    
    public native CvSparseMat valoffset(int paramInt);
    
    protected static class ReleaseDeallocator
      extends CvSparseMat
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(CvSparseMat paramCvSparseMat)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseSparseMat(this);
      }
    }
  }
  
  public static class CvSparseMatIterator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSparseMatIterator()
    {
      allocate();
    }
    
    public CvSparseMatIterator(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSparseMatIterator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int curidx();
    
    public native CvSparseMatIterator curidx(int paramInt);
    
    public native CvSparseMat mat();
    
    public native CvSparseMatIterator mat(CvSparseMat paramCvSparseMat);
    
    public native CvSparseMatIterator node(CvSparseNode paramCvSparseNode);
    
    public native CvSparseNode node();
    
    public CvSparseMatIterator position(int paramInt)
    {
      return (CvSparseMatIterator)super.position(paramInt);
    }
  }
  
  public static class CvSparseNode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSparseNode()
    {
      allocate();
    }
    
    public CvSparseNode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSparseNode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int hashval();
    
    public native CvSparseNode hashval(int paramInt);
    
    public native CvSparseNode next();
    
    public native CvSparseNode next(CvSparseNode paramCvSparseNode);
    
    public CvSparseNode position(int paramInt)
    {
      return (CvSparseNode)super.position(paramInt);
    }
  }
  
  public static class CvString
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvString()
    {
      allocate();
    }
    
    public CvString(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvString(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int len();
    
    public native CvString len(int paramInt);
    
    public CvString position(int paramInt)
    {
      return (CvString)super.position(paramInt);
    }
    
    @Cast({"char*"})
    public native BytePointer ptr();
    
    public native CvString ptr(BytePointer paramBytePointer);
  }
  
  public static class CvStringHashNode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStringHashNode()
    {
      allocate();
    }
    
    public CvStringHashNode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvStringHashNode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int hashval();
    
    public native CvStringHashNode hashval(int paramInt);
    
    public native CvStringHashNode next();
    
    public native CvStringHashNode next(CvStringHashNode paramCvStringHashNode);
    
    public CvStringHashNode position(int paramInt)
    {
      return (CvStringHashNode)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvString str();
    
    public native CvStringHashNode str(CvString paramCvString);
  }
  
  public static class CvTermCriteria
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvTermCriteria()
    {
      allocate();
    }
    
    public CvTermCriteria(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvTermCriteria(int paramInt1, int paramInt2, double paramDouble)
    {
      allocate();
      type(paramInt1).max_iter(paramInt2).epsilon(paramDouble);
    }
    
    public CvTermCriteria(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double epsilon();
    
    public native CvTermCriteria epsilon(double paramDouble);
    
    public native int max_iter();
    
    public native CvTermCriteria max_iter(int paramInt);
    
    public CvTermCriteria position(int paramInt)
    {
      return (CvTermCriteria)super.position(paramInt);
    }
    
    public native int type();
    
    public native CvTermCriteria type(int paramInt);
  }
  
  public static class CvTreeNodeIterator
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvTreeNodeIterator()
    {
      allocate();
    }
    
    public CvTreeNodeIterator(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvTreeNodeIterator(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int level();
    
    public native CvTreeNodeIterator level(int paramInt);
    
    public native int max_level();
    
    public native CvTreeNodeIterator max_level(int paramInt);
    
    @Const
    public native Pointer node();
    
    public native CvTreeNodeIterator node(Pointer paramPointer);
    
    public CvTreeNodeIterator position(int paramInt)
    {
      return (CvTreeNodeIterator)super.position(paramInt);
    }
  }
  
  public static class CvTypeInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvTypeInfo()
    {
      allocate();
    }
    
    public CvTypeInfo(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvTypeInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native CvCloneFunc clone();
    
    public native CvTypeInfo clone(CvCloneFunc paramCvCloneFunc);
    
    public native int flags();
    
    public native CvTypeInfo flags(int paramInt);
    
    public native int header_size();
    
    public native CvTypeInfo header_size(int paramInt);
    
    public native CvIsInstanceFunc is_instance();
    
    public native CvTypeInfo is_instance(CvIsInstanceFunc paramCvIsInstanceFunc);
    
    public native CvTypeInfo next();
    
    public native CvTypeInfo next(CvTypeInfo paramCvTypeInfo);
    
    public CvTypeInfo position(int paramInt)
    {
      return (CvTypeInfo)super.position(paramInt);
    }
    
    public native CvTypeInfo prev();
    
    public native CvTypeInfo prev(CvTypeInfo paramCvTypeInfo);
    
    public native CvReadFunc read();
    
    public native CvTypeInfo read(CvReadFunc paramCvReadFunc);
    
    public native CvReleaseFunc release();
    
    public native CvTypeInfo release(CvReleaseFunc paramCvReleaseFunc);
    
    @Cast({"const char*"})
    public native BytePointer type_name();
    
    public native CvTypeInfo type_name(BytePointer paramBytePointer);
    
    public native CvTypeInfo write(CvWriteFunc paramCvWriteFunc);
    
    public native CvWriteFunc write();
  }
  
  public static class CvWriteFunc
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvWriteFunc()
    {
      allocate();
    }
    
    public CvWriteFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(CvFileStorage paramCvFileStorage, String paramString, @Const Pointer paramPointer, @ByVal opencv_core.CvAttrList paramCvAttrList);
  }
  
  @Convention("CV_STDCALL")
  public static class Cv_iplAllocateImageData
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Cv_iplAllocateImageData()
    {
      allocate();
    }
    
    public Cv_iplAllocateImageData(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(IplImage paramIplImage, int paramInt1, int paramInt2);
  }
  
  @Convention("CV_STDCALL")
  public static class Cv_iplCloneImage
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Cv_iplCloneImage()
    {
      allocate();
    }
    
    public Cv_iplCloneImage(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native IplImage call(@Const opencv_core.IplImage paramIplImage);
  }
  
  @Convention("CV_STDCALL")
  public static class Cv_iplCreateImageHeader
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Cv_iplCreateImageHeader()
    {
      allocate();
    }
    
    public Cv_iplCreateImageHeader(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native IplImage call(int paramInt1, int paramInt2, int paramInt3, @Cast({"char*"}) BytePointer paramBytePointer1, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, IplROI paramIplROI, IplImage paramIplImage, Pointer paramPointer, IplTileInfo paramIplTileInfo);
  }
  
  @Convention("CV_STDCALL")
  public static class Cv_iplCreateROI
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Cv_iplCreateROI()
    {
      allocate();
    }
    
    public Cv_iplCreateROI(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native IplROI call(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
  
  @Convention("CV_STDCALL")
  public static class Cv_iplDeallocate
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Cv_iplDeallocate()
    {
      allocate();
    }
    
    public Cv_iplDeallocate(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(IplImage paramIplImage, int paramInt);
  }
  
  @Adapter("ArrayAdapter")
  @Const
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InputArray {}
  
  @Adapter("MatAdapter")
  @Const
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InputMat {}
  
  @Name({"std::vector<std::vector<int> >"})
  public static class IntVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IntVectorVector()
    {
      allocate();
    }
    
    public IntVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public IntVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native int get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native IntVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, int paramInt);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  public static class IplImage
    extends CvArr
  {
    public static final byte[] gamma22;
    public static final byte[] gamma22inv;
    private Object bufferedImage = null;
    
    static
    {
      if (!opencv_core.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        gamma22 = new byte['Ā'];
        gamma22inv = new byte['Ā'];
        for (int i = 0; i < 256; i++)
        {
          gamma22[i] = ((byte)(int)Math.round(255.0D * Math.pow(i / 255.0D, 2.2D)));
          gamma22inv[i] = ((byte)(int)Math.round(255.0D * Math.pow(i / 255.0D, 0.45454545454545453D)));
        }
      }
    }
    
    public IplImage()
    {
      allocate();
      zero();
    }
    
    public IplImage(int paramInt)
    {
      allocateArray(paramInt);
      zero();
    }
    
    public IplImage(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public static IplImage create(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return create(opencv_core.cvSize(paramInt1, paramInt2), paramInt3, paramInt4);
    }
    
    public static IplImage create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      IplImage localIplImage = create(paramInt1, paramInt2, paramInt3, paramInt4);
      if (localIplImage != null) {
        localIplImage.origin(paramInt5);
      }
      return localIplImage;
    }
    
    public static IplImage create(CvSize paramCvSize, int paramInt1, int paramInt2)
    {
      IplImage localIplImage = opencv_core.cvCreateImage(paramCvSize, paramInt1, paramInt2);
      if (localIplImage != null) {
        localIplImage.deallocator(new ReleaseDeallocator(localIplImage));
      }
      return localIplImage;
    }
    
    public static IplImage create(CvSize paramCvSize, int paramInt1, int paramInt2, int paramInt3)
    {
      IplImage localIplImage = create(paramCvSize, paramInt1, paramInt2);
      if (localIplImage != null) {
        localIplImage.origin(paramInt3);
      }
      return localIplImage;
    }
    
    public static IplImage createCompatible(IplImage paramIplImage)
    {
      return createIfNotCompatible(null, paramIplImage);
    }
    
    public static IplImage createFrom(BufferedImage paramBufferedImage)
    {
      return createFrom(paramBufferedImage, 1.0D);
    }
    
    public static IplImage createFrom(BufferedImage paramBufferedImage, double paramDouble)
    {
      return createFrom(paramBufferedImage, paramDouble, false);
    }
    
    public static IplImage createFrom(BufferedImage paramBufferedImage, double paramDouble, boolean paramBoolean)
    {
      if (paramBufferedImage == null) {
        return null;
      }
      SampleModel localSampleModel = paramBufferedImage.getSampleModel();
      int i = localSampleModel.getNumBands();
      int j = paramBufferedImage.getType();
      int k = 0;
      switch (j)
      {
      }
      while ((k == 0) || (i == 0)) {
        switch (localSampleModel.getDataType())
        {
        default: 
          if (!$assertionsDisabled)
          {
            throw new AssertionError();
            k = 8;
            i = 4;
          }
          break;
        case 0: 
          k = 8;
        }
      }
      for (;;)
      {
        IplImage localIplImage = create(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), k, i);
        localIplImage.copyFrom(paramBufferedImage, paramDouble, paramBoolean);
        return localIplImage;
        k = 16;
        continue;
        k = -2147483632;
        continue;
        k = -2147483616;
        continue;
        k = 32;
        continue;
        k = 64;
      }
    }
    
    public static IplImage createHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return createHeader(opencv_core.cvSize(paramInt1, paramInt2), paramInt3, paramInt4);
    }
    
    public static IplImage createHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      IplImage localIplImage = createHeader(paramInt1, paramInt2, paramInt3, paramInt4);
      if (localIplImage != null) {
        localIplImage.origin(paramInt5);
      }
      return localIplImage;
    }
    
    public static IplImage createHeader(CvSize paramCvSize, int paramInt1, int paramInt2)
    {
      IplImage localIplImage = opencv_core.cvCreateImageHeader(paramCvSize, paramInt1, paramInt2);
      if (localIplImage != null) {
        localIplImage.deallocator(new HeaderReleaseDeallocator(localIplImage));
      }
      return localIplImage;
    }
    
    public static IplImage createHeader(CvSize paramCvSize, int paramInt1, int paramInt2, int paramInt3)
    {
      IplImage localIplImage = createHeader(paramCvSize, paramInt1, paramInt2);
      if (localIplImage != null) {
        localIplImage.origin(paramInt3);
      }
      return localIplImage;
    }
    
    public static IplImage createIfNotCompatible(IplImage paramIplImage1, IplImage paramIplImage2)
    {
      if ((paramIplImage1 == null) || (paramIplImage1.width() != paramIplImage2.width()) || (paramIplImage1.height() != paramIplImage2.height()) || (paramIplImage1.depth() != paramIplImage2.depth()) || (paramIplImage1.nChannels() != paramIplImage2.nChannels()))
      {
        paramIplImage1 = create(paramIplImage2.width(), paramIplImage2.height(), paramIplImage2.depth(), paramIplImage2.nChannels(), paramIplImage2.origin());
        if (paramIplImage2.bufferedImage != null) {
          paramIplImage1.bufferedImage = paramIplImage2.cloneBufferedImage();
        }
      }
      paramIplImage1.origin(paramIplImage2.origin());
      return paramIplImage1;
    }
    
    public static int decodeGamma22(int paramInt)
    {
      return 0xFF & gamma22[(paramInt & 0xFF)];
    }
    
    public static int encodeGamma22(int paramInt)
    {
      return 0xFF & gamma22inv[(paramInt & 0xFF)];
    }
    
    public static void flipCopyWithGamma(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, boolean paramBoolean1, double paramDouble, boolean paramBoolean2, int paramInt3)
    {
      assert (paramByteBuffer1 != paramByteBuffer2);
      int i = Math.min(paramInt1, paramInt2);
      int j = paramByteBuffer1.position();
      int k = paramByteBuffer2.position();
      byte[] arrayOfByte = new byte[paramInt3];
      while ((j < paramByteBuffer1.capacity()) && (k < paramByteBuffer2.capacity()))
      {
        int i7;
        if (paramBoolean2)
        {
          paramByteBuffer1.position(paramByteBuffer1.capacity() - j - paramInt1);
          paramByteBuffer2.position(k);
          i = Math.min(Math.min(i, paramByteBuffer1.remaining()), paramByteBuffer2.remaining());
          if (!paramBoolean1) {
            break label306;
          }
          if (paramInt3 > 1) {
            i7 = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i7 >= i) {
              break label581;
            }
            int i8 = 0;
            label130:
            if (i8 < paramInt3)
            {
              int i10 = paramByteBuffer1.get();
              if (paramDouble == 1.0D) {}
              for (int i11 = i10;; i11 = (byte)(int)Math.round(127.0D * Math.pow(i10 / 127.0D, paramDouble)))
              {
                arrayOfByte[i8] = i11;
                i8++;
                break label130;
                paramByteBuffer1.position(j);
                break;
              }
            }
            for (int i9 = paramInt3 - 1; i9 >= 0; i9--) {
              paramByteBuffer2.put(arrayOfByte[i9]);
            }
            i7 += paramInt3;
          }
        }
        int i6 = 0;
        if (i6 < i)
        {
          byte b2 = paramByteBuffer1.get();
          if (paramDouble == 1.0D) {}
          for (byte b3 = b2;; b3 = (byte)(int)Math.round(127.0D * Math.pow(b2 / 127.0D, paramDouble)))
          {
            paramByteBuffer2.put(b3);
            i6++;
            break;
          }
          label306:
          if (paramInt3 > 1)
          {
            int i1 = 0;
            while (i1 < i)
            {
              int i2 = 0;
              if (i2 < paramInt3)
              {
                int i4 = 0xFF & paramByteBuffer1.get();
                int i5;
                if (paramDouble == 1.0D) {
                  i5 = (byte)i4;
                }
                for (;;)
                {
                  arrayOfByte[i2] = i5;
                  i2++;
                  break;
                  if (paramDouble == 2.2D) {
                    i5 = gamma22[i4];
                  } else if (paramDouble == 0.45454545454545453D) {
                    i5 = gamma22inv[i4];
                  } else {
                    i5 = (byte)(int)Math.round(255.0D * Math.pow(i4 / 255.0D, paramDouble));
                  }
                }
              }
              for (int i3 = paramInt3 - 1; i3 >= 0; i3--) {
                paramByteBuffer2.put(arrayOfByte[i3]);
              }
              i1 += paramInt3;
            }
          }
          int m = 0;
          if (m < i)
          {
            int n = 0xFF & paramByteBuffer1.get();
            byte b1;
            if (paramDouble == 1.0D) {
              b1 = (byte)n;
            }
            for (;;)
            {
              paramByteBuffer2.put(b1);
              m++;
              break;
              if (paramDouble == 2.2D) {
                b1 = gamma22[n];
              } else if (paramDouble == 0.45454545454545453D) {
                b1 = gamma22inv[n];
              } else {
                b1 = (byte)(int)Math.round(255.0D * Math.pow(n / 255.0D, paramDouble));
              }
            }
          }
        }
        label581:
        j += paramInt1;
        k += paramInt2;
      }
    }
    
    public static void flipCopyWithGamma(DoubleBuffer paramDoubleBuffer1, int paramInt1, DoubleBuffer paramDoubleBuffer2, int paramInt2, double paramDouble, boolean paramBoolean, int paramInt3)
    {
      assert (paramDoubleBuffer1 != paramDoubleBuffer2);
      int i = Math.min(paramInt1, paramInt2);
      int j = paramDoubleBuffer1.position();
      int k = paramDoubleBuffer2.position();
      double[] arrayOfDouble = new double[paramInt3];
      while ((j < paramDoubleBuffer1.capacity()) && (k < paramDoubleBuffer2.capacity()))
      {
        int n;
        if (paramBoolean)
        {
          paramDoubleBuffer1.position(paramDoubleBuffer1.capacity() - j - paramInt1);
          paramDoubleBuffer2.position(k);
          i = Math.min(Math.min(i, paramDoubleBuffer1.remaining()), paramDoubleBuffer2.remaining());
          if (paramInt3 > 1) {
            n = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (n >= i) {
              break label273;
            }
            int i1 = 0;
            label125:
            if (i1 < paramInt3)
            {
              double d3 = paramDoubleBuffer1.get();
              if (paramDouble == 1.0D) {}
              for (double d4 = d3;; d4 = Math.pow(d3, paramDouble))
              {
                arrayOfDouble[i1] = d4;
                i1++;
                break label125;
                paramDoubleBuffer1.position(j);
                break;
              }
            }
            for (int i2 = paramInt3 - 1; i2 >= 0; i2--) {
              paramDoubleBuffer2.put(arrayOfDouble[i2]);
            }
            n += paramInt3;
          }
        }
        int m = 0;
        if (m < i)
        {
          double d1 = paramDoubleBuffer1.get();
          if (paramDouble == 1.0D) {}
          for (double d2 = d1;; d2 = Math.pow(d1, paramDouble))
          {
            paramDoubleBuffer2.put(d2);
            m++;
            break;
          }
        }
        label273:
        j += paramInt1;
        k += paramInt2;
      }
    }
    
    public static void flipCopyWithGamma(FloatBuffer paramFloatBuffer1, int paramInt1, FloatBuffer paramFloatBuffer2, int paramInt2, double paramDouble, boolean paramBoolean, int paramInt3)
    {
      assert (paramFloatBuffer1 != paramFloatBuffer2);
      int i = Math.min(paramInt1, paramInt2);
      int j = paramFloatBuffer1.position();
      int k = paramFloatBuffer2.position();
      float[] arrayOfFloat = new float[paramInt3];
      while ((j < paramFloatBuffer1.capacity()) && (k < paramFloatBuffer2.capacity()))
      {
        int n;
        if (paramBoolean)
        {
          paramFloatBuffer1.position(paramFloatBuffer1.capacity() - j - paramInt1);
          paramFloatBuffer2.position(k);
          i = Math.min(Math.min(i, paramFloatBuffer1.remaining()), paramFloatBuffer2.remaining());
          if (paramInt3 > 1) {
            n = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (n >= i) {
              break label277;
            }
            int i1 = 0;
            label125:
            if (i1 < paramInt3)
            {
              float f3 = paramFloatBuffer1.get();
              if (paramDouble == 1.0D) {}
              for (float f4 = f3;; f4 = (float)Math.pow(f3, paramDouble))
              {
                arrayOfFloat[i1] = f4;
                i1++;
                break label125;
                paramFloatBuffer1.position(j);
                break;
              }
            }
            for (int i2 = paramInt3 - 1; i2 >= 0; i2--) {
              paramFloatBuffer2.put(arrayOfFloat[i2]);
            }
            n += paramInt3;
          }
        }
        int m = 0;
        if (m < i)
        {
          float f1 = paramFloatBuffer1.get();
          if (paramDouble == 1.0D) {}
          for (float f2 = f1;; f2 = (float)Math.pow(f1, paramDouble))
          {
            paramFloatBuffer2.put(f2);
            m++;
            break;
          }
        }
        label277:
        j += paramInt1;
        k += paramInt2;
      }
    }
    
    public static void flipCopyWithGamma(IntBuffer paramIntBuffer1, int paramInt1, IntBuffer paramIntBuffer2, int paramInt2, double paramDouble, boolean paramBoolean, int paramInt3)
    {
      assert (paramIntBuffer1 != paramIntBuffer2);
      int i = Math.min(paramInt1, paramInt2);
      int j = paramIntBuffer1.position();
      int k = paramIntBuffer2.position();
      int[] arrayOfInt = new int[paramInt3];
      while ((j < paramIntBuffer1.capacity()) && (k < paramIntBuffer2.capacity()))
      {
        int i2;
        if (paramBoolean)
        {
          paramIntBuffer1.position(paramIntBuffer1.capacity() - j - paramInt1);
          paramIntBuffer2.position(k);
          i = Math.min(Math.min(i, paramIntBuffer1.remaining()), paramIntBuffer2.remaining());
          if (paramInt3 > 1) {
            i2 = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i2 >= i) {
              break label299;
            }
            int i3 = 0;
            label125:
            if (i3 < paramInt3)
            {
              int i5 = paramIntBuffer1.get();
              if (paramDouble == 1.0D) {}
              for (int i6 = i5;; i6 = (int)Math.round(2.147483647E9D * Math.pow(i5 / 2.147483647E9D, paramDouble)))
              {
                arrayOfInt[i3] = i6;
                i3++;
                break label125;
                paramIntBuffer1.position(j);
                break;
              }
            }
            for (int i4 = paramInt3 - 1; i4 >= 0; i4--) {
              paramIntBuffer2.put(arrayOfInt[i4]);
            }
            i2 += paramInt3;
          }
        }
        int m = 0;
        if (m < i)
        {
          int n = paramIntBuffer1.get();
          if (paramDouble == 1.0D) {}
          for (int i1 = n;; i1 = (int)Math.round(2.147483647E9D * Math.pow(n / 2.147483647E9D, paramDouble)))
          {
            paramIntBuffer2.put(i1);
            m++;
            break;
          }
        }
        label299:
        j += paramInt1;
        k += paramInt2;
      }
    }
    
    public static void flipCopyWithGamma(ShortBuffer paramShortBuffer1, int paramInt1, ShortBuffer paramShortBuffer2, int paramInt2, boolean paramBoolean1, double paramDouble, boolean paramBoolean2, int paramInt3)
    {
      assert (paramShortBuffer1 != paramShortBuffer2);
      int i = Math.min(paramInt1, paramInt2);
      int j = paramShortBuffer1.position();
      int k = paramShortBuffer2.position();
      short[] arrayOfShort = new short[paramInt3];
      while ((j < paramShortBuffer1.capacity()) && (k < paramShortBuffer2.capacity()))
      {
        int i7;
        if (paramBoolean2)
        {
          paramShortBuffer1.position(paramShortBuffer1.capacity() - j - paramInt1);
          paramShortBuffer2.position(k);
          i = Math.min(Math.min(i, paramShortBuffer1.remaining()), paramShortBuffer2.remaining());
          if (!paramBoolean1) {
            break label306;
          }
          if (paramInt3 > 1) {
            i7 = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i7 >= i) {
              break label496;
            }
            int i8 = 0;
            label130:
            if (i8 < paramInt3)
            {
              int i10 = paramShortBuffer1.get();
              if (paramDouble == 1.0D) {}
              for (int i11 = i10;; i11 = (short)(int)Math.round(32767.0D * Math.pow(i10 / 32767.0D, paramDouble)))
              {
                arrayOfShort[i8] = i11;
                i8++;
                break label130;
                paramShortBuffer1.position(j);
                break;
              }
            }
            for (int i9 = paramInt3 - 1; i9 >= 0; i9--) {
              paramShortBuffer2.put(arrayOfShort[i9]);
            }
            i7 += paramInt3;
          }
        }
        int i6 = 0;
        if (i6 < i)
        {
          short s2 = paramShortBuffer1.get();
          if (paramDouble == 1.0D) {}
          for (short s3 = s2;; s3 = (short)(int)Math.round(32767.0D * Math.pow(s2 / 32767.0D, paramDouble)))
          {
            paramShortBuffer2.put(s3);
            i6++;
            break;
          }
          label306:
          if (paramInt3 > 1)
          {
            int i1 = 0;
            while (i1 < i)
            {
              int i2 = 0;
              if (i2 < paramInt3)
              {
                int i4 = paramShortBuffer1.get();
                if (paramDouble == 1.0D) {}
                for (int i5 = i4;; i5 = (short)(int)Math.round(65535.0D * Math.pow(i4 / 65535.0D, paramDouble)))
                {
                  arrayOfShort[i2] = i5;
                  i2++;
                  break;
                }
              }
              for (int i3 = paramInt3 - 1; i3 >= 0; i3--) {
                paramShortBuffer2.put(arrayOfShort[i3]);
              }
              i1 += paramInt3;
            }
          }
          int m = 0;
          if (m < i)
          {
            int n = 0xFFFF & paramShortBuffer1.get();
            if (paramDouble == 1.0D) {}
            for (short s1 = (short)n;; s1 = (short)(int)Math.round(65535.0D * Math.pow(n / 65535.0D, paramDouble)))
            {
              paramShortBuffer2.put(s1);
              m++;
              break;
            }
          }
        }
        label496:
        j += paramInt1;
        k += paramInt2;
      }
    }
    
    public native int BorderConst(int paramInt);
    
    public native IplImage BorderConst(int paramInt1, int paramInt2);
    
    public native int BorderMode(int paramInt);
    
    public native IplImage BorderMode(int paramInt1, int paramInt2);
    
    public native int ID();
    
    public native IplImage ID(int paramInt);
    
    public native int align();
    
    public native IplImage align(int paramInt);
    
    public native int alphaChannel();
    
    public native IplImage alphaChannel(int paramInt);
    
    public void applyGamma(double paramDouble)
    {
      if (paramDouble == 1.0D) {}
      do
      {
        return;
        switch (depth())
        {
        }
      } while ($assertionsDisabled);
      throw new AssertionError();
      flipCopyWithGamma(getByteBuffer(), widthStep(), getByteBuffer(), widthStep(), false, paramDouble, false, 0);
      return;
      flipCopyWithGamma(getByteBuffer(), widthStep(), getByteBuffer(), widthStep(), true, paramDouble, false, 0);
      return;
      flipCopyWithGamma(getShortBuffer(), widthStep() / 2, getShortBuffer(), widthStep() / 2, false, paramDouble, false, 0);
      return;
      flipCopyWithGamma(getShortBuffer(), widthStep() / 2, getShortBuffer(), widthStep() / 2, true, paramDouble, false, 0);
      return;
      flipCopyWithGamma(getFloatBuffer(), widthStep() / 4, getFloatBuffer(), widthStep() / 4, paramDouble, false, 0);
      return;
      flipCopyWithGamma(getFloatBuffer(), widthStep() / 4, getFloatBuffer(), widthStep() / 4, paramDouble, false, 0);
      return;
      flipCopyWithGamma(getDoubleBuffer(), widthStep() / 8, getDoubleBuffer(), widthStep() / 8, paramDouble, false, 0);
    }
    
    public CvMat asCvMat()
    {
      CvMat localCvMat = new CvMat();
      opencv_core.cvGetMat(this, localCvMat, null, 0);
      return localCvMat;
    }
    
    public native int channelSeq(int paramInt);
    
    public native IplImage channelSeq(int paramInt1, int paramInt2);
    
    public IplImage clone()
    {
      IplImage localIplImage = opencv_core.cvCloneImage(this);
      if (localIplImage != null) {
        localIplImage.deallocator(new ReleaseDeallocator(localIplImage));
      }
      if (this.bufferedImage != null) {
        localIplImage.bufferedImage = cloneBufferedImage();
      }
      return localIplImage;
    }
    
    protected BufferedImage cloneBufferedImage()
    {
      if (this.bufferedImage == null) {
        return null;
      }
      BufferedImage localBufferedImage = (BufferedImage)this.bufferedImage;
      int i = localBufferedImage.getType();
      if (i == 0) {
        return new BufferedImage(localBufferedImage.getColorModel(), localBufferedImage.copyData(null), localBufferedImage.isAlphaPremultiplied(), null);
      }
      return new BufferedImage(localBufferedImage.getWidth(), localBufferedImage.getHeight(), i);
    }
    
    public native int colorModel(int paramInt);
    
    public native IplImage colorModel(int paramInt1, int paramInt2);
    
    public void copyFrom(BufferedImage paramBufferedImage)
    {
      copyFrom(paramBufferedImage, 1.0D);
    }
    
    public void copyFrom(BufferedImage paramBufferedImage, double paramDouble)
    {
      copyFrom(paramBufferedImage, paramDouble, false);
    }
    
    public void copyFrom(BufferedImage paramBufferedImage, double paramDouble, boolean paramBoolean)
    {
      IplROI localIplROI = roi();
      Rectangle localRectangle = null;
      if (localIplROI != null) {
        localRectangle = new Rectangle(localIplROI.xOffset(), localIplROI.yOffset(), localIplROI.width(), localIplROI.height());
      }
      copyFrom(paramBufferedImage, paramDouble, paramBoolean, localRectangle);
    }
    
    public void copyFrom(BufferedImage paramBufferedImage, double paramDouble, boolean paramBoolean, Rectangle paramRectangle)
    {
      origin(0);
      int i;
      ByteBuffer localByteBuffer1;
      SampleModel localSampleModel;
      DataBuffer localDataBuffer;
      int m;
      int n;
      label105:
      int i1;
      int i13;
      if (paramRectangle == null)
      {
        i = 0;
        localByteBuffer1 = getByteBuffer(i);
        localSampleModel = paramBufferedImage.getSampleModel();
        WritableRaster localWritableRaster = paramBufferedImage.getRaster();
        localDataBuffer = localWritableRaster.getDataBuffer();
        int j = -localWritableRaster.getSampleModelTranslateX();
        int k = -localWritableRaster.getSampleModelTranslateY();
        m = localSampleModel.getWidth() * localSampleModel.getNumBands();
        n = localSampleModel.getNumBands();
        if (!(localSampleModel instanceof ComponentSampleModel)) {
          break label243;
        }
        m = ((ComponentSampleModel)localSampleModel).getScanlineStride();
        n = ((ComponentSampleModel)localSampleModel).getPixelStride();
        i1 = k * m + j * n;
        if (!(localDataBuffer instanceof DataBufferByte)) {
          break label307;
        }
        byte[] arrayOfByte = ((DataBufferByte)localDataBuffer).getData();
        ByteBuffer localByteBuffer2 = ByteBuffer.wrap(arrayOfByte, i1, arrayOfByte.length - i1);
        int i12 = widthStep();
        if (!paramBoolean) {
          break label301;
        }
        i13 = n;
        label166:
        flipCopyWithGamma(localByteBuffer2, m, localByteBuffer1, i12, false, paramDouble, false, i13);
      }
      label243:
      label301:
      label307:
      do
      {
        if ((this.bufferedImage == null) && (paramRectangle == null) && (paramBufferedImage.getWidth() == width()) && (paramBufferedImage.getHeight() == height())) {
          this.bufferedImage = paramBufferedImage;
        }
        return;
        i = paramRectangle.y * widthStep() + paramRectangle.x;
        break;
        if ((localSampleModel instanceof SinglePixelPackedSampleModel))
        {
          m = ((SinglePixelPackedSampleModel)localSampleModel).getScanlineStride();
          n = 1;
          break label105;
        }
        if (!(localSampleModel instanceof MultiPixelPackedSampleModel)) {
          break label105;
        }
        m = ((MultiPixelPackedSampleModel)localSampleModel).getScanlineStride();
        n = ((MultiPixelPackedSampleModel)localSampleModel).getPixelBitStride() / 8;
        break label105;
        i13 = 0;
        break label166;
        if ((localDataBuffer instanceof DataBufferDouble))
        {
          double[] arrayOfDouble = ((DataBufferDouble)localDataBuffer).getData();
          DoubleBuffer localDoubleBuffer1 = DoubleBuffer.wrap(arrayOfDouble, i1, arrayOfDouble.length - i1);
          DoubleBuffer localDoubleBuffer2 = localByteBuffer1.asDoubleBuffer();
          int i10 = widthStep() / 8;
          if (paramBoolean) {}
          for (int i11 = n;; i11 = 0)
          {
            flipCopyWithGamma(localDoubleBuffer1, m, localDoubleBuffer2, i10, paramDouble, false, i11);
            break;
          }
        }
        if ((localDataBuffer instanceof DataBufferFloat))
        {
          float[] arrayOfFloat = ((DataBufferFloat)localDataBuffer).getData();
          FloatBuffer localFloatBuffer1 = FloatBuffer.wrap(arrayOfFloat, i1, arrayOfFloat.length - i1);
          FloatBuffer localFloatBuffer2 = localByteBuffer1.asFloatBuffer();
          int i8 = widthStep() / 4;
          if (paramBoolean) {}
          for (int i9 = n;; i9 = 0)
          {
            flipCopyWithGamma(localFloatBuffer1, m, localFloatBuffer2, i8, paramDouble, false, i9);
            break;
          }
        }
        if ((localDataBuffer instanceof DataBufferInt))
        {
          int[] arrayOfInt = ((DataBufferInt)localDataBuffer).getData();
          IntBuffer localIntBuffer1 = IntBuffer.wrap(arrayOfInt, i1, arrayOfInt.length - i1);
          IntBuffer localIntBuffer2 = localByteBuffer1.asIntBuffer();
          int i6 = widthStep() / 4;
          if (paramBoolean) {}
          for (int i7 = n;; i7 = 0)
          {
            flipCopyWithGamma(localIntBuffer1, m, localIntBuffer2, i6, paramDouble, false, i7);
            break;
          }
        }
        if ((localDataBuffer instanceof DataBufferShort))
        {
          short[] arrayOfShort2 = ((DataBufferShort)localDataBuffer).getData();
          ShortBuffer localShortBuffer3 = ShortBuffer.wrap(arrayOfShort2, i1, arrayOfShort2.length - i1);
          ShortBuffer localShortBuffer4 = localByteBuffer1.asShortBuffer();
          int i4 = widthStep() / 2;
          if (paramBoolean) {}
          for (int i5 = n;; i5 = 0)
          {
            flipCopyWithGamma(localShortBuffer3, m, localShortBuffer4, i4, true, paramDouble, false, i5);
            break;
          }
        }
        if ((localDataBuffer instanceof DataBufferUShort))
        {
          short[] arrayOfShort1 = ((DataBufferUShort)localDataBuffer).getData();
          ShortBuffer localShortBuffer1 = ShortBuffer.wrap(arrayOfShort1, i1, arrayOfShort1.length - i1);
          ShortBuffer localShortBuffer2 = localByteBuffer1.asShortBuffer();
          int i2 = widthStep() / 2;
          if (paramBoolean) {}
          for (int i3 = n;; i3 = 0)
          {
            flipCopyWithGamma(localShortBuffer1, m, localShortBuffer2, i2, false, paramDouble, false, i3);
            break;
          }
        }
      } while ($assertionsDisabled);
      throw new AssertionError();
    }
    
    public void copyTo(BufferedImage paramBufferedImage)
    {
      copyTo(paramBufferedImage, 1.0D);
    }
    
    public void copyTo(BufferedImage paramBufferedImage, double paramDouble)
    {
      copyTo(paramBufferedImage, paramDouble, false);
    }
    
    public void copyTo(BufferedImage paramBufferedImage, double paramDouble, boolean paramBoolean)
    {
      IplROI localIplROI = roi();
      Rectangle localRectangle = null;
      if (localIplROI != null) {
        localRectangle = new Rectangle(localIplROI.xOffset(), localIplROI.yOffset(), localIplROI.width(), localIplROI.height());
      }
      copyTo(paramBufferedImage, paramDouble, paramBoolean, localRectangle);
    }
    
    public void copyTo(BufferedImage paramBufferedImage, double paramDouble, boolean paramBoolean, Rectangle paramRectangle)
    {
      boolean bool;
      int i;
      label19:
      ByteBuffer localByteBuffer1;
      SampleModel localSampleModel;
      DataBuffer localDataBuffer;
      int m;
      int n;
      label110:
      int i1;
      int i13;
      if (origin() == 1)
      {
        bool = true;
        if (paramRectangle != null) {
          break label195;
        }
        i = 0;
        localByteBuffer1 = getByteBuffer(i);
        localSampleModel = paramBufferedImage.getSampleModel();
        WritableRaster localWritableRaster = paramBufferedImage.getRaster();
        localDataBuffer = localWritableRaster.getDataBuffer();
        int j = -localWritableRaster.getSampleModelTranslateX();
        int k = -localWritableRaster.getSampleModelTranslateY();
        m = localSampleModel.getWidth() * localSampleModel.getNumBands();
        n = localSampleModel.getNumBands();
        if (!(localSampleModel instanceof ComponentSampleModel)) {
          break label221;
        }
        m = ((ComponentSampleModel)localSampleModel).getScanlineStride();
        n = ((ComponentSampleModel)localSampleModel).getPixelStride();
        i1 = k * m + j * n;
        if (!(localDataBuffer instanceof DataBufferByte)) {
          break label285;
        }
        byte[] arrayOfByte = ((DataBufferByte)localDataBuffer).getData();
        int i12 = widthStep();
        ByteBuffer localByteBuffer2 = ByteBuffer.wrap(arrayOfByte, i1, arrayOfByte.length - i1);
        if (!paramBoolean) {
          break label279;
        }
        i13 = n;
        label171:
        flipCopyWithGamma(localByteBuffer1, i12, localByteBuffer2, m, false, paramDouble, bool, i13);
      }
      label195:
      label221:
      label279:
      label285:
      do
      {
        return;
        bool = false;
        break;
        i = paramRectangle.y * widthStep() + paramRectangle.x * nChannels();
        break label19;
        if ((localSampleModel instanceof SinglePixelPackedSampleModel))
        {
          m = ((SinglePixelPackedSampleModel)localSampleModel).getScanlineStride();
          n = 1;
          break label110;
        }
        if (!(localSampleModel instanceof MultiPixelPackedSampleModel)) {
          break label110;
        }
        m = ((MultiPixelPackedSampleModel)localSampleModel).getScanlineStride();
        n = ((MultiPixelPackedSampleModel)localSampleModel).getPixelBitStride() / 8;
        break label110;
        i13 = 0;
        break label171;
        if ((localDataBuffer instanceof DataBufferDouble))
        {
          double[] arrayOfDouble = ((DataBufferDouble)localDataBuffer).getData();
          DoubleBuffer localDoubleBuffer1 = localByteBuffer1.asDoubleBuffer();
          int i10 = widthStep() / 8;
          DoubleBuffer localDoubleBuffer2 = DoubleBuffer.wrap(arrayOfDouble, i1, arrayOfDouble.length - i1);
          if (paramBoolean) {}
          for (int i11 = n;; i11 = 0)
          {
            flipCopyWithGamma(localDoubleBuffer1, i10, localDoubleBuffer2, m, paramDouble, bool, i11);
            return;
          }
        }
        if ((localDataBuffer instanceof DataBufferFloat))
        {
          float[] arrayOfFloat = ((DataBufferFloat)localDataBuffer).getData();
          FloatBuffer localFloatBuffer1 = localByteBuffer1.asFloatBuffer();
          int i8 = widthStep() / 4;
          FloatBuffer localFloatBuffer2 = FloatBuffer.wrap(arrayOfFloat, i1, arrayOfFloat.length - i1);
          if (paramBoolean) {}
          for (int i9 = n;; i9 = 0)
          {
            flipCopyWithGamma(localFloatBuffer1, i8, localFloatBuffer2, m, paramDouble, bool, i9);
            return;
          }
        }
        if ((localDataBuffer instanceof DataBufferInt))
        {
          int[] arrayOfInt = ((DataBufferInt)localDataBuffer).getData();
          IntBuffer localIntBuffer1 = localByteBuffer1.asIntBuffer();
          int i6 = widthStep() / 4;
          IntBuffer localIntBuffer2 = IntBuffer.wrap(arrayOfInt, i1, arrayOfInt.length - i1);
          if (paramBoolean) {}
          for (int i7 = n;; i7 = 0)
          {
            flipCopyWithGamma(localIntBuffer1, i6, localIntBuffer2, m, paramDouble, bool, i7);
            return;
          }
        }
        if ((localDataBuffer instanceof DataBufferShort))
        {
          short[] arrayOfShort2 = ((DataBufferShort)localDataBuffer).getData();
          ShortBuffer localShortBuffer3 = localByteBuffer1.asShortBuffer();
          int i4 = widthStep() / 2;
          ShortBuffer localShortBuffer4 = ShortBuffer.wrap(arrayOfShort2, i1, arrayOfShort2.length - i1);
          if (paramBoolean) {}
          for (int i5 = n;; i5 = 0)
          {
            flipCopyWithGamma(localShortBuffer3, i4, localShortBuffer4, m, true, paramDouble, bool, i5);
            return;
          }
        }
        if ((localDataBuffer instanceof DataBufferUShort))
        {
          short[] arrayOfShort1 = ((DataBufferUShort)localDataBuffer).getData();
          ShortBuffer localShortBuffer1 = localByteBuffer1.asShortBuffer();
          int i2 = widthStep() / 2;
          ShortBuffer localShortBuffer2 = ShortBuffer.wrap(arrayOfShort1, i1, arrayOfShort1.length - i1);
          if (paramBoolean) {}
          for (int i3 = n;; i3 = 0)
          {
            flipCopyWithGamma(localShortBuffer1, i2, localShortBuffer2, m, false, paramDouble, bool, i3);
            return;
          }
        }
      } while ($assertionsDisabled);
      throw new AssertionError();
    }
    
    public CvSize cvSize()
    {
      return opencv_core.cvSize(width(), height());
    }
    
    public native int dataOrder();
    
    public native IplImage dataOrder(int paramInt);
    
    public native int depth();
    
    public native IplImage depth(int paramInt);
    
    public BufferedImage getBufferedImage()
    {
      return getBufferedImage(1.0D);
    }
    
    public BufferedImage getBufferedImage(double paramDouble)
    {
      return getBufferedImage(paramDouble, false);
    }
    
    public BufferedImage getBufferedImage(double paramDouble, boolean paramBoolean)
    {
      return getBufferedImage(paramDouble, paramBoolean, null);
    }
    
    public BufferedImage getBufferedImage(double paramDouble, boolean paramBoolean, ColorSpace paramColorSpace)
    {
      int i = getBufferedImageType();
      if ((this.bufferedImage == null) && (i != 0) && (paramColorSpace == null)) {
        this.bufferedImage = new BufferedImage(width(), height(), i);
      }
      boolean bool2;
      int[] arrayOfInt;
      ComponentColorModel localComponentColorModel;
      WritableRaster localWritableRaster;
      if (this.bufferedImage == null)
      {
        if (nChannels() == 1)
        {
          bool2 = false;
          if (paramColorSpace == null) {
            paramColorSpace = ColorSpace.getInstance(1003);
          }
          arrayOfInt = new int[] { 0 };
          if ((depth() != 8) && (depth() != -2147483640)) {
            break label346;
          }
          localComponentColorModel = new ComponentColorModel(paramColorSpace, bool2, false, 1, 0);
          localWritableRaster = Raster.createWritableRaster(new ComponentSampleModel(0, width(), height(), nChannels(), widthStep(), arrayOfInt), null);
          label151:
          this.bufferedImage = new BufferedImage(localComponentColorModel, localWritableRaster, false, null);
        }
      }
      else if (this.bufferedImage != null)
      {
        IplROI localIplROI = roi();
        if (localIplROI == null) {
          break label681;
        }
        copyTo(((BufferedImage)this.bufferedImage).getSubimage(localIplROI.xOffset(), localIplROI.yOffset(), localIplROI.width(), localIplROI.height()), paramDouble, paramBoolean);
      }
      for (;;)
      {
        return (BufferedImage)this.bufferedImage;
        if (nChannels() == 3)
        {
          if (paramColorSpace == null) {
            paramColorSpace = ColorSpace.getInstance(1004);
          }
          arrayOfInt = new int[] { 2, 1, 0 };
          bool2 = false;
          break;
        }
        if (nChannels() == 4)
        {
          bool2 = true;
          if (paramColorSpace == null) {
            paramColorSpace = ColorSpace.getInstance(1004);
          }
          arrayOfInt = new int[] { 0, 1, 2, 3 };
          break;
        }
        boolean bool1 = $assertionsDisabled;
        bool2 = false;
        arrayOfInt = null;
        if (bool1) {
          break;
        }
        throw new AssertionError();
        label346:
        if (depth() == 16)
        {
          localComponentColorModel = new ComponentColorModel(paramColorSpace, bool2, false, 1, 1);
          localWritableRaster = Raster.createWritableRaster(new ComponentSampleModel(1, width(), height(), nChannels(), widthStep() / 2, arrayOfInt), null);
          break label151;
        }
        if (depth() == -2147483632)
        {
          localComponentColorModel = new ComponentColorModel(paramColorSpace, bool2, false, 1, 2);
          localWritableRaster = Raster.createWritableRaster(new ComponentSampleModel(2, width(), height(), nChannels(), widthStep() / 2, arrayOfInt), null);
          break label151;
        }
        if (depth() == -2147483616)
        {
          localComponentColorModel = new ComponentColorModel(paramColorSpace, bool2, false, 1, 3);
          localWritableRaster = Raster.createWritableRaster(new ComponentSampleModel(3, width(), height(), nChannels(), widthStep() / 4, arrayOfInt), null);
          break label151;
        }
        if (depth() == 32)
        {
          localComponentColorModel = new ComponentColorModel(paramColorSpace, bool2, false, 1, 4);
          localWritableRaster = Raster.createWritableRaster(new ComponentSampleModel(4, width(), height(), nChannels(), widthStep() / 4, arrayOfInt), null);
          break label151;
        }
        if (depth() == 64)
        {
          localComponentColorModel = new ComponentColorModel(paramColorSpace, bool2, false, 1, 5);
          localWritableRaster = Raster.createWritableRaster(new ComponentSampleModel(5, width(), height(), nChannels(), widthStep() / 8, arrayOfInt), null);
          break label151;
        }
        boolean bool3 = $assertionsDisabled;
        localComponentColorModel = null;
        localWritableRaster = null;
        if (bool3) {
          break label151;
        }
        throw new AssertionError();
        label681:
        copyTo((BufferedImage)this.bufferedImage, paramDouble, paramBoolean);
      }
    }
    
    public int getBufferedImageType()
    {
      int j;
      if (nChannels() == 1) {
        if ((depth() == 8) || (depth() == -2147483640)) {
          j = 10;
        }
      }
      label85:
      int k;
      do
      {
        int i;
        do
        {
          int m;
          do
          {
            int n;
            do
            {
              return j;
              n = depth();
              j = 0;
            } while (n != 16);
            return 11;
            if (nChannels() != 3) {
              break label85;
            }
            if (depth() == 8) {
              break;
            }
            m = depth();
            j = 0;
          } while (m != -2147483640);
          return 5;
          i = nChannels();
          j = 0;
        } while (i != 4);
        if (depth() == 8) {
          break;
        }
        k = depth();
        j = 0;
      } while (k != -2147483640);
      return 6;
    }
    
    public ByteBuffer getByteBuffer()
    {
      return getByteBuffer(0);
    }
    
    public ByteBuffer getByteBuffer(int paramInt)
    {
      return imageData().position(paramInt).capacity(imageSize()).asByteBuffer();
    }
    
    public DoubleBuffer getDoubleBuffer()
    {
      return getDoubleBuffer(0);
    }
    
    public DoubleBuffer getDoubleBuffer(int paramInt)
    {
      return getByteBuffer(paramInt * 8).asDoubleBuffer();
    }
    
    public FloatBuffer getFloatBuffer()
    {
      return getFloatBuffer(0);
    }
    
    public FloatBuffer getFloatBuffer(int paramInt)
    {
      return getByteBuffer(paramInt * 4).asFloatBuffer();
    }
    
    public IntBuffer getIntBuffer()
    {
      return getIntBuffer(0);
    }
    
    public IntBuffer getIntBuffer(int paramInt)
    {
      return getByteBuffer(paramInt * 4).asIntBuffer();
    }
    
    public ShortBuffer getShortBuffer()
    {
      return getShortBuffer(0);
    }
    
    public ShortBuffer getShortBuffer(int paramInt)
    {
      return getByteBuffer(paramInt * 2).asShortBuffer();
    }
    
    public native int height();
    
    public native IplImage height(int paramInt);
    
    public double highValue()
    {
      double d = 0.0D;
      switch (depth())
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
      case 8: 
        d = 255.0D;
        return d;
      case 16: 
        return 65535.0D;
      case -2147483640: 
        return 127.0D;
      case -2147483632: 
        return 32767.0D;
      case -2147483616: 
        return 2.147483647E9D;
      }
      return 1.0D;
    }
    
    @Cast({"char*"})
    public native BytePointer imageData();
    
    public native IplImage imageData(BytePointer paramBytePointer);
    
    @MemberSetter
    public native IplImage imageData(@Cast({"char*"}) ByteBuffer paramByteBuffer);
    
    @Cast({"char*"})
    public native BytePointer imageDataOrigin();
    
    public native IplImage imageDataOrigin(BytePointer paramBytePointer);
    
    public native Pointer imageId();
    
    public native IplImage imageId(Pointer paramPointer);
    
    public native int imageSize();
    
    public native IplImage imageSize(int paramInt);
    
    public native IplImage maskROI();
    
    public native IplImage maskROI(IplImage paramIplImage);
    
    public native int nChannels();
    
    public native IplImage nChannels(int paramInt);
    
    public native int nSize();
    
    public native IplImage nSize(int paramInt);
    
    public native int origin();
    
    public native IplImage origin(int paramInt);
    
    public IplImage position(int paramInt)
    {
      return (IplImage)super.position(paramInt);
    }
    
    public void release()
    {
      deallocate();
    }
    
    public native IplImage roi(IplROI paramIplROI);
    
    public native IplROI roi();
    
    public native IplImage tileInfo(IplTileInfo paramIplTileInfo);
    
    public native IplTileInfo tileInfo();
    
    public String toString()
    {
      if (isNull()) {
        return super.toString();
      }
      return "IplImage[width=" + width() + ",height=" + height() + ",depth=" + depth() + ",nChannels=" + nChannels() + "]";
    }
    
    public native int width();
    
    public native IplImage width(int paramInt);
    
    public native int widthStep();
    
    public native IplImage widthStep(int paramInt);
    
    protected static class HeaderReleaseDeallocator
      extends IplImage
      implements Pointer.Deallocator
    {
      HeaderReleaseDeallocator(IplImage paramIplImage)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseImageHeader(this);
      }
    }
    
    protected static class ReleaseDeallocator
      extends IplImage
      implements Pointer.Deallocator
    {
      ReleaseDeallocator(IplImage paramIplImage)
      {
        super();
      }
      
      public void deallocate()
      {
        opencv_core.cvReleaseImage(this);
      }
    }
  }
  
  @Name({"IplImage*"})
  public static class IplImageArray
    extends CvArrArray
  {
    public IplImageArray(int paramInt)
    {
      super();
      allocateArray(paramInt);
    }
    
    public IplImageArray(Pointer paramPointer)
    {
      super();
    }
    
    public IplImageArray(IplImage... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
      position(0);
    }
    
    private native void allocateArray(int paramInt);
    
    @ValueGetter
    public native opencv_core.IplImage get();
    
    public IplImageArray position(int paramInt)
    {
      return (IplImageArray)super.position(paramInt);
    }
    
    public IplImageArray put(CvArr paramCvArr)
    {
      if ((paramCvArr instanceof IplImage)) {
        return (IplImageArray)super.put(paramCvArr);
      }
      throw new ArrayStoreException(paramCvArr.getClass().getName());
    }
    
    public IplImageArray put(CvArr... paramVarArgs)
    {
      return (IplImageArray)super.put(paramVarArgs);
    }
  }
  
  public static class IplROI
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IplROI()
    {
      allocate();
    }
    
    public IplROI(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public IplROI(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int coi();
    
    public native IplROI coi(int paramInt);
    
    public native int height();
    
    public native IplROI height(int paramInt);
    
    public IplROI position(int paramInt)
    {
      return (IplROI)super.position(paramInt);
    }
    
    public native int width();
    
    public native IplROI width(int paramInt);
    
    public native int xOffset();
    
    public native IplROI xOffset(int paramInt);
    
    public native int yOffset();
    
    public native IplROI yOffset(int paramInt);
  }
  
  @Opaque
  public static class IplTileInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public IplTileInfo() {}
    
    public IplTileInfo(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Namespace("cv")
  @NoOffset
  public static class KDTree
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public KDTree()
    {
      allocate();
    }
    
    public KDTree(Pointer paramPointer)
    {
      super();
    }
    
    public KDTree(CvMat paramCvMat1, CvMat paramCvMat2, boolean paramBoolean)
    {
      allocate(paramCvMat1, paramCvMat2, paramBoolean);
    }
    
    public KDTree(CvMat paramCvMat, boolean paramBoolean)
    {
      allocate(paramCvMat, paramBoolean);
    }
    
    private native void allocate();
    
    private native void allocate(@InputArray CvMat paramCvMat1, @InputArray CvMat paramCvMat2, @Cast({"bool"}) boolean paramBoolean);
    
    private native void allocate(@InputArray CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
    
    public native void build(@InputArray CvMat paramCvMat1, @InputArray CvMat paramCvMat2, @Cast({"bool"}) boolean paramBoolean);
    
    public native void build(@InputArray CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
    
    public native int dims();
    
    public native int findNearest(@InputArray FloatPointer paramFloatPointer1, int paramInt1, int paramInt2, @OutputArray IntPointer paramIntPointer1, @OutputArray CvMat paramCvMat, @OutputArray FloatPointer paramFloatPointer2, @OutputArray IntPointer paramIntPointer2);
    
    public native int findNearest(@InputArray CvMat paramCvMat1, int paramInt1, int paramInt2, @OutputArray CvMat paramCvMat2, @OutputArray CvMat paramCvMat3, @OutputArray CvMat paramCvMat4, @OutputArray CvMat paramCvMat5);
    
    public native void findOrthoRange(@InputArray FloatPointer paramFloatPointer1, @InputArray FloatPointer paramFloatPointer2, @OutputArray IntPointer paramIntPointer1, @OutputArray CvMat paramCvMat, @OutputArray IntPointer paramIntPointer2);
    
    public native void findOrthoRange(@InputArray CvMat paramCvMat1, @InputArray CvMat paramCvMat2, @OutputArray CvMat paramCvMat3, @OutputArray CvMat paramCvMat4, @OutputArray CvMat paramCvMat5);
    
    @Const
    public native FloatPointer getPoint(int paramInt, int[] paramArrayOfInt);
    
    public native void getPoints(@InputArray FloatPointer paramFloatPointer, @OutputArray CvMat paramCvMat, @OutputArray IntPointer paramIntPointer);
    
    public native void getPoints(@InputArray CvMat paramCvMat1, @OutputArray CvMat paramCvMat2, @OutputArray CvMat paramCvMat3);
    
    @Const
    @StdVector
    public native IntPointer labels();
    
    public native KDTree labels(IntPointer paramIntPointer);
    
    public native int maxDepth();
    
    public native KDTree maxDepth(int paramInt);
    
    @Const
    @StdVector
    public native Node nodes();
    
    public native KDTree nodes(Node paramNode);
    
    public native int normType();
    
    public native KDTree normType(int paramInt);
    
    @InputMat
    public native CvMat points();
    
    public native KDTree points(CvMat paramCvMat);
    
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
      
      public Node(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
      {
        allocate(paramInt1, paramInt2, paramInt3, paramFloat);
      }
      
      public Node(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      private native void allocate(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
      
      private native void allocateArray(int paramInt);
      
      public native float boundary();
      
      public native Node boundary(float paramFloat);
      
      public native int idx();
      
      public native Node idx(int paramInt);
      
      public native int left();
      
      public native Node left(int paramInt);
      
      public Node position(int paramInt)
      {
        return (Node)super.position(paramInt);
      }
      
      public native int right();
      
      public native Node right(int paramInt);
    }
  }
  
  @Name({"std::vector<cv::Mat>"})
  public static class MatVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public MatVector()
    {
      allocate();
    }
    
    public MatVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public MatVector(Pointer paramPointer)
    {
      super();
    }
    
    public MatVector(CvArr... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @Index
    @ValueGetter
    @OutputMat
    public native opencv_core.CvMat getCvMat(@Cast({"size_t"}) long paramLong);
    
    @Index
    @ValueGetter
    @OutputMat
    public native opencv_core.CvMatND getCvMatND(@Cast({"size_t"}) long paramLong);
    
    @Index
    @ValueGetter
    @OutputMat
    public native opencv_core.IplImage getIplImage(@Cast({"size_t"}) long paramLong);
    
    @Index
    @ValueSetter
    public native MatVector put(@Cast({"size_t"}) long paramLong, @InputMat CvArr paramCvArr);
    
    public MatVector put(CvArr... paramVarArgs)
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
  
  @Adapter("ArrayAdapter")
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
  public static @interface OutputArray {}
  
  @Adapter("MatAdapter")
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
  public static @interface OutputMat {}
  
  @Namespace("cv")
  @NoOffset
  public static class Param
    extends Pointer
  {
    public static final int ALGORITHM = 6;
    public static final int BOOLEAN = 1;
    public static final int FLOAT = 7;
    public static final int INT = 0;
    public static final int MAT = 4;
    public static final int MAT_VECTOR = 5;
    public static final int REAL = 2;
    public static final int SHORT = 10;
    public static final int STRING = 3;
    public static final int UCHAR = 11;
    public static final int UINT64 = 9;
    public static final int UNSIGNED_INT = 8;
    
    static
    {
      Loader.load();
    }
    
    public Param()
    {
      allocate();
    }
    
    public Param(int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2, Algorithm.Getter paramGetter, Algorithm.Setter paramSetter, String paramString)
    {
      allocate(paramInt1, paramBoolean, paramInt2, paramGetter, paramSetter, paramString);
    }
    
    public Param(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2, Algorithm.Getter paramGetter, Algorithm.Setter paramSetter, String paramString);
    
    public native Algorithm.Getter getter();
    
    public native Param getter(Algorithm.Getter paramGetter);
    
    public native Param help(String paramString);
    
    @ByRef
    public native String help();
    
    public native int offset();
    
    public native Param offset(int paramInt);
    
    public native Param readonly(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean readonly();
    
    public native Algorithm.Setter setter();
    
    public native Param setter(Algorithm.Setter paramSetter);
    
    public native int type();
    
    public native Param type(int paramInt);
  }
  
  @Name({"std::vector<std::vector<cv::Point2d> >"})
  public static class Point2dVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Point2dVectorVector()
    {
      allocate();
    }
    
    public Point2dVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public Point2dVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    @Index
    public native opencv_core.CvPoint2D32f get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native Point2dVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, CvPoint2D32f paramCvPoint2D32f);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  @Name({"std::vector<std::vector<cv::Point2f> >"})
  public static class Point2fVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Point2fVectorVector()
    {
      allocate();
    }
    
    public Point2fVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public Point2fVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    @Index
    public native opencv_core.CvPoint2D32f get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native Point2fVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, CvPoint2D32f paramCvPoint2D32f);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  @Name({"std::vector<std::vector<cv::Point> >"})
  public static class PointVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public PointVectorVector()
    {
      allocate();
    }
    
    public PointVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public PointVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    @Index
    public native opencv_core.CvPoint get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native PointVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, CvPoint paramCvPoint);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  public static class Predicate
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Predicate()
    {
      allocate();
    }
    
    public Predicate(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native boolean call(Pointer paramPointer1, Pointer paramPointer2);
  }
  
  @Adapter("PtrAdapter")
  @Cast({"cv::Ptr", "&"})
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
  public static @interface Ptr
  {
    String value() default "";
  }
  
  @Name({"std::vector<std::vector<cv::Rect> >"})
  public static class RectVectorVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public RectVectorVector()
    {
      allocate();
    }
    
    public RectVectorVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public RectVectorVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByVal
    @Index
    public native opencv_core.CvRect get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native RectVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, CvRect paramCvRect);
    
    public native void resize(@Cast({"size_t"}) long paramLong);
    
    @Index
    public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
    
    public native long size();
    
    @Index
    public native long size(@Cast({"size_t"}) long paramLong);
  }
  
  @Name({"std::vector<std::string>"})
  public static class StringVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public StringVector()
    {
      allocate();
    }
    
    public StringVector(long paramLong)
    {
      allocate(paramLong);
    }
    
    public StringVector(Pointer paramPointer)
    {
      super();
    }
    
    public StringVector(String... paramVarArgs)
    {
      this(paramVarArgs.length);
      put(paramVarArgs);
    }
    
    private native void allocate();
    
    private native void allocate(@Cast({"size_t"}) long paramLong);
    
    @ByRef
    @Index
    public native String get(@Cast({"size_t"}) long paramLong);
    
    public native StringVector put(@Cast({"size_t"}) long paramLong, String paramString);
    
    public StringVector put(String... paramVarArgs)
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
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_core.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */