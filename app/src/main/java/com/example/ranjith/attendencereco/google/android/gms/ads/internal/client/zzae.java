package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae
  implements Parcelable.Creator<SearchAdRequestParcel>
{
  static void zza(SearchAdRequestParcel paramSearchAdRequestParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramSearchAdRequestParcel.versionCode);
    zzb.zzc(paramParcel, 2, paramSearchAdRequestParcel.zzuI);
    zzb.zzc(paramParcel, 3, paramSearchAdRequestParcel.backgroundColor);
    zzb.zzc(paramParcel, 4, paramSearchAdRequestParcel.zzuJ);
    zzb.zzc(paramParcel, 5, paramSearchAdRequestParcel.zzuK);
    zzb.zzc(paramParcel, 6, paramSearchAdRequestParcel.zzuL);
    zzb.zzc(paramParcel, 7, paramSearchAdRequestParcel.zzuM);
    zzb.zzc(paramParcel, 8, paramSearchAdRequestParcel.zzuN);
    zzb.zzc(paramParcel, 9, paramSearchAdRequestParcel.zzuO);
    zzb.zza(paramParcel, 10, paramSearchAdRequestParcel.zzuP, false);
    zzb.zzc(paramParcel, 11, paramSearchAdRequestParcel.zzuQ);
    zzb.zza(paramParcel, 12, paramSearchAdRequestParcel.zzuR, false);
    zzb.zzc(paramParcel, 13, paramSearchAdRequestParcel.zzuS);
    zzb.zzc(paramParcel, 14, paramSearchAdRequestParcel.zzuT);
    zzb.zza(paramParcel, 15, paramSearchAdRequestParcel.zzuU, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SearchAdRequestParcel zzd(Parcel paramParcel)
  {
    int i = zza.zzau(paramParcel);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    String str1 = null;
    int i6 = 0;
    String str2 = null;
    int i7 = 0;
    int i8 = 0;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int i9 = zza.zzat(paramParcel);
      switch (zza.zzcc(i9))
      {
      default: 
        zza.zzb(paramParcel, i9);
        break;
      case 1: 
        j = zza.zzg(paramParcel, i9);
        break;
      case 2: 
        k = zza.zzg(paramParcel, i9);
        break;
      case 3: 
        m = zza.zzg(paramParcel, i9);
        break;
      case 4: 
        n = zza.zzg(paramParcel, i9);
        break;
      case 5: 
        i1 = zza.zzg(paramParcel, i9);
        break;
      case 6: 
        i2 = zza.zzg(paramParcel, i9);
        break;
      case 7: 
        i3 = zza.zzg(paramParcel, i9);
        break;
      case 8: 
        i4 = zza.zzg(paramParcel, i9);
        break;
      case 9: 
        i5 = zza.zzg(paramParcel, i9);
        break;
      case 10: 
        str1 = zza.zzp(paramParcel, i9);
        break;
      case 11: 
        i6 = zza.zzg(paramParcel, i9);
        break;
      case 12: 
        str2 = zza.zzp(paramParcel, i9);
        break;
      case 13: 
        i7 = zza.zzg(paramParcel, i9);
        break;
      case 14: 
        i8 = zza.zzg(paramParcel, i9);
        break;
      case 15: 
        str3 = zza.zzp(paramParcel, i9);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new SearchAdRequestParcel(j, k, m, n, i1, i2, i3, i4, i5, str1, i6, str2, i7, i8, str3);
  }
  
  public SearchAdRequestParcel[] zzo(int paramInt)
  {
    return new SearchAdRequestParcel[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */