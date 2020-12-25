package com.is.films.movie_rentables.utils;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;
/**
 * Source: https://www.zymr.com/postgresql-full-text-searchfts-hibernate/
 */
public class PostgreSQLFtsFunction implements SQLFunction {
    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override
    public Type getReturnType(Type type, Mapping mapping) throws QueryException {
        return new BooleanType();
    }

    @Override
    public String render(Type type, List list, SessionFactoryImplementor sessionFactoryImplementor) throws QueryException {
        if (list== null || list.size() < 2) {
            throw new IllegalArgumentException("The function must be passed at least 2 arguments");
        }
        String fragment = null;
        String ftsConfiguration = null;
        String field = null;
        String value = null;
        if (list.size() == 3) {
            ftsConfiguration = (String) list.get(0);
            field = (String) list.get(1);
            value = (String) list.get(2);
            fragment = "to_tsvector(" + ftsConfiguration + ", " + field + ") @@ " + "plainto_tsquery(" + ftsConfiguration + ", " + value + ")";
        } else {
            field = (String) list.get(0);
            value = (String) list.get(1);
            fragment = "to_tsvector(" + field + ") @@ " + "plainto_tsquery('" + value + "')";

        }
        return fragment;
    }
}
