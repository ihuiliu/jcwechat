module.exports = function(imitator) {

	imitator.static('/jcwechat', './public');
	//风险测评
    imitator({
        url: '/jcwechat/risk.action',
        result: {"result":200,"content":{"investRiskAQ":{"no":"1","aqType":"1010","content":"私募基金投资者风险识别能力和承受能力调查问卷（个人）","remark":"","special":{"no":"2","serialNo":0,"questionType":"1010","content":"请您确认符合以下哪种条件？","remark":"","options":[{"no":"3","serialNo":1,"content":"A. 金融资产不低于300 万元（金融资产包括银行存款、股票、债券、基金份额、资产管理计划、银行理财产品、信托计划、保险产品、期货权益等）","score":0.0,"remark":""},{"no":"4","serialNo":2,"content":"B.最近三年个人年均收入不低于50 万元","score":0.0,"remark":""},{"no":"5","serialNo":3,"content":"C.投资于所管理私募基金的私募基金管理人的从业人员","score":0.0,"remark":""}]},"questions":[{"no":"6","serialNo":1,"questionType":"1010","content":"您的年龄?","remark":"","options":[{"no":"7","serialNo":1,"content":"A.高于60岁","score":1.0,"remark":""},{"no":"8","serialNo":2,"content":"B.51岁-60岁","score":2.0,"remark":""},{"no":"9","serialNo":3,"content":"C.41岁-50岁","score":3.0,"remark":""},{"no":"10","serialNo":4,"content":"D.31岁-40岁","score":4.0,"remark":""},{"no":"11","serialNo":5,"content":"E.30岁以下","score":5.0,"remark":""}]},{"no":"12","serialNo":2,"questionType":"1010","content":"您的学历?","remark":"","options":[{"no":"13","serialNo":1,"content":"A.初中及以下","score":1.0,"remark":""},{"no":"14","serialNo":2,"content":"B.高中或中专","score":2.0,"remark":""},{"no":"15","serialNo":3,"content":"C.大专","score":3.0,"remark":""},{"no":"16","serialNo":4,"content":"D.本科","score":4.0,"remark":""},{"no":"17","serialNo":5,"content":"E.硕士及以上","score":5.0,"remark":""}]},{"no":"18","serialNo":3,"questionType":"1010","content":"您的职业?","remark":"","options":[{"no":"19","serialNo":1,"content":"A.其他","score":1.0,"remark":""},{"no":"20","serialNo":2,"content":"B.机关企事业单位员工","score":2.0,"remark":""},{"no":"21","serialNo":3,"content":"C.金融行业从业人员及退休人员","score":3.0,"remark":""},{"no":"22","serialNo":4,"content":"D.公司高管","score":4.0,"remark":""},{"no":"23","serialNo":5,"content":"E.私营企业主","score":5.0,"remark":""}]},{"no":"24","serialNo":4,"questionType":"1010","content":"您对金融法律法规、投资市场及产品情况的了解程度可描述为","remark":"","options":[{"no":"25","serialNo":1,"content":"A.从来没接触过","score":1.0,"remark":""},{"no":"26","serialNo":2,"content":"B.听说过，不太了解","score":2.0,"remark":""},{"no":"27","serialNo":3,"content":"C.一般了解","score":3.0,"remark":""},{"no":"28","serialNo":4,"content":"D.比较了解","score":4.0,"remark":""},{"no":"29","serialNo":5,"content":"E.非常了解","score":5.0,"remark":""}]},{"no":"30","serialNo":5,"questionType":"1010","content":"最近三年个人年均收入？","remark":"","options":[{"no":"31","serialNo":1,"content":"A.20万元以下","score":2.0,"remark":""},{"no":"32","serialNo":2,"content":"B.20-50万元","score":4.0,"remark":""},{"no":"33","serialNo":3,"content":"C.50-100万元","score":6.0,"remark":""},{"no":"34","serialNo":4,"content":"D.100-500万元","score":8.0,"remark":""},{"no":"35","serialNo":5,"content":"E.500万元及以上","score":10.0,"remark":""}]},{"no":"36","serialNo":6,"questionType":"1010","content":"在您收入中，可用于金融投资的比例为？","remark":"","options":[{"no":"37","serialNo":1,"content":"A.小于20% ","score":2.0,"remark":""},{"no":"38","serialNo":2,"content":"B.20%至30%","score":4.0,"remark":""},{"no":"39","serialNo":3,"content":"C.30%至40%","score":6.0,"remark":""},{"no":"40","serialNo":4,"content":"D.40%至50%","score":8.0,"remark":""},{"no":"41","serialNo":5,"content":"E.大于50%","score":10.0,"remark":""}]},{"no":"42","serialNo":7,"questionType":"1010","content":"您对私募基金风险的了解程度可描述为","remark":"","options":[{"no":"43","serialNo":1,"content":"A.从来没接触过","score":2.0,"remark":""},{"no":"44","serialNo":2,"content":"B.听说过，不太了解","score":4.0,"remark":""},{"no":"45","serialNo":3,"content":"C.一般了解","score":6.0,"remark":""},{"no":"46","serialNo":4,"content":"D.比较了解","score":8.0,"remark":""},{"no":"47","serialNo":5,"content":"E.非常了解","score":10.0,"remark":""}]},{"no":"48","serialNo":8,"questionType":"1010","content":"您投资金融产品的经验？","remark":"","options":[{"no":"49","serialNo":1,"content":"A.没有经验","score":2.0,"remark":""},{"no":"50","serialNo":2,"content":"B.少于2年","score":4.0,"remark":""},{"no":"51","serialNo":3,"content":"C.2至5年","score":6.0,"remark":""},{"no":"52","serialNo":4,"content":"D.5至10年","score":8.0,"remark":""},{"no":"53","serialNo":5,"content":"E.10年以上","score":10.0,"remark":""}]},{"no":"54","serialNo":9,"questionType":"1020","content":"您投资过以下哪些产品？（多选）","remark":"","options":[{"no":"55","serialNo":1,"content":"A.股票或股票类产品","score":2.0,"remark":""},{"no":"56","serialNo":2,"content":"B.期货、期权或其它金融衍生品","score":2.0,"remark":""},{"no":"57","serialNo":3,"content":"C.股权或股权类基金","score":2.0,"remark":""},{"no":"58","serialNo":4,"content":"D.债券或债权类固定收益产品","score":2.0,"remark":""},{"no":"59","serialNo":5,"content":"E.其他理财产品","score":2.0,"remark":""}]},{"no":"60","serialNo":10,"questionType":"1010","content":"您投资基金的主要目的？","remark":"","options":[{"no":"61","serialNo":1,"content":"A.补贴家用","score":2.0,"remark":""},{"no":"62","serialNo":2,"content":"B.养老","score":4.0,"remark":""},{"no":"63","serialNo":3,"content":"C.子女教育","score":6.0,"remark":""},{"no":"64","serialNo":4,"content":"D.资产增值","score":8.0,"remark":""},{"no":"65","serialNo":5,"content":"E.家庭富裕","score":10.0,"remark":""}]},{"no":"66","serialNo":11,"questionType":"1010","content":"以下哪项描述最符合您的投资态度？","remark":"","options":[{"no":"67","serialNo":1,"content":"A. 无法承担风险","score":2.0,"remark":""},{"no":"68","serialNo":2,"content":"B. 虽然厌恶风险，但愿意承担一些风险","score":4.0,"remark":""},{"no":"69","serialNo":3,"content":"C. 在深思熟虑后，愿意承担一定的风险","score":6.0,"remark":""},{"no":"70","serialNo":4,"content":"D. 敢冒风险，比较激进","score":8.0,"remark":""},{"no":"71","serialNo":5,"content":"E.爱好风险，相当激进","score":10.0,"remark":""}]},{"no":"72","serialNo":12,"questionType":"1010","content":"如果您的基金投资暂时亏损了15%，您会如何操作？","remark":"","options":[{"no":"73","serialNo":1,"content":"A.马上赎回","score":2.0,"remark":""},{"no":"74","serialNo":2,"content":"B.3个月内如果还是亏损15%，准备赎回","score":4.0,"remark":""},{"no":"75","serialNo":3,"content":"C.6个月内如果还是亏损15%，准备赎回","score":6.0,"remark":""},{"no":"76","serialNo":4,"content":"D.1至2年内都可以持有，等待机会","score":8.0,"remark":""},{"no":"77","serialNo":5,"content":"E.长期持有，等待机会","score":10.0,"remark":""}]}]}}}
    });


	//产品列表
    imitator({
        url: '/jcwechat/prdtlist.action',  
        result: {"result":200,"content":{"page":1,"size":10,"totals":2,"list":[{"pid":"93fee0bf-581e-e611-80c9-ecf4bbf1c777","code":"JC02NR","name":"悦翔盛世基金","establishDate":"2015-03-11T16:00:00Z","type":"","viewPoint":"","startLimit":100.0,"term":"","yearRate":"","response":""},{"pid":"a701e1bf-581e-e611-80c9-ecf4bbf1c777","code":"JC03LE","name":"金诚财富-金牛FOF证券投资私募基金第5期","establishDate":"0001-01-01T00:00:00","type":"","viewPoint":"","startLimit":100.0,"term":"","yearRate":"","response":""}]}}
    });
	//产品详情
	imitator({
        url: '/jcwechat/product.action',  
        result: {"result":200,"content":{"product":{"pid":"93fee0bf-581e-e611-80c9-ecf4bbf1c777","code":"JC02NR","name":"悦翔盛世基金","establishDate":"2015-03-11T16:00:00Z","type":"","viewPoint":"","startLimit":100.0,"term":"","yearRate":"","response":""}}}
    });
	//持有资产
	imitator({
        url: '/jcwechat/shares.action',  
        result: {"result":200,"content":{"list":[{"id":"21f5cd20-4e2d-e611-80cc-ecf4bbf1c777","prdtCode":"JC03WN","prdtName":"yang-接口测试0608第一期","contract":"jctest0608","confirmAmount":1002000.0,"shareAmount":1000000.0,"netValue":0.0,"confirmDate":"2016-06-05T16:00:00Z"},{"id":"a328574e-fb31-e611-80cd-ecf4bbf1c777","prdtCode":"JC03WN","prdtName":"yang-接口测试0608第一期","contract":"jctest0608","confirmAmount":0.0,"shareAmount":0.0,"netValue":0.0,"confirmDate":"2016-06-06T16:00:00Z"},{"id":"46687c77-ad33-e611-80cd-ecf4bbf1c777","prdtCode":"JC0403","prdtName":"yangtest0616-第1期","contract":"0008989898","confirmAmount":5000000.0,"shareAmount":5000000.0,"netValue":0.0,"confirmDate":"2016-06-08T16:00:00Z"},{"id":"acf12600-d931-e611-80cc-ecf4bbf1cdb3","prdtCode":"JC03XT","prdtName":"杭州第一分公司测试第一期","contract":"JCTEST-HF01","confirmAmount":4000000.0,"shareAmount":4000000.0,"netValue":0.0,"confirmDate":"2016-06-06T16:00:00Z"},{"id":"277429bf-5234-e611-80cc-ecf4bbf1cdb3","prdtCode":"JC0403","prdtName":"yangtest0616-第1期","contract":"0008989898","confirmAmount":2000000.0,"shareAmount":3000000.0,"netValue":0.0,"confirmDate":"2016-06-12T16:00:00Z"}]}}
    });
	//持有资产详情
	imitator({
        url: '/jcwechat/sharesAll.action',  
        result: {"result":200,"content":{"shares":{"id":"21f5cd20-4e2d-e611-80cc-ecf4bbf1c777","prdtCode":"JC03WN","prdtName":"yang-接口测试0608第一期","contractNo":"jctest0608","principal":1002000.0,"shares":1000000.0,"netValue":0.0,"netDate":"2016-06-05T16:00:00Z","nameInBank":"莉莉","bankAcco":"435435464565","bankName":null,"phone":null,"mobileNo":null,"email":null,"faxNo":null,"address":null,"tradeList":[{"id":"21f5cd20-4e2d-e611-80cc-ecf4bbf1c777","prdtCode":"JC03WN","prdtName":"yang-接口测试0608第一期","contract":"jctest0608","confirmAmount":1002000.0,"shareAmount":1000000.0,"netValue":0.0,"confirmDate":"2016-06-05T16:00:00Z"},{"id":"a328574e-fb31-e611-80cd-ecf4bbf1c777","prdtCode":"JC03WN","prdtName":"yang-接口测试0608第一期","contract":"jctest0608","confirmAmount":0.0,"shareAmount":0.0,"netValue":0.0,"confirmDate":"2016-06-06T16:00:00Z"},{"id":"46687c77-ad33-e611-80cd-ecf4bbf1c777","prdtCode":"JC0403","prdtName":"yangtest0616-第1期","contract":"0008989898","confirmAmount":5000000.0,"shareAmount":5000000.0,"netValue":0.0,"confirmDate":"2016-06-08T16:00:00Z"},{"id":"acf12600-d931-e611-80cc-ecf4bbf1cdb3","prdtCode":"JC03XT","prdtName":"杭州第一分公司测试第一期","contract":"JCTEST-HF01","confirmAmount":4000000.0,"shareAmount":4000000.0,"netValue":0.0,"confirmDate":"2016-06-06T16:00:00Z"},{"id":"277429bf-5234-e611-80cc-ecf4bbf1cdb3","prdtCode":"JC0403","prdtName":"yangtest0616-第1期","contract":"0008989898","confirmAmount":2000000.0,"shareAmount":3000000.0,"netValue":0.0,"confirmDate":"2016-06-12T16:00:00Z"}],"incomeList":[{"startDate":"2016-06-08T16:00:00Z","endDate":"2016-06-13T16:00:00Z","divideDays":5.0,"contractSignBalance":5000000.0,"realBalance":2671.23,"interest":0.0}]}}}
    });
	
	//礼品列表
	imitator({
        url: '/jcwechat/services.action',  
        result: {"result":200,"content":{"page":1,"size":10,"totals":773,"list":[{"serviceNo":"1551","serviceType":"实物属性","serviceName":"爱丽丝童话活动","exintegral":100.0,"exStartTime":"2016-05-27T00:00:00Z","exEndTime":"2016-05-27T16:00:00Z","startTime":"2016-05-28T00:00:00Z","endTime":"2016-06-01T00:00:00Z","desc":"简介1\n2\n3\n4\n啊实打实的","provider":"","explain":"一人兑换一次","totals":10,"remaining":10},{"serviceNo":"779","serviceType":"实物属性","serviceName":"G03-MontBlanc万宝龙大班系列经典签字笔","exintegral":700.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"万宝龙的名号代表着书写的艺术，笔顶的六角白星标记，恰恰是欧洲最高的山峰勃朗峰俯瞰的形状，使得MONT BLANC书写工具如勃朗峰般坚实而又高贵。","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":0},{"serviceNo":"780","serviceType":"实物属性","serviceName":"（已下架）尼康微单相机","exintegral":800.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"拥有高级复合自动对焦系统，高速图像处理器和智能照片选择器，轻易拍出精彩照片。","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":0},{"serviceNo":"781","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":1},{"serviceNo":"782","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":1},{"serviceNo":"783","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":1},{"serviceNo":"784","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":0},{"serviceNo":"785","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":1},{"serviceNo":"786","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":0},{"serviceNo":"787","serviceType":"实物属性","serviceName":"H04-苹果（Apple）iPad Air9.7英寸平板电脑","exintegral":900.0,"exStartTime":"0001-01-01T00:00:00","exEndTime":"0001-01-01T00:00:00","startTime":"0001-01-01T00:00:00","endTime":"0001-01-01T00:00:00","desc":"屏幕分辨率 2048 x 1536 \n净重 437g","provider":"","explain":"金诚并无礼品库存，若因市场原因或其他客观因素造成的断货，请您谅解，您可以选择兑换其他同积分礼品。","totals":1,"remaining":0}]}}
    });
	
	//礼品详情
	imitator({
        url: '/jcwechat/servicesDetail.action',  
        result: {"result":200,"content":{"services":{"serviceNo":"1551","serviceType":"实物属性","serviceName":"爱丽丝童话活动","exintegral":100.0,"exStartTime":"2016-05-27T00:00:00Z","exEndTime":"2016-05-27T16:00:00Z","startTime":"2016-05-28T00:00:00Z","endTime":"2016-06-01T00:00:00Z","desc":"简介1\n2\n3\n4\n啊实打实的","provider":"","explain":"一人兑换一次","totals":10,"remaining":10}}}
    });
	
	
}