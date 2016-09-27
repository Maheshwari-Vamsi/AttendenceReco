package com.example.ranjith.attendencereco.googlecode.javacv;

public class BufferRing<B extends ReleasableBuffer>
{
  private Object[] buffers;
  private int position;
  
  public BufferRing(BufferFactory<B> paramBufferFactory, int paramInt)
  {
    this.buffers = new Object[paramInt];
    for (int i = 0; i < paramInt; i++) {
      this.buffers[i] = paramBufferFactory.create();
    }
    this.position = 0;
  }
  
  public int capacity()
  {
    return this.buffers.length;
  }
  
  public B get()
  {
    return (ReleasableBuffer)this.buffers[this.position];
  }
  
  public B get(int paramInt)
  {
    return (ReleasableBuffer)this.buffers[(((paramInt + this.position) % this.buffers.length + this.buffers.length) % this.buffers.length)];
  }
  
  public int position()
  {
    return this.position;
  }
  
  public BufferRing position(int paramInt)
  {
    this.position = ((paramInt % this.buffers.length + this.buffers.length) % this.buffers.length);
    return this;
  }
  
  public void release()
  {
    for (int i = 0; i < this.buffers.length; i++) {
      ((ReleasableBuffer)this.buffers[i]).release();
    }
    this.buffers = null;
  }
  
  public static abstract interface BufferFactory<B extends ReleasableBuffer>
  {
    public abstract B create();
  }
  
  public static abstract interface ReleasableBuffer
  {
    public abstract void release();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\BufferRing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */