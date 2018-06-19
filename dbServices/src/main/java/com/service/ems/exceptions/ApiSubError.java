package com.service.ems.exceptions;

abstract class ApiSubError {

}


class ApiValidationError extends ApiSubError {
   public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		super();
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}



private String object;
   private String field;
   private Object rejectedValue;
   private String message;
   
   

   @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((field == null) ? 0 : field.hashCode());
	result = prime * result + ((message == null) ? 0 : message.hashCode());
	result = prime * result + ((object == null) ? 0 : object.hashCode());
	result = prime * result + ((rejectedValue == null) ? 0 : rejectedValue.hashCode());
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ApiValidationError other = (ApiValidationError) obj;
	if (field == null) {
		if (other.field != null)
			return false;
	} else if (!field.equals(other.field))
		return false;
	if (message == null) {
		if (other.message != null)
			return false;
	} else if (!message.equals(other.message))
		return false;
	if (object == null) {
		if (other.object != null)
			return false;
	} else if (!object.equals(other.object))
		return false;
	if (rejectedValue == null) {
		if (other.rejectedValue != null)
			return false;
	} else if (!rejectedValue.equals(other.rejectedValue))
		return false;
	return true;
}



ApiValidationError(String object, String message) {
       this.object = object;
       this.message = message;
   }
}