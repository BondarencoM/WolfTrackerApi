package com.wolfpack.tracker.helpers;

import org.hibernate.Hibernate;

/**
 * Contains static methods that help
 * perform trivial Hibernate related tasks.
 * Cannot be instantiated
 */
public class HibernateHelper {

    private HibernateHelper(){};

    @SuppressWarnings("unchecked")
    public static <ProxyBaseType> ProxyBaseType resolveProxy(ProxyBaseType wolfProxy){
        return (ProxyBaseType) Hibernate.unproxy(wolfProxy);
    }
}
