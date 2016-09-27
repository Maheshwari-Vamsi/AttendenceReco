package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy
  implements Parcelable.Creator<ResolveAccountRequest>
{
  static void zza(ResolveAccountRequest paramResolveAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramResolveAccountRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramResolveAccountRequest.getAccount(), paramInt, false);
    zzb.zzc(paramParcel, 3, paramResolveAccountRequest.getSessionId());
    zzb.zza(paramParcel, 4, paramResolveAccountRequest.zzqG(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ResolveAccountRequest zzap(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = zza.zzau(paramParcel);
    Object localObject2 = null;
    int k = 0;
    if (paramParcel.dataPosition() < j)
    {
      int m = zza.zzat(paramParcel);
      Object localObject3;
      int n;
      Object localObject4;
      int i1;
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        localObject3 = localObject1;
        n = i;
        localObject4 = localObject2;
        i1 = k;
      }
      for (;;)
      {
        k = i1;
        localObject2 = localObject4;
        i = n;
        localObject1 = localObject3;
        break;
        int i4 = zza.zzg(paramParcel, m);
        Object localObject6 = localObject1;
        n = i;
        localObject4 = localObject2;
        i1 = i4;
        localObject3 = localObject6;
        continue;
        Account localAccount = (Account)zza.zza(paramParcel, m, Account.CREATOR);
        i1 = k;
        int i3 = i;
        localObject4 = localAccount;
        localObject3 = localObject1;
        n = i3;
        continue;
        int i2 = zza.zzg(paramParcel, m);
        localObject4 = localObject2;
        i1 = k;
        Object localObject5 = localObject1;
        n = i2;
        localObject3 = localObject5;
        continue;
        localObject3 = (GoogleSignInAccount)zza.zza(paramParcel, m, GoogleSignInAccount.CREATOR);
        n = i;
        localObject4 = localObject2;
        i1 = k;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ResolveAccountRequest(k, (Account)localObject2, i, (GoogleSignInAccount)localObject1);
  }
  
  public ResolveAccountRequest[] zzbY(int paramInt)
  {
    return new ResolveAccountRequest[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */