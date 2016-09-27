package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<GetServiceRequest>
{
  static void zza(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetServiceRequest.version);
    zzb.zzc(paramParcel, 2, paramGetServiceRequest.zzajA);
    zzb.zzc(paramParcel, 3, paramGetServiceRequest.zzajB);
    zzb.zza(paramParcel, 4, paramGetServiceRequest.zzajC, false);
    zzb.zza(paramParcel, 5, paramGetServiceRequest.zzajD, false);
    zzb.zza(paramParcel, 6, paramGetServiceRequest.zzajE, paramInt, false);
    zzb.zza(paramParcel, 7, paramGetServiceRequest.zzajF, false);
    zzb.zza(paramParcel, 8, paramGetServiceRequest.zzajG, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetServiceRequest zzao(Parcel paramParcel)
  {
    int i = 0;
    Account localAccount = null;
    int j = zza.zzau(paramParcel);
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        m = zza.zzg(paramParcel, n);
        break;
      case 2: 
        k = zza.zzg(paramParcel, n);
        break;
      case 3: 
        i = zza.zzg(paramParcel, n);
        break;
      case 4: 
        str = zza.zzp(paramParcel, n);
        break;
      case 5: 
        localIBinder = zza.zzq(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])zza.zzb(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = zza.zzr(paramParcel, n);
        break;
      case 8: 
        localAccount = (Account)zza.zza(paramParcel, n, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetServiceRequest(m, k, i, str, localIBinder, arrayOfScope, localBundle, localAccount);
  }
  
  public GetServiceRequest[] zzbS(int paramInt)
  {
    return new GetServiceRequest[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */