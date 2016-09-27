package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import java.util.Set;

@zzha
public class zzfm
  extends zzfr
{
  static final Set<String> zzCa = zznm.zzc(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" });
  private AdSizeParcel zzBh;
  private String zzCb = "top-right";
  private boolean zzCc = true;
  private int zzCd = 0;
  private int zzCe = 0;
  private int zzCf = 0;
  private int zzCg = 0;
  private final Activity zzCh;
  private ImageView zzCi;
  private LinearLayout zzCj;
  private zzfs zzCk;
  private PopupWindow zzCl;
  private RelativeLayout zzCm;
  private ViewGroup zzCn;
  private int zzov = -1;
  private int zzow = -1;
  private final Object zzpK = new Object();
  private final zzjn zzps;
  
  public zzfm(zzjn paramzzjn, zzfs paramzzfs)
  {
    super(paramzzjn, "resize");
    this.zzps = paramzzjn;
    this.zzCh = paramzzjn.zzhx();
    this.zzCk = paramzzfs;
  }
  
  private int[] zzeB()
  {
    if (!zzeD()) {
      return null;
    }
    if (this.zzCc)
    {
      int[] arrayOfInt3 = new int[2];
      arrayOfInt3[0] = (this.zzCd + this.zzCf);
      arrayOfInt3[1] = (this.zzCe + this.zzCg);
      return arrayOfInt3;
    }
    int[] arrayOfInt1 = zzp.zzbx().zzh(this.zzCh);
    int[] arrayOfInt2 = zzp.zzbx().zzj(this.zzCh);
    int i = arrayOfInt1[0];
    int j = this.zzCd + this.zzCf;
    int k = this.zzCe + this.zzCg;
    if (j < 0)
    {
      j = 0;
      if (k >= arrayOfInt2[0]) {
        break label155;
      }
      k = arrayOfInt2[0];
    }
    for (;;)
    {
      return new int[] { j, k };
      if (j + this.zzov <= i) {
        break;
      }
      j = i - this.zzov;
      break;
      label155:
      if (k + this.zzow > arrayOfInt2[1]) {
        k = arrayOfInt2[1] - this.zzow;
      }
    }
  }
  
  private void zzf(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width"))) {
      this.zzov = zzp.zzbx().zzaA((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height"))) {
      this.zzow = zzp.zzbx().zzaA((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX"))) {
      this.zzCf = zzp.zzbx().zzaA((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY"))) {
      this.zzCg = zzp.zzbx().zzaA((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen"))) {
      this.zzCc = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    }
    String str = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(str)) {
      this.zzCb = str;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      this.zzCd = paramInt1;
      this.zzCe = paramInt2;
      if ((this.zzCl != null) && (paramBoolean))
      {
        int[] arrayOfInt = zzeB();
        if (arrayOfInt != null)
        {
          this.zzCl.update(zzl.zzcN().zzb(this.zzCh, arrayOfInt[0]), zzl.zzcN().zzb(this.zzCh, arrayOfInt[1]), this.zzCl.getWidth(), this.zzCl.getHeight());
          zzd(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      zzp(true);
    }
  }
  
  void zzc(int paramInt1, int paramInt2)
  {
    if (this.zzCk != null) {
      this.zzCk.zza(paramInt1, paramInt2, this.zzov, this.zzow);
    }
  }
  
  void zzd(int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt2 - zzp.zzbx().zzj(this.zzCh)[0], this.zzov, this.zzow);
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    this.zzCd = paramInt1;
    this.zzCe = paramInt2;
  }
  
  boolean zzeA()
  {
    return (this.zzov > -1) && (this.zzow > -1);
  }
  
  public boolean zzeC()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzCl != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean zzeD()
  {
    int[] arrayOfInt1 = zzp.zzbx().zzh(this.zzCh);
    int[] arrayOfInt2 = zzp.zzbx().zzj(this.zzCh);
    int i = arrayOfInt1[0];
    int j = arrayOfInt1[1];
    if ((this.zzov < 50) || (this.zzov > i))
    {
      zzb.zzaH("Width is too small or too large.");
      return false;
    }
    if ((this.zzow < 50) || (this.zzow > j))
    {
      zzb.zzaH("Height is too small or too large.");
      return false;
    }
    if ((this.zzow == j) && (this.zzov == i))
    {
      zzb.zzaH("Cannot resize to a full-screen ad.");
      return false;
    }
    String str;
    int k;
    label184:
    int m;
    int n;
    if (this.zzCc)
    {
      str = this.zzCb;
      k = -1;
      switch (str.hashCode())
      {
      default: 
        switch (k)
        {
        default: 
          m = -50 + (this.zzCd + this.zzCf + this.zzov);
          n = this.zzCe + this.zzCg;
        }
        break;
      }
    }
    while ((m >= 0) && (m + 50 <= i) && (n >= arrayOfInt2[0]) && (n + 50 <= arrayOfInt2[1]))
    {
      return true;
      if (!str.equals("top-left")) {
        break label184;
      }
      k = 0;
      break label184;
      if (!str.equals("top-center")) {
        break label184;
      }
      k = 1;
      break label184;
      if (!str.equals("center")) {
        break label184;
      }
      k = 2;
      break label184;
      if (!str.equals("bottom-left")) {
        break label184;
      }
      k = 3;
      break label184;
      if (!str.equals("bottom-center")) {
        break label184;
      }
      k = 4;
      break label184;
      if (!str.equals("bottom-right")) {
        break label184;
      }
      k = 5;
      break label184;
      m = this.zzCd + this.zzCf;
      n = this.zzCe + this.zzCg;
      continue;
      m = -25 + (this.zzCd + this.zzCf + this.zzov / 2);
      n = this.zzCe + this.zzCg;
      continue;
      m = -25 + (this.zzCd + this.zzCf + this.zzov / 2);
      n = -25 + (this.zzCe + this.zzCg + this.zzow / 2);
      continue;
      m = this.zzCd + this.zzCf;
      n = -50 + (this.zzCe + this.zzCg + this.zzow);
      continue;
      m = -25 + (this.zzCd + this.zzCf + this.zzov / 2);
      n = -50 + (this.zzCe + this.zzCg + this.zzow);
      continue;
      m = -50 + (this.zzCd + this.zzCf + this.zzov);
      n = -50 + (this.zzCe + this.zzCg + this.zzow);
    }
  }
  
  public void zzg(Map<String, String> paramMap)
  {
    synchronized (this.zzpK)
    {
      if (this.zzCh == null)
      {
        zzal("Not an activity context. Cannot resize.");
        return;
      }
      if (this.zzps.zzaP() == null)
      {
        zzal("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (this.zzps.zzaP().zztW)
    {
      zzal("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (this.zzps.zzhG())
    {
      zzal("Cannot resize an expanded banner.");
      return;
    }
    zzf(paramMap);
    if (!zzeA())
    {
      zzal("Invalid width and height options. Cannot resize.");
      return;
    }
    Window localWindow = this.zzCh.getWindow();
    if ((localWindow == null) || (localWindow.getDecorView() == null))
    {
      zzal("Activity context is not ready, cannot get window or decor view.");
      return;
    }
    int[] arrayOfInt = zzeB();
    if (arrayOfInt == null)
    {
      zzal("Resize location out of screen or close button is not visible.");
      return;
    }
    int i = zzl.zzcN().zzb(this.zzCh, this.zzov);
    int j = zzl.zzcN().zzb(this.zzCh, this.zzow);
    ViewParent localViewParent = this.zzps.getView().getParent();
    PopupWindow localPopupWindow;
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      ((ViewGroup)localViewParent).removeView(this.zzps.getView());
      if (this.zzCl == null)
      {
        this.zzCn = ((ViewGroup)localViewParent);
        Bitmap localBitmap = zzp.zzbx().zzl(this.zzps.getView());
        this.zzCi = new ImageView(this.zzCh);
        this.zzCi.setImageBitmap(localBitmap);
        this.zzBh = this.zzps.zzaP();
        this.zzCn.addView(this.zzCi);
        this.zzCm = new RelativeLayout(this.zzCh);
        this.zzCm.setBackgroundColor(0);
        this.zzCm.setLayoutParams(new ViewGroup.LayoutParams(i, j));
        this.zzCl = zzp.zzbx().zza(this.zzCm, i, j, false);
        this.zzCl.setOutsideTouchable(true);
        this.zzCl.setTouchable(true);
        localPopupWindow = this.zzCl;
        if (this.zzCc) {
          break label1072;
        }
      }
    }
    label1026:
    label1029:
    label1032:
    label1072:
    for (boolean bool = true;; bool = false)
    {
      localPopupWindow.setClippingEnabled(bool);
      this.zzCm.addView(this.zzps.getView(), -1, -1);
      this.zzCj = new LinearLayout(this.zzCh);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(zzl.zzcN().zzb(this.zzCh, 50), zzl.zzcN().zzb(this.zzCh, 50));
      String str = this.zzCb;
      switch (str.hashCode())
      {
      case -1012429441: 
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(11);
      case 1755462605: 
      case -1364013995: 
      case -655373719: 
      case 1288627767: 
      case 1163912186: 
        for (;;)
        {
          this.zzCj.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              zzfm.this.zzp(true);
            }
          });
          this.zzCj.setContentDescription("Close button");
          this.zzCm.addView(this.zzCj, localLayoutParams);
          try
          {
            this.zzCl.showAtLocation(localWindow.getDecorView(), 0, zzl.zzcN().zzb(this.zzCh, arrayOfInt[0]), zzl.zzcN().zzb(this.zzCh, arrayOfInt[1]));
            zzc(arrayOfInt[0], arrayOfInt[1]);
            this.zzps.zza(new AdSizeParcel(this.zzCh, new AdSize(this.zzov, this.zzow)));
            zzd(arrayOfInt[0], arrayOfInt[1]);
            zzan("resized");
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            zzal("Cannot show popup window: " + localRuntimeException.getMessage());
            this.zzCm.removeView(this.zzps.getView());
            if (this.zzCn == null) {
              break label1026;
            }
            this.zzCn.removeView(this.zzCi);
            this.zzCn.addView(this.zzps.getView());
            this.zzps.zza(this.zzBh);
            return;
          }
          this.zzCl.dismiss();
          break;
          zzal("Webview is detached, probably in the middle of a resize or expand.");
          return;
          if (!str.equals("top-left")) {
            break label1029;
          }
          k = 0;
          break label1032;
          if (!str.equals("top-center")) {
            break label1029;
          }
          k = 1;
          break label1032;
          if (!str.equals("center")) {
            break label1029;
          }
          k = 2;
          break label1032;
          if (!str.equals("bottom-left")) {
            break label1029;
          }
          k = 3;
          break label1032;
          if (!str.equals("bottom-center")) {
            break label1029;
          }
          k = 4;
          break label1032;
          if (!str.equals("bottom-right")) {
            break label1029;
          }
          k = 5;
          break label1032;
          localLayoutParams.addRule(10);
          localLayoutParams.addRule(9);
          continue;
          localLayoutParams.addRule(10);
          localLayoutParams.addRule(14);
          continue;
          localLayoutParams.addRule(13);
          continue;
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(9);
          continue;
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(14);
          continue;
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(11);
        }
      }
      int k = -1;
      switch (k)
      {
      }
    }
  }
  
  public void zzp(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (this.zzCl != null)
      {
        this.zzCl.dismiss();
        this.zzCm.removeView(this.zzps.getView());
        if (this.zzCn != null)
        {
          this.zzCn.removeView(this.zzCi);
          this.zzCn.addView(this.zzps.getView());
          this.zzps.zza(this.zzBh);
        }
        if (paramBoolean)
        {
          zzan("default");
          if (this.zzCk != null) {
            this.zzCk.zzbe();
          }
        }
        this.zzCl = null;
        this.zzCm = null;
        this.zzCn = null;
        this.zzCj = null;
      }
      return;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */