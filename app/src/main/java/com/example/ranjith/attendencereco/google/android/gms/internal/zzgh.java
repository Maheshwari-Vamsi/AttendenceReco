package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

@zzha
public final class zzgh
  extends zzgc.zza
{
  private final InAppPurchaseListener zzuz;
  
  public zzgh(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.zzuz = paramInAppPurchaseListener;
  }
  
  public void zza(zzgb paramzzgb)
  {
    this.zzuz.onInAppPurchaseRequested(new zzgk(paramzzgb));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */