package com.example.recovery.util;

import java.io.Serializable;
import java.util.*;

/**
 * @author Admin
 */
public class BusinessConst implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3537133954540675477L;

	public static final String FANOUT_EXCHANGE = "rabbitServer";

	/**
	 * 密码相同
	 */
	public static final String DATA_FAILED_SAMEPASS = "error.passwordSame";

	/**
	 * 用户名已存在
	 */
	public static final String DATA_FAILED_USERNAMEEXIST = "error.usernameExistence";

	/**
	 * 药品相同
	 */
	public static final String DATA_FAILED_SAMEDRUG = "error.drugSame";

	/**
	 * 分配比例总和应为100%
	 */
	public static final String DATE_RATIO_ERROR = "error.date.ratio";

	/**
	 * 该时间段已经被预约,请换一个时间段
	 */
	public static final String DATA_APPOINTMENT = "error.data.appointment";

	/**
	 * 该预约时间已过期，请换一个时间段
	 */
	public static final String DATA_APPOINTMENT_EXPIRE = "error.data.appointment.expire";

	/**
	 * 该分诊已完成，不能进行转诊
	 */
	public static final String DATA_TRIAGE_COMPLETE = "error.data.complete";

	/**
	 * 该分诊不存在！
	 */
	public static final String DATA_TRIAGE_UNEXISTS = "error.data.triage.unexists";

	/**
	 * 该分诊不存在！
	 */
	public static final String DATA_TRIAGE_CANCEL = "error.data.triage.cancel";

	/**
	 * 选择时间不能小于当前日期！
	 */
	public static final String DATA_NOW_LESS = "error.data.now.less";

	/**
	 * 选择时间超过规定日期！
	 */
	public static final String DATA_NOW_LARGE = "error.data.now.large";

	/**
	 * 该预约区间已存在!
	 */
	public static final String DATA_APPOINTMENT_EXISTS = "error.data.appointment.exists";

	/**
	 * 该用户不是专家医师!
	 */
	public static final String DATA_NOT_SPECIALIST = "error.data.not.specialist";

	/**
	 * 选择的开始时间不能在结束时间之后！
	 */
	public static final String DATA_START_TIME_LARGE = "error.start.time.large";

	/**
	 * 预约间隔过长
	 */
	public static final String DATA_TALKTIME_LANG = "error.data.talktime.lang";

	/**
	 * 余额不足(分配金额)！
	 */
	public static final String DATA_BALANCE_LESS = "error.data.balance.less";

	/**
	 * 余额不足(提现金额)！
	 */
	public static final String DATA_USER_BALANCE_LESS = "error.data.user.balance.less";

	/**
	 * 分配金额大于收费标准
	 */
	public static final String DATA_BALANCE_MORE = "error.data.balance.more";

	/**
	 * 推荐名医
	 */
	public static final String DATA_RECOMMEND = "msg.recommend";

	/**
	 * 自动取消
	 */
    public static final String AUTO_CANCEL_MSG = "AUTO_CANCEL";

	/**
	 * 手动取消
	 */
	public static final String HAND_CANCEL_MSG = "HAND_CANCEL";

	/**
	 * 请求处理成功返回的状态码
	 */
	public static final String DATA_SUCCESS = "true";

	/**
	 * 请求处理失败返回的状态码
	 */
	public static final String DATA_FAILED = "false";

	/**
	 * service层中异常捕捉打印分类
	 */
	public static final String SQL_ERROR = "SQL-ERROR";

	/**
	 * controller层中异常捕捉打印分类
	 */
	public static final String SERVICE_ERROR = "SERVICE-ERROR";

	/**
	 * 自定义异常分类
	 */
	public static final String BUSINESS_ERROR = "BUSINESS-ERROR";

	/**
	 * 请求处理失败返回的失败信息
	 */
	public static final String DATA_FAILED_MSG = "operation.failure.data";

	/**
	 * 该用户不存在
	 */
	public static final String DATA_USER_UNEXISTS = "error.data.user.unexists";

	/**
	 * 自定义异常返回的异常信息
	 */
	public static final String BUSINESS_FAILED_MSG = "operation.failure.businessException";

	/**
	 * 请求处理成功后返回的成功信息
	 */
	public static final String DATA_SUCCESS_MSG = "operation.success";

	/**
	 * 编码日期格式
	 */
	public static final String CODE_DATE_FORMAT = "yyyyMMdd";

	/**
	 * 验证码异常
	 */
	public static final String DATA_FAILED_VERIFY = "error.verification";

	/**
	 * 用户退出异常
	 */
	public static final String DATA_FAILED_QUIT = "error.userQuit";

	/**
	 * 用户登陆异常
	 */
	public static final String DATA_FAILED_LOGIN = "error.login";

	/**
	 * 密码不正确
	 */
	public static final String DATA_FAILED_DIFPASS = "error.passwordDifference";

	/**
	 * 原密码错误
	 */
	public static final String DATA_FAILED_OLDPASSERR = "error.oldPasswordError";

	/**
	 * restTemplate通信异常
	 */
	public static final String RESTFUL_ERROR = "RESTFUL-ERROR";

	/**
	 * 文件上传异常
	 */
	public static final String RESTFUL_OSS = "OSS-ERROR";

	/**
	 * 文件上传失败
	 */
	public static final String UPLOAD_FAILED = "文件上传失败";

	/**
	 * IO流异常
	 */
	public static final String IO_EXCEPTION = "IO流异常";

	/**
	 * OCR变换异常
	 */
	public static final String RESTFUL_OCR = "OCR-ERROR";
	
	/**
	 * 短信发送异常
	 */
	public static final String RESTFUL_SMS = "SMS-ERROR";

	/**
	 * 药店截止日期小于当前日期
	 */
	public static final String DATE_DEADLINE_LESS = "deadline.less";

	/**
	 * 所选医生不存在
	 */
	public static final String DATA_DOCTOR_UNEXIST = "doctor.unexist";

	/**
	 * 所选医生不在线
	 */
	public static final String DATA_DOCTOR_OFFLINE = "doctor.offline";

	/**
	 * 科室编号为空
	 */
	public static final String DATA_DEPART_BLANK = "depart.blank";

	/**
	 * 医生编号为空
	 */
	public static final String DATA_DOCTOR_BLANK = "doctor.blank";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_DOCTOR = "doctor/";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_ASSISTANT = "assistant/";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_DOCTOR_GROUP = "doctorGroup/";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_ACADEMY = "academy/";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_PHARMACIST = "pharmacist/";

    /**
     * oss文件backet路径名 格式BUCKET_PATH
     * bucket: zx-prescription
     */
    public static final String ZX_PRESCRIPTION_CLERK = "clerk/";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_APOTHECARY = "apothecary/";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_SOUND_RECORD = "soundRecord/";

	/**
	 * ERP客户端ID
	 */
	public static final String ERP_USER = "1";

	/**
	 * 嘉嘉康药店店员客户端ID
	 */
	public static final String JJK_CLERK = "2";

	/**
	 * 嘉嘉康医师客户端ID
	 */
	public static final String JJK_DOCTOR = "3";

	/**
	 * 嘉嘉康平台客户端ID
	 */
	public static final String JJK_PLAT = "4";

	/**
	 * 嘉嘉康药师客户端ID
	 */
	public static final String JJK_PHARMACIST = "5";

	/**
	 * 嘉嘉康顾客客户端ID
	 */
	public static final String JJK_PATIENT = "6";

	/**
	 * 嘉嘉康顾客客户端ID
	 */
	public static final String JJK_ASSISTANT = "7";

	/**
	 * 手机验证码错误
	 */
	public static final String VERIFICATION_CODE_ERROR = "验证码错误";

	/**
	 * 运维客户
	 */
	public static final String OPERATOR = "OPERATOR";

	/**
	 * 药店用户
	 */
	public static final String PHARMACY = "PHARMACY";

	/**
	 * 注册未完成专家医师
	 */
	public static final String UNREGISTERED_DIRECTOR = "UNREGISTERED_DIRECTOR";

	/**
	 * 注册未完成专家医师
	 */
	public static final String REJECT_DIRECTOR = "REJECT_DIRECTOR";

	/**
	 * 原手机号码不正确
	 */
	public static final String DATA_FAILED_PHONEERR = "error.phoneNumError";

	/**
	 * 新手机号码已存在
	 */
	public static final String DATA_FAILED_PHONEEXIST = "error.phoneNumExistence";

	/**
	 * 用户名下已有药店，不可再次注册
	 */
	public static final String DATA_USER_OWN_DRUGSTORE = "user.own.drugstore";

	/**
	 * 该药师已下线
	 */
	public static final String DATA_USER_OFFLINE = "apothecary.offline";
	
	/**
	 * 新手机号码已存在
	 */
	public static final String MOBILE_EXIST = "新手机号码已存在";

	/**
	 * 年龄
	 */
	public static final String MASTER_AGE = "1";

	/**
	 * 工作年限
	 */
	public static final String MASTER_WORKINGYEAR = "2";

	/**
	 * 药品剂型
	 */
	public static final String MASTER_DRUGFORM = "3";

	/**
	 * 药品用量单位
	 */
	public static final String MASTER_DOSAGEUNIT = "4";

	/**
	 * 药品数量单位
	 */
	public static final String MASTER_QUANTITYUNIT = "5";

	/**
	 * 省份
	 */
	public static final String MASTER_PROVINCE = "6";

	/**
	 * 城市
	 */
	public static final String MASTER_CITY = "7";

	/**
	 * 地区
	 */
	public static final String MASTER_COUNTRY = "8";

	/**
	 * 医院
	 */
	public static final String MASTER_HOSPITAL = "9";

	/**
	 * 科室
	 */
	public static final String MASTER_DEPARTMENT= "10";

	/**
	 * 临床诊断
	 */
	public static final String MASTER_CLINICAL_DIAGNOSIS = "11";

    /**
     * 病情
     */
    public static final String MASTER_ILLNESS = "12";

	/**
	 * 基本数据添加
	 */
	public static final String MASTER_BASIC_ADD = "1";

	/**
	 * 城市添加
	 */
	public static final String MASTER_CITY_ADD = "2";

	/**
	 * 地区添加
	 */
	public static final String MASTER_COUNTRY_ADD = "3";

	/**
	 * 医院添加
	 */
	public static final String MASTER_HOSPITAL_ADD = "4";

	/**
	 * 科室添加
	 */
	public static final String MASTER_DEPARTMENT_ADD = "5";

	/**
	 * 临床诊断添加
	 */
	public static final String MASTER_CLINICAL_DIAGNOSIS_ADD = "6";

	/**
	 * 省份添加
	 */
	public static final String MASTER_PROVINCE_ADD = "7";

	/**
	 * 基本数据删除
	 */
	public static final String MASTER_BASIC_DEL = "1";

	/**
	 * 城市删除
	 */
	public static final String MASTER_CITY_DEL = "2";

	/**
	 * 地区删除
	 */
	public static final String MASTER_COUNTRY_DEL = "3";

	/**
	 * 医院删除
	 */
	public static final String MASTER_HOSPITAL_DEL = "4";

	/**
	 * 科室删除
	 */
	public static final String MASTER_DEPARTMENT_DEL = "5";

	/**
	 * 临床诊断删除
	 */
	public static final String MASTER_CLINICAL_DIAGNOSIS_DEL = "6";

	/**
	 * 省份删除
	 */
	public static final String MASTER_PROVINCE_DEL = "7";

	/**
	 * 驳回审核短信模板
	 */
	public static final String SMS_REJECT_APPLICATION = "SMS_165117230";

	/**
	 * 注册成功短信模板
	 */
	public static final String SMS_APPROVAL_APPLICATION = "SMS_164277655";
	/**
	 * 子药店审核通过模板
	 */
	public static final String SMS_APPROVAL_CHILD = "SMS_195721131";
	/**
	 * 注销通过短信模板
	 */
	public static final String SMS_LOGOUT_APPLICATION = "SMS_165109418";

	/**
	 * 余额不足通知管理员短信模板
	 */
	public static final String SMS_BALANCE_LOW_APPLICATION = "SMS_171116083";

	/**
	 * 压缩异常
	 */
	public static final String COMPRESS_ERROR = "压缩异常";

	/**
	 * 编码格式
	 */
	public static final String CHARSET_NAME = "UTF-8";

	/**
	 * 医师视频中使用的redis库号
	 */
	public static final Integer VIDEO_REDIS = 3;

	/**
	 * 药师视频中使用的redis库号
	 */
	public static final Integer DISTRIBUTED_LOCK = 4;

	/**
	 * 隐私电话使用的redis库号
	 */
	public static final Integer PHONE_REDIS = 5;

	/**
	 * 监听名医推荐退款
	 */
	public static final int FAMOUS_RECOMMEND = 6;

	/**
	 * 分诊过期自动取消
	 */
	public static final int AUTO_CANCEL = 7;

	/**
	 * 模板消息推送计时器
	 */
	public static final int TEMPLATE_MESSAGE_TIMER = 8;

	/**
	 * 微信的token
	 */
	public static final int VX_TOKEN = 9;

	/**
	 * 监听超时未预约预付款
	 */
	public static final int ADVANCE = 10;

	/**
	 * 监听模板消息时长
	 */
	public static final int MESSAGE = 11;

	/**
	 * 监听二维码超时
	 */
	public static final int QR_CODE = 12;

	/**
	 * 医疗咨询师心跳
	 */
	public static final int HEART = 13;

	/**
	 * 临时授权URL
	 */
	public static final int PIC_SIGNATURE_URL = 14;

	/**
	 * 医疗咨询师心跳
	 */
	public static final String DR_HEART = "heart_";

	/**
	 * oauth 用户
	 */
	public static final String PRINCIPAL = "principal";

	/**
	 * oauth 返回用户信息
	 */
	public static final String COMMONUSERDTO = "commonUserDto";

	/**
	 * oss文件backet路径名 格式BUCKET_PATH
	 * bucket: zx-prescription
	 */
	public static final String ZX_PRESCRIPTION_DRUGSTORE = "drugstore/";

	/**
	 * 密码校验错误信息
	 */
	public static final String PASSWORD_CHECK_ERROR = "密码不符合规范要求，长度8-16位，必须包含字母、数字";

	/**
	 * 用户名校验错误信息
	 */
	public static final String USER_ACCOUNT_CHECK_ERROR = "用户名不符合规范要求，长度6-16位，必须包含字母、数字";

	/**
	 * 对象转XML异常
	 */
	public static final String XML_ERROR = "对象解析异常";

	/**
	 * 预约成功短信模板
	 */
	public static final String APPOINT_SUCCESS = "SMS_171116063";

	/**
	 * 预约提醒短信模板
	 */
	public static final String APPOINT_REMIND = "SMS_171116075";

	/**
	 * 医师取消分诊模板
	 */
	public static final String DOCTOR_CANCEL_TRIAGE = "SMS_174814956";

	/**
	 * 微信URL
	 */
	public static final String WX_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

	/**
	 * 阿里URL
	 */
	public static final String ALI_URL = "https://openapi.alipaydev.com/gateway.do"/*"https://openapi.alipay.com/gateway.do"*/;

	/**
	 * 极光推送URL
	 */
	public static final String JG_URL = "https://bjapi.push.jiguang.cn";

	/**
	 * 华为URL
	 */
	public static final String HW_URL = "/rest/caas/relationnumber/partners/v1.0";

	/**
	 * 预约信息redis前缀
	 */
	public static final String APPOINTMENT_PRE = "appointmentTime_";

	/**
	 * 药店缴费修改失败
	 */
	public static final String MODIFYFAILED = "药店缴费修改失败";

	/**
	 * 年月日期格式
	 */
	public static final String YEAR_MONTH_PATTEN = "yyyyMM";

	/**
	 * 分诊病人队列前缀
	 */
	public static final String TRIAGE_QUEUE = "doc_triageQueue_";

	/**
	 * 退款前缀
	 */
	public static final String REFUND = "refund_";

	/**
	 * clientId
	 */
	public static final String CLIENT_ID = "client_id";

	/**
	 * secret
	 */
	public static final String CLIENT_SECRET = "client_secret";

	/**
	 * grant_type
	 */
	public static final String GRANT_TYPE = "grant_type";

	/**
	 * 认证路径
	 */
	public static final String AU_PATH = "/oauth/token";

	/**
	 * refresh_token
	 */
	public static final String REFRESH_TOKEN = "refresh_token";

	/**
	 * 支持厂商通道
	 */
	public static final String[] CHANNEL_SUPPORT = {"XIAOMI","HUAWEI","MEIZU","VIVO","OPPO"};

	/**
	 * 交易完成
	 */
	public static final String TRADE_FINISHED = "TRADE_FINISHED";

	/**
	 * 支付成功
	 */
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";

	/**
	 * 交易创建
	 */
	public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";

	/**
	 * 交易关闭
	 */
	public static final String TRADE_CLOSED = "TRADE_CLOSED";

	/**
	 * 交易关闭
	 */
	public static final String ORDER_EXPIRE = "1h";

	/**
	 * 二维码分诊编号
	 */
	public static final String QRCODE_TRIAGE = "triage_";

	/**
	 * 二维码名医推荐
	 */
	public static final String QRCODE_RECOMMEND = "recommend_";

	/**
	 * 二维码医助
	 */
	public static final String QRCODE_ASSISTANT = "assistant_";

	/**
	 * 二维码复诊
	 */
	public static final String QRCODE_RE_EXAMINATION = "re-examination_";

	/**
	 * 推荐名医计时器前缀
	 */
	public static final String FAMOUS_RECOMMEND_TIMER_PREFIX = "recommendTimer_";
	/**
	 * 复诊计时器前缀
	 */
	public static final String RE_EXAMINATION_TIMER_PREFIX = "re-examinationTimer_";

	/**
	 * 复诊卡延时推送前缀
	 */
	public static final String RE_EXAMINATION_CARD_PUSH_TIMER_PREFIX = "re-examinationCardTimer_";

	/**
	 * 一天的秒数
	 */
	public static final int ONE_DAY_SECONDS = 86400;

	/**
	 * 一小时的秒数
	 */
	public static final int ONE_HOUR_SECONDS = 3600;

	/**
	 * 分诊咨询费
	 */
	public static final String TRIAGE_PAY ="分诊咨询费";

	/**
	 * 复诊咨询费
	 */
	public static final String REEXAMINATION_PAY ="复诊咨询费";

	/**
	 * 推荐名医费
	 */
	public static final String RECOMMEND_PAY ="推荐名医费";

	/**
	 * 自动退款秒数(秒)，24小时
	 */
	public static final int AUTO_REFUND_SECOND = 86400;

	/**
	 * 自动退款警告时间，30分钟
	 */
	public static final Long WARN_TIME = 1800L;

	public static final String INVALID_REGISTRATION_ID = "invalid_registration_id";

	public static final String ERROR_TYPE = "error_type";

	/**
	 * 微信推送时名医推荐URL
	 */
	public static final String WX_RECOMMEND_URL = "https://{url}/dorDetail?drId={drId}&referralId={referralId}";

	/**
	 * 微信推送时复诊卡URL
	 */
	public static final String WX_REEXAMINATION_URL = "https://{url}/doctor?account=";

	/**
	 * 微信提现异常信息集合
	 */
	public static final Map<String,String> WX_ERROR_MSG_MAP = new HashMap<>();

	/**
	 * 支付宝提现异常信息集合
	 */
	public static final Map<String,String> ALI_ERROR_MSG_MAP = new HashMap<>();

	public static final List<String> REASON_LIST = new ArrayList<>();

	public static final List<String> COMPOUND_SURNAME = Arrays.asList("欧阳","太史","端木","上官","司马","东方","独孤",
			"南宫","万俟","闻人","夏侯","诸葛","尉迟","公羊","赫连","澹台","皇甫","宗政","濮阳","公冶","太叔","申屠","公孙",
			"慕容","仲孙","钟离","长孙","宇文","司徒","鲜于","司空","闾丘","子车","亓官","司寇","巫马","公西","颛孙","壤驷",
			"公良","漆雕","乐正","宰父","谷梁","拓跋","夹谷","轩辕","令狐","段干","百里","呼延","东郭","南门","羊舌","微生",
			"公户","公玉","公仪","梁丘","公仲","公上","公门","公山","公坚","左丘","公伯","西门","公祖","第五","公乘","贯丘",
			"公皙","南荣","东里","东宫","仲长","子书","子桑","即墨","淳于","达奚","褚师","吴铭","纳兰","归海");

	static{
		WX_ERROR_MSG_MAP.put("NO_AUTH","没有该接口权限");
		WX_ERROR_MSG_MAP.put("AMOUNT_LIMIT","金额超限");
		WX_ERROR_MSG_MAP.put("PARAM_ERROR","参数错误");
		WX_ERROR_MSG_MAP.put("OPENID_ERROR","Openid错误");
		WX_ERROR_MSG_MAP.put("SEND_FAILED","付款错误");
		WX_ERROR_MSG_MAP.put("NOTENOUGH","余额不足");
		WX_ERROR_MSG_MAP.put("SYSTEMERROR","系统繁忙，请稍后再试。");
		WX_ERROR_MSG_MAP.put("NAME_MISMATCH","姓名校验出错");
		WX_ERROR_MSG_MAP.put("SIGN_ERROR","签名错误");
		WX_ERROR_MSG_MAP.put("XML_ERROR","Post内容出错");
		WX_ERROR_MSG_MAP.put("FATAL_ERROR","两次请求参数不一致");
		WX_ERROR_MSG_MAP.put("FREQ_LIMIT","超过频率限制，请稍后再试。");
		WX_ERROR_MSG_MAP.put("MONEY_LIMIT","已经达到今日付款总额上限/已达到付款给此用户额度上限");
		WX_ERROR_MSG_MAP.put("CA_ERROR","商户API证书校验出错");
		WX_ERROR_MSG_MAP.put("V2_ACCOUNT_SIMPLE_BAN","无法给非实名用户付款");
		WX_ERROR_MSG_MAP.put("PARAM_IS_NOT_UTF8","请求参数中包含非utf8编码字符");
		WX_ERROR_MSG_MAP.put("SENDNUM_LIMIT","该用户今日付款次数超过限制");
		WX_ERROR_MSG_MAP.put("RECV_ACCOUNT_NOT_ALLOWED","收款账户不在收款账户列表");
		WX_ERROR_MSG_MAP.put("PAY_CHANNEL_NOT_ALLOWED","本商户号未配置API发起能力");

		ALI_ERROR_MSG_MAP.put("INVALID_PARAMETER","参数有误。");
		ALI_ERROR_MSG_MAP.put("SYSTEM_ERROR","系统繁忙");
		ALI_ERROR_MSG_MAP.put("PERMIT_CHECK_PERM_LIMITED","根据监管部门的要求，请补全您的身份信息解除限制");
		ALI_ERROR_MSG_MAP.put("PAYCARD_UNABLE_PAYMENT","付款账户余额支付功能不可用");
		ALI_ERROR_MSG_MAP.put("PAYEE_NOT_EXIST","收款账号不存在");
		ALI_ERROR_MSG_MAP.put("PAYER_DATA_INCOMPLETE","根据监管部门的要求，需要付款用户补充身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("PERM_AML_NOT_REALNAME_REV","根据监管部门的要求，需要收款用户补充身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("PERM_AML_NOT_REALNAME_REV","根据监管部门的要求，需要收款用户补充身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("PAYER_STATUS_ERROR","付款账号状态异常");
		ALI_ERROR_MSG_MAP.put("PAYER_STATUS_ERROR","付款方用户状态不正常。");
		ALI_ERROR_MSG_MAP.put("PAYEE_USER_INFO_ERROR","支付宝账号和姓名不匹配，请确认姓名是否正确");
		ALI_ERROR_MSG_MAP.put("PAYER_USER_INFO_ERROR","付款用户姓名或其它信息不一致");
		ALI_ERROR_MSG_MAP.put("PAYER_DATA_INCOMPLETE","根据监管部门的要求，需要付款用户补充身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("PAYER_BALANCE_NOT_ENOUGH","付款方余额不足");
		ALI_ERROR_MSG_MAP.put("PAYMENT_INFO_INCONSISTENCY","两次请求商户单号一样，但是参数不一致");
		ALI_ERROR_MSG_MAP.put("CERT_MISS_TRANS_LIMIT","您的付款金额已达单笔1万元或月累计5万元，根据监管部门的要求，需要付款用户补充身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("CERT_MISS_ACC_LIMIT","您连续10天余额账户的资金都超过5000元，根据监管部门的要求，需要付款用户补充身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("PAYEE_ACC_OCUPIED","该手机号对应多个支付宝账户，请传入收款方姓名确定正确的收款账号");
		ALI_ERROR_MSG_MAP.put("MEMO_REQUIRED_IN_TRANSFER_ERROR","根据监管部门的要求，单笔转账金额达到50000元时，需要填写付款理由");
		ALI_ERROR_MSG_MAP.put("PERMIT_NON_BANK_LIMIT_PAYEE","根据监管部门的要求，对方未完善身份信息或未开立余额账户，无法收款");
		ALI_ERROR_MSG_MAP.put("PERMIT_PAYER_LOWEST_FORBIDDEN","根据监管部门要求，付款方身份信息完整程度较低，余额支付额度受限");
		ALI_ERROR_MSG_MAP.put("PERMIT_PAYER_FORBIDDEN","根据监管部门要求，付款方余额支付额度受限");
		ALI_ERROR_MSG_MAP.put("PERMIT_CHECK_PERM_IDENTITY_THEFT","您的账户存在身份冒用风险，请进行身份核实解除限制");
		ALI_ERROR_MSG_MAP.put("REMARK_HAS_SENSITIVE_WORD","转账备注包含敏感词，请修改备注文案后重试");
		ALI_ERROR_MSG_MAP.put("ACCOUNT_NOT_EXIST","根据监管部门的要求，请补全你的身份信息，开立余额账户");
		ALI_ERROR_MSG_MAP.put("PAYER_CERT_EXPIRED","根据监管部门的要求，需要付款用户更新身份信息才能继续操作");
		ALI_ERROR_MSG_MAP.put("PERMIT_NON_BANK_LIMIT_PAYEE","根据监管部门的要求，对方未完善身份信息或未开立余额账户，无法收款");
		ALI_ERROR_MSG_MAP.put("EXCEED_LIMIT_PERSONAL_SM_AMOUNT","转账给个人支付宝账户单笔最多5万元");
		ALI_ERROR_MSG_MAP.put("EXCEED_LIMIT_ENT_SM_AMOUNT","转账给企业支付宝账户单笔最多10万元");
		ALI_ERROR_MSG_MAP.put("EXCEED_LIMIT_SM_MIN_AMOUNT","单笔最低转账金额0.1元");
		ALI_ERROR_MSG_MAP.put("EXCEED_LIMIT_DM_MAX_AMOUNT","单日最多可转100万元");
		ALI_ERROR_MSG_MAP.put("EXCEED_LIMIT_UNRN_DM_AMOUNT","收款账户未实名，单日最多可收款1000元");
		ALI_ERROR_MSG_MAP.put("PAYER_PAYEE_CANNOT_SAME","收付款方不能相同");
		ALI_ERROR_MSG_MAP.put("SYNC_SECURITY_CHECK_FAILED","当前操作存在风险，请停止操作，如有疑问请咨询客服");
		ALI_ERROR_MSG_MAP.put("TRANSFER_ERROR","转账失败");

		REASON_LIST.add("预约列表为空，无法预约");
		REASON_LIST.add("预约列表中没有符合您病情的医师");
		REASON_LIST.add("当前分诊已超时，请重新发起新的分诊");
	}
}
