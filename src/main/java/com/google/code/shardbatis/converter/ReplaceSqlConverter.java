package com.google.code.shardbatis.converter;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.replace.Replace;

/**
 * Created by Yangxq on 2016/4/11.
 */
public class ReplaceSqlConverter extends AbstractSqlConverter {

    @Override
    protected Statement doConvert(Statement statement, Object params, String mapperId) {
        if (!(statement instanceof Replace)) {
            throw new IllegalArgumentException(
                    "The argument statement must is instance of Replace.");
        }
        Replace replace = (Replace) statement;

        String name = replace.getTable().getName();
        replace.getTable()
                .setName(this.convertTableName(name, params, mapperId));
        return replace;
    }
}
