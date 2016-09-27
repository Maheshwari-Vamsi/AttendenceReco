package com.purplebrain.adbuddiz.sdk.j.b.a;

import android.annotation.SuppressLint;
import com.purplebrain.adbuddiz.sdk.i.y;
import com.purplebrain.adbuddiz.sdk.j.b.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressLint({"NewApi"})
public abstract class a
{
  protected Node a;
  private List b = null;
  private List c = null;
  private List d = null;
  
  public a(Node paramNode)
  {
    this.a = paramNode;
  }
  
  public final Integer a()
  {
    return y.f(this.a.getParentNode(), "sequence");
  }
  
  public final List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a() == paramInt) {
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
  
  public final List b()
  {
    if (this.b == null) {
      this.b = y.c(this.a, "Error");
    }
    return this.b;
  }
  
  public final List c()
  {
    if (this.c == null) {
      this.c = y.c(this.a, "Impression");
    }
    return this.c;
  }
  
  public final List d()
  {
    if (this.d == null)
    {
      this.d = new ArrayList();
      NodeList localNodeList = y.a(this.a, "Creatives/Creative/Linear | Creatives/Creative/CompanionAds | Creatives/Creative/NonLinearAds");
      for (int i = 0; i < localNodeList.getLength(); i++)
      {
        b localb = b.a(this, localNodeList.item(i));
        if (localb != null) {
          this.d.add(localb);
        }
      }
    }
    return this.d;
  }
  
  public abstract int e();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */