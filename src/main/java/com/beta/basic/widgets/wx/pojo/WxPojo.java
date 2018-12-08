package com.beta.basic.widgets.wx.pojo;

public class WxPojo {
	private String signature;
	private String echostr;
	private String timestamp;
	private String nonce;

	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public WxPojo(String signature, String echostr, String timestamp, String nonce) {
		super();
		this.signature = signature;
		this.echostr = echostr;
		this.timestamp = timestamp;
		this.nonce = nonce;
	}
	public WxPojo() {
		super();
	}
	@Override
	public String toString() {
		return "WxPojo [signature=" + signature + ", echostr=" + echostr + ", timestamp=" + timestamp + ", nonce="
				+ nonce + "]";
	}
}
