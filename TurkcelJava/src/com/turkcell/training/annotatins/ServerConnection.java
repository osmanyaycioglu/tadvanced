package com.turkcell.training.annotatins;

@PropertySource(value = "my.properties",fallback = "test.properties")
public class ServerConnection {
	@Property("server.port")
	private int port;
	@Property("server.ip")
	private String ip;
	@Property("server.desc")
	private String desc;
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "ServerConnection [port=" + port + ", ip=" + ip + ", desc=" + desc + "]";
	}
	
	
	
}
