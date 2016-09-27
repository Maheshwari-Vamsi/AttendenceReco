package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras
  implements NetworkExtras
{
  private final Bundle mExtras;
  
  public AdMobExtras(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (Bundle localBundle = new Bundle(paramBundle);; localBundle = null)
    {
      this.mExtras = localBundle;
      return;
    }
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\mediation\admob\AdMobExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */