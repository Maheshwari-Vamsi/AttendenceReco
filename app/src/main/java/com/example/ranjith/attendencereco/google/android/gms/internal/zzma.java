package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class zzma
  implements zzmm
{
  private final Context mContext;
  private final Looper zzaeK;
  private int zzafA = 0;
  private final zzmg zzafp;
  private final zzmi zzafq;
  private final zzmi zzafr;
  private final Map<Api.zzc<?>, zzmi> zzafs = new ArrayMap();
  private final Set<zzmp> zzaft = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zzb zzafu;
  private Bundle zzafv;
  private ConnectionResult zzafw = null;
  private ConnectionResult zzafx = null;
  private final AtomicInteger zzafy = new AtomicInteger(0);
  private final Lock zzafz;
  
  public zzma(Context paramContext, zzmg paramzzmg, Lock paramLock, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability, Map<Api.zzc<?>, Api.zzb> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzsc, zzsd> paramzza, ArrayList<zzlz> paramArrayList)
  {
    this.mContext = paramContext;
    this.zzafp = paramzzmg;
    this.zzafz = paramLock;
    this.zzaeK = paramLooper;
    Object localObject = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Api.zzc localzzc4 = (Api.zzc)localIterator1.next();
      Api.zzb localzzb = (Api.zzb)paramMap.get(localzzc4);
      if (localzzb.zzmJ()) {
        localObject = localzzb;
      }
      if (localzzb.zzmn()) {
        localArrayMap1.put(localzzc4, localzzb);
      } else {
        localArrayMap2.put(localzzc4, localzzb);
      }
    }
    this.zzafu = ((Api.zzb)localObject);
    if (localArrayMap1.isEmpty()) {
      throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    }
    ArrayMap localArrayMap3 = new ArrayMap();
    ArrayMap localArrayMap4 = new ArrayMap();
    Iterator localIterator2 = paramMap1.keySet().iterator();
    while (localIterator2.hasNext())
    {
      Api localApi = (Api)localIterator2.next();
      Api.zzc localzzc3 = localApi.zzoA();
      if (localArrayMap1.containsKey(localzzc3)) {
        localArrayMap3.put(localApi, paramMap1.get(localApi));
      } else if (localArrayMap2.containsKey(localzzc3)) {
        localArrayMap4.put(localApi, paramMap1.get(localApi));
      } else {
        throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator3 = paramArrayList.iterator();
    while (localIterator3.hasNext())
    {
      zzlz localzzlz = (zzlz)localIterator3.next();
      if (localArrayMap3.containsKey(localzzlz.zzafm)) {
        localArrayList1.add(localzzlz);
      } else if (localArrayMap4.containsKey(localzzlz.zzafm)) {
        localArrayList2.add(localzzlz);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
      }
    }
    zzmm.zza local1 = new zzmm.zza()
    {
      public void zzbz(int paramAnonymousInt)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, zzma.zzc(zzma.this), paramAnonymousInt);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zze(ConnectionResult paramAnonymousConnectionResult)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, paramAnonymousConnectionResult);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zzi(Bundle paramAnonymousBundle)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, paramAnonymousBundle);
          zzma.zza(zzma.this, ConnectionResult.zzadR);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
    };
    this.zzafq = new zzmi(paramContext, this.zzafp, paramLock, paramLooper, paramGoogleApiAvailability, localArrayMap2, null, localArrayMap4, null, localArrayList2, local1);
    zzmm.zza local2 = new zzmm.zza()
    {
      public void zzbz(int paramAnonymousInt)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zza(zzma.this, zzma.zzd(zzma.this), paramAnonymousInt);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zze(ConnectionResult paramAnonymousConnectionResult)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zzb(zzma.this, paramAnonymousConnectionResult);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
      
      public void zzi(Bundle paramAnonymousBundle)
      {
        zzma.zza(zzma.this).lock();
        try
        {
          zzma.zzb(zzma.this, ConnectionResult.zzadR);
          zzma.zzb(zzma.this);
          return;
        }
        finally
        {
          zzma.zza(zzma.this).unlock();
        }
      }
    };
    this.zzafr = new zzmi(paramContext, this.zzafp, paramLock, paramLooper, paramGoogleApiAvailability, localArrayMap1, paramzzf, localArrayMap3, paramzza, localArrayList1, local2);
    Iterator localIterator4 = localArrayMap2.keySet().iterator();
    while (localIterator4.hasNext())
    {
      Api.zzc localzzc2 = (Api.zzc)localIterator4.next();
      this.zzafs.put(localzzc2, this.zzafq);
    }
    Iterator localIterator5 = localArrayMap1.keySet().iterator();
    while (localIterator5.hasNext())
    {
      Api.zzc localzzc1 = (Api.zzc)localIterator5.next();
      this.zzafs.put(localzzc1, this.zzafr);
    }
  }
  
  private void zza(zzmi paramzzmi, int paramInt)
  {
    if (this.zzafy.getAndIncrement() % 2 == 1) {
      this.zzafp.zzbz(paramInt);
    }
    paramzzmi.onConnectionSuspended(paramInt);
    this.zzafx = null;
    this.zzafw = null;
  }
  
  private void zzc(ConnectionResult paramConnectionResult)
  {
    switch (this.zzafA)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zzafA = 0;
      return;
      this.zzafp.zze(paramConnectionResult);
      zzoY();
    }
  }
  
  private boolean zzc(zzlx.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    Api.zzc localzzc = paramzza.zzoA();
    zzx.zzb(this.zzafs.containsKey(localzzc), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzmi)this.zzafs.get(localzzc)).equals(this.zzafr);
  }
  
  private static boolean zzd(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private void zzh(Bundle paramBundle)
  {
    if (this.zzafv == null) {
      this.zzafv = paramBundle;
    }
    while (paramBundle == null) {
      return;
    }
    this.zzafv.putAll(paramBundle);
  }
  
  private void zzoV()
  {
    this.zzafx = null;
    this.zzafw = null;
    this.zzafq.connect();
    this.zzafr.connect();
  }
  
  private void zzoW()
  {
    if (zzd(this.zzafw)) {
      if ((zzd(this.zzafx)) || (zzoZ())) {
        zzoX();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.zzafx == null);
      if (this.zzafA == 1)
      {
        zzoY();
        return;
      }
      zzc(this.zzafx);
      this.zzafq.disconnect();
      return;
      if ((this.zzafw != null) && (zzd(this.zzafx)))
      {
        this.zzafr.disconnect();
        zzc(this.zzafw);
        return;
      }
    } while ((this.zzafw == null) || (this.zzafx == null));
    ConnectionResult localConnectionResult = this.zzafw;
    if (this.zzafr.zzagM < this.zzafq.zzagM) {
      localConnectionResult = this.zzafx;
    }
    zzc(localConnectionResult);
  }
  
  private void zzoX()
  {
    switch (this.zzafA)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zzafA = 0;
      return;
      this.zzafp.zzi(this.zzafv);
      zzoY();
    }
  }
  
  private void zzoY()
  {
    Iterator localIterator = this.zzaft.iterator();
    while (localIterator.hasNext()) {
      ((zzmp)localIterator.next()).zzmI();
    }
    this.zzaft.clear();
  }
  
  private boolean zzoZ()
  {
    return (this.zzafx != null) && (this.zzafx.getErrorCode() == 4);
  }
  
  private PendingIntent zzpa()
  {
    if (this.zzafu == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, this.zzafp.getSessionId(), this.zzafu.zzmK(), 134217728);
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void connect()
  {
    this.zzafA = 2;
    zzoV();
  }
  
  public void disconnect()
  {
    this.zzafx = null;
    this.zzafw = null;
    this.zzafA = 0;
    this.zzafq.disconnect();
    this.zzafr.disconnect();
    zzoY();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zzafr.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("unauthClient").println(":");
    this.zzafq.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    if (((zzmi)this.zzafs.get(paramApi.zzoA())).equals(this.zzafr))
    {
      if (zzoZ()) {
        return new ConnectionResult(4, zzpa());
      }
      return this.zzafr.getConnectionResult(paramApi);
    }
    return this.zzafq.getConnectionResult(paramApi);
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 356 1 0
    //   11: aload_0
    //   12: getfield 167	com/google/android/gms/internal/zzma:zzafq	Lcom/google/android/gms/internal/zzmi;
    //   15: invokevirtual 358	com/google/android/gms/internal/zzmi:isConnected	()Z
    //   18: ifeq +38 -> 56
    //   21: aload_0
    //   22: invokevirtual 361	com/google/android/gms/internal/zzma:zzoU	()Z
    //   25: ifne +20 -> 45
    //   28: aload_0
    //   29: invokespecial 259	com/google/android/gms/internal/zzma:zzoZ	()Z
    //   32: ifne +13 -> 45
    //   35: aload_0
    //   36: getfield 68	com/google/android/gms/internal/zzma:zzafA	I
    //   39: istore_3
    //   40: iload_3
    //   41: iload_1
    //   42: if_icmpne +14 -> 56
    //   45: aload_0
    //   46: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   49: invokeinterface 364 1 0
    //   54: iload_1
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_1
    //   58: goto -13 -> 45
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   66: invokeinterface 364 1 0
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zzma
    //   1	57	1	i	int
    //   61	11	2	localObject	Object
    //   39	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   11	40	61	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 356 1 0
    //   9: aload_0
    //   10: getfield 167	com/google/android/gms/internal/zzma:zzafq	Lcom/google/android/gms/internal/zzmi;
    //   13: invokevirtual 367	com/google/android/gms/internal/zzmi:isConnecting	()Z
    //   16: ifne +23 -> 39
    //   19: aload_0
    //   20: getfield 172	com/google/android/gms/internal/zzma:zzafr	Lcom/google/android/gms/internal/zzmi;
    //   23: invokevirtual 367	com/google/android/gms/internal/zzmi:isConnecting	()Z
    //   26: ifeq +26 -> 52
    //   29: aload_0
    //   30: getfield 68	com/google/android/gms/internal/zzma:zzafA	I
    //   33: istore_3
    //   34: iload_3
    //   35: iconst_2
    //   36: if_icmpne +16 -> 52
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   45: invokeinterface 364 1 0
    //   50: iload_2
    //   51: ireturn
    //   52: iconst_0
    //   53: istore_2
    //   54: goto -13 -> 41
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   62: invokeinterface 364 1 0
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	zzma
    //   57	11	1	localObject	Object
    //   40	14	2	bool	boolean
    //   33	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   9	34	57	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT)
  {
    if (paramT.zzoQ() == 1) {
      throw new IllegalStateException("ReportingServices.getReportingState is not supported with SIGN_IN_MODE_OPTIONAL.");
    }
    if (zzc(paramT))
    {
      if (zzoZ())
      {
        paramT.zzx(new Status(4, null, zzpa()));
        return paramT;
      }
      return this.zzafr.zza(paramT);
    }
    return this.zzafq.zza(paramT);
  }
  
  public boolean zza(zzmp paramzzmp)
  {
    this.zzafz.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!zzoU()))
      {
        this.zzaft.add(paramzzmp);
        if (this.zzafA == 0) {
          this.zzafA = 1;
        }
        this.zzafx = null;
        this.zzafr.connect();
        return true;
      }
      return false;
    }
    finally
    {
      this.zzafz.unlock();
    }
  }
  
  public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT)
  {
    if (zzc(paramT))
    {
      if (zzoZ())
      {
        paramT.zzx(new Status(4, null, zzpa()));
        return paramT;
      }
      return this.zzafr.zzb(paramT);
    }
    return this.zzafq.zzb(paramT);
  }
  
  /* Error */
  public void zzoF()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 356 1 0
    //   9: aload_0
    //   10: invokevirtual 388	com/google/android/gms/internal/zzma:isConnecting	()Z
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 172	com/google/android/gms/internal/zzma:zzafr	Lcom/google/android/gms/internal/zzmi;
    //   18: invokevirtual 267	com/google/android/gms/internal/zzmi:disconnect	()V
    //   21: aload_0
    //   22: new 240	com/google/android/gms/common/ConnectionResult
    //   25: dup
    //   26: iconst_4
    //   27: invokespecial 394	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   30: putfield 59	com/google/android/gms/internal/zzma:zzafx	Lcom/google/android/gms/common/ConnectionResult;
    //   33: iload_2
    //   34: ifeq +36 -> 70
    //   37: new 396	android/os/Handler
    //   40: dup
    //   41: aload_0
    //   42: getfield 76	com/google/android/gms/internal/zzma:zzaeK	Landroid/os/Looper;
    //   45: invokespecial 399	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   48: new 401	com/google/android/gms/internal/zzma$3
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 402	com/google/android/gms/internal/zzma$3:<init>	(Lcom/google/android/gms/internal/zzma;)V
    //   56: invokevirtual 406	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 364 1 0
    //   69: return
    //   70: aload_0
    //   71: invokespecial 222	com/google/android/gms/internal/zzma:zzoY	()V
    //   74: goto -14 -> 60
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 74	com/google/android/gms/internal/zzma:zzafz	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 364 1 0
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzma
    //   77	11	1	localObject	Object
    //   13	21	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	33	77	finally
    //   37	60	77	finally
    //   70	74	77	finally
  }
  
  public boolean zzoU()
  {
    return this.zzafr.isConnected();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */