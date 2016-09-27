package com.purplebrain.adbuddiz.sdk;

public enum AdBuddizLogLevel
{
  static
  {
    Error = new AdBuddizLogLevel("Error", 1);
    Silent = new AdBuddizLogLevel("Silent", 2);
    AdBuddizLogLevel[] arrayOfAdBuddizLogLevel = new AdBuddizLogLevel[3];
    arrayOfAdBuddizLogLevel[0] = Info;
    arrayOfAdBuddizLogLevel[1] = Error;
    arrayOfAdBuddizLogLevel[2] = Silent;
    $VALUES = arrayOfAdBuddizLogLevel;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddizLogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */