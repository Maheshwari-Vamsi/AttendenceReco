package com.purplebrain.adbuddiz.sdk.j.b.b;

import com.purplebrain.adbuddiz.sdk.i.y;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class e
  extends b
{
  private List c = null;
  
  public e(com.purplebrain.adbuddiz.sdk.j.b.a.a parama, Node paramNode)
  {
    super(parama, paramNode);
  }
  
  public final int a()
  {
    return c.a;
  }
  
  public final long c()
  {
    String str = y.d(this.b, "Duration");
    if (str.contains("%")) {}
    for (com.purplebrain.adbuddiz.sdk.i.c.a locala = null; locala == null; locala = com.purplebrain.adbuddiz.sdk.i.c.a.b(str, Long.MAX_VALUE)) {
      throw new com.purplebrain.adbuddiz.sdk.j.a.b(com.purplebrain.adbuddiz.sdk.j.a.a.a, "Time '" + str + "' cannot be parse into a valid duration.");
    }
    return locala.a;
  }
  
  public final String d()
  {
    Node localNode = y.b(this.b, "VideoClicks");
    if (localNode == null) {
      return null;
    }
    return y.d(localNode, "ClickThrough");
  }
  
  public final List e()
  {
    Node localNode = y.b(this.b, "VideoClicks");
    if (localNode == null) {
      return new ArrayList();
    }
    return y.c(localNode, "ClickTracking");
  }
  
  public final boolean f()
  {
    return g() != null;
  }
  
  public final String g()
  {
    String str = y.e(this.b, "skipoffset");
    if ((str != null) && (com.purplebrain.adbuddiz.sdk.i.c.a.a(str, 2147483647L) == null)) {
      throw new com.purplebrain.adbuddiz.sdk.j.a.b(com.purplebrain.adbuddiz.sdk.j.a.a.a, "Offset '" + str + "' cannot be parsed into a valid duration.");
    }
    return str;
  }
  
  public final List h()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      NodeList localNodeList = y.a(this.b, "MediaFiles/MediaFile");
      for (int i = 0; i < localNodeList.getLength(); i++) {
        this.c.add(new f(this, localNodeList.item(i)));
      }
    }
    return this.c;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */