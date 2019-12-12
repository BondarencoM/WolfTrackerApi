package com.wolfpack.tracker.helpers;

import org.hibernate.Hibernate;

public class HibernateHelper {

    private HibernateHelper(){};

    public static <ProxyBaseType> ProxyBaseType resolveProxy(ProxyBaseType wolfProxy){
        return (ProxyBaseType) Hibernate.unproxy(wolfProxy);
    }
}
