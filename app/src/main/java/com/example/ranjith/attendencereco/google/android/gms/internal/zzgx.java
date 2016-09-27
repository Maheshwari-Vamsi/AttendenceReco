package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgx
  implements zzgv.zza<zze>
{
  private final boolean zzFZ;
  private final boolean zzGa;
  
  public zzgx(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzFZ = paramBoolean1;
    this.zzGa = paramBoolean2;
  }
  
  public zze zzc(zzgv paramzzgv, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    List localList = paramzzgv.zza(paramJSONObject, "images", true, this.zzFZ, this.zzGa);
    zzje localzzje1 = paramzzgv.zza(paramJSONObject, "secondary_image", false, this.zzFZ);
    zzje localzzje2 = paramzzgv.zze(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((zzje)localIterator.next()).get());
    }
    return new zze(paramJSONObject.getString("headline"), localArrayList, paramJSONObject.getString("body"), (zzcn)localzzje1.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.getString("advertiser"), (zza)localzzje2.get(), new Bundle());
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */