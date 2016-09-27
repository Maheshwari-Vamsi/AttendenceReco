package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza
  extends zzp.zza
{
  private Context mContext;
  private Account zzSo;
  int zzaiR;
  
  public static Account zzb(zzp paramzzp)
  {
    Object localObject1 = null;
    long l;
    if (paramzzp != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      Account localAccount = paramzzp.getAccount();
      localObject1 = localAccount;
      return (Account)localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    return this.zzSo.equals(((zza)paramObject).zzSo);
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == this.zzaiR) {
      return this.zzSo;
    }
    if (GooglePlayServicesUtil.zze(this.mContext, i))
    {
      this.zzaiR = i;
      return this.zzSo;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */