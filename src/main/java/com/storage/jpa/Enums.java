package com.storage.jpa;

public class Enums {

	public static enum ConnectorType {
		HTTP, FTP, S3, SHAREPOINT, RSS
		// Add more connector types as needed
	}

	public static enum FileType {
		JSON("json"), XML("xml");

		// Add more connector types as needed
		private String type;

		FileType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

	}

}
