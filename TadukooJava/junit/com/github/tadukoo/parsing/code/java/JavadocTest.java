package com.github.tadukoo.parsing.code.java;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavadocTest{
	private Javadoc doc;
	
	@BeforeEach
	public void setup(){
		doc = Javadoc.builder()
				.build();
	}
	
	@Test
	public void testDefaultCondensed(){
		assertFalse(doc.isCondensed());
	}
	
	@Test
	public void testDefaultContent(){
		List<String> content = doc.getContent();
		assertNotNull(content);
		assertEquals(0, content.size());
	}
	
	@Test
	public void testDefaultAuthor(){
		assertNull(doc.getAuthor());
	}
	
	@Test
	public void testDefaultVersion(){
		assertNull(doc.getVersion());
	}
	
	@Test
	public void testDefaultSince(){
		assertNull(doc.getSince());
	}
	
	@Test
	public void testDefaultParams(){
		List<Pair<String, String>> params = doc.getParams();
		assertNotNull(params);
		assertEquals(0, params.size());
	}
	
	@Test
	public void testDefaultReturnVal(){
		assertNull(doc.getReturnVal());
	}
	
	@Test
	public void testSetCondensedValue(){
		doc = Javadoc.builder()
				.condensed(true)
				.build();
		assertTrue(doc.isCondensed());
	}
	
	@Test
	public void testSetCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.build();
		assertTrue(doc.isCondensed());
	}
	
	@Test
	public void testSetContent(){
		List<String> content = ListUtil.createList("test", "derp");
		doc = Javadoc.builder()
				.content(content)
				.build();
		assertEquals(content, doc.getContent());
	}
	
	@Test
	public void testSetContentLine(){
		String content = "test";
		doc = Javadoc.builder()
				.content(content)
				.build();
		List<String> actContent = doc.getContent();
		assertEquals(1, actContent.size());
		assertEquals(content, actContent.get(0));
	}
	
	@Test
	public void testSetAuthor(){
		doc = Javadoc.builder()
				.author("Logan Ferree (Tadukoo)")
				.build();
		assertEquals("Logan Ferree (Tadukoo)", doc.getAuthor());
	}
	
	@Test
	public void testSetVersion(){
		doc = Javadoc.builder()
				.version("Alpha v.0.1")
				.build();
		assertEquals("Alpha v.0.1", doc.getVersion());
	}
	
	@Test
	public void testSetSince(){
		doc = Javadoc.builder()
				.since("Alpha v.0.0.1")
				.build();
		assertEquals("Alpha v.0.0.1", doc.getSince());
	}
	
	@Test
	public void testSetParams(){
		List<Pair<String, String>> params = ListUtil.createList(Pair.of("test", "yes"),
				Pair.of("derp", "no"));
		doc = Javadoc.builder()
				.params(params)
				.build();
		assertEquals(params, doc.getParams());
	}
	
	@Test
	public void testSetParamPair(){
		Pair<String, String> param = Pair.of("test", "yes");
		doc = Javadoc.builder()
				.param(param)
				.build();
		List<Pair<String, String>> params = doc.getParams();
		assertEquals(1, params.size());
		assertEquals(param, params.get(0));
	}
	
	@Test
	public void testSetParamPieces(){
		doc = Javadoc.builder()
				.param("test", "yes")
				.build();
		List<Pair<String, String>> params = doc.getParams();
		assertEquals(1, params.size());
		Pair<String, String> param = params.get(0);
		assertEquals("test", param.getLeft());
		assertEquals("yes", param.getRight());
	}
	
	@Test
	public void testSetReturnVal(){
		doc = Javadoc.builder()
				.returnVal("this, to continue building")
				.build();
		assertEquals("this, to continue building", doc.getReturnVal());
	}
	
	@Test
	public void testSetAll(){
		List<String> content = ListUtil.createList("test", "derp");
		List<Pair<String, String>> params = ListUtil.createList(Pair.of("test", "yes"),
				Pair.of("derp", "no"));
		doc = Javadoc.builder()
				.condensed()
				.content(content)
				.author("Logan Ferree (Tadukoo)")
				.version("Alpha v.0.1")
				.since("Alpha v.0.0.1")
				.params(params)
				.returnVal("this, to continue building")
				.build();
		assertTrue(doc.isCondensed());
		assertEquals(content, doc.getContent());
		assertEquals("Logan Ferree (Tadukoo)", doc.getAuthor());
		assertEquals("Alpha v.0.1", doc.getVersion());
		assertEquals("Alpha v.0.0.1", doc.getSince());
		assertEquals(params, doc.getParams());
		assertEquals("this, to continue building", doc.getReturnVal());
	}
	
	@Test
	public void testToString(){
		assertEquals("/**\n */", doc.toString());
	}
	
	@Test
	public void testToStringWithContent(){
		doc = Javadoc.builder()
				.content("test")
				.content("derp")
				.build();
		assertEquals("""
				/**
				 * test
				 * derp
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithAuthor(){
		doc = Javadoc.builder()
				.author("Logan Ferree (Tadukoo)")
				.build();
		assertEquals("""
				/**
				 * @author Logan Ferree (Tadukoo)
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithVersion(){
		doc = Javadoc.builder()
				.version("Alpha v.0.1")
				.build();
		assertEquals("""
				/**
				 * @version Alpha v.0.1
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithSince(){
		doc = Javadoc.builder()
				.since("Alpha v.0.0.1")
				.build();
		assertEquals("""
				/**
				 * @since Alpha v.0.0.1
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithSingleParam(){
		doc = Javadoc.builder()
				.param("test", "yes")
				.build();
		assertEquals("""
				/**
				 * @param test yes
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithMultipleParams(){
		doc = Javadoc.builder()
				.param("test", "yes")
				.param("derp", "no")
				.build();
		assertEquals("""
				/**
				 * @param test yes
				 * @param derp no
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithReturnVal(){
		doc = Javadoc.builder()
				.returnVal("this, to continue building")
				.build();
		assertEquals("""
				/**
				 * @return this, to continue building
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringWithEverything(){
		doc = Javadoc.builder()
				.content("test")
				.content("derp")
				.author("Logan Ferree (Tadukoo)")
				.version("Alpha v.0.1")
				.since("Alpha v.0.0.1")
				.param("test", "yes")
				.param("derp", "no")
				.returnVal("this, to continue building")
				.build();
		assertEquals("""
				/**
				 * test
				 * derp
				 *\040
				 * @author Logan Ferree (Tadukoo)
				 * @version Alpha v.0.1
				 * @since Alpha v.0.0.1
				 *\040
				 * @param test yes
				 * @param derp no
				 * @return this, to continue building
				 */""", doc.toString());
	}
	
	@Test
	public void testToStringCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.build();
		assertEquals("/** */", doc.toString());
	}
	
	@Test
	public void testToStringWithContentCondensed(){
		List<String> content = ListUtil.createList("test", "derp");
		doc = Javadoc.builder()
				.condensed()
				.content(content)
				.build();
		assertEquals("""
				/** test
				 * derp */""", doc.toString());
	}
	
	@Test
	public void testToStringWithAuthorCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.author("Logan Ferree (Tadukoo)")
				.build();
		assertEquals("/** @author Logan Ferree (Tadukoo) */", doc.toString());
	}
	
	@Test
	public void testToStringWithVersionCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.version("Alpha v.0.1")
				.build();
		assertEquals("/** @version Alpha v.0.1 */", doc.toString());
	}
	
	@Test
	public void testToStringWithSinceCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.since("Alpha v.0.0.1")
				.build();
		assertEquals("/** @since Alpha v.0.0.1 */", doc.toString());
	}
	
	@Test
	public void testToStringWithSingleParamCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.param("test", "yes")
				.build();
		assertEquals("""
				/** @param test yes */""", doc.toString());
	}
	
	@Test
	public void testToStringWithMultipleParamsCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.param("test", "yes")
				.param("derp", "no")
				.build();
		assertEquals("""
				/** @param test yes
				 * @param derp no */""", doc.toString());
	}
	
	@Test
	public void testToStringWithReturnValCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.returnVal("this, to continue building")
				.build();
		assertEquals("""
				/** @return this, to continue building */""", doc.toString());
	}
	
	@Test
	public void testToStringWithEverythingCondensed(){
		doc = Javadoc.builder()
				.condensed()
				.content("test")
				.content("derp")
				.author("Logan Ferree (Tadukoo)")
				.version("Alpha v.0.1")
				.since("Alpha v.0.0.1")
				.param("test", "yes")
				.param("derp", "no")
				.returnVal("this, to continue building")
				.build();
		assertEquals("""
				/** test
				 * derp
				 *\040
				 * @author Logan Ferree (Tadukoo)
				 * @version Alpha v.0.1
				 * @since Alpha v.0.0.1
				 *\040
				 * @param test yes
				 * @param derp no
				 * @return this, to continue building */""", doc.toString());
	}
}
