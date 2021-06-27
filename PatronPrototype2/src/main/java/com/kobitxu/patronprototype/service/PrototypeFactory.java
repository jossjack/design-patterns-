package com.kobitxu.patronprototype.service;

import java.util.HashMap;

import com.kobitxu.patronprototype.model.IPrototype;

public class PrototypeFactory {
	private static HashMap<String, IPrototype> prototypes = new HashMap<>();

	public static IPrototype getPrototype(String prototypeName) {
		return prototypes.get(prototypeName).deepClone();
	}

	public static void addPrototype(String prototypeName, IPrototype prototype) {
		prototypes.put(prototypeName, prototype);
	}
}