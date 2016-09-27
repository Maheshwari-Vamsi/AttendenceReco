package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.dc1394;
import com.googlecode.javacv.cpp.dc1394.dc1394_t;
import com.googlecode.javacv.cpp.dc1394.dc1394camera_id_t;
import com.googlecode.javacv.cpp.dc1394.dc1394camera_list_t;
import com.googlecode.javacv.cpp.dc1394.dc1394camera_t;
import com.googlecode.javacv.cpp.dc1394.dc1394video_frame_t;
import com.googlecode.javacv.cpp.dc1394.pollfd;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class DC1394FrameGrabber
  extends FrameGrabber
{
  private static final boolean linux;
  private static FrameGrabber.Exception loadingException;
  private dc1394.dc1394camera_t camera = null;
  private dc1394.dc1394video_frame_t conv_image;
  private dc1394.dc1394_t d = null;
  private dc1394.dc1394video_frame_t enqueue_image;
  private dc1394.pollfd fds = new dc1394.pollfd();
  private dc1394.dc1394video_frame_t frame;
  private final float[] gammaOut;
  private boolean oneShotMode = false;
  private final int[] out;
  private final float[] outFloat;
  private dc1394.dc1394video_frame_t[] raw_image;
  private boolean resetDone = false;
  private opencv_core.IplImage return_image;
  private opencv_core.IplImage temp_image;
  
  static
  {
    if (!DC1394FrameGrabber.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      loadingException = null;
      linux = Loader.getPlatformName().startsWith("linux");
      return;
    }
  }
  
  public DC1394FrameGrabber(int paramInt)
    throws FrameGrabber.Exception
  {
    dc1394.dc1394video_frame_t[] arrayOfdc1394video_frame_t = new dc1394.dc1394video_frame_t[2];
    arrayOfdc1394video_frame_t[0] = new dc1394.dc1394video_frame_t(null);
    arrayOfdc1394video_frame_t[1] = new dc1394.dc1394video_frame_t(null);
    this.raw_image = arrayOfdc1394video_frame_t;
    this.conv_image = new dc1394.dc1394video_frame_t();
    this.frame = null;
    this.enqueue_image = null;
    this.return_image = null;
    this.out = new int[1];
    this.outFloat = new float[1];
    this.gammaOut = new float[1];
    this.d = dc1394.dc1394_new();
    dc1394.dc1394camera_list_t localdc1394camera_list_t = new dc1394.dc1394camera_list_t(null);
    int i = dc1394.dc1394_camera_enumerate(this.d, localdc1394camera_list_t);
    if (i != 0) {
      throw new FrameGrabber.Exception("dc1394_camera_enumerate() Error " + i + ": Failed to enumerate cameras.");
    }
    int j = localdc1394camera_list_t.num();
    if (j <= paramInt) {
      throw new FrameGrabber.Exception("DC1394Grabber() Error: Camera number " + paramInt + " not found. There are only " + j + " devices.");
    }
    dc1394.dc1394camera_id_t localdc1394camera_id_t = localdc1394camera_list_t.ids().position(paramInt);
    this.camera = dc1394.dc1394_camera_new_unit(this.d, localdc1394camera_id_t.guid(), localdc1394camera_id_t.unit());
    if (this.camera == null) {
      throw new FrameGrabber.Exception("dc1394_camera_new_unit() Error: Failed to initialize camera with GUID 0x" + Long.toHexString(localdc1394camera_id_t.guid()) + " / " + this.camera.unit() + ".");
    }
    dc1394.dc1394_camera_free_list(localdc1394camera_list_t);
  }
  
  public static DC1394FrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return new DC1394FrameGrabber(paramInt);
  }
  
  public static DC1394FrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static DC1394FrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  private void enqueue()
    throws FrameGrabber.Exception
  {
    enqueue(this.enqueue_image);
    this.enqueue_image = null;
  }
  
  private void enqueue(dc1394.dc1394video_frame_t paramdc1394video_frame_t)
    throws FrameGrabber.Exception
  {
    if (paramdc1394video_frame_t != null)
    {
      int i = dc1394.dc1394_capture_enqueue(this.camera, paramdc1394video_frame_t);
      if (i != 0) {
        throw new FrameGrabber.Exception("dc1394_capture_enqueue() Error " + i + ": Could not release a frame.");
      }
    }
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    dc1394.dc1394_t localdc1394_t = dc1394.dc1394_new();
    if (localdc1394_t == null) {
      throw new FrameGrabber.Exception("dc1394_new() Error: Failed to initialize libdc1394.");
    }
    dc1394.dc1394camera_list_t localdc1394camera_list_t = new dc1394.dc1394camera_list_t(null);
    int i = dc1394.dc1394_camera_enumerate(localdc1394_t, localdc1394camera_list_t);
    if (i != 0) {
      throw new FrameGrabber.Exception("dc1394_camera_enumerate() Error " + i + ": Failed to enumerate cameras.");
    }
    int j = localdc1394camera_list_t.num();
    String[] arrayOfString = new String[j];
    if (j > 0)
    {
      dc1394.dc1394camera_id_t localdc1394camera_id_t = localdc1394camera_list_t.ids();
      for (int k = 0; k < j; k++)
      {
        localdc1394camera_id_t.position(k);
        dc1394.dc1394camera_t localdc1394camera_t = dc1394.dc1394_camera_new_unit(localdc1394_t, localdc1394camera_id_t.guid(), localdc1394camera_id_t.unit());
        if (localdc1394camera_t == null) {
          throw new FrameGrabber.Exception("dc1394_camera_new_unit() Error: Failed to initialize camera with GUID 0x" + Long.toHexString(localdc1394camera_id_t.guid()) + " / " + localdc1394camera_t.unit() + ".");
        }
        arrayOfString[k] = (localdc1394camera_t.vendor().getString() + " " + localdc1394camera_t.model().getString() + " 0x" + Long.toHexString(localdc1394camera_t.guid()) + " / " + localdc1394camera_t.unit());
        dc1394.dc1394_camera_free(localdc1394camera_t);
      }
    }
    dc1394.dc1394_camera_free_list(localdc1394camera_list_t);
    dc1394.dc1394_free(localdc1394_t);
    return arrayOfString;
  }
  
  public static void tryLoad()
    throws FrameGrabber.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      Loader.load(dc1394.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      FrameGrabber.Exception localException = new FrameGrabber.Exception("Failed to load " + DC1394FrameGrabber.class, localThrowable);
      loadingException = localException;
      throw localException;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public double getFrameRate()
  {
    if (this.camera == null) {
      return super.getFrameRate();
    }
    if (dc1394.dc1394_feature_get_absolute_value(this.camera, 431, this.outFloat) != 0)
    {
      dc1394.dc1394_video_get_framerate(this.camera, this.out);
      dc1394.dc1394_framerate_as_float(this.out[0], this.outFloat);
    }
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
    enqueue();
    if (linux)
    {
      this.fds.events((short)1);
      if (dc1394.poll(this.fds, 1L, this.timeout) == 0) {
        throw new FrameGrabber.Exception("poll() Error: Timeout occured. (Has start() been called?)");
      }
    }
    int i = 0;
    int j = dc1394.dc1394_capture_dequeue(this.camera, 672, this.raw_image[0]);
    if (j != 0) {
      throw new FrameGrabber.Exception("dc1394_capture_dequeue(WAIT) Error " + j + ": Could not capture a frame. (Has start() been called?)");
    }
    int k = 0;
    while (!this.raw_image[i].isNull())
    {
      enqueue();
      this.enqueue_image = this.raw_image[i];
      i = (i + 1) % 2;
      k++;
      int i22 = dc1394.dc1394_capture_dequeue(this.camera, 673, this.raw_image[i]);
      if (i22 != 0) {
        throw new FrameGrabber.Exception("dc1394_capture_dequeue(POLL) Error " + i22 + ": Could not capture a frame.");
      }
    }
    this.frame = this.raw_image[((i + 1) % 2)];
    int m = this.frame.size(0);
    int n = this.frame.size(1);
    int i1 = this.frame.data_depth();
    int i2;
    int i3;
    int i4;
    int i5;
    ByteOrder localByteOrder;
    label339:
    int i7;
    label367:
    int i8;
    label386:
    int i9;
    label413:
    BytePointer localBytePointer;
    switch (i1)
    {
    default: 
      boolean bool = $assertionsDisabled;
      i2 = 0;
      if (!bool) {
        throw new AssertionError();
      }
    case 8: 
      i2 = 8;
      i3 = this.frame.stride();
      i4 = this.frame.image_bytes();
      i5 = 8 * (i3 / m) / i1;
      if (this.frame.little_endian() != 0)
      {
        localByteOrder = ByteOrder.LITTLE_ENDIAN;
        int i6 = this.frame.color_coding();
        if ((i6 != 361) && (i6 != 362)) {
          break label636;
        }
        i7 = 1;
        if ((i6 != 356) && (i6 != 358)) {
          break label642;
        }
        i8 = 1;
        if ((i6 != 353) && (i6 != 354) && (i6 != 355)) {
          break label648;
        }
        i9 = 1;
        localBytePointer = this.frame.image();
        if (((i1 > 8) && (!localByteOrder.equals(ByteOrder.nativeOrder()))) || (i9 != 0) || ((this.imageMode != FrameGrabber.ImageMode.RAW) && ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (i5 != 3)) && ((this.imageMode != FrameGrabber.ImageMode.GRAY) || (i5 != 1) || (i7 != 0)))) {
          break label654;
        }
        if (this.return_image == null) {
          this.return_image = opencv_core.IplImage.createHeader(m, n, i2, i5);
        }
        this.return_image.widthStep(i3);
        this.return_image.imageSize(i4);
        this.return_image.imageData(localBytePointer);
        label544:
        switch (this.frame.color_filter())
        {
        default: 
          this.sensorPattern = -1L;
        }
      }
      break;
    }
    for (;;)
    {
      this.enqueue_image = this.frame;
      this.timestamp = this.frame.timestamp();
      this.frameNumber = (k + this.frameNumber);
      return this.return_image;
      i2 = 16;
      break;
      localByteOrder = ByteOrder.BIG_ENDIAN;
      break label339;
      label636:
      i7 = 0;
      break label367;
      label642:
      i8 = 0;
      break label386;
      label648:
      i9 = 0;
      break label413;
      label654:
      int i10 = this.frame.padding_bytes();
      int i11 = (int)Math.ceil(i10 / (m * i1 / 8));
      int i12 = (int)Math.ceil(i10 / (i1 * (m * 3) / 8));
      int i20;
      int i21;
      label737:
      label849:
      int i19;
      label909:
      int i17;
      if (this.return_image == null)
      {
        if (this.imageMode == FrameGrabber.ImageMode.COLOR)
        {
          i20 = 3;
          if (this.imageMode != FrameGrabber.ImageMode.COLOR) {
            break label1094;
          }
          i21 = i12;
          this.return_image = opencv_core.IplImage.create(m, n + i21, i2, i20);
          this.return_image.height(this.return_image.height() - i21);
        }
      }
      else
      {
        if (this.temp_image == null)
        {
          if ((this.imageMode != FrameGrabber.ImageMode.COLOR) || ((i5 <= 1) && (i1 <= 8)) || (i9 != 0) || (i7 != 0)) {
            break label1101;
          }
          this.temp_image = opencv_core.IplImage.create(m, n + i11, i2, i5);
          this.temp_image.height(this.temp_image.height() - i11);
        }
        this.conv_image.size(0, this.temp_image.width());
        this.conv_image.size(1, this.temp_image.height());
        if (i1 <= 8) {
          break label1284;
        }
        dc1394.dc1394video_frame_t localdc1394video_frame_t2 = this.conv_image;
        if (this.imageMode != FrameGrabber.ImageMode.RAW) {
          break label1257;
        }
        i19 = 362;
        localdc1394video_frame_t2.color_coding(i19);
        this.conv_image.data_depth(16);
        this.conv_image.stride(this.temp_image.widthStep());
        int i14 = this.temp_image.imageSize();
        this.conv_image.allocated_image_bytes(i14).total_bytes(i14).image_bytes(i14);
        this.conv_image.image(this.temp_image.imageData());
        if (i7 == 0) {
          break label1433;
        }
        i17 = this.frame.color_filter();
        if (i17 != 512) {
          break label1353;
        }
        this.frame.color_filter(515);
      }
      int i15;
      label1094:
      label1101:
      label1257:
      label1284:
      label1353:
      label1419:
      do
      {
        for (;;)
        {
          int i18 = dc1394.dc1394_debayer_frames(this.frame, this.conv_image, 1);
          this.frame.color_filter(i17);
          i15 = 0;
          if (i18 == 0) {
            break label1533;
          }
          throw new FrameGrabber.Exception("dc1394_debayer_frames() Error " + i18 + ": Could not debayer frame.");
          i20 = 1;
          break;
          i21 = i11;
          break label737;
          if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && ((i9 != 0) || (i7 != 0) || ((i8 != 0) && (i1 > 8))))
          {
            this.temp_image = opencv_core.IplImage.create(m, n + i12, i2, 3);
            this.temp_image.height(this.temp_image.height() - i12);
            break label849;
          }
          if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (i8 != 0))
          {
            this.temp_image = opencv_core.IplImage.createHeader(m, n, i2, 3);
            break label849;
          }
          if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (i5 == 1) && (i9 == 0) && (i7 == 0))
          {
            this.temp_image = opencv_core.IplImage.createHeader(m, n, i2, 1);
            break label849;
          }
          this.temp_image = this.return_image;
          break label849;
          if (this.temp_image.nChannels() == 1)
          {
            i19 = 357;
            break label909;
          }
          i19 = 358;
          break label909;
          dc1394.dc1394video_frame_t localdc1394video_frame_t1 = this.conv_image;
          int i13;
          if (this.imageMode == FrameGrabber.ImageMode.RAW) {
            i13 = 361;
          }
          for (;;)
          {
            localdc1394video_frame_t1.color_coding(i13);
            this.conv_image.data_depth(8);
            break;
            if (this.temp_image.nChannels() == 1) {
              i13 = 352;
            } else {
              i13 = 356;
            }
          }
          if (i17 == 513)
          {
            this.frame.color_filter(514);
          }
          else if (i17 == 514)
          {
            this.frame.color_filter(513);
          }
          else
          {
            if (i17 != 515) {
              break label1419;
            }
            this.frame.color_filter(512);
          }
        }
      } while ($assertionsDisabled);
      throw new AssertionError();
      label1433:
      if ((i1 > 8) && (this.frame.data_depth() == this.conv_image.data_depth()) && (this.frame.color_coding() == this.conv_image.color_coding()) && (this.frame.stride() == this.conv_image.stride()))
      {
        ShortBuffer localShortBuffer2 = this.frame.getByteBuffer().order(localByteOrder).asShortBuffer();
        this.temp_image.getByteBuffer().order(ByteOrder.nativeOrder()).asShortBuffer().put(localShortBuffer2);
        i15 = 1;
      }
      label1533:
      label1713:
      label1740:
      int i16;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              if ((i15 == 0) && (i1 > 8) && (!localByteOrder.equals(ByteOrder.nativeOrder())))
              {
                ByteBuffer localByteBuffer = this.temp_image.getByteBuffer();
                ShortBuffer localShortBuffer1 = localByteBuffer.order(localByteOrder).asShortBuffer();
                localByteBuffer.order(ByteOrder.nativeOrder()).asShortBuffer().put(localShortBuffer1);
              }
              if ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (i5 != 1) || (i9 != 0) || (i7 != 0)) {
                break label1796;
              }
              opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 8);
              break;
              if (((this.imageMode != FrameGrabber.ImageMode.GRAY) || (i8 == 0)) && ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (i5 != 1) || (i9 != 0) || (i7 != 0))) {
                break label1713;
              }
              this.temp_image.widthStep(i3);
              this.temp_image.imageSize(i4);
              this.temp_image.imageData(localBytePointer);
              i15 = 0;
            }
            i15 = 0;
          } while (i8 != 0);
          if ((i7 != 0) || (i9 != 0)) {
            break label1740;
          }
          i15 = 0;
        } while (i5 <= 1);
        i16 = dc1394.dc1394_convert_frames(this.frame, this.conv_image);
        i15 = 0;
      } while (i16 == 0);
      throw new FrameGrabber.Exception("dc1394_convert_frames() Error " + i16 + ": Could not convert frame.");
      label1796:
      if ((this.imageMode != FrameGrabber.ImageMode.GRAY) || ((i7 == 0) && (i8 == 0) && (i9 == 0))) {
        break label544;
      }
      opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 6);
      break label544;
      this.sensorPattern = 0L;
      continue;
      this.sensorPattern = 4294967296L;
      continue;
      this.sensorPattern = 1L;
      continue;
      this.sensorPattern = 4294967297L;
    }
  }
  
  public void release()
    throws FrameGrabber.Exception
  {
    if (this.camera != null)
    {
      stop();
      dc1394.dc1394_camera_free(this.camera);
      this.camera = null;
    }
    if (this.d != null)
    {
      dc1394.dc1394_free(this.d);
      this.d = null;
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
    start(true, true);
  }
  
  /* Error */
  public void start(boolean paramBoolean1, boolean paramBoolean2)
    throws FrameGrabber.Exception
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 374	com/googlecode/javacv/DC1394FrameGrabber:imageMode	Lcom/googlecode/javacv/FrameGrabber$ImageMode;
    //   6: getstatic 382	com/googlecode/javacv/FrameGrabber$ImageMode:COLOR	Lcom/googlecode/javacv/FrameGrabber$ImageMode;
    //   9: if_acmpeq +13 -> 22
    //   12: aload_0
    //   13: getfield 374	com/googlecode/javacv/DC1394FrameGrabber:imageMode	Lcom/googlecode/javacv/FrameGrabber$ImageMode;
    //   16: getstatic 379	com/googlecode/javacv/FrameGrabber$ImageMode:RAW	Lcom/googlecode/javacv/FrameGrabber$ImageMode;
    //   19: if_acmpne +437 -> 456
    //   22: aload_0
    //   23: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   26: ifle +10 -> 36
    //   29: aload_0
    //   30: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   33: ifgt +293 -> 326
    //   36: iconst_m1
    //   37: istore_3
    //   38: iload_3
    //   39: iconst_m1
    //   40: if_icmpne +22 -> 62
    //   43: aload_0
    //   44: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   47: aload_0
    //   48: getfield 95	com/googlecode/javacv/DC1394FrameGrabber:out	[I
    //   51: invokestatic 538	com/googlecode/javacv/cpp/dc1394:dc1394_video_get_mode	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;[I)I
    //   54: pop
    //   55: aload_0
    //   56: getfield 95	com/googlecode/javacv/DC1394FrameGrabber:out	[I
    //   59: iconst_0
    //   60: iaload
    //   61: istore_3
    //   62: iconst_m1
    //   63: istore 4
    //   65: aload_0
    //   66: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   69: dconst_0
    //   70: dcmpg
    //   71: ifgt +619 -> 690
    //   74: iconst_m1
    //   75: istore 4
    //   77: iload 4
    //   79: iconst_m1
    //   80: if_icmpne +23 -> 103
    //   83: aload_0
    //   84: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   87: aload_0
    //   88: getfield 95	com/googlecode/javacv/DC1394FrameGrabber:out	[I
    //   91: invokestatic 268	com/googlecode/javacv/cpp/dc1394:dc1394_video_get_framerate	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;[I)I
    //   94: pop
    //   95: aload_0
    //   96: getfield 95	com/googlecode/javacv/DC1394FrameGrabber:out	[I
    //   99: iconst_0
    //   100: iaload
    //   101: istore 4
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 75	com/googlecode/javacv/DC1394FrameGrabber:oneShotMode	Z
    //   108: aload_0
    //   109: getfield 545	com/googlecode/javacv/DC1394FrameGrabber:triggerMode	Z
    //   112: ifeq +19 -> 131
    //   115: aload_0
    //   116: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   119: iconst_1
    //   120: invokestatic 549	com/googlecode/javacv/cpp/dc1394:dc1394_external_trigger_set_power	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   123: ifeq +711 -> 834
    //   126: aload_0
    //   127: iconst_1
    //   128: putfield 75	com/googlecode/javacv/DC1394FrameGrabber:oneShotMode	Z
    //   131: aload_0
    //   132: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   135: sipush 480
    //   138: invokestatic 552	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_operation_mode	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   141: istore 11
    //   143: iload_2
    //   144: ifeq +1182 -> 1326
    //   147: aload_0
    //   148: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   151: sipush 481
    //   154: invokestatic 552	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_operation_mode	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   157: istore 11
    //   159: iload 11
    //   161: ifne +1165 -> 1326
    //   164: aload_0
    //   165: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   168: iconst_3
    //   169: invokestatic 555	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_iso_speed	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   172: istore 11
    //   174: goto +1152 -> 1326
    //   177: aload_0
    //   178: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   181: iconst_2
    //   182: invokestatic 555	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_iso_speed	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   185: istore 12
    //   187: iload 12
    //   189: ifeq +709 -> 898
    //   192: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   195: dup
    //   196: new 114	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 557
    //   206: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload 12
    //   211: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: ldc_w 559
    //   217: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   226: athrow
    //   227: astore 6
    //   229: iload_1
    //   230: ifeq +1071 -> 1301
    //   233: aload_0
    //   234: getfield 77	com/googlecode/javacv/DC1394FrameGrabber:resetDone	Z
    //   237: ifne +1064 -> 1301
    //   240: aload_0
    //   241: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   244: invokestatic 563	com/googlecode/javacv/cpp/dc1394:dc1394_reset_bus	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;)I
    //   247: pop
    //   248: ldc2_w 564
    //   251: invokestatic 571	java/lang/Thread:sleep	(J)V
    //   254: aload_0
    //   255: iconst_1
    //   256: putfield 77	com/googlecode/javacv/DC1394FrameGrabber:resetDone	Z
    //   259: aload_0
    //   260: iconst_0
    //   261: iload_2
    //   262: invokevirtual 527	com/googlecode/javacv/DC1394FrameGrabber:start	(ZZ)V
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 77	com/googlecode/javacv/DC1394FrameGrabber:resetDone	Z
    //   270: getstatic 58	com/googlecode/javacv/DC1394FrameGrabber:linux	Z
    //   273: ifeq +52 -> 325
    //   276: iload_2
    //   277: ifeq +48 -> 325
    //   280: aload_0
    //   281: getfield 545	com/googlecode/javacv/DC1394FrameGrabber:triggerMode	Z
    //   284: ifeq +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 574	com/googlecode/javacv/DC1394FrameGrabber:trigger	()V
    //   291: aload_0
    //   292: getfield 73	com/googlecode/javacv/DC1394FrameGrabber:fds	Lcom/googlecode/javacv/cpp/dc1394$pollfd;
    //   295: iconst_1
    //   296: invokevirtual 306	com/googlecode/javacv/cpp/dc1394$pollfd:events	(S)Lcom/googlecode/javacv/cpp/dc1394$pollfd;
    //   299: pop
    //   300: aload_0
    //   301: getfield 73	com/googlecode/javacv/DC1394FrameGrabber:fds	Lcom/googlecode/javacv/cpp/dc1394$pollfd;
    //   304: lconst_1
    //   305: aload_0
    //   306: getfield 310	com/googlecode/javacv/DC1394FrameGrabber:timeout	I
    //   309: invokestatic 314	com/googlecode/javacv/cpp/dc1394:poll	(Lcom/googlecode/javacv/cpp/dc1394$pollfd;JI)I
    //   312: ifne +992 -> 1304
    //   315: aload_0
    //   316: invokevirtual 519	com/googlecode/javacv/DC1394FrameGrabber:stop	()V
    //   319: aload_0
    //   320: iload_1
    //   321: iconst_0
    //   322: invokevirtual 527	com/googlecode/javacv/DC1394FrameGrabber:start	(ZZ)V
    //   325: return
    //   326: aload_0
    //   327: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   330: sipush 640
    //   333: if_icmpgt +19 -> 352
    //   336: aload_0
    //   337: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   340: sipush 480
    //   343: if_icmpgt +9 -> 352
    //   346: bipush 68
    //   348: istore_3
    //   349: goto -311 -> 38
    //   352: aload_0
    //   353: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   356: sipush 800
    //   359: if_icmpgt +19 -> 378
    //   362: aload_0
    //   363: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   366: sipush 600
    //   369: if_icmpgt +9 -> 378
    //   372: bipush 72
    //   374: istore_3
    //   375: goto -337 -> 38
    //   378: aload_0
    //   379: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   382: sipush 1024
    //   385: if_icmpgt +19 -> 404
    //   388: aload_0
    //   389: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   392: sipush 768
    //   395: if_icmpgt +9 -> 404
    //   398: bipush 75
    //   400: istore_3
    //   401: goto -363 -> 38
    //   404: aload_0
    //   405: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   408: sipush 1280
    //   411: if_icmpgt +19 -> 430
    //   414: aload_0
    //   415: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   418: sipush 960
    //   421: if_icmpgt +9 -> 430
    //   424: bipush 80
    //   426: istore_3
    //   427: goto -389 -> 38
    //   430: aload_0
    //   431: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   434: sipush 1600
    //   437: if_icmpgt -399 -> 38
    //   440: aload_0
    //   441: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   444: sipush 1200
    //   447: if_icmpgt -409 -> 38
    //   450: bipush 83
    //   452: istore_3
    //   453: goto -415 -> 38
    //   456: aload_0
    //   457: getfield 374	com/googlecode/javacv/DC1394FrameGrabber:imageMode	Lcom/googlecode/javacv/FrameGrabber$ImageMode;
    //   460: getstatic 385	com/googlecode/javacv/FrameGrabber$ImageMode:GRAY	Lcom/googlecode/javacv/FrameGrabber$ImageMode;
    //   463: if_acmpne -425 -> 38
    //   466: aload_0
    //   467: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   470: ifle +10 -> 480
    //   473: aload_0
    //   474: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   477: ifgt +8 -> 485
    //   480: iconst_m1
    //   481: istore_3
    //   482: goto -444 -> 38
    //   485: aload_0
    //   486: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   489: sipush 640
    //   492: if_icmpgt +34 -> 526
    //   495: aload_0
    //   496: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   499: sipush 480
    //   502: if_icmpgt +24 -> 526
    //   505: aload_0
    //   506: getfield 577	com/googlecode/javacv/DC1394FrameGrabber:bpp	I
    //   509: bipush 8
    //   511: if_icmple +9 -> 520
    //   514: bipush 70
    //   516: istore_3
    //   517: goto -479 -> 38
    //   520: bipush 69
    //   522: istore_3
    //   523: goto -6 -> 517
    //   526: aload_0
    //   527: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   530: sipush 800
    //   533: if_icmpgt +34 -> 567
    //   536: aload_0
    //   537: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   540: sipush 600
    //   543: if_icmpgt +24 -> 567
    //   546: aload_0
    //   547: getfield 577	com/googlecode/javacv/DC1394FrameGrabber:bpp	I
    //   550: bipush 8
    //   552: if_icmple +9 -> 561
    //   555: bipush 77
    //   557: istore_3
    //   558: goto -520 -> 38
    //   561: bipush 73
    //   563: istore_3
    //   564: goto -6 -> 558
    //   567: aload_0
    //   568: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   571: sipush 1024
    //   574: if_icmpgt +34 -> 608
    //   577: aload_0
    //   578: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   581: sipush 768
    //   584: if_icmpgt +24 -> 608
    //   587: aload_0
    //   588: getfield 577	com/googlecode/javacv/DC1394FrameGrabber:bpp	I
    //   591: bipush 8
    //   593: if_icmple +9 -> 602
    //   596: bipush 78
    //   598: istore_3
    //   599: goto -561 -> 38
    //   602: bipush 76
    //   604: istore_3
    //   605: goto -6 -> 599
    //   608: aload_0
    //   609: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   612: sipush 1280
    //   615: if_icmpgt +34 -> 649
    //   618: aload_0
    //   619: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   622: sipush 960
    //   625: if_icmpgt +24 -> 649
    //   628: aload_0
    //   629: getfield 577	com/googlecode/javacv/DC1394FrameGrabber:bpp	I
    //   632: bipush 8
    //   634: if_icmple +9 -> 643
    //   637: bipush 85
    //   639: istore_3
    //   640: goto -602 -> 38
    //   643: bipush 81
    //   645: istore_3
    //   646: goto -6 -> 640
    //   649: aload_0
    //   650: getfield 532	com/googlecode/javacv/DC1394FrameGrabber:imageWidth	I
    //   653: sipush 1600
    //   656: if_icmpgt -618 -> 38
    //   659: aload_0
    //   660: getfield 535	com/googlecode/javacv/DC1394FrameGrabber:imageHeight	I
    //   663: sipush 1200
    //   666: if_icmpgt -628 -> 38
    //   669: aload_0
    //   670: getfield 577	com/googlecode/javacv/DC1394FrameGrabber:bpp	I
    //   673: bipush 8
    //   675: if_icmple +9 -> 684
    //   678: bipush 86
    //   680: istore_3
    //   681: goto -643 -> 38
    //   684: bipush 84
    //   686: istore_3
    //   687: goto -6 -> 681
    //   690: aload_0
    //   691: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   694: ldc2_w 578
    //   697: dcmpg
    //   698: ifgt +10 -> 708
    //   701: bipush 32
    //   703: istore 4
    //   705: goto -628 -> 77
    //   708: aload_0
    //   709: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   712: ldc2_w 580
    //   715: dcmpg
    //   716: ifgt +10 -> 726
    //   719: bipush 33
    //   721: istore 4
    //   723: goto -646 -> 77
    //   726: aload_0
    //   727: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   730: ldc2_w 582
    //   733: dcmpg
    //   734: ifgt +10 -> 744
    //   737: bipush 34
    //   739: istore 4
    //   741: goto -664 -> 77
    //   744: aload_0
    //   745: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   748: ldc2_w 584
    //   751: dcmpg
    //   752: ifgt +10 -> 762
    //   755: bipush 35
    //   757: istore 4
    //   759: goto -682 -> 77
    //   762: aload_0
    //   763: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   766: ldc2_w 586
    //   769: dcmpg
    //   770: ifgt +10 -> 780
    //   773: bipush 36
    //   775: istore 4
    //   777: goto -700 -> 77
    //   780: aload_0
    //   781: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   784: ldc2_w 588
    //   787: dcmpg
    //   788: ifgt +10 -> 798
    //   791: bipush 37
    //   793: istore 4
    //   795: goto -718 -> 77
    //   798: aload_0
    //   799: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   802: ldc2_w 590
    //   805: dcmpg
    //   806: ifgt +10 -> 816
    //   809: bipush 38
    //   811: istore 4
    //   813: goto -736 -> 77
    //   816: aload_0
    //   817: getfield 542	com/googlecode/javacv/DC1394FrameGrabber:frameRate	D
    //   820: ldc2_w 592
    //   823: dcmpg
    //   824: ifgt -747 -> 77
    //   827: bipush 39
    //   829: istore 4
    //   831: goto -754 -> 77
    //   834: aload_0
    //   835: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   838: sipush 390
    //   841: invokestatic 596	com/googlecode/javacv/cpp/dc1394:dc1394_external_trigger_set_mode	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   844: ifeq +14 -> 858
    //   847: aload_0
    //   848: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   851: sipush 384
    //   854: invokestatic 596	com/googlecode/javacv/cpp/dc1394:dc1394_external_trigger_set_mode	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   857: pop
    //   858: aload_0
    //   859: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   862: sipush 580
    //   865: invokestatic 599	com/googlecode/javacv/cpp/dc1394:dc1394_external_trigger_set_source	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   868: ifeq -737 -> 131
    //   871: aload_0
    //   872: iconst_1
    //   873: putfield 75	com/googlecode/javacv/DC1394FrameGrabber:oneShotMode	Z
    //   876: aload_0
    //   877: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   880: iconst_0
    //   881: invokestatic 549	com/googlecode/javacv/cpp/dc1394:dc1394_external_trigger_set_power	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   884: pop
    //   885: goto -754 -> 131
    //   888: astore 5
    //   890: aload_0
    //   891: iconst_0
    //   892: putfield 77	com/googlecode/javacv/DC1394FrameGrabber:resetDone	Z
    //   895: aload 5
    //   897: athrow
    //   898: aload_0
    //   899: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   902: iload_3
    //   903: invokestatic 602	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_mode	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   906: istore 13
    //   908: iload 13
    //   910: ifeq +38 -> 948
    //   913: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   916: dup
    //   917: new 114	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   924: ldc_w 604
    //   927: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: iload 13
    //   932: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   935: ldc_w 606
    //   938: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   947: athrow
    //   948: iload_3
    //   949: invokestatic 609	com/googlecode/javacv/cpp/dc1394:dc1394_is_video_mode_scalable	(I)I
    //   952: iconst_1
    //   953: if_icmpne +59 -> 1012
    //   956: aload_0
    //   957: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   960: iload_3
    //   961: iconst_m1
    //   962: iconst_m1
    //   963: iconst_m1
    //   964: iconst_m1
    //   965: iconst_m1
    //   966: iconst_m1
    //   967: invokestatic 613	com/googlecode/javacv/cpp/dc1394:dc1394_format7_set_roi	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;IIIIIII)I
    //   970: istore 19
    //   972: iload 19
    //   974: ifeq +89 -> 1063
    //   977: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   980: dup
    //   981: new 114	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   988: ldc_w 615
    //   991: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: iload 19
    //   996: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   999: ldc_w 617
    //   1002: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   1011: athrow
    //   1012: aload_0
    //   1013: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   1016: iload 4
    //   1018: invokestatic 620	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_framerate	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   1021: istore 14
    //   1023: iload 14
    //   1025: ifeq +38 -> 1063
    //   1028: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   1031: dup
    //   1032: new 114	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1039: ldc_w 622
    //   1042: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: iload 14
    //   1047: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1050: ldc_w 624
    //   1053: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   1062: athrow
    //   1063: aload_0
    //   1064: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   1067: aload_0
    //   1068: getfield 627	com/googlecode/javacv/DC1394FrameGrabber:numBuffers	I
    //   1071: iconst_4
    //   1072: invokestatic 631	com/googlecode/javacv/cpp/dc1394:dc1394_capture_setup	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;II)I
    //   1075: istore 15
    //   1077: iload 15
    //   1079: ifeq +44 -> 1123
    //   1082: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   1085: dup
    //   1086: new 114	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 633
    //   1096: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: iload 15
    //   1101: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1104: ldc_w 635
    //   1107: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: ldc_w 637
    //   1113: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   1122: athrow
    //   1123: aload_0
    //   1124: getfield 640	com/googlecode/javacv/DC1394FrameGrabber:gamma	D
    //   1127: dconst_0
    //   1128: dcmpl
    //   1129: ifeq +60 -> 1189
    //   1132: aload_0
    //   1133: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   1136: sipush 422
    //   1139: aload_0
    //   1140: getfield 640	com/googlecode/javacv/DC1394FrameGrabber:gamma	D
    //   1143: d2f
    //   1144: invokestatic 644	com/googlecode/javacv/cpp/dc1394:dc1394_feature_set_absolute_value	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;IF)I
    //   1147: istore 18
    //   1149: iload 18
    //   1151: ifeq +38 -> 1189
    //   1154: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   1157: dup
    //   1158: new 114	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1165: ldc_w 646
    //   1168: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: iload 18
    //   1173: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1176: ldc_w 648
    //   1179: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   1188: athrow
    //   1189: aload_0
    //   1190: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   1193: sipush 422
    //   1196: aload_0
    //   1197: getfield 99	com/googlecode/javacv/DC1394FrameGrabber:gammaOut	[F
    //   1200: invokestatic 264	com/googlecode/javacv/cpp/dc1394:dc1394_feature_get_absolute_value	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I[F)I
    //   1203: ifeq +12 -> 1215
    //   1206: aload_0
    //   1207: getfield 99	com/googlecode/javacv/DC1394FrameGrabber:gammaOut	[F
    //   1210: iconst_0
    //   1211: ldc_w 649
    //   1214: fastore
    //   1215: getstatic 58	com/googlecode/javacv/DC1394FrameGrabber:linux	Z
    //   1218: ifeq +18 -> 1236
    //   1221: aload_0
    //   1222: getfield 73	com/googlecode/javacv/DC1394FrameGrabber:fds	Lcom/googlecode/javacv/cpp/dc1394$pollfd;
    //   1225: aload_0
    //   1226: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   1229: invokestatic 652	com/googlecode/javacv/cpp/dc1394:dc1394_capture_get_fileno	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;)I
    //   1232: invokevirtual 656	com/googlecode/javacv/cpp/dc1394$pollfd:fd	(I)Lcom/googlecode/javacv/cpp/dc1394$pollfd;
    //   1235: pop
    //   1236: aload_0
    //   1237: getfield 75	com/googlecode/javacv/DC1394FrameGrabber:oneShotMode	Z
    //   1240: ifne +53 -> 1293
    //   1243: aload_0
    //   1244: getfield 68	com/googlecode/javacv/DC1394FrameGrabber:camera	Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;
    //   1247: iconst_1
    //   1248: invokestatic 659	com/googlecode/javacv/cpp/dc1394:dc1394_video_set_transmission	(Lcom/googlecode/javacv/cpp/dc1394$dc1394camera_t;I)I
    //   1251: istore 16
    //   1253: iload 16
    //   1255: ifeq +38 -> 1293
    //   1258: new 62	com/googlecode/javacv/FrameGrabber$Exception
    //   1261: dup
    //   1262: new 114	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1269: ldc_w 661
    //   1272: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: iload 16
    //   1277: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1280: ldc_w 663
    //   1283: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1289: invokespecial 132	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;)V
    //   1292: athrow
    //   1293: aload_0
    //   1294: iconst_0
    //   1295: putfield 77	com/googlecode/javacv/DC1394FrameGrabber:resetDone	Z
    //   1298: goto -1028 -> 270
    //   1301: aload 6
    //   1303: athrow
    //   1304: aload_0
    //   1305: getfield 545	com/googlecode/javacv/DC1394FrameGrabber:triggerMode	Z
    //   1308: ifeq -983 -> 325
    //   1311: aload_0
    //   1312: invokevirtual 665	com/googlecode/javacv/DC1394FrameGrabber:grab	()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    //   1315: pop
    //   1316: aload_0
    //   1317: invokespecial 302	com/googlecode/javacv/DC1394FrameGrabber:enqueue	()V
    //   1320: return
    //   1321: astore 8
    //   1323: goto -1069 -> 254
    //   1326: iload 11
    //   1328: ifne -1151 -> 177
    //   1331: iload_2
    //   1332: ifne -434 -> 898
    //   1335: goto -1158 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1338	0	this	DC1394FrameGrabber
    //   0	1338	1	paramBoolean1	boolean
    //   0	1338	2	paramBoolean2	boolean
    //   1	960	3	i	int
    //   63	954	4	j	int
    //   888	8	5	localObject	Object
    //   227	1075	6	localException	FrameGrabber.Exception
    //   1321	1	8	localInterruptedException	InterruptedException
    //   141	1186	11	k	int
    //   185	25	12	m	int
    //   906	25	13	n	int
    //   1021	25	14	i1	int
    //   1075	25	15	i2	int
    //   1251	25	16	i3	int
    //   1147	25	18	i4	int
    //   970	25	19	i5	int
    // Exception table:
    //   from	to	target	type
    //   103	131	227	com/googlecode/javacv/FrameGrabber$Exception
    //   131	143	227	com/googlecode/javacv/FrameGrabber$Exception
    //   147	159	227	com/googlecode/javacv/FrameGrabber$Exception
    //   164	174	227	com/googlecode/javacv/FrameGrabber$Exception
    //   177	187	227	com/googlecode/javacv/FrameGrabber$Exception
    //   192	227	227	com/googlecode/javacv/FrameGrabber$Exception
    //   834	858	227	com/googlecode/javacv/FrameGrabber$Exception
    //   858	885	227	com/googlecode/javacv/FrameGrabber$Exception
    //   898	908	227	com/googlecode/javacv/FrameGrabber$Exception
    //   913	948	227	com/googlecode/javacv/FrameGrabber$Exception
    //   948	972	227	com/googlecode/javacv/FrameGrabber$Exception
    //   977	1012	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1012	1023	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1028	1063	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1063	1077	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1082	1123	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1123	1149	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1154	1189	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1189	1215	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1215	1236	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1236	1253	227	com/googlecode/javacv/FrameGrabber$Exception
    //   1258	1293	227	com/googlecode/javacv/FrameGrabber$Exception
    //   103	131	888	finally
    //   131	143	888	finally
    //   147	159	888	finally
    //   164	174	888	finally
    //   177	187	888	finally
    //   192	227	888	finally
    //   233	248	888	finally
    //   248	254	888	finally
    //   254	265	888	finally
    //   834	858	888	finally
    //   858	885	888	finally
    //   898	908	888	finally
    //   913	948	888	finally
    //   948	972	888	finally
    //   977	1012	888	finally
    //   1012	1023	888	finally
    //   1028	1063	888	finally
    //   1063	1077	888	finally
    //   1082	1123	888	finally
    //   1123	1149	888	finally
    //   1154	1189	888	finally
    //   1189	1215	888	finally
    //   1215	1236	888	finally
    //   1236	1253	888	finally
    //   1258	1293	888	finally
    //   1301	1304	888	finally
    //   248	254	1321	java/lang/InterruptedException
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {
    this.enqueue_image = null;
    this.temp_image = null;
    this.return_image = null;
    this.timestamp = 0L;
    this.frameNumber = 0;
    int i = dc1394.dc1394_video_set_transmission(this.camera, 0);
    if (i != 0) {
      throw new FrameGrabber.Exception("dc1394_video_set_transmission() Error " + i + ": Could not stop the camera?");
    }
    int j = dc1394.dc1394_capture_stop(this.camera);
    if ((j != 0) && (j != -10)) {
      throw new FrameGrabber.Exception("dc1394_capture_stop() Error " + j + ": Could not stop the camera?");
    }
    if ((dc1394.dc1394_external_trigger_get_mode(this.camera, this.out) == 0) && (this.out[0] >= 384))
    {
      int k = dc1394.dc1394_external_trigger_set_power(this.camera, 0);
      if (k != 0) {
        throw new FrameGrabber.Exception("dc1394_external_trigger_set_power() Error " + k + ": Could not switch off external trigger.");
      }
    }
  }
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    enqueue();
    if (this.oneShotMode)
    {
      int j = dc1394.dc1394_video_set_one_shot(this.camera, 1);
      if (j != 0) {
        throw new FrameGrabber.Exception("dc1394_video_set_one_shot() Error " + j + ": Could not set camera into one-shot mode.");
      }
    }
    else
    {
      long l = System.currentTimeMillis();
      dc1394.dc1394_software_trigger_get_power(this.camera, this.out);
      if (System.currentTimeMillis() - l > this.timeout) {}
      for (;;)
      {
        int i = dc1394.dc1394_software_trigger_set_power(this.camera, 1);
        if (i == 0) {
          return;
        }
        throw new FrameGrabber.Exception("dc1394_software_trigger_set_power() Error " + i + ": Could not trigger camera.");
        if (this.out[0] == 1) {
          break;
        }
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\DC1394FrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */