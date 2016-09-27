package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzfu.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjo.zza;
import com.google.android.gms.internal.zzjp;
import java.util.Collections;

@zzha
public class zzd
  extends zzfu.zza
  implements zzo
{
  static final int zzDg = Color.argb(0, 0, 0, 0);
  private final Activity mActivity;
  RelativeLayout zzCm;
  AdOverlayInfoParcel zzDh;
  zzc zzDi;
  zzm zzDj;
  boolean zzDk = false;
  FrameLayout zzDl;
  WebChromeClient.CustomViewCallback zzDm;
  boolean zzDn = false;
  boolean zzDo = false;
  boolean zzDp = false;
  int zzDq = 0;
  private boolean zzDr;
  private boolean zzDs = false;
  private boolean zzDt = true;
  zzjn zzps;
  
  public zzd(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void close()
  {
    this.zzDq = 2;
    this.mActivity.finish();
  }
  
  public void onBackPressed()
  {
    this.zzDq = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.zzDn = bool;
    do
    {
      try
      {
        this.zzDh = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
        if (this.zzDh == null) {
          throw new zza("Could not get info for ad overlay.");
        }
      }
      catch (zza localzza)
      {
        zzb.zzaH(localzza.getMessage());
        this.zzDq = 3;
        this.mActivity.finish();
        return;
      }
      if (this.zzDh.zzqR.zzLG > 7500000) {
        this.zzDq = 3;
      }
      if (this.mActivity.getIntent() != null) {
        this.zzDt = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
      }
      if (this.zzDh.zzDL != null) {}
      for (this.zzDo = this.zzDh.zzDL.zzqa;; this.zzDo = false)
      {
        if ((((Boolean)zzbz.zzwI.get()).booleanValue()) && (this.zzDo) && (this.zzDh.zzDL.zzqc != null)) {
          new zzd(null).zzgX();
        }
        if (paramBundle == null)
        {
          if ((this.zzDh.zzDB != null) && (this.zzDt)) {
            this.zzDh.zzDB.zzaY();
          }
          if ((this.zzDh.zzDI != 1) && (this.zzDh.zzDA != null)) {
            this.zzDh.zzDA.onAdClicked();
          }
        }
        this.zzCm = new zzb(this.mActivity, this.zzDh.zzDK);
        switch (this.zzDh.zzDI)
        {
        default: 
          throw new zza("Could not determine ad overlay type.");
        }
      }
      zzx(false);
      return;
      this.zzDi = new zzc(this.zzDh.zzDC);
      zzx(false);
      return;
      zzx(true);
      return;
      if (this.zzDn)
      {
        this.zzDq = 3;
        this.mActivity.finish();
        return;
      }
    } while (zzp.zzbu().zza(this.mActivity, this.zzDh.zzDz, this.zzDh.zzDH));
    this.zzDq = 3;
    this.mActivity.finish();
  }
  
  public void onDestroy()
  {
    if (this.zzps != null) {
      this.zzCm.removeView(this.zzps.getView());
    }
    zzfe();
  }
  
  public void onPause()
  {
    zzfa();
    if ((this.zzps != null) && ((!this.mActivity.isFinishing()) || (this.zzDi == null))) {
      zzp.zzbz().zzf(this.zzps);
    }
    zzfe();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.zzDh != null) && (this.zzDh.zzDI == 4))
    {
      if (!this.zzDn) {
        break label68;
      }
      this.zzDq = 3;
      this.mActivity.finish();
    }
    while ((this.zzps != null) && (!this.zzps.isDestroyed()))
    {
      zzp.zzbz().zzg(this.zzps);
      return;
      label68:
      this.zzDn = true;
    }
    zzb.zzaH("The webview does not exit. Ignoring action.");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzDn);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    zzfe();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.mActivity.setRequestedOrientation(paramInt);
  }
  
  public void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.zzDl = new FrameLayout(this.mActivity);
    this.zzDl.setBackgroundColor(-16777216);
    this.zzDl.addView(paramView, -1, -1);
    this.mActivity.setContentView(this.zzDl);
    zzaF();
    this.zzDm = paramCustomViewCallback;
    this.zzDk = true;
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.zzDj != null) {
      this.zzDj.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  public void zzaF()
  {
    this.zzDr = true;
  }
  
  public void zzfa()
  {
    if ((this.zzDh != null) && (this.zzDk)) {
      setRequestedOrientation(this.zzDh.orientation);
    }
    if (this.zzDl != null)
    {
      this.mActivity.setContentView(this.zzCm);
      zzaF();
      this.zzDl.removeAllViews();
      this.zzDl = null;
    }
    if (this.zzDm != null)
    {
      this.zzDm.onCustomViewHidden();
      this.zzDm = null;
    }
    this.zzDk = false;
  }
  
  public void zzfb()
  {
    this.zzDq = 1;
    this.mActivity.finish();
  }
  
  public boolean zzfc()
  {
    this.zzDq = 0;
    boolean bool;
    if (this.zzps == null) {
      bool = true;
    }
    do
    {
      return bool;
      bool = this.zzps.zzhI();
    } while (bool);
    this.zzps.zzb("onbackblocked", Collections.emptyMap());
    return bool;
  }
  
  public void zzfd()
  {
    this.zzCm.removeView(this.zzDj);
    zzw(true);
  }
  
  protected void zzfe()
  {
    if ((!this.mActivity.isFinishing()) || (this.zzDs)) {}
    do
    {
      return;
      this.zzDs = true;
      if (this.zzps != null)
      {
        zzy(this.zzDq);
        this.zzCm.removeView(this.zzps.getView());
        if (this.zzDi != null)
        {
          this.zzps.setContext(this.zzDi.context);
          this.zzps.zzD(false);
          this.zzDi.zzDw.addView(this.zzps.getView(), this.zzDi.index, this.zzDi.zzDv);
          this.zzDi = null;
        }
        this.zzps = null;
      }
    } while ((this.zzDh == null) || (this.zzDh.zzDB == null));
    this.zzDh.zzDB.zzaX();
  }
  
  public void zzff()
  {
    if (this.zzDp)
    {
      this.zzDp = false;
      zzfg();
    }
  }
  
  protected void zzfg()
  {
    this.zzps.zzfg();
  }
  
  public void zzw(boolean paramBoolean)
  {
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.zzDj = new zzm(this.mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label90;
      }
    }
    label90:
    for (int j = 11;; j = 9)
    {
      localLayoutParams.addRule(j);
      this.zzDj.zza(paramBoolean, this.zzDh.zzDF);
      this.zzCm.addView(this.zzDj, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  protected void zzx(boolean paramBoolean)
    throws zzd.zza
  {
    if (!this.zzDr) {
      this.mActivity.requestWindowFeature(1);
    }
    Window localWindow = this.mActivity.getWindow();
    if (localWindow == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((!this.zzDo) || ((this.zzDh.zzDL != null) && (this.zzDh.zzDL.zzqb))) {
      localWindow.setFlags(1024, 1024);
    }
    boolean bool1 = this.zzDh.zzDC.zzhC().zzcb();
    this.zzDp = false;
    boolean bool3;
    if (bool1)
    {
      if (this.zzDh.orientation != zzp.zzbz().zzhd()) {
        break label526;
      }
      if (this.mActivity.getResources().getConfiguration().orientation == 1)
      {
        bool3 = true;
        this.zzDp = bool3;
      }
    }
    else
    {
      label146:
      zzb.zzaF("Delay onShow to next orientation change: " + this.zzDp);
      setRequestedOrientation(this.zzDh.orientation);
      if (zzp.zzbz().zza(localWindow)) {
        zzb.zzaF("Hardware acceleration on the AdActivity window enabled.");
      }
      if (this.zzDo) {
        break label577;
      }
      this.zzCm.setBackgroundColor(-16777216);
      label216:
      this.mActivity.setContentView(this.zzCm);
      zzaF();
      if (!paramBoolean) {
        break label644;
      }
      this.zzps = zzp.zzby().zza(this.mActivity, this.zzDh.zzDC.zzaP(), true, bool1, null, this.zzDh.zzqR);
      this.zzps.zzhC().zzb(null, null, this.zzDh.zzDD, this.zzDh.zzDH, true, this.zzDh.zzDJ, null, this.zzDh.zzDC.zzhC().zzhO(), null);
      this.zzps.zzhC().zza(new zzjo.zza()
      {
        public void zza(zzjn paramAnonymouszzjn, boolean paramAnonymousBoolean)
        {
          paramAnonymouszzjn.zzfg();
        }
      });
      if (this.zzDh.url == null) {
        break label590;
      }
      this.zzps.loadUrl(this.zzDh.url);
      label370:
      if (this.zzDh.zzDC != null) {
        this.zzDh.zzDC.zzc(this);
      }
    }
    for (;;)
    {
      this.zzps.zzb(this);
      ViewParent localViewParent = this.zzps.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(this.zzps.getView());
      }
      if (this.zzDo) {
        this.zzps.setBackgroundColor(zzDg);
      }
      this.zzCm.addView(this.zzps.getView(), -1, -1);
      if ((!paramBoolean) && (!this.zzDp)) {
        zzfg();
      }
      zzw(bool1);
      if (this.zzps.zzhD()) {
        zza(bool1, true);
      }
      return;
      bool3 = false;
      break;
      label526:
      if (this.zzDh.orientation != zzp.zzbz().zzhe()) {
        break label146;
      }
      if (this.mActivity.getResources().getConfiguration().orientation == 2) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        this.zzDp = bool2;
        break;
      }
      label577:
      this.zzCm.setBackgroundColor(zzDg);
      break label216;
      label590:
      if (this.zzDh.zzDG != null)
      {
        this.zzps.loadDataWithBaseURL(this.zzDh.zzDE, this.zzDh.zzDG, "text/html", "UTF-8", null);
        break label370;
      }
      throw new zza("No URL or HTML to display in ad overlay.");
      label644:
      this.zzps = this.zzDh.zzDC;
      this.zzps.setContext(this.mActivity);
    }
  }
  
  protected void zzy(int paramInt)
  {
    this.zzps.zzy(paramInt);
  }
  
  @zzha
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzha
  static final class zzb
    extends RelativeLayout
  {
    zzis zzry;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
      this.zzry = new zzis(paramContext, paramString);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.zzry.zze(paramMotionEvent);
      return false;
    }
  }
  
  @zzha
  public static class zzc
  {
    public final Context context;
    public final int index;
    public final ViewGroup.LayoutParams zzDv;
    public final ViewGroup zzDw;
    
    public zzc(zzjn paramzzjn)
      throws zzd.zza
    {
      this.zzDv = paramzzjn.getLayoutParams();
      ViewParent localViewParent = paramzzjn.getParent();
      this.context = paramzzjn.zzhy();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        this.zzDw = ((ViewGroup)localViewParent);
        this.index = this.zzDw.indexOfChild(paramzzjn.getView());
        this.zzDw.removeView(paramzzjn.getView());
        paramzzjn.zzD(true);
        return;
      }
      throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzha
  private class zzd
    extends zzil
  {
    private zzd() {}
    
    public void onStop() {}
    
    public void zzbp()
    {
      Bitmap localBitmap = zzp.zzbx().zze(zzd.zza(zzd.this), zzd.this.zzDh.zzDL.zzqc);
      if (localBitmap != null)
      {
        final Drawable localDrawable = zzp.zzbz().zza(zzd.zza(zzd.this), localBitmap, zzd.this.zzDh.zzDL.zzqd, zzd.this.zzDh.zzDL.zzqe);
        zzip.zzKO.post(new Runnable()
        {
          public void run()
          {
            zzd.zza(zzd.this).getWindow().setBackgroundDrawable(localDrawable);
          }
        });
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */