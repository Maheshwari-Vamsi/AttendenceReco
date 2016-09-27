package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class zzjl
{
  private final WeakReference<View> zzMc;
  
  public zzjl(View paramView)
  {
    this.zzMc = new WeakReference(paramView);
  }
  
  public final void detach()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null) {
      zzb(localViewTreeObserver);
    }
  }
  
  protected ViewTreeObserver getViewTreeObserver()
  {
    View localView = (View)this.zzMc.get();
    ViewTreeObserver localViewTreeObserver;
    if (localView == null) {
      localViewTreeObserver = null;
    }
    do
    {
      return localViewTreeObserver;
      localViewTreeObserver = localView.getViewTreeObserver();
    } while ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()));
    return null;
  }
  
  protected abstract void zza(ViewTreeObserver paramViewTreeObserver);
  
  protected abstract void zzb(ViewTreeObserver paramViewTreeObserver);
  
  public final void zzhu()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null) {
      zza(localViewTreeObserver);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */