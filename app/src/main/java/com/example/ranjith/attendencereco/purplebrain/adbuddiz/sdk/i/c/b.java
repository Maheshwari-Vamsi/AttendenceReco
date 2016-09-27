package com.purplebrain.adbuddiz.sdk.i.c;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import com.purplebrain.adbuddiz.sdk.d.a;
import com.purplebrain.adbuddiz.sdk.i.o;

public final class b
  extends CountDownTimer
{
  public Integer a;
  private a b;
  private MediaPlayer c;
  private com.purplebrain.adbuddiz.sdk.f.b d;
  private Integer e;
  
  public b(a parama, MediaPlayer paramMediaPlayer)
  {
    super(2147483647L, 1000L);
    this.b = parama;
    this.c = paramMediaPlayer;
    this.d = com.purplebrain.adbuddiz.sdk.e.b.a().b();
  }
  
  public final boolean a()
  {
    if ((this.e == null) || (this.c == null) || (!this.c.isPlaying())) {}
    while (this.e.intValue() <= this.d.z) {
      return false;
    }
    return true;
  }
  
  public final void onFinish() {}
  
  public final void onTick(long paramLong)
  {
    try
    {
      if ((this.a != null) && (this.c.isPlaying()))
      {
        this.e = Integer.valueOf(64536 + this.c.getCurrentPosition() - this.a.intValue());
        if (a())
        {
          new Object[1][0] = this.e;
          this.b.a(true);
        }
      }
      this.a = Integer.valueOf(this.c.getCurrentPosition());
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("ABVASTStuckMediaPlayerDetector.onTick()", localThrowable);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */