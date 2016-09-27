package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzha
public class zzdz
  extends zzdw
{
  private static final Set<String> zzzv = Collections.synchronizedSet(new HashSet());
  private static final DecimalFormat zzzw = new DecimalFormat("#,###");
  private File zzzx;
  private boolean zzzy;
  
  public zzdz(zzjn paramzzjn)
  {
    super(paramzzjn);
    File localFile = paramzzjn.getContext().getCacheDir();
    if (localFile == null) {
      zzb.zzaH("Context.getCacheDir() returned null");
    }
    do
    {
      return;
      this.zzzx = new File(localFile, "admobVideoStreams");
      if ((!this.zzzx.isDirectory()) && (!this.zzzx.mkdirs()))
      {
        zzb.zzaH("Could not create preload cache directory at " + this.zzzx.getAbsolutePath());
        this.zzzx = null;
        return;
      }
    } while ((this.zzzx.setReadable(true, false)) && (this.zzzx.setExecutable(true, false)));
    zzb.zzaH("Could not set cache file permissions at " + this.zzzx.getAbsolutePath());
    this.zzzx = null;
  }
  
  private File zza(File paramFile)
  {
    return new File(this.zzzx, paramFile.getName() + ".done");
  }
  
  private static void zzb(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.setLastModified(System.currentTimeMillis());
      return;
    }
    try
    {
      paramFile.createNewFile();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void abort()
  {
    this.zzzy = true;
  }
  
  /* Error */
  public boolean zzZ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/google/android/gms/internal/zzdz:zzzx	Ljava/io/File;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: aload_1
    //   9: aconst_null
    //   10: ldc -117
    //   12: aconst_null
    //   13: invokevirtual 142	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: invokevirtual 146	com/google/android/gms/internal/zzdz:zzdT	()I
    //   22: getstatic 152	com/google/android/gms/internal/zzbz:zzvt	Lcom/google/android/gms/internal/zzbv;
    //   25: invokevirtual 158	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   28: checkcast 160	java/lang/Integer
    //   31: invokevirtual 163	java/lang/Integer:intValue	()I
    //   34: if_icmple +26 -> 60
    //   37: aload_0
    //   38: invokevirtual 166	com/google/android/gms/internal/zzdz:zzdU	()Z
    //   41: ifne -23 -> 18
    //   44: ldc -88
    //   46: invokestatic 60	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: aconst_null
    //   52: ldc -86
    //   54: aconst_null
    //   55: invokevirtual 142	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 174	com/google/android/gms/internal/zzdz:zzaa	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_2
    //   66: new 62	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: getfield 69	com/google/android/gms/internal/zzdz:zzzx	Ljava/io/File;
    //   74: aload_2
    //   75: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   78: astore_3
    //   79: aload_0
    //   80: aload_3
    //   81: invokespecial 176	com/google/android/gms/internal/zzdz:zza	(Ljava/io/File;)Ljava/io/File;
    //   84: astore 4
    //   86: aload_3
    //   87: invokevirtual 115	java/io/File:isFile	()Z
    //   90: ifeq +53 -> 143
    //   93: aload 4
    //   95: invokevirtual 115	java/io/File:isFile	()Z
    //   98: ifeq +45 -> 143
    //   101: aload_3
    //   102: invokevirtual 179	java/io/File:length	()J
    //   105: l2i
    //   106: istore 47
    //   108: new 78	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   115: ldc -75
    //   117: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 184	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: aload_1
    //   132: aload_3
    //   133: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   136: iload 47
    //   138: invokevirtual 187	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;I)V
    //   141: iconst_1
    //   142: ireturn
    //   143: new 78	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   150: aload_0
    //   151: getfield 69	com/google/android/gms/internal/zzdz:zzzx	Ljava/io/File;
    //   154: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   157: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore 5
    //   169: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   172: astore 6
    //   174: aload 6
    //   176: monitorenter
    //   177: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   180: aload 5
    //   182: invokeinterface 193 2 0
    //   187: ifeq +50 -> 237
    //   190: new 78	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   197: ldc -61
    //   199: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 60	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   212: aload_0
    //   213: aload_1
    //   214: aload_3
    //   215: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: ldc -59
    //   220: aconst_null
    //   221: invokevirtual 142	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 6
    //   226: monitorexit
    //   227: iconst_0
    //   228: ireturn
    //   229: astore 7
    //   231: aload 6
    //   233: monitorexit
    //   234: aload 7
    //   236: athrow
    //   237: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   240: aload 5
    //   242: invokeinterface 200 2 0
    //   247: pop
    //   248: aload 6
    //   250: monitorexit
    //   251: aconst_null
    //   252: astore 9
    //   254: new 202	java/net/URL
    //   257: dup
    //   258: aload_1
    //   259: invokespecial 203	java/net/URL:<init>	(Ljava/lang/String;)V
    //   262: invokevirtual 207	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   265: astore 16
    //   267: getstatic 210	com/google/android/gms/internal/zzbz:zzvy	Lcom/google/android/gms/internal/zzbv;
    //   270: invokevirtual 158	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   273: checkcast 160	java/lang/Integer
    //   276: invokevirtual 163	java/lang/Integer:intValue	()I
    //   279: istore 17
    //   281: aload 16
    //   283: iload 17
    //   285: invokevirtual 216	java/net/URLConnection:setConnectTimeout	(I)V
    //   288: aload 16
    //   290: iload 17
    //   292: invokevirtual 219	java/net/URLConnection:setReadTimeout	(I)V
    //   295: aload 16
    //   297: instanceof 221
    //   300: ifeq +217 -> 517
    //   303: aload 16
    //   305: checkcast 221	java/net/HttpURLConnection
    //   308: invokevirtual 224	java/net/HttpURLConnection:getResponseCode	()I
    //   311: istore 45
    //   313: iload 45
    //   315: sipush 400
    //   318: if_icmplt +199 -> 517
    //   321: ldc -30
    //   323: astore 11
    //   325: new 78	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   332: ldc -28
    //   334: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: iload 45
    //   339: invokestatic 231	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   342: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: astore 46
    //   350: aload 46
    //   352: astore 12
    //   354: new 112	java/io/IOException
    //   357: dup
    //   358: new 78	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   365: ldc -23
    //   367: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload 45
    //   372: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: ldc -18
    //   377: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokespecial 239	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   390: athrow
    //   391: astore 10
    //   393: aload 10
    //   395: instanceof 135
    //   398: ifeq +12 -> 410
    //   401: invokestatic 245	com/google/android/gms/ads/internal/zzp:zzbA	()Lcom/google/android/gms/internal/zzig;
    //   404: aload 10
    //   406: iconst_1
    //   407: invokevirtual 250	com/google/android/gms/internal/zzig:zzb	(Ljava/lang/Throwable;Z)V
    //   410: aload 9
    //   412: invokevirtual 255	java/io/FileOutputStream:close	()V
    //   415: aload_0
    //   416: getfield 131	com/google/android/gms/internal/zzdz:zzzy	Z
    //   419: ifeq +741 -> 1160
    //   422: new 78	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 257
    //   432: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 259
    //   442: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 262	com/google/android/gms/ads/internal/util/client/zzb:zzaG	(Ljava/lang/String;)V
    //   451: aload_3
    //   452: invokevirtual 265	java/io/File:exists	()Z
    //   455: ifeq +36 -> 491
    //   458: aload_3
    //   459: invokevirtual 268	java/io/File:delete	()Z
    //   462: ifne +29 -> 491
    //   465: new 78	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 270
    //   475: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_3
    //   479: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 60	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   491: aload_0
    //   492: aload_1
    //   493: aload_3
    //   494: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   497: aload 11
    //   499: aload 12
    //   501: invokevirtual 142	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   504: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   507: aload 5
    //   509: invokeinterface 273 2 0
    //   514: pop
    //   515: iconst_0
    //   516: ireturn
    //   517: aload 16
    //   519: invokevirtual 276	java/net/URLConnection:getContentLength	()I
    //   522: istore 18
    //   524: iload 18
    //   526: ifge +52 -> 578
    //   529: new 78	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 278
    //   539: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_1
    //   543: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 60	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: aload_1
    //   554: aload_3
    //   555: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   558: ldc_w 280
    //   561: aconst_null
    //   562: invokevirtual 142	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   565: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   568: aload 5
    //   570: invokeinterface 273 2 0
    //   575: pop
    //   576: iconst_0
    //   577: ireturn
    //   578: getstatic 38	com/google/android/gms/internal/zzdz:zzzw	Ljava/text/DecimalFormat;
    //   581: iload 18
    //   583: i2l
    //   584: invokevirtual 284	java/text/DecimalFormat:format	(J)Ljava/lang/String;
    //   587: astore 20
    //   589: getstatic 287	com/google/android/gms/internal/zzbz:zzvu	Lcom/google/android/gms/internal/zzbv;
    //   592: invokevirtual 158	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   595: checkcast 160	java/lang/Integer
    //   598: invokevirtual 163	java/lang/Integer:intValue	()I
    //   601: istore 21
    //   603: iload 18
    //   605: iload 21
    //   607: if_icmple +87 -> 694
    //   610: new 78	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 289
    //   620: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 20
    //   625: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc_w 291
    //   631: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_1
    //   635: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 60	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   644: new 78	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 293
    //   654: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload 20
    //   659: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: astore 22
    //   667: aload_0
    //   668: aload_1
    //   669: aload_3
    //   670: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   673: ldc_w 295
    //   676: aload 22
    //   678: invokevirtual 142	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   681: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   684: aload 5
    //   686: invokeinterface 273 2 0
    //   691: pop
    //   692: iconst_0
    //   693: ireturn
    //   694: new 78	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 297
    //   704: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload 20
    //   709: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: ldc_w 299
    //   715: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload_1
    //   719: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 184	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   728: aload 16
    //   730: invokevirtual 303	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   733: invokestatic 309	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
    //   736: astore 24
    //   738: new 252	java/io/FileOutputStream
    //   741: dup
    //   742: aload_3
    //   743: invokespecial 311	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   746: astore 25
    //   748: aload 25
    //   750: invokevirtual 315	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   753: astore 26
    //   755: ldc_w 316
    //   758: invokestatic 322	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   761: astore 27
    //   763: invokestatic 326	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   766: astore 28
    //   768: iconst_0
    //   769: istore 29
    //   771: aload 28
    //   773: invokeinterface 329 1 0
    //   778: lstore 30
    //   780: getstatic 332	com/google/android/gms/internal/zzbz:zzvx	Lcom/google/android/gms/internal/zzbv;
    //   783: invokevirtual 158	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   786: checkcast 334	java/lang/Long
    //   789: invokevirtual 337	java/lang/Long:longValue	()J
    //   792: lstore 32
    //   794: new 339	com/google/android/gms/internal/zzix
    //   797: dup
    //   798: lload 32
    //   800: invokespecial 342	com/google/android/gms/internal/zzix:<init>	(J)V
    //   803: astore 34
    //   805: getstatic 345	com/google/android/gms/internal/zzbz:zzvw	Lcom/google/android/gms/internal/zzbv;
    //   808: invokevirtual 158	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   811: checkcast 334	java/lang/Long
    //   814: invokevirtual 337	java/lang/Long:longValue	()J
    //   817: lstore 35
    //   819: aload 24
    //   821: aload 27
    //   823: invokeinterface 351 2 0
    //   828: istore 37
    //   830: iload 37
    //   832: iflt +235 -> 1067
    //   835: iload 29
    //   837: iload 37
    //   839: iadd
    //   840: istore 29
    //   842: iload 29
    //   844: iload 21
    //   846: if_icmple +58 -> 904
    //   849: ldc_w 295
    //   852: astore 11
    //   854: new 78	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 293
    //   864: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: iload 29
    //   869: invokestatic 231	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   872: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: astore 44
    //   880: aload 44
    //   882: astore 12
    //   884: new 112	java/io/IOException
    //   887: dup
    //   888: ldc_w 353
    //   891: invokespecial 239	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   894: athrow
    //   895: astore 10
    //   897: aload 25
    //   899: astore 9
    //   901: goto -508 -> 393
    //   904: aload 27
    //   906: invokevirtual 357	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   909: pop
    //   910: aload 26
    //   912: aload 27
    //   914: invokevirtual 362	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   917: ifgt -7 -> 910
    //   920: aload 27
    //   922: invokevirtual 365	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   925: pop
    //   926: aload 28
    //   928: invokeinterface 329 1 0
    //   933: lload 30
    //   935: lsub
    //   936: ldc2_w 366
    //   939: lload 35
    //   941: lmul
    //   942: lcmp
    //   943: ifle +64 -> 1007
    //   946: ldc_w 369
    //   949: astore 11
    //   951: new 78	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 371
    //   961: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: lload 35
    //   966: invokestatic 373	java/lang/Long:toString	(J)Ljava/lang/String;
    //   969: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: ldc_w 375
    //   975: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: astore 43
    //   983: aload 43
    //   985: astore 12
    //   987: new 112	java/io/IOException
    //   990: dup
    //   991: ldc_w 377
    //   994: invokespecial 239	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   997: athrow
    //   998: astore 10
    //   1000: aload 25
    //   1002: astore 9
    //   1004: goto -611 -> 393
    //   1007: aload_0
    //   1008: getfield 131	com/google/android/gms/internal/zzdz:zzzy	Z
    //   1011: ifeq +31 -> 1042
    //   1014: ldc_w 379
    //   1017: astore 11
    //   1019: new 112	java/io/IOException
    //   1022: dup
    //   1023: ldc_w 381
    //   1026: invokespecial 239	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1029: athrow
    //   1030: astore 10
    //   1032: aload 25
    //   1034: astore 9
    //   1036: aconst_null
    //   1037: astore 12
    //   1039: goto -646 -> 393
    //   1042: aload 34
    //   1044: invokevirtual 384	com/google/android/gms/internal/zzix:tryAcquire	()Z
    //   1047: ifeq -228 -> 819
    //   1050: aload_0
    //   1051: aload_1
    //   1052: aload_3
    //   1053: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1056: iload 29
    //   1058: iload 18
    //   1060: iconst_0
    //   1061: invokevirtual 387	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;IIZ)V
    //   1064: goto -245 -> 819
    //   1067: aload 25
    //   1069: invokevirtual 255	java/io/FileOutputStream:close	()V
    //   1072: iconst_3
    //   1073: invokestatic 391	com/google/android/gms/ads/internal/util/client/zzb:zzQ	(I)Z
    //   1076: ifeq +48 -> 1124
    //   1079: getstatic 38	com/google/android/gms/internal/zzdz:zzzw	Ljava/text/DecimalFormat;
    //   1082: iload 29
    //   1084: i2l
    //   1085: invokevirtual 284	java/text/DecimalFormat:format	(J)Ljava/lang/String;
    //   1088: astore 40
    //   1090: new 78	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1097: ldc_w 393
    //   1100: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload 40
    //   1105: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: ldc_w 299
    //   1111: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: aload_1
    //   1115: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 184	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   1124: aload_3
    //   1125: iconst_1
    //   1126: iconst_0
    //   1127: invokevirtual 96	java/io/File:setReadable	(ZZ)Z
    //   1130: pop
    //   1131: aload 4
    //   1133: invokestatic 395	com/google/android/gms/internal/zzdz:zzb	(Ljava/io/File;)V
    //   1136: aload_0
    //   1137: aload_1
    //   1138: aload_3
    //   1139: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1142: iload 29
    //   1144: invokevirtual 187	com/google/android/gms/internal/zzdz:zza	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1147: getstatic 29	com/google/android/gms/internal/zzdz:zzzv	Ljava/util/Set;
    //   1150: aload 5
    //   1152: invokeinterface 273 2 0
    //   1157: pop
    //   1158: iconst_1
    //   1159: ireturn
    //   1160: new 78	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1167: ldc_w 397
    //   1170: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload_1
    //   1174: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: ldc_w 259
    //   1180: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: aload 10
    //   1188: invokestatic 401	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1191: goto -740 -> 451
    //   1194: astore 15
    //   1196: goto -781 -> 415
    //   1199: astore 13
    //   1201: goto -786 -> 415
    //   1204: astore 10
    //   1206: ldc_w 403
    //   1209: astore 11
    //   1211: aconst_null
    //   1212: astore 12
    //   1214: aconst_null
    //   1215: astore 9
    //   1217: goto -824 -> 393
    //   1220: astore 10
    //   1222: aconst_null
    //   1223: astore 12
    //   1225: aconst_null
    //   1226: astore 9
    //   1228: goto -835 -> 393
    //   1231: astore 10
    //   1233: aconst_null
    //   1234: astore 9
    //   1236: goto -843 -> 393
    //   1239: astore 10
    //   1241: ldc_w 403
    //   1244: astore 11
    //   1246: aload 25
    //   1248: astore 9
    //   1250: aconst_null
    //   1251: astore 12
    //   1253: goto -860 -> 393
    //   1256: astore 10
    //   1258: aload 25
    //   1260: astore 9
    //   1262: aconst_null
    //   1263: astore 12
    //   1265: goto -872 -> 393
    //   1268: astore 10
    //   1270: ldc_w 403
    //   1273: astore 11
    //   1275: aconst_null
    //   1276: astore 12
    //   1278: aconst_null
    //   1279: astore 9
    //   1281: goto -888 -> 393
    //   1284: astore 10
    //   1286: aconst_null
    //   1287: astore 12
    //   1289: aconst_null
    //   1290: astore 9
    //   1292: goto -899 -> 393
    //   1295: astore 10
    //   1297: ldc_w 403
    //   1300: astore 11
    //   1302: aload 25
    //   1304: astore 9
    //   1306: aconst_null
    //   1307: astore 12
    //   1309: goto -916 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1312	0	this	zzdz
    //   0	1312	1	paramString	String
    //   65	10	2	str1	String
    //   78	1061	3	localFile1	File
    //   84	1048	4	localFile2	File
    //   167	984	5	str2	String
    //   172	77	6	localSet	Set
    //   229	6	7	localObject1	Object
    //   252	1053	9	localObject2	Object
    //   391	14	10	localIOException1	IOException
    //   895	1	10	localIOException2	IOException
    //   998	1	10	localRuntimeException1	RuntimeException
    //   1030	157	10	localIOException3	IOException
    //   1204	1	10	localRuntimeException2	RuntimeException
    //   1220	1	10	localRuntimeException3	RuntimeException
    //   1231	1	10	localRuntimeException4	RuntimeException
    //   1239	1	10	localRuntimeException5	RuntimeException
    //   1256	1	10	localRuntimeException6	RuntimeException
    //   1268	1	10	localIOException4	IOException
    //   1284	1	10	localIOException5	IOException
    //   1295	1	10	localIOException6	IOException
    //   323	978	11	str3	String
    //   352	956	12	localObject3	Object
    //   1199	1	13	localNullPointerException	NullPointerException
    //   1194	1	15	localIOException7	IOException
    //   265	464	16	localURLConnection	java.net.URLConnection
    //   279	12	17	i	int
    //   522	537	18	j	int
    //   587	121	20	str4	String
    //   601	246	21	k	int
    //   665	12	22	str5	String
    //   736	84	24	localReadableByteChannel	java.nio.channels.ReadableByteChannel
    //   746	557	25	localFileOutputStream	java.io.FileOutputStream
    //   753	158	26	localFileChannel	java.nio.channels.FileChannel
    //   761	160	27	localByteBuffer	java.nio.ByteBuffer
    //   766	161	28	localzznl	zznl
    //   769	374	29	m	int
    //   778	156	30	l1	long
    //   792	7	32	l2	long
    //   803	240	34	localzzix	zzix
    //   817	148	35	l3	long
    //   828	12	37	n	int
    //   1088	16	40	str6	String
    //   981	3	43	str7	String
    //   878	3	44	str8	String
    //   311	60	45	i1	int
    //   348	3	46	str9	String
    //   106	31	47	i2	int
    // Exception table:
    //   from	to	target	type
    //   177	227	229	finally
    //   231	234	229	finally
    //   237	251	229	finally
    //   354	391	391	java/io/IOException
    //   884	895	895	java/io/IOException
    //   987	998	895	java/io/IOException
    //   884	895	998	java/lang/RuntimeException
    //   987	998	998	java/lang/RuntimeException
    //   854	880	1030	java/io/IOException
    //   951	983	1030	java/io/IOException
    //   1019	1030	1030	java/io/IOException
    //   410	415	1194	java/io/IOException
    //   410	415	1199	java/lang/NullPointerException
    //   254	313	1204	java/lang/RuntimeException
    //   517	524	1204	java/lang/RuntimeException
    //   529	576	1204	java/lang/RuntimeException
    //   578	603	1204	java/lang/RuntimeException
    //   610	692	1204	java/lang/RuntimeException
    //   694	748	1204	java/lang/RuntimeException
    //   325	350	1220	java/lang/RuntimeException
    //   354	391	1231	java/lang/RuntimeException
    //   748	768	1239	java/lang/RuntimeException
    //   771	819	1239	java/lang/RuntimeException
    //   819	830	1239	java/lang/RuntimeException
    //   904	910	1239	java/lang/RuntimeException
    //   910	946	1239	java/lang/RuntimeException
    //   1007	1014	1239	java/lang/RuntimeException
    //   1042	1064	1239	java/lang/RuntimeException
    //   1067	1124	1239	java/lang/RuntimeException
    //   1124	1158	1239	java/lang/RuntimeException
    //   854	880	1256	java/lang/RuntimeException
    //   951	983	1256	java/lang/RuntimeException
    //   1019	1030	1256	java/lang/RuntimeException
    //   254	313	1268	java/io/IOException
    //   517	524	1268	java/io/IOException
    //   529	576	1268	java/io/IOException
    //   578	603	1268	java/io/IOException
    //   610	692	1268	java/io/IOException
    //   694	748	1268	java/io/IOException
    //   325	350	1284	java/io/IOException
    //   748	768	1295	java/io/IOException
    //   771	819	1295	java/io/IOException
    //   819	830	1295	java/io/IOException
    //   904	910	1295	java/io/IOException
    //   910	946	1295	java/io/IOException
    //   1007	1014	1295	java/io/IOException
    //   1042	1064	1295	java/io/IOException
    //   1067	1124	1295	java/io/IOException
    //   1124	1158	1295	java/io/IOException
  }
  
  public int zzdT()
  {
    File localFile = this.zzzx;
    int i = 0;
    if (localFile == null) {}
    for (;;)
    {
      return i;
      File[] arrayOfFile = this.zzzx.listFiles();
      int j = arrayOfFile.length;
      for (int k = 0; k < j; k++) {
        if (!arrayOfFile[k].getName().endsWith(".done")) {
          i++;
        }
      }
    }
  }
  
  public boolean zzdU()
  {
    if (this.zzzx == null) {
      return false;
    }
    Object localObject1 = null;
    long l1 = Long.MAX_VALUE;
    File[] arrayOfFile = this.zzzx.listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    File localFile2;
    long l2;
    if (j < i)
    {
      localFile2 = arrayOfFile[j];
      if (localFile2.getName().endsWith(".done")) {
        break label133;
      }
      l2 = localFile2.lastModified();
      if (l2 >= l1) {
        break label133;
      }
    }
    for (Object localObject2 = localFile2;; localObject2 = localObject1)
    {
      j++;
      localObject1 = localObject2;
      l1 = l2;
      break;
      boolean bool;
      if (localObject1 != null)
      {
        bool = ((File)localObject1).delete();
        File localFile1 = zza((File)localObject1);
        if (localFile1.isFile()) {
          bool &= localFile1.delete();
        }
      }
      for (;;)
      {
        return bool;
        bool = false;
      }
      label133:
      l2 = l1;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */