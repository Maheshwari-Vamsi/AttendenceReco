package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;

public class zzg
{
  public static String zza(PowerManager.WakeLock paramWakeLock, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramWakeLock)));
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    return paramString;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\stats\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */