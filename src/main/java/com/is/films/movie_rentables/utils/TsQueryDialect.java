package com.is.films.movie_rentables.utils;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.dialect.function.SQLFunction;

/**
 * Source: https://www.zymr.com/postgresql-full-text-searchfts-hibernate/
 */
public class TsQueryDialect extends PostgreSQL9Dialect {
    @Override
    protected void registerFunction(String name, SQLFunction function) {
        super.registerFunction("fts", new PostgreSQLFtsFunction());
    }
}
