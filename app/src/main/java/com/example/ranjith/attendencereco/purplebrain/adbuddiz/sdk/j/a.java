package com.purplebrain.adbuddiz.sdk.j;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public com.purplebrain.adbuddiz.sdk.f.f a;
  private double b;
  
  public a(com.purplebrain.adbuddiz.sdk.f.f paramf, int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramf;
    this.b = ((paramInt1 + paramInt2) / paramFloat);
  }
  
  private static int a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (int)Math.floor((paramDouble2 / paramDouble1 - 1.0D) / paramDouble3);
  }
  
  public final void a(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      double d = locala.a.c().intValue() + locala.a.d().intValue();
      int i = a(this.b, d, this.a.b);
      if (i >= 0) {
        locala.b += i * this.a.c;
      } else {
        locala.b += -i * this.a.d;
      }
    }
  }
  
  public final void b(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      Double localDouble = (Double)this.a.e.get(locala.a.b());
      if (localDouble != null) {
        locala.b += localDouble.doubleValue();
      }
    }
  }
  
  public final void c(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a.e() != null)
      {
        int i = a(this.a.f, locala.a.e().intValue(), this.a.g);
        locala.b += Math.abs(i) * this.a.h;
      }
    }
  }
  
  private static final class a
  {
    public com.purplebrain.adbuddiz.sdk.j.b.b.f a;
    public double b;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */