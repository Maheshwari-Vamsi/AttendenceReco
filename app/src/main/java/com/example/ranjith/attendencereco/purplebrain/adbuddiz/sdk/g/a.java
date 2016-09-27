package com.purplebrain.adbuddiz.sdk.g;

import android.webkit.WebView;
import com.purplebrain.adbuddiz.sdk.b.h;
import com.purplebrain.adbuddiz.sdk.i.f;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();
  private WebView b = null;
  
  public a(WebView paramWebView)
  {
    this.b = paramWebView;
  }
  
  public static void a(WebView paramWebView)
  {
    try
    {
      a(paramWebView, f.b("InVzZSBzdHJpY3QiO3dpbmRvdy5fbXJhaWQ9KGZ1bmN0aW9uKCl7dmFyIGg9WyJsb2FkaW5nIiwiZGVmYXVsdCIsImV4cGFuZGVkIiwicmVzaXplZCIsImhpZGRlbiJdO3ZhciBnPVsicmVhZHkiLCJlcnJvciIsInN0YXRlQ2hhbmdlIiwidmlld2FibGVDaGFuZ2UiLCJzaXplQ2hhbmdlIl07dmFyIGE9ImxvYWRpbmciO3ZhciBkPWZhbHNlO3ZhciBiPXt9O3ZhciBmPXt9O3ZhciBsPXtzbXM6ZmFsc2UsdGVsOmZhbHNlLGNhbGVuZGFyOmZhbHNlLHN0b3JlUGljdHVyZTpmYWxzZSxpbmxpbmVWaWRlbzpmYWxzZX07dmFyIGM9e2FsbG93T3JpZW50YXRpb25DaGFuZ2U6dHJ1ZSxmb3JjZU9yaWVudGF0aW9uOiJub25lIn07dmFyIGs9e307Zm9yKHZhciBlPTA7ZTxnLmxlbmd0aDtlKyspe2tbZ1tlXV09W119dmFyIGo9e19maXJlRXZlbnQ6ZnVuY3Rpb24ocCl7aWYoZy5pbmRleE9mKHApPT0tMSl7cmV0dXJufXZhciBuPVtdO2Zvcih2YXIgbT0xO208YXJndW1lbnRzLmxlbmd0aDttKyspe24ucHVzaChhcmd1bWVudHNbbV0pfXZhciBxPWtbcF07Zm9yKHZhciBvPTA7bzxxLmxlbmd0aDtvKyspe3Fbb10uYXBwbHkodW5kZWZpbmVkLG4pfX0sX2NhbGxBY3Rpb246ZnVuY3Rpb24obyxxKXt2YXIgbT0ibXJhaWQ6Ly9hZGJ1ZGRpei8iK287aWYocSE9dW5kZWZpbmVkKXt2YXIgaT0iIjtmb3IodmFyIHAgaW4gcSl7aWYoaS5sZW5ndGg9PTApe2krPSI/In1lbHNle2krPSImIn1pKz1wKyI9IitlbmNvZGVVUklDb21wb25lbnQocVtwXSl9bSs9aX12YXIgbj1kb2N1bWVudC5jcmVhdGVFbGVtZW50KCJpZnJhbWUiKTtuLnNldEF0dHJpYnV0ZSgic3JjIixtKTtuLnNldEF0dHJpYnV0ZSgic3R5bGUiLCJkaXNwbGF5OiBub25lOyIpO2lmKGRvY3VtZW50LmJvZHkhPW51bGwpe2RvY3VtZW50LmJvZHkuYXBwZW5kQ2hpbGQobil9ZWxzZXtkb2N1bWVudC5hZGRFdmVudExpc3RlbmVyKCJET01Db250ZW50TG9hZGVkIixmdW5jdGlvbigpe2RvY3VtZW50LmJvZHkuYXBwZW5kQ2hpbGQobil9LGZhbHNlKX19LF9zZXRTdXBwb3J0Rm9yOmZ1bmN0aW9uKGksbSl7aWYobFtpXT09dW5kZWZpbmVkKXtyZXR1cm59bFtpXT0obT09InRydWUiKX0sX3N1cHBvcnRzOmZ1bmN0aW9uKGkpe2lmKGxbaV09PXVuZGVmaW5lZCl7cmV0dXJuIGZhbHNlfXJldHVybiBsW2ldfSxfc2V0U3RhdGU6ZnVuY3Rpb24oaSl7YT1pfSxfZ2V0U3RhdGU6ZnVuY3Rpb24oKXtyZXR1cm4gYX0sX3NldFZpc2libGU6ZnVuY3Rpb24oaSl7ZD0oaT09InRydWUiKX0sX2lzVmlld2FibGU6ZnVuY3Rpb24oKXtyZXR1cm4oZD09dHJ1ZSl9LF9zZXRNYXhTaXplOmZ1bmN0aW9uKG0saSl7Zj17d2lkdGg6cGFyc2VJbnQobSksaGVpZ2h0OnBhcnNlSW50KGkpfX0sX2dldE1heFNpemU6ZnVuY3Rpb24oKXtyZXR1cm4gZn0sX3NldFNjcmVlblNpemU6ZnVuY3Rpb24obSxpKXtiPXt3aWR0aDpwYXJzZUludChtKSxoZWlnaHQ6cGFyc2VJbnQoaSl9fSxfZ2V0U2NyZWVuU2l6ZTpmdW5jdGlvbigpe3JldHVybiBifSxfc2V0T3JpZW50YXRpb25Qcm9wZXJ0aWVzOmZ1bmN0aW9uKG0saSl7ai5fY2FsbEFjdGlvbigic2V0T3JpZW50YXRpb25Qcm9wZXJ0aWVzIix7YWxsb3dPcmllbnRhdGlvbkNoYW5nZTptfHx0cnVlLGZvcmNlT3JpZW50YXRpb246aXx8Im5vbmUifSl9LF9nZXRPcmllbnRhdGlvblByb3BlcnRpZXM6ZnVuY3Rpb24oKXt9LF9vcGVuOmZ1bmN0aW9uKGkpe2lmKGk9PXVuZGVmaW5lZCl7ai5fZmlyZUV2ZW50KCJlcnJvciIsInVybCBwYXJhbWF0ZXIgaXMgbWFuZGF0b3J5Iiwib3BlbiIpO3JldHVybn1qLl9jYWxsQWN0aW9uKCJvcGVuIix7dXJsOml9KX0sX3BsYXlWaWRlbzpmdW5jdGlvbihpKXtpZihpPT11bmRlZmluZWQpe2ouX2ZpcmVFdmVudCgiZXJyb3IiLCJ1cmkgcGFyYW1hdGVyIGlzIG1hbmRhdG9yeSIsIm9wZW4iKTtyZXR1cm59ai5fY2FsbEFjdGlvbigicGxheVZpZGVvIix7dXJpOml9KX0sX2Nsb3NlOmZ1bmN0aW9uKCl7ai5fY2FsbEFjdGlvbigiY2xvc2UiKX0sX2FkZEV2ZW50TGlzdGVuZXI6ZnVuY3Rpb24oaSxtKXtpZihnLmluZGV4T2YoaSk9PS0xKXtqLl9maXJlRXZlbnQoImVycm9yIixpKyIgaXMgbm90IGEgdmFsaWQgTVJBSUQgMi4wIGV2ZW50LiIsImFkZEV2ZW50TGlzdGVuZXIiKTtyZXR1cm59a1tpXS5wdXNoKG0pfSxfcmVtb3ZlRXZlbnRMaXN0ZW5lcjpmdW5jdGlvbihtLG4pe2lmKGcuaW5kZXhPZihtKT09LTEpe3JldHVybn12YXIgaT1rW21dLmluZGV4T2Yobik7aWYoaSE9LTEpe2tbbV0uc3BsaWNlKDEsMSl9fX07cmV0dXJuIGp9KSgpO3ZhciBtcmFpZD0oZnVuY3Rpb24oKXtyZXR1cm57YWRkRXZlbnRMaXN0ZW5lcjp3aW5kb3cuX21yYWlkLl9hZGRFdmVudExpc3RlbmVyLGNyZWF0ZUNhbGVuZGFyRXZlbnQ6ZnVuY3Rpb24oKXt9LGNsb3NlOndpbmRvdy5fbXJhaWQuX2Nsb3NlLGV4cGFuZDpmdW5jdGlvbigpe30sZ2V0Q3VycmVudFBvc2l0aW9uOmZ1bmN0aW9uKCl7cmV0dXJue3g6MCx5OjAsd2lkdGg6d2luZG93Ll9tcmFpZC5fZ2V0TWF4U2l6ZSgpLndpZHRoLGhlaWdodDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkuaGVpZ2h0fX0sZ2V0RGVmYXVsdFBvc2l0aW9uOmZ1bmN0aW9uKCl7cmV0dXJue3g6MCx5OjAsd2lkdGg6d2luZG93Ll9tcmFpZC5fZ2V0TWF4U2l6ZSgpLndpZHRoLGhlaWdodDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkuaGVpZ2h0fX0sZ2V0RXhwYW5kUHJvcGVydGllczpmdW5jdGlvbigpe3JldHVybnt3aWR0aDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkud2lkdGgsaGVpZ2h0OndpbmRvdy5fbXJhaWQuX2dldE1heFNpemUoKS5oZWlnaHQsdXNlQ3VzdG9tQ2xvc2U6ZmFsc2UsaXNNb2RhbDp0cnVlfX0sZ2V0TWF4U2l6ZTp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplLGdldE9yaWVudGF0aW9uUHJvcGVydGllczp3aW5kb3cuX21yYWlkLl9nZXRPcmllbnRhdGlvblByb3BlcnRpZXMsZ2V0UGxhY2VtZW50VHlwZTpmdW5jdGlvbigpe3JldHVybiJpbnRlcnN0aXRpYWwifSxnZXRSZXNpemVQcm9wZXJ0aWVzOmZ1bmN0aW9uKCl7cmV0dXJue3dpZHRoOndpbmRvdy5fbXJhaWQuX2dldE1heFNpemUoKS53aWR0aCxoZWlnaHQ6d2luZG93Ll9tcmFpZC5fZ2V0TWF4U2l6ZSgpLmhlaWdodCxvZmZzZXRYOjAsb2Zmc2V0WTowfX0sZ2V0U2NyZWVuU2l6ZTp3aW5kb3cuX21yYWlkLl9nZXRTY3JlZW5TaXplLGdldFN0YXRlOndpbmRvdy5fbXJhaWQuX2dldFN0YXRlLGdldFZlcnNpb246ZnVuY3Rpb24oKXtyZXR1cm4iMi4wIn0saXNWaWV3YWJsZTp3aW5kb3cuX21yYWlkLl9pc1ZpZXdhYmxlLG9wZW46d2luZG93Ll9tcmFpZC5fb3BlbixwbGF5VmlkZW86d2luZG93Ll9tcmFpZC5fcGxheVZpZGVvLHJlbW92ZUV2ZW50TGlzdGVuZXI6d2luZG93Ll9tcmFpZC5fcmVtb3ZlRXZlbnRMaXN0ZW5lcixyZXNpemU6ZnVuY3Rpb24oKXt9LHNldEV4cGFuZFByb3BlcnRpZXM6ZnVuY3Rpb24oKXt9LHNldE9yaWVudGF0aW9uUHJvcGVydGllczpmdW5jdGlvbihhKXt3aW5kb3cuX21yYWlkLl9zZXRPcmllbnRhdGlvblByb3BlcnRpZXMoYS5hbGxvd09yaWVudGF0aW9uQ2hhbmdlLGEuZm9yY2VPcmllbnRhdGlvbnx8Im5vbmUiKX0sc2V0UmVzaXplUHJvcGVydGllczpmdW5jdGlvbigpe30sc3RvcmVQaWN0dXJlOmZ1bmN0aW9uKCl7fSxzdXBwb3J0czp3aW5kb3cuX21yYWlkLl9zdXBwb3J0cyx1c2VDdXN0b21DbG9zZTpmdW5jdGlvbigpe319fSkoKTs="));
      return;
    }
    catch (h localh) {}
  }
  
  static void a(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl("javascript:" + paramString);
  }
  
  private void b(String paramString, Object... paramVarArgs)
  {
    String str1 = "javascript:" + paramString;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    StringBuilder localStringBuilder;
    for (String str2 = str1 + "()";; str2 = str1 + "(" + localStringBuilder + ")")
    {
      this.b.loadUrl(str2);
      return;
      localStringBuilder = new StringBuilder();
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject = paramVarArgs[j];
        if (localStringBuilder.length() != 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(JSONObject.quote(localObject.toString()));
      }
    }
  }
  
  public final void a(d paramd, Object... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[1 + paramVarArgs.length];
    arrayOfObject[0] = paramd;
    for (int i = 1; i <= paramVarArgs.length; i++) {
      arrayOfObject[i] = paramVarArgs[(i - 1)];
    }
    a("_fireEvent", arrayOfObject);
  }
  
  public final void a(String paramString, Object... paramVarArgs)
  {
    b("window._mraid." + paramString, paramVarArgs);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */