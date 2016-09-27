package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<RewardItemParcel>
{
  static void zza(RewardItemParcel paramRewardItemParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramRewardItemParcel.versionCode);
    zzb.zza(paramParcel, 2, paramRewardItemParcel.type, false);
    zzb.zzc(paramParcel, 3, paramRewardItemParcel.zzJD);
    zzb.zzI(paramParcel, i);
  }
  
  public RewardItemParcel[] zzO(int paramInt)
  {
    return new RewardItemParcel[paramInt];
  }
  
  public RewardItemParcel zzo(Parcel paramParcel)
  {
    int i = 0;
    int j = zza.zzau(paramParcel);
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        k = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str = zza.zzp(paramParcel, m);
        break;
      case 3: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RewardItemParcel(k, str, i);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\reward\mediation\client\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */