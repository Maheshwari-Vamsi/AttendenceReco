package com.purplebrain.adbuddiz.sdk.i;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressLint({"NewApi"})
public final class y
{
  private static XPathFactory a = null;
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\n|\t", "");
  }
  
  public static Map a(Node paramNode)
  {
    HashMap localHashMap = new HashMap();
    if (paramNode.getAttributes() != null) {
      for (int i = 0; i < paramNode.getAttributes().getLength(); i++)
      {
        Node localNode = paramNode.getAttributes().item(i);
        localHashMap.put(localNode.getNodeName(), localNode.getNodeValue());
      }
    }
    return localHashMap;
  }
  
  public static NodeList a(Node paramNode, String paramString)
  {
    try
    {
      if (a == null) {
        a = XPathFactory.newInstance();
      }
      NodeList localNodeList = (NodeList)a.newXPath().evaluate(paramString, paramNode, XPathConstants.NODESET);
      return localNodeList;
    }
    catch (XPathExpressionException localXPathExpressionException)
    {
      throw new RuntimeException(localXPathExpressionException);
    }
  }
  
  public static Node b(Node paramNode, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    NodeList localNodeList = paramNode.getChildNodes();
    for (int i = 0; i < localNodeList.getLength(); i++) {
      if (paramString.equals(localNodeList.item(i).getNodeName())) {
        localArrayList.add(localNodeList.item(i));
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return (Node)localArrayList.get(0);
  }
  
  public static List c(Node paramNode, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    NodeList localNodeList = paramNode.getChildNodes();
    for (int i = 0; i < localNodeList.getLength(); i++) {
      if (paramString.equals(localNodeList.item(i).getNodeName())) {
        localArrayList.add(a(localNodeList.item(i).getTextContent()));
      }
    }
    return localArrayList;
  }
  
  public static String d(Node paramNode, String paramString)
  {
    Node localNode = b(paramNode, paramString);
    if (localNode == null) {
      return null;
    }
    return a(localNode.getTextContent());
  }
  
  public static String e(Node paramNode, String paramString)
  {
    if (paramNode.getAttributes() == null) {}
    Node localNode;
    do
    {
      return null;
      localNode = paramNode.getAttributes().getNamedItem(paramString);
    } while (localNode == null);
    return localNode.getTextContent();
  }
  
  public static Integer f(Node paramNode, String paramString)
  {
    String str = e(paramNode, paramString);
    if (str != null) {
      return Integer.valueOf(Integer.parseInt(str));
    }
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */