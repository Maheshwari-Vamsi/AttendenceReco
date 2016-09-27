package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@zzha
public class zzbo
{
  public static int zzC(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      arrayOfByte1 = arrayOfByte2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte1 = paramString.getBytes();
      }
    }
    return zznw.zza(arrayOfByte1, 0, arrayOfByte1.length, 0);
  }
  
  public static String[] zzD(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int i = paramString.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n;
    int i1;
    int i2;
    int i3;
    if (m < i)
    {
      n = Character.codePointAt(arrayOfChar, m);
      i1 = Character.charCount(n);
      if (zzi(n))
      {
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, k, m - k));
        }
        localArrayList.add(new String(arrayOfChar, m, i1));
        i2 = k;
        i3 = 0;
      }
    }
    for (;;)
    {
      m += i1;
      int i4 = i3;
      k = i2;
      j = i4;
      break;
      if ((Character.isLetterOrDigit(n)) || (Character.getType(n) == 6) || (Character.getType(n) == 8))
      {
        if (j == 0) {
          k = m;
        }
        i2 = k;
        i3 = 1;
      }
      else if (j != 0)
      {
        localArrayList.add(new String(arrayOfChar, k, m - k));
        i2 = k;
        i3 = 0;
        continue;
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, k, m - k));
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      else
      {
        int i5 = j;
        i2 = k;
        i3 = i5;
      }
    }
  }
  
  private static boolean zza(Character.UnicodeBlock paramUnicodeBlock)
  {
    return (paramUnicodeBlock == Character.UnicodeBlock.BOPOMOFO) || (paramUnicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (paramUnicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS) || (paramUnicodeBlock == Character.UnicodeBlock.HANGUL_JAMO) || (paramUnicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) || (paramUnicodeBlock == Character.UnicodeBlock.HIRAGANA) || (paramUnicodeBlock == Character.UnicodeBlock.KATAKANA) || (paramUnicodeBlock == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
  }
  
  static boolean zzi(int paramInt)
  {
    return (Character.isLetter(paramInt)) && ((zza(Character.UnicodeBlock.of(paramInt))) || (zzj(paramInt)));
  }
  
  private static boolean zzj(int paramInt)
  {
    return ((paramInt >= 65382) && (paramInt <= 65437)) || ((paramInt >= 65441) && (paramInt <= 65500));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */