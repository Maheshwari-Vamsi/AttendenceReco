package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacv.cpp.avcodec;
import com.googlecode.javacv.cpp.avcodec.AVCodec;
import com.googlecode.javacv.cpp.avcodec.AVCodecContext;
import com.googlecode.javacv.cpp.avcodec.AVFrame;
import com.googlecode.javacv.cpp.avcodec.AVPacket;
import com.googlecode.javacv.cpp.avdevice;
import com.googlecode.javacv.cpp.avformat;
import com.googlecode.javacv.cpp.avformat.AVFormatContext;
import com.googlecode.javacv.cpp.avformat.AVInputFormat;
import com.googlecode.javacv.cpp.avformat.AVStream;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.avutil.AVDictionary;
import com.googlecode.javacv.cpp.avutil.AVRational;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.swscale;
import com.googlecode.javacv.cpp.swscale.SwsContext;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class FFmpegFrameGrabber
  extends FrameGrabber
{
  private static FrameGrabber.Exception loadingException;
  private avcodec.AVCodecContext audio_c;
  private avformat.AVStream audio_st;
  private BytePointer buffer_rgb;
  private String filename;
  private Frame frame;
  private boolean frameGrabbed;
  private int[] got_frame;
  private swscale.SwsContext img_convert_ctx;
  private avformat.AVFormatContext oc;
  private avcodec.AVFrame picture;
  private avcodec.AVFrame picture_rgb;
  private avcodec.AVPacket pkt;
  private avcodec.AVPacket pkt2;
  private opencv_core.IplImage return_image;
  private Buffer[] samples_buf;
  private avcodec.AVFrame samples_frame;
  private BytePointer[] samples_ptr;
  private int sizeof_pkt;
  private avcodec.AVCodecContext video_c;
  private avformat.AVStream video_st;
  
  static
  {
    if (!FFmpegFrameGrabber.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      loadingException = null;
      return;
    }
  }
  
  public FFmpegFrameGrabber(File paramFile)
  {
    this(paramFile.getAbsolutePath());
  }
  
  public FFmpegFrameGrabber(String paramString)
  {
    avcodec.avcodec_register_all();
    avdevice.avdevice_register_all();
    avformat.av_register_all();
    avformat.avformat_network_init();
    this.filename = paramString;
  }
  
  public static FFmpegFrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static FFmpegFrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return new FFmpegFrameGrabber(paramFile);
  }
  
  public static FFmpegFrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return new FFmpegFrameGrabber(paramString);
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    throw new UnsupportedOperationException("Device enumeration not support by FFmpeg.");
  }
  
  private opencv_core.IplImage grab(boolean paramBoolean)
    throws FrameGrabber.Exception
  {
    Frame localFrame = grabFrame(paramBoolean, false);
    if (localFrame != null) {
      return localFrame.image;
    }
    return null;
  }
  
  private Frame grabFrame(boolean paramBoolean1, boolean paramBoolean2)
    throws FrameGrabber.Exception
  {
    if (this.frameGrabbed)
    {
      this.frameGrabbed = false;
      if (paramBoolean1) {
        processImage();
      }
      this.frame.image = this.return_image;
      this.frame.samples = null;
      return this.frame;
    }
    if ((this.oc == null) || (this.oc.isNull())) {
      throw new FrameGrabber.Exception("Could not grab: No AVFormatContext. (Has start() been called?)");
    }
    label366:
    label368:
    do
    {
      i = 0;
      int j;
      for (;;)
      {
        if (i != 0) {
          break label780;
        }
        if ((this.pkt2.size() <= 0) && (avformat.av_read_frame(this.oc, this.pkt) < 0)) {
          return null;
        }
        if ((this.video_st != null) && (this.pkt.stream_index() == this.video_st.index())) {
          if ((avcodec.avcodec_decode_video2(this.video_c, this.picture, this.got_frame, this.pkt) >= 0) && (this.got_frame[0] != 0))
          {
            long l = avcodec.av_frame_get_best_effort_timestamp(this.picture);
            avutil.AVRational localAVRational = this.video_st.time_base();
            this.timestamp = (1000000L * l * localAVRational.num() / localAVRational.den());
            this.frameNumber = ((int)(1000000.0D * getFrameRate() / this.timestamp));
            if (paramBoolean1) {
              processImage();
            }
            i = 1;
            this.frame.image = this.return_image;
            this.frame.samples = null;
          }
        }
        for (;;)
        {
          if (this.pkt2.size() > 0) {
            break label366;
          }
          avcodec.av_free_packet(this.pkt);
          break;
          if ((paramBoolean2) && (this.audio_st != null) && (this.pkt.stream_index() == this.audio_st.index()))
          {
            if (this.pkt2.size() <= 0) {
              BytePointer.memcpy(this.pkt2, this.pkt, this.sizeof_pkt);
            }
            avcodec.avcodec_get_frame_defaults(this.samples_frame);
            j = avcodec.avcodec_decode_audio4(this.audio_c, this.samples_frame, this.got_frame, this.pkt2);
            if (j > 0) {
              break label368;
            }
            this.pkt2.size(0);
          }
        }
      }
      this.pkt2.data(this.pkt2.data().position(j));
      this.pkt2.size(this.pkt2.size() - j);
    } while (this.got_frame[0] == 0);
    int i = 1;
    this.frame.image = null;
    int k = this.samples_frame.format();
    if (avutil.av_sample_fmt_is_planar(k) != 0) {}
    int i1;
    int i2;
    ByteBuffer localByteBuffer;
    for (int m = this.samples_frame.channels();; m = 1)
    {
      int n = avutil.av_samples_get_buffer_size(null, this.audio_c.channels(), this.samples_frame.nb_samples(), this.audio_c.sample_fmt(), 1) / m;
      if ((this.samples_buf == null) || (this.samples_buf.length != m))
      {
        this.samples_ptr = new BytePointer[m];
        this.samples_buf = new Buffer[m];
      }
      this.frame.samples = this.samples_buf;
      i1 = n / avutil.av_get_bytes_per_sample(k);
      i2 = 0;
      if (i2 >= m) {
        break;
      }
      BytePointer localBytePointer = this.samples_frame.data(i2);
      if ((localBytePointer.equals(this.samples_ptr[i2])) && (this.samples_ptr[i2].capacity() >= n)) {
        break label697;
      }
      this.samples_ptr[i2] = localBytePointer.capacity(n);
      localByteBuffer = localBytePointer.asBuffer();
      switch (k)
      {
      default: 
        if ($assertionsDisabled) {
          break label697;
        }
        throw new AssertionError();
      }
    }
    this.samples_buf[i2] = localByteBuffer;
    for (;;)
    {
      label697:
      this.samples_buf[i2].position(0).limit(i1);
      i2++;
      break;
      this.samples_buf[i2] = localByteBuffer.asShortBuffer();
      continue;
      this.samples_buf[i2] = localByteBuffer.asIntBuffer();
      continue;
      this.samples_buf[i2] = localByteBuffer.asFloatBuffer();
      continue;
      this.samples_buf[i2] = localByteBuffer.asDoubleBuffer();
    }
    label780:
    return this.frame;
  }
  
  private void processImage()
    throws FrameGrabber.Exception
  {
    switch (this.imageMode)
    {
    default: 
      if (!$assertionsDisabled) {
        throw new AssertionError();
      }
      break;
    case ???: 
    case ???: 
      if (this.deinterlace) {
        avcodec.avpicture_deinterlace(this.picture, this.picture, this.video_c.pix_fmt(), this.video_c.width(), this.video_c.height());
      }
      this.img_convert_ctx = swscale.sws_getCachedContext(this.img_convert_ctx, this.video_c.width(), this.video_c.height(), this.video_c.pix_fmt(), getImageWidth(), getImageHeight(), getPixelFormat(), 2, null, null, null);
      if (this.img_convert_ctx == null) {
        throw new FrameGrabber.Exception("sws_getCachedContext() error: Cannot initialize the conversion context.");
      }
      swscale.sws_scale(this.img_convert_ctx, new PointerPointer(this.picture), this.picture.linesize(), 0, this.video_c.height(), new PointerPointer(this.picture_rgb), this.picture_rgb.linesize());
      this.return_image.imageData(this.buffer_rgb);
      this.return_image.widthStep(this.picture_rgb.linesize(0));
    }
    for (;;)
    {
      this.return_image.imageSize(this.return_image.height() * this.return_image.widthStep());
      this.return_image.nChannels(this.return_image.widthStep() / this.return_image.width());
      return;
      assert ((this.video_c.width() == this.return_image.width()) && (this.video_c.height() == this.return_image.height()));
      this.return_image.imageData(this.picture.data(0));
      this.return_image.widthStep(this.picture.linesize(0));
    }
  }
  
  public static void tryLoad()
    throws FrameGrabber.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      Loader.load(avutil.class);
      Loader.load(avcodec.class);
      Loader.load(avformat.class);
      Loader.load(avdevice.class);
      Loader.load(swscale.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof FrameGrabber.Exception))
      {
        FrameGrabber.Exception localException2 = (FrameGrabber.Exception)localThrowable;
        loadingException = localException2;
        throw localException2;
      }
      FrameGrabber.Exception localException1 = new FrameGrabber.Exception("Failed to load " + FFmpegFrameGrabber.class, localThrowable);
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
  
  public int getAudioChannels()
  {
    if (this.audio_c == null) {
      return super.getAudioChannels();
    }
    return this.audio_c.channels();
  }
  
  public String getFormat()
  {
    if (this.oc == null) {
      return super.getFormat();
    }
    return this.oc.iformat().name().getString();
  }
  
  public double getFrameRate()
  {
    if (this.video_st == null) {
      return super.getFrameRate();
    }
    avutil.AVRational localAVRational = this.video_st.r_frame_rate();
    return localAVRational.num() / localAVRational.den();
  }
  
  public double getGamma()
  {
    if (this.gamma == 0.0D) {
      return 2.2D;
    }
    return this.gamma;
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
  
  public int getLengthInFrames()
  {
    return (int)(getLengthInTime() * getFrameRate() / 1000000.0D);
  }
  
  public long getLengthInTime()
  {
    return 1000000L * this.oc.duration() / 1000000L;
  }
  
  public int getPixelFormat()
  {
    if ((this.imageMode == FrameGrabber.ImageMode.COLOR) || (this.imageMode == FrameGrabber.ImageMode.GRAY))
    {
      if (this.pixelFormat == -1)
      {
        if (this.imageMode == FrameGrabber.ImageMode.COLOR) {
          return 3;
        }
        return 8;
      }
      return this.pixelFormat;
    }
    if (this.video_c != null) {
      return this.video_c.pix_fmt();
    }
    return super.getPixelFormat();
  }
  
  public int getSampleFormat()
  {
    if (this.audio_c == null) {
      return super.getSampleFormat();
    }
    return this.audio_c.sample_fmt();
  }
  
  public int getSampleRate()
  {
    if (this.audio_c == null) {
      return super.getSampleRate();
    }
    return this.audio_c.sample_rate();
  }
  
  public opencv_core.IplImage grab()
    throws FrameGrabber.Exception
  {
    Frame localFrame = grabFrame(true, false);
    if (localFrame != null) {
      return localFrame.image;
    }
    return null;
  }
  
  public Frame grabFrame()
    throws FrameGrabber.Exception
  {
    return grabFrame(true, true);
  }
  
  public void release()
    throws FrameGrabber.Exception
  {
    if ((this.pkt != null) && (this.pkt2 != null))
    {
      if (this.pkt2.size() > 0) {
        avcodec.av_free_packet(this.pkt);
      }
      this.pkt2 = null;
      this.pkt = null;
    }
    if (this.buffer_rgb != null)
    {
      avutil.av_free(this.buffer_rgb);
      this.buffer_rgb = null;
    }
    if (this.picture_rgb != null)
    {
      avcodec.avcodec_free_frame(this.picture_rgb);
      this.picture_rgb = null;
    }
    if (this.picture != null)
    {
      avcodec.avcodec_free_frame(this.picture);
      this.picture = null;
    }
    if (this.video_c != null)
    {
      avcodec.avcodec_close(this.video_c);
      this.video_c = null;
    }
    if (this.samples_frame != null)
    {
      avcodec.avcodec_free_frame(this.samples_frame);
      this.samples_frame = null;
    }
    if (this.audio_c != null)
    {
      avcodec.avcodec_close(this.audio_c);
      this.audio_c = null;
    }
    if ((this.oc != null) && (!this.oc.isNull()))
    {
      avformat.avformat_close_input(this.oc);
      this.oc = null;
    }
    if (this.img_convert_ctx != null)
    {
      swscale.sws_freeContext(this.img_convert_ctx);
      this.img_convert_ctx = null;
    }
    this.got_frame = null;
    this.return_image = null;
    this.frameGrabbed = false;
    this.frame = null;
    this.timestamp = 0L;
    this.frameNumber = 0;
  }
  
  public void setFrameNumber(int paramInt)
    throws FrameGrabber.Exception
  {
    setTimestamp(Math.round(1000000L * paramInt / getFrameRate()));
  }
  
  public void setTimestamp(long paramLong)
    throws FrameGrabber.Exception
  {
    if ((this.oc == null) || (this.video_c == null))
    {
      super.setTimestamp(paramLong);
      return;
    }
    long l = paramLong * 1000000L / 1000000L;
    if (this.oc.start_time() != Long.MIN_VALUE) {
      l += this.oc.start_time();
    }
    int i = avformat.avformat_seek_file(this.oc, -1, Long.MIN_VALUE, l, Long.MAX_VALUE, 1);
    if (i < 0) {
      throw new FrameGrabber.Exception("avformat_seek_file() error " + i + ": Could not seek file to timestamp " + l + ".");
    }
    avcodec.avcodec_flush_buffers(this.video_c);
    if (this.audio_c != null) {
      avcodec.avcodec_flush_buffers(this.audio_c);
    }
    while ((this.timestamp > l) && (grab(false) != null)) {}
    while ((this.timestamp < l) && (grab(false) != null)) {}
    this.frameGrabbed = true;
  }
  
  public void start()
    throws FrameGrabber.Exception
  {
    this.img_convert_ctx = null;
    this.oc = new avformat.AVFormatContext(null);
    this.video_c = null;
    this.audio_c = null;
    this.pkt = new avcodec.AVPacket();
    this.pkt2 = new avcodec.AVPacket();
    this.sizeof_pkt = this.pkt.sizeof();
    this.got_frame = new int[1];
    this.return_image = null;
    this.frameGrabbed = false;
    this.frame = new Frame();
    this.timestamp = 0L;
    this.frameNumber = 0;
    this.pkt2.size(0);
    String str1 = this.format;
    avformat.AVInputFormat localAVInputFormat = null;
    if (str1 != null)
    {
      int i5 = this.format.length();
      localAVInputFormat = null;
      if (i5 > 0)
      {
        localAVInputFormat = avformat.av_find_input_format(this.format);
        if (localAVInputFormat == null) {
          throw new FrameGrabber.Exception("av_find_input_format() error: Could not find input format \"" + this.format + "\".");
        }
      }
    }
    avutil.AVDictionary localAVDictionary = new avutil.AVDictionary(null);
    if (this.frameRate > 0.0D)
    {
      avutil.AVRational localAVRational = avutil.av_d2q(this.frameRate, 1001000);
      avutil.av_dict_set(localAVDictionary, "framerate", localAVRational.num() + "/" + localAVRational.den(), 0);
    }
    if (this.imageMode != FrameGrabber.ImageMode.RAW) {
      if (this.imageMode != FrameGrabber.ImageMode.COLOR) {
        break label496;
      }
    }
    label496:
    for (String str2 = "bgr24";; str2 = "gray8")
    {
      avutil.av_dict_set(localAVDictionary, "pixel_format", str2, 0);
      if ((this.imageWidth > 0) && (this.imageHeight > 0)) {
        avutil.av_dict_set(localAVDictionary, "video_size", this.imageWidth + "x" + this.imageHeight, 0);
      }
      if (this.sampleRate > 0) {
        avutil.av_dict_set(localAVDictionary, "sample_rate", "" + this.sampleRate, 0);
      }
      if (this.audioChannels > 0) {
        avutil.av_dict_set(localAVDictionary, "channels", "" + this.audioChannels, 0);
      }
      int i = avformat.avformat_open_input(this.oc, this.filename, localAVInputFormat, localAVDictionary);
      if (i >= 0) {
        break;
      }
      throw new FrameGrabber.Exception("avformat_open_input() error " + i + ": Could not open input \"" + this.filename + "\". (Has setFormat() been called?)");
    }
    avutil.av_dict_free(localAVDictionary);
    int j = avformat.avformat_find_stream_info(this.oc, null);
    if (j < 0) {
      throw new FrameGrabber.Exception("avformat_find_stream_info() error " + j + ": Could not find stream information.");
    }
    avformat.av_dump_format(this.oc, 0, this.filename, 0);
    this.audio_st = null;
    this.video_st = null;
    int k = this.oc.nb_streams();
    int m = 0;
    if (m < k)
    {
      avformat.AVStream localAVStream = this.oc.streams(m);
      avcodec.AVCodecContext localAVCodecContext = localAVStream.codec();
      if ((this.video_st == null) && (localAVCodecContext.codec_type() == 0))
      {
        this.video_st = localAVStream;
        this.video_c = localAVCodecContext;
      }
      for (;;)
      {
        m++;
        break;
        if ((this.audio_st == null) && (localAVCodecContext.codec_type() == 1))
        {
          this.audio_st = localAVStream;
          this.audio_c = localAVCodecContext;
        }
      }
    }
    if ((this.video_st == null) && (this.audio_st == null)) {
      throw new FrameGrabber.Exception("Did not find a video or audio stream inside \"" + this.filename + "\".");
    }
    if (this.video_st != null)
    {
      avcodec.AVCodec localAVCodec2 = avcodec.avcodec_find_decoder(this.video_c.codec_id());
      if (localAVCodec2 == null) {
        throw new FrameGrabber.Exception("avcodec_find_decoder() error: Unsupported video format or codec not found: " + this.video_c.codec_id() + ".");
      }
      int i1 = avcodec.avcodec_open2(this.video_c, localAVCodec2, null);
      if (i1 < 0) {
        throw new FrameGrabber.Exception("avcodec_open2() error " + i1 + ": Could not open video codec.");
      }
      if ((this.video_c.time_base().num() > 1000) && (this.video_c.time_base().den() == 1)) {
        this.video_c.time_base().den(1000);
      }
      avcodec.AVFrame localAVFrame2 = avcodec.avcodec_alloc_frame();
      this.picture = localAVFrame2;
      if (localAVFrame2 == null) {
        throw new FrameGrabber.Exception("avcodec_alloc_frame() error: Could not allocate raw picture frame.");
      }
      avcodec.AVFrame localAVFrame3 = avcodec.avcodec_alloc_frame();
      this.picture_rgb = localAVFrame3;
      if (localAVFrame3 == null) {
        throw new FrameGrabber.Exception("avcodec_alloc_frame() error: Could not allocate RGB picture frame.");
      }
      int i2;
      if (getImageWidth() > 0)
      {
        i2 = getImageWidth();
        label961:
        if (getImageHeight() <= 0) {
          break label1038;
        }
      }
      label1038:
      for (int i3 = getImageHeight();; i3 = this.video_c.height()) {
        switch (this.imageMode)
        {
        default: 
          if ($assertionsDisabled) {
            break label1112;
          }
          throw new AssertionError();
          i2 = this.video_c.width();
          break label961;
        }
      }
      int i4 = getPixelFormat();
      this.buffer_rgb = new BytePointer(avutil.av_malloc(avcodec.avpicture_get_size(i4, i2, i3)));
      avcodec.avpicture_fill(this.picture_rgb, this.buffer_rgb, i4, i2, i3);
      this.return_image = opencv_core.IplImage.createHeader(i2, i3, 8, 1);
    }
    label1112:
    while (this.audio_st != null)
    {
      avcodec.AVCodec localAVCodec1 = avcodec.avcodec_find_decoder(this.audio_c.codec_id());
      if (localAVCodec1 == null)
      {
        throw new FrameGrabber.Exception("avcodec_find_decoder() error: Unsupported audio format or codec not found: " + this.audio_c.codec_id() + ".");
        this.buffer_rgb = null;
        this.return_image = opencv_core.IplImage.createHeader(this.video_c.width(), this.video_c.height(), 8, 1);
      }
      else
      {
        int n = avcodec.avcodec_open2(this.audio_c, localAVCodec1, null);
        if (n < 0) {
          throw new FrameGrabber.Exception("avcodec_open2() error " + n + ": Could not open audio codec.");
        }
        avcodec.AVFrame localAVFrame1 = avcodec.avcodec_alloc_frame();
        this.samples_frame = localAVFrame1;
        if (localAVFrame1 == null) {
          throw new FrameGrabber.Exception("avcodec_alloc_frame() error: Could not allocate audio frame.");
        }
      }
    }
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {
    release();
  }
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    if ((this.oc == null) || (this.oc.isNull())) {
      throw new FrameGrabber.Exception("Could not trigger: No AVFormatContext. (Has start() been called?)");
    }
    if (this.pkt2.size() > 0)
    {
      this.pkt2.size(0);
      avcodec.av_free_packet(this.pkt);
    }
    for (int i = 0;; i++)
    {
      if ((i >= 1 + this.numBuffers) || (avformat.av_read_frame(this.oc, this.pkt) < 0)) {
        return;
      }
      avcodec.av_free_packet(this.pkt);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\FFmpegFrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */