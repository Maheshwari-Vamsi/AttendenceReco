package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn
  implements Parcelable.Creator<StringParcel>
{
  static void zza(StringParcel paramStringParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramStringParcel.mVersionCode);
    zzb.zza(paramParcel, 2, paramStringParcel.zzxi, false);
    zzb.zzI(paramParcel, i);
  }
  
  public StringParcel[] zzK(int paramInt)
  {
    return new StringParcel[paramInt];
  }
  
  public StringParcel zzm(Parcel paramParcel)
  {
    int i = zza.zzau(paramParcel);
    int j = 0;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new StringParcel(j, str);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */