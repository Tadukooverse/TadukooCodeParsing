package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.util.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Method represents a method in a Java class or interface, etc.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 * @since Alpha v.0.2
 */
public class JavaMethod{
	
	/**
	 * Java Method Builder is used to build a new {@link JavaMethod}. It contains the following parameters:
	 *
	 * <table>
	 *     <caption>Java Method Parameters</caption>
	 *     <tr>
	 *         <th>Parameter</th>
	 *         <th>Description</th>
	 *         <th>Default or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>sectionComment</td>
	 *         <td>The section comment above the method</td>
	 *         <td>null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>javadoc</td>
	 *         <td>The {@link Javadoc} on the method</td>
	 *         <td>null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>annotations</td>
	 *         <td>The {@link JavaAnnotation annotations} on the method</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>visibility</td>
	 *         <td>The {@link Visibility} of the method</td>
	 *         <td>{@link Visibility#PUBLIC}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>isStatic</td>
	 *         <td>Whether the method is static or not</td>
	 *         <td>Defaults to false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>returnType</td>
	 *         <td>The return type of the method</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>name</td>
	 *         <td>The name of the method</td>
	 *         <td>null (used for constructors)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>parameters</td>
	 *         <td>The parameters used in the method - pairs of type, then name</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>throwTypes</td>
	 *         <td>The types that can be thrown by the method</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>lines</td>
	 *         <td>The actual lines of code in the method</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3.3
	 * @since Alpha v.0.2
	 */
	public static class JavaMethodBuilder{
		/** The section comment above the method */
		private String sectionComment = null;
		/** The {@link Javadoc} on the method */
		private Javadoc javadoc = null;
		/** The {@link JavaAnnotation annotations} on the method */
		private List<JavaAnnotation> annotations = new ArrayList<>();
		/** The {@link Visibility} of the method */
		private Visibility visibility = Visibility.PUBLIC;
		/** Whether the method is static or not */
		private boolean isStatic = false;
		/** The return type of the method */
		private String returnType = null;
		/** The name of the method */
		private String name = null;
		/** The parameters used in the method - pairs of type, then name */
		private List<Pair<String, String>> parameters = new ArrayList<>();
		/** The types that can be thrown by the method */
		private List<String> throwTypes = new ArrayList<>();
		/** The actual lines of code in the method */
		private List<String> lines = new ArrayList<>();
		
		/** Can't create outside JavaMethod */
		private JavaMethodBuilder(){ }
		
		/**
		 * @param sectionComment The section comment above the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder sectionComment(String sectionComment){
			this.sectionComment = sectionComment;
			return this;
		}
		
		/**
		 * @param javadoc The {@link Javadoc} on the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder javadoc(Javadoc javadoc){
			this.javadoc = javadoc;
			return this;
		}
		
		/**
		 * @param annotations The {@link JavaAnnotation annotations} on the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder annotations(List<JavaAnnotation> annotations){
			this.annotations = annotations;
			return this;
		}
		
		/**
		 * @param annotation A single {@link JavaAnnotation annotation} on the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder annotation(JavaAnnotation annotation){
			annotations.add(annotation);
			return this;
		}
		
		/**
		 * @param visibility The {@link Visibility} of the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder visibility(Visibility visibility){
			this.visibility = visibility;
			return this;
		}
		
		/**
		 * Sets the method as static
		 *
		 * @return this, to continue building
		 */
		public JavaMethodBuilder isStatic(){
			isStatic = true;
			return this;
		}
		
		/**
		 * @param isStatic Whether the method is static or not
		 * @return this, to continue building
		 */
		public JavaMethodBuilder isStatic(boolean isStatic){
			this.isStatic = isStatic;
			return this;
		}
		
		/**
		 * @param returnType The return type of the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder returnType(String returnType){
			this.returnType = returnType;
			return this;
		}
		
		/**
		 * @param name The name of the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder name(String name){
			this.name = name;
			return this;
		}
		
		/**
		 * @param parameters The parameters used in the method - pairs of type, then name
		 * @return this, to continue building
		 */
		public JavaMethodBuilder parameters(List<Pair<String, String>> parameters){
			this.parameters = parameters;
			return this;
		}
		
		/**
		 * @param parameter A single parameter, with type first, then name - to add to the list
		 * @return this, to continue building
		 */
		public JavaMethodBuilder parameter(Pair<String, String> parameter){
			parameters.add(parameter);
			return this;
		}
		
		/**
		 * @param type The type of the parameter to be added
		 * @param name The name of the parameter to be added
		 * @return this, to continue building
		 */
		public JavaMethodBuilder parameter(String type, String name){
			parameters.add(Pair.of(type, name));
			return this;
		}
		
		/**
		 * @param throwTypes The types the method can throw
		 * @return this, to continue building
		 */
		public JavaMethodBuilder throwTypes(List<String> throwTypes){
			this.throwTypes = throwTypes;
			return this;
		}
		
		/**
		 * @param throwType A type the method can throw - to add to the list
		 * @return this, to continue building
		 */
		public JavaMethodBuilder throwType(String throwType){
			throwTypes.add(throwType);
			return this;
		}
		
		/**
		 * @param lines The actual lines of code in the method
		 * @return this, to continue building
		 */
		public JavaMethodBuilder lines(List<String> lines){
			this.lines = lines;
			return this;
		}
		
		/**
		 * @param line A single line of code in the method, to add to the list
		 * @return this, to continue building
		 */
		public JavaMethodBuilder line(String line){
			lines.add(line);
			return this;
		}
		
		/**
		 * Checks for any errors in the current parameters
		 *
		 * @throws IllegalArgumentException if anything is wrong
		 */
		private void checkForErrors(){
			List<String> errors = new ArrayList<>();
			
			if(StringUtil.isBlank(returnType)){
				errors.add("Must specify returnType!");
			}
			
			if(!errors.isEmpty()){
				throw new IllegalArgumentException(StringUtil.buildStringWithNewLines(errors));
			}
		}
		
		/**
		 * Checks for any errors in the current parameters, then builds a new {@link JavaMethod}
		 *
		 * @return A newly built {@link JavaMethod}
		 * @throws IllegalArgumentException if anything is wrong with the current parameters
		 */
		public JavaMethod build(){
			checkForErrors();
			
			return new JavaMethod(sectionComment, javadoc, annotations,
					visibility, isStatic, returnType, name,
					parameters, throwTypes, lines);
		}
	}
	
	/** The section comment above the method */
	private final String sectionComment;
	/** The {@link Javadoc} on the method */
	private final Javadoc javadoc;
	/** The {@link JavaAnnotation annotations} on the method */
	private final List<JavaAnnotation> annotations;
	/** The {@link Visibility} of the method */
	private final Visibility visibility;
	/** Whether the method is static or not */
	private final boolean isStatic;
	/** The return type of the method */
	private final String returnType;
	/** The name of the method */
	private final String name;
	/** The parameters used in the method - pairs of type, then name */
	private final List<Pair<String, String>> parameters;
	/** The types that can be thrown by the method */
	private final List<String> throwTypes;
	/** The actual lines of code in the method */
	private final List<String> lines;
	
	/**
	 * Constructs a new Java Method with the given parameters
	 *
	 * @param sectionComment The section comment above the method
	 * @param javadoc The {@link Javadoc} on the method
	 * @param annotations The {@link JavaAnnotation annotations} on the method
	 * @param visibility The {@link Visibility} of the method
	 * @param isStatic Whether the method is static or not
	 * @param returnType The return type of the method
	 * @param name The name of the method
	 * @param parameters The parameters used in the method - pairs of type, then name
	 * @param throwTypes The types that can be thrown by the method
	 * @param lines The actual lines of code in the method
	 */
	private JavaMethod(
			String sectionComment, Javadoc javadoc, List<JavaAnnotation> annotations,
			Visibility visibility, boolean isStatic, String returnType, String name,
			List<Pair<String, String>> parameters, List<String> throwTypes, List<String> lines){
		this.sectionComment = sectionComment;
		this.javadoc = javadoc;
		this.annotations = annotations;
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.returnType = returnType;
		this.name = name;
		this.parameters = parameters;
		this.throwTypes = throwTypes;
		this.lines = lines;
	}
	
	/**
	 * @return A new {@link JavaMethodBuilder} to use to build a {@link JavaMethod}
	 */
	public static JavaMethodBuilder builder(){
		return new JavaMethodBuilder();
	}
	
	/**
	 * @return The section comment above the method
	 */
	public String getSectionComment(){
		return sectionComment;
	}
	
	/**
	 * @return The {@link Javadoc} on the method
	 */
	public Javadoc getJavadoc(){
		return javadoc;
	}
	
	/**
	 * @return The {@link JavaAnnotation annotations} on the method
	 */
	public List<JavaAnnotation> getAnnotations(){
		return annotations;
	}
	
	/**
	 * @return The {@link Visibility} of the method
	 */
	public Visibility getVisibility(){
		return visibility;
	}
	
	/**
	 * @return Whether the method is static or not
	 */
	public boolean isStatic(){
		return isStatic;
	}
	
	/**
	 * @return The return type of the method
	 */
	public String getReturnType(){
		return returnType;
	}
	
	/**
	 * @return The name of the method
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return The parameters used in the method - pairs of type, then name
	 */
	public List<Pair<String, String>> getParameters(){
		return parameters;
	}
	
	/**
	 * @return The types that can be thrown by the method
	 */
	public List<String> getThrowTypes(){
		return throwTypes;
	}
	
	/**
	 * @return The actual lines of code in the method
	 */
	public List<String> getLines(){
		return lines;
	}
	
	/**
	 * @return This Java Method as a String, ready to be put in some Java code
	 */
	@Override
	public String toString(){
		List<String> content = new ArrayList<>();
		
		// Section Comment
		if(StringUtil.isNotBlank(sectionComment)){
			content.add("/*");
			content.add(" * " + sectionComment);
			content.add(" */");
			content.add("");
		}
		
		// Javadoc
		if(javadoc != null){
			content.add(javadoc.toString());
		}
		
		// Annotations
		if(ListUtil.isNotBlank(annotations)){
			for(JavaAnnotation annotation: annotations){
				content.add(annotation.toString());
			}
		}
		
		/*
		 * Declaration
		 */
		StringBuilder declaration = new StringBuilder(visibility.getText() + (isStatic?" static":"") + " " + returnType);
		
		// Add name to declaration if we have it
		if(StringUtil.isNotBlank(name)){
			declaration.append(" ").append(name);
		}
		
		// Start of parameter section
		declaration.append("(");
		
		// Add parameters to the declaration
		if(ListUtil.isNotBlank(parameters)){
			for(Pair<String, String> parameter: parameters){
				declaration.append(parameter.getLeft()).append(" ").append(parameter.getRight()).append(", ");
			}
			// Remove final comma + space
			declaration.setLength(declaration.length()-2);
		}
		
		// If we have throw types, add them to the end of the declaration
		if(ListUtil.isNotBlank(throwTypes)){
			declaration.append(") throws ");
			for(String throwType: throwTypes){
				declaration.append(throwType).append(", ");
			}
			// Remove the final comma and space
			declaration.delete(declaration.length() - 2, declaration.length());
			// Add the opening brace
			declaration.append('{');
		}else{
			// If no throw types, just end the declaration
			declaration.append("){");
		}
		// Add the declaration to the content
		content.add(declaration.toString());
		
		// Add the lines to the method
		if(ListUtil.isNotBlank(lines)){
			for(String line: lines){
				content.add("\t" + line);
			}
		}
		
		// Closing brace of the method
		content.add("}");
		
		return StringUtil.buildStringWithNewLines(content);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object otherMethod){
		if(otherMethod instanceof JavaMethod method){
			return StringUtil.equals(this.toString(), method.toString());
		}else{
			return false;
		}
	}
}
