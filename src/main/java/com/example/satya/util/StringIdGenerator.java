package com.example.satya.util;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StringIdGenerator implements IdentifierGenerator {

    private static final long serialVersionUID = 6580027363949610070L;


	@Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return Long.toString(System.currentTimeMillis());
    }
    
    
    public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}