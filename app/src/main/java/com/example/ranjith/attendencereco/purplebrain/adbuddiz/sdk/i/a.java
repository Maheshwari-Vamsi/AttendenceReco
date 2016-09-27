package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import android.content.Intent;
import com.purplebrain.adbuddiz.sdk.AdBuddizActivity;
import org.json.JSONObject;

public final class a
{
  public com.purplebrain.adbuddiz.sdk.f.a.a a;
  public String b;
  private Context c;
  
  public a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public final Intent a()
  {
    Intent localIntent = new Intent(this.c, AdBuddizActivity.class);
    localIntent.putExtra("a", this.a.a().toString());
    if (this.b != null) {
      localIntent.putExtra("p", this.b);
    }
    localIntent.putExtra("fs", j.b(this.c));
    localIntent.putExtra("wt", j.c(this.c));
    localIntent.putExtra("suf", j.d(this.c));
    Integer localInteger1 = j.f(this.c);
    if (localInteger1 != null) {
      localIntent.putExtra("sbc", localInteger1);
    }
    Integer localInteger2 = j.g(this.c);
    if (localInteger2 != null) {
      localIntent.putExtra("snc", localInteger2);
    }
    return localIntent;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */