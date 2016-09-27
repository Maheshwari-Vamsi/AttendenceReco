package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<FieldMappingDictionary.FieldMapPair>
{
  static void zza(FieldMappingDictionary.FieldMapPair paramFieldMapPair, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramFieldMapPair.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramFieldMapPair.key, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramFieldMapPair.zzali, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public FieldMappingDictionary.FieldMapPair zzaB(Parcel paramParcel)
  {
    FastJsonResponse.Field localField = null;
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
        break;
      case 3: 
        localField = (FastJsonResponse.Field)zza.zza(paramParcel, k, FastJsonResponse.Field.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new FieldMappingDictionary.FieldMapPair(j, str, localField);
  }
  
  public FieldMappingDictionary.FieldMapPair[] zzcj(int paramInt)
  {
    return new FieldMappingDictionary.FieldMapPair[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\server\response\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */