package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public class zzcb
{
  final Context mContext;
  final String zzrD;
  String zzwL;
  BlockingQueue<zzch> zzwN;
  ExecutorService zzwO;
  LinkedHashMap<String, String> zzwP = new LinkedHashMap();
  Map<String, zzce> zzwQ = new HashMap();
  private AtomicBoolean zzwR;
  private File zzwS;
  
  public zzcb(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.mContext = paramContext;
    this.zzrD = paramString1;
    this.zzwL = paramString2;
    this.zzwR = new AtomicBoolean(false);
    this.zzwR.set(((Boolean)zzbz.zzvN.get()).booleanValue());
    if (this.zzwR.get())
    {
      File localFile = Environment.getExternalStorageDirectory();
      if (localFile != null) {
        this.zzwS = new File(localFile, "sdk_csi_data.txt");
      }
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.zzwP.put(localEntry.getKey(), localEntry.getValue());
    }
    this.zzwN = new ArrayBlockingQueue(30);
    this.zzwO = Executors.newSingleThreadExecutor();
    this.zzwO.execute(new Runnable()
    {
      public void run()
      {
        zzcb.zza(zzcb.this);
      }
    });
    this.zzwQ.put("action", zzce.zzwV);
    this.zzwQ.put("ad_format", zzce.zzwV);
    this.zzwQ.put("e", zzce.zzwW);
  }
  
  /* Error */
  private void zza(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +103 -> 104
    //   4: new 173	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: iconst_1
    //   10: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_2
    //   16: invokevirtual 182	java/lang/String:getBytes	()[B
    //   19: invokevirtual 186	java/io/FileOutputStream:write	([B)V
    //   22: aload_3
    //   23: bipush 10
    //   25: invokevirtual 188	java/io/FileOutputStream:write	(I)V
    //   28: aload_3
    //   29: ifnull +7 -> 36
    //   32: aload_3
    //   33: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   36: return
    //   37: astore 8
    //   39: ldc -63
    //   41: aload 8
    //   43: invokestatic 199	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   46: return
    //   47: astore 4
    //   49: aconst_null
    //   50: astore_3
    //   51: ldc -55
    //   53: aload 4
    //   55: invokestatic 199	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_3
    //   59: ifnull -23 -> 36
    //   62: aload_3
    //   63: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   66: return
    //   67: astore 7
    //   69: ldc -63
    //   71: aload 7
    //   73: invokestatic 199	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: return
    //   77: astore 5
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +7 -> 89
    //   85: aload_3
    //   86: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   89: aload 5
    //   91: athrow
    //   92: astore 6
    //   94: ldc -63
    //   96: aload 6
    //   98: invokestatic 199	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: goto -12 -> 89
    //   104: ldc -53
    //   106: invokestatic 207	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   109: return
    //   110: astore 5
    //   112: goto -31 -> 81
    //   115: astore 4
    //   117: goto -66 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	zzcb
    //   0	120	1	paramFile	File
    //   0	120	2	paramString	String
    //   13	73	3	localFileOutputStream	java.io.FileOutputStream
    //   47	7	4	localIOException1	java.io.IOException
    //   115	1	4	localIOException2	java.io.IOException
    //   77	13	5	localObject1	Object
    //   110	1	5	localObject2	Object
    //   92	5	6	localIOException3	java.io.IOException
    //   67	5	7	localIOException4	java.io.IOException
    //   37	5	8	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	36	37	java/io/IOException
    //   4	14	47	java/io/IOException
    //   62	66	67	java/io/IOException
    //   4	14	77	finally
    //   85	89	92	java/io/IOException
    //   14	28	110	finally
    //   51	58	110	finally
    //   14	28	115	java/io/IOException
  }
  
  private void zzc(Map<String, String> paramMap, String paramString)
  {
    String str = zza(this.zzwL, paramMap, paramString);
    if (this.zzwR.get())
    {
      zza(this.zzwS, str);
      return;
    }
    zzp.zzbx().zzc(this.mContext, this.zzrD, str);
  }
  
  private void zzdq()
  {
    try
    {
      for (;;)
      {
        zzch localzzch = (zzch)this.zzwN.take();
        String str = localzzch.zzdw();
        if (!TextUtils.isEmpty(str)) {
          zzc(zza(this.zzwP, localzzch.zzn()), str);
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzb.zzd("CsiReporter:reporter interrupted", localInterruptedException);
    }
  }
  
  public zzce zzP(String paramString)
  {
    zzce localzzce = (zzce)this.zzwQ.get(paramString);
    if (localzzce != null) {
      return localzzce;
    }
    return zzce.zzwU;
  }
  
  String zza(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    Uri.Builder localBuilder = Uri.parse(paramString1).buildUpon();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBuilder.appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    StringBuilder localStringBuilder = new StringBuilder(localBuilder.build().toString());
    localStringBuilder.append("&").append("it").append("=").append(paramString2);
    return localStringBuilder.toString();
  }
  
  Map<String, String> zza(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramMap1);
    if (paramMap2 == null) {
      return localLinkedHashMap;
    }
    Iterator localIterator = paramMap2.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      String str3 = (String)localLinkedHashMap.get(str1);
      localLinkedHashMap.put(str1, zzP(str1).zzc(str3, str2));
    }
    return localLinkedHashMap;
  }
  
  public boolean zza(zzch paramzzch)
  {
    return this.zzwN.offer(paramzzch);
  }
  
  public void zzb(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.zzwP.put("e", TextUtils.join(",", paramList));
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */