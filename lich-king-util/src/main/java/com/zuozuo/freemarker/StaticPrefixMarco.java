package com.zuozuo.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * Created by bug on 15/11/27.
 */
public class StaticPrefixMarco implements TemplateMethodModelEx {

//    private static final String BASE_STATIC_PREFIX = "lich-king";
    private static final String BASE_STATIC_PREFIX = "7xo6gy.com1.z0.glb.clouddn.com";

    public Object exec(List list) throws TemplateModelException {
        return BASE_STATIC_PREFIX + list.get(0);
    }
}
