package com.purplebrain.adbuddiz.sdk.j.b.b;

import com.purplebrain.adbuddiz.sdk.i.y;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class b
{
  public com.purplebrain.adbuddiz.sdk.j.b.a.a a;
  protected Node b;
  private List c;
  
  protected b(com.purplebrain.adbuddiz.sdk.j.b.a.a parama, Node paramNode)
  {
    this.a = parama;
    this.b = paramNode;
  }
  
  public static b a(com.purplebrain.adbuddiz.sdk.j.b.a.a parama, Node paramNode)
  {
    if ("Linear".equals(paramNode.getNodeName())) {
      return new e(parama, paramNode);
    }
    if ("NonLinear".equals(paramNode.getNodeName())) {
      return new h(parama, paramNode);
    }
    if ("CompanionAds".equals(paramNode.getNodeName())) {
      return new a(parama, paramNode);
    }
    return null;
  }
  
  public abstract int a();
  
  public final List b()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      NodeList localNodeList = y.a(this.b, "TrackingEvents/Tracking");
      for (int i = 0; i < localNodeList.getLength(); i++) {
        this.c.add(new i(localNodeList.item(i)));
      }
    }
    return this.c;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */