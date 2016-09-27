package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzha
public class zzet
  implements zzel
{
  private final Context mContext;
  private final zzen zzBf;
  private final AdRequestInfoParcel zzBu;
  private final long zzBv;
  private final long zzBw;
  private final int zzBx;
  private boolean zzBy = false;
  private final Map<zzje<zzer>, zzeq> zzBz = new HashMap();
  private final Object zzpK = new Object();
  private final zzew zzpd;
  private final boolean zzrF;
  
  public zzet(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzew paramzzew, zzen paramzzen, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    this.mContext = paramContext;
    this.zzBu = paramAdRequestInfoParcel;
    this.zzpd = paramzzew;
    this.zzBf = paramzzen;
    this.zzrF = paramBoolean;
    this.zzBv = paramLong1;
    this.zzBw = paramLong2;
    this.zzBx = paramInt;
  }
  
  private void zza(final zzje<zzer> paramzzje)
  {
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = zzet.zze(zzet.this).keySet().iterator();
        while (localIterator.hasNext())
        {
          zzje localzzje = (zzje)localIterator.next();
          if (localzzje != paramzzje) {
            ((zzeq)zzet.zze(zzet.this).get(localzzje)).cancel();
          }
        }
      }
    });
  }
  
  private zzer zzd(List<zzje<zzer>> paramList)
  {
    for (;;)
    {
      zzje localzzje;
      synchronized (this.zzpK)
      {
        if (this.zzBy)
        {
          zzer localzzer1 = new zzer(-1);
          return localzzer1;
        }
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext()) {
          localzzje = (zzje)localIterator.next();
        }
      }
      try
      {
        zzer localzzer2 = (zzer)localzzje.get();
        if ((localzzer2 == null) || (localzzer2.zzBo != 0)) {
          continue;
        }
        zza(localzzje);
        return localzzer2;
      }
      catch (InterruptedException localInterruptedException)
      {
        zzb.zzd("Exception while processing an adapter; continuing with other adapters", localInterruptedException);
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        zza(null);
        return new zzer(1);
      }
      catch (ExecutionException localExecutionException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  private zzer zze(List<zzje<zzer>> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/android/gms/internal/zzet:zzpK	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 37	com/google/android/gms/internal/zzet:zzBy	Z
    //   11: ifeq +18 -> 29
    //   14: new 90	com/google/android/gms/internal/zzer
    //   17: dup
    //   18: iconst_m1
    //   19: invokespecial 93	com/google/android/gms/internal/zzer:<init>	(I)V
    //   22: astore 4
    //   24: aload_2
    //   25: monitorexit
    //   26: aload 4
    //   28: areturn
    //   29: aload_2
    //   30: monitorexit
    //   31: iconst_m1
    //   32: istore 5
    //   34: aconst_null
    //   35: astore 6
    //   37: aconst_null
    //   38: astore 7
    //   40: aload_0
    //   41: getfield 50	com/google/android/gms/internal/zzet:zzBf	Lcom/google/android/gms/internal/zzen;
    //   44: getfield 136	com/google/android/gms/internal/zzen:zzAY	J
    //   47: ldc2_w 137
    //   50: lcmp
    //   51: ifeq +199 -> 250
    //   54: aload_0
    //   55: getfield 50	com/google/android/gms/internal/zzet:zzBf	Lcom/google/android/gms/internal/zzen;
    //   58: getfield 136	com/google/android/gms/internal/zzen:zzAY	J
    //   61: lstore 8
    //   63: aload_1
    //   64: invokeinterface 99 1 0
    //   69: astore 10
    //   71: lload 8
    //   73: lstore 11
    //   75: aload 10
    //   77: invokeinterface 105 1 0
    //   82: ifeq +252 -> 334
    //   85: aload 10
    //   87: invokeinterface 109 1 0
    //   92: checkcast 111	com/google/android/gms/internal/zzje
    //   95: astore 13
    //   97: invokestatic 144	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   100: invokeinterface 150 1 0
    //   105: lstore 14
    //   107: lload 11
    //   109: lconst_0
    //   110: lcmp
    //   111: ifne +147 -> 258
    //   114: aload 13
    //   116: invokeinterface 153 1 0
    //   121: ifeq +137 -> 258
    //   124: aload 13
    //   126: invokeinterface 114 1 0
    //   131: checkcast 90	com/google/android/gms/internal/zzer
    //   134: astore 22
    //   136: aload 22
    //   138: ifnull +231 -> 369
    //   141: aload 22
    //   143: getfield 117	com/google/android/gms/internal/zzer:zzBo	I
    //   146: ifne +223 -> 369
    //   149: aload 22
    //   151: getfield 157	com/google/android/gms/internal/zzer:zzBt	Lcom/google/android/gms/internal/zzez;
    //   154: astore 29
    //   156: aload 29
    //   158: ifnull +211 -> 369
    //   161: aload 29
    //   163: invokeinterface 163 1 0
    //   168: iload 5
    //   170: if_icmple +199 -> 369
    //   173: aload 29
    //   175: invokeinterface 163 1 0
    //   180: istore 30
    //   182: iload 30
    //   184: istore 25
    //   186: aload 22
    //   188: astore 31
    //   190: aload 13
    //   192: astore 24
    //   194: aload 31
    //   196: astore 23
    //   198: lload 11
    //   200: invokestatic 144	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   203: invokeinterface 150 1 0
    //   208: lload 14
    //   210: lsub
    //   211: lsub
    //   212: lconst_0
    //   213: invokestatic 169	java/lang/Math:max	(JJ)J
    //   216: lstore 26
    //   218: aload 24
    //   220: astore 6
    //   222: aload 23
    //   224: astore 28
    //   226: lload 26
    //   228: lstore 20
    //   230: iload 25
    //   232: istore 5
    //   234: aload 28
    //   236: astore 7
    //   238: lload 20
    //   240: lstore 11
    //   242: goto -167 -> 75
    //   245: astore_3
    //   246: aload_2
    //   247: monitorexit
    //   248: aload_3
    //   249: athrow
    //   250: ldc2_w 170
    //   253: lstore 8
    //   255: goto -192 -> 63
    //   258: aload 13
    //   260: lload 11
    //   262: getstatic 177	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   265: invokeinterface 180 4 0
    //   270: checkcast 90	com/google/android/gms/internal/zzer
    //   273: astore 22
    //   275: goto -139 -> 136
    //   278: astore 16
    //   280: ldc 121
    //   282: aload 16
    //   284: invokestatic 126	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: lload 11
    //   289: invokestatic 144	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   292: invokeinterface 150 1 0
    //   297: lload 14
    //   299: lsub
    //   300: lsub
    //   301: lconst_0
    //   302: invokestatic 169	java/lang/Math:max	(JJ)J
    //   305: lstore 20
    //   307: goto -69 -> 238
    //   310: astore 17
    //   312: lload 11
    //   314: invokestatic 144	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   317: invokeinterface 150 1 0
    //   322: lload 14
    //   324: lsub
    //   325: lsub
    //   326: lconst_0
    //   327: invokestatic 169	java/lang/Math:max	(JJ)J
    //   330: pop2
    //   331: aload 17
    //   333: athrow
    //   334: aload_0
    //   335: aload 6
    //   337: invokespecial 119	com/google/android/gms/internal/zzet:zza	(Lcom/google/android/gms/internal/zzje;)V
    //   340: aload 7
    //   342: ifnonnull +42 -> 384
    //   345: new 90	com/google/android/gms/internal/zzer
    //   348: dup
    //   349: iconst_1
    //   350: invokespecial 93	com/google/android/gms/internal/zzer:<init>	(I)V
    //   353: areturn
    //   354: astore 16
    //   356: goto -76 -> 280
    //   359: astore 16
    //   361: goto -81 -> 280
    //   364: astore 16
    //   366: goto -86 -> 280
    //   369: aload 7
    //   371: astore 23
    //   373: aload 6
    //   375: astore 24
    //   377: iload 5
    //   379: istore 25
    //   381: goto -183 -> 198
    //   384: aload 7
    //   386: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	zzet
    //   0	387	1	paramList	List<zzje<zzer>>
    //   4	243	2	localObject1	Object
    //   245	4	3	localObject2	Object
    //   22	5	4	localzzer1	zzer
    //   32	346	5	i	int
    //   35	339	6	localObject3	Object
    //   38	347	7	localObject4	Object
    //   61	193	8	l1	long
    //   69	17	10	localIterator	Iterator
    //   73	240	11	l2	long
    //   95	164	13	localzzje	zzje
    //   105	218	14	l3	long
    //   278	5	16	localInterruptedException	InterruptedException
    //   354	1	16	localTimeoutException	java.util.concurrent.TimeoutException
    //   359	1	16	localExecutionException	ExecutionException
    //   364	1	16	localRemoteException	android.os.RemoteException
    //   310	22	17	localObject5	Object
    //   228	78	20	l4	long
    //   134	140	22	localzzer2	zzer
    //   196	176	23	localObject6	Object
    //   192	184	24	localObject7	Object
    //   184	196	25	j	int
    //   216	11	26	l5	long
    //   224	11	28	localObject8	Object
    //   154	20	29	localzzez	zzez
    //   180	3	30	k	int
    //   188	7	31	localzzer3	zzer
    // Exception table:
    //   from	to	target	type
    //   7	26	245	finally
    //   29	31	245	finally
    //   246	248	245	finally
    //   114	136	278	java/lang/InterruptedException
    //   141	156	278	java/lang/InterruptedException
    //   161	182	278	java/lang/InterruptedException
    //   258	275	278	java/lang/InterruptedException
    //   114	136	310	finally
    //   141	156	310	finally
    //   161	182	310	finally
    //   258	275	310	finally
    //   280	287	310	finally
    //   114	136	354	java/util/concurrent/TimeoutException
    //   141	156	354	java/util/concurrent/TimeoutException
    //   161	182	354	java/util/concurrent/TimeoutException
    //   258	275	354	java/util/concurrent/TimeoutException
    //   114	136	359	java/util/concurrent/ExecutionException
    //   141	156	359	java/util/concurrent/ExecutionException
    //   161	182	359	java/util/concurrent/ExecutionException
    //   258	275	359	java/util/concurrent/ExecutionException
    //   114	136	364	android/os/RemoteException
    //   141	156	364	android/os/RemoteException
    //   161	182	364	android/os/RemoteException
    //   258	275	364	android/os/RemoteException
  }
  
  public void cancel()
  {
    synchronized (this.zzpK)
    {
      this.zzBy = true;
      Iterator localIterator = this.zzBz.values().iterator();
      if (localIterator.hasNext()) {
        ((zzeq)localIterator.next()).cancel();
      }
    }
  }
  
  public zzer zzc(List<zzem> paramList)
  {
    zzb.zzaF("Starting mediation.");
    ExecutorService localExecutorService = Executors.newCachedThreadPool();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      zzem localzzem = (zzem)localIterator1.next();
      zzb.zzaG("Trying mediation network: " + localzzem.zzAF);
      Iterator localIterator2 = localzzem.zzAG.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        final zzeq localzzeq = new zzeq(this.mContext, str, this.zzpd, this.zzBf, localzzem, this.zzBu.zzGq, this.zzBu.zzqV, this.zzBu.zzqR, this.zzrF, this.zzBu.zzrj, this.zzBu.zzrl);
        zzje localzzje = zzio.zza(localExecutorService, new Callable()
        {
          public zzer zzet()
            throws Exception
          {
            synchronized (zzet.zza(zzet.this))
            {
              if (zzet.zzb(zzet.this)) {
                return null;
              }
              return localzzeq.zza(zzet.zzc(zzet.this), zzet.zzd(zzet.this));
            }
          }
        });
        this.zzBz.put(localzzje, localzzeq);
        localArrayList.add(localzzje);
      }
    }
    switch (this.zzBx)
    {
    default: 
      return zzd(localArrayList);
    }
    return zze(localArrayList);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */