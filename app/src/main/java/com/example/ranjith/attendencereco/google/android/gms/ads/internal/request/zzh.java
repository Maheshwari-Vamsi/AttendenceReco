package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<AdResponseParcel>
{
  static void zza(AdResponseParcel paramAdResponseParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdResponseParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdResponseParcel.zzDE, false);
    zzb.zza(paramParcel, 3, paramAdResponseParcel.body, false);
    zzb.zzb(paramParcel, 4, paramAdResponseParcel.zzAQ, false);
    zzb.zzc(paramParcel, 5, paramAdResponseParcel.errorCode);
    zzb.zzb(paramParcel, 6, paramAdResponseParcel.zzAR, false);
    zzb.zza(paramParcel, 7, paramAdResponseParcel.zzGM);
    zzb.zza(paramParcel, 8, paramAdResponseParcel.zzGN);
    zzb.zza(paramParcel, 9, paramAdResponseParcel.zzGO);
    zzb.zzb(paramParcel, 10, paramAdResponseParcel.zzGP, false);
    zzb.zza(paramParcel, 11, paramAdResponseParcel.zzAU);
    zzb.zzc(paramParcel, 12, paramAdResponseParcel.orientation);
    zzb.zza(paramParcel, 13, paramAdResponseParcel.zzGQ, false);
    zzb.zza(paramParcel, 14, paramAdResponseParcel.zzGR);
    zzb.zza(paramParcel, 15, paramAdResponseParcel.zzGS, false);
    zzb.zza(paramParcel, 19, paramAdResponseParcel.zzGU, false);
    zzb.zza(paramParcel, 18, paramAdResponseParcel.zzGT);
    zzb.zza(paramParcel, 21, paramAdResponseParcel.zzGV, false);
    zzb.zza(paramParcel, 23, paramAdResponseParcel.zztY);
    zzb.zza(paramParcel, 22, paramAdResponseParcel.zzGW);
    zzb.zza(paramParcel, 25, paramAdResponseParcel.zzGX);
    zzb.zza(paramParcel, 24, paramAdResponseParcel.zzGy);
    zzb.zzc(paramParcel, 27, paramAdResponseParcel.zzGZ);
    zzb.zza(paramParcel, 26, paramAdResponseParcel.zzGY);
    zzb.zza(paramParcel, 29, paramAdResponseParcel.zzHb, false);
    zzb.zza(paramParcel, 28, paramAdResponseParcel.zzHa, paramInt, false);
    zzb.zza(paramParcel, 31, paramAdResponseParcel.zztZ);
    zzb.zza(paramParcel, 30, paramAdResponseParcel.zzHc, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdResponseParcel[] zzH(int paramInt)
  {
    return new AdResponseParcel[paramInt];
  }
  
  public AdResponseParcel zzj(Parcel paramParcel)
  {
    int i = zza.zzau(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList1 = null;
    int k = 0;
    ArrayList localArrayList2 = null;
    long l1 = 0L;
    boolean bool1 = false;
    long l2 = 0L;
    ArrayList localArrayList3 = null;
    long l3 = 0L;
    int m = 0;
    String str3 = null;
    long l4 = 0L;
    String str4 = null;
    boolean bool2 = false;
    String str5 = null;
    String str6 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    int n = 0;
    LargeParcelTeleporter localLargeParcelTeleporter = null;
    String str7 = null;
    String str8 = null;
    boolean bool8 = false;
    while (paramParcel.dataPosition() < i)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      case 16: 
      case 17: 
      case 20: 
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        str1 = zza.zzp(paramParcel, i1);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 4: 
        localArrayList1 = zza.zzD(paramParcel, i1);
        break;
      case 5: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 6: 
        localArrayList2 = zza.zzD(paramParcel, i1);
        break;
      case 7: 
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 8: 
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 9: 
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 10: 
        localArrayList3 = zza.zzD(paramParcel, i1);
        break;
      case 11: 
        l3 = zza.zzi(paramParcel, i1);
        break;
      case 12: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 13: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 14: 
        l4 = zza.zzi(paramParcel, i1);
        break;
      case 15: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 19: 
        str5 = zza.zzp(paramParcel, i1);
        break;
      case 18: 
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 21: 
        str6 = zza.zzp(paramParcel, i1);
        break;
      case 23: 
        bool4 = zza.zzc(paramParcel, i1);
        break;
      case 22: 
        bool3 = zza.zzc(paramParcel, i1);
        break;
      case 25: 
        bool6 = zza.zzc(paramParcel, i1);
        break;
      case 24: 
        bool5 = zza.zzc(paramParcel, i1);
        break;
      case 27: 
        n = zza.zzg(paramParcel, i1);
        break;
      case 26: 
        bool7 = zza.zzc(paramParcel, i1);
        break;
      case 29: 
        str7 = zza.zzp(paramParcel, i1);
        break;
      case 28: 
        localLargeParcelTeleporter = (LargeParcelTeleporter)zza.zza(paramParcel, i1, LargeParcelTeleporter.CREATOR);
        break;
      case 31: 
        bool8 = zza.zzc(paramParcel, i1);
        break;
      case 30: 
        str8 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new AdResponseParcel(j, str1, str2, localArrayList1, k, localArrayList2, l1, bool1, l2, localArrayList3, l3, m, str3, l4, str4, bool2, str5, str6, bool3, bool4, bool5, bool6, bool7, n, localLargeParcelTeleporter, str7, str8, bool8);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */