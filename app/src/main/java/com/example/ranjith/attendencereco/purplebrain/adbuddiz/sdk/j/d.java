package com.purplebrain.adbuddiz.sdk.j;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.j.b.b.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class d
  extends CountDownTimer
{
  public long a;
  public long b;
  private com.purplebrain.adbuddiz.sdk.f.a.a.c c;
  private MediaPlayer d;
  private com.purplebrain.adbuddiz.sdk.i.c.c e;
  private List f = new ArrayList();
  
  public d(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc, MediaPlayer paramMediaPlayer, Integer paramInteger, com.purplebrain.adbuddiz.sdk.i.c.c paramc1)
  {
    super(2147483647L, 1000L);
    this.c = paramc;
    this.d = paramMediaPlayer;
    this.e = paramc1;
    this.a = 0L;
    this.b = com.purplebrain.adbuddiz.sdk.i.c.d.b(paramc);
    a(com.purplebrain.adbuddiz.sdk.j.b.b.d.c, 0.25D);
    a(com.purplebrain.adbuddiz.sdk.j.b.b.d.d, 0.5D);
    a(com.purplebrain.adbuddiz.sdk.j.b.b.d.e, 0.75D);
    Iterator localIterator1 = com.purplebrain.adbuddiz.sdk.j.d.a.b(paramc, com.purplebrain.adbuddiz.sdk.j.b.b.d.u).iterator();
    while (localIterator1.hasNext())
    {
      i locali = (i)localIterator1.next();
      String str = (String)locali.c.get("offset");
      a locala = new a((byte)0);
      locala.a = ((int)com.purplebrain.adbuddiz.sdk.i.c.a.a(str, this.b).a);
      locala.b = com.purplebrain.adbuddiz.sdk.j.b.b.d.u;
      locala.c = Collections.singletonList(locali.b);
      this.f.add(locala);
    }
    Collections.sort(this.f, new Comparator() {});
    if (paramInteger != null)
    {
      this.a = paramInteger.intValue();
      Iterator localIterator2 = this.f.iterator();
      while (localIterator2.hasNext()) {
        if (((a)localIterator2.next()).a <= paramInteger.intValue()) {
          localIterator2.remove();
        }
      }
    }
  }
  
  private void a(com.purplebrain.adbuddiz.sdk.j.b.b.d paramd, double paramDouble)
  {
    long l = com.purplebrain.adbuddiz.sdk.i.c.d.b(this.c);
    List localList = com.purplebrain.adbuddiz.sdk.j.d.a.a(this.c, paramd);
    if (!localList.isEmpty())
    {
      a locala = new a((byte)0);
      locala.a = ((int)(paramDouble * l));
      locala.b = paramd;
      locala.c = localList;
      this.f.add(locala);
    }
  }
  
  public final void onFinish() {}
  
  public final void onTick(long paramLong)
  {
    try
    {
      this.a = this.d.getCurrentPosition();
      ListIterator localListIterator = this.f.listIterator();
      while (localListIterator.hasNext())
      {
        a locala = (a)localListIterator.next();
        if (locala.a > this.d.getCurrentPosition()) {
          break;
        }
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = locala.b.w;
        arrayOfObject[1] = Integer.valueOf(this.d.getCurrentPosition());
        arrayOfObject[2] = Long.valueOf(this.b);
        e.a("TimeEvent", locala.c, this.c, Integer.valueOf(this.d.getCurrentPosition()));
        this.e.a(locala.b);
        localListIterator.remove();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("ABVASTTimeBasedTrackingEventHelper.onTick()", localThrowable);
    }
  }
  
  private final class a
  {
    public int a;
    public com.purplebrain.adbuddiz.sdk.j.b.b.d b;
    public List c;
    
    private a() {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */