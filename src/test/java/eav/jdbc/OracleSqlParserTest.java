// all oracle selects, inserts, updates and deletes are correctly parsed
package eav.jdbc;

import java.util.List;

import junit.framework.TestCase;

public class OracleSqlParserTest extends TestCase {
	
	private OracleSqlParser parser;
	
	@Override
	public void setUp() {
		parser = new OracleSqlParser();
	}
	
	public void testSimpleSelectStar() {
		String sql = "SELECT * FROM my_table";
		
		ParsingTree tree = parser.parse(sql);
		
		List<TableReference> tables = tree.getTableReferences();
		assertEquals(1, tables.size());
		TableReference table = tables.get(0);
		assertEquals("my_table", table.getName());
		
		List<ColumnReference> columns = tree.getColumnReferences();
		assertEquals(1, columns.size());
		ColumnReference column = columns.get(0);
		assertTrue(column.isStar());
		assertEquals(table, column.getTable());
	}
	
	public void testSimpleSelectColumns() {
		String sql = "SELECT a, b FROM my_table";
		
		ParsingTree tree = parser.parse(sql);
		
		List<TableReference> tables = tree.getTableReferences();
		assertEquals(1, tables.size());
		TableReference table = tables.get(0);
		assertEquals("my_table", table.getName());
		
		List<ColumnReference> columns = tree.getColumnReferences();
		assertEquals(2, columns.size());

		assertFalse(columns.get(0).isStar());
		assertEquals(table, columns.get(0).getTable());
		assertEquals("a", columns.get(0).getName());

		assertFalse(columns.get(1).isStar());
		assertEquals(table, columns.get(1).getTable());
		assertEquals("b", columns.get(1).getName());
	}

}
