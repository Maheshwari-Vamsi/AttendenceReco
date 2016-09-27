package com.example.ranjith.attendencereco.googlecode.javacpp;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

public class BuildMojo
  extends AbstractMojo
{
  protected String classOrPackageName = null;
  protected String[] classOrPackageNames = null;
  private String classPath = null;
  private String[] classPaths = null;
  protected boolean compile = true;
  protected String[] compilerOptions = null;
  protected Map<String, String> environmentVariables = null;
  protected boolean header = false;
  protected String jarPrefix = null;
  private File outputDirectory = null;
  protected String outputName = null;
  protected String properties = null;
  protected File propertyFile = null;
  protected Properties propertyKeysAndValues = null;
  
  public void execute()
    throws MojoExecutionException
  {
    for (;;)
    {
      try
      {
        getLog().info("Executing JavaCPP Builder");
        if (getLog().isDebugEnabled())
        {
          getLog().debug("classPath: " + this.classPath);
          getLog().debug("classPaths: " + Arrays.deepToString(this.classPaths));
          getLog().debug("outputDirectory: " + this.outputDirectory);
          getLog().debug("outputName: " + this.outputName);
          getLog().debug("compile: " + this.compile);
          getLog().debug("header: " + this.header);
          getLog().debug("jarPrefix: " + this.jarPrefix);
          getLog().debug("properties: " + this.properties);
          getLog().debug("propertyFile: " + this.propertyFile);
          getLog().debug("propertyKeysAndValues: " + this.propertyKeysAndValues);
          getLog().debug("classOrPackageName: " + this.classOrPackageName);
          getLog().debug("classOrPackageNames: " + Arrays.deepToString(this.classOrPackageNames));
          getLog().debug("environmentVariables: " + this.environmentVariables);
          getLog().debug("compilerOptions: " + this.compilerOptions);
        }
        if ((this.classPaths != null) && (this.classPath != null))
        {
          this.classPaths = ((String[])Arrays.copyOf(this.classPaths, 1 + this.classPaths.length));
          this.classPaths[(-1 + this.classPaths.length)] = this.classPath;
          if ((this.classOrPackageNames != null) && (this.classOrPackageName != null))
          {
            this.classOrPackageNames = ((String[])Arrays.copyOf(this.classOrPackageNames, 1 + this.classOrPackageNames.length));
            this.classOrPackageNames[(-1 + this.classOrPackageNames.length)] = this.classOrPackageName;
            Collection localCollection = new Builder().classPaths(this.classPaths).outputDirectory(this.outputDirectory).outputName(this.outputName).compile(this.compile).header(this.header).jarPrefix(this.jarPrefix).properties(this.properties).propertyFile(this.propertyFile).properties(this.propertyKeysAndValues).classesOrPackages(this.classOrPackageNames).environmentVariables(this.environmentVariables).compilerOptions(this.compilerOptions).build();
            getLog().info("Successfully executed JavaCPP Builder");
            if (!getLog().isDebugEnabled()) {
              break;
            }
            getLog().debug("outputFiles: " + localCollection);
          }
        }
        else
        {
          if (this.classPath == null) {
            continue;
          }
          String[] arrayOfString1 = new String[1];
          arrayOfString1[0] = this.classPath;
          this.classPaths = arrayOfString1;
          continue;
        }
        if (this.classOrPackageName == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        getLog().error("Failed to execute JavaCPP Builder: " + localException.getMessage());
        throw new MojoExecutionException("Failed to execute JavaCPP Builder", localException);
      }
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = this.classOrPackageName;
      this.classOrPackageNames = arrayOfString2;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\BuildMojo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */