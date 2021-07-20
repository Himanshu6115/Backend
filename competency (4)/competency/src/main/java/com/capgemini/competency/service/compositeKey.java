package com.capgemini.competency.service;

import java.io.Serializable;
import java.util.Objects;

public class compositeKey implements Serializable {
	
	private int serialId;
	private int globalId;
	
	public compositeKey() {
		
	}
	
	public compositeKey(int serialId, int globalId) {
		this.globalId = globalId;
		this.serialId = serialId;
	}

	@Override
	public int hashCode() {
	/*	final int prime = 31;
		int result = 1;
		result = prime * result + globalId;
		result = prime * result + serialId;
		return result;*/
		return Objects.hash(serialId,globalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		compositeKey other = (compositeKey) obj;
	    return serialId==other.serialId && globalId==other.globalId;
	    
	}

	
}
