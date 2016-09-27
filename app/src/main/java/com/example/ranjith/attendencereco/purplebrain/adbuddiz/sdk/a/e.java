package com.purplebrain.adbuddiz.sdk.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.j.a.a;
import java.util.List;

@SuppressLint({"NewApi"})
public final class e
  extends f
{
  private com.purplebrain.adbuddiz.sdk.f.a.a.c a = null;
  private com.purplebrain.adbuddiz.sdk.j.d b = null;
  
  protected final void a(MediaPlayer paramMediaPlayer)
  {
    com.purplebrain.adbuddiz.sdk.j.e.a(this.a, paramMediaPlayer, a.h);
  }
  
  protected final void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    int i = 1;
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if (this.b == null) {}
    for (;;)
    {
      if (i != 0) {
        com.purplebrain.adbuddiz.sdk.j.e.a(this.a, paramMediaPlayer, a.h);
      }
      return;
      if (this.b.a >= localb.E * this.b.b) {
        i = 0;
      }
    }
  }
  
  protected final void a(View paramView)
  {
    paramView.playSoundEffect(0);
    if (!p()) {}
    while (!q()) {
      return;
    }
    r();
    com.purplebrain.adbuddiz.sdk.f.a.a.c localc = this.a;
    MediaPlayer localMediaPlayer = this.u;
    List localList = localc.c("ct");
    Integer localInteger;
    if (localMediaPlayer != null) {
      localInteger = Integer.valueOf(localMediaPlayer.getCurrentPosition());
    }
    for (;;)
    {
      com.purplebrain.adbuddiz.sdk.j.e.a("Click", localList, localc, localInteger);
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(c().b("c")));
        this.d.startActivity(localIntent);
        s();
        return;
        localInteger = null;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  protected final void a_()
  {
    this.b.cancel();
    this.b.onTick(0L);
    com.purplebrain.adbuddiz.sdk.j.e.a(c(), this.u, com.purplebrain.adbuddiz.sdk.j.b.b.d.f);
    this.B.a(com.purplebrain.adbuddiz.sdk.j.b.b.d.f);
    if (c().b("c") == null) {
      n();
    }
  }
  
  protected final void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (!this.x) {
      this.b.start();
    }
    if ((this.v == null) && (!this.x))
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc = this.a;
      com.purplebrain.adbuddiz.sdk.j.e.a("Impression", localc.c("i"), localc, null);
      com.purplebrain.adbuddiz.sdk.j.e.a(this.a, this.u, com.purplebrain.adbuddiz.sdk.j.b.b.d.a);
      this.B.a(com.purplebrain.adbuddiz.sdk.j.b.b.d.a);
      com.purplebrain.adbuddiz.sdk.j.e.a(this.a, this.u, com.purplebrain.adbuddiz.sdk.j.b.b.d.b);
      this.B.a(com.purplebrain.adbuddiz.sdk.j.b.b.d.b);
    }
  }
  
  protected final void b_()
  {
    super.b_();
    if ((!this.x) && (this.u != null)) {}
    try
    {
      this.b = new com.purplebrain.adbuddiz.sdk.j.d(c(), this.u, this.v, this.B);
      return;
    }
    catch (com.purplebrain.adbuddiz.sdk.j.a.b localb)
    {
      o.a("ABVASTAdDisplayer.prepareTimerForTrackingEvent()", localb);
      com.purplebrain.adbuddiz.sdk.j.e.a(this.a, this.u, localb.a);
      this.n.a(localb);
    }
  }
  
  protected final com.purplebrain.adbuddiz.sdk.f.a.a.c c()
  {
    if (this.a == null) {
      this.a = com.purplebrain.adbuddiz.sdk.i.c.a(this.e, com.purplebrain.adbuddiz.sdk.f.a.a.d.b, l());
    }
    return this.a;
  }
  
  protected final Uri d()
  {
    com.purplebrain.adbuddiz.sdk.f.a.a.c localc = c();
    if (localc.c()) {
      return Uri.parse("file://" + m.a(AdBuddiz.getContext(), localc));
    }
    return Uri.parse(localc.f());
  }
  
  protected final String e()
  {
    return ((com.purplebrain.adbuddiz.sdk.f.a.f)this.e).l;
  }
  
  protected final String[] f()
  {
    return com.purplebrain.adbuddiz.sdk.j.c.a((com.purplebrain.adbuddiz.sdk.f.a.f)this.e, this.a);
  }
  
  protected final void u()
  {
    super.u();
    int i;
    if ((this.C != null) && (!this.C.a()))
    {
      MediaPlayer localMediaPlayer = this.u;
      com.purplebrain.adbuddiz.sdk.f.a.f localf = (com.purplebrain.adbuddiz.sdk.f.a.f)this.e;
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc = this.a;
      if (localc.b("so") == null) {
        break label130;
      }
      i = 1;
      if ((i == 0) || (!localMediaPlayer.isPlaying())) {
        break label136;
      }
      long l = localMediaPlayer.getCurrentPosition();
      Integer.valueOf(0);
      if (l <= com.purplebrain.adbuddiz.sdk.i.c.e.a(com.purplebrain.adbuddiz.sdk.i.c.d.b(localc), com.purplebrain.adbuddiz.sdk.j.c.a(localf, localc)).longValue()) {
        break label136;
      }
    }
    label130:
    label136:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        break label142;
      }
      com.purplebrain.adbuddiz.sdk.j.e.a(this.a, this.u, com.purplebrain.adbuddiz.sdk.j.b.b.d.t);
      this.B.a(com.purplebrain.adbuddiz.sdk.j.b.b.d.t);
      return;
      i = 0;
      break;
    }
    label142:
    com.purplebrain.adbuddiz.sdk.j.e.a(this.a, this.u, com.purplebrain.adbuddiz.sdk.j.b.b.d.s);
    this.B.a(com.purplebrain.adbuddiz.sdk.j.b.b.d.s);
  }
  
  public final void w()
  {
    super.w();
    if (this.b != null) {
      this.b.cancel();
    }
  }
  
  public final void x() {}
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */