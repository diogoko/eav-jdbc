package eav.jdbc;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.SQLParser;
import com.foundationdb.sql.parser.StatementNode;

public class OracleSqlParser {

	public ParsingTree parse(String sql) {
		try {
			SQLParser parser = new SQLParser();
			StatementNode statement = parser.parseStatement(sql);
			statement.treePrint();
			return new ParsingTree();
		} catch (StandardException e) {
			throw new IllegalArgumentException("Error parsing statement", e);
		}
	}

}
