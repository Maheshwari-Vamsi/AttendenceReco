package com.example.ranjith.attendencereco.googlecode.javacpp.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
public @interface Platform
{
  String[] cinclude() default {};
  
  String[] define() default {};
  
  String[] framework() default {};
  
  String[] include() default {};
  
  String[] includepath() default {};
  
  String library() default "";
  
  String[] link() default {};
  
  String[] linkpath() default {};
  
  String[] not() default {};
  
  String[] options() default {};
  
  String[] preload() default {};
  
  String[] preloadpath() default {};
  
  String[] value() default {};
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\annotation\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */