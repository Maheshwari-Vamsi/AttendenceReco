package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<FacebookSignInOptions>
{
  static void zza(FacebookSignInOptions paramFacebookSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramFacebookSignInOptions.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramFacebookSignInOptions.zzmt(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, 3, paramFacebookSignInOptions.zzmu(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public FacebookSignInOptions zzQ(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = zza.zzau(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = zza.zzat(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        int n = zza.zzg(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        Intent localIntent = (Intent)zza.zza(paramParcel, k, Intent.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localIntent;
        continue;
        localObject3 = zza.zzD(paramParcel, k);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new FacebookSignInOptions(j, (Intent)localObject2, (ArrayList)localObject1);
  }
  
  public FacebookSignInOptions[] zzaL(int paramInt)
  {
    return new FacebookSignInOptions[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */