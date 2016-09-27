package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzgn
  implements Runnable
{
  private final Handler zzFi;
  private final long zzFj;
  private long zzFk;
  private zzjo.zza zzFl;
  protected boolean zzFm;
  protected boolean zzFn;
  private final int zzov;
  private final int zzow;
  protected final zzjn zzps;
  
  public zzgn(zzjo.zza paramzza, zzjn paramzzjn, int paramInt1, int paramInt2)
  {
    this(paramzza, paramzzjn, paramInt1, paramInt2, 200L, 50L);
  }
  
  public zzgn(zzjo.zza paramzza, zzjn paramzzjn, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.zzFj = paramLong1;
    this.zzFk = paramLong2;
    this.zzFi = new Handler(Looper.getMainLooper());
    this.zzps = paramzzjn;
    this.zzFl = paramzza;
    this.zzFm = false;
    this.zzFn = false;
    this.zzow = paramInt2;
    this.zzov = paramInt1;
  }
  
  public void run()
  {
    if ((this.zzps == null) || (zzfU()))
    {
      this.zzFl.zza(this.zzps, true);
      return;
    }
    new zza(this.zzps.getWebView()).execute(new Void[0]);
  }
  
  public void zza(AdResponseParcel paramAdResponseParcel)
  {
    zza(paramAdResponseParcel, new zzjw(this, this.zzps, paramAdResponseParcel.zzGU));
  }
  
  public void zza(AdResponseParcel paramAdResponseParcel, zzjw paramzzjw)
  {
    this.zzps.setWebViewClient(paramzzjw);
    zzjn localzzjn = this.zzps;
    if (TextUtils.isEmpty(paramAdResponseParcel.zzDE)) {}
    for (String str = null;; str = zzp.zzbx().zzaz(paramAdResponseParcel.zzDE))
    {
      localzzjn.loadDataWithBaseURL(str, paramAdResponseParcel.body, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void zzfS()
  {
    this.zzFi.postDelayed(this, this.zzFj);
  }
  
  public void zzfT()
  {
    try
    {
      this.zzFm = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean zzfU()
  {
    try
    {
      boolean bool = this.zzFm;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean zzfV()
  {
    return this.zzFn;
  }
  
  protected final class zza
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView zzFo;
    private Bitmap zzFp;
    
    public zza(WebView paramWebView)
    {
      this.zzFo = paramWebView;
    }
    
    protected void onPreExecute()
    {
      try
      {
        this.zzFp = Bitmap.createBitmap(zzgn.zza(zzgn.this), zzgn.zzb(zzgn.this), Bitmap.Config.ARGB_8888);
        this.zzFo.setVisibility(0);
        this.zzFo.measure(View.MeasureSpec.makeMeasureSpec(zzgn.zza(zzgn.this), 0), View.MeasureSpec.makeMeasureSpec(zzgn.zzb(zzgn.this), 0));
        this.zzFo.layout(0, 0, zzgn.zza(zzgn.this), zzgn.zzb(zzgn.this));
        Canvas localCanvas = new Canvas(this.zzFp);
        this.zzFo.draw(localCanvas);
        this.zzFo.invalidate();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    protected Boolean zza(Void... paramVarArgs)
    {
      for (;;)
      {
        int k;
        try
        {
          int i = this.zzFp.getWidth();
          int j = this.zzFp.getHeight();
          Object localObject2;
          if ((i == 0) || (j == 0))
          {
            Boolean localBoolean1 = Boolean.valueOf(false);
            localObject2 = localBoolean1;
            return (Boolean)localObject2;
          }
          k = 0;
          int m = 0;
          int n;
          if (k < i)
          {
            n = 0;
            if (n >= j) {
              break label139;
            }
            if (this.zzFp.getPixel(k, n) != 0) {
              m++;
            }
          }
          else
          {
            if (m / (i * j / 100.0D) > 0.1D)
            {
              bool = true;
              Boolean localBoolean2 = Boolean.valueOf(bool);
              localObject2 = localBoolean2;
              continue;
            }
            boolean bool = false;
            continue;
          }
          n += 10;
        }
        finally {}
        continue;
        label139:
        k += 10;
      }
    }
    
    protected void zza(Boolean paramBoolean)
    {
      zzgn.zzc(zzgn.this);
      if ((paramBoolean.booleanValue()) || (zzgn.this.zzfU()) || (zzgn.zzd(zzgn.this) <= 0L))
      {
        zzgn.this.zzFn = paramBoolean.booleanValue();
        zzgn.zze(zzgn.this).zza(zzgn.this.zzps, true);
      }
      while (zzgn.zzd(zzgn.this) <= 0L) {
        return;
      }
      if (zzb.zzQ(2)) {
        zzb.zzaF("Ad not detected, scheduling another run.");
      }
      zzgn.zzg(zzgn.this).postDelayed(zzgn.this, zzgn.zzf(zzgn.this));
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */