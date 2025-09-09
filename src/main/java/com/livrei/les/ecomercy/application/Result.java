package com.livrei.les.ecomercy.application;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.livrei.les.ecomercy.domain.EntityDomain;

public class Result {
	 private List<EntityDomain> entities;
	    private String message;
	    private boolean success;
	    private int statusCode;
	    private Instant moment;
	    private List<String> errors;
	    private Map<String, Object> debugInfo;

	    public Result() {
	        this.moment = Instant.now();
	        this.errors = new ArrayList<>();
	        this.entities = new ArrayList<>();
	        this.debugInfo = new HashMap<>();
	    }

		public List<EntityDomain> getEntities() {
			return entities;
		}

		public void setEntities(List<EntityDomain> entities) {
			this.entities = entities;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public Instant getMoment() {
			return moment;
		}

		public void setMoment(Instant moment) {
			this.moment = moment;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}

		public Map<String, Object> getDebugInfo() {
			return debugInfo;
		}

		public void setDebugInfo(Map<String, Object> debugInfo) {
			this.debugInfo = debugInfo;
		}
}
