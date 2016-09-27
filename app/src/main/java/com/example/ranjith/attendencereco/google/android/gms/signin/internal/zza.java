package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AuthAccountResult>
{
  static void zza(AuthAccountResult paramAuthAccountResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAuthAccountResult.mVersionCode);
    zzb.zzc(paramParcel, 2, paramAuthAccountResult.zzDR());
    zzb.zza(paramParcel, 3, paramAuthAccountResult.zzDS(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AuthAccountResult zzgG(Parcel paramParcel)
  {
    int i = 0;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    Intent localIntent = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 3: 
        localIntent = (Intent)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, Intent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AuthAccountResult(k, i, localIntent);
  }
  
  public AuthAccountResult[] zzjJ(int paramInt)
  {
    return new AuthAccountResult[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\signin\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */