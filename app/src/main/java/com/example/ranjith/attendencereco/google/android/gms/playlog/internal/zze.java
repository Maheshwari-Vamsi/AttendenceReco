package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<PlayLoggerContext>
{
  static void zza(PlayLoggerContext paramPlayLoggerContext, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramPlayLoggerContext.versionCode);
    zzb.zza(paramParcel, 2, paramPlayLoggerContext.packageName, false);
    zzb.zzc(paramParcel, 3, paramPlayLoggerContext.zzaYy);
    zzb.zzc(paramParcel, 4, paramPlayLoggerContext.zzaYz);
    zzb.zza(paramParcel, 5, paramPlayLoggerContext.zzaYA, false);
    zzb.zza(paramParcel, 6, paramPlayLoggerContext.zzaYB, false);
    zzb.zza(paramParcel, 7, paramPlayLoggerContext.zzaYC);
    zzb.zza(paramParcel, 8, paramPlayLoggerContext.zzaYD, false);
    zzb.zza(paramParcel, 9, paramPlayLoggerContext.zzaYE);
    zzb.zzc(paramParcel, 10, paramPlayLoggerContext.zzaYF);
    zzb.zzI(paramParcel, i);
  }
  
  public PlayLoggerContext zzgo(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = zza.zzau(paramParcel);
    boolean bool1 = true;
    boolean bool2 = false;
    String str2 = null;
    String str3 = null;
    int k = 0;
    int m = 0;
    String str4 = null;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        n = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 3: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 5: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 7: 
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, i1);
        break;
      case 9: 
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 10: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlayLoggerContext(n, str4, m, k, str3, str2, bool1, str1, bool2, i);
  }
  
  public PlayLoggerContext[] zzjq(int paramInt)
  {
    return new PlayLoggerContext[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\playlog\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */