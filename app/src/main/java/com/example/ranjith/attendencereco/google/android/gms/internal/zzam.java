package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzam
  extends zzal
{
  private static AdvertisingIdClient zznV = null;
  private static CountDownLatch zznW = new CountDownLatch(1);
  private static volatile boolean zznX;
  private boolean zznY;
  
  protected zzam(Context paramContext, zzap paramzzap, zzaq paramzzaq, boolean paramBoolean)
  {
    super(paramContext, paramzzap, paramzzaq);
    this.zznY = paramBoolean;
  }
  
  public static zzam zza(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzah localzzah = new zzah();
    zza(paramString, paramContext, localzzah);
    if (paramBoolean) {}
    try
    {
      if (zznV == null) {
        new Thread(new zzb(paramContext)).start();
      }
      return new zzam(paramContext, localzzah, new zzas(239), paramBoolean);
    }
    finally {}
  }
  
  zza zzZ()
    throws IOException
  {
    try
    {
      if (!zznW.await(2L, TimeUnit.SECONDS))
      {
        zza localzza1 = new zza(null, false);
        return localzza1;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      return new zza(null, false);
    }
    try
    {
      if (zznV == null)
      {
        zza localzza2 = new zza(null, false);
        return localzza2;
      }
    }
    finally {}
    AdvertisingIdClient.Info localInfo = zznV.getInfo();
    return new zza(zzk(localInfo.getId()), localInfo.isLimitAdTrackingEnabled());
  }
  
  protected void zzc(Context paramContext)
  {
    super.zzc(paramContext);
    try
    {
      if ((zznX) || (!this.zznY))
      {
        zza(24, zzf(paramContext));
        zza(24, zznN);
        return;
      }
      zza localzza1 = zzZ();
      str = localzza1.getId();
      if (str == null) {
        return;
      }
      if (!localzza1.isLimitAdTrackingEnabled()) {
        break label102;
      }
      l = 1L;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str;
        return;
        long l = 0L;
      }
    }
    catch (zzal.zza localzza) {}
    zza(28, l);
    zza(26, 5L);
    zza(24, str);
    zza(28, zznN);
    return;
    label102:
  }
  
  class zza
  {
    private String zznZ;
    private boolean zzoa;
    
    public zza(String paramString, boolean paramBoolean)
    {
      this.zznZ = paramString;
      this.zzoa = paramBoolean;
    }
    
    public String getId()
    {
      return this.zznZ;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.zzoa;
    }
  }
  
  private static final class zzb
    implements Runnable
  {
    private Context zzoc;
    
    public zzb(Context paramContext)
    {
      this.zzoc = paramContext.getApplicationContext();
      if (this.zzoc == null) {
        this.zzoc = paramContext;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 30
      //   2: monitorenter
      //   3: invokestatic 34	com/google/android/gms/internal/zzam:zzaa	()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;
      //   6: ifnonnull +27 -> 33
      //   9: new 36	com/google/android/gms/ads/identifier/AdvertisingIdClient
      //   12: dup
      //   13: aload_0
      //   14: getfield 21	com/google/android/gms/internal/zzam$zzb:zzoc	Landroid/content/Context;
      //   17: invokespecial 38	com/google/android/gms/ads/identifier/AdvertisingIdClient:<init>	(Landroid/content/Context;)V
      //   20: astore 7
      //   22: aload 7
      //   24: invokevirtual 41	com/google/android/gms/ads/identifier/AdvertisingIdClient:start	()V
      //   27: aload 7
      //   29: invokestatic 45	com/google/android/gms/internal/zzam:zza	(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;
      //   32: pop
      //   33: invokestatic 49	com/google/android/gms/internal/zzam:zzab	()Ljava/util/concurrent/CountDownLatch;
      //   36: invokevirtual 54	java/util/concurrent/CountDownLatch:countDown	()V
      //   39: ldc 30
      //   41: monitorexit
      //   42: return
      //   43: astore 5
      //   45: iconst_1
      //   46: invokestatic 57	com/google/android/gms/internal/zzam:zza	(Z)Z
      //   49: pop
      //   50: invokestatic 49	com/google/android/gms/internal/zzam:zzab	()Ljava/util/concurrent/CountDownLatch;
      //   53: invokevirtual 54	java/util/concurrent/CountDownLatch:countDown	()V
      //   56: goto -17 -> 39
      //   59: astore_2
      //   60: ldc 30
      //   62: monitorexit
      //   63: aload_2
      //   64: athrow
      //   65: astore 4
      //   67: invokestatic 49	com/google/android/gms/internal/zzam:zzab	()Ljava/util/concurrent/CountDownLatch;
      //   70: invokevirtual 54	java/util/concurrent/CountDownLatch:countDown	()V
      //   73: goto -34 -> 39
      //   76: astore_3
      //   77: invokestatic 49	com/google/android/gms/internal/zzam:zzab	()Ljava/util/concurrent/CountDownLatch;
      //   80: invokevirtual 54	java/util/concurrent/CountDownLatch:countDown	()V
      //   83: goto -44 -> 39
      //   86: astore_1
      //   87: invokestatic 49	com/google/android/gms/internal/zzam:zzab	()Ljava/util/concurrent/CountDownLatch;
      //   90: invokevirtual 54	java/util/concurrent/CountDownLatch:countDown	()V
      //   93: aload_1
      //   94: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	95	0	this	zzb
      //   86	8	1	localObject1	Object
      //   59	5	2	localObject2	Object
      //   76	1	3	localGooglePlayServicesRepairableException	com.google.android.gms.common.GooglePlayServicesRepairableException
      //   65	1	4	localIOException	IOException
      //   43	1	5	localGooglePlayServicesNotAvailableException	com.google.android.gms.common.GooglePlayServicesNotAvailableException
      //   20	8	7	localAdvertisingIdClient	AdvertisingIdClient
      // Exception table:
      //   from	to	target	type
      //   3	33	43	com/google/android/gms/common/GooglePlayServicesNotAvailableException
      //   33	39	59	finally
      //   39	42	59	finally
      //   50	56	59	finally
      //   60	63	59	finally
      //   67	73	59	finally
      //   77	83	59	finally
      //   87	95	59	finally
      //   3	33	65	java/io/IOException
      //   3	33	76	com/google/android/gms/common/GooglePlayServicesRepairableException
      //   3	33	86	finally
      //   45	50	86	finally
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */