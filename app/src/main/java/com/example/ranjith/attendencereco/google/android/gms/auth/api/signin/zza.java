package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<EmailSignInOptions>
{
  static void zza(EmailSignInOptions paramEmailSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramEmailSignInOptions.versionCode);
    zzb.zza(paramParcel, 2, paramEmailSignInOptions.zzmo(), paramInt, false);
    zzb.zza(paramParcel, 3, paramEmailSignInOptions.zzmq(), false);
    zzb.zza(paramParcel, 4, paramEmailSignInOptions.zzmp(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public EmailSignInOptions zzP(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      Object localObject4;
      Object localObject5;
      Object localObject6;
      int m;
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
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
        int n = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        Object localObject9 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = n;
        localObject4 = localObject9;
        continue;
        Uri localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        m = j;
        Object localObject8 = localObject2;
        localObject6 = localUri;
        localObject4 = localObject1;
        localObject5 = localObject8;
        continue;
        String str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        localObject6 = localObject3;
        m = j;
        Object localObject7 = localObject1;
        localObject5 = str;
        localObject4 = localObject7;
        continue;
        localObject4 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new EmailSignInOptions(j, (Uri)localObject3, (String)localObject2, (Uri)localObject1);
  }
  
  public EmailSignInOptions[] zzaK(int paramInt)
  {
    return new EmailSignInOptions[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */