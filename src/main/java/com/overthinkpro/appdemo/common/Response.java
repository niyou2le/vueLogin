package com.overthinkpro.appdemo.common;

public class Response {
	private static final String OK = "ok";
	private static final String Error = "error";
	private Meta meta;
	private Object data;

	public Response success() {
		meta = new Meta(true, OK);
		return this;
	}

	public Response success(Object data) {
		meta = new Meta(true, OK);
		this.data = data;
		return this;
	}

	public Response failure() {
		meta = new Meta(false, Error);
		return this;
	}
	
	public Response failure(String message) {
		meta = new Meta(false, message);
		return this;
	}

	class Meta {
		private boolean success;
		private String message;

		Meta(boolean success) {
			this.success = success;
		}

		Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}

	}

}
