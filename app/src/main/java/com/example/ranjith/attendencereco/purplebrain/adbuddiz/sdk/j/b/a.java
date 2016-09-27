package com.purplebrain.adbuddiz.sdk.j.b;

import android.annotation.SuppressLint;
import com.purplebrain.adbuddiz.sdk.i.y;
import com.purplebrain.adbuddiz.sdk.j.b.a.c;
import com.purplebrain.adbuddiz.sdk.j.b.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressLint({"NewApi"})
public final class a
{
  private Node a;
  private List b = null;
  
  public a(Node paramNode)
  {
    this.a = paramNode;
  }
  
  public final List a()
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      NodeList localNodeList = y.a(this.a, "Ad/InLine | Ad/Wrapper");
      int i = 0;
      if (i < localNodeList.getLength())
      {
        Node localNode = localNodeList.item(i);
        Object localObject;
        if ("InLine".equals(localNode.getNodeName())) {
          localObject = new c(localNode);
        }
        for (;;)
        {
          if (localObject != null) {
            this.b.add(localObject);
          }
          i++;
          break;
          if ("Wrapper".equals(localNode.getNodeName())) {
            localObject = new d(localNode);
          } else {
            localObject = null;
          }
        }
      }
    }
    return this.b;
  }
  
  public final List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      com.purplebrain.adbuddiz.sdk.j.b.a.a locala = (com.purplebrain.adbuddiz.sdk.j.b.a.a)localIterator.next();
      if ((locala.e() == paramInt) && (locala.a() == null)) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */