package com.example.ranjith.attendencereco.googlecode.javacv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Parallel
{
  public static final String NUM_THREADS = "com.googlecode.javacv.numthreads";
  private static final ExecutorService threadPool = ;
  
  public static int getNumCores()
  {
    return Runtime.getRuntime().availableProcessors();
  }
  
  public static int getNumThreads()
  {
    try
    {
      String str = System.getProperty("com.googlecode.javacv.numthreads");
      if (str != null)
      {
        int i = Integer.valueOf(str).intValue();
        return i;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new RuntimeException(localNumberFormatException);
    }
    return getNumCores();
  }
  
  public static void loop(int paramInt1, int paramInt2, int paramInt3, Looper paramLooper)
  {
    int i = paramInt2 - paramInt1;
    if (paramInt3 > 0) {}
    Runnable[] arrayOfRunnable;
    for (;;)
    {
      int j = Math.min(i, paramInt3);
      arrayOfRunnable = new Runnable[j];
      for (final int k = 0; k < j; k++) {
        arrayOfRunnable[k = new Runnable()
        {
          public void run()
          {
            this.val$looper.loop(this.val$subFrom, this.val$subTo, k);
          }
        };
      }
      paramInt3 = getNumCores();
    }
    run(arrayOfRunnable);
  }
  
  public static void loop(int paramInt1, int paramInt2, Looper paramLooper)
  {
    loop(paramInt1, paramInt2, getNumThreads(), paramLooper);
  }
  
  public static void run(Runnable... paramVarArgs)
  {
    if (paramVarArgs.length == 1) {
      paramVarArgs[0].run();
    }
    Future[] arrayOfFuture;
    Object localObject;
    for (;;)
    {
      return;
      arrayOfFuture = new Future[paramVarArgs.length];
      for (int i = 0; i < paramVarArgs.length; i++) {
        arrayOfFuture[i] = threadPool.submit(paramVarArgs[i]);
      }
      try
      {
        int m = arrayOfFuture.length;
        for (int n = 0;; n++)
        {
          localObject = null;
          if (n >= m) {
            break;
          }
          Future localFuture = arrayOfFuture[n];
          if (!localFuture.isDone()) {
            localFuture.get();
          }
        }
        if (localObject == null) {}
      }
      catch (Throwable localThrowable)
      {
        localObject = localThrowable;
      }
    }
    int j = arrayOfFuture.length;
    for (int k = 0; k < j; k++) {
      arrayOfFuture[k].cancel(true);
    }
    throw new RuntimeException((Throwable)localObject);
  }
  
  public static void setNumThreads(int paramInt)
  {
    System.setProperty("com.googlecode.javacv.numthreads", Integer.toString(paramInt));
  }
  
  public static abstract interface Looper
  {
    public abstract void loop(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\Parallel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */