package com.example.ranjith.attendencereco.googlecode.javacpp;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;

public class LongPointer
  extends Pointer
{
  public LongPointer(int paramInt)
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
  
  public LongPointer(Pointer paramPointer)
  {
    super(paramPointer);
  }
  
  public LongPointer(LongBuffer paramLongBuffer)
  {
    super(paramLongBuffer);
    if ((paramLongBuffer != null) && (paramLongBuffer.hasArray()))
    {
      long[] arrayOfLong = paramLongBuffer.array();
      allocateArray(arrayOfLong.length);
      put(arrayOfLong);
      position(paramLongBuffer.position());
      limit(paramLongBuffer.limit());
    }
  }
  
  public LongPointer(long... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  private native void allocateArray(int paramInt);
  
  public final LongBuffer asBuffer()
  {
    return asByteBuffer().asLongBuffer();
  }
  
  public LongPointer capacity(int paramInt)
  {
    return (LongPointer)super.capacity(paramInt);
  }
  
  public long get()
  {
    return get(0);
  }
  
  public native long get(int paramInt);
  
  public LongPointer get(long[] paramArrayOfLong)
  {
    return get(paramArrayOfLong, 0, paramArrayOfLong.length);
  }
  
  public native LongPointer get(long[] paramArrayOfLong, int paramInt1, int paramInt2);
  
  public LongPointer limit(int paramInt)
  {
    return (LongPointer)super.limit(paramInt);
  }
  
  public LongPointer position(int paramInt)
  {
    return (LongPointer)super.position(paramInt);
  }
  
  public native LongPointer put(int paramInt, long paramLong);
  
  public LongPointer put(long paramLong)
  {
    return put(0, paramLong);
  }
  
  public LongPointer put(long[] paramArrayOfLong)
  {
    return put(paramArrayOfLong, 0, paramArrayOfLong.length);
  }
  
  public native LongPointer put(long[] paramArrayOfLong, int paramInt1, int paramInt2);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\LongPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */