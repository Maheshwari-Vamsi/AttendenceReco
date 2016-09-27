package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.PGRFlyCapture;
import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureContext;
import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureImage;
import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureInfoEx;
import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureTimestamp;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class FlyCaptureFrameGrabber
  extends FrameGrabber
{
  public static final int CAMERA_POWER = 1552;
  public static final int IMAGE_DATA_FORMAT = 4168;
  public static final int INITIALIZE = 0;
  public static final int IS_CAMERA_POWER = 1024;
  public static final int SOFTWARE_TRIGGER = 1580;
  public static final int SOFT_ASYNC_TRIGGER = 4140;
  public static final int TRIGGER_INQ = 1328;
  private static FrameGrabber.Exception loadingException = null;
  private PGRFlyCapture.FlyCaptureContext context = new PGRFlyCapture.FlyCaptureContext(null);
  private PGRFlyCapture.FlyCaptureImage conv_image = new PGRFlyCapture.FlyCaptureImage();
  private final float[] gammaOut = new float[1];
  private final float[] outFloat = new float[1];
  private PGRFlyCapture.FlyCaptureImage raw_image = new PGRFlyCapture.FlyCaptureImage();
  private final int[] regOut = new int[1];
  private opencv_core.IplImage return_image = null;
  private opencv_core.IplImage temp_image;
  
  public FlyCaptureFrameGrabber(int paramInt)
    throws FrameGrabber.Exception
  {
    int i = PGRFlyCapture.flycaptureCreateContext(this.context);
    if (i != 0) {
      throw new FrameGrabber.Exception("flycaptureCreateContext() Error " + i);
    }
    int j = PGRFlyCapture.flycaptureInitializePlus(this.context, paramInt, this.numBuffers, null);
    if (j != 0) {
      throw new FrameGrabber.Exception("flycaptureInitialize() Error " + j);
    }
  }
  
  public static FlyCaptureFrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return new FlyCaptureFrameGrabber(paramInt);
  }
  
  public static FlyCaptureFrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static FlyCaptureFrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  private int getDepth(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 16: 
    case 512: 
    case 268435457: 
    case 268435458: 
    default: 
      return 8;
    case 32: 
    case 64: 
    case 1024: 
      return 16;
    }
    return -2147483632;
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    int[] arrayOfInt = new int[1];
    int i = PGRFlyCapture.flycaptureBusCameraCount(arrayOfInt);
    if (i != 0) {
      throw new FrameGrabber.Exception("flycaptureBusCameraCount() Error " + i);
    }
    int j = arrayOfInt[0];
    String[] arrayOfString = new String[j];
    if (j > 0)
    {
      PGRFlyCapture.FlyCaptureInfoEx localFlyCaptureInfoEx = new PGRFlyCapture.FlyCaptureInfoEx(j);
      int k = PGRFlyCapture.flycaptureBusEnumerateCamerasEx(localFlyCaptureInfoEx, arrayOfInt);
      if (k != 0) {
        throw new FrameGrabber.Exception("flycaptureBusEnumerateCamerasEx() Error " + k);
      }
      for (int m = 0; m < arrayOfString.length; m++)
      {
        localFlyCaptureInfoEx.position(m);
        arrayOfString[m] = (localFlyCaptureInfoEx.pszVendorName() + " " + localFlyCaptureInfoEx.pszModelName() + " " + localFlyCaptureInfoEx.SerialNumber());
      }
    }
    return arrayOfString;
  }
  
  private int getNumChannels(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 16: 
    case 64: 
    case 256: 
    case 268435457: 
      return 3;
    case 1: 
    case 32: 
    case 128: 
    case 512: 
    case 1024: 
      return 1;
    }
    return 4;
  }
  
  public static void tryLoad()
    throws FrameGrabber.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      Loader.load(PGRFlyCapture.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      FrameGrabber.Exception localException = new FrameGrabber.Exception("Failed to load " + FlyCaptureFrameGrabber.class, localThrowable);
      loadingException = localException;
      throw localException;
    }
  }
  
  private void waitForTriggerReady()
    throws FrameGrabber.Exception
  {
    long l = System.currentTimeMillis();
    do
    {
      int i = PGRFlyCapture.flycaptureGetCameraRegister(this.context, 1580, this.regOut);
      if (i != 0) {
        throw new FrameGrabber.Exception("flycaptureGetCameraRegister() Error " + i);
      }
      if (System.currentTimeMillis() - l > this.timeout) {
        return;
      }
    } while (this.regOut[0] >>> 31 != 0);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public double getFrameRate()
  {
    if ((this.context == null) || (this.context.isNull())) {
      return super.getFrameRate();
    }
    PGRFlyCapture.flycaptureGetCameraAbsProperty(this.context, 15, this.outFloat);
    return this.outFloat[0];
  }
  
  public double getGamma()
  {
    if ((Float.isNaN(this.gammaOut[0])) || (Float.isInfinite(this.gammaOut[0])) || (this.gammaOut[0] == 0.0F)) {
      return 2.2D;
    }
    return this.gammaOut[0];
  }
  
  public int getImageHeight()
  {
    if (this.return_image == null) {
      return super.getImageHeight();
    }
    return this.return_image.height();
  }
  
  public int getImageWidth()
  {
    if (this.return_image == null) {
      return super.getImageWidth();
    }
    return this.return_image.width();
  }
  
  public opencv_core.IplImage grab()
    throws FrameGrabber.Exception
  {
    int i = PGRFlyCapture.flycaptureGrabImage2(this.context, this.raw_image);
    if (i != 0) {
      throw new FrameGrabber.Exception("flycaptureGrabImage2() Error " + i + " (Has start() been called?)");
    }
    int j = this.raw_image.iCols();
    int k = this.raw_image.iRows();
    int m = this.raw_image.pixelFormat();
    int n = getDepth(m);
    int i1 = this.raw_image.iRowInc();
    int i2 = k * i1;
    int i3 = getNumChannels(m);
    int i4 = PGRFlyCapture.flycaptureGetCameraRegister(this.context, 4168, this.regOut);
    if (i4 != 0) {
      throw new FrameGrabber.Exception("flycaptureGetCameraRegister() Error " + i4);
    }
    ByteOrder localByteOrder;
    boolean bool;
    int i5;
    label211:
    int i6;
    label233:
    BytePointer localBytePointer;
    if ((0x1 & this.regOut[0]) != 0)
    {
      localByteOrder = ByteOrder.BIG_ENDIAN;
      bool = this.raw_image.bStippled();
      if ((m != 16) && (m != 64) && (m != 268435457) && (m != 268435458)) {
        break label421;
      }
      i5 = 1;
      if ((m != 2) && (m != 4) && (m != 8)) {
        break label427;
      }
      i6 = 1;
      localBytePointer = this.raw_image.pData();
      if (((n != 8) && (!localByteOrder.equals(ByteOrder.nativeOrder()))) || ((this.imageMode != FrameGrabber.ImageMode.RAW) && ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (i3 != 3)) && ((this.imageMode != FrameGrabber.ImageMode.GRAY) || (i3 != 1) || (bool)))) {
        break label433;
      }
      if (this.return_image == null) {
        this.return_image = opencv_core.IplImage.createHeader(j, k, n, i3);
      }
      this.return_image.widthStep(i1);
      this.return_image.imageSize(i2);
      this.return_image.imageData(localBytePointer);
      label357:
      if (PGRFlyCapture.flycaptureGetColorTileFormat(this.context, this.regOut) == 0) {
        break label1155;
      }
      this.sensorPattern = -1L;
    }
    for (;;)
    {
      PGRFlyCapture.FlyCaptureTimestamp localFlyCaptureTimestamp = this.raw_image.timeStamp();
      this.timestamp = (1000000L * localFlyCaptureTimestamp.ulSeconds() + localFlyCaptureTimestamp.ulMicroSeconds());
      return this.return_image;
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
      break;
      label421:
      i5 = 0;
      break label211;
      label427:
      i6 = 0;
      break label233;
      label433:
      int i11;
      label453:
      label519:
      int i10;
      label577:
      int i8;
      if (this.return_image == null)
      {
        if (this.imageMode == FrameGrabber.ImageMode.COLOR)
        {
          i11 = 3;
          this.return_image = opencv_core.IplImage.create(j, k, n, i11);
        }
      }
      else
      {
        if (this.temp_image == null)
        {
          if ((this.imageMode != FrameGrabber.ImageMode.COLOR) || ((i3 <= 1) && (n <= 8)) || (i6 != 0) || (bool)) {
            break label767;
          }
          this.temp_image = opencv_core.IplImage.create(j, k, n, i3);
        }
        this.conv_image.iRowInc(this.temp_image.widthStep());
        this.conv_image.pData(this.temp_image.imageData());
        if (n != 8) {
          break label904;
        }
        PGRFlyCapture.FlyCaptureImage localFlyCaptureImage2 = this.conv_image;
        if (this.imageMode != FrameGrabber.ImageMode.RAW) {
          break label879;
        }
        i10 = 512;
        localFlyCaptureImage2.pixelFormat(i10);
        if ((n == 8) || (this.conv_image.pixelFormat() != m) || (this.conv_image.iRowInc() != i1)) {
          break label961;
        }
        ShortBuffer localShortBuffer2 = this.raw_image.getByteBuffer().order(localByteOrder).asShortBuffer();
        this.temp_image.getByteBuffer().order(ByteOrder.nativeOrder()).asShortBuffer().put(localShortBuffer2);
        i8 = 1;
      }
      label767:
      label879:
      label904:
      label961:
      label1038:
      label1065:
      int i9;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              if ((i8 == 0) && (n != 8) && (!localByteOrder.equals(ByteOrder.nativeOrder())))
              {
                ByteBuffer localByteBuffer = this.temp_image.getByteBuffer();
                ShortBuffer localShortBuffer1 = localByteBuffer.order(localByteOrder).asShortBuffer();
                localByteBuffer.order(ByteOrder.nativeOrder()).asShortBuffer().put(localShortBuffer1);
              }
              if ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (i3 != 1) || (i6 != 0) || (bool)) {
                break label1119;
              }
              opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 8);
              break;
              i11 = 1;
              break label453;
              if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (bool))
              {
                this.temp_image = opencv_core.IplImage.create(j, k, n, 3);
                break label519;
              }
              if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (i5 != 0))
              {
                this.temp_image = opencv_core.IplImage.createHeader(j, k, n, 3);
                break label519;
              }
              if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (i3 == 1) && (i6 == 0) && (!bool))
              {
                this.temp_image = opencv_core.IplImage.createHeader(j, k, n, 1);
                break label519;
              }
              this.temp_image = this.return_image;
              break label519;
              if (this.temp_image.nChannels() == 1)
              {
                i10 = 1;
                break label577;
              }
              i10 = 268435457;
              break label577;
              PGRFlyCapture.FlyCaptureImage localFlyCaptureImage1 = this.conv_image;
              int i7;
              if (this.imageMode == FrameGrabber.ImageMode.RAW) {
                i7 = 1024;
              }
              for (;;)
              {
                localFlyCaptureImage1.pixelFormat(i7);
                break;
                if (this.temp_image.nChannels() == 1) {
                  i7 = 32;
                } else {
                  i7 = 64;
                }
              }
              if (((this.imageMode != FrameGrabber.ImageMode.GRAY) || (i5 == 0)) && ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (i3 != 1) || (i6 != 0) || (bool))) {
                break label1038;
              }
              this.temp_image.widthStep(i1);
              this.temp_image.imageSize(i2);
              this.temp_image.imageData(localBytePointer);
              i8 = 0;
            }
            i8 = 0;
          } while (i5 != 0);
          if ((bool) || (i6 != 0)) {
            break label1065;
          }
          i8 = 0;
        } while (i3 <= 1);
        i9 = PGRFlyCapture.flycaptureConvertImage(this.context, this.raw_image, this.conv_image);
        i8 = 0;
      } while (i9 == 0);
      throw new FrameGrabber.Exception("flycaptureConvertImage() Error " + i9);
      label1119:
      if ((this.imageMode != FrameGrabber.ImageMode.GRAY) || ((!bool) && (i5 == 0))) {
        break label357;
      }
      opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 6);
      break label357;
      label1155:
      switch (this.regOut[0])
      {
      default: 
        this.sensorPattern = -1L;
        break;
      case 0: 
        this.sensorPattern = 4294967297L;
        break;
      case 1: 
        this.sensorPattern = 4294967296L;
        break;
      case 2: 
        this.sensorPattern = 1L;
        break;
      case 3: 
        this.sensorPattern = 0L;
      }
    }
  }
  
  public void release()
    throws FrameGrabber.Exception
  {
    if (this.context != null)
    {
      stop();
      int i = PGRFlyCapture.flycaptureDestroyContext(this.context);
      this.context = null;
      if (i != 0) {
        throw new FrameGrabber.Exception("flycaptureDestroyContext() Error " + i);
      }
    }
  }
  
  public void setImageMode(FrameGrabber.ImageMode paramImageMode)
  {
    if (paramImageMode != this.imageMode)
    {
      this.temp_image = null;
      this.return_image = null;
    }
    super.setImageMode(paramImageMode);
  }
  
  public void start()
    throws FrameGrabber.Exception
  {
    int i = 11;
    if (this.frameRate <= 0.0D)
    {
      i = 11;
      j = 16;
      if ((this.imageMode != FrameGrabber.ImageMode.COLOR) && (this.imageMode != FrameGrabber.ImageMode.RAW)) {
        break label386;
      }
      if ((this.imageWidth > 0) && (this.imageHeight > 0)) {
        break label257;
      }
      j = 16;
    }
    int[] arrayOfInt1;
    label257:
    label386:
    label416:
    do
    {
      for (;;)
      {
        arrayOfInt1 = new int[1];
        int[] arrayOfInt2 = new int[1];
        int[] arrayOfInt3 = new int[1];
        int[] arrayOfInt4 = new int[1];
        int k = PGRFlyCapture.flycaptureGetTrigger(this.context, null, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, null);
        if (k == 0) {
          break label620;
        }
        throw new FrameGrabber.Exception("flycaptureGetTrigger() Error " + k);
        if (this.frameRate <= 1.876D)
        {
          i = 0;
          break;
        }
        if (this.frameRate <= 3.76D)
        {
          i = 1;
          break;
        }
        if (this.frameRate <= 7.51D)
        {
          i = 2;
          break;
        }
        if (this.frameRate <= 15.01D)
        {
          i = 3;
          break;
        }
        if (this.frameRate <= 30.01D)
        {
          i = 4;
          break;
        }
        if (this.frameRate <= 60.01D)
        {
          i = 6;
          break;
        }
        if (this.frameRate <= 120.01D)
        {
          i = 7;
          break;
        }
        if (this.frameRate > 240.01D) {
          break;
        }
        i = 8;
        break;
        if ((this.imageWidth <= 640) && (this.imageHeight <= 480))
        {
          j = 4;
        }
        else if ((this.imageWidth <= 800) && (this.imageHeight <= 600))
        {
          j = 18;
        }
        else if ((this.imageWidth <= 1024) && (this.imageHeight <= 768))
        {
          j = 21;
        }
        else if ((this.imageWidth <= 1280) && (this.imageHeight <= 960))
        {
          j = 23;
        }
        else if ((this.imageWidth <= 1600) && (this.imageHeight <= 1200))
        {
          j = 51;
          continue;
          if (this.imageMode == FrameGrabber.ImageMode.GRAY)
          {
            if ((this.imageWidth > 0) && (this.imageHeight > 0)) {
              break label416;
            }
            j = 16;
          }
        }
      }
      if ((this.imageWidth <= 640) && (this.imageHeight <= 480))
      {
        if (this.bpp > 8) {}
        for (j = 6;; j = 5) {
          break;
        }
      }
      if ((this.imageWidth <= 800) && (this.imageHeight <= 600))
      {
        if (this.bpp > 8) {}
        for (j = 19;; j = 7) {
          break;
        }
      }
      if ((this.imageWidth <= 1024) && (this.imageHeight <= 768))
      {
        if (this.bpp > 8) {}
        for (j = 9;; j = 8) {
          break;
        }
      }
      if ((this.imageWidth <= 1280) && (this.imageHeight <= 960))
      {
        if (this.bpp > 8) {}
        for (j = 24;; j = 10) {
          break;
        }
      }
    } while ((this.imageWidth > 1600) || (this.imageHeight > 1200));
    if (this.bpp > 8) {}
    for (int j = 52;; j = 11) {
      break;
    }
    label620:
    int m = PGRFlyCapture.flycaptureSetTrigger(this.context, this.triggerMode, arrayOfInt1[0], 7, 14, 0);
    if (m != 0) {
      m = PGRFlyCapture.flycaptureSetTrigger(this.context, true, arrayOfInt1[0], 7, 0, 0);
    }
    if (m != 0) {
      throw new FrameGrabber.Exception("flycaptureSetTrigger() Error " + m);
    }
    if (this.triggerMode) {
      waitForTriggerReady();
    }
    int n = PGRFlyCapture.flycaptureGetCameraRegister(this.context, 4168, this.regOut);
    if (n != 0) {
      throw new FrameGrabber.Exception("flycaptureGetCameraRegister() Error " + n);
    }
    if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {}
    for (int i1 = 0x1 | this.regOut[0];; i1 = 0xFFFFFFFE & this.regOut[0])
    {
      int i2 = PGRFlyCapture.flycaptureSetCameraRegister(this.context, 4168, i1);
      if (i2 == 0) {
        break;
      }
      throw new FrameGrabber.Exception("flycaptureSetCameraRegister() Error " + i2);
    }
    if (PGRFlyCapture.flycaptureSetBusSpeed(this.context, 7, 7) != 0)
    {
      int i6 = PGRFlyCapture.flycaptureSetBusSpeed(this.context, 8, 8);
      if (i6 != 0) {
        throw new FrameGrabber.Exception("flycaptureSetBusSpeed() Error " + i6);
      }
    }
    if (this.gamma != 0.0D)
    {
      int i5 = PGRFlyCapture.flycaptureSetCameraAbsProperty(this.context, 6, (float)this.gamma);
      if (i5 != 0) {
        throw new FrameGrabber.Exception("flycaptureSetCameraAbsProperty() Error " + i5 + ": Could not set gamma.");
      }
    }
    if (PGRFlyCapture.flycaptureGetCameraAbsProperty(this.context, 6, this.gammaOut) != 0) {
      this.gammaOut[0] = 2.2F;
    }
    int i3 = PGRFlyCapture.flycaptureStart(this.context, j, i);
    if (i3 != 0) {
      throw new FrameGrabber.Exception("flycaptureStart() Error " + i3);
    }
    int i4 = PGRFlyCapture.flycaptureSetGrabTimeoutEx(this.context, this.timeout);
    if (i4 != 0) {
      throw new FrameGrabber.Exception("flycaptureSetGrabTimeoutEx() Error " + i4);
    }
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {
    int i = PGRFlyCapture.flycaptureStop(this.context);
    if ((i != 0) && (i != 1)) {
      throw new FrameGrabber.Exception("flycaptureStop() Error " + i);
    }
    this.temp_image = null;
    this.return_image = null;
    this.timestamp = 0L;
    this.frameNumber = 0;
  }
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    waitForTriggerReady();
    int i = PGRFlyCapture.flycaptureSetCameraRegister(this.context, 4140, Integer.MIN_VALUE);
    if (i != 0) {
      throw new FrameGrabber.Exception("flycaptureSetCameraRegister() Error " + i);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\FlyCaptureFrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */