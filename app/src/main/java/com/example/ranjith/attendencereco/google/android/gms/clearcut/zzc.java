package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzc
  implements Parcelable.Creator<LogEventParcelable>
{
  static void zza(LogEventParcelable paramLogEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLogEventParcelable.versionCode);
    zzb.zza(paramParcel, 2, paramLogEventParcelable.zzadx, paramInt, false);
    zzb.zza(paramParcel, 3, paramLogEventParcelable.zzady, false);
    zzb.zza(paramParcel, 4, paramLogEventParcelable.zzadz, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LogEventParcelable zzaf(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = zza.zzau(paramParcel);
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = zza.zzat(paramParcel);
      Object localObject4;
      Object localObject5;
      Object localObject6;
      int m;
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        break;
        int n = zza.zzg(paramParcel, k);
        Object localObject9 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = n;
        localObject4 = localObject9;
        continue;
        PlayLoggerContext localPlayLoggerContext = (PlayLoggerContext)zza.zza(paramParcel, k, PlayLoggerContext.CREATOR);
        m = j;
        Object localObject8 = localObject2;
        localObject6 = localPlayLoggerContext;
        localObject4 = localObject1;
        localObject5 = localObject8;
        continue;
        byte[] arrayOfByte = zza.zzs(paramParcel, k);
        localObject6 = localObject3;
        m = j;
        Object localObject7 = localObject1;
        localObject5 = arrayOfByte;
        localObject4 = localObject7;
        continue;
        localObject4 = zza.zzv(paramParcel, k);
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new LogEventParcelable(j, (PlayLoggerContext)localObject3, (byte[])localObject2, (int[])localObject1);
  }
  
  public LogEventParcelable[] zzbs(int paramInt)
  {
    return new LogEventParcelable[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\clearcut\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */