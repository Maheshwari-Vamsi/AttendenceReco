package com.purplebrain.adbuddiz.sdk.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.purplebrain.adbuddiz.sdk.i.c.c.a;
import com.purplebrain.adbuddiz.sdk.i.c.d;
import com.purplebrain.adbuddiz.sdk.i.c.e;
import com.purplebrain.adbuddiz.sdk.i.o;
import java.util.Locale;

@SuppressLint({"NewApi"})
public abstract class f
  extends c
{
  e A = null;
  protected com.purplebrain.adbuddiz.sdk.i.c.c B = null;
  protected com.purplebrain.adbuddiz.sdk.i.c.b C = null;
  private WifiManager.WifiLock D = null;
  private SurfaceHolder.Callback E = new SurfaceHolder.Callback()
  {
    public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      try
      {
        if (f.this.u != null) {
          f.this.u.setSurface(paramAnonymousSurfaceHolder.getSurface());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVASTAdDisplayer#Callback.surfaceCreated()", localThrowable);
      }
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      try
      {
        if (f.this.u != null) {
          f.this.u.setSurface(null);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVASTAdDisplayer#Callback.surfaceDestroyed()", localThrowable);
      }
    }
  };
  private MediaPlayer.OnPreparedListener F = new MediaPlayer.OnPreparedListener()
  {
    public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      try
      {
        f.this.b_();
        f.this.b(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVASTAdDisplayer#OnPreparedListener.onPrepared()", localThrowable);
      }
    }
  };
  private View.OnClickListener G = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      try
      {
        f.this.a(paramAnonymousView);
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVASTAdDisplayer#OnClickListener.onClick", localThrowable);
      }
    }
  };
  private View.OnClickListener H = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      try
      {
        f localf = f.this;
        boolean bool1 = f.this.z;
        boolean bool2 = false;
        if (!bool1) {
          bool2 = true;
        }
        localf.a(bool2, false);
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVASTAdDisplayer#onToggleMuteButtonClicked.onClick()", localThrowable);
      }
    }
  };
  private MediaPlayer.OnInfoListener I = new MediaPlayer.OnInfoListener()
  {
    public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      boolean bool = false;
      if (paramAnonymousInt1 == 3)
      {
        f.this.s.setBackgroundColor(0);
        bool = true;
      }
      return bool;
    }
  };
  private MediaPlayer.OnCompletionListener J = new MediaPlayer.OnCompletionListener()
  {
    public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      try
      {
        f.this.j();
        if (f.this.C != null) {
          f.this.C.cancel();
        }
        if ((!f.this.x) && (!f.this.y))
        {
          f.this.x = true;
          if (f.this.A != null)
          {
            e locale = f.this.A;
            locale.cancel();
            locale.a();
          }
          f.this.a_();
        }
        f.this.z();
        f.this.t.setKeepScreenOn(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVideoAdDisplayer#OnCompletionListener.onCompletion()", localThrowable);
      }
    }
  };
  private MediaPlayer.OnErrorListener K = new MediaPlayer.OnErrorListener()
  {
    public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      try
      {
        f.this.y = true;
        Locale localLocale = Locale.US;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Integer.valueOf(paramAnonymousInt1);
        arrayOfObject1[1] = Integer.valueOf(paramAnonymousInt2);
        String str1 = String.format(localLocale, "Error while playing the media. What: %d. Extra: %d.", arrayOfObject1);
        o.b(str1);
        if (f.a(f.this))
        {
          int i = -1;
          if ((f.this.C != null) && (f.this.C.a != null)) {
            i = f.this.C.a.intValue();
          }
          long l = d.b(f.this.c());
          StringBuilder localStringBuilder = new StringBuilder().append(str1);
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Integer.valueOf(i);
          arrayOfObject2[1] = Long.valueOf(l);
          String str2 = String.format(" Position: %d / %d", arrayOfObject2);
          f.this.n.a(new Exception(str2));
        }
        f.this.a(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
        return false;
      }
      catch (Throwable localThrowable)
      {
        o.a("ABVASTAdDisplayer#OnErrorListener.onError()", localThrowable);
      }
      return false;
    }
  };
  private ImageButton a = null;
  private Drawable b = null;
  private Drawable c = null;
  protected RelativeLayout r = null;
  protected SurfaceView s = null;
  protected SurfaceHolder t = null;
  protected MediaPlayer u = null;
  protected Integer v = null;
  protected int w = 0;
  protected boolean x = false;
  protected boolean y = false;
  boolean z;
  
  private MediaPlayer A()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(this.d, d());
      localMediaPlayer.setOnPreparedListener(this.F);
      localMediaPlayer.setOnInfoListener(this.I);
      localMediaPlayer.setOnCompletionListener(this.J);
      localMediaPlayer.setOnErrorListener(this.K);
      return localMediaPlayer;
    }
    catch (Exception localException)
    {
      a(localMediaPlayer);
      this.n.a(new Exception("MediaPlayer.create() returned null.", localException));
    }
    return null;
  }
  
  public final View a(Activity paramActivity, Bundle paramBundle, com.purplebrain.adbuddiz.sdk.f.a.a parama, String paramString)
  {
    View localView = super.a(paramActivity, paramBundle, parama, paramString);
    com.purplebrain.adbuddiz.sdk.d.a locala = this.j;
    this.r = new RelativeLayout(this.d);
    ImageButton localImageButton = h();
    if (localImageButton != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      this.r.addView(localImageButton, localLayoutParams);
    }
    locala.addView(this.r, 1);
    if (paramBundle == null)
    {
      boolean bool1 = parama.b;
      boolean bool2 = false;
      if (!bool1) {
        bool2 = com.purplebrain.adbuddiz.sdk.e.b.a().b().D;
      }
      a(bool2, true);
    }
    return localView;
  }
  
  protected void a(MediaPlayer paramMediaPlayer) {}
  
  protected void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {}
  
  public final void a(Bundle paramBundle)
  {
    paramBundle.putBoolean("complete", this.x);
    paramBundle.putBoolean("muted", this.z);
    if (this.u != null) {
      if ((!this.x) || (this.u.getDuration() == -1)) {
        break label116;
      }
    }
    label116:
    for (this.v = Integer.valueOf(this.u.getDuration());; this.v = Integer.valueOf(this.u.getCurrentPosition()))
    {
      paramBundle.putInt("pos", this.v.intValue());
      if ((this.v != null) && (this.v.intValue() > this.w)) {
        this.w = this.v.intValue();
      }
      paramBundle.putInt("max", this.w);
      return;
    }
  }
  
  protected void a(View paramView) {}
  
  public final void a(boolean paramBoolean)
  {
    this.g = false;
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.z == paramBoolean1) && (!paramBoolean2)) {}
    float f;
    do
    {
      return;
      Drawable localDrawable = this.c;
      f = 1.0F;
      if (paramBoolean1)
      {
        localDrawable = this.b;
        f = 0.0F;
      }
      this.z = paramBoolean1;
      if (this.a != null) {
        this.a.setImageDrawable(localDrawable);
      }
    } while (this.u == null);
    this.u.setVolume(f, f);
  }
  
  protected void a_() {}
  
  protected View b()
  {
    this.s = new SurfaceView(this.d);
    this.s.setZOrderMediaOverlay(true);
    this.s.setSoundEffectsEnabled(true);
    this.s.setOnClickListener(this.G);
    if (Build.VERSION.SDK_INT >= 17) {
      this.s.setBackgroundColor(-16777216);
    }
    this.t = this.s.getHolder();
    this.t.setKeepScreenOn(true);
    this.t.addCallback(this.E);
    this.t.setSizeFromLayout();
    this.u = A();
    try
    {
      if (this.u != null) {
        this.u.prepareAsync();
      }
      return this.s;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(this.u);
        this.n.a(localThrowable);
      }
    }
  }
  
  protected final ViewGroup.LayoutParams b(View paramView)
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  protected final void b(Bundle paramBundle)
  {
    this.x = paramBundle.getBoolean("complete");
    a(paramBundle.getBoolean("muted"), true);
    if (paramBundle.containsKey("pos")) {
      this.v = Integer.valueOf(paramBundle.getInt("pos"));
    }
    this.w = paramBundle.getInt("max");
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((this.v != null) && (!paramBoolean)) {
      this.u.seekTo(this.v.intValue());
    }
    this.u.start();
    for (;;)
    {
      try
      {
        boolean bool = "file".equalsIgnoreCase(d().getScheme());
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        com.purplebrain.adbuddiz.sdk.i.c.c localc;
        Long localLong;
        continue;
        if (!localc.c()) {
          continue;
        }
        new StringBuilder("Impression will be send on event '").append(localc.a).append("'.");
        if (!"skipoffset".equals(localc.a)) {
          continue;
        }
        if (localc.d == null) {
          continue;
        }
        localc.d.a = localc.f;
        continue;
        localc.d();
        continue;
      }
      if (!this.x)
      {
        localc = this.B;
        if (localc.a()) {
          continue;
        }
        if (!localc.b()) {
          continue;
        }
        localLong = Long.valueOf(com.purplebrain.adbuddiz.sdk.i.c.a.a(localc.a, localc.b).a - localc.c);
        if (localLong != null)
        {
          new StringBuilder("Impression will be send in ").append(localLong).append("ms");
          localc.e = new c.a(localc, localLong.longValue());
          localc.e.start();
        }
        if (this.A != null) {
          this.A.start();
        }
        this.C.start();
      }
      return;
      if (com.purplebrain.adbuddiz.sdk.i.a.h.a(this.d, "android.permission.WAKE_LOCK"))
      {
        this.D = ((WifiManager)this.d.getSystemService("wifi")).createWifiLock(1, "mediaPlayerLock");
        this.D.acquire();
      }
    }
  }
  
  protected void b_()
  {
    if (this.u != null) {
      this.C = new com.purplebrain.adbuddiz.sdk.i.c.b(this.j, this.u);
    }
    this.A = null;
    com.purplebrain.adbuddiz.sdk.f.a.a.c localc1 = c();
    if ((this.u != null) && (localc1 != null) && (!this.x))
    {
      long l2 = d.b(localc1);
      this.A = e.a(this.e, this.j, this.u, l2, this.w, f());
    }
    com.purplebrain.adbuddiz.sdk.d.a locala = this.j;
    if (this.A == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.a(bool);
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc2 = c();
      if ((this.u != null) && (localc2 != null))
      {
        long l1 = d.b(localc2);
        this.B = new com.purplebrain.adbuddiz.sdk.i.c.c(this.e, this.f, e(), l1, this.w, this.A, this.k);
      }
      return;
    }
  }
  
  protected abstract com.purplebrain.adbuddiz.sdk.f.a.a.c c();
  
  protected abstract Uri d();
  
  protected abstract String e();
  
  protected abstract String[] f();
  
  protected Double g()
  {
    com.purplebrain.adbuddiz.sdk.f.a.a.c localc = c();
    if (localc != null)
    {
      int i = d.c(localc);
      int j = d.d(localc);
      return Double.valueOf(i / j);
    }
    return null;
  }
  
  protected ImageButton h()
  {
    if (this.e.b) {
      return null;
    }
    this.a = new ImageButton(this.d);
    this.a.setBackgroundDrawable(null);
    this.a.setOnClickListener(this.H);
    try
    {
      byte[] arrayOfByte1 = com.purplebrain.adbuddiz.sdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAYAAABV7bNHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAONJREFUeNrs3EEOgkAMQFEx3Ft68jEeQKImzLT1/YQdC/ICm2nDNsa46X13BIAAAQIECBAgQAIEqD/QAegc5wGoEE4WoLQ4GYBS46wGSo+zEqgEziqgMjgrgErhzAYqhzMTqCTOLKCyODOASuNcDVQe50qgFjiv9g/v+9v5tAMzQIAAAQIECBAgAQIECBAgQIAA6Qeg7csrvEHnHV2Qrp5qBKDmSLMmqwGoKdLs7Y4A1Axp1YZZAGqCtHrLNQAVR8qyaR+AiiLtiZ7lyAi0+XdHjU8MECBAgAQIECBAgAC16inAAAx7JBiffjKJAAAAAElFTkSuQmCC".toCharArray());
      Bitmap localBitmap1 = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length);
      localBitmap1.setDensity(480);
      this.b = a(localBitmap1);
      byte[] arrayOfByte2 = com.purplebrain.adbuddiz.sdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAYAAABV7bNHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA5VJREFUeNrsmz1oFEEUx3cvJwomnBi0ESSIRgSjiZLCQhCChagg2iSFICJRG7EJiincFCqihXZGxSKKdoIflRYpoogmpyQGMVFO8QMFFT9AxTNk/S/uwRU3M29u9zYzO/Pgx8G8vTdz/9uZnY+3ru/7jjW2ZawEViArkBXICmQFsgJZgQy1LOUi13VnvKGY0Lbg42nS9boazaSDhn4At8EVMBSWWYHKBCq3SXAaDIA/poxBnsS1zeA8eAG6atm3VcHz/xvLL7JB0BR3uzIK3TlHI8bYAMZAZ9q6GFUcyjjTAK6BE8H4moYu5lXoKqxrc2AXGPFpdglkorZRNXF84nc3gjxBpAHg6iiQx/lR1BjB3XEQ/BKIdFw3gTzBD5KN1wImBTE7dRHII3SLauI2ggecmD/AUtUF8oiDa7XxGwQiDaosEFUcP2I988FLTuydsjGTWIvJTgJdzpxtmvD9lWAYzKngewOWgaIqE8U4Zsgly4N1hOvGwRGGbzHYo8pEUaZbUbpYYFPgMKHuOjDKiD8hMzdSTRzqYvUsoQ2bOHV0xC1QkkZtwyFCux8z6rio22q+GjtGGJP6GeVbqeMv9SmW5LajK9GGUdDGaV8OfGbsva8BT9J+qrEabOP4v4N7DB/liZiKY59ugX+IUb7WFIE6QD3HP8IoX2KKQLNAO8dfYJQ3mXSy2szxvecM4MYI1Mjx/WSU15skUBwHkakW6AvHN1fyzkqlQBMc3yJG+TdTBPob7v84ko/z16YIdFfQXdolH/+pE6hf4F8vOYFM1WI1H94hrPbNA58Yi9XWcLGb2jtoCuwX/HldDHE+OsRsNZ0F6hEMzoHtY5TfcmgHAGSBXEn6aizOSXBGcM0WsIrhu0qfTuq1aV8EBwh1Z8E4I/4zlQ4OvRgFug9aifX2cOJ3p/XgkGpBt3oEZlfwvQLLw8mlo8og7SUwJpVsAbjBECewXhlxaj0GJZ28kBNkn90xOf1lIRjmxPxabQZsGhKo2kBBEHOHiSl4deHT6rdAnD4Tkzg3gzFCd72gc5arbBpwkBy1lyhMYOeiZriqIFAlkVjXFYnCTIcxY2mfau9pRHlXo/S02h5n27KKrMy98DNKNlqws7gbvIuzYaoIVC6SrBXCrY/rNdm90/iFuiAX8VS4dTFVq0qzjl72FtwEl8HDJCrUSaAV4HnSlerUxWbE7HvzViArkBXICmQFsgJZgUy1fwIMAL0jl379L/YCAAAAAElFTkSuQmCC".toCharArray());
      Bitmap localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte2, 0, arrayOfByte2.length);
      localBitmap2.setDensity(480);
      this.c = a(localBitmap2);
      a(this.z, true);
      return this.a;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.h localh)
    {
      for (;;) {}
    }
  }
  
  protected void j() {}
  
  public final void o()
  {
    if (this.u != null)
    {
      b_();
      b(true);
    }
  }
  
  public void w()
  {
    if (this.u != null) {}
    try
    {
      if (this.u.isPlaying()) {
        this.u.pause();
      }
      if (this.A != null) {
        this.A.cancel();
      }
      if (this.B != null)
      {
        com.purplebrain.adbuddiz.sdk.i.c.c localc = this.B;
        if ((localc.b()) && (localc.e != null)) {
          localc.e.cancel();
        }
      }
      if (this.C != null) {
        this.C.cancel();
      }
      z();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public void x()
  {
    if (this.u != null) {}
    try
    {
      this.u.reset();
      this.u.release();
      this.u = null;
      if ((this.t != null) && (this.t.getSurface() != null)) {
        this.t.getSurface().release();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  protected final com.purplebrain.adbuddiz.sdk.d.a y()
  {
    com.purplebrain.adbuddiz.sdk.d.a locala = super.y();
    locala.a(g());
    return locala;
  }
  
  final void z()
  {
    if (this.D != null)
    {
      this.D.release();
      this.D = null;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */