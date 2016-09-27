package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<NativeAdOptionsParcel>
{
  static void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramNativeAdOptionsParcel.versionCode);
    zzb.zza(paramParcel, 2, paramNativeAdOptionsParcel.zzyc);
    zzb.zzc(paramParcel, 3, paramNativeAdOptionsParcel.zzyd);
    zzb.zza(paramParcel, 4, paramNativeAdOptionsParcel.zzye);
    zzb.zzI(paramParcel, i);
  }
  
  public NativeAdOptionsParcel zze(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = zza.zzau(paramParcel);
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    while (paramParcel.dataPosition() < i)
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
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
        break;
      case 4: 
        bool1 = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new NativeAdOptionsParcel(k, bool2, j, bool1);
  }
  
  public NativeAdOptionsParcel[] zzp(int paramInt)
  {
    return new NativeAdOptionsParcel[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */