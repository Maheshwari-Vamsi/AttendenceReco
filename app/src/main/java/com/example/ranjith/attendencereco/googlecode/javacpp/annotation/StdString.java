package com.example.ranjith.attendencereco.googlecode.javacpp.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Adapter("StringAdapter")
@Cast({"std::string&"})
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface StdString {}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\annotation\StdString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */