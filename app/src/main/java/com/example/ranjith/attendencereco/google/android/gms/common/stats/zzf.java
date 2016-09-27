package com.google.android.gms.common.stats;

public abstract class zzf
{
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    return getTimeMillis() + "\t" + getEventType() + "\t" + zzrv() + zzry();
  }
  
  public abstract long zzrv();
  
  public abstract String zzry();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\stats\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */