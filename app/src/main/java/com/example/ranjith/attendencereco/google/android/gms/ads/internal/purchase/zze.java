package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgd.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zziq;

@zzha
public class zze
  extends zzgd.zza
  implements ServiceConnection
{
  private final Activity mActivity;
  private zzb zzEB;
  zzh zzEC;
  private zzk zzEE;
  private Context zzEJ;
  private zzgb zzEK;
  private zzf zzEL;
  private zzj zzEM;
  private String zzEN = null;
  
  public zze(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.zzEC = zzh.zzy(this.mActivity.getApplicationContext());
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 1001
    //   4: if_icmpne +92 -> 96
    //   7: invokestatic 58	com/google/android/gms/ads/internal/zzp:zzbH	()Lcom/google/android/gms/ads/internal/purchase/zzi;
    //   10: aload_3
    //   11: invokevirtual 64	com/google/android/gms/ads/internal/purchase/zzi:zzd	(Landroid/content/Intent;)I
    //   14: istore 6
    //   16: iload_2
    //   17: iconst_m1
    //   18: if_icmpne +79 -> 97
    //   21: invokestatic 58	com/google/android/gms/ads/internal/zzp:zzbH	()Lcom/google/android/gms/ads/internal/purchase/zzi;
    //   24: pop
    //   25: iload 6
    //   27: ifne +70 -> 97
    //   30: aload_0
    //   31: getfield 66	com/google/android/gms/ads/internal/purchase/zze:zzEE	Lcom/google/android/gms/ads/internal/purchase/zzk;
    //   34: aload_0
    //   35: getfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   38: iload_2
    //   39: aload_3
    //   40: invokevirtual 72	com/google/android/gms/ads/internal/purchase/zzk:zza	(Ljava/lang/String;ILandroid/content/Intent;)Z
    //   43: istore 8
    //   45: iconst_0
    //   46: istore 9
    //   48: iload 8
    //   50: ifeq +6 -> 56
    //   53: iconst_1
    //   54: istore 9
    //   56: aload_0
    //   57: getfield 74	com/google/android/gms/ads/internal/purchase/zze:zzEK	Lcom/google/android/gms/internal/zzgb;
    //   60: iload 6
    //   62: invokeinterface 80 2 0
    //   67: aload_0
    //   68: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   71: invokevirtual 83	android/app/Activity:finish	()V
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 74	com/google/android/gms/ads/internal/purchase/zze:zzEK	Lcom/google/android/gms/internal/zzgb;
    //   79: invokeinterface 87 1 0
    //   84: iload 9
    //   86: iload_2
    //   87: aload_3
    //   88: invokevirtual 90	com/google/android/gms/ads/internal/purchase/zze:zza	(Ljava/lang/String;ZILandroid/content/Intent;)V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   96: return
    //   97: aload_0
    //   98: getfield 48	com/google/android/gms/ads/internal/purchase/zze:zzEC	Lcom/google/android/gms/ads/internal/purchase/zzh;
    //   101: aload_0
    //   102: getfield 92	com/google/android/gms/ads/internal/purchase/zze:zzEL	Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   105: invokevirtual 95	com/google/android/gms/ads/internal/purchase/zzh:zza	(Lcom/google/android/gms/ads/internal/purchase/zzf;)V
    //   108: iconst_0
    //   109: istore 9
    //   111: goto -55 -> 56
    //   114: astore 5
    //   116: ldc 97
    //   118: invokestatic 103	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   125: invokevirtual 83	android/app/Activity:finish	()V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   133: return
    //   134: astore 4
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   141: aload 4
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	zze
    //   0	144	1	paramInt1	int
    //   0	144	2	paramInt2	int
    //   0	144	3	paramIntent	Intent
    //   134	8	4	localObject	Object
    //   114	1	5	localRemoteException	RemoteException
    //   14	47	6	i	int
    //   43	6	8	bool1	boolean
    //   46	64	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	16	114	android/os/RemoteException
    //   21	25	114	android/os/RemoteException
    //   30	45	114	android/os/RemoteException
    //   56	91	114	android/os/RemoteException
    //   97	108	114	android/os/RemoteException
    //   7	16	134	finally
    //   21	25	134	finally
    //   30	45	134	finally
    //   56	91	134	finally
    //   97	108	134	finally
    //   116	128	134	finally
  }
  
  public void onCreate()
  {
    GInAppPurchaseManagerInfoParcel localGInAppPurchaseManagerInfoParcel = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
    this.zzEM = localGInAppPurchaseManagerInfoParcel.zzEx;
    this.zzEE = localGInAppPurchaseManagerInfoParcel.zzrm;
    this.zzEK = localGInAppPurchaseManagerInfoParcel.zzEv;
    this.zzEB = new zzb(this.mActivity.getApplicationContext());
    this.zzEJ = localGInAppPurchaseManagerInfoParcel.zzEw;
    if (this.mActivity.getResources().getConfiguration().orientation == 2) {
      this.mActivity.setRequestedOrientation(zzp.zzbz().zzhd());
    }
    for (;;)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      this.mActivity.bindService(localIntent, this, 1);
      return;
      this.mActivity.setRequestedOrientation(zzp.zzbz().zzhe());
    }
  }
  
  public void onDestroy()
  {
    this.mActivity.unbindService(this);
    this.zzEB.destroy();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzEB.zzN(paramIBinder);
    try
    {
      this.zzEN = this.zzEE.zzfN();
      Bundle localBundle = this.zzEB.zzb(this.mActivity.getPackageName(), this.zzEK.getProductId(), this.zzEN);
      PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
      if (localPendingIntent == null)
      {
        int i = zzp.zzbH().zzd(localBundle);
        this.zzEK.recordPlayBillingResolution(i);
        zza(this.zzEK.getProductId(), false, i, null);
        this.mActivity.finish();
        return;
      }
      this.zzEL = new zzf(this.zzEK.getProductId(), this.zzEN);
      this.zzEC.zzb(this.zzEL);
      this.mActivity.startIntentSenderForResult(localPendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Error when connecting in-app billing service", localRemoteException);
      this.mActivity.finish();
      return;
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      for (;;) {}
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
    this.zzEB.destroy();
  }
  
  protected void zza(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if (this.zzEM != null) {
      this.zzEM.zza(paramString, paramBoolean, paramInt, paramIntent, this.zzEL);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */