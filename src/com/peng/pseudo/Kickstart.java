package com.peng.pseudo;

import com.google.i18n.pseudolocalization.PseudolocalizationPipeline;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by peng.lim on 5/5/16.
 */
public class Kickstart {

  public static void main(String[] args) {
    Properties props = new Properties();
    try {
      FileReader fr = new FileReader("ecomm-labels.properties");
      props.load(fr);
      PseudolocalizationPipeline pipeline =
          PseudolocalizationPipeline.getVariantPipeline(true, "psbidi");
//      PseudolocalizationPipeline pipeline =
//          PseudolocalizationPipeline.getVariantPipeline(true, "psaccent");

      for(Object prop : props.keySet()){

        String value = props.getProperty(prop.toString());
        String result = pipeline.localize(value);
        System.out.println("old: " + value + "\tnew: " + result);

      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
