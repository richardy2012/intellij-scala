package org.jetbrains.plugins.scala.project;

import com.intellij.util.xmlb.annotations.AbstractCollection;
import com.intellij.util.xmlb.annotations.Tag;

import java.util.Arrays;

/**
 * @author Pavel Fatin
 */
public class ScalaLibraryPropertiesState {
  // We have to rely on the Java's enumeration for serialization
  public PlatformProxy platform = null;

  // We have to rely on the Java's enumeration for serialization
  public ScalaLanguageLevelProxy languageLevel = null;

  public ScalaLibraryPropertiesState() {
    this(PlatformProxy.Scala, ScalaLanguageLevel.Default().proxy());
  }

  public ScalaLibraryPropertiesState(PlatformProxy platform, ScalaLanguageLevelProxy languageLevel) {
    this.platform = platform;
    this.languageLevel = languageLevel;
  }

  @Tag("compiler-classpath")
  @AbstractCollection(surroundWithTag = false, elementTag = "root", elementValueAttribute = "url")
  public String[] compilerClasspath = new String[]{};

  @Override
  public boolean equals(Object obj) {
    ScalaLibraryPropertiesState that = (ScalaLibraryPropertiesState) obj;
    return languageLevel == that.languageLevel && Arrays.equals(compilerClasspath, that.compilerClasspath);
  }
}