package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<SignInAccount>
{
  static void zza(SignInAccount paramSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramSignInAccount.versionCode);
    zzb.zza(paramParcel, 2, paramSignInAccount.zzmC(), false);
    zzb.zza(paramParcel, 3, paramSignInAccount.getIdToken(), false);
    zzb.zza(paramParcel, 4, paramSignInAccount.getEmail(), false);
    zzb.zza(paramParcel, 5, paramSignInAccount.getDisplayName(), false);
    zzb.zza(paramParcel, 6, paramSignInAccount.getPhotoUrl(), paramInt, false);
    zzb.zza(paramParcel, 7, paramSignInAccount.zzmD(), paramInt, false);
    zzb.zza(paramParcel, 8, paramSignInAccount.getUserId(), false);
    zzb.zza(paramParcel, 9, paramSignInAccount.zzmE(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SignInAccount zzT(Parcel paramParcel)
  {
    String str1 = null;
    int i = zza.zzau(paramParcel);
    int j = 0;
    String str2 = "";
    GoogleSignInAccount localGoogleSignInAccount = null;
    Uri localUri = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
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
        str6 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 7: 
        localGoogleSignInAccount = (GoogleSignInAccount)zza.zza(paramParcel, k, GoogleSignInAccount.CREATOR);
        break;
      case 8: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 9: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new SignInAccount(j, str6, str5, str4, str3, localUri, localGoogleSignInAccount, str2, str1);
  }
  
  public SignInAccount[] zzaO(int paramInt)
  {
    return new SignInAccount[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */