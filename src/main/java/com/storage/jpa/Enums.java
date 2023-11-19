package com.storage.jpa;

public class Enums {

	public static enum ConnectorType {
		HTTP, FTP, S3, SHAREPOINT, RSS
		// Add more connector types as needed
	}

	public static enum FileType {
		JSON("json"), XML("xml"), RSS("rss");

		// Add more connector types as needed
		private String type;

		FileType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

	}

	public static enum EngineType {
		INGESTION("ingestion"), TRANSFORMER("transformer");

		// Add more connector types as needed
		private String type;

		EngineType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

	}

}
