package com.google.android.gms.ads.identifier;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zza;
import com.google.android.gms.internal.zzav;
import com.google.android.gms.internal.zzav.zza;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private static boolean zzoN = false;
  private final Context mContext;
  zza zzoH;
  zzav zzoI;
  boolean zzoJ;
  Object zzoK = new Object();
  zza zzoL;
  final long zzoM;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong)
  {
    zzx.zzy(paramContext);
    this.mContext = paramContext;
    this.zzoJ = false;
    this.zzoM = paramLong;
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    AdvertisingIdClient localAdvertisingIdClient = new AdvertisingIdClient(paramContext, -1L);
    try
    {
      localAdvertisingIdClient.zzb(false);
      Info localInfo = localAdvertisingIdClient.getInfo();
      return localInfo;
    }
    finally
    {
      localAdvertisingIdClient.finish();
    }
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean)
  {
    zzoN = paramBoolean;
  }
  
  static zzav zza(Context paramContext, zza paramzza)
    throws IOException
  {
    try
    {
      zzav localzzav = zzav.zza.zzb(paramzza.zzor());
      return localzzav;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable localThrowable)
    {
      throw new IOException(localThrowable);
    }
  }
  
  private void zzaL()
  {
    synchronized (this.zzoK)
    {
      if (this.zzoL != null) {
        this.zzoL.cancel();
      }
    }
    try
    {
      this.zzoL.join();
      if (this.zzoM > 0L) {
        this.zzoL = new zza(this, this.zzoM);
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  static zza zzp(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 119	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: ldc 121
    //   6: iconst_0
    //   7: invokevirtual 127	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   10: pop
    //   11: getstatic 23	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoN	Z
    //   14: ifeq +67 -> 81
    //   17: ldc -127
    //   19: ldc -125
    //   21: invokestatic 137	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: invokestatic 143	com/google/android/gms/common/GoogleApiAvailability:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailability;
    //   28: aload_0
    //   29: invokevirtual 147	com/google/android/gms/common/GoogleApiAvailability:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   32: tableswitch	default:+28->60, 0:+53->85, 1:+28->60, 2:+53->85
    //   60: new 50	java/io/IOException
    //   63: dup
    //   64: ldc -107
    //   66: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: astore_1
    //   71: new 54	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   74: dup
    //   75: bipush 9
    //   77: invokespecial 152	com/google/android/gms/common/GooglePlayServicesNotAvailableException:<init>	(I)V
    //   80: athrow
    //   81: aload_0
    //   82: invokestatic 157	com/google/android/gms/common/GooglePlayServicesUtil:zzac	(Landroid/content/Context;)V
    //   85: new 78	com/google/android/gms/common/zza
    //   88: dup
    //   89: invokespecial 158	com/google/android/gms/common/zza:<init>	()V
    //   92: astore 4
    //   94: new 160	android/content/Intent
    //   97: dup
    //   98: ldc -94
    //   100: invokespecial 163	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   103: astore 5
    //   105: aload 5
    //   107: ldc -91
    //   109: invokevirtual 169	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   112: pop
    //   113: invokestatic 175	com/google/android/gms/common/stats/zzb:zzrz	()Lcom/google/android/gms/common/stats/zzb;
    //   116: aload_0
    //   117: aload 5
    //   119: aload 4
    //   121: iconst_1
    //   122: invokevirtual 178	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   125: istore 8
    //   127: iload 8
    //   129: ifeq +28 -> 157
    //   132: aload 4
    //   134: areturn
    //   135: astore_3
    //   136: new 50	java/io/IOException
    //   139: dup
    //   140: aload_3
    //   141: invokespecial 95	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   144: athrow
    //   145: astore 7
    //   147: new 50	java/io/IOException
    //   150: dup
    //   151: aload 7
    //   153: invokespecial 95	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   156: athrow
    //   157: new 50	java/io/IOException
    //   160: dup
    //   161: ldc -76
    //   163: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramContext	Context
    //   70	1	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   135	6	3	localGooglePlayServicesNotAvailableException	GooglePlayServicesNotAvailableException
    //   92	41	4	localzza	zza
    //   103	15	5	localIntent	android.content.Intent
    //   145	7	7	localThrowable	Throwable
    //   125	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	11	70	android/content/pm/PackageManager$NameNotFoundException
    //   81	85	135	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   113	127	145	java/lang/Throwable
  }
  
  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc -69
    //   2: invokestatic 190	com/google/android/gms/common/internal/zzx:zzcy	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 42	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 192	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoH	Lcom/google/android/gms/common/zza;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 44	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoJ	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 175	com/google/android/gms/common/stats/zzb:zzrz	()Lcom/google/android/gms/common/stats/zzb;
    //   34: aload_0
    //   35: getfield 42	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 192	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoH	Lcom/google/android/gms/common/zza;
    //   42: invokevirtual 195	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 44	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoJ	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 197	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoI	Lcom/google/android/gms/internal/zzav;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 192	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoH	Lcom/google/android/gms/common/zza;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: ldc -57
    //   71: ldc -55
    //   73: aload_2
    //   74: invokestatic 205	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   77: pop
    //   78: goto -33 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	AdvertisingIdClient
    //   63	4	1	localObject	Object
    //   68	6	2	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   69	78	63	finally
    //   24	45	68	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc -69
    //   2: invokestatic 190	com/google/android/gms/common/internal/zzx:zzcy	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 44	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoJ	Z
    //   11: ifne +91 -> 102
    //   14: aload_0
    //   15: getfield 34	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoK	Ljava/lang/Object;
    //   18: astore 7
    //   20: aload 7
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 98	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoL	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: getfield 98	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoL	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   34: invokevirtual 213	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzaM	()Z
    //   37: ifne +26 -> 63
    //   40: new 50	java/io/IOException
    //   43: dup
    //   44: ldc -41
    //   46: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore 8
    //   52: aload 7
    //   54: monitorexit
    //   55: aload 8
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: aload 7
    //   65: monitorexit
    //   66: aload_0
    //   67: iconst_0
    //   68: invokevirtual 62	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzb	(Z)V
    //   71: aload_0
    //   72: getfield 44	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoJ	Z
    //   75: ifne +27 -> 102
    //   78: new 50	java/io/IOException
    //   81: dup
    //   82: ldc -39
    //   84: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   87: athrow
    //   88: astore 9
    //   90: new 50	java/io/IOException
    //   93: dup
    //   94: ldc -39
    //   96: aload 9
    //   98: invokespecial 220	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: athrow
    //   102: aload_0
    //   103: getfield 192	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoH	Lcom/google/android/gms/common/zza;
    //   106: invokestatic 40	com/google/android/gms/common/internal/zzx:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_0
    //   111: getfield 197	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoI	Lcom/google/android/gms/internal/zzav;
    //   114: invokestatic 40	com/google/android/gms/common/internal/zzx:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: new 222	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   121: dup
    //   122: aload_0
    //   123: getfield 197	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoI	Lcom/google/android/gms/internal/zzav;
    //   126: invokeinterface 228 1 0
    //   131: aload_0
    //   132: getfield 197	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzoI	Lcom/google/android/gms/internal/zzav;
    //   135: iconst_1
    //   136: invokeinterface 232 2 0
    //   141: invokespecial 235	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   144: astore 4
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_0
    //   149: invokespecial 237	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzaL	()V
    //   152: aload 4
    //   154: areturn
    //   155: astore 5
    //   157: ldc -57
    //   159: ldc -17
    //   161: aload 5
    //   163: invokestatic 205	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   166: pop
    //   167: new 50	java/io/IOException
    //   170: dup
    //   171: ldc -15
    //   173: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	AdvertisingIdClient
    //   58	4	1	localObject1	Object
    //   144	9	4	localInfo	Info
    //   155	7	5	localRemoteException	android.os.RemoteException
    //   50	6	8	localObject3	Object
    //   88	9	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   23	40	50	finally
    //   40	50	50	finally
    //   52	55	50	finally
    //   63	66	50	finally
    //   7	23	58	finally
    //   55	58	58	finally
    //   59	61	58	finally
    //   66	71	58	finally
    //   71	88	58	finally
    //   90	102	58	finally
    //   102	118	58	finally
    //   118	146	58	finally
    //   146	148	58	finally
    //   157	177	58	finally
    //   66	71	88	java/lang/Exception
    //   118	146	155	android/os/RemoteException
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzb(true);
  }
  
  protected void zzb(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzoJ) {
        finish();
      }
      this.zzoH = zzp(this.mContext);
      this.zzoI = zza(this.mContext, this.zzoH);
      this.zzoJ = true;
      if (paramBoolean) {
        zzaL();
      }
      return;
    }
    finally {}
  }
  
  public static final class Info
  {
    private final String zzoS;
    private final boolean zzoT;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.zzoS = paramString;
      this.zzoT = paramBoolean;
    }
    
    public String getId()
    {
      return this.zzoS;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.zzoT;
    }
    
    public String toString()
    {
      return "{" + this.zzoS + "}" + this.zzoT;
    }
  }
  
  static class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzoO;
    private long zzoP;
    CountDownLatch zzoQ;
    boolean zzoR;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzoO = new WeakReference(paramAdvertisingIdClient);
      this.zzoP = paramLong;
      this.zzoQ = new CountDownLatch(1);
      this.zzoR = false;
      start();
    }
    
    private void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzoO.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzoR = true;
      }
    }
    
    public void cancel()
    {
      this.zzoQ.countDown();
    }
    
    public void run()
    {
      try
      {
        if (!this.zzoQ.await(this.zzoP, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
      }
    }
    
    public boolean zzaM()
    {
      return this.zzoR;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\identifier\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */