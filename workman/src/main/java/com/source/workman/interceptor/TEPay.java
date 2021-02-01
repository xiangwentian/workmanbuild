package com.source.workman.interceptor;

public class TEPay {

    private static final long serialVersionUID = 3950479483523227188L;

    /**
     * 支付使用的第三方支付渠道
     */
    private String channel;

    /**
     * 支付金额
     */
    private Double amount;

    /**
     * 支付创建时间
     */
    private String ctime;

    /**
     * 业务订单编码
     */
    private String orderCode;

    /**
     * 业务类型
     */
    private String category;

    /**
     * 三位 ISO 货币代码，目前仅支持人民币 cny
     */
    private String currency;
    /**
     * 收款人【可选-维修租赁必选】
     */
    private String payee;
    /**
     * 付款人【可选-维修租赁积分必选】
     */
    private String payor;
    /**
     * 商品描述信息
     */
    private String body;
    /**
     * 商户订单号
     */
    private Integer orderId;
    /**
     * 发起支付请求客户端的 IP 地址，格式为 IPv4 整型，如 127.0.0.1。
     */
    private String clientIp;
    /**
     * 状态 1-支付中，2-支付完成，3-支付失败，4-更改渠道(或叫过期作废）
     */
    private Integer status;
    /**
     * 回调地址（电商业务 必填）
     */
    private String callbackUrl;
    /**
     * 支付成功回调时间 Date-time
     */
    private String backTime;
    /**
     * 支付流水号ping++
     */
    private String transNo;
    /**
     * 支付凭证id
     */
    private String chargeId;
    /**
     * 支付单编码
     */
    private String payCode;
    /**
     * 调用类型：1-线上( 或 空)；2-测试
     */
    private Integer invokeType;
    /**
     * 收款人账号（能获得 就给值）
     */
    private String payeeAccount;
    /**
     * 付款人账号（能获得 就给值）
     */
    private String payorAccount;
    /**
     * onlin  在线支付      test 测试支付
     */
    private String model;
    /**
     * 客户端名称：owner 车主端，artificer 维修工。  mi 微信小程序支付
     */
    private String clientName;
    /**
     * 支付人uid
     */
    private Integer payorUid;
    /**
     * 版本
     */
    protected String version;
    /**
     * 支付密码
     */
    private String payWord;
    /**
     * 附加说明
     */
    private String remark;
    /**
     * 退款状态
     */
    private Integer refunded;
    /**
     *
     */
    private String notifyUrl;
    /**
     * 是否存在
     */
    private String exist;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 定金 id
     */
    private Integer depositId;

    /**
     * 是否存在优惠券  1:存在  2:不存在
     */
    private Integer existCoupon;
    /**
     * 后台确认收款人ID
     */
    private Integer surePayUid;
    /**
     * 小程序  微信open_id
     */
    private String openId;
    /**
     * 成功返回地址
     */
    private String resultUrl;
    /**
     * 失败返回地址
     */
    private String cancelUrl;

    public TEPay() {

    }


    public TEPay(String channel, Double amount, String orderCode,
                 String category, String currency, String payee, String payor,
                 String body, Integer orderId, String clientIp) {
        this.channel = channel;
        this.amount = amount;
        this.orderCode = orderCode;
        this.category = category;
        this.currency = currency;
        this.payee = payee;
        this.payor = payor;
        this.body = body;
        this.orderId = orderId;
        this.clientIp = clientIp;
    }


    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getRefunded() {
        return refunded;
    }

    public void setRefunded(Integer refunded) {
        this.refunded = refunded;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayWord() {
        return payWord;
    }

    public void setPayWord(String payWord) {
        this.payWord = payWord;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getPayorUid() {
        return payorUid;
    }

    public void setPayorUid(Integer payorUid) {
        this.payorUid = payorUid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayor() {
        return payor;
    }

    public void setPayor(String payor) {
        this.payor = payor;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public Integer getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(Integer invokeType) {
        this.invokeType = invokeType;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getPayorAccount() {
        return payorAccount;
    }

    public void setPayorAccount(String payorAccount) {
        this.payorAccount = payorAccount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getCtime() {
        //格式化日期
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		try {
//			if(StringUtil.isNotEmpty(ctime)){
//				return sdf.parse(ctime).getTime()+"";
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getExist() {
        return exist;
    }

    public void setExist(String exist) {
        this.exist = exist;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getExistCoupon() {
        return existCoupon;
    }

    public void setExistCoupon(Integer existCoupon) {
        this.existCoupon = existCoupon;
    }

    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
    }

    public Integer getSurePayUid() {
        return surePayUid;
    }

    public void setSurePayUid(Integer surePayUid) {
        this.surePayUid = surePayUid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }
}