package com.example.ranjith.attendencereco.googlecode.javacpp;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;

@Name({"long"})
public class CLongPointer
  extends Pointer
{
  public CLongPointer(int paramInt)
  {
    try
    {
      allocateArray(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", localUnsatisfiedLinkError);
    }
  }
  
  public CLongPointer(Pointer paramPointer)
  {
    super(paramPointer);
  }
  
  private native void allocateArray(int paramInt);
  
  public CLongPointer capacity(int paramInt)
  {
    return (CLongPointer)super.capacity(paramInt);
  }
  
  public long get()
  {
    return get(0);
  }
  
  @Cast({"long"})
  public native long get(int paramInt);
  
  public CLongPointer limit(int paramInt)
  {
    return (CLongPointer)super.limit(paramInt);
  }
  
  public CLongPointer position(int paramInt)
  {
    return (CLongPointer)super.position(paramInt);
  }
  
  public native CLongPointer put(int paramInt, long paramLong);
  
  public CLongPointer put(long paramLong)
  {
    return put(0, paramLong);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\CLongPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */