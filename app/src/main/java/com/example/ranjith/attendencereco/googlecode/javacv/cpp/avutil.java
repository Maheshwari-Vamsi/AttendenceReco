package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.SizeTPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;
import java.nio.ByteOrder;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavutil/avutil.h>", "<libavutil/audioconvert.h>", "<libavutil/cpu.h>", "<libavutil/dict.h>", "<libavutil/opt.h>", "<libavutil/samplefmt.h>", "<libavutil/imgutils.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"avutil-52"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class avutil
{
  public static final int AVERROR_BSF_NOT_FOUND = 0;
  public static final int AVERROR_BUFFER_TOO_SMALL = 0;
  public static final int AVERROR_BUG = 0;
  public static final int AVERROR_BUG2 = 0;
  public static final int AVERROR_DECODER_NOT_FOUND = 0;
  public static final int AVERROR_DEMUXER_NOT_FOUND = 0;
  public static final int AVERROR_ENCODER_NOT_FOUND = 0;
  public static final int AVERROR_EOF = 0;
  public static final int AVERROR_EXIT = 0;
  public static final int AVERROR_EXPERIMENTAL = -733130664;
  public static final int AVERROR_EXTERNAL = 0;
  public static final int AVERROR_FILTER_NOT_FOUND = 0;
  public static final int AVERROR_INVALIDDATA = 0;
  public static final int AVERROR_MUXER_NOT_FOUND = 0;
  public static final int AVERROR_OPTION_NOT_FOUND = 0;
  public static final int AVERROR_PATCHWELCOME = 0;
  public static final int AVERROR_PROTOCOL_NOT_FOUND = 0;
  public static final int AVERROR_STREAM_NOT_FOUND = 0;
  public static final int AVERROR_UNKNOWN = 0;
  public static final int AVMEDIA_TYPE_ATTACHMENT = 4;
  public static final int AVMEDIA_TYPE_AUDIO = 1;
  public static final int AVMEDIA_TYPE_DATA = 2;
  public static final int AVMEDIA_TYPE_NB = 5;
  public static final int AVMEDIA_TYPE_SUBTITLE = 3;
  public static final int AVMEDIA_TYPE_UNKNOWN = -1;
  public static final int AVMEDIA_TYPE_VIDEO = 0;
  public static final int AVPALETTE_COUNT = 256;
  public static final int AVPALETTE_SIZE = 1024;
  public static final int AV_CH_BACK_CENTER = 256;
  public static final int AV_CH_BACK_LEFT = 16;
  public static final int AV_CH_BACK_RIGHT = 32;
  public static final int AV_CH_FRONT_CENTER = 4;
  public static final int AV_CH_FRONT_LEFT = 1;
  public static final int AV_CH_FRONT_LEFT_OF_CENTER = 64;
  public static final int AV_CH_FRONT_RIGHT = 2;
  public static final int AV_CH_FRONT_RIGHT_OF_CENTER = 128;
  public static final int AV_CH_LAYOUT_2POINT1 = 11;
  public static final int AV_CH_LAYOUT_2_1 = 259;
  public static final int AV_CH_LAYOUT_2_2 = 1539;
  public static final int AV_CH_LAYOUT_3POINT1 = 15;
  public static final int AV_CH_LAYOUT_4POINT0 = 263;
  public static final int AV_CH_LAYOUT_4POINT1 = 271;
  public static final int AV_CH_LAYOUT_5POINT0 = 1543;
  public static final int AV_CH_LAYOUT_5POINT0_BACK = 55;
  public static final int AV_CH_LAYOUT_5POINT1 = 1551;
  public static final int AV_CH_LAYOUT_5POINT1_BACK = 63;
  public static final int AV_CH_LAYOUT_6POINT0 = 1799;
  public static final int AV_CH_LAYOUT_6POINT0_FRONT = 1731;
  public static final int AV_CH_LAYOUT_6POINT1 = 1807;
  public static final int AV_CH_LAYOUT_6POINT1_BACK = 319;
  public static final int AV_CH_LAYOUT_6POINT1_FRONT = 1739;
  public static final int AV_CH_LAYOUT_7POINT0 = 1591;
  public static final int AV_CH_LAYOUT_7POINT0_FRONT = 1735;
  public static final int AV_CH_LAYOUT_7POINT1 = 1599;
  public static final int AV_CH_LAYOUT_7POINT1_WIDE = 1743;
  public static final int AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255;
  public static final int AV_CH_LAYOUT_HEXAGONAL = 311;
  public static final int AV_CH_LAYOUT_MONO = 4;
  public static final long AV_CH_LAYOUT_NATIVE = Long.MIN_VALUE;
  public static final int AV_CH_LAYOUT_OCTAGONAL = 1847;
  public static final int AV_CH_LAYOUT_QUAD = 51;
  public static final int AV_CH_LAYOUT_STEREO = 3;
  public static final int AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736;
  public static final int AV_CH_LAYOUT_SURROUND = 7;
  public static final int AV_CH_LOW_FREQUENCY = 8;
  public static final int AV_CH_SIDE_LEFT = 512;
  public static final int AV_CH_SIDE_RIGHT = 1024;
  public static final int AV_CH_STEREO_LEFT = 536870912;
  public static final int AV_CH_STEREO_RIGHT = 1073741824;
  public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
  public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
  public static final int AV_CH_TOP_BACK_CENTER = 65536;
  public static final int AV_CH_TOP_BACK_LEFT = 32768;
  public static final int AV_CH_TOP_BACK_RIGHT = 131072;
  public static final int AV_CH_TOP_CENTER = 2048;
  public static final int AV_CH_TOP_FRONT_CENTER = 8192;
  public static final int AV_CH_TOP_FRONT_LEFT = 4096;
  public static final int AV_CH_TOP_FRONT_RIGHT = 16384;
  public static final long AV_CH_WIDE_LEFT = 2147483648L;
  public static final long AV_CH_WIDE_RIGHT = 4294967296L;
  public static final int AV_CLASS_CATEGORY_BITSTREAM_FILTER = 8;
  public static final int AV_CLASS_CATEGORY_DECODER = 6;
  public static final int AV_CLASS_CATEGORY_DEMUXER = 4;
  public static final int AV_CLASS_CATEGORY_ENCODER = 5;
  public static final int AV_CLASS_CATEGORY_FILTER = 7;
  public static final int AV_CLASS_CATEGORY_INPUT = 1;
  public static final int AV_CLASS_CATEGORY_MUXER = 3;
  public static final int AV_CLASS_CATEGORY_NA = 0;
  public static final int AV_CLASS_CATEGORY_OUTPUT = 2;
  public static final int AV_CLASS_CATEGORY_SWRESAMPLER = 10;
  public static final int AV_CLASS_CATEGORY_SWSCALER = 9;
  public static final int AV_CPU_FLAG_3DNOW = 4;
  public static final int AV_CPU_FLAG_3DNOWEXT = 32;
  public static final int AV_CPU_FLAG_ALTIVEC = 1;
  public static final int AV_CPU_FLAG_ARMV5TE = 1;
  public static final int AV_CPU_FLAG_ARMV6 = 2;
  public static final int AV_CPU_FLAG_ARMV6T2 = 4;
  public static final int AV_CPU_FLAG_ATOM = 268435456;
  public static final int AV_CPU_FLAG_AVX = 16384;
  public static final int AV_CPU_FLAG_CMOV = 4096;
  public static final int AV_CPU_FLAG_FMA4 = 2048;
  public static final int AV_CPU_FLAG_FORCE = Integer.MIN_VALUE;
  public static final int AV_CPU_FLAG_MMX = 1;
  public static final int AV_CPU_FLAG_MMXEXT = 2;
  public static final int AV_CPU_FLAG_NEON = 32;
  public static final int AV_CPU_FLAG_SSE = 8;
  public static final int AV_CPU_FLAG_SSE2 = 16;
  public static final int AV_CPU_FLAG_SSE2SLOW = 1073741824;
  public static final int AV_CPU_FLAG_SSE3 = 64;
  public static final int AV_CPU_FLAG_SSE3SLOW = 536870912;
  public static final int AV_CPU_FLAG_SSE4 = 256;
  public static final int AV_CPU_FLAG_SSE42 = 512;
  public static final int AV_CPU_FLAG_SSSE3 = 128;
  public static final int AV_CPU_FLAG_VFP = 8;
  public static final int AV_CPU_FLAG_VFPV3 = 16;
  public static final int AV_CPU_FLAG_XOP = 1024;
  public static final int AV_DICT_APPEND = 32;
  public static final int AV_DICT_DONT_OVERWRITE = 16;
  public static final int AV_DICT_DONT_STRDUP_KEY = 4;
  public static final int AV_DICT_DONT_STRDUP_VAL = 8;
  public static final int AV_DICT_IGNORE_SUFFIX = 2;
  public static final int AV_DICT_MATCH_CASE = 1;
  public static final int AV_ERROR_MAX_STRING_SIZE = 64;
  public static final int AV_LOG_DEBUG = 48;
  public static final int AV_LOG_ERROR = 16;
  public static final int AV_LOG_FATAL = 8;
  public static final int AV_LOG_INFO = 32;
  public static final int AV_LOG_MAX_OFFSET = 56;
  public static final int AV_LOG_PANIC = 0;
  public static final int AV_LOG_QUIET = -8;
  public static final int AV_LOG_SKIP_REPEATED = 1;
  public static final int AV_LOG_VERBOSE = 40;
  public static final int AV_LOG_WARNING = 24;
  public static final int AV_MATRIX_ENCODING_DOLBY = 1;
  public static final int AV_MATRIX_ENCODING_DPLII = 2;
  public static final int AV_MATRIX_ENCODING_NB = 3;
  public static final int AV_MATRIX_ENCODING_NONE = 0;
  public static final long AV_NOPTS_VALUE = Long.MIN_VALUE;
  public static final int AV_OPT_FLAG_IMPLICIT_KEY = 1;
  public static final int AV_OPT_SEARCH_CHILDREN = 1;
  public static final int AV_OPT_SEARCH_FAKE_OBJ = 2;
  public static final int AV_OPT_TYPE_BINARY = 7;
  public static final int AV_OPT_TYPE_CONST = 128;
  public static final int AV_OPT_TYPE_DOUBLE = 3;
  public static final int AV_OPT_TYPE_FLAGS = 0;
  public static final int AV_OPT_TYPE_FLOAT = 4;
  public static final int AV_OPT_TYPE_IMAGE_SIZE = 0;
  public static final int AV_OPT_TYPE_INT = 1;
  public static final int AV_OPT_TYPE_INT64 = 2;
  public static final int AV_OPT_TYPE_PIXEL_FMT = 0;
  public static final int AV_OPT_TYPE_RATIONAL = 6;
  public static final int AV_OPT_TYPE_SAMPLE_FMT = 0;
  public static final int AV_OPT_TYPE_STRING = 5;
  public static final int AV_PICTURE_TYPE_B = 4;
  public static final int AV_PICTURE_TYPE_BI = 8;
  public static final int AV_PICTURE_TYPE_I = 2;
  public static final int AV_PICTURE_TYPE_NONE = 0;
  public static final int AV_PICTURE_TYPE_P = 3;
  public static final int AV_PICTURE_TYPE_S = 5;
  public static final int AV_PICTURE_TYPE_SI = 6;
  public static final int AV_PICTURE_TYPE_SP = 7;
  public static final int AV_PIX_FMT_0BGR = 297;
  public static final int AV_PIX_FMT_0BGR32 = 0;
  public static final int AV_PIX_FMT_0RGB = 295;
  public static final int AV_PIX_FMT_0RGB32 = 0;
  public static final int AV_PIX_FMT_ABGR = 29;
  public static final int AV_PIX_FMT_ARGB = 27;
  public static final int AV_PIX_FMT_BGR0 = 298;
  public static final int AV_PIX_FMT_BGR24 = 3;
  public static final int AV_PIX_FMT_BGR32 = 0;
  public static final int AV_PIX_FMT_BGR32_1 = 0;
  public static final int AV_PIX_FMT_BGR4 = 20;
  public static final int AV_PIX_FMT_BGR444 = 0;
  public static final int AV_PIX_FMT_BGR444BE = 65;
  public static final int AV_PIX_FMT_BGR444LE = 64;
  public static final int AV_PIX_FMT_BGR48 = 0;
  public static final int AV_PIX_FMT_BGR48BE = 67;
  public static final int AV_PIX_FMT_BGR48LE = 68;
  public static final int AV_PIX_FMT_BGR4_BYTE = 21;
  public static final int AV_PIX_FMT_BGR555 = 0;
  public static final int AV_PIX_FMT_BGR555BE = 49;
  public static final int AV_PIX_FMT_BGR555LE = 50;
  public static final int AV_PIX_FMT_BGR565 = 0;
  public static final int AV_PIX_FMT_BGR565BE = 47;
  public static final int AV_PIX_FMT_BGR565LE = 48;
  public static final int AV_PIX_FMT_BGR8 = 19;
  public static final int AV_PIX_FMT_BGRA = 30;
  public static final int AV_PIX_FMT_BGRA64 = 0;
  public static final int AV_PIX_FMT_BGRA64BE = 293;
  public static final int AV_PIX_FMT_BGRA64LE = 294;
  public static final int AV_PIX_FMT_DXVA2_VLD = 61;
  public static final int AV_PIX_FMT_GBR24P = 82;
  public static final int AV_PIX_FMT_GBRP = 82;
  public static final int AV_PIX_FMT_GBRP10 = 0;
  public static final int AV_PIX_FMT_GBRP10BE = 85;
  public static final int AV_PIX_FMT_GBRP10LE = 86;
  public static final int AV_PIX_FMT_GBRP12 = 0;
  public static final int AV_PIX_FMT_GBRP12BE = 312;
  public static final int AV_PIX_FMT_GBRP12LE = 313;
  public static final int AV_PIX_FMT_GBRP14 = 0;
  public static final int AV_PIX_FMT_GBRP14BE = 314;
  public static final int AV_PIX_FMT_GBRP14LE = 315;
  public static final int AV_PIX_FMT_GBRP16 = 0;
  public static final int AV_PIX_FMT_GBRP16BE = 87;
  public static final int AV_PIX_FMT_GBRP16LE = 88;
  public static final int AV_PIX_FMT_GBRP9 = 0;
  public static final int AV_PIX_FMT_GBRP9BE = 83;
  public static final int AV_PIX_FMT_GBRP9LE = 84;
  public static final int AV_PIX_FMT_GRAY16 = 0;
  public static final int AV_PIX_FMT_GRAY16BE = 31;
  public static final int AV_PIX_FMT_GRAY16LE = 32;
  public static final int AV_PIX_FMT_GRAY8 = 8;
  public static final int AV_PIX_FMT_GRAY8A = 66;
  public static final int AV_PIX_FMT_MONOBLACK = 10;
  public static final int AV_PIX_FMT_MONOWHITE = 9;
  public static final int AV_PIX_FMT_NONE = -1;
  public static final int AV_PIX_FMT_NV12 = 25;
  public static final int AV_PIX_FMT_NV21 = 26;
  public static final int AV_PIX_FMT_PAL8 = 11;
  public static final int AV_PIX_FMT_RGB0 = 296;
  public static final int AV_PIX_FMT_RGB24 = 2;
  public static final int AV_PIX_FMT_RGB32 = 0;
  public static final int AV_PIX_FMT_RGB32_1 = 0;
  public static final int AV_PIX_FMT_RGB4 = 23;
  public static final int AV_PIX_FMT_RGB444 = 0;
  public static final int AV_PIX_FMT_RGB444BE = 63;
  public static final int AV_PIX_FMT_RGB444LE = 62;
  public static final int AV_PIX_FMT_RGB48 = 0;
  public static final int AV_PIX_FMT_RGB48BE = 41;
  public static final int AV_PIX_FMT_RGB48LE = 42;
  public static final int AV_PIX_FMT_RGB4_BYTE = 24;
  public static final int AV_PIX_FMT_RGB555 = 0;
  public static final int AV_PIX_FMT_RGB555BE = 45;
  public static final int AV_PIX_FMT_RGB555LE = 46;
  public static final int AV_PIX_FMT_RGB565 = 0;
  public static final int AV_PIX_FMT_RGB565BE = 43;
  public static final int AV_PIX_FMT_RGB565LE = 44;
  public static final int AV_PIX_FMT_RGB8 = 22;
  public static final int AV_PIX_FMT_RGBA = 28;
  public static final int AV_PIX_FMT_RGBA64 = 0;
  public static final int AV_PIX_FMT_RGBA64BE = 291;
  public static final int AV_PIX_FMT_RGBA64LE = 292;
  public static final int AV_PIX_FMT_UYVY422 = 17;
  public static final int AV_PIX_FMT_UYYVYY411 = 18;
  public static final int AV_PIX_FMT_VAAPI_IDCT = 52;
  public static final int AV_PIX_FMT_VAAPI_MOCO = 51;
  public static final int AV_PIX_FMT_VAAPI_VLD = 53;
  public static final int AV_PIX_FMT_VDA_VLD = 81;
  public static final int AV_PIX_FMT_VDPAU = 109;
  public static final int AV_PIX_FMT_VDPAU_H264 = 36;
  public static final int AV_PIX_FMT_VDPAU_MPEG1 = 37;
  public static final int AV_PIX_FMT_VDPAU_MPEG2 = 38;
  public static final int AV_PIX_FMT_VDPAU_MPEG4 = 60;
  public static final int AV_PIX_FMT_VDPAU_VC1 = 40;
  public static final int AV_PIX_FMT_VDPAU_WMV3 = 39;
  public static final int AV_PIX_FMT_XVMC_MPEG2_IDCT = 16;
  public static final int AV_PIX_FMT_XVMC_MPEG2_MC = 15;
  public static final int AV_PIX_FMT_Y400A = 66;
  public static final int AV_PIX_FMT_YUV410P = 6;
  public static final int AV_PIX_FMT_YUV411P = 7;
  public static final int AV_PIX_FMT_YUV420P = 0;
  public static final int AV_PIX_FMT_YUV420P10 = 0;
  public static final int AV_PIX_FMT_YUV420P10BE = 71;
  public static final int AV_PIX_FMT_YUV420P10LE = 72;
  public static final int AV_PIX_FMT_YUV420P12 = 0;
  public static final int AV_PIX_FMT_YUV420P12BE = 300;
  public static final int AV_PIX_FMT_YUV420P12LE = 301;
  public static final int AV_PIX_FMT_YUV420P14 = 0;
  public static final int AV_PIX_FMT_YUV420P14BE = 302;
  public static final int AV_PIX_FMT_YUV420P14LE = 303;
  public static final int AV_PIX_FMT_YUV420P16 = 0;
  public static final int AV_PIX_FMT_YUV420P16BE = 55;
  public static final int AV_PIX_FMT_YUV420P16LE = 54;
  public static final int AV_PIX_FMT_YUV420P9 = 0;
  public static final int AV_PIX_FMT_YUV420P9BE = 69;
  public static final int AV_PIX_FMT_YUV420P9LE = 70;
  public static final int AV_PIX_FMT_YUV422P = 4;
  public static final int AV_PIX_FMT_YUV422P10 = 0;
  public static final int AV_PIX_FMT_YUV422P10BE = 73;
  public static final int AV_PIX_FMT_YUV422P10LE = 74;
  public static final int AV_PIX_FMT_YUV422P12 = 0;
  public static final int AV_PIX_FMT_YUV422P12BE = 304;
  public static final int AV_PIX_FMT_YUV422P12LE = 305;
  public static final int AV_PIX_FMT_YUV422P14 = 0;
  public static final int AV_PIX_FMT_YUV422P14BE = 306;
  public static final int AV_PIX_FMT_YUV422P14LE = 307;
  public static final int AV_PIX_FMT_YUV422P16 = 0;
  public static final int AV_PIX_FMT_YUV422P16BE = 57;
  public static final int AV_PIX_FMT_YUV422P16LE = 56;
  public static final int AV_PIX_FMT_YUV422P9 = 0;
  public static final int AV_PIX_FMT_YUV422P9BE = 79;
  public static final int AV_PIX_FMT_YUV422P9LE = 80;
  public static final int AV_PIX_FMT_YUV440P = 33;
  public static final int AV_PIX_FMT_YUV444P = 5;
  public static final int AV_PIX_FMT_YUV444P10 = 0;
  public static final int AV_PIX_FMT_YUV444P10BE = 77;
  public static final int AV_PIX_FMT_YUV444P10LE = 78;
  public static final int AV_PIX_FMT_YUV444P12 = 0;
  public static final int AV_PIX_FMT_YUV444P12BE = 308;
  public static final int AV_PIX_FMT_YUV444P12LE = 309;
  public static final int AV_PIX_FMT_YUV444P14 = 0;
  public static final int AV_PIX_FMT_YUV444P14BE = 310;
  public static final int AV_PIX_FMT_YUV444P14LE = 311;
  public static final int AV_PIX_FMT_YUV444P16 = 0;
  public static final int AV_PIX_FMT_YUV444P16BE = 59;
  public static final int AV_PIX_FMT_YUV444P16LE = 58;
  public static final int AV_PIX_FMT_YUV444P9 = 0;
  public static final int AV_PIX_FMT_YUV444P9BE = 75;
  public static final int AV_PIX_FMT_YUV444P9LE = 76;
  public static final int AV_PIX_FMT_YUVA420P = 35;
  public static final int AV_PIX_FMT_YUVA420P10 = 0;
  public static final int AV_PIX_FMT_YUVA420P10BE = 97;
  public static final int AV_PIX_FMT_YUVA420P10LE = 98;
  public static final int AV_PIX_FMT_YUVA420P16 = 0;
  public static final int AV_PIX_FMT_YUVA420P16BE = 103;
  public static final int AV_PIX_FMT_YUVA420P16LE = 104;
  public static final int AV_PIX_FMT_YUVA420P9 = 0;
  public static final int AV_PIX_FMT_YUVA420P9BE = 91;
  public static final int AV_PIX_FMT_YUVA420P9LE = 92;
  public static final int AV_PIX_FMT_YUVA422P = 300;
  public static final int AV_PIX_FMT_YUVA422P10 = 0;
  public static final int AV_PIX_FMT_YUVA422P10BE = 99;
  public static final int AV_PIX_FMT_YUVA422P10LE = 100;
  public static final int AV_PIX_FMT_YUVA422P16 = 0;
  public static final int AV_PIX_FMT_YUVA422P16BE = 105;
  public static final int AV_PIX_FMT_YUVA422P16LE = 106;
  public static final int AV_PIX_FMT_YUVA422P9 = 0;
  public static final int AV_PIX_FMT_YUVA422P9BE = 93;
  public static final int AV_PIX_FMT_YUVA422P9LE = 94;
  public static final int AV_PIX_FMT_YUVA422P_LIBAV = 89;
  public static final int AV_PIX_FMT_YUVA444P = 299;
  public static final int AV_PIX_FMT_YUVA444P10 = 0;
  public static final int AV_PIX_FMT_YUVA444P10BE = 101;
  public static final int AV_PIX_FMT_YUVA444P10LE = 102;
  public static final int AV_PIX_FMT_YUVA444P16 = 0;
  public static final int AV_PIX_FMT_YUVA444P16BE = 107;
  public static final int AV_PIX_FMT_YUVA444P16LE = 108;
  public static final int AV_PIX_FMT_YUVA444P9 = 0;
  public static final int AV_PIX_FMT_YUVA444P9BE = 95;
  public static final int AV_PIX_FMT_YUVA444P9LE = 96;
  public static final int AV_PIX_FMT_YUVA444P_LIBAV = 90;
  public static final int AV_PIX_FMT_YUVJ420P = 12;
  public static final int AV_PIX_FMT_YUVJ422P = 13;
  public static final int AV_PIX_FMT_YUVJ440P = 34;
  public static final int AV_PIX_FMT_YUVJ444P = 14;
  public static final int AV_PIX_FMT_YUYV422 = 1;
  public static final int AV_ROUND_DOWN = 2;
  public static final int AV_ROUND_INF = 1;
  public static final int AV_ROUND_NEAR_INF = 5;
  public static final int AV_ROUND_PASS_MINMAX = 8192;
  public static final int AV_ROUND_UP = 3;
  public static final int AV_ROUND_ZERO = 0;
  public static final int AV_SAMPLE_FMT_DBL = 4;
  public static final int AV_SAMPLE_FMT_DBLP = 9;
  public static final int AV_SAMPLE_FMT_FLT = 3;
  public static final int AV_SAMPLE_FMT_FLTP = 8;
  public static final int AV_SAMPLE_FMT_NONE = -1;
  public static final int AV_SAMPLE_FMT_S16 = 1;
  public static final int AV_SAMPLE_FMT_S16P = 6;
  public static final int AV_SAMPLE_FMT_S32 = 2;
  public static final int AV_SAMPLE_FMT_S32P = 7;
  public static final int AV_SAMPLE_FMT_U8 = 0;
  public static final int AV_SAMPLE_FMT_U8P = 5;
  public static final int AV_TIME_BASE = 1000000;
  public static final AVRational AV_TIME_BASE_Q;
  public static final int FF_LAMBDA_MAX = 32767;
  public static final int FF_LAMBDA_SCALE = 128;
  public static final int FF_LAMBDA_SHIFT = 7;
  public static final int FF_QP2LAMBDA = 118;
  public static final int FF_QUALITY_SCALE = 128;
  public static final double INFINITY = 0.0D;
  public static final int LIBAVUTIL_BUILD = 0;
  public static final String LIBAVUTIL_IDENT;
  public static final String LIBAVUTIL_VERSION;
  public static final int LIBAVUTIL_VERSION_INT = 0;
  public static final int LIBAVUTIL_VERSION_MAJOR = 52;
  public static final int LIBAVUTIL_VERSION_MICRO = 100;
  public static final int LIBAVUTIL_VERSION_MINOR = 18;
  public static final double M_E = 2.718281828459045D;
  public static final double M_LN10 = 2.302585092994046D;
  public static final double M_LN2 = 0.6931471805599453D;
  public static final double M_LOG2_10 = 3.321928094887362D;
  public static final double M_PHI = 1.618033988749895D;
  public static final double M_PI = 3.141592653589793D;
  public static final double M_SQRT1_2 = 0.7071067811865476D;
  public static final double M_SQRT2 = 1.4142135623730951D;
  public static final double NAN = 0.0D;
  public static final String androidIncludepath = "../include/";
  public static final String androidLinkpath = "../lib/";
  public static final String genericIncludepath = "/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/";
  public static final String genericLinkpath = "/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/";
  public static final String windowsIncludepath = "C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/";
  public static final String windowsLinkpath = "C:/MinGW/local/lib/;C:/MinGW/lib/";
  public static final String windowsPreloadpath = "C:/MinGW/local/bin/;C:/MinGW/bin/";
  
  static
  {
    Loader.load();
    LIBAVUTIL_VERSION_INT = AV_VERSION_INT(52, 18, 100);
    LIBAVUTIL_VERSION = AV_VERSION(52, 18, 100);
    LIBAVUTIL_BUILD = LIBAVUTIL_VERSION_INT;
    LIBAVUTIL_IDENT = "Lavu" + LIBAVUTIL_VERSION;
    AVRational localAVRational;
    int i;
    label361:
    int j;
    label374:
    int k;
    label388:
    int m;
    label403:
    int n;
    label419:
    int i1;
    label435:
    int i2;
    label450:
    int i3;
    label465:
    int i4;
    label480:
    int i5;
    label495:
    int i6;
    label510:
    int i7;
    label525:
    int i8;
    label540:
    int i9;
    label555:
    int i10;
    label570:
    int i11;
    label585:
    int i12;
    label600:
    int i13;
    label615:
    int i14;
    label630:
    int i15;
    label645:
    int i16;
    label660:
    int i17;
    label676:
    int i18;
    label692:
    int i19;
    label708:
    int i20;
    label724:
    int i21;
    label740:
    int i22;
    label756:
    int i23;
    label771:
    int i24;
    label786:
    int i25;
    label801:
    int i26;
    label817:
    int i27;
    label833:
    int i28;
    label848:
    int i29;
    label863:
    int i30;
    label879:
    int i31;
    label895:
    int i32;
    label910:
    int i33;
    label925:
    int i34;
    label940:
    int i35;
    label955:
    int i36;
    label970:
    int i37;
    label985:
    int i38;
    label1000:
    int i39;
    label1015:
    int i40;
    if (Loader.load() == null)
    {
      localAVRational = null;
      AV_TIME_BASE_Q = localAVRational;
      AVERROR_BSF_NOT_FOUND = FFERRTAG(248, 66, 83, 70);
      AVERROR_BUG = FFERRTAG(66, 85, 71, 33);
      AVERROR_BUFFER_TOO_SMALL = FFERRTAG(66, 85, 70, 83);
      AVERROR_DECODER_NOT_FOUND = FFERRTAG(248, 68, 69, 67);
      AVERROR_DEMUXER_NOT_FOUND = FFERRTAG(248, 68, 69, 77);
      AVERROR_ENCODER_NOT_FOUND = FFERRTAG(248, 69, 78, 67);
      AVERROR_EOF = FFERRTAG(69, 79, 70, 32);
      AVERROR_EXIT = FFERRTAG(69, 88, 73, 84);
      AVERROR_EXTERNAL = FFERRTAG(69, 88, 84, 32);
      AVERROR_FILTER_NOT_FOUND = FFERRTAG(248, 70, 73, 76);
      AVERROR_INVALIDDATA = FFERRTAG(73, 78, 68, 65);
      AVERROR_MUXER_NOT_FOUND = FFERRTAG(248, 77, 85, 88);
      AVERROR_OPTION_NOT_FOUND = FFERRTAG(248, 79, 80, 84);
      AVERROR_PATCHWELCOME = FFERRTAG(80, 65, 87, 69);
      AVERROR_PROTOCOL_NOT_FOUND = FFERRTAG(248, 80, 82, 79);
      AVERROR_STREAM_NOT_FOUND = FFERRTAG(248, 83, 84, 82);
      AVERROR_BUG2 = FFERRTAG(66, 85, 71, 32);
      AVERROR_UNKNOWN = FFERRTAG(85, 78, 75, 78);
      NAN = Float.intBitsToFloat(2143289344);
      INFINITY = Float.intBitsToFloat(2139095040);
      if (!AV_HAVE_BIGENDIAN()) {
        break label1114;
      }
      i = 27;
      AV_PIX_FMT_RGB32 = i;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1120;
      }
      j = 28;
      AV_PIX_FMT_RGB32_1 = j;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1126;
      }
      k = 29;
      AV_PIX_FMT_BGR32 = k;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1133;
      }
      m = 30;
      AV_PIX_FMT_BGR32_1 = m;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1140;
      }
      n = 295;
      AV_PIX_FMT_0RGB32 = n;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1148;
      }
      i1 = 297;
      AV_PIX_FMT_0BGR32 = i1;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1156;
      }
      i2 = 31;
      AV_PIX_FMT_GRAY16 = i2;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1163;
      }
      i3 = 41;
      AV_PIX_FMT_RGB48 = i3;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1170;
      }
      i4 = 43;
      AV_PIX_FMT_RGB565 = i4;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1177;
      }
      i5 = 45;
      AV_PIX_FMT_RGB555 = i5;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1184;
      }
      i6 = 63;
      AV_PIX_FMT_RGB444 = i6;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1191;
      }
      i7 = 67;
      AV_PIX_FMT_BGR48 = i7;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1198;
      }
      i8 = 47;
      AV_PIX_FMT_BGR565 = i8;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1205;
      }
      i9 = 49;
      AV_PIX_FMT_BGR555 = i9;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1212;
      }
      i10 = 65;
      AV_PIX_FMT_BGR444 = i10;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1219;
      }
      i11 = 69;
      AV_PIX_FMT_YUV420P9 = i11;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1226;
      }
      i12 = 79;
      AV_PIX_FMT_YUV422P9 = i12;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1233;
      }
      i13 = 75;
      AV_PIX_FMT_YUV444P9 = i13;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1240;
      }
      i14 = 71;
      AV_PIX_FMT_YUV420P10 = i14;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1247;
      }
      i15 = 73;
      AV_PIX_FMT_YUV422P10 = i15;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1254;
      }
      i16 = 77;
      AV_PIX_FMT_YUV444P10 = i16;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1261;
      }
      i17 = 300;
      AV_PIX_FMT_YUV420P12 = i17;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1269;
      }
      i18 = 304;
      AV_PIX_FMT_YUV422P12 = i18;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1277;
      }
      i19 = 308;
      AV_PIX_FMT_YUV444P12 = i19;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1285;
      }
      i20 = 302;
      AV_PIX_FMT_YUV420P14 = i20;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1293;
      }
      i21 = 306;
      AV_PIX_FMT_YUV422P14 = i21;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1301;
      }
      i22 = 310;
      AV_PIX_FMT_YUV444P14 = i22;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1309;
      }
      i23 = 55;
      AV_PIX_FMT_YUV420P16 = i23;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1316;
      }
      i24 = 57;
      AV_PIX_FMT_YUV422P16 = i24;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1323;
      }
      i25 = 59;
      AV_PIX_FMT_YUV444P16 = i25;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1330;
      }
      i26 = 291;
      AV_PIX_FMT_RGBA64 = i26;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1338;
      }
      i27 = 293;
      AV_PIX_FMT_BGRA64 = i27;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1346;
      }
      i28 = 83;
      AV_PIX_FMT_GBRP9 = i28;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1353;
      }
      i29 = 85;
      AV_PIX_FMT_GBRP10 = i29;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1360;
      }
      i30 = 312;
      AV_PIX_FMT_GBRP12 = i30;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1368;
      }
      i31 = 314;
      AV_PIX_FMT_GBRP14 = i31;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1376;
      }
      i32 = 87;
      AV_PIX_FMT_GBRP16 = i32;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1383;
      }
      i33 = 91;
      AV_PIX_FMT_YUVA420P9 = i33;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1390;
      }
      i34 = 93;
      AV_PIX_FMT_YUVA422P9 = i34;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1397;
      }
      i35 = 95;
      AV_PIX_FMT_YUVA444P9 = i35;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1404;
      }
      i36 = 97;
      AV_PIX_FMT_YUVA420P10 = i36;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1411;
      }
      i37 = 99;
      AV_PIX_FMT_YUVA422P10 = i37;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1418;
      }
      i38 = 101;
      AV_PIX_FMT_YUVA444P10 = i38;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1425;
      }
      i39 = 103;
      AV_PIX_FMT_YUVA420P16 = i39;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1432;
      }
      i40 = 105;
      label1030:
      AV_PIX_FMT_YUVA422P16 = i40;
      if (!AV_HAVE_BIGENDIAN()) {
        break label1439;
      }
    }
    label1114:
    label1120:
    label1126:
    label1133:
    label1140:
    label1148:
    label1156:
    label1163:
    label1170:
    label1177:
    label1184:
    label1191:
    label1198:
    label1205:
    label1212:
    label1219:
    label1226:
    label1233:
    label1240:
    label1247:
    label1254:
    label1261:
    label1269:
    label1277:
    label1285:
    label1293:
    label1301:
    label1309:
    label1316:
    label1323:
    label1330:
    label1338:
    label1346:
    label1353:
    label1360:
    label1368:
    label1376:
    label1383:
    label1390:
    label1397:
    label1404:
    label1411:
    label1418:
    label1425:
    label1432:
    label1439:
    for (int i41 = 107;; i41 = 108)
    {
      AV_PIX_FMT_YUVA444P16 = i41;
      AV_OPT_TYPE_IMAGE_SIZE = MKBETAG(83, 73, 90, 69);
      AV_OPT_TYPE_PIXEL_FMT = MKBETAG(80, 70, 77, 84);
      AV_OPT_TYPE_SAMPLE_FMT = MKBETAG(83, 70, 77, 84);
      return;
      localAVRational = new AVRational().num(1).den(1000000);
      break;
      i = 30;
      break label361;
      j = 29;
      break label374;
      k = 28;
      break label388;
      m = 27;
      break label403;
      n = 297;
      break label419;
      i1 = 295;
      break label435;
      i2 = 32;
      break label450;
      i3 = 42;
      break label465;
      i4 = 44;
      break label480;
      i5 = 46;
      break label495;
      i6 = 62;
      break label510;
      i7 = 68;
      break label525;
      i8 = 48;
      break label540;
      i9 = 50;
      break label555;
      i10 = 64;
      break label570;
      i11 = 70;
      break label585;
      i12 = 80;
      break label600;
      i13 = 76;
      break label615;
      i14 = 72;
      break label630;
      i15 = 74;
      break label645;
      i16 = 78;
      break label660;
      i17 = 301;
      break label676;
      i18 = 305;
      break label692;
      i19 = 309;
      break label708;
      i20 = 303;
      break label724;
      i21 = 307;
      break label740;
      i22 = 311;
      break label756;
      i23 = 54;
      break label771;
      i24 = 56;
      break label786;
      i25 = 58;
      break label801;
      i26 = 292;
      break label817;
      i27 = 294;
      break label833;
      i28 = 84;
      break label848;
      i29 = 86;
      break label863;
      i30 = 313;
      break label879;
      i31 = 315;
      break label895;
      i32 = 88;
      break label910;
      i33 = 92;
      break label925;
      i34 = 94;
      break label940;
      i35 = 96;
      break label955;
      i36 = 98;
      break label970;
      i37 = 100;
      break label985;
      i38 = 102;
      break label1000;
      i39 = 104;
      break label1015;
      i40 = 106;
      break label1030;
    }
  }
  
  public static boolean AV_HAVE_BIGENDIAN()
  {
    return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
  }
  
  public static String AV_VERSION(int paramInt1, int paramInt2, int paramInt3)
  {
    return AV_VERSION_DOT(paramInt1, paramInt2, paramInt3);
  }
  
  public static String AV_VERSION_DOT(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 + "." + paramInt2 + "." + paramInt3;
  }
  
  public static int AV_VERSION_INT(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt3 | paramInt1 << 16 | paramInt2 << 8;
  }
  
  public static int FFERRTAG(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -MKTAG(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int MKBETAG(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4 | paramInt3 << 8 | paramInt2 << 16 | paramInt1 << 24;
  }
  
  public static int MKTAG(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 | paramInt2 << 8 | paramInt3 << 16 | paramInt4 << 24;
  }
  
  @ByVal
  public static native AVRational av_add_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
  
  public static native void av_bprint_channel_layout(AVBPrint paramAVBPrint, int paramInt, long paramLong);
  
  public static native Pointer av_calloc(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
  
  public static native long av_channel_layout_extract_channel(long paramLong, int paramInt);
  
  public static native int av_cmp_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
  
  public static native long av_compare_mod(@Cast({"uint64_t"}) long paramLong1, @Cast({"uint64_t"}) long paramLong2, @Cast({"uint64_t"}) long paramLong3);
  
  public static native int av_compare_ts(long paramLong1, @ByVal AVRational paramAVRational1, long paramLong2, @ByVal AVRational paramAVRational2);
  
  @ByVal
  public static native AVRational av_d2q(double paramDouble, int paramInt);
  
  @Cast({"AVClassCategory"})
  public static native int av_default_get_category(Pointer paramPointer);
  
  public static native String av_default_item_name(Pointer paramPointer);
  
  public static native void av_dict_copy(@ByPtrPtr AVDictionary paramAVDictionary1, AVDictionary paramAVDictionary2, int paramInt);
  
  public static native int av_dict_count(AVDictionary paramAVDictionary);
  
  public static native void av_dict_free(@ByPtrPtr AVDictionary paramAVDictionary);
  
  public static native AVDictionaryEntry av_dict_get(AVDictionary paramAVDictionary, String paramString, AVDictionaryEntry paramAVDictionaryEntry, int paramInt);
  
  public static native int av_dict_parse_string(@ByPtrPtr AVDictionary paramAVDictionary, String paramString1, String paramString2, String paramString3, int paramInt);
  
  public static native int av_dict_set(@ByPtrPtr AVDictionary paramAVDictionary, String paramString1, String paramString2, int paramInt);
  
  @ByVal
  public static native AVRational av_div_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
  
  public static native void av_dynarray_add(Pointer paramPointer1, int[] paramArrayOfInt, Pointer paramPointer2);
  
  public static native int av_find_nearest_q_idx(@ByVal AVRational paramAVRational1, AVRational paramAVRational2);
  
  public static native void av_force_cpu_flags(int paramInt);
  
  public static native void av_free(Pointer paramPointer);
  
  public static native void av_freep(Pointer paramPointer);
  
  public static native long av_gcd(long paramLong1, long paramLong2);
  
  @Cast({"AVSampleFormat"})
  public static native int av_get_alt_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
  
  public static native int av_get_bytes_per_sample(@Cast({"AVSampleFormat"}) int paramInt);
  
  public static native String av_get_channel_description(long paramLong);
  
  public static native long av_get_channel_layout(String paramString);
  
  public static native int av_get_channel_layout_channel_index(long paramLong1, long paramLong2);
  
  public static native int av_get_channel_layout_nb_channels(long paramLong);
  
  public static native void av_get_channel_layout_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, long paramLong);
  
  public static native String av_get_channel_name(long paramLong);
  
  public static native int av_get_cpu_flags();
  
  public static native long av_get_default_channel_layout(int paramInt);
  
  public static native String av_get_media_type_string(@Cast({"AVMediaType"}) int paramInt);
  
  @Cast({"AVSampleFormat"})
  public static native int av_get_packed_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt);
  
  @Cast({"char"})
  public static native int av_get_picture_type_char(@Cast({"AVPictureType"}) int paramInt);
  
  @Cast({"AVSampleFormat"})
  public static native int av_get_planar_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt);
  
  @Cast({"AVSampleFormat"})
  public static native int av_get_sample_fmt(String paramString);
  
  public static native String av_get_sample_fmt_name(@Cast({"AVSampleFormat"}) int paramInt);
  
  public static native String av_get_sample_fmt_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2);
  
  public static native int av_get_standard_channel_layout(@Cast({"unsigned"}) int paramInt, @Cast({"uint64_t*"}) long[] paramArrayOfLong, @ByPtrPtr @Cast({"const char**"}) BytePointer paramBytePointer);
  
  public static native int av_image_alloc(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4);
  
  public static native int av_image_check_size(@Cast({"unsigned"}) int paramInt1, @Cast({"unsigned"}) int paramInt2, int paramInt3, Pointer paramPointer);
  
  public static native void av_image_copy(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer1, int[] paramArrayOfInt1, @Cast({"const uint8_t **"}) PointerPointer paramPointerPointer2, int[] paramArrayOfInt2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native void av_image_copy_plane(@Cast({"uint8_t*"}) BytePointer paramBytePointer1, int paramInt1, @Cast({"uint8_t*"}) BytePointer paramBytePointer2, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int av_image_copy_to_buffer(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, @Cast({"const uint8_t * const*"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native int av_image_fill_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int av_image_fill_linesizes(int[] paramArrayOfInt, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
  
  public static native void av_image_fill_max_pixsteps(int[] paramArrayOfInt1, int[] paramArrayOfInt2, @Cast({"AVPixFmtDescriptor*"}) int[] paramArrayOfInt3);
  
  public static native int av_image_fill_pointers(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int[] paramArrayOfInt);
  
  public static native int av_image_get_buffer_size(@Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int av_image_get_linesize(@Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  @ByVal
  public static native AVRational av_inv_q(@ByVal AVRational paramAVRational);
  
  public static native void av_log(Pointer paramPointer, int paramInt, String paramString);
  
  public static native void av_log_default_callback(Pointer paramPointer1, int paramInt, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
  
  public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2, int[] paramArrayOfInt);
  
  public static native int av_log_get_level();
  
  public static native void av_log_set_callback(LogCallback paramLogCallback);
  
  public static native void av_log_set_flags(int paramInt);
  
  public static native void av_log_set_level(int paramInt);
  
  @Cast({"char*"})
  public static native BytePointer av_make_error_string(@Cast({"char*"}) BytePointer paramBytePointer, @Cast({"size_t"}) long paramLong, int paramInt);
  
  public static native Pointer av_malloc(@Cast({"size_t"}) long paramLong);
  
  public static native Pointer av_malloc_array(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
  
  public static native Pointer av_mallocz(@Cast({"size_t"}) long paramLong);
  
  public static native Pointer av_mallocz_array(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
  
  public static native void av_max_alloc(@Cast({"size_t"}) long paramLong);
  
  public static native void av_memcpy_backptr(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
  
  @ByVal
  public static native AVRational av_mul_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
  
  public static native int av_nearer_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2, @ByVal AVRational paramAVRational3);
  
  @Const
  public static native AVClass av_opt_child_class_next(AVClass paramAVClass1, AVClass paramAVClass2);
  
  public static native Pointer av_opt_child_next(Pointer paramPointer1, Pointer paramPointer2);
  
  public static native int av_opt_eval_double(Pointer paramPointer, AVOption paramAVOption, String paramString, double[] paramArrayOfDouble);
  
  public static native int av_opt_eval_flags(Pointer paramPointer, AVOption paramAVOption, String paramString, int[] paramArrayOfInt);
  
  public static native int av_opt_eval_float(Pointer paramPointer, AVOption paramAVOption, String paramString, float[] paramArrayOfFloat);
  
  public static native int av_opt_eval_int(Pointer paramPointer, AVOption paramAVOption, String paramString, int[] paramArrayOfInt);
  
  public static native int av_opt_eval_int64(Pointer paramPointer, AVOption paramAVOption, String paramString, long[] paramArrayOfLong);
  
  public static native int av_opt_eval_q(Pointer paramPointer, AVOption paramAVOption, String paramString, AVRational paramAVRational);
  
  @Const
  public static native AVOption av_opt_find(Pointer paramPointer, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  @Const
  public static native AVOption av_opt_find2(Pointer paramPointer, String paramString1, String paramString2, int paramInt1, int paramInt2, PointerPointer paramPointerPointer);
  
  public static native int av_opt_flag_is_set(Pointer paramPointer, String paramString1, String paramString2);
  
  public static native void av_opt_free(Pointer paramPointer);
  
  public static native void av_opt_freep_ranges(@ByPtrPtr AVOptionRanges paramAVOptionRanges);
  
  public static native int av_opt_get(Pointer paramPointer, String paramString, int paramInt, @ByPtrPtr @Cast({"uint8_t**"}) BytePointer paramBytePointer);
  
  public static native int av_opt_get_double(Pointer paramPointer, String paramString, int paramInt, double[] paramArrayOfDouble);
  
  public static native int av_opt_get_image_size(Pointer paramPointer, String paramString, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static native int av_opt_get_int(Pointer paramPointer, String paramString, int paramInt, long[] paramArrayOfLong);
  
  public static native int av_opt_get_key_value(@Cast({"const char**"}) PointerPointer paramPointerPointer1, String paramString1, String paramString2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer2, @Cast({"char**"}) PointerPointer paramPointerPointer3);
  
  public static native int av_opt_get_pixel_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVPixelFormat*"}) int[] paramArrayOfInt);
  
  public static native int av_opt_get_q(Pointer paramPointer, String paramString, int paramInt, AVRational paramAVRational);
  
  public static native int av_opt_get_sample_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVSampleFormat*"}) int[] paramArrayOfInt);
  
  @Const
  public static native AVOption av_opt_next(Pointer paramPointer, AVOption paramAVOption);
  
  public static native Pointer av_opt_ptr(AVClass paramAVClass, Pointer paramPointer, String paramString);
  
  public static native int av_opt_query_ranges(@ByPtrPtr AVOptionRanges paramAVOptionRanges, Pointer paramPointer, String paramString, int paramInt);
  
  public static native int av_opt_query_ranges_default(@ByPtrPtr AVOptionRanges paramAVOptionRanges, Pointer paramPointer, String paramString, int paramInt);
  
  public static native int av_opt_set(Pointer paramPointer, String paramString1, String paramString2, int paramInt);
  
  public static native int av_opt_set_bin(Pointer paramPointer, String paramString, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
  
  public static native void av_opt_set_defaults(Pointer paramPointer);
  
  public static native int av_opt_set_dict(Pointer paramPointer, @ByPtrPtr AVDictionary paramAVDictionary);
  
  public static native int av_opt_set_double(Pointer paramPointer, String paramString, double paramDouble, int paramInt);
  
  public static native int av_opt_set_from_string(Pointer paramPointer, String paramString1, @Cast({"const char *const *"}) PointerPointer paramPointerPointer, String paramString2, String paramString3);
  
  public static native int av_opt_set_image_size(Pointer paramPointer, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int av_opt_set_int(Pointer paramPointer, String paramString, long paramLong, int paramInt);
  
  public static native int av_opt_set_pixel_fmt(Pointer paramPointer, String paramString, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
  
  public static native int av_opt_set_q(Pointer paramPointer, String paramString, @ByVal AVRational paramAVRational, int paramInt);
  
  public static native int av_opt_set_sample_fmt(Pointer paramPointer, String paramString, @Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
  
  public static native int av_opt_show2(Pointer paramPointer1, Pointer paramPointer2, int paramInt1, int paramInt2);
  
  public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) int[] paramArrayOfInt, String paramString);
  
  @Deprecated
  public static native int av_parse_cpu_flags(String paramString);
  
  public static native double av_q2d(@ByVal AVRational paramAVRational);
  
  public static native Pointer av_realloc(Pointer paramPointer, @Cast({"size_t"}) long paramLong);
  
  public static native Pointer av_realloc_f(Pointer paramPointer, @Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
  
  public static native int av_reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2, long paramLong1, long paramLong2, long paramLong3);
  
  public static native long av_rescale(long paramLong1, long paramLong2, long paramLong3);
  
  public static native long av_rescale_delta(@ByVal AVRational paramAVRational1, long paramLong, @ByVal AVRational paramAVRational2, int paramInt, long[] paramArrayOfLong, @ByVal AVRational paramAVRational3);
  
  public static native long av_rescale_q(long paramLong, @ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
  
  public static native long av_rescale_q_rnd(long paramLong, @ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2, @Cast({"AVRounding"}) int paramInt);
  
  public static native long av_rescale_rnd(long paramLong1, long paramLong2, long paramLong3, @Cast({"AVRounding"}) int paramInt);
  
  public static native int av_sample_fmt_is_planar(@Cast({"AVSampleFormat"}) int paramInt);
  
  public static native int av_samples_alloc(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
  
  public static native int av_samples_copy(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer1, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5);
  
  public static native int av_samples_fill_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
  
  public static native int av_samples_get_buffer_size(int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
  
  public static native int av_samples_set_silence(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4);
  
  public static native int av_set_options_string(Pointer paramPointer, String paramString1, String paramString2, String paramString3);
  
  public static native int av_size_mult(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, SizeTPointer paramSizeTPointer);
  
  @Cast({"char*"})
  public static native BytePointer av_strdup(String paramString);
  
  public static native int av_strerror(int paramInt, @Cast({"char*"}) byte[] paramArrayOfByte, @Cast({"size_t"}) long paramLong);
  
  @ByVal
  public static native AVRational av_sub_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
  
  public static native void av_vlog(Pointer paramPointer1, int paramInt, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
  
  public static native Pointer av_x_if_null(Pointer paramPointer1, Pointer paramPointer2);
  
  public static native int avpriv_set_systematic_pal2(@Cast({"uint32_t*"}) int[] paramArrayOfInt, @Cast({"AVPixelFormat"}) int paramInt);
  
  public static native String avutil_configuration();
  
  public static native String avutil_license();
  
  @Cast({"unsigned"})
  public static native int avutil_version();
  
  @Opaque
  public static class AVBPrint
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVBPrint() {}
    
    public AVBPrint(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVClass
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVClass()
    {
      allocate();
    }
    
    public AVClass(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVClass(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"AVClassCategory"})
    public native int category();
    
    public native AVClass category(int paramInt);
    
    public native Child_class_next child_class_next();
    
    public native AVClass child_class_next(Child_class_next paramChild_class_next);
    
    public native Child_next child_next();
    
    public native AVClass child_next(Child_next paramChild_next);
    
    @Cast({"const char*"})
    public native BytePointer class_name();
    
    public native AVClass class_name(BytePointer paramBytePointer);
    
    public native Get_category get_category();
    
    public native AVClass get_category(Get_category paramGet_category);
    
    public native Item_name item_name();
    
    public native AVClass item_name(Item_name paramItem_name);
    
    public native int log_level_offset_offset();
    
    public native AVClass log_level_offset_offset(int paramInt);
    
    public native AVClass option(AVOption paramAVOption);
    
    @Const
    public native avutil.AVOption option();
    
    public native int parent_log_context_offset();
    
    public native AVClass parent_log_context_offset(int paramInt);
    
    public AVClass position(int paramInt)
    {
      return (AVClass)super.position(paramInt);
    }
    
    public native Query_ranges query_ranges();
    
    public native AVClass query_ranges(Query_ranges paramQuery_ranges);
    
    public native int version();
    
    public native AVClass version(int paramInt);
    
    public static class Child_class_next
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Child_class_next()
      {
        allocate();
      }
      
      public Child_class_next(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      @Const
      public native avutil.AVClass call(@Const avutil.AVClass paramAVClass);
    }
    
    public static class Child_next
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Child_next()
      {
        allocate();
      }
      
      public Child_next(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native Pointer call(Pointer paramPointer1, Pointer paramPointer2);
    }
    
    public static class Get_category
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Get_category()
      {
        allocate();
      }
      
      public Get_category(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      @Cast({"AVClassCategory"})
      public native int call(Pointer paramPointer);
    }
    
    public static class Item_name
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Item_name()
      {
        allocate();
      }
      
      public Item_name(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      @Cast({"const char*"})
      public native BytePointer call(Pointer paramPointer);
    }
    
    public static class Query_ranges
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Query_ranges()
      {
        allocate();
      }
      
      public Query_ranges(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(@ByPtrPtr avutil.AVOptionRanges paramAVOptionRanges, Pointer paramPointer1, @Cast({"const char *"}) Pointer paramPointer2, int paramInt);
    }
  }
  
  @Opaque
  public static class AVDictionary
    extends Pointer
  {
    public AVDictionary() {}
    
    public AVDictionary(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVDictionaryEntry
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVDictionaryEntry()
    {
      allocate();
    }
    
    public AVDictionaryEntry(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVDictionaryEntry(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"char*"})
    public native BytePointer key();
    
    public native AVDictionaryEntry key(BytePointer paramBytePointer);
    
    public AVDictionaryEntry position(int paramInt)
    {
      return (AVDictionaryEntry)super.position(paramInt);
    }
    
    @Cast({"char*"})
    public native BytePointer value();
    
    public native AVDictionaryEntry value(BytePointer paramBytePointer);
  }
  
  public static class AVOption
    extends Pointer
  {
    public static final int AV_OPT_FLAG_AUDIO_PARAM = 8;
    public static final int AV_OPT_FLAG_DECODING_PARAM = 2;
    public static final int AV_OPT_FLAG_ENCODING_PARAM = 1;
    public static final int AV_OPT_FLAG_FILTERING_PARAM = 65536;
    public static final int AV_OPT_FLAG_METADATA = 4;
    public static final int AV_OPT_FLAG_SUBTITLE_PARAM = 32;
    public static final int AV_OPT_FLAG_VIDEO_PARAM = 16;
    
    static
    {
      Loader.load();
    }
    
    public AVOption()
    {
      allocate();
    }
    
    public AVOption(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVOption(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Name({"default_val.dbl"})
    public native double default_val_dbl();
    
    public native AVOption default_val_dbl(double paramDouble);
    
    @Name({"default_val.i64"})
    public native long default_val_i64();
    
    public native AVOption default_val_i64(long paramLong);
    
    public native AVOption default_val_q(AVRational paramAVRational);
    
    @ByVal
    @Name({"default_val.q"})
    public native avutil.AVRational default_val_q();
    
    @Cast({"const char*"})
    @Name({"default_val.str"})
    public native BytePointer default_val_str();
    
    public native AVOption default_val_str(BytePointer paramBytePointer);
    
    public native int flags();
    
    public native AVOption flags(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer help();
    
    public native AVOption help(BytePointer paramBytePointer);
    
    public native double max();
    
    public native AVOption max(double paramDouble);
    
    public native double min();
    
    public native AVOption min(double paramDouble);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVOption name(BytePointer paramBytePointer);
    
    public native int offset();
    
    public native AVOption offset(int paramInt);
    
    public AVOption position(int paramInt)
    {
      return (AVOption)super.position(paramInt);
    }
    
    @Cast({"AVOptionType"})
    public native int type();
    
    public native AVOption type(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer unit();
    
    public native AVOption unit(BytePointer paramBytePointer);
  }
  
  public static class AVOptionRange
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVOptionRange()
    {
      allocate();
    }
    
    public AVOptionRange(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVOptionRange(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double component_max();
    
    public native AVOptionRange component_max(double paramDouble);
    
    public native double component_min();
    
    public native AVOptionRange component_min(double paramDouble);
    
    public native int is_range();
    
    public native AVOptionRange is_range(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer str();
    
    public native AVOptionRange str(BytePointer paramBytePointer);
    
    public native double value_max();
    
    public native AVOptionRange value_max(double paramDouble);
    
    public native double value_min();
    
    public native AVOptionRange value_min(double paramDouble);
  }
  
  public static class AVOptionRanges
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVOptionRanges()
    {
      allocate();
    }
    
    public AVOptionRanges(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVOptionRanges(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int nb_ranges();
    
    public native AVOptionRanges nb_ranges(int paramInt);
    
    public native AVOptionRange range(int paramInt);
    
    public native AVOptionRanges range(int paramInt, AVOptionRange paramAVOptionRange);
  }
  
  public static class AVRational
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVRational()
    {
      allocate();
    }
    
    public AVRational(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVRational(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int den();
    
    public native AVRational den(int paramInt);
    
    public native int num();
    
    public native AVRational num(int paramInt);
    
    public AVRational position(int paramInt)
    {
      return (AVRational)super.position(paramInt);
    }
  }
  
  public static class LogCallback
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected LogCallback()
    {
      allocate();
    }
    
    public LogCallback(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(Pointer paramPointer1, int paramInt, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\avutil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */