package fr.irit.smac.may.speadl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.irit.smac.may.speadl.services.SpeADLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSpeADLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'namespace'", "'{'", "'}'", "':'", "'ecosystem'", "'['", "','", "']'", "'specializes'", "'component'", "'species'", "'('", "')'", "'provides'", "'='", "'requires'", "'part'", "'use'", "'bind'", "'to'", "'eco'", "'.'", "'+='", "'-='", "'*='", "'/='", "'%='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'==='", "'!=='", "'instanceof'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'++'", "'--'", "'::'", "'?.'", "'#'", "'|'", "';'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'extends'", "'static'", "'import'", "'extension'", "'super'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'synchronized'", "'catch'", "'?'", "'&'"
    };
    public static final int RULE_HEX=6;
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalSpeADLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSpeADLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSpeADLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSpeADL.g"; }



     	private SpeADLGrammarAccess grammarAccess;
     	
        public InternalSpeADLParser(TokenStream input, SpeADLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected SpeADLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalSpeADL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSpeADL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalSpeADL.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSpeADL.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleNamespace ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_elements_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:79:28: ( ( ( (lv_imports_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleNamespace ) )* ) )
            // InternalSpeADL.g:80:1: ( ( (lv_imports_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleNamespace ) )* )
            {
            // InternalSpeADL.g:80:1: ( ( (lv_imports_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleNamespace ) )* )
            // InternalSpeADL.g:80:2: ( (lv_imports_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleNamespace ) )*
            {
            // InternalSpeADL.g:80:2: ( (lv_imports_0_0= ruleXImportSection ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==83) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSpeADL.g:81:1: (lv_imports_0_0= ruleXImportSection )
                    {
                    // InternalSpeADL.g:81:1: (lv_imports_0_0= ruleXImportSection )
                    // InternalSpeADL.g:82:3: lv_imports_0_0= ruleXImportSection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getImportsXImportSectionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_3);
                    lv_imports_0_0=ruleXImportSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"imports",
                              		lv_imports_0_0, 
                              		"org.eclipse.xtext.xbase.Xtype.XImportSection");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSpeADL.g:98:3: ( (lv_elements_1_0= ruleNamespace ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSpeADL.g:99:1: (lv_elements_1_0= ruleNamespace )
            	    {
            	    // InternalSpeADL.g:99:1: (lv_elements_1_0= ruleNamespace )
            	    // InternalSpeADL.g:100:3: lv_elements_1_0= ruleNamespace
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getElementsNamespaceParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_elements_1_0=ruleNamespace();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_1_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.Namespace");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleNamespace"
    // InternalSpeADL.g:124:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalSpeADL.g:125:2: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalSpeADL.g:126:2: iv_ruleNamespace= ruleNamespace EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamespaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamespace; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalSpeADL.g:133:1: ruleNamespace returns [EObject current=null] : (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleModelElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:136:28: ( (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleModelElement ) )* otherlv_4= '}' ) )
            // InternalSpeADL.g:137:1: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleModelElement ) )* otherlv_4= '}' )
            {
            // InternalSpeADL.g:137:1: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleModelElement ) )* otherlv_4= '}' )
            // InternalSpeADL.g:137:3: otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleModelElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNamespaceAccess().getNamespaceKeyword_0());
                  
            }
            // InternalSpeADL.g:141:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSpeADL.g:142:1: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSpeADL.g:142:1: (lv_name_1_0= ruleQualifiedName )
            // InternalSpeADL.g:143:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xbase.QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalSpeADL.g:163:1: ( (lv_elements_3_0= ruleModelElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13||LA3_0==17||LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSpeADL.g:164:1: (lv_elements_3_0= ruleModelElement )
            	    {
            	    // InternalSpeADL.g:164:1: (lv_elements_3_0= ruleModelElement )
            	    // InternalSpeADL.g:165:3: lv_elements_3_0= ruleModelElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNamespaceAccess().getElementsModelElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_elements_3_0=ruleModelElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.ModelElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleModelElement"
    // InternalSpeADL.g:193:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // InternalSpeADL.g:194:2: (iv_ruleModelElement= ruleModelElement EOF )
            // InternalSpeADL.g:195:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // InternalSpeADL.g:202:1: ruleModelElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Element_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:205:28: ( (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) )
            // InternalSpeADL.g:206:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
            {
            // InternalSpeADL.g:206:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            else if ( (LA4_0==17||LA4_0==22) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSpeADL.g:207:5: this_Namespace_0= ruleNamespace
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getModelElementAccess().getNamespaceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Namespace_0=ruleNamespace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Namespace_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:217:5: this_Element_1= ruleElement
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getModelElementAccess().getElementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Element_1=ruleElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Element_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleElement"
    // InternalSpeADL.g:233:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalSpeADL.g:234:2: (iv_ruleElement= ruleElement EOF )
            // InternalSpeADL.g:235:2: iv_ruleElement= ruleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalSpeADL.g:242:1: ruleElement returns [EObject current=null] : (this_Ecosystem_0= ruleEcosystem | this_Component_1= ruleComponent ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Ecosystem_0 = null;

        EObject this_Component_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:245:28: ( (this_Ecosystem_0= ruleEcosystem | this_Component_1= ruleComponent ) )
            // InternalSpeADL.g:246:1: (this_Ecosystem_0= ruleEcosystem | this_Component_1= ruleComponent )
            {
            // InternalSpeADL.g:246:1: (this_Ecosystem_0= ruleEcosystem | this_Component_1= ruleComponent )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==22) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSpeADL.g:247:5: this_Ecosystem_0= ruleEcosystem
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getElementAccess().getEcosystemParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Ecosystem_0=ruleEcosystem();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Ecosystem_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:257:5: this_Component_1= ruleComponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getElementAccess().getComponentParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Component_1=ruleComponent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Component_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRulePort"
    // InternalSpeADL.g:277:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalSpeADL.g:278:2: (iv_rulePort= rulePort EOF )
            // InternalSpeADL.g:279:2: iv_rulePort= rulePort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePort=rulePort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // InternalSpeADL.g:286:1: rulePort returns [EObject current=null] : (this_ProvidedPort_0= ruleProvidedPort | this_RequiredPort_1= ruleRequiredPort ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        EObject this_ProvidedPort_0 = null;

        EObject this_RequiredPort_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:289:28: ( (this_ProvidedPort_0= ruleProvidedPort | this_RequiredPort_1= ruleRequiredPort ) )
            // InternalSpeADL.g:290:1: (this_ProvidedPort_0= ruleProvidedPort | this_RequiredPort_1= ruleRequiredPort )
            {
            // InternalSpeADL.g:290:1: (this_ProvidedPort_0= ruleProvidedPort | this_RequiredPort_1= ruleRequiredPort )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            else if ( (LA6_0==28) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSpeADL.g:291:5: this_ProvidedPort_0= ruleProvidedPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getProvidedPortParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ProvidedPort_0=ruleProvidedPort();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProvidedPort_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:301:5: this_RequiredPort_1= ruleRequiredPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getRequiredPortParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RequiredPort_1=ruleRequiredPort();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RequiredPort_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRulePart"
    // InternalSpeADL.g:323:1: entryRulePart returns [EObject current=null] : iv_rulePart= rulePart EOF ;
    public final EObject entryRulePart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePart = null;


        try {
            // InternalSpeADL.g:324:2: (iv_rulePart= rulePart EOF )
            // InternalSpeADL.g:325:2: iv_rulePart= rulePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePart=rulePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePart"


    // $ANTLR start "rulePart"
    // InternalSpeADL.g:332:1: rulePart returns [EObject current=null] : (this_ComponentPart_0= ruleComponentPart | this_SpeciesPart_1= ruleSpeciesPart ) ;
    public final EObject rulePart() throws RecognitionException {
        EObject current = null;

        EObject this_ComponentPart_0 = null;

        EObject this_SpeciesPart_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:335:28: ( (this_ComponentPart_0= ruleComponentPart | this_SpeciesPart_1= ruleSpeciesPart ) )
            // InternalSpeADL.g:336:1: (this_ComponentPart_0= ruleComponentPart | this_SpeciesPart_1= ruleSpeciesPart )
            {
            // InternalSpeADL.g:336:1: (this_ComponentPart_0= ruleComponentPart | this_SpeciesPart_1= ruleSpeciesPart )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            else if ( (LA7_0==30) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSpeADL.g:337:5: this_ComponentPart_0= ruleComponentPart
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartAccess().getComponentPartParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ComponentPart_0=ruleComponentPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ComponentPart_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:347:5: this_SpeciesPart_1= ruleSpeciesPart
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartAccess().getSpeciesPartParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SpeciesPart_1=ruleSpeciesPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SpeciesPart_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePart"


    // $ANTLR start "entryRuleFeature"
    // InternalSpeADL.g:365:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalSpeADL.g:366:2: (iv_ruleFeature= ruleFeature EOF )
            // InternalSpeADL.g:367:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalSpeADL.g:374:1: ruleFeature returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_parameterType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:377:28: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ) )
            // InternalSpeADL.g:378:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) )
            {
            // InternalSpeADL.g:378:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) )
            // InternalSpeADL.g:378:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_parameterType_2_0= ruleJvmTypeReference ) )
            {
            // InternalSpeADL.g:378:2: ( (lv_name_0_0= ruleValidID ) )
            // InternalSpeADL.g:379:1: (lv_name_0_0= ruleValidID )
            {
            // InternalSpeADL.g:379:1: (lv_name_0_0= ruleValidID )
            // InternalSpeADL.g:380:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureAccess().getNameValidIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_7);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFeatureRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getColonKeyword_1());
                  
            }
            // InternalSpeADL.g:400:1: ( (lv_parameterType_2_0= ruleJvmTypeReference ) )
            // InternalSpeADL.g:401:1: (lv_parameterType_2_0= ruleJvmTypeReference )
            {
            // InternalSpeADL.g:401:1: (lv_parameterType_2_0= ruleJvmTypeReference )
            // InternalSpeADL.g:402:3: lv_parameterType_2_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureAccess().getParameterTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_parameterType_2_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFeatureRule());
              	        }
                     		set(
                     			current, 
                     			"parameterType",
                      		lv_parameterType_2_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleEcosystem"
    // InternalSpeADL.g:426:1: entryRuleEcosystem returns [EObject current=null] : iv_ruleEcosystem= ruleEcosystem EOF ;
    public final EObject entryRuleEcosystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEcosystem = null;


        try {
            // InternalSpeADL.g:427:2: (iv_ruleEcosystem= ruleEcosystem EOF )
            // InternalSpeADL.g:428:2: iv_ruleEcosystem= ruleEcosystem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEcosystemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEcosystem=ruleEcosystem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEcosystem; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEcosystem"


    // $ANTLR start "ruleEcosystem"
    // InternalSpeADL.g:435:1: ruleEcosystem returns [EObject current=null] : (otherlv_0= 'ecosystem' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) | ( (lv_species_13_0= ruleSpecies ) ) )* otherlv_14= '}' ) ;
    public final EObject ruleEcosystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_specializes_8_0 = null;

        EObject lv_provides_10_0 = null;

        EObject lv_requires_11_0 = null;

        EObject lv_parts_12_0 = null;

        EObject lv_species_13_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:438:28: ( (otherlv_0= 'ecosystem' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) | ( (lv_species_13_0= ruleSpecies ) ) )* otherlv_14= '}' ) )
            // InternalSpeADL.g:439:1: (otherlv_0= 'ecosystem' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) | ( (lv_species_13_0= ruleSpecies ) ) )* otherlv_14= '}' )
            {
            // InternalSpeADL.g:439:1: (otherlv_0= 'ecosystem' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) | ( (lv_species_13_0= ruleSpecies ) ) )* otherlv_14= '}' )
            // InternalSpeADL.g:439:3: otherlv_0= 'ecosystem' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) | ( (lv_species_13_0= ruleSpecies ) ) )* otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEcosystemAccess().getEcosystemKeyword_0());
                  
            }
            // InternalSpeADL.g:443:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:444:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:444:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:445:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEcosystemAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:461:2: (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSpeADL.g:461:4: otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEcosystemAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // InternalSpeADL.g:465:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    // InternalSpeADL.g:466:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    {
                    // InternalSpeADL.g:466:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    // InternalSpeADL.g:467:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEcosystemAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_typeParameters_3_0=ruleJvmTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
                      	        }
                             		add(
                             			current, 
                             			"typeParameters",
                              		lv_typeParameters_3_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:483:2: (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==19) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalSpeADL.g:483:4: otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getEcosystemAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:487:1: ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) )
                    	    // InternalSpeADL.g:488:1: (lv_typeParameters_5_0= ruleJvmTypeParameter )
                    	    {
                    	    // InternalSpeADL.g:488:1: (lv_typeParameters_5_0= ruleJvmTypeParameter )
                    	    // InternalSpeADL.g:489:3: lv_typeParameters_5_0= ruleJvmTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEcosystemAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_typeParameters_5_0=ruleJvmTypeParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeParameters",
                    	              		lv_typeParameters_5_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getEcosystemAccess().getRightSquareBracketKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:509:3: (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSpeADL.g:509:5: otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEcosystemAccess().getSpecializesKeyword_3_0());
                          
                    }
                    // InternalSpeADL.g:513:1: ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) )
                    // InternalSpeADL.g:514:1: (lv_specializes_8_0= ruleJvmParameterizedTypeReference )
                    {
                    // InternalSpeADL.g:514:1: (lv_specializes_8_0= ruleJvmParameterizedTypeReference )
                    // InternalSpeADL.g:515:3: lv_specializes_8_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEcosystemAccess().getSpecializesJvmParameterizedTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
                    lv_specializes_8_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
                      	        }
                             		set(
                             			current, 
                             			"specializes",
                              		lv_specializes_8_0, 
                              		"fr.irit.smac.may.speadl.SpeADL.JvmParameterizedTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getEcosystemAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalSpeADL.g:535:1: ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) | ( (lv_species_13_0= ruleSpecies ) ) )*
            loop11:
            do {
                int alt11=5;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt11=1;
                    }
                    break;
                case 28:
                    {
                    alt11=2;
                    }
                    break;
                case 29:
                    {
                    alt11=3;
                    }
                    break;
                case 23:
                    {
                    alt11=4;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // InternalSpeADL.g:535:2: ( (lv_provides_10_0= ruleProvidedPort ) )
            	    {
            	    // InternalSpeADL.g:535:2: ( (lv_provides_10_0= ruleProvidedPort ) )
            	    // InternalSpeADL.g:536:1: (lv_provides_10_0= ruleProvidedPort )
            	    {
            	    // InternalSpeADL.g:536:1: (lv_provides_10_0= ruleProvidedPort )
            	    // InternalSpeADL.g:537:3: lv_provides_10_0= ruleProvidedPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEcosystemAccess().getProvidesProvidedPortParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_provides_10_0=ruleProvidedPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"provides",
            	              		lv_provides_10_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.ProvidedPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpeADL.g:554:6: ( (lv_requires_11_0= ruleRequiredPort ) )
            	    {
            	    // InternalSpeADL.g:554:6: ( (lv_requires_11_0= ruleRequiredPort ) )
            	    // InternalSpeADL.g:555:1: (lv_requires_11_0= ruleRequiredPort )
            	    {
            	    // InternalSpeADL.g:555:1: (lv_requires_11_0= ruleRequiredPort )
            	    // InternalSpeADL.g:556:3: lv_requires_11_0= ruleRequiredPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEcosystemAccess().getRequiresRequiredPortParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_requires_11_0=ruleRequiredPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_11_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.RequiredPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSpeADL.g:573:6: ( (lv_parts_12_0= ruleComponentPart ) )
            	    {
            	    // InternalSpeADL.g:573:6: ( (lv_parts_12_0= ruleComponentPart ) )
            	    // InternalSpeADL.g:574:1: (lv_parts_12_0= ruleComponentPart )
            	    {
            	    // InternalSpeADL.g:574:1: (lv_parts_12_0= ruleComponentPart )
            	    // InternalSpeADL.g:575:3: lv_parts_12_0= ruleComponentPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEcosystemAccess().getPartsComponentPartParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_parts_12_0=ruleComponentPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_12_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.ComponentPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSpeADL.g:592:6: ( (lv_species_13_0= ruleSpecies ) )
            	    {
            	    // InternalSpeADL.g:592:6: ( (lv_species_13_0= ruleSpecies ) )
            	    // InternalSpeADL.g:593:1: (lv_species_13_0= ruleSpecies )
            	    {
            	    // InternalSpeADL.g:593:1: (lv_species_13_0= ruleSpecies )
            	    // InternalSpeADL.g:594:3: lv_species_13_0= ruleSpecies
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEcosystemAccess().getSpeciesSpeciesParserRuleCall_5_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_species_13_0=ruleSpecies();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEcosystemRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"species",
            	              		lv_species_13_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.Species");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_14=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getEcosystemAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEcosystem"


    // $ANTLR start "entryRuleComponent"
    // InternalSpeADL.g:622:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalSpeADL.g:623:2: (iv_ruleComponent= ruleComponent EOF )
            // InternalSpeADL.g:624:2: iv_ruleComponent= ruleComponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalSpeADL.g:631:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) )* otherlv_13= '}' ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_specializes_8_0 = null;

        EObject lv_provides_10_0 = null;

        EObject lv_requires_11_0 = null;

        EObject lv_parts_12_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:634:28: ( (otherlv_0= 'component' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) )* otherlv_13= '}' ) )
            // InternalSpeADL.g:635:1: (otherlv_0= 'component' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) )* otherlv_13= '}' )
            {
            // InternalSpeADL.g:635:1: (otherlv_0= 'component' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) )* otherlv_13= '}' )
            // InternalSpeADL.g:635:3: otherlv_0= 'component' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )? (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_9= '{' ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
                  
            }
            // InternalSpeADL.g:639:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:640:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:640:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:641:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:657:2: (otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSpeADL.g:657:4: otherlv_2= '[' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // InternalSpeADL.g:661:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    // InternalSpeADL.g:662:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    {
                    // InternalSpeADL.g:662:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    // InternalSpeADL.g:663:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_typeParameters_3_0=ruleJvmTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getComponentRule());
                      	        }
                             		add(
                             			current, 
                             			"typeParameters",
                              		lv_typeParameters_3_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:679:2: (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==19) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSpeADL.g:679:4: otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getComponentAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:683:1: ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) )
                    	    // InternalSpeADL.g:684:1: (lv_typeParameters_5_0= ruleJvmTypeParameter )
                    	    {
                    	    // InternalSpeADL.g:684:1: (lv_typeParameters_5_0= ruleJvmTypeParameter )
                    	    // InternalSpeADL.g:685:3: lv_typeParameters_5_0= ruleJvmTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_typeParameters_5_0=ruleJvmTypeParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeParameters",
                    	              		lv_typeParameters_5_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getComponentAccess().getRightSquareBracketKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:705:3: (otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalSpeADL.g:705:5: otherlv_7= 'specializes' ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getComponentAccess().getSpecializesKeyword_3_0());
                          
                    }
                    // InternalSpeADL.g:709:1: ( (lv_specializes_8_0= ruleJvmParameterizedTypeReference ) )
                    // InternalSpeADL.g:710:1: (lv_specializes_8_0= ruleJvmParameterizedTypeReference )
                    {
                    // InternalSpeADL.g:710:1: (lv_specializes_8_0= ruleJvmParameterizedTypeReference )
                    // InternalSpeADL.g:711:3: lv_specializes_8_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentAccess().getSpecializesJvmParameterizedTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
                    lv_specializes_8_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getComponentRule());
                      	        }
                             		set(
                             			current, 
                             			"specializes",
                              		lv_specializes_8_0, 
                              		"fr.irit.smac.may.speadl.SpeADL.JvmParameterizedTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalSpeADL.g:731:1: ( ( (lv_provides_10_0= ruleProvidedPort ) ) | ( (lv_requires_11_0= ruleRequiredPort ) ) | ( (lv_parts_12_0= ruleComponentPart ) ) )*
            loop15:
            do {
                int alt15=4;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt15=1;
                    }
                    break;
                case 28:
                    {
                    alt15=2;
                    }
                    break;
                case 29:
                    {
                    alt15=3;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // InternalSpeADL.g:731:2: ( (lv_provides_10_0= ruleProvidedPort ) )
            	    {
            	    // InternalSpeADL.g:731:2: ( (lv_provides_10_0= ruleProvidedPort ) )
            	    // InternalSpeADL.g:732:1: (lv_provides_10_0= ruleProvidedPort )
            	    {
            	    // InternalSpeADL.g:732:1: (lv_provides_10_0= ruleProvidedPort )
            	    // InternalSpeADL.g:733:3: lv_provides_10_0= ruleProvidedPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComponentAccess().getProvidesProvidedPortParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_provides_10_0=ruleProvidedPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"provides",
            	              		lv_provides_10_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.ProvidedPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpeADL.g:750:6: ( (lv_requires_11_0= ruleRequiredPort ) )
            	    {
            	    // InternalSpeADL.g:750:6: ( (lv_requires_11_0= ruleRequiredPort ) )
            	    // InternalSpeADL.g:751:1: (lv_requires_11_0= ruleRequiredPort )
            	    {
            	    // InternalSpeADL.g:751:1: (lv_requires_11_0= ruleRequiredPort )
            	    // InternalSpeADL.g:752:3: lv_requires_11_0= ruleRequiredPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComponentAccess().getRequiresRequiredPortParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_requires_11_0=ruleRequiredPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_11_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.RequiredPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSpeADL.g:769:6: ( (lv_parts_12_0= ruleComponentPart ) )
            	    {
            	    // InternalSpeADL.g:769:6: ( (lv_parts_12_0= ruleComponentPart ) )
            	    // InternalSpeADL.g:770:1: (lv_parts_12_0= ruleComponentPart )
            	    {
            	    // InternalSpeADL.g:770:1: (lv_parts_12_0= ruleComponentPart )
            	    // InternalSpeADL.g:771:3: lv_parts_12_0= ruleComponentPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComponentAccess().getPartsComponentPartParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_parts_12_0=ruleComponentPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_12_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.ComponentPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_13=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleSpecies"
    // InternalSpeADL.g:799:1: entryRuleSpecies returns [EObject current=null] : iv_ruleSpecies= ruleSpecies EOF ;
    public final EObject entryRuleSpecies() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecies = null;


        try {
            // InternalSpeADL.g:800:2: (iv_ruleSpecies= ruleSpecies EOF )
            // InternalSpeADL.g:801:2: iv_ruleSpecies= ruleSpecies EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpeciesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpecies=ruleSpecies();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecies; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecies"


    // $ANTLR start "ruleSpecies"
    // InternalSpeADL.g:808:1: ruleSpecies returns [EObject current=null] : (otherlv_0= 'species' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_provides_8_0= ruleProvidedPort ) ) | ( (lv_requires_9_0= ruleRequiredPort ) ) | ( (lv_parts_10_0= rulePart ) ) )* otherlv_11= '}' ) ;
    public final EObject ruleSpecies() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_provides_8_0 = null;

        EObject lv_requires_9_0 = null;

        EObject lv_parts_10_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:811:28: ( (otherlv_0= 'species' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_provides_8_0= ruleProvidedPort ) ) | ( (lv_requires_9_0= ruleRequiredPort ) ) | ( (lv_parts_10_0= rulePart ) ) )* otherlv_11= '}' ) )
            // InternalSpeADL.g:812:1: (otherlv_0= 'species' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_provides_8_0= ruleProvidedPort ) ) | ( (lv_requires_9_0= ruleRequiredPort ) ) | ( (lv_parts_10_0= rulePart ) ) )* otherlv_11= '}' )
            {
            // InternalSpeADL.g:812:1: (otherlv_0= 'species' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_provides_8_0= ruleProvidedPort ) ) | ( (lv_requires_9_0= ruleRequiredPort ) ) | ( (lv_parts_10_0= rulePart ) ) )* otherlv_11= '}' )
            // InternalSpeADL.g:812:3: otherlv_0= 'species' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_provides_8_0= ruleProvidedPort ) ) | ( (lv_requires_9_0= ruleRequiredPort ) ) | ( (lv_parts_10_0= rulePart ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSpeciesAccess().getSpeciesKeyword_0());
                  
            }
            // InternalSpeADL.g:816:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:817:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:817:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:818:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSpeciesAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSpeciesRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:834:2: (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalSpeADL.g:834:4: otherlv_2= '(' ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )? otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSpeciesAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // InternalSpeADL.g:838:1: ( ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_ID) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalSpeADL.g:838:2: ( (lv_parameters_3_0= ruleFeature ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )*
                            {
                            // InternalSpeADL.g:838:2: ( (lv_parameters_3_0= ruleFeature ) )
                            // InternalSpeADL.g:839:1: (lv_parameters_3_0= ruleFeature )
                            {
                            // InternalSpeADL.g:839:1: (lv_parameters_3_0= ruleFeature )
                            // InternalSpeADL.g:840:3: lv_parameters_3_0= ruleFeature
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getSpeciesAccess().getParametersFeatureParserRuleCall_2_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_15);
                            lv_parameters_3_0=ruleFeature();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getSpeciesRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"parameters",
                                      		lv_parameters_3_0, 
                                      		"fr.irit.smac.may.speadl.SpeADL.Feature");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpeADL.g:856:2: (otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) ) )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==19) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // InternalSpeADL.g:856:4: otherlv_4= ',' ( (lv_parameters_5_0= ruleFeature ) )
                            	    {
                            	    otherlv_4=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_4, grammarAccess.getSpeciesAccess().getCommaKeyword_2_1_1_0());
                            	          
                            	    }
                            	    // InternalSpeADL.g:860:1: ( (lv_parameters_5_0= ruleFeature ) )
                            	    // InternalSpeADL.g:861:1: (lv_parameters_5_0= ruleFeature )
                            	    {
                            	    // InternalSpeADL.g:861:1: (lv_parameters_5_0= ruleFeature )
                            	    // InternalSpeADL.g:862:3: lv_parameters_5_0= ruleFeature
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSpeciesAccess().getParametersFeatureParserRuleCall_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_15);
                            	    lv_parameters_5_0=ruleFeature();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSpeciesRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"parameters",
                            	              		lv_parameters_5_0, 
                            	              		"fr.irit.smac.may.speadl.SpeADL.Feature");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSpeciesAccess().getRightParenthesisKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getSpeciesAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // InternalSpeADL.g:886:1: ( ( (lv_provides_8_0= ruleProvidedPort ) ) | ( (lv_requires_9_0= ruleRequiredPort ) ) | ( (lv_parts_10_0= rulePart ) ) )*
            loop19:
            do {
                int alt19=4;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt19=1;
                    }
                    break;
                case 28:
                    {
                    alt19=2;
                    }
                    break;
                case 29:
                case 30:
                    {
                    alt19=3;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // InternalSpeADL.g:886:2: ( (lv_provides_8_0= ruleProvidedPort ) )
            	    {
            	    // InternalSpeADL.g:886:2: ( (lv_provides_8_0= ruleProvidedPort ) )
            	    // InternalSpeADL.g:887:1: (lv_provides_8_0= ruleProvidedPort )
            	    {
            	    // InternalSpeADL.g:887:1: (lv_provides_8_0= ruleProvidedPort )
            	    // InternalSpeADL.g:888:3: lv_provides_8_0= ruleProvidedPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpeciesAccess().getProvidesProvidedPortParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_provides_8_0=ruleProvidedPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpeciesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"provides",
            	              		lv_provides_8_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.ProvidedPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpeADL.g:905:6: ( (lv_requires_9_0= ruleRequiredPort ) )
            	    {
            	    // InternalSpeADL.g:905:6: ( (lv_requires_9_0= ruleRequiredPort ) )
            	    // InternalSpeADL.g:906:1: (lv_requires_9_0= ruleRequiredPort )
            	    {
            	    // InternalSpeADL.g:906:1: (lv_requires_9_0= ruleRequiredPort )
            	    // InternalSpeADL.g:907:3: lv_requires_9_0= ruleRequiredPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpeciesAccess().getRequiresRequiredPortParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_requires_9_0=ruleRequiredPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpeciesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_9_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.RequiredPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSpeADL.g:924:6: ( (lv_parts_10_0= rulePart ) )
            	    {
            	    // InternalSpeADL.g:924:6: ( (lv_parts_10_0= rulePart ) )
            	    // InternalSpeADL.g:925:1: (lv_parts_10_0= rulePart )
            	    {
            	    // InternalSpeADL.g:925:1: (lv_parts_10_0= rulePart )
            	    // InternalSpeADL.g:926:3: lv_parts_10_0= rulePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpeciesAccess().getPartsPartParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_parts_10_0=rulePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpeciesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_10_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.Part");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_11=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getSpeciesAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecies"


    // $ANTLR start "entryRuleProvidedPort"
    // InternalSpeADL.g:954:1: entryRuleProvidedPort returns [EObject current=null] : iv_ruleProvidedPort= ruleProvidedPort EOF ;
    public final EObject entryRuleProvidedPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProvidedPort = null;


        try {
            // InternalSpeADL.g:955:2: (iv_ruleProvidedPort= ruleProvidedPort EOF )
            // InternalSpeADL.g:956:2: iv_ruleProvidedPort= ruleProvidedPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProvidedPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProvidedPort=ruleProvidedPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProvidedPort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProvidedPort"


    // $ANTLR start "ruleProvidedPort"
    // InternalSpeADL.g:963:1: ruleProvidedPort returns [EObject current=null] : (otherlv_0= 'provides' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) ) )? ) ;
    public final EObject ruleProvidedPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeReference_3_0 = null;

        EObject lv_bound_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:966:28: ( (otherlv_0= 'provides' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) ) )? ) )
            // InternalSpeADL.g:967:1: (otherlv_0= 'provides' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) ) )? )
            {
            // InternalSpeADL.g:967:1: (otherlv_0= 'provides' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) ) )? )
            // InternalSpeADL.g:967:3: otherlv_0= 'provides' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProvidedPortAccess().getProvidesKeyword_0());
                  
            }
            // InternalSpeADL.g:971:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:972:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:972:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:973:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProvidedPortAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProvidedPortRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProvidedPortAccess().getColonKeyword_2());
                  
            }
            // InternalSpeADL.g:993:1: ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) )
            // InternalSpeADL.g:994:1: (lv_typeReference_3_0= ruleJvmParameterizedTypeReference )
            {
            // InternalSpeADL.g:994:1: (lv_typeReference_3_0= ruleJvmParameterizedTypeReference )
            // InternalSpeADL.g:995:3: lv_typeReference_3_0= ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProvidedPortAccess().getTypeReferenceJvmParameterizedTypeReferenceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_17);
            lv_typeReference_3_0=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProvidedPortRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_3_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmParameterizedTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:1011:2: (otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSpeADL.g:1011:4: otherlv_4= '=' ( (lv_bound_5_0= rulePortRef ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getProvidedPortAccess().getEqualsSignKeyword_4_0());
                          
                    }
                    // InternalSpeADL.g:1015:1: ( (lv_bound_5_0= rulePortRef ) )
                    // InternalSpeADL.g:1016:1: (lv_bound_5_0= rulePortRef )
                    {
                    // InternalSpeADL.g:1016:1: (lv_bound_5_0= rulePortRef )
                    // InternalSpeADL.g:1017:3: lv_bound_5_0= rulePortRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProvidedPortAccess().getBoundPortRefParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_bound_5_0=rulePortRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProvidedPortRule());
                      	        }
                             		set(
                             			current, 
                             			"bound",
                              		lv_bound_5_0, 
                              		"fr.irit.smac.may.speadl.SpeADL.PortRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProvidedPort"


    // $ANTLR start "entryRuleRequiredPort"
    // InternalSpeADL.g:1041:1: entryRuleRequiredPort returns [EObject current=null] : iv_ruleRequiredPort= ruleRequiredPort EOF ;
    public final EObject entryRuleRequiredPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequiredPort = null;


        try {
            // InternalSpeADL.g:1042:2: (iv_ruleRequiredPort= ruleRequiredPort EOF )
            // InternalSpeADL.g:1043:2: iv_ruleRequiredPort= ruleRequiredPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequiredPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRequiredPort=ruleRequiredPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequiredPort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredPort"


    // $ANTLR start "ruleRequiredPort"
    // InternalSpeADL.g:1050:1: ruleRequiredPort returns [EObject current=null] : (otherlv_0= 'requires' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) ) ;
    public final EObject ruleRequiredPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeReference_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1053:28: ( (otherlv_0= 'requires' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) ) )
            // InternalSpeADL.g:1054:1: (otherlv_0= 'requires' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) )
            {
            // InternalSpeADL.g:1054:1: (otherlv_0= 'requires' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) ) )
            // InternalSpeADL.g:1054:3: otherlv_0= 'requires' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRequiredPortAccess().getRequiresKeyword_0());
                  
            }
            // InternalSpeADL.g:1058:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:1059:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:1059:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:1060:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRequiredPortAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRequiredPortRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRequiredPortAccess().getColonKeyword_2());
                  
            }
            // InternalSpeADL.g:1080:1: ( (lv_typeReference_3_0= ruleJvmParameterizedTypeReference ) )
            // InternalSpeADL.g:1081:1: (lv_typeReference_3_0= ruleJvmParameterizedTypeReference )
            {
            // InternalSpeADL.g:1081:1: (lv_typeReference_3_0= ruleJvmParameterizedTypeReference )
            // InternalSpeADL.g:1082:3: lv_typeReference_3_0= ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRequiredPortAccess().getTypeReferenceJvmParameterizedTypeReferenceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_3_0=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRequiredPortRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_3_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmParameterizedTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequiredPort"


    // $ANTLR start "entryRuleComponentPart"
    // InternalSpeADL.g:1106:1: entryRuleComponentPart returns [EObject current=null] : iv_ruleComponentPart= ruleComponentPart EOF ;
    public final EObject entryRuleComponentPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentPart = null;


        try {
            // InternalSpeADL.g:1107:2: (iv_ruleComponentPart= ruleComponentPart EOF )
            // InternalSpeADL.g:1108:2: iv_ruleComponentPart= ruleComponentPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComponentPart=ruleComponentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentPart"


    // $ANTLR start "ruleComponentPart"
    // InternalSpeADL.g:1115:1: ruleComponentPart returns [EObject current=null] : (otherlv_0= 'part' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_componentReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleComponentPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_componentReference_3_0 = null;

        EObject lv_bindings_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1118:28: ( (otherlv_0= 'part' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_componentReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? ) )
            // InternalSpeADL.g:1119:1: (otherlv_0= 'part' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_componentReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? )
            {
            // InternalSpeADL.g:1119:1: (otherlv_0= 'part' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_componentReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? )
            // InternalSpeADL.g:1119:3: otherlv_0= 'part' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_componentReference_3_0= ruleJvmParameterizedTypeReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentPartAccess().getPartKeyword_0());
                  
            }
            // InternalSpeADL.g:1123:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:1124:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:1124:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:1125:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentPartAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentPartRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getComponentPartAccess().getColonKeyword_2());
                  
            }
            // InternalSpeADL.g:1145:1: ( (lv_componentReference_3_0= ruleJvmParameterizedTypeReference ) )
            // InternalSpeADL.g:1146:1: (lv_componentReference_3_0= ruleJvmParameterizedTypeReference )
            {
            // InternalSpeADL.g:1146:1: (lv_componentReference_3_0= ruleJvmParameterizedTypeReference )
            // InternalSpeADL.g:1147:3: lv_componentReference_3_0= ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentPartAccess().getComponentReferenceJvmParameterizedTypeReferenceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_componentReference_3_0=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentPartRule());
              	        }
                     		set(
                     			current, 
                     			"componentReference",
                      		lv_componentReference_3_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmParameterizedTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:1163:2: (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==14) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSpeADL.g:1163:4: otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getComponentPartAccess().getLeftCurlyBracketKeyword_4_0());
                          
                    }
                    // InternalSpeADL.g:1167:1: ( (lv_bindings_5_0= ruleBinding ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==31) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalSpeADL.g:1168:1: (lv_bindings_5_0= ruleBinding )
                    	    {
                    	    // InternalSpeADL.g:1168:1: (lv_bindings_5_0= ruleBinding )
                    	    // InternalSpeADL.g:1169:3: lv_bindings_5_0= ruleBinding
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentPartAccess().getBindingsBindingParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_20);
                    	    lv_bindings_5_0=ruleBinding();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentPartRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"bindings",
                    	              		lv_bindings_5_0, 
                    	              		"fr.irit.smac.may.speadl.SpeADL.Binding");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getComponentPartAccess().getRightCurlyBracketKeyword_4_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentPart"


    // $ANTLR start "entryRuleSpeciesPart"
    // InternalSpeADL.g:1197:1: entryRuleSpeciesPart returns [EObject current=null] : iv_ruleSpeciesPart= ruleSpeciesPart EOF ;
    public final EObject entryRuleSpeciesPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpeciesPart = null;


        try {
            // InternalSpeADL.g:1198:2: (iv_ruleSpeciesPart= ruleSpeciesPart EOF )
            // InternalSpeADL.g:1199:2: iv_ruleSpeciesPart= ruleSpeciesPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpeciesPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpeciesPart=ruleSpeciesPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpeciesPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpeciesPart"


    // $ANTLR start "ruleSpeciesPart"
    // InternalSpeADL.g:1206:1: ruleSpeciesPart returns [EObject current=null] : (otherlv_0= 'use' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_speciesReference_3_0= ruleSpeciesReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleSpeciesPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_speciesReference_3_0 = null;

        EObject lv_bindings_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1209:28: ( (otherlv_0= 'use' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_speciesReference_3_0= ruleSpeciesReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? ) )
            // InternalSpeADL.g:1210:1: (otherlv_0= 'use' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_speciesReference_3_0= ruleSpeciesReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? )
            {
            // InternalSpeADL.g:1210:1: (otherlv_0= 'use' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_speciesReference_3_0= ruleSpeciesReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )? )
            // InternalSpeADL.g:1210:3: otherlv_0= 'use' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= ':' ( (lv_speciesReference_3_0= ruleSpeciesReference ) ) (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSpeciesPartAccess().getUseKeyword_0());
                  
            }
            // InternalSpeADL.g:1214:1: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:1215:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:1215:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:1216:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSpeciesPartAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSpeciesPartRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSpeciesPartAccess().getColonKeyword_2());
                  
            }
            // InternalSpeADL.g:1236:1: ( (lv_speciesReference_3_0= ruleSpeciesReference ) )
            // InternalSpeADL.g:1237:1: (lv_speciesReference_3_0= ruleSpeciesReference )
            {
            // InternalSpeADL.g:1237:1: (lv_speciesReference_3_0= ruleSpeciesReference )
            // InternalSpeADL.g:1238:3: lv_speciesReference_3_0= ruleSpeciesReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSpeciesPartAccess().getSpeciesReferenceSpeciesReferenceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_speciesReference_3_0=ruleSpeciesReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSpeciesPartRule());
              	        }
                     		set(
                     			current, 
                     			"speciesReference",
                      		lv_speciesReference_3_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.SpeciesReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:1254:2: (otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==14) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSpeADL.g:1254:4: otherlv_4= '{' ( (lv_bindings_5_0= ruleBinding ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSpeciesPartAccess().getLeftCurlyBracketKeyword_4_0());
                          
                    }
                    // InternalSpeADL.g:1258:1: ( (lv_bindings_5_0= ruleBinding ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==31) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalSpeADL.g:1259:1: (lv_bindings_5_0= ruleBinding )
                    	    {
                    	    // InternalSpeADL.g:1259:1: (lv_bindings_5_0= ruleBinding )
                    	    // InternalSpeADL.g:1260:3: lv_bindings_5_0= ruleBinding
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpeciesPartAccess().getBindingsBindingParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_20);
                    	    lv_bindings_5_0=ruleBinding();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpeciesPartRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"bindings",
                    	              		lv_bindings_5_0, 
                    	              		"fr.irit.smac.may.speadl.SpeADL.Binding");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSpeciesPartAccess().getRightCurlyBracketKeyword_4_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpeciesPart"


    // $ANTLR start "entryRuleBinding"
    // InternalSpeADL.g:1288:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalSpeADL.g:1289:2: (iv_ruleBinding= ruleBinding EOF )
            // InternalSpeADL.g:1290:2: iv_ruleBinding= ruleBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinding; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalSpeADL.g:1297:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'bind' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (lv_to_3_0= rulePortRef ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1300:28: ( (otherlv_0= 'bind' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (lv_to_3_0= rulePortRef ) ) ) )
            // InternalSpeADL.g:1301:1: (otherlv_0= 'bind' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (lv_to_3_0= rulePortRef ) ) )
            {
            // InternalSpeADL.g:1301:1: (otherlv_0= 'bind' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (lv_to_3_0= rulePortRef ) ) )
            // InternalSpeADL.g:1301:3: otherlv_0= 'bind' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (lv_to_3_0= rulePortRef ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindKeyword_0());
                  
            }
            // InternalSpeADL.g:1305:1: ( (otherlv_1= RULE_ID ) )
            // InternalSpeADL.g:1306:1: (otherlv_1= RULE_ID )
            {
            // InternalSpeADL.g:1306:1: (otherlv_1= RULE_ID )
            // InternalSpeADL.g:1307:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBindingRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getBindingAccess().getFromRequiredPortCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getToKeyword_2());
                  
            }
            // InternalSpeADL.g:1322:1: ( (lv_to_3_0= rulePortRef ) )
            // InternalSpeADL.g:1323:1: (lv_to_3_0= rulePortRef )
            {
            // InternalSpeADL.g:1323:1: (lv_to_3_0= rulePortRef )
            // InternalSpeADL.g:1324:3: lv_to_3_0= rulePortRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBindingAccess().getToPortRefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_to_3_0=rulePortRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBindingRule());
              	        }
                     		set(
                     			current, 
                     			"to",
                      		lv_to_3_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.PortRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRulePortRef"
    // InternalSpeADL.g:1348:1: entryRulePortRef returns [EObject current=null] : iv_rulePortRef= rulePortRef EOF ;
    public final EObject entryRulePortRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortRef = null;


        try {
            // InternalSpeADL.g:1349:2: (iv_rulePortRef= rulePortRef EOF )
            // InternalSpeADL.g:1350:2: iv_rulePortRef= rulePortRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePortRef=rulePortRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortRef"


    // $ANTLR start "rulePortRef"
    // InternalSpeADL.g:1357:1: rulePortRef returns [EObject current=null] : ( ( (lv_ecosystem_0_0= 'eco' ) )? ( ( ( ruleValidID ) ) otherlv_2= '.' )? ( ( ruleValidID ) ) ) ;
    public final EObject rulePortRef() throws RecognitionException {
        EObject current = null;

        Token lv_ecosystem_0_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:1360:28: ( ( ( (lv_ecosystem_0_0= 'eco' ) )? ( ( ( ruleValidID ) ) otherlv_2= '.' )? ( ( ruleValidID ) ) ) )
            // InternalSpeADL.g:1361:1: ( ( (lv_ecosystem_0_0= 'eco' ) )? ( ( ( ruleValidID ) ) otherlv_2= '.' )? ( ( ruleValidID ) ) )
            {
            // InternalSpeADL.g:1361:1: ( ( (lv_ecosystem_0_0= 'eco' ) )? ( ( ( ruleValidID ) ) otherlv_2= '.' )? ( ( ruleValidID ) ) )
            // InternalSpeADL.g:1361:2: ( (lv_ecosystem_0_0= 'eco' ) )? ( ( ( ruleValidID ) ) otherlv_2= '.' )? ( ( ruleValidID ) )
            {
            // InternalSpeADL.g:1361:2: ( (lv_ecosystem_0_0= 'eco' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalSpeADL.g:1362:1: (lv_ecosystem_0_0= 'eco' )
                    {
                    // InternalSpeADL.g:1362:1: (lv_ecosystem_0_0= 'eco' )
                    // InternalSpeADL.g:1363:3: lv_ecosystem_0_0= 'eco'
                    {
                    lv_ecosystem_0_0=(Token)match(input,33,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_ecosystem_0_0, grammarAccess.getPortRefAccess().getEcosystemEcoKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortRefRule());
                      	        }
                             		setWithLastConsumed(current, "ecosystem", true, "eco");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSpeADL.g:1376:3: ( ( ( ruleValidID ) ) otherlv_2= '.' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==34) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalSpeADL.g:1376:4: ( ( ruleValidID ) ) otherlv_2= '.'
                    {
                    // InternalSpeADL.g:1376:4: ( ( ruleValidID ) )
                    // InternalSpeADL.g:1377:1: ( ruleValidID )
                    {
                    // InternalSpeADL.g:1377:1: ( ruleValidID )
                    // InternalSpeADL.g:1378:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortRefRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPortRefAccess().getPartPartCrossReference_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_22);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPortRefAccess().getFullStopKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:1395:3: ( ( ruleValidID ) )
            // InternalSpeADL.g:1396:1: ( ruleValidID )
            {
            // InternalSpeADL.g:1396:1: ( ruleValidID )
            // InternalSpeADL.g:1397:3: ruleValidID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPortRefAccess().getPortPortCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortRef"


    // $ANTLR start "entryRuleSpeciesReference"
    // InternalSpeADL.g:1418:1: entryRuleSpeciesReference returns [EObject current=null] : iv_ruleSpeciesReference= ruleSpeciesReference EOF ;
    public final EObject entryRuleSpeciesReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpeciesReference = null;


        try {
            // InternalSpeADL.g:1419:2: (iv_ruleSpeciesReference= ruleSpeciesReference EOF )
            // InternalSpeADL.g:1420:2: iv_ruleSpeciesReference= ruleSpeciesReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpeciesReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpeciesReference=ruleSpeciesReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpeciesReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpeciesReference"


    // $ANTLR start "ruleSpeciesReference"
    // InternalSpeADL.g:1427:1: ruleSpeciesReference returns [EObject current=null] : ( ( ( ruleValidID ) ) otherlv_1= '.' ( ( ruleValidID ) ) (otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleSpeciesReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:1430:28: ( ( ( ( ruleValidID ) ) otherlv_1= '.' ( ( ruleValidID ) ) (otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')' )? ) )
            // InternalSpeADL.g:1431:1: ( ( ( ruleValidID ) ) otherlv_1= '.' ( ( ruleValidID ) ) (otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalSpeADL.g:1431:1: ( ( ( ruleValidID ) ) otherlv_1= '.' ( ( ruleValidID ) ) (otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')' )? )
            // InternalSpeADL.g:1431:2: ( ( ruleValidID ) ) otherlv_1= '.' ( ( ruleValidID ) ) (otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')' )?
            {
            // InternalSpeADL.g:1431:2: ( ( ruleValidID ) )
            // InternalSpeADL.g:1432:1: ( ruleValidID )
            {
            // InternalSpeADL.g:1432:1: ( ruleValidID )
            // InternalSpeADL.g:1433:3: ruleValidID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSpeciesReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSpeciesReferenceAccess().getPartComponentPartCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_22);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSpeciesReferenceAccess().getFullStopKeyword_1());
                  
            }
            // InternalSpeADL.g:1450:1: ( ( ruleValidID ) )
            // InternalSpeADL.g:1451:1: ( ruleValidID )
            {
            // InternalSpeADL.g:1451:1: ( ruleValidID )
            // InternalSpeADL.g:1452:3: ruleValidID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSpeciesReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSpeciesReferenceAccess().getSpeciesSpeciesCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:1465:2: (otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==24) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSpeADL.g:1465:4: otherlv_3= '(' ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSpeciesReferenceAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    // InternalSpeADL.g:1469:1: ( ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )* )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_ID) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalSpeADL.g:1469:2: ( ( ruleValidID ) ) (otherlv_5= ',' ( ( ruleValidID ) ) )*
                            {
                            // InternalSpeADL.g:1469:2: ( ( ruleValidID ) )
                            // InternalSpeADL.g:1470:1: ( ruleValidID )
                            {
                            // InternalSpeADL.g:1470:1: ( ruleValidID )
                            // InternalSpeADL.g:1471:3: ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getSpeciesReferenceRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getSpeciesReferenceAccess().getArgumentsFeatureCrossReference_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_15);
                            ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpeADL.g:1484:2: (otherlv_5= ',' ( ( ruleValidID ) ) )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==19) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // InternalSpeADL.g:1484:4: otherlv_5= ',' ( ( ruleValidID ) )
                            	    {
                            	    otherlv_5=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getSpeciesReferenceAccess().getCommaKeyword_3_1_1_0());
                            	          
                            	    }
                            	    // InternalSpeADL.g:1488:1: ( ( ruleValidID ) )
                            	    // InternalSpeADL.g:1489:1: ( ruleValidID )
                            	    {
                            	    // InternalSpeADL.g:1489:1: ( ruleValidID )
                            	    // InternalSpeADL.g:1490:3: ruleValidID
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      			if (current==null) {
                            	      	            current = createModelElement(grammarAccess.getSpeciesReferenceRule());
                            	      	        }
                            	              
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSpeciesReferenceAccess().getArgumentsFeatureCrossReference_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_15);
                            	    ruleValidID();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop27;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSpeciesReferenceAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpeciesReference"


    // $ANTLR start "entryRuleJvmTypeReference"
    // InternalSpeADL.g:1515:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // InternalSpeADL.g:1516:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // InternalSpeADL.g:1517:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // InternalSpeADL.g:1524:1: ruleJvmTypeReference returns [EObject current=null] : this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1527:28: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference )
            // InternalSpeADL.g:1529:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_JvmParameterizedTypeReference_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // InternalSpeADL.g:1545:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // InternalSpeADL.g:1546:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // InternalSpeADL.g:1547:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // InternalSpeADL.g:1554:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1557:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )? ) )
            // InternalSpeADL.g:1558:1: ( ( ( ruleQualifiedName ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )? )
            {
            // InternalSpeADL.g:1558:1: ( ( ( ruleQualifiedName ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )? )
            // InternalSpeADL.g:1558:2: ( ( ruleQualifiedName ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )?
            {
            // InternalSpeADL.g:1558:2: ( ( ruleQualifiedName ) )
            // InternalSpeADL.g:1559:1: ( ruleQualifiedName )
            {
            // InternalSpeADL.g:1559:1: ( ruleQualifiedName )
            // InternalSpeADL.g:1560:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:1573:2: ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )?
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // InternalSpeADL.g:1573:3: ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']'
                    {
                    // InternalSpeADL.g:1573:3: ( ( '[' )=>otherlv_1= '[' )
                    // InternalSpeADL.g:1573:4: ( '[' )=>otherlv_1= '['
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }

                    }

                    // InternalSpeADL.g:1578:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // InternalSpeADL.g:1579:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalSpeADL.g:1579:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // InternalSpeADL.g:1580:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:1596:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==19) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalSpeADL.g:1596:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:1600:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalSpeADL.g:1601:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalSpeADL.g:1601:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // InternalSpeADL.g:1602:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getRightSquareBracketKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleXExpression"
    // InternalSpeADL.g:1630:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // InternalSpeADL.g:1631:2: (iv_ruleXExpression= ruleXExpression EOF )
            // InternalSpeADL.g:1632:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // InternalSpeADL.g:1639:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1642:28: (this_XAssignment_0= ruleXAssignment )
            // InternalSpeADL.g:1644:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // InternalSpeADL.g:1660:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // InternalSpeADL.g:1661:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // InternalSpeADL.g:1662:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // InternalSpeADL.g:1669:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1672:28: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // InternalSpeADL.g:1673:1: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // InternalSpeADL.g:1673:1: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt33=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==27) ) {
                    alt33=1;
                }
                else if ( (LA33_1==EOF||(LA33_1>=RULE_ID && LA33_1<=RULE_DECIMAL)||(LA33_1>=14 && LA33_1<=16)||(LA33_1>=18 && LA33_1<=20)||(LA33_1>=24 && LA33_1<=25)||(LA33_1>=34 && LA33_1<=68)||(LA33_1>=70 && LA33_1<=96)) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==EOF||(LA33_2>=RULE_ID && LA33_2<=RULE_DECIMAL)||(LA33_2>=14 && LA33_2<=16)||(LA33_2>=18 && LA33_2<=20)||(LA33_2>=24 && LA33_2<=25)||(LA33_2>=34 && LA33_2<=68)||(LA33_2>=70 && LA33_2<=96)) ) {
                    alt33=2;
                }
                else if ( (LA33_2==27) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA33_3 = input.LA(2);

                if ( (LA33_3==EOF||(LA33_3>=RULE_ID && LA33_3<=RULE_DECIMAL)||(LA33_3>=14 && LA33_3<=16)||(LA33_3>=18 && LA33_3<=20)||(LA33_3>=24 && LA33_3<=25)||(LA33_3>=34 && LA33_3<=68)||(LA33_3>=70 && LA33_3<=96)) ) {
                    alt33=2;
                }
                else if ( (LA33_3==27) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 3, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                int LA33_4 = input.LA(2);

                if ( (LA33_4==27) ) {
                    alt33=1;
                }
                else if ( (LA33_4==EOF||(LA33_4>=RULE_ID && LA33_4<=RULE_DECIMAL)||(LA33_4>=14 && LA33_4<=16)||(LA33_4>=18 && LA33_4<=20)||(LA33_4>=24 && LA33_4<=25)||(LA33_4>=34 && LA33_4<=68)||(LA33_4>=70 && LA33_4<=96)) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 4, input);

                    throw nvae;
                }
                }
                break;
            case 84:
                {
                int LA33_5 = input.LA(2);

                if ( (LA33_5==EOF||(LA33_5>=RULE_ID && LA33_5<=RULE_DECIMAL)||(LA33_5>=14 && LA33_5<=16)||(LA33_5>=18 && LA33_5<=20)||(LA33_5>=24 && LA33_5<=25)||(LA33_5>=34 && LA33_5<=68)||(LA33_5>=70 && LA33_5<=96)) ) {
                    alt33=2;
                }
                else if ( (LA33_5==27) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 14:
            case 18:
            case 24:
            case 40:
            case 56:
            case 57:
            case 62:
            case 68:
            case 71:
            case 73:
            case 76:
            case 77:
            case 78:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 95:
                {
                alt33=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalSpeADL.g:1673:2: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // InternalSpeADL.g:1673:2: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // InternalSpeADL.g:1673:3: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // InternalSpeADL.g:1673:3: ()
                    // InternalSpeADL.g:1674:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpeADL.g:1679:2: ( ( ruleFeatureCallID ) )
                    // InternalSpeADL.g:1680:1: ( ruleFeatureCallID )
                    {
                    // InternalSpeADL.g:1680:1: ( ruleFeatureCallID )
                    // InternalSpeADL.g:1681:3: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_26);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_27);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpeADL.g:1702:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // InternalSpeADL.g:1703:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // InternalSpeADL.g:1703:1: (lv_value_3_0= ruleXAssignment )
                    // InternalSpeADL.g:1704:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:1721:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // InternalSpeADL.g:1721:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // InternalSpeADL.g:1722:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_28);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpeADL.g:1730:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt32=2;
                    alt32 = dfa32.predict(input);
                    switch (alt32) {
                        case 1 :
                            // InternalSpeADL.g:1730:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // InternalSpeADL.g:1730:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // InternalSpeADL.g:1730:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // InternalSpeADL.g:1735:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // InternalSpeADL.g:1735:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // InternalSpeADL.g:1735:7: ()
                            // InternalSpeADL.g:1736:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // InternalSpeADL.g:1741:2: ( ( ruleOpMultiAssign ) )
                            // InternalSpeADL.g:1742:1: ( ruleOpMultiAssign )
                            {
                            // InternalSpeADL.g:1742:1: ( ruleOpMultiAssign )
                            // InternalSpeADL.g:1743:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_27);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }

                            // InternalSpeADL.g:1756:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // InternalSpeADL.g:1757:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // InternalSpeADL.g:1757:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // InternalSpeADL.g:1758:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"rightOperand",
                                      		lv_rightOperand_7_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.XAssignment");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalSpeADL.g:1782:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // InternalSpeADL.g:1783:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // InternalSpeADL.g:1784:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // InternalSpeADL.g:1791:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:1794:28: (kw= '=' )
            // InternalSpeADL.g:1796:2: kw= '='
            {
            kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // InternalSpeADL.g:1809:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // InternalSpeADL.g:1810:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // InternalSpeADL.g:1811:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // InternalSpeADL.g:1818:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:1821:28: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // InternalSpeADL.g:1822:1: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // InternalSpeADL.g:1822:1: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            int alt35=7;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt35=1;
                }
                break;
            case 36:
                {
                alt35=2;
                }
                break;
            case 37:
                {
                alt35=3;
                }
                break;
            case 38:
                {
                alt35=4;
                }
                break;
            case 39:
                {
                alt35=5;
                }
                break;
            case 40:
                {
                alt35=6;
                }
                break;
            case 41:
                {
                alt35=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalSpeADL.g:1823:2: kw= '+='
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:1830:2: kw= '-='
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:1837:2: kw= '*='
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:1844:2: kw= '/='
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpeADL.g:1851:2: kw= '%='
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpeADL.g:1857:6: (kw= '<' kw= '<' kw= '=' )
                    {
                    // InternalSpeADL.g:1857:6: (kw= '<' kw= '<' kw= '=' )
                    // InternalSpeADL.g:1858:2: kw= '<' kw= '<' kw= '='
                    {
                    kw=(Token)match(input,40,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0()); 
                          
                    }
                    kw=(Token)match(input,40,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1()); 
                          
                    }
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSpeADL.g:1876:6: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // InternalSpeADL.g:1876:6: (kw= '>' (kw= '>' )? kw= '>=' )
                    // InternalSpeADL.g:1877:2: kw= '>' (kw= '>' )? kw= '>='
                    {
                    kw=(Token)match(input,41,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0()); 
                          
                    }
                    // InternalSpeADL.g:1882:1: (kw= '>' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==41) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalSpeADL.g:1883:2: kw= '>'
                            {
                            kw=(Token)match(input,41,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1()); 
                                  
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // InternalSpeADL.g:1902:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // InternalSpeADL.g:1903:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // InternalSpeADL.g:1904:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // InternalSpeADL.g:1911:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:1914:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // InternalSpeADL.g:1915:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // InternalSpeADL.g:1915:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // InternalSpeADL.g:1916:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_32);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:1924:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==43) ) {
                    int LA36_2 = input.LA(2);

                    if ( (synpred3_InternalSpeADL()) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // InternalSpeADL.g:1924:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // InternalSpeADL.g:1924:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // InternalSpeADL.g:1924:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // InternalSpeADL.g:1929:6: ( () ( ( ruleOpOr ) ) )
            	    // InternalSpeADL.g:1929:7: () ( ( ruleOpOr ) )
            	    {
            	    // InternalSpeADL.g:1929:7: ()
            	    // InternalSpeADL.g:1930:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:1935:2: ( ( ruleOpOr ) )
            	    // InternalSpeADL.g:1936:1: ( ruleOpOr )
            	    {
            	    // InternalSpeADL.g:1936:1: ( ruleOpOr )
            	    // InternalSpeADL.g:1937:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:1950:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // InternalSpeADL.g:1951:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // InternalSpeADL.g:1951:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // InternalSpeADL.g:1952:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalSpeADL.g:1976:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalSpeADL.g:1977:2: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalSpeADL.g:1978:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalSpeADL.g:1985:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:1988:28: (kw= '||' )
            // InternalSpeADL.g:1990:2: kw= '||'
            {
            kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // InternalSpeADL.g:2003:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // InternalSpeADL.g:2004:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // InternalSpeADL.g:2005:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // InternalSpeADL.g:2012:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2015:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // InternalSpeADL.g:2016:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // InternalSpeADL.g:2016:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // InternalSpeADL.g:2017:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_33);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2025:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==44) ) {
                    int LA37_2 = input.LA(2);

                    if ( (synpred4_InternalSpeADL()) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // InternalSpeADL.g:2025:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // InternalSpeADL.g:2025:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // InternalSpeADL.g:2025:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // InternalSpeADL.g:2030:6: ( () ( ( ruleOpAnd ) ) )
            	    // InternalSpeADL.g:2030:7: () ( ( ruleOpAnd ) )
            	    {
            	    // InternalSpeADL.g:2030:7: ()
            	    // InternalSpeADL.g:2031:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:2036:2: ( ( ruleOpAnd ) )
            	    // InternalSpeADL.g:2037:1: ( ruleOpAnd )
            	    {
            	    // InternalSpeADL.g:2037:1: ( ruleOpAnd )
            	    // InternalSpeADL.g:2038:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:2051:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // InternalSpeADL.g:2052:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // InternalSpeADL.g:2052:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // InternalSpeADL.g:2053:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalSpeADL.g:2077:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalSpeADL.g:2078:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalSpeADL.g:2079:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalSpeADL.g:2086:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2089:28: (kw= '&&' )
            // InternalSpeADL.g:2091:2: kw= '&&'
            {
            kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // InternalSpeADL.g:2104:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // InternalSpeADL.g:2105:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // InternalSpeADL.g:2106:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // InternalSpeADL.g:2113:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2116:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // InternalSpeADL.g:2117:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // InternalSpeADL.g:2117:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // InternalSpeADL.g:2118:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_34);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2126:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                switch ( input.LA(1) ) {
                case 45:
                    {
                    int LA38_2 = input.LA(2);

                    if ( (synpred5_InternalSpeADL()) ) {
                        alt38=1;
                    }


                    }
                    break;
                case 46:
                    {
                    int LA38_3 = input.LA(2);

                    if ( (synpred5_InternalSpeADL()) ) {
                        alt38=1;
                    }


                    }
                    break;
                case 47:
                    {
                    int LA38_4 = input.LA(2);

                    if ( (synpred5_InternalSpeADL()) ) {
                        alt38=1;
                    }


                    }
                    break;
                case 48:
                    {
                    int LA38_5 = input.LA(2);

                    if ( (synpred5_InternalSpeADL()) ) {
                        alt38=1;
                    }


                    }
                    break;

                }

                switch (alt38) {
            	case 1 :
            	    // InternalSpeADL.g:2126:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // InternalSpeADL.g:2126:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // InternalSpeADL.g:2126:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // InternalSpeADL.g:2131:6: ( () ( ( ruleOpEquality ) ) )
            	    // InternalSpeADL.g:2131:7: () ( ( ruleOpEquality ) )
            	    {
            	    // InternalSpeADL.g:2131:7: ()
            	    // InternalSpeADL.g:2132:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:2137:2: ( ( ruleOpEquality ) )
            	    // InternalSpeADL.g:2138:1: ( ruleOpEquality )
            	    {
            	    // InternalSpeADL.g:2138:1: ( ruleOpEquality )
            	    // InternalSpeADL.g:2139:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:2152:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // InternalSpeADL.g:2153:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // InternalSpeADL.g:2153:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // InternalSpeADL.g:2154:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalSpeADL.g:2178:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalSpeADL.g:2179:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalSpeADL.g:2180:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalSpeADL.g:2187:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2190:28: ( (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) )
            // InternalSpeADL.g:2191:1: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            {
            // InternalSpeADL.g:2191:1: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            int alt39=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt39=1;
                }
                break;
            case 46:
                {
                alt39=2;
                }
                break;
            case 47:
                {
                alt39=3;
                }
                break;
            case 48:
                {
                alt39=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalSpeADL.g:2192:2: kw= '=='
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2199:2: kw= '!='
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:2206:2: kw= '==='
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:2213:2: kw= '!=='
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // InternalSpeADL.g:2226:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // InternalSpeADL.g:2227:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // InternalSpeADL.g:2228:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // InternalSpeADL.g:2235:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2238:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // InternalSpeADL.g:2239:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // InternalSpeADL.g:2239:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // InternalSpeADL.g:2240:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_35);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2248:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop40:
            do {
                int alt40=3;
                switch ( input.LA(1) ) {
                case 40:
                    {
                    int LA40_2 = input.LA(2);

                    if ( (synpred7_InternalSpeADL()) ) {
                        alt40=2;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA40_3 = input.LA(2);

                    if ( (synpred7_InternalSpeADL()) ) {
                        alt40=2;
                    }


                    }
                    break;
                case 49:
                    {
                    int LA40_4 = input.LA(2);

                    if ( (synpred6_InternalSpeADL()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA40_5 = input.LA(2);

                    if ( (synpred7_InternalSpeADL()) ) {
                        alt40=2;
                    }


                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // InternalSpeADL.g:2248:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // InternalSpeADL.g:2248:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // InternalSpeADL.g:2248:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // InternalSpeADL.g:2248:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // InternalSpeADL.g:2248:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // InternalSpeADL.g:2250:5: ( () otherlv_2= 'instanceof' )
            	    // InternalSpeADL.g:2250:6: () otherlv_2= 'instanceof'
            	    {
            	    // InternalSpeADL.g:2250:6: ()
            	    // InternalSpeADL.g:2251:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpeADL.g:2260:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // InternalSpeADL.g:2261:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // InternalSpeADL.g:2261:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // InternalSpeADL.g:2262:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpeADL.g:2279:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // InternalSpeADL.g:2279:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // InternalSpeADL.g:2279:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // InternalSpeADL.g:2279:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // InternalSpeADL.g:2279:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // InternalSpeADL.g:2284:6: ( () ( ( ruleOpCompare ) ) )
            	    // InternalSpeADL.g:2284:7: () ( ( ruleOpCompare ) )
            	    {
            	    // InternalSpeADL.g:2284:7: ()
            	    // InternalSpeADL.g:2285:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:2290:2: ( ( ruleOpCompare ) )
            	    // InternalSpeADL.g:2291:1: ( ruleOpCompare )
            	    {
            	    // InternalSpeADL.g:2291:1: ( ruleOpCompare )
            	    // InternalSpeADL.g:2292:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:2305:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // InternalSpeADL.g:2306:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // InternalSpeADL.g:2306:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // InternalSpeADL.g:2307:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_6_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalSpeADL.g:2331:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalSpeADL.g:2332:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalSpeADL.g:2333:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalSpeADL.g:2340:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2343:28: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // InternalSpeADL.g:2344:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // InternalSpeADL.g:2344:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt41=1;
                }
                break;
            case 40:
                {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==EOF||(LA41_2>=RULE_ID && LA41_2<=RULE_DECIMAL)||LA41_2==14||LA41_2==18||LA41_2==24||LA41_2==40||(LA41_2>=56 && LA41_2<=57)||LA41_2==62||LA41_2==68||LA41_2==71||LA41_2==73||(LA41_2>=76 && LA41_2<=78)||(LA41_2>=81 && LA41_2<=93)||LA41_2==95) ) {
                    alt41=4;
                }
                else if ( (LA41_2==27) ) {
                    alt41=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }
                }
                break;
            case 41:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalSpeADL.g:2345:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2351:6: (kw= '<' kw= '=' )
                    {
                    // InternalSpeADL.g:2351:6: (kw= '<' kw= '=' )
                    // InternalSpeADL.g:2352:2: kw= '<' kw= '='
                    {
                    kw=(Token)match(input,40,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:2365:2: kw= '>'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:2372:2: kw= '<'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // InternalSpeADL.g:2385:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // InternalSpeADL.g:2386:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // InternalSpeADL.g:2387:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // InternalSpeADL.g:2394:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2397:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // InternalSpeADL.g:2398:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // InternalSpeADL.g:2398:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // InternalSpeADL.g:2399:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_36);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2407:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // InternalSpeADL.g:2407:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // InternalSpeADL.g:2407:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // InternalSpeADL.g:2407:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // InternalSpeADL.g:2412:6: ( () ( ( ruleOpOther ) ) )
            	    // InternalSpeADL.g:2412:7: () ( ( ruleOpOther ) )
            	    {
            	    // InternalSpeADL.g:2412:7: ()
            	    // InternalSpeADL.g:2413:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:2418:2: ( ( ruleOpOther ) )
            	    // InternalSpeADL.g:2419:1: ( ruleOpOther )
            	    {
            	    // InternalSpeADL.g:2419:1: ( ruleOpOther )
            	    // InternalSpeADL.g:2420:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:2433:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // InternalSpeADL.g:2434:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // InternalSpeADL.g:2434:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // InternalSpeADL.g:2435:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // InternalSpeADL.g:2459:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // InternalSpeADL.g:2460:2: (iv_ruleOpOther= ruleOpOther EOF )
            // InternalSpeADL.g:2461:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // InternalSpeADL.g:2468:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2471:28: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // InternalSpeADL.g:2472:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // InternalSpeADL.g:2472:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt45=9;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // InternalSpeADL.g:2473:2: kw= '->'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2480:2: kw= '..<'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:2486:6: (kw= '>' kw= '..' )
                    {
                    // InternalSpeADL.g:2486:6: (kw= '>' kw= '..' )
                    // InternalSpeADL.g:2487:2: kw= '>' kw= '..'
                    {
                    kw=(Token)match(input,41,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:2500:2: kw= '..'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpeADL.g:2507:2: kw= '=>'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpeADL.g:2513:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // InternalSpeADL.g:2513:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // InternalSpeADL.g:2514:2: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,41,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
                          
                    }
                    // InternalSpeADL.g:2519:1: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==41) ) {
                        int LA43_1 = input.LA(2);

                        if ( (LA43_1==41) && (synpred9_InternalSpeADL())) {
                            alt43=1;
                        }
                        else if ( (LA43_1==EOF||(LA43_1>=RULE_ID && LA43_1<=RULE_DECIMAL)||LA43_1==14||LA43_1==18||LA43_1==24||LA43_1==40||(LA43_1>=56 && LA43_1<=57)||LA43_1==62||LA43_1==68||LA43_1==71||LA43_1==73||(LA43_1>=76 && LA43_1<=78)||(LA43_1>=81 && LA43_1<=93)||LA43_1==95) ) {
                            alt43=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 43, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalSpeADL.g:2519:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // InternalSpeADL.g:2519:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // InternalSpeADL.g:2519:3: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // InternalSpeADL.g:2523:5: (kw= '>' kw= '>' )
                            // InternalSpeADL.g:2524:2: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,41,FOLLOW_38); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpeADL.g:2537:2: kw= '>'
                            {
                            kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSpeADL.g:2543:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // InternalSpeADL.g:2543:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // InternalSpeADL.g:2544:2: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    kw=(Token)match(input,40,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
                          
                    }
                    // InternalSpeADL.g:2549:1: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt44=3;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==40) ) {
                        int LA44_1 = input.LA(2);

                        if ( (synpred10_InternalSpeADL()) ) {
                            alt44=1;
                        }
                        else if ( (true) ) {
                            alt44=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 44, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA44_0==53) ) {
                        alt44=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalSpeADL.g:2549:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // InternalSpeADL.g:2549:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // InternalSpeADL.g:2549:3: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // InternalSpeADL.g:2553:5: (kw= '<' kw= '<' )
                            // InternalSpeADL.g:2554:2: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,40,FOLLOW_29); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpeADL.g:2567:2: kw= '<'
                            {
                            kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
                                  
                            }

                            }
                            break;
                        case 3 :
                            // InternalSpeADL.g:2574:2: kw= '=>'
                            {
                            kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSpeADL.g:2581:2: kw= '<>'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalSpeADL.g:2588:2: kw= '?:'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // InternalSpeADL.g:2601:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // InternalSpeADL.g:2602:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // InternalSpeADL.g:2603:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // InternalSpeADL.g:2610:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2613:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // InternalSpeADL.g:2614:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // InternalSpeADL.g:2614:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // InternalSpeADL.g:2615:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_40);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2623:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==56) ) {
                    int LA46_2 = input.LA(2);

                    if ( (synpred11_InternalSpeADL()) ) {
                        alt46=1;
                    }


                }
                else if ( (LA46_0==57) ) {
                    int LA46_3 = input.LA(2);

                    if ( (synpred11_InternalSpeADL()) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // InternalSpeADL.g:2623:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // InternalSpeADL.g:2623:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // InternalSpeADL.g:2623:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // InternalSpeADL.g:2628:6: ( () ( ( ruleOpAdd ) ) )
            	    // InternalSpeADL.g:2628:7: () ( ( ruleOpAdd ) )
            	    {
            	    // InternalSpeADL.g:2628:7: ()
            	    // InternalSpeADL.g:2629:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:2634:2: ( ( ruleOpAdd ) )
            	    // InternalSpeADL.g:2635:1: ( ruleOpAdd )
            	    {
            	    // InternalSpeADL.g:2635:1: ( ruleOpAdd )
            	    // InternalSpeADL.g:2636:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:2649:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // InternalSpeADL.g:2650:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // InternalSpeADL.g:2650:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // InternalSpeADL.g:2651:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalSpeADL.g:2675:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalSpeADL.g:2676:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalSpeADL.g:2677:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalSpeADL.g:2684:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2687:28: ( (kw= '+' | kw= '-' ) )
            // InternalSpeADL.g:2688:1: (kw= '+' | kw= '-' )
            {
            // InternalSpeADL.g:2688:1: (kw= '+' | kw= '-' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==56) ) {
                alt47=1;
            }
            else if ( (LA47_0==57) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalSpeADL.g:2689:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2696:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // InternalSpeADL.g:2709:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // InternalSpeADL.g:2710:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // InternalSpeADL.g:2711:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // InternalSpeADL.g:2718:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2721:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // InternalSpeADL.g:2722:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // InternalSpeADL.g:2722:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // InternalSpeADL.g:2723:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_41);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2731:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop48:
            do {
                int alt48=2;
                switch ( input.LA(1) ) {
                case 58:
                    {
                    int LA48_2 = input.LA(2);

                    if ( (synpred12_InternalSpeADL()) ) {
                        alt48=1;
                    }


                    }
                    break;
                case 59:
                    {
                    int LA48_3 = input.LA(2);

                    if ( (synpred12_InternalSpeADL()) ) {
                        alt48=1;
                    }


                    }
                    break;
                case 60:
                    {
                    int LA48_4 = input.LA(2);

                    if ( (synpred12_InternalSpeADL()) ) {
                        alt48=1;
                    }


                    }
                    break;
                case 61:
                    {
                    int LA48_5 = input.LA(2);

                    if ( (synpred12_InternalSpeADL()) ) {
                        alt48=1;
                    }


                    }
                    break;

                }

                switch (alt48) {
            	case 1 :
            	    // InternalSpeADL.g:2731:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // InternalSpeADL.g:2731:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // InternalSpeADL.g:2731:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // InternalSpeADL.g:2736:6: ( () ( ( ruleOpMulti ) ) )
            	    // InternalSpeADL.g:2736:7: () ( ( ruleOpMulti ) )
            	    {
            	    // InternalSpeADL.g:2736:7: ()
            	    // InternalSpeADL.g:2737:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:2742:2: ( ( ruleOpMulti ) )
            	    // InternalSpeADL.g:2743:1: ( ruleOpMulti )
            	    {
            	    // InternalSpeADL.g:2743:1: ( ruleOpMulti )
            	    // InternalSpeADL.g:2744:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:2757:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // InternalSpeADL.g:2758:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // InternalSpeADL.g:2758:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // InternalSpeADL.g:2759:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_41);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalSpeADL.g:2783:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalSpeADL.g:2784:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalSpeADL.g:2785:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalSpeADL.g:2792:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2795:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // InternalSpeADL.g:2796:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // InternalSpeADL.g:2796:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt49=1;
                }
                break;
            case 59:
                {
                alt49=2;
                }
                break;
            case 60:
                {
                alt49=3;
                }
                break;
            case 61:
                {
                alt49=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalSpeADL.g:2797:2: kw= '*'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2804:2: kw= '**'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:2811:2: kw= '/'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:2818:2: kw= '%'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // InternalSpeADL.g:2831:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // InternalSpeADL.g:2832:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // InternalSpeADL.g:2833:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // InternalSpeADL.g:2840:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2843:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // InternalSpeADL.g:2844:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // InternalSpeADL.g:2844:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=56 && LA50_0<=57)||LA50_0==62) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_DECIMAL)||LA50_0==14||LA50_0==18||LA50_0==24||LA50_0==40||LA50_0==68||LA50_0==71||LA50_0==73||(LA50_0>=76 && LA50_0<=78)||(LA50_0>=81 && LA50_0<=93)||LA50_0==95) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalSpeADL.g:2844:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // InternalSpeADL.g:2844:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // InternalSpeADL.g:2844:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // InternalSpeADL.g:2844:3: ()
                    // InternalSpeADL.g:2845:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpeADL.g:2850:2: ( ( ruleOpUnary ) )
                    // InternalSpeADL.g:2851:1: ( ruleOpUnary )
                    {
                    // InternalSpeADL.g:2851:1: ( ruleOpUnary )
                    // InternalSpeADL.g:2852:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_27);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:2865:2: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // InternalSpeADL.g:2866:1: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // InternalSpeADL.g:2866:1: (lv_operand_2_0= ruleXUnaryOperation )
                    // InternalSpeADL.g:2867:3: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2885:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalSpeADL.g:2901:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalSpeADL.g:2902:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalSpeADL.g:2903:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalSpeADL.g:2910:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:2913:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // InternalSpeADL.g:2914:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // InternalSpeADL.g:2914:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt51=1;
                }
                break;
            case 57:
                {
                alt51=2;
                }
                break;
            case 56:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalSpeADL.g:2915:2: kw= '!'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:2922:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:2929:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // InternalSpeADL.g:2942:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // InternalSpeADL.g:2943:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // InternalSpeADL.g:2944:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // InternalSpeADL.g:2951:1: ruleXCastedExpression returns [EObject current=null] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XPostfixOperation_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:2954:28: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // InternalSpeADL.g:2955:1: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // InternalSpeADL.g:2955:1: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // InternalSpeADL.g:2956:5: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_42);
            this_XPostfixOperation_0=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPostfixOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:2964:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==63) ) {
                    int LA52_2 = input.LA(2);

                    if ( (synpred13_InternalSpeADL()) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // InternalSpeADL.g:2964:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // InternalSpeADL.g:2964:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // InternalSpeADL.g:2964:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // InternalSpeADL.g:2966:5: ( () otherlv_2= 'as' )
            	    // InternalSpeADL.g:2966:6: () otherlv_2= 'as'
            	    {
            	    // InternalSpeADL.g:2966:6: ()
            	    // InternalSpeADL.g:2967:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,63,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpeADL.g:2976:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // InternalSpeADL.g:2977:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // InternalSpeADL.g:2977:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // InternalSpeADL.g:2978:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXPostfixOperation"
    // InternalSpeADL.g:3002:1: entryRuleXPostfixOperation returns [EObject current=null] : iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
    public final EObject entryRuleXPostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPostfixOperation = null;


        try {
            // InternalSpeADL.g:3003:2: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
            // InternalSpeADL.g:3004:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPostfixOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPostfixOperation=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPostfixOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPostfixOperation"


    // $ANTLR start "ruleXPostfixOperation"
    // InternalSpeADL.g:3011:1: ruleXPostfixOperation returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
    public final EObject ruleXPostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject this_XMemberFeatureCall_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3014:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
            // InternalSpeADL.g:3015:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            {
            // InternalSpeADL.g:3015:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            // InternalSpeADL.g:3016:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_43);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:3024:1: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==64) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred14_InternalSpeADL()) ) {
                    alt53=1;
                }
            }
            else if ( (LA53_0==65) ) {
                int LA53_2 = input.LA(2);

                if ( (synpred14_InternalSpeADL()) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalSpeADL.g:3024:2: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
                    {
                    // InternalSpeADL.g:3029:6: ( () ( ( ruleOpPostfix ) ) )
                    // InternalSpeADL.g:3029:7: () ( ( ruleOpPostfix ) )
                    {
                    // InternalSpeADL.g:3029:7: ()
                    // InternalSpeADL.g:3030:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpeADL.g:3035:2: ( ( ruleOpPostfix ) )
                    // InternalSpeADL.g:3036:1: ( ruleOpPostfix )
                    {
                    // InternalSpeADL.g:3036:1: ( ruleOpPostfix )
                    // InternalSpeADL.g:3037:3: ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXPostfixOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXPostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalSpeADL.g:3058:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalSpeADL.g:3059:2: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalSpeADL.g:3060:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpPostfixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // InternalSpeADL.g:3067:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:3070:28: ( (kw= '++' | kw= '--' ) )
            // InternalSpeADL.g:3071:1: (kw= '++' | kw= '--' )
            {
            // InternalSpeADL.g:3071:1: (kw= '++' | kw= '--' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==64) ) {
                alt54=1;
            }
            else if ( (LA54_0==65) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalSpeADL.g:3072:2: kw= '++'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:3079:2: kw= '--'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // InternalSpeADL.g:3092:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // InternalSpeADL.g:3093:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // InternalSpeADL.g:3094:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // InternalSpeADL.g:3101:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitStatic_3_0=null;
        Token otherlv_8=null;
        Token lv_nullSafe_9_0=null;
        Token lv_explicitStatic_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_explicitOperationCall_17_0=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_typeArguments_12_0 = null;

        EObject lv_typeArguments_14_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_19_0 = null;

        EObject lv_memberCallArguments_21_0 = null;

        EObject lv_memberCallArguments_23_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3104:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
            // InternalSpeADL.g:3105:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            {
            // InternalSpeADL.g:3105:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            // InternalSpeADL.g:3106:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_44);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:3114:1: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            loop63:
            do {
                int alt63=3;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA63_2 = input.LA(2);

                    if ( (synpred15_InternalSpeADL()) ) {
                        alt63=1;
                    }
                    else if ( (synpred16_InternalSpeADL()) ) {
                        alt63=2;
                    }


                    }
                    break;
                case 66:
                    {
                    int LA63_3 = input.LA(2);

                    if ( (synpred15_InternalSpeADL()) ) {
                        alt63=1;
                    }
                    else if ( (synpred16_InternalSpeADL()) ) {
                        alt63=2;
                    }


                    }
                    break;
                case 67:
                    {
                    int LA63_4 = input.LA(2);

                    if ( (synpred16_InternalSpeADL()) ) {
                        alt63=2;
                    }


                    }
                    break;

                }

                switch (alt63) {
            	case 1 :
            	    // InternalSpeADL.g:3114:2: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    {
            	    // InternalSpeADL.g:3114:2: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    // InternalSpeADL.g:3114:3: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
            	    {
            	    // InternalSpeADL.g:3114:3: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            	    // InternalSpeADL.g:3114:4: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    {
            	    // InternalSpeADL.g:3127:25: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    // InternalSpeADL.g:3127:26: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
            	    {
            	    // InternalSpeADL.g:3127:26: ()
            	    // InternalSpeADL.g:3128:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:3133:2: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( (LA55_0==34) ) {
            	        alt55=1;
            	    }
            	    else if ( (LA55_0==66) ) {
            	        alt55=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 55, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // InternalSpeADL.g:3133:4: otherlv_2= '.'
            	            {
            	            otherlv_2=(Token)match(input,34,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpeADL.g:3138:6: ( (lv_explicitStatic_3_0= '::' ) )
            	            {
            	            // InternalSpeADL.g:3138:6: ( (lv_explicitStatic_3_0= '::' ) )
            	            // InternalSpeADL.g:3139:1: (lv_explicitStatic_3_0= '::' )
            	            {
            	            // InternalSpeADL.g:3139:1: (lv_explicitStatic_3_0= '::' )
            	            // InternalSpeADL.g:3140:3: lv_explicitStatic_3_0= '::'
            	            {
            	            lv_explicitStatic_3_0=(Token)match(input,66,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitStatic_3_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitStatic", true, "::");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalSpeADL.g:3153:3: ( ( ruleFeatureCallID ) )
            	    // InternalSpeADL.g:3154:1: ( ruleFeatureCallID )
            	    {
            	    // InternalSpeADL.g:3154:1: ( ruleFeatureCallID )
            	    // InternalSpeADL.g:3155:3: ruleFeatureCallID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    ruleFeatureCallID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_27);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // InternalSpeADL.g:3176:3: ( (lv_value_6_0= ruleXAssignment ) )
            	    // InternalSpeADL.g:3177:1: (lv_value_6_0= ruleXAssignment )
            	    {
            	    // InternalSpeADL.g:3177:1: (lv_value_6_0= ruleXAssignment )
            	    // InternalSpeADL.g:3178:3: lv_value_6_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_value_6_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_6_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpeADL.g:3195:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    {
            	    // InternalSpeADL.g:3195:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    // InternalSpeADL.g:3195:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    {
            	    // InternalSpeADL.g:3195:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
            	    // InternalSpeADL.g:3195:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    {
            	    // InternalSpeADL.g:3211:7: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    // InternalSpeADL.g:3211:8: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    {
            	    // InternalSpeADL.g:3211:8: ()
            	    // InternalSpeADL.g:3212:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalSpeADL.g:3217:2: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    int alt56=3;
            	    switch ( input.LA(1) ) {
            	    case 34:
            	        {
            	        alt56=1;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt56=2;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt56=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt56) {
            	        case 1 :
            	            // InternalSpeADL.g:3217:4: otherlv_8= '.'
            	            {
            	            otherlv_8=(Token)match(input,34,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpeADL.g:3222:6: ( (lv_nullSafe_9_0= '?.' ) )
            	            {
            	            // InternalSpeADL.g:3222:6: ( (lv_nullSafe_9_0= '?.' ) )
            	            // InternalSpeADL.g:3223:1: (lv_nullSafe_9_0= '?.' )
            	            {
            	            // InternalSpeADL.g:3223:1: (lv_nullSafe_9_0= '?.' )
            	            // InternalSpeADL.g:3224:3: lv_nullSafe_9_0= '?.'
            	            {
            	            lv_nullSafe_9_0=(Token)match(input,67,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_nullSafe_9_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "nullSafe", true, "?.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalSpeADL.g:3238:6: ( (lv_explicitStatic_10_0= '::' ) )
            	            {
            	            // InternalSpeADL.g:3238:6: ( (lv_explicitStatic_10_0= '::' ) )
            	            // InternalSpeADL.g:3239:1: (lv_explicitStatic_10_0= '::' )
            	            {
            	            // InternalSpeADL.g:3239:1: (lv_explicitStatic_10_0= '::' )
            	            // InternalSpeADL.g:3240:3: lv_explicitStatic_10_0= '::'
            	            {
            	            lv_explicitStatic_10_0=(Token)match(input,66,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitStatic_10_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitStatic", true, "::");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpeADL.g:3253:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
            	    int alt58=2;
            	    int LA58_0 = input.LA(1);

            	    if ( (LA58_0==40) ) {
            	        alt58=1;
            	    }
            	    switch (alt58) {
            	        case 1 :
            	            // InternalSpeADL.g:3253:7: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
            	            {
            	            otherlv_11=(Token)match(input,40,FOLLOW_25); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // InternalSpeADL.g:3257:1: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
            	            // InternalSpeADL.g:3258:1: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            {
            	            // InternalSpeADL.g:3258:1: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            // InternalSpeADL.g:3259:3: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_47);
            	            lv_typeArguments_12_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"typeArguments",
            	                      		lv_typeArguments_12_0, 
            	                      		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // InternalSpeADL.g:3275:2: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop57:
            	            do {
            	                int alt57=2;
            	                int LA57_0 = input.LA(1);

            	                if ( (LA57_0==19) ) {
            	                    alt57=1;
            	                }


            	                switch (alt57) {
            	            	case 1 :
            	            	    // InternalSpeADL.g:3275:4: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_13=(Token)match(input,19,FOLLOW_25); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // InternalSpeADL.g:3279:1: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    // InternalSpeADL.g:3280:1: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // InternalSpeADL.g:3280:1: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    // InternalSpeADL.g:3281:3: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_47);
            	            	    lv_typeArguments_14_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      	        }
            	            	             		add(
            	            	             			current, 
            	            	             			"typeArguments",
            	            	              		lv_typeArguments_14_0, 
            	            	              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
            	            	      	        afterParserOrEnumRuleCall();
            	            	      	    
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop57;
            	                }
            	            } while (true);

            	            otherlv_15=(Token)match(input,41,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // InternalSpeADL.g:3301:3: ( ( ruleIdOrSuper ) )
            	    // InternalSpeADL.g:3302:1: ( ruleIdOrSuper )
            	    {
            	    // InternalSpeADL.g:3302:1: ( ruleIdOrSuper )
            	    // InternalSpeADL.g:3303:3: ruleIdOrSuper
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_48);
            	    ruleIdOrSuper();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // InternalSpeADL.g:3316:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
            	    int alt61=2;
            	    alt61 = dfa61.predict(input);
            	    switch (alt61) {
            	        case 1 :
            	            // InternalSpeADL.g:3316:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
            	            {
            	            // InternalSpeADL.g:3316:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
            	            // InternalSpeADL.g:3316:4: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
            	            {
            	            // InternalSpeADL.g:3323:1: (lv_explicitOperationCall_17_0= '(' )
            	            // InternalSpeADL.g:3324:3: lv_explicitOperationCall_17_0= '('
            	            {
            	            lv_explicitOperationCall_17_0=(Token)match(input,24,FOLLOW_49); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitOperationCall_17_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // InternalSpeADL.g:3337:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
            	            int alt60=3;
            	            alt60 = dfa60.predict(input);
            	            switch (alt60) {
            	                case 1 :
            	                    // InternalSpeADL.g:3337:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    {
            	                    // InternalSpeADL.g:3337:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    // InternalSpeADL.g:3337:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    {
            	                    // InternalSpeADL.g:3354:1: (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    // InternalSpeADL.g:3355:3: lv_memberCallArguments_18_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_50);
            	                    lv_memberCallArguments_18_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_18_0, 
            	                              		"org.eclipse.xtext.xbase.Xbase.XShortClosure");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpeADL.g:3372:6: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    {
            	                    // InternalSpeADL.g:3372:6: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    // InternalSpeADL.g:3372:7: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    {
            	                    // InternalSpeADL.g:3372:7: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
            	                    // InternalSpeADL.g:3373:1: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    {
            	                    // InternalSpeADL.g:3373:1: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    // InternalSpeADL.g:3374:3: lv_memberCallArguments_19_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_15);
            	                    lv_memberCallArguments_19_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_19_0, 
            	                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // InternalSpeADL.g:3390:2: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    loop59:
            	                    do {
            	                        int alt59=2;
            	                        int LA59_0 = input.LA(1);

            	                        if ( (LA59_0==19) ) {
            	                            alt59=1;
            	                        }


            	                        switch (alt59) {
            	                    	case 1 :
            	                    	    // InternalSpeADL.g:3390:4: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_20=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_20, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // InternalSpeADL.g:3394:1: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    // InternalSpeADL.g:3395:1: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    {
            	                    	    // InternalSpeADL.g:3395:1: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    // InternalSpeADL.g:3396:3: lv_memberCallArguments_21_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_15);
            	                    	    lv_memberCallArguments_21_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"memberCallArguments",
            	                    	              		lv_memberCallArguments_21_0, 
            	                    	              		"org.eclipse.xtext.xbase.Xbase.XExpression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop59;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_22=(Token)match(input,25,FOLLOW_51); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_22, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // InternalSpeADL.g:3416:3: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    int alt62=2;
            	    alt62 = dfa62.predict(input);
            	    switch (alt62) {
            	        case 1 :
            	            // InternalSpeADL.g:3416:4: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
            	            {
            	            // InternalSpeADL.g:3419:1: (lv_memberCallArguments_23_0= ruleXClosure )
            	            // InternalSpeADL.g:3420:3: lv_memberCallArguments_23_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_44);
            	            lv_memberCallArguments_23_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"memberCallArguments",
            	                      		lv_memberCallArguments_23_0, 
            	                      		"org.eclipse.xtext.xbase.Xbase.XClosure");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // InternalSpeADL.g:3444:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // InternalSpeADL.g:3445:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // InternalSpeADL.g:3446:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // InternalSpeADL.g:3453:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XSynchronizedExpression_3 = null;

        EObject this_XFeatureCall_4 = null;

        EObject this_XLiteral_5 = null;

        EObject this_XIfExpression_6 = null;

        EObject this_XForLoopExpression_7 = null;

        EObject this_XBasicForLoopExpression_8 = null;

        EObject this_XWhileExpression_9 = null;

        EObject this_XDoWhileExpression_10 = null;

        EObject this_XThrowExpression_11 = null;

        EObject this_XReturnExpression_12 = null;

        EObject this_XTryCatchFinallyExpression_13 = null;

        EObject this_XParenthesizedExpression_14 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3456:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
            // InternalSpeADL.g:3457:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            {
            // InternalSpeADL.g:3457:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            int alt64=15;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalSpeADL.g:3458:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:3468:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:3478:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:3487:6: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    {
                    // InternalSpeADL.g:3487:6: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    // InternalSpeADL.g:3487:7: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XSynchronizedExpression_3=ruleXSynchronizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSynchronizedExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSpeADL.g:3501:5: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpeADL.g:3511:5: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalSpeADL.g:3521:5: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalSpeADL.g:3530:6: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    {
                    // InternalSpeADL.g:3530:6: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    // InternalSpeADL.g:3530:7: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSpeADL.g:3549:5: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBasicForLoopExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalSpeADL.g:3559:5: this_XWhileExpression_9= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XWhileExpression_9=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalSpeADL.g:3569:5: this_XDoWhileExpression_10= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XDoWhileExpression_10=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalSpeADL.g:3579:5: this_XThrowExpression_11= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XThrowExpression_11=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalSpeADL.g:3589:5: this_XReturnExpression_12= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XReturnExpression_12=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalSpeADL.g:3599:5: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_13; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalSpeADL.g:3609:5: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XParenthesizedExpression_14=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_14; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // InternalSpeADL.g:3625:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // InternalSpeADL.g:3626:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // InternalSpeADL.g:3627:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // InternalSpeADL.g:3634:1: ruleXLiteral returns [EObject current=null] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XCollectionLiteral_0 = null;

        EObject this_XClosure_1 = null;

        EObject this_XBooleanLiteral_2 = null;

        EObject this_XNumberLiteral_3 = null;

        EObject this_XNullLiteral_4 = null;

        EObject this_XStringLiteral_5 = null;

        EObject this_XTypeLiteral_6 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3637:28: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) )
            // InternalSpeADL.g:3638:1: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            {
            // InternalSpeADL.g:3638:1: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            int alt65=7;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==68) ) {
                alt65=1;
            }
            else if ( (LA65_0==18) && (synpred22_InternalSpeADL())) {
                alt65=2;
            }
            else if ( ((LA65_0>=87 && LA65_0<=88)) ) {
                alt65=3;
            }
            else if ( ((LA65_0>=RULE_HEX && LA65_0<=RULE_DECIMAL)) ) {
                alt65=4;
            }
            else if ( (LA65_0==89) ) {
                alt65=5;
            }
            else if ( (LA65_0==RULE_STRING) ) {
                alt65=6;
            }
            else if ( (LA65_0==90) ) {
                alt65=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalSpeADL.g:3639:5: this_XCollectionLiteral_0= ruleXCollectionLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XCollectionLiteral_0=ruleXCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCollectionLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:3648:6: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    {
                    // InternalSpeADL.g:3648:6: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    // InternalSpeADL.g:3648:7: ( ( () '[' ) )=>this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XClosure_1=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:3661:5: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XBooleanLiteral_2=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:3671:5: this_XNumberLiteral_3= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XNumberLiteral_3=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNumberLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpeADL.g:3681:5: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XNullLiteral_4=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpeADL.g:3691:5: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XStringLiteral_5=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalSpeADL.g:3701:5: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXCollectionLiteral"
    // InternalSpeADL.g:3717:1: entryRuleXCollectionLiteral returns [EObject current=null] : iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
    public final EObject entryRuleXCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCollectionLiteral = null;


        try {
            // InternalSpeADL.g:3718:2: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
            // InternalSpeADL.g:3719:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCollectionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCollectionLiteral"


    // $ANTLR start "ruleXCollectionLiteral"
    // InternalSpeADL.g:3726:1: ruleXCollectionLiteral returns [EObject current=null] : (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) ;
    public final EObject ruleXCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XSetLiteral_0 = null;

        EObject this_XListLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3729:28: ( (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) )
            // InternalSpeADL.g:3730:1: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            {
            // InternalSpeADL.g:3730:1: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==68) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==14) ) {
                    alt66=1;
                }
                else if ( (LA66_1==18) ) {
                    alt66=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalSpeADL.g:3731:5: this_XSetLiteral_0= ruleXSetLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XSetLiteral_0=ruleXSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSetLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:3741:5: this_XListLiteral_1= ruleXListLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XListLiteral_1=ruleXListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XListLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCollectionLiteral"


    // $ANTLR start "entryRuleXSetLiteral"
    // InternalSpeADL.g:3757:1: entryRuleXSetLiteral returns [EObject current=null] : iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
    public final EObject entryRuleXSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSetLiteral = null;


        try {
            // InternalSpeADL.g:3758:2: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
            // InternalSpeADL.g:3759:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSetLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSetLiteral=ruleXSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSetLiteral"


    // $ANTLR start "ruleXSetLiteral"
    // InternalSpeADL.g:3766:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleXSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3769:28: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
            // InternalSpeADL.g:3770:1: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            {
            // InternalSpeADL.g:3770:1: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            // InternalSpeADL.g:3770:2: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
            {
            // InternalSpeADL.g:3770:2: ()
            // InternalSpeADL.g:3771:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,14,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalSpeADL.g:3784:1: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_DECIMAL)||LA68_0==14||LA68_0==18||LA68_0==24||LA68_0==40||(LA68_0>=56 && LA68_0<=57)||LA68_0==62||LA68_0==68||LA68_0==71||LA68_0==73||(LA68_0>=76 && LA68_0<=78)||(LA68_0>=81 && LA68_0<=93)||LA68_0==95) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalSpeADL.g:3784:2: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // InternalSpeADL.g:3784:2: ( (lv_elements_3_0= ruleXExpression ) )
                    // InternalSpeADL.g:3785:1: (lv_elements_3_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:3785:1: (lv_elements_3_0= ruleXExpression )
                    // InternalSpeADL.g:3786:3: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_53);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_3_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:3802:2: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==19) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalSpeADL.g:3802:4: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:3806:1: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // InternalSpeADL.g:3807:1: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // InternalSpeADL.g:3807:1: (lv_elements_5_0= ruleXExpression )
                    	    // InternalSpeADL.g:3808:3: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_53);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_5_0, 
                    	              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSetLiteral"


    // $ANTLR start "entryRuleXListLiteral"
    // InternalSpeADL.g:3836:1: entryRuleXListLiteral returns [EObject current=null] : iv_ruleXListLiteral= ruleXListLiteral EOF ;
    public final EObject entryRuleXListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXListLiteral = null;


        try {
            // InternalSpeADL.g:3837:2: (iv_ruleXListLiteral= ruleXListLiteral EOF )
            // InternalSpeADL.g:3838:2: iv_ruleXListLiteral= ruleXListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXListLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXListLiteral=ruleXListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXListLiteral"


    // $ANTLR start "ruleXListLiteral"
    // InternalSpeADL.g:3845:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
    public final EObject ruleXListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3848:28: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
            // InternalSpeADL.g:3849:1: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            {
            // InternalSpeADL.g:3849:1: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            // InternalSpeADL.g:3849:2: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
            {
            // InternalSpeADL.g:3849:2: ()
            // InternalSpeADL.g:3850:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,18,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // InternalSpeADL.g:3863:1: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=RULE_ID && LA70_0<=RULE_DECIMAL)||LA70_0==14||LA70_0==18||LA70_0==24||LA70_0==40||(LA70_0>=56 && LA70_0<=57)||LA70_0==62||LA70_0==68||LA70_0==71||LA70_0==73||(LA70_0>=76 && LA70_0<=78)||(LA70_0>=81 && LA70_0<=93)||LA70_0==95) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalSpeADL.g:3863:2: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // InternalSpeADL.g:3863:2: ( (lv_elements_3_0= ruleXExpression ) )
                    // InternalSpeADL.g:3864:1: (lv_elements_3_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:3864:1: (lv_elements_3_0= ruleXExpression )
                    // InternalSpeADL.g:3865:3: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXListLiteralRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_3_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:3881:2: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==19) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalSpeADL.g:3881:4: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:3885:1: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // InternalSpeADL.g:3886:1: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // InternalSpeADL.g:3886:1: (lv_elements_5_0= ruleXExpression )
                    	    // InternalSpeADL.g:3887:3: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXListLiteralRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_5_0, 
                    	              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXListLiteral"


    // $ANTLR start "entryRuleXClosure"
    // InternalSpeADL.g:3915:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // InternalSpeADL.g:3916:2: (iv_ruleXClosure= ruleXClosure EOF )
            // InternalSpeADL.g:3917:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // InternalSpeADL.g:3924:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:3927:28: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // InternalSpeADL.g:3928:1: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // InternalSpeADL.g:3928:1: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // InternalSpeADL.g:3928:2: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // InternalSpeADL.g:3928:2: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // InternalSpeADL.g:3928:3: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // InternalSpeADL.g:3930:5: ( () otherlv_1= '[' )
            // InternalSpeADL.g:3930:6: () otherlv_1= '['
            {
            // InternalSpeADL.g:3930:6: ()
            // InternalSpeADL.g:3931:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_56); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
                  
            }

            }


            }

            // InternalSpeADL.g:3940:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt73=2;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalSpeADL.g:3940:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // InternalSpeADL.g:3955:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // InternalSpeADL.g:3955:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // InternalSpeADL.g:3955:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==RULE_ID) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalSpeADL.g:3955:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // InternalSpeADL.g:3955:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // InternalSpeADL.g:3956:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // InternalSpeADL.g:3956:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // InternalSpeADL.g:3957:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_57);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"declaredFormalParameters",
                                      		lv_declaredFormalParameters_2_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpeADL.g:3973:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop71:
                            do {
                                int alt71=2;
                                int LA71_0 = input.LA(1);

                                if ( (LA71_0==19) ) {
                                    alt71=1;
                                }


                                switch (alt71) {
                            	case 1 :
                            	    // InternalSpeADL.g:3973:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
                            	          
                            	    }
                            	    // InternalSpeADL.g:3977:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // InternalSpeADL.g:3978:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // InternalSpeADL.g:3978:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // InternalSpeADL.g:3979:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_57);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"declaredFormalParameters",
                            	              		lv_declaredFormalParameters_4_0, 
                            	              		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop71;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalSpeADL.g:3995:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // InternalSpeADL.g:3996:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // InternalSpeADL.g:3996:1: (lv_explicitSyntax_5_0= '|' )
                    // InternalSpeADL.g:3997:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,69,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXClosureRule());
                      	        }
                             		setWithLastConsumed(current, "explicitSyntax", true, "|");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalSpeADL.g:4010:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // InternalSpeADL.g:4011:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // InternalSpeADL.g:4011:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // InternalSpeADL.g:4012:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_59);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpressionInClosure");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // InternalSpeADL.g:4040:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // InternalSpeADL.g:4041:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // InternalSpeADL.g:4042:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // InternalSpeADL.g:4049:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4052:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // InternalSpeADL.g:4053:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // InternalSpeADL.g:4053:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // InternalSpeADL.g:4053:2: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // InternalSpeADL.g:4053:2: ()
            // InternalSpeADL.g:4054:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:4059:2: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0>=RULE_ID && LA75_0<=RULE_DECIMAL)||LA75_0==14||LA75_0==18||LA75_0==24||LA75_0==40||(LA75_0>=56 && LA75_0<=57)||LA75_0==62||LA75_0==68||LA75_0==71||LA75_0==73||(LA75_0>=76 && LA75_0<=93)||LA75_0==95) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalSpeADL.g:4059:3: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // InternalSpeADL.g:4059:3: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // InternalSpeADL.g:4060:1: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // InternalSpeADL.g:4060:1: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // InternalSpeADL.g:4061:3: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_expressions_1_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_1_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // InternalSpeADL.g:4077:2: (otherlv_2= ';' )?
            	    int alt74=2;
            	    int LA74_0 = input.LA(1);

            	    if ( (LA74_0==70) ) {
            	        alt74=1;
            	    }
            	    switch (alt74) {
            	        case 1 :
            	            // InternalSpeADL.g:4077:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,70,FOLLOW_61); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // InternalSpeADL.g:4089:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // InternalSpeADL.g:4090:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // InternalSpeADL.g:4091:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // InternalSpeADL.g:4098:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4101:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:4102:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:4102:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // InternalSpeADL.g:4102:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:4102:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // InternalSpeADL.g:4102:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // InternalSpeADL.g:4118:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // InternalSpeADL.g:4118:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // InternalSpeADL.g:4118:7: ()
            // InternalSpeADL.g:4119:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:4124:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalSpeADL.g:4124:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // InternalSpeADL.g:4124:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // InternalSpeADL.g:4125:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // InternalSpeADL.g:4125:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // InternalSpeADL.g:4126:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_57);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"declaredFormalParameters",
                              		lv_declaredFormalParameters_1_0, 
                              		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:4142:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==19) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalSpeADL.g:4142:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:4146:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // InternalSpeADL.g:4147:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // InternalSpeADL.g:4147:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // InternalSpeADL.g:4148:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_57);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"declaredFormalParameters",
                    	              		lv_declaredFormalParameters_3_0, 
                    	              		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpeADL.g:4164:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // InternalSpeADL.g:4165:1: (lv_explicitSyntax_4_0= '|' )
            {
            // InternalSpeADL.g:4165:1: (lv_explicitSyntax_4_0= '|' )
            // InternalSpeADL.g:4166:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,69,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXShortClosureRule());
              	        }
                     		setWithLastConsumed(current, "explicitSyntax", true, "|");
              	    
            }

            }


            }


            }


            }

            // InternalSpeADL.g:4179:4: ( (lv_expression_5_0= ruleXExpression ) )
            // InternalSpeADL.g:4180:1: (lv_expression_5_0= ruleXExpression )
            {
            // InternalSpeADL.g:4180:1: (lv_expression_5_0= ruleXExpression )
            // InternalSpeADL.g:4181:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // InternalSpeADL.g:4205:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // InternalSpeADL.g:4206:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // InternalSpeADL.g:4207:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // InternalSpeADL.g:4214:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4217:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // InternalSpeADL.g:4218:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // InternalSpeADL.g:4218:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // InternalSpeADL.g:4218:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_50);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // InternalSpeADL.g:4243:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // InternalSpeADL.g:4244:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // InternalSpeADL.g:4245:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // InternalSpeADL.g:4252:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4255:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // InternalSpeADL.g:4256:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // InternalSpeADL.g:4256:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // InternalSpeADL.g:4256:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // InternalSpeADL.g:4256:2: ()
            // InternalSpeADL.g:4257:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalSpeADL.g:4270:1: ( (lv_if_3_0= ruleXExpression ) )
            // InternalSpeADL.g:4271:1: (lv_if_3_0= ruleXExpression )
            {
            // InternalSpeADL.g:4271:1: (lv_if_3_0= ruleXExpression )
            // InternalSpeADL.g:4272:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalSpeADL.g:4292:1: ( (lv_then_5_0= ruleXExpression ) )
            // InternalSpeADL.g:4293:1: (lv_then_5_0= ruleXExpression )
            {
            // InternalSpeADL.g:4293:1: (lv_then_5_0= ruleXExpression )
            // InternalSpeADL.g:4294:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_63);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:4310:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==72) ) {
                int LA78_1 = input.LA(2);

                if ( (synpred26_InternalSpeADL()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // InternalSpeADL.g:4310:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // InternalSpeADL.g:4310:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalSpeADL.g:4310:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,72,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // InternalSpeADL.g:4315:2: ( (lv_else_7_0= ruleXExpression ) )
                    // InternalSpeADL.g:4316:1: (lv_else_7_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4316:1: (lv_else_7_0= ruleXExpression )
                    // InternalSpeADL.g:4317:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // InternalSpeADL.g:4341:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // InternalSpeADL.g:4342:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // InternalSpeADL.g:4343:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // InternalSpeADL.g:4350:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_switch_5_0 = null;

        EObject lv_declaredParam_7_0 = null;

        EObject lv_switch_9_0 = null;

        EObject lv_cases_11_0 = null;

        EObject lv_default_14_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4353:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // InternalSpeADL.g:4354:1: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // InternalSpeADL.g:4354:1: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // InternalSpeADL.g:4354:2: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // InternalSpeADL.g:4354:2: ()
            // InternalSpeADL.g:4355:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // InternalSpeADL.g:4364:1: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
            int alt80=2;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // InternalSpeADL.g:4364:2: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    {
                    // InternalSpeADL.g:4364:2: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    // InternalSpeADL.g:4364:3: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
                    {
                    // InternalSpeADL.g:4364:3: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
                    // InternalSpeADL.g:4364:4: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    {
                    // InternalSpeADL.g:4370:5: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    // InternalSpeADL.g:4370:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
                          
                    }
                    // InternalSpeADL.g:4374:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
                    // InternalSpeADL.g:4375:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    {
                    // InternalSpeADL.g:4375:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    // InternalSpeADL.g:4376:3: lv_declaredParam_3_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_7);
                    lv_declaredParam_3_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"declaredParam",
                              		lv_declaredParam_3_0, 
                              		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
                          
                    }

                    }


                    }

                    // InternalSpeADL.g:4396:3: ( (lv_switch_5_0= ruleXExpression ) )
                    // InternalSpeADL.g:4397:1: (lv_switch_5_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4397:1: (lv_switch_5_0= ruleXExpression )
                    // InternalSpeADL.g:4398:3: lv_switch_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_50);
                    lv_switch_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_5_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:4419:6: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    {
                    // InternalSpeADL.g:4419:6: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    // InternalSpeADL.g:4419:7: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
                    {
                    // InternalSpeADL.g:4419:7: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
                    int alt79=2;
                    alt79 = dfa79.predict(input);
                    switch (alt79) {
                        case 1 :
                            // InternalSpeADL.g:4419:8: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            {
                            // InternalSpeADL.g:4424:5: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            // InternalSpeADL.g:4424:6: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
                            {
                            // InternalSpeADL.g:4424:6: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
                            // InternalSpeADL.g:4425:1: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            {
                            // InternalSpeADL.g:4425:1: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            // InternalSpeADL.g:4426:3: lv_declaredParam_7_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_7);
                            lv_declaredParam_7_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"declaredParam",
                                      		lv_declaredParam_7_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_8=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // InternalSpeADL.g:4446:4: ( (lv_switch_9_0= ruleXExpression ) )
                    // InternalSpeADL.g:4447:1: (lv_switch_9_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4447:1: (lv_switch_9_0= ruleXExpression )
                    // InternalSpeADL.g:4448:3: lv_switch_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
                    lv_switch_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_9_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,14,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // InternalSpeADL.g:4468:1: ( (lv_cases_11_0= ruleXCasePart ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_ID||LA81_0==16||LA81_0==19||LA81_0==75) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalSpeADL.g:4469:1: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // InternalSpeADL.g:4469:1: (lv_cases_11_0= ruleXCasePart )
            	    // InternalSpeADL.g:4470:3: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_64);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_11_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            // InternalSpeADL.g:4486:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==74) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalSpeADL.g:4486:5: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,74,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                          
                    }
                    otherlv_13=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                          
                    }
                    // InternalSpeADL.g:4494:1: ( (lv_default_14_0= ruleXExpression ) )
                    // InternalSpeADL.g:4495:1: (lv_default_14_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4495:1: (lv_default_14_0= ruleXExpression )
                    // InternalSpeADL.g:4496:3: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_65);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_14_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // InternalSpeADL.g:4524:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // InternalSpeADL.g:4525:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // InternalSpeADL.g:4526:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // InternalSpeADL.g:4533:1: ruleXCasePart returns [EObject current=null] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_fallThrough_6_0=null;
        EObject lv_typeGuard_1_0 = null;

        EObject lv_case_3_0 = null;

        EObject lv_then_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4536:28: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
            // InternalSpeADL.g:4537:1: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            {
            // InternalSpeADL.g:4537:1: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            // InternalSpeADL.g:4537:2: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            {
            // InternalSpeADL.g:4537:2: ()
            // InternalSpeADL.g:4538:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:4543:2: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_ID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalSpeADL.g:4544:1: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    {
                    // InternalSpeADL.g:4544:1: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    // InternalSpeADL.g:4545:3: lv_typeGuard_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_66);
                    lv_typeGuard_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"typeGuard",
                              		lv_typeGuard_1_0, 
                              		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSpeADL.g:4561:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==75) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalSpeADL.g:4561:5: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
                    {
                    otherlv_2=(Token)match(input,75,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXCasePartAccess().getCaseKeyword_2_0());
                          
                    }
                    // InternalSpeADL.g:4565:1: ( (lv_case_3_0= ruleXExpression ) )
                    // InternalSpeADL.g:4566:1: (lv_case_3_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4566:1: (lv_case_3_0= ruleXExpression )
                    // InternalSpeADL.g:4567:3: lv_case_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_67);
                    lv_case_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"case",
                              		lv_case_3_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSpeADL.g:4583:4: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==16) ) {
                alt85=1;
            }
            else if ( (LA85_0==19) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalSpeADL.g:4583:5: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    {
                    // InternalSpeADL.g:4583:5: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    // InternalSpeADL.g:4583:7: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
                    {
                    otherlv_4=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0());
                          
                    }
                    // InternalSpeADL.g:4587:1: ( (lv_then_5_0= ruleXExpression ) )
                    // InternalSpeADL.g:4588:1: (lv_then_5_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4588:1: (lv_then_5_0= ruleXExpression )
                    // InternalSpeADL.g:4589:3: lv_then_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_then_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_5_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:4606:6: ( (lv_fallThrough_6_0= ',' ) )
                    {
                    // InternalSpeADL.g:4606:6: ( (lv_fallThrough_6_0= ',' ) )
                    // InternalSpeADL.g:4607:1: (lv_fallThrough_6_0= ',' )
                    {
                    // InternalSpeADL.g:4607:1: (lv_fallThrough_6_0= ',' )
                    // InternalSpeADL.g:4608:3: lv_fallThrough_6_0= ','
                    {
                    lv_fallThrough_6_0=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_fallThrough_6_0, grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXCasePartRule());
                      	        }
                             		setWithLastConsumed(current, "fallThrough", true, ",");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // InternalSpeADL.g:4629:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // InternalSpeADL.g:4630:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // InternalSpeADL.g:4631:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // InternalSpeADL.g:4638:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4641:28: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:4642:1: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:4642:1: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // InternalSpeADL.g:4642:2: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:4642:2: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
            // InternalSpeADL.g:4642:3: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            {
            // InternalSpeADL.g:4650:5: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            // InternalSpeADL.g:4650:6: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
            {
            // InternalSpeADL.g:4650:6: ()
            // InternalSpeADL.g:4651:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
                  
            }
            // InternalSpeADL.g:4664:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // InternalSpeADL.g:4665:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // InternalSpeADL.g:4665:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // InternalSpeADL.g:4666:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0()); 
              	    
            }
            pushFollow(FOLLOW_7);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_3_0, 
                      		"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
                  
            }

            }


            }

            // InternalSpeADL.g:4686:3: ( (lv_forExpression_5_0= ruleXExpression ) )
            // InternalSpeADL.g:4687:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // InternalSpeADL.g:4687:1: (lv_forExpression_5_0= ruleXExpression )
            // InternalSpeADL.g:4688:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_5_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
                  
            }
            // InternalSpeADL.g:4708:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // InternalSpeADL.g:4709:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // InternalSpeADL.g:4709:1: (lv_eachExpression_7_0= ruleXExpression )
            // InternalSpeADL.g:4710:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_7_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXBasicForLoopExpression"
    // InternalSpeADL.g:4734:1: entryRuleXBasicForLoopExpression returns [EObject current=null] : iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
    public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBasicForLoopExpression = null;


        try {
            // InternalSpeADL.g:4735:2: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
            // InternalSpeADL.g:4736:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBasicForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBasicForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBasicForLoopExpression"


    // $ANTLR start "ruleXBasicForLoopExpression"
    // InternalSpeADL.g:4743:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
    public final EObject ruleXBasicForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_initExpressions_3_0 = null;

        EObject lv_initExpressions_5_0 = null;

        EObject lv_expression_7_0 = null;

        EObject lv_updateExpressions_9_0 = null;

        EObject lv_updateExpressions_11_0 = null;

        EObject lv_eachExpression_13_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4746:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:4747:1: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:4747:1: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            // InternalSpeADL.g:4747:2: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:4747:2: ()
            // InternalSpeADL.g:4748:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalSpeADL.g:4761:1: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( ((LA87_0>=RULE_ID && LA87_0<=RULE_DECIMAL)||LA87_0==14||LA87_0==18||LA87_0==24||LA87_0==40||(LA87_0>=56 && LA87_0<=57)||LA87_0==62||LA87_0==68||LA87_0==71||LA87_0==73||(LA87_0>=76 && LA87_0<=93)||LA87_0==95) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalSpeADL.g:4761:2: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    {
                    // InternalSpeADL.g:4761:2: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
                    // InternalSpeADL.g:4762:1: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    {
                    // InternalSpeADL.g:4762:1: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    // InternalSpeADL.g:4763:3: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_69);
                    lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      	        }
                             		add(
                             			current, 
                             			"initExpressions",
                              		lv_initExpressions_3_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:4779:2: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==19) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalSpeADL.g:4779:4: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_70); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:4783:1: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    // InternalSpeADL.g:4784:1: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    {
                    	    // InternalSpeADL.g:4784:1: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    // InternalSpeADL.g:4785:3: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_69);
                    	    lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"initExpressions",
                    	              		lv_initExpressions_5_0, 
                    	              		"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,70,FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
                  
            }
            // InternalSpeADL.g:4805:1: ( (lv_expression_7_0= ruleXExpression ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=RULE_ID && LA88_0<=RULE_DECIMAL)||LA88_0==14||LA88_0==18||LA88_0==24||LA88_0==40||(LA88_0>=56 && LA88_0<=57)||LA88_0==62||LA88_0==68||LA88_0==71||LA88_0==73||(LA88_0>=76 && LA88_0<=78)||(LA88_0>=81 && LA88_0<=93)||LA88_0==95) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalSpeADL.g:4806:1: (lv_expression_7_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4806:1: (lv_expression_7_0= ruleXExpression )
                    // InternalSpeADL.g:4807:3: lv_expression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_72);
                    lv_expression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_7_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,70,FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
                  
            }
            // InternalSpeADL.g:4827:1: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=RULE_ID && LA90_0<=RULE_DECIMAL)||LA90_0==14||LA90_0==18||LA90_0==24||LA90_0==40||(LA90_0>=56 && LA90_0<=57)||LA90_0==62||LA90_0==68||LA90_0==71||LA90_0==73||(LA90_0>=76 && LA90_0<=78)||(LA90_0>=81 && LA90_0<=93)||LA90_0==95) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalSpeADL.g:4827:2: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    {
                    // InternalSpeADL.g:4827:2: ( (lv_updateExpressions_9_0= ruleXExpression ) )
                    // InternalSpeADL.g:4828:1: (lv_updateExpressions_9_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:4828:1: (lv_updateExpressions_9_0= ruleXExpression )
                    // InternalSpeADL.g:4829:3: lv_updateExpressions_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_15);
                    lv_updateExpressions_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      	        }
                             		add(
                             			current, 
                             			"updateExpressions",
                              		lv_updateExpressions_9_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:4845:2: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==19) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // InternalSpeADL.g:4845:4: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    {
                    	    otherlv_10=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:4849:1: ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    // InternalSpeADL.g:4850:1: (lv_updateExpressions_11_0= ruleXExpression )
                    	    {
                    	    // InternalSpeADL.g:4850:1: (lv_updateExpressions_11_0= ruleXExpression )
                    	    // InternalSpeADL.g:4851:3: lv_updateExpressions_11_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_updateExpressions_11_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"updateExpressions",
                    	              		lv_updateExpressions_11_0, 
                    	              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
                  
            }
            // InternalSpeADL.g:4871:1: ( (lv_eachExpression_13_0= ruleXExpression ) )
            // InternalSpeADL.g:4872:1: (lv_eachExpression_13_0= ruleXExpression )
            {
            // InternalSpeADL.g:4872:1: (lv_eachExpression_13_0= ruleXExpression )
            // InternalSpeADL.g:4873:3: lv_eachExpression_13_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_13_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_13_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBasicForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // InternalSpeADL.g:4897:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // InternalSpeADL.g:4898:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // InternalSpeADL.g:4899:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // InternalSpeADL.g:4906:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4909:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:4910:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:4910:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // InternalSpeADL.g:4910:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:4910:2: ()
            // InternalSpeADL.g:4911:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,77,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalSpeADL.g:4924:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // InternalSpeADL.g:4925:1: (lv_predicate_3_0= ruleXExpression )
            {
            // InternalSpeADL.g:4925:1: (lv_predicate_3_0= ruleXExpression )
            // InternalSpeADL.g:4926:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalSpeADL.g:4946:1: ( (lv_body_5_0= ruleXExpression ) )
            // InternalSpeADL.g:4947:1: (lv_body_5_0= ruleXExpression )
            {
            // InternalSpeADL.g:4947:1: (lv_body_5_0= ruleXExpression )
            // InternalSpeADL.g:4948:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // InternalSpeADL.g:4972:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // InternalSpeADL.g:4973:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // InternalSpeADL.g:4974:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // InternalSpeADL.g:4981:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:4984:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // InternalSpeADL.g:4985:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // InternalSpeADL.g:4985:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // InternalSpeADL.g:4985:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // InternalSpeADL.g:4985:2: ()
            // InternalSpeADL.g:4986:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,78,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // InternalSpeADL.g:4995:1: ( (lv_body_2_0= ruleXExpression ) )
            // InternalSpeADL.g:4996:1: (lv_body_2_0= ruleXExpression )
            {
            // InternalSpeADL.g:4996:1: (lv_body_2_0= ruleXExpression )
            // InternalSpeADL.g:4997:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_74);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_2_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,77,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // InternalSpeADL.g:5021:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // InternalSpeADL.g:5022:1: (lv_predicate_5_0= ruleXExpression )
            {
            // InternalSpeADL.g:5022:1: (lv_predicate_5_0= ruleXExpression )
            // InternalSpeADL.g:5023:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_5_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // InternalSpeADL.g:5051:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // InternalSpeADL.g:5052:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // InternalSpeADL.g:5053:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // InternalSpeADL.g:5060:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5063:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // InternalSpeADL.g:5064:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // InternalSpeADL.g:5064:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // InternalSpeADL.g:5064:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // InternalSpeADL.g:5064:2: ()
            // InternalSpeADL.g:5065:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,14,FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalSpeADL.g:5074:1: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0>=RULE_ID && LA92_0<=RULE_DECIMAL)||LA92_0==14||LA92_0==18||LA92_0==24||LA92_0==40||(LA92_0>=56 && LA92_0<=57)||LA92_0==62||LA92_0==68||LA92_0==71||LA92_0==73||(LA92_0>=76 && LA92_0<=93)||LA92_0==95) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalSpeADL.g:5074:2: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // InternalSpeADL.g:5074:2: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
            	    // InternalSpeADL.g:5075:1: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // InternalSpeADL.g:5075:1: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    // InternalSpeADL.g:5076:3: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_76);
            	    lv_expressions_2_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // InternalSpeADL.g:5092:2: (otherlv_3= ';' )?
            	    int alt91=2;
            	    int LA91_0 = input.LA(1);

            	    if ( (LA91_0==70) ) {
            	        alt91=1;
            	    }
            	    switch (alt91) {
            	        case 1 :
            	            // InternalSpeADL.g:5092:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,70,FOLLOW_75); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionOrVarDeclaration"
    // InternalSpeADL.g:5108:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] : iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
    public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionOrVarDeclaration = null;


        try {
            // InternalSpeADL.g:5109:2: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
            // InternalSpeADL.g:5110:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionOrVarDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionOrVarDeclaration"


    // $ANTLR start "ruleXExpressionOrVarDeclaration"
    // InternalSpeADL.g:5117:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5120:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // InternalSpeADL.g:5121:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // InternalSpeADL.g:5121:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( ((LA93_0>=79 && LA93_0<=80)) ) {
                alt93=1;
            }
            else if ( ((LA93_0>=RULE_ID && LA93_0<=RULE_DECIMAL)||LA93_0==14||LA93_0==18||LA93_0==24||LA93_0==40||(LA93_0>=56 && LA93_0<=57)||LA93_0==62||LA93_0==68||LA93_0==71||LA93_0==73||(LA93_0>=76 && LA93_0<=78)||(LA93_0>=81 && LA93_0<=93)||LA93_0==95) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalSpeADL.g:5122:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:5132:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionOrVarDeclaration"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // InternalSpeADL.g:5148:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // InternalSpeADL.g:5149:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // InternalSpeADL.g:5150:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // InternalSpeADL.g:5157:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5160:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // InternalSpeADL.g:5161:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // InternalSpeADL.g:5161:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // InternalSpeADL.g:5161:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // InternalSpeADL.g:5161:2: ()
            // InternalSpeADL.g:5162:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:5167:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==79) ) {
                alt94=1;
            }
            else if ( (LA94_0==80) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalSpeADL.g:5167:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // InternalSpeADL.g:5167:3: ( (lv_writeable_1_0= 'var' ) )
                    // InternalSpeADL.g:5168:1: (lv_writeable_1_0= 'var' )
                    {
                    // InternalSpeADL.g:5168:1: (lv_writeable_1_0= 'var' )
                    // InternalSpeADL.g:5169:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,79,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "writeable", true, "var");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:5183:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,80,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:5187:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_ID) ) {
                int LA95_1 = input.LA(2);

                if ( (synpred30_InternalSpeADL()) ) {
                    alt95=1;
                }
                else if ( (true) ) {
                    alt95=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 95, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalSpeADL.g:5187:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // InternalSpeADL.g:5187:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // InternalSpeADL.g:5187:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // InternalSpeADL.g:5195:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // InternalSpeADL.g:5195:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // InternalSpeADL.g:5195:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // InternalSpeADL.g:5196:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // InternalSpeADL.g:5196:1: (lv_type_3_0= ruleJvmTypeReference )
                    // InternalSpeADL.g:5197:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_4);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:5213:2: ( (lv_name_4_0= ruleValidID ) )
                    // InternalSpeADL.g:5214:1: (lv_name_4_0= ruleValidID )
                    {
                    // InternalSpeADL.g:5214:1: (lv_name_4_0= ruleValidID )
                    // InternalSpeADL.g:5215:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_17);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"org.eclipse.xtext.xbase.Xtype.ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:5232:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // InternalSpeADL.g:5232:6: ( (lv_name_5_0= ruleValidID ) )
                    // InternalSpeADL.g:5233:1: (lv_name_5_0= ruleValidID )
                    {
                    // InternalSpeADL.g:5233:1: (lv_name_5_0= ruleValidID )
                    // InternalSpeADL.g:5234:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_17);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"org.eclipse.xtext.xbase.Xtype.ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSpeADL.g:5250:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==27) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalSpeADL.g:5250:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalSpeADL.g:5254:1: ( (lv_right_7_0= ruleXExpression ) )
                    // InternalSpeADL.g:5255:1: (lv_right_7_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:5255:1: (lv_right_7_0= ruleXExpression )
                    // InternalSpeADL.g:5256:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // InternalSpeADL.g:5280:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // InternalSpeADL.g:5281:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // InternalSpeADL.g:5282:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // InternalSpeADL.g:5289:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5292:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalSpeADL.g:5293:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalSpeADL.g:5293:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // InternalSpeADL.g:5293:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalSpeADL.g:5293:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_ID) ) {
                int LA97_1 = input.LA(2);

                if ( (LA97_1==RULE_ID||LA97_1==18||LA97_1==34) ) {
                    alt97=1;
                }
            }
            switch (alt97) {
                case 1 :
                    // InternalSpeADL.g:5294:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // InternalSpeADL.g:5294:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // InternalSpeADL.g:5295:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_4);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"parameterType",
                              		lv_parameterType_0_0, 
                              		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSpeADL.g:5311:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:5312:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:5312:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:5313:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // InternalSpeADL.g:5337:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // InternalSpeADL.g:5338:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // InternalSpeADL.g:5339:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // InternalSpeADL.g:5346:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5349:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalSpeADL.g:5350:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalSpeADL.g:5350:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // InternalSpeADL.g:5350:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalSpeADL.g:5350:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // InternalSpeADL.g:5351:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // InternalSpeADL.g:5351:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // InternalSpeADL.g:5352:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"parameterType",
                      		lv_parameterType_0_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:5368:2: ( (lv_name_1_0= ruleValidID ) )
            // InternalSpeADL.g:5369:1: (lv_name_1_0= ruleValidID )
            {
            // InternalSpeADL.g:5369:1: (lv_name_1_0= ruleValidID )
            // InternalSpeADL.g:5370:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // InternalSpeADL.g:5394:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // InternalSpeADL.g:5395:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // InternalSpeADL.g:5396:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // InternalSpeADL.g:5403:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_featureCallArguments_8_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_11_0 = null;

        EObject lv_featureCallArguments_13_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5406:28: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
            // InternalSpeADL.g:5407:1: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            {
            // InternalSpeADL.g:5407:1: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            // InternalSpeADL.g:5407:2: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            {
            // InternalSpeADL.g:5407:2: ()
            // InternalSpeADL.g:5408:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:5413:2: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==40) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalSpeADL.g:5413:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
                          
                    }
                    // InternalSpeADL.g:5417:1: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // InternalSpeADL.g:5418:1: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalSpeADL.g:5418:1: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // InternalSpeADL.g:5419:3: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_47);
                    lv_typeArguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_2_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:5435:2: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==19) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalSpeADL.g:5435:4: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:5439:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalSpeADL.g:5440:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalSpeADL.g:5440:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // InternalSpeADL.g:5441:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_47);
                    	    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_4_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,41,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:5461:3: ( ( ruleIdOrSuper ) )
            // InternalSpeADL.g:5462:1: ( ruleIdOrSuper )
            {
            // InternalSpeADL.g:5462:1: ( ruleIdOrSuper )
            // InternalSpeADL.g:5463:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_77);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:5476:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt102=2;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    // InternalSpeADL.g:5476:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // InternalSpeADL.g:5476:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // InternalSpeADL.g:5476:4: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // InternalSpeADL.g:5483:1: (lv_explicitOperationCall_7_0= '(' )
                    // InternalSpeADL.g:5484:3: lv_explicitOperationCall_7_0= '('
                    {
                    lv_explicitOperationCall_7_0=(Token)match(input,24,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_7_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:5497:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt101=3;
                    alt101 = dfa101.predict(input);
                    switch (alt101) {
                        case 1 :
                            // InternalSpeADL.g:5497:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // InternalSpeADL.g:5497:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // InternalSpeADL.g:5497:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // InternalSpeADL.g:5514:1: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // InternalSpeADL.g:5515:3: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_50);
                            lv_featureCallArguments_8_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_8_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpeADL.g:5532:6: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // InternalSpeADL.g:5532:6: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // InternalSpeADL.g:5532:7: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // InternalSpeADL.g:5532:7: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // InternalSpeADL.g:5533:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // InternalSpeADL.g:5533:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            // InternalSpeADL.g:5534:3: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_15);
                            lv_featureCallArguments_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_9_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpeADL.g:5550:2: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop100:
                            do {
                                int alt100=2;
                                int LA100_0 = input.LA(1);

                                if ( (LA100_0==19) ) {
                                    alt100=1;
                                }


                                switch (alt100) {
                            	case 1 :
                            	    // InternalSpeADL.g:5550:4: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    otherlv_10=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
                            	          
                            	    }
                            	    // InternalSpeADL.g:5554:1: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // InternalSpeADL.g:5555:1: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // InternalSpeADL.g:5555:1: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // InternalSpeADL.g:5556:3: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_15);
                            	    lv_featureCallArguments_11_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_11_0, 
                            	              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop100;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,25,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:5576:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            int alt103=2;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // InternalSpeADL.g:5576:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
                    {
                    // InternalSpeADL.g:5579:1: (lv_featureCallArguments_13_0= ruleXClosure )
                    // InternalSpeADL.g:5580:3: lv_featureCallArguments_13_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_featureCallArguments_13_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"featureCallArguments",
                              		lv_featureCallArguments_13_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleFeatureCallID"
    // InternalSpeADL.g:5604:1: entryRuleFeatureCallID returns [String current=null] : iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
    public final String entryRuleFeatureCallID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCallID = null;


        try {
            // InternalSpeADL.g:5605:2: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
            // InternalSpeADL.g:5606:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallID=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // InternalSpeADL.g:5613:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5616:28: ( (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' ) )
            // InternalSpeADL.g:5617:1: (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' )
            {
            // InternalSpeADL.g:5617:1: (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' )
            int alt104=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt104=1;
                }
                break;
            case 81:
                {
                alt104=2;
                }
                break;
            case 82:
                {
                alt104=3;
                }
                break;
            case 83:
                {
                alt104=4;
                }
                break;
            case 84:
                {
                alt104=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalSpeADL.g:5618:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureCallIDAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ValidID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:5630:2: kw= 'extends'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:5637:2: kw= 'static'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpeADL.g:5644:2: kw= 'import'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpeADL.g:5651:2: kw= 'extension'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRuleIdOrSuper"
    // InternalSpeADL.g:5664:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // InternalSpeADL.g:5665:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // InternalSpeADL.g:5666:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // InternalSpeADL.g:5673:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FeatureCallID_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5676:28: ( (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' ) )
            // InternalSpeADL.g:5677:1: (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' )
            {
            // InternalSpeADL.g:5677:1: (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_ID||(LA105_0>=81 && LA105_0<=84)) ) {
                alt105=1;
            }
            else if ( (LA105_0==85) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalSpeADL.g:5678:5: this_FeatureCallID_0= ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCallID_0=ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FeatureCallID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:5690:2: kw= 'super'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleXConstructorCall"
    // InternalSpeADL.g:5703:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // InternalSpeADL.g:5704:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // InternalSpeADL.g:5705:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // InternalSpeADL.g:5712:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_explicitConstructorCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_arguments_14_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:5715:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // InternalSpeADL.g:5716:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // InternalSpeADL.g:5716:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // InternalSpeADL.g:5716:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // InternalSpeADL.g:5716:2: ()
            // InternalSpeADL.g:5717:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,86,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // InternalSpeADL.g:5726:1: ( ( ruleQualifiedName ) )
            // InternalSpeADL.g:5727:1: ( ruleQualifiedName )
            {
            // InternalSpeADL.g:5727:1: ( ruleQualifiedName )
            // InternalSpeADL.g:5728:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_78);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:5741:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt107=2;
            alt107 = dfa107.predict(input);
            switch (alt107) {
                case 1 :
                    // InternalSpeADL.g:5741:3: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // InternalSpeADL.g:5741:3: ( ( '<' )=>otherlv_3= '<' )
                    // InternalSpeADL.g:5741:4: ( '<' )=>otherlv_3= '<'
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }

                    }

                    // InternalSpeADL.g:5746:2: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // InternalSpeADL.g:5747:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalSpeADL.g:5747:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // InternalSpeADL.g:5748:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_47);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_4_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:5764:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==19) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // InternalSpeADL.g:5764:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // InternalSpeADL.g:5768:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalSpeADL.g:5769:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalSpeADL.g:5769:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // InternalSpeADL.g:5770:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_47);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_6_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop106;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,41,FOLLOW_77); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:5790:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt110=2;
            alt110 = dfa110.predict(input);
            switch (alt110) {
                case 1 :
                    // InternalSpeADL.g:5790:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // InternalSpeADL.g:5790:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
                    // InternalSpeADL.g:5790:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
                    {
                    // InternalSpeADL.g:5797:1: (lv_explicitConstructorCall_8_0= '(' )
                    // InternalSpeADL.g:5798:3: lv_explicitConstructorCall_8_0= '('
                    {
                    lv_explicitConstructorCall_8_0=(Token)match(input,24,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXConstructorCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitConstructorCall", true, "(");
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:5811:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt109=3;
                    alt109 = dfa109.predict(input);
                    switch (alt109) {
                        case 1 :
                            // InternalSpeADL.g:5811:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // InternalSpeADL.g:5811:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // InternalSpeADL.g:5811:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // InternalSpeADL.g:5828:1: (lv_arguments_9_0= ruleXShortClosure )
                            // InternalSpeADL.g:5829:3: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_50);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_9_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpeADL.g:5846:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // InternalSpeADL.g:5846:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // InternalSpeADL.g:5846:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // InternalSpeADL.g:5846:7: ( (lv_arguments_10_0= ruleXExpression ) )
                            // InternalSpeADL.g:5847:1: (lv_arguments_10_0= ruleXExpression )
                            {
                            // InternalSpeADL.g:5847:1: (lv_arguments_10_0= ruleXExpression )
                            // InternalSpeADL.g:5848:3: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_15);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_10_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpeADL.g:5864:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop108:
                            do {
                                int alt108=2;
                                int LA108_0 = input.LA(1);

                                if ( (LA108_0==19) ) {
                                    alt108=1;
                                }


                                switch (alt108) {
                            	case 1 :
                            	    // InternalSpeADL.g:5864:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // InternalSpeADL.g:5868:1: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // InternalSpeADL.g:5869:1: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // InternalSpeADL.g:5869:1: (lv_arguments_12_0= ruleXExpression )
                            	    // InternalSpeADL.g:5870:3: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_15);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_12_0, 
                            	              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop108;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,25,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // InternalSpeADL.g:5890:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt111=2;
            alt111 = dfa111.predict(input);
            switch (alt111) {
                case 1 :
                    // InternalSpeADL.g:5890:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // InternalSpeADL.g:5893:1: (lv_arguments_14_0= ruleXClosure )
                    // InternalSpeADL.g:5894:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_14_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // InternalSpeADL.g:5918:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // InternalSpeADL.g:5919:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // InternalSpeADL.g:5920:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // InternalSpeADL.g:5927:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:5930:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalSpeADL.g:5931:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalSpeADL.g:5931:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalSpeADL.g:5931:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalSpeADL.g:5931:2: ()
            // InternalSpeADL.g:5932:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:5937:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==87) ) {
                alt112=1;
            }
            else if ( (LA112_0==88) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalSpeADL.g:5937:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:5942:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalSpeADL.g:5942:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalSpeADL.g:5943:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalSpeADL.g:5943:1: (lv_isTrue_2_0= 'true' )
                    // InternalSpeADL.g:5944:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // InternalSpeADL.g:5965:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // InternalSpeADL.g:5966:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // InternalSpeADL.g:5967:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // InternalSpeADL.g:5974:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:5977:28: ( ( () otherlv_1= 'null' ) )
            // InternalSpeADL.g:5978:1: ( () otherlv_1= 'null' )
            {
            // InternalSpeADL.g:5978:1: ( () otherlv_1= 'null' )
            // InternalSpeADL.g:5978:2: () otherlv_1= 'null'
            {
            // InternalSpeADL.g:5978:2: ()
            // InternalSpeADL.g:5979:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // InternalSpeADL.g:5996:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // InternalSpeADL.g:5997:2: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // InternalSpeADL.g:5998:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // InternalSpeADL.g:6005:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6008:28: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // InternalSpeADL.g:6009:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // InternalSpeADL.g:6009:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // InternalSpeADL.g:6009:2: () ( (lv_value_1_0= ruleNumber ) )
            {
            // InternalSpeADL.g:6009:2: ()
            // InternalSpeADL.g:6010:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:6015:2: ( (lv_value_1_0= ruleNumber ) )
            // InternalSpeADL.g:6016:1: (lv_value_1_0= ruleNumber )
            {
            // InternalSpeADL.g:6016:1: (lv_value_1_0= ruleNumber )
            // InternalSpeADL.g:6017:3: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.eclipse.xtext.xbase.Xbase.Number");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // InternalSpeADL.g:6041:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // InternalSpeADL.g:6042:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // InternalSpeADL.g:6043:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // InternalSpeADL.g:6050:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:6053:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalSpeADL.g:6054:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalSpeADL.g:6054:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalSpeADL.g:6054:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalSpeADL.g:6054:2: ()
            // InternalSpeADL.g:6055:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalSpeADL.g:6060:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalSpeADL.g:6061:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalSpeADL.g:6061:1: (lv_value_1_0= RULE_STRING )
            // InternalSpeADL.g:6062:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.eclipse.xtext.xbase.Xtype.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // InternalSpeADL.g:6086:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // InternalSpeADL.g:6087:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // InternalSpeADL.g:6088:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // InternalSpeADL.g:6095:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_arrayDimensions_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6098:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
            // InternalSpeADL.g:6099:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            {
            // InternalSpeADL.g:6099:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            // InternalSpeADL.g:6099:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
            {
            // InternalSpeADL.g:6099:2: ()
            // InternalSpeADL.g:6100:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,90,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalSpeADL.g:6113:1: ( ( ruleQualifiedName ) )
            // InternalSpeADL.g:6114:1: ( ruleQualifiedName )
            {
            // InternalSpeADL.g:6114:1: ( ruleQualifiedName )
            // InternalSpeADL.g:6115:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_79);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:6128:2: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==18) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalSpeADL.g:6129:1: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // InternalSpeADL.g:6129:1: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // InternalSpeADL.g:6130:3: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_79);
            	    lv_arrayDimensions_4_0=ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXTypeLiteralRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"arrayDimensions",
            	              		lv_arrayDimensions_4_0, 
            	              		"org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop113;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // InternalSpeADL.g:6158:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // InternalSpeADL.g:6159:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // InternalSpeADL.g:6160:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // InternalSpeADL.g:6167:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6170:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:6171:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:6171:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // InternalSpeADL.g:6171:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:6171:2: ()
            // InternalSpeADL.g:6172:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,91,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // InternalSpeADL.g:6181:1: ( (lv_expression_2_0= ruleXExpression ) )
            // InternalSpeADL.g:6182:1: (lv_expression_2_0= ruleXExpression )
            {
            // InternalSpeADL.g:6182:1: (lv_expression_2_0= ruleXExpression )
            // InternalSpeADL.g:6183:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // InternalSpeADL.g:6207:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // InternalSpeADL.g:6208:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // InternalSpeADL.g:6209:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // InternalSpeADL.g:6216:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6219:28: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // InternalSpeADL.g:6220:1: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // InternalSpeADL.g:6220:1: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            // InternalSpeADL.g:6220:2: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // InternalSpeADL.g:6220:2: ()
            // InternalSpeADL.g:6221:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,92,FOLLOW_80); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // InternalSpeADL.g:6230:1: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt114=2;
            alt114 = dfa114.predict(input);
            switch (alt114) {
                case 1 :
                    // InternalSpeADL.g:6230:2: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:6258:1: (lv_expression_2_0= ruleXExpression )
                    // InternalSpeADL.g:6259:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // InternalSpeADL.g:6283:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // InternalSpeADL.g:6284:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // InternalSpeADL.g:6285:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // InternalSpeADL.g:6292:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6295:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // InternalSpeADL.g:6296:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // InternalSpeADL.g:6296:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // InternalSpeADL.g:6296:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // InternalSpeADL.g:6296:2: ()
            // InternalSpeADL.g:6297:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,93,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // InternalSpeADL.g:6306:1: ( (lv_expression_2_0= ruleXExpression ) )
            // InternalSpeADL.g:6307:1: (lv_expression_2_0= ruleXExpression )
            {
            // InternalSpeADL.g:6307:1: (lv_expression_2_0= ruleXExpression )
            // InternalSpeADL.g:6308:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_81);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:6324:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==96) ) {
                alt117=1;
            }
            else if ( (LA117_0==94) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // InternalSpeADL.g:6324:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // InternalSpeADL.g:6324:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // InternalSpeADL.g:6324:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // InternalSpeADL.g:6324:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt115=0;
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==96) ) {
                            int LA115_2 = input.LA(2);

                            if ( (synpred39_InternalSpeADL()) ) {
                                alt115=1;
                            }


                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalSpeADL.g:6324:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // InternalSpeADL.g:6326:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // InternalSpeADL.g:6327:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_82);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"catchClauses",
                    	              		lv_catchClauses_3_0, 
                    	              		"org.eclipse.xtext.xbase.Xbase.XCatchClause");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt115 >= 1 ) break loop115;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(115, input);
                                throw eee;
                        }
                        cnt115++;
                    } while (true);

                    // InternalSpeADL.g:6343:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==94) ) {
                        int LA116_1 = input.LA(2);

                        if ( (synpred40_InternalSpeADL()) ) {
                            alt116=1;
                        }
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalSpeADL.g:6343:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // InternalSpeADL.g:6343:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // InternalSpeADL.g:6343:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,94,FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // InternalSpeADL.g:6348:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // InternalSpeADL.g:6349:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // InternalSpeADL.g:6349:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // InternalSpeADL.g:6350:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finallyExpression",
                                      		lv_finallyExpression_5_0, 
                                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:6367:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // InternalSpeADL.g:6367:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // InternalSpeADL.g:6367:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,94,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // InternalSpeADL.g:6371:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // InternalSpeADL.g:6372:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // InternalSpeADL.g:6372:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // InternalSpeADL.g:6373:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyExpression",
                              		lv_finallyExpression_7_0, 
                              		"org.eclipse.xtext.xbase.Xbase.XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXSynchronizedExpression"
    // InternalSpeADL.g:6397:1: entryRuleXSynchronizedExpression returns [EObject current=null] : iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
    public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSynchronizedExpression = null;


        try {
            // InternalSpeADL.g:6398:2: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
            // InternalSpeADL.g:6399:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSynchronizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSynchronizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSynchronizedExpression"


    // $ANTLR start "ruleXSynchronizedExpression"
    // InternalSpeADL.g:6406:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXSynchronizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6409:28: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:6410:1: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:6410:1: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            // InternalSpeADL.g:6410:2: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:6410:2: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
            // InternalSpeADL.g:6410:3: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            {
            // InternalSpeADL.g:6413:5: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            // InternalSpeADL.g:6413:6: () otherlv_1= 'synchronized' otherlv_2= '('
            {
            // InternalSpeADL.g:6413:6: ()
            // InternalSpeADL.g:6414:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,95,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
                  
            }

            }


            }

            // InternalSpeADL.g:6427:3: ( (lv_param_3_0= ruleXExpression ) )
            // InternalSpeADL.g:6428:1: (lv_param_3_0= ruleXExpression )
            {
            // InternalSpeADL.g:6428:1: (lv_param_3_0= ruleXExpression )
            // InternalSpeADL.g:6429:3: lv_param_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_param_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"param",
                      		lv_param_3_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }
            // InternalSpeADL.g:6449:1: ( (lv_expression_5_0= ruleXExpression ) )
            // InternalSpeADL.g:6450:1: (lv_expression_5_0= ruleXExpression )
            {
            // InternalSpeADL.g:6450:1: (lv_expression_5_0= ruleXExpression )
            // InternalSpeADL.g:6451:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSynchronizedExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // InternalSpeADL.g:6475:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // InternalSpeADL.g:6476:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // InternalSpeADL.g:6477:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // InternalSpeADL.g:6484:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6487:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // InternalSpeADL.g:6488:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // InternalSpeADL.g:6488:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // InternalSpeADL.g:6488:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // InternalSpeADL.g:6488:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // InternalSpeADL.g:6488:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,96,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalSpeADL.g:6497:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // InternalSpeADL.g:6498:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // InternalSpeADL.g:6498:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // InternalSpeADL.g:6499:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"org.eclipse.xtext.xbase.Xbase.FullJvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalSpeADL.g:6519:1: ( (lv_expression_4_0= ruleXExpression ) )
            // InternalSpeADL.g:6520:1: (lv_expression_4_0= ruleXExpression )
            {
            // InternalSpeADL.g:6520:1: (lv_expression_4_0= ruleXExpression )
            // InternalSpeADL.g:6521:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"org.eclipse.xtext.xbase.Xbase.XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalSpeADL.g:6545:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSpeADL.g:6546:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSpeADL.g:6547:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalSpeADL.g:6554:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6557:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // InternalSpeADL.g:6558:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // InternalSpeADL.g:6558:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // InternalSpeADL.g:6559:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_83);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpeADL.g:6569:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==34) ) {
                    int LA118_2 = input.LA(2);

                    if ( (LA118_2==RULE_ID) ) {
                        int LA118_3 = input.LA(3);

                        if ( (synpred43_InternalSpeADL()) ) {
                            alt118=1;
                        }


                    }


                }


                switch (alt118) {
            	case 1 :
            	    // InternalSpeADL.g:6569:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // InternalSpeADL.g:6569:2: ( ( '.' )=>kw= '.' )
            	    // InternalSpeADL.g:6569:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_83);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // InternalSpeADL.g:6596:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalSpeADL.g:6600:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalSpeADL.g:6601:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalSpeADL.g:6611:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalSpeADL.g:6615:28: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // InternalSpeADL.g:6616:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // InternalSpeADL.g:6616:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==RULE_HEX) ) {
                alt122=1;
            }
            else if ( ((LA122_0>=RULE_INT && LA122_0<=RULE_DECIMAL)) ) {
                alt122=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // InternalSpeADL.g:6616:6: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:6624:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // InternalSpeADL.g:6624:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // InternalSpeADL.g:6624:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // InternalSpeADL.g:6624:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==RULE_INT) ) {
                        alt119=1;
                    }
                    else if ( (LA119_0==RULE_DECIMAL) ) {
                        alt119=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 119, 0, input);

                        throw nvae;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalSpeADL.g:6624:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_83); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpeADL.g:6632:10: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_83); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_DECIMAL_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // InternalSpeADL.g:6639:2: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==34) ) {
                        int LA121_1 = input.LA(2);

                        if ( ((LA121_1>=RULE_INT && LA121_1<=RULE_DECIMAL)) ) {
                            alt121=1;
                        }
                    }
                    switch (alt121) {
                        case 1 :
                            // InternalSpeADL.g:6640:2: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,34,FOLLOW_84); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); 
                                  
                            }
                            // InternalSpeADL.g:6645:1: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt120=2;
                            int LA120_0 = input.LA(1);

                            if ( (LA120_0==RULE_INT) ) {
                                alt120=1;
                            }
                            else if ( (LA120_0==RULE_DECIMAL) ) {
                                alt120=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 120, 0, input);

                                throw nvae;
                            }
                            switch (alt120) {
                                case 1 :
                                    // InternalSpeADL.g:6645:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_INT_4);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalSpeADL.g:6653:10: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_DECIMAL_5);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1()); 
                                          
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleArrayBrackets"
    // InternalSpeADL.g:6673:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // InternalSpeADL.g:6674:2: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // InternalSpeADL.g:6675:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // InternalSpeADL.g:6682:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:6685:28: ( (kw= '[' kw= ']' ) )
            // InternalSpeADL.g:6686:1: (kw= '[' kw= ']' )
            {
            // InternalSpeADL.g:6686:1: (kw= '[' kw= ']' )
            // InternalSpeADL.g:6687:2: kw= '[' kw= ']'
            {
            kw=(Token)match(input,18,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
                  
            }
            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // InternalSpeADL.g:6708:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // InternalSpeADL.g:6709:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // InternalSpeADL.g:6710:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // InternalSpeADL.g:6717:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6720:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // InternalSpeADL.g:6721:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // InternalSpeADL.g:6721:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_ID) ) {
                alt123=1;
            }
            else if ( (LA123_0==97) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalSpeADL.g:6722:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:6732:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // InternalSpeADL.g:6748:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // InternalSpeADL.g:6749:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // InternalSpeADL.g:6750:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // InternalSpeADL.g:6757:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;

        EObject lv_constraints_4_0 = null;

        EObject lv_constraints_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6760:28: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // InternalSpeADL.g:6761:1: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // InternalSpeADL.g:6761:1: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // InternalSpeADL.g:6761:2: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // InternalSpeADL.g:6761:2: ()
            // InternalSpeADL.g:6762:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,97,FOLLOW_85); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // InternalSpeADL.g:6771:1: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt126=3;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==81) ) {
                alt126=1;
            }
            else if ( (LA126_0==85) ) {
                alt126=2;
            }
            switch (alt126) {
                case 1 :
                    // InternalSpeADL.g:6771:2: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // InternalSpeADL.g:6771:2: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // InternalSpeADL.g:6771:3: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // InternalSpeADL.g:6771:3: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // InternalSpeADL.g:6772:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // InternalSpeADL.g:6772:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // InternalSpeADL.g:6773:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_86);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:6789:2: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==98) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalSpeADL.g:6790:1: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // InternalSpeADL.g:6790:1: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // InternalSpeADL.g:6791:3: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_86);
                    	    lv_constraints_3_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_3_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop124;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:6808:6: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // InternalSpeADL.g:6808:6: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // InternalSpeADL.g:6808:7: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // InternalSpeADL.g:6808:7: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // InternalSpeADL.g:6809:1: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // InternalSpeADL.g:6809:1: (lv_constraints_4_0= ruleJvmLowerBound )
                    // InternalSpeADL.g:6810:3: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_86);
                    lv_constraints_4_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_4_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:6826:2: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop125:
                    do {
                        int alt125=2;
                        int LA125_0 = input.LA(1);

                        if ( (LA125_0==98) ) {
                            alt125=1;
                        }


                        switch (alt125) {
                    	case 1 :
                    	    // InternalSpeADL.g:6827:1: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // InternalSpeADL.g:6827:1: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // InternalSpeADL.g:6828:3: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_86);
                    	    lv_constraints_5_0=ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_5_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop125;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // InternalSpeADL.g:6852:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // InternalSpeADL.g:6853:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // InternalSpeADL.g:6854:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // InternalSpeADL.g:6861:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6864:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalSpeADL.g:6865:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalSpeADL.g:6865:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalSpeADL.g:6865:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,81,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // InternalSpeADL.g:6869:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalSpeADL.g:6870:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalSpeADL.g:6870:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalSpeADL.g:6871:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // InternalSpeADL.g:6895:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // InternalSpeADL.g:6896:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // InternalSpeADL.g:6897:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // InternalSpeADL.g:6904:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6907:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalSpeADL.g:6908:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalSpeADL.g:6908:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalSpeADL.g:6908:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,98,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // InternalSpeADL.g:6912:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalSpeADL.g:6913:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalSpeADL.g:6913:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalSpeADL.g:6914:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // InternalSpeADL.g:6938:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // InternalSpeADL.g:6939:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // InternalSpeADL.g:6940:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // InternalSpeADL.g:6947:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6950:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalSpeADL.g:6951:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalSpeADL.g:6951:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalSpeADL.g:6951:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,85,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // InternalSpeADL.g:6955:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalSpeADL.g:6956:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalSpeADL.g:6956:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalSpeADL.g:6957:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // InternalSpeADL.g:6981:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] : iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
    public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBoundAnded = null;


        try {
            // InternalSpeADL.g:6982:2: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
            // InternalSpeADL.g:6983:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // InternalSpeADL.g:6990:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:6993:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalSpeADL.g:6994:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalSpeADL.g:6994:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalSpeADL.g:6994:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,98,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // InternalSpeADL.g:6998:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalSpeADL.g:6999:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalSpeADL.g:6999:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalSpeADL.g:7000:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"fr.irit.smac.may.speadl.SpeADL.JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleJvmTypeParameter"
    // InternalSpeADL.g:7024:1: entryRuleJvmTypeParameter returns [EObject current=null] : iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF ;
    public final EObject entryRuleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeParameter = null;


        try {
            // InternalSpeADL.g:7025:2: (iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF )
            // InternalSpeADL.g:7026:2: iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeParameter"


    // $ANTLR start "ruleJvmTypeParameter"
    // InternalSpeADL.g:7033:1: ruleJvmTypeParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? ) ;
    public final EObject ruleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_constraints_1_0 = null;

        EObject lv_constraints_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:7036:28: ( ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? ) )
            // InternalSpeADL.g:7037:1: ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? )
            {
            // InternalSpeADL.g:7037:1: ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? )
            // InternalSpeADL.g:7037:2: ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )?
            {
            // InternalSpeADL.g:7037:2: ( (lv_name_0_0= ruleValidID ) )
            // InternalSpeADL.g:7038:1: (lv_name_0_0= ruleValidID )
            {
            // InternalSpeADL.g:7038:1: (lv_name_0_0= ruleValidID )
            // InternalSpeADL.g:7039:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getNameValidIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_87);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpeADL.g:7055:2: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==81) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalSpeADL.g:7055:3: ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // InternalSpeADL.g:7055:3: ( (lv_constraints_1_0= ruleJvmUpperBound ) )
                    // InternalSpeADL.g:7056:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    {
                    // InternalSpeADL.g:7056:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    // InternalSpeADL.g:7057:3: lv_constraints_1_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_86);
                    lv_constraints_1_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_1_0, 
                              		"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:7073:2: ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==98) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // InternalSpeADL.g:7074:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // InternalSpeADL.g:7074:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    // InternalSpeADL.g:7075:3: lv_constraints_2_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_86);
                    	    lv_constraints_2_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_2_0, 
                    	              		"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop127;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeParameter"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalSpeADL.g:7099:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalSpeADL.g:7100:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalSpeADL.g:7101:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalSpeADL.g:7108:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:7111:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
            // InternalSpeADL.g:7112:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            {
            // InternalSpeADL.g:7112:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            // InternalSpeADL.g:7113:5: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_22);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            kw=(Token)match(input,34,FOLLOW_88); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); 
                  
            }
            kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // InternalSpeADL.g:7143:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalSpeADL.g:7144:2: (iv_ruleValidID= ruleValidID EOF )
            // InternalSpeADL.g:7145:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalSpeADL.g:7152:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalSpeADL.g:7155:28: (this_ID_0= RULE_ID )
            // InternalSpeADL.g:7156:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportSection"
    // InternalSpeADL.g:7171:1: entryRuleXImportSection returns [EObject current=null] : iv_ruleXImportSection= ruleXImportSection EOF ;
    public final EObject entryRuleXImportSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportSection = null;


        try {
            // InternalSpeADL.g:7172:2: (iv_ruleXImportSection= ruleXImportSection EOF )
            // InternalSpeADL.g:7173:2: iv_ruleXImportSection= ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportSectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportSection=ruleXImportSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXImportSection"


    // $ANTLR start "ruleXImportSection"
    // InternalSpeADL.g:7180:1: ruleXImportSection returns [EObject current=null] : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final EObject ruleXImportSection() throws RecognitionException {
        EObject current = null;

        EObject lv_importDeclarations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:7183:28: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // InternalSpeADL.g:7184:1: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // InternalSpeADL.g:7184:1: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            int cnt129=0;
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==83) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // InternalSpeADL.g:7185:1: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // InternalSpeADL.g:7185:1: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // InternalSpeADL.g:7186:3: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXImportSectionAccess().getImportDeclarationsXImportDeclarationParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_89);
            	    lv_importDeclarations_0_0=ruleXImportDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXImportSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"importDeclarations",
            	              		lv_importDeclarations_0_0, 
            	              		"org.eclipse.xtext.xbase.Xtype.XImportDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt129 >= 1 ) break loop129;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(129, input);
                        throw eee;
                }
                cnt129++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXImportSection"


    // $ANTLR start "entryRuleXImportDeclaration"
    // InternalSpeADL.g:7210:1: entryRuleXImportDeclaration returns [EObject current=null] : iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
    public final EObject entryRuleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportDeclaration = null;


        try {
            // InternalSpeADL.g:7211:2: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
            // InternalSpeADL.g:7212:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // InternalSpeADL.g:7219:1: ruleXImportDeclaration returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final EObject ruleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_memberName_5_0 = null;

        AntlrDatatypeRuleToken lv_importedNamespace_7_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:7222:28: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // InternalSpeADL.g:7223:1: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // InternalSpeADL.g:7223:1: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // InternalSpeADL.g:7223:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            otherlv_0=(Token)match(input,83,FOLLOW_90); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
                  
            }
            // InternalSpeADL.g:7227:1: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt132=3;
            alt132 = dfa132.predict(input);
            switch (alt132) {
                case 1 :
                    // InternalSpeADL.g:7227:2: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // InternalSpeADL.g:7227:2: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // InternalSpeADL.g:7227:3: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // InternalSpeADL.g:7227:3: ( (lv_static_1_0= 'static' ) )
                    // InternalSpeADL.g:7228:1: (lv_static_1_0= 'static' )
                    {
                    // InternalSpeADL.g:7228:1: (lv_static_1_0= 'static' )
                    // InternalSpeADL.g:7229:3: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,82,FOLLOW_91); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "static", true, "static");
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:7242:2: ( (lv_extension_2_0= 'extension' ) )?
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==84) ) {
                        alt130=1;
                    }
                    switch (alt130) {
                        case 1 :
                            // InternalSpeADL.g:7243:1: (lv_extension_2_0= 'extension' )
                            {
                            // InternalSpeADL.g:7243:1: (lv_extension_2_0= 'extension' )
                            // InternalSpeADL.g:7244:3: lv_extension_2_0= 'extension'
                            {
                            lv_extension_2_0=(Token)match(input,84,FOLLOW_91); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              	        }
                                     		setWithLastConsumed(current, "extension", true, "extension");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalSpeADL.g:7257:3: ( ( ruleQualifiedNameInStaticImport ) )
                    // InternalSpeADL.g:7258:1: ( ruleQualifiedNameInStaticImport )
                    {
                    // InternalSpeADL.g:7258:1: ( ruleQualifiedNameInStaticImport )
                    // InternalSpeADL.g:7259:3: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_92);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpeADL.g:7272:2: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt131=2;
                    int LA131_0 = input.LA(1);

                    if ( (LA131_0==58) ) {
                        alt131=1;
                    }
                    else if ( (LA131_0==RULE_ID) ) {
                        alt131=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 0, input);

                        throw nvae;
                    }
                    switch (alt131) {
                        case 1 :
                            // InternalSpeADL.g:7272:3: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // InternalSpeADL.g:7272:3: ( (lv_wildcard_4_0= '*' ) )
                            // InternalSpeADL.g:7273:1: (lv_wildcard_4_0= '*' )
                            {
                            // InternalSpeADL.g:7273:1: (lv_wildcard_4_0= '*' )
                            // InternalSpeADL.g:7274:3: lv_wildcard_4_0= '*'
                            {
                            lv_wildcard_4_0=(Token)match(input,58,FOLLOW_93); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              	        }
                                     		setWithLastConsumed(current, "wildcard", true, "*");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpeADL.g:7288:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // InternalSpeADL.g:7288:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // InternalSpeADL.g:7289:1: (lv_memberName_5_0= ruleValidID )
                            {
                            // InternalSpeADL.g:7289:1: (lv_memberName_5_0= ruleValidID )
                            // InternalSpeADL.g:7290:3: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_93);
                            lv_memberName_5_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"memberName",
                                      		lv_memberName_5_0, 
                                      		"org.eclipse.xtext.xbase.Xtype.ValidID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpeADL.g:7307:6: ( ( ruleQualifiedName ) )
                    {
                    // InternalSpeADL.g:7307:6: ( ( ruleQualifiedName ) )
                    // InternalSpeADL.g:7308:1: ( ruleQualifiedName )
                    {
                    // InternalSpeADL.g:7308:1: ( ruleQualifiedName )
                    // InternalSpeADL.g:7309:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_93);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpeADL.g:7323:6: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // InternalSpeADL.g:7323:6: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // InternalSpeADL.g:7324:1: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // InternalSpeADL.g:7324:1: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // InternalSpeADL.g:7325:3: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_93);
                    lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"importedNamespace",
                              		lv_importedNamespace_7_0, 
                              		"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSpeADL.g:7341:3: (otherlv_8= ';' )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==70) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // InternalSpeADL.g:7341:5: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // InternalSpeADL.g:7353:1: entryRuleQualifiedNameInStaticImport returns [String current=null] : iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
    public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport = null;


        try {
            // InternalSpeADL.g:7354:2: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
            // InternalSpeADL.g:7355:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameInStaticImport.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // InternalSpeADL.g:7362:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // InternalSpeADL.g:7365:28: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
            // InternalSpeADL.g:7366:1: (this_ValidID_0= ruleValidID kw= '.' )+
            {
            // InternalSpeADL.g:7366:1: (this_ValidID_0= ruleValidID kw= '.' )+
            int cnt134=0;
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==RULE_ID) ) {
                    int LA134_2 = input.LA(2);

                    if ( (LA134_2==34) ) {
                        alt134=1;
                    }


                }


                switch (alt134) {
            	case 1 :
            	    // InternalSpeADL.g:7367:5: this_ValidID_0= ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_22);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,34,FOLLOW_94); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt134 >= 1 ) break loop134;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(134, input);
                        throw eee;
                }
                cnt134++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred1_InternalSpeADL
    public final void synpred1_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:1573:4: ( '[' )
        // InternalSpeADL.g:1573:6: '['
        {
        match(input,18,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalSpeADL

    // $ANTLR start synpred2_InternalSpeADL
    public final void synpred2_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:1730:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // InternalSpeADL.g:1730:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // InternalSpeADL.g:1730:4: ( () ( ( ruleOpMultiAssign ) ) )
        // InternalSpeADL.g:1730:5: () ( ( ruleOpMultiAssign ) )
        {
        // InternalSpeADL.g:1730:5: ()
        // InternalSpeADL.g:1731:1: 
        {
        }

        // InternalSpeADL.g:1731:2: ( ( ruleOpMultiAssign ) )
        // InternalSpeADL.g:1732:1: ( ruleOpMultiAssign )
        {
        // InternalSpeADL.g:1732:1: ( ruleOpMultiAssign )
        // InternalSpeADL.g:1733:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_2);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSpeADL

    // $ANTLR start synpred3_InternalSpeADL
    public final void synpred3_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:1924:3: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalSpeADL.g:1924:4: ( () ( ( ruleOpOr ) ) )
        {
        // InternalSpeADL.g:1924:4: ( () ( ( ruleOpOr ) ) )
        // InternalSpeADL.g:1924:5: () ( ( ruleOpOr ) )
        {
        // InternalSpeADL.g:1924:5: ()
        // InternalSpeADL.g:1925:1: 
        {
        }

        // InternalSpeADL.g:1925:2: ( ( ruleOpOr ) )
        // InternalSpeADL.g:1926:1: ( ruleOpOr )
        {
        // InternalSpeADL.g:1926:1: ( ruleOpOr )
        // InternalSpeADL.g:1927:3: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSpeADL

    // $ANTLR start synpred4_InternalSpeADL
    public final void synpred4_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2025:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalSpeADL.g:2025:4: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalSpeADL.g:2025:4: ( () ( ( ruleOpAnd ) ) )
        // InternalSpeADL.g:2025:5: () ( ( ruleOpAnd ) )
        {
        // InternalSpeADL.g:2025:5: ()
        // InternalSpeADL.g:2026:1: 
        {
        }

        // InternalSpeADL.g:2026:2: ( ( ruleOpAnd ) )
        // InternalSpeADL.g:2027:1: ( ruleOpAnd )
        {
        // InternalSpeADL.g:2027:1: ( ruleOpAnd )
        // InternalSpeADL.g:2028:3: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalSpeADL

    // $ANTLR start synpred5_InternalSpeADL
    public final void synpred5_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2126:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalSpeADL.g:2126:4: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalSpeADL.g:2126:4: ( () ( ( ruleOpEquality ) ) )
        // InternalSpeADL.g:2126:5: () ( ( ruleOpEquality ) )
        {
        // InternalSpeADL.g:2126:5: ()
        // InternalSpeADL.g:2127:1: 
        {
        }

        // InternalSpeADL.g:2127:2: ( ( ruleOpEquality ) )
        // InternalSpeADL.g:2128:1: ( ruleOpEquality )
        {
        // InternalSpeADL.g:2128:1: ( ruleOpEquality )
        // InternalSpeADL.g:2129:3: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalSpeADL

    // $ANTLR start synpred6_InternalSpeADL
    public final void synpred6_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2248:4: ( ( () 'instanceof' ) )
        // InternalSpeADL.g:2248:5: ( () 'instanceof' )
        {
        // InternalSpeADL.g:2248:5: ( () 'instanceof' )
        // InternalSpeADL.g:2248:6: () 'instanceof'
        {
        // InternalSpeADL.g:2248:6: ()
        // InternalSpeADL.g:2249:1: 
        {
        }

        match(input,49,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalSpeADL

    // $ANTLR start synpred7_InternalSpeADL
    public final void synpred7_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2279:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalSpeADL.g:2279:9: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalSpeADL.g:2279:9: ( () ( ( ruleOpCompare ) ) )
        // InternalSpeADL.g:2279:10: () ( ( ruleOpCompare ) )
        {
        // InternalSpeADL.g:2279:10: ()
        // InternalSpeADL.g:2280:1: 
        {
        }

        // InternalSpeADL.g:2280:2: ( ( ruleOpCompare ) )
        // InternalSpeADL.g:2281:1: ( ruleOpCompare )
        {
        // InternalSpeADL.g:2281:1: ( ruleOpCompare )
        // InternalSpeADL.g:2282:3: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalSpeADL

    // $ANTLR start synpred8_InternalSpeADL
    public final void synpred8_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2407:3: ( ( () ( ( ruleOpOther ) ) ) )
        // InternalSpeADL.g:2407:4: ( () ( ( ruleOpOther ) ) )
        {
        // InternalSpeADL.g:2407:4: ( () ( ( ruleOpOther ) ) )
        // InternalSpeADL.g:2407:5: () ( ( ruleOpOther ) )
        {
        // InternalSpeADL.g:2407:5: ()
        // InternalSpeADL.g:2408:1: 
        {
        }

        // InternalSpeADL.g:2408:2: ( ( ruleOpOther ) )
        // InternalSpeADL.g:2409:1: ( ruleOpOther )
        {
        // InternalSpeADL.g:2409:1: ( ruleOpOther )
        // InternalSpeADL.g:2410:3: ruleOpOther
        {
        pushFollow(FOLLOW_2);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalSpeADL

    // $ANTLR start synpred9_InternalSpeADL
    public final void synpred9_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2519:3: ( ( '>' '>' ) )
        // InternalSpeADL.g:2519:4: ( '>' '>' )
        {
        // InternalSpeADL.g:2519:4: ( '>' '>' )
        // InternalSpeADL.g:2520:2: '>' '>'
        {
        match(input,41,FOLLOW_38); if (state.failed) return ;
        match(input,41,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalSpeADL

    // $ANTLR start synpred10_InternalSpeADL
    public final void synpred10_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2549:3: ( ( '<' '<' ) )
        // InternalSpeADL.g:2549:4: ( '<' '<' )
        {
        // InternalSpeADL.g:2549:4: ( '<' '<' )
        // InternalSpeADL.g:2550:2: '<' '<'
        {
        match(input,40,FOLLOW_29); if (state.failed) return ;
        match(input,40,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalSpeADL

    // $ANTLR start synpred11_InternalSpeADL
    public final void synpred11_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2623:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalSpeADL.g:2623:4: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalSpeADL.g:2623:4: ( () ( ( ruleOpAdd ) ) )
        // InternalSpeADL.g:2623:5: () ( ( ruleOpAdd ) )
        {
        // InternalSpeADL.g:2623:5: ()
        // InternalSpeADL.g:2624:1: 
        {
        }

        // InternalSpeADL.g:2624:2: ( ( ruleOpAdd ) )
        // InternalSpeADL.g:2625:1: ( ruleOpAdd )
        {
        // InternalSpeADL.g:2625:1: ( ruleOpAdd )
        // InternalSpeADL.g:2626:3: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalSpeADL

    // $ANTLR start synpred12_InternalSpeADL
    public final void synpred12_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2731:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalSpeADL.g:2731:4: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalSpeADL.g:2731:4: ( () ( ( ruleOpMulti ) ) )
        // InternalSpeADL.g:2731:5: () ( ( ruleOpMulti ) )
        {
        // InternalSpeADL.g:2731:5: ()
        // InternalSpeADL.g:2732:1: 
        {
        }

        // InternalSpeADL.g:2732:2: ( ( ruleOpMulti ) )
        // InternalSpeADL.g:2733:1: ( ruleOpMulti )
        {
        // InternalSpeADL.g:2733:1: ( ruleOpMulti )
        // InternalSpeADL.g:2734:3: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalSpeADL

    // $ANTLR start synpred13_InternalSpeADL
    public final void synpred13_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:2964:3: ( ( () 'as' ) )
        // InternalSpeADL.g:2964:4: ( () 'as' )
        {
        // InternalSpeADL.g:2964:4: ( () 'as' )
        // InternalSpeADL.g:2964:5: () 'as'
        {
        // InternalSpeADL.g:2964:5: ()
        // InternalSpeADL.g:2965:1: 
        {
        }

        match(input,63,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalSpeADL

    // $ANTLR start synpred14_InternalSpeADL
    public final void synpred14_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3024:2: ( ( () ( ( ruleOpPostfix ) ) ) )
        // InternalSpeADL.g:3024:3: ( () ( ( ruleOpPostfix ) ) )
        {
        // InternalSpeADL.g:3024:3: ( () ( ( ruleOpPostfix ) ) )
        // InternalSpeADL.g:3024:4: () ( ( ruleOpPostfix ) )
        {
        // InternalSpeADL.g:3024:4: ()
        // InternalSpeADL.g:3025:1: 
        {
        }

        // InternalSpeADL.g:3025:2: ( ( ruleOpPostfix ) )
        // InternalSpeADL.g:3026:1: ( ruleOpPostfix )
        {
        // InternalSpeADL.g:3026:1: ( ruleOpPostfix )
        // InternalSpeADL.g:3027:3: ruleOpPostfix
        {
        pushFollow(FOLLOW_2);
        ruleOpPostfix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalSpeADL

    // $ANTLR start synpred15_InternalSpeADL
    public final void synpred15_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3114:4: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
        // InternalSpeADL.g:3114:5: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        {
        // InternalSpeADL.g:3114:5: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        // InternalSpeADL.g:3114:6: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
        {
        // InternalSpeADL.g:3114:6: ()
        // InternalSpeADL.g:3115:1: 
        {
        }

        // InternalSpeADL.g:3115:2: ( '.' | ( ( '::' ) ) )
        int alt135=2;
        int LA135_0 = input.LA(1);

        if ( (LA135_0==34) ) {
            alt135=1;
        }
        else if ( (LA135_0==66) ) {
            alt135=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 135, 0, input);

            throw nvae;
        }
        switch (alt135) {
            case 1 :
                // InternalSpeADL.g:3115:4: '.'
                {
                match(input,34,FOLLOW_45); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSpeADL.g:3117:6: ( ( '::' ) )
                {
                // InternalSpeADL.g:3117:6: ( ( '::' ) )
                // InternalSpeADL.g:3118:1: ( '::' )
                {
                // InternalSpeADL.g:3118:1: ( '::' )
                // InternalSpeADL.g:3119:2: '::'
                {
                match(input,66,FOLLOW_45); if (state.failed) return ;

                }


                }


                }
                break;

        }

        // InternalSpeADL.g:3123:3: ( ( ruleFeatureCallID ) )
        // InternalSpeADL.g:3124:1: ( ruleFeatureCallID )
        {
        // InternalSpeADL.g:3124:1: ( ruleFeatureCallID )
        // InternalSpeADL.g:3125:3: ruleFeatureCallID
        {
        pushFollow(FOLLOW_26);
        ruleFeatureCallID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_2);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalSpeADL

    // $ANTLR start synpred16_InternalSpeADL
    public final void synpred16_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3195:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
        // InternalSpeADL.g:3195:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        {
        // InternalSpeADL.g:3195:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        // InternalSpeADL.g:3195:10: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        {
        // InternalSpeADL.g:3195:10: ()
        // InternalSpeADL.g:3196:1: 
        {
        }

        // InternalSpeADL.g:3196:2: ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        int alt136=3;
        switch ( input.LA(1) ) {
        case 34:
            {
            alt136=1;
            }
            break;
        case 67:
            {
            alt136=2;
            }
            break;
        case 66:
            {
            alt136=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 136, 0, input);

            throw nvae;
        }

        switch (alt136) {
            case 1 :
                // InternalSpeADL.g:3196:4: '.'
                {
                match(input,34,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSpeADL.g:3198:6: ( ( '?.' ) )
                {
                // InternalSpeADL.g:3198:6: ( ( '?.' ) )
                // InternalSpeADL.g:3199:1: ( '?.' )
                {
                // InternalSpeADL.g:3199:1: ( '?.' )
                // InternalSpeADL.g:3200:2: '?.'
                {
                match(input,67,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // InternalSpeADL.g:3205:6: ( ( '::' ) )
                {
                // InternalSpeADL.g:3205:6: ( ( '::' ) )
                // InternalSpeADL.g:3206:1: ( '::' )
                {
                // InternalSpeADL.g:3206:1: ( '::' )
                // InternalSpeADL.g:3207:2: '::'
                {
                match(input,66,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred16_InternalSpeADL

    // $ANTLR start synpred17_InternalSpeADL
    public final void synpred17_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3316:4: ( ( '(' ) )
        // InternalSpeADL.g:3317:1: ( '(' )
        {
        // InternalSpeADL.g:3317:1: ( '(' )
        // InternalSpeADL.g:3318:2: '('
        {
        match(input,24,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalSpeADL

    // $ANTLR start synpred18_InternalSpeADL
    public final void synpred18_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3337:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalSpeADL.g:3337:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalSpeADL.g:3337:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalSpeADL.g:3337:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalSpeADL.g:3337:6: ()
        // InternalSpeADL.g:3338:1: 
        {
        }

        // InternalSpeADL.g:3338:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt138=2;
        int LA138_0 = input.LA(1);

        if ( (LA138_0==RULE_ID) ) {
            alt138=1;
        }
        switch (alt138) {
            case 1 :
                // InternalSpeADL.g:3338:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalSpeADL.g:3338:3: ( ( ruleJvmFormalParameter ) )
                // InternalSpeADL.g:3339:1: ( ruleJvmFormalParameter )
                {
                // InternalSpeADL.g:3339:1: ( ruleJvmFormalParameter )
                // InternalSpeADL.g:3340:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_57);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalSpeADL.g:3342:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop137:
                do {
                    int alt137=2;
                    int LA137_0 = input.LA(1);

                    if ( (LA137_0==19) ) {
                        alt137=1;
                    }


                    switch (alt137) {
                	case 1 :
                	    // InternalSpeADL.g:3342:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,19,FOLLOW_4); if (state.failed) return ;
                	    // InternalSpeADL.g:3343:1: ( ( ruleJvmFormalParameter ) )
                	    // InternalSpeADL.g:3344:1: ( ruleJvmFormalParameter )
                	    {
                	    // InternalSpeADL.g:3344:1: ( ruleJvmFormalParameter )
                	    // InternalSpeADL.g:3345:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_57);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop137;
                    }
                } while (true);


                }
                break;

        }

        // InternalSpeADL.g:3347:6: ( ( '|' ) )
        // InternalSpeADL.g:3348:1: ( '|' )
        {
        // InternalSpeADL.g:3348:1: ( '|' )
        // InternalSpeADL.g:3349:2: '|'
        {
        match(input,69,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred18_InternalSpeADL

    // $ANTLR start synpred19_InternalSpeADL
    public final void synpred19_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3416:4: ( ( () '[' ) )
        // InternalSpeADL.g:3416:5: ( () '[' )
        {
        // InternalSpeADL.g:3416:5: ( () '[' )
        // InternalSpeADL.g:3416:6: () '['
        {
        // InternalSpeADL.g:3416:6: ()
        // InternalSpeADL.g:3417:1: 
        {
        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalSpeADL

    // $ANTLR start synpred20_InternalSpeADL
    public final void synpred20_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3487:7: ( ( () 'synchronized' '(' ) )
        // InternalSpeADL.g:3487:8: ( () 'synchronized' '(' )
        {
        // InternalSpeADL.g:3487:8: ( () 'synchronized' '(' )
        // InternalSpeADL.g:3487:9: () 'synchronized' '('
        {
        // InternalSpeADL.g:3487:9: ()
        // InternalSpeADL.g:3488:1: 
        {
        }

        match(input,95,FOLLOW_62); if (state.failed) return ;
        match(input,24,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalSpeADL

    // $ANTLR start synpred21_InternalSpeADL
    public final void synpred21_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3530:7: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // InternalSpeADL.g:3530:8: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // InternalSpeADL.g:3530:8: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // InternalSpeADL.g:3530:9: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        // InternalSpeADL.g:3530:9: ()
        // InternalSpeADL.g:3531:1: 
        {
        }

        match(input,76,FOLLOW_62); if (state.failed) return ;
        match(input,24,FOLLOW_4); if (state.failed) return ;
        // InternalSpeADL.g:3533:1: ( ( ruleJvmFormalParameter ) )
        // InternalSpeADL.g:3534:1: ( ruleJvmFormalParameter )
        {
        // InternalSpeADL.g:3534:1: ( ruleJvmFormalParameter )
        // InternalSpeADL.g:3535:1: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_7);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalSpeADL

    // $ANTLR start synpred22_InternalSpeADL
    public final void synpred22_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3648:7: ( ( () '[' ) )
        // InternalSpeADL.g:3648:8: ( () '[' )
        {
        // InternalSpeADL.g:3648:8: ( () '[' )
        // InternalSpeADL.g:3648:9: () '['
        {
        // InternalSpeADL.g:3648:9: ()
        // InternalSpeADL.g:3649:1: 
        {
        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalSpeADL

    // $ANTLR start synpred24_InternalSpeADL
    public final void synpred24_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:3940:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalSpeADL.g:3940:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalSpeADL.g:3940:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalSpeADL.g:3940:6: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalSpeADL.g:3940:6: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt140=2;
        int LA140_0 = input.LA(1);

        if ( (LA140_0==RULE_ID) ) {
            alt140=1;
        }
        switch (alt140) {
            case 1 :
                // InternalSpeADL.g:3940:7: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalSpeADL.g:3940:7: ( ( ruleJvmFormalParameter ) )
                // InternalSpeADL.g:3941:1: ( ruleJvmFormalParameter )
                {
                // InternalSpeADL.g:3941:1: ( ruleJvmFormalParameter )
                // InternalSpeADL.g:3942:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_57);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalSpeADL.g:3944:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop139:
                do {
                    int alt139=2;
                    int LA139_0 = input.LA(1);

                    if ( (LA139_0==19) ) {
                        alt139=1;
                    }


                    switch (alt139) {
                	case 1 :
                	    // InternalSpeADL.g:3944:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,19,FOLLOW_4); if (state.failed) return ;
                	    // InternalSpeADL.g:3945:1: ( ( ruleJvmFormalParameter ) )
                	    // InternalSpeADL.g:3946:1: ( ruleJvmFormalParameter )
                	    {
                	    // InternalSpeADL.g:3946:1: ( ruleJvmFormalParameter )
                	    // InternalSpeADL.g:3947:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_57);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop139;
                    }
                } while (true);


                }
                break;

        }

        // InternalSpeADL.g:3949:6: ( ( '|' ) )
        // InternalSpeADL.g:3950:1: ( '|' )
        {
        // InternalSpeADL.g:3950:1: ( '|' )
        // InternalSpeADL.g:3951:2: '|'
        {
        match(input,69,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalSpeADL

    // $ANTLR start synpred26_InternalSpeADL
    public final void synpred26_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:4310:4: ( 'else' )
        // InternalSpeADL.g:4310:6: 'else'
        {
        match(input,72,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalSpeADL

    // $ANTLR start synpred27_InternalSpeADL
    public final void synpred27_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:4364:4: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // InternalSpeADL.g:4364:5: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // InternalSpeADL.g:4364:5: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // InternalSpeADL.g:4364:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        match(input,24,FOLLOW_4); if (state.failed) return ;
        // InternalSpeADL.g:4365:1: ( ( ruleJvmFormalParameter ) )
        // InternalSpeADL.g:4366:1: ( ruleJvmFormalParameter )
        {
        // InternalSpeADL.g:4366:1: ( ruleJvmFormalParameter )
        // InternalSpeADL.g:4367:1: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_7);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_InternalSpeADL

    // $ANTLR start synpred28_InternalSpeADL
    public final void synpred28_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:4419:8: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
        // InternalSpeADL.g:4419:9: ( ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // InternalSpeADL.g:4419:9: ( ( ( ruleJvmFormalParameter ) ) ':' )
        // InternalSpeADL.g:4419:10: ( ( ruleJvmFormalParameter ) ) ':'
        {
        // InternalSpeADL.g:4419:10: ( ( ruleJvmFormalParameter ) )
        // InternalSpeADL.g:4420:1: ( ruleJvmFormalParameter )
        {
        // InternalSpeADL.g:4420:1: ( ruleJvmFormalParameter )
        // InternalSpeADL.g:4421:1: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_7);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalSpeADL

    // $ANTLR start synpred30_InternalSpeADL
    public final void synpred30_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5187:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // InternalSpeADL.g:5187:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // InternalSpeADL.g:5187:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // InternalSpeADL.g:5187:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // InternalSpeADL.g:5187:6: ( ( ruleJvmTypeReference ) )
        // InternalSpeADL.g:5188:1: ( ruleJvmTypeReference )
        {
        // InternalSpeADL.g:5188:1: ( ruleJvmTypeReference )
        // InternalSpeADL.g:5189:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_4);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSpeADL.g:5191:2: ( ( ruleValidID ) )
        // InternalSpeADL.g:5192:1: ( ruleValidID )
        {
        // InternalSpeADL.g:5192:1: ( ruleValidID )
        // InternalSpeADL.g:5193:1: ruleValidID
        {
        pushFollow(FOLLOW_2);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalSpeADL

    // $ANTLR start synpred31_InternalSpeADL
    public final void synpred31_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5476:4: ( ( '(' ) )
        // InternalSpeADL.g:5477:1: ( '(' )
        {
        // InternalSpeADL.g:5477:1: ( '(' )
        // InternalSpeADL.g:5478:2: '('
        {
        match(input,24,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalSpeADL

    // $ANTLR start synpred32_InternalSpeADL
    public final void synpred32_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5497:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalSpeADL.g:5497:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalSpeADL.g:5497:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalSpeADL.g:5497:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalSpeADL.g:5497:6: ()
        // InternalSpeADL.g:5498:1: 
        {
        }

        // InternalSpeADL.g:5498:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt144=2;
        int LA144_0 = input.LA(1);

        if ( (LA144_0==RULE_ID) ) {
            alt144=1;
        }
        switch (alt144) {
            case 1 :
                // InternalSpeADL.g:5498:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalSpeADL.g:5498:3: ( ( ruleJvmFormalParameter ) )
                // InternalSpeADL.g:5499:1: ( ruleJvmFormalParameter )
                {
                // InternalSpeADL.g:5499:1: ( ruleJvmFormalParameter )
                // InternalSpeADL.g:5500:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_57);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalSpeADL.g:5502:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop143:
                do {
                    int alt143=2;
                    int LA143_0 = input.LA(1);

                    if ( (LA143_0==19) ) {
                        alt143=1;
                    }


                    switch (alt143) {
                	case 1 :
                	    // InternalSpeADL.g:5502:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,19,FOLLOW_4); if (state.failed) return ;
                	    // InternalSpeADL.g:5503:1: ( ( ruleJvmFormalParameter ) )
                	    // InternalSpeADL.g:5504:1: ( ruleJvmFormalParameter )
                	    {
                	    // InternalSpeADL.g:5504:1: ( ruleJvmFormalParameter )
                	    // InternalSpeADL.g:5505:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_57);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop143;
                    }
                } while (true);


                }
                break;

        }

        // InternalSpeADL.g:5507:6: ( ( '|' ) )
        // InternalSpeADL.g:5508:1: ( '|' )
        {
        // InternalSpeADL.g:5508:1: ( '|' )
        // InternalSpeADL.g:5509:2: '|'
        {
        match(input,69,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred32_InternalSpeADL

    // $ANTLR start synpred33_InternalSpeADL
    public final void synpred33_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5576:4: ( ( () '[' ) )
        // InternalSpeADL.g:5576:5: ( () '[' )
        {
        // InternalSpeADL.g:5576:5: ( () '[' )
        // InternalSpeADL.g:5576:6: () '['
        {
        // InternalSpeADL.g:5576:6: ()
        // InternalSpeADL.g:5577:1: 
        {
        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred33_InternalSpeADL

    // $ANTLR start synpred34_InternalSpeADL
    public final void synpred34_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5741:4: ( '<' )
        // InternalSpeADL.g:5741:6: '<'
        {
        match(input,40,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalSpeADL

    // $ANTLR start synpred35_InternalSpeADL
    public final void synpred35_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5790:5: ( ( '(' ) )
        // InternalSpeADL.g:5791:1: ( '(' )
        {
        // InternalSpeADL.g:5791:1: ( '(' )
        // InternalSpeADL.g:5792:2: '('
        {
        match(input,24,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred35_InternalSpeADL

    // $ANTLR start synpred36_InternalSpeADL
    public final void synpred36_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5811:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalSpeADL.g:5811:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalSpeADL.g:5811:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalSpeADL.g:5811:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalSpeADL.g:5811:6: ()
        // InternalSpeADL.g:5812:1: 
        {
        }

        // InternalSpeADL.g:5812:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt146=2;
        int LA146_0 = input.LA(1);

        if ( (LA146_0==RULE_ID) ) {
            alt146=1;
        }
        switch (alt146) {
            case 1 :
                // InternalSpeADL.g:5812:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalSpeADL.g:5812:3: ( ( ruleJvmFormalParameter ) )
                // InternalSpeADL.g:5813:1: ( ruleJvmFormalParameter )
                {
                // InternalSpeADL.g:5813:1: ( ruleJvmFormalParameter )
                // InternalSpeADL.g:5814:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_57);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalSpeADL.g:5816:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop145:
                do {
                    int alt145=2;
                    int LA145_0 = input.LA(1);

                    if ( (LA145_0==19) ) {
                        alt145=1;
                    }


                    switch (alt145) {
                	case 1 :
                	    // InternalSpeADL.g:5816:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,19,FOLLOW_4); if (state.failed) return ;
                	    // InternalSpeADL.g:5817:1: ( ( ruleJvmFormalParameter ) )
                	    // InternalSpeADL.g:5818:1: ( ruleJvmFormalParameter )
                	    {
                	    // InternalSpeADL.g:5818:1: ( ruleJvmFormalParameter )
                	    // InternalSpeADL.g:5819:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_57);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop145;
                    }
                } while (true);


                }
                break;

        }

        // InternalSpeADL.g:5821:6: ( ( '|' ) )
        // InternalSpeADL.g:5822:1: ( '|' )
        {
        // InternalSpeADL.g:5822:1: ( '|' )
        // InternalSpeADL.g:5823:2: '|'
        {
        match(input,69,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred36_InternalSpeADL

    // $ANTLR start synpred37_InternalSpeADL
    public final void synpred37_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:5890:4: ( ( () '[' ) )
        // InternalSpeADL.g:5890:5: ( () '[' )
        {
        // InternalSpeADL.g:5890:5: ( () '[' )
        // InternalSpeADL.g:5890:6: () '['
        {
        // InternalSpeADL.g:5890:6: ()
        // InternalSpeADL.g:5891:1: 
        {
        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred37_InternalSpeADL

    // $ANTLR start synpred38_InternalSpeADL
    public final void synpred38_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:6230:2: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
        // InternalSpeADL.g:
        {
        if ( (input.LA(1)>=RULE_ID && input.LA(1)<=RULE_DECIMAL)||input.LA(1)==14||input.LA(1)==18||input.LA(1)==24||input.LA(1)==40||(input.LA(1)>=56 && input.LA(1)<=57)||input.LA(1)==62||input.LA(1)==68||input.LA(1)==71||input.LA(1)==73||(input.LA(1)>=76 && input.LA(1)<=78)||(input.LA(1)>=81 && input.LA(1)<=93)||input.LA(1)==95 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred38_InternalSpeADL

    // $ANTLR start synpred39_InternalSpeADL
    public final void synpred39_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:6324:5: ( 'catch' )
        // InternalSpeADL.g:6324:7: 'catch'
        {
        match(input,96,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalSpeADL

    // $ANTLR start synpred40_InternalSpeADL
    public final void synpred40_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:6343:5: ( 'finally' )
        // InternalSpeADL.g:6343:7: 'finally'
        {
        match(input,94,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalSpeADL

    // $ANTLR start synpred43_InternalSpeADL
    public final void synpred43_InternalSpeADL_fragment() throws RecognitionException {   
        // InternalSpeADL.g:6569:3: ( '.' )
        // InternalSpeADL.g:6570:2: '.'
        {
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalSpeADL

    // Delegated rules

    public final boolean synpred35_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalSpeADL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalSpeADL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA31 dfa31 = new DFA31(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA102 dfa102 = new DFA102(this);
    protected DFA101 dfa101 = new DFA101(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA107 dfa107 = new DFA107(this);
    protected DFA110 dfa110 = new DFA110(this);
    protected DFA109 dfa109 = new DFA109(this);
    protected DFA111 dfa111 = new DFA111(this);
    protected DFA114 dfa114 = new DFA114(this);
    protected DFA132 dfa132 = new DFA132(this);
    static final String dfa_1s = "\125\uffff";
    static final String dfa_2s = "\1\2\124\uffff";
    static final String dfa_3s = "\1\4\1\0\123\uffff";
    static final String dfa_4s = "\1\142\1\0\123\uffff";
    static final String dfa_5s = "\2\uffff\1\2\121\uffff\1\1";
    static final String dfa_6s = "\1\uffff\1\0\123\uffff}>";
    static final String[] dfa_7s = {
            "\5\2\5\uffff\3\2\1\uffff\1\1\2\2\2\uffff\10\2\3\uffff\43\2\1\uffff\33\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1573:2: ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= ']' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalSpeADL()) ) {s = 84;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\12\uffff";
    static final String dfa_9s = "\1\10\11\uffff";
    static final String dfa_10s = "\1\4\7\0\2\uffff";
    static final String dfa_11s = "\1\140\7\0\2\uffff";
    static final String dfa_12s = "\10\uffff\1\2\1\1";
    static final String dfa_13s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff}>";
    static final String[] dfa_14s = {
            "\5\10\5\uffff\3\10\1\uffff\3\10\3\uffff\2\10\10\uffff\1\10\1\1\1\2\1\3\1\4\1\5\1\6\1\7\33\10\1\uffff\33\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1730:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSpeADL()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\13\uffff";
    static final String dfa_16s = "\1\1\12\uffff";
    static final String dfa_17s = "\1\4\1\uffff\10\0\1\uffff";
    static final String dfa_18s = "\1\140\1\uffff\10\0\1\uffff";
    static final String dfa_19s = "\1\uffff\1\2\10\uffff\1\1";
    static final String dfa_20s = "\2\uffff\1\2\1\3\1\0\1\1\1\6\1\7\1\4\1\5\1\uffff}>";
    static final String[] dfa_21s = {
            "\5\1\5\uffff\3\1\1\uffff\3\1\3\uffff\2\1\10\uffff\6\1\1\2\1\3\10\1\1\4\1\5\1\6\1\7\1\10\1\11\15\1\1\uffff\33\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "()* loopback of 2407:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalSpeADL()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_22s = "\1\50\2\uffff\1\51\7\uffff";
    static final String dfa_23s = "\1\67\2\uffff\1\64\7\uffff";
    static final String dfa_24s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\6\1\3";
    static final String dfa_25s = "\13\uffff}>";
    static final String[] dfa_26s = {
            "\1\6\1\3\10\uffff\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\11\12\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_15;
            this.eof = dfa_15;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2472:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
    }
    static final String dfa_27s = "\116\uffff";
    static final String dfa_28s = "\1\2\115\uffff";
    static final String dfa_29s = "\1\4\1\0\114\uffff";
    static final String dfa_30s = "\1\140\1\0\114\uffff";
    static final String dfa_31s = "\2\uffff\1\2\112\uffff\1\1";
    static final String dfa_32s = "\1\uffff\1\0\114\uffff}>";
    static final String[] dfa_33s = {
            "\5\2\5\uffff\3\2\1\uffff\3\2\3\uffff\1\1\1\2\10\uffff\43\2\1\uffff\33\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "3316:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_34s = "\43\uffff";
    static final String dfa_35s = "\1\4\1\0\41\uffff";
    static final String dfa_36s = "\1\137\1\0\41\uffff";
    static final String dfa_37s = "\2\uffff\1\1\1\2\36\uffff\1\3";
    static final String dfa_38s = "\1\0\1\1\41\uffff}>";
    static final String[] dfa_39s = {
            "\1\1\4\3\5\uffff\1\3\3\uffff\1\3\5\uffff\1\3\1\42\16\uffff\1\3\17\uffff\2\3\4\uffff\1\3\5\uffff\1\3\1\2\1\uffff\1\3\1\uffff\1\3\2\uffff\3\3\2\uffff\15\3\1\uffff\1\3",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_34;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "3337:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_0 = input.LA(1);

                         
                        int index60_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA60_0==RULE_ID) ) {s = 1;}

                        else if ( (LA60_0==69) && (synpred18_InternalSpeADL())) {s = 2;}

                        else if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_DECIMAL)||LA60_0==14||LA60_0==18||LA60_0==24||LA60_0==40||(LA60_0>=56 && LA60_0<=57)||LA60_0==62||LA60_0==68||LA60_0==71||LA60_0==73||(LA60_0>=76 && LA60_0<=78)||(LA60_0>=81 && LA60_0<=93)||LA60_0==95) ) {s = 3;}

                        else if ( (LA60_0==25) ) {s = 34;}

                         
                        input.seek(index60_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalSpeADL()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_40s = {
            "\5\2\5\uffff\3\2\1\uffff\1\1\2\2\3\uffff\2\2\10\uffff\43\2\1\uffff\33\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "3416:3: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_41s = "\40\uffff";
    static final String dfa_42s = "\1\4\26\uffff\1\0\10\uffff";
    static final String dfa_43s = "\1\137\26\uffff\1\0\10\uffff";
    static final String dfa_44s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\6\uffff\1\6\11\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\11";
    static final String dfa_45s = "\1\0\26\uffff\1\1\10\uffff}>";
    static final String[] dfa_46s = {
            "\1\5\4\14\5\uffff\1\2\3\uffff\1\14\5\uffff\1\35\17\uffff\1\5\33\uffff\1\14\2\uffff\1\26\1\uffff\1\3\2\uffff\1\27\1\30\1\31\2\uffff\5\5\1\1\4\14\1\32\1\33\1\34\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_41;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_45;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "3457:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_0 = input.LA(1);

                         
                        int index64_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA64_0==86) ) {s = 1;}

                        else if ( (LA64_0==14) ) {s = 2;}

                        else if ( (LA64_0==73) ) {s = 3;}

                        else if ( (LA64_0==95) && (synpred20_InternalSpeADL())) {s = 4;}

                        else if ( (LA64_0==RULE_ID||LA64_0==40||(LA64_0>=81 && LA64_0<=85)) ) {s = 5;}

                        else if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_DECIMAL)||LA64_0==18||LA64_0==68||(LA64_0>=87 && LA64_0<=90)) ) {s = 12;}

                        else if ( (LA64_0==71) ) {s = 22;}

                        else if ( (LA64_0==76) ) {s = 23;}

                        else if ( (LA64_0==77) ) {s = 24;}

                        else if ( (LA64_0==78) ) {s = 25;}

                        else if ( (LA64_0==91) ) {s = 26;}

                        else if ( (LA64_0==92) ) {s = 27;}

                        else if ( (LA64_0==93) ) {s = 28;}

                        else if ( (LA64_0==24) ) {s = 29;}

                         
                        input.seek(index64_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_23 = input.LA(1);

                         
                        int index64_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSpeADL()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index64_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_47s = "\45\uffff";
    static final String dfa_48s = "\1\4\1\0\43\uffff";
    static final String dfa_49s = "\1\137\1\0\43\uffff";
    static final String dfa_50s = "\2\uffff\1\1\1\2\41\uffff";
    static final String dfa_51s = "\1\0\1\1\43\uffff}>";
    static final String[] dfa_52s = {
            "\1\1\4\3\5\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\3\17\uffff\1\3\17\uffff\2\3\4\uffff\1\3\5\uffff\1\3\1\2\1\uffff\1\3\1\uffff\1\3\2\uffff\22\3\1\uffff\1\3",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[][] dfa_52 = unpackEncodedStringArray(dfa_52s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_47;
            this.eof = dfa_47;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_51;
            this.transition = dfa_52;
        }
        public String getDescription() {
            return "3940:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA73_0 = input.LA(1);

                         
                        int index73_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA73_0==RULE_ID) ) {s = 1;}

                        else if ( (LA73_0==69) && (synpred24_InternalSpeADL())) {s = 2;}

                        else if ( ((LA73_0>=RULE_STRING && LA73_0<=RULE_DECIMAL)||LA73_0==14||LA73_0==18||LA73_0==20||LA73_0==24||LA73_0==40||(LA73_0>=56 && LA73_0<=57)||LA73_0==62||LA73_0==68||LA73_0==71||LA73_0==73||(LA73_0>=76 && LA73_0<=93)||LA73_0==95) ) {s = 3;}

                         
                        input.seek(index73_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_1 = input.LA(1);

                         
                        int index73_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalSpeADL()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 73, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_53s = "\42\uffff";
    static final String dfa_54s = "\1\4\1\0\40\uffff";
    static final String dfa_55s = "\1\137\1\0\40\uffff";
    static final String dfa_56s = "\2\uffff\1\2\36\uffff\1\1";
    static final String dfa_57s = "\1\uffff\1\0\40\uffff}>";
    static final String[] dfa_58s = {
            "\5\2\5\uffff\1\2\3\uffff\1\2\5\uffff\1\1\17\uffff\1\2\17\uffff\2\2\4\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\2\uffff\3\2\2\uffff\15\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_53 = DFA.unpackEncodedString(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final char[] dfa_55 = DFA.unpackEncodedStringToUnsignedChars(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[] dfa_57 = DFA.unpackEncodedString(dfa_57s);
    static final short[][] dfa_58 = unpackEncodedStringArray(dfa_58s);

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = dfa_53;
            this.eof = dfa_53;
            this.min = dfa_54;
            this.max = dfa_55;
            this.accept = dfa_56;
            this.special = dfa_57;
            this.transition = dfa_58;
        }
        public String getDescription() {
            return "4364:1: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalSpeADL()) ) {s = 33;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_59s = {
            "\1\1\4\2\5\uffff\1\2\3\uffff\1\2\5\uffff\1\2\17\uffff\1\2\17\uffff\2\2\4\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\2\uffff\3\2\2\uffff\15\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_59 = unpackEncodedStringArray(dfa_59s);

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = dfa_53;
            this.eof = dfa_53;
            this.min = dfa_54;
            this.max = dfa_55;
            this.accept = dfa_56;
            this.special = dfa_57;
            this.transition = dfa_59;
        }
        public String getDescription() {
            return "4419:7: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_1 = input.LA(1);

                         
                        int index79_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalSpeADL()) ) {s = 33;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index79_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 79, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "5476:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA102_1 = input.LA(1);

                         
                        int index102_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index102_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 102, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = dfa_34;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "5497:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA101_0 = input.LA(1);

                         
                        int index101_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_0==RULE_ID) ) {s = 1;}

                        else if ( (LA101_0==69) && (synpred32_InternalSpeADL())) {s = 2;}

                        else if ( ((LA101_0>=RULE_STRING && LA101_0<=RULE_DECIMAL)||LA101_0==14||LA101_0==18||LA101_0==24||LA101_0==40||(LA101_0>=56 && LA101_0<=57)||LA101_0==62||LA101_0==68||LA101_0==71||LA101_0==73||(LA101_0>=76 && LA101_0<=78)||(LA101_0>=81 && LA101_0<=93)||LA101_0==95) ) {s = 3;}

                        else if ( (LA101_0==25) ) {s = 34;}

                         
                        input.seek(index101_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA101_1 = input.LA(1);

                         
                        int index101_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalSpeADL()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index101_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 101, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "5576:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA103_1 = input.LA(1);

                         
                        int index103_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index103_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 103, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_60s = {
            "\5\2\5\uffff\3\2\1\uffff\3\2\3\uffff\2\2\10\uffff\6\2\1\1\34\2\1\uffff\33\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_60 = unpackEncodedStringArray(dfa_60s);

    class DFA107 extends DFA {

        public DFA107(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 107;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_60;
        }
        public String getDescription() {
            return "5741:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA107_1 = input.LA(1);

                         
                        int index107_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index107_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 107, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA110 extends DFA {

        public DFA110(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 110;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "5790:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA110_1 = input.LA(1);

                         
                        int index110_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index110_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 110, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = dfa_34;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "5811:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA109_0 = input.LA(1);

                         
                        int index109_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA109_0==RULE_ID) ) {s = 1;}

                        else if ( (LA109_0==69) && (synpred36_InternalSpeADL())) {s = 2;}

                        else if ( ((LA109_0>=RULE_STRING && LA109_0<=RULE_DECIMAL)||LA109_0==14||LA109_0==18||LA109_0==24||LA109_0==40||(LA109_0>=56 && LA109_0<=57)||LA109_0==62||LA109_0==68||LA109_0==71||LA109_0==73||(LA109_0>=76 && LA109_0<=78)||(LA109_0>=81 && LA109_0<=93)||LA109_0==95) ) {s = 3;}

                        else if ( (LA109_0==25) ) {s = 34;}

                         
                        input.seek(index109_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA109_1 = input.LA(1);

                         
                        int index109_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalSpeADL()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index109_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 109, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "5890:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA111_1 = input.LA(1);

                         
                        int index111_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index111_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 111, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_61s = "\1\41\115\uffff";
    static final String dfa_62s = "\1\4\40\0\55\uffff";
    static final String dfa_63s = "\1\140\40\0\55\uffff";
    static final String dfa_64s = "\41\uffff\1\2\53\uffff\1\1";
    static final String dfa_65s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\55\uffff}>";
    static final String[] dfa_66s = {
            "\1\1\1\27\1\23\1\24\1\25\5\uffff\1\12\2\41\1\uffff\1\20\2\41\3\uffff\1\40\1\41\10\uffff\6\41\1\15\17\41\1\10\1\7\4\41\1\6\5\41\1\17\1\uffff\1\41\1\31\1\41\1\13\2\41\1\32\1\33\1\34\2\41\1\2\1\3\1\4\1\5\1\16\1\11\1\21\1\22\1\26\1\30\1\35\1\36\1\37\1\41\1\14\1\41",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final char[] dfa_62 = DFA.unpackEncodedStringToUnsignedChars(dfa_62s);
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final short[] dfa_64 = DFA.unpackEncodedString(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[][] dfa_66 = unpackEncodedStringArray(dfa_66s);

    class DFA114 extends DFA {

        public DFA114(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 114;
            this.eot = dfa_27;
            this.eof = dfa_61;
            this.min = dfa_62;
            this.max = dfa_63;
            this.accept = dfa_64;
            this.special = dfa_65;
            this.transition = dfa_66;
        }
        public String getDescription() {
            return "6230:1: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA114_1 = input.LA(1);

                         
                        int index114_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA114_2 = input.LA(1);

                         
                        int index114_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA114_3 = input.LA(1);

                         
                        int index114_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA114_4 = input.LA(1);

                         
                        int index114_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA114_5 = input.LA(1);

                         
                        int index114_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA114_6 = input.LA(1);

                         
                        int index114_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA114_7 = input.LA(1);

                         
                        int index114_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA114_8 = input.LA(1);

                         
                        int index114_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA114_9 = input.LA(1);

                         
                        int index114_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA114_10 = input.LA(1);

                         
                        int index114_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA114_11 = input.LA(1);

                         
                        int index114_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA114_12 = input.LA(1);

                         
                        int index114_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA114_13 = input.LA(1);

                         
                        int index114_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA114_14 = input.LA(1);

                         
                        int index114_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA114_15 = input.LA(1);

                         
                        int index114_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA114_16 = input.LA(1);

                         
                        int index114_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA114_17 = input.LA(1);

                         
                        int index114_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA114_18 = input.LA(1);

                         
                        int index114_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA114_19 = input.LA(1);

                         
                        int index114_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA114_20 = input.LA(1);

                         
                        int index114_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA114_21 = input.LA(1);

                         
                        int index114_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA114_22 = input.LA(1);

                         
                        int index114_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA114_23 = input.LA(1);

                         
                        int index114_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA114_24 = input.LA(1);

                         
                        int index114_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA114_25 = input.LA(1);

                         
                        int index114_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA114_26 = input.LA(1);

                         
                        int index114_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA114_27 = input.LA(1);

                         
                        int index114_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA114_28 = input.LA(1);

                         
                        int index114_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA114_29 = input.LA(1);

                         
                        int index114_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA114_30 = input.LA(1);

                         
                        int index114_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA114_31 = input.LA(1);

                         
                        int index114_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA114_32 = input.LA(1);

                         
                        int index114_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSpeADL()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index114_32);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 114, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_67s = "\7\uffff";
    static final String dfa_68s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_69s = "\1\4\1\uffff\1\15\1\4\2\uffff\1\15";
    static final String dfa_70s = "\1\122\1\uffff\1\123\1\72\2\uffff\1\123";
    static final String dfa_71s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String dfa_72s = "\7\uffff}>";
    static final String[] dfa_73s = {
            "\1\2\115\uffff\1\1",
            "",
            "\1\4\24\uffff\1\3\43\uffff\1\4\14\uffff\1\4",
            "\1\6\65\uffff\1\5",
            "",
            "",
            "\1\4\24\uffff\1\3\43\uffff\1\4\14\uffff\1\4"
    };

    static final short[] dfa_67 = DFA.unpackEncodedString(dfa_67s);
    static final short[] dfa_68 = DFA.unpackEncodedString(dfa_68s);
    static final char[] dfa_69 = DFA.unpackEncodedStringToUnsignedChars(dfa_69s);
    static final char[] dfa_70 = DFA.unpackEncodedStringToUnsignedChars(dfa_70s);
    static final short[] dfa_71 = DFA.unpackEncodedString(dfa_71s);
    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[][] dfa_73 = unpackEncodedStringArray(dfa_73s);

    class DFA132 extends DFA {

        public DFA132(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 132;
            this.eot = dfa_67;
            this.eof = dfa_68;
            this.min = dfa_69;
            this.max = dfa_70;
            this.accept = dfa_71;
            this.special = dfa_72;
            this.transition = dfa_73;
        }
        public String getDescription() {
            return "7227:1: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000042A000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000244000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000034808000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000034008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000074008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080008000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000010L,0x0000000200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x43000100010441F0L,0x00000000BFFE7290L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000003F800000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002070000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00FC030000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x3C00000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000400000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000010L,0x00000000001E0000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000010000000010L,0x00000000003E0000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000020000080000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000401040002L,0x000000000000000CL});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x43000100030441F0L,0x00000000BFFE72B0L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000400040002L,0x000000000000000CL});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x430001000104C1F0L,0x00000000BFFE7290L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x43000100011441F0L,0x00000000BFFE7290L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x43000100011441F0L,0x00000000BFFFF2B0L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000020L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x43000100011441F0L,0x00000000BFFFF290L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x43000100010441F2L,0x00000000BFFFF2D0L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x43000100010441F2L,0x00000000BFFFF290L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000098010L,0x0000000000000C00L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000090000L,0x0000000000000800L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x43000100010441F0L,0x00000000BFFFF2D0L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x43000100010441F0L,0x00000000BFFFF290L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x43000100010441F0L,0x00000000BFFE72D0L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x43000100030441F0L,0x00000000BFFE7290L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x430001000104C1F0L,0x00000000BFFFF290L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x430001000104C1F0L,0x00000000BFFFF2D0L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000001040002L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000010001040002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x43000100010441F2L,0x00000000BFFE7290L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000140000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000220000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000010L,0x0000000000040000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000010L,0x0000000000100000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000012L});

}