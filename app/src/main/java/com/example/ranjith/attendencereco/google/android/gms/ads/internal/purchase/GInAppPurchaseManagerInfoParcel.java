package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzha;

@zzha
public final class GInAppPurchaseManagerInfoParcel
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final int versionCode;
  public final zzgb zzEv;
  public final Context zzEw;
  public final zzj zzEx;
  public final zzk zzrm;
  
  GInAppPurchaseManagerInfoParcel(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    this.versionCode = paramInt;
    this.zzrm = ((zzk)zze.zzp(zzd.zza.zzbs(paramIBinder1)));
    this.zzEv = ((zzgb)zze.zzp(zzd.zza.zzbs(paramIBinder2)));
    this.zzEw = ((Context)zze.zzp(zzd.zza.zzbs(paramIBinder3)));
    this.zzEx = ((zzj)zze.zzp(zzd.zza.zzbs(paramIBinder4)));
  }
  
  public GInAppPurchaseManagerInfoParcel(Context paramContext, zzk paramzzk, zzgb paramzzgb, zzj paramzzj)
  {
    this.versionCode = 2;
    this.zzEw = paramContext;
    this.zzrm = paramzzk;
    this.zzEv = paramzzgb;
    this.zzEx = paramzzj;
  }
  
  public static void zza(Intent paramIntent, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramGInAppPurchaseManagerInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static GInAppPurchaseManagerInfoParcel zzc(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      localBundle.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
      GInAppPurchaseManagerInfoParcel localGInAppPurchaseManagerInfoParcel = (GInAppPurchaseManagerInfoParcel)localBundle.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return localGInAppPurchaseManagerInfoParcel;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzfF()
  {
    return zze.zzB(this.zzEx).asBinder();
  }
  
  IBinder zzfG()
  {
    return zze.zzB(this.zzrm).asBinder();
  }
  
  IBinder zzfH()
  {
    return zze.zzB(this.zzEv).asBinder();
  }
  
  IBinder zzfI()
  {
    return zze.zzB(this.zzEw).asBinder();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\GInAppPurchaseManagerInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */