package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzha
public class zzju
  extends zzjo
{
  public zzju(zzjn paramzzjn, boolean paramBoolean)
  {
    super(paramzzjn, paramBoolean);
  }
  
  /* Error */
  public WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: ldc 21
    //   2: new 23	java/io/File
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 30	java/io/File:getName	()Ljava/lang/String;
    //   13: invokevirtual 36	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokespecial 38	com/google/android/gms/internal/zzjo:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   25: areturn
    //   26: aload_1
    //   27: instanceof 40
    //   30: ifne +15 -> 45
    //   33: ldc 42
    //   35: invokestatic 47	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: invokespecial 38	com/google/android/gms/internal/zzjo:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   44: areturn
    //   45: aload_1
    //   46: checkcast 40	com/google/android/gms/internal/zzjn
    //   49: astore 4
    //   51: aload 4
    //   53: invokeinterface 51 1 0
    //   58: invokevirtual 55	com/google/android/gms/internal/zzjo:zzfd	()V
    //   61: aload 4
    //   63: invokeinterface 59 1 0
    //   68: getfield 65	com/google/android/gms/ads/internal/client/AdSizeParcel:zztW	Z
    //   71: ifeq +68 -> 139
    //   74: getstatic 71	com/google/android/gms/internal/zzbz:zzvK	Lcom/google/android/gms/internal/zzbv;
    //   77: invokevirtual 77	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   80: checkcast 32	java/lang/String
    //   83: astore 5
    //   85: new 79	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   92: ldc 83
    //   94: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 5
    //   99: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 89
    //   104: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 95	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: aload 4
    //   116: invokeinterface 99 1 0
    //   121: aload_0
    //   122: getfield 103	com/google/android/gms/internal/zzju:zzps	Lcom/google/android/gms/internal/zzjn;
    //   125: invokeinterface 107 1 0
    //   130: getfield 113	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:afmaVersion	Ljava/lang/String;
    //   133: aload 5
    //   135: invokevirtual 117	com/google/android/gms/internal/zzju:zzd	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   138: areturn
    //   139: aload 4
    //   141: invokeinterface 121 1 0
    //   146: ifeq +17 -> 163
    //   149: getstatic 124	com/google/android/gms/internal/zzbz:zzvJ	Lcom/google/android/gms/internal/zzbv;
    //   152: invokevirtual 77	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   155: checkcast 32	java/lang/String
    //   158: astore 5
    //   160: goto -75 -> 85
    //   163: getstatic 127	com/google/android/gms/internal/zzbz:zzvI	Lcom/google/android/gms/internal/zzbv;
    //   166: invokevirtual 77	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   169: checkcast 32	java/lang/String
    //   172: astore 5
    //   174: goto -89 -> 85
    //   177: astore_3
    //   178: new 79	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   185: ldc -127
    //   187: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_3
    //   191: invokevirtual 134	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 47	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   203: aload_0
    //   204: aload_1
    //   205: aload_2
    //   206: invokespecial 38	com/google/android/gms/internal/zzjo:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   209: areturn
    //   210: astore_3
    //   211: goto -33 -> 178
    //   214: astore_3
    //   215: goto -37 -> 178
    //   218: astore_3
    //   219: goto -41 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	zzju
    //   0	222	1	paramWebView	android.webkit.WebView
    //   0	222	2	paramString	String
    //   177	14	3	localInterruptedException	InterruptedException
    //   210	1	3	localTimeoutException	TimeoutException
    //   214	1	3	localIOException	IOException
    //   218	1	3	localExecutionException	ExecutionException
    //   49	91	4	localzzjn	zzjn
    //   83	90	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	26	177	java/lang/InterruptedException
    //   26	45	177	java/lang/InterruptedException
    //   45	85	177	java/lang/InterruptedException
    //   85	139	177	java/lang/InterruptedException
    //   139	160	177	java/lang/InterruptedException
    //   163	174	177	java/lang/InterruptedException
    //   0	26	210	java/util/concurrent/TimeoutException
    //   26	45	210	java/util/concurrent/TimeoutException
    //   45	85	210	java/util/concurrent/TimeoutException
    //   85	139	210	java/util/concurrent/TimeoutException
    //   139	160	210	java/util/concurrent/TimeoutException
    //   163	174	210	java/util/concurrent/TimeoutException
    //   0	26	214	java/io/IOException
    //   26	45	214	java/io/IOException
    //   45	85	214	java/io/IOException
    //   85	139	214	java/io/IOException
    //   139	160	214	java/io/IOException
    //   163	174	214	java/io/IOException
    //   0	26	218	java/util/concurrent/ExecutionException
    //   26	45	218	java/util/concurrent/ExecutionException
    //   45	85	218	java/util/concurrent/ExecutionException
    //   85	139	218	java/util/concurrent/ExecutionException
    //   139	160	218	java/util/concurrent/ExecutionException
    //   163	174	218	java/util/concurrent/ExecutionException
  }
  
  protected WebResourceResponse zzd(Context paramContext, String paramString1, String paramString2)
    throws IOException, ExecutionException, InterruptedException, TimeoutException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", zzp.zzbx().zzd(paramContext, paramString1));
    localHashMap.put("Cache-Control", "max-stale=3600");
    String str = (String)new zziu(paramContext).zza(paramString2, localHashMap).get(60L, TimeUnit.SECONDS);
    if (str == null) {
      return null;
    }
    return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str.getBytes("UTF-8")));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */