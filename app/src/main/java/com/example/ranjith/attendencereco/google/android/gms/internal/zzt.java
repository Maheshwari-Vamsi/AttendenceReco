package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt
  implements zzf
{
  protected static final boolean DEBUG = zzs.DEBUG;
  private static int zzao = 3000;
  private static int zzap = 4096;
  protected final zzy zzaq;
  protected final zzu zzar;
  
  public zzt(zzy paramzzy)
  {
    this(paramzzy, new zzu(zzap));
  }
  
  public zzt(zzy paramzzy, zzu paramzzu)
  {
    this.zzaq = paramzzy;
    this.zzar = paramzzu;
  }
  
  protected static Map<String, String> zza(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < paramArrayOfHeader.length; i++) {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    }
    return localTreeMap;
  }
  
  private void zza(long paramLong, zzk<?> paramzzk, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    Object[] arrayOfObject;
    if ((DEBUG) || (paramLong > zzao))
    {
      arrayOfObject = new Object[5];
      arrayOfObject[0] = paramzzk;
      arrayOfObject[1] = Long.valueOf(paramLong);
      if (paramArrayOfByte == null) {
        break label91;
      }
    }
    label91:
    for (Object localObject = Integer.valueOf(paramArrayOfByte.length);; localObject = "null")
    {
      arrayOfObject[2] = localObject;
      arrayOfObject[3] = Integer.valueOf(paramStatusLine.getStatusCode());
      arrayOfObject[4] = Integer.valueOf(paramzzk.zzu().zze());
      zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", arrayOfObject);
      return;
    }
  }
  
  private static void zza(String paramString, zzk<?> paramzzk, zzr paramzzr)
    throws zzr
  {
    zzo localzzo = paramzzk.zzu();
    int i = paramzzk.zzt();
    try
    {
      localzzo.zza(paramzzr);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(i);
      paramzzk.zzc(String.format("%s-retry [timeout=%s]", arrayOfObject2));
      return;
    }
    catch (zzr localzzr)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(i);
      paramzzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", arrayOfObject1));
      throw localzzr;
    }
  }
  
  private void zza(Map<String, String> paramMap, zzb.zza paramzza)
  {
    if (paramzza == null) {}
    do
    {
      return;
      if (paramzza.zzb != null) {
        paramMap.put("If-None-Match", paramzza.zzb);
      }
    } while (paramzza.zzd <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramzza.zzd)));
  }
  
  private byte[] zza(HttpEntity paramHttpEntity)
    throws IOException, zzp
  {
    zzaa localzzaa = new zzaa(this.zzar, (int)paramHttpEntity.getContentLength());
    byte[] arrayOfByte1 = null;
    InputStream localInputStream;
    try
    {
      localInputStream = paramHttpEntity.getContent();
      arrayOfByte1 = null;
      if (localInputStream == null) {
        throw new zzp();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.zzar.zza(arrayOfByte1);
      localzzaa.close();
      throw ((Throwable)localObject);
      arrayOfByte1 = this.zzar.zzb(1024);
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte1);
        if (i == -1) {
          break;
        }
        localzzaa.write(arrayOfByte1, 0, i);
      }
      byte[] arrayOfByte2 = localzzaa.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.zzar.zza(arrayOfByte1);
        localzzaa.close();
        return arrayOfByte2;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          zzs.zza("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        zzs.zza("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public zzi zza(zzk<?> paramzzk)
    throws zzr
  {
    // Byte code:
    //   0: invokestatic 216	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: invokestatic 222	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 5
    //   12: new 224	java/util/HashMap
    //   15: dup
    //   16: invokespecial 225	java/util/HashMap:<init>	()V
    //   19: astore 6
    //   21: aload_0
    //   22: aload 6
    //   24: aload_1
    //   25: invokevirtual 229	com/google/android/gms/internal/zzk:zzi	()Lcom/google/android/gms/internal/zzb$zza;
    //   28: invokespecial 231	com/google/android/gms/internal/zzt:zza	(Ljava/util/Map;Lcom/google/android/gms/internal/zzb$zza;)V
    //   31: aload_0
    //   32: getfield 40	com/google/android/gms/internal/zzt:zzaq	Lcom/google/android/gms/internal/zzy;
    //   35: aload_1
    //   36: aload 6
    //   38: invokeinterface 236 3 0
    //   43: astore 15
    //   45: aload 15
    //   47: invokeinterface 242 1 0
    //   52: astore 16
    //   54: aload 16
    //   56: invokeinterface 88 1 0
    //   61: istore 17
    //   63: aload 15
    //   65: invokeinterface 246 1 0
    //   70: invokestatic 248	com/google/android/gms/internal/zzt:zza	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   73: astore 5
    //   75: iload 17
    //   77: sipush 304
    //   80: if_icmpne +73 -> 153
    //   83: aload_1
    //   84: invokevirtual 229	com/google/android/gms/internal/zzk:zzi	()Lcom/google/android/gms/internal/zzb$zza;
    //   87: astore 18
    //   89: aload 18
    //   91: ifnonnull +23 -> 114
    //   94: new 250	com/google/android/gms/internal/zzi
    //   97: dup
    //   98: sipush 304
    //   101: aconst_null
    //   102: aload 5
    //   104: iconst_1
    //   105: invokestatic 216	android/os/SystemClock:elapsedRealtime	()J
    //   108: lload_2
    //   109: lsub
    //   110: invokespecial 253	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   113: areturn
    //   114: aload 18
    //   116: getfield 257	com/google/android/gms/internal/zzb$zza:zzg	Ljava/util/Map;
    //   119: aload 5
    //   121: invokeinterface 261 2 0
    //   126: new 250	com/google/android/gms/internal/zzi
    //   129: dup
    //   130: sipush 304
    //   133: aload 18
    //   135: getfield 265	com/google/android/gms/internal/zzb$zza:data	[B
    //   138: aload 18
    //   140: getfield 257	com/google/android/gms/internal/zzb$zza:zzg	Ljava/util/Map;
    //   143: iconst_1
    //   144: invokestatic 216	android/os/SystemClock:elapsedRealtime	()J
    //   147: lload_2
    //   148: lsub
    //   149: invokespecial 253	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   152: areturn
    //   153: aload 15
    //   155: invokeinterface 269 1 0
    //   160: ifnull +77 -> 237
    //   163: aload_0
    //   164: aload 15
    //   166: invokeinterface 269 1 0
    //   171: invokespecial 271	com/google/android/gms/internal/zzt:zza	(Lorg/apache/http/HttpEntity;)[B
    //   174: astore 23
    //   176: aload 23
    //   178: astore 19
    //   180: aload_0
    //   181: invokestatic 216	android/os/SystemClock:elapsedRealtime	()J
    //   184: lload_2
    //   185: lsub
    //   186: aload_1
    //   187: aload 19
    //   189: aload 16
    //   191: invokespecial 273	com/google/android/gms/internal/zzt:zza	(JLcom/google/android/gms/internal/zzk;[BLorg/apache/http/StatusLine;)V
    //   194: iload 17
    //   196: sipush 200
    //   199: if_icmplt +11 -> 210
    //   202: iload 17
    //   204: sipush 299
    //   207: if_icmple +38 -> 245
    //   210: new 156	java/io/IOException
    //   213: dup
    //   214: invokespecial 274	java/io/IOException:<init>	()V
    //   217: athrow
    //   218: astore 14
    //   220: ldc_w 276
    //   223: aload_1
    //   224: new 278	com/google/android/gms/internal/zzq
    //   227: dup
    //   228: invokespecial 279	com/google/android/gms/internal/zzq:<init>	()V
    //   231: invokestatic 281	com/google/android/gms/internal/zzt:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   234: goto -230 -> 4
    //   237: iconst_0
    //   238: newarray <illegal type>
    //   240: astore 19
    //   242: goto -62 -> 180
    //   245: invokestatic 216	android/os/SystemClock:elapsedRealtime	()J
    //   248: lload_2
    //   249: lsub
    //   250: lstore 20
    //   252: new 250	com/google/android/gms/internal/zzi
    //   255: dup
    //   256: iload 17
    //   258: aload 19
    //   260: aload 5
    //   262: iconst_0
    //   263: lload 20
    //   265: invokespecial 253	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   268: astore 22
    //   270: aload 22
    //   272: areturn
    //   273: astore 13
    //   275: ldc_w 283
    //   278: aload_1
    //   279: new 278	com/google/android/gms/internal/zzq
    //   282: dup
    //   283: invokespecial 279	com/google/android/gms/internal/zzq:<init>	()V
    //   286: invokestatic 281	com/google/android/gms/internal/zzt:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   289: goto -285 -> 4
    //   292: astore 12
    //   294: new 285	java/lang/RuntimeException
    //   297: dup
    //   298: new 287	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 290
    //   308: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 297	com/google/android/gms/internal/zzk:getUrl	()Ljava/lang/String;
    //   315: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: aload 12
    //   323: invokespecial 303	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: athrow
    //   327: astore 7
    //   329: aconst_null
    //   330: astore 8
    //   332: aload 4
    //   334: ifnull +109 -> 443
    //   337: aload 4
    //   339: invokeinterface 242 1 0
    //   344: invokeinterface 88 1 0
    //   349: istore 9
    //   351: iconst_2
    //   352: anewarray 4	java/lang/Object
    //   355: astore 10
    //   357: aload 10
    //   359: iconst_0
    //   360: iload 9
    //   362: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: aload 10
    //   368: iconst_1
    //   369: aload_1
    //   370: invokevirtual 297	com/google/android/gms/internal/zzk:getUrl	()Ljava/lang/String;
    //   373: aastore
    //   374: ldc_w 305
    //   377: aload 10
    //   379: invokestatic 307	com/google/android/gms/internal/zzs:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: aload 8
    //   384: ifnull +79 -> 463
    //   387: new 250	com/google/android/gms/internal/zzi
    //   390: dup
    //   391: iload 9
    //   393: aload 8
    //   395: aload 5
    //   397: iconst_0
    //   398: invokestatic 216	android/os/SystemClock:elapsedRealtime	()J
    //   401: lload_2
    //   402: lsub
    //   403: invokespecial 253	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   406: astore 11
    //   408: iload 9
    //   410: sipush 401
    //   413: if_icmpeq +11 -> 424
    //   416: iload 9
    //   418: sipush 403
    //   421: if_icmpne +32 -> 453
    //   424: ldc_w 309
    //   427: aload_1
    //   428: new 311	com/google/android/gms/internal/zza
    //   431: dup
    //   432: aload 11
    //   434: invokespecial 314	com/google/android/gms/internal/zza:<init>	(Lcom/google/android/gms/internal/zzi;)V
    //   437: invokestatic 281	com/google/android/gms/internal/zzt:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   440: goto -436 -> 4
    //   443: new 316	com/google/android/gms/internal/zzj
    //   446: dup
    //   447: aload 7
    //   449: invokespecial 319	com/google/android/gms/internal/zzj:<init>	(Ljava/lang/Throwable;)V
    //   452: athrow
    //   453: new 158	com/google/android/gms/internal/zzp
    //   456: dup
    //   457: aload 11
    //   459: invokespecial 320	com/google/android/gms/internal/zzp:<init>	(Lcom/google/android/gms/internal/zzi;)V
    //   462: athrow
    //   463: new 322	com/google/android/gms/internal/zzh
    //   466: dup
    //   467: aconst_null
    //   468: invokespecial 323	com/google/android/gms/internal/zzh:<init>	(Lcom/google/android/gms/internal/zzi;)V
    //   471: athrow
    //   472: astore 7
    //   474: aload 15
    //   476: astore 4
    //   478: aconst_null
    //   479: astore 8
    //   481: goto -149 -> 332
    //   484: astore 7
    //   486: aload 19
    //   488: astore 8
    //   490: aload 15
    //   492: astore 4
    //   494: goto -162 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	zzt
    //   0	497	1	paramzzk	zzk<?>
    //   3	399	2	l1	long
    //   5	488	4	localObject	Object
    //   10	386	5	localMap	Map
    //   19	18	6	localHashMap	java.util.HashMap
    //   327	121	7	localIOException1	IOException
    //   472	1	7	localIOException2	IOException
    //   484	1	7	localIOException3	IOException
    //   330	159	8	arrayOfByte1	byte[]
    //   349	73	9	i	int
    //   355	23	10	arrayOfObject	Object[]
    //   406	52	11	localzzi1	zzi
    //   292	30	12	localMalformedURLException	java.net.MalformedURLException
    //   273	1	13	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   218	1	14	localSocketTimeoutException	java.net.SocketTimeoutException
    //   43	448	15	localHttpResponse	org.apache.http.HttpResponse
    //   52	138	16	localStatusLine	StatusLine
    //   61	196	17	j	int
    //   87	52	18	localzza	zzb.zza
    //   178	309	19	arrayOfByte2	byte[]
    //   250	14	20	l2	long
    //   268	3	22	localzzi2	zzi
    //   174	3	23	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	45	218	java/net/SocketTimeoutException
    //   45	75	218	java/net/SocketTimeoutException
    //   83	89	218	java/net/SocketTimeoutException
    //   94	114	218	java/net/SocketTimeoutException
    //   114	153	218	java/net/SocketTimeoutException
    //   153	176	218	java/net/SocketTimeoutException
    //   180	194	218	java/net/SocketTimeoutException
    //   210	218	218	java/net/SocketTimeoutException
    //   237	242	218	java/net/SocketTimeoutException
    //   245	270	218	java/net/SocketTimeoutException
    //   12	45	273	org/apache/http/conn/ConnectTimeoutException
    //   45	75	273	org/apache/http/conn/ConnectTimeoutException
    //   83	89	273	org/apache/http/conn/ConnectTimeoutException
    //   94	114	273	org/apache/http/conn/ConnectTimeoutException
    //   114	153	273	org/apache/http/conn/ConnectTimeoutException
    //   153	176	273	org/apache/http/conn/ConnectTimeoutException
    //   180	194	273	org/apache/http/conn/ConnectTimeoutException
    //   210	218	273	org/apache/http/conn/ConnectTimeoutException
    //   237	242	273	org/apache/http/conn/ConnectTimeoutException
    //   245	270	273	org/apache/http/conn/ConnectTimeoutException
    //   12	45	292	java/net/MalformedURLException
    //   45	75	292	java/net/MalformedURLException
    //   83	89	292	java/net/MalformedURLException
    //   94	114	292	java/net/MalformedURLException
    //   114	153	292	java/net/MalformedURLException
    //   153	176	292	java/net/MalformedURLException
    //   180	194	292	java/net/MalformedURLException
    //   210	218	292	java/net/MalformedURLException
    //   237	242	292	java/net/MalformedURLException
    //   245	270	292	java/net/MalformedURLException
    //   12	45	327	java/io/IOException
    //   45	75	472	java/io/IOException
    //   83	89	472	java/io/IOException
    //   94	114	472	java/io/IOException
    //   114	153	472	java/io/IOException
    //   153	176	472	java/io/IOException
    //   237	242	472	java/io/IOException
    //   180	194	484	java/io/IOException
    //   210	218	484	java/io/IOException
    //   245	270	484	java/io/IOException
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */