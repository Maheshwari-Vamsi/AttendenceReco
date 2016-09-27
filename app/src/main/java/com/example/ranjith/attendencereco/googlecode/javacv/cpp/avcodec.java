package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;
import java.nio.Buffer;
import java.nio.ShortBuffer;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavcodec/avcodec.h>", "<libavcodec/avfft.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"avcodec@.54", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(cinclude={"<libavcodec/vaapi.h>", "<libavcodec/vdpau.h>", "<libavcodec/xvmc.h>", "<libavcodec/avcodec.h>", "<libavcodec/avfft.h>"}, value={"linux", "freebsd", "solaris", "sunos"}), @com.googlecode.javacpp.annotation.Platform(cinclude={"<DShow.h>", "<d3d9.h>", "<vmr9.h>", "<evr9.h>", "<libavcodec/dxva2.h>", "<libavcodec/avcodec.h>", "<libavcodec/avfft.h>"}, includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"avcodec-54"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class avcodec
{
  public static final int AVCHROMA_LOC_BOTTOM = 6;
  public static final int AVCHROMA_LOC_BOTTOMLEFT = 5;
  public static final int AVCHROMA_LOC_CENTER = 2;
  public static final int AVCHROMA_LOC_LEFT = 1;
  public static final int AVCHROMA_LOC_TOP = 4;
  public static final int AVCHROMA_LOC_TOPLEFT = 3;
  public static final int AVCHROMA_LOC_UNSPECIFIED = 0;
  public static final int AVCOL_PRI_BT470BG = 5;
  public static final int AVCOL_PRI_BT470M = 4;
  public static final int AVCOL_PRI_BT709 = 1;
  public static final int AVCOL_PRI_FILM = 8;
  public static final int AVCOL_PRI_SMPTE170M = 6;
  public static final int AVCOL_PRI_SMPTE240M = 7;
  public static final int AVCOL_PRI_UNSPECIFIED = 2;
  public static final int AVCOL_RANGE_JPEG = 2;
  public static final int AVCOL_RANGE_MPEG = 1;
  public static final int AVCOL_RANGE_UNSPECIFIED = 0;
  public static final int AVCOL_SPC_BT470BG = 5;
  public static final int AVCOL_SPC_BT709 = 1;
  public static final int AVCOL_SPC_FCC = 4;
  public static final int AVCOL_SPC_RGB = 0;
  public static final int AVCOL_SPC_SMPTE170M = 6;
  public static final int AVCOL_SPC_SMPTE240M = 7;
  public static final int AVCOL_SPC_UNSPECIFIED = 2;
  public static final int AVCOL_SPC_YCGCO = 8;
  public static final int AVCOL_SPC_YCOCG = 8;
  public static final int AVCOL_TRC_BT709 = 1;
  public static final int AVCOL_TRC_GAMMA22 = 4;
  public static final int AVCOL_TRC_GAMMA28 = 5;
  public static final int AVCOL_TRC_SMPTE240M = 7;
  public static final int AVCOL_TRC_UNSPECIFIED = 2;
  public static final int AVDISCARD_ALL = 48;
  public static final int AVDISCARD_BIDIR = 16;
  public static final int AVDISCARD_DEFAULT = 0;
  public static final int AVDISCARD_NONE = -16;
  public static final int AVDISCARD_NONKEY = 32;
  public static final int AVDISCARD_NONREF = 8;
  public static final int AV_AUDIO_SERVICE_TYPE_COMMENTARY = 5;
  public static final int AV_AUDIO_SERVICE_TYPE_DIALOGUE = 4;
  public static final int AV_AUDIO_SERVICE_TYPE_EFFECTS = 1;
  public static final int AV_AUDIO_SERVICE_TYPE_EMERGENCY = 6;
  public static final int AV_AUDIO_SERVICE_TYPE_HEARING_IMPAIRED = 3;
  public static final int AV_AUDIO_SERVICE_TYPE_KARAOKE = 8;
  public static final int AV_AUDIO_SERVICE_TYPE_MAIN = 0;
  public static final int AV_AUDIO_SERVICE_TYPE_VISUALLY_IMPAIRED = 2;
  public static final int AV_AUDIO_SERVICE_TYPE_VOICE_OVER = 7;
  public static final int AV_CODEC_ID_012V = 0;
  public static final int AV_CODEC_ID_4XM = 35;
  public static final int AV_CODEC_ID_8BPS = 49;
  public static final int AV_CODEC_ID_8SVX_EXP = 86071;
  public static final int AV_CODEC_ID_8SVX_FIB = 86072;
  public static final int AV_CODEC_ID_8SVX_RAW = 0;
  public static final int AV_CODEC_ID_A64_MULTI = 145;
  public static final int AV_CODEC_ID_A64_MULTI5 = 146;
  public static final int AV_CODEC_ID_AAC = 86018;
  public static final int AV_CODEC_ID_AAC_LATM = 86066;
  public static final int AV_CODEC_ID_AASC = 76;
  public static final int AV_CODEC_ID_AC3 = 86019;
  public static final int AV_CODEC_ID_ADPCM_4XM = 69639;
  public static final int AV_CODEC_ID_ADPCM_ADX = 69641;
  public static final int AV_CODEC_ID_ADPCM_AFC = 0;
  public static final int AV_CODEC_ID_ADPCM_CT = 69644;
  public static final int AV_CODEC_ID_ADPCM_EA = 69642;
  public static final int AV_CODEC_ID_ADPCM_EA_MAXIS_XA = 69658;
  public static final int AV_CODEC_ID_ADPCM_EA_R1 = 69652;
  public static final int AV_CODEC_ID_ADPCM_EA_R2 = 69654;
  public static final int AV_CODEC_ID_ADPCM_EA_R3 = 69653;
  public static final int AV_CODEC_ID_ADPCM_EA_XAS = 69657;
  public static final int AV_CODEC_ID_ADPCM_G722 = 69660;
  public static final int AV_CODEC_ID_ADPCM_G726 = 69643;
  public static final int AV_CODEC_ID_ADPCM_IMA_AMV = 69651;
  public static final int AV_CODEC_ID_ADPCM_IMA_APC = 69661;
  public static final int AV_CODEC_ID_ADPCM_IMA_DK3 = 69634;
  public static final int AV_CODEC_ID_ADPCM_IMA_DK4 = 69635;
  public static final int AV_CODEC_ID_ADPCM_IMA_EA_EACS = 69656;
  public static final int AV_CODEC_ID_ADPCM_IMA_EA_SEAD = 69655;
  public static final int AV_CODEC_ID_ADPCM_IMA_ISS = 69659;
  public static final int AV_CODEC_ID_ADPCM_IMA_OKI = 0;
  public static final int AV_CODEC_ID_ADPCM_IMA_QT = 69632;
  public static final int AV_CODEC_ID_ADPCM_IMA_SMJPEG = 69637;
  public static final int AV_CODEC_ID_ADPCM_IMA_WAV = 69633;
  public static final int AV_CODEC_ID_ADPCM_IMA_WS = 69636;
  public static final int AV_CODEC_ID_ADPCM_MS = 69638;
  public static final int AV_CODEC_ID_ADPCM_SBPRO_2 = 69649;
  public static final int AV_CODEC_ID_ADPCM_SBPRO_3 = 69648;
  public static final int AV_CODEC_ID_ADPCM_SBPRO_4 = 69647;
  public static final int AV_CODEC_ID_ADPCM_SWF = 69645;
  public static final int AV_CODEC_ID_ADPCM_THP = 69650;
  public static final int AV_CODEC_ID_ADPCM_XA = 69640;
  public static final int AV_CODEC_ID_ADPCM_YAMAHA = 69646;
  public static final int AV_CODEC_ID_ALAC = 86032;
  public static final int AV_CODEC_ID_AMR_NB = 73728;
  public static final int AV_CODEC_ID_AMR_WB = 73729;
  public static final int AV_CODEC_ID_AMV = 109;
  public static final int AV_CODEC_ID_ANM = 136;
  public static final int AV_CODEC_ID_ANSI = 144;
  public static final int AV_CODEC_ID_APE = 86049;
  public static final int AV_CODEC_ID_ASV1 = 32;
  public static final int AV_CODEC_ID_ASV2 = 33;
  public static final int AV_CODEC_ID_ATRAC1 = 86063;
  public static final int AV_CODEC_ID_ATRAC3 = 86047;
  public static final int AV_CODEC_ID_ATRAC3P = 86056;
  public static final int AV_CODEC_ID_AURA = 125;
  public static final int AV_CODEC_ID_AURA2 = 126;
  public static final int AV_CODEC_ID_AVRN = 0;
  public static final int AV_CODEC_ID_AVRP = 0;
  public static final int AV_CODEC_ID_AVS = 84;
  public static final int AV_CODEC_ID_AVUI = 0;
  public static final int AV_CODEC_ID_AYUV = 0;
  public static final int AV_CODEC_ID_BETHSOFTVID = 105;
  public static final int AV_CODEC_ID_BFI = 119;
  public static final int AV_CODEC_ID_BINKAUDIO_DCT = 86065;
  public static final int AV_CODEC_ID_BINKAUDIO_RDFT = 86064;
  public static final int AV_CODEC_ID_BINKVIDEO = 137;
  public static final int AV_CODEC_ID_BINTEXT = 0;
  public static final int AV_CODEC_ID_BMP = 80;
  public static final int AV_CODEC_ID_BMV_AUDIO = 86073;
  public static final int AV_CODEC_ID_BMV_VIDEO = 156;
  public static final int AV_CODEC_ID_BRENDER_PIX = 0;
  public static final int AV_CODEC_ID_C93 = 104;
  public static final int AV_CODEC_ID_CAVS = 89;
  public static final int AV_CODEC_ID_CDGRAPHICS = 134;
  public static final int AV_CODEC_ID_CDXL = 161;
  public static final int AV_CODEC_ID_CELT = 86068;
  public static final int AV_CODEC_ID_CINEPAK = 44;
  public static final int AV_CODEC_ID_CLJR = 37;
  public static final int AV_CODEC_ID_CLLC = 168;
  public static final int AV_CODEC_ID_CMV = 120;
  public static final int AV_CODEC_ID_COMFORT_NOISE = 86078;
  public static final int AV_CODEC_ID_COOK = 86036;
  public static final int AV_CODEC_ID_CPIA = 0;
  public static final int AV_CODEC_ID_CSCD = 81;
  public static final int AV_CODEC_ID_CYUV = 27;
  public static final int AV_CODEC_ID_DFA = 152;
  public static final int AV_CODEC_ID_DIRAC = 118;
  public static final int AV_CODEC_ID_DNXHD = 101;
  public static final int AV_CODEC_ID_DPX = 130;
  public static final int AV_CODEC_ID_DSICINAUDIO = 86042;
  public static final int AV_CODEC_ID_DSICINVIDEO = 96;
  public static final int AV_CODEC_ID_DTS = 86020;
  public static final int AV_CODEC_ID_DVAUDIO = 86022;
  public static final int AV_CODEC_ID_DVB_SUBTITLE = 94209;
  public static final int AV_CODEC_ID_DVB_TELETEXT = 94215;
  public static final int AV_CODEC_ID_DVD_SUBTITLE = 94208;
  public static final int AV_CODEC_ID_DVVIDEO = 25;
  public static final int AV_CODEC_ID_DXA = 100;
  public static final int AV_CODEC_ID_DXTORY = 158;
  public static final int AV_CODEC_ID_EAC3 = 86057;
  public static final int AV_CODEC_ID_EIA_608 = 0;
  public static final int AV_CODEC_ID_ESCAPE124 = 117;
  public static final int AV_CODEC_ID_ESCAPE130 = 0;
  public static final int AV_CODEC_ID_EVRC = 0;
  public static final int AV_CODEC_ID_EXR = 0;
  public static final int AV_CODEC_ID_FFMETADATA = 135168;
  public static final int AV_CODEC_ID_FFV1 = 34;
  public static final int AV_CODEC_ID_FFVHUFF = 69;
  public static final int AV_CODEC_ID_FFWAVESYNTH = 0;
  public static final int AV_CODEC_ID_FIRST_AUDIO = 65536;
  public static final int AV_CODEC_ID_FIRST_SUBTITLE = 94208;
  public static final int AV_CODEC_ID_FIRST_UNKNOWN = 98304;
  public static final int AV_CODEC_ID_FLAC = 86028;
  public static final int AV_CODEC_ID_FLASHSV = 88;
  public static final int AV_CODEC_ID_FLASHSV2 = 133;
  public static final int AV_CODEC_ID_FLIC = 51;
  public static final int AV_CODEC_ID_FLV1 = 22;
  public static final int AV_CODEC_ID_FRAPS = 78;
  public static final int AV_CODEC_ID_FRWU = 132;
  public static final int AV_CODEC_ID_G2M = 0;
  public static final int AV_CODEC_ID_G723_1 = 86069;
  public static final int AV_CODEC_ID_G729 = 86070;
  public static final int AV_CODEC_ID_GIF = 99;
  public static final int AV_CODEC_ID_GSM = 86034;
  public static final int AV_CODEC_ID_GSM_MS = 86046;
  public static final int AV_CODEC_ID_H261 = 4;
  public static final int AV_CODEC_ID_H263 = 5;
  public static final int AV_CODEC_ID_H263I = 21;
  public static final int AV_CODEC_ID_H263P = 20;
  public static final int AV_CODEC_ID_H264 = 28;
  public static final int AV_CODEC_ID_HDMV_PGS_SUBTITLE = 94214;
  public static final int AV_CODEC_ID_HUFFYUV = 26;
  public static final int AV_CODEC_ID_IAC = 86075;
  public static final int AV_CODEC_ID_IDCIN = 48;
  public static final int AV_CODEC_ID_IDF = avutil.MKBETAG(0, 73, 68, 70);
  public static final int AV_CODEC_ID_IFF_BYTERUN1 = 139;
  public static final int AV_CODEC_ID_IFF_ILBM = 138;
  public static final int AV_CODEC_ID_ILBC = 86076;
  public static final int AV_CODEC_ID_IMC = 86043;
  public static final int AV_CODEC_ID_INDEO2 = 77;
  public static final int AV_CODEC_ID_INDEO3 = 29;
  public static final int AV_CODEC_ID_INDEO4 = 113;
  public static final int AV_CODEC_ID_INDEO5 = 114;
  public static final int AV_CODEC_ID_INTERPLAY_DPCM = 81921;
  public static final int AV_CODEC_ID_INTERPLAY_VIDEO = 40;
  public static final int AV_CODEC_ID_JACOSUB = 0;
  public static final int AV_CODEC_ID_JPEG2000 = 90;
  public static final int AV_CODEC_ID_JPEGLS = 12;
  public static final int AV_CODEC_ID_JV = 151;
  public static final int AV_CODEC_ID_KGV1 = 140;
  public static final int AV_CODEC_ID_KMVC = 87;
  public static final int AV_CODEC_ID_LAGARITH = 149;
  public static final int AV_CODEC_ID_LJPEG = 10;
  public static final int AV_CODEC_ID_LOCO = 74;
  public static final int AV_CODEC_ID_MACE3 = 86025;
  public static final int AV_CODEC_ID_MACE6 = 86026;
  public static final int AV_CODEC_ID_MAD = 131;
  public static final int AV_CODEC_ID_MDEC = 38;
  public static final int AV_CODEC_ID_MICRODVD = 0;
  public static final int AV_CODEC_ID_MIMIC = 115;
  public static final int AV_CODEC_ID_MJPEG = 8;
  public static final int AV_CODEC_ID_MJPEGB = 9;
  public static final int AV_CODEC_ID_MLP = 86045;
  public static final int AV_CODEC_ID_MMVIDEO = 82;
  public static final int AV_CODEC_ID_MOTIONPIXELS = 121;
  public static final int AV_CODEC_ID_MOV_TEXT = 94213;
  public static final int AV_CODEC_ID_MP1 = 86059;
  public static final int AV_CODEC_ID_MP2 = 86016;
  public static final int AV_CODEC_ID_MP3 = 86017;
  public static final int AV_CODEC_ID_MP3ADU = 86029;
  public static final int AV_CODEC_ID_MP3ON4 = 86030;
  public static final int AV_CODEC_ID_MP4ALS = 86062;
  public static final int AV_CODEC_ID_MPEG1VIDEO = 1;
  public static final int AV_CODEC_ID_MPEG2TS = 131072;
  public static final int AV_CODEC_ID_MPEG2VIDEO = 2;
  public static final int AV_CODEC_ID_MPEG2VIDEO_XVMC = 3;
  public static final int AV_CODEC_ID_MPEG4 = 13;
  public static final int AV_CODEC_ID_MPEG4SYSTEMS = 131073;
  public static final int AV_CODEC_ID_MPL2 = 0;
  public static final int AV_CODEC_ID_MSA1 = 165;
  public static final int AV_CODEC_ID_MSMPEG4V1 = 15;
  public static final int AV_CODEC_ID_MSMPEG4V2 = 16;
  public static final int AV_CODEC_ID_MSMPEG4V3 = 17;
  public static final int AV_CODEC_ID_MSRLE = 46;
  public static final int AV_CODEC_ID_MSS1 = 164;
  public static final int AV_CODEC_ID_MSS2 = 170;
  public static final int AV_CODEC_ID_MSVIDEO1 = 47;
  public static final int AV_CODEC_ID_MSZH = 54;
  public static final int AV_CODEC_ID_MTS2 = 167;
  public static final int AV_CODEC_ID_MUSEPACK7 = 86044;
  public static final int AV_CODEC_ID_MUSEPACK8 = 86051;
  public static final int AV_CODEC_ID_MVC1 = 0;
  public static final int AV_CODEC_ID_MVC2 = 0;
  public static final int AV_CODEC_ID_MXPEG = 148;
  public static final int AV_CODEC_ID_NELLYMOSER = 86050;
  public static final int AV_CODEC_ID_NONE = 0;
  public static final int AV_CODEC_ID_NUV = 86;
  public static final int AV_CODEC_ID_OPUS = 0;
  public static final int AV_CODEC_ID_OPUS_DEPRECATED = 86077;
  public static final int AV_CODEC_ID_OTF = avutil.MKBETAG(0, 79, 84, 70);
  public static final int AV_CODEC_ID_PAF_AUDIO = 0;
  public static final int AV_CODEC_ID_PAF_VIDEO = 0;
  public static final int AV_CODEC_ID_PAM = 68;
  public static final int AV_CODEC_ID_PBM = 65;
  public static final int AV_CODEC_ID_PCM_ALAW = 65543;
  public static final int AV_CODEC_ID_PCM_BLURAY = 65560;
  public static final int AV_CODEC_ID_PCM_DVD = 65555;
  public static final int AV_CODEC_ID_PCM_F32BE = 65556;
  public static final int AV_CODEC_ID_PCM_F32LE = 65557;
  public static final int AV_CODEC_ID_PCM_F64BE = 65558;
  public static final int AV_CODEC_ID_PCM_F64LE = 65559;
  public static final int AV_CODEC_ID_PCM_LXF = 65561;
  public static final int AV_CODEC_ID_PCM_MULAW = 65542;
  public static final int AV_CODEC_ID_PCM_S16BE = 65537;
  public static final int AV_CODEC_ID_PCM_S16BE_PLANAR = 0;
  public static final int AV_CODEC_ID_PCM_S16LE = 65536;
  public static final int AV_CODEC_ID_PCM_S16LE_PLANAR = 65554;
  public static final int AV_CODEC_ID_PCM_S24BE = 65549;
  public static final int AV_CODEC_ID_PCM_S24DAUD = 65552;
  public static final int AV_CODEC_ID_PCM_S24LE = 65548;
  public static final int AV_CODEC_ID_PCM_S24LE_PLANAR = 0;
  public static final int AV_CODEC_ID_PCM_S32BE = 65545;
  public static final int AV_CODEC_ID_PCM_S32LE = 65544;
  public static final int AV_CODEC_ID_PCM_S32LE_PLANAR = 0;
  public static final int AV_CODEC_ID_PCM_S8 = 65540;
  public static final int AV_CODEC_ID_PCM_S8_PLANAR = 65562;
  public static final int AV_CODEC_ID_PCM_U16BE = 65539;
  public static final int AV_CODEC_ID_PCM_U16LE = 65538;
  public static final int AV_CODEC_ID_PCM_U24BE = 65551;
  public static final int AV_CODEC_ID_PCM_U24LE = 65550;
  public static final int AV_CODEC_ID_PCM_U32BE = 65547;
  public static final int AV_CODEC_ID_PCM_U32LE = 65546;
  public static final int AV_CODEC_ID_PCM_U8 = 65541;
  public static final int AV_CODEC_ID_PCM_ZORK = 65553;
  public static final int AV_CODEC_ID_PCX = 111;
  public static final int AV_CODEC_ID_PGM = 66;
  public static final int AV_CODEC_ID_PGMYUV = 67;
  public static final int AV_CODEC_ID_PICTOR = 143;
  public static final int AV_CODEC_ID_PJS = 0;
  public static final int AV_CODEC_ID_PNG = 63;
  public static final int AV_CODEC_ID_PPM = 64;
  public static final int AV_CODEC_ID_PROBE = 102400;
  public static final int AV_CODEC_ID_PRORES = 150;
  public static final int AV_CODEC_ID_PTX = 106;
  public static final int AV_CODEC_ID_QCELP = 86040;
  public static final int AV_CODEC_ID_QDM2 = 86035;
  public static final int AV_CODEC_ID_QDMC = 86067;
  public static final int AV_CODEC_ID_QDRAW = 60;
  public static final int AV_CODEC_ID_QPEG = 62;
  public static final int AV_CODEC_ID_QTRLE = 56;
  public static final int AV_CODEC_ID_R10K = 147;
  public static final int AV_CODEC_ID_R210 = 135;
  public static final int AV_CODEC_ID_RALF = 86074;
  public static final int AV_CODEC_ID_RAWVIDEO = 14;
  public static final int AV_CODEC_ID_RA_144 = 77824;
  public static final int AV_CODEC_ID_RA_288 = 77825;
  public static final int AV_CODEC_ID_REALTEXT = 0;
  public static final int AV_CODEC_ID_RL2 = 116;
  public static final int AV_CODEC_ID_ROQ = 39;
  public static final int AV_CODEC_ID_ROQ_DPCM = 81920;
  public static final int AV_CODEC_ID_RPZA = 43;
  public static final int AV_CODEC_ID_RV10 = 6;
  public static final int AV_CODEC_ID_RV20 = 7;
  public static final int AV_CODEC_ID_RV30 = 70;
  public static final int AV_CODEC_ID_RV40 = 71;
  public static final int AV_CODEC_ID_S302M = 65562;
  public static final int AV_CODEC_ID_SAMI = 0;
  public static final int AV_CODEC_ID_SANM = 0;
  public static final int AV_CODEC_ID_SGI = 103;
  public static final int AV_CODEC_ID_SGIRLE = 0;
  public static final int AV_CODEC_ID_SHORTEN = 86031;
  public static final int AV_CODEC_ID_SIPR = 86058;
  public static final int AV_CODEC_ID_SMACKAUDIO = 86039;
  public static final int AV_CODEC_ID_SMACKVIDEO = 85;
  public static final int AV_CODEC_ID_SMC = 50;
  public static final int AV_CODEC_ID_SMPTE_KLV = avutil.MKBETAG(75, 76, 86, 65);
  public static final int AV_CODEC_ID_SMV = 0;
  public static final int AV_CODEC_ID_SNOW = 57;
  public static final int AV_CODEC_ID_SOL_DPCM = 81923;
  public static final int AV_CODEC_ID_SONIC = 0;
  public static final int AV_CODEC_ID_SONIC_LS = 0;
  public static final int AV_CODEC_ID_SP5X = 11;
  public static final int AV_CODEC_ID_SPEEX = 86052;
  public static final int AV_CODEC_ID_SRT = 94216;
  public static final int AV_CODEC_ID_SSA = 94212;
  public static final int AV_CODEC_ID_SUBRIP = 0;
  public static final int AV_CODEC_ID_SUBVIEWER = 0;
  public static final int AV_CODEC_ID_SUBVIEWER1 = 0;
  public static final int AV_CODEC_ID_SUNRAST = 112;
  public static final int AV_CODEC_ID_SVQ1 = 23;
  public static final int AV_CODEC_ID_SVQ3 = 24;
  public static final int AV_CODEC_ID_TAK = 0;
  public static final int AV_CODEC_ID_TAK_DEPRECATED = 86079;
  public static final int AV_CODEC_ID_TARGA = 95;
  public static final int AV_CODEC_ID_TARGA_Y216 = 0;
  public static final int AV_CODEC_ID_TEXT = 94210;
  public static final int AV_CODEC_ID_TGQ = 123;
  public static final int AV_CODEC_ID_TGV = 122;
  public static final int AV_CODEC_ID_THEORA = 31;
  public static final int AV_CODEC_ID_THP = 102;
  public static final int AV_CODEC_ID_TIERTEXSEQVIDEO = 97;
  public static final int AV_CODEC_ID_TIFF = 98;
  public static final int AV_CODEC_ID_TMV = 128;
  public static final int AV_CODEC_ID_TQI = 124;
  public static final int AV_CODEC_ID_TRUEHD = 86061;
  public static final int AV_CODEC_ID_TRUEMOTION1 = 52;
  public static final int AV_CODEC_ID_TRUEMOTION2 = 79;
  public static final int AV_CODEC_ID_TRUESPEECH = 86037;
  public static final int AV_CODEC_ID_TSCC = 58;
  public static final int AV_CODEC_ID_TSCC2 = 166;
  public static final int AV_CODEC_ID_TTA = 86038;
  public static final int AV_CODEC_ID_TTF = 98304;
  public static final int AV_CODEC_ID_TWINVQ = 86060;
  public static final int AV_CODEC_ID_TXD = 107;
  public static final int AV_CODEC_ID_ULTI = 59;
  public static final int AV_CODEC_ID_UTVIDEO = 155;
  public static final int AV_CODEC_ID_V210 = 129;
  public static final int AV_CODEC_ID_V210X = 127;
  public static final int AV_CODEC_ID_V308 = 0;
  public static final int AV_CODEC_ID_V408 = 0;
  public static final int AV_CODEC_ID_V410 = 159;
  public static final int AV_CODEC_ID_VB = 110;
  public static final int AV_CODEC_ID_VBLE = 157;
  public static final int AV_CODEC_ID_VC1 = 72;
  public static final int AV_CODEC_ID_VC1IMAGE = 154;
  public static final int AV_CODEC_ID_VCR1 = 36;
  public static final int AV_CODEC_ID_VIMA = 0;
  public static final int AV_CODEC_ID_VIXL = 61;
  public static final int AV_CODEC_ID_VMDAUDIO = 86027;
  public static final int AV_CODEC_ID_VMDVIDEO = 53;
  public static final int AV_CODEC_ID_VMNC = 91;
  public static final int AV_CODEC_ID_VORBIS = 86021;
  public static final int AV_CODEC_ID_VOXWARE = 86048;
  public static final int AV_CODEC_ID_VP3 = 30;
  public static final int AV_CODEC_ID_VP5 = 92;
  public static final int AV_CODEC_ID_VP6 = 93;
  public static final int AV_CODEC_ID_VP6A = 108;
  public static final int AV_CODEC_ID_VP6F = 94;
  public static final int AV_CODEC_ID_VP8 = 142;
  public static final int AV_CODEC_ID_VP9 = 169;
  public static final int AV_CODEC_ID_VPLAYER = 0;
  public static final int AV_CODEC_ID_WAVPACK = 86041;
  public static final int AV_CODEC_ID_WEBVTT = 0;
  public static final int AV_CODEC_ID_WESTWOOD_SND1 = 86033;
  public static final int AV_CODEC_ID_WMALOSSLESS = 86055;
  public static final int AV_CODEC_ID_WMAPRO = 86054;
  public static final int AV_CODEC_ID_WMAV1 = 86023;
  public static final int AV_CODEC_ID_WMAV2 = 86024;
  public static final int AV_CODEC_ID_WMAVOICE = 86053;
  public static final int AV_CODEC_ID_WMV1 = 18;
  public static final int AV_CODEC_ID_WMV2 = 19;
  public static final int AV_CODEC_ID_WMV3 = 73;
  public static final int AV_CODEC_ID_WMV3IMAGE = 153;
  public static final int AV_CODEC_ID_WNV1 = 75;
  public static final int AV_CODEC_ID_WS_VQA = 45;
  public static final int AV_CODEC_ID_XAN_DPCM = 81922;
  public static final int AV_CODEC_ID_XAN_WC3 = 41;
  public static final int AV_CODEC_ID_XAN_WC4 = 42;
  public static final int AV_CODEC_ID_XBIN = 0;
  public static final int AV_CODEC_ID_XBM = 162;
  public static final int AV_CODEC_ID_XFACE = 0;
  public static final int AV_CODEC_ID_XSUB = 94211;
  public static final int AV_CODEC_ID_XWD = 160;
  public static final int AV_CODEC_ID_Y41P = 0;
  public static final int AV_CODEC_ID_YOP = 141;
  public static final int AV_CODEC_ID_YUV4 = 0;
  public static final int AV_CODEC_ID_ZEROCODEC = 163;
  public static final int AV_CODEC_ID_ZLIB = 55;
  public static final int AV_CODEC_ID_ZMBV = 83;
  public static final int AV_CODEC_PROP_BITMAP_SUB = 65536;
  public static final int AV_CODEC_PROP_INTRA_ONLY = 1;
  public static final int AV_CODEC_PROP_LOSSLESS = 4;
  public static final int AV_CODEC_PROP_LOSSY = 2;
  public static final int AV_FIELD_BB = 3;
  public static final int AV_FIELD_BT = 5;
  public static final int AV_FIELD_PROGRESSIVE = 1;
  public static final int AV_FIELD_TB = 4;
  public static final int AV_FIELD_TT = 2;
  public static final int AV_FIELD_UNKNOWN = 0;
  public static final int AV_LOCK_CREATE = 0;
  public static final int AV_LOCK_DESTROY = 3;
  public static final int AV_LOCK_OBTAIN = 1;
  public static final int AV_LOCK_RELEASE = 2;
  public static final int AV_PKT_DATA_H263_MB_INFO = 3;
  public static final int AV_PKT_DATA_JP_DUALMONO = 71;
  public static final int AV_PKT_DATA_MATROSKA_BLOCKADDITIONAL = 74;
  public static final int AV_PKT_DATA_NEW_EXTRADATA = 1;
  public static final int AV_PKT_DATA_PALETTE = 0;
  public static final int AV_PKT_DATA_PARAM_CHANGE = 2;
  public static final int AV_PKT_DATA_SKIP_SAMPLES = 70;
  public static final int AV_PKT_DATA_STRINGS_METADATA = 72;
  public static final int AV_PKT_DATA_SUBTITLE_POSITION = 73;
  public static final int AV_PKT_FLAG_CORRUPT = 2;
  public static final int AV_PKT_FLAG_KEY = 1;
  public static final int AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_COUNT = 1;
  public static final int AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_LAYOUT = 2;
  public static final int AV_SIDE_DATA_PARAM_CHANGE_DIMENSIONS = 8;
  public static final int AV_SIDE_DATA_PARAM_CHANGE_SAMPLE_RATE = 4;
  public static final int AV_SUBTITLE_FLAG_FORCED = 1;
  public static final int CODEC_CAP_AUTO_THREADS = 32768;
  public static final int CODEC_CAP_CHANNEL_CONF = 1024;
  public static final int CODEC_CAP_DELAY = 32;
  public static final int CODEC_CAP_DR1 = 2;
  public static final int CODEC_CAP_DRAW_HORIZ_BAND = 1;
  public static final int CODEC_CAP_EXPERIMENTAL = 512;
  public static final int CODEC_CAP_FRAME_THREADS = 4096;
  public static final int CODEC_CAP_HWACCEL = 16;
  public static final int CODEC_CAP_HWACCEL_VDPAU = 128;
  public static final int CODEC_CAP_INTRA_ONLY = 1073741824;
  public static final int CODEC_CAP_LOSSLESS = Integer.MIN_VALUE;
  public static final int CODEC_CAP_NEG_LINESIZES = 2048;
  public static final int CODEC_CAP_PARAM_CHANGE = 16384;
  public static final int CODEC_CAP_SLICE_THREADS = 8192;
  public static final int CODEC_CAP_SMALL_LAST_FRAME = 64;
  public static final int CODEC_CAP_SUBFRAMES = 256;
  public static final int CODEC_CAP_TRUNCATED = 8;
  public static final int CODEC_CAP_VARIABLE_FRAME_SIZE = 65536;
  public static final int CODEC_FLAG2_CHUNKS = 32768;
  public static final int CODEC_FLAG2_DROP_FRAME_TIMECODE = 8192;
  public static final int CODEC_FLAG2_FAST = 1;
  public static final int CODEC_FLAG2_IGNORE_CROP = 65536;
  public static final int CODEC_FLAG2_LOCAL_HEADER = 8;
  public static final int CODEC_FLAG2_NO_OUTPUT = 4;
  public static final int CODEC_FLAG2_SHOW_ALL = 4194304;
  public static final int CODEC_FLAG2_SKIP_RD = 16384;
  public static final int CODEC_FLAG2_STRICT_GOP = 2;
  public static final int CODEC_FLAG_4MV = 4;
  public static final int CODEC_FLAG_AC_PRED = 16777216;
  public static final int CODEC_FLAG_BITEXACT = 8388608;
  public static final int CODEC_FLAG_CBP_RD = 67108864;
  public static final int CODEC_FLAG_CLOSED_GOP = Integer.MIN_VALUE;
  public static final int CODEC_FLAG_EMU_EDGE = 16384;
  public static final int CODEC_FLAG_GLOBAL_HEADER = 4194304;
  public static final int CODEC_FLAG_GMC = 32;
  public static final int CODEC_FLAG_GRAY = 8192;
  public static final int CODEC_FLAG_INPUT_PRESERVED = 256;
  public static final int CODEC_FLAG_INTERLACED_DCT = 262144;
  public static final int CODEC_FLAG_INTERLACED_ME = 536870912;
  public static final int CODEC_FLAG_LOOP_FILTER = 2048;
  public static final int CODEC_FLAG_LOW_DELAY = 524288;
  public static final int CODEC_FLAG_MV0 = 64;
  public static final int CODEC_FLAG_NORMALIZE_AQP = 131072;
  public static final int CODEC_FLAG_PASS1 = 512;
  public static final int CODEC_FLAG_PASS2 = 1024;
  public static final int CODEC_FLAG_PSNR = 32768;
  public static final int CODEC_FLAG_QPEL = 16;
  public static final int CODEC_FLAG_QP_RD = 134217728;
  public static final int CODEC_FLAG_QSCALE = 2;
  public static final int CODEC_FLAG_TRUNCATED = 65536;
  public static final int FF_BUFFER_HINTS_PRESERVE = 4;
  public static final int FF_BUFFER_HINTS_READABLE = 2;
  public static final int FF_BUFFER_HINTS_REUSABLE = 8;
  public static final int FF_BUFFER_HINTS_VALID = 1;
  public static final int FF_BUFFER_TYPE_COPY = 8;
  public static final int FF_BUFFER_TYPE_INTERNAL = 1;
  public static final int FF_BUFFER_TYPE_SHARED = 4;
  public static final int FF_BUFFER_TYPE_USER = 2;
  public static final int FF_INPUT_BUFFER_PADDING_SIZE = 16;
  public static final int FF_LOSS_ALPHA = 8;
  public static final int FF_LOSS_CHROMA = 32;
  public static final int FF_LOSS_COLORQUANT = 16;
  public static final int FF_LOSS_COLORSPACE = 4;
  public static final int FF_LOSS_DEPTH = 2;
  public static final int FF_LOSS_RESOLUTION = 1;
  public static final int FF_MAX_B_FRAMES = 16;
  public static final int FF_MIN_BUFFER_SIZE = 16384;
  public static final int FF_QSCALE_TYPE_H264 = 2;
  public static final int FF_QSCALE_TYPE_MPEG1 = 0;
  public static final int FF_QSCALE_TYPE_MPEG2 = 1;
  public static final int FF_QSCALE_TYPE_VP56 = 3;
  public static final int LIBAVCODEC_BUILD = 0;
  public static final String LIBAVCODEC_IDENT;
  public static final String LIBAVCODEC_VERSION;
  public static final int LIBAVCODEC_VERSION_INT = 0;
  public static final int LIBAVCODEC_VERSION_MAJOR = 54;
  public static final int LIBAVCODEC_VERSION_MICRO = 100;
  public static final int LIBAVCODEC_VERSION_MINOR = 92;
  public static final int MB_TYPE_16x16 = 8;
  public static final int MB_TYPE_16x8 = 16;
  public static final int MB_TYPE_8x16 = 32;
  public static final int MB_TYPE_8x8 = 64;
  public static final int MB_TYPE_ACPRED = 512;
  public static final int MB_TYPE_CBP = 131072;
  public static final int MB_TYPE_DIRECT2 = 256;
  public static final int MB_TYPE_GMC = 1024;
  public static final int MB_TYPE_INTERLACED = 128;
  public static final int MB_TYPE_INTRA16x16 = 2;
  public static final int MB_TYPE_INTRA4x4 = 1;
  public static final int MB_TYPE_INTRA_PCM = 4;
  public static final int MB_TYPE_L0 = 12288;
  public static final int MB_TYPE_L0L1 = 61440;
  public static final int MB_TYPE_L1 = 49152;
  public static final int MB_TYPE_P0L0 = 4096;
  public static final int MB_TYPE_P0L1 = 16384;
  public static final int MB_TYPE_P1L0 = 8192;
  public static final int MB_TYPE_P1L1 = 32768;
  public static final int MB_TYPE_QUANT = 65536;
  public static final int MB_TYPE_SKIP = 2048;
  public static final int ME_EPZS = 5;
  public static final int ME_FULL = 2;
  public static final int ME_HEX = 7;
  public static final int ME_ITER = 9;
  public static final int ME_LOG = 3;
  public static final int ME_PHODS = 4;
  public static final int ME_TESA = 10;
  public static final int ME_UMH = 8;
  public static final int ME_X1 = 6;
  public static final int ME_ZERO = 1;
  public static final int SUBTITLE_ASS = 3;
  public static final int SUBTITLE_BITMAP = 1;
  public static final int SUBTITLE_NONE = 0;
  public static final int SUBTITLE_TEXT = 2;
  
  static
  {
    Loader.load(avutil.class);
    Loader.load();
    LIBAVCODEC_VERSION_INT = avutil.AV_VERSION_INT(54, 92, 100);
    LIBAVCODEC_VERSION = avutil.AV_VERSION(54, 92, 100);
    LIBAVCODEC_BUILD = LIBAVCODEC_VERSION_INT;
    LIBAVCODEC_IDENT = "Lavc" + LIBAVCODEC_VERSION;
    AV_CODEC_ID_BRENDER_PIX = avutil.MKBETAG(66, 80, 73, 88);
    AV_CODEC_ID_Y41P = avutil.MKBETAG(89, 52, 49, 80);
    AV_CODEC_ID_ESCAPE130 = avutil.MKBETAG(69, 49, 51, 48);
    AV_CODEC_ID_EXR = avutil.MKBETAG(48, 69, 88, 82);
    AV_CODEC_ID_AVRP = avutil.MKBETAG(65, 86, 82, 80);
    AV_CODEC_ID_012V = avutil.MKBETAG(48, 49, 50, 86);
    AV_CODEC_ID_G2M = avutil.MKBETAG(0, 71, 50, 77);
    AV_CODEC_ID_AVUI = avutil.MKBETAG(65, 86, 85, 73);
    AV_CODEC_ID_AYUV = avutil.MKBETAG(65, 89, 85, 86);
    AV_CODEC_ID_TARGA_Y216 = avutil.MKBETAG(84, 50, 49, 54);
    AV_CODEC_ID_V308 = avutil.MKBETAG(86, 51, 48, 56);
    AV_CODEC_ID_V408 = avutil.MKBETAG(86, 52, 48, 56);
    AV_CODEC_ID_YUV4 = avutil.MKBETAG(89, 85, 86, 52);
    AV_CODEC_ID_SANM = avutil.MKBETAG(83, 65, 78, 77);
    AV_CODEC_ID_PAF_VIDEO = avutil.MKBETAG(80, 65, 70, 86);
    AV_CODEC_ID_AVRN = avutil.MKBETAG(65, 86, 82, 110);
    AV_CODEC_ID_CPIA = avutil.MKBETAG(67, 80, 73, 65);
    AV_CODEC_ID_XFACE = avutil.MKBETAG(88, 70, 65, 67);
    AV_CODEC_ID_SGIRLE = avutil.MKBETAG(83, 71, 73, 82);
    AV_CODEC_ID_MVC1 = avutil.MKBETAG(77, 86, 67, 49);
    AV_CODEC_ID_MVC2 = avutil.MKBETAG(77, 86, 67, 50);
    AV_CODEC_ID_PCM_S24LE_PLANAR = avutil.MKBETAG(24, 80, 83, 80);
    AV_CODEC_ID_PCM_S32LE_PLANAR = avutil.MKBETAG(32, 80, 83, 80);
    AV_CODEC_ID_PCM_S16BE_PLANAR = avutil.MKBETAG(80, 83, 80, 16);
    AV_CODEC_ID_VIMA = avutil.MKBETAG(86, 73, 77, 65);
    AV_CODEC_ID_ADPCM_AFC = avutil.MKBETAG(65, 70, 67, 32);
    AV_CODEC_ID_ADPCM_IMA_OKI = avutil.MKBETAG(79, 75, 73, 32);
    AV_CODEC_ID_FFWAVESYNTH = avutil.MKBETAG(70, 70, 87, 83);
    AV_CODEC_ID_8SVX_RAW = avutil.MKBETAG(56, 83, 86, 88);
    AV_CODEC_ID_SONIC = avutil.MKBETAG(83, 79, 78, 67);
    AV_CODEC_ID_SONIC_LS = avutil.MKBETAG(83, 79, 78, 76);
    AV_CODEC_ID_PAF_AUDIO = avutil.MKBETAG(80, 65, 70, 65);
    AV_CODEC_ID_OPUS = avutil.MKBETAG(79, 80, 85, 83);
    AV_CODEC_ID_TAK = avutil.MKBETAG(116, 66, 97, 75);
    AV_CODEC_ID_EVRC = avutil.MKBETAG(115, 101, 118, 99);
    AV_CODEC_ID_SMV = avutil.MKBETAG(115, 115, 109, 118);
    AV_CODEC_ID_MICRODVD = avutil.MKBETAG(109, 68, 86, 68);
    AV_CODEC_ID_EIA_608 = avutil.MKBETAG(99, 54, 48, 56);
    AV_CODEC_ID_JACOSUB = avutil.MKBETAG(74, 83, 85, 66);
    AV_CODEC_ID_SAMI = avutil.MKBETAG(83, 65, 77, 73);
    AV_CODEC_ID_REALTEXT = avutil.MKBETAG(82, 84, 88, 84);
    AV_CODEC_ID_SUBVIEWER1 = avutil.MKBETAG(83, 98, 86, 49);
    AV_CODEC_ID_SUBVIEWER = avutil.MKBETAG(83, 117, 98, 86);
    AV_CODEC_ID_SUBRIP = avutil.MKBETAG(83, 82, 105, 112);
    AV_CODEC_ID_WEBVTT = avutil.MKBETAG(87, 86, 84, 84);
    AV_CODEC_ID_MPL2 = avutil.MKBETAG(77, 80, 76, 50);
    AV_CODEC_ID_VPLAYER = avutil.MKBETAG(86, 80, 108, 114);
    AV_CODEC_ID_PJS = avutil.MKBETAG(80, 104, 74, 83);
    AV_CODEC_ID_BINTEXT = avutil.MKBETAG(66, 84, 88, 84);
    AV_CODEC_ID_XBIN = avutil.MKBETAG(88, 66, 73, 78);
  }
  
  @Deprecated
  public static native int audio_resample(ReSampleContext paramReSampleContext, @Cast({"short*"}) Pointer paramPointer1, @Cast({"short*"}) Pointer paramPointer2, int paramInt);
  
  @Deprecated
  public static native int audio_resample(ReSampleContext paramReSampleContext, ShortPointer paramShortPointer1, ShortPointer paramShortPointer2, int paramInt);
  
  @Deprecated
  public static native int audio_resample(ReSampleContext paramReSampleContext, @Cast({"short*"}) Buffer paramBuffer1, @Cast({"short*"}) Buffer paramBuffer2, int paramInt);
  
  @Deprecated
  public static native int audio_resample(ReSampleContext paramReSampleContext, ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2, int paramInt);
  
  @Deprecated
  public static native int audio_resample(ReSampleContext paramReSampleContext, @Cast({"short*"}) byte[] paramArrayOfByte1, @Cast({"short*"}) byte[] paramArrayOfByte2, int paramInt);
  
  @Deprecated
  public static native int audio_resample(ReSampleContext paramReSampleContext, short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt);
  
  @Deprecated
  public static native void audio_resample_close(ReSampleContext paramReSampleContext);
  
  @Deprecated
  public static native ReSampleContext av_audio_resample_init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5, @Cast({"AVSampleFormat"}) int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble);
  
  public static native void av_bitstream_filter_close(AVBitStreamFilterContext paramAVBitStreamFilterContext);
  
  public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, String paramString, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
  
  public static native AVBitStreamFilterContext av_bitstream_filter_init(String paramString);
  
  public static native AVBitStreamFilter av_bitstream_filter_next(AVBitStreamFilter paramAVBitStreamFilter);
  
  @Const
  public static native AVCodecDescriptor av_codec_get_codec_descriptor(AVCodecContext paramAVCodecContext);
  
  @ByVal
  public static native avutil.AVRational av_codec_get_pkt_timebase(AVCodecContext paramAVCodecContext);
  
  public static native int av_codec_is_decoder(AVCodec paramAVCodec);
  
  public static native int av_codec_is_encoder(AVCodec paramAVCodec);
  
  public static native AVCodec av_codec_next(AVCodec paramAVCodec);
  
  public static native void av_codec_set_codec_descriptor(AVCodecContext paramAVCodecContext, AVCodecDescriptor paramAVCodecDescriptor);
  
  public static native void av_codec_set_pkt_timebase(AVCodecContext paramAVCodecContext, @ByVal avutil.AVRational paramAVRational);
  
  public static native int av_copy_packet(AVPacket paramAVPacket1, AVPacket paramAVPacket2);
  
  public static native void av_destruct_packet(AVPacket paramAVPacket);
  
  public static native int av_dup_packet(AVPacket paramAVPacket);
  
  public static native void av_fast_malloc(Pointer paramPointer, @Cast({"unsigned*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
  
  public static native void av_fast_padded_malloc(Pointer paramPointer, @Cast({"unsigned*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
  
  public static native void av_fast_padded_mallocz(Pointer paramPointer, @Cast({"unsigned*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
  
  public static native Pointer av_fast_realloc(Pointer paramPointer, @Cast({"unsigned*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
  
  public static native long av_frame_get_best_effort_timestamp(AVFrame paramAVFrame);
  
  public static native long av_frame_get_channel_layout(AVFrame paramAVFrame);
  
  public static native int av_frame_get_channels(AVFrame paramAVFrame);
  
  public static native int av_frame_get_decode_error_flags(AVFrame paramAVFrame);
  
  public static native avutil.AVDictionary av_frame_get_metadata(AVFrame paramAVFrame);
  
  public static native long av_frame_get_pkt_duration(AVFrame paramAVFrame);
  
  public static native long av_frame_get_pkt_pos(AVFrame paramAVFrame);
  
  public static native int av_frame_get_pkt_size(AVFrame paramAVFrame);
  
  public static native int av_frame_get_sample_rate(AVFrame paramAVFrame);
  
  public static native void av_frame_set_best_effort_timestamp(AVFrame paramAVFrame, long paramLong);
  
  public static native void av_frame_set_channel_layout(AVFrame paramAVFrame, long paramLong);
  
  public static native void av_frame_set_channels(AVFrame paramAVFrame, int paramInt);
  
  public static native void av_frame_set_decode_error_flags(AVFrame paramAVFrame, int paramInt);
  
  public static native void av_frame_set_metadata(AVFrame paramAVFrame, avutil.AVDictionary paramAVDictionary);
  
  public static native void av_frame_set_pkt_duration(AVFrame paramAVFrame, long paramLong);
  
  public static native void av_frame_set_pkt_pos(AVFrame paramAVFrame, long paramLong);
  
  public static native void av_frame_set_pkt_size(AVFrame paramAVFrame, int paramInt);
  
  public static native void av_frame_set_sample_rate(AVFrame paramAVFrame, int paramInt);
  
  public static native void av_free_packet(AVPacket paramAVPacket);
  
  public static native int av_get_audio_frame_duration(AVCodecContext paramAVCodecContext, int paramInt);
  
  public static native int av_get_bits_per_sample(@Cast({"AVCodecID"}) int paramInt);
  
  @Cast({"size_t"})
  public static native long av_get_codec_tag_string(@Cast({"char*"}) BytePointer paramBytePointer, @Cast({"size_t"}) long paramLong, @Cast({"unsigned"}) int paramInt);
  
  public static native int av_get_exact_bits_per_sample(@Cast({"AVCodecID"}) int paramInt);
  
  @Cast({"AVCodecID"})
  public static native int av_get_pcm_codec(@Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
  
  public static native String av_get_profile_name(AVCodec paramAVCodec, int paramInt);
  
  public static native int av_grow_packet(AVPacket paramAVPacket, int paramInt);
  
  public static native AVHWAccel av_hwaccel_next(AVHWAccel paramAVHWAccel);
  
  public static native void av_init_packet(AVPacket paramAVPacket);
  
  public static native int av_lockmgr_register(Cb paramCb);
  
  public static native void av_log_ask_for_sample(Pointer paramPointer, String paramString);
  
  public static native void av_log_missing_feature(Pointer paramPointer, String paramString, int paramInt);
  
  public static native int av_new_packet(AVPacket paramAVPacket, int paramInt);
  
  @Cast({"uint8_t*"})
  public static native BytePointer av_packet_get_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt, int[] paramArrayOfInt);
  
  public static native int av_packet_merge_side_data(AVPacket paramAVPacket);
  
  @Cast({"uint8_t*"})
  public static native BytePointer av_packet_new_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt1, int paramInt2);
  
  public static native int av_packet_shrink_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt1, int paramInt2);
  
  public static native int av_packet_split_side_data(AVPacket paramAVPacket);
  
  public static native int av_parser_change(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
  
  public static native void av_parser_close(AVCodecParserContext paramAVCodecParserContext);
  
  public static native AVCodecParserContext av_parser_init(int paramInt);
  
  public static native AVCodecParser av_parser_next(AVCodecParser paramAVCodecParser);
  
  public static native int av_parser_parse2(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  public static native void av_picture_copy(AVPicture paramAVPicture1, AVPicture paramAVPicture2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native int av_picture_crop(AVPicture paramAVPicture1, AVPicture paramAVPicture2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native int av_picture_pad(AVPicture paramAVPicture1, AVPicture paramAVPicture2, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int[] paramArrayOfInt);
  
  public static native void av_register_bitstream_filter(AVBitStreamFilter paramAVBitStreamFilter);
  
  public static native void av_register_codec_parser(AVCodecParser paramAVCodecParser);
  
  public static native void av_register_hwaccel(AVHWAccel paramAVHWAccel);
  
  @Deprecated
  public static native int av_resample(AVResampleContext paramAVResampleContext, @Cast({"short*"}) Pointer paramPointer1, @Cast({"short*"}) Pointer paramPointer2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native int av_resample(AVResampleContext paramAVResampleContext, ShortPointer paramShortPointer1, ShortPointer paramShortPointer2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native int av_resample(AVResampleContext paramAVResampleContext, @Cast({"short*"}) Buffer paramBuffer1, @Cast({"short*"}) Buffer paramBuffer2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native int av_resample(AVResampleContext paramAVResampleContext, ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native int av_resample(AVResampleContext paramAVResampleContext, @Cast({"short*"}) byte[] paramArrayOfByte1, @Cast({"short*"}) byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native int av_resample(AVResampleContext paramAVResampleContext, short[] paramArrayOfShort1, short[] paramArrayOfShort2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native void av_resample_close(AVResampleContext paramAVResampleContext);
  
  @Deprecated
  public static native void av_resample_compensate(AVResampleContext paramAVResampleContext, int paramInt1, int paramInt2);
  
  @Deprecated
  public static native AVResampleContext av_resample_init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble);
  
  public static native void av_shrink_packet(AVPacket paramAVPacket, int paramInt);
  
  @Cast({"unsigned"})
  public static native int av_xiphlacing(@Cast({"unsigned char*"}) BytePointer paramBytePointer, @Cast({"unsigned"}) int paramInt);
  
  public static native void avcodec_align_dimensions(AVCodecContext paramAVCodecContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static native void avcodec_align_dimensions2(AVCodecContext paramAVCodecContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public static native AVCodecContext avcodec_alloc_context3(AVCodec paramAVCodec);
  
  public static native AVFrame avcodec_alloc_frame();
  
  public static native int avcodec_close(AVCodecContext paramAVCodecContext);
  
  public static native String avcodec_configuration();
  
  public static native int avcodec_copy_context(AVCodecContext paramAVCodecContext1, AVCodecContext paramAVCodecContext2);
  
  public static native int avcodec_decode_audio4(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame, int[] paramArrayOfInt, AVPacket paramAVPacket);
  
  public static native int avcodec_decode_subtitle2(AVCodecContext paramAVCodecContext, AVSubtitle paramAVSubtitle, int[] paramArrayOfInt, AVPacket paramAVPacket);
  
  public static native int avcodec_decode_video2(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame, int[] paramArrayOfInt, AVPacket paramAVPacket);
  
  public static native int avcodec_default_execute(AVCodecContext paramAVCodecContext, AVCodecContext.Execute.Func paramFunc, Pointer paramPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2);
  
  public static native int avcodec_default_execute2(AVCodecContext paramAVCodecContext, AVCodecContext.Execute2.Func2 paramFunc2, Pointer paramPointer, IntPointer paramIntPointer, int paramInt);
  
  public static native void avcodec_default_free_buffers(AVCodecContext paramAVCodecContext);
  
  public static native int avcodec_default_get_buffer(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame);
  
  @Cast({"AVPixelFormat"})
  public static native int avcodec_default_get_format(AVCodecContext paramAVCodecContext, @Cast({"AVPixelFormat*"}) int[] paramArrayOfInt);
  
  public static native int avcodec_default_reget_buffer(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame);
  
  public static native void avcodec_default_release_buffer(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame);
  
  @Const
  public static native AVCodecDescriptor avcodec_descriptor_get(@Cast({"AVCodecID"}) int paramInt);
  
  @Const
  public static native AVCodecDescriptor avcodec_descriptor_get_by_name(String paramString);
  
  @Const
  public static native AVCodecDescriptor avcodec_descriptor_next(AVCodecDescriptor paramAVCodecDescriptor);
  
  public static native int avcodec_encode_audio2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, AVFrame paramAVFrame, int[] paramArrayOfInt);
  
  public static native int avcodec_encode_subtitle(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, AVSubtitle paramAVSubtitle);
  
  public static native int avcodec_encode_video2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, AVFrame paramAVFrame, int[] paramArrayOfInt);
  
  public static native int avcodec_fill_audio_frame(AVFrame paramAVFrame, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt3, int paramInt4);
  
  @Cast({"AVPixelFormat"})
  @Deprecated
  public static native int avcodec_find_best_pix_fmt(long paramLong, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  @Cast({"AVPixelFormat"})
  @Deprecated
  public static native int avcodec_find_best_pix_fmt2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int[] paramArrayOfInt);
  
  @Cast({"AVPixelFormat"})
  public static native int avcodec_find_best_pix_fmt_of_2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int[] paramArrayOfInt);
  
  @Cast({"AVPixelFormat"})
  public static native int avcodec_find_best_pix_fmt_of_list(@Cast({"AVPixelFormat*"}) int[] paramArrayOfInt1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int[] paramArrayOfInt2);
  
  public static native AVCodec avcodec_find_decoder(@Cast({"AVCodecID"}) int paramInt);
  
  public static native AVCodec avcodec_find_decoder_by_name(String paramString);
  
  public static native AVCodec avcodec_find_encoder(@Cast({"AVCodecID"}) int paramInt);
  
  public static native AVCodec avcodec_find_encoder_by_name(String paramString);
  
  public static native void avcodec_flush_buffers(AVCodecContext paramAVCodecContext);
  
  public static native void avcodec_free_frame(@ByPtrPtr AVFrame paramAVFrame);
  
  public static native void avcodec_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  @Const
  public static native avutil.AVClass avcodec_get_class();
  
  public static native int avcodec_get_context_defaults3(AVCodecContext paramAVCodecContext, AVCodec paramAVCodec);
  
  @Cast({"unsigned"})
  public static native int avcodec_get_edge_width();
  
  @Const
  public static native avutil.AVClass avcodec_get_frame_class();
  
  public static native void avcodec_get_frame_defaults(AVFrame paramAVFrame);
  
  public static native String avcodec_get_name(@Cast({"AVCodecID"}) int paramInt);
  
  public static native int avcodec_get_pix_fmt_loss(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3);
  
  @Const
  public static native avutil.AVClass avcodec_get_subtitle_rect_class();
  
  @Cast({"AVMediaType"})
  public static native int avcodec_get_type(@Cast({"AVCodecID"}) int paramInt);
  
  public static native int avcodec_is_open(AVCodecContext paramAVCodecContext);
  
  public static native String avcodec_license();
  
  public static native int avcodec_open2(AVCodecContext paramAVCodecContext, AVCodec paramAVCodec, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
  
  @Cast({"unsigned"})
  public static native int avcodec_pix_fmt_to_codec_tag(@Cast({"AVPixelFormat"}) int paramInt);
  
  public static native void avcodec_register(AVCodec paramAVCodec);
  
  public static native void avcodec_register_all();
  
  public static native void avcodec_set_dimensions(AVCodecContext paramAVCodecContext, int paramInt1, int paramInt2);
  
  public static native void avcodec_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, AVCodecContext paramAVCodecContext, int paramInt2);
  
  @Cast({"unsigned"})
  public static native int avcodec_version();
  
  public static native int avpicture_alloc(AVPicture paramAVPicture, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  @Deprecated
  public static native int avpicture_deinterlace(AVPicture paramAVPicture1, AVPicture paramAVPicture2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native int avpicture_fill(AVPicture paramAVPicture, @Cast({"uint8_t*"}) BytePointer paramBytePointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native void avpicture_free(AVPicture paramAVPicture);
  
  public static native int avpicture_get_size(@Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
  
  public static native int avpicture_layout(AVPicture paramAVPicture, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, @Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt4);
  
  public static native void avsubtitle_free(AVSubtitle paramAVSubtitle);
  
  public static class AVBitStreamFilter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVBitStreamFilter()
    {
      allocate();
    }
    
    public AVBitStreamFilter(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVBitStreamFilter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native Close close();
    
    public native AVBitStreamFilter close(Close paramClose);
    
    public native Filter filter();
    
    public native AVBitStreamFilter filter(Filter paramFilter);
    
    @Cast({"const char *"})
    public native BytePointer name();
    
    public native AVBitStreamFilter name(BytePointer paramBytePointer);
    
    public native AVBitStreamFilter next();
    
    public native AVBitStreamFilter next(AVBitStreamFilter paramAVBitStreamFilter);
    
    public AVBitStreamFilter position(int paramInt)
    {
      return (AVBitStreamFilter)super.position(paramInt);
    }
    
    public native int priv_data_size();
    
    public native AVBitStreamFilter priv_data_size(int paramInt);
    
    public static class Close
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Close()
      {
        allocate();
      }
      
      public Close(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVBitStreamFilterContext paramAVBitStreamFilterContext);
    }
    
    public static class Filter
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Filter()
      {
        allocate();
      }
      
      public Filter(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, String paramString, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
    }
  }
  
  public static class AVBitStreamFilterContext
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVBitStreamFilterContext()
    {
      allocate();
    }
    
    public AVBitStreamFilterContext(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVBitStreamFilterContext(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native AVBitStreamFilter filter();
    
    public native AVBitStreamFilterContext filter(AVBitStreamFilter paramAVBitStreamFilter);
    
    public native AVBitStreamFilterContext next();
    
    public native AVBitStreamFilterContext next(AVBitStreamFilterContext paramAVBitStreamFilterContext);
    
    public native AVBitStreamFilterContext parser(AVCodecParserContext paramAVCodecParserContext);
    
    public native AVCodecParserContext parser();
    
    public AVBitStreamFilterContext position(int paramInt)
    {
      return (AVBitStreamFilterContext)super.position(paramInt);
    }
    
    public native Pointer priv_data();
    
    public native AVBitStreamFilterContext priv_data(Pointer paramPointer);
  }
  
  public static class AVCodec
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVCodec()
    {
      allocate();
    }
    
    public AVCodec(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVCodec(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int capabilities();
    
    public native AVCodec capabilities(int paramInt);
    
    @Cast({"const uint64_t*"})
    public native LongPointer channel_layouts();
    
    public native AVCodec channel_layouts(LongPointer paramLongPointer);
    
    @Cast({"AVCodecID"})
    public native int id();
    
    public native AVCodec id(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer long_name();
    
    public native AVCodec long_name(BytePointer paramBytePointer);
    
    @Cast({"uint8_t"})
    public native int max_lowres();
    
    public native AVCodec max_lowres(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVCodec name(BytePointer paramBytePointer);
    
    @Cast({"const AVPixelFormat*"})
    public native IntPointer pix_fmts();
    
    public native AVCodec pix_fmts(IntPointer paramIntPointer);
    
    public AVCodec position(int paramInt)
    {
      return (AVCodec)super.position(paramInt);
    }
    
    public native AVCodec priv_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass priv_class();
    
    public native AVCodec profiles(AVProfile paramAVProfile);
    
    @Const
    public native avcodec.AVProfile profiles();
    
    @Cast({"const AVSampleFormat*"})
    public native IntPointer sample_fmts();
    
    public native AVCodec sample_fmts(IntPointer paramIntPointer);
    
    public native AVCodec supported_framerates(avutil.AVRational paramAVRational);
    
    @Const
    public native avutil.AVRational supported_framerates();
    
    @Const
    public native IntPointer supported_samplerates();
    
    public native AVCodec supported_samplerates(IntPointer paramIntPointer);
    
    @Cast({"AVMediaType"})
    public native int type();
    
    public native AVCodec type(int paramInt);
  }
  
  public static class AVCodecContext
    extends Pointer
  {
    public static final int AV_EF_AGGRESSIVE = 262144;
    public static final int AV_EF_BITSTREAM = 2;
    public static final int AV_EF_BUFFER = 4;
    public static final int AV_EF_CAREFUL = 65536;
    public static final int AV_EF_COMPLIANT = 131072;
    public static final int AV_EF_CRCCHECK = 1;
    public static final int AV_EF_EXPLODE = 8;
    public static final int FF_ASPECT_EXTENDED = 15;
    public static final int FF_BUG_AC_VLC = 0;
    public static final int FF_BUG_AMV = 32;
    public static final int FF_BUG_AUTODETECT = 1;
    public static final int FF_BUG_DC_CLIP = 4096;
    public static final int FF_BUG_DIRECT_BLOCKSIZE = 512;
    public static final int FF_BUG_EDGE = 1024;
    public static final int FF_BUG_HPEL_CHROMA = 2048;
    public static final int FF_BUG_MS = 8192;
    public static final int FF_BUG_NO_PADDING = 16;
    public static final int FF_BUG_OLD_MSMPEG4 = 2;
    public static final int FF_BUG_QPEL_CHROMA = 64;
    public static final int FF_BUG_QPEL_CHROMA2 = 256;
    public static final int FF_BUG_STD_QPEL = 128;
    public static final int FF_BUG_TRUNCATED = 16384;
    public static final int FF_BUG_UMP4 = 8;
    public static final int FF_BUG_XVID_ILACE = 4;
    public static final int FF_CMP_BIT = 5;
    public static final int FF_CMP_CHROMA = 256;
    public static final int FF_CMP_DCT = 3;
    public static final int FF_CMP_DCT264 = 14;
    public static final int FF_CMP_DCTMAX = 13;
    public static final int FF_CMP_NSSE = 10;
    public static final int FF_CMP_PSNR = 4;
    public static final int FF_CMP_RD = 6;
    public static final int FF_CMP_SAD = 0;
    public static final int FF_CMP_SATD = 2;
    public static final int FF_CMP_SSE = 1;
    public static final int FF_CMP_VSAD = 8;
    public static final int FF_CMP_VSSE = 9;
    public static final int FF_CMP_W53 = 11;
    public static final int FF_CMP_W97 = 12;
    public static final int FF_CMP_ZERO = 7;
    public static final int FF_CODER_TYPE_AC = 1;
    public static final int FF_CODER_TYPE_DEFLATE = 4;
    public static final int FF_CODER_TYPE_RAW = 2;
    public static final int FF_CODER_TYPE_RLE = 3;
    public static final int FF_CODER_TYPE_VLC = 0;
    public static final int FF_COMPLIANCE_EXPERIMENTAL = -2;
    public static final int FF_COMPLIANCE_NORMAL = 0;
    public static final int FF_COMPLIANCE_STRICT = 1;
    public static final int FF_COMPLIANCE_UNOFFICIAL = -1;
    public static final int FF_COMPLIANCE_VERY_STRICT = 2;
    public static final int FF_COMPRESSION_DEFAULT = -1;
    public static final int FF_DCT_ALTIVEC = 5;
    public static final int FF_DCT_AUTO = 0;
    public static final int FF_DCT_FAAN = 6;
    public static final int FF_DCT_FASTINT = 1;
    public static final int FF_DCT_INT = 2;
    public static final int FF_DCT_MMX = 3;
    public static final int FF_DEBUG_BITSTREAM = 4;
    public static final int FF_DEBUG_BUFFERS = 32768;
    public static final int FF_DEBUG_BUGS = 4096;
    public static final int FF_DEBUG_DCT_COEFF = 64;
    public static final int FF_DEBUG_ER = 1024;
    public static final int FF_DEBUG_MB_TYPE = 8;
    public static final int FF_DEBUG_MMCO = 2048;
    public static final int FF_DEBUG_MV = 32;
    public static final int FF_DEBUG_PICT_INFO = 1;
    public static final int FF_DEBUG_PTS = 512;
    public static final int FF_DEBUG_QP = 16;
    public static final int FF_DEBUG_RC = 2;
    public static final int FF_DEBUG_SKIP = 128;
    public static final int FF_DEBUG_STARTCODE = 256;
    public static final int FF_DEBUG_THREADS = 65536;
    public static final int FF_DEBUG_VIS_MB_TYPE = 16384;
    public static final int FF_DEBUG_VIS_MV_B_BACK = 4;
    public static final int FF_DEBUG_VIS_MV_B_FOR = 2;
    public static final int FF_DEBUG_VIS_MV_P_FOR = 1;
    public static final int FF_DEBUG_VIS_QP = 8192;
    public static final int FF_DEFAULT_QUANT_BIAS = 999999;
    public static final int FF_DTG_AFD_14_9 = 11;
    public static final int FF_DTG_AFD_16_9 = 10;
    public static final int FF_DTG_AFD_16_9_SP_14_9 = 14;
    public static final int FF_DTG_AFD_4_3 = 9;
    public static final int FF_DTG_AFD_4_3_SP_14_9 = 13;
    public static final int FF_DTG_AFD_SAME = 8;
    public static final int FF_DTG_AFD_SP_4_3 = 15;
    public static final int FF_EC_DEBLOCK = 2;
    public static final int FF_EC_GUESS_MVS = 1;
    public static final int FF_IDCT_ALTIVEC = 8;
    public static final int FF_IDCT_ARM = 7;
    public static final int FF_IDCT_AUTO = 0;
    public static final int FF_IDCT_BINK = 24;
    public static final int FF_IDCT_CAVS = 15;
    public static final int FF_IDCT_EA = 21;
    public static final int FF_IDCT_FAAN = 20;
    public static final int FF_IDCT_H264 = 11;
    public static final int FF_IDCT_INT = 1;
    public static final int FF_IDCT_IPP = 13;
    public static final int FF_IDCT_LIBMPEG2MMX = 4;
    public static final int FF_IDCT_MMI = 5;
    public static final int FF_IDCT_SH4 = 9;
    public static final int FF_IDCT_SIMPLE = 2;
    public static final int FF_IDCT_SIMPLEALPHA = 23;
    public static final int FF_IDCT_SIMPLEARM = 10;
    public static final int FF_IDCT_SIMPLEARMV5TE = 16;
    public static final int FF_IDCT_SIMPLEARMV6 = 17;
    public static final int FF_IDCT_SIMPLEMMX = 3;
    public static final int FF_IDCT_SIMPLENEON = 22;
    public static final int FF_IDCT_SIMPLEVIS = 18;
    public static final int FF_IDCT_VP3 = 12;
    public static final int FF_IDCT_WMV2 = 19;
    public static final int FF_IDCT_XVIDMMX = 14;
    public static final int FF_LEVEL_UNKNOWN = -99;
    public static final int FF_MB_DECISION_BITS = 1;
    public static final int FF_MB_DECISION_RD = 2;
    public static final int FF_MB_DECISION_SIMPLE = 0;
    public static final int FF_PRED_LEFT = 0;
    public static final int FF_PRED_MEDIAN = 2;
    public static final int FF_PRED_PLANE = 1;
    public static final int FF_PROFILE_AAC_ELD = 38;
    public static final int FF_PROFILE_AAC_HE = 4;
    public static final int FF_PROFILE_AAC_HE_V2 = 28;
    public static final int FF_PROFILE_AAC_LD = 22;
    public static final int FF_PROFILE_AAC_LOW = 1;
    public static final int FF_PROFILE_AAC_LTP = 3;
    public static final int FF_PROFILE_AAC_MAIN = 0;
    public static final int FF_PROFILE_AAC_SSR = 2;
    public static final int FF_PROFILE_DTS = 20;
    public static final int FF_PROFILE_DTS_96_24 = 40;
    public static final int FF_PROFILE_DTS_ES = 30;
    public static final int FF_PROFILE_DTS_HD_HRA = 50;
    public static final int FF_PROFILE_DTS_HD_MA = 60;
    public static final int FF_PROFILE_H264_BASELINE = 66;
    public static final int FF_PROFILE_H264_CAVLC_444 = 44;
    public static final int FF_PROFILE_H264_CONSTRAINED = 512;
    public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
    public static final int FF_PROFILE_H264_EXTENDED = 88;
    public static final int FF_PROFILE_H264_HIGH = 100;
    public static final int FF_PROFILE_H264_HIGH_10 = 110;
    public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
    public static final int FF_PROFILE_H264_HIGH_422 = 122;
    public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
    public static final int FF_PROFILE_H264_HIGH_444 = 144;
    public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
    public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
    public static final int FF_PROFILE_H264_INTRA = 2048;
    public static final int FF_PROFILE_H264_MAIN = 77;
    public static final int FF_PROFILE_MPEG2_422 = 0;
    public static final int FF_PROFILE_MPEG2_HIGH = 1;
    public static final int FF_PROFILE_MPEG2_MAIN = 4;
    public static final int FF_PROFILE_MPEG2_SIMPLE = 5;
    public static final int FF_PROFILE_MPEG2_SNR_SCALABLE = 3;
    public static final int FF_PROFILE_MPEG2_SS = 2;
    public static final int FF_PROFILE_MPEG4_ADVANCED_CODING = 11;
    public static final int FF_PROFILE_MPEG4_ADVANCED_CORE = 12;
    public static final int FF_PROFILE_MPEG4_ADVANCED_REAL_TIME = 9;
    public static final int FF_PROFILE_MPEG4_ADVANCED_SCALABLE_TEXTURE = 13;
    public static final int FF_PROFILE_MPEG4_ADVANCED_SIMPLE = 15;
    public static final int FF_PROFILE_MPEG4_BASIC_ANIMATED_TEXTURE = 7;
    public static final int FF_PROFILE_MPEG4_CORE = 2;
    public static final int FF_PROFILE_MPEG4_CORE_SCALABLE = 10;
    public static final int FF_PROFILE_MPEG4_HYBRID = 8;
    public static final int FF_PROFILE_MPEG4_MAIN = 3;
    public static final int FF_PROFILE_MPEG4_N_BIT = 4;
    public static final int FF_PROFILE_MPEG4_SCALABLE_TEXTURE = 5;
    public static final int FF_PROFILE_MPEG4_SIMPLE = 0;
    public static final int FF_PROFILE_MPEG4_SIMPLE_FACE_ANIMATION = 6;
    public static final int FF_PROFILE_MPEG4_SIMPLE_SCALABLE = 1;
    public static final int FF_PROFILE_MPEG4_SIMPLE_STUDIO = 14;
    public static final int FF_PROFILE_RESERVED = -100;
    public static final int FF_PROFILE_UNKNOWN = -99;
    public static final int FF_PROFILE_VC1_ADVANCED = 3;
    public static final int FF_PROFILE_VC1_COMPLEX = 2;
    public static final int FF_PROFILE_VC1_MAIN = 1;
    public static final int FF_PROFILE_VC1_SIMPLE = 0;
    public static final int FF_RC_STRATEGY_XVID = 1;
    public static final int FF_SUB_CHARENC_MODE_AUTOMATIC = 0;
    public static final int FF_SUB_CHARENC_MODE_DO_NOTHING = -1;
    public static final int FF_SUB_CHARENC_MODE_PRE_DECODER = 1;
    public static final int FF_THREAD_FRAME = 1;
    public static final int FF_THREAD_SLICE = 2;
    public static final int SLICE_FLAG_ALLOW_FIELD = 2;
    public static final int SLICE_FLAG_ALLOW_PLANE = 4;
    public static final int SLICE_FLAG_CODED_ORDER = 1;
    int sub_charenc_mode;
    
    static
    {
      Loader.load();
    }
    
    public AVCodecContext()
    {
      allocate();
    }
    
    public AVCodecContext(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVCodecContext(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int active_thread_type();
    
    public native AVCodecContext active_thread_type(int paramInt);
    
    @Cast({"AVAudioServiceType"})
    public native int audio_service_type();
    
    public native AVCodecContext audio_service_type(int paramInt);
    
    public native AVCodecContext av_class(avutil.AVClass paramAVClass);
    
    @Const
    public native avutil.AVClass av_class();
    
    public native int b_frame_strategy();
    
    public native AVCodecContext b_frame_strategy(int paramInt);
    
    public native float b_quant_factor();
    
    public native AVCodecContext b_quant_factor(float paramFloat);
    
    public native float b_quant_offset();
    
    public native AVCodecContext b_quant_offset(float paramFloat);
    
    public native int b_sensitivity();
    
    public native AVCodecContext b_sensitivity(int paramInt);
    
    public native int bidir_refine();
    
    public native AVCodecContext bidir_refine(int paramInt);
    
    public native int bit_rate();
    
    public native AVCodecContext bit_rate(int paramInt);
    
    public native int bit_rate_tolerance();
    
    public native AVCodecContext bit_rate_tolerance(int paramInt);
    
    public native int bits_per_coded_sample();
    
    public native AVCodecContext bits_per_coded_sample(int paramInt);
    
    public native int bits_per_raw_sample();
    
    public native AVCodecContext bits_per_raw_sample(int paramInt);
    
    public native int block_align();
    
    public native AVCodecContext block_align(int paramInt);
    
    public native float border_masking();
    
    public native AVCodecContext border_masking(float paramFloat);
    
    public native int brd_scale();
    
    public native AVCodecContext brd_scale(int paramInt);
    
    @Cast({"uint64_t"})
    public native long channel_layout();
    
    public native AVCodecContext channel_layout(long paramLong);
    
    public native int channels();
    
    public native AVCodecContext channels(int paramInt);
    
    @Cast({"AVChromaLocation"})
    public native int chroma_sample_location();
    
    public native AVCodecContext chroma_sample_location(int paramInt);
    
    public native int chromaoffset();
    
    public native AVCodecContext chromaoffset(int paramInt);
    
    @Const
    public native avcodec.AVCodec codec();
    
    public native AVCodecContext codec(AVCodec paramAVCodec);
    
    public native AVCodecContext codec_descriptor(AVCodecDescriptor paramAVCodecDescriptor);
    
    @Const
    public native avcodec.AVCodecDescriptor codec_descriptor();
    
    @Cast({"AVCodecID"})
    public native int codec_id();
    
    public native AVCodecContext codec_id(int paramInt);
    
    public native AVCodecContext codec_name(String paramString);
    
    public native String codec_name();
    
    public native int codec_tag();
    
    public native AVCodecContext codec_tag(int paramInt);
    
    @Cast({"AVMediaType"})
    public native int codec_type();
    
    public native AVCodecContext codec_type(int paramInt);
    
    public native AVCodecContext coded_frame(AVFrame paramAVFrame);
    
    public native AVFrame coded_frame();
    
    public native int coded_height();
    
    public native AVCodecContext coded_height(int paramInt);
    
    public native int coded_width();
    
    public native AVCodecContext coded_width(int paramInt);
    
    public native int coder_type();
    
    public native AVCodecContext coder_type(int paramInt);
    
    @Cast({"AVColorPrimaries"})
    public native int color_primaries();
    
    public native AVCodecContext color_primaries(int paramInt);
    
    @Cast({"AVColorRange"})
    public native int color_range();
    
    public native AVCodecContext color_range(int paramInt);
    
    @Cast({"AVColorTransferCharacteristic"})
    public native int color_trc();
    
    public native AVCodecContext color_trc(int paramInt);
    
    @Cast({"AVColorSpace"})
    public native int colorspace();
    
    public native AVCodecContext colorspace(int paramInt);
    
    public native int compression_level();
    
    public native AVCodecContext compression_level(int paramInt);
    
    public native int context_model();
    
    public native AVCodecContext context_model(int paramInt);
    
    public native int cutoff();
    
    public native AVCodecContext cutoff(int paramInt);
    
    public native float dark_masking();
    
    public native AVCodecContext dark_masking(float paramFloat);
    
    public native int dct_algo();
    
    public native AVCodecContext dct_algo(int paramInt);
    
    public native int debug();
    
    public native AVCodecContext debug(int paramInt);
    
    public native int debug_mv();
    
    public native AVCodecContext debug_mv(int paramInt);
    
    public native int delay();
    
    public native AVCodecContext delay(int paramInt);
    
    public native int dia_size();
    
    public native AVCodecContext dia_size(int paramInt);
    
    public native Draw_horiz_band draw_horiz_band();
    
    public native AVCodecContext draw_horiz_band(Draw_horiz_band paramDraw_horiz_band);
    
    public native int dtg_active_format();
    
    public native AVCodecContext dtg_active_format(int paramInt);
    
    public native int err_recognition();
    
    public native AVCodecContext err_recognition(int paramInt);
    
    @Cast({"uint64_t"})
    public native long error(int paramInt);
    
    public native AVCodecContext error(int paramInt, long paramLong);
    
    public native int error_concealment();
    
    public native AVCodecContext error_concealment(int paramInt);
    
    public native int error_rate();
    
    public native AVCodecContext error_rate(int paramInt);
    
    public native Execute execute();
    
    public native AVCodecContext execute(Execute paramExecute);
    
    public native Execute2 execute2();
    
    public native AVCodecContext execute2(Execute2 paramExecute2);
    
    @Cast({"uint8_t*"})
    public native BytePointer extradata();
    
    public native AVCodecContext extradata(BytePointer paramBytePointer);
    
    public native int extradata_size();
    
    public native AVCodecContext extradata_size(int paramInt);
    
    @Cast({"AVFieldOrder"})
    public native int field_order();
    
    public native AVCodecContext field_order(int paramInt);
    
    public native int flags();
    
    public native AVCodecContext flags(int paramInt);
    
    public native int flags2();
    
    public native AVCodecContext flags2(int paramInt);
    
    public native int frame_bits();
    
    public native AVCodecContext frame_bits(int paramInt);
    
    public native int frame_number();
    
    public native AVCodecContext frame_number(int paramInt);
    
    public native int frame_size();
    
    public native AVCodecContext frame_size(int paramInt);
    
    public native int frame_skip_cmp();
    
    public native AVCodecContext frame_skip_cmp(int paramInt);
    
    public native int frame_skip_exp();
    
    public native AVCodecContext frame_skip_exp(int paramInt);
    
    public native int frame_skip_factor();
    
    public native AVCodecContext frame_skip_factor(int paramInt);
    
    public native int frame_skip_threshold();
    
    public native AVCodecContext frame_skip_threshold(int paramInt);
    
    public native Get_buffer get_buffer();
    
    public native AVCodecContext get_buffer(Get_buffer paramGet_buffer);
    
    public native Get_format get_format();
    
    public native AVCodecContext get_format(Get_format paramGet_format);
    
    public native int global_quality();
    
    public native AVCodecContext global_quality(int paramInt);
    
    public native int gop_size();
    
    public native AVCodecContext gop_size(int paramInt);
    
    public native int has_b_frames();
    
    public native AVCodecContext has_b_frames(int paramInt);
    
    public native int header_bits();
    
    public native AVCodecContext header_bits(int paramInt);
    
    public native int height();
    
    public native AVCodecContext height(int paramInt);
    
    public native AVCodecContext hwaccel(AVHWAccel paramAVHWAccel);
    
    public native AVHWAccel hwaccel();
    
    public native Pointer hwaccel_context();
    
    public native AVCodecContext hwaccel_context(Pointer paramPointer);
    
    public native int i_count();
    
    public native AVCodecContext i_count(int paramInt);
    
    public native float i_quant_factor();
    
    public native AVCodecContext i_quant_factor(float paramFloat);
    
    public native float i_quant_offset();
    
    public native AVCodecContext i_quant_offset(float paramFloat);
    
    public native int i_tex_bits();
    
    public native AVCodecContext i_tex_bits(int paramInt);
    
    public native int idct_algo();
    
    public native AVCodecContext idct_algo(int paramInt);
    
    public native int ildct_cmp();
    
    public native AVCodecContext ildct_cmp(int paramInt);
    
    @Cast({"uint16_t*"})
    public native ShortPointer inter_matrix();
    
    public native AVCodecContext inter_matrix(ShortPointer paramShortPointer);
    
    public native int inter_quant_bias();
    
    public native AVCodecContext inter_quant_bias(int paramInt);
    
    public native AVCodecContext internal(AVCodecInternal paramAVCodecInternal);
    
    public native AVCodecInternal internal();
    
    public native int intra_dc_precision();
    
    public native AVCodecContext intra_dc_precision(int paramInt);
    
    @Cast({"uint16_t*"})
    public native ShortPointer intra_matrix();
    
    public native AVCodecContext intra_matrix(ShortPointer paramShortPointer);
    
    public native int intra_quant_bias();
    
    public native AVCodecContext intra_quant_bias(int paramInt);
    
    public native int keyint_min();
    
    public native AVCodecContext keyint_min(int paramInt);
    
    public native int last_predictor_count();
    
    public native AVCodecContext last_predictor_count(int paramInt);
    
    public native int level();
    
    public native AVCodecContext level(int paramInt);
    
    public native int lmax();
    
    public native AVCodecContext lmax(int paramInt);
    
    public native int lmin();
    
    public native AVCodecContext lmin(int paramInt);
    
    public native int log_level_offset();
    
    public native AVCodecContext log_level_offset(int paramInt);
    
    public native int lowres();
    
    public native AVCodecContext lowres(int paramInt);
    
    public native float lumi_masking();
    
    public native AVCodecContext lumi_masking(float paramFloat);
    
    public native int max_b_frames();
    
    public native AVCodecContext max_b_frames(int paramInt);
    
    public native int max_prediction_order();
    
    public native AVCodecContext max_prediction_order(int paramInt);
    
    public native int max_qdiff();
    
    public native AVCodecContext max_qdiff(int paramInt);
    
    public native int mb_cmp();
    
    public native AVCodecContext mb_cmp(int paramInt);
    
    public native int mb_decision();
    
    public native AVCodecContext mb_decision(int paramInt);
    
    public native int mb_lmax();
    
    public native AVCodecContext mb_lmax(int paramInt);
    
    public native int mb_lmin();
    
    public native AVCodecContext mb_lmin(int paramInt);
    
    public native int mb_threshold();
    
    public native AVCodecContext mb_threshold(int paramInt);
    
    public native int me_cmp();
    
    public native AVCodecContext me_cmp(int paramInt);
    
    public native int me_method();
    
    public native AVCodecContext me_method(int paramInt);
    
    public native int me_penalty_compensation();
    
    public native AVCodecContext me_penalty_compensation(int paramInt);
    
    public native int me_pre_cmp();
    
    public native AVCodecContext me_pre_cmp(int paramInt);
    
    public native int me_range();
    
    public native AVCodecContext me_range(int paramInt);
    
    public native int me_sub_cmp();
    
    public native AVCodecContext me_sub_cmp(int paramInt);
    
    public native int me_subpel_quality();
    
    public native AVCodecContext me_subpel_quality(int paramInt);
    
    public native int me_threshold();
    
    public native AVCodecContext me_threshold(int paramInt);
    
    public native AVCodecContext metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    public native int min_prediction_order();
    
    public native AVCodecContext min_prediction_order(int paramInt);
    
    public native int misc_bits();
    
    public native AVCodecContext misc_bits(int paramInt);
    
    public native int mpeg_quant();
    
    public native AVCodecContext mpeg_quant(int paramInt);
    
    public native int mv0_threshold();
    
    public native AVCodecContext mv0_threshold(int paramInt);
    
    public native int mv_bits();
    
    public native AVCodecContext mv_bits(int paramInt);
    
    public native int noise_reduction();
    
    public native AVCodecContext noise_reduction(int paramInt);
    
    public native int nsse_weight();
    
    public native AVCodecContext nsse_weight(int paramInt);
    
    public native Pointer opaque();
    
    public native AVCodecContext opaque(Pointer paramPointer);
    
    public native int p_count();
    
    public native AVCodecContext p_count(int paramInt);
    
    public native float p_masking();
    
    public native AVCodecContext p_masking(float paramFloat);
    
    public native int p_tex_bits();
    
    public native AVCodecContext p_tex_bits(int paramInt);
    
    @Cast({"AVPixelFormat"})
    public native int pix_fmt();
    
    public native AVCodecContext pix_fmt(int paramInt);
    
    public native AVCodecContext pkt(AVPacket paramAVPacket);
    
    public native AVPacket pkt();
    
    public native AVCodecContext pkt_timebase(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational pkt_timebase();
    
    public AVCodecContext position(int paramInt)
    {
      return (AVCodecContext)super.position(paramInt);
    }
    
    public native int pre_dia_size();
    
    public native AVCodecContext pre_dia_size(int paramInt);
    
    public native int pre_me();
    
    public native AVCodecContext pre_me(int paramInt);
    
    public native int prediction_method();
    
    public native AVCodecContext prediction_method(int paramInt);
    
    public native Pointer priv_data();
    
    public native AVCodecContext priv_data(Pointer paramPointer);
    
    public native int profile();
    
    public native AVCodecContext profile(int paramInt);
    
    public native long pts_correction_last_dts();
    
    public native AVCodecContext pts_correction_last_dts(long paramLong);
    
    public native long pts_correction_last_pts();
    
    public native AVCodecContext pts_correction_last_pts(long paramLong);
    
    public native long pts_correction_num_faulty_dts();
    
    public native AVCodecContext pts_correction_num_faulty_dts(long paramLong);
    
    public native long pts_correction_num_faulty_pts();
    
    public native AVCodecContext pts_correction_num_faulty_pts(long paramLong);
    
    public native float qblur();
    
    public native AVCodecContext qblur(float paramFloat);
    
    public native float qcompress();
    
    public native AVCodecContext qcompress(float paramFloat);
    
    public native int qmax();
    
    public native AVCodecContext qmax(int paramInt);
    
    public native int qmin();
    
    public native AVCodecContext qmin(int paramInt);
    
    public native float rc_buffer_aggressivity();
    
    public native AVCodecContext rc_buffer_aggressivity(float paramFloat);
    
    public native int rc_buffer_size();
    
    public native AVCodecContext rc_buffer_size(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer rc_eq();
    
    public native AVCodecContext rc_eq(BytePointer paramBytePointer);
    
    public native int rc_initial_buffer_occupancy();
    
    public native AVCodecContext rc_initial_buffer_occupancy(int paramInt);
    
    public native float rc_initial_cplx();
    
    public native AVCodecContext rc_initial_cplx(float paramFloat);
    
    public native float rc_max_available_vbv_use();
    
    public native AVCodecContext rc_max_available_vbv_use(float paramFloat);
    
    public native int rc_max_rate();
    
    public native AVCodecContext rc_max_rate(int paramInt);
    
    public native int rc_min_rate();
    
    public native AVCodecContext rc_min_rate(int paramInt);
    
    public native float rc_min_vbv_overflow_use();
    
    public native AVCodecContext rc_min_vbv_overflow_use(float paramFloat);
    
    public native AVCodecContext rc_override(RcOverride paramRcOverride);
    
    public native RcOverride rc_override();
    
    public native int rc_override_count();
    
    public native AVCodecContext rc_override_count(int paramInt);
    
    public native float rc_qmod_amp();
    
    public native AVCodecContext rc_qmod_amp(float paramFloat);
    
    public native int rc_qmod_freq();
    
    public native AVCodecContext rc_qmod_freq(int paramInt);
    
    public native float rc_qsquish();
    
    public native AVCodecContext rc_qsquish(float paramFloat);
    
    public native int rc_strategy();
    
    public native AVCodecContext rc_strategy(int paramInt);
    
    public native int refs();
    
    public native AVCodecContext refs(int paramInt);
    
    public native Reget_buffer reget_buffer();
    
    public native AVCodecContext reget_buffer(Reget_buffer paramReget_buffer);
    
    public native Release_buffer release_buffer();
    
    public native AVCodecContext release_buffer(Release_buffer paramRelease_buffer);
    
    @Cast({"uint64_t"})
    public native long request_channel_layout();
    
    public native AVCodecContext request_channel_layout(long paramLong);
    
    @Cast({"AVSampleFormat"})
    public native int request_sample_fmt();
    
    public native AVCodecContext request_sample_fmt(int paramInt);
    
    public native Rtp_callback rtp_callback();
    
    public native AVCodecContext rtp_callback(Rtp_callback paramRtp_callback);
    
    public native int rtp_payload_size();
    
    public native AVCodecContext rtp_payload_size(int paramInt);
    
    public native AVCodecContext sample_aspect_ratio(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational sample_aspect_ratio();
    
    @Cast({"AVSampleFormat"})
    public native int sample_fmt();
    
    public native AVCodecContext sample_fmt(int paramInt);
    
    public native int sample_rate();
    
    public native AVCodecContext sample_rate(int paramInt);
    
    public native int scenechange_factor();
    
    public native AVCodecContext scenechange_factor(int paramInt);
    
    public native int scenechange_threshold();
    
    public native AVCodecContext scenechange_threshold(int paramInt);
    
    public native int skip_bottom();
    
    public native AVCodecContext skip_bottom(int paramInt);
    
    public native int skip_count();
    
    public native AVCodecContext skip_count(int paramInt);
    
    @Cast({"AVDiscard"})
    public native int skip_frame();
    
    public native AVCodecContext skip_frame(int paramInt);
    
    @Cast({"AVDiscard"})
    public native int skip_idct();
    
    public native AVCodecContext skip_idct(int paramInt);
    
    @Cast({"AVDiscard"})
    public native int skip_loop_filter();
    
    public native AVCodecContext skip_loop_filter(int paramInt);
    
    public native int skip_top();
    
    public native AVCodecContext skip_top(int paramInt);
    
    public native int slice_count();
    
    public native AVCodecContext slice_count(int paramInt);
    
    public native int slice_flags();
    
    public native AVCodecContext slice_flags(int paramInt);
    
    public native IntPointer slice_offset();
    
    public native AVCodecContext slice_offset(IntPointer paramIntPointer);
    
    public native int slices();
    
    public native AVCodecContext slices(int paramInt);
    
    public native float spatial_cplx_masking();
    
    public native AVCodecContext spatial_cplx_masking(float paramFloat);
    
    @Cast({"char*"})
    public native BytePointer stats_in();
    
    public native AVCodecContext stats_in(BytePointer paramBytePointer);
    
    @Cast({"char*"})
    public native BytePointer stats_out();
    
    public native AVCodecContext stats_out(BytePointer paramBytePointer);
    
    @Cast({"unsigned int"})
    public native int stream_codec_tag();
    
    public native AVCodecContext stream_codec_tag(int paramInt);
    
    public native int strict_std_compliance();
    
    public native AVCodecContext strict_std_compliance(int paramInt);
    
    @Cast({"char*"})
    public native BytePointer sub_charenc();
    
    public native AVCodecContext sub_charenc(BytePointer paramBytePointer);
    
    public native int sub_charenc_mode();
    
    public native AVCodecContext sub_charenc_mode(int paramInt);
    
    @Cast({"uint8_t*"})
    public native BytePointer subtitle_header();
    
    public native AVCodecContext subtitle_header(BytePointer paramBytePointer);
    
    public native int subtitle_header_size();
    
    public native AVCodecContext subtitle_header_size(int paramInt);
    
    public native float temporal_cplx_masking();
    
    public native AVCodecContext temporal_cplx_masking(float paramFloat);
    
    public native int thread_count();
    
    public native AVCodecContext thread_count(int paramInt);
    
    public native Pointer thread_opaque();
    
    public native AVCodecContext thread_opaque(Pointer paramPointer);
    
    public native int thread_safe_callbacks();
    
    public native AVCodecContext thread_safe_callbacks(int paramInt);
    
    public native int thread_type();
    
    public native AVCodecContext thread_type(int paramInt);
    
    public native int ticks_per_frame();
    
    public native AVCodecContext ticks_per_frame(int paramInt);
    
    public native AVCodecContext time_base(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational time_base();
    
    public native long timecode_frame_start();
    
    public native AVCodecContext timecode_frame_start(long paramLong);
    
    public native int trellis();
    
    public native AVCodecContext trellis(int paramInt);
    
    public native long vbv_delay();
    
    public native AVCodecContext vbv_delay(long paramLong);
    
    public native int width();
    
    public native AVCodecContext width(int paramInt);
    
    public native int workaround_bugs();
    
    public native AVCodecContext workaround_bugs(int paramInt);
    
    public native int xvmc_acceleration();
    
    public native AVCodecContext xvmc_acceleration(int paramInt);
    
    public static class Draw_horiz_band
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Draw_horiz_band()
      {
        allocate();
      }
      
      public Draw_horiz_band(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVCodecContext paramAVCodecContext, @Const avcodec.AVFrame paramAVFrame, IntPointer paramIntPointer, int paramInt1, int paramInt2, int paramInt3);
    }
    
    public static class Execute
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Execute()
      {
        allocate();
      }
      
      public Execute(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecContext paramAVCodecContext, Func paramFunc, Pointer paramPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2);
      
      public static class Func
        extends FunctionPointer
      {
        static
        {
          Loader.load();
        }
        
        protected Func()
        {
          allocate();
        }
        
        public Func(Pointer paramPointer)
        {
          super();
        }
        
        private native void allocate();
        
        public native int call(AVCodecContext paramAVCodecContext, Pointer paramPointer);
      }
    }
    
    public static class Execute2
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Execute2()
      {
        allocate();
      }
      
      public Execute2(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecContext paramAVCodecContext, Func2 paramFunc2, Pointer paramPointer, IntPointer paramIntPointer, int paramInt);
      
      public static class Func2
        extends FunctionPointer
      {
        static
        {
          Loader.load();
        }
        
        protected Func2()
        {
          allocate();
        }
        
        public Func2(Pointer paramPointer)
        {
          super();
        }
        
        private native void allocate();
        
        public native int call(AVCodecContext paramAVCodecContext, Pointer paramPointer, int paramInt1, int paramInt2);
      }
    }
    
    public static class Get_buffer
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Get_buffer()
      {
        allocate();
      }
      
      public Get_buffer(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame);
    }
    
    public static class Get_format
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Get_format()
      {
        allocate();
      }
      
      public Get_format(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      @Cast({"AVPixelFormat"})
      public native int call(AVCodecContext paramAVCodecContext, @Cast({"const AVPixelFormat*"}) IntPointer paramIntPointer);
    }
    
    public static class Reget_buffer
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Reget_buffer()
      {
        allocate();
      }
      
      public Reget_buffer(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame);
    }
    
    public static class Release_buffer
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Release_buffer()
      {
        allocate();
      }
      
      public Release_buffer(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVCodecContext paramAVCodecContext, AVFrame paramAVFrame);
    }
    
    public static class Rtp_callback
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Rtp_callback()
      {
        allocate();
      }
      
      public Rtp_callback(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVCodecContext paramAVCodecContext, Pointer paramPointer, int paramInt1, int paramInt2);
    }
  }
  
  @Opaque
  public static class AVCodecDefault
    extends Pointer
  {
    public AVCodecDefault() {}
    
    public AVCodecDefault(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVCodecDescriptor
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVCodecDescriptor()
    {
      allocate();
    }
    
    public AVCodecDescriptor(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVCodecDescriptor(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"AVCodecID"})
    public native int id();
    
    public native AVCodecDescriptor id(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer long_name();
    
    public native AVCodecDescriptor long_name(BytePointer paramBytePointer);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVCodecDescriptor name(BytePointer paramBytePointer);
    
    public AVCodecDescriptor position(int paramInt)
    {
      return (AVCodecDescriptor)super.position(paramInt);
    }
    
    public native int props();
    
    public native AVCodecDescriptor props(int paramInt);
    
    @Cast({"AVMediaType"})
    public native int type();
    
    public native AVCodecDescriptor type(int paramInt);
  }
  
  @Opaque
  public static class AVCodecInternal
    extends Pointer
  {
    public AVCodecInternal() {}
    
    public AVCodecInternal(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVCodecParser
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVCodecParser()
    {
      allocate();
    }
    
    public AVCodecParser(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVCodecParser(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int codec_ids(int paramInt);
    
    public native AVCodecParser codec_ids(int paramInt1, int paramInt2);
    
    public native AVCodecParser next();
    
    public native AVCodecParser next(AVCodecParser paramAVCodecParser);
    
    public native Parser_close parser_close();
    
    public native AVCodecParser parser_close(Parser_close paramParser_close);
    
    public native Parser_init parser_init();
    
    public native AVCodecParser parser_init(Parser_init paramParser_init);
    
    public native Parser_parse parser_parse();
    
    public native AVCodecParser parser_parse(Parser_parse paramParser_parse);
    
    public AVCodecParser position(int paramInt)
    {
      return (AVCodecParser)super.position(paramInt);
    }
    
    public native int priv_data_size();
    
    public native AVCodecParser priv_data_size(int paramInt);
    
    public native Split split();
    
    public native AVCodecParser split(Split paramSplit);
    
    public static class Parser_close
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Parser_close()
      {
        allocate();
      }
      
      public Parser_close(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVCodecParserContext paramAVCodecParserContext);
    }
    
    public static class Parser_init
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Parser_init()
      {
        allocate();
      }
      
      public Parser_init(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecParserContext paramAVCodecParserContext);
    }
    
    public static class Parser_parse
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Parser_parse()
      {
        allocate();
      }
      
      public Parser_parse(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt);
    }
    
    public static class Split
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Split()
      {
        allocate();
      }
      
      public Split(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecContext paramAVCodecContext, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt);
    }
  }
  
  public static class AVCodecParserContext
    extends Pointer
  {
    public static final int AV_PARSER_PTS_NB = 4;
    public static final int PARSER_FLAG_COMPLETE_FRAMES = 1;
    public static final int PARSER_FLAG_FETCHED_OFFSET = 4;
    public static final int PARSER_FLAG_ONCE = 2;
    public static final int PARSER_FLAG_USE_CODEC_TS = 4096;
    
    static
    {
      Loader.load();
    }
    
    public AVCodecParserContext()
    {
      allocate();
    }
    
    public AVCodecParserContext(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVCodecParserContext(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native long convergence_duration();
    
    public native AVCodecParserContext convergence_duration(long paramLong);
    
    public native long cur_frame_dts(int paramInt);
    
    public native AVCodecParserContext cur_frame_dts(int paramInt, long paramLong);
    
    public native long cur_frame_end(int paramInt);
    
    public native AVCodecParserContext cur_frame_end(int paramInt, long paramLong);
    
    public native long cur_frame_offset(int paramInt);
    
    public native AVCodecParserContext cur_frame_offset(int paramInt, long paramLong);
    
    public native long cur_frame_pos(int paramInt);
    
    public native AVCodecParserContext cur_frame_pos(int paramInt, long paramLong);
    
    public native long cur_frame_pts(int paramInt);
    
    public native AVCodecParserContext cur_frame_pts(int paramInt, long paramLong);
    
    public native int cur_frame_start_index();
    
    public native AVCodecParserContext cur_frame_start_index(int paramInt);
    
    public native long cur_offset();
    
    public native AVCodecParserContext cur_offset(long paramLong);
    
    public native long dts();
    
    public native AVCodecParserContext dts(long paramLong);
    
    public native int dts_ref_dts_delta();
    
    public native AVCodecParserContext dts_ref_dts_delta(int paramInt);
    
    public native int dts_sync_point();
    
    public native AVCodecParserContext dts_sync_point(int paramInt);
    
    public native int duration();
    
    public native AVCodecParserContext duration(int paramInt);
    
    public native int fetch_timestamp();
    
    public native AVCodecParserContext fetch_timestamp(int paramInt);
    
    public native int flags();
    
    public native AVCodecParserContext flags(int paramInt);
    
    public native long frame_offset();
    
    public native AVCodecParserContext frame_offset(long paramLong);
    
    public native int key_frame();
    
    public native AVCodecParserContext key_frame(int paramInt);
    
    public native long last_dts();
    
    public native AVCodecParserContext last_dts(long paramLong);
    
    public native long last_pos();
    
    public native AVCodecParserContext last_pos(long paramLong);
    
    public native long last_pts();
    
    public native AVCodecParserContext last_pts(long paramLong);
    
    public native long next_frame_offset();
    
    public native AVCodecParserContext next_frame_offset(long paramLong);
    
    public native long offset();
    
    public native AVCodecParserContext offset(long paramLong);
    
    public native AVCodecParser parser();
    
    public native AVCodecParserContext parser(AVCodecParser paramAVCodecParser);
    
    public native int pict_type();
    
    public native AVCodecParserContext pict_type(int paramInt);
    
    public native long pos();
    
    public native AVCodecParserContext pos(long paramLong);
    
    public AVCodecParserContext position(int paramInt)
    {
      return (AVCodecParserContext)super.position(paramInt);
    }
    
    public native Pointer priv_data();
    
    public native AVCodecParserContext priv_data(Pointer paramPointer);
    
    public native long pts();
    
    public native AVCodecParserContext pts(long paramLong);
    
    public native int pts_dts_delta();
    
    public native AVCodecParserContext pts_dts_delta(int paramInt);
    
    public native int repeat_pict();
    
    public native AVCodecParserContext repeat_pict(int paramInt);
  }
  
  public static class AVFrame
    extends AVPicture
  {
    public static final int AV_NUM_DATA_POINTERS = 8;
    public static final int FF_DECODE_ERROR_INVALID_BITSTREAM = 1;
    public static final int FF_DECODE_ERROR_MISSING_REFERENCE = 2;
    
    static
    {
      Loader.load();
    }
    
    public AVFrame()
    {
      allocate();
    }
    
    public AVFrame(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVFrame(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"uint8_t*"})
    public native BytePointer base(int paramInt);
    
    public native AVFrame base(int paramInt, BytePointer paramBytePointer);
    
    public native long best_effort_timestamp();
    
    public native AVFrame best_effort_timestamp(long paramLong);
    
    public native int buffer_hints();
    
    public native AVFrame buffer_hints(int paramInt);
    
    @Cast({"uint64_t"})
    public native long channel_layout();
    
    public native AVFrame channel_layout(long paramLong);
    
    public native int channels();
    
    public native AVFrame channels(int paramInt);
    
    public native int coded_picture_number();
    
    public native AVFrame coded_picture_number(int paramInt);
    
    public native ShortPointer dct_coeff();
    
    public native AVFrame dct_coeff(ShortPointer paramShortPointer);
    
    public native int decode_error_flags();
    
    public native AVFrame decode_error_flags(int paramInt);
    
    public native int display_picture_number();
    
    public native AVFrame display_picture_number(int paramInt);
    
    @Cast({"uint64_t"})
    public native int error(long paramLong);
    
    public native AVFrame error(long paramLong, int paramInt);
    
    @Cast({"uint8_t**"})
    public native PointerPointer extended_data();
    
    public native AVFrame extended_data(PointerPointer paramPointerPointer);
    
    public native int format();
    
    public native AVFrame format(int paramInt);
    
    public native int height();
    
    public native AVFrame height(int paramInt);
    
    public native Pointer hwaccel_picture_private();
    
    public native AVFrame hwaccel_picture_private(Pointer paramPointer);
    
    public native int interlaced_frame();
    
    public native AVFrame interlaced_frame(int paramInt);
    
    public native int key_frame();
    
    public native AVFrame key_frame(int paramInt);
    
    @Cast({"uint32_t*"})
    public native IntPointer mb_type();
    
    public native AVFrame mb_type(IntPointer paramIntPointer);
    
    @Cast({"uint8_t*"})
    public native BytePointer mbskip_table();
    
    public native AVFrame mbskip_table(BytePointer paramBytePointer);
    
    public native AVFrame metadata(avutil.AVDictionary paramAVDictionary);
    
    public native avutil.AVDictionary metadata();
    
    @Cast({"uint8_t"})
    public native int motion_subsample_log2();
    
    public native AVFrame motion_subsample_log2(int paramInt);
    
    @Cast({"int16_t (*)[2]"})
    public native PointerPointer motion_val(int paramInt);
    
    public native AVFrame motion_val(int paramInt1, int paramInt2, int paramInt3, short paramShort);
    
    public native AVFrame motion_val(int paramInt, PointerPointer paramPointerPointer);
    
    public native short motion_val(int paramInt1, int paramInt2, int paramInt3);
    
    public native int nb_samples();
    
    public native AVFrame nb_samples(int paramInt);
    
    public native Pointer opaque();
    
    public native AVFrame opaque(Pointer paramPointer);
    
    public native AVCodecContext owner();
    
    public native AVFrame owner(AVCodecContext paramAVCodecContext);
    
    public native int palette_has_changed();
    
    public native AVFrame palette_has_changed(int paramInt);
    
    public native AVFrame pan_scan(AVPanScan paramAVPanScan);
    
    public native AVPanScan pan_scan();
    
    @Cast({"AVPictureType"})
    public native int pict_type();
    
    public native AVFrame pict_type(int paramInt);
    
    public native long pkt_dts();
    
    public native AVFrame pkt_dts(long paramLong);
    
    public native long pkt_duration();
    
    public native AVFrame pkt_duration(long paramLong);
    
    public native long pkt_pos();
    
    public native AVFrame pkt_pos(long paramLong);
    
    public native long pkt_pts();
    
    public native AVFrame pkt_pts(long paramLong);
    
    public native int pkt_size();
    
    public native AVFrame pkt_size(int paramInt);
    
    public AVFrame position(int paramInt)
    {
      return (AVFrame)super.position(paramInt);
    }
    
    public native long pts();
    
    public native AVFrame pts(long paramLong);
    
    @Cast({"int8_t*"})
    public native BytePointer qscale_table();
    
    public native AVFrame qscale_table(BytePointer paramBytePointer);
    
    public native int qscale_type();
    
    public native AVFrame qscale_type(int paramInt);
    
    public native int qstride();
    
    public native AVFrame qstride(int paramInt);
    
    public native int quality();
    
    public native AVFrame quality(int paramInt);
    
    @Cast({"int8_t*"})
    public native BytePointer ref_index(int paramInt);
    
    public native AVFrame ref_index(int paramInt, BytePointer paramBytePointer);
    
    public native int reference();
    
    public native AVFrame reference(int paramInt);
    
    public native int repeat_pict();
    
    public native AVFrame repeat_pict(int paramInt);
    
    public native AVFrame sample_aspect_ratio(avutil.AVRational paramAVRational);
    
    @ByRef
    public native avutil.AVRational sample_aspect_ratio();
    
    public native int sample_rate();
    
    public native AVFrame sample_rate(int paramInt);
    
    public native Pointer thread_opaque();
    
    public native AVFrame thread_opaque(Pointer paramPointer);
    
    public native int top_field_first();
    
    public native AVFrame top_field_first(int paramInt);
    
    public native int type();
    
    public native AVFrame type(int paramInt);
    
    public native int width();
    
    public native AVFrame width(int paramInt);
  }
  
  public static class AVHWAccel
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVHWAccel()
    {
      allocate();
    }
    
    public AVHWAccel(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVHWAccel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int capabilities();
    
    public native AVHWAccel capabilities(int paramInt);
    
    public native Decode_slice decode_slice();
    
    public native AVHWAccel decode_slice(Decode_slice paramDecode_slice);
    
    public native End_frame end_frame();
    
    public native AVHWAccel end_frame(End_frame paramEnd_frame);
    
    @Cast({"AVCodecID"})
    public native int id();
    
    public native AVHWAccel id(int paramInt);
    
    @Cast({"const char *"})
    public native BytePointer name();
    
    public native AVHWAccel name(BytePointer paramBytePointer);
    
    public native AVHWAccel next();
    
    public native AVHWAccel next(AVHWAccel paramAVHWAccel);
    
    @Cast({"AVPixelFormat"})
    public native int pix_fmt();
    
    public native AVHWAccel pix_fmt(int paramInt);
    
    public AVHWAccel position(int paramInt)
    {
      return (AVHWAccel)super.position(paramInt);
    }
    
    public native int priv_data_size();
    
    public native AVHWAccel priv_data_size(int paramInt);
    
    public native Start_frame start_frame();
    
    public native AVHWAccel start_frame(Start_frame paramStart_frame);
    
    @Cast({"AVMediaType"})
    public native int type();
    
    public native AVHWAccel type(int paramInt);
    
    public static class Decode_slice
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Decode_slice()
      {
        allocate();
      }
      
      public Decode_slice(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native int call(AVCodecContext paramAVCodecContext, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"uint32_t"}) int paramInt);
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
      
      public native int call(AVCodecContext paramAVCodecContext);
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
      
      public native int call(AVCodecContext paramAVCodecContext, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"uint32_t"}) int paramInt);
    }
  }
  
  public static class AVPacket
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVPacket()
    {
      allocate();
    }
    
    public AVPacket(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVPacket(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native long convergence_duration();
    
    public native AVPacket convergence_duration(long paramLong);
    
    @Cast({"uint8_t*"})
    public native BytePointer data();
    
    public native AVPacket data(BytePointer paramBytePointer);
    
    public native Destruct destruct();
    
    public native AVPacket destruct(Destruct paramDestruct);
    
    public native long dts();
    
    public native AVPacket dts(long paramLong);
    
    public native int duration();
    
    public native AVPacket duration(int paramInt);
    
    public native int flags();
    
    public native AVPacket flags(int paramInt);
    
    public native long pos();
    
    public native AVPacket pos(long paramLong);
    
    public AVPacket position(int paramInt)
    {
      return (AVPacket)super.position(paramInt);
    }
    
    public native Pointer priv();
    
    public native AVPacket priv(Pointer paramPointer);
    
    public native long pts();
    
    public native AVPacket pts(long paramLong);
    
    @Cast({"uint8_t*"})
    @Name({"side_data", ".data"})
    public native BytePointer side_data_data(int paramInt);
    
    public native AVPacket side_data_data(int paramInt, BytePointer paramBytePointer);
    
    public native int side_data_elems();
    
    public native AVPacket side_data_elems(int paramInt);
    
    @Name({"side_data", ".size"})
    public native int side_data_size(int paramInt);
    
    public native AVPacket side_data_size(int paramInt1, int paramInt2);
    
    @Cast({"AVPacketSideDataType"})
    @Name({"side_data", ".type"})
    public native int side_data_type(int paramInt);
    
    public native AVPacket side_data_type(int paramInt1, int paramInt2);
    
    public native int size();
    
    public native AVPacket size(int paramInt);
    
    public native int stream_index();
    
    public native AVPacket stream_index(int paramInt);
    
    public static class Destruct
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      protected Destruct()
      {
        allocate();
      }
      
      public Destruct(Pointer paramPointer)
      {
        super();
      }
      
      private native void allocate();
      
      public native void call(AVPacket paramAVPacket);
    }
  }
  
  public static class AVPanScan
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVPanScan()
    {
      allocate();
    }
    
    public AVPanScan(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVPanScan(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int height();
    
    public native AVPanScan height(int paramInt);
    
    public native int id();
    
    public native AVPanScan id(int paramInt);
    
    public AVPanScan position(int paramInt)
    {
      return (AVPanScan)super.position(paramInt);
    }
    
    public native AVPanScan position(int paramInt1, int paramInt2, short paramShort);
    
    public native short position(int paramInt1, int paramInt2);
    
    public native int width();
    
    public native AVPanScan width(int paramInt);
  }
  
  public static class AVPicture
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVPicture()
    {
      allocate();
    }
    
    public AVPicture(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVPicture(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"uint8_t*"})
    public native BytePointer data(int paramInt);
    
    @Cast({"uint8_t**"})
    @MemberGetter
    public native PointerPointer data();
    
    public native AVPicture data(int paramInt, BytePointer paramBytePointer);
    
    public native int linesize(int paramInt);
    
    @MemberGetter
    public native IntPointer linesize();
    
    public native AVPicture linesize(int paramInt1, int paramInt2);
    
    public AVPicture position(int paramInt)
    {
      return (AVPicture)super.position(paramInt);
    }
  }
  
  public static class AVProfile
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVProfile()
    {
      allocate();
    }
    
    public AVProfile(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVProfile(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"const char*"})
    public native BytePointer name();
    
    public native AVProfile name(BytePointer paramBytePointer);
    
    public AVProfile position(int paramInt)
    {
      return (AVProfile)super.position(paramInt);
    }
    
    public native int profile();
    
    public native AVProfile profile(int paramInt);
  }
  
  @Opaque
  public static class AVResampleContext
    extends Pointer
  {
    public AVResampleContext() {}
    
    public AVResampleContext(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class AVSubtitle
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVSubtitle()
    {
      allocate();
    }
    
    public AVSubtitle(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVSubtitle(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int end_display_time();
    
    public native AVSubtitle end_display_time(int paramInt);
    
    public native AVSubtitle format(short paramShort);
    
    public native short format();
    
    public native int num_rects();
    
    public native AVSubtitle num_rects(int paramInt);
    
    public AVSubtitle position(int paramInt)
    {
      return (AVSubtitle)super.position(paramInt);
    }
    
    public native long pts();
    
    public native AVSubtitle pts(long paramLong);
    
    @Cast({"AVSubtitleRect**"})
    public native PointerPointer rects();
    
    public native AVSubtitle rects(PointerPointer paramPointerPointer);
    
    public native int start_display_time();
    
    public native AVSubtitle start_display_time(int paramInt);
  }
  
  public static class AVSubtitleRect
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public AVSubtitleRect()
    {
      allocate();
    }
    
    public AVSubtitleRect(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public AVSubtitleRect(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @Cast({"char *"})
    public native BytePointer ass();
    
    public native AVSubtitleRect ass(BytePointer paramBytePointer);
    
    public native int flags();
    
    public native AVSubtitleRect flags(int paramInt);
    
    public native int h();
    
    public native AVSubtitleRect h(int paramInt);
    
    public native int nb_colors();
    
    public native AVSubtitleRect nb_colors(int paramInt);
    
    @ByRef
    public native avcodec.AVPicture pict();
    
    public native AVSubtitleRect pict(AVPicture paramAVPicture);
    
    public AVSubtitleRect position(int paramInt)
    {
      return (AVSubtitleRect)super.position(paramInt);
    }
    
    @Cast({"char *"})
    public native BytePointer text();
    
    public native AVSubtitleRect text(BytePointer paramBytePointer);
    
    @Cast({"AVSubtitleType"})
    public native int type();
    
    public native AVSubtitleRect type(int paramInt);
    
    public native int w();
    
    public native AVSubtitleRect w(int paramInt);
    
    public native int x();
    
    public native AVSubtitleRect x(int paramInt);
    
    public native int y();
    
    public native AVSubtitleRect y(int paramInt);
  }
  
  public static class Cb
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected Cb()
    {
      allocate();
    }
    
    public Cb(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int call(PointerPointer paramPointerPointer, @Cast({"AVLockOp"}) int paramInt);
  }
  
  public static class RcOverride
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public RcOverride()
    {
      allocate();
    }
    
    public RcOverride(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public RcOverride(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int end_frame();
    
    public native RcOverride end_frame(int paramInt);
    
    public RcOverride position(int paramInt)
    {
      return (RcOverride)super.position(paramInt);
    }
    
    public native int qscale();
    
    public native RcOverride qscale(int paramInt);
    
    public native float quality_factor();
    
    public native RcOverride quality_factor(float paramFloat);
    
    public native int start_frame();
    
    public native RcOverride start_frame(int paramInt);
  }
  
  @Opaque
  public static class ReSampleContext
    extends Pointer
  {
    public ReSampleContext() {}
    
    public ReSampleContext(Pointer paramPointer)
    {
      super();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\avcodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */