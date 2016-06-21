package cn.goldfiance.com.domain;

import java.util.List;

/**
 * 
 * @author liuhui 2016 6 14
 *
 */
public class User {
	/**
	 * "custno": "20160509006",
      "custname": "金钢",
      "gender": "先生",
      "identityno": "411526199405041919",
      "identitynype": "身份证",
      "mobileno": "13323456789",
      "point": 0,
      "isFrozen": 0,
      "riskType": "1000",
      "address": "登云路99号",
      "rank": "白银级",
      "firstbroker": {
        "brokername": "经理一",
        "mobileno": "13502036231",
        "email": ""
      },
      "password": "",
      "ticket": "CC2C18D67B219DA206438E76EB9423F7D9B0EB4FF6B2......"

	 */
	private String custno;
    private String custname;
        
    private String gender;
    private String identityno;
    
    private String identitynype;
    private int isFrozen;
    private String riskType;
    private String mobileno;
    
    private String point;
    private String address;
    
    private String rank;
    private String password;
    private Broker firstBroker;
    private String ticket;
    
	public String getIdentitynype() {
		return identitynype;
	}
	public void setIdentitynype(String identitynype) {
		this.identitynype = identitynype;
	}
	public int getIsFrozen() {
		return isFrozen;
	}
	public void setIsFrozen(int isFrozen) {
		this.isFrozen = isFrozen;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdentityno() {
		return identityno;
	}
	public void setIdentityno(String identityno) {
		this.identityno = identityno;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Broker getFirstBroker() {
		return firstBroker;
	}
	public void setFirstBroker(Broker firstBroker) {
		this.firstBroker = firstBroker;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
    

}
