package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<TokenData>
{
  static void zza(TokenData paramTokenData, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramTokenData.mVersionCode);
    zzb.zza(paramParcel, 2, paramTokenData.getToken(), false);
    zzb.zza(paramParcel, 3, paramTokenData.zzlW(), false);
    zzb.zza(paramParcel, 4, paramTokenData.zzlX());
    zzb.zza(paramParcel, 5, paramTokenData.zzlY());
    zzb.zzb(paramParcel, 6, paramTokenData.zzlZ(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public TokenData zzC(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    boolean bool1 = false;
    int i = zza.zzau(paramParcel);
    boolean bool2 = false;
    Long localLong = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localLong = zza.zzj(paramParcel, k);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        localArrayList = zza.zzD(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new TokenData(j, str, localLong, bool2, bool1, localArrayList);
  }
  
  public TokenData[] zzax(int paramInt)
  {
    return new TokenData[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */