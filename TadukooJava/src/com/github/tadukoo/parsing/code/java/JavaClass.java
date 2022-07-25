package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Class is used to represent a class in Java.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 * @since Alpha v.0.2
 */
public class JavaClass{
	
	/**
	 * Java Class Builder is used to create a {@link JavaClass}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>Java Class Parameters</caption>
	 *     <tr>
	 *         <th>Parameter</th>
	 *         <th>Description</th>
	 *         <th>Default or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>isInnerClass</td>
	 *         <td>Whether the class is an inner class or not</td>
	 *         <td>Defaults to false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>packageName</td>
	 *         <td>The name of the package the class is in</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>imports</td>
	 *         <td>The classes imported by the class</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>staticImports</td>
	 *         <td>The classes imported statically by the class</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>javadoc</td>
	 *         <td>The {@link Javadoc} for the class</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>annotations</td>
	 *         <td>The {@link JavaAnnotation annotations} on the class</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>visibility</td>
	 *         <td>The {@link Visibility} of the class</td>
	 *         <td>{@link Visibility#PUBLIC}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>isStatic</td>
	 *         <td>Whether the class is static or not</td>
	 *         <td>false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>className</td>
	 *         <td>The name of the class</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>superClassName</td>
	 *         <td>The name of the class this one extends (may be null)</td>
	 *         <td>null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>innerClasses</td>
	 *         <td>Inner {@link JavaClass classes} inside the class</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fields</td>
	 *         <td>The {@link JavaField fields} on the class</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 *     <tr>
	 *         <td>methods</td>
	 *         <td>The {@link JavaMethod methods} in the class</td>
	 *         <td>An empty list</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3.3
	 * @since Alpha v.0.2
	 */
	public static class JavaClassBuilder{
		/** Whether the class is an inner class or not */
		private boolean isInnerClass = false;
		/** The name of the package the class is in */
		private String packageName = null;
		/** The classes imported by the class */
		private List<String> imports = new ArrayList<>();
		/** The classes imported statically by the class */
		private List<String> staticImports = new ArrayList<>();
		/** The {@link Javadoc} for the class */
		private Javadoc javadoc = null;
		/** The {@link JavaAnnotation annotations} on the class */
		private List<JavaAnnotation> annotations = new ArrayList<>();
		/** The {@link Visibility} of the class */
		private Visibility visibility = Visibility.PUBLIC;
		/** Whether the class is static or not */
		private boolean isStatic = false;
		/** The name of the class */
		private String className = null;
		/** The name of the class this one extends (may be null) */
		private String superClassName = null;
		/** Inner {@link JavaClass classes} inside the class */
		private List<JavaClass> innerClasses = new ArrayList<>();
		/** The {@link JavaField fields} on the class */
		private List<JavaField> fields = new ArrayList<>();
		/** The {@link JavaMethod methods} in the class */
		private List<JavaMethod> methods = new ArrayList<>();
		
		// Can't create outside of JavaClass
		private JavaClassBuilder(){ }
		
		/**
		 * @param isInnerClass Whether the class is an inner class or not
		 * @return this, to continue building
		 */
		public JavaClassBuilder isInnerClass(boolean isInnerClass){
			this.isInnerClass = isInnerClass;
			return this;
		}
		
		/**
		 * Set the class as an inner class
		 *
		 * @return this, to continue building
		 */
		public JavaClassBuilder innerClass(){
			this.isInnerClass = true;
			return this;
		}
		
		/**
		 * @param packageName The name of the package the class is in
		 * @return this, to continue building
		 */
		public JavaClassBuilder packageName(String packageName){
			this.packageName = packageName;
			return this;
		}
		
		/**
		 * @param imports The classes imported by the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder imports(List<String> imports){
			this.imports = imports;
			return this;
		}
		
		/**
		 * @param singleImport A single class imported by the class, to be added to the list
		 * @return this, to continue building
		 */
		public JavaClassBuilder singleImport(String singleImport){
			imports.add(singleImport);
			return this;
		}
		
		/**
		 * @param staticImports The classes imported statically by the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder staticImports(List<String> staticImports){
			this.staticImports = staticImports;
			return this;
		}
		
		/**
		 * @param staticImport A single class imported statically by the class, to be added to the list
		 * @return this, to continue building
		 */
		public JavaClassBuilder staticImport(String staticImport){
			staticImports.add(staticImport);
			return this;
		}
		
		/**
		 * @param javadoc The {@link Javadoc} for the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder javadoc(Javadoc javadoc){
			this.javadoc = javadoc;
			return this;
		}
		
		/**
		 * @param annotations The {@link JavaAnnotation annotations} on the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder annotations(List<JavaAnnotation> annotations){
			this.annotations = annotations;
			return this;
		}
		
		/**
		 * @param annotation A single {@link JavaAnnotation annotation} on the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder annotation(JavaAnnotation annotation){
			annotations.add(annotation);
			return this;
		}
		
		/**
		 * @param visibility The {@link Visibility} of the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder visibility(Visibility visibility){
			this.visibility = visibility;
			return this;
		}
		
		/**
		 * @param isStatic Whether the class is static or not
		 * @return this, to continue building
		 */
		public JavaClassBuilder isStatic(boolean isStatic){
			this.isStatic = isStatic;
			return this;
		}
		
		/**
		 * Sets isStatic to true, defining the class as a static class
		 *
		 * @return this, to continue building
		 */
		public JavaClassBuilder isStatic(){
			this.isStatic = true;
			return this;
		}
		
		/**
		 * @param className The name of the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder className(String className){
			this.className = className;
			return this;
		}
		
		/**
		 * @param superClassName The name of the class this one extends (may be null)
		 * @return this, to continue building
		 */
		public JavaClassBuilder superClassName(String superClassName){
			this.superClassName = superClassName;
			return this;
		}
		
		/**
		 * @param innerClasses Inner {@link JavaClass classes} inside the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder innerClasses(List<JavaClass> innerClasses){
			this.innerClasses = innerClasses;
			return this;
		}
		
		/**
		 * @param innerClass An inner {@link JavaClass class} inside the class to be added to the list
		 * @return this, to continue building
		 */
		public JavaClassBuilder innerClass(JavaClass innerClass){
			this.innerClasses.add(innerClass);
			return this;
		}
		
		/**
		 * @param fields The {@link JavaField fields} on the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder fields(List<JavaField> fields){
			this.fields = fields;
			return this;
		}
		
		/**
		 * @param field A {@link JavaField field} on the class, to be added to the list
		 * @return this, to continue building
		 */
		public JavaClassBuilder field(JavaField field){
			fields.add(field);
			return this;
		}
		
		/**
		 * @param methods The {@link JavaMethod methods} in the class
		 * @return this, to continue building
		 */
		public JavaClassBuilder methods(List<JavaMethod> methods){
			this.methods = methods;
			return this;
		}
		
		/**
		 * @param method A {@link JavaMethod method} in the class, to be added to the list
		 * @return this, to continue building
		 */
		public JavaClassBuilder method(JavaMethod method){
			methods.add(method);
			return this;
		}
		
		/**
		 * Checks for any errors in the current parameters
		 *
		 * @throws IllegalArgumentException if anything is wrong
		 */
		private void checkForErrors(){
			List<String> errors = new ArrayList<>();
			
			// Generic problems
			if(StringUtil.isBlank(className)){
				errors.add("Must specify className!");
			}
			
			if(ListUtil.isNotBlank(innerClasses)){
				for(JavaClass innerClass: innerClasses){
					if(!innerClass.isInnerClass()){
						errors.add("Inner class '" + innerClass.getClassName() + "' is not an inner class!");
					}
				}
			}
			
			// Inner class problems
			if(isInnerClass){
				if(StringUtil.isNotBlank(packageName)){
					errors.add("Not allowed to have packageName for an inner class!");
				}
				
				if(ListUtil.isNotBlank(imports)){
					errors.add("Not allowed to have imports for an inner class!");
				}
				
				if(ListUtil.isNotBlank(staticImports)){
					errors.add("Not allowed to have static imports for an inner class!");
				}
			}else{
				// Regular class problems
				if(StringUtil.isBlank(packageName)){
					errors.add("Must specify packageName when not making an inner class!");
				}
				
				if(isStatic){
					errors.add("Only inner classes can be static!");
				}
			}
			
			if(!errors.isEmpty()){
				throw new IllegalArgumentException(StringUtil.buildStringWithNewLines(errors));
			}
		}
		
		/**
		 * Checks for any errors in the current parameters, then builds a new {@link JavaClass}
		 *
		 * @return A newly built {@link JavaClass}
		 * @throws IllegalArgumentException if anything is wrong with the current parameters
		 */
		public JavaClass build(){
			// Run the error check
			checkForErrors();
			
			// Actually build the Java Class
			return new JavaClass(isInnerClass, packageName, imports, staticImports, javadoc, annotations,
					visibility, isStatic, className, superClassName, innerClasses, fields, methods);
		}
	}
	
	/** Whether this is an inner class or not */
	private final boolean isInnerClass;
	/** The name of the package the class is in */
	private final String packageName;
	/** The classes imported by the class */
	private final List<String> imports;
	/** The classes imported statically by the class */
	private final List<String> staticImports;
	/** The {@link Javadoc} for the class */
	private final Javadoc javadoc;
	/** The {@link JavaAnnotation annotations} on the class */
	private final List<JavaAnnotation> annotations;
	/** The {@link Visibility} of the class */
	private final Visibility visibility;
	/** Whether this is a static class or not */
	private final boolean isStatic;
	/** The name of the class */
	private final String className;
	/** The name of the class this one extends (may be null) */
	private final String superClassName;
	/** Inner {@link JavaClass classes} inside the class */
	private final List<JavaClass> innerClasses;
	/** The {@link JavaField fields} on the class */
	private final List<JavaField> fields;
	/** The {@link JavaMethod methods} in the class */
	private final List<JavaMethod> methods;
	
	/**
	 * Constructs a new Java Class with the given parameters
	 *
	 * @param isInnerClass Whether this is an inner class or not
	 * @param packageName The name of the package the class is in
	 * @param imports The classes imported by the class
	 * @param staticImports The classes imported statically by the class
	 * @param javadoc The {@link Javadoc} for the class
	 * @param annotations The {@link JavaAnnotation annotations} on the class
	 * @param visibility The {@link Visibility} of the class
	 * @param isStatic Whether this is a static class or not
	 * @param className The name of the class
	 * @param superClassName The name of the class this one extends (may be null)
	 * @param innerClasses Inner {@link JavaClass classes} inside the class
	 * @param fields The {@link JavaField fields} on the class
	 * @param methods The {@link JavaMethod methods} in the class
	 */
	private JavaClass(boolean isInnerClass, String packageName, List<String> imports, List<String> staticImports,
	                  Javadoc javadoc, List<JavaAnnotation> annotations,
	                  Visibility visibility, boolean isStatic, String className, String superClassName,
	                  List<JavaClass> innerClasses, List<JavaField> fields, List<JavaMethod> methods){
		this.isInnerClass = isInnerClass;
		this.packageName = packageName;
		this.imports = imports;
		this.staticImports = staticImports;
		this.javadoc = javadoc;
		this.annotations = annotations;
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.className = className;
		this.superClassName = superClassName;
		this.innerClasses = innerClasses;
		this.fields = fields;
		this.methods = methods;
	}
	
	/**
	 * @return A new {@link JavaClassBuilder} to use to build a {@link JavaClass}
	 */
	public static JavaClassBuilder builder(){
		return new JavaClassBuilder();
	}
	
	/**
	 * @return Whether this is an inner class or not
	 */
	public boolean isInnerClass(){
		return isInnerClass;
	}
	
	/**
	 * @return The name of the package the class is in
	 */
	public String getPackageName(){
		return packageName;
	}
	
	/**
	 * @return The classes imported by the class
	 */
	public List<String> getImports(){
		return imports;
	}
	
	/**
	 * @return The classes imported statically by the class
	 */
	public List<String> getStaticImports(){
		return staticImports;
	}
	
	/**
	 * @return The {@link Javadoc} for the class
	 */
	public Javadoc getJavadoc(){
		return javadoc;
	}
	
	/**
	 * @return The {@link JavaAnnotation annotations} on the class
	 */
	public List<JavaAnnotation> getAnnotations(){
		return annotations;
	}
	
	/**
	 * @return The {@link Visibility} of the class
	 */
	public Visibility getVisibility(){
		return visibility;
	}
	
	/**
	 * @return Whether this class is static or not
	 */
	public boolean isStatic(){
		return isStatic;
	}
	
	/**
	 * @return The name of the class
	 */
	public String getClassName(){
		return className;
	}
	
	/**
	 * @return The name of the class this one extends (may be null)
	 */
	public String getSuperClassName(){
		return superClassName;
	}
	
	/**
	 * @return Inner {@link JavaClass classes} inside this class
	 */
	public List<JavaClass> getInnerClasses(){
		return innerClasses;
	}
	
	/**
	 * @return The {@link JavaField fields} on the class
	 */
	public List<JavaField> getFields(){
		return fields;
	}
	
	/**
	 * @return The {@link JavaMethod methods} in the class
	 */
	public List<JavaMethod> getMethods(){
		return methods;
	}
	
	/**
	 * @return The actual Java code this {@link JavaClass} represents
	 */
	@Override
	public String toString(){
		// Create a list of the lines of the class
		List<String> content = new ArrayList<>();
		
		// Package Declaration
		if(!isInnerClass){
			content.add("package " + packageName + ";");
		}
		
		// Import Statements
		if(ListUtil.isNotBlank(imports)){
			// Newline between package declaration + imports
			content.add("");
			for(String singleImport: imports){
				content.add("import " + singleImport + ";");
			}
		}
		
		// Static Import Statements
		if(ListUtil.isNotBlank(staticImports)){
			// Newline between package declaration/imports + static imports
			content.add("");
			for(String staticImport: staticImports){
				content.add("import static " + staticImport + ";");
			}
		}
		
		// Newline between package declaration/imports + javadoc/annotations/class declaration
		if(!isInnerClass){
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
		
		// Class Declaration
		content.add(visibility.getText() + (isStatic?" static":"") + " class " + className +
				(StringUtil.isNotBlank(superClassName)?" extends " + superClassName:"") + "{");
		
		// Newline at start of class
		content.add("\t");
		
		// Inner classes of the class
		if(ListUtil.isNotBlank(innerClasses)){
			for(JavaClass clazz: innerClasses){
				content.add(StringUtil.indentAllLines(clazz.toString()));
			}
		}
		
		// Fields on the class
		if(ListUtil.isNotBlank(fields)){
			for(JavaField field: fields){
				content.add("\t" + field.toString() + ";");
			}
		}
		
		// Methods in the class
		if(ListUtil.isNotBlank(methods)){
			// Newline to separate fields from methods
			if(ListUtil.isNotBlank(fields)){
				content.add("\t");
			}
			for(JavaMethod method: methods){
				// Split the method into its lines so we can add it to our lines
				List<String> lines = StringUtil.parseListFromStringWithSeparator(
						method.toString(), "\n", false);
				for(String line: lines){
					content.add("\t" + line);
				}
				content.add("\t");
			}
			// Remove extra newline at the end
			content.remove(content.size()-1);
		}
		
		// Closing brace at end of class and empty newline at end of file
		content.add("}");
		content.add("");
		
		// Build the full string
		return StringUtil.buildStringWithNewLines(content);
	}
}
