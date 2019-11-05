package com.turkcell.training.patterns;

public class Connection {
	private String url;
	private String username;
	private String password;
	
	private Connection() {
	}
	
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public static ConnectionBuilder getBuilder() {
		return new ConnectionBuilder();
	}

	static public class ConnectionBuilder{
		private Connection connection;
		private ConnectionBuilder() {
		}
		
		public ConnectionBuilder withUrl(String url) {
			connection.url = url;
			return this;
		}

		public ConnectionBuilder withUsername(String username) {
			connection.username = username;
			return this;
		}

		public ConnectionBuilder withPassword(String password) {
			connection.password = password;
			return this;
		}
		
		public Connection build() {
			return connection;
		}
		
	}
	
	
}
