package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.util.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Javadoc represents a Javadoc in Java.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public class Javadoc{
	
	/**
	 * A builder class to build a {@link Javadoc}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>Javadoc Parameters</caption>
	 *     <tr>
	 *         <th>Parameter</th>
	 *         <th>Description</th>
	 *         <th>Default or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>condensed</td>
	 *         <td>Whether the {@link Javadoc} is condensed or not</td>
	 *         <td>Defaults to false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>content</td>
	 *         <td>The content of the {@link Javadoc}</td>
	 *         <td>Defaults to an empty List</td>
	 *     </tr>
	 *     <tr>
	 *         <td>author</td>
	 *         <td>The author of the {@link Javadoc}</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>version</td>
	 *         <td>The version of the {@link Javadoc}</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>since</td>
	 *         <td>The "since" value of the {@link Javadoc}</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>params</td>
	 *         <td>The parameters in the {@link Javadoc}</td>
	 *         <td>Defaults to an empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>returnVal</td>
	 *         <td>The return string for the {@link Javadoc}</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3.3
	 */
	public static class JavadocBuilder{
		/** Whether the {@link Javadoc} is condensed or not */
		private boolean condensed = false;
		/** The content of the {@link Javadoc} */
		private List<String> content = new ArrayList<>();
		/** The author of the {@link Javadoc} */
		private String author = null;
		/** The version for the {@link Javadoc} */
		private String version = null;
		/** The "since" value for the {@link Javadoc} */
		private String since = null;
		/** The parameters in the {@link Javadoc} */
		private List<Pair<String, String>> params = new ArrayList<>();
		/** The return string for the {@link Javadoc} */
		private String returnVal = null;
		
		/** Not allowed to instantiate outside of Javadoc */
		private JavadocBuilder(){ }
		
		/**
		 * @param condensed Whether the {@link Javadoc} is condensed or not
		 * @return this, to continue building
		 */
		public JavadocBuilder condensed(boolean condensed){
			this.condensed = condensed;
			return this;
		}
		
		/**
		 * Sets that the {@link Javadoc} is condensed
		 *
		 * @return this, to continue building
		 */
		public JavadocBuilder condensed(){
			this.condensed = true;
			return this;
		}
		
		/**
		 * @param content The content of the {@link Javadoc}
		 * @return this, to continue building
		 */
		public JavadocBuilder content(List<String> content){
			this.content = content;
			return this;
		}
		
		/**
		 * @param content Content for the {@link Javadoc} (to add to the List)
		 * @return this, to continue building
		 */
		public JavadocBuilder content(String content){
			this.content.add(content);
			return this;
		}
		
		/**
		 * @param author The author of the {@link Javadoc}
		 * @return this, to continue building
		 */
		public JavadocBuilder author(String author){
			this.author = author;
			return this;
		}
		
		/**
		 * @param version The version for the {@link Javadoc}
		 * @return this, to continue building
		 */
		public JavadocBuilder version(String version){
			this.version = version;
			return this;
		}
		
		/**
		 * @param since The "since" value for the {@link Javadoc}
		 * @return this, to continue building
		 */
		public JavadocBuilder since(String since){
			this.since = since;
			return this;
		}
		
		/**
		 * @param params The parameters in the {@link Javadoc}
		 * @return this, to continue building
		 */
		public JavadocBuilder params(List<Pair<String, String>> params){
			this.params = params;
			return this;
		}
		
		/**
		 * @param param A parameter in the {@link Javadoc} to add to the list
		 * @return this, to continue building
		 */
		public JavadocBuilder param(Pair<String, String> param){
			this.params.add(param);
			return this;
		}
		
		/**
		 * @param name The name of the parameter in the {@link Javadoc} to add to the list
		 * @param description The description of the parameter in the {@link Javadoc} to add to the list
		 * @return this, to continue building
		 */
		public JavadocBuilder param(String name, String description){
			this.params.add(Pair.of(name, description));
			return this;
		}
		
		/**
		 * @param returnVal The return string for the {@link Javadoc}
		 * @return this, to continue building
		 */
		public JavadocBuilder returnVal(String returnVal){
			this.returnVal = returnVal;
			return this;
		}
		
		/**
		 * Builds a new {@link Javadoc} using the set parameters
		 *
		 * @return The newly built {@link Javadoc}
		 */
		public Javadoc build(){
			return new Javadoc(condensed, content, author, version, since, params, returnVal);
		}
	}
	
	/** Whether the {@link Javadoc} is condensed or not */
	private final boolean condensed;
	/** The content of the {@link Javadoc} */
	private final List<String> content;
	/** The author of the {@link Javadoc} */
	private final String author;
	/** The version for the {@link Javadoc} */
	private final String version;
	/** The "since" value for the {@link Javadoc} */
	private final String since;
	/** The parameters in the {@link Javadoc} */
	private final List<Pair<String, String>> params;
	/** The return string in the {@link Javadoc} */
	private final String returnVal;
	
	/**
	 * Constructs a new {@link Javadoc} using the given parameters
	 *
	 * @param condensed Whether the {@link Javadoc} is condensed or not
	 * @param content The content of the {@link Javadoc}
	 * @param author The author of the {@link Javadoc}
	 * @param version The version for the {@link Javadoc}
	 * @param since The "since" value for the {@link Javadoc}
	 * @param params The parameters in the {@link Javadoc}
	 * @param returnVal The return string in the {@link Javadoc}
	 */
	private Javadoc(
			boolean condensed, List<String> content, String author, String version, String since,
			List<Pair<String, String>> params, String returnVal){
		this.condensed = condensed;
		this.content = content;
		this.author = author;
		this.version = version;
		this.since = since;
		this.params = params;
		this.returnVal = returnVal;
	}
	
	/**
	 * @return A {@link JavadocBuilder builder} to build a {@link Javadoc}
	 */
	public static JavadocBuilder builder(){
		return new JavadocBuilder();
	}
	
	/**
	 * @return Whether the {@link Javadoc} is condensed or not
	 */
	public boolean isCondensed(){
		return condensed;
	}
	
	/**
	 * @return The content of the {@link Javadoc}
	 */
	public List<String> getContent(){
		return content;
	}
	
	/**
	 * @return The author of the {@link Javadoc}
	 */
	public String getAuthor(){
		return author;
	}
	
	/**
	 * @return The version for the {@link Javadoc}
	 */
	public String getVersion(){
		return version;
	}
	
	/**
	 * @return The "since" value for the {@link Javadoc}
	 */
	public String getSince(){
		return since;
	}
	
	/**
	 * @return The parameters in the {@link Javadoc}
	 */
	public List<Pair<String, String>> getParams(){
		return params;
	}
	
	/**
	 * @return The return string for the {@link Javadoc}
	 */
	public String getReturnVal(){
		return returnVal;
	}
	
	/**
	 * @return The actual Javadoc text this class represents
	 */
	@Override
	public String toString(){
		// Start with the opening
		StringBuilder doc = new StringBuilder("/**");
		
		// Check what we have
		boolean haveContent = ListUtil.isNotBlank(content);
		boolean haveInfoAnnotations = StringUtil.anyNotBlank(author, version, since);
		boolean haveCodeAnnotations = ListUtil.isNotBlank(params) || StringUtil.isNotBlank(returnVal);
		boolean prevContent = false;
		
		// If not condensed, go to the next line if we have content or annotations coming up
		if(!condensed && (haveContent || haveInfoAnnotations || haveCodeAnnotations)){
			doc.append("\n *");
		}
		
		// Add the content (if we have it)
		if(haveContent){
			for(String line: content){
				doc.append(" ").append(line).append("\n *");
			}
			if(!haveInfoAnnotations  && !haveCodeAnnotations){
				doc.delete(doc.length()-3, doc.length());
			}else{
				doc.append(" ");
			}
			prevContent = true;
		}
		
		// Add the author (if we have it)
		if(StringUtil.isNotBlank(author)){
			if(prevContent){
				doc.append("\n *");
			}
			doc.append(" @author ").append(author);
			prevContent = true;
		}
		
		// Add the version (if we have it)
		if(StringUtil.isNotBlank(version)){
			if(prevContent){
				doc.append("\n *");
			}
			doc.append(" @version ").append(version);
			prevContent = true;
		}
		
		// Add the since (if we have it)
		if(StringUtil.isNotBlank(since)){
			if(prevContent){
				doc.append("\n *");
			}
			doc.append(" @since ").append(since);
			prevContent = true;
		}
		
		// Add extra line
		if(haveInfoAnnotations && haveCodeAnnotations){
			doc.append("\n * ");
		}
		
		// Add the parameters
		if(ListUtil.isNotBlank(params)){
			if(prevContent){
				doc.append("\n *");
			}
			for(Pair<String, String> param: params){
				doc.append(" @param ").append(param.getLeft()).append(" ").append(param.getRight()).append("\n *");
			}
			doc.delete(doc.length()-3, doc.length());
			prevContent = true;
		}
		
		// Add the return value
		if(StringUtil.isNotBlank(returnVal)){
			if(prevContent){
				doc.append("\n *");
			}
			doc.append(" @return ").append(returnVal);
		}
		
		// If not condensed, go to the next line for the closing
		if(!condensed){
			doc.append("\n");
		}
		
		// End with the closing
		doc.append(" */");
		
		return doc.toString();
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object otherJavadoc){
		if(otherJavadoc instanceof Javadoc doc){
			return StringUtil.equals(this.toString(), doc.toString());
		}else{
			return false;
		}
	}
}
