package eav.jdbc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import eav.jdbc.OracleParser.SelectContext;

public class OracleSqlParser {

	public ParsingTree parse(String sql) {
		CharStream input = new ANTLRInputStream(sql);
		OracleLexer lexer = new OracleLexer(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		OracleParser parser = new OracleParser(tokenStream);
		SelectContext tree = parser.select();
		
		return new ParsingTree();
	}

}
