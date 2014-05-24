grammar Oracle;


tokens {
	SELECT,
	FROM
}


select : subquery ';'? ;

subquery :
	(
		query_block
		//| subquery ( ( 'UNION' 'ALL'? | 'INTERSECT' | 'MINUS' ) subquery )+
		//| '(' subquery ')'
	)
	//order_by_clause
;

query_block : 'SELECT' select_list 'FROM' table_reference ;

select_list : expr ( ',' expr )* ;

table_reference : NAME ;

expr : NAME ;

NAME : [A-Z] [A-Z0-9_]* ;
