package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw
  implements zzy
{
  protected final HttpClient zzaD;
  
  public zzw(HttpClient paramHttpClient)
  {
    this.zzaD = paramHttpClient;
  }
  
  private static void zza(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, zzk<?> paramzzk)
    throws zza
  {
    byte[] arrayOfByte = paramzzk.zzq();
    if (arrayOfByte != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(arrayOfByte));
    }
  }
  
  private static void zza(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  static HttpUriRequest zzb(zzk<?> paramzzk, Map<String, String> paramMap)
    throws zza
  {
    switch (paramzzk.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      byte[] arrayOfByte = paramzzk.zzm();
      if (arrayOfByte != null)
      {
        HttpPost localHttpPost2 = new HttpPost(paramzzk.getUrl());
        localHttpPost2.addHeader("Content-Type", paramzzk.zzl());
        localHttpPost2.setEntity(new ByteArrayEntity(arrayOfByte));
        return localHttpPost2;
      }
      return new HttpGet(paramzzk.getUrl());
    case 0: 
      return new HttpGet(paramzzk.getUrl());
    case 3: 
      return new HttpDelete(paramzzk.getUrl());
    case 1: 
      HttpPost localHttpPost1 = new HttpPost(paramzzk.getUrl());
      localHttpPost1.addHeader("Content-Type", paramzzk.zzp());
      zza(localHttpPost1, paramzzk);
      return localHttpPost1;
    case 2: 
      HttpPut localHttpPut = new HttpPut(paramzzk.getUrl());
      localHttpPut.addHeader("Content-Type", paramzzk.zzp());
      zza(localHttpPut, paramzzk);
      return localHttpPut;
    case 4: 
      return new HttpHead(paramzzk.getUrl());
    case 5: 
      return new HttpOptions(paramzzk.getUrl());
    case 6: 
      return new HttpTrace(paramzzk.getUrl());
    }
    zza localzza = new zza(paramzzk.getUrl());
    localzza.addHeader("Content-Type", paramzzk.zzp());
    zza(localzza, paramzzk);
    return localzza;
  }
  
  public HttpResponse zza(zzk<?> paramzzk, Map<String, String> paramMap)
    throws IOException, zza
  {
    HttpUriRequest localHttpUriRequest = zzb(paramzzk, paramMap);
    zza(localHttpUriRequest, paramMap);
    zza(localHttpUriRequest, paramzzk.getHeaders());
    zza(localHttpUriRequest);
    HttpParams localHttpParams = localHttpUriRequest.getParams();
    int i = paramzzk.zzt();
    HttpConnectionParams.setConnectionTimeout(localHttpParams, 5000);
    HttpConnectionParams.setSoTimeout(localHttpParams, i);
    return this.zzaD.execute(localHttpUriRequest);
  }
  
  protected void zza(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {}
  
  public static final class zza
    extends HttpEntityEnclosingRequestBase
  {
    public zza() {}
    
    public zza(String paramString)
    {
      setURI(URI.create(paramString));
    }
    
    public String getMethod()
    {
      return "PATCH";
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */