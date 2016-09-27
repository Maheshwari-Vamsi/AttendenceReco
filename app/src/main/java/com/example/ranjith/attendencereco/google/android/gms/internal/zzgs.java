package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzgs
  extends zzgr
{
  private Object zzFu = new Object();
  private PopupWindow zzFv;
  private boolean zzFw = false;
  
  zzgs(Context paramContext, zzie.zza paramzza, zzjn paramzzjn, zzgq.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzjn, paramzza1);
  }
  
  private void zzfX()
  {
    synchronized (this.zzFu)
    {
      this.zzFw = true;
      if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isDestroyed())) {
        this.zzFv = null;
      }
      if (this.zzFv != null)
      {
        if (this.zzFv.isShowing()) {
          this.zzFv.dismiss();
        }
        this.zzFv = null;
      }
      return;
    }
  }
  
  public void cancel()
  {
    zzfX();
    super.cancel();
  }
  
  protected void zzC(int paramInt)
  {
    zzfX();
    super.zzC(paramInt);
  }
  
  protected void zzfW()
  {
    if ((this.mContext instanceof Activity)) {}
    for (Window localWindow = ((Activity)this.mContext).getWindow();; localWindow = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null)) {}
      while (((Activity)this.mContext).isDestroyed()) {
        return;
      }
      FrameLayout localFrameLayout = new FrameLayout(this.mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(this.zzps.getView(), -1, -1);
      synchronized (this.zzFu)
      {
        if (this.zzFw) {
          return;
        }
      }
      this.zzFv = new PopupWindow(localFrameLayout, 1, 1, false);
      this.zzFv.setOutsideTouchable(true);
      this.zzFv.setClippingEnabled(false);
      zzb.zzaF("Displaying the 1x1 popup off the screen.");
      try
      {
        this.zzFv.showAtLocation(localWindow.getDecorView(), 0, -1, -1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.zzFv = null;
        }
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */