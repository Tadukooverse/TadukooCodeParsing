package com.github.tadukoo.parsing.code.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JavaAnnotationTest{
	private JavaAnnotation annotation;
	
	@Test
	public void testBuilderName(){
		annotation = JavaAnnotation.builder().name("Test").build();
		assertEquals("Test", annotation.getName());
	}
	
	@Test
	public void testBuilderMissingName(){
		try{
			annotation = JavaAnnotation.builder().build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Must specify name!", e.getMessage());
		}
	}
	
	@Test
	public void testToString(){
		annotation = JavaAnnotation.builder().name("Test").build();
		assertEquals("@Test", annotation.toString());
	}
	
	/*
	 * Test Equals
	 */
	
	@Test
	public void testEquals(){
		annotation = JavaAnnotation.builder().name("Test").build();
		JavaAnnotation otherAnnotation = JavaAnnotation.builder().name("Test").build();
		assertEquals(annotation, otherAnnotation);
	}
	
	@Test
	public void testEqualsNotEqual(){
		annotation = JavaAnnotation.builder().name("Test").build();
		JavaAnnotation otherAnnotation = JavaAnnotation.builder().name("Testing").build();
		assertNotEquals(annotation, otherAnnotation);
	}
	
	@Test
	public void testEqualsDifferentType(){
		annotation = JavaAnnotation.builder().name("Test").build();
		assertNotEquals(annotation, "testing");
	}
}
