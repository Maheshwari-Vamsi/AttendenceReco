package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavfilter/avfilter.h>", "<libavfilter/buffersink.h>", "<libavfilter/buffersrc.h>", "<libavfilter/avcodec.h>", "<libavfilter/avfiltergraph.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"avfilter@.3", "swscale@.2", "swresample@.0", "postproc@.52", "avformat@.54", "avcodec@.54", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"avfilter-3"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class avfilter
{
  public static final int AVFILTER_AUTO_CONVERT_ALL = 0;
  public static final int AVFILTER_AUTO_CONVERT_NONE = -1;
  public static final int AVFILTER_CMD_FLAG_FAST = 2;
  public static final int AVFILTER_CMD_FLAG_ONE = 1;
  public static final int AV_BUFFERSINK_FLAG_NO_REQUEST = 2;
  public static final int AV_BUFFERSINK_FLAG_PEEK = 1;
  public static final int AV_BUFFERSRC_FLAG_NO_CHECK_FORMAT = 1;
  public static final int AV_BUFFERSRC_FLAG_NO_COPY = 2;
  public static final int AV_BUFFERSRC_FLAG_PUSH = 4;
  public static final int AV_PERM_ALIGN = 64;
  public static final int AV_PERM_NEG_LINESIZES = 32;
  public static final int AV_PERM_PRESERVE = 4;
  public static final int AV_PERM_READ = 1;
  public static final int AV_PERM_REUSE = 8;
  public static final int AV_PERM_REUSE2 = 16;
  public static final int AV_PERM_WRITE = 2;
  public static final int LIBAVFILTER_BUILD = LIBAVFILTER_VERSION_INT;
  public static final String LIBAVFILTER_IDENT = "Lavu" + LIBAVFILTER_VERSION;
  public static final String LIBAVFILTER_VERSION;
  public static final int LIBAVFILTER_VERSION_INT = 0;
  public static final int LIBAVFILTER_VERSION_MAJOR = 3;
  public static final int LIBAVFILTER_VERSION_MICRO = 103;
  public static final int LIBAVFILTER_VERSION_MINOR = 42;
  
  static
  {
    Loader.load(avformat.class);
    Loader.load(postproc.class);
    Loader.load(swresample.class);
    Loader.load(swscale.class);
    Loader.load();
    LIBAVFILTER_VERSION_INT = avutil.AV_VERSION_INT(3, 42, 103);
    LIBAVFILTER_VERSION = avutil.AV_VERSION(3, 42, 103);
  }
  
  public static native AVABufferSinkParams av_abuffersink_params_alloc();
  
  public static native int av_buffersink_get_buffer_ref(AVFilterContext paramAVFilterContext, @ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
  
  @ByVal
  public static native avutil.AVRational av_buffersink_get_frame_rate(AVFilterContext paramAVFilterContext);
  
  public static native AVBufferSinkParams av_buffersink_params_alloc();
  
  public static native int av_buffersink_poll_frame(AVFilterContext paramAVFilterContext);
  
  public static native int av_buffersink_read(AVFilterContext paramAVFilterContext, @ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef);
  
  public static native int av_buffersink_read_samples(AVFilterContext paramAVFilterContext, @ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
  
  public static native void av_buffersink_set_frame_size(AVFilterContext paramAVFilterContext, @Cast({"unsigned"}) int paramInt);
  
  public static native int av_buffersrc_add_frame(AVFilterContext paramAVFilterContext, avcodec.AVFrame paramAVFrame, int paramInt);
  
  public static native int av_buffersrc_add_ref(AVFilterContext paramAVFilterContext, AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
  
  @Deprecated
  public static native int av_buffersrc_buffer(AVFilterContext paramAVFilterContext, AVFilterBufferRef paramAVFilterBufferRef);
  
  @Cast({"unsigned"})
  public static native int av_buffersrc_get_nb_failed_requests(AVFilterContext paramAVFilterContext);
  
  public static native int av_buffersrc_write_frame(AVFilterContext paramAVFilterContext, avcodec.AVFrame paramAVFrame);
  
  @ByPtrPtr
  public static native AVFilter av_filter_next(@ByPtrPtr AVFilter paramAVFilter);
  
  public static native int avfilter_config_links(AVFilterContext paramAVFilterContext);
  
  public static native String avfilter_configuration();
  
  public static native int avfilter_copy_buf_props(avcodec.AVFrame paramAVFrame, AVFilterBufferRef paramAVFilterBufferRef);
  
  public static native void avfilter_copy_buffer_ref_props(AVFilterBufferRef paramAVFilterBufferRef1, AVFilterBufferRef paramAVFilterBufferRef2);
  
  public static native int avfilter_copy_frame_props(AVFilterBufferRef paramAVFilterBufferRef, avcodec.AVFrame paramAVFrame);
  
  @Deprecated
  public static native int avfilter_fill_frame_from_audio_buffer_ref(avcodec.AVFrame paramAVFrame, AVFilterBufferRef paramAVFilterBufferRef);
  
  @Deprecated
  public static native int avfilter_fill_frame_from_buffer_ref(avcodec.AVFrame paramAVFrame, AVFilterBufferRef paramAVFilterBufferRef);
  
  @Deprecated
  public static native int avfilter_fill_frame_from_video_buffer_ref(avcodec.AVFrame paramAVFrame, AVFilterBufferRef paramAVFilterBufferRef);
  
  public static native void avfilter_free(AVFilterContext paramAVFilterContext);
  
  public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, @Cast({"uint64_t"}) long paramLong);
  
  public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"enum AVSampleFormat"}) int paramInt4, int paramInt5, @Cast({"uint64_t"}) long paramLong);
  
  public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_frame(avcodec.AVFrame paramAVFrame, int paramInt);
  
  public static native AVFilterBufferRef avfilter_get_buffer_ref_from_frame(@Cast({"AVMediaType"}) int paramInt1, avcodec.AVFrame paramAVFrame, int paramInt2);
  
  public static native AVFilter avfilter_get_by_name(String paramString);
  
  @Const
  public static native avutil.AVClass avfilter_get_class();
  
  public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVPixelFormat"}) int paramInt4);
  
  public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_frame(avcodec.AVFrame paramAVFrame, int paramInt);
  
  public static native int avfilter_graph_add_filter(AVFilterGraph paramAVFilterGraph, AVFilterContext paramAVFilterContext);
  
  public static native AVFilterGraph avfilter_graph_alloc();
  
  public static native int avfilter_graph_config(AVFilterGraph paramAVFilterGraph, Pointer paramPointer);
  
  public static native int avfilter_graph_create_filter(@ByPtrPtr AVFilterContext paramAVFilterContext, AVFilter paramAVFilter, String paramString1, String paramString2, Pointer paramPointer, AVFilterGraph paramAVFilterGraph);
  
  @Cast({"char*"})
  public static native BytePointer avfilter_graph_dump(AVFilterGraph paramAVFilterGraph, String paramString);
  
  public static native void avfilter_graph_free(@ByPtrPtr AVFilterGraph paramAVFilterGraph);
  
  public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph paramAVFilterGraph, @Cast({"char*"}) String paramString);
  
  public static native int avfilter_graph_parse(AVFilterGraph paramAVFilterGraph, String paramString, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2, Pointer paramPointer);
  
  public static native int avfilter_graph_parse2(AVFilterGraph paramAVFilterGraph, String paramString, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2);
  
  public static native int avfilter_graph_queue_command(AVFilterGraph paramAVFilterGraph, String paramString1, String paramString2, String paramString3, int paramInt, double paramDouble);
  
  public static native int avfilter_graph_request_oldest(AVFilterGraph paramAVFilterGraph);
  
  public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, String paramString1, String paramString2, String paramString3, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void avfilter_graph_set_auto_convert(AVFilterGraph paramAVFilterGraph, @Cast({"unsigned"}) int paramInt);
  
  public static native int avfilter_init_filter(AVFilterContext paramAVFilterContext, String paramString, Pointer paramPointer);
  
  public static native AVFilterInOut avfilter_inout_alloc();
  
  public static native void avfilter_inout_free(@ByPtrPtr AVFilterInOut paramAVFilterInOut);
  
  public static native int avfilter_insert_filter(AVFilterLink paramAVFilterLink, AVFilterContext paramAVFilterContext, @Cast({"unsigned"}) int paramInt1, @Cast({"unsigned"}) int paramInt2);
  
  public static native String avfilter_license();
  
  public static native int avfilter_link(AVFilterContext paramAVFilterContext1, @Cast({"unsigned"}) int paramInt1, AVFilterContext paramAVFilterContext2, @Cast({"unsigned"}) int paramInt2);
  
  public static native void avfilter_link_free(@ByPtrPtr AVFilterLink paramAVFilterLink);
  
  public static native int avfilter_link_get_channels(AVFilterLink paramAVFilterLink);
  
  public static native void avfilter_link_set_closed(AVFilterLink paramAVFilterLink, int paramInt);
  
  public static native int avfilter_open(@ByPtrPtr AVFilterContext paramAVFilterContext, AVFilter paramAVFilter, String paramString);
  
  public static native String avfilter_pad_get_name(AVFilterPad paramAVFilterPad, int paramInt);
  
  @Cast({"AVMediaType"})
  public static native int avfilter_pad_get_type(AVFilterPad paramAVFilterPad, int paramInt);
  
  public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, String paramString1, String paramString2, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native AVFilterBufferRef avfilter_ref_buffer(AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
  
  public static native int avfilter_ref_get_channels(AVFilterBufferRef paramAVFilterBufferRef);
  
  public static native int avfilter_register(AVFilter paramAVFilter);
  
  public static native void avfilter_register_all();
  
  public static native void avfilter_uninit();
  
  public static native void avfilter_unref_buffer(AVFilterBufferRef paramAVFilterBufferRef);
  
  public static native void avfilter_unref_bufferp(@ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef);
  
  @Cast({"unsigned"})
  public static native int avfilter_version();
  
  public static class AVABufferSinkParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVABufferSinkParams()
    {
      allocate();
    }
    
    public AVABufferSinkParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVABufferSinkParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int all_channel_counts();
    
    public native AVABufferSinkParams all_channel_counts(int paramInt);
    
    @Const
    public native IntPointer channel_counts();
    
    public native AVABufferSinkParams channel_counts(IntPointer paramIntPointer);
    
    @Const
    public native LongPointer channel_layouts();
    
    public native AVABufferSinkParams channel_layouts(LongPointer paramLongPointer);
    
    public AVABufferSinkParams position(int paramInt)
    {
      return (AVABufferSinkParams)super.position(paramInt);
    }
    
    @Cast({"const AVSampleFormat*"})
    public native IntPointer sample_fmts();
    
    public native AVABufferSinkParams sample_fmts(IntPointer paramIntPointer);
    
    public native IntPointer sample_rates();
    
    public native AVABufferSinkParams sample_rates(IntPointer paramIntPointer);
  }
  
  public static class AVBufferSinkParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVBufferSinkParams()
    {
      allocate();
    }
    
    public AVBufferSinkParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVBufferSinkParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"const AVPixelFormat*"})
    public native IntPointer pixel_fmts();
    
    public native AVBufferSinkParams pixel_fmts(IntPointer paramIntPointer);
    
    public AVBufferSinkParams position(int paramInt)
    {
      return (AVBufferSinkParams)super.position(paramInt);
    }
  }
  
  public static class AVFilter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilter()
    {
      allocate();
    }
    
    public AVFilter(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer description();
    
    public native AVFilter description(BytePointer paramBytePointer);
    
    public native AVFilter inputs(AVFilterPad paramAVFilterPad);
    
    @Const
    public native avfilter.AVFilterPad inputs();
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVFilter name(BytePointer paramBytePointer);
    
    public native AVFilter outputs(AVFilterPad paramAVFilterPad);
    
    @Const
    public native avfilter.AVFilterPad outputs();
    
    public AVFilter position(int paramInt)
    {
      return (AVFilter)super.position(paramInt);
    }
  }
  
  public static class AVFilterBuffer
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterBuffer()
    {
      allocate();
    }
    
    public AVFilterBuffer(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterBuffer(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"uint8_t*"})
    public native BytePointer data(int paramInt);
    
    public native AVFilterBuffer data(int paramInt, BytePointer paramBytePointer);
    
    @Cast({"uint8_t**"})
    public native PointerPointer extended_data();
    
    public native AVFilterBuffer extended_data(PointerPointer paramPointerPointer);
    
    public native int format();
    
    public native AVFilterBuffer format(int paramInt);
    
    public native Free free();
    
    public native AVFilterBuffer free(Free paramFree);
    
    public native int h();
    
    public native AVFilterBuffer h(int paramInt);
    
    public native int linesize(int paramInt);
    
    public native AVFilterBuffer linesize(int paramInt1, int paramInt2);
    
    public AVFilterBuffer position(int paramInt)
    {
      return (AVFilterBuffer)super.position(paramInt);
    }
    
    public native Pointer priv();
    
    public native AVFilterBuffer priv(Pointer paramPointer);
    
    @Cast({"unsigned"})
    public native int refcount();
    
    public native AVFilterBuffer refcount(int paramInt);
    
    public native int w();
    
    public native AVFilterBuffer w(int paramInt);
    
    public static class Free
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Free()
      {
        allocate();
      }
      
      public Free(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVFilterBuffer paramAVFilterBuffer);
    }
  }
  
  public static class AVFilterBufferRef
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterBufferRef()
    {
      allocate();
    }
    
    public AVFilterBufferRef(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterBufferRef(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native AVFilterBufferRef audio(AVFilterBufferRefAudioProps paramAVFilterBufferRefAudioProps);
    
    public native AVFilterBufferRefAudioProps audio();
    
    public native AVFilterBuffer buf();
    
    public native AVFilterBufferRef buf(AVFilterBuffer paramAVFilterBuffer);
    
    @Cast({"uint8_t*"})
    public native BytePointer data(int paramInt);
    
    public native AVFilterBufferRef data(int paramInt, BytePointer paramBytePointer);
    
    @Cast({"uint8_t**"})
    public native PointerPointer extended_data();
    
    public native AVFilterBufferRef extended_data(PointerPointer paramPointerPointer);
    
    public native int format();
    
    public native AVFilterBufferRef format(int paramInt);
    
    public native int linesize(int paramInt);
    
    public native AVFilterBufferRef linesize(int paramInt1, int paramInt2);
    
    public native AVFilterBufferRef metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    public native int perms();
    
    public native AVFilterBufferRef perms(int paramInt);
    
    public native long pos();
    
    public native AVFilterBufferRef pos(long paramLong);
    
    public AVFilterBufferRef position(int paramInt)
    {
      return (AVFilterBufferRef)super.position(paramInt);
    }
    
    public native long pts();
    
    public native AVFilterBufferRef pts(long paramLong);
    
    @Cast({"AVMediaType"})
    public native int type();
    
    public native AVFilterBufferRef type(int paramInt);
    
    public native AVFilterBufferRef video(AVFilterBufferRefVideoProps paramAVFilterBufferRefVideoProps);
    
    public native AVFilterBufferRefVideoProps video();
  }
  
  public static class AVFilterBufferRefAudioProps
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterBufferRefAudioProps()
    {
      allocate();
    }
    
    public AVFilterBufferRefAudioProps(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterBufferRefAudioProps(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"uint64_t"})
    public native long channel_layout();
    
    public native AVFilterBufferRefAudioProps channel_layout(long paramLong);
    
    public native int channels();
    
    public native AVFilterBufferRefAudioProps channels(int paramInt);
    
    public native int nb_samples();
    
    public native AVFilterBufferRefAudioProps nb_samples(int paramInt);
    
    public AVFilterBufferRefAudioProps position(int paramInt)
    {
      return (AVFilterBufferRefAudioProps)super.position(paramInt);
    }
    
    public native int sample_rate();
    
    public native AVFilterBufferRefAudioProps sample_rate(int paramInt);
  }
  
  public static class AVFilterBufferRefVideoProps
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterBufferRefVideoProps()
    {
      allocate();
    }
    
    public AVFilterBufferRefVideoProps(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterBufferRefVideoProps(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int h();
    
    public native AVFilterBufferRefVideoProps h(int paramInt);
    
    public native int interlaced();
    
    public native AVFilterBufferRefVideoProps interlaced(int paramInt);
    
    public native int key_frame();
    
    public native AVFilterBufferRefVideoProps key_frame(int paramInt);
    
    @Cast({"enum AVPictureType"})
    public native int pict_type();
    
    public native AVFilterBufferRefVideoProps pict_type(int paramInt);
    
    public AVFilterBufferRefVideoProps position(int paramInt)
    {
      return (AVFilterBufferRefVideoProps)super.position(paramInt);
    }
    
    public native BytePointer qp_table();
    
    public native AVFilterBufferRefVideoProps qp_table(BytePointer paramBytePointer);
    
    public native int qp_table_linesize();
    
    public native AVFilterBufferRefVideoProps qp_table_linesize(int paramInt);
    
    public native int qp_table_size();
    
    public native AVFilterBufferRefVideoProps qp_table_size(int paramInt);
    
    public native AVFilterBufferRefVideoProps sample_aspect_ratio(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational sample_aspect_ratio();
    
    public native int top_field_first();
    
    public native AVFilterBufferRefVideoProps top_field_first(int paramInt);
    
    public native int w();
    
    public native AVFilterBufferRefVideoProps w(int paramInt);
  }
  
  @Opaque
  public static class AVFilterChannelLayouts
    extends Pointer
  {
    public AVFilterChannelLayouts() {}
    
    public AVFilterChannelLayouts(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Opaque
  public static class AVFilterCommand
    extends Pointer
  {
    public AVFilterCommand() {}
    
    public AVFilterCommand(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVFilterContext
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterContext()
    {
      allocate();
    }
    
    public AVFilterContext(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterContext(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native AVFilterContext av_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass av_class();
    
    public native AVFilterCommand command_queue();
    
    public native AVFilterContext command_queue(AVFilterCommand paramAVFilterCommand);
    
    public native AVFilter filter();
    
    public native AVFilterContext filter(AVFilter paramAVFilter);
    
    public native AVFilterContext input_pads(AVFilterPad paramAVFilterPad);
    
    public native AVFilterPad input_pads();
    
    @Cast({"AVFilterLink**"})
    public native PointerPointer inputs();
    
    public native AVFilterContext inputs(PointerPointer paramPointerPointer);
    
    @Cast({"char*"})
    public native BytePointer name();
    
    public native AVFilterContext name(BytePointer paramBytePointer);
    
    @Cast({"unsigned"})
    public native int nb_inputs();
    
    public native AVFilterContext nb_inputs(int paramInt);
    
    @Cast({"unsigned"})
    public native int nb_outputs();
    
    public native AVFilterContext nb_outputs(int paramInt);
    
    public native AVFilterContext output_pads(AVFilterPad paramAVFilterPad);
    
    public native AVFilterPad output_pads();
    
    @Cast({"AVFilterLink**"})
    public native PointerPointer outputs();
    
    public native AVFilterContext outputs(PointerPointer paramPointerPointer);
    
    public AVFilterContext position(int paramInt)
    {
      return (AVFilterContext)super.position(paramInt);
    }
    
    public native Pointer priv();
    
    public native AVFilterContext priv(Pointer paramPointer);
  }
  
  public static class AVFilterGraph
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterGraph()
    {
      allocate();
    }
    
    public AVFilterGraph(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterGraph(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"char*"})
    public native BytePointer aresample_swr_opts();
    
    public native AVFilterGraph aresample_swr_opts(BytePointer paramBytePointer);
    
    public native AVFilterGraph av_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass av_class();
    
    @Cast({"unsigned"})
    public native int filter_count();
    
    public native AVFilterGraph filter_count(int paramInt);
    
    @Cast({"AVFilterContext**"})
    public native PointerPointer filters();
    
    @MemberGetter
    public native avfilter.AVFilterContext filters(int paramInt);
    
    public native AVFilterGraph filters(PointerPointer paramPointerPointer);
    
    public AVFilterGraph position(int paramInt)
    {
      return (AVFilterGraph)super.position(paramInt);
    }
    
    @Cast({"char*"})
    public native BytePointer resample_lavr_opts();
    
    public native AVFilterGraph resample_lavr_opts(BytePointer paramBytePointer);
    
    @Cast({"char*"})
    public native BytePointer scale_sws_opts();
    
    public native AVFilterGraph scale_sws_opts(BytePointer paramBytePointer);
  }
  
  public static class AVFilterInOut
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterInOut()
    {
      allocate();
    }
    
    public AVFilterInOut(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterInOut(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native AVFilterContext filter_ctx();
    
    public native AVFilterInOut filter_ctx(AVFilterContext paramAVFilterContext);
    
    @Cast({"char*"})
    public native BytePointer name();
    
    public native AVFilterInOut name(BytePointer paramBytePointer);
    
    public native AVFilterInOut next();
    
    public native AVFilterInOut next(AVFilterInOut paramAVFilterInOut);
    
    public native int pad_idx();
    
    public native AVFilterInOut pad_idx(int paramInt);
    
    public AVFilterInOut position(int paramInt)
    {
      return (AVFilterInOut)super.position(paramInt);
    }
  }
  
  public static class AVFilterLink
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterLink()
    {
      allocate();
    }
    
    public AVFilterLink(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterLink(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"uint64_t"})
    public native long channel_layout();
    
    public native AVFilterLink channel_layout(long paramLong);
    
    public native AVFilterContext dst();
    
    public native AVFilterLink dst(AVFilterContext paramAVFilterContext);
    
    public native AVFilterLink dstpad(AVFilterPad paramAVFilterPad);
    
    public native AVFilterPad dstpad();
    
    public native int format();
    
    public native AVFilterLink format(int paramInt);
    
    public native int h();
    
    public native AVFilterLink h(int paramInt);
    
    public AVFilterLink position(int paramInt)
    {
      return (AVFilterLink)super.position(paramInt);
    }
    
    public native AVFilterLink sample_aspect_ratio(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational sample_aspect_ratio();
    
    public native int sample_rate();
    
    public native AVFilterLink sample_rate(int paramInt);
    
    public native AVFilterContext src();
    
    public native AVFilterLink src(AVFilterContext paramAVFilterContext);
    
    public native AVFilterLink srcpad(AVFilterPad paramAVFilterPad);
    
    public native AVFilterPad srcpad();
    
    public native AVFilterLink time_base(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational time_base();
    
    @Cast({"AVMediaType"})
    public native int type();
    
    public native AVFilterLink type(int paramInt);
    
    public native int w();
    
    public native AVFilterLink w(int paramInt);
  }
  
  public static class AVFilterPad
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFilterPad()
    {
      allocate();
    }
    
    public AVFilterPad(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFilterPad(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native Config_props config_props();
    
    public native AVFilterPad config_props(Config_props paramConfig_props);
    
    public native Draw_slice draw_slice();
    
    public native AVFilterPad draw_slice(Draw_slice paramDraw_slice);
    
    public native End_frame end_frame();
    
    public native AVFilterPad end_frame(End_frame paramEnd_frame);
    
    public native Filter_frame filter_frame();
    
    public native AVFilterPad filter_frame(Filter_frame paramFilter_frame);
    
    public native Get_audio_buffer get_audio_buffer();
    
    public native AVFilterPad get_audio_buffer(Get_audio_buffer paramGet_audio_buffer);
    
    public native Get_video_buffer get_video_buffer();
    
    public native AVFilterPad get_video_buffer(Get_video_buffer paramGet_video_buffer);
    
    public native int min_perms();
    
    public native AVFilterPad min_perms(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVFilterPad name(BytePointer paramBytePointer);
    
    public native int needs_fifo();
    
    public native AVFilterPad needs_fifo(int paramInt);
    
    public native Poll_frame poll_frame();
    
    public native AVFilterPad poll_frame(Poll_frame paramPoll_frame);
    
    public AVFilterPad position(int paramInt)
    {
      return (AVFilterPad)super.position(paramInt);
    }
    
    public native int rej_perms();
    
    public native AVFilterPad rej_perms(int paramInt);
    
    public native Request_frame request_frame();
    
    public native AVFilterPad request_frame(Request_frame paramRequest_frame);
    
    public native Start_frame start_frame();
    
    public native AVFilterPad start_frame(Start_frame paramStart_frame);
    
    @Cast({"AVMediaType"})
    public native int type();
    
    public native AVFilterPad type(int paramInt);
    
    public static class Config_props
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Config_props()
      {
        allocate();
      }
      
      public Config_props(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink);
    }
    
    public static class Draw_slice
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Draw_slice()
      {
        allocate();
      }
      
      public Draw_slice(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink, int paramInt1, int paramInt2, int paramInt3);
    }
    
    public static class End_frame
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected End_frame()
      {
        allocate();
      }
      
      public End_frame(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink);
    }
    
    public static class Filter_frame
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Filter_frame()
      {
        allocate();
      }
      
      public Filter_frame(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink, AVFilterBufferRef paramAVFilterBufferRef);
    }
    
    public static class Get_audio_buffer
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Get_audio_buffer()
      {
        allocate();
      }
      
      public Get_audio_buffer(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native AVFilterBufferRef callback(AVFilterLink paramAVFilterLink, int paramInt1, int paramInt2);
    }
    
    public static class Get_video_buffer
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Get_video_buffer()
      {
        allocate();
      }
      
      public Get_video_buffer(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native AVFilterBufferRef callback(AVFilterLink paramAVFilterLink, int paramInt1, int paramInt2, int paramInt3);
    }
    
    public static class Poll_frame
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Poll_frame()
      {
        allocate();
      }
      
      public Poll_frame(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink);
    }
    
    public static class Request_frame
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Request_frame()
      {
        allocate();
      }
      
      public Request_frame(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink);
    }
    
    public static class Start_frame
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Start_frame()
      {
        allocate();
      }
      
      public Start_frame(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVFilterLink paramAVFilterLink, AVFilterBufferRef paramAVFilterBufferRef);
    }
  }
  
  @Opaque
  public static class AVFilterPool
    extends Pointer
  {
    public AVFilterPool() {}
    
    public AVFilterPool(Pointer paramPointer)
    {
      super();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\avfilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */