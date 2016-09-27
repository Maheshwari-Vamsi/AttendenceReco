package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzn;
import java.util.concurrent.Future;

@zzha
public class zzgu
  extends zzil
{
  private Future<zzie> zzFA;
  private final zzgq.zza zzFb;
  private final zzie.zza zzFc;
  private final AdResponseParcel zzFd;
  private final zzgv zzFz;
  private final Object zzpK = new Object();
  
  public zzgu(Context paramContext, zzn paramzzn, zzbc paramzzbc, zzie.zza paramzza, zzan paramzzan, zzgq.zza paramzza1)
  {
    this(paramzza, paramzza1, new zzgv(paramContext, paramzzn, paramzzbc, new zziu(paramContext), paramzzan, paramzza));
  }
  
  zzgu(zzie.zza paramzza, zzgq.zza paramzza1, zzgv paramzzgv)
  {
    this.zzFc = paramzza;
    this.zzFd = paramzza.zzJL;
    this.zzFb = paramzza1;
    this.zzFz = paramzzgv;
  }
  
  private zzie zzE(int paramInt)
  {
    return new zzie(this.zzFc.zzJK.zzGq, null, null, paramInt, null, null, this.zzFd.orientation, this.zzFd.zzAU, this.zzFc.zzJK.zzGt, false, null, null, null, null, null, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
  }
  
  public void onStop()
  {
    synchronized (this.zzpK)
    {
      if (this.zzFA != null) {
        this.zzFA.cancel(true);
      }
      return;
    }
  }
  
  /* Error */
  public void zzbp()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/gms/internal/zzgu:zzpK	Ljava/lang/Object;
    //   4: astore 9
    //   6: aload 9
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 54	com/google/android/gms/internal/zzgu:zzFz	Lcom/google/android/gms/internal/zzgv;
    //   14: invokestatic 133	com/google/android/gms/internal/zzio:zza	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/internal/zzje;
    //   17: putfield 113	com/google/android/gms/internal/zzgu:zzFA	Ljava/util/concurrent/Future;
    //   20: aload 9
    //   22: monitorexit
    //   23: aload_0
    //   24: getfield 113	com/google/android/gms/internal/zzgu:zzFA	Ljava/util/concurrent/Future;
    //   27: ldc2_w 134
    //   30: getstatic 141	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: invokeinterface 145 4 0
    //   38: checkcast 58	com/google/android/gms/internal/zzie
    //   41: astore_3
    //   42: bipush -2
    //   44: istore_2
    //   45: aload_3
    //   46: ifnull +79 -> 125
    //   49: getstatic 151	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   52: new 153	com/google/android/gms/internal/zzgu$1
    //   55: dup
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 156	com/google/android/gms/internal/zzgu$1:<init>	(Lcom/google/android/gms/internal/zzgu;Lcom/google/android/gms/internal/zzie;)V
    //   61: invokevirtual 162	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   64: pop
    //   65: return
    //   66: astore 10
    //   68: aload 9
    //   70: monitorexit
    //   71: aload 10
    //   73: athrow
    //   74: astore 7
    //   76: ldc -92
    //   78: invokestatic 170	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 113	com/google/android/gms/internal/zzgu:zzFA	Ljava/util/concurrent/Future;
    //   85: iconst_1
    //   86: invokeinterface 119 2 0
    //   91: pop
    //   92: iconst_2
    //   93: istore_2
    //   94: aconst_null
    //   95: astore_3
    //   96: goto -51 -> 45
    //   99: astore 6
    //   101: aconst_null
    //   102: astore_3
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -60 -> 45
    //   108: astore 5
    //   110: iconst_m1
    //   111: istore_2
    //   112: aconst_null
    //   113: astore_3
    //   114: goto -69 -> 45
    //   117: astore_1
    //   118: iconst_m1
    //   119: istore_2
    //   120: aconst_null
    //   121: astore_3
    //   122: goto -77 -> 45
    //   125: aload_0
    //   126: iload_2
    //   127: invokespecial 172	com/google/android/gms/internal/zzgu:zzE	(I)Lcom/google/android/gms/internal/zzie;
    //   130: astore_3
    //   131: goto -82 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	zzgu
    //   117	1	1	localCancellationException	java.util.concurrent.CancellationException
    //   44	83	2	i	int
    //   41	90	3	localzzie	zzie
    //   108	1	5	localInterruptedException	InterruptedException
    //   99	1	6	localExecutionException	java.util.concurrent.ExecutionException
    //   74	1	7	localTimeoutException	java.util.concurrent.TimeoutException
    //   66	6	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	23	66	finally
    //   68	71	66	finally
    //   0	9	74	java/util/concurrent/TimeoutException
    //   23	42	74	java/util/concurrent/TimeoutException
    //   71	74	74	java/util/concurrent/TimeoutException
    //   0	9	99	java/util/concurrent/ExecutionException
    //   23	42	99	java/util/concurrent/ExecutionException
    //   71	74	99	java/util/concurrent/ExecutionException
    //   0	9	108	java/lang/InterruptedException
    //   23	42	108	java/lang/InterruptedException
    //   71	74	108	java/lang/InterruptedException
    //   0	9	117	java/util/concurrent/CancellationException
    //   23	42	117	java/util/concurrent/CancellationException
    //   71	74	117	java/util/concurrent/CancellationException
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */