package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzha
public class zzfz
  extends Handler
{
  private final zzfy zzEp;
  
  public zzfz(Context paramContext)
  {
    this(new zzga(paramContext));
  }
  
  public zzfz(zzfy paramzzfy)
  {
    this.zzEp = paramzzfy;
  }
  
  private void zzc(JSONObject paramJSONObject)
  {
    try
    {
      this.zzEp.zza(paramJSONObject.getString("request_id"), paramJSONObject.getString("base_url"), paramJSONObject.getString("html"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      Bundle localBundle = paramMessage.getData();
      if (localBundle == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject(localBundle.getString("data"));
      if ("fetch_html".equals(localJSONObject.getString("message_name")))
      {
        zzc(localJSONObject);
        return;
      }
    }
    catch (Exception localException) {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */