package com.example.ranjith.attendencereco.googlecode.javacpp;

public class PointerPointer
  extends Pointer
{
  private Pointer[] pointerArray;
  
  public PointerPointer(int paramInt)
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
  
  public PointerPointer(Pointer paramPointer)
  {
    super(paramPointer);
  }
  
  public PointerPointer(Pointer... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(byte[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(char[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(double[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(float[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(int[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(long[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  public PointerPointer(short[]... paramVarArgs)
  {
    this(paramVarArgs.length);
    put(paramVarArgs);
  }
  
  private native void allocateArray(int paramInt);
  
  public PointerPointer capacity(int paramInt)
  {
    return (PointerPointer)super.capacity(paramInt);
  }
  
  public Pointer get()
  {
    return get(0);
  }
  
  public native Pointer get(int paramInt);
  
  public PointerPointer limit(int paramInt)
  {
    return (PointerPointer)super.limit(paramInt);
  }
  
  public PointerPointer position(int paramInt)
  {
    return (PointerPointer)super.position(paramInt);
  }
  
  public native PointerPointer put(int paramInt, Pointer paramPointer);
  
  public PointerPointer put(Pointer paramPointer)
  {
    return put(0, paramPointer);
  }
  
  public PointerPointer put(Pointer... paramVarArgs)
  {
    for (int i = 0; i < paramVarArgs.length; i++) {
      put(i, paramVarArgs[i]);
    }
    return this;
  }
  
  public PointerPointer put(byte[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new BytePointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
  
  public PointerPointer put(char[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new CharPointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
  
  public PointerPointer put(double[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new DoublePointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
  
  public PointerPointer put(float[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new FloatPointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
  
  public PointerPointer put(int[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new IntPointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
  
  public PointerPointer put(long[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new LongPointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
  
  public PointerPointer put(short[]... paramVarArgs)
  {
    this.pointerArray = new Pointer[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.pointerArray[i] = new ShortPointer(paramVarArgs[i]);
    }
    return put(this.pointerArray);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\PointerPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */