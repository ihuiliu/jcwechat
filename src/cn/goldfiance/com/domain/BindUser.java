package cn.goldfiance.com.domain;
/**
 * 
 * @author liuhui 2016 6 16
 * 绑定用户实体
 */
public class BindUser {
	private String openid;
	private String custno;
	private String ticket;
	//private String status;
	/*public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	

}
