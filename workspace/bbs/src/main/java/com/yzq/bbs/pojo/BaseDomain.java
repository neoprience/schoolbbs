package com.yzq.bbs.pojo;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: withstars
 * Date: 2018-04-22
 * Time: 8:43
 * Mail: withstars@126.com
 */
public class BaseDomain implements Serializable {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
