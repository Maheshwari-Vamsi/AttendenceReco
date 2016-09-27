package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.util.Set;

public class zzd
{
  private static final zzd zzael = new zzd();
  
  private boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return false;
    }
    zzc.zzb localzzb = new zzc.zzb(paramPackageInfo.signatures[0].toByteArray());
    if (paramBoolean) {}
    for (Set localSet = zzc.zzos(); localSet.contains(localzzb); localSet = zzc.zzot()) {
      return true;
    }
    if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
      Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(localzzb.getBytes(), 0));
    }
    return false;
  }
  
  public static zzd zzox()
  {
    return zzael;
  }
  
  zzc.zza zza(PackageInfo paramPackageInfo, zzc.zza... paramVarArgs)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    zzc.zzb localzzb = new zzc.zzb(paramPackageInfo.signatures[0].toByteArray());
    for (int i = 0; i < paramVarArgs.length; i++) {
      if (paramVarArgs[i].equals(localzzb)) {
        return paramVarArgs[i];
      }
    }
    if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
      Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(localzzb.getBytes(), 0));
    }
    return null;
  }
  
  public boolean zza(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool = false;
    if (paramPackageInfo == null) {}
    do
    {
      return bool;
      if (GooglePlayServicesUtil.zzc(paramPackageManager)) {
        return zza(paramPackageInfo, true);
      }
      bool = zza(paramPackageInfo, false);
    } while ((bool) || (!zza(paramPackageInfo, true)));
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool;
  }
  
  public boolean zzb(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      return zza(paramPackageManager, localPackageInfo);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
        Log.d("GoogleSignatureVerifier", "Package manager can't find package " + paramString + ", defaulting to false");
      }
    }
    return false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */