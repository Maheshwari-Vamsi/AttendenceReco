package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@Platform(include={"<opencv2/highgui/highgui_c.h>"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_highgui@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, preload={"opencv_ffmpeg245", "opencv_ffmpeg245_64"}, value={"windows"}), @Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_highgui
{
  public static final int CV_CAP_ANDROID = 1000;
  public static final int CV_CAP_ANDROID_ANTIBANDING_50HZ = 0;
  public static final int CV_CAP_ANDROID_ANTIBANDING_60HZ = 1;
  public static final int CV_CAP_ANDROID_ANTIBANDING_AUTO = 2;
  public static final int CV_CAP_ANDROID_ANTIBANDING_OFF = 3;
  public static final int CV_CAP_ANDROID_COLOR_FRAME = 0;
  public static final int CV_CAP_ANDROID_COLOR_FRAME_BGR = 0;
  public static final int CV_CAP_ANDROID_COLOR_FRAME_BGRA = 3;
  public static final int CV_CAP_ANDROID_COLOR_FRAME_RGB = 2;
  public static final int CV_CAP_ANDROID_COLOR_FRAME_RGBA = 4;
  public static final int CV_CAP_ANDROID_FLASH_MODE_AUTO = 0;
  public static final int CV_CAP_ANDROID_FLASH_MODE_OFF = 1;
  public static final int CV_CAP_ANDROID_FLASH_MODE_ON = 2;
  public static final int CV_CAP_ANDROID_FLASH_MODE_RED_EYE = 3;
  public static final int CV_CAP_ANDROID_FLASH_MODE_TORCH = 4;
  public static final int CV_CAP_ANDROID_FOCUS_MODE_AUTO = 0;
  public static final int CV_CAP_ANDROID_FOCUS_MODE_CONTINUOUS_VIDEO = 1;
  public static final int CV_CAP_ANDROID_FOCUS_MODE_EDOF = 2;
  public static final int CV_CAP_ANDROID_FOCUS_MODE_FIXED = 3;
  public static final int CV_CAP_ANDROID_FOCUS_MODE_INFINITY = 4;
  public static final int CV_CAP_ANDROID_FOCUS_MODE_MACRO = 5;
  public static final int CV_CAP_ANDROID_GREY_FRAME = 1;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_AUTO = 0;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_CLOUDY_DAYLIGHT = 1;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_DAYLIGHT = 2;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_FLUORESCENT = 3;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_INCANDESCENT = 4;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_SHADE = 5;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_TWILIGHT = 6;
  public static final int CV_CAP_ANDROID_WHITE_BALANCE_WARM_FLUORESCENT = 7;
  public static final int CV_CAP_ANY = 0;
  public static final int CV_CAP_AVFOUNDATION = 1200;
  public static final int CV_CAP_CMU1394 = 300;
  public static final int CV_CAP_DC1394 = 300;
  public static final int CV_CAP_DSHOW = 700;
  public static final int CV_CAP_FIREWARE = 300;
  public static final int CV_CAP_FIREWIRE = 300;
  public static final int CV_CAP_GIGANETIX = 1300;
  public static final int CV_CAP_GSTREAMER_QUEUE_LENGTH = 200;
  public static final int CV_CAP_IEEE1394 = 300;
  public static final int CV_CAP_MIL = 100;
  public static final int CV_CAP_MSMF = 1400;
  public static final int CV_CAP_OPENNI = 900;
  public static final int CV_CAP_OPENNI_ASUS = 910;
  public static final int CV_CAP_OPENNI_BGR_IMAGE = 5;
  public static final int CV_CAP_OPENNI_DEPTH_GENERATOR = Integer.MIN_VALUE;
  public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_BASELINE = -2147483546;
  public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_FOCAL_LENGTH = -2147483545;
  public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION = -2147483544;
  public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION_ON = -2147483544;
  public static final int CV_CAP_OPENNI_DEPTH_MAP = 0;
  public static final int CV_CAP_OPENNI_DISPARITY_MAP = 2;
  public static final int CV_CAP_OPENNI_DISPARITY_MAP_32F = 3;
  public static final int CV_CAP_OPENNI_GENERATORS_MASK = -1073741824;
  public static final int CV_CAP_OPENNI_GRAY_IMAGE = 6;
  public static final int CV_CAP_OPENNI_IMAGE_GENERATOR = 1073741824;
  public static final int CV_CAP_OPENNI_IMAGE_GENERATOR_OUTPUT_MODE = 1073741924;
  public static final int CV_CAP_OPENNI_IMAGE_GENERATOR_PRESENT = 1073741933;
  public static final int CV_CAP_OPENNI_POINT_CLOUD_MAP = 1;
  public static final int CV_CAP_OPENNI_QVGA_30HZ = 3;
  public static final int CV_CAP_OPENNI_QVGA_60HZ = 4;
  public static final int CV_CAP_OPENNI_SXGA_15HZ = 1;
  public static final int CV_CAP_OPENNI_SXGA_30HZ = 2;
  public static final int CV_CAP_OPENNI_VALID_DEPTH_MASK = 4;
  public static final int CV_CAP_OPENNI_VGA_30HZ = 0;
  public static final int CV_CAP_PROP_ANDROID_ANTIBANDING = 8004;
  public static final int CV_CAP_PROP_ANDROID_FLASH_MODE = 8001;
  public static final int CV_CAP_PROP_ANDROID_FOCAL_LENGTH = 8005;
  public static final int CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_FAR = 8008;
  public static final int CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_NEAR = 8006;
  public static final int CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_OPTIMAL = 8007;
  public static final int CV_CAP_PROP_ANDROID_FOCUS_MODE = 8002;
  public static final int CV_CAP_PROP_ANDROID_WHITE_BALANCE = 8003;
  public static final int CV_CAP_PROP_AUTOGRAB = 1024;
  public static final int CV_CAP_PROP_AUTO_EXPOSURE = 21;
  public static final int CV_CAP_PROP_BACKLIGHT = 32;
  public static final int CV_CAP_PROP_BRIGHTNESS = 10;
  public static final int CV_CAP_PROP_CONTRAST = 11;
  public static final int CV_CAP_PROP_CONVERT_RGB = 16;
  public static final int CV_CAP_PROP_DC1394_MODE_AUTO = -2;
  public static final int CV_CAP_PROP_DC1394_MODE_MANUAL = -3;
  public static final int CV_CAP_PROP_DC1394_MODE_ONE_PUSH_AUTO = -1;
  public static final int CV_CAP_PROP_DC1394_OFF = -4;
  public static final int CV_CAP_PROP_EXPOSURE = 15;
  public static final int CV_CAP_PROP_FOCUS = 28;
  public static final int CV_CAP_PROP_FORMAT = 8;
  public static final int CV_CAP_PROP_FOURCC = 6;
  public static final int CV_CAP_PROP_FPS = 5;
  public static final int CV_CAP_PROP_FRAME_COUNT = 7;
  public static final int CV_CAP_PROP_FRAME_HEIGHT = 4;
  public static final int CV_CAP_PROP_FRAME_WIDTH = 3;
  public static final int CV_CAP_PROP_GAIN = 14;
  public static final int CV_CAP_PROP_GAMMA = 22;
  public static final int CV_CAP_PROP_GIGA_FRAME_HEIGH_MAX = 10004;
  public static final int CV_CAP_PROP_GIGA_FRAME_OFFSET_X = 10001;
  public static final int CV_CAP_PROP_GIGA_FRAME_OFFSET_Y = 10002;
  public static final int CV_CAP_PROP_GIGA_FRAME_SENS_HEIGH = 10006;
  public static final int CV_CAP_PROP_GIGA_FRAME_SENS_WIDTH = 10005;
  public static final int CV_CAP_PROP_GIGA_FRAME_WIDTH_MAX = 10003;
  public static final int CV_CAP_PROP_GUID = 29;
  public static final int CV_CAP_PROP_HUE = 13;
  public static final int CV_CAP_PROP_IOS_DEVICE_EXPOSURE = 9002;
  public static final int CV_CAP_PROP_IOS_DEVICE_FLASH = 9003;
  public static final int CV_CAP_PROP_IOS_DEVICE_FOCUS = 9001;
  public static final int CV_CAP_PROP_IOS_DEVICE_TORCH = 9005;
  public static final int CV_CAP_PROP_IOS_DEVICE_WHITEBALANCE = 9004;
  public static final int CV_CAP_PROP_IRIS = 36;
  public static final int CV_CAP_PROP_ISO_SPEED = 30;
  public static final int CV_CAP_PROP_MAX_DC1394 = 31;
  public static final int CV_CAP_PROP_MODE = 9;
  public static final int CV_CAP_PROP_MONOCROME = 19;
  public static final int CV_CAP_PROP_OPENNI_APPROX_FRAME_SYNC = 105;
  public static final int CV_CAP_PROP_OPENNI_BASELINE = 102;
  public static final int CV_CAP_PROP_OPENNI_CIRCLE_BUFFER = 107;
  public static final int CV_CAP_PROP_OPENNI_FOCAL_LENGTH = 103;
  public static final int CV_CAP_PROP_OPENNI_FRAME_MAX_DEPTH = 101;
  public static final int CV_CAP_PROP_OPENNI_GENERATOR_PRESENT = 109;
  public static final int CV_CAP_PROP_OPENNI_MAX_BUFFER_SIZE = 106;
  public static final int CV_CAP_PROP_OPENNI_MAX_TIME_DURATION = 108;
  public static final int CV_CAP_PROP_OPENNI_OUTPUT_MODE = 100;
  public static final int CV_CAP_PROP_OPENNI_REGISTRATION = 104;
  public static final int CV_CAP_PROP_OPENNI_REGISTRATION_ON = 104;
  public static final int CV_CAP_PROP_PAN = 33;
  public static final int CV_CAP_PROP_POS_AVI_RATIO = 2;
  public static final int CV_CAP_PROP_POS_FRAMES = 1;
  public static final int CV_CAP_PROP_POS_MSEC = 0;
  public static final int CV_CAP_PROP_PREVIEW_FORMAT = 1025;
  public static final int CV_CAP_PROP_PVAPI_MULTICASTIP = 300;
  public static final int CV_CAP_PROP_RECTIFICATION = 18;
  public static final int CV_CAP_PROP_ROLL = 35;
  public static final int CV_CAP_PROP_SATURATION = 12;
  public static final int CV_CAP_PROP_SETTINGS = 37;
  public static final int CV_CAP_PROP_SHARPNESS = 20;
  public static final int CV_CAP_PROP_SUPPORTED_PREVIEW_SIZES_STRING = 1025;
  public static final int CV_CAP_PROP_TEMPERATURE = 23;
  public static final int CV_CAP_PROP_TILT = 34;
  public static final int CV_CAP_PROP_TRIGGER = 24;
  public static final int CV_CAP_PROP_TRIGGER_DELAY = 25;
  public static final int CV_CAP_PROP_WHITE_BALANCE_BLUE_U = 17;
  public static final int CV_CAP_PROP_WHITE_BALANCE_RED_V = 26;
  public static final int CV_CAP_PROP_XI_AEAG = 415;
  public static final int CV_CAP_PROP_XI_AEAG_LEVEL = 419;
  public static final int CV_CAP_PROP_XI_AE_MAX_LIMIT = 417;
  public static final int CV_CAP_PROP_XI_AG_MAX_LIMIT = 418;
  public static final int CV_CAP_PROP_XI_AUTO_WB = 414;
  public static final int CV_CAP_PROP_XI_DATA_FORMAT = 401;
  public static final int CV_CAP_PROP_XI_DOWNSAMPLING = 400;
  public static final int CV_CAP_PROP_XI_EXP_PRIORITY = 416;
  public static final int CV_CAP_PROP_XI_GPI_LEVEL = 408;
  public static final int CV_CAP_PROP_XI_GPI_MODE = 407;
  public static final int CV_CAP_PROP_XI_GPI_SELECTOR = 406;
  public static final int CV_CAP_PROP_XI_GPO_MODE = 410;
  public static final int CV_CAP_PROP_XI_GPO_SELECTOR = 409;
  public static final int CV_CAP_PROP_XI_LED_MODE = 412;
  public static final int CV_CAP_PROP_XI_LED_SELECTOR = 411;
  public static final int CV_CAP_PROP_XI_MANUAL_WB = 413;
  public static final int CV_CAP_PROP_XI_OFFSET_X = 402;
  public static final int CV_CAP_PROP_XI_OFFSET_Y = 403;
  public static final int CV_CAP_PROP_XI_TIMEOUT = 420;
  public static final int CV_CAP_PROP_XI_TRG_SOFTWARE = 405;
  public static final int CV_CAP_PROP_XI_TRG_SOURCE = 404;
  public static final int CV_CAP_PROP_ZOOM = 27;
  public static final int CV_CAP_PVAPI = 800;
  public static final int CV_CAP_QT = 500;
  public static final int CV_CAP_STEREO = 400;
  public static final int CV_CAP_TYZX = 400;
  public static final int CV_CAP_UNICAP = 600;
  public static final int CV_CAP_V4L = 200;
  public static final int CV_CAP_V4L2 = 200;
  public static final int CV_CAP_VFW = 200;
  public static final int CV_CAP_XIAPI = 1100;
  public static int CV_CHECKBOX = 0;
  public static final int CV_CVTIMG_FLIP = 1;
  public static final int CV_CVTIMG_SWAP_RB = 2;
  public static final int CV_EVENT_FLAG_ALTKEY = 32;
  public static final int CV_EVENT_FLAG_CTRLKEY = 8;
  public static final int CV_EVENT_FLAG_LBUTTON = 1;
  public static final int CV_EVENT_FLAG_MBUTTON = 4;
  public static final int CV_EVENT_FLAG_RBUTTON = 2;
  public static final int CV_EVENT_FLAG_SHIFTKEY = 16;
  public static final int CV_EVENT_LBUTTONDBLCLK = 7;
  public static final int CV_EVENT_LBUTTONDOWN = 1;
  public static final int CV_EVENT_LBUTTONUP = 4;
  public static final int CV_EVENT_MBUTTONDBLCLK = 9;
  public static final int CV_EVENT_MBUTTONDOWN = 3;
  public static final int CV_EVENT_MBUTTONUP = 6;
  public static final int CV_EVENT_MOUSEMOVE = 0;
  public static final int CV_EVENT_RBUTTONDBLCLK = 8;
  public static final int CV_EVENT_RBUTTONDOWN = 2;
  public static final int CV_EVENT_RBUTTONUP = 5;
  public static final int CV_FONT_BLACK = 87;
  public static final int CV_FONT_BOLD = 75;
  public static final int CV_FONT_DEMIBOLD = 63;
  public static final int CV_FONT_LIGHT = 25;
  public static final int CV_FONT_NORMAL = 50;
  public static final int CV_FOURCC_DEFAULT = CV_FOURCC('I', 'Y', 'U', 'V');
  public static final int CV_FOURCC_PROMPT = -1;
  public static final int CV_GUI_EXPANDED = 0;
  public static final int CV_GUI_NORMAL = 16;
  public static final int CV_IMWRITE_JPEG_QUALITY = 1;
  public static final int CV_IMWRITE_PNG_BILEVEL = 18;
  public static final int CV_IMWRITE_PNG_COMPRESSION = 16;
  public static final int CV_IMWRITE_PNG_STRATEGY = 17;
  public static final int CV_IMWRITE_PNG_STRATEGY_DEFAULT = 0;
  public static final int CV_IMWRITE_PNG_STRATEGY_FILTERED = 1;
  public static final int CV_IMWRITE_PNG_STRATEGY_FIXED = 4;
  public static final int CV_IMWRITE_PNG_STRATEGY_HUFFMAN_ONLY = 2;
  public static final int CV_IMWRITE_PNG_STRATEGY_RLE = 3;
  public static final int CV_IMWRITE_PXM_BINARY = 32;
  public static final int CV_LOAD_IMAGE_ANYCOLOR = 4;
  public static final int CV_LOAD_IMAGE_ANYDEPTH = 2;
  public static final int CV_LOAD_IMAGE_COLOR = 1;
  public static final int CV_LOAD_IMAGE_GRAYSCALE = 0;
  public static final int CV_LOAD_IMAGE_UNCHANGED = -1;
  public static int CV_PUSH_BUTTON = 0;
  public static int CV_RADIOBOX = 0;
  public static final int CV_STYLE_ITALIC = 1;
  public static final int CV_STYLE_NORMAL = 0;
  public static final int CV_STYLE_OBLIQUE = 2;
  public static final int CV_TYZX_COLOR = 402;
  public static final int CV_TYZX_LEFT = 400;
  public static final int CV_TYZX_RIGHT = 401;
  public static final int CV_TYZX_Z = 403;
  public static final int CV_WINDOW_AUTOSIZE = 1;
  public static final int CV_WINDOW_FREERATIO = 256;
  public static final int CV_WINDOW_FULLSCREEN = 1;
  public static final int CV_WINDOW_KEEPRATIO = 0;
  public static final int CV_WINDOW_NORMAL = 0;
  public static final int CV_WINDOW_OPENGL = 4096;
  public static final int CV_WND_PROP_ASPECTRATIO = 2;
  public static final int CV_WND_PROP_AUTOSIZE = 1;
  public static final int CV_WND_PROP_FULLSCREEN = 0;
  public static final int CV_WND_PROP_OPENGL = 3;
  
  static
  {
    Loader.load(opencv_imgproc.class);
    Loader.load();
    CV_PUSH_BUTTON = 0;
    CV_CHECKBOX = 1;
    CV_RADIOBOX = 2;
  }
  
  public static int CV_FOURCC(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return (paramByte1 & 0xFF) + ((paramByte2 & 0xFF) << 8) + ((paramByte3 & 0xFF) << 16) + ((paramByte4 & 0xFF) << 24);
  }
  
  public static int CV_FOURCC(char paramChar1, char paramChar2, char paramChar3, char paramChar4)
  {
    return CV_FOURCC((byte)paramChar1, (byte)paramChar2, (byte)paramChar3, (byte)paramChar4);
  }
  
  @Platform({"linux"})
  public static native void cvAddText(opencv_core.CvArr paramCvArr, String paramString, @ByVal opencv_core.CvPoint paramCvPoint, opencv_core.CvFont paramCvFont);
  
  public static native void cvConvertImage(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
  
  @Platform({"linux"})
  public static native int cvCreateButton(String paramString, CvButtonCallback paramCvButtonCallback, Pointer paramPointer, int paramInt1, int paramInt2);
  
  public static native CvCapture cvCreateCameraCapture(int paramInt);
  
  public static native CvCapture cvCreateFileCapture(String paramString);
  
  public static native int cvCreateTrackbar(String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, CvTrackbarCallback paramCvTrackbarCallback);
  
  public static native int cvCreateTrackbar2(String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, CvTrackbarCallback2 paramCvTrackbarCallback2, Pointer paramPointer);
  
  public static native CvVideoWriter cvCreateVideoWriter(String paramString, int paramInt1, double paramDouble, @ByVal opencv_core.CvSize paramCvSize, int paramInt2);
  
  public static opencv_core.IplImage cvDecodeImage(opencv_core.CvMat paramCvMat)
  {
    return cvDecodeImage(paramCvMat, 1);
  }
  
  public static native opencv_core.IplImage cvDecodeImage(opencv_core.CvMat paramCvMat, int paramInt);
  
  public static opencv_core.CvMat cvDecodeImageM(opencv_core.CvMat paramCvMat)
  {
    return cvDecodeImageM(paramCvMat, 1);
  }
  
  public static native opencv_core.CvMat cvDecodeImageM(opencv_core.CvMat paramCvMat, int paramInt);
  
  public static native void cvDestroyAllWindows();
  
  public static native void cvDestroyWindow(String paramString);
  
  @Platform({"linux"})
  public static native void cvDisplayOverlay(String paramString1, String paramString2, int paramInt);
  
  @Platform({"linux"})
  public static native void cvDisplayStatusBar(String paramString1, String paramString2, int paramInt);
  
  public static opencv_core.CvMat cvEncodeImage(String paramString, opencv_core.CvArr paramCvArr)
  {
    return cvEncodeImage(paramString, paramCvArr, null);
  }
  
  public static native opencv_core.CvMat cvEncodeImage(String paramString, opencv_core.CvArr paramCvArr, int[] paramArrayOfInt);
  
  @ByVal
  @Platform({"linux"})
  public static native opencv_core.CvFont cvFontQt(String paramString, int paramInt1, @ByVal opencv_core.CvScalar paramCvScalar, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int cvGetCaptureDomain(CvCapture paramCvCapture);
  
  public static native double cvGetCaptureProperty(CvCapture paramCvCapture, int paramInt);
  
  public static native int cvGetTrackbarPos(String paramString1, String paramString2);
  
  public static native Pointer cvGetWindowHandle(String paramString);
  
  public static native String cvGetWindowName(Pointer paramPointer);
  
  public static native double cvGetWindowProperty(String paramString, int paramInt);
  
  public static native int cvGrabFrame(CvCapture paramCvCapture);
  
  public static native int cvInitSystem(int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer);
  
  public static opencv_core.IplImage cvLoadImage(String paramString)
  {
    return cvLoadImage(paramString, 1);
  }
  
  public static native opencv_core.IplImage cvLoadImage(String paramString, int paramInt);
  
  public static opencv_core.IplImage cvLoadImageBGRA(String paramString)
  {
    opencv_core.IplImage localIplImage1 = cvLoadImage(paramString, 1);
    if (localIplImage1 == null) {
      return null;
    }
    opencv_core.IplImage localIplImage2 = opencv_core.cvCreateImage(opencv_core.cvGetSize(localIplImage1), localIplImage1.depth(), 4);
    opencv_imgproc.cvCvtColor(localIplImage1, localIplImage2, 0);
    opencv_core.cvReleaseImage(localIplImage1);
    return localIplImage2;
  }
  
  public static opencv_core.CvMat cvLoadImageM(String paramString)
  {
    return cvLoadImageM(paramString, 1);
  }
  
  public static native opencv_core.CvMat cvLoadImageM(String paramString, int paramInt);
  
  public static opencv_core.IplImage cvLoadImageRGBA(String paramString)
  {
    opencv_core.IplImage localIplImage1 = cvLoadImage(paramString, 1);
    if (localIplImage1 == null) {
      return null;
    }
    opencv_core.IplImage localIplImage2 = opencv_core.cvCreateImage(opencv_core.cvGetSize(localIplImage1), localIplImage1.depth(), 4);
    opencv_imgproc.cvCvtColor(localIplImage1, localIplImage2, 2);
    opencv_core.cvReleaseImage(localIplImage1);
    return localIplImage2;
  }
  
  @Platform({"linux"})
  public static native void cvLoadWindowParameters(String paramString);
  
  public static native void cvMoveWindow(String paramString, int paramInt1, int paramInt2);
  
  public static int cvNamedWindow(String paramString)
  {
    return cvNamedWindow(paramString, 1);
  }
  
  public static native int cvNamedWindow(String paramString, int paramInt);
  
  public static native opencv_core.IplImage cvQueryFrame(CvCapture paramCvCapture);
  
  public static native void cvReleaseCapture(@ByPtrPtr CvCapture paramCvCapture);
  
  public static native void cvReleaseVideoWriter(@ByPtrPtr CvVideoWriter paramCvVideoWriter);
  
  public static native void cvResizeWindow(String paramString, int paramInt1, int paramInt2);
  
  public static opencv_core.IplImage cvRetrieveFrame(CvCapture paramCvCapture)
  {
    return cvRetrieveFrame(paramCvCapture, 0);
  }
  
  public static native opencv_core.IplImage cvRetrieveFrame(CvCapture paramCvCapture, int paramInt);
  
  public static int cvSaveImage(String paramString, opencv_core.CvArr paramCvArr)
  {
    return cvSaveImage(paramString, paramCvArr, null);
  }
  
  public static native int cvSaveImage(String paramString, opencv_core.CvArr paramCvArr, int[] paramArrayOfInt);
  
  @Platform({"linux"})
  public static native void cvSaveWindowParameters(String paramString);
  
  public static native int cvSetCaptureProperty(CvCapture paramCvCapture, int paramInt, double paramDouble);
  
  public static native void cvSetMouseCallback(String paramString, CvMouseCallback paramCvMouseCallback, Pointer paramPointer);
  
  public static native void cvSetOpenGlContext(String paramString);
  
  public static native void cvSetOpenGlDrawCallback(String paramString, CvOpenGLCallback paramCvOpenGLCallback, Pointer paramPointer);
  
  public static native void cvSetTrackbarPos(String paramString1, String paramString2, int paramInt);
  
  public static native void cvSetWindowProperty(String paramString, int paramInt, double paramDouble);
  
  public static native void cvShowImage(String paramString, opencv_core.CvArr paramCvArr);
  
  @Platform({"linux"})
  public static native int cvStartLoop(Pt2Func paramPt2Func, int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer);
  
  public static native int cvStartWindowThread();
  
  @Platform({"linux"})
  public static native void cvStopLoop();
  
  public static native void cvUpdateWindow(String paramString);
  
  public static int cvWaitKey()
  {
    return cvWaitKey(0);
  }
  
  public static native int cvWaitKey(int paramInt);
  
  public static native int cvWriteFrame(CvVideoWriter paramCvVideoWriter, opencv_core.IplImage paramIplImage);
  
  @Platform({"linux"})
  public static class CvButtonCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvButtonCallback()
    {
      allocate();
    }
    
    public CvButtonCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(int paramInt, Pointer paramPointer);
  }
  
  @Opaque
  public static class CvCapture
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvCapture() {}
    
    public CvCapture(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class CvMouseCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvMouseCallback()
    {
      allocate();
    }
    
    public CvMouseCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Pointer paramPointer);
  }
  
  public static class CvOpenGLCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvOpenGLCallback()
    {
      allocate();
    }
    
    public CvOpenGLCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(Pointer paramPointer);
  }
  
  public static class CvTrackbarCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvTrackbarCallback()
    {
      allocate();
    }
    
    public CvTrackbarCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(int paramInt);
  }
  
  public static class CvTrackbarCallback2
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected CvTrackbarCallback2()
    {
      allocate();
    }
    
    public CvTrackbarCallback2(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(int paramInt, Pointer paramPointer);
  }
  
  @Opaque
  public static class CvVideoWriter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvVideoWriter() {}
    
    public CvVideoWriter(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Platform({"linux"})
  public static class Pt2Func
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Pt2Func()
    {
      allocate();
    }
    
    public Pt2Func(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_highgui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */