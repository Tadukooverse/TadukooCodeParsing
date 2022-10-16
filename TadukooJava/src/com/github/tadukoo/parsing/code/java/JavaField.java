package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Field represents a field in a {@link JavaClass Java class}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 * @since Alpha v.0.2
 */
public class JavaField{
	
	/**
	 * Java Field Builder is a builder to create a {@link JavaField}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>Java Field Parameters</caption>
	 *     <tr>
	 *         <th>Parameter</th>
	 *         <th>Description</th>
	 *         <th>Default or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>sectionComment</td>
	 *         <td>The section comment above the field</td>
	 *         <td>null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>javadoc</td>
	 *         <td>The {@link Javadoc} on the field</td>
	 *         <td>null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>annotations</td>
	 *         <td>The {@link JavaAnnotation annotations} on the field</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>visibility</td>
	 *         <td>The {@link Visibility} of the field</td>
	 *         <td>{@link Visibility#PRIVATE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>isStatic</td>
	 *         <td>If the field is static or not</td>
	 *         <td>false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>isFinal</td>
	 *         <td>If the field is final or not</td>
	 *         <td>false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>type</td>
	 *         <td>The type of the field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>name</td>
	 *         <td>The name of the field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>value</td>
	 *         <td>The value assigned to the field</td>
	 *         <td>null</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3.3
	 * @since Alpha v.0.2
	 */
	public static class JavaFieldBuilder{
		/** The section comment above the field */
		private String sectionComment = null;
		/** The {@link Javadoc} on the field */
		private Javadoc javadoc = null;
		/** The {@link JavaAnnotation annotations} on the field */
		private List<JavaAnnotation> annotations = new ArrayList<>();
		/** The {@link Visibility} of the field */
		private Visibility visibility = Visibility.PRIVATE;
		/** Whether the field is static or not */
		private boolean isStatic = false;
		/** Whether the field is final or not */
		private boolean isFinal = false;
		/** The type of the field */
		private String type = null;
		/** The name of the field */
		private String name = null;
		/** The value assigned to the field */
		private String value = null;
		
		/** Not allowed to create outside JavaField */
		private JavaFieldBuilder(){ }
		
		/**
		 * @param sectionComment The section comment above the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder sectionComment(String sectionComment){
			this.sectionComment = sectionComment;
			return this;
		}
		
		/**
		 * @param javadoc The {@link Javadoc} on the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder javadoc(Javadoc javadoc){
			this.javadoc = javadoc;
			return this;
		}
		
		/**
		 * @param annotations The {@link JavaAnnotation annotations} on the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder annotations(List<JavaAnnotation> annotations){
			this.annotations = annotations;
			return this;
		}
		
		/**
		 * @param annotation A single {@link JavaAnnotation annotation} on the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder annotation(JavaAnnotation annotation){
			annotations.add(annotation);
			return this;
		}
		
		/**
		 * @param visibility The {@link Visibility} of the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder visibility(Visibility visibility){
			this.visibility = visibility;
			return this;
		}
		
		/**
		 * Sets the field to be static
		 *
		 * @return this, to continue building
		 */
		public JavaFieldBuilder isStatic(){
			isStatic = true;
			return this;
		}
		
		/**
		 * @param isStatic Whether the field is static or not
		 * @return this, to continue building
		 */
		public JavaFieldBuilder isStatic(boolean isStatic){
			this.isStatic = isStatic;
			return this;
		}
		
		/**
		 * Sets the field to be final
		 *
		 * @return this, to continue building
		 */
		public JavaFieldBuilder isFinal(){
			isFinal = true;
			return this;
		}
		
		/**
		 * @param isFinal Whether the field is final or not
		 * @return this, to continue building
		 */
		public JavaFieldBuilder isFinal(boolean isFinal){
			this.isFinal = isFinal;
			return this;
		}
		
		/**
		 * @param type The type of the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder type(String type){
			this.type = type;
			return this;
		}
		
		/**
		 * @param name The name of the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder name(String name){
			this.name = name;
			return this;
		}
		
		/**
		 * @param value The value assigned to the field
		 * @return this, to continue building
		 */
		public JavaFieldBuilder value(String value){
			this.value = value;
			return this;
		}
		
		/**
		 * Checks for any errors in the current parameters
		 *
		 * @throws IllegalArgumentException if anything is wrong
		 */
		private void checkForErrors(){
			List<String> errors = new ArrayList<>();
			
			if(StringUtil.isBlank(type)){
				errors.add("Must specify type!");
			}
			
			if(StringUtil.isBlank(name)){
				errors.add("Must specify name!");
			}
			
			if(!errors.isEmpty()){
				throw new IllegalArgumentException(StringUtil.buildStringWithNewLines(errors));
			}
		}
		
		/**
		 * Checks for any errors in the current parameters, then builds a new {@link JavaField}
		 *
		 * @return A newly built {@link JavaField}
		 * @throws IllegalArgumentException if anything is wrong with the current parameters
		 */
		public JavaField build(){
			checkForErrors();
			
			return new JavaField(sectionComment, javadoc, annotations, visibility, isStatic, isFinal, type, name, value);
		}
	}
	
	/** The section comment above the field */
	private final String sectionComment;
	/** The {@link Javadoc} on the field */
	private final Javadoc javadoc;
	/** The {@link JavaAnnotation annotations} on the field */
	private final List<JavaAnnotation> annotations;
	/** The {@link Visibility} of the field */
	private final Visibility visibility;
	/** Whether the field is static or not */
	private final boolean isStatic;
	/** Whether the field is final or not */
	private final boolean isFinal;
	/** The type of the field */
	private final String type;
	/** The name of the field */
	private final String name;
	/** The value assigned to the field */
	private final String value;
	
	/**
	 * Constructs a Java Field with the given parameters
	 *
	 * @param sectionComment The section comment above the field
	 * @param javadoc The {@link Javadoc} on the field
	 * @param annotations The {@link JavaAnnotation annotations} on the field
	 * @param visibility The {@link Visibility} of the field
	 * @param isStatic Whether the field is static or not
	 * @param isFinal Whether the field is final or not
	 * @param type The type of the field
	 * @param name The name of the field
	 * @param value The value assigned to the field
	 */
	private JavaField(
			String sectionComment, Javadoc javadoc, List<JavaAnnotation> annotations,
			Visibility visibility, boolean isStatic, boolean isFinal,
			String type, String name, String value){
		this.sectionComment = sectionComment;
		this.javadoc = javadoc;
		this.annotations = annotations;
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.type = type;
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @return A new {@link JavaFieldBuilder} to create a new {@link JavaField}
	 */
	public static JavaFieldBuilder builder(){
		return new JavaFieldBuilder();
	}
	
	/**
	 * @return The section comment above the field
	 */
	public String getSectionComment(){
		return sectionComment;
	}
	
	/**
	 * @return The {@link Javadoc} on the field
	 */
	public Javadoc getJavadoc(){
		return javadoc;
	}
	
	/**
	 * @return The {@link JavaAnnotation annotations} on the field
	 */
	public List<JavaAnnotation> getAnnotations(){
		return annotations;
	}
	
	/**
	 * @return The {@link Visibility} of the field
	 */
	public Visibility getVisibility(){
		return visibility;
	}
	
	/**
	 * @return Whether the field is static or not
	 */
	public boolean isStatic(){
		return isStatic;
	}
	
	/**
	 * @return Whether the field is final or not
	 */
	public boolean isFinal(){
		return isFinal;
	}
	
	/**
	 * @return The type of the field
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * @return The name of the field
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return The value assigned to the field
	 */
	public String getValue(){
		return value;
	}
	
	/**
	 * @return A string of the form "{visibility.getText()} {type} {name}", with javadoc and annotations on newlines above
	 */
	@Override
	public String toString(){
		List<String> content = new ArrayList<>();
		
		// Section comment
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
		
		// Add field declaration
		String declaration = visibility.getText() + (isStatic?" static":"") + (isFinal?" final":"") +
				" " + type + " " + name;
		// Add value to declaration if we have one
		if(StringUtil.isNotBlank(value)){
			declaration += " = " + value;
		}
		content.add(declaration);
		
		return StringUtil.buildStringWithNewLines(content);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object otherField){
		if(otherField instanceof JavaField field){
			return StringUtil.equals(this.toString(), field.toString());
		}else{
			return false;
		}
	}
}
