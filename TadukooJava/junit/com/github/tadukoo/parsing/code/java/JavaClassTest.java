package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class JavaClassTest{
	private JavaClass clazz = JavaClass.builder()
			.packageName("some.package").className("AClassName")
			.build();
	
	@Test
	public void testDefaultIsInnerClass(){
		assertFalse(clazz.isInnerClass());
	}
	
	@Test
	public void testDefaultImports(){
		assertNotNull(clazz.getImports());
		assertTrue(clazz.getImports().isEmpty());
	}
	
	@Test
	public void testDefaultStaticImports(){
		assertNotNull(clazz.getStaticImports());
		assertTrue(clazz.getStaticImports().isEmpty());
	}
	
	@Test
	public void testDefaultJavadoc(){
		assertNull(clazz.getJavadoc());
	}
	
	@Test
	public void testDefaultAnnotations(){
		assertNotNull(clazz.getAnnotations());
		assertTrue(clazz.getAnnotations().isEmpty());
	}
	
	@Test
	public void testDefaultVisibility(){
		assertEquals(Visibility.PUBLIC, clazz.getVisibility());
	}
	
	@Test
	public void testDefaultIsStatic(){
		assertFalse(clazz.isStatic());
	}
	
	@Test
	public void testDefaultSuperClassName(){
		assertNull(clazz.getSuperClassName());
	}
	
	@Test
	public void testDefaultFields(){
		assertNotNull(clazz.getFields());
		assertTrue(clazz.getFields().isEmpty());
	}
	
	@Test
	public void testSetIsInnerClass(){
		clazz = JavaClass.builder()
				.className("AClassName")
				.isInnerClass(true)
				.build();
		assertTrue(clazz.isInnerClass());
	}
	
	@Test
	public void testSetInnerClass(){
		clazz = JavaClass.builder()
				.className("AClassName")
				.innerClass()
				.build();
		assertTrue(clazz.isInnerClass());
	}
	
	@Test
	public void testSetPackageName(){
		assertEquals("some.package", clazz.getPackageName());
	}
	
	@Test
	public void testSetClassName(){
		assertEquals("AClassName", clazz.getClassName());
	}
	
	@Test
	public void testSetImports(){
		List<String> imports = ListUtil.createList("com.example.*", "com.github.tadukoo.*");
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.imports(imports)
				.build();
		assertEquals(imports, clazz.getImports());
	}
	
	@Test
	public void testSetSingleImport(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.singleImport("com.example.*")
				.build();
		List<String> imports = clazz.getImports();
		assertEquals(1, imports.size());
		assertEquals("com.example.*", imports.get(0));
	}
	
	@Test
	public void testSetStaticImports(){
		List<String> staticImports = ListUtil.createList("com.example.Test", "com.github.tadukoo.*");
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.staticImports(staticImports)
				.build();
		assertEquals(staticImports, clazz.getStaticImports());
	}
	
	@Test
	public void testSetSingleStaticImport(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.staticImport("com.github.tadukoo.*")
				.build();
		List<String> staticImports = clazz.getStaticImports();
		assertEquals(1, staticImports.size());
		assertEquals("com.github.tadukoo.*", staticImports.get(0));
	}
	
	@Test
	public void testSetJavadoc(){
		Javadoc doc = Javadoc.builder().build();
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.javadoc(doc)
				.build();
		assertEquals(doc, clazz.getJavadoc());
	}
	
	@Test
	public void testSetAnnotations(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		JavaAnnotation derp = JavaAnnotation.builder().name("Derp").build();
		List<JavaAnnotation> annotations = ListUtil.createList(test, derp);
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.annotations(annotations)
				.build();
		assertEquals(annotations, clazz.getAnnotations());
	}
	
	@Test
	public void testSetSingleAnnotation(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.annotation(test)
				.build();
		List<JavaAnnotation> annotations = clazz.getAnnotations();
		assertEquals(1, annotations.size());
		assertEquals(test, annotations.get(0));
	}
	
	@Test
	public void testSetVisibility(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.visibility(Visibility.PRIVATE)
				.build();
		assertEquals(Visibility.PRIVATE, clazz.getVisibility());
	}
	
	@Test
	public void testSetIsStatic(){
		clazz = JavaClass.builder()
				.innerClass()
				.className("AClassName")
				.isStatic(true)
				.build();
		assertTrue(clazz.isStatic());
	}
	
	@Test
	public void testSetIsStaticNoParam(){
		clazz = JavaClass.builder()
				.innerClass()
				.className("AClassName")
				.isStatic()
				.build();
		assertTrue(clazz.isStatic());
	}
	
	@Test
	public void testSetSuperClassName(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.superClassName("AnotherClassName")
				.build();
		assertEquals("AnotherClassName", clazz.getSuperClassName());
	}
	
	@Test
	public void testSetInnerClasses(){
		List<JavaClass> classes = ListUtil.createList(JavaClass.builder().innerClass().className("AClass").build(),
				JavaClass.builder().innerClass().className("BClass").build());
		clazz = JavaClass.builder()
				.packageName("some.package").className("CClassName")
				.innerClasses(classes)
				.build();
		assertEquals(classes, clazz.getInnerClasses());
	}
	
	@Test
	public void testSet1InnerClass(){
		JavaClass class2 = JavaClass.builder().innerClass().className("AClass").build();
		clazz = JavaClass.builder()
				.packageName("some.package").className("BClassName")
				.innerClass(class2)
				.build();
		List<JavaClass> innerClasses = clazz.getInnerClasses();
		assertEquals(1, innerClasses.size());
		assertEquals(class2, innerClasses.get(0));
	}
	
	@Test
	public void testSetFields(){
		List<JavaField> fields = ListUtil.createList(JavaField.builder().type("int").name("test").build(),
				JavaField.builder().type("String").name("derp").build());
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.fields(fields)
				.build();
		assertEquals(fields, clazz.getFields());
	}
	
	@Test
	public void testSetField(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.field(JavaField.builder().type("int").name("test").build())
				.build();
		List<JavaField> fields = clazz.getFields();
		assertEquals(1, fields.size());
		JavaField field = fields.get(0);
		assertEquals(Visibility.PRIVATE, field.getVisibility());
		assertEquals("int", field.getType());
		assertEquals("test", field.getName());
	}
	
	@Test
	public void testSetMethods(){
		List<JavaMethod> methods = ListUtil.createList(JavaMethod.builder().returnType("int").build(),
				JavaMethod.builder().returnType("String").build());
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.methods(methods)
				.build();
		assertEquals(methods, clazz.getMethods());
	}
	
	@Test
	public void testSetMethod(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.method(JavaMethod.builder().returnType("int").name("someMethod").line("return 42;").build())
				.build();
		List<JavaMethod> methods = clazz.getMethods();
		assertEquals(1, methods.size());
		JavaMethod method = methods.get(0);
		assertEquals(Visibility.PUBLIC, method.getVisibility());
		assertEquals("int", method.getReturnType());
		assertEquals("someMethod", method.getName());
		assertTrue(method.getParameters().isEmpty());
		List<String> lines = method.getLines();
		assertEquals(1, lines.size());
		assertEquals("return 42;", lines.get(0));
	}
	
	@Test
	public void testNullPackageName(){
		try{
			clazz = JavaClass.builder()
					.className("AClassName")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify packageName when not making an inner class!", e.getMessage());
		}
	}
	
	@Test
	public void testNullClassName(){
		try{
			clazz = JavaClass.builder()
					.packageName("some.package")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify className!", e.getMessage());
		}
	}
	
	@Test
	public void testInnerClassNotInnerClass(){
		try{
			JavaClass inner = JavaClass.builder()
					.packageName("some.package").className("AClassName")
					.build();
			clazz = JavaClass.builder()
					.packageName("some.package").className("BClassName")
					.innerClass(inner)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Inner class 'AClassName' is not an inner class!", e.getMessage());
		}
	}
	
	@Test
	public void testOuterClassCantBeStatic(){
		try{
			clazz = JavaClass.builder()
					.isStatic()
					.packageName("some.package").className("AClassName")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Only inner classes can be static!", e.getMessage());
		}
	}
	
	@Test
	public void testAllOuterClassErrors(){
		try{
			JavaClass inner = JavaClass.builder()
					.packageName("some.package").className("AClassName")
					.build();
			clazz = JavaClass.builder()
					.isStatic()
					.innerClass(inner)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("""
					Must specify className!
					Inner class 'AClassName' is not an inner class!
					Must specify packageName when not making an inner class!
					Only inner classes can be static!""", e.getMessage());
		}
	}
	
	@Test
	public void testNullClassNameInnerClass(){
		try{
			clazz = JavaClass.builder()
					.innerClass()
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify className!", e.getMessage());
		}
	}
	
	@Test
	public void testInnerClassNotInnerClassInInnerClass(){
		try{
			JavaClass inner = JavaClass.builder()
					.packageName("some.package").className("AClassName")
					.build();
			clazz = JavaClass.builder()
					.innerClass()
					.className("BClassName")
					.innerClass(inner)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Inner class 'AClassName' is not an inner class!", e.getMessage());
		}
	}
	
	@Test
	public void testSetPackageNameInnerClass(){
		try{
			clazz = JavaClass.builder()
					.innerClass()
					.packageName("some.package")
					.className("AClassName")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Not allowed to have packageName for an inner class!", e.getMessage());
		}
	}
	
	@Test
	public void testSetImportInnerClass(){
		try{
			clazz = JavaClass.builder()
					.innerClass()
					.className("AClassName")
					.singleImport("an.import")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Not allowed to have imports for an inner class!", e.getMessage());
		}
	}
	
	@Test
	public void testSetStaticImportInnerClass(){
		try{
			clazz = JavaClass.builder()
					.innerClass()
					.className("AClassName")
					.staticImport("an.other.import")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Not allowed to have static imports for an inner class!", e.getMessage());
		}
	}
	
	@Test
	public void testAllInnerClassBuilderErrors(){
		try{
			JavaClass inner = JavaClass.builder()
					.packageName("some.package").className("AClassName")
					.build();
			clazz = JavaClass.builder()
					.innerClass()
					.packageName("some.package")
					.innerClass(inner)
					.singleImport("an.import")
					.staticImport("an.other.import")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("""
					Must specify className!
					Inner class 'AClassName' is not an inner class!
					Not allowed to have packageName for an inner class!
					Not allowed to have imports for an inner class!
					Not allowed to have static imports for an inner class!""", e.getMessage());
		}
	}
	
	@Test
	public void testToString(){
		String javaString = """
				package some.package;
				
				public class AClassName{
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithSuperClassName(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName").superClassName("AnotherClassName")
				.build();
		String javaString = """
				package some.package;
				
				public class AClassName extends AnotherClassName{
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithJavadoc(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.javadoc(Javadoc.builder().build())
				.build();
		String javaString = """
				package some.package;
				
				/**
				 */
				public class AClassName{
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithAnnotations(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		JavaAnnotation derp = JavaAnnotation.builder().name("Derp").build();
		List<JavaAnnotation> annotations = ListUtil.createList(test, derp);
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.annotations(annotations)
				.build();
		String javaString = """
				package some.package;
				
				@Test
				@Derp
				public class AClassName{
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithImports(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.imports(ListUtil.createList("com.example.*", null, "com.github.tadukoo.*"))
				.build();
		String javaString = """
				package some.package;
				
				import com.example.*;
				
				import com.github.tadukoo.*;
				
				public class AClassName{
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithStaticImports(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.staticImports(ListUtil.createList("com.example.Test", null, "com.github.tadukoo.test.*"))
				.build();
		String javaString = """
				package some.package;
				
				import static com.example.Test;
				
				import static com.github.tadukoo.test.*;
				
				public class AClassName{
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithInnerClasses(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.innerClass(JavaClass.builder().innerClass().className("BClassName").build())
				.innerClass(JavaClass.builder().innerClass().className("CClassName").build())
				.build();
		String javaString = """
				package some.package;
				
				public class AClassName{
				\t
					public class BClassName{
					\t
					}
				\t
					public class CClassName{
					\t
					}
				\t
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithFields(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.field(JavaField.builder().type("int").name("test").build())
				.field(JavaField.builder().type("String").name("derp").build())
				.build();
		String javaString = """
				package some.package;
				
				public class AClassName{
				\t
					private int test;
					private String derp;
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithFieldsWithJavadocsOnFields(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.field(JavaField.builder()
						.javadoc(Javadoc.builder()
								.condensed()
								.content("something")
								.build())
						.type("int").name("test")
						.build())
				.field(JavaField.builder().type("String").name("derp").build())
				.build();
		String javaString = """
				package some.package;
				
				public class AClassName{
				\t
					/** something */
					private int test;
					private String derp;
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithMethods(){
		clazz = JavaClass.builder()
				.packageName("some.package").className("AClassName")
				.method(JavaMethod.builder().returnType("AClassName").build())
				.method(JavaMethod.builder().returnType("String").name("getSomething")
						.parameter("int", "test").line("return doSomething();").build())
				.build();
		String javaString = """
				package some.package;
				
				public class AClassName{
				\t
					public AClassName(){
					}
				\t
					public String getSomething(int test){
						return doSomething();
					}
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringWithEverything(){
		clazz = JavaClass.builder()
				.packageName("some.package")
				.imports(ListUtil.createList("com.example.*", "", "com.github.tadukoo.*"))
				.staticImports(ListUtil.createList("com.example.Test", "", "com.github.tadukoo.test.*"))
				.javadoc(Javadoc.builder().build())
				.annotation(JavaAnnotation.builder().name("Test").build())
				.annotation(JavaAnnotation.builder().name("Derp").build())
				.className("AClassName").superClassName("AnotherClassName")
				.innerClass(JavaClass.builder().innerClass().className("BClassName").build())
				.innerClass(JavaClass.builder().innerClass().className("CClassName").build())
				.field(JavaField.builder().type("int").name("test").build())
				.field(JavaField.builder().type("String").name("derp").build())
				.method(JavaMethod.builder().returnType("AClassName").build())
				.method(JavaMethod.builder().returnType("String").name("getSomething")
						.parameter("int", "test").line("return doSomething();").build())
				.build();
		String javaString = """
				package some.package;
				
				import com.example.*;
				
				import com.github.tadukoo.*;
				
				import static com.example.Test;
				
				import static com.github.tadukoo.test.*;
				
				/**
				 */
				@Test
				@Derp
				public class AClassName extends AnotherClassName{
				\t
					public class BClassName{
					\t
					}
				\t
					public class CClassName{
					\t
					}
				\t
					private int test;
					private String derp;
				\t
					public AClassName(){
					}
				\t
					public String getSomething(int test){
						return doSomething();
					}
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testToStringInnerClass(){
		clazz = JavaClass.builder()
				.innerClass()
				.className("AClassName")
				.build();
		assertEquals("""
				public class AClassName{
				\t
				}
				""", clazz.toString());
	}
	
	@Test
	public void testToStringStaticInnerClass(){
		clazz = JavaClass.builder()
				.innerClass()
				.isStatic()
				.className("AClassName")
				.build();
		assertEquals("""
				public static class AClassName{
				\t
				}
				""", clazz.toString());
	}
	
	@Test
	public void testToStringInnerClassWithEverything(){
		clazz = JavaClass.builder()
				.innerClass()
				.javadoc(Javadoc.builder().build())
				.annotation(JavaAnnotation.builder().name("Test").build())
				.annotation(JavaAnnotation.builder().name("Derp").build())
				.isStatic()
				.className("AClassName").superClassName("AnotherClassName")
				.innerClass(JavaClass.builder().innerClass().className("BClassName").build())
				.innerClass(JavaClass.builder().innerClass().className("CClassName").build())
				.field(JavaField.builder().type("int").name("test").build())
				.field(JavaField.builder().type("String").name("derp").build())
				.method(JavaMethod.builder().returnType("AClassName").build())
				.method(JavaMethod.builder().returnType("String").name("getSomething")
						.parameter("int", "test").line("return doSomething();").build())
				.build();
		String javaString = """
				/**
				 */
				@Test
				@Derp
				public static class AClassName extends AnotherClassName{
				\t
					public class BClassName{
					\t
					}
				\t
					public class CClassName{
					\t
					}
				\t
					private int test;
					private String derp;
				\t
					public AClassName(){
					}
				\t
					public String getSomething(int test){
						return doSomething();
					}
				}
				""";
		assertEquals(javaString, clazz.toString());
	}
	
	@Test
	public void testEquals(){
		clazz = JavaClass.builder()
				.packageName("some.package")
				.imports(ListUtil.createList("com.example.*", "", "com.github.tadukoo.*"))
				.staticImports(ListUtil.createList("com.example.Test", "", "com.github.tadukoo.test.*"))
				.javadoc(Javadoc.builder().build())
				.annotation(JavaAnnotation.builder().name("Test").build())
				.annotation(JavaAnnotation.builder().name("Derp").build())
				.className("AClassName").superClassName("AnotherClassName")
				.innerClass(JavaClass.builder().innerClass().className("BClassName").build())
				.innerClass(JavaClass.builder().innerClass().className("CClassName").build())
				.field(JavaField.builder().type("int").name("test").build())
				.field(JavaField.builder().type("String").name("derp").build())
				.method(JavaMethod.builder().returnType("AClassName").build())
				.method(JavaMethod.builder().returnType("String").name("getSomething")
						.parameter("int", "test").line("return doSomething();").build())
				.build();
		JavaClass otherClass = JavaClass.builder()
				.packageName("some.package")
				.imports(ListUtil.createList("com.example.*", "", "com.github.tadukoo.*"))
				.staticImports(ListUtil.createList("com.example.Test", "", "com.github.tadukoo.test.*"))
				.javadoc(Javadoc.builder().build())
				.annotation(JavaAnnotation.builder().name("Test").build())
				.annotation(JavaAnnotation.builder().name("Derp").build())
				.className("AClassName").superClassName("AnotherClassName")
				.innerClass(JavaClass.builder().innerClass().className("BClassName").build())
				.innerClass(JavaClass.builder().innerClass().className("CClassName").build())
				.field(JavaField.builder().type("int").name("test").build())
				.field(JavaField.builder().type("String").name("derp").build())
				.method(JavaMethod.builder().returnType("AClassName").build())
				.method(JavaMethod.builder().returnType("String").name("getSomething")
						.parameter("int", "test").line("return doSomething();").build())
				.build();
		assertEquals(clazz, otherClass);
	}
	
	@Test
	public void testEqualsNotEqual(){
		JavaClass otherClass = JavaClass.builder()
				.packageName("some.package.different").className("AClassName")
				.build();
		assertNotEquals(clazz, otherClass);
	}
	
	@Test
	public void testEqualsNotSameType(){
		assertNotEquals(clazz, "testing");
	}
}
