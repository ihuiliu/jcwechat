package cn.goldfiance.com.domain;
/**
 * 
 * @author liuhui 2016 6 14
 *
 */
public class Broker {
	
	
	/**
	 * brokerNo
	 *   "brokername": "经理一",
        "mobileno": "13502036231",
        "email": ""

	 */
		private String brokerNo;
	 	private String brokerName;
	    private String mobileNo;
		private String email;
		
		public String getBrokerNo() {
			return brokerNo;
		}
		public void setBrokerNo(String brokerNo) {
			this.brokerNo = brokerNo;
		}
		
		public String getBrokerName() {
			return brokerName;
		}
		public void setBrokerName(String brokerName) {
			this.brokerName = brokerName;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}
