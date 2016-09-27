package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacv.cpp.avcodec;
import com.googlecode.javacv.cpp.avcodec.AVCodec;
import com.googlecode.javacv.cpp.avcodec.AVCodecContext;
import com.googlecode.javacv.cpp.avcodec.AVFrame;
import com.googlecode.javacv.cpp.avcodec.AVPacket;
import com.googlecode.javacv.cpp.avcodec.AVPicture;
import com.googlecode.javacv.cpp.avformat;
import com.googlecode.javacv.cpp.avformat.AVFormatContext;
import com.googlecode.javacv.cpp.avformat.AVIOContext;
import com.googlecode.javacv.cpp.avformat.AVOutputFormat;
import com.googlecode.javacv.cpp.avformat.AVStream;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.avutil.AVDictionary;
import com.googlecode.javacv.cpp.avutil.AVRational;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.swresample;
import com.googlecode.javacv.cpp.swresample.SwrContext;
import com.googlecode.javacv.cpp.swscale;
import com.googlecode.javacv.cpp.swscale.SwsContext;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FFmpegFrameRecorder
  extends FrameRecorder
{
  private static FrameRecorder.Exception loadingException;
  private avcodec.AVCodecContext audio_c;
  private avcodec.AVCodec audio_codec;
  private int audio_input_frame_size;
  private BytePointer audio_outbuf;
  private int audio_outbuf_size;
  private avcodec.AVPacket audio_pkt;
  private avformat.AVStream audio_st;
  private String filename;
  private avcodec.AVFrame frame;
  private int[] got_audio_packet;
  private int[] got_video_packet;
  private swscale.SwsContext img_convert_ctx;
  private avformat.AVFormatContext oc;
  private avformat.AVOutputFormat oformat;
  private avcodec.AVFrame picture;
  private BytePointer picture_buf;
  private swresample.SwrContext samples_convert_ctx;
  private Pointer[] samples_in;
  private PointerPointer samples_in_ptr;
  private BytePointer[] samples_out;
  private PointerPointer samples_out_ptr;
  private avcodec.AVFrame tmp_picture;
  private avcodec.AVCodecContext video_c;
  private avcodec.AVCodec video_codec;
  private BytePointer video_outbuf;
  private int video_outbuf_size;
  private avcodec.AVPacket video_pkt;
  private avformat.AVStream video_st;
  
  static
  {
    if (!FFmpegFrameRecorder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      loadingException = null;
      return;
    }
  }
  
  public FFmpegFrameRecorder(File paramFile, int paramInt)
  {
    this(paramFile, 0, 0, paramInt);
  }
  
  public FFmpegFrameRecorder(File paramFile, int paramInt1, int paramInt2)
  {
    this(paramFile, paramInt1, paramInt2, 0);
  }
  
  public FFmpegFrameRecorder(File paramFile, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramFile.getAbsolutePath(), paramInt1, paramInt2);
  }
  
  public FFmpegFrameRecorder(String paramString, int paramInt)
  {
    this(paramString, 0, 0, paramInt);
  }
  
  public FFmpegFrameRecorder(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, paramInt1, paramInt2, 0);
  }
  
  public FFmpegFrameRecorder(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    avformat.av_register_all();
    avformat.avformat_network_init();
    this.filename = paramString;
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    this.audioChannels = paramInt3;
    this.pixelFormat = -1;
    this.videoCodec = 0;
    this.videoBitrate = 400000;
    this.frameRate = 30.0D;
    this.sampleFormat = -1;
    this.audioCodec = 0;
    this.audioBitrate = 64000;
    this.sampleRate = 44100;
    this.interleaved = true;
    this.video_pkt = new avcodec.AVPacket();
    this.audio_pkt = new avcodec.AVPacket();
  }
  
  public static FFmpegFrameRecorder createDefault(File paramFile, int paramInt1, int paramInt2)
    throws FrameRecorder.Exception
  {
    return new FFmpegFrameRecorder(paramFile, paramInt1, paramInt2);
  }
  
  public static FFmpegFrameRecorder createDefault(String paramString, int paramInt1, int paramInt2)
    throws FrameRecorder.Exception
  {
    return new FFmpegFrameRecorder(paramString, paramInt1, paramInt2);
  }
  
  public static void tryLoad()
    throws FrameRecorder.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      Loader.load(avutil.class);
      Loader.load(avcodec.class);
      Loader.load(avformat.class);
      Loader.load(swscale.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof FrameRecorder.Exception))
      {
        FrameRecorder.Exception localException2 = (FrameRecorder.Exception)localThrowable;
        loadingException = localException2;
        throw localException2;
      }
      FrameRecorder.Exception localException1 = new FrameRecorder.Exception("Failed to load " + FFmpegFrameRecorder.class, localThrowable);
      loadingException = localException1;
      throw localException1;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public int getFrameNumber()
  {
    if (this.picture == null) {
      return super.getFrameNumber();
    }
    return (int)this.picture.pts();
  }
  
  public long getTimestamp()
  {
    return Math.round(1000000L * getFrameNumber() / getFrameRate());
  }
  
  public void record(opencv_core.IplImage paramIplImage)
    throws FrameRecorder.Exception
  {
    record(paramIplImage, -1);
  }
  
  public void record(opencv_core.IplImage paramIplImage, int paramInt)
    throws FrameRecorder.Exception
  {
    if (this.video_st == null) {
      throw new FrameRecorder.Exception("No video output stream (Is imageWidth > 0 && imageHeight > 0 and has start() been called?)");
    }
    if (paramIplImage == null)
    {
      if ((0x20 & this.oformat.flags()) == 0) {
        break label660;
      }
      avcodec.av_init_packet(this.video_pkt);
      this.video_pkt.flags(0x1 | this.video_pkt.flags());
      this.video_pkt.stream_index(this.video_st.index());
      this.video_pkt.data(new BytePointer(this.picture));
      this.video_pkt.size(Loader.sizeof(avcodec.AVPicture.class));
    }
    for (;;)
    {
      synchronized (this.oc)
      {
        if ((!this.interleaved) || (this.audio_st == null)) {
          break label903;
        }
        int i4 = avformat.av_interleaved_write_frame(this.oc, this.video_pkt);
        if (i4 >= 0) {
          break label956;
        }
        throw new FrameRecorder.Exception("av_interleaved_write_frame() error " + i4 + " while writing interleaved video frame.");
      }
      int i = paramIplImage.width();
      int j = paramIplImage.height();
      int k = paramIplImage.widthStep();
      BytePointer localBytePointer = paramIplImage.imageData();
      int i5;
      int i6;
      if (paramInt == -1)
      {
        i5 = paramIplImage.depth();
        i6 = paramIplImage.nChannels();
        if (((i5 != 8) && (i5 != -2147483640)) || (i6 != 3)) {
          break label361;
        }
        paramInt = 3;
      }
      for (;;)
      {
        if ((this.video_c.pix_fmt() != paramInt) || (this.video_c.width() != i) || (this.video_c.height() != j))
        {
          swscale.SwsContext localSwsContext = this.img_convert_ctx;
          int m = this.video_c.width();
          int n = this.video_c.height();
          int i1 = this.video_c.pix_fmt();
          this.img_convert_ctx = swscale.sws_getCachedContext(localSwsContext, i, j, paramInt, m, n, i1, 2, null, null, null);
          if (this.img_convert_ctx == null)
          {
            throw new FrameRecorder.Exception("sws_getCachedContext() error: Cannot initialize the conversion context.");
            label361:
            if (((i5 == 8) || (i5 == -2147483640)) && (i6 == 1))
            {
              paramInt = 8;
            }
            else
            {
              if (((i5 == 16) || (i5 == -2147483632)) && (i6 == 1))
              {
                if (avutil.AV_HAVE_BIGENDIAN()) {}
                for (paramInt = 31;; paramInt = 32) {
                  break;
                }
              }
              if (((i5 == 8) || (i5 == -2147483640)) && (i6 == 4))
              {
                paramInt = 28;
              }
              else if (((i5 == 8) || (i5 == -2147483640)) && (i6 == 2))
              {
                paramInt = 26;
                k = i;
              }
              else
              {
                throw new FrameRecorder.Exception("Could not guess pixel format of image: depth=" + i5 + ", channels=" + i6);
              }
            }
          }
          else
          {
            avcodec.avpicture_fill(this.tmp_picture, localBytePointer, paramInt, i, j);
            avcodec.avpicture_fill(this.picture, this.picture_buf, this.video_c.pix_fmt(), this.video_c.width(), this.video_c.height());
            this.tmp_picture.linesize(0, k);
            swscale.sws_scale(this.img_convert_ctx, new PointerPointer(this.tmp_picture), this.tmp_picture.linesize(), 0, j, new PointerPointer(this.picture), this.picture.linesize());
            break;
          }
        }
      }
      avcodec.avpicture_fill(this.picture, localBytePointer, paramInt, i, j);
      this.picture.linesize(0, k);
      break;
      label660:
      avcodec.av_init_packet(this.video_pkt);
      this.video_pkt.data(this.video_outbuf);
      this.video_pkt.size(this.video_outbuf_size);
      this.picture.quality(this.video_c.global_quality());
      int i2 = avcodec.avcodec_encode_video2(this.video_c, this.video_pkt, this.picture, this.got_video_packet);
      if (i2 < 0) {
        throw new FrameRecorder.Exception("avcodec_encode_video2() error " + i2 + ": Could not encode video packet.");
      }
      this.picture.pts(1L + this.picture.pts());
      if (this.got_video_packet[0] == 0) {
        return;
      }
      if (this.video_pkt.pts() != Long.MIN_VALUE) {
        this.video_pkt.pts(avutil.av_rescale_q(this.video_pkt.pts(), this.video_c.time_base(), this.video_st.time_base()));
      }
      if (this.video_pkt.dts() != Long.MIN_VALUE) {
        this.video_pkt.dts(avutil.av_rescale_q(this.video_pkt.dts(), this.video_c.time_base(), this.video_st.time_base()));
      }
      this.video_pkt.stream_index(this.video_st.index());
    }
    label903:
    int i3 = avformat.av_write_frame(this.oc, this.video_pkt);
    if (i3 < 0) {
      throw new FrameRecorder.Exception("av_write_frame() error " + i3 + " while writing video frame.");
    }
    label956:
  }
  
  /* Error */
  public void record(java.nio.Buffer[] paramArrayOfBuffer)
    throws FrameRecorder.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 275	com/googlecode/javacv/FFmpegFrameRecorder:audio_st	Lcom/googlecode/javacv/cpp/avformat$AVStream;
    //   4: ifnonnull +14 -> 18
    //   7: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   10: dup
    //   11: ldc_w 409
    //   14: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: iconst_0
    //   20: aaload
    //   21: invokevirtual 414	java/nio/Buffer:limit	()I
    //   24: aload_1
    //   25: iconst_0
    //   26: aaload
    //   27: invokevirtual 417	java/nio/Buffer:position	()I
    //   30: isub
    //   31: istore_2
    //   32: aload_1
    //   33: arraylength
    //   34: iconst_1
    //   35: if_icmple +143 -> 178
    //   38: iconst_1
    //   39: istore_3
    //   40: aload_0
    //   41: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   44: invokevirtual 422	com/googlecode/javacv/cpp/avcodec$AVCodecContext:sample_fmt	()I
    //   47: istore 4
    //   49: aload_0
    //   50: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   53: arraylength
    //   54: iconst_1
    //   55: if_icmple +131 -> 186
    //   58: iconst_1
    //   59: istore 5
    //   61: iload 4
    //   63: invokestatic 428	com/googlecode/javacv/cpp/avutil:av_get_bytes_per_sample	(I)I
    //   66: istore 6
    //   68: aload_1
    //   69: iconst_0
    //   70: aaload
    //   71: instanceof 430
    //   74: ifeq +146 -> 220
    //   77: aload_1
    //   78: arraylength
    //   79: iconst_1
    //   80: if_icmple +115 -> 195
    //   83: iconst_5
    //   84: istore 7
    //   86: iconst_1
    //   87: istore 8
    //   89: iconst_0
    //   90: istore 51
    //   92: iload 51
    //   94: aload_1
    //   95: arraylength
    //   96: if_icmpge +701 -> 797
    //   99: aload_1
    //   100: iload 51
    //   102: aaload
    //   103: checkcast 430	java/nio/ByteBuffer
    //   106: astore 52
    //   108: aload_0
    //   109: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   112: iload 51
    //   114: aaload
    //   115: instanceof 255
    //   118: ifeq +83 -> 201
    //   121: aload_0
    //   122: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   125: iload 51
    //   127: aaload
    //   128: invokevirtual 437	com/googlecode/javacpp/Pointer:capacity	()I
    //   131: iload_2
    //   132: if_icmplt +69 -> 201
    //   135: aload 52
    //   137: invokevirtual 440	java/nio/ByteBuffer:hasArray	()Z
    //   140: ifeq +61 -> 201
    //   143: aload_0
    //   144: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   147: iload 51
    //   149: aaload
    //   150: checkcast 255	com/googlecode/javacpp/BytePointer
    //   153: iconst_0
    //   154: invokevirtual 443	com/googlecode/javacpp/BytePointer:position	(I)Lcom/googlecode/javacpp/BytePointer;
    //   157: aload 52
    //   159: invokevirtual 447	java/nio/ByteBuffer:array	()[B
    //   162: aload 52
    //   164: invokevirtual 448	java/nio/ByteBuffer:position	()I
    //   167: iload_2
    //   168: invokevirtual 452	com/googlecode/javacpp/BytePointer:put	([BII)Lcom/googlecode/javacpp/BytePointer;
    //   171: pop
    //   172: iinc 51 1
    //   175: goto -83 -> 92
    //   178: aload_0
    //   179: getfield 105	com/googlecode/javacv/FFmpegFrameRecorder:audioChannels	I
    //   182: istore_3
    //   183: goto -143 -> 40
    //   186: aload_0
    //   187: getfield 105	com/googlecode/javacv/FFmpegFrameRecorder:audioChannels	I
    //   190: istore 5
    //   192: goto -131 -> 61
    //   195: iconst_0
    //   196: istore 7
    //   198: goto -112 -> 86
    //   201: aload_0
    //   202: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   205: iload 51
    //   207: new 255	com/googlecode/javacpp/BytePointer
    //   210: dup
    //   211: aload 52
    //   213: invokespecial 455	com/googlecode/javacpp/BytePointer:<init>	(Ljava/nio/ByteBuffer;)V
    //   216: aastore
    //   217: goto -45 -> 172
    //   220: aload_1
    //   221: iconst_0
    //   222: aaload
    //   223: instanceof 457
    //   226: ifeq +132 -> 358
    //   229: aload_1
    //   230: arraylength
    //   231: iconst_1
    //   232: if_icmple +101 -> 333
    //   235: bipush 6
    //   237: istore 7
    //   239: iconst_2
    //   240: istore 8
    //   242: iconst_0
    //   243: istore 48
    //   245: iload 48
    //   247: aload_1
    //   248: arraylength
    //   249: if_icmpge +548 -> 797
    //   252: aload_1
    //   253: iload 48
    //   255: aaload
    //   256: checkcast 457	java/nio/ShortBuffer
    //   259: astore 49
    //   261: aload_0
    //   262: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   265: iload 48
    //   267: aaload
    //   268: instanceof 459
    //   271: ifeq +68 -> 339
    //   274: aload_0
    //   275: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   278: iload 48
    //   280: aaload
    //   281: invokevirtual 437	com/googlecode/javacpp/Pointer:capacity	()I
    //   284: iload_2
    //   285: if_icmplt +54 -> 339
    //   288: aload 49
    //   290: invokevirtual 460	java/nio/ShortBuffer:hasArray	()Z
    //   293: ifeq +46 -> 339
    //   296: aload_0
    //   297: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   300: iload 48
    //   302: aaload
    //   303: checkcast 459	com/googlecode/javacpp/ShortPointer
    //   306: iconst_0
    //   307: invokevirtual 463	com/googlecode/javacpp/ShortPointer:position	(I)Lcom/googlecode/javacpp/ShortPointer;
    //   310: aload 49
    //   312: invokevirtual 466	java/nio/ShortBuffer:array	()[S
    //   315: aload_1
    //   316: iload 48
    //   318: aaload
    //   319: invokevirtual 417	java/nio/Buffer:position	()I
    //   322: iload_2
    //   323: invokevirtual 469	com/googlecode/javacpp/ShortPointer:put	([SII)Lcom/googlecode/javacpp/ShortPointer;
    //   326: pop
    //   327: iinc 48 1
    //   330: goto -85 -> 245
    //   333: iconst_1
    //   334: istore 7
    //   336: goto -97 -> 239
    //   339: aload_0
    //   340: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   343: iload 48
    //   345: new 459	com/googlecode/javacpp/ShortPointer
    //   348: dup
    //   349: aload 49
    //   351: invokespecial 472	com/googlecode/javacpp/ShortPointer:<init>	(Ljava/nio/ShortBuffer;)V
    //   354: aastore
    //   355: goto -28 -> 327
    //   358: aload_1
    //   359: iconst_0
    //   360: aaload
    //   361: instanceof 474
    //   364: ifeq +132 -> 496
    //   367: aload_1
    //   368: arraylength
    //   369: iconst_1
    //   370: if_icmple +101 -> 471
    //   373: bipush 7
    //   375: istore 7
    //   377: iconst_4
    //   378: istore 8
    //   380: iconst_0
    //   381: istore 45
    //   383: iload 45
    //   385: aload_1
    //   386: arraylength
    //   387: if_icmpge +410 -> 797
    //   390: aload_1
    //   391: iload 45
    //   393: aaload
    //   394: checkcast 474	java/nio/IntBuffer
    //   397: astore 46
    //   399: aload_0
    //   400: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   403: iload 45
    //   405: aaload
    //   406: instanceof 476
    //   409: ifeq +68 -> 477
    //   412: aload_0
    //   413: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   416: iload 45
    //   418: aaload
    //   419: invokevirtual 437	com/googlecode/javacpp/Pointer:capacity	()I
    //   422: iload_2
    //   423: if_icmplt +54 -> 477
    //   426: aload 46
    //   428: invokevirtual 477	java/nio/IntBuffer:hasArray	()Z
    //   431: ifeq +46 -> 477
    //   434: aload_0
    //   435: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   438: iload 45
    //   440: aaload
    //   441: checkcast 476	com/googlecode/javacpp/IntPointer
    //   444: iconst_0
    //   445: invokevirtual 480	com/googlecode/javacpp/IntPointer:position	(I)Lcom/googlecode/javacpp/IntPointer;
    //   448: aload 46
    //   450: invokevirtual 483	java/nio/IntBuffer:array	()[I
    //   453: aload_1
    //   454: iload 45
    //   456: aaload
    //   457: invokevirtual 417	java/nio/Buffer:position	()I
    //   460: iload_2
    //   461: invokevirtual 486	com/googlecode/javacpp/IntPointer:put	([III)Lcom/googlecode/javacpp/IntPointer;
    //   464: pop
    //   465: iinc 45 1
    //   468: goto -85 -> 383
    //   471: iconst_2
    //   472: istore 7
    //   474: goto -97 -> 377
    //   477: aload_0
    //   478: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   481: iload 45
    //   483: new 476	com/googlecode/javacpp/IntPointer
    //   486: dup
    //   487: aload 46
    //   489: invokespecial 489	com/googlecode/javacpp/IntPointer:<init>	(Ljava/nio/IntBuffer;)V
    //   492: aastore
    //   493: goto -28 -> 465
    //   496: aload_1
    //   497: iconst_0
    //   498: aaload
    //   499: instanceof 491
    //   502: ifeq +130 -> 632
    //   505: aload_1
    //   506: arraylength
    //   507: iconst_1
    //   508: if_icmple +99 -> 607
    //   511: bipush 8
    //   513: istore 7
    //   515: iconst_4
    //   516: istore 8
    //   518: iconst_0
    //   519: istore 42
    //   521: iload 42
    //   523: aload_1
    //   524: arraylength
    //   525: if_icmpge +272 -> 797
    //   528: aload_1
    //   529: iload 42
    //   531: aaload
    //   532: checkcast 491	java/nio/FloatBuffer
    //   535: astore 43
    //   537: aload_0
    //   538: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   541: iload 42
    //   543: aaload
    //   544: instanceof 493
    //   547: ifeq +66 -> 613
    //   550: aload_0
    //   551: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   554: iload 42
    //   556: aaload
    //   557: invokevirtual 437	com/googlecode/javacpp/Pointer:capacity	()I
    //   560: iload_2
    //   561: if_icmplt +52 -> 613
    //   564: aload 43
    //   566: invokevirtual 494	java/nio/FloatBuffer:hasArray	()Z
    //   569: ifeq +44 -> 613
    //   572: aload_0
    //   573: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   576: iload 42
    //   578: aaload
    //   579: checkcast 493	com/googlecode/javacpp/FloatPointer
    //   582: iconst_0
    //   583: invokevirtual 497	com/googlecode/javacpp/FloatPointer:position	(I)Lcom/googlecode/javacpp/FloatPointer;
    //   586: aload 43
    //   588: invokevirtual 500	java/nio/FloatBuffer:array	()[F
    //   591: aload 43
    //   593: invokevirtual 501	java/nio/FloatBuffer:position	()I
    //   596: iload_2
    //   597: invokevirtual 504	com/googlecode/javacpp/FloatPointer:put	([FII)Lcom/googlecode/javacpp/FloatPointer;
    //   600: pop
    //   601: iinc 42 1
    //   604: goto -83 -> 521
    //   607: iconst_3
    //   608: istore 7
    //   610: goto -95 -> 515
    //   613: aload_0
    //   614: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   617: iload 42
    //   619: new 493	com/googlecode/javacpp/FloatPointer
    //   622: dup
    //   623: aload 43
    //   625: invokespecial 507	com/googlecode/javacpp/FloatPointer:<init>	(Ljava/nio/FloatBuffer;)V
    //   628: aastore
    //   629: goto -28 -> 601
    //   632: aload_1
    //   633: iconst_0
    //   634: aaload
    //   635: instanceof 509
    //   638: ifeq +131 -> 769
    //   641: aload_1
    //   642: arraylength
    //   643: iconst_1
    //   644: if_icmple +100 -> 744
    //   647: bipush 9
    //   649: istore 7
    //   651: bipush 8
    //   653: istore 8
    //   655: iconst_0
    //   656: istore 9
    //   658: iload 9
    //   660: aload_1
    //   661: arraylength
    //   662: if_icmpge +135 -> 797
    //   665: aload_1
    //   666: iload 9
    //   668: aaload
    //   669: checkcast 509	java/nio/DoubleBuffer
    //   672: astore 40
    //   674: aload_0
    //   675: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   678: iload 9
    //   680: aaload
    //   681: instanceof 511
    //   684: ifeq +66 -> 750
    //   687: aload_0
    //   688: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   691: iload 9
    //   693: aaload
    //   694: invokevirtual 437	com/googlecode/javacpp/Pointer:capacity	()I
    //   697: iload_2
    //   698: if_icmplt +52 -> 750
    //   701: aload 40
    //   703: invokevirtual 512	java/nio/DoubleBuffer:hasArray	()Z
    //   706: ifeq +44 -> 750
    //   709: aload_0
    //   710: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   713: iload 9
    //   715: aaload
    //   716: checkcast 511	com/googlecode/javacpp/DoublePointer
    //   719: iconst_0
    //   720: invokevirtual 515	com/googlecode/javacpp/DoublePointer:position	(I)Lcom/googlecode/javacpp/DoublePointer;
    //   723: aload 40
    //   725: invokevirtual 518	java/nio/DoubleBuffer:array	()[D
    //   728: aload 40
    //   730: invokevirtual 519	java/nio/DoubleBuffer:position	()I
    //   733: iload_2
    //   734: invokevirtual 522	com/googlecode/javacpp/DoublePointer:put	([DII)Lcom/googlecode/javacpp/DoublePointer;
    //   737: pop
    //   738: iinc 9 1
    //   741: goto -83 -> 658
    //   744: iconst_4
    //   745: istore 7
    //   747: goto -96 -> 651
    //   750: aload_0
    //   751: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   754: iload 9
    //   756: new 511	com/googlecode/javacpp/DoublePointer
    //   759: dup
    //   760: aload 40
    //   762: invokespecial 525	com/googlecode/javacpp/DoublePointer:<init>	(Ljava/nio/DoubleBuffer;)V
    //   765: aastore
    //   766: goto -28 -> 738
    //   769: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   772: dup
    //   773: new 169	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   780: ldc_w 527
    //   783: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload_1
    //   787: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   796: athrow
    //   797: aload_0
    //   798: getfield 529	com/googlecode/javacv/FFmpegFrameRecorder:samples_convert_ctx	Lcom/googlecode/javacv/cpp/swresample$SwrContext;
    //   801: ifnonnull +112 -> 913
    //   804: aload_0
    //   805: aconst_null
    //   806: aload_0
    //   807: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   810: invokevirtual 532	com/googlecode/javacv/cpp/avcodec$AVCodecContext:channel_layout	()J
    //   813: iload 4
    //   815: aload_0
    //   816: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   819: invokevirtual 535	com/googlecode/javacv/cpp/avcodec$AVCodecContext:sample_rate	()I
    //   822: aload_0
    //   823: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   826: invokevirtual 532	com/googlecode/javacv/cpp/avcodec$AVCodecContext:channel_layout	()J
    //   829: iload 7
    //   831: aload_0
    //   832: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   835: invokevirtual 535	com/googlecode/javacv/cpp/avcodec$AVCodecContext:sample_rate	()I
    //   838: iconst_0
    //   839: aconst_null
    //   840: invokestatic 541	com/googlecode/javacv/cpp/swresample:swr_alloc_set_opts	(Lcom/googlecode/javacv/cpp/swresample$SwrContext;JIIJIIILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/swresample$SwrContext;
    //   843: putfield 529	com/googlecode/javacv/FFmpegFrameRecorder:samples_convert_ctx	Lcom/googlecode/javacv/cpp/swresample$SwrContext;
    //   846: aload_0
    //   847: getfield 529	com/googlecode/javacv/FFmpegFrameRecorder:samples_convert_ctx	Lcom/googlecode/javacv/cpp/swresample$SwrContext;
    //   850: ifnonnull +14 -> 864
    //   853: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   856: dup
    //   857: ldc_w 543
    //   860: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   863: athrow
    //   864: aload_0
    //   865: getfield 529	com/googlecode/javacv/FFmpegFrameRecorder:samples_convert_ctx	Lcom/googlecode/javacv/cpp/swresample$SwrContext;
    //   868: invokestatic 547	com/googlecode/javacv/cpp/swresample:swr_init	(Lcom/googlecode/javacv/cpp/swresample$SwrContext;)I
    //   871: istore 39
    //   873: iload 39
    //   875: ifge +38 -> 913
    //   878: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   881: dup
    //   882: new 169	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   889: ldc_w 549
    //   892: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: iload 39
    //   897: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   900: ldc_w 551
    //   903: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   912: athrow
    //   913: iconst_0
    //   914: istore 10
    //   916: iload 10
    //   918: aload_1
    //   919: arraylength
    //   920: if_icmpge +54 -> 974
    //   923: aload_0
    //   924: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   927: iload 10
    //   929: aaload
    //   930: iload 8
    //   932: aload_0
    //   933: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   936: iload 10
    //   938: aaload
    //   939: invokevirtual 552	com/googlecode/javacpp/Pointer:position	()I
    //   942: imul
    //   943: invokevirtual 555	com/googlecode/javacpp/Pointer:position	(I)Lcom/googlecode/javacpp/Pointer;
    //   946: iload 8
    //   948: iload_2
    //   949: aload_0
    //   950: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   953: iload 10
    //   955: aaload
    //   956: invokevirtual 552	com/googlecode/javacpp/Pointer:position	()I
    //   959: iadd
    //   960: imul
    //   961: invokevirtual 557	com/googlecode/javacpp/Pointer:limit	(I)Lcom/googlecode/javacpp/Pointer;
    //   964: pop
    //   965: iinc 10 1
    //   968: goto -52 -> 916
    //   971: aload 26
    //   973: monitorexit
    //   974: aload_0
    //   975: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   978: iconst_0
    //   979: aaload
    //   980: invokevirtual 552	com/googlecode/javacpp/Pointer:position	()I
    //   983: aload_0
    //   984: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   987: iconst_0
    //   988: aaload
    //   989: invokevirtual 558	com/googlecode/javacpp/Pointer:limit	()I
    //   992: if_icmpge +784 -> 1776
    //   995: aload_0
    //   996: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   999: iconst_0
    //   1000: aaload
    //   1001: invokevirtual 558	com/googlecode/javacpp/Pointer:limit	()I
    //   1004: aload_0
    //   1005: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   1008: iconst_0
    //   1009: aaload
    //   1010: invokevirtual 552	com/googlecode/javacpp/Pointer:position	()I
    //   1013: isub
    //   1014: iload_3
    //   1015: iload 8
    //   1017: imul
    //   1018: idiv
    //   1019: aload_0
    //   1020: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1023: iconst_0
    //   1024: aaload
    //   1025: invokevirtual 559	com/googlecode/javacpp/BytePointer:limit	()I
    //   1028: aload_0
    //   1029: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1032: iconst_0
    //   1033: aaload
    //   1034: invokevirtual 560	com/googlecode/javacpp/BytePointer:position	()I
    //   1037: isub
    //   1038: iload 5
    //   1040: iload 6
    //   1042: imul
    //   1043: idiv
    //   1044: invokestatic 564	java/lang/Math:min	(II)I
    //   1047: istore 11
    //   1049: iconst_0
    //   1050: istore 12
    //   1052: iload 12
    //   1054: aload_1
    //   1055: arraylength
    //   1056: if_icmpge +26 -> 1082
    //   1059: aload_0
    //   1060: getfield 566	com/googlecode/javacv/FFmpegFrameRecorder:samples_in_ptr	Lcom/googlecode/javacpp/PointerPointer;
    //   1063: iload 12
    //   1065: aload_0
    //   1066: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   1069: iload 12
    //   1071: aaload
    //   1072: invokevirtual 569	com/googlecode/javacpp/PointerPointer:put	(ILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/PointerPointer;
    //   1075: pop
    //   1076: iinc 12 1
    //   1079: goto -27 -> 1052
    //   1082: iconst_0
    //   1083: istore 13
    //   1085: iload 13
    //   1087: aload_0
    //   1088: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1091: arraylength
    //   1092: if_icmpge +26 -> 1118
    //   1095: aload_0
    //   1096: getfield 571	com/googlecode/javacv/FFmpegFrameRecorder:samples_out_ptr	Lcom/googlecode/javacpp/PointerPointer;
    //   1099: iload 13
    //   1101: aload_0
    //   1102: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1105: iload 13
    //   1107: aaload
    //   1108: invokevirtual 569	com/googlecode/javacpp/PointerPointer:put	(ILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/PointerPointer;
    //   1111: pop
    //   1112: iinc 13 1
    //   1115: goto -30 -> 1085
    //   1118: aload_0
    //   1119: getfield 529	com/googlecode/javacv/FFmpegFrameRecorder:samples_convert_ctx	Lcom/googlecode/javacv/cpp/swresample$SwrContext;
    //   1122: aload_0
    //   1123: getfield 571	com/googlecode/javacv/FFmpegFrameRecorder:samples_out_ptr	Lcom/googlecode/javacpp/PointerPointer;
    //   1126: iload 11
    //   1128: aload_0
    //   1129: getfield 566	com/googlecode/javacv/FFmpegFrameRecorder:samples_in_ptr	Lcom/googlecode/javacpp/PointerPointer;
    //   1132: iload 11
    //   1134: invokestatic 575	com/googlecode/javacv/cpp/swresample:swr_convert	(Lcom/googlecode/javacv/cpp/swresample$SwrContext;Lcom/googlecode/javacpp/PointerPointer;ILcom/googlecode/javacpp/PointerPointer;I)I
    //   1137: istore 14
    //   1139: iload 14
    //   1141: ifge +38 -> 1179
    //   1144: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   1147: dup
    //   1148: new 169	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1155: ldc_w 577
    //   1158: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: iload 14
    //   1163: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: ldc_w 579
    //   1169: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   1178: athrow
    //   1179: iconst_0
    //   1180: istore 15
    //   1182: iload 15
    //   1184: aload_1
    //   1185: arraylength
    //   1186: if_icmpge +38 -> 1224
    //   1189: aload_0
    //   1190: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   1193: iload 15
    //   1195: aaload
    //   1196: aload_0
    //   1197: getfield 432	com/googlecode/javacv/FFmpegFrameRecorder:samples_in	[Lcom/googlecode/javacpp/Pointer;
    //   1200: iload 15
    //   1202: aaload
    //   1203: invokevirtual 552	com/googlecode/javacpp/Pointer:position	()I
    //   1206: iload 8
    //   1208: iload 14
    //   1210: iload_3
    //   1211: imul
    //   1212: imul
    //   1213: iadd
    //   1214: invokevirtual 555	com/googlecode/javacpp/Pointer:position	(I)Lcom/googlecode/javacpp/Pointer;
    //   1217: pop
    //   1218: iinc 15 1
    //   1221: goto -39 -> 1182
    //   1224: iconst_0
    //   1225: istore 16
    //   1227: iload 16
    //   1229: aload_0
    //   1230: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1233: arraylength
    //   1234: if_icmpge +39 -> 1273
    //   1237: aload_0
    //   1238: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1241: iload 16
    //   1243: aaload
    //   1244: aload_0
    //   1245: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1248: iload 16
    //   1250: aaload
    //   1251: invokevirtual 560	com/googlecode/javacpp/BytePointer:position	()I
    //   1254: iload 6
    //   1256: iload 14
    //   1258: iload 5
    //   1260: imul
    //   1261: imul
    //   1262: iadd
    //   1263: invokevirtual 443	com/googlecode/javacpp/BytePointer:position	(I)Lcom/googlecode/javacpp/BytePointer;
    //   1266: pop
    //   1267: iinc 16 1
    //   1270: goto -43 -> 1227
    //   1273: aload_0
    //   1274: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1277: iconst_0
    //   1278: aaload
    //   1279: invokevirtual 560	com/googlecode/javacpp/BytePointer:position	()I
    //   1282: aload_0
    //   1283: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1286: iconst_0
    //   1287: aaload
    //   1288: invokevirtual 559	com/googlecode/javacpp/BytePointer:limit	()I
    //   1291: if_icmplt -317 -> 974
    //   1294: aload_0
    //   1295: getfield 581	com/googlecode/javacv/FFmpegFrameRecorder:frame	Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1298: aload_0
    //   1299: getfield 583	com/googlecode/javacv/FFmpegFrameRecorder:audio_input_frame_size	I
    //   1302: invokevirtual 586	com/googlecode/javacv/cpp/avcodec$AVFrame:nb_samples	(I)Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1305: pop
    //   1306: aload_0
    //   1307: getfield 581	com/googlecode/javacv/FFmpegFrameRecorder:frame	Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1310: aload_0
    //   1311: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1314: invokevirtual 589	com/googlecode/javacv/cpp/avcodec$AVCodecContext:channels	()I
    //   1317: iload 4
    //   1319: aload_0
    //   1320: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1323: iconst_0
    //   1324: aaload
    //   1325: aload_0
    //   1326: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1329: iconst_0
    //   1330: aaload
    //   1331: invokevirtual 559	com/googlecode/javacpp/BytePointer:limit	()I
    //   1334: iconst_0
    //   1335: invokestatic 593	com/googlecode/javacv/cpp/avcodec:avcodec_fill_audio_frame	(Lcom/googlecode/javacv/cpp/avcodec$AVFrame;IILcom/googlecode/javacpp/BytePointer;II)I
    //   1338: pop
    //   1339: iconst_0
    //   1340: istore 19
    //   1342: iload 19
    //   1344: aload_0
    //   1345: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1348: arraylength
    //   1349: if_icmpge +50 -> 1399
    //   1352: aload_0
    //   1353: getfield 581	com/googlecode/javacv/FFmpegFrameRecorder:frame	Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1356: iload 19
    //   1358: aload_0
    //   1359: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1362: iload 19
    //   1364: aaload
    //   1365: iconst_0
    //   1366: invokevirtual 443	com/googlecode/javacpp/BytePointer:position	(I)Lcom/googlecode/javacpp/BytePointer;
    //   1369: invokevirtual 596	com/googlecode/javacv/cpp/avcodec$AVFrame:data	(ILcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avcodec$AVPicture;
    //   1372: pop
    //   1373: aload_0
    //   1374: getfield 581	com/googlecode/javacv/FFmpegFrameRecorder:frame	Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1377: iload 19
    //   1379: aload_0
    //   1380: getfield 424	com/googlecode/javacv/FFmpegFrameRecorder:samples_out	[Lcom/googlecode/javacpp/BytePointer;
    //   1383: iload 19
    //   1385: aaload
    //   1386: invokevirtual 559	com/googlecode/javacpp/BytePointer:limit	()I
    //   1389: invokevirtual 345	com/googlecode/javacv/cpp/avcodec$AVFrame:linesize	(II)Lcom/googlecode/javacv/cpp/avcodec$AVPicture;
    //   1392: pop
    //   1393: iinc 19 1
    //   1396: goto -54 -> 1342
    //   1399: aload_0
    //   1400: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1403: invokestatic 241	com/googlecode/javacv/cpp/avcodec:av_init_packet	(Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V
    //   1406: aload_0
    //   1407: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1410: aload_0
    //   1411: getfield 598	com/googlecode/javacv/FFmpegFrameRecorder:audio_outbuf	Lcom/googlecode/javacpp/BytePointer;
    //   1414: invokevirtual 262	com/googlecode/javacv/cpp/avcodec$AVPacket:data	(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1417: pop
    //   1418: aload_0
    //   1419: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1422: aload_0
    //   1423: getfield 600	com/googlecode/javacv/FFmpegFrameRecorder:audio_outbuf_size	I
    //   1426: invokevirtual 271	com/googlecode/javacv/cpp/avcodec$AVPacket:size	(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1429: pop
    //   1430: aload_0
    //   1431: getfield 581	com/googlecode/javacv/FFmpegFrameRecorder:frame	Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1434: aload_0
    //   1435: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1438: invokevirtual 362	com/googlecode/javacv/cpp/avcodec$AVCodecContext:global_quality	()I
    //   1441: invokevirtual 366	com/googlecode/javacv/cpp/avcodec$AVFrame:quality	(I)Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1444: pop
    //   1445: aload_0
    //   1446: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1449: aload_0
    //   1450: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1453: aload_0
    //   1454: getfield 581	com/googlecode/javacv/FFmpegFrameRecorder:frame	Lcom/googlecode/javacv/cpp/avcodec$AVFrame;
    //   1457: aload_0
    //   1458: getfield 602	com/googlecode/javacv/FFmpegFrameRecorder:got_audio_packet	[I
    //   1461: invokestatic 605	com/googlecode/javacv/cpp/avcodec:avcodec_encode_audio2	(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVFrame;[I)I
    //   1464: istore 23
    //   1466: iload 23
    //   1468: ifge +38 -> 1506
    //   1471: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   1474: dup
    //   1475: new 169	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1482: ldc_w 607
    //   1485: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: iload 23
    //   1490: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1493: ldc_w 609
    //   1496: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1502: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   1505: athrow
    //   1506: aload_0
    //   1507: getfield 602	com/googlecode/javacv/FFmpegFrameRecorder:got_audio_packet	[I
    //   1510: iconst_0
    //   1511: iaload
    //   1512: ifeq -538 -> 974
    //   1515: aload_0
    //   1516: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1519: invokevirtual 380	com/googlecode/javacv/cpp/avcodec$AVPacket:pts	()J
    //   1522: ldc2_w 381
    //   1525: lcmp
    //   1526: ifeq +35 -> 1561
    //   1529: aload_0
    //   1530: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1533: aload_0
    //   1534: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1537: invokevirtual 380	com/googlecode/javacv/cpp/avcodec$AVPacket:pts	()J
    //   1540: aload_0
    //   1541: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1544: invokevirtual 386	com/googlecode/javacv/cpp/avcodec$AVCodecContext:time_base	()Lcom/googlecode/javacv/cpp/avutil$AVRational;
    //   1547: aload_0
    //   1548: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1551: invokevirtual 386	com/googlecode/javacv/cpp/avcodec$AVCodecContext:time_base	()Lcom/googlecode/javacv/cpp/avutil$AVRational;
    //   1554: invokestatic 391	com/googlecode/javacv/cpp/avutil:av_rescale_q	(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J
    //   1557: invokevirtual 394	com/googlecode/javacv/cpp/avcodec$AVPacket:pts	(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1560: pop
    //   1561: aload_0
    //   1562: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1565: invokevirtual 397	com/googlecode/javacv/cpp/avcodec$AVPacket:dts	()J
    //   1568: ldc2_w 381
    //   1571: lcmp
    //   1572: ifeq +35 -> 1607
    //   1575: aload_0
    //   1576: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1579: aload_0
    //   1580: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1583: invokevirtual 397	com/googlecode/javacv/cpp/avcodec$AVPacket:dts	()J
    //   1586: aload_0
    //   1587: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1590: invokevirtual 386	com/googlecode/javacv/cpp/avcodec$AVCodecContext:time_base	()Lcom/googlecode/javacv/cpp/avutil$AVRational;
    //   1593: aload_0
    //   1594: getfield 419	com/googlecode/javacv/FFmpegFrameRecorder:audio_c	Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;
    //   1597: invokevirtual 386	com/googlecode/javacv/cpp/avcodec$AVCodecContext:time_base	()Lcom/googlecode/javacv/cpp/avutil$AVRational;
    //   1600: invokestatic 391	com/googlecode/javacv/cpp/avutil:av_rescale_q	(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J
    //   1603: invokevirtual 399	com/googlecode/javacv/cpp/avcodec$AVPacket:dts	(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1606: pop
    //   1607: aload_0
    //   1608: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1611: iconst_1
    //   1612: aload_0
    //   1613: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1616: invokevirtual 242	com/googlecode/javacv/cpp/avcodec$AVPacket:flags	()I
    //   1619: ior
    //   1620: invokevirtual 245	com/googlecode/javacv/cpp/avcodec$AVPacket:flags	(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1623: pop
    //   1624: aload_0
    //   1625: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1628: aload_0
    //   1629: getfield 275	com/googlecode/javacv/FFmpegFrameRecorder:audio_st	Lcom/googlecode/javacv/cpp/avformat$AVStream;
    //   1632: invokevirtual 250	com/googlecode/javacv/cpp/avformat$AVStream:index	()I
    //   1635: invokevirtual 253	com/googlecode/javacv/cpp/avcodec$AVPacket:stream_index	(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1638: pop
    //   1639: aload_0
    //   1640: getfield 273	com/googlecode/javacv/FFmpegFrameRecorder:oc	Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;
    //   1643: astore 26
    //   1645: aload 26
    //   1647: monitorenter
    //   1648: aload_0
    //   1649: getfield 138	com/googlecode/javacv/FFmpegFrameRecorder:interleaved	Z
    //   1652: ifeq +71 -> 1723
    //   1655: aload_0
    //   1656: getfield 225	com/googlecode/javacv/FFmpegFrameRecorder:video_st	Lcom/googlecode/javacv/cpp/avformat$AVStream;
    //   1659: ifnull +64 -> 1723
    //   1662: aload_0
    //   1663: getfield 273	com/googlecode/javacv/FFmpegFrameRecorder:oc	Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;
    //   1666: aload_0
    //   1667: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1670: invokestatic 279	com/googlecode/javacv/cpp/avformat:av_interleaved_write_frame	(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I
    //   1673: istore 29
    //   1675: iload 29
    //   1677: ifge -706 -> 971
    //   1680: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   1683: dup
    //   1684: new 169	java/lang/StringBuilder
    //   1687: dup
    //   1688: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1691: ldc_w 281
    //   1694: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: iload 29
    //   1699: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1702: ldc_w 611
    //   1705: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1711: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   1714: athrow
    //   1715: astore 27
    //   1717: aload 26
    //   1719: monitorexit
    //   1720: aload 27
    //   1722: athrow
    //   1723: aload_0
    //   1724: getfield 273	com/googlecode/javacv/FFmpegFrameRecorder:oc	Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;
    //   1727: aload_0
    //   1728: getfield 145	com/googlecode/javacv/FFmpegFrameRecorder:audio_pkt	Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    //   1731: invokestatic 402	com/googlecode/javacv/cpp/avformat:av_write_frame	(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I
    //   1734: istore 28
    //   1736: iload 28
    //   1738: ifge -767 -> 971
    //   1741: new 149	com/googlecode/javacv/FrameRecorder$Exception
    //   1744: dup
    //   1745: new 169	java/lang/StringBuilder
    //   1748: dup
    //   1749: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1752: ldc_w 404
    //   1755: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: iload 28
    //   1760: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1763: ldc_w 613
    //   1766: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: invokespecial 230	com/googlecode/javacv/FrameRecorder$Exception:<init>	(Ljava/lang/String;)V
    //   1775: athrow
    //   1776: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1777	0	this	FFmpegFrameRecorder
    //   0	1777	1	paramArrayOfBuffer	java.nio.Buffer[]
    //   31	929	2	i	int
    //   39	1173	3	j	int
    //   47	1271	4	k	int
    //   59	1202	5	m	int
    //   66	1196	6	n	int
    //   84	746	7	i1	int
    //   87	1126	8	i2	int
    //   656	99	9	i3	int
    //   914	52	10	i4	int
    //   1047	86	11	i5	int
    //   1050	27	12	i6	int
    //   1083	30	13	i7	int
    //   1137	124	14	i8	int
    //   1180	39	15	i9	int
    //   1225	43	16	i10	int
    //   1340	54	19	i11	int
    //   1464	25	23	i12	int
    //   971	747	26	localAVFormatContext	avformat.AVFormatContext
    //   1715	6	27	localObject	Object
    //   1734	25	28	i13	int
    //   1673	25	29	i14	int
    //   871	25	39	i15	int
    //   672	89	40	localDoubleBuffer	java.nio.DoubleBuffer
    //   519	99	42	i16	int
    //   535	89	43	localFloatBuffer	java.nio.FloatBuffer
    //   381	101	45	i17	int
    //   397	91	46	localIntBuffer	java.nio.IntBuffer
    //   243	101	48	i18	int
    //   259	91	49	localShortBuffer	java.nio.ShortBuffer
    //   90	116	51	i19	int
    //   106	106	52	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   971	974	1715	finally
    //   1648	1675	1715	finally
    //   1680	1715	1715	finally
    //   1717	1720	1715	finally
    //   1723	1736	1715	finally
    //   1741	1776	1715	finally
  }
  
  public void release()
    throws FrameRecorder.Exception
  {
    if (this.video_c != null)
    {
      avcodec.avcodec_close(this.video_c);
      this.video_c = null;
    }
    if (this.audio_c != null)
    {
      avcodec.avcodec_close(this.audio_c);
      this.audio_c = null;
    }
    if (this.picture_buf != null)
    {
      avutil.av_free(this.picture_buf);
      this.picture_buf = null;
    }
    if (this.picture != null)
    {
      avcodec.avcodec_free_frame(this.picture);
      this.picture = null;
    }
    if (this.tmp_picture != null)
    {
      avcodec.avcodec_free_frame(this.tmp_picture);
      this.tmp_picture = null;
    }
    if (this.video_outbuf != null)
    {
      avutil.av_free(this.video_outbuf);
      this.video_outbuf = null;
    }
    if (this.frame != null)
    {
      avcodec.avcodec_free_frame(this.frame);
      this.frame = null;
    }
    if (this.samples_out != null)
    {
      for (int k = 0; k < this.samples_out.length; k++) {
        avutil.av_free(this.samples_out[k].position(0));
      }
      this.samples_out = null;
    }
    if (this.audio_outbuf != null)
    {
      avutil.av_free(this.audio_outbuf);
      this.audio_outbuf = null;
    }
    this.video_st = null;
    this.audio_st = null;
    if (this.oc != null)
    {
      int i = this.oc.nb_streams();
      for (int j = 0; j < i; j++)
      {
        avutil.av_free(this.oc.streams(j).codec());
        avutil.av_free(this.oc.streams(j));
      }
      avutil.av_free(this.oc);
      this.oc = null;
    }
    if (this.img_convert_ctx != null)
    {
      swscale.sws_freeContext(this.img_convert_ctx);
      this.img_convert_ctx = null;
    }
    if (this.samples_convert_ctx != null)
    {
      swresample.swr_free(this.samples_convert_ctx);
      this.samples_convert_ctx = null;
    }
  }
  
  public void setFrameNumber(int paramInt)
  {
    if (this.picture == null)
    {
      super.setFrameNumber(paramInt);
      return;
    }
    this.picture.pts(paramInt);
  }
  
  public void setTimestamp(long paramLong)
  {
    setFrameNumber((int)Math.round(paramLong * getFrameRate() / 1000000.0D));
  }
  
  public void start()
    throws FrameRecorder.Exception
  {
    this.picture = null;
    this.tmp_picture = null;
    this.picture_buf = null;
    this.frame = null;
    this.video_outbuf = null;
    this.audio_outbuf = null;
    this.oc = null;
    this.video_c = null;
    this.audio_c = null;
    this.video_st = null;
    this.audio_st = null;
    this.got_video_packet = new int[1];
    this.got_audio_packet = new int[1];
    if ((this.format == null) || (this.format.length() == 0)) {}
    for (String str1 = null;; str1 = this.format)
    {
      avformat.AVOutputFormat localAVOutputFormat1 = avformat.av_guess_format(str1, this.filename, null);
      this.oformat = localAVOutputFormat1;
      if (localAVOutputFormat1 != null) {
        break;
      }
      int i2 = this.filename.indexOf("://");
      if (i2 > 0) {
        str1 = this.filename.substring(0, i2);
      }
      avformat.AVOutputFormat localAVOutputFormat2 = avformat.av_guess_format(str1, this.filename, null);
      this.oformat = localAVOutputFormat2;
      if (localAVOutputFormat2 != null) {
        break;
      }
      throw new FrameRecorder.Exception("av_guess_format() error: Could not guess output format for \"" + this.filename + "\" and " + this.format + " format.");
    }
    String str2 = this.oformat.name().getString();
    avformat.AVFormatContext localAVFormatContext = avformat.avformat_alloc_context();
    this.oc = localAVFormatContext;
    if (localAVFormatContext == null) {
      throw new FrameRecorder.Exception("avformat_alloc_context() error: Could not allocate format context");
    }
    this.oc.oformat(this.oformat);
    this.oc.filename(this.filename);
    if ((this.imageWidth > 0) && (this.imageHeight > 0))
    {
      if (this.videoCodec != 0) {
        this.oformat.video_codec(this.videoCodec);
      }
      for (;;)
      {
        avcodec.AVCodec localAVCodec2 = avcodec.avcodec_find_encoder(this.oformat.video_codec());
        this.video_codec = localAVCodec2;
        if (localAVCodec2 != null) {
          break;
        }
        release();
        throw new FrameRecorder.Exception("avcodec_find_encoder() error: Video codec not found.");
        if ("flv".equals(str2)) {
          this.oformat.video_codec(22);
        } else if ("mp4".equals(str2)) {
          this.oformat.video_codec(13);
        } else if ("3gp".equals(str2)) {
          this.oformat.video_codec(5);
        } else if ("avi".equals(str2)) {
          this.oformat.video_codec(26);
        }
      }
      avutil.AVRational localAVRational1 = avutil.av_d2q(this.frameRate, 1001000);
      avutil.AVRational localAVRational2 = this.video_codec.supported_framerates();
      if (localAVRational2 != null) {
        localAVRational1 = localAVRational2.position(avutil.av_find_nearest_q_idx(localAVRational1, localAVRational2));
      }
      avformat.AVStream localAVStream2 = avformat.avformat_new_stream(this.oc, this.video_codec);
      this.video_st = localAVStream2;
      if (localAVStream2 == null)
      {
        release();
        throw new FrameRecorder.Exception("avformat_new_stream() error: Could not allocate video stream.");
      }
      this.video_c = this.video_st.codec();
      this.video_c.codec_id(this.oformat.video_codec());
      this.video_c.codec_type(0);
      this.video_c.bit_rate(this.videoBitrate);
      this.video_c.width(16 * ((15 + this.imageWidth) / 16));
      this.video_c.height(this.imageHeight);
      this.video_c.time_base(avutil.av_inv_q(localAVRational1));
      this.video_c.gop_size(12);
      if (this.videoQuality >= 0.0D)
      {
        this.video_c.flags(0x2 | this.video_c.flags());
        this.video_c.global_quality((int)Math.round(118.0D * this.videoQuality));
      }
      if (this.pixelFormat == -1) {
        break label841;
      }
      this.video_c.pix_fmt(this.pixelFormat);
      if (this.video_c.codec_id() != 2) {
        break label915;
      }
      this.video_c.max_b_frames(2);
      label707:
      if ((0x40 & this.oformat.flags()) != 0) {
        this.video_c.flags(0x400000 | this.video_c.flags());
      }
      if ((0x200 & this.video_codec.capabilities()) != 0) {
        this.video_c.strict_std_compliance(-2);
      }
    }
    if ((this.audioChannels > 0) && (this.audioBitrate > 0) && (this.sampleRate > 0))
    {
      if (this.audioCodec != 0) {
        this.oformat.audio_codec(this.audioCodec);
      }
      for (;;)
      {
        avcodec.AVCodec localAVCodec1 = avcodec.avcodec_find_encoder(this.oformat.audio_codec());
        this.audio_codec = localAVCodec1;
        if (localAVCodec1 != null) {
          break label1221;
        }
        release();
        throw new FrameRecorder.Exception("avcodec_find_encoder() error: Audio codec not found.");
        label841:
        if ((this.video_c.codec_id() == 14) || (this.video_c.codec_id() == 63) || (this.video_c.codec_id() == 26) || (this.video_c.codec_id() == 34))
        {
          this.video_c.pix_fmt(avutil.AV_PIX_FMT_RGB32);
          break;
        }
        this.video_c.pix_fmt(0);
        break;
        label915:
        if (this.video_c.codec_id() == 1)
        {
          this.video_c.mb_decision(2);
          break label707;
        }
        if (this.video_c.codec_id() == 5)
        {
          if ((this.imageWidth <= 128) && (this.imageHeight <= 96))
          {
            this.video_c.width(128).height(96);
            break label707;
          }
          if ((this.imageWidth <= 176) && (this.imageHeight <= 144))
          {
            this.video_c.width(176).height(144);
            break label707;
          }
          if ((this.imageWidth <= 352) && (this.imageHeight <= 288))
          {
            this.video_c.width(352).height(288);
            break label707;
          }
          if ((this.imageWidth <= 704) && (this.imageHeight <= 576))
          {
            this.video_c.width(704).height(576);
            break label707;
          }
          this.video_c.width(1408).height(1152);
          break label707;
        }
        if (this.video_c.codec_id() != 28) {
          break label707;
        }
        this.video_c.profile(578);
        break label707;
        if (("flv".equals(str2)) || ("mp4".equals(str2)) || ("3gp".equals(str2))) {
          this.oformat.audio_codec(86018);
        } else if ("avi".equals(str2)) {
          this.oformat.audio_codec(65536);
        }
      }
      label1221:
      avformat.AVStream localAVStream1 = avformat.avformat_new_stream(this.oc, this.audio_codec);
      this.audio_st = localAVStream1;
      if (localAVStream1 == null)
      {
        release();
        throw new FrameRecorder.Exception("avformat_new_stream() error: Could not allocate audio stream.");
      }
      this.audio_c = this.audio_st.codec();
      this.audio_c.codec_id(this.oformat.audio_codec());
      this.audio_c.codec_type(1);
      this.audio_c.bit_rate(this.audioBitrate);
      this.audio_c.sample_rate(this.sampleRate);
      this.audio_c.channels(this.audioChannels);
      this.audio_c.channel_layout(avutil.av_get_default_channel_layout(this.audioChannels));
      if (this.sampleFormat != -1) {
        this.audio_c.sample_fmt(this.sampleFormat);
      }
      for (;;)
      {
        this.audio_c.time_base().num(1).den(this.sampleRate);
        switch (this.audio_c.sample_fmt())
        {
        default: 
          if ($assertionsDisabled) {
            break label1524;
          }
          throw new AssertionError();
          if ((this.audio_c.codec_id() == 86018) && ((0x200 & this.audio_codec.capabilities()) != 0)) {
            this.audio_c.sample_fmt(8);
          } else {
            this.audio_c.sample_fmt(1);
          }
          break;
        }
      }
      this.audio_c.bits_per_raw_sample(8);
    }
    label1524:
    avutil.AVDictionary localAVDictionary1;
    for (;;)
    {
      if (this.audioQuality >= 0.0D)
      {
        this.audio_c.flags(0x2 | this.audio_c.flags());
        this.audio_c.global_quality((int)Math.round(118.0D * this.audioQuality));
      }
      if ((0x40 & this.oformat.flags()) != 0) {
        this.audio_c.flags(0x400000 | this.audio_c.flags());
      }
      if ((0x200 & this.audio_codec.capabilities()) != 0) {
        this.audio_c.strict_std_compliance(-2);
      }
      avformat.av_dump_format(this.oc, 0, this.filename, 1);
      if (this.video_st == null) {
        break label2082;
      }
      localAVDictionary1 = new avutil.AVDictionary(null);
      if (this.videoQuality >= 0.0D) {
        avutil.av_dict_set(localAVDictionary1, "crf", "" + this.videoQuality, 0);
      }
      Iterator localIterator1 = this.videoOptions.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
        avutil.av_dict_set(localAVDictionary1, (String)localEntry2.getKey(), (String)localEntry2.getValue(), 0);
      }
      this.audio_c.bits_per_raw_sample(16);
      continue;
      this.audio_c.bits_per_raw_sample(32);
      continue;
      this.audio_c.bits_per_raw_sample(32);
      continue;
      this.audio_c.bits_per_raw_sample(64);
    }
    int i = avcodec.avcodec_open2(this.video_c, this.video_codec, localAVDictionary1);
    if (i < 0)
    {
      release();
      throw new FrameRecorder.Exception("avcodec_open2() error " + i + ": Could not open video codec.");
    }
    avutil.av_dict_free(localAVDictionary1);
    this.video_outbuf = null;
    if ((0x20 & this.oformat.flags()) == 0)
    {
      this.video_outbuf_size = Math.max(262144, 8 * this.video_c.width() * this.video_c.height());
      this.video_outbuf = new BytePointer(avutil.av_malloc(this.video_outbuf_size));
    }
    avcodec.AVFrame localAVFrame1 = avcodec.avcodec_alloc_frame();
    this.picture = localAVFrame1;
    if (localAVFrame1 == null)
    {
      release();
      throw new FrameRecorder.Exception("avcodec_alloc_frame() error: Could not allocate picture.");
    }
    this.picture.pts(0L);
    BytePointer localBytePointer = new BytePointer(avutil.av_malloc(avcodec.avpicture_get_size(this.video_c.pix_fmt(), this.video_c.width(), this.video_c.height())));
    this.picture_buf = localBytePointer;
    if (localBytePointer.isNull())
    {
      release();
      throw new FrameRecorder.Exception("av_malloc() error: Could not allocate picture buffer.");
    }
    avcodec.AVFrame localAVFrame2 = avcodec.avcodec_alloc_frame();
    this.tmp_picture = localAVFrame2;
    if (localAVFrame2 == null)
    {
      release();
      throw new FrameRecorder.Exception("avcodec_alloc_frame() error: Could not allocate temporary picture.");
    }
    label2082:
    if (this.audio_st != null)
    {
      avutil.AVDictionary localAVDictionary2 = new avutil.AVDictionary(null);
      if (this.audioQuality >= 0.0D) {
        avutil.av_dict_set(localAVDictionary2, "crf", "" + this.audioQuality, 0);
      }
      Iterator localIterator2 = this.audioOptions.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
        avutil.av_dict_set(localAVDictionary2, (String)localEntry1.getKey(), (String)localEntry1.getValue(), 0);
      }
      int j = avcodec.avcodec_open2(this.audio_c, this.audio_codec, localAVDictionary2);
      if (j < 0)
      {
        release();
        throw new FrameRecorder.Exception("avcodec_open2() error " + j + ": Could not open audio codec.");
      }
      avutil.av_dict_free(localAVDictionary2);
      this.audio_outbuf_size = 262144;
      this.audio_outbuf = new BytePointer(avutil.av_malloc(this.audio_outbuf_size));
      if (this.audio_c.frame_size() <= 1)
      {
        this.audio_outbuf_size = 16384;
        this.audio_input_frame_size = (this.audio_outbuf_size / this.audio_c.channels());
        switch (this.audio_c.codec_id())
        {
        default: 
          if (avutil.av_sample_fmt_is_planar(this.audio_c.sample_fmt()) == 0) {
            break;
          }
        }
      }
      for (int k = this.audio_c.channels();; k = 1)
      {
        int m = avutil.av_samples_get_buffer_size(null, this.audio_c.channels(), this.audio_input_frame_size, this.audio_c.sample_fmt(), 1) / k;
        this.samples_out = new BytePointer[k];
        for (int n = 0; n < this.samples_out.length; n++) {
          this.samples_out[n] = new BytePointer(avutil.av_malloc(m)).capacity(m);
        }
        this.audio_input_frame_size >>= 1;
        break;
        this.audio_input_frame_size = this.audio_c.frame_size();
        break;
      }
      this.samples_in = new Pointer[8];
      this.samples_in_ptr = new PointerPointer(8);
      this.samples_out_ptr = new PointerPointer(8);
      avcodec.AVFrame localAVFrame3 = avcodec.avcodec_alloc_frame();
      this.frame = localAVFrame3;
      if (localAVFrame3 == null)
      {
        release();
        throw new FrameRecorder.Exception("avcodec_alloc_frame() error: Could not allocate audio frame.");
      }
    }
    if ((0x1 & this.oformat.flags()) == 0)
    {
      avformat.AVIOContext localAVIOContext = new avformat.AVIOContext(null);
      int i1 = avformat.avio_open(localAVIOContext, this.filename, 2);
      if (i1 < 0)
      {
        release();
        throw new FrameRecorder.Exception("avio_open error() error " + i1 + ": Could not open '" + this.filename + "'");
      }
      this.oc.pb(localAVIOContext);
    }
    avformat.avformat_write_header(this.oc, null);
  }
  
  public void stop()
    throws FrameRecorder.Exception
  {
    if (this.oc != null)
    {
      avformat.av_write_trailer(this.oc);
      if ((0x1 & this.oformat.flags()) == 0) {
        avformat.avio_close(this.oc.pb());
      }
    }
    release();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\FFmpegFrameRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */