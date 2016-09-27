package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<InterstitialAdParameterParcel>
{
  static void zza(InterstitialAdParameterParcel paramInterstitialAdParameterParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramInterstitialAdParameterParcel.versionCode);
    zzb.zza(paramParcel, 2, paramInterstitialAdParameterParcel.zzqa);
    zzb.zza(paramParcel, 3, paramInterstitialAdParameterParcel.zzqb);
    zzb.zza(paramParcel, 4, paramInterstitialAdParameterParcel.zzqc, false);
    zzb.zza(paramParcel, 5, paramInterstitialAdParameterParcel.zzqd);
    zzb.zza(paramParcel, 6, paramInterstitialAdParameterParcel.zzqe);
    zzb.zzI(paramParcel, i);
  }
  
  public InterstitialAdParameterParcel zza(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = zza.zzau(paramParcel);
    String str = null;
    float f = 0.0F;
    boolean bool2 = false;
    boolean bool3 = false;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        j = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        str = zza.zzp(paramParcel, k);
        break;
      case 5: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        f = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new InterstitialAdParameterParcel(j, bool3, bool2, str, bool1, f);
  }
  
  public InterstitialAdParameterParcel[] zzg(int paramInt)
  {
    return new InterstitialAdParameterParcel[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */