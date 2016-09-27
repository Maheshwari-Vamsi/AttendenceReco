package com.purplebrain.adbuddiz.sdk.j.b.b;

import android.annotation.SuppressLint;
import com.purplebrain.adbuddiz.sdk.i.y;
import org.w3c.dom.Node;

@SuppressLint({"NewApi"})
public final class f
{
  public b a;
  private Node b;
  
  public f(b paramb, Node paramNode)
  {
    this.a = paramb;
    this.b = paramNode;
  }
  
  public final g a()
  {
    try
    {
      g localg = g.a(y.e(this.b, "delivery"));
      return localg;
    }
    catch (Throwable localThrowable) {}
    return g.c;
  }
  
  public final String b()
  {
    return y.e(this.b, "type");
  }
  
  public final Integer c()
  {
    return y.f(this.b, "width");
  }
  
  public final Integer d()
  {
    return y.f(this.b, "height");
  }
  
  public final Integer e()
  {
    return y.f(this.b, "bitrate");
  }
  
  public final String f()
  {
    return y.a(this.b.getTextContent());
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */