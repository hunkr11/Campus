// created for tiles through java configuration but didn't worked  

package com.hifi.thattukada.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Definition;
//import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;

public class JavaDefinitionsFactory extends UnresolvingLocaleDefinitionsFactory {
	private static final Map<String,Definition> tiles = new HashMap<String,Definition>();
	
	
	public JavaDefinitionsFactory(){}
	
//	@Override
//	 public Definition getDefinition(String name,TilesRequestContext tilesContext) {
//		System.out.println("\n \n class JavaDefinitionsFactory getDefinition() method calling name...."+name  +" \n \n");
//	        return tiles.get(name);
//	 }
}
