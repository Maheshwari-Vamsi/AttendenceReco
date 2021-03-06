package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public abstract interface MediationAdapter
{
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public static class zza
  {
    private int zzMT;
    
    public zza zzS(int paramInt)
    {
      this.zzMT = paramInt;
      return this;
    }
    
    public Bundle zzie()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("capabilities", this.zzMT);
      return localBundle;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\mediation\MediationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */