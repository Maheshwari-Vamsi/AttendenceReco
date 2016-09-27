package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<AdSizeParcel>
{
  static void zza(AdSizeParcel paramAdSizeParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdSizeParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdSizeParcel.zztV, false);
    zzb.zzc(paramParcel, 3, paramAdSizeParcel.height);
    zzb.zzc(paramParcel, 4, paramAdSizeParcel.heightPixels);
    zzb.zza(paramParcel, 5, paramAdSizeParcel.zztW);
    zzb.zzc(paramParcel, 6, paramAdSizeParcel.width);
    zzb.zzc(paramParcel, 7, paramAdSizeParcel.widthPixels);
    zzb.zza(paramParcel, 8, paramAdSizeParcel.zztX, paramInt, false);
    zzb.zza(paramParcel, 9, paramAdSizeParcel.zztY);
    zzb.zza(paramParcel, 10, paramAdSizeParcel.zztZ);
    zzb.zza(paramParcel, 11, paramAdSizeParcel.zzua);
    zzb.zzI(paramParcel, i);
  }
  
  public AdSizeParcel zzc(Parcel paramParcel)
  {
    AdSizeParcel[] arrayOfAdSizeParcel = null;
    boolean bool1 = false;
    int i = zza.zzau(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    int j = 0;
    int k = 0;
    boolean bool4 = false;
    int m = 0;
    int n = 0;
    String str = null;
    int i1 = 0;
    while (paramParcel.dataPosition() < i)
    {
      int i2 = zza.zzat(paramParcel);
      switch (zza.zzcc(i2))
      {
      default: 
        zza.zzb(paramParcel, i2);
        break;
      case 1: 
        i1 = zza.zzg(paramParcel, i2);
        break;
      case 2: 
        str = zza.zzp(paramParcel, i2);
        break;
      case 3: 
        n = zza.zzg(paramParcel, i2);
        break;
      case 4: 
        m = zza.zzg(paramParcel, i2);
        break;
      case 5: 
        bool4 = zza.zzc(paramParcel, i2);
        break;
      case 6: 
        k = zza.zzg(paramParcel, i2);
        break;
      case 7: 
        j = zza.zzg(paramParcel, i2);
        break;
      case 8: 
        arrayOfAdSizeParcel = (AdSizeParcel[])zza.zzb(paramParcel, i2, AdSizeParcel.CREATOR);
        break;
      case 9: 
        bool3 = zza.zzc(paramParcel, i2);
        break;
      case 10: 
        bool2 = zza.zzc(paramParcel, i2);
        break;
      case 11: 
        bool1 = zza.zzc(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new AdSizeParcel(i1, str, n, m, bool4, k, j, arrayOfAdSizeParcel, bool3, bool2, bool1);
  }
  
  public AdSizeParcel[] zzm(int paramInt)
  {
    return new AdSizeParcel[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */