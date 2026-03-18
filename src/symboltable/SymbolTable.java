package symboltable;

import java.util.*;
import ast.definition.Definition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;
	public SymbolTable()  {
		table = new ArrayList<Map<String, Definition>>();
		table.add(new HashMap<String, Definition>());
	}

	public void set() {
		table.add(new HashMap<String, Definition>());
		scope++;
	}
	
	public void reset() {
		table.removeLast();
		scope--;
	}
	
	public boolean insert(Definition definition) {
		if(findInCurrentScope(definition.getName()) == null){
			definition.setScope(scope);
			table.get(scope).put(definition.getName(), definition);
			return true;
		}else{
			return false;
		}
	}
	
	public Definition find(String id) {
		for(Map<String, Definition> map : table){
			for(String name : map.keySet()){
				if(name.equals(id)){
					return map.get(name);
				}
			}
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		Map<String, Definition> actualTable = table.get(scope);
		for(String name : actualTable.keySet()){
			if(name.equals(id)){
				return actualTable.get(name);
			}
		}
		return null;
	}
}
