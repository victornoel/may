/*
* generated by Xtext
*/
package fr.irit.smac.may.speadl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SpeADLAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("fr/irit/smac/may/speadl/parser/antlr/internal/InternalSpeADL.tokens");
	}
}