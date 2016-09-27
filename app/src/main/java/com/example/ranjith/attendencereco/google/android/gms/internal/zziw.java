package com.google.android.gms.internal;

import android.content.Context;

@zzha
public final class zziw
  extends zzil
{
  private final Context mContext;
  private final String zzF;
  private String zzKi = null;
  private final String zzrD;
  
  public zziw(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.zzrD = paramString1;
    this.zzF = paramString2;
  }
  
  public zziw(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.zzrD = paramString1;
    this.zzF = paramString2;
    this.zzKi = paramString3;
  }
  
  public void onStop() {}
  
  /* Error */
  public void zzbp()
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: ldc 38
    //   9: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: getfield 24	com/google/android/gms/internal/zziw:zzF	Ljava/lang/String;
    //   16: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 52	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   25: new 54	java/net/URL
    //   28: dup
    //   29: aload_0
    //   30: getfield 24	com/google/android/gms/internal/zziw:zzF	Ljava/lang/String;
    //   33: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 62	java/net/HttpURLConnection
    //   42: astore 4
    //   44: aload_0
    //   45: getfield 18	com/google/android/gms/internal/zziw:zzKi	Ljava/lang/String;
    //   48: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +84 -> 135
    //   54: invokestatic 74	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   57: aload_0
    //   58: getfield 20	com/google/android/gms/internal/zziw:mContext	Landroid/content/Context;
    //   61: aload_0
    //   62: getfield 22	com/google/android/gms/internal/zziw:zzrD	Ljava/lang/String;
    //   65: iconst_1
    //   66: aload 4
    //   68: invokevirtual 80	com/google/android/gms/internal/zzip:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   71: aload 4
    //   73: invokevirtual 84	java/net/HttpURLConnection:getResponseCode	()I
    //   76: istore 6
    //   78: iload 6
    //   80: sipush 200
    //   83: if_icmplt +11 -> 94
    //   86: iload 6
    //   88: sipush 300
    //   91: if_icmplt +38 -> 129
    //   94: new 35	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   101: ldc 86
    //   103: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 6
    //   108: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc 91
    //   113: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 24	com/google/android/gms/internal/zziw:zzF	Ljava/lang/String;
    //   120: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 94	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   129: aload 4
    //   131: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
    //   134: return
    //   135: invokestatic 74	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   138: aload_0
    //   139: getfield 20	com/google/android/gms/internal/zziw:mContext	Landroid/content/Context;
    //   142: aload_0
    //   143: getfield 22	com/google/android/gms/internal/zziw:zzrD	Ljava/lang/String;
    //   146: iconst_1
    //   147: aload 4
    //   149: aload_0
    //   150: getfield 18	com/google/android/gms/internal/zziw:zzKi	Ljava/lang/String;
    //   153: invokevirtual 100	com/google/android/gms/internal/zzip:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;Ljava/lang/String;)V
    //   156: goto -85 -> 71
    //   159: astore 5
    //   161: aload 4
    //   163: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
    //   166: aload 5
    //   168: athrow
    //   169: astore_3
    //   170: new 35	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   177: ldc 102
    //   179: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 24	com/google/android/gms/internal/zziw:zzF	Ljava/lang/String;
    //   186: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 104
    //   191: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_3
    //   195: invokevirtual 107	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 94	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   207: return
    //   208: astore_2
    //   209: new 35	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   216: ldc 109
    //   218: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: getfield 24	com/google/android/gms/internal/zziw:zzF	Ljava/lang/String;
    //   225: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 104
    //   230: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_2
    //   234: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   237: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 94	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   246: return
    //   247: astore_1
    //   248: new 35	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   255: ldc 109
    //   257: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: getfield 24	com/google/android/gms/internal/zziw:zzF	Ljava/lang/String;
    //   264: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 104
    //   269: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: invokevirtual 111	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   276: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 94	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   285: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	zziw
    //   247	26	1	localRuntimeException	RuntimeException
    //   208	26	2	localIOException	java.io.IOException
    //   169	26	3	localIndexOutOfBoundsException	IndexOutOfBoundsException
    //   42	120	4	localHttpURLConnection	java.net.HttpURLConnection
    //   159	8	5	localObject	Object
    //   76	31	6	i	int
    // Exception table:
    //   from	to	target	type
    //   44	71	159	finally
    //   71	78	159	finally
    //   94	129	159	finally
    //   135	156	159	finally
    //   0	44	169	java/lang/IndexOutOfBoundsException
    //   129	134	169	java/lang/IndexOutOfBoundsException
    //   161	169	169	java/lang/IndexOutOfBoundsException
    //   0	44	208	java/io/IOException
    //   129	134	208	java/io/IOException
    //   161	169	208	java/io/IOException
    //   0	44	247	java/lang/RuntimeException
    //   129	134	247	java/lang/RuntimeException
    //   161	169	247	java/lang/RuntimeException
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zziw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */