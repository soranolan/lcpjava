package com.example.lcpjava.common;

import java.util.Objects;

public class AuthenticationToken {
	
	public String tokenId;
	
	public int expiredTime;
	
	public boolean inValid;
	
	public AuthenticationToken() {}
	
	public AuthenticationToken(String tokenId, int expiredTime) {
		this.tokenId = tokenId;
		this.expiredTime = expiredTime;
	}
	
	@Override
	public String toString() {
		return "AuthenticationToken [tokenId=" + tokenId + ", expiredTime=" + expiredTime + ", inValid=" + inValid + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(expiredTime, inValid, tokenId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthenticationToken other = (AuthenticationToken) obj;
		return expiredTime == other.expiredTime && inValid == other.inValid && Objects.equals(tokenId, other.tokenId);
	}
	
}
