package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class JavaFieldTest{
	private JavaField field = JavaField.builder()
			.type("int").name("test")
			.build();
	
	@Test
	public void testDefaultAnnotations(){
		assertTrue(field.getAnnotations().isEmpty());
	}
	
	@Test
	public void testDefaultVisibility(){
		assertEquals(Visibility.PRIVATE, field.getVisibility());
	}
	
	@Test
	public void testDefaultIsFinal(){
		assertFalse(field.isFinal());
	}
	
	@Test
	public void testDefaultValue(){
		assertNull(field.getValue());
	}
	
	@Test
	public void testSetType(){
		assertEquals("int", field.getType());
	}
	
	@Test
	public void testSetName(){
		assertEquals("test", field.getName());
	}
	
	@Test
	public void testSetAnnotations(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		JavaAnnotation derp = JavaAnnotation.builder().name("Derp").build();
		List<JavaAnnotation> annotations = ListUtil.createList(test, derp);
		field = JavaField.builder()
				.annotations(annotations)
				.type("int").name("test")
				.build();
		assertEquals(annotations, field.getAnnotations());
	}
	
	@Test
	public void testSetAnnotation(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		field = JavaField.builder()
				.annotation(test)
				.type("int").name("Test").build();
		List<JavaAnnotation> annotations = field.getAnnotations();
		assertEquals(1, annotations.size());
		assertEquals(test, annotations.get(0));
	}
	
	@Test
	public void testSetVisibility(){
		field = JavaField.builder()
				.visibility(Visibility.PUBLIC).type("int").name("test")
				.build();
		
		assertEquals(Visibility.PUBLIC, field.getVisibility());
	}
	
	@Test
	public void testSetIsFinal(){
		field = JavaField.builder()
				.type("int").name("test").isFinal(false)
				.build();
		assertFalse(field.isFinal());
		
		field = JavaField.builder()
				.type("int").name("test").isFinal(true)
				.build();
		assertTrue(field.isFinal());
	}
	
	@Test
	public void testIsFinal(){
		field = JavaField.builder()
				.type("int").name("test").isFinal()
				.build();
		assertTrue(field.isFinal());
	}
	
	@Test
	public void testSetValue(){
		field = JavaField.builder()
				.type("int").name("test")
				.value("42")
				.build();
		assertEquals("42", field.getValue());
	}
	
	@Test
	public void testNullType(){
		try{
			field = JavaField.builder()
					.name("test")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify type!", e.getMessage());
		}
	}
	
	@Test
	public void testNullName(){
		try{
			field = JavaField.builder()
					.type("int")
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify name!", e.getMessage());
		}
	}
	
	@Test
	public void testNullTypeAndName(){
		try{
			field = JavaField.builder()
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify type!\nMust specify name!", e.getMessage());
		}
	}
	
	@Test
	public void testToString(){
		assertEquals("private int test", field.toString());
	}
	
	@Test
	public void testToStringWithSingleAnnotation(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		field = JavaField.builder()
				.type("int").name("test")
				.annotation(test)
				.build();
		String javaString = """
				@Test
				private int test""";
		assertEquals(javaString, field.toString());
	}
	
	@Test
	public void testToStringWithAnnotations(){
		JavaAnnotation test = JavaAnnotation.builder().name("Test").build();
		JavaAnnotation derp = JavaAnnotation.builder().name("Derp").build();
		field = JavaField.builder()
				.type("int").name("test")
				.annotation(test).annotation(derp)
				.build();
		String javaString = """
				@Test
				@Derp
				private int test""";
		assertEquals(javaString, field.toString());
	}
	
	@Test
	public void testToStringWithIsFinal(){
		field = JavaField.builder()
				.type("int").name("test")
				.isFinal()
				.build();
		String javaString = """
				private final int test""";
		assertEquals(javaString, field.toString());
	}
	
	@Test
	public void testToStringWithValue(){
		field = JavaField.builder()
				.type("int").name("test")
				.value("42")
				.build();
		assertEquals("private int test = 42", field.toString());
	}
	
	@Test
	public void testToStringWithEverything(){
		field = JavaField.builder()
				.type("int").name("test")
				.annotation(JavaAnnotation.builder().name("Test").build())
				.annotation(JavaAnnotation.builder().name("Derp").build())
				.isFinal()
				.value("42")
				.build();
		String javaString = """
				@Test
				@Derp
				private final int test = 42""";
		assertEquals(javaString, field.toString());
	}
}
