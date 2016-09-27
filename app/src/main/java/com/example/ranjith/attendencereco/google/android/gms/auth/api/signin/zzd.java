package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<GoogleSignInOptions>
{
  static void zza(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGoogleSignInOptions.versionCode);
    zzb.zzc(paramParcel, 2, paramGoogleSignInOptions.zzmu(), false);
    zzb.zza(paramParcel, 3, paramGoogleSignInOptions.getAccount(), paramInt, false);
    zzb.zza(paramParcel, 4, paramGoogleSignInOptions.zzmy());
    zzb.zza(paramParcel, 5, paramGoogleSignInOptions.zzmz());
    zzb.zza(paramParcel, 6, paramGoogleSignInOptions.zzmA());
    zzb.zza(paramParcel, 7, paramGoogleSignInOptions.zzmB(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public GoogleSignInOptions zzS(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int i = zza.zzau(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 3: 
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 7: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new GoogleSignInOptions(j, localArrayList, localAccount, bool3, bool2, bool1, str);
  }
  
  public GoogleSignInOptions[] zzaN(int paramInt)
  {
    return new GoogleSignInOptions[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */