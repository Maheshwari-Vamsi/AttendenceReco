package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavformat/avformat.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"avformat@.54", "avcodec@.54", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"avformat-54"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class avformat
{
  public static final int AVFMTCTX_NOHEADER = 1;
  public static final int AVFMT_ALLOW_FLUSH = 65536;
  public static final int AVFMT_DURATION_FROM_BITRATE = 2;
  public static final int AVFMT_DURATION_FROM_PTS = 0;
  public static final int AVFMT_DURATION_FROM_STREAM = 1;
  public static final int AVFMT_GENERIC_INDEX = 256;
  public static final int AVFMT_GLOBALHEADER = 64;
  public static final int AVFMT_NEEDNUMBER = 2;
  public static final int AVFMT_NOBINSEARCH = 8192;
  public static final int AVFMT_NODIMENSIONS = 2048;
  public static final int AVFMT_NOFILE = 1;
  public static final int AVFMT_NOGENSEARCH = 16384;
  public static final int AVFMT_NOSTREAMS = 4096;
  public static final int AVFMT_NOTIMESTAMPS = 128;
  public static final int AVFMT_NO_BYTE_SEEK = 32768;
  public static final int AVFMT_RAWPICTURE = 32;
  public static final int AVFMT_SEEK_TO_PTS = 67108864;
  public static final int AVFMT_SHOW_IDS = 8;
  public static final int AVFMT_TS_DISCONT = 512;
  public static final int AVFMT_TS_NONSTRICT = 134348800;
  public static final int AVFMT_VARIABLE_FPS = 1024;
  public static final int AVIO_FLAG_DIRECT = 32768;
  public static final int AVIO_FLAG_NONBLOCK = 8;
  public static final int AVIO_FLAG_READ = 1;
  public static final int AVIO_FLAG_READ_WRITE = 3;
  public static final int AVIO_FLAG_WRITE = 2;
  public static final int AVIO_SEEKABLE_NORMAL = 1;
  public static final int AVPROBE_PADDING_SIZE = 32;
  public static final int AVPROBE_SCORE_MAX = 100;
  public static final int AVPROBE_SCORE_RETRY = 25;
  public static final int AVSEEK_FLAG_ANY = 4;
  public static final int AVSEEK_FLAG_BACKWARD = 1;
  public static final int AVSEEK_FLAG_BYTE = 2;
  public static final int AVSEEK_FLAG_FRAME = 8;
  public static final int AVSEEK_FORCE = 131072;
  public static final int AVSEEK_SIZE = 65536;
  public static final int AVSTREAM_PARSE_FULL = 1;
  public static final int AVSTREAM_PARSE_FULL_ONCE = 4;
  public static final int AVSTREAM_PARSE_FULL_RAW = avutil.MKTAG(0, 82, 65, 87);
  public static final int AVSTREAM_PARSE_HEADERS = 2;
  public static final int AVSTREAM_PARSE_NONE = 0;
  public static final int AVSTREAM_PARSE_TIMESTAMPS = 3;
  public static final int AV_DISPOSITION_ATTACHED_PIC = 1024;
  public static final int AV_DISPOSITION_CLEAN_EFFECTS = 512;
  public static final int AV_DISPOSITION_COMMENT = 8;
  public static final int AV_DISPOSITION_DEFAULT = 1;
  public static final int AV_DISPOSITION_DUB = 2;
  public static final int AV_DISPOSITION_FORCED = 64;
  public static final int AV_DISPOSITION_HEARING_IMPAIRED = 128;
  public static final int AV_DISPOSITION_KARAOKE = 32;
  public static final int AV_DISPOSITION_LYRICS = 16;
  public static final int AV_DISPOSITION_ORIGINAL = 4;
  public static final int AV_DISPOSITION_VISUAL_IMPAIRED = 256;
  public static final int AV_PROGRAM_RUNNING = 1;
  public static final int AV_PTS_WRAP_ADD_OFFSET = 1;
  public static final int AV_PTS_WRAP_IGNORE = 0;
  public static final int AV_PTS_WRAP_SUB_OFFSET = -1;
  public static final int LIBAVFORMAT_BUILD = 0;
  public static final String LIBAVFORMAT_IDENT;
  public static final String LIBAVFORMAT_VERSION;
  public static final int LIBAVFORMAT_VERSION_INT = 0;
  public static final int LIBAVFORMAT_VERSION_MAJOR = 54;
  public static final int LIBAVFORMAT_VERSION_MICRO = 104;
  public static final int LIBAVFORMAT_VERSION_MINOR = 63;
  
  static
  {
    Loader.load(avcodec.class);
    Loader.load();
    LIBAVFORMAT_VERSION_INT = avutil.AV_VERSION_INT(54, 63, 104);
    LIBAVFORMAT_VERSION = avutil.AV_VERSION(54, 63, 104);
    LIBAVFORMAT_BUILD = LIBAVFORMAT_VERSION_INT;
    LIBAVFORMAT_IDENT = "Lavf" + LIBAVFORMAT_VERSION;
  }
  
  public static native int av_add_index_entry(AVStream paramAVStream, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int av_append_packet(AVIOContext paramAVIOContext, avcodec.AVPacket paramAVPacket, int paramInt);
  
  @Cast({"AVCodecID"})
  public static native int av_codec_get_id(@ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"unsigned"}) int paramInt);
  
  @Cast({"unsigned"})
  public static native int av_codec_get_tag(@ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"AVCodecID"}) int paramInt);
  
  public static native int av_codec_get_tag2(@ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"AVCodecID"}) int paramInt, @Cast({"unsigned*"}) int[] paramArrayOfInt);
  
  public static native void av_dump_format(AVFormatContext paramAVFormatContext, int paramInt1, String paramString, int paramInt2);
  
  public static native int av_filename_number_test(String paramString);
  
  public static native int av_find_best_stream(AVFormatContext paramAVFormatContext, @Cast({"AVMediaType"}) int paramInt1, int paramInt2, int paramInt3, @ByPtrPtr avcodec.AVCodec paramAVCodec, int paramInt4);
  
  public static native int av_find_default_stream_index(AVFormatContext paramAVFormatContext);
  
  public static native AVInputFormat av_find_input_format(String paramString);
  
  public static native AVProgram av_find_program_from_stream(AVFormatContext paramAVFormatContext, AVProgram paramAVProgram, int paramInt);
  
  @Cast({"AVDurationEstimationMethod"})
  public static native int av_fmt_ctx_get_duration_estimation_method(AVFormatContext paramAVFormatContext);
  
  public static native int av_get_frame_filename(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, String paramString, int paramInt2);
  
  public static native int av_get_output_timestamp(AVFormatContext paramAVFormatContext, int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  
  public static native int av_get_packet(AVIOContext paramAVIOContext, avcodec.AVPacket paramAVPacket, int paramInt);
  
  @Cast({"AVCodecID"})
  public static native int av_guess_codec(AVOutputFormat paramAVOutputFormat, String paramString1, String paramString2, String paramString3, @Cast({"AVMediaType"}) int paramInt);
  
  public static native AVOutputFormat av_guess_format(String paramString1, String paramString2, String paramString3);
  
  @ByVal
  public static native avutil.AVRational av_guess_sample_aspect_ratio(AVFormatContext paramAVFormatContext, AVStream paramAVStream, avcodec.AVFrame paramAVFrame);
  
  public static native void av_hex_dump(@Cast({"FILE*"}) Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
  
  public static native void av_hex_dump_log(Pointer paramPointer, int paramInt1, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt2);
  
  public static native AVInputFormat av_iformat_next(AVInputFormat paramAVInputFormat);
  
  public static native int av_index_search_timestamp(AVStream paramAVStream, long paramLong, int paramInt);
  
  public static native int av_interleaved_write_frame(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
  
  public static native int av_match_ext(String paramString1, String paramString2);
  
  public static native AVProgram av_new_program(AVFormatContext paramAVFormatContext, int paramInt);
  
  public static native AVOutputFormat av_oformat_next(AVOutputFormat paramAVOutputFormat);
  
  public static native void av_pkt_dump2(@Cast({"FILE*"}) Pointer paramPointer, avcodec.AVPacket paramAVPacket, int paramInt, AVStream paramAVStream);
  
  public static native void av_pkt_dump_log2(Pointer paramPointer, int paramInt1, avcodec.AVPacket paramAVPacket, int paramInt2, AVStream paramAVStream);
  
  public static native int av_probe_input_buffer(AVIOContext paramAVIOContext, @ByPtrPtr AVInputFormat paramAVInputFormat, String paramString, Pointer paramPointer, @Cast({"unsigned"}) int paramInt1, @Cast({"unsigned"}) int paramInt2);
  
  public static native AVInputFormat av_probe_input_format(AVProbeData paramAVProbeData, int paramInt);
  
  public static native AVInputFormat av_probe_input_format2(AVProbeData paramAVProbeData, int paramInt, int[] paramArrayOfInt);
  
  public static native AVInputFormat av_probe_input_format3(AVProbeData paramAVProbeData, int paramInt, int[] paramArrayOfInt);
  
  public static native int av_read_frame(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
  
  public static native int av_read_pause(AVFormatContext paramAVFormatContext);
  
  public static native int av_read_play(AVFormatContext paramAVFormatContext);
  
  public static native void av_register_all();
  
  public static native void av_register_input_format(AVInputFormat paramAVInputFormat);
  
  public static native void av_register_output_format(AVOutputFormat paramAVOutputFormat);
  
  public static native int av_sdp_create(@Cast({"AVFormatContext**"}) PointerPointer paramPointerPointer, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
  
  public static native int av_seek_frame(AVFormatContext paramAVFormatContext, int paramInt1, long paramLong, int paramInt2);
  
  public static native void av_url_split(@Cast({"char*"}) byte[] paramArrayOfByte1, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte2, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte3, int paramInt3, int[] paramArrayOfInt, @Cast({"char*"}) byte[] paramArrayOfByte4, int paramInt4, String paramString);
  
  public static native int av_write_frame(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
  
  public static native int av_write_trailer(AVFormatContext paramAVFormatContext);
  
  public static native AVFormatContext avformat_alloc_context();
  
  public static native int avformat_alloc_output_context2(@ByPtrPtr AVFormatContext paramAVFormatContext, AVOutputFormat paramAVOutputFormat, String paramString1, String paramString2);
  
  public static native void avformat_close_input(@ByPtrPtr AVFormatContext paramAVFormatContext);
  
  public static native String avformat_configuration();
  
  public static native int avformat_find_stream_info(AVFormatContext paramAVFormatContext, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
  
  public static native void avformat_free_context(AVFormatContext paramAVFormatContext);
  
  @Const
  public static native avutil.AVClass avformat_get_class();
  
  @Const
  public static native AVCodecTag avformat_get_riff_audio_tags();
  
  @Const
  public static native AVCodecTag avformat_get_riff_video_tags();
  
  public static native String avformat_license();
  
  public static native int avformat_match_stream_specifier(AVFormatContext paramAVFormatContext, AVStream paramAVStream, String paramString);
  
  public static native int avformat_network_deinit();
  
  public static native int avformat_network_init();
  
  public static native AVStream avformat_new_stream(AVFormatContext paramAVFormatContext, avcodec.AVCodec paramAVCodec);
  
  public static native int avformat_open_input(@ByPtrPtr AVFormatContext paramAVFormatContext, String paramString, AVInputFormat paramAVInputFormat, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
  
  public static native int avformat_query_codec(AVOutputFormat paramAVOutputFormat, @Cast({"AVCodecID"}) int paramInt1, int paramInt2);
  
  public static native void avformat_queue_attached_pictures(AVFormatContext paramAVFormatContext);
  
  public static native int avformat_seek_file(AVFormatContext paramAVFormatContext, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
  
  @Cast({"unsigned"})
  public static native int avformat_version();
  
  public static native int avformat_write_header(AVFormatContext paramAVFormatContext, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
  
  public static native AVIOContext avio_alloc_context(@Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, Pointer paramPointer, AVIOContext.Read_packet paramRead_packet, AVIOContext.Write_packet paramWrite_packet, AVIOContext.Seek paramSeek);
  
  public static native int avio_check(String paramString, int paramInt);
  
  public static native int avio_close(AVIOContext paramAVIOContext);
  
  public static native int avio_close_dyn_buf(AVIOContext paramAVIOContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer);
  
  public static native int avio_closep(@ByPtrPtr AVIOContext paramAVIOContext);
  
  public static native String avio_enum_protocols(PointerPointer paramPointerPointer, int paramInt);
  
  public static native void avio_flush(AVIOContext paramAVIOContext);
  
  public static native int avio_get_str(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
  
  public static native int avio_get_str16be(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
  
  public static native int avio_get_str16le(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
  
  public static native int avio_open(@ByPtrPtr AVIOContext paramAVIOContext, String paramString, int paramInt);
  
  public static native int avio_open2(@ByPtrPtr AVIOContext paramAVIOContext, String paramString, int paramInt, AVIOInterruptCB paramAVIOInterruptCB, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
  
  public static native int avio_open_dyn_buf(@ByPtrPtr AVIOContext paramAVIOContext);
  
  public static native int avio_pause(AVIOContext paramAVIOContext, int paramInt);
  
  public static native int avio_printf(AVIOContext paramAVIOContext, String paramString);
  
  public static native int avio_put_str(AVIOContext paramAVIOContext, String paramString);
  
  public static native int avio_put_str16le(AVIOContext paramAVIOContext, String paramString);
  
  public static native int avio_r8(AVIOContext paramAVIOContext);
  
  @Cast({"unsigned"})
  public static native int avio_rb16(AVIOContext paramAVIOContext);
  
  @Cast({"unsigned"})
  public static native int avio_rb24(AVIOContext paramAVIOContext);
  
  @Cast({"unsigned"})
  public static native int avio_rb32(AVIOContext paramAVIOContext);
  
  @Cast({"uint64_t"})
  public static native long avio_rb64(AVIOContext paramAVIOContext);
  
  public static native int avio_read(AVIOContext paramAVIOContext, @Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt);
  
  @Cast({"unsigned"})
  public static native int avio_rl16(AVIOContext paramAVIOContext);
  
  @Cast({"unsigned"})
  public static native int avio_rl24(AVIOContext paramAVIOContext);
  
  @Cast({"unsigned"})
  public static native int avio_rl32(AVIOContext paramAVIOContext);
  
  @Cast({"uint64_t"})
  public static native long avio_rl64(AVIOContext paramAVIOContext);
  
  public static native long avio_seek(AVIOContext paramAVIOContext, long paramLong, int paramInt);
  
  public static native long avio_seek_time(AVIOContext paramAVIOContext, int paramInt1, long paramLong, int paramInt2);
  
  public static native long avio_size(AVIOContext paramAVIOContext);
  
  public static native long avio_skip(AVIOContext paramAVIOContext, long paramLong);
  
  public static native long avio_tell(AVIOContext paramAVIOContext);
  
  public static native void avio_w8(AVIOContext paramAVIOContext, int paramInt);
  
  public static native void avio_wb16(AVIOContext paramAVIOContext, @Cast({"unsigned"}) int paramInt);
  
  public static native void avio_wb24(AVIOContext paramAVIOContext, @Cast({"unsigned"}) int paramInt);
  
  public static native void avio_wb32(AVIOContext paramAVIOContext, @Cast({"unsigned"}) int paramInt);
  
  public static native void avio_wb64(AVIOContext paramAVIOContext, @Cast({"uint64_t"}) long paramLong);
  
  public static native void avio_wl16(AVIOContext paramAVIOContext, @Cast({"unsigned"}) int paramInt);
  
  public static native void avio_wl24(AVIOContext paramAVIOContext, @Cast({"unsigned"}) int paramInt);
  
  public static native void avio_wl32(AVIOContext paramAVIOContext, @Cast({"unsigned"}) int paramInt);
  
  public static native void avio_wl64(AVIOContext paramAVIOContext, @Cast({"uint64_t"}) long paramLong);
  
  public static native void avio_write(AVIOContext paramAVIOContext, @Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt);
  
  public static native int url_feof(AVIOContext paramAVIOContext);
  
  public static class AVChapter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVChapter()
    {
      allocate();
    }
    
    public AVChapter(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVChapter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native long end();
    
    public native AVChapter end(long paramLong);
    
    public native int id();
    
    public native AVChapter id(int paramInt);
    
    public native AVChapter metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    public AVChapter position(int paramInt)
    {
      return (AVChapter)super.position(paramInt);
    }
    
    public native long start();
    
    public native AVChapter start(long paramLong);
    
    public native AVChapter time_base(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational time_base();
  }
  
  @Opaque
  public static class AVCodecTag
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVCodecTag() {}
    
    public AVCodecTag(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVFormatContext
    extends Pointer
  {
    public static final int AVFMT_FLAG_CUSTOM_IO = 128;
    public static final int AVFMT_FLAG_DISCARD_CORRUPT = 256;
    public static final int AVFMT_FLAG_GENPTS = 1;
    public static final int AVFMT_FLAG_IGNDTS = 8;
    public static final int AVFMT_FLAG_IGNIDX = 2;
    public static final int AVFMT_FLAG_KEEP_SIDE_DATA = 262144;
    public static final int AVFMT_FLAG_MP4A_LATM = 32768;
    public static final int AVFMT_FLAG_NOBUFFER = 64;
    public static final int AVFMT_FLAG_NOFILLIN = 16;
    public static final int AVFMT_FLAG_NONBLOCK = 4;
    public static final int AVFMT_FLAG_NOPARSE = 32;
    public static final int AVFMT_FLAG_PRIV_OPT = 131072;
    public static final int AVFMT_FLAG_SORT_DTS = 65536;
    public static final int FF_FDEBUG_TS = 1;
    
    static
    {
      Loader.load();
    }
    
    public AVFormatContext()
    {
      allocate();
    }
    
    public AVFormatContext(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFormatContext(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"AVCodecID"})
    public native int audio_codec_id();
    
    public native AVFormatContext audio_codec_id(int paramInt);
    
    public native int audio_preload();
    
    public native AVFormatContext audio_preload(int paramInt);
    
    public native AVFormatContext av_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass av_class();
    
    public native int avio_flags();
    
    public native AVFormatContext avio_flags(int paramInt);
    
    public native int avoid_negative_ts();
    
    public native AVFormatContext avoid_negative_ts(int paramInt);
    
    public native int bit_rate();
    
    public native AVFormatContext bit_rate(int paramInt);
    
    @Cast({"AVChapter**"})
    public native PointerPointer chapters();
    
    @MemberGetter
    public native avformat.AVChapter chapters(int paramInt);
    
    public native AVFormatContext chapters(PointerPointer paramPointerPointer);
    
    @Cast({"unsigned"})
    public native int correct_ts_overflow();
    
    public native AVFormatContext correct_ts_overflow(int paramInt);
    
    public native int ctx_flags();
    
    public native AVFormatContext ctx_flags(int paramInt);
    
    public native int debug();
    
    public native AVFormatContext debug(int paramInt);
    
    public native long duration();
    
    public native AVFormatContext duration(long paramLong);
    
    @Cast({"AVDurationEstimationMethod"})
    public native int duration_estimation_method();
    
    public native AVFormatContext duration_estimation_method(int paramInt);
    
    public native int error_recognition();
    
    public native AVFormatContext error_recognition(int paramInt);
    
    public native AVFormatContext filename(String paramString);
    
    public native String filename();
    
    public native int flags();
    
    public native AVFormatContext flags(int paramInt);
    
    public native int fps_probe_size();
    
    public native AVFormatContext fps_probe_size(int paramInt);
    
    public native AVFormatContext iformat(AVInputFormat paramAVInputFormat);
    
    public native AVInputFormat iformat();
    
    public native AVFormatContext interrupt_callback(AVIOInterruptCB paramAVIOInterruptCB);
    
    @ByRef
    public native avformat.AVIOInterruptCB interrupt_callback();
    
    @Cast({"const uint8_t*"})
    public native BytePointer key();
    
    public native AVFormatContext key(BytePointer paramBytePointer);
    
    public native int keylen();
    
    public native AVFormatContext keylen(int paramInt);
    
    public native int max_analyze_duration();
    
    public native AVFormatContext max_analyze_duration(int paramInt);
    
    public native int max_chunk_duration();
    
    public native AVFormatContext max_chunk_duration(int paramInt);
    
    public native int max_chunk_size();
    
    public native AVFormatContext max_chunk_size(int paramInt);
    
    public native int max_delay();
    
    public native AVFormatContext max_delay(int paramInt);
    
    @Cast({"unsigned"})
    public native int max_index_size();
    
    public native AVFormatContext max_index_size(int paramInt);
    
    @Cast({"unsigned"})
    public native int max_picture_buffer();
    
    public native AVFormatContext max_picture_buffer(int paramInt);
    
    public native AVFormatContext metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    @Cast({"unsigned"})
    public native int nb_chapters();
    
    public native AVFormatContext nb_chapters(int paramInt);
    
    @Cast({"unsigned"})
    public native int nb_programs();
    
    public native AVFormatContext nb_programs(int paramInt);
    
    @Cast({"unsigned"})
    public native int nb_streams();
    
    public native AVFormatContext nb_streams(int paramInt);
    
    public native AVFormatContext oformat(AVOutputFormat paramAVOutputFormat);
    
    public native AVOutputFormat oformat();
    
    @Cast({"unsigned"})
    public native int packet_size();
    
    public native AVFormatContext packet_size(int paramInt);
    
    public native AVFormatContext pb(AVIOContext paramAVIOContext);
    
    public native AVIOContext pb();
    
    public AVFormatContext position(int paramInt)
    {
      return (AVFormatContext)super.position(paramInt);
    }
    
    public native Pointer priv_data();
    
    public native AVFormatContext priv_data(Pointer paramPointer);
    
    @Cast({"unsigned"})
    public native int probesize();
    
    public native AVFormatContext probesize(int paramInt);
    
    @Cast({"AVProgram**"})
    public native PointerPointer programs();
    
    public native AVFormatContext programs(PointerPointer paramPointerPointer);
    
    @MemberGetter
    public native avformat.AVProgram programs(int paramInt);
    
    public native int seek2any();
    
    public native AVFormatContext seek2any(int paramInt);
    
    @Cast({"unsigned"})
    public native int skip_initial_bytes();
    
    public native AVFormatContext skip_initial_bytes(int paramInt);
    
    public native long start_time();
    
    public native AVFormatContext start_time(long paramLong);
    
    public native long start_time_realtime();
    
    public native AVFormatContext start_time_realtime(long paramLong);
    
    @Cast({"AVStream**"})
    public native PointerPointer streams();
    
    public native AVFormatContext streams(PointerPointer paramPointerPointer);
    
    @MemberGetter
    public native avformat.AVStream streams(int paramInt);
    
    @Cast({"AVCodecID"})
    public native int subtitle_codec_id();
    
    public native AVFormatContext subtitle_codec_id(int paramInt);
    
    public native int ts_id();
    
    public native AVFormatContext ts_id(int paramInt);
    
    public native int use_wallclock_as_timestamps();
    
    public native AVFormatContext use_wallclock_as_timestamps(int paramInt);
    
    @Cast({"AVCodecID"})
    public native int video_codec_id();
    
    public native AVFormatContext video_codec_id(int paramInt);
  }
  
  public static class AVFrac
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVFrac()
    {
      allocate();
    }
    
    public AVFrac(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFrac(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native long den();
    
    public native AVFrac den(long paramLong);
    
    public native long num();
    
    public native AVFrac num(long paramLong);
    
    public AVFrac position(int paramInt)
    {
      return (AVFrac)super.position(paramInt);
    }
    
    public native long val();
    
    public native AVFrac val(long paramLong);
  }
  
  public static class AVIOContext
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVIOContext()
    {
      allocate();
    }
    
    public AVIOContext(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVIOContext(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native AVIOContext av_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass av_class();
    
    @Cast({"unsigned char*"})
    public native BytePointer buf_end();
    
    public native AVIOContext buf_end(BytePointer paramBytePointer);
    
    @Cast({"unsigned char*"})
    public native BytePointer buf_ptr();
    
    public native AVIOContext buf_ptr(BytePointer paramBytePointer);
    
    @Cast({"unsigned char*"})
    public native BytePointer buffer();
    
    public native AVIOContext buffer(BytePointer paramBytePointer);
    
    public native int buffer_size();
    
    public native AVIOContext buffer_size(int paramInt);
    
    public native long bytes_read();
    
    public native AVIOContext bytes_read(long paramLong);
    
    @Cast({"unsigned long"})
    public native long checksum();
    
    public native AVIOContext checksum(long paramLong);
    
    @Cast({"unsigned char*"})
    public native BytePointer checksum_ptr();
    
    public native AVIOContext checksum_ptr(BytePointer paramBytePointer);
    
    public native int direct();
    
    public native AVIOContext direct(int paramInt);
    
    public native int eof_reached();
    
    public native AVIOContext eof_reached(int paramInt);
    
    public native int error();
    
    public native AVIOContext error(int paramInt);
    
    public native int max_packet_size();
    
    public native AVIOContext max_packet_size(int paramInt);
    
    public native long maxsize();
    
    public native AVIOContext maxsize(long paramLong);
    
    public native int must_flush();
    
    public native AVIOContext must_flush(int paramInt);
    
    public native Pointer opaque();
    
    public native AVIOContext opaque(Pointer paramPointer);
    
    public native long pos();
    
    public native AVIOContext pos(long paramLong);
    
    public AVIOContext position(int paramInt)
    {
      return (AVIOContext)super.position(paramInt);
    }
    
    public native Read_packet read_packet();
    
    public native AVIOContext read_packet(Read_packet paramRead_packet);
    
    public native Read_pause read_pause();
    
    public native AVIOContext read_pause(Read_pause paramRead_pause);
    
    public native Read_seek read_seek();
    
    public native AVIOContext read_seek(Read_seek paramRead_seek);
    
    public native Seek seek();
    
    public native AVIOContext seek(Seek paramSeek);
    
    public native int seek_count();
    
    public native AVIOContext seek_count(int paramInt);
    
    public native int seekable();
    
    public native AVIOContext seekable(int paramInt);
    
    public native Update_checksum update_checksum();
    
    public native AVIOContext update_checksum(Update_checksum paramUpdate_checksum);
    
    public native int write_flag();
    
    public native AVIOContext write_flag(int paramInt);
    
    public native Write_packet write_packet();
    
    public native AVIOContext write_packet(Write_packet paramWrite_packet);
    
    public static class Read_packet
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Read_packet()
      {
        allocate();
      }
      
      public Read_packet(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
    }
    
    public static class Read_pause
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Read_pause()
      {
        allocate();
      }
      
      public Read_pause(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(Pointer paramPointer, int paramInt);
    }
    
    public static class Read_seek
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Read_seek()
      {
        allocate();
      }
      
      public Read_seek(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native long call(Pointer paramPointer, int paramInt1, long paramLong, int paramInt2);
    }
    
    public static class Seek
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Seek()
      {
        allocate();
      }
      
      public Seek(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native long call(Pointer paramPointer, long paramLong, int paramInt);
    }
    
    public static class Update_checksum
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Update_checksum()
      {
        allocate();
      }
      
      public Update_checksum(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      @Cast({"unsigned long"})
      public native long call(@Cast({"unsigned long"}) long paramLong, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"unsigned"}) int paramInt);
    }
    
    public static class Write_packet
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Write_packet()
      {
        allocate();
      }
      
      public Write_packet(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
    }
  }
  
  public static class AVIOInterruptCB
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVIOInterruptCB()
    {
      allocate();
    }
    
    public AVIOInterruptCB(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVIOInterruptCB(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native Callback callback();
    
    public native AVIOInterruptCB callback(Callback paramCallback);
    
    public native Pointer opaque();
    
    public native AVIOInterruptCB opaque(Pointer paramPointer);
    
    public AVIOInterruptCB position(int paramInt)
    {
      return (AVIOInterruptCB)super.position(paramInt);
    }
    
    public static class Callback
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Callback()
      {
        allocate();
      }
      
      public Callback(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(Pointer paramPointer);
    }
  }
  
  public static class AVIndexEntry
    extends Pointer
  {
    public static final int AVINDEX_KEYFRAME = 1;
    
    static
    {
      Loader.load();
    }
    
    public AVIndexEntry()
    {
      allocate();
    }
    
    public AVIndexEntry(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVIndexEntry(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @NoOffset
    public native int flags();
    
    public native AVIndexEntry flags(int paramInt);
    
    public native int min_distance();
    
    public native AVIndexEntry min_distance(int paramInt);
    
    public native long pos();
    
    public native AVIndexEntry pos(long paramLong);
    
    public AVIndexEntry position(int paramInt)
    {
      return (AVIndexEntry)super.position(paramInt);
    }
    
    @NoOffset
    public native int size();
    
    public native AVIndexEntry size(int paramInt);
    
    public native long timestamp();
    
    public native AVIndexEntry timestamp(long paramLong);
  }
  
  public static class AVInputFormat
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVInputFormat()
    {
      allocate();
    }
    
    public AVInputFormat(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVInputFormat(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"const AVCodecTag * const *"})
    public native PointerPointer codec_tag();
    
    public native AVInputFormat codec_tag(PointerPointer paramPointerPointer);
    
    @Cast({"const char*"})
    public native BytePointer extensions();
    
    public native AVInputFormat extensions(BytePointer paramBytePointer);
    
    public native int flags();
    
    public native AVInputFormat flags(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer long_name();
    
    public native AVInputFormat long_name(BytePointer paramBytePointer);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVInputFormat name(BytePointer paramBytePointer);
    
    public AVInputFormat position(int paramInt)
    {
      return (AVInputFormat)super.position(paramInt);
    }
    
    public native AVInputFormat priv_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass priv_class();
  }
  
  public static class AVOutputFormat
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVOutputFormat()
    {
      allocate();
    }
    
    public AVOutputFormat(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVOutputFormat(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"AVCodecID"})
    public native int audio_codec();
    
    public native AVOutputFormat audio_codec(int paramInt);
    
    @Cast({"const AVCodecTag * const *"})
    public native PointerPointer codec_tag();
    
    public native AVOutputFormat codec_tag(PointerPointer paramPointerPointer);
    
    @Cast({"const char*"})
    public native BytePointer extensions();
    
    public native AVOutputFormat extensions(BytePointer paramBytePointer);
    
    public native int flags();
    
    public native AVOutputFormat flags(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer long_name();
    
    public native AVOutputFormat long_name(BytePointer paramBytePointer);
    
    @Cast({"const char*"})
    public native BytePointer mime_type();
    
    public native AVOutputFormat mime_type(BytePointer paramBytePointer);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVOutputFormat name(BytePointer paramBytePointer);
    
    public AVOutputFormat position(int paramInt)
    {
      return (AVOutputFormat)super.position(paramInt);
    }
    
    public native AVOutputFormat priv_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass priv_class();
    
    @Cast({"AVCodecID"})
    public native int subtitle_codec();
    
    public native AVOutputFormat subtitle_codec(int paramInt);
    
    @Cast({"AVCodecID"})
    public native int video_codec();
    
    public native AVOutputFormat video_codec(int paramInt);
  }
  
  public static class AVPacketList
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVPacketList()
    {
      allocate();
    }
    
    public AVPacketList(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVPacketList(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native AVPacketList next();
    
    public native AVPacketList next(AVPacketList paramAVPacketList);
    
    @ByRef
    public native avcodec.AVPacket pkt();
    
    public native AVPacketList pkt(avcodec.AVPacket paramAVPacket);
    
    public AVPacketList position(int paramInt)
    {
      return (AVPacketList)super.position(paramInt);
    }
  }
  
  public static class AVProbeData
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVProbeData()
    {
      allocate();
    }
    
    public AVProbeData(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVProbeData(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"unsigned char*"})
    public native BytePointer buf();
    
    public native AVProbeData buf(BytePointer paramBytePointer);
    
    public native int buf_size();
    
    public native AVProbeData buf_size(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer filename();
    
    public native AVProbeData filename(BytePointer paramBytePointer);
    
    public AVProbeData position(int paramInt)
    {
      return (AVProbeData)super.position(paramInt);
    }
  }
  
  public static class AVProgram
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVProgram()
    {
      allocate();
    }
    
    public AVProgram(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVProgram(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"AVDiscard"})
    public native int discard();
    
    public native AVProgram discard(int paramInt);
    
    public native int flags();
    
    public native AVProgram flags(int paramInt);
    
    public native int id();
    
    public native AVProgram id(int paramInt);
    
    public native AVProgram metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    public native int nb_stream_indexes();
    
    public native AVProgram nb_stream_indexes(int paramInt);
    
    public native int pcr_pid();
    
    public native AVProgram pcr_pid(int paramInt);
    
    public native int pmt_pid();
    
    public native AVProgram pmt_pid(int paramInt);
    
    public AVProgram position(int paramInt)
    {
      return (AVProgram)super.position(paramInt);
    }
    
    public native int program_num();
    
    public native AVProgram program_num(int paramInt);
    
    @Cast({"unsigned int*"})
    public native IntPointer stream_index();
    
    public native AVProgram stream_index(IntPointer paramIntPointer);
  }
  
  public static class AVStream
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVStream()
    {
      allocate();
    }
    
    public AVStream(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVStream(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    public native avcodec.AVPacket attached_pic();
    
    public native AVStream attached_pic(avcodec.AVPacket paramAVPacket);
    
    public native AVStream avg_frame_rate(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational avg_frame_rate();
    
    public native avcodec.AVCodecContext codec();
    
    public native AVStream codec(avcodec.AVCodecContext paramAVCodecContext);
    
    @Cast({"AVDiscard"})
    public native int discard();
    
    public native AVStream discard(int paramInt);
    
    public native int disposition();
    
    public native AVStream disposition(int paramInt);
    
    public native long duration();
    
    public native AVStream duration(long paramLong);
    
    public native int id();
    
    public native AVStream id(int paramInt);
    
    public native int index();
    
    public native AVStream index(int paramInt);
    
    public native AVStream metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    public native long nb_frames();
    
    public native AVStream nb_frames(long paramLong);
    
    public AVStream position(int paramInt)
    {
      return (AVStream)super.position(paramInt);
    }
    
    public native Pointer priv_data();
    
    public native AVStream priv_data(Pointer paramPointer);
    
    @ByRef
    public native avformat.AVFrac pts();
    
    public native AVStream pts(AVFrac paramAVFrac);
    
    public native AVStream r_frame_rate(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational r_frame_rate();
    
    public native AVStream sample_aspect_ratio(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational sample_aspect_ratio();
    
    public native long start_time();
    
    public native AVStream start_time(long paramLong);
    
    public native AVStream time_base(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational time_base();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\avformat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */